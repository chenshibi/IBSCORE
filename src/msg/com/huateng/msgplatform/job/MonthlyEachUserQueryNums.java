package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocPerQuery;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.report.common.service.ReportCommonService;

public class MonthlyEachUserQueryNums implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(MonthlyEachUserQueryNums.class);

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		String result = ReportCommonService.JOB_OK;
		Date startTm = null;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		try {
			startTm = new Date();//*获取当前时间
			jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();

			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.DATE, 1);
			cal.add(Calendar.MONTH, -1);
			String start = new SimpleDateFormat("yyyyMMdd").format(cal
					.getTime());
			System.out.println(start);

			Calendar lastDate = Calendar.getInstance();
			lastDate.add(Calendar.MONTH, -1);// 减一个月
			lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
			lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
			String end = new SimpleDateFormat("yyyyMMdd").format(lastDate
					.getTime());
			System.out.println(end);
			// 各用户查询个人次数
			// 各用户查询个人次数
		    StringBuffer hqlper = new StringBuffer("select createUser,count(*) as query_times from CustPbocPerQuery po where 1=1 ");
			hqlper.append(" and createTime >= '" + start + "000000" + "'");
			hqlper.append(" and createTime <= '" + end + "235959" + "'");
			hqlper.append("GROUP BY createUser");
			List listcppq=new ArrayList<CustPbocPerQuery>();
			listcppq = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqlper.toString());
			// 各用户查询企业次数
			StringBuffer hqlent = new StringBuffer("select createUser,count(*) as query_times from CustPbocEntQuery po where 1=1 ");
			hqlent.append(" and createTime >= '" + start + "000000" + "'");
			hqlent.append(" and createTime <= '" + end + "235959" + "'");
			hqlent.append("GROUP BY createUser");
			List listcpeq=new ArrayList<CustPbocEntQuery>();
			listcpeq = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqlent.toString());
			String title = "Monthly Each User query times report - Personal";
			String title1 = "Monthly Each User query times report - Corp";
			String content = "";
			String content1 = "";
			//String roleName = null;
			content1 = content += "<h4>Dear All,</h4>";
			content1 = content += "This is the monthly query_times of each user.<br>";
			content1 = content += "<html> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\"> "
					+ " <table style='border:1px solid black;'>";
			content += 	"<tr>" 
									+"<th>用户ID</th>"
									+"<th>查询个人次数</th>"
									+"</tr>";
			if (listcppq.size() > 0) {
				for (int i = 0; i < listcppq.size(); i++) {					
					Object[] obj=(Object[])listcppq.get(i);
	            	String name=(String)obj[0];
	            	Long count=(Long)obj[1];
					
					content += " <tr>"
							+ " <td>"+ name +"</td>"
							+ "<td>" + count +"</td>"
							+ "</tr>";
				}
			}
				content1 += 	"<tr>" 
						+"<th>用户ID</th>"
						+"<th>查询企业次数</th>"
						+"</tr>";
				// <th>Time of last login</th> <th>creation time</th>在tlrinfo表中
				if (listcpeq.size() > 0) {
					for (int i = 0; i < listcpeq.size(); i++) {
						//CustPbocEntQuery cpeqi = listcpeq.get(i);
						Object[] obj=(Object[])listcppq.get(i);
		            	String name=(String)obj[0];
		            	Long count=(Long)obj[1];
						content1 += " <tr>"
								+ " <td>"+ name +"</td>"
								+ "<td>" + count +"</td>"
								+ "</tr>";
					}
				}
					
						
				content += " </table>  </html>";
				content1 += " </table>  </html>";
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_MONTHLYEACHUSERQUERYNUMS, content, title);
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_MONTHLYEACHUSERQUERYNUMS, content1, title1);
			
		} catch (Exception e) {
			e.printStackTrace();
			result = ReportCommonService.JOB_FAILED;
			remark = e.getMessage();
		} finally {
			endTm = new Date();
			ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId,
					result, jobName, remark);
		}
	}


	@SuppressWarnings("rawtypes")
	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}

}

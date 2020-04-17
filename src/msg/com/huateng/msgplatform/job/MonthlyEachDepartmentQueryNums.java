package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.TlrInfo;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocEntQueryTlrInfo;
import resource.bean.crms.CustPbocPerQuery;
import resource.bean.crms.CustPbocPerQueryTlrInfo;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.report.common.service.ReportCommonService;

public class MonthlyEachDepartmentQueryNums implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(MonthlyEachDepartmentQueryNums.class);

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
			String start = new SimpleDateFormat("yyyy-MM-dd").format(cal
					.getTime());
			System.out.println(start);

			Calendar lastDate = Calendar.getInstance();
			lastDate.add(Calendar.MONTH, -1);// 减一个月
			lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
			lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
			String end = new SimpleDateFormat("yyyy-MM-dd").format(lastDate
					.getTime());
			System.out.println(end);
			// 各部门查询个人次数
			StringBuffer hqlper = new StringBuffer(
					"select t.DEPARTMENT,count(t.DEPARTMENT) as query_times"+
					"from CUST_PBOC_PER_QUERY  c"+
					"LEFT JOIN"+
					"TLR_INFO t on c.CREATE_USER =t.TLRNO"+
					"WHERE" + 
					"1=1");
			hqlper.append(" and c.CREATE_TIME >= '" + start + " 00:00:00" + "'");
			hqlper.append(" and c.CREATE_TIME <= '" + end + " 23:59:59" + "'");
			hqlper.append("GROUP BY t.DEPARTMENT");
			List<CustPbocPerQueryTlrInfo> listcppqti = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqlper.toString());
			// 各部门查询企业次数
			StringBuffer hqlent = new StringBuffer(
					"select t.DEPARTMENT,count(t.DEPARTMENT) as query_times"+
					"from CUST_PBOC_ENT_QUERY  c"+
					"LEFT JOIN"+
					"TLR_INFO t on c.CREATE_USER =t.TLRNO"+
					"WHERE" + 
					"1=1");
			hqlent.append(" and c.CREATE_TIME >= '" + start + " 00:00:00" + "'");
			hqlent.append(" and c.CREATE_TIME <= '" + end + " 23:59:59" + "'");
			hqlent.append("GROUP BY t.DEPARTMENT");
			List<CustPbocEntQueryTlrInfo> listcpeqti = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqlent.toString());
			/*//用户对应查询部门
			StringBuffer hqldep = new StringBuffer(
					"SELECT TLRNO,DEPARTMENT " + 
					"from TLR_INFO " + 
					"WHERE" + 
					"1=1");
			List<TlrInfo> listtlrinfo = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hqldep.toString());
			if (listcppq.size() > 0) {
				for (int i = 0; i < listcppq.size(); i++) {
				CustPbocPerQuery cppqi = listcppq.get(i);
				
				}
			}*/
			
			
			
			
			String title = "Monthly Each Deparment query times report - Personal";
			String title1 = "Monthly Each Deparment query times report - Corp";
			String content = "";
			String content1 = "";
			//String roleName = null;
			content1 = content += "<h4>Dear All,</h4>";
			content1 = content += "This is the monthly query_times of each Department.<br>";
			content1 = content += "<html> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\"> "
					+ " <table style='border:1px solid black;'>";
			content += 	"<tr>" 
					+"<th>部门</th>"
					+"<th>查询个人次数</th>"
					+"</tr>";
			if (listcppqti.size() > 0) {
				for (int i = 0; i < listcppqti.size(); i++) {
					
					CustPbocPerQueryTlrInfo cppqi = listcppqti.get(i);
					
					content += " <tr>"
							+ " <td>"+ cppqi.getDepartment()+"</td>"
							+ "<td>" + cppqi.getQuery_times() +"</td>"
							+ "</tr>";	
				}
			}
			content1 += 	"<tr>" 
					+"<th>部门</th>"
					+"<th>查询企业次数</th>"
					+"</tr>";
				// <th>Time of last login</th> <th>creation time</th>在tlrinfo表中
			if (listcpeqti.size() > 0) {
				for (int i = 0; i < listcpeqti.size(); i++) {
					CustPbocEntQueryTlrInfo cpeqi = listcpeqti.get(i);
					content1 += " <tr> "
							+ " <td>"+ cpeqi.getDepartment() +"</td> "
							+ " <td>" + cpeqi.getQuery_times() +"</td> "
							+ " </tr> ";
				}
			}
					
						
			content += " </table>  </html>";
			content1 += " </table>  </html>";
			SendMailService.getMailBeanAndSendMail(
					MailConstants.SEND_MONTHLYEACHDEPARTMENTQUERYNUMS, content, title);
			SendMailService.getMailBeanAndSendMail(
					MailConstants.SEND_MONTHLYEACHDEPARTMENTQUERYNUMS, content1, title1);
			
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

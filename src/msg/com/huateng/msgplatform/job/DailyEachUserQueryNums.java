package com.huateng.msgplatform.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.TlrInfoChange;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocPerQuery;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;

public class DailyEachUserQueryNums implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(DailyEachUserQueryNums.class);

	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		String result = ReportCommonService.JOB_OK;
		Date startTm = null;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		/*Map mflag = null;
		Map mcity = null;
		Map mregion = null;
		Map mdepartMent = null;*/
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
			
			DateFormat fmt = new SimpleDateFormat("yyyyMMdd");// 年月日
			String day = fmt.format(startTm);// 获取当前时间的年月日
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			String yesterday = new SimpleDateFormat("yyyyMMdd").format(cal
					.getTime());
			System.out.println(yesterday);
			// 各用户查询个人次数
			StringBuffer hqlper = new StringBuffer(
					"select createUser,count(*) as query_times " + 
					"from CustPbocPerQuery po " + 
					"where" + 
					" 1=1");
			hqlper.append(" and createTime >= '" + yesterday + "000000" + "'");
			hqlper.append(" and createTime <= '" + day + "000000" + "'");
			hqlper.append(" group by createUser");
			List listcppq = new ArrayList<CustPbocPerQuery>();
			listcppq=ROOTDAOUtils.getROOTDAO().queryByCondition(hqlper.toString());
			// 各用户查询企业次数
			StringBuffer hqlent = new StringBuffer(
					"SELECT createUser,COUNT(*) as query_times " + 
					"from CustPbocEntQuery po " + 
					"WHERE" + 
					" 1=1");
			hqlent.append(" and createTime >= '" + yesterday + "000000" + "'");
			hqlent.append(" and createTime <= '" + day + "000000" + "'");
			hqlent.append(" GROUP BY createUser");
			List listcpeq = new ArrayList<CustPbocEntQuery>();
			listcpeq=ROOTDAOUtils.getROOTDAO().queryByCondition(hqlent.toString());
			String title = "Daily Each User query times report - Personal";
			String title1 = "Daily Each User query times report - Corp";
			String content = "";
			String content1 = "";
			//String roleName = null;
			content1 = content += "<h4>Dear All,</h4>";
			content1 = content += "This is the daily query_times of each user.<br>";
			content1 = content += "<html> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\"> "
					+ " <table style='border:1px solid black;'>";
			content += 	"<tr>" 
									+"<th>用户ID</th>"
									+"<th>查询个人次数</th>"
									+"</tr>";
			// <th>Time of last login</th> <th>creation time</th>在tlrinfo表中
				for (int i = 0; i < listcppq.size(); i++) {
					//String personalBureauEnquiry = "";
					//String corpBureauEnquiry = "";
					//CustPbocPerQuery cppqi = (CustPbocPerQuery)listcppq.get(i);
					Object[] obj=(Object[])listcppq.get(i);
	            	String name=(String)obj[0];
	            	Long count=(Long)obj[1];
					/*StringBuffer hql1 = new StringBuffer(
							"select co.ROLE_NAME from TLR_ROLE_REL_CHANGE ao ,ROLE_INFO co where 1=1 and co.ROLE_ID = ao.ROLE_ID");
					hql1.append(" and ao.TLRNO= '" + cppqi.getCreateUser() + "'");
					Iterator it = rootdao.queryBySQL2(hql1.toString());*/
					/*mflag = DataMapService.getNameByNo(38);
					mcity = DataMapService.getNameByNo(503);
					mregion = DataMapService.getNameByNo(502);
					mdepartMent = DataMapService.getNameByNo(501);*/
					/*String flag = checkNull(mflag,
							transfer_toString(ti.getFlag()));
					String city = checkNull(mcity,
							transfer_toString(ti.getCity()));
					String region = checkNull(mregion,
							transfer_toString(ti.getRegion()));
					String departMent = checkNull(mdepartMent,
							transfer_toString(ti.getDepartment()));*/
					/*while (it.hasNext()) {
						Map map = (Map) it.next();
						if (!"".equals((String) map.get("ROLE_NAME"))
								&& null != (String) map.get("ROLE_NAME")) {
							roleName = (String) map.get("ROLE_NAME");
						} else {
							roleName = "null";
						}

					}*/
					/*if ("Ind Enq".equals(roleName)
							|| "Ind Enq Batch".equals(roleName)
							|| "Ind Enq Emerg".equals(roleName)) {
						//personalBureauEnquiry = "Y";
						content += " <tr> <td></td><td>" + cppqi.getCreateUser()
								+ "</td><td>"+ cppqi.getQuery_times() + "</td>"
								+ "<td>查询用户</td><td>"
								+ lockAndUnlock(ti.getStatus()) + "</td><td>"
								+ ti.getLastUpdTms() + "</td><td>前置系统用户</td>"
								+ "<td>" + city + "</td></tr>";

					}*/
					// else {
					// personalBureauEnquiry = "N";
					// }

					/*if ("Com Enq".equals(roleName)
							|| "Com Enq Batch".equals(roleName)
							|| "Com Enq Emerg".equals(roleName)) {
						//corpBureauEnquiry = "Y";
						content += " <tr>"
								+ " <td></td>"
								+ "<td>" + ti.getTlrno()+"</td>"
								+ "<td>" + ti.getTlrName() + "</td>"
								+ "<td>查询用户</td>"
								+ "<td>"+lockAndUnlock(ti.getStatus()) + "</td>"
								+ "<td>"+ti.getLastUpdTms() + "</td>"
								+ "<td>前置系统用户</td>"
								+ "<td>" + city + "</td></tr>";
					}*/
					
					content += " <tr>"
							+ " <td>"+ name +"</td>"
							+ "<td>" + count +"</td>"
							+ "</tr>";
				
			}
				content1 += 	"<tr>" 
						+"<th>用户ID</th>"
						+"<th>查询企业次数</th>"
						+"</tr>";
				// <th>Time of last login</th> <th>creation time</th>在tlrinfo表中
				if (listcpeq.size() > 0) {
					for (int i = 0; i < listcpeq.size(); i++) {
						//CustPbocEntQuery cpeqi = (CustPbocEntQuery)listcpeq.get(i);
						Object[] obj=(Object[])listcpeq.get(i);
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
						MailConstants.SEND_DAILYEACHUSERQUERYNUMS, content, title);
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_DAILYEACHUSERQUERYNUMS, content1, title1);
			
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

	/*private String lockAndUnlock(String status) {
		if (status.equals("2")) {
			return "停用";
		} else if (status.equals("0") || status.equals("1")) {
			return "启用";
		}
		return status;
	}*/

	/*private String transfer_toString(Object str_son) {
		if (null == str_son)
			return "NULL".toString();
		return str_son.toString();
	}*/

	@SuppressWarnings("rawtypes")
	public String checkNull(Map p, String t) {
		if (t == null) {
			return "";
		} else {
			return (String) p.get(t.trim());
		}
	}

}

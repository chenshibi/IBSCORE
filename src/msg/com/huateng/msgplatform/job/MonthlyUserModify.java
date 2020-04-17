package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
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

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.msgplatform.service.DataMapService;
import com.huateng.report.common.service.ReportCommonService;

public class MonthlyUserModify implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(MonthlyUserModify.class);

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		String result = ReportCommonService.JOB_OK;
		Date startTm = null;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		Map mflag = null;
		Map mcity = null;
		Map mregion = null;
		Map mdepartMent = null;
		try {
			startTm = new Date();
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
			// 个人征信报告查询监控（包括单笔和batch）
			StringBuffer hql = new StringBuffer(
					"select to from TlrInfoChange to where 1=1");
			hql.append(" and lastUpdTms >= '" + start + " 00:00:00" + "'");
			hql.append(" and lastUpdTms <= '" + end + " 23:59:59" + "'");
			List<TlrInfoChange> listtrl = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hql.toString());
			String title = "Personal User Month Modify  List";
			String title1 = "Corp User Month Modify  List";
			String content = "";
			String content1 = "";
			String roleName = null;
			content1 = content += "<h4>Dear All,</h4>";
			content1 = content += "Please kindly find the detailed information listed.";
			content1 = content += "<html> <meta http-equiv=\"Content-Type\" content=\"text/html; charset=GBK\"> "
					+ " <table style='border:1px solid black;'>";
			content1 = content += " <tr> <th>所属机构</th><th>用户ID</th><th>用户姓名</th><th>用户权限</th>"
					+ "<th>用户状态</th><th>变更时间</th><th>备注</th><th>城市</th></tr>";
			// <th>Time of last login</th> <th>creation time</th>在tlrinfo表中
			if (listtrl.size() > 0) {
				for (int i = 0; i < listtrl.size(); i++) {
					String personalBureauEnquiry = "";
					String corpBureauEnquiry = "";
					TlrInfoChange ti = listtrl.get(i);
					StringBuffer hql1 = new StringBuffer(
							"select co.ROLE_NAME from TLR_ROLE_REL_CHANGE ao ,ROLE_INFO co where 1=1 and co.ROLE_ID = ao.ROLE_ID");
					hql1.append(" and ao.TLRNO= '" + ti.getTlrno() + "'");
					Iterator it = rootdao.queryBySQL2(hql1.toString());
					mflag = DataMapService.getNameByNo(38);
					mcity = DataMapService.getNameByNo(503);
					mregion = DataMapService.getNameByNo(502);
					mdepartMent = DataMapService.getNameByNo(501);
					String flag = checkNull(mflag,
							transfer_toString(ti.getFlag()));
					String city = checkNull(mcity,
							transfer_toString(ti.getCity()));
					String region = checkNull(mregion,
							transfer_toString(ti.getRegion()));
					String departMent = checkNull(mdepartMent,
							transfer_toString(ti.getDepartment()));
					while (it.hasNext()) {
						Map map = (Map) it.next();
						if (!"".equals((String) map.get("ROLE_NAME"))
								&& null != (String) map.get("ROLE_NAME")) {
							roleName = (String) map.get("ROLE_NAME");
						} else {
							roleName = "null";
						}

					}
					if ("Ind Enq".equals(roleName)
							|| "Ind Enq Batch".equals(roleName)
							|| "Ind Enq Emerg".equals(roleName)) {
						personalBureauEnquiry = "Y";
						content += " <tr> <td></td><td>" + ti.getTlrno()
								+ "</td><td>" + ti.getTlrName() + "</td>"
								+ "<td>查询用户</td><td>"
								+ lockAndUnlock(ti.getStatus()) + "</td><td>"
								+ ti.getLastUpdTms() + "</td><td>前置系统用户</td>"
								+ "<td>" + city + "</td></tr>";

					}
					// else {
					// personalBureauEnquiry = "N";
					// }

					if ("Com Enq".equals(roleName)
							|| "Com Enq Batch".equals(roleName)
							|| "Com Enq Emerg".equals(roleName)) {
						corpBureauEnquiry = "Y";
						content += " <tr> <td></td><td>" + ti.getTlrno()
								+ "</td><td>" + ti.getTlrName() + "</td>"
								+ "<td>查询用户</td><td>"
								+ lockAndUnlock(ti.getStatus()) + "</td><td>"
								+ ti.getLastUpdTms() + "</td><td>前置系统用户</td>"
								+ "<td>" + city + "</td></tr>";
					}
					// else {
					// corpBureauEnquiry = "N";
					// }

				}
				content += " </table>  </html>";
				content1 += " </table>  </html>";
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_MONTHLYUSERMODIFY, content, title);
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_MONTHLYUSERMODIFY, content1, title1);
			}
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

	private String lockAndUnlock(String status) {
		if (status.equals("2")) {
			return "停用";
		} else if (status.equals("0") || status.equals("1")) {
			return "启用";
		}
		return status;
	}

	private String transfer_toString(Object str_son) {
		if (null == str_son)
			return "NULL".toString();
		return str_son.toString();
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

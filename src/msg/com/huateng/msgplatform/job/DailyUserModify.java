package com.huateng.msgplatform.job;

import java.text.DateFormat;
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

public class DailyUserModify implements org.quartz.StatefulJob {
	@SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(DailyUserModify.class);

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
			/*配置定时任务--qx*/
			startTm = new Date();//*获取当前时间
			jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();
			/*判断是否为节假日,并将标记为"该JOB只在工作日执行"--qx*/
			if (DateUtil.isHoliday()
					&& "Y".equals(jobConfig.getJustWorkdateRun())) {
				remark = "该JOB只在工作日执行";
				return;
			}
			/*获取定时时间范围，此处为每天，将作为sql查询的时间条件--qx*/
			DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");// 年月日
			String day = fmt.format(startTm);// 获取当前时间的年月日
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal
					.getTime());
			System.out.println(yesterday);
			// 个人征信报告查询监控（包括单笔和batch）
			/*查询每天用户信息变化表信息，并将其添加为TlrInfoChange类型的list集合--qx*/
			StringBuffer hql = new StringBuffer(
					"select to from TlrInfoChange to where 1=1");
			hql.append(" and lastUpdTms >= '" + yesterday + " 00:00:00" + "'");
			hql.append(" and lastUpdTms <= '" + day + " 00:00:00" + "'");
			List<TlrInfoChange> listtrl = ROOTDAOUtils.getROOTDAO()
					.queryByCondition(hql.toString());
			/*设置邮件格式：标题、内容--qx*/
			String title = "Daily User change report - Personal";
			String title1 = "Daily User change report - Corp";
			String content = "";
			String content1 = "";
			String roleName = null;
			content1 = content += "<h4>Dear All,</h4>";
			content1 = content += "This user change report for your reference.<br>";
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
					/*map.put(dc.getDataNo(), dc.getDataName());通过data_dic字典data_type_no查询并返回data_no和data_name的map集合--qx*/
					mflag = DataMapService.getNameByNo(38);
					mcity = DataMapService.getNameByNo(503);
					mregion = DataMapService.getNameByNo(502);
					mdepartMent = DataMapService.getNameByNo(501);
					/*返回''或者字典对应的名称data_name--qx*/
					String flag = checkNull(mflag,
							transfer_toString(ti.getFlag()));
					String city = checkNull(mcity,
							transfer_toString(ti.getCity()));
					String region = checkNull(mregion,
							transfer_toString(ti.getRegion()));
					String departMent = checkNull(mdepartMent,
							transfer_toString(ti.getDepartment()));
					/*获取ROLE_NAME--qx*/
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
						MailConstants.SEND_DAILYUSERMODIFY, content, title);
				SendMailService.getMailBeanAndSendMail(
						MailConstants.SEND_DAILYUSERMODIFY, content1, title1);
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
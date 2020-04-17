package com.huateng.msgplatform.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.report.common.service.ReportCommonService;

import resource.bean.basic.CorpCust;
import resource.bean.basic.InqCust;
import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.TlrInfo;

@SuppressWarnings("rawtypes")
public class CheckUserNoWorkJob implements org.quartz.StatefulJob {
	private Logger htlog = Logger.getLogger(CheckUserNoWorkJob.class);
	private String ROLE_ID = "('202','226','228','212')";

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		// TODO Auto-generated method stub

		String result = ReportCommonService.JOB_OK;
		Date endTm = null;
		String jobName = null;
		String jobId = null;
		String remark = "";
		Date startTm = null;

		try {
			jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class,
					jobId);
			jobName = jobConfig.getJobName();
			remark = jobConfig.getJobRemark();
			startTm = new Date();
			System.out.println("startTm" + startTm);
			checkUser();
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

	private void checkUser() {
		try {
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String sql = "select distinct(info.TLRNO) from TLR_INFO info " +
						   "left join TLR_ROLE_REL po " +
					         "on info.TLRNO = po.TLRNO " +
					     " where ROLE_ID in " + ROLE_ID +  
					       " and info.STATUS in (0,1);";
			Iterator it = rootdao.queryBySQL2(sql.toString());
			while (it.hasNext()) {
				Map map = (Map) it.next();
				String TLRNO = transfer_toString(map.get("TLRNO"));
				doCheckof30days(TLRNO);
			}
				

		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void doCheckof30days(String createUser) {
		try {
			String hqlInd = "from InqCust as e where e.createUser='" + createUser +"' order by ID desc";
			String hqlCorp = "from CorpCust as e where e.createUser='" + createUser +"' order by ID desc";
			
			List<InqCust> listInd = new ArrayList<InqCust>();
			List<CorpCust> listCorp = new ArrayList<CorpCust>();
			
			listInd = ROOTDAOUtils.getROOTDAO().pageQueryByHql(hqlInd,1, 1); 
			listCorp = ROOTDAOUtils.getROOTDAO().pageQueryByHql(hqlCorp,1, 1); 
			boolean indflag = false;
			boolean corpflag = false;
			Date nowTime = new Date();

			if (listInd.size() > 0) {
				InqCust inqCust = listInd.get(0);
				Date inqCreateTime = inqCust.getCreateTime();
				long days = (nowTime.getTime() - inqCreateTime.getTime())
						/ 1000 / 60 / 60 / 24;
				if (days > 30) {
					indflag = true;
				}
			}

			if (listCorp.size() > 0) {
				CorpCust corpCust = listCorp.get(0);
				Date corpCreateTime = corpCust.getCreateTime();
				long days = (nowTime.getTime() - corpCreateTime.getTime())
						/ 1000 / 60 / 60 / 24;
				if (days > 30) {
					corpflag = true;
				}
			}

			if ((indflag && listCorp.size() == 0)//个人查询标记为 并且没有企业查询
					|| (corpflag && listInd.size() == 0)//企业查询标记为 并且没有个人查询
					|| (indflag && corpflag)) {//个人查询标记为 并且 企业查询标记为
				updateStatus(createUser);
			}

		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

	private void updateStatus(String tlrno) {
		try {
			String hql = "from TlrInfo as e where e.tlrno='" + tlrno +"'";
			List<TlrInfo> list = new ArrayList<TlrInfo>();
			list = ROOTDAOUtils.getROOTDAO().pageQueryByHql(hql,1, 1); 
			TlrInfo tlrInfo = list.get(0);
			tlrInfo.setStatus("3");
			ROOTDAOUtils.getROOTDAO().update(tlrInfo);
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}
	private String transfer_toString(Object str_son) {
		if (null == str_son)
			return "NULL".toString();
		return str_son.toString();
	}
}

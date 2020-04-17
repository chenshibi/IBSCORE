package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.dao.PbocQueryHistoryQueryDAO;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.utils.DateUtils;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.SysParams;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocHistoryQuery;
import resource.dao.basic.SysParamsDAO;

public class PbocQueryHistoryJob implements org.quartz.StatefulJob {
	 private Logger htlog = Logger.getLogger(PbocQueryHistoryJob.class);
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		 String result = ReportCommonService.JOB_OK;
	     Date startTm = null;
	     Date endTm = null;
	     String jobName = null;
	     String jobId = null;
	     String remark = "";
	     try{
	    	  startTm = new Date();	 
         jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
         ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
         ReportJobConfig jobConfig;
		
	     jobConfig = rootdao.query(ReportJobConfig.class, jobId);
         jobName = jobConfig.getJobName();
         remark = jobConfig.getJobRemark();
         startTm = new Date();

         if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
             remark = "该JOB只在工作日执行";
             return;
         }
         
         SysParamsDAO dao=DAOUtils.getSysParamsDAO();
         List list1=dao.findByProperty("paramName", "查询日期");
         SysParams param=(SysParams)list1.get(0);
         String value=param.getParamVal();
         
         Date currentDate = new Date();   
         PbocQueryHistoryQueryDAO historyDao = BaseDAOUtils.getPbocQueryHistoryQueryDAO();
         PbocQueryHistoryQueryDAO queryDAO=BaseDAOUtils.getPbocQueryHistoryQueryDAO();
         String sql="select c.* from CUST_PBOC_HISTORY_QUERY c where c.IS_Lock = '0' and c.status = '02'";
         List list = DAOUtils.getHQLDAO().queryBySQL2List(sql);   
         for(int i=0;i<list.size();i++){
        	 Map map = new HashMap();
        	map = (Map)list.get(i);
        	 String findDate =(String)map.get("QUERY_DATE");//查询日期
        	 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        	 Date lastDate = sf.parse(findDate);
        	 int a=DateUtils.getDaysBetween(currentDate, lastDate);
        	 if(a>=Integer.valueOf(value)){
        		 CustPbocHistoryQuery history = new CustPbocHistoryQuery();
        		    history.setEntCertNum((String)map.get("ENT_CERT_NUM"));
        			history.setEntCertType((String)map.get("ENT_CERT_TYPE"));
        			history.setEntName((String)map.get("ENT_NAME"));
        			history.setId((String)map.get("ID"));
        			history.setIsLock("1");//1-已锁定
        			history.setQueryDate((String)map.get("QUERY_DATE"));
        			history.setQueryReason((String)map.get("QUERY_REASON"));
        			history.setUserId((String)map.get("user_Id"));
        			history.setStatus((String)map.get("STATUS"));
        			queryDAO.update(history);
        	 }
        	 
         }
         
	     }catch(Exception e){
	    	 e.printStackTrace();
	    	 htlog.info("Job执行失败！");
	    	 
	     }
		
		
	}

}

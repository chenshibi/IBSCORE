package com.huateng.msgplatform.job;

import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.service.ReportCommonService;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SqlConstantUtils;
import com.huateng.report.utils.WriteDbToExcelUtil;

import resource.bean.basic.ReportJobConfig;

public class CorpDataExtractionJob implements org.quartz.StatefulJob {
    @SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(CorpDataExtractionJob.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String result = ReportCommonService.JOB_OK;
        Date startTm = null;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        Connection oracleConnection =null;
        try {
            startTm = new Date();
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();
            String firstMonthDay = DateUtils.getFirstMonthDay();
            firstMonthDay=firstMonthDay.replace("-", "");
            String lastMonthDay = DateUtils.getLastMonthDay();
            lastMonthDay=lastMonthDay.replace("-", "");
            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            String user = ReportUtils.getSysParamsValue("ORACLE", "USER");
            String pwd=ReportUtils.getSysParamsValue("ORACLE", "PWD");
            oracleConnection=ReportUtils.getOracleConnection(user,pwd);
            htlog.info("==========="+oracleConnection+"连接成功");
            StringBuffer sb=new StringBuffer();
   		    sb.append("select B.resp_Id from  Cust_Pboc_Ent_Query B ")
   	       .append(" where substr(B.resp_Time,1,8)  BETWEEN ").append("'").append(firstMonthDay).append("'")
   		    .append(" and '").append(lastMonthDay).append("' ");
			String inSql=sb.toString();
            LinkedHashMap<String, String> sqlMap = WriteDbToExcelUtil.getGen2TableMap(inSql);
            Iterator<Entry<String, String>> iterator = sqlMap.entrySet().iterator();
            String path = ReportUtils.getSysParamsValue("DATA", "GENCORP") + File.separator + firstMonthDay.substring(0, 6) + File.separator;
            WriteDbToExcelUtil.isChartPathExist(path);
            long start=System.currentTimeMillis();
            htlog.info("===========生成二代数据表开始=============");
            htlog.info("==========="+"start time :"+start+"(ms)");
            while (iterator.hasNext()) { 
            	  Map.Entry<String, String> entry = iterator.next(); 
            	  htlog.info("===========生成"+entry.getKey().trim()+"数据表Excel开始===========");
            	  String gen2CorpSql = SqlConstantUtils.getGen2CorpSql(inSql, entry.getKey().trim());
            	  int queryNum = ReportUtils.queryCount(oracleConnection,gen2CorpSql);
            	  WriteDbToExcelUtil.writeDbtoExcel(oracleConnection,entry.getValue(), entry.getKey().trim(),path,queryNum);
            	  htlog.info("===========生成"+entry.getKey().trim()+"数据表Excel结束===========");
            	}
            long end=System.currentTimeMillis();
            htlog.info("===========生成二代数据表结束=============");
            htlog.info("==========="+"end time :"+end+"(ms)");
            htlog.info("==========="+"总 run time :"+(end-start)+"(ms)");
        } catch (Exception e) {
            e.printStackTrace();
            result = ReportCommonService.JOB_FAILED;
            remark = e.getMessage();
        } finally {
        	endTm = new Date();
            ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
            ReportUtils.closeConnection(oracleConnection);
        }
    }
    
}

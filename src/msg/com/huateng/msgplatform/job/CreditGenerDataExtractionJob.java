package com.huateng.msgplatform.job;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import com.huateng.report.pboc.entity.DataGenCorpEntity;
import com.huateng.report.pboc.entity.DataGenEntity;
import com.huateng.report.utils.DateUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SqlConstantUtils;
import com.huateng.report.utils.WriteDbToExcelUtil;

import resource.bean.basic.ReportJobConfig;
/**
 * 
 * @author Grassy
 *
 */
public class CreditGenerDataExtractionJob implements org.quartz.StatefulJob {
    @SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(CreditGenerDataExtractionJob.class);
    
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
            String lastMonthDay = DateUtils.getLastMonthDay();
            String queryDate=firstMonthDay.replaceAll("-", "").substring(0, 6);
            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            String user = ReportUtils.getSysParamsValue("ORACLE", "USER");
            String pwd=ReportUtils.getSysParamsValue("ORACLE", "PWD");
            ArrayList <DataGenEntity> beanList=new ArrayList<DataGenEntity>();
            ArrayList<DataGenCorpEntity> entityList=new ArrayList<DataGenCorpEntity>();
            DataGenEntity bean=null;
            DataGenCorpEntity entity=null;
            oracleConnection=ReportUtils.getOracleConnection(user,pwd);
            htlog.info("==========="+oracleConnection+"连接成功");
            StringBuffer sb=new StringBuffer();
            sb.append("select ia.Rpt_id  as rptId,ic.inq_cust_appid as inqCustAppId from ind_app ia left join inq_cust ic on ia.id=ic.inq_cust_appid where 1=1 ")
            .append("AND ia.Rpt_id IS NOT NULL and ia.Rpt_id <> ' ' ").append(" AND to_char(ia.return_time,'yyyy-mm-dd HH24:MI:SS')>=to_char")
            .append("(to_date('").append(firstMonthDay).append(" 00:00:00','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')")
            .append(" AND to_char(ia.return_time,'yyyy-mm-dd HH24:MI:SS')<=to_char(to_date('").append(lastMonthDay)
            .append(" 23:59:59','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')").append(" ORDER BY ia.return_time DESC");
            Iterator it = rootdao.queryBySQLGen(sb.toString()); 
            while (it.hasNext()) {
                Map map = (Map)it.next();
                bean=new DataGenEntity();
                if (map.get("rptId") != null) {
                	bean.setRptId(map.get("rptId").toString());
                } if(map.get("inqCustAppId") != null) {
            	    bean.setInqCustAppId(map.get("inqCustAppId").toString());
                  }
              beanList.add(bean);
         } 
            StringBuffer bf=new StringBuffer();
            bf.append("select cc.rpt_key as rptKey,tca.id as corpCustId,tcda.rpt_key as detailrptKey from corp_cust tca left join t_corp_app cc on tca.corp_cust_appid=cc.id")
            .append(" left join t_corp_detail_app tcda   on tcda.id=tca.corp_cust_detail_id where 1=1 and  cc.rpt_key is not null and cc.rpt_key <> '-' and cc.rpt_key <> ' '")
            .append(" AND to_char(cc.return_time,'yyyy-mm-dd HH24:MI:SS')>=to_char")
            .append("(to_date('").append(firstMonthDay).append(" 00:00:00','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')")
            .append(" AND to_char(cc.return_time,'yyyy-mm-dd HH24:MI:SS')<=to_char(to_date('").append(lastMonthDay)
            .append(" 23:59:59','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')").append(" ORDER BY cc.return_time DESC");
            Iterator iter = rootdao.queryBySQLGenCorp(bf.toString());
            while(iter.hasNext()) {
            	 Map map=(Map)iter.next();
            	 entity=new DataGenCorpEntity();
            	 if(map.get("rptKey")!=null) {
            		 entity.setRptKey(map.get("rptKey").toString());
            	 }if(map.get("corpCustId")!=null) {
            		 entity.setCorpCustId(map.get("corpCustId").toString());
            	 }if(map.get("detailrptKey")!=null) {
            		 entity.setDetailrptKey(map.get("detailrptKey").toString());
            	 }
            	 entityList.add(entity);
            }
            Map<String, ArrayList<String>> newMap = WriteDbToExcelUtil.getNewMap(beanList);
            Map<String, ArrayList<String>> newMap2 = WriteDbToExcelUtil.getNewMap2(entityList);
        	Map<String,String> paramMap=new HashMap();
        	paramMap.put("queryDate", queryDate);
            ReportUtils.delete(oracleConnection,paramMap, SqlConstantUtils.TMP_PER_REPORTID);
            ReportUtils.delete(oracleConnection,paramMap, SqlConstantUtils.TMP_CUST_APPID);
            ReportUtils.delete(oracleConnection,paramMap, SqlConstantUtils.TMP_CORP_REPORTID);
            ReportUtils.delete(oracleConnection,paramMap, SqlConstantUtils.TMP_CORP_CUSTID);
            ReportUtils.batchInsert(oracleConnection,paramMap, newMap.get("reportId"),SqlConstantUtils.TMP_PER_REPORTID);
            ReportUtils.batchInsert(oracleConnection,paramMap, newMap.get("inqCustId"), SqlConstantUtils.TMP_CUST_APPID);
            ReportUtils.batchInsert(oracleConnection,paramMap, newMap2.get("reportId"), SqlConstantUtils.TMP_CORP_REPORTID);
            ReportUtils.batchInsert(oracleConnection,paramMap, newMap2.get("corpCustId"), SqlConstantUtils.TMP_CORP_CUSTID);
			/*String rptStrs = CustomerLevelQueryUtil.implode("','", newMap.get("reportId"));
			String cusAppIdStrs=CustomerLevelQueryUtil.implode("','", newMap.get("inqCustId"));
			String rptKeys=CustomerLevelQueryUtil.implode("','", newMap2.get("reportId"));
			String corpustIds=CustomerLevelQueryUtil.implode("','", newMap2.get("corpCustId"));*/
            String rptStrs=SqlConstantUtils.TMP_PER_REPORTID_SQL;
			String cusAppIdStrs=SqlConstantUtils.TMP_CUST_APPID_SQL;
			String rptKeys=SqlConstantUtils.TMP_CORP_REPORTID_SQL;
			String corpustIds=SqlConstantUtils.TMP_CORP_CUSTID_SQL;
			LinkedHashMap<String, String> sqlMap = SqlConstantUtils.getDataTableMap(rptStrs,cusAppIdStrs,rptKeys,corpustIds);
            Iterator<Entry<String, String>> iterator = sqlMap.entrySet().iterator();
            String path = ReportUtils.getSysParamsValue("DATA", "GEN") + File.separator + queryDate + File.separator;
            WriteDbToExcelUtil.isChartPathExist(path);
            long start=System.currentTimeMillis();
            htlog.info("===========生成一代数据表开始=============");
            htlog.info("==========="+"start time :"+start+"(ms)");
            while (iterator.hasNext()) { 
            	  Map.Entry<String, String> entry = iterator.next(); 
            	  htlog.info("===========生成"+entry.getKey().trim()+"数据表Excel开始===========");
            	  String genSql = SqlConstantUtils.getDataTableMap(rptStrs, cusAppIdStrs, rptKeys, corpustIds,entry.getKey().trim());
            	  int queryCount = ReportUtils.queryCount(oracleConnection,genSql);
            	  WriteDbToExcelUtil.writeDbtoExcel(oracleConnection,entry.getValue(), entry.getKey().trim(),path,queryCount);
            	  htlog.info("===========生成"+entry.getKey().trim()+"数据表Excel结束===========");
            	}
            long end=System.currentTimeMillis();
            htlog.info("===========生成一代数据表结束=============");
            htlog.info("==========="+"end time :"+end+"(ms)");
            htlog.info("==========="+"run time :"+(end-start)+"(ms)");
        }
         catch (Exception e) {
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

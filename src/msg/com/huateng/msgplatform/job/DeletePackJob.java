package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.SysParams;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.ZipUtil;
import com.huateng.report.common.service.ReportCommonService;

public class DeletePackJob implements org.quartz.StatefulJob {
    @SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(DeletePackJob.class);

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String result = ReportCommonService.JOB_OK;
        Date startTm = null;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        try {
            startTm = new Date();
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();

            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }
            
            List<SysParams> listPackDayq = null;//个人打包Q天以前
            List<SysParams> listPackDayp = null;//企业打包P天以前
            List<SysParams> listPackDaydq = null;//个人打包Q天以前
            List<SysParams> listPackDaydp = null;//企业打包P天以前
            List<SysParams> listPutPath = null;//  打包文件存放地址
         
           
           //获得delete天数 企业是P 
            StringBuffer hql3 = new StringBuffer("select po from SysParams po where 1=1 ");
            hql3.append(" and po.id.paramgroupId = 'ORIGINAL'");
            hql3.append(" and po.id.paramId = 'CORP'");
            listPackDaydp = ROOTDAOUtils.getROOTDAO().queryByCondition(hql3.toString());
            htlog.info(hql3);
            
            //获得delete天数 个人是Q 
            StringBuffer hql4 = new StringBuffer("select po from SysParams po where 1=1 ");
            hql4.append(" and po.id.paramgroupId = 'ORIGINAL'");
            hql4.append(" and po.id.paramId = 'IND'");
            listPackDaydq = ROOTDAOUtils.getROOTDAO().queryByCondition(hql4.toString());
            htlog.info(hql4);
            //获得打包目录
            StringBuffer hql1 = new StringBuffer("select po from SysParams po where 1=1 ");
            hql1.append(" and po.id.paramgroupId = 'PACK'");
            hql1.append(" and po.id.paramId = 'FILEPATH'");
            listPutPath = ROOTDAOUtils.getROOTDAO().queryByCondition(hql1.toString());
            htlog.info(hql1);
            
            
            //获得打包天数 企业是P 
            StringBuffer hqlp = new StringBuffer("select po from SysParams po where 1=1 ");
            hqlp.append(" and po.id.paramgroupId = 'PACK'");
            hqlp.append(" and po.id.paramId = 'PDAY'");
            listPackDayp = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlp.toString());
            htlog.info(hqlp);
            
            //获得打包天数 个人是Q 
            StringBuffer hqlq = new StringBuffer("select po from SysParams po where 1=1 ");
            hqlq.append(" and po.id.paramgroupId = 'PACK'");
            hqlq.append(" and po.id.paramId = 'QDAY'");
            listPackDayq = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlq.toString());
            htlog.info(hqlq);
            
            String dayq = listPackDayq.get(0).getParamVal();//查询要打包多少天之前的个人征信文件q
            String daydq = listPackDaydq.get(0).getParamVal();//查询要打包多少天之前的个人征信文件q
            String dayp = listPackDayp.get(0).getParamVal();//查询要打包多少天之前的企业征信文件p
            String daydp = listPackDaydp.get(0).getParamVal();//查询要打包多少天之前的企业征信文件p
            String putPath=listPutPath.get(0).getParamVal();   //打包文件存放目录
            
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)-Integer.parseInt(dayq)-Integer.parseInt(daydq));//q天之前
            Date today=calendar.getTime();
            SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
            int q=Integer.parseInt(format.format(today));
            
            Calendar calendar1 = Calendar.getInstance();
            calendar1.set(Calendar.DAY_OF_YEAR, calendar1.get(Calendar.DAY_OF_YEAR)-Integer.parseInt(dayp)-Integer.parseInt(daydp));//p天之前
            Date today1=calendar1.getTime();
            SimpleDateFormat format1=new SimpleDateFormat("yyyyMMdd");
            int p=Integer.parseInt(format1.format(today1));
            if(putPath!=null){
            	ZipUtil.delete(putPath,q,"ind-");
                ZipUtil.delete(putPath,p,"corp-");
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            result = ReportCommonService.JOB_FAILED;
            remark = e.getMessage();
        } finally {
            endTm = new Date();
            ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
        }
    }
    
}

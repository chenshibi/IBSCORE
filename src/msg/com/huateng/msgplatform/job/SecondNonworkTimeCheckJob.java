package com.huateng.msgplatform.job;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.management.service.SendMailService;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.htaml.reportForm.util.MailConstants;
import com.huateng.report.common.service.ReportCommonService;

import resource.bean.basic.ReportJobConfig;
import resource.bean.basic.SysParams;
import resource.bean.basic.TlrInfo;
import resource.bean.crms.CustPbocEntQuery;
import resource.bean.crms.CustPbocPerQuery;

public class SecondNonworkTimeCheckJob implements org.quartz.StatefulJob {
    @SuppressWarnings("unused")
	private Logger htlog = Logger.getLogger(SecondNonworkTimeCheckJob.class);

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
            
            String hqls = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
 	        ArrayList<String> condList = new ArrayList<String>();
 	        condList.add("NON_WORK");
 	        condList.add("START");
 		    List<SysParams> lists = rootdao.queryByCondition(hqls,condList.toArray());
 	  	    
 	  	    String hqle = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
	        ArrayList<String> condListn = new ArrayList<String>();
	        condListn.add("NON_WORK");
	        condListn.add("OFF");
		    List<SysParams> liste = rootdao.queryByCondition(hqle,condListn.toArray());
		    
            String hqlL = "select po from SysParams po where 1=1 and po.id.paramgroupId = ? and po.id.paramId = ?";
	        ArrayList<String> condListL = new ArrayList<String>();
	        condListL.add("NON_WORK");
	        condListL.add("QUERY");
		    List<SysParams> listL = rootdao.queryByCondition(hqlL,condListL.toArray());
		    
		    String starTime=lists.get(0).getParamVal();
		    String endTime=liste.get(0).getParamVal();
	  	    int  L=Integer.parseInt(listL.get(0).getParamVal());//工作起始时间
	  	    
	  	    DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");//年月日
            String day=fmt.format(startTm);//获取当前时间的年月日
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE,-1);
            String yesterday=new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
	  	    
            List listInq = new ArrayList<CustPbocPerQuery>();
            StringBuffer hql = new StringBuffer("select count(*) ,createUser from CustPbocPerQuery po where 1=1");
            hql.append(" and createTime >= '"+yesterday+" "+endTime+"'");
        	hql.append(" and createTime <= '"+day+" "+starTime+"'");
            hql.append(" group by createUser ");
            listInq = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            
            String title="Warning of PBOC Bureau Non-working Enquiry - Personal";
    		String content="";
            content+="<h4>Dear Admin,</h4>";
            content+="During"+yesterday+" "+endTime+"'"+"to "+day+" "+starTime+"'"+" below user just performed  bureau enquiry during non-working hours.";
            content+="<br/>";
            content+="Please kindly find the detailed information listed.";
            content+="<html>    <table style='border:1px solid black;'>";
            content+=" <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th> </tr>";
            int sum=0;
            for(int i=0;i<listInq.size();i++){
                Object[] obj=(Object[])listInq.get(i);
            	Long count=(Long) obj[0];
            	String name=(String)obj[1];
            	if(count>L){
            		sum++;
           		 StringBuffer tlrhql = new StringBuffer("select po from TlrInfo po where tlrno='"+name+"'");
           		 List<TlrInfo> listTlr=new ArrayList<TlrInfo>();
           		 listTlr= ROOTDAOUtils.getROOTDAO().queryByCondition(tlrhql.toString());
           		 if(listTlr !=null && listTlr.size()>0){
           			 content+=" <tr> <td>"+listTlr.get(0).getIdNumber()+"</td><td>"+listTlr.get(0).getTlrName()+"</td><td>"+listTlr.get(0).getRegion()+"</td><td>"+listTlr.get(0).getCity()+"</td><td>"+listTlr.get(0).getDepartment()+"</td><td>"+count+"</td> </tr>";
           		 }
            	}
            }
            content+=" </table>  </html>";
            if(sum>0){
        		SendMailService.getMailBeanAndSendMail(MailConstants.SEND_NONWORK, content,title);   
            }
            
            
            
            List listCorp = new ArrayList<CustPbocEntQuery>();
            StringBuffer hqlc = new StringBuffer("select count(*) ,createUser from CustPbocEntQuery po where 1=1");
            hqlc.append(" and createTime >= '"+yesterday+" "+endTime+"'");
        	hqlc.append(" and createTime <= '"+day+" "+starTime+"'");
            hqlc.append(" group by createUser ");
            listCorp = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlc.toString());
            
    		String content1="";
    		String title1="Warning of PBOC Bureau Non-working Enquiry - Corp";
            content1+="<h4>Dear Admin,</h4>";
            content1+="During"+yesterday+" "+endTime+"'"+"to "+day+" "+starTime+"'"+" below user just performed  bureau enquiry during non-working hours.";
            content1+="<br/>";
            content1+="Please kindly find the detailed information listed.";
            content1+="<html>    <table style='border:1px solid black;'>";
            content1+=" <tr> <th>ID</th><th>Name</th><th>Region</th><th>City</th><th>Dept</th><th>No. Inquiries</th> </tr>";
            int sum1=0;
            for(int i=0;i<listCorp.size();i++){
                Object[] obj=(Object[])listCorp.get(i);
            	Long count=(Long) obj[0];
            	String name=(String)obj[1];
            	if(count>L){
            		sum1++;
           		 StringBuffer tlrhql = new StringBuffer("select po from TlrInfo po where tlrno='"+name+"'");
           		 List<TlrInfo> listTlr=new ArrayList<TlrInfo>();
           		 listTlr= ROOTDAOUtils.getROOTDAO().queryByCondition(tlrhql.toString());
           		 if(listTlr !=null && listTlr.size()>0){
           			 content1+=" <tr> <td>"+listTlr.get(0).getIdNumber()+"</td><td>"+listTlr.get(0).getTlrName()+"</td><td>"+listTlr.get(0).getRegion()+"</td><td>"+listTlr.get(0).getCity()+"</td><td>"+listTlr.get(0).getDepartment()+"</td><td>"+count+"</td> </tr>";
           		 }
            	}
            }
            content1+=" </table>  </html>";
            if(sum1>0){
        		SendMailService.getMailBeanAndSendMail(MailConstants.SEND_NONWORK, content1,title1);   
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

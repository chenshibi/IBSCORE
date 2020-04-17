package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.msgplatform.mail.MailInfo;
import com.huateng.msgplatform.mail.MailSendResult;
import com.huateng.msgplatform.mail.MailUtil;
import com.huateng.msgplatform.mail.SmtpInfo;
import com.huateng.report.utils.DateUtils;

import resource.bean.basic.SysParams;
import resource.bean.basic.TlrInfo;
import resource.bean.msg.CpgMsgUsrTmp;
import resource.dao.basic.SysParamsDAO;
/**
 * 每个月查询超过20笔的用户锁定，域值可以配置，发邮件给锁定用户
 * @author chensibi
 *
 */
public class CheckUserNoQuery1Job implements org.quartz.StatefulJob{
	 private Logger htlog = Logger.getLogger(CheckUserNoQuery1Job.class);
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		//先获取系统维护参数
		 SysParamsDAO dao=DAOUtils.getSysParamsDAO();
         List list=dao.findByProperty("paramName", "每个月查询笔数");
         SysParams param=(SysParams)list.get(0);
         String month=param.getParamVal();
         
         List list1=dao.findByProperty("paramName", "笔数");
         SysParams param1=(SysParams)list1.get(0);
         String value1=param1.getParamVal();
         
         Date endDate = new Date();//当前日期
         //根据终止日计算起始日
         Date startDate = DateUtils.getStartDateByMonths(endDate, Integer.valueOf(month));//判断起始日
         SimpleDateFormat format =new SimpleDateFormat("yyyyMMdd");
         String a=format.format(startDate);
         StringBuffer buffer= new StringBuffer();
         //buffer.append("select a.* from (");
         buffer.append("select CREATE_USER from CUST_PBOC_ENT_QUERY where QUERY_DATE");
         buffer.append(" >= ").append("'");
         buffer.append(a);
         buffer.append("'");
         buffer.append(" group by CREATE_USER having count(CREATE_USER) > '").append(value1).append("'");
         try {
			List sql = DAOUtils.getHQLDAO().queryBySQL2List(buffer.toString());
			for(int i=0;i<sql.size();i++){
			Map map= new HashMap();
			map=(Map)sql.get(i);
			String userName=(String)map.get("CREATE_USER");
			updateStatus(userName);
			sendMails(userName);
			}
		} catch (CommonException e) {
			
			e.printStackTrace();
		}   
      		
	}
	
	public void sendMails(String userName){
		StringBuffer str=new StringBuffer();
		str.append("select * from Cpg_Msg_Usr_Tmp where USER_ID = '").append(userName).append("'");
		try {
			List sql = DAOUtils.getHQLDAO().queryBySQL2List(str.toString());
			Map map = new HashMap();			
			map=(Map)sql.get(0);
			String email=null;
			email=(String)map.get("RCV_INF");
			if(email==null||"".equals(email)){
				ExceptionUtil.throwCommonException("邮箱信息未维护");
			}
			
			//发送邮件
			 MailInfo mail = new MailInfo();
			 mail.setId("1");
	        mail.setContent("您的账户被锁定");
	        mail.setTitle("通知");
	        List<String> list11 = new ArrayList<String>();
	        list11.add(email);
	        mail.setAddresses(list11);
	        sendMail(mail);		
		} catch (CommonException e) {
			
			e.printStackTrace();
		}
		
	}
	
	 public MailSendResult sendMail(MailInfo mailInfo) {
	        MailSendResult result = new MailSendResult();

	        SmtpInfo smtpInfo = MailUtil.initSmtpInfo();
	        if (smtpInfo == null) {
	            htlog.info("get smtp info failed");
	            result.setFailedReason("get smtp info failed");
	            result.setSendResult(false);
	            return result;
	        }
	        return MailUtil.sendMail(smtpInfo, mailInfo);
	    }
	
	private void updateStatus(String userName) {
		try {
			String hql = "from TlrInfo as e where e.tlrno='" + userName +"'";
			List<TlrInfo> list = new ArrayList<TlrInfo>();
			list = ROOTDAOUtils.getROOTDAO().pageQueryByHql(hql,1, 1); 
			for(int i=0;i<list.size();i++){
			TlrInfo tlrInfo = list.get(i);
			tlrInfo.setIsLock("1");//1-已锁定
			ROOTDAOUtils.getROOTDAO().update(tlrInfo);
			}
		} catch (CommonException e) {
			e.printStackTrace();
		}
	}
	

}

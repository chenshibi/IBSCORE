package com.huateng.ebank.business.customer.operation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;

import resource.bean.basic.TCorpPermit;
import resource.bean.crms.CustPbocEntQuery;

public class TCorpPermitOperation2 extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(TCorpPermitOperation2.class);
 //	public static final String ID = "customer.TCorpPermitOperation2";
    public static final String CMD = "CMD";
    public static final String IN_PARAM = "IN_PARAM";
    public static final String IN_OPERATION = "IN_OPERATION";
	public static final String FILIED_MAP = "FILIED_MAP";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}
		
	@Override
	public void execute(OperationContext context) throws CommonException {
		 String cmd = (String) context.getAttribute(CMD);
	        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
	        BusinessUploadService service=new BusinessUploadService();
	        Map fieldMap = (Map) context.getAttribute("FILIED_MAP");
	        ROOTDAO rootDao =  ROOTDAOUtils.getROOTDAO();
			try {
				 //获取变量值
		        String loanCardNo=(String) fieldMap.get("form_loanCardNo");
		        String loanCardPass =(String) fieldMap.get("form_loanCardPass");
		        String enterpriseRegId =(String) fieldMap.get("form_enterpriseRegId"); 
		        String corpName =(String) fieldMap.get("form_corpName"); 
		        String fullPath=(String) fieldMap.get("filepath");
		        String date =(String) fieldMap.get("form_expireDate");
		        String time =(String) fieldMap.get("form_approveTime"); 
		        String id=(String) fieldMap.get("form_pbocEntId");
		        if(date.indexOf("/") > 0){
		        	 String[] dates = date.split("/");
		        	 if(dates[1].length() == 1){
		        		 dates[1] = "0" + dates[1];
		        	 }
		        	 if(dates[2].length() == 1){
		        		 dates[2] = "0" + dates[2];
		        	 }
		        	 date = dates[0] + dates[1] + dates[2];
		        }
		        if(time.indexOf("/") > 0){
		        	 String[] times = time.split("/");
		        	 if(times[1].length() == 1){
		        		 times[1] = "0" + times[1];
		        	 }
		        	 if(times[2].length() == 1){
		        		 times[2] = "0" + times[2];
		        	 }
		        	 time = times[0] + times[1] + times[2];
		        }
		        System.out.println("======================="+time+"=========================");
		        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		        List<TCorpPermit> list=service.getTCorpPermitQuery(loanCardNo);
		        if(null != list && list.size()>0){
		        	for (TCorpPermit tCorpPermit : list) {
						String status=tCorpPermit.getStatus();
						//0是无效 1是有效
						tCorpPermit.setStatus("0");
						rootDao.saveOrUpdate(tCorpPermit);
						htlog.info("TCorpPermit表status已置为0！");
					}
		        }
		        	 Date expireDate= sdf.parse(date);
		        	 Date approveTime=sdf.parse(time);
				        TCorpPermit  tcorpPermit =new TCorpPermit();
				        tcorpPermit.setLoanCardNo(loanCardNo);
				        tcorpPermit.setLoanCardPass(loanCardPass);
				        tcorpPermit.setEnterpriseRegId(enterpriseRegId);
				        tcorpPermit.setCorpName(corpName);
				        tcorpPermit.setCustomerConUp(fullPath);
				        tcorpPermit.setCreateUser(globalinfo.getTlrno());
				        tcorpPermit.setInputTime(DateUtil.getTimestamp());
				      /*  Timestamp expireTimeStamp = new Timestamp(expireDate.getTime());
				        String expireStr = expireTimeStamp.toString().substring(0, expireTimeStamp.toString().indexOf("."));
				       tcorpPermit.setExpireDate(java.sql.Timestamp.valueOf(expireStr));*/
				       tcorpPermit.setExpireDate(expireDate);
				       tcorpPermit.setApproveTime(approveTime);
				        tcorpPermit.setStatus("1");
				        rootDao.save(tcorpPermit);
				        htlog.info("写入TCorpPermit表成功！");
				        if(StringUtils.isNotEmpty(id)) {
				        	   CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
						        CustPbocEntQuery custPbocEntQuery = dao.findById(id);
						        custPbocEntQuery.setCertAuthStatus("01");
						        dao.update(custPbocEntQuery);
				        }
				       
		       
			} catch (ParseException e) {
				ExceptionUtil.throwCommonException("提交数据库失败！");
				e.printStackTrace();
			}
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}

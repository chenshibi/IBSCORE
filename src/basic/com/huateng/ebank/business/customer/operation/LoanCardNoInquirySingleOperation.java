package com.huateng.ebank.business.customer.operation;

import java.util.Date;
import java.util.List;

import resource.bean.basic.TCorpLoancardInq;
import resource.bean.basic.TCorpPermit;
import com.huateng.ebank.framework.util.DateUtil;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class LoanCardNoInquirySingleOperation extends BaseOperation {
	private static final HtLog htlog = HtLogFactory.getLogger(LoanCardNoInquirySingleOperation.class);
 	public static final String ID = "customer.LoanCardNoInquirySingleOperation";
    public static final String CMD = "CMD";
    public static final String IN_PARAM = "IN_PARAM";
    public static final String IN_OPERATION = "IN_OPERATION";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		 String cmd = (String) context.getAttribute(CMD);
	        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
	        TCorpLoancardInq tcorpLoancardInq = (TCorpLoancardInq) context.getAttribute(IN_OPERATION);
	        List<TCorpLoancardInq> paramList = (List) context.getAttribute(IN_PARAM);
	        BusinessUploadService service=new BusinessUploadService();
	        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
	        //獲取個人征信信息
	            for (int i = 0; i < paramList.size(); i++) {
	                String inquiryType = paramList.get(i).getInquiryType();
	                String inquiryValue= paramList.get(i).getInquiryValue();
	                String queryReason=paramList.get(i).getQueryReason();
//	                List<TCorpPermit> list=service.getTCorpPermit(loanCardNo);
//	                if(list==null && list.size()<0){
	                	tcorpLoancardInq.setInquiryValue(inquiryValue);
	                	tcorpLoancardInq.setInquiryType(inquiryType);
	                	tcorpLoancardInq.setQueryReason(queryReason);
	                	tcorpLoancardInq.setStatus("1");
	                	tcorpLoancardInq.setInputTime(DateUtil.getCurrentTime());
	                	tcorpLoancardInq.setPwid(globalinfo.getTlrno());
	                	tcorpLoancardInq.setCreateUserIp(globalinfo.getIp());
	                	rootDao.save2(tcorpLoancardInq);
	                    
//	                }else{
//	                	  ExceptionUtil.throwCommonException("该记录已被提交，请勿重复提交！");
//	                }
	                
//	                saveLog("新增");
	            }
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}

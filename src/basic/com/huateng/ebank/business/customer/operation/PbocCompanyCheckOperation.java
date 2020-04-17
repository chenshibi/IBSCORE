package com.huateng.ebank.business.customer.operation;

import java.util.List;

import resource.bean.basic.CorpCust;
import resource.bean.basic.IndPermit;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class PbocCompanyCheckOperation extends BaseOperation{
	private static final HtLog htlog = HtLogFactory
			.getLogger(PbocCompanyCheckOperation.class);
	public static final String ID = "customer.PbocCompanyCheckOperation";
	public static final String CMD = "CMD";
	public static final String IN_PARAM = "IN_PARAM";
	public static final String IN_OPERATION = "IN_OPERATION";
	public static final String FLAG="";

	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(OperationContext context) throws CommonException {
		CorpCust corpCust= (CorpCust) context.getAttribute(IN_PARAM);
		BusinessUploadService service = new BusinessUploadService();
		String flag="0";
		if(null != corpCust ){
			String rloanCardId = corpCust.getCorpCustLoancard();
			String rcorpCustCompanyname = corpCust.getCorpCustCompanyname();
			String rcorpCustType = corpCust.getCorpCustType();
			//查询许可文件	
	        List<IndPermit> listPermitQueryCom = service.getIndPermitQuery(rcorpCustType, rcorpCustCompanyname, rloanCardId);
	        if(listPermitQueryCom==null||listPermitQueryCom.size()==0){
	        	flag="1";
				context.setAttribute(FLAG, flag);
	        }
			
		}
		
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

}

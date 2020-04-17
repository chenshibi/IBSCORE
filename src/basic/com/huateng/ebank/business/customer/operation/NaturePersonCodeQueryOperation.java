package com.huateng.ebank.business.customer.operation;

import java.util.Date;
import java.util.List;

import resource.bean.basic.TDetailIndApp;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

public class NaturePersonCodeQueryOperation extends BaseOperation {
	@SuppressWarnings("unused")
	private static final HtLog htlog = HtLogFactory.getLogger(NaturePersonCodeQueryOperation.class);
 	public static final String ID = "customer.NaturePersonCodeQueryOperation";
    public static final String IN_PARAM = "IN_PARAM";
	@Override
	public void beforeProc(OperationContext context) throws CommonException {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void execute(OperationContext context) throws CommonException {
	        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
	        TDetailIndApp tDetailIndApp = new TDetailIndApp();
	        List<TDetailIndApp> TDetailIndAppList = (List) context.getAttribute(IN_PARAM);
	        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
	        Date nowDay = new Date();
	        //獲取個人征信信息
	            for (int i = 0; i < TDetailIndAppList.size(); i++) {
	                String individualIdType = TDetailIndAppList.get(i).getIndividualIdType();
	                String individualId= TDetailIndAppList.get(i).getIndividualId();
	                String name=TDetailIndAppList.get(i).getName();
	                    tDetailIndApp.setRptKey("-");
	                    tDetailIndApp.setIndividualIdType(individualIdType);
	                    tDetailIndApp.setIndividualId(individualId);
	                    tDetailIndApp.setType("1");
	                    tDetailIndApp.setInputUser(globalinfo.getTlrno());
	                    tDetailIndApp.setInputTime(DateUtil.getTimestamp());
	                    tDetailIndApp.setQueryTime(DateUtil.getTimestamp());
	                    tDetailIndApp.setReturnTime(DateUtil.getTimestamp());
	                    tDetailIndApp.setParseTime(DateUtil.getTimestamp());
	                    tDetailIndApp.setStatus("1");
	                    tDetailIndApp.setInputUserIp(globalinfo.getIp());
	                    tDetailIndApp.setName(name);
	                    //tDetailIndApp.setInputTime(DateUtil.getCurrentTime());
	                	rootDao.save(tDetailIndApp);
	                    
	                
	            }
	}

	@Override
	public void afterProc(OperationContext context) throws CommonException {
	
	}

}

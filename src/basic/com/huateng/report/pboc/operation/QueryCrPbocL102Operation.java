package com.huateng.report.pboc.operation;

import org.apache.commons.lang3.StringUtils;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.dao.CrPbocL102DAO;
import com.huateng.report.pboc.util.Constant;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.crms.CrPbocL102;

/**
 * 
 * @author Grassy
 *
 */
public class QueryCrPbocL102Operation extends BaseOperation {
	
	  
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryCrPbocL102Operation.class);
    
    
    @Override
    public void beforeProc(OperationContext context) throws CommonException {

    }

    @Override
    public void execute(OperationContext context) throws CommonException {
            CrPbocL102DAO dao = ROOTDAOUtils.getCrPbocL102DAO();
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        	String uuid = (String) context.getAttribute("uuid");
            String status = (String) context.getAttribute("status");
            CrPbocL102 crPbocL102 = dao.findById(uuid);
            if (crPbocL102 !=null && StringUtils.equals("success", status)) {
            	 crPbocL102.setRecordStatus(Constant.RESP_QUERY_STATUS);
            	 SysParams sysParams = (SysParams)rootdao.query(SysParams.class, new SysParamsPK(
     					"BANK", "PWD"));
            	 String paramValue=(String)context.getAttribute("value");
            	 sysParams.setParamVal(paramValue);
            	 crPbocL102.setReceiptTime(DateUtil.get14Time());
            	 try {
            		 rootdao.saveOrUpdate(sysParams);
            		 dao.update(crPbocL102);
				} catch (CommonException e) {
					e.printStackTrace();
				}
             } else if(crPbocL102!=null && StringUtils.equals("failed", status)) {
            	 crPbocL102.setRecordStatus(Constant.FAIL_QUERY_STATUS);
            	 crPbocL102.setReceiptTime(DateUtil.get14Time());
            	 dao.update(crPbocL102);
             } 
    }


    @Override
    public void afterProc(OperationContext context) throws CommonException {

    }
}

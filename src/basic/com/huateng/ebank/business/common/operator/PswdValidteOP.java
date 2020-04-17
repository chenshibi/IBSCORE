/**
 *
 */
package com.huateng.ebank.business.common.operator;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resource.bean.basic.TlrInfo;

/**
 * Title: Description: Copyright: Copyright (c) 2011 Company: Shanghai Huateng
 * Software Systems Co., Ltd.
 * 
 * @author zhaozhiguo
 * @version 1.1
 */
public class PswdValidteOP extends BaseOperation {

    public final static String IN_OPER = "IN_OPER";
    public final static String ID = "Management.PswdValidteOP";
    public final static String NOT_LOCKED = "0";
    public final static String LOCKED = "1";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.
     * huateng.ebank.framework.operation.OperationContext)
     */
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void execute(OperationContext context) throws CommonException {
        TlrInfo oper = (TlrInfo) context.getAttribute(IN_OPER);
        DAOUtils.getTlrInfoDAO().update(oper);
    }

}

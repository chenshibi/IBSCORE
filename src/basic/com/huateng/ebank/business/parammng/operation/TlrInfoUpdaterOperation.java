/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.parammng.operation;

import java.util.Iterator;
import java.util.List;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrRoleRel;

/**
 * @author wuguangjie
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class TlrInfoUpdaterOperation extends BaseOperation {

    public static final String CMD = "CMD";
    public static final String TLRNO = "TLRNO";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        String tlrno = (String) context.getAttribute(TLRNO);
        TlrInfo tlrinfo = DAOUtils.getTlrInfoDAO().queryById(tlrno);
        if ("del".equals(cmd)) {
            List tlrref = DAOUtils.getTlrRoleRelDAO().queryByCondition("tlrno=" + tlrno);
            for (Iterator it = tlrref.iterator(); it.hasNext();) {
                TlrRoleRel ref = (TlrRoleRel) it.next();
                DAOUtils.getTlrRoleRelDAO().delete(ref);
            }
            DAOUtils.getTlrInfoDAO().delete(tlrno);

        } else if ("unlock".equals(cmd)) {
            tlrinfo.setIsLock("0");
            DAOUtils.getTlrInfoDAO().update(tlrinfo);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }
}
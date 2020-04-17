/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.operation;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-7-20
 *
 *       base operation class of the operations.
 */
public abstract class BaseOperation {
    // 是否需要记录日志, 缺省为不记录
    private boolean needLog = false;

    // 是否需要记录失败流水，缺省为不记录
    private boolean needFailLog = false;

    /*
     * (non-Javadoc)
     * 
     * @see com.huateng.ebank.framework.operation.BaseOperation#beforeProc(com.
     * huateng.ebank.framework.operation.OperationContext)
     */
    public abstract void beforeProc(OperationContext context) throws CommonException;

    /**
     *
     * @param context
     */
    public void procTLsrno(OperationContext context) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
        if (null != globalInfo) {
            String strTlrNo = GlobalInfo.getCurrentInstance().getTlrno();
            // 获取主流水号
            TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
            TlrInfo tlrInfo = null;

            tlrInfo = tlrInfoDAO.queryById(strTlrNo);
            if (tlrInfo == null) {
                ExceptionUtil.throwCommonException("系统登录失败", ErrorCode.ERROR_CODE_USER_NOT_EXIST);
            }

            Integer msrno = tlrInfo.getMsrno();
            if (msrno == null) {
                msrno = new Integer(1);
            } else {
                msrno = new Integer(msrno.intValue() + 1);

            }
            tlrInfo.setMsrno(msrno);

            GlobalInfo.getCurrentInstance().setTlsrnoPr(msrno.intValue());
            // 初始化次流水号
            GlobalInfo.getCurrentInstance().setTlsrnoEx(0);
            tlrInfoDAO.update(tlrInfo);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public abstract void execute(OperationContext context) throws CommonException;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.huateng.ebank.framework.operation.BaseOperation#afterProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public abstract void afterProc(OperationContext context) throws CommonException;

    /**
     * @return Returns the needLog.
     */
    public boolean isNeedLog() {
        return needLog;
    }

    /**
     * @param needLog
     *            The needLog to set.
     */
    public void setNeedLog(boolean needLog) {
        this.needLog = needLog;
    }

    public boolean isNeedFailLog() {
        return needFailLog;
    }

    public void setNeedFailLog(boolean needFailLog) {
        this.needFailLog = needFailLog;
    }
}
/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.commquery.common.CommonQueryConstants;
import com.huateng.commquery.servlet.CommQueryResultServlet;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.exception.DomainException;

/**
 * Title: BankCommQueryResultServlet Description: Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-1-1
 */
public class BankCommQueryResultServlet extends CommQueryResultServlet {
    private static final Logger log = Logger.getLogger(BankCommQueryResultServlet.class);

    /** memeber variable: long serialVersionUID. */
    private static final long serialVersionUID = -7846607176295431141L;

    /**
     * pre process
     * 
     * @param request
     * @param response
     * @throws DomainException
     */
    @Override
    protected Object preProcess(HttpServletRequest request, HttpServletResponse response) throws DomainException {
        try {
            init(request);
        } catch (CommonException cex) {
            throw new AppException("", cex.getKey(), ErrorCodeUtil.convertErrorMessage(log, cex), cex);
        }
        super.preProcess(request, response);
        return null;
    }

    /**
     * post process
     * 
     * @param request
     * @param response
     * @throws DomainException
     */
    @Override
    protected void postProcess(HttpServletRequest request, HttpServletResponse response, Exception ex, Object obj)
            throws DomainException {
    }

    /**
     * Initialize function for action
     *
     * @param request
     *            HttpServletRequest
     * @throws CommonException
     *             If error happened.
     */
    protected void init(HttpServletRequest request) throws CommonException {
        this.checkGlobalInfo(request);

    }

    protected GlobalInfo checkGlobalInfo(HttpServletRequest request) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getFromRequest(request);
        if (null == globalInfo) {
            ExceptionUtil.throwCommonException("用户没有登录.", ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID);
        }
        GlobalInfo.setCurrentInstance(globalInfo);
        String cqId = request.getParameter(CommonQueryConstants.COMMON_QUERY_ID);
        String funCd = TxnPrivilegeMng.checkTxnPrivilege(request, cqId);
        globalInfo.setFuncCode(funCd);
        return globalInfo;
    }

    protected GlobalInfo initGlobalInfo(HttpServletRequest request) throws CommonException {
        return checkGlobalInfo(request);
    }

}

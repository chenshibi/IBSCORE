/**
 *
 */
package com.huateng.ebank.framework.web.commQuery;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.result.databus.CommonQueryDataBusMng;
import com.huateng.commquery.servlet.CommQueryServlet;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;
import com.huateng.exception.DomainException;

/**
 * Title: BankCommQueryServlet Description: Copyright: Copyright (c) 2008
 * Company: Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-1-1
 */
public class BankCommQueryServlet extends CommQueryServlet {
    private static final Logger log = Logger.getLogger(BankCommQueryInterfaceServlet.class);
    /** memeber variable: long serialVersionUID. */
    private static final long serialVersionUID = -7223047626902349647L;

    /**
     * pre process
     * 
     * @param request
     * @param response
     * @throws DomainException
     */
    @Override
    protected Object preProcess(HttpServletRequest request, HttpServletResponse response) throws DomainException {
        init(request);
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
    @Override
    public void init() throws ServletException {
        try {
            String str1 = getServletContext().getRealPath("/");
            com.huateng.common.Constants.rootPath = str1;
            String str2 = getInitParameter("CommonQueryConfigLocation");
            String[] arrayOfString = str2.split(",");
            CommonQueryUtil.init(arrayOfString, getServletContext());
            CommonQueryDataBusMng.init("1");
        } catch (AppException localAppException) {
            log.error("System boot with fault, error message is '" + localAppException.getMessage(), localAppException);
            System.err.println("System boot with fault, error message is '" + localAppException.getMessage());
        }
    }

    protected GlobalInfo checkGlobalInfo(HttpServletRequest request) throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getFromRequest(request);
        if (null == globalInfo) {
            ExceptionUtil.throwCommonException("用户没有登录.", ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID);
        }
        GlobalInfo.setCurrentInstance(globalInfo);
        return globalInfo;
    }

    protected GlobalInfo initGlobalInfo(HttpServletRequest request) throws CommonException {
        return checkGlobalInfo(request);
    }
}

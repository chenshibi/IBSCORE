/*
 * Created on 2005-4-2
 * $Id: BaseAction.java,v 1.15 2005/07/12 08:07:21 liuwen Exp $
 * 
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 */
package com.huateng.ebank.framework.web.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.databus.CommonQueryDataBusMng;
import com.huateng.commquery.result.databus.DataBus;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.ErrorCodeUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.session.SessionManager;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.exception.AppException;

/**
 * @author liu_wen@huateng.com
 * @version $Revision: 1.15 $
 * 
 *          Base class for action used in the application.
 */
public class BaseServlet extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = -9161443487755309580L;
    private static Logger log = Logger.getLogger(BaseServlet.class);

    /**
     * 清除session中不必要的信息.
     * 
     * @param session
     *            将要被清除信息的session.
     * @param attribute
     *            本次操作中不能被清除的信息的key.
     */
    protected void refineSession(HttpSession session, String attribute) {
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
        return globalInfo;
    }

    // 登陆时初始化 GlobalInfo
    protected GlobalInfo initGlobalInfo(HttpServletRequest request) throws CommonException {

        return checkGlobalInfo(request);
    }

    /**
     * Session data manage For session data
     */
    /**
     * Retrieve a session object based on the request and the attribute name.
     */
    protected Object getSessionObject(HttpServletRequest req, String attrName) {
        return SessionManager.getInstance().getSessionObject(req, attrName);
    }

    /**
     * Set a session object based on the request and the attribute name.
     */
    protected boolean setSessionObject(HttpServletRequest req, String attrName, Object value) {
        return SessionManager.getInstance().setSessionObject(req, attrName, value);
    }

    /**
     * Remove a session object based on the request and the attribute name.
     */
    protected boolean removeSessionObject(HttpServletRequest req, String attrName) {
        return SessionManager.getInstance().removeSessionObject(req, attrName);
    }

    /**
     * Session manage For session
     */
    public HttpSession getNewSession(HttpServletRequest req) {
        return SessionManager.getInstance().getNewSession(req);
    }

    protected HttpSession getSession(HttpServletRequest req) {
        return SessionManager.getInstance().getSession(req);
    }

    protected String getSessionID(HttpServletRequest req) {
        return SessionManager.getInstance().getSessionID(req);
    }

    protected boolean isExpired(HttpServletRequest req) {
        return SessionManager.getInstance().isExpired(req);
    }

    protected boolean destroySessionData(HttpServletRequest req) {
        return SessionManager.getInstance().destroySessionData(req);
    }

    protected boolean destroySession(HttpServletRequest req) {
        return SessionManager.getInstance().destroySession(req);
    }

    // 从databus中获得相关的值
    public void setValue2DataBus(HttpServletRequest request, String databusId, String fieldId, String fieldValue)
            throws AppException {
        try {
            if (fieldValue == null)
                fieldValue = "";
            HttpSession session = null;
            session = request.getSession();
            DataBus dataBus = CommonQueryDataBusMng.getDataBus(session.getId(), databusId, session);
            dataBus.setField(fieldId, fieldValue);
        } catch (AppException appEx) {
            throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
                    ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
        }
    }

    // 把相关的值放到databus中
    public String getValueFromDataBus(HttpServletRequest request, String databusId, String fieldId)
            throws AppException {
        try {
            HttpSession session = null;
            session = request.getSession();
            DataBus dataBus = CommonQueryDataBusMng.getDataBus(session.getId(), databusId, session);
            return dataBus.getFieldValue(fieldId);
        } catch (AppException appEx) {
            throw new AppException(appEx.getModuleName(), appEx.getErrCd(),
                    ErrorCodeUtil.convertErrorMessage(log, appEx), appEx);
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex);
        }
    }

}

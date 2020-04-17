/*
 * $Header: /home/plis/batch/cvs/cvsdvp/BocomplJAR/JavaSource/com/huateng/ebank/framework/session/SessionManager.java,v 1.12 2005/05/12 02:51:29 wu_zhiqiang Exp $
 * $Revision: 1.12 $
 * $Date: 2005/05/12 02:51:29 $
 *
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2003-2004 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.session;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.SystemConstant;

/**
 * Session管理类；
 * 
 * @author James wu
 * @version 1.0.0
 */

public class SessionManager {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(SessionManager.class);

    // Property
    private static SessionManager instance = null;

    protected SessionManager() {
    }

    public static SessionManager getInstance() {
        if (logger.isDebugEnabled()) {
            logger.info("getInstance() - start"); //$NON-NLS-1$
        }

        if (null == instance) {
            instance = new SessionManager();
        }

        if (logger.isDebugEnabled()) {
            logger.info("getInstance() - end"); //$NON-NLS-1$
        }
        return instance;
    }

    public HttpSession getNewSession(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getNewSession(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(true);
        long currentTime = System.currentTimeMillis();
        if (true == session.isNew())
            session.setAttribute("sessionCreationTime", String.valueOf(currentTime));
        logger.info("Start sessionLastAccessedTime");
        session.setAttribute("sessionLastAccessedTime", String.valueOf(currentTime));
        logger.info("sessionLastAccessedTime = " + session.getAttribute("sessionLastAccessedTime"));

        // String strBetweenSessionTime =
        // System.getProperty("sessionBetweenSessionTime") ;
        // long timeOut = Long.valueOf(strBetweenSessionTime).longValue() / 1000
        // ;
        // session.setMaxInactiveInterval((int)timeOut) ;

        if (logger.isDebugEnabled()) {
            logger.info("getNewSession(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return session;
    }

    public HttpSession getSession(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSession(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession returnHttpSession = req.getSession(false);
        if (logger.isDebugEnabled()) {
            logger.info("getSession(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnHttpSession;
    }

    public void getSessionAndRefresh(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionAndRefresh(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null != session) {
            long currentTime = System.currentTimeMillis();
            if (true == session.isNew())
                session.setAttribute("sessionCreationTime", String.valueOf(currentTime));
            session.setAttribute("sessionLastAccessedTime", String.valueOf(currentTime));
        }

        if (logger.isDebugEnabled()) {
            logger.info("getSessionAndRefresh(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return;
    }

    public String getSessionID(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionID(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return null;
        String returnString = session.getId();
        if (logger.isDebugEnabled()) {
            logger.info("getSessionID(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnString;
    }

    public String getSessionIDFromContext(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIDFromContext(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return null;
        String returnString = session.getAttribute(SystemConstant.WEB_SESSION_ID).toString();
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIDFromContext(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnString;
    }

    public boolean isValid(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("isValid(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        boolean returnboolean = req.isRequestedSessionIdValid();
        if (logger.isDebugEnabled()) {
            logger.info("isValid(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnboolean;
    }

    public boolean isExpired(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("isExpired(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        // if(true) return false; //TODO: 测试用代码

        // HttpSession session = req.getSession(false);
        // if (null == session)
        // return true;
        //
        // // SESSION ID 是否超期
        // long currentTime = System.currentTimeMillis();
        // String strLastAccessedTime =
        // session.getAttribute("sessionLastAccessedTime").toString();
        // String strBetweenSessionTime =
        // System.getProperty("sessionBetweenSessionTime");
        // long lastAccessedTime =
        // Long.valueOf(strLastAccessedTime).longValue();
        // long betweenSessionTime =
        // Long.valueOf(strBetweenSessionTime).longValue();
        //
        // // System.out.println("strLastAccessedTime=<"+lastAccessedTime+">");
        // // System.out.println("currentTime=<"+currentTime+">");
        // //
        // System.out.println("betweenTime=<"+(currentTime-lastAccessedTime)+">");
        //
        // if (currentTime > (lastAccessedTime + betweenSessionTime))
        // return true;
        //
        // // 校验是否存在SESSION ID数据
        // String sessionID =
        // session.getAttribute(SystemConstant.WEB_SESSION_ID).toString();
        // if (null == sessionID)
        // return true;
        //
        // // 校验是否存在用户用户数据
        // UserSessionInfo userSessionInfo = (UserSessionInfo)
        // getSessionObject(req, LoginManagerOP.OUT_USER_SESSION_INFO);
        // if (null == userSessionInfo)
        // return true;
        //
        // if (logger.isDebugEnabled()) {
        // logger.info("isExpired(HttpServletRequest) - end"); //$NON-NLS-1$
        // }
        // return false;

        return true;

    }

    public boolean destroySessionData(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("destroySessionData(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return false;
        String strAttrName = null;
        Enumeration names = session.getAttributeNames();
        while (names.hasMoreElements()) {
            strAttrName = (String) names.nextElement();
            session.removeAttribute(strAttrName);
        }

        if (logger.isDebugEnabled()) {
            logger.info("destroySessionData(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return true;
    }

    public boolean destroySession(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("destroySession(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return false;
        session.invalidate();

        if (logger.isDebugEnabled()) {
            logger.info("destroySession(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * Session data manage For session data
     */
    /**
     * Retrieve a session object based on the request and the attribute name.
     */
    public Object getSessionObject(HttpServletRequest req, String attrName) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionObject(HttpServletRequest, String) - start"); //$NON-NLS-1$
        }

        Object sessionObj = null;
        HttpSession session = req.getSession(false);
        if (null == session)
            return sessionObj;
        sessionObj = session.getAttribute(attrName);

        if (logger.isDebugEnabled()) {
            logger.info("getSessionObject(HttpServletRequest, String) - end"); //$NON-NLS-1$
        }
        return sessionObj;
    }

    /**
     * Set a session object based on the request and the attribute name.
     */
    public boolean setSessionObject(HttpServletRequest req, String attrName, Object value) {
        if (logger.isDebugEnabled()) {
            logger.info("setSessionObject(HttpServletRequest, String, Object) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return false;
        session.setAttribute(attrName, value);

        if (logger.isDebugEnabled()) {
            logger.info("setSessionObject(HttpServletRequest, String, Object) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * Remove a session object based on the request and the attribute name.
     */
    public boolean removeSessionObject(HttpServletRequest req, String attrName) {
        if (logger.isDebugEnabled()) {
            logger.info("removeSessionObject(HttpServletRequest, String) - start"); //$NON-NLS-1$
        }

        HttpSession session = req.getSession(false);
        if (null == session)
            return false;
        session.removeAttribute(attrName);

        if (logger.isDebugEnabled()) {
            logger.info("removeSessionObject(HttpServletRequest, String) - end"); //$NON-NLS-1$
        }
        return true;
    }

    /**
     * Returns the current session identifier string an HTML hidden field.
     * 
     * @return String - The <I>session id</I> field html.
     */
    public String getSessionIdHtmlField(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIdHtmlField(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        String returnString = "<input type=\"hidden\" name=\"" + SystemConstant.WEB_SESSION_ID + "\" value=\""
                + this.getSessionIDFromContext(req) + "\">";
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIdHtmlField(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnString;
    }

    /**
     * Returns the current session identifier string a URL parameter.
     * 
     * @return String - The <I>session id</I> parameter.
     */
    public String getSessionIdParameter(HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIdParameter(HttpServletRequest) - start"); //$NON-NLS-1$
        }

        String returnString = SystemConstant.WEB_SESSION_ID + "=" + this.getSessionIDFromContext(req);
        if (logger.isDebugEnabled()) {
            logger.info("getSessionIdParameter(HttpServletRequest) - end"); //$NON-NLS-1$
        }
        return returnString;
    }

    /** modify by shen_antonio 20091229 for csrf begin. */
    /**
     * @Title: check AutoCheckCode @Description: TODO @param @param
     *         inputAuthCheckCode @param @param req @param @return @return
     *         boolean @author shen_antonio @date 2009-12-29 下午01:06:14 @throws
     */
    public boolean checkAutoCheckCode(String inputAuthCheckCode, HttpServletRequest req) {
        if (logger.isDebugEnabled()) {
            logger.info("checkAutoCheckCode(HttpServletRequest) - start"); //$NON-NLS-1$
        }
        String authCheckCode = (String) req.getSession().getAttribute("SECTION_CI");
        req.getSession().removeAttribute("SECTION_CI");
        if (StringUtils.isEmpty(authCheckCode)) {
            logger.error("not found session authCheckCode"); //$NON-NLS-1$
            return false;
        } else {
            if (!authCheckCode.equals(inputAuthCheckCode)) {
                logger.error("error authCheckCode, reject request");//$NON-NLS-1$
                return false;
            }
            return true;
        }
    }
    /** modify by shen_antonio 20091229 for csrf end. */

}

package com.huateng.ebank.business.management.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.remote.base.SessionFactory;
import com.huateng.ebank.framework.web.servlet.BaseServlet;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.service.pub.TlrLoginLogService;
import com.huateng.service.pub.UserMgrService;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;

public class LogoutActions extends BaseServlet {

    private static final Logger logger = Logger.getLogger(LogoutActions.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        try {
            GlobalInfo globalInfo = (GlobalInfo) request.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
            if (null != globalInfo) {
                GlobalInfo.setCurrentInstance(globalInfo);
                String sessionId = request.getSession().getId();
                globalInfo.setSessionId(sessionId);
            }
            if (request.getSession(false) != null) {
                // 记录登录日志
                TlrLoginLogService tlrLoginLogService = TlrLoginLogService.getInstance();
                tlrLoginLogService.saveTlrLoginLog("logout", false, "退出系统");
                /* 不是重新登陆才记录退出信息 */
                // if (StringUtils.isBlank(request.getParameter("relogin")))
                UserMgrService.getInstance().setLoginOutInfo(GlobalInfo.getCurrentInstance().getTlrno());
                // 删除系统记录的session
                SessionFactory.getInstance().removeSession(request.getSession(false).getId());
            }
            destroySession(request);
            SysParams logout = SysParamsService.getInstance().selectById(new SysParamsPK("SSO_LOGOUT", "URL"));
            if (logout == null || logout.getParamVal() == null || logout.getParamVal().trim().length() == 0) {
                resp.sendRedirect(request.getContextPath() + "/login_sso.jsp");
            } else {
                resp.sendRedirect(logout.getParamVal().trim());
            }

            // actionForward = mapping.findForward("success");

        } catch (Exception e) {
            logger.info(e.getMessage());
            SysParams logout = SysParamsService.getInstance().selectById(new SysParamsPK("SSO_LOGOUT", "URL"));
            resp.sendRedirect(request.getContextPath() + "/login_sso.jsp");

        }
    }
}
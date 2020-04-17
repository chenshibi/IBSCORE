/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.huateng.common.err.Module;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.exception.AppException;

public class UrlAuthorizationFilter implements Filter {

    public void init(FilterConfig config) {

    }

    public void destroy() {

    }

    @Autowired
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI();
        // if (isUrlEnter == null) {
        // RequestDispatcher dispatcher =
        // req.getRequestDispatcher("/login/login.jsp");
        // dispatcher.forward(req, res);
        // return;
        // } else {
        if (!StringUtils.endsWithIgnoreCase(url, ".js") && !StringUtils.endsWithIgnoreCase(url, ".css")
                && !StringUtils.endsWithIgnoreCase(url, ".dwr") && !StringUtils.endsWithIgnoreCase(url, "/")
                && !StringUtils.endsWithIgnoreCase(url, ".png") && !StringUtils.endsWithIgnoreCase(url, ".gif")
                && !StringUtils.endsWithIgnoreCase(url, "memoryPck.jsp")) {
            GlobalInfo globalInfo = (GlobalInfo) req.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);

            HttpSession httpSession = ((HttpServletRequest) request).getSession();
            if (httpSession == null) {
                try {
                    throw new AppException(Module.SYSTEM_MODULE, ErrorCode.ERROR_CODE_TLRNO_SESSION_INVALID, null,
                            null);
                } catch (AppException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (globalInfo != null) {
                // ROLE_FUNC_REL
                // Map<String, String> pageFunctionMap =
                // globalInfo.getPageFunctionMap();
                Map<String, String> pageFunctionMap = globalInfo.getButtonMap();
                // FUNCTIONINFO
                Map<String, String> pageFuncMap = globalInfo.getPageFuncMap();
                String contextPath = req.getContextPath();
                String[] authPath = url.split(contextPath);
                if (authPath.length >= 2) {
                    String realPath = authPath[1];
                    String pageFuncMapId = pageFuncMap.get(realPath);
                    String pageFunctionMapId = pageFunctionMap.get(realPath);
                    if (pageFuncMapId == null) {
                        filterChain.doFilter(request, response);
                        return;
                    } else {
                        if (pageFunctionMapId == null) {
                            // 没有访问权限的处理
                            RequestDispatcher dispatcher = req.getRequestDispatcher("/common/errorAuthority.jsp");
                            dispatcher.forward(req, res);
                            return;
                        } else {
                            filterChain.doFilter(request, response);
                            return;
                        }
                    }
                }

            }
        }

        // }

        // 传递Filter链
        filterChain.doFilter(request, response);
        return;

    }

}

package com.huateng.ebank.framework.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;

public class StrutsSecurityFilter implements Filter {
    private static final String regex = "(.*\\.|^|.*|\\[('|\"))class(\\.|('|\")]|\\[).*";
    private static final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    private static Logger log = Logger.getLogger(StrutsSecurityFilter.class.getName());

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        Enumeration<String> paramNames = req.getParameterNames();
        boolean inNext = true;
        while (paramNames.hasMoreElements()) {
            String paramNm = paramNames.nextElement();
            Matcher matcher = pattern.matcher(paramNm);
            if (matcher.find()) {
                inNext = false;
                GlobalInfo globalInfo = (GlobalInfo) req.getSession().getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
                if (globalInfo != null) {
                    log.warn("User:" + globalInfo.getTlrno() + ",request Ip:" + getRequestIP(req) + ",request URI:"
                            + req.getRequestURI() + ", paramName:" + paramNm);
                } else {
                    log.warn("request Ip:" + getRequestIP(req) + ",request URI:" + req.getRequestURI() + ", paramName:"
                            + paramNm);
                }
                break;
            }
        }
        if (inNext) {
            filterChain.doFilter(request, response);
        } else {
            HttpServletResponse rsp = (HttpServletResponse) response;
            rsp.sendError(500);
            return;
        }
    }

    private String getRequestIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
    }

}

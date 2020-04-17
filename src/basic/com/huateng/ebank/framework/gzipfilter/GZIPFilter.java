package com.huateng.ebank.framework.gzipfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hades
 * @version 2.1.1
 * @date 2013-5-21
 *
 */

public class GZIPFilter implements Filter {
    private String encoding = "UTF-8";

    public String getEncoding() {
        return encoding;
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        if (req instanceof HttpServletRequest) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            String ae = request.getHeader("accept-encoding");
            if (ae != null && ae.indexOf("gzip") != -1) {
                GZIPResponseWrapper wrappedResponse = new GZIPResponseWrapper(response);
                wrappedResponse.encoding = this.getEncoding();
                chain.doFilter(req, wrappedResponse);
                wrappedResponse.finishResponse();
                return;
            }
            chain.doFilter(req, res);
        }
    }

    public void init(FilterConfig filterConfig) {
        if (filterConfig.getInitParameter("encoding") != null
                && filterConfig.getInitParameter("encoding").trim().length() > 0) {
            this.encoding = filterConfig.getInitParameter("encoding");
        }

    }

    public void destroy() {
        // noop
    }
}

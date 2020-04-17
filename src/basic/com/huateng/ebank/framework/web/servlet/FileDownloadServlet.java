package com.huateng.ebank.framework.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class FileDownloadServlet extends BaseServlet {
    private static final Logger log = Logger.getLogger(FileDownloadServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            this.init(req);
        } catch (CommonException e) {
            e.printStackTrace();
            throw new ServletException("Please login again.");
        }
        String uriStr = StringUtils.substringAfterLast(req.getRequestURI(), "/");
        uriStr = StringUtils.substringBefore(uriStr, ".do");
        log.debug("req.getRequestURI() = " + req.getRequestURI() + ", uriStr = " + uriStr);
        if (uriStr != null && uriStr.trim().length() > 0) {
            IFileDownload dl = (IFileDownload) ApplicationContextUtils.getBean("download." + uriStr);
            if (dl != null) {
                dl.download(req, resp);
            }
        } else {
       //     resp.sendRedirect(req.getContextPath() + "/common/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}

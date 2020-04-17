package com.huateng.report.pboc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.pboc.operation.ServletUntils;
import com.huateng.report.pboc.service.PbocCorpQueryService;

/**
 * @author Grassy
 * @date 2019/1/15 10:15
 * @jdk.version 1.8
 * @desc 二代企业征信报告(已脱敏)
 */
public class CorpReportServlet extends HttpServlet {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CorpReportServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.error("don't support get method!");
        throw new ServletException("Security Issue detected!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (httpSession == null) {
            throw new ServletException("Security Issue detected!");
        }
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        if (null != globalInfo) {
            GlobalInfo.setCurrentInstance(globalInfo);
            String sessionId = httpSession.getId();
            globalInfo.setSessionId(sessionId);
        } else {
            throw new ServletException("User not login!");
        }
        String uuid = request.getParameter("uuid");
        logger.info("uuid = " + uuid);
        Map<String, Object> map = PbocCorpQueryService.getInstance().getCorpReport(uuid);
        Map<String, Object> map2= ServletUntils.getCorpMap1(map) ;    
        request.setAttribute("map", map2);
 //       PrintWriter out = response.getWriter();
 //       String contextPath = request.getContextPath();
   //     out.println("<script language='javascript'>window.location.href='/IBSCORE/fpages/crms/ftl/CorpReportOfBasic.ftl';</script>");
        request.setAttribute("uuid", uuid);
    //     response.sendRedirect(request.getContextPath()+"/fpages/crms/ftl/CorpReportOfBasic.ftl?uuid="+uuid);
        request.getRequestDispatcher("/fpages/crms/ftl/CorpReportOfBasic.ftl").forward(request, response);
    }
}

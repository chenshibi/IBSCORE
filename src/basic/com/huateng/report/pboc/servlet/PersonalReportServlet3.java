package com.huateng.report.pboc.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.pboc.service.PbocQueryService;

/**
 * 
 * @author Grassy
 *	@editor quxin 20190620
 *	@version 个人信息核验
 */
public class PersonalReportServlet3 extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PersonalReportServlet.class);

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
        Map<String, Object> map = PbocQueryService.getInstance().getPersonalReport(uuid);
            
        request.setAttribute("map", map);       
        request.setAttribute("uuid", uuid);
        request.getRequestDispatcher("/fpages/crms/ftl/PersonalReport3.ftl").forward(request, response);
    }
}

package com.huateng.report.pboc.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.common.PbocConstants;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SqlConstantUtils;
import com.huateng.report.utils.WriteDbToExcelUtil;

/**
 * Servlet implementation class PersonalDataExtractionServlet
 */
public class PersonalDataExtractionServlet extends HttpServlet {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DataExtractionServlet.class);
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalDataExtractionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession httpSession = request.getSession();
	        if (httpSession == null) {
	            throw new ServletException("Security Issue detected!");
	        }
	        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
	        String flag=request.getParameter("flag");
	        if (null != globalInfo) {
	            GlobalInfo.setCurrentInstance(globalInfo);
	            String sessionId = httpSession.getId();
	            globalInfo.setSessionId(sessionId);
	        } else {
	            throw new ServletException("User not login!");
	        }
	        String user = ReportUtils.getSysParamsValue("ORACLE", "USER");
            String pwd=ReportUtils.getSysParamsValue("ORACLE", "PWD");
            Connection oracleConnection =null;
	        try {
	        	 oracleConnection=ReportUtils.getOracleConnection(user,pwd);
	        	 logger.info("==========="+oracleConnection+"连接成功");
	        	 String startDate = request.getParameter("startDate");
	             String endDate = request.getParameter("endDate");
	    		 StringBuffer sb=new StringBuffer();
	    	    if(PbocConstants.SYS_HIST_FLAG.equals(flag)){
	    			 sb.append(" AND to_char(tm,'yyyy-mm-dd HH24:MI:SS')>=to_char")
	    	            .append("(to_date('").append(startDate).append(" 00:00:00','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')")
	    	            .append(" AND to_char(tm,'yyyy-mm-dd HH24:MI:SS')<=to_char(to_date('").append(endDate)
	    	            .append(" 23:59:59','yyyy-mm-dd HH24:MI:SS'),'yyyy-mm-dd HH24:MI:SS')").append(" ORDER BY tm DESC");
	    		 }else {
	    			 sb.append("select B.resp_Id from  Cust_Pboc_Per_Query B ")
	    			 .append("  where B.query_Date BETWEEN ").append("'").append(startDate).append("'")
	    			 .append("  and '").append(endDate).append("' ");
	    		 }
	    		 String inSql=sb.toString();
	    		 String tableName = WriteDbToExcelUtil.getPerGen2TableName(flag);
	    		 String gen2Sql = WriteDbToExcelUtil.getPerGen2Sql(inSql, tableName);
	    		 String perGen2Sql = SqlConstantUtils.getPerGen2Sql(inSql, tableName);
	    		 int queryCount = ReportUtils.queryCount(oracleConnection,perGen2Sql);
	    		 WriteDbToExcelUtil.createExcelToWeb(oracleConnection, response, gen2Sql, tableName,queryCount);
			} catch (Exception e) {
				e.printStackTrace();
			}

	    }
	}

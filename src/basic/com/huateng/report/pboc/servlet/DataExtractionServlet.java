package com.huateng.report.pboc.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.report.pboc.service.DataExtractionService;
import com.huateng.report.utils.ReportUtils;
import com.huateng.report.utils.SqlConstantUtils;
import com.huateng.report.utils.WriteDbToExcelUtil;



public class DataExtractionServlet extends HttpServlet{
	 private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DataExtractionServlet.class);

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
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
	        try {
	        	 oracleConnection=ReportUtils.getOracleConnection(user,pwd);
	        	 logger.info("==========="+oracleConnection+"连接成功");
	        	 StringBuffer sb=new StringBuffer();
	        	 sb.append("select C.ID  from  CrComEaa C left join CustPbocEntQuery B on B.respId=C.ID where 1=1 ")
	        	 .append(" and substr(B.respTime,1,8)  BETWEEN ").append("'").append(startDate).append("'")
	        	 .append(" and '").append(endDate).append("' ");
	    		/* sb.append("select B.resp_Id from  Cust_Pboc_Ent_Query B ")
	    	     .append(" where substr(B.resp_Time,1,8)  BETWEEN ").append("'").append(startDate).append("'")
	    		 .append(" and '").append(endDate).append("' ");*/
	    		 DataExtractionService service = DataExtractionService.getInstance();
	    		 service.excelCrComEaaExport(response, sb.toString());
	    		 String inSql=sb.toString();
	    		 String tableName = WriteDbToExcelUtil.getCorpTableMap(flag);
	    		 String gen2Sql = WriteDbToExcelUtil.getGen2Sql(inSql, tableName);
	    		 String gen2CorpSql = SqlConstantUtils.getGen2CorpSql(inSql, tableName);
	    		 int queryNum = ReportUtils.queryCount(oracleConnection,gen2CorpSql);
	    		 WriteDbToExcelUtil.createExcelToWeb(oracleConnection, response, gen2Sql, tableName,queryNum);
			} catch (Exception e) {
				e.printStackTrace();
			}

	    }
	}

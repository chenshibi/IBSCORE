/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.htaml.reportForm.util;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.orm.hibernate3.SessionFactoryUtils;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.report.utils.HuaTengUtils;


/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-8-5
 *
 * 下载文件的Action.
 */
public class DownloadReportFormAction extends BaseAction {
	private static final Log log = LogFactory.getLog(DownloadReportFormAction.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
    	java.sql.PreparedStatement statement = null;
		java.sql.ResultSet rs = null;
		try {
			this.init(request);
			String pageFlag = request.getParameter("page");
			String reportDate = request.getParameter("reportDate");
			log.info(pageFlag);
			log.info(reportDate);
			String fileToBeRead=null;
			String filename=null;
			String sql_download=null;
			conn = SessionFactoryUtils.getDataSource(ROOTDAOUtils.getROOTDAO().getSessionFactory()).getConnection();
			
			if(ReportFormUtils.PAGE_06.equals(pageFlag)){
				log.info("===========monthly_ind_bureau_inquiry_record_=============");
			    sql_download="select PARAM_VAL from SYS_PARAMS where PARAMGROUP_ID='PER_DIALY' and PARAM_ID='DIA_REPORT'";
		      	statement = conn.prepareStatement(sql_download);
		      	rs = statement.executeQuery();
		 		if(rs.next()) {
		 		log.info("Login_addr"+rs.getString("PARAM_VAL"));
		 		filename="monthly_ind_bureau_inquiry_record_"+reportDate+".xls";
		 		filename=HuaTengUtils.toStringAndTrim(filename);
		 		fileToBeRead=transfer_toString(rs.getString("PARAM_VAL"))+filename;
		 	}
		 		log.info(pageFlag);
		 		File file=new File(fileToBeRead);
		 		if(!file.exists()){
					//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/PersonalReportFormdownload.ftl';</script>");
					return null;
			     }
			}
		 	if(ReportFormUtils.PAGE_07.equals(pageFlag)) {
		 		log.info("=============monthly_corp_bureau_inquiry_record_============");
		 		//log.info("execute");
			    sql_download="select PARAM_VAL from SYS_PARAMS where PARAMGROUP_ID='COMP_DIALY' and PARAM_ID='COMP_REP'";
		      	statement = conn.prepareStatement(sql_download);
		      	rs = statement.executeQuery();
		 		if(rs.next()) {
		 		log.info("Login_addr"+rs.getString("PARAM_VAL"));
		 		filename="monthly_corp_bureau_inquiry_record_"+reportDate+".xls";
		 		filename=HuaTengUtils.toStringAndTrim(filename);
		 		fileToBeRead=transfer_toString(rs.getString("PARAM_VAL"))+filename;
		 		}	
		 		log.info(pageFlag);
		 		File file=new File(fileToBeRead);
		 		if(!file.exists()){
						//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/CompanyReportFormdownload.ftl';</script>");
						return null;
				}
		 	}
		 	if(ReportFormUtils.PAGE_18.equals(pageFlag)){
		 		log.info("==============monthly_nature_bureau_inquiry_record_=================");
			    sql_download="select PARAM_VAL from SYS_PARAMS where PARAMGROUP_ID='PER_DIALY' and PARAM_ID='NA_REPORT'";
		      	statement = conn.prepareStatement(sql_download);
		      	rs = statement.executeQuery();
		 		if(rs.next()) {
		 		log.info("Login_addr"+rs.getString("PARAM_VAL"));
		 		filename="monthly_nature_bureau_inquiry_record_"+reportDate+".xls";
		 		filename=HuaTengUtils.toStringAndTrim(filename);
		 		fileToBeRead=transfer_toString(rs.getString("PARAM_VAL"))+filename;
		 	}
		 		log.info(pageFlag);
		 		File file=new File(fileToBeRead);
		 		if(!file.exists()){
					//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/PersonalReportFormdownload.ftl';</script>");
					return null;
			     }

		 		log.info(fileToBeRead);
				setResponse(request,response,filename);
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(fileToBeRead));
				workbook.write(response.getOutputStream());
				response.getOutputStream().flush();
				response.getOutputStream().close();
				workbook.close();
				log.info("monthly_nature_bureau_inquiry_record_====success");
			return null;
			}
			
		 		log.info(fileToBeRead);
				setResponse(request,response,filename);
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
				workbook.write(response.getOutputStream());
				response.getOutputStream().flush();
				response.getOutputStream().close();
				workbook.close();
				log.info("success");
			return null;
		}catch (Exception e) {
			//if(!e.equals("java.net.SocketException")) {
			String errMsg = ActionExceptionHandler.convertErrorMessage(e);
			request.setAttribute("errormsg", errMsg);
			log.error("下载异常：" + e.getMessage());
			return mapping.findForward("error");
			//}
			//return null;
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}
	}

	private void setResponse( HttpServletRequest request,HttpServletResponse response, String fileName) {
		// TODO Auto-generated method stub
		try {
			response.reset();
			String finalFileName;
			 String userAgent = request.getHeader("USER-AGENT");  
			if(StringUtils.contains(userAgent, "MSIE")){//IE浏览器  
	             finalFileName = URLEncoder.encode(fileName,"UTF8");  
	         }else if(StringUtils.contains(userAgent, "Mozilla")){//google,火狐浏览器  
	             finalFileName = new String(fileName.getBytes(), "ISO8859-1");  
	         }else{  
	             finalFileName = URLEncoder.encode(fileName,"UTF8");//其他浏览器  
	         }  
			String contentType = "application/octet-stream;charset=utf-8";
		//	String headerValue = "attachment;   filename=" + fileName;
			response.setContentType(contentType);
			response.setHeader("Content-Disposition", "attachment;filename="  
			        + finalFileName);
			//response.setHeader("Content-Disposition", headerValue);
		} catch (Exception e) {
			log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	  private String transfer_toString(Object str_son) {
	    	if(null==str_son)
	    		return "NULL".toString();
	    	return str_son.toString();
	    }
}
	
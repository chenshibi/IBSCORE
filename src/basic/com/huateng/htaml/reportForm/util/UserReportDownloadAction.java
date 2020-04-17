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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import com.huateng.htaml.reportForm.util.ActionExceptionHandler;
import com.huateng.htaml.reportForm.util.ReportFormUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ReportUtils;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.ebank.framework.web.struts.BaseAction;


/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-8-5
 *
 * 下载文件的Action.
 */
public class UserReportDownloadAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(UserReportDownloadAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String reportdate = request.getParameter("reportDate");
			Date date=DateUtil.stringToDate2(reportdate);
			String reportDate=DateUtil.dateToString(date);
			String path=ReportUtils.getSysParamsValue("UserReport", "User");
			String fileName="User_Report_"+reportDate+".xls";
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(path+"\\"+fileName);
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/UserReportRoleMatrixDownload.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file,fileName);
			}
		} catch (Exception e) {
			
			logger.error("下载异常：" + e.getMessage());
			request.setAttribute("errorMsg", "下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}
	
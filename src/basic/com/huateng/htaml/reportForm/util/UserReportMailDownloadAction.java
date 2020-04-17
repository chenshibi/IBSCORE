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
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.ebank.framework.web.struts.BaseAction;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ReportUtils;


/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-8-5
 *
 * 下载文件的Action.
 */
public class UserReportMailDownloadAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(UserReportMailDownloadAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String reportdate = request.getParameter("reportDate");
			Date date=DateUtil.stringToDate2(reportdate);
			String reportDate=DateUtil.dateToString(date).replaceAll("-", "");
			String path=ReportUtils.getSysParamsValue("Doubtful", "xls");
			String fileName=path+reportDate+"/"+"zip"+"/"+reportDate+".zip";
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(fileName);
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/UserReportRoleMatrixDownload.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file,fileName);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}
	
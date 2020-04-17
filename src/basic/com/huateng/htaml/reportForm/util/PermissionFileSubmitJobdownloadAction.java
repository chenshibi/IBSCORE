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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
public class PermissionFileSubmitJobdownloadAction extends BaseAction {
	private static final Logger logger = Logger.getLogger(PermissionFileSubmitJobdownloadAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String reportDate = request.getParameter("reportDate");
			String path=ReportUtils.getSysParamsValue("BATCH_APP", "LOAD_PATH");
			String fileName=reportDate+".xls";
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(path+"\\"+fileName);
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/PermissionFileSubmitJobdownload.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file,"monthly_permit_record_"+fileName);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg",ChineseUtils.DEXCEL_EXCEPTION+ e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}
	
package com.huateng.ebank.business.customer.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.report.utils.HuaTengUtils;

public class DownloadNonWorkFileAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadNonWorkFileAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String nonWorkhourFilepath = request.getParameter("nonWorkhourFilepath");
			nonWorkhourFilepath=HuaTengUtils.toStringAndTrim(nonWorkhourFilepath);
			File file=new File(nonWorkhourFilepath);
				WebDownloadFile.downloadFile(response, file, file.getName());
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

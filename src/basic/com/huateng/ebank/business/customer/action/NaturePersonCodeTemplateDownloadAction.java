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
import com.huateng.report.utils.ReportUtils;

public class NaturePersonCodeTemplateDownloadAction extends Action{
	private static final Logger logger = Logger.getLogger(NaturePersonCodeTemplateDownloadAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String path=ReportUtils.getSysParamsValue("TEMPLATE", "LOAN_TEMPL");
			String fileName="批量自然人中证码上传template.xlsx";
			File file=new File(path+"\\"+fileName);
			if(!file.exists()){
				response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/BatchNaturePersonCodeQuery.jsp';</script>");
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

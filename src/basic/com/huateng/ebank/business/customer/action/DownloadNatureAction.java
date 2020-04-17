package com.huateng.ebank.business.customer.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.report.utils.HuaTengUtils;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;

public class DownloadNatureAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadNatureAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String individualId=request.getParameter("individualId");
			String queryTime=request.getParameter("queryTime");
			String rptKey=request.getParameter("rptKey");
			SysParams params = new SysParams();
			params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
					"CORPDETAIL", "FILEPATH"));
			String filePath=params.getParamVal();
			StringBuffer date= new StringBuffer(queryTime);
			date.insert(4, "-").insert(7, "-");
			String datePath=filePath+date+"/Natural/"+rptKey;
			String fileName=individualId+"megHtml.html";
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			 File file=new File(datePath+"/"+fileName);
			logger.info(file.getName());
				WebDownloadFile.downloadFile(response, file, file.getName());
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

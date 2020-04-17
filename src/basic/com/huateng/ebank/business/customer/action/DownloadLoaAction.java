package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import resource.bean.basic.IndApp;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.form.UpfileForm;
import com.huateng.ebank.business.customer.operation.IndAppUploadOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;

public class DownloadLoaAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadLoaAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String consentFilePath="";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String id=request.getParameter("Id");
			if(null==id||"".equals(id)){
				consentFilePath="";
			}
			else{
			StringBuffer hql = new StringBuffer("select consentFilePath from CorpCust where id='"+id+"'");
			consentFilePath=(String) rootdao.queryByCondition(hql.toString()).get(0);
			}
			 File file=new File(consentFilePath);
			System.out.println(file.getName());
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/CompanyReport.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, file.getName());
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

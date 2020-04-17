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

public class DownloadFileAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadFileAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			System.out.println("ActionForward");
			String id=request.getParameter("id");
			StringBuffer hql = new StringBuffer("select filePath from FileSubmit po where id='"+id+"'");
			String filePath=(String) rootdao.queryByCondition(hql.toString()).get(0);
				if(null==filePath){
					filePath="";
				}
			File file=new File(filePath);
			System.out.println(file.getName());
			WebDownloadFile.downloadFile(response, file, file.getName());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

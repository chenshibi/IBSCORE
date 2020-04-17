package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.util.List;

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
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.report.utils.ReportUtils;

public class BatchDownLoadTlrUpdateInfoAction extends Action{
	private static final Logger logger = Logger.getLogger(BatchDownLoadTlrUpdateInfoAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String path=ReportUtils.getSysParamsValue("TEMPLATE", "TLR_TEMPLA");
			String fileName="用户批量信息更新上传template.xlsx";
			File file=new File(path+"\\"+fileName);
			if(!file.exists()){
				response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/batchTlrUpdateInfoImport.jsp';</script>");
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

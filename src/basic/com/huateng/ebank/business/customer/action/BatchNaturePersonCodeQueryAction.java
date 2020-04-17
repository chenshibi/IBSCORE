package com.huateng.ebank.business.customer.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.huateng.ebank.business.customer.form.UploadfileForm;
import com.huateng.ebank.business.customer.operation.BatchNaturePersonCodeQueryOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.utils.ChineseUtils;

/**
 * Excel导入
 *
 * @author dhb
 *
 */
public class BatchNaturePersonCodeQueryAction extends Action {
	private static final Logger logger = Logger.getLogger(BatchNaturePersonCodeQueryAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			System.out.println("BatchNaturePersonCodeQuery start!");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			UploadfileForm upform = (UploadfileForm) form;
			//获取excel文件
		//	FormFile excelFile = upform.getFile();
			List<FormFile> files=upform.getFile();
			OperationContext context = new OperationContext();
			// 执行EXCEL解析
			context.setAttribute(BatchNaturePersonCodeQueryOperation.CMD,BatchNaturePersonCodeQueryOperation.CMD_TYPE_FILE);
			context.setAttribute(BatchNaturePersonCodeQueryOperation.IN_ORDER_FORMFILE, files);
			
			OPCaller.call(BatchNaturePersonCodeQueryOperation.ID, context);
			request.setAttribute("flag", context.getAttribute(BatchNaturePersonCodeQueryOperation.FLAG) );
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.EXCEL_EXCEPTION + e.getMessage());
			logger.error("导入Excel异常：" + e.getMessage());
		}
		
		return mapping.findForward("success");
	}
}

package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;

public class MatrixUploadAction extends Action{
	private static final Logger logger = Logger.getLogger(MatrixUploadAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			 DiskFileItemFactory factory = new DiskFileItemFactory();
	         ServletFileUpload upload = new ServletFileUpload(factory);
	         upload.setSizeMax(1024*1024*50);
	         List<FileItem> list = upload.parseRequest(request);
			Map<String, String> fieldMap = new HashMap<String, String>();
			String path=ReportUtils.getSysParamsValue("UserReport", "User");
			
            try {
            	   for(FileItem item : list){
		            	//创建指定路径文件夹
						FileUtils.forceMkdir(new File(path));
						String  upLoadFileName = item.getName();
						String fienNameEnd=upLoadFileName.substring(upLoadFileName.lastIndexOf(".")+1);
						String fileName="Matrix."+fienNameEnd;
						 //获取许可文件全路径
						String fullUpPath =path+"/"+fileName;
						System.out.println(fullUpPath);
						fieldMap.put("filepath",fullUpPath);
						//上传文件
		                File file = new File(fullUpPath);
		                if(file.exists()){
		                	file.delete();
		                }
		                System.out.println("=============="+file);
		                item.write(file);
            	   }  
			} catch (Exception e) {
				ExceptionUtil.throwCommonException("Matrix文件上传失败！");
				request.getRequestDispatcher("/fpages/business/ftl/batchTlrUpdateInfoImport.jsp").forward(request,response);
				e.printStackTrace();
			}
		
		return mapping.findForward("success");
	} catch (Exception e) {
        e.printStackTrace();
        try {
			ExceptionUtil.throwCommonException("解析request失败！");
			 
		} catch (Exception e1) {
			try {
				request.getRequestDispatcher("/fpages/business/ftl/batchTlrUpdateInfoImport.jsp").forward(request,response);
			} catch (ServletException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			e1.printStackTrace();
		}
       
    }
		return null;
}
}
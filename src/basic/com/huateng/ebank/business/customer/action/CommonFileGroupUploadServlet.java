package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.customer.operation.FileGroupUploadOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;

public class CommonFileGroupUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		try {
			GlobalInfo globalInfo = GlobalInfo.getFromRequest(req);
		} catch (CommonException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println("start upload file！");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(1024 * 1024 * 50);
			OperationContext context = new OperationContext();
			List<FileItem> list = upload.parseRequest(req);
			Map<String, String> fieldMap = new HashMap<String, String>();
			String TargetPath = ReportUtils.getSysParamsValue("FILE_PATH",
					"FILE_PATH") + DateUtil.get14Time();

			// 遍历FileItem对象
			for (FileItem item : list) {
				if (item.isFormField()) {
					// 将字段存放在map中
					fieldMap.put(item.getFieldName(), item.getString("utf-8"));
				}
			}
			for (FileItem item : list) {
				if (!(item.isFormField())) {
					// 获取文件名
					String upLoadFileName = item.getName();
					if ("".equals(upLoadFileName)) {
						req.setAttribute("fileName", upLoadFileName);
						ExceptionUtil.throwCommonException("获取文件失败！");
					}
					String fileName;
					if (upLoadFileName.indexOf("\\") > 0) {
						fileName = upLoadFileName.substring(upLoadFileName
										.lastIndexOf("\\") + 1);
						fieldMap.put("fileName", upLoadFileName.substring(upLoadFileName.lastIndexOf("\\") + 1));
					/*	String fileType = (String) fieldMap.get("form_fileType");
						String city=(String) fieldMap.get("form_city");
						if("01".equals(city)) {
							city="25";
						}*/
						//个人
				/*		if("2".equals(fileType)) {
	                       if(!fileName.contains(Constant.PERSON_FILE_TYPE)) {
	                    	   ExceptionUtil.throwCommonException("上传文件失败，文件必须是个人！");
	                       }else if("25".equals(city)) {
	                    	   if(!fileName.contains(Constant.WUHAN)) {
	                    		   ExceptionUtil.throwCommonException("上传文件失败，文件必须是武汉的！");
	                    	   }
	                    	   
	                       }           						
						}
						//对公
						if("1".equals(fileType)) {
		                       if(!fileName.contains(Constant.CORP_FILE_TYPE)) {
		                    	   ExceptionUtil.throwCommonException("上传文件失败，文件必须是对公！");
		                       }else if("25".equals(city)) {
		                    	   if(!fileName.contains(Constant.WUHAN)) {
		                    		   ExceptionUtil.throwCommonException("上传文件失败，文件必须是武汉的！");
		                    	   }
		                    	   
		                       }           						
							}*/
						
					} else {
						fileName =  upLoadFileName;
						fieldMap.put("fileName", upLoadFileName);
					}
					
					try {
						// 创建指定路径文件夹
						FileUtils.forceMkdir(new File(TargetPath));
						// 获取许可文件全路径
						String fullUpPath = TargetPath + "/" + fileName;
						fieldMap.put("filepath", fullUpPath);
						// 上传文件
						System.out.println("uploadfile" + fullUpPath);
						File file = new File(fullUpPath);
						System.out.println("file");
						item.write(file);
						System.out.println(fullUpPath);
					} catch (Exception e) {
						ExceptionUtil.throwCommonException("文件上传失败！");
						System.out.println("upload error");
						req.getRequestDispatcher(
								"/fpages/crms/ftl/CommonFileGroupUpload.ftl")
								.forward(req, resp);
						e.printStackTrace();
					}

				}
			}
			context.setAttribute(FileGroupUploadOperation.FILIED_MAP, fieldMap);
			OPCaller.call(FileGroupUploadOperation.ID, context);
			req.getRequestDispatcher("/fpages/crms/ftl/CommonFileGroupUpload.ftl")
					.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ExceptionUtil.throwCommonException("解析request失败！");

			} catch (CommonException e1) {
				req.getRequestDispatcher(
						"/fpages/crms/ftl/CommonFileGroupUpload.ftl").forward(
						req, resp);
				e1.printStackTrace();
			}

		}
	}

}

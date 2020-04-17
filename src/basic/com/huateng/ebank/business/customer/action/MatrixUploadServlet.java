package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
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
import com.huateng.ebank.business.customer.operation.BatchCorpOperation;
import com.huateng.ebank.business.customer.operation.IndPermitOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;


public class MatrixUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		 resp.setContentType("text/html");
         resp.setCharacterEncoding("utf-8");
		try {
			GlobalInfo globalInfo = GlobalInfo.getFromRequest(req);
		} catch (CommonException e1) {
			e1.printStackTrace();
		}
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1024*1024*50);
            OperationContext context = new OperationContext();
            List<FileItem> list = upload.parseRequest(req);
            Map<String, String> fieldMap = new HashMap<String, String>();
            String TargetPath=ReportUtils.getSysParamsValue("UserReport", "User");
           
            
           
            for(FileItem item : list){
                if(!(item.isFormField())){
                	//获取文件名
                	String  upLoadFileName = item.getName();
                	if("".equals(upLoadFileName)){
                		req.setAttribute("fileName", upLoadFileName);
                		ExceptionUtil.throwCommonException("获取许可证文件失败！");
                	}
                    String fileNameend=upLoadFileName.substring(upLoadFileName.lastIndexOf(".")+1);
                    String fileName="Matrix."+fileNameend;
                    try {
                    	//创建指定路径文件夹
    					FileUtils.forceMkdir(new File(TargetPath));
    					 //获取许可文件全路径
    					String fullUpPath =TargetPath+"/"+fileName;
    					System.out.println(fullUpPath);
    					fieldMap.put("filepath",fullUpPath);
    					//上传文件
    	                File file = new File(fullUpPath);
    	                item.write(file);
    	                
    				} catch (Exception e) {
    					ExceptionUtil.throwCommonException("Matrix文件上传失败！");
    					 req.getRequestDispatcher("/fpages/business/ftl/batchTlrUpdateInfoImport.jsp").forward(req,resp);
    					e.printStackTrace();
    				}
              
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
				ExceptionUtil.throwCommonException("解析request失败！");
				 
			} catch (CommonException e1) {
				req.getRequestDispatcher("/fpages/business/ftl/batchTlrUpdateInfoImport.jsp").forward(req,resp);
				e1.printStackTrace();
			}
           
        }
	}

}

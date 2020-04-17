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
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;


public class nonWorkhourFileUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		 resp.setContentType("text/html");
         resp.setCharacterEncoding("utf-8");
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1024*1024*50);
            OperationContext context = new OperationContext();
            List<FileItem> list = upload.parseRequest(req);
            String TargetPath=ReportUtils.getSysParamsValue("NOWORK_APP","NOWORKPATH")+DateUtil.get8Date(); 
            
            //遍历FileItem对象
            for(FileItem item : list){
                	//获取文件名
                	String  fileName = item.getName();
                    File f = new File(fileName);
                    fileName = f.getName();
                    try {
                    	//创建指定路径文件夹
    					FileUtils.forceMkdir(new File(TargetPath));
    					 //获取许可文件全路径
    					String fullUpPath =TargetPath+"/"+fileName;
    					//上传文件
    	                File file = new File(fullUpPath);
    	                item.write(file);
    	                req.setAttribute("filePath", fullUpPath);
    	                req.getRequestDispatcher("/fpages/business/ftl/nonWorkhourFileUpload.jsp").forward(req,resp);
    	               // req.getRequestDispatcher("nonWorkhourFileUpload.jsp").forward(req, resp);
    				} catch (Exception e) {
    					ExceptionUtil.throwCommonException("许可证文件上传失败！");
    					e.printStackTrace();
    				}
            }
        } catch (Exception e) {
				req.getRequestDispatcher("/fpages/business/ftl/nonWorkhourFileUpload.jsp").forward(req,resp);
				e.printStackTrace();
        }
       
	}

}

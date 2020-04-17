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
import com.huateng.ebank.business.customer.operation.TCorpPermitOperation;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportUtils;


public class TcorpPermitUploadServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		try {
			GlobalInfo globalInfo = GlobalInfo.getFromRequest(req);
		} catch (CommonException e1) {
			e1.printStackTrace();
		}
        try {
        	req.setCharacterEncoding("utf-8");
        	resp.setContentType("text/html;charset=gbk");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1024*1024*50);
            OperationContext context = new OperationContext();
            List<FileItem> list = upload.parseRequest(req);
            Map<String, String> fieldMap = new HashMap<String, String>();
	        String TargetPath=ReportUtils.getSysParamsValue("BATCH_APP","CORP_PATH")+DateUtil.get8Date(); 
	        //遍历FileItem对象
	        for(FileItem item : list){
	        	 if(item.isFormField()){
		            	//将字段存放在map中
		                fieldMap.put(item.getFieldName(), item.getString("utf-8"));
		            }
	        }
	        for(FileItem item : list){
	            if(!(item.isFormField())){
	            	//获取文件名
	            	 String  upLoadFileName = item.getName();
	        		 String fileName=fieldMap.get("form_loanCardNo")+"_"+DateUtil.get14Time()+"."+upLoadFileName.substring(upLoadFileName.lastIndexOf(".")+1);
	                try {
	                	//创建指定路径文件夹
						FileUtils.forceMkdir(new File(TargetPath));
						 //获取许可文件全路径
						String fullUpPath =TargetPath+"/"+fileName;
						fieldMap.put("filepath",fullUpPath);
						//上传文件
		                File file = new File(fullUpPath);
		                item.write(file);
		                
					} catch (Exception e) {
						req.getRequestDispatcher("/fpages/business/ftl/TCorpPermitUpload.ftl").forward(req,resp);
						ExceptionUtil.throwCommonException("主管批复文件上传失败！");
						e.printStackTrace();
					}
	          
	            }
	        }
	       
            
            context.setAttribute(TCorpPermitOperation.FILIED_MAP, fieldMap);
            OPCaller.call(TCorpPermitOperation.ID, context);
            req.getRequestDispatcher("/fpages/business/ftl/TCorpPermitUpload.ftl").forward(req,resp);
        } catch (Exception e) {
        	req.getRequestDispatcher("/fpages/business/ftl/TCorpPermitUpload.ftl").forward(req,resp);
            e.printStackTrace();
            throw new ServletException("解析request失败");
        }
	}

}

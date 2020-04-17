package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class DownloadLogDetailsAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadLogDetailsAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			 String date =request.getParameter("date");
			 String id =request.getParameter("id");
			 String fileName="";
			 
			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            
		    logger.info(fileName);
			SysParams params = new SysParams();
			params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
					"XML", "FILEPATH"));
			String filePath=params.getParamVal();
			String datePath=filePath+date+"/";
			if(id.equals("downLoadind")){
            	fileName=searchFile("W10312900H0012_GRZXCXMX_",datePath);
            }else{
            	fileName=searchFile("W10312900H0012_QYZXCXMX_",datePath);
            }
			 fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(datePath+fileName);
			if(!file.exists()){
				response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/logdownload.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, fileName);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg",ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		return null ;
	}
	
	
	public static String searchFile(String start,String path){
		String loadName=null;
		File file = new File(path);
		if(file.exists()){
			File[] fl=file.listFiles();
			int temp=0000;
			for(int i=0;i<fl.length;i++){
				if(fl[i].isFile()){
					if(fl[i].getName().startsWith(start)&&fl[i].getName().endsWith(".txt")){
						logger.info(fl[i].getName());
						int time=Integer.parseInt(fl[i].getName().replace(start, "").replace(".txt", "").substring(11));
						logger.info(time);
						if(time>temp){
							loadName=fl[i].getName();
						}
						
					}
				}
			}
		}
		return loadName;
	}
	public static int trimChar(String str){
		Pattern pattern = Pattern.compile("[^0-9]");
		
		Matcher m=pattern.matcher(str);
		return Integer.parseInt(m.replaceAll("").trim());
	}
}

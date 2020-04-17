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

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.report.utils.HuaTengUtils;

import resource.bean.basic.IndApp;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.crms.CustPbocPerQuery;

public class DownloadCustPbocPerQueryAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadInqCustAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String respId = request.getParameter("respId");
			String RSV9 = "";
			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			 StringBuffer hql = new StringBuffer("select cppq from CustPbocPerQuery cppq  where cppq.respId ='" + respId +"'");
		     List<CustPbocPerQuery> list = rootdao.queryByCondition(hql.toString());
		     if(list.size()>0){
		    	 RSV9 = list.get(0).getRsv9();
		    	logger.info(RSV9);
		     }
		     int rsv9Length = RSV9.length();
		     String str ="\\";//String str ="\\";取路径字符串中最后一个'\'的索引,  第一个'\'为转义符
		     logger.info("str="+str);
		     System.out.println("str="+str);
		     int beginIndex = RSV9.lastIndexOf(str)+1;//  截取方法修改为lastIndexOf();
		     //int beginIndex = rsv9Length-63;
		     int endIndex = rsv9Length;
		     logger.info("beginIndex="+beginIndex);
		     logger.info("endIndex="+endIndex);
		     System.out.println("beginIndex="+beginIndex);
		     System.out.println("endIndex="+endIndex);
		    String fileName=RSV9.substring(beginIndex, endIndex);
		    logger.info(fileName);
		    System.out.println("fileName="+fileName);
			File file=new File(RSV9);
			System.out.println("file="+file);
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/inqRequest.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, fileName);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION+ e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

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

public class DownloadInqCustAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadInqCustAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String rptId = request.getParameter("rptId");
			 String IndividualId="";
			 String name="";
			 String returnTime="";
			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			 StringBuffer hql = new StringBuffer("select ia from IndApp ia where ia.rptId='"+rptId+"'");
		     List<IndApp> listApp = rootdao.queryByCondition(hql.toString());
		     if(listApp.size()>0){
		    	 rptId=listApp.get(0).getRptId();
		    	 IndividualId=listApp.get(0).getIndividualId();
		    	 name=listApp.get(0).getName();
		    	 returnTime=listApp.get(0).getReturnTime().toString().substring(0,10);
		    	logger.info(returnTime);
		     }
		    String fileName=rptId+"."+IndividualId+"."+name+".html";
		   logger.info(fileName);
			SysParams params = new SysParams();
			params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
					"PERSONAL", "FILEPATH"));
			String filePath=params.getParamVal();
			String path=filePath+returnTime;
			System.out.println(path);
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(path+"\\"+fileName);
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

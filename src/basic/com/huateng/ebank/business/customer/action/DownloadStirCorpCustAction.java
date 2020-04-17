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

import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.TCorpApp;

public class DownloadStirCorpCustAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadStirCorpCustAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String rptId = request.getParameter("rptKey");
			 String returnTime="";
			 String loancarid="";
			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			 StringBuffer hql = new StringBuffer("select ia from TCorpApp ia where ia.rptKey='"+rptId+"'");
		     List<TCorpApp> listApp = rootdao.queryByCondition(hql.toString());
		     if(listApp.size()>0){
		    	 rptId=listApp.get(0).getRptKey();
		    	 loancarid=listApp.get(0).getLoanCardNo();
		    	 if(null != listApp.get(0).getQueryTime()){
		    		 returnTime=String.valueOf(listApp.get(0).getQueryTime()).substring(0,10);
		    	 }
		     }
		    String fileName=loancarid+"Expend.html";
			SysParams params = new SysParams();
			params = (SysParams) rootdao.query(SysParams.class, new SysParamsPK(
					"CORP", "STIRPATH"));
			String filePath=params.getParamVal();
			String path=filePath+returnTime;
			fileName=HuaTengUtils.toStringAndTrim(fileName);
			File file=new File(path+"/"+"Normal"+"/"+rptId+"/"+fileName);
			if(!file.exists()){
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/CompanyReport.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, fileName);
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		return null ;
	}
}

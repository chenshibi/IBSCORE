package com.huateng.ebank.business.customer.action;

import java.io.File;

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

public class DownloadIndPermitAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadIndPermitAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
		    ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String id=request.getParameter("id");
			StringBuffer hql = new StringBuffer("select customerConUp from IndPermit po where id='"+id+"'");
			String consentFilePath=(String) rootdao.queryByCondition(hql.toString()).get(0);
				if(null==consentFilePath){
					consentFilePath="";
				}
			 File file=new File(consentFilePath);
			System.out.println(file.getName());
			//if(!file.exists()){
//				response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/IndPermitQuery.ftl';</script>");
//			}else{
				WebDownloadFile.downloadFile(response, file, file.getName());
//			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

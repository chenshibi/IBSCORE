package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

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

public class DownloadReplyAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadReplyAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String nonWorkhourFilepath="";
			String Id = request.getParameter("Id");
			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			 StringBuffer hql = new StringBuffer("select tca.non_workhour_filepath as nonWorkhourFilepath from corp_cust tca left join t_corp_app cc on tca.corp_cust_appid=cc.id left join t_corp_detail_app tcda   on tcda.id=tca.corp_cust_detail_id where tca.id='"+Id+"'");
			 Iterator it = rootdao.queryBySQL2(hql.toString());
				while(it.hasNext()){
					Map map = (Map)it.next();
					nonWorkhourFilepath=(String) map.get("nonWorkhourFilepath");
				}
				if(null==nonWorkhourFilepath){
					nonWorkhourFilepath="";
				}
			 File file=new File(nonWorkhourFilepath);
			System.out.println(file.getName());
			if(!file.exists()){
				response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/CompanyReport.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, file.getName());
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg",ChineseUtils.DEXCEL_EXCEPTION+ e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

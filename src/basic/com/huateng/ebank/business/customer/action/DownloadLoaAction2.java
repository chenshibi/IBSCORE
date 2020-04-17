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

import resource.bean.basic.TCorpPermit;

public class DownloadLoaAction2 extends Action{
	private static final Logger logger = Logger.getLogger(DownloadLoaAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String customerConUp="";
			List<TCorpPermit> list=null;
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String entCertNum=request.getParameter("entCertNum");
			String entCertType=request.getParameter("entCertType");
			if(null==entCertNum||"".equals(entCertNum)){
				customerConUp="";
			}
			StringBuffer hql = new StringBuffer();
						hql.append("from TCorpPermit where status='1'").append(" and loanCardNo =").append("'").append(entCertNum).append("'");
					    list=rootdao.queryByCondition(hql.toString());
						if(list!=null && list.size()>0) {
							customerConUp=list.get(0).getCustomerConUp() ;
						}
			 File file=new File(customerConUp);
			 logger.info("获取的文件名为======"+file.getName());			 
			if(!file.exists()){
			}else{
				WebDownloadFile.downloadFile(response, file, file.getName());
			}
		} catch (Exception e) {
			logger.error("下载异常：" + e.getMessage());
			request.setAttribute("errorMsg", "下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

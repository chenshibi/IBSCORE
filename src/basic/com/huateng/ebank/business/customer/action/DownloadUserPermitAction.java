package com.huateng.ebank.business.customer.action;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import resource.bean.basic.IndApp;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.form.UpfileForm;
import com.huateng.ebank.business.customer.operation.IndAppUploadOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.util.WebDownloadFile;
import com.huateng.report.utils.ChineseUtils;

public class DownloadUserPermitAction extends Action{
	private static final Logger logger = Logger.getLogger(DownloadUserPermitAction.class);

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			String consentFilePath="";
			ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
			String id=request.getParameter("id");
			if(null==id||"".equals(id)){
				consentFilePath="";
			}
			else{
			StringBuffer hql = new StringBuffer("select consentFilePath from InqCust where id='"+id+"'");
			consentFilePath=(String) rootdao.queryByCondition(hql.toString()).get(0);
			}
//			String consentFilePath = request.getParameter("consentFilePath");
			/*System.out.println(consentFilePath);
			String path="D:\\TFMS\\report\\2017-03-27";
			String fileName="SCB_bglist_2017-03-27.xls";*/
//			String rptId = request.getParameter("rptId");
//			 ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//			 StringBuffer hql = new StringBuffer("select ic.consent_file_path as consentFilePath from ind_app ia left join inq_cust ic on ia.id=ic.inq_cust_appid where ia.Rpt_id='"+rptId+"'");
//			 Iterator it = rootdao.queryBySQL2(hql.toString());
//				while(it.hasNext()){
//					Map map = (Map)it.next();
//					consentFilePath=(String) map.get("consentFilePath");
//				}
			 File file=new File(consentFilePath);
			System.out.println(file.getName());
			if(!file.exists()){
				//System.out.println("文件不存在");
//				response.getWriter().write("<script>alert('The file does not exists!');history.go(-1);window.location='/credit/fpages/reportform/ftl/ActiveInspectionForm.ftl';</script>");
				//response.getWriter().write("<script>alert('The file does not exists!');window.location='/IBSCORE/fpages/business/ftl/inqRequest.ftl';</script>");
				//response.getWriter().write("<script>window.location='/IBSCORE/fpages/business/ftl/inqRequest.ftl';</script>");
			}else{
				WebDownloadFile.downloadFile(response, file, file.getName());
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg",ChineseUtils.DEXCEL_EXCEPTION + e.getMessage());
			logger.error("下载异常：" + e.getMessage());
		}
		
		return null ;
	}
}

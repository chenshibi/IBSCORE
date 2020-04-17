package com.huateng.report.pboc.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.dwr.DwrFunctions;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;

import resource.bean.crms.CustPbocEntQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchQueryRematchCorpUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CrmsBatchQueryCorpReport");
	            while (updateResultBean.hasNext()) {
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")) {
	                    list.add(map);
	                }
	            }
	            DwrFunctions dw=new DwrFunctions();
	            CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            for(int i=0;i<list.size();i++) {
	            	Map<String, String> map = list.get(i);
	            	String loanCardNo=map.get("entCertNum").toString();
	            	String queryReason=map.get("queryReason").toString();
	            	String is = dw.isCompanyExpire(loanCardNo, queryReason);
	            	if(is=="2") {
	            		 String id=(String) map.get("id");
	                     CustPbocEntQuery custPbocEntQuery = dao.findById(id);
	                     custPbocEntQuery.setCertAuthStatus("01");
	                     dao.update(custPbocEntQuery);
	            	}
	            }
	            return updateReturnBean;
	        } catch (AppException appEx) {
	            throw appEx;
	        } catch (Exception ex) {
	            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	        }
}
	}

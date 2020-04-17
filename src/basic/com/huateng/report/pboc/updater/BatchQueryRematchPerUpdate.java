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
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;

import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchQueryRematchPerUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CrmsBatchQueryPersonalReport");
	            while (updateResultBean.hasNext()) {
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")) {
	                    list.add(map);
	                }
	            }
	            DwrFunctions dw=new DwrFunctions();
	            CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            for(int i=0;i<list.size();i++) {
	            	Map<String, String> map = list.get(i);
	            	String idType=map.get("idType").toString();
	            	String name=map.get("name").toString();
	            	String idNum=map.get("idNum").toString();
	            	String queryReason=map.get("queryReason").toString();
	            	String is = dw.isExpire(idType, name,idNum,queryReason);
	            	if(is=="2") {
	            		 String id=(String) map.get("id");
	                     CustPbocPerQuery custPbocPerQuery = dao.findById(id);
	                     custPbocPerQuery.setCertAuthStatus("01");
	                     dao.update(custPbocPerQuery);
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

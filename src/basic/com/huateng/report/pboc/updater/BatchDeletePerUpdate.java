package com.huateng.report.pboc.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;

import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchDeletePerUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<CustPbocPerQuery> list = new ArrayList<CustPbocPerQuery>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CrmsBatchQueryPersonalReport");
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            while (updateResultBean.hasNext()) {
	            	CustPbocPerQuery custPbocPerQuery=new CustPbocPerQuery();
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")) {
	                	mapToObject(custPbocPerQuery, map);
	                    list.add(custPbocPerQuery);
	                }
	            }
	            CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
	            String opr=GlobalInfo.getCurrentInstance().getTlrno().toString();
	            List<String> successList=new ArrayList<String>();
	            List<String> errMsgList=new ArrayList<String>();
	            if(list!=null && list.size()>0 && StringUtils.isNotEmpty(opr)) {
	            	for(int i=0;i<list.size();i++) {
	            		CustPbocPerQuery custPbocPerQuery2 = list.get(i);
	            		 if(opr.equals(custPbocPerQuery2.getCreateUser())) {
	            			 String idNum=custPbocPerQuery2.getIdNum();
	            			 dao.delete(custPbocPerQuery2);
	            			 successList.add(idNum);
	            		 }else {
	            			 String idNum=custPbocPerQuery2.getIdNum();
	            			 errMsgList.add(idNum);
	            		 }
	            	}
	            }else {
	            	    updateReturnBean.setParameter("errMsg", "删除失败");
	            }
	            if(successList!=null && successList.size()>0) {
               	 StringBuffer sb=new StringBuffer();
               	 for(String s:successList) {
                   	    sb.append(s).append("\r\n");
                      }
               	 String msg="个人身份证件号码为"+"\r\n"+sb+"\r\n"+"的个人删除成功";
                    updateReturnBean.setParameter("result",msg );
               }
	            if(errMsgList!=null && errMsgList.size()>0) {
	               	 StringBuffer sb=new StringBuffer();
	               	 for(String s:errMsgList) {
	                   	    sb.append(s).append("\r\n");
	                      }
	               	 String msg="个人身份证件号码为"+"\r\n"+sb+"\r\n"+"的个人删除失败！"+"当前操作者只能删除操作者录入的数据";
	                    updateReturnBean.setParameter("notDel",msg );
	               }
	            return updateReturnBean;
	        } catch (AppException appEx) {
	            throw appEx;
	        } catch (Exception ex) {
	            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	        }
}
	}

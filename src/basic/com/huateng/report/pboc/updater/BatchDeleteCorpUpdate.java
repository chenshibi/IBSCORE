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
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;

import resource.bean.crms.CustPbocEntQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchDeleteCorpUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<CustPbocEntQuery> list = new ArrayList<CustPbocEntQuery>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CrmsBatchQueryCorpReport");
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            while (updateResultBean.hasNext()) {
	            	CustPbocEntQuery custPbocEntQuery=new CustPbocEntQuery();
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")) {
	                	mapToObject(custPbocEntQuery, map);
	                    list.add(custPbocEntQuery);
	                }
	            }
	            CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
	            String opr=GlobalInfo.getCurrentInstance().getTlrno().toString();
	            List<String> successList=new ArrayList<String>();
	            List<String> errMsgList=new ArrayList<String>();
	            if(list!=null && list.size()>0 && StringUtils.isNotEmpty(opr)) {
	            	for(int i=0;i<list.size();i++) {
	            		CustPbocEntQuery custPbocEntQuery2 = list.get(i);
	            		 if(opr.equals(custPbocEntQuery2.getCreateUser())) {
	            			 String entCertNum=custPbocEntQuery2.getEntCertNum();
	            			 dao.delete(custPbocEntQuery2);
	            			 successList.add(entCertNum);
	            		 }else {
	            			 String entCertNum=custPbocEntQuery2.getEntCertNum();
	            			 errMsgList.add(entCertNum);
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
               	 String msg="企业标识号码为"+"\r\n"+sb+"\r\n"+"的企业删除成功";
                    updateReturnBean.setParameter("result",msg );
                  //  return updateReturnBean;
               }
	            if(errMsgList!=null && errMsgList.size()>0) {
	               	 StringBuffer sb=new StringBuffer();
	               	 for(String s:errMsgList) {
	                   	    sb.append(s).append("\r\n");
	                      }
	               	 String msg="企业标识号码为"+"\r\n"+sb+"\r\n"+"的企业删除失败！"+"当前操作者只能删除操作者录入的数据";
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

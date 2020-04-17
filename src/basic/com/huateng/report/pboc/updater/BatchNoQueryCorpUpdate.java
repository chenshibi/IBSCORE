package com.huateng.report.pboc.updater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.operation.QueryCorpOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.PbocD103Service;
import com.huateng.report.utils.JsonUtils;

import resource.bean.crms.CustPbocEntQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchNoQueryCorpUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            String id="";
	            boolean isOk = true;
	            String rptId = "";
	            GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
	            OperationContext context = new OperationContext();
	            PbocD103Service service = PbocD103Service.getInstance();
	            CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
	            List<CustPbocEntQuery> list = dao.searchCorpByAddStatus(currentInstance.getTlrno().toString());
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            List<String> expireList=new ArrayList<String>();
	            List<String> sussessList=new ArrayList<String>();
	            List<String> errList=new ArrayList<String>();
	            List<String> exceptionList=new ArrayList<String>();
	            List<Map<String,String>> queryList=new ArrayList<Map<String,String>>();
	            List<Map<String,String>> reQueryList=new ArrayList<Map<String,String>>();
	            try {
	                for(int i=0;i<list.size();i++){
	                    CustPbocEntQuery custPbocEntQuery = list.get(i);
	                    Map<String,String> map=new HashMap<String,String>();
	                    map.put("tlrno", currentInstance.getTlrno().toString());
	                    map.put("id", custPbocEntQuery.getId());
	                    map.put("entName", custPbocEntQuery.getEntName());
	                    map.put("entCertType", custPbocEntQuery.getEntCertType());
	                    map.put("entCertNum", custPbocEntQuery.getEntCertNum());
	                    map.put("queryReason", custPbocEntQuery.getQueryReason());
	                    map.put("serviceCode", custPbocEntQuery.getServiceCode());
	                    map.put("query_org_code", custPbocEntQuery.getRsv8());
	                    map.put("user_code", custPbocEntQuery.getRsv9());
	                    map.put("queryLevel",custPbocEntQuery.getQueryLevel() );
	                    map.put("status", custPbocEntQuery.getStatus());
	                    List<CustPbocEntQuery> findPbocEntQueryMonthBefore2 = dao.findPbocEntQueryMonthBefore2(custPbocEntQuery.getId(),custPbocEntQuery.getEntCertNum(),custPbocEntQuery.getEntName()); 
	                 /*   if((QueryUntils.Default).equals(custPbocEntQuery.getCertAuthStatus())) {
	                    	authList.add(custPbocEntQuery.getEntCertNum());
	                    }*/
	                    if(findPbocEntQueryMonthBefore2!=null && findPbocEntQueryMonthBefore2.size()>0) {
	                    	 expireList.add(custPbocEntQuery.getEntCertNum()+" "+","+" "+custPbocEntQuery.getEntName());
	                    	 reQueryList.add(map);
	                    }
	                    else {
	                    	 queryList.add(map);
	                    }
	                }
	           /*     if(authList!=null && authList.size()>0) {
	                	 StringBuffer sb=new StringBuffer();
	                	 for(String s:authList) {
	                    	    sb.append(s).append("\r\n");
	                       }
	                	 String msg="企业标识号码为"+"\r\n"+sb+"\r\n"+"的企业没有授予证书权限";
	                     updateReturnBean.setParameter("authErrMsg",msg );
	                }*/
	                
                    if(expireList!=null && expireList.size()>0) {
                       StringBuffer sb=new StringBuffer();
                       for(String s:expireList) {
                    	    sb.append(s).append("\r\n");
                       }
                       String msg="企业标识号码和企业"+"\r\n"+sb+"的企业在一个月之内已经查询过";
                       updateReturnBean.setParameter("errMsg",msg );
                       updateReturnBean.setParameter("list",JsonUtils.toJson(reQueryList));
                    }	
                    if(queryList!=null && queryList.size()>0) {
                    	 for(int i=0;i<queryList.size();i++) {
                    		 Map<String, String> map = queryList.get(i);
                    		 context.setAttribute("CMD", "BatchUpdate");
                			 context.setAttribute("id", map.get("id"));
                    		 OPCaller.call(QueryCorpOperation.class, context);
                             QueryResult queryResult = service.queryEnterprise(map);
	   	                        context.setAttribute("id", (String)map.get("id"));
	   		                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
	   		                        logger.info("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "success");
	   		                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	   	                            context.setAttribute("uuid", rptId);
	   	                            context.setAttribute("CMD", "UPDATE");
	   	                           id=(String)context.getAttribute("id");
	   		                        context.setAttribute("rptId", rptId);
	   		                        context.setAttribute("status", "success");
	   		                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
	   		                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        sussessList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    //    rptIdList.add(rptId);
	   		                    //    updateReturnBean.setParameter("uuid", rptIdList.toString());
	   		                    } else {
	   	                            context.setAttribute("CMD", "UPDATE");
	   	                            id=(String)context.getAttribute("id");
	   		                        isOk = false;
	   		                        logger.error("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "failed");
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        errList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    //    ExceptionUtil.throwCommonException("企业查询失败");
	   		                    }
                    	 }
                    	
                    }
                    
                    if(sussessList!=null && sussessList.size()>0) {
                     	 StringBuffer sb=new StringBuffer();
                     	 for(String s:sussessList) {
                         	    sb.append(s).append("\r\n");
                            }
                     	 String msg="企业标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询成功,请至二代企业信用信息查询菜单下查收征信结果！";
                        updateReturnBean.setParameter("result",msg );
                     }
                    if(errList!=null && errList.size()>0) {
	                   	 StringBuffer sb=new StringBuffer();
	                   	 for(String s:errList) {
	                       	    sb.append(s).append("\r\n");
	                          }
	                   	 String msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询失败！";
	                     updateReturnBean.setParameter("errList",msg );
	                   } 

	            } catch (Exception e) {
	            	context.setAttribute("CMD", "UPDATE");
                    id=(String)context.getAttribute("id");
	                isOk = false;
	                context.setAttribute("status", "failed");
	                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                OPCaller.call(QueryCorpOperation.class, context);
	                exceptionList.add(context.getAttribute("entCertNum").toString()+" "+","+" "+context.getAttribute("entName").toString());
	             //   ExceptionUtil.throwCommonException("企业查询异常");
	            }
	            if(exceptionList!=null && exceptionList.size()>0) {
	            	StringBuffer sb=new StringBuffer();
	            	for(String s:exceptionList) {
	            		sb.append(s).append("\r\n");
	            	}
	            	String msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询异常！";
	            	updateReturnBean.setParameter("exceptionList",msg );
	            } 
	            return updateReturnBean;
	        } catch (AppException appEx) {
	            throw appEx;
	        } catch (Exception ex) {
	            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
	        }
}
	}

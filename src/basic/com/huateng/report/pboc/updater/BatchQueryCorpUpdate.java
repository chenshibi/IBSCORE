package com.huateng.report.pboc.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.excel.imp.QueryUntils;
import com.huateng.exception.AppException;
import com.huateng.report.common.PbocConstants;
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
public class BatchQueryCorpUpdate extends BaseUpdate{

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
	            String id="";
	            boolean isOk = true;
	            String rptId = "";
	            OperationContext context = new OperationContext();
	      //      List<String> rptIdList=new ArrayList<String>();
	            PbocD103Service service = PbocD103Service.getInstance();
	            CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            List<String> expireList=new ArrayList<String>();
	            List<String> authList=new ArrayList<String>();
	            List<String> sussessList=new ArrayList<String>();
	            List<String> errList=new ArrayList<String>();
	            List<String> exceptionList=new ArrayList<String>();
	            List<String> emptyList=new ArrayList<String>();
	            List<Map<String, String>> queryList=new ArrayList<Map<String, String>>();
	            List<Map<String, String>> reQueryList=new ArrayList<Map<String, String>>();
	            try {
	                for(int i=0;i<list.size();i++){
	                    Map<String, String> map = list.get(i);
	                    List<CustPbocEntQuery> findPbocEntQueryMonthBefore2 = dao.findPbocEntQueryMonthBefore2(map.get("id").toString(),map.get("entCertNum").toString(),map.get("entName").toString()); 
	                    if((QueryUntils.Default).equals(map.get("certAuthStatus"))) {
	                    	authList.add(map.get("entCertNum").toString());
	                    }
	                    else if(findPbocEntQueryMonthBefore2!=null && findPbocEntQueryMonthBefore2.size()>0) {
	                    	 expireList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	                    	 reQueryList.add(map);
	                    }
	                    else {
	                    	 queryList.add(map);
	                    }
	                }
	                if(authList!=null && authList.size()>0) {
	                	 StringBuffer sb=new StringBuffer();
	                	 for(String s:authList) {
	                    	    sb.append(s).append("\r\n");
	                       }
	                	 String msg="企业标识号码为"+"\r\n"+sb+"\r\n"+"的企业没有授予证书权限";
	                     updateReturnBean.setParameter("authErrMsg",msg );
	                }
	                
                    if(expireList!=null && expireList.size()>0) {
                       StringBuffer sb=new StringBuffer();
                       for(String s:expireList) {
                    	    sb.append(s).append("\r\n");
                       }
                       String msg="企业标识号码和企业"+"\r\n"+sb+"的企业在一个月之内已经查询过";
                       updateReturnBean.setParameter("errMsg",msg );
                       updateReturnBean.setParameter("list",JsonUtils.toJson(reQueryList));
                     //  return updateReturnBean;
                    }	
                    if(queryList!=null && queryList.size()>0) {
                    	 for(int i=0;i<queryList.size();i++) {
                    		 Map<String, String> map = queryList.get(i);
                    		   if(!"00".equals(map.get("status"))) {
                    			   context.setAttribute("CMD", "INSERT"); 
                      			   context.setAttribute("CorpMakeMap", map);
                      			   OPCaller.call(QueryCorpOperation.class, context);
                    		   }else {
                    			   context.setAttribute("id", (String)map.get("id"));
                    		   }
                    		 
                    	/*	 if("00".equals(map.get("status"))) {
                    			 context.setAttribute("CMD", "BatchUpdate");
                    			 context.setAttribute("id", map.get("id"));
                    		 }else {
                    			 context.setAttribute("CMD", "INSERT"); 
                    			 context.setAttribute("CorpMakeMap", map);
                    		 }*/
                             QueryResult queryResult = service.queryEnterprise(map);
	   		                    if (StringUtils.equals(queryResult.getCode(), PbocConstants.QUERY_SUCCESS)) {
	   		                        logger.info("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "success");
	   		                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	   	                            context.setAttribute("uuid", rptId);
	   	                            context.setAttribute("CMD", "BatchUpdate");
	   	                            id=(String)context.getAttribute("id");
	   		                        context.setAttribute("uuid", rptId);
	   		                        context.setAttribute("rptId", rptId);
	   		                        context.setAttribute("status", "success");
	   		                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
	   		                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        sussessList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    } else if(StringUtils.equals(queryResult.getCode(),PbocConstants.QUERY_EMPTY_XML)){
	   		                        context.setAttribute("CMD", "BatchUpdate");
	   	                            id=(String)context.getAttribute("id");
	   		                        isOk = false;
	   		                        logger.error("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "failed");
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        emptyList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
	   		                    }else {
	   	                            context.setAttribute("CMD", "BatchUpdate");
	   	                            id=(String)context.getAttribute("id");
	   		                        isOk = false;
	   		                        logger.error("queryResult = " + queryResult);
	   		                        context.setAttribute("status", "failed");
	   		                        OPCaller.call(QueryCorpOperation.class, context);
	   		                        errList.add(map.get("entCertNum").toString()+" "+","+" "+map.get("entName").toString());
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
                    if(emptyList!=null && emptyList.size()>0) {
	                   	 StringBuffer sb=new StringBuffer();
	                   	 for(String s:emptyList) {
	                       	    sb.append(s).append("\r\n");
	                          }
	                   	 String msg="企业身份标识号码和企业"+"\r\n"+sb+"\r\n"+"的企业查询人行返回明细信息为空！";
	                     updateReturnBean.setParameter("emptyList",msg );
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
	            	context.setAttribute("CMD", "BatchUpdate");
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

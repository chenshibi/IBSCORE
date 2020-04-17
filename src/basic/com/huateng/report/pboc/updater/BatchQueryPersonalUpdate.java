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
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.pboc.operation.QueryPersonalOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.PbocD101Service;
import com.huateng.report.utils.JsonUtils;

import resource.bean.crms.CustPbocPerQuery;

/**
 * 
 * @author Grassy
 *
 */
public class BatchQueryPersonalUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            List<Map<String,String>> list = new ArrayList<Map<String,String>>();
	            UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("CrmsBatchQueryPersonalReport");
	            while (updateResultBean.hasNext()) {
	                Map<String, String> map = updateResultBean.next();
	                if (map.get("select").equals("true")){
	                    list.add(map);
	                }
	            }
	            boolean isOk = true;
	            String rptId = "";
	            String id="";
	            OperationContext context = new OperationContext();
	         //   List<String> rptIdList=new ArrayList<String>();
	            PbocD101Service service = PbocD101Service.getInstance();
	            CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	        //    context.setAttribute("CMD", "BatchUpdate");
	            List<String> sussessList=new ArrayList<String>();
	            List<String> expireList=new ArrayList<String>();
	            List<String> authList=new ArrayList<String>();
	            List<String> errList=new ArrayList<String>();
	            List<String> exceptionList=new ArrayList<String>();
	            List<Map<String, String>> queryList=new ArrayList<Map<String, String>>();
	            List<Map<String, String>> reQueryList=new ArrayList<Map<String, String>>();
	            try {
	                for(int i=0;i<list.size();i++){
	                    Map<String, String> map = list.get(i);
	                    List<CustPbocPerQuery> findPbocPerQueryMonthBefore2 = dao.findPbocPerQueryMonthBefore2(map.get("id").toString(),map.get("idNum").toString(),map.get("name").toString());
	                    if((QueryUntils.Default).equals(map.get("certAuthStatus"))) {
	                    	authList.add(map.get("certAuthStatus").toString());
	                    }
	                    else if(findPbocPerQueryMonthBefore2!=null && findPbocPerQueryMonthBefore2.size()>0) {
	                    	 expireList.add(map.get("idNum").toString()+" "+","+" "+map.get("name").toString());
	                    	 reQueryList.add(map);
	                    }else {
	                    	queryList.add(map);
	                    }
	                }
	                
	                if(authList!=null && authList.size()>0) {
	                	 StringBuffer sb=new StringBuffer();
	                	 for(String s:authList) {
	                    	    sb.append(s).append("\r\n");
	                       }
	                	 String msg="证件号码为"+"\r\n"+sb+"\r\n"+"的个人没有授予证书权限";
	                     updateReturnBean.setParameter("authErrMsg",msg );
	                //     return updateReturnBean;
	                }
	                
	                 if(expireList!=null && expireList.size()>0) {
                      StringBuffer sb=new StringBuffer();
                      for(String s:expireList) {
                   	    sb.append(s).append("\r\n");
                      }
                      String msg="个人证件号码和名称"+"\r\n"+sb+"的个人在一个月之内已经查询过";
                      updateReturnBean.setParameter("errMsg",msg );
                      updateReturnBean.setParameter("list",JsonUtils.toJson(reQueryList));
                  //    return updateReturnBean;
                   }
	                if(queryList!=null && queryList.size()>0) {
                	   for(int i=0;i<queryList.size();i++){
                		   Map<String, String> param = queryList.get(i);
                		   if(!"00".equals(param.get("status"))) {
                			   context.setAttribute("CMD", "INSERT"); 
                  			   context.setAttribute("PersonalMakeMap", param);
                  			   OPCaller.call(QueryPersonalOperation.class, context);
                		   }else {
                			   context.setAttribute("id", (String)param.get("id"));
                		   }
                            QueryResult queryResult = service.queryPersonal(param);
  		                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
  		                        logger.info("queryResult = " + queryResult);
  		                        context.setAttribute("status", "success");
  		                        rptId = StringUtils.trimToEmpty(queryResult.getId());
 	                            context.setAttribute("uuid", rptId);
 	                            context.setAttribute("CMD", "BatchUpdate");
 	                            id=(String)context.getAttribute("id");
  		                        context.setAttribute("rptId", rptId);
  		                        context.setAttribute("status", "success");
  		                        context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
  		                        context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
  		                        OPCaller.call(QueryPersonalOperation.class, context);
  		                        sussessList.add(param.get("idNum").toString()+" "+","+" "+param.get("name").toString());
  		                      //  rptIdList.add(rptId);
  		                     //   updateReturnBean.setParameter("uuid", rptIdList.toString());
  		                    } else {
  		                    	context.setAttribute("CMD", "BatchUpdate");
 	                            id=(String)context.getAttribute("id");
  		                        isOk = false;
  		                        logger.error("queryResult = " + queryResult);
  		                        context.setAttribute("status", "failed");
  		                        OPCaller.call(QueryPersonalOperation.class, context);
  		                        errList.add(param.get("idNum").toString()+" "+","+" "+param.get("name").toString());
  		                     //   ExceptionUtil.throwCommonException("个人查询失败");
  		                    }
                	   }
                   }
	                
	                if(sussessList!=null && sussessList.size()>0) {
                   	 StringBuffer sb=new StringBuffer();
                   	 for(String s:sussessList) {
                       	    sb.append(s).append("\r\n");
                          }
                   	 String msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询成功,请至二代个人信用信息查询菜单下查收征信结果！";
                      updateReturnBean.setParameter("result",msg );
                   }
	                
	                if(errList!=null && errList.size()>0) {
	                   	 StringBuffer sb=new StringBuffer();
	                   	 for(String s:errList) {
	                       	    sb.append(s).append("\r\n");
	                          }
	                   	 String msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询失败！";
	                     updateReturnBean.setParameter("errList",msg );
	                   } 

	            } catch (Exception e) {
	                isOk = false;
	                context.setAttribute("CMD", "BatchUpdate");
                    id=(String)context.getAttribute("id");
	                context.setAttribute("status", "failed");
	                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                OPCaller.call(QueryPersonalOperation.class, context);
	                exceptionList.add(context.getAttribute("idNum").toString()+" "+","+" "+context.getAttribute("name").toString());
	            //    ExceptionUtil.throwCommonException("个人查询异常");
	            }
	            
                if(exceptionList!=null && exceptionList.size()>0) {
                   	 StringBuffer sb=new StringBuffer();
                   	 for(String s:exceptionList) {
                       	    sb.append(s).append("\r\n");
                          }
                   	 String msg="个人身份证号和姓名"+"\r\n"+sb+"\r\n"+"的个人查询异常！";
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

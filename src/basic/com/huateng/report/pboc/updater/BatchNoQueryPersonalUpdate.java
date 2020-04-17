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
import com.huateng.ebank.framework.util.ExceptionUtil;
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
public class BatchNoQueryPersonalUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
	      try {
	            boolean isOk = true;
	            String rptId = "";
	            String id="";
	            OperationContext context = new OperationContext();
	            List<String> rptIdList=new ArrayList<String>();
	            PbocD101Service service = PbocD101Service.getInstance();
	            CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
	            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
	            List<String> expireList=new ArrayList<String>();
	            List<String> authList=new ArrayList<String>();
	            List<String> sussessList=new ArrayList<String>();
	            List<String> errList=new ArrayList<String>();
	            List<String> exceptionList=new ArrayList<String>();
	            List<Map<String, String>> queryList=new ArrayList<Map<String, String>>();
	            List<Map<String, String>> reQueryList=new ArrayList<Map<String, String>>();
	            List<CustPbocPerQuery> custPbocPerQueryList = dao.searchPerByAddStatus();
	            try {
	                for(int i=0;i<custPbocPerQueryList.size();i++){
	                    CustPbocPerQuery custPbocPerQuery = custPbocPerQueryList.get(i);
	                    Map<String,String> map=new HashMap<String,String>();
	                    map.put("tlrno", GlobalInfo.getCurrentInstance().getTlrno().toString());
	                    map.put("id", custPbocPerQuery.getId());
	                    map.put("name", custPbocPerQuery.getName());
	                    map.put("idType",custPbocPerQuery.getIdType() );
	                    map.put("idNum", custPbocPerQuery.getIdNum());
	                    map.put("queryReason", custPbocPerQuery.getQueryReason());
	                    map.put("serviceCode", custPbocPerQuery.getServiceCode());
	                    map.put("ip", GlobalInfo.getCurrentInstance().getIp());
	                    map.put("query_org_code", custPbocPerQuery.getRsv8());
	                    map.put("user_code", custPbocPerQuery.getRsv9());
	                    map.put("queryLevel",custPbocPerQuery.getQueryLevel() );
	                    map.put("status", custPbocPerQuery.getStatus());
	                    List<CustPbocPerQuery> findPbocPerQueryMonthBefore2 = dao.findPbocPerQueryMonthBefore2(custPbocPerQuery.getId(),custPbocPerQuery.getIdNum(),custPbocPerQuery.getName());
	                    if((QueryUntils.Default).equals(custPbocPerQuery.getCertAuthStatus())) {
	                    	authList.add(custPbocPerQuery.getIdNum());
	                    }
	                    else if(findPbocPerQueryMonthBefore2!=null && findPbocPerQueryMonthBefore2.size()>0) {
	                    	 expireList.add(custPbocPerQuery.getIdNum()+" "+","+" "+custPbocPerQuery.getName());
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
	                }
	                
	                 if(expireList!=null && expireList.size()>0) {
                      StringBuffer sb=new StringBuffer();
                      for(String s:expireList) {
                   	    sb.append(s).append("\r\n");
                      }
                      String msg="个人证件号码和名称"+"\r\n"+sb+"的个人在一个月之内已经查询过";
                      updateReturnBean.setParameter("errMsg",msg );
                      updateReturnBean.setParameter("list",JsonUtils.toJson(reQueryList));
                   }
	                if(queryList!=null && queryList.size()>0) {
                	   for(int i=0;i<queryList.size();i++){
                		   Map<String, String> param = queryList.get(i);
                		    context.setAttribute("CMD", "BatchUpdate");
              			    context.setAttribute("id", param.get("id"));
                			OPCaller.call(QueryPersonalOperation.class, context);
                            QueryResult queryResult = service.queryPersonal(param);
  	                        context.setAttribute("id", (String)param.get("id"));
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
  		                        OPCaller.call(QueryPersonalOperation.class, context);
  		                        sussessList.add(param.get("idNum").toString()+" "+","+" "+param.get("name").toString());
  		                    //    rptIdList.add(rptId);
  		                    //    updateReturnBean.setParameter("uuid", rptIdList.toString());
  		                    } else {
  		                    	context.setAttribute("CMD", "UPDATE");
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
	                context.setAttribute("CMD", "UPDATE");
                    id=(String)context.getAttribute("id");
	                context.setAttribute("status", "failed");
	                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
	                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
	                OPCaller.call(QueryPersonalOperation.class, context);
	                exceptionList.add(context.getAttribute("idNum").toString()+" "+","+" "+context.getAttribute("name").toString());
	           //     ExceptionUtil.throwCommonException("个人查询异常");
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

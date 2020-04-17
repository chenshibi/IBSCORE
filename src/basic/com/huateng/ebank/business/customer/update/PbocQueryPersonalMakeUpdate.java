package com.huateng.ebank.business.customer.update;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.dao.CustPbocPerQueryDAO;
import com.huateng.report.pboc.operation.QueryPersonalOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.service.PbocD101Service;

import resource.bean.crms.CustPbocPerQuery;
/**
 * 
 * @author Grassy
 *
 */
public class PbocQueryPersonalMakeUpdate extends BaseUpdate {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PbocQueryPersonalMakeUpdate.class);

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws AppException {
        UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryPersonalMake");

        Map<String, String> map = null;
        if (updateResultBean.hasNext()) {
            map = updateResultBean.next();
        }
        	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
        	NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        	CustPbocPerQueryDAO dao = ROOTDAOUtils.getCustPbocPerQueryDAO();
        	map.put("tlrno", currentInstance.getTlrno());
        	map.put("brno", currentInstance.getBrcode());
        	map.put("ip",currentInstance.getIp());
        	map.put("query_org_code", sysParamsService.getBankCode());
        	map.put("user_code", currentInstance.getTlrno());
            PbocD101Service service = PbocD101Service.getInstance();
            boolean isOk = true;
      	    String rptId = "";
      	    String id="";
      	    OperationContext context = new OperationContext();
            try {
            	  List<CustPbocPerQuery> findPbocPerQueryMonthBefore2 = dao.findPbocPerQueryMonthBefore3(map.get("idNum").toString(),map.get("name").toString());
            	  if(findPbocPerQueryMonthBefore2!=null && findPbocPerQueryMonthBefore2.size()>0) {
            		   //reQueryList.add(map);
            		   String idNum=map.get("idNum").toString();
            		   String name=map.get("name").toString();
            		   String msg="个人证件号"+idNum+"\r\n"+"名称为"+name+"的个人在一个月内已经查询过";
                       updateReturnBean.setParameter("errMsg",msg );
                       updateReturnBean.setParameter("name",name);
                       updateReturnBean.setParameter("idNum",idNum);
                       updateReturnBean.setParameter("idType",map.get("idType").toString());
                       updateReturnBean.setParameter("queryReason",map.get("queryReason").toString());
                       updateReturnBean.setParameter("serviceCode",map.get("serviceCode").toString());
                       updateReturnBean.setParameter("queryLevel", map.get("queryLevel").toString());
                       return updateReturnBean;
            	  }
            	  context.setAttribute("CMD", "INSERT");
            	  context.setAttribute("PersonalMakeMap", map);
            	  OPCaller.call(QueryPersonalOperation.class, context);
                    QueryResult queryResult = service.queryPersonal(map);
                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
                        logger.info("queryResult = " + queryResult);
                        context.setAttribute("status", "success");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        id=(String)context.getAttribute("id");
	                    context.setAttribute("uuid", rptId);
	                    context.setAttribute("status", "success");
	                    context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
	                    context.setAttribute("respMsg", StringUtils.trimToEmpty(queryResult.getMsg()));
	                    OPCaller.call(QueryPersonalOperation.class, context);
	                    updateReturnBean.setParameter("uuid", rptId);
                    } else {
                        isOk = false;
                        logger.error("queryResult = " + queryResult);
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "failed");
                        OPCaller.call(QueryPersonalOperation.class, context);
                        ExceptionUtil.throwCommonException("个人查询失败");
                    }

            } catch (Exception e) {
                isOk = false;
                context.setAttribute("CMD", "UPDATE");
                context.setAttribute("status", "failed");
                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
                OPCaller.call(QueryPersonalOperation.class, context);
                ExceptionUtil.throwCommonException("个人查询异常");
            }
            return updateReturnBean;
        }
    }
  
  

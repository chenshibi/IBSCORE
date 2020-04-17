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
import com.huateng.report.common.PbocConstants;
import com.huateng.report.pboc.dao.CustPbocEntQueryDAO;
import com.huateng.report.pboc.operation.QueryCorpOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.NewSysParamsService;
import com.huateng.report.service.PbocD103Service;

import resource.bean.crms.CustPbocEntQuery;
/**
 * 
 * @author Grassy
 *
 */
public class CrmsPbocQueryCorpMakeUpdate extends BaseUpdate {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CrmsPbocQueryCorpMakeUpdate.class);

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws AppException {
        UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryCorpMake");

        Map<String, String> map = null;
        if (updateResultBean.hasNext()) {
            map = updateResultBean.next();
        }
        	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
        	CustPbocEntQueryDAO dao = ROOTDAOUtils.getCustPbocEntQueryDAO();
        	NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        	map.put("tlrno", currentInstance.getTlrno());
        	map.put("brno", currentInstance.getBrcode());
        	map.put("query_org_code", sysParamsService.getBankCode());
        	map.put("user_code", currentInstance.getTlrno());
            OperationContext context = new OperationContext();
            boolean isOk = true;
            String rptId = "";
            String id="";
            PbocD103Service service = PbocD103Service.getInstance();
            try {
          	  List<CustPbocEntQuery> findPboEntQueryMonthBefore2 = dao.findPbocEntQueryMonthBefore3(map.get("entCertNum").toString(),map.get("entName").toString());
        	  if(findPboEntQueryMonthBefore2!=null && findPboEntQueryMonthBefore2.size()>0) {
        		   //reQueryList.add(map);
        		   String entCertNum=map.get("entCertNum").toString();
        		   String entName=map.get("entName").toString();
        		   String msg="企业标识号"+entCertNum+"\r\n"+"名称为"+entName+"的企业在一个月内已经查询过";
                   updateReturnBean.setParameter("errMsg",msg );
                   updateReturnBean.setParameter("entName",entName);
                   updateReturnBean.setParameter("entCertNum",entCertNum);
                   updateReturnBean.setParameter("entCertType",map.get("entCertType").toString());
                   updateReturnBean.setParameter("queryReason",map.get("queryReason").toString());
                   updateReturnBean.setParameter("serviceCode",map.get("serviceCode").toString());
                   return updateReturnBean;
        	  }
        	       context.setAttribute("CMD", "INSERT");
                   context.setAttribute("CorpMakeMap", map);
                   OPCaller.call(QueryCorpOperation.class, context);
                    QueryResult queryResult = service.queryEnterprise(map);
                    if (StringUtils.equals(queryResult.getCode(), PbocConstants.QUERY_SUCCESS)) {
                        logger.info("queryResult = " + queryResult);
                        context.setAttribute("status", "success");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        id=(String)context.getAttribute("id");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
	                    context.setAttribute("uuid", rptId);
	                    context.setAttribute("status", "success");
	                    context.setAttribute("respCode", StringUtils.trimToEmpty(queryResult.getCode()));
	                    context.setAttribute("respMsg",  StringUtils.trimToEmpty(queryResult.getMsg()));
	                    OPCaller.call(QueryCorpOperation.class, context);
	                    updateReturnBean.setParameter("uuid", rptId);
                    }else if(StringUtils.equals(queryResult.getCode(), PbocConstants.QUERY_EMPTY_XML)){
                    	isOk = false;
                    	logger.error("queryResult = " + queryResult);
                    	rptId = StringUtils.trimToEmpty(queryResult.getId());
                    	id=(String)context.getAttribute("id");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("id", id);	                        
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "failed");
                        OPCaller.call(QueryCorpOperation.class, context);
                        ExceptionUtil.throwCommonException("人行返回企业明细信息为空");
                    }else {
                        isOk = false;
                        logger.error("queryResult = " + queryResult);
                        id=(String)context.getAttribute("id");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("id", id);	                        
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "failed");
                        OPCaller.call(QueryCorpOperation.class, context);
                        ExceptionUtil.throwCommonException("企业查询失败");
                    }

            } catch (Exception e) {
                isOk = false;
                context.setAttribute("CMD", "UPDATE");
                context.setAttribute("status", "failed");
                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
                OPCaller.call(QueryCorpOperation.class, context);
                ExceptionUtil.throwCommonException("企业查询异常");
            }
            return updateReturnBean;
        }
    }
  
  

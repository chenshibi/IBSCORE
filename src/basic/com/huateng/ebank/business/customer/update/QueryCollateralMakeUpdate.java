package com.huateng.ebank.business.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.operation.QueryCollateralOperation;
import com.huateng.report.pboc.result.QueryResult;
import com.huateng.report.service.PbocR103Service;
/**
 * 
 * @author Grassy
 *
 */
public class QueryCollateralMakeUpdate extends BaseUpdate {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(QueryCollateralMakeUpdate.class);

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws AppException {
        UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("QueryCollateralMake");

        Map<String, String> map = null;
        if (updateResultBean.hasNext()) {
            map = updateResultBean.next();
        }
        	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
            OperationContext context = new OperationContext();
            map.put("tlrno", currentInstance.getTlrno());
            boolean isOk = true;
            String rptId = "";
            String id="";
            PbocR103Service service = PbocR103Service.getInstance();
            try {
        	       context.setAttribute("CMD", "INSERT");
                   context.setAttribute("CollateralMakeMap", map);
                   OPCaller.call(QueryCollateralOperation.class, context);
                    QueryResult queryResult = service.queryCollateral(map);
                    if (StringUtils.equals(queryResult.getCode(), "0000")) {
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
	                    OPCaller.call(QueryCollateralOperation.class, context);
	                    updateReturnBean.setParameter("uuid", rptId);
                    } else {
                        isOk = false;
                        logger.error("queryResult = " + queryResult);
                        id=(String)context.getAttribute("id");
                        rptId = StringUtils.trimToEmpty(queryResult.getId());
                        context.setAttribute("id", id);	                        
                        context.setAttribute("uuid", rptId);
                        context.setAttribute("CMD", "UPDATE");
                        context.setAttribute("status", "failed");
                        OPCaller.call(QueryCollateralOperation.class, context);
                        ExceptionUtil.throwCommonException("企业相关还款责任人及抵押物查询失败");
                    }

            } catch (Exception e) {
                isOk = false;
                context.setAttribute("CMD", "UPDATE");
                context.setAttribute("status", "failed");
                context.setAttribute("respCode", StringUtils.trimToEmpty("9999"));
                context.setAttribute("respMsg", StringUtils.trimToEmpty(e.getMessage()));
                OPCaller.call(QueryCollateralOperation.class, context);
                ExceptionUtil.throwCommonException("企业相关还款责任人及抵押物查询异常");
            }
            return updateReturnBean;
        }
    }
  
  

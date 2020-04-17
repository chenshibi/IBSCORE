package com.huateng.ebank.business.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.operation.QueryPersonalCrawlOperation;
import com.huateng.report.service.NewSysParamsService;
/**
 * 
 * @author Grassy
 *
 */
public class PbocQueryPersonalCrawl extends BaseUpdate {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(PbocQueryPersonalCrawl.class);

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse) throws AppException {
        UpdateResultBean updateResultBean = paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryPersonalCrawl");

        Map<String, String> map = null;
        if (updateResultBean.hasNext()) {
            map = updateResultBean.next();
        }
        	UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        	GlobalInfo currentInstance = GlobalInfo.getCurrentInstance();
        	NewSysParamsService sysParamsService = NewSysParamsService.getInstance();
        	map.put("tlrno", currentInstance.getTlrno());
        	map.put("brno", currentInstance.getBrcode());
        	map.put("query_org_code", sysParamsService.getBankCode());
        	map.put("user_code", currentInstance.getTlrno());
            OperationContext context = new OperationContext();
            context.setAttribute("CMD", "INSERT");
            context.setAttribute("PersonalMakeMap", map);
            OPCaller.call(QueryPersonalCrawlOperation.class, context);
            updateReturnBean.setParameter("result", "ok");
            return updateReturnBean;
        }
    }
  
  

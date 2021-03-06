/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;


import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author 
 *
 */
@SuppressWarnings("unchecked")
public class IbsPerCreditGetter2 extends BaseGetter {

    public Result call() throws AppException {
        try {

            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageResult.getTotalCount());
        	this.setValue2DataBus(ReportConstant.QUERY_LOG_BUSI_NAME,"IBSCORE报表管理");
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

	private PageQueryResult getData() throws CommonException {

		int pageSize = getResult().getPage().getEveryPage();
		int pageIndex = getResult().getPage().getCurrentPage();
		ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
		PageQueryResult pageQueryResult = null;
		PageQueryCondition queryCondition = new PageQueryCondition();
		StringBuilder hql = new StringBuilder(" SELECT model FROM IbsPerCredit model WHERE 1 = 1 ");
		String id= (String)getCommQueryServletRequest().getParameterMap().get("xh");
	    hql.append("and batchid = ").append("'").append(id).append("'");
		hql.append(" order by klrq desc ");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
	    return pageQueryResult;
	}
}

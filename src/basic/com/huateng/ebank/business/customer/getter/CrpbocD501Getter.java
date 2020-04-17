/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;
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
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author 
 *
 */
@SuppressWarnings("unchecked")
public class CrpbocD501Getter extends BaseGetter {

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
		StringBuilder hql = new StringBuilder(" SELECT model FROM CrPbocD501 model WHERE 1 = 1 ");
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
		String qworkDateStart = map.get("etlDateStart")+"000000";
		String qworkDateEnd = map.get("etlDateEnd")+"240000";
		String brcode=map.get("brcodeName");
		String statusCode=map.get("status");
		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(qworkDateStart)) {
			hql.append(" and fileGenTime  >= ? ");
			paramentList.add(qworkDateStart);
		}
		if (!DataFormat.isEmpty(qworkDateEnd)) {
			hql.append(" and fileGenTime  <= ? ");
			paramentList.add(qworkDateEnd);
		}
		if (!DataFormat.isEmpty(brcode)) {
			hql.append(" and RSV3= ? ");
			paramentList.add(brcode);
		}
		if (!DataFormat.isEmpty(statusCode)) {
			hql.append(" and status= ? ");
			paramentList.add(statusCode);
		}

		hql.append(" order by createTime desc,status desc ");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
		queryCondition.setObjArray(paramentList.toArray());
		pageQueryResult = rootDAO.pageQueryByQL(queryCondition);
	    return pageQueryResult;
	}
}

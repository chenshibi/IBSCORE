package com.huateng.boa.getter;

import java.util.ArrayList;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


@SuppressWarnings("unchecked")
public class CustHolidayQueryGetter extends BaseGetter {

	public Result call() throws AppException {
		try {
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
			result.init();
			result.setTotal(pageResult.getTotalCount());
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
		PageQueryResult queryResult = new PageQueryResult();
		PageQueryCondition queryCondition = new PageQueryCondition();
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);

		String qreqdatebegin = (String) getCommQueryServletRequest().getParameterMap().get("qreqdatebegin");
		String qreqdateend = (String) getCommQueryServletRequest().getParameterMap().get("qreqdateend");
		String sql = " from CustHoliday po where 1 = 1 ";
		ArrayList<String> condList = new ArrayList<String>();
		if (!DataFormat.isEmpty(qreqdatebegin)) {
			sql = sql + " and po.hdate >= ? ";
			condList.add(qreqdatebegin);
		}
		if (!DataFormat.isEmpty(qreqdateend)) {
			sql = sql + " and po.hdate <= ? ";
			condList.add(qreqdateend);
		}
		sql = sql + " order by po.hdate asc ";
		ROOTDAOUtils.getROOTDAO().queryByCondition(sql, condList.toArray());
		queryCondition.setQueryString(sql);
		queryCondition.setObjArray(condList.toArray());
		queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
		return queryResult;
	}

}

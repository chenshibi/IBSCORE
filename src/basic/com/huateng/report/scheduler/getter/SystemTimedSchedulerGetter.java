package com.huateng.report.scheduler.getter;

import java.util.ArrayList;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.dao.basic.ComposedBean;

@SuppressWarnings("unchecked")
public class SystemTimedSchedulerGetter extends BaseGetter {

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
        String sysName = (String) getCommQueryServletRequest().getParameterMap().get("sysName");
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        ComposedBean composeBean = new ComposedBean();
        StringBuffer hql = new StringBuffer();
        ArrayList<String> condList = new ArrayList<String>();
        hql.append("from ReportJobConfig t where 1=1 ");
        if (!DataFormat.isEmpty(sysName)) {
            hql.append(" and t.sysName = ? ");
            condList.add(sysName);
        }
        hql.append("order by t.sysName");
        composeBean.setSql(hql.toString());
        composeBean.setParams(condList);
        queryCondition.setQueryString(composeBean.getSql());
        queryCondition.setObjArray(condList.toArray());
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        queryResult = rootDao.pageQueryByQL(queryCondition);

        return queryResult;
    }

}

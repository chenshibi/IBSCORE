package com.huateng.report.pboc.getter;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author Grassy
 * @date 2019/2/19 12:11
 * @jdk.version 1.8
 * @desc
 */
public class PasswordModifyQueryGetter extends BaseGetter {
    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
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

    private PageQueryResult getData() throws Exception {
        PageQueryResult queryResult = new PageQueryResult();
        PageQueryCondition queryCondition = new PageQueryCondition();
        int pageSize = getResult().getPage().getEveryPage();
        int pageIndex = getResult().getPage().getCurrentPage();
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        StringBuffer hql = new StringBuffer();
        hql.append(" from CrPbocL102 ");
        hql.append("where 0 = 0 ");
        hql.append("  order by RECORD_STATUS desc").append(",").append("RECEIPT_TIME").append(" ").append("desc");
        queryCondition.setQueryString(hql.toString());
        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);

        return queryResult;
    }
}

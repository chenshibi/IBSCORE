package com.huateng.ebank.business.management.getter;

import java.util.ArrayList;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class AllFaRenBranchSelect extends BaseGetter {

    public Result call() throws AppException {
        try {
            PageQueryCondition queryCondition = new PageQueryCondition();
            Page page = result.getPage();
            ArrayList<String> condList = new ArrayList<String>();
            String value = getCommQueryServletRequest().getParameter("value1");
            if (value == null || "".equals(value)) {
                queryCondition.setQueryString("from StBankInfo ");
            } else {
                condList.add("%" + value.trim() + "%");
                queryCondition.setQueryString("from StBankInfo po where po.stbrNo like ? ");
            }

            queryCondition.setPageSize(page.getEveryPage());
            queryCondition.setPageIndex(page.getCurrentPage());
            queryCondition.setObjArray(condList.toArray());
            for (String s : condList) {
                System.out.println(s);
            }
            PageQueryResult pageResult = DAOUtils.getHQLDAO().pageQueryByQL(queryCondition);

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            if (pageResult.getQueryResult().size() == 0) {
                result.getPage().setTotalPage(0);
            } else {
                result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            }
            result.init();
            result.setTotal(pageResult.getTotalCount());
            return result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}

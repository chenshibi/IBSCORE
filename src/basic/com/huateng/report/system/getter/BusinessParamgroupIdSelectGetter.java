package com.huateng.report.system.getter;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.system.service.BusinessService;

public class BusinessParamgroupIdSelectGetter extends BaseGetter {
    /*
     * 参数段编号下拉框(模糊筛选框)
     * 
     */
    @Override
    public Result call() throws AppException {
        // TODO Auto-generated method stub
        String paramgroupId = this.getCommQueryServletRequest().getParameter("value");
        BusinessService service = BusinessService.getInstance();
        int pageSize = this.getResult().getPage().getEveryPage();
        int pageIndex = this.getResult().getPage().getCurrentPage();
        PageQueryResult pageResult = service.paramgroupIdSelect(pageIndex, pageSize, paramgroupId);
        ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                getResult());
        result.setContent(pageResult.getQueryResult());
        result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
        result.init();
        result.setTotal(pageResult.getTotalCount());
        return result;
    }

}

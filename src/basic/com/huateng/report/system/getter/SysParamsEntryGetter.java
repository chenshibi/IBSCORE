package com.huateng.report.system.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.system.service.SysParamsService;

public class SysParamsEntryGetter extends BaseGetter {
    /*
     * 获取系统参数列表
     * 
     * @author zhuhongyong
     */
    @Override
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

    private PageQueryResult getData() {

        Map paramMap = this.getCommQueryServletRequest().getParameterMap();
        String paramgroupId = (String) paramMap.get("paramgroupIdSelect");
        String qst = getCommQueryServletRequest().getParameter("st");
        int pageSize = this.getResult().getPage().getEveryPage();
        int pageIndex = this.getResult().getPage().getCurrentPage();
        return SysParamsService.getInstance().pageQueryByHql(pageIndex, pageSize, paramgroupId, qst);
    }
}

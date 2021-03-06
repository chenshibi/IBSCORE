package com.huateng.msgplatform.getter;

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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.dao.basic.ComposedBean;
import resource.dao.msg.ComposedMsgSql;

/**
 * 
 * Filename:LoanersQueryGetter.java Description:借款人机构信息第一屏 Copyright:Copyright
 * (c)2012 Company: HuaTeng
 * 
 * @author: shijie.zhu
 * @version: 1.0
 * @Create: 2013-1-1 Modification History: Date Author Version
 *          ------------------------------------------------------------------
 *          2013-1-1上午11:01:01 shijie.zhu 1.0
 */
@SuppressWarnings("unchecked")
public class RcvUserGroupGetter extends BaseGetter {

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

        String type = (String) this.getCommQueryServletRequest().getParameterMap().get("type");// 区分是不是历史表
                                                                                               // 区分是不是新增操作
        if ("addNewGroup".equals(type)) {
            return new PageQueryResult();
        }

        Map<String, String> map = this.getCommQueryServletRequest().getParameterMap();
        ComposedBean composeBean = ComposedMsgSql.queryGroupInf(map, type);
        queryCondition.setQueryString(composeBean.getSql());
        queryCondition.setObjArray(composeBean.getParams().toArray());
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        queryResult = rootDao.pageQueryByQL(queryCondition);

        return queryResult;
    }

}

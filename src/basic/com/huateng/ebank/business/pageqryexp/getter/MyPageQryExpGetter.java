package com.huateng.ebank.business.pageqryexp.getter;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.pageqryexp.service.MyPageQryExpService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class MyPageQryExpGetter extends BaseGetter {
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();

            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());

            this.result.setContent(pageResult.getQueryResult());
            this.result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));

            this.result.init();
            this.result.setTotal(pageResult.getTotalCount());
            return this.result;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException("SY", "9999", ex.getMessage(), ex);
        }
    }

    private PageQueryResult getData() throws CommonException {
        int pageSize = getResult().getPage().getEveryPage();

        int pageIndex = getResult().getPage().getCurrentPage();
        ArrayList<String> condList = new ArrayList<String>();

        MyPageQryExpService service = new MyPageQryExpService();
        StringBuffer hql = new StringBuffer("select tsk from TblCSFileExportTskInf tsk where  tskStartOp = '"
                + GlobalInfo.getCurrentInstance().getTlrno() + "' ");

        String qFileNm = getCommQueryServletRequest().getParameter("qFileNm");
        String qTskStat = getCommQueryServletRequest().getParameter("qTskStat");
        String qTskStartDt = getCommQueryServletRequest().getParameter("qTskStartDt");
        if (StringUtils.isNotBlank(qTskStat)) {
            hql.append(" and tsk.tskStat= ? ");
            condList.add(qTskStat);
        }
        if (StringUtils.isNotBlank(qFileNm)) {
            hql.append(" and tsk.taskDesc like ? ");
            condList.add("%" + qFileNm + "%");
        }
        if (StringUtils.isNotBlank(qTskStartDt)) {
            hql.append(" and tsk.tskStartTms like ? ");
            condList.add("%" + qTskStartDt + "%");
        }
        hql.append(" order by tsk.tskStartTms desc");
        return service.list(pageIndex, pageSize, hql.toString(), condList.toArray());
    }
}
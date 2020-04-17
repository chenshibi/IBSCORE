package com.huateng.msgplatform.getter;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class CpgClientEmailQueryGetter extends BaseGetter {
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

    protected PageQueryResult getData() throws Exception {
        PageQueryResult queryResult = new PageQueryResult();
        PageQueryCondition queryCondition = new PageQueryCondition();
        int pageSize = getResult().getPage().getEveryPage();
        int pageIndex = getResult().getPage().getCurrentPage();
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        ArrayList<String> condList = new ArrayList<String>();
        StringBuffer hql = new StringBuffer();

        hql.append(
                "select new com.huateng.msgplatform.getter.CpgClientEmailQueryGetterView(  tbl_CPG_CLIENT_EMAIL.actno as cpgClientEmailActno,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.actName as cpgClientEmailActName,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.brno as cpgClientEmailBrno,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.email as cpgClientEmailEmail,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.msgId as cpgClientEmailMsgId,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.msgName as cpgClientEmailMsgName,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.sndTime as cpgClientEmailSndTime,");
        hql.append(" tbl_CPG_CLIENT_EMAIL.st as cpgClientEmailSt ");
        hql.append(")  from  CpgClientEmail tbl_CPG_CLIENT_EMAIL  ");
        hql.append("where 0 = 0 ");
        hql.append(" ");
        String querycpgClientEmailActno = (String) getCommQueryServletRequest().getParameterMap()
                .get("querycpgClientEmailActno");
        if (StringUtils.isNotBlank(querycpgClientEmailActno)) {
            hql.append(" and tbl_CPG_CLIENT_EMAIL.actno = ? ");
            condList.add(querycpgClientEmailActno);
        }
        String querycpgClientEmailActName = (String) getCommQueryServletRequest().getParameterMap()
                .get("querycpgClientEmailActName");
        if (StringUtils.isNotBlank(querycpgClientEmailActName)) {
            hql.append(" and tbl_CPG_CLIENT_EMAIL.actName like '%' || ? || '%' ");
            condList.add(querycpgClientEmailActName);
        }
        queryCondition.setObjArray(condList.toArray());
        queryCondition.setQueryString(hql.toString());
        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
        return queryResult;
    }
}

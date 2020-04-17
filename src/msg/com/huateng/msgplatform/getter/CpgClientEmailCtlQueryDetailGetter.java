package com.huateng.msgplatform.getter;

import java.util.ArrayList;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

public class CpgClientEmailCtlQueryDetailGetter extends BaseGetter {
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
                "select new com.huateng.msgplatform.getter.CpgClientEmailCtlQueryDetailGetterView(  tbl_CPG_CLIENT_EMAIL_CTL.msgId as cpgClientEmailCtlMsgId,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.msgName as cpgClientEmailCtlMsgName,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.sysName as cpgClientEmailCtlSysName,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.brno as cpgClientEmailCtlBrno,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.clientSnd as cpgClientEmailCtlClientSnd,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.opsSnd as cpgClientEmailCtlOpsSnd,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.email as cpgClientEmailCtlEmail,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.st as cpgClientEmailCtlSt,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.mdTlr as cpgClientEmailCtlMdTlr,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.mdTime as cpgClientEmailCtlMdTime,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.apvTlr as cpgClientEmailCtlApvTlr,");
        hql.append(" tbl_CPG_CLIENT_EMAIL_CTL.apvTime as cpgClientEmailCtlApvTime ");
        hql.append(")  from  CpgClientEmailCtl tbl_CPG_CLIENT_EMAIL_CTL  ");
        hql.append("where 0 = 0 ");
        hql.append(" ");
        queryCondition.setObjArray(condList.toArray());
        queryCondition.setQueryString(hql.toString());
        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);
        return queryResult;
    }
}

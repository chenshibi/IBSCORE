package com.huateng.report.pboc.getter;

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

/**
 * @author Grassy
 * @date 2019/2/19 12:11
 * @jdk.version 1.8
 * @desc
 */
public class CrComEaaGetter extends BaseGetter {
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
        ArrayList<String> condList = new ArrayList<String>();
        StringBuffer hql = new StringBuffer();
        hql.append(" from CrComEaa ");
        hql.append("where 0 = 0 ");

    /*    String entName = (String) getCommQueryServletRequest().getParameterMap().get("entName");
        if (StringUtils.isNotBlank(entName)) {
            hql.append(" and upper(entName) like '%' || upper(?) || '%'");
            condList.add(entName);
        }
        String entCertNum = (String) getCommQueryServletRequest().getParameterMap().get("entCertNum");
        if (StringUtils.isNotBlank(entCertNum)) {
            hql.append(" and upper(entCertNum) like '%' || upper(?) || '%'");
            condList.add(entCertNum);
        }
        String qtlrno = (String) getCommQueryServletRequest().getParameterMap().get("qtlrno");
        if (!DataFormat.isEmpty(qtlrno)) {
            hql.append("and upper(createUser) like '%' || upper(?) || '%' ");
            condList.add(qtlrno.toLowerCase());
        }
        String st=(String) getCommQueryServletRequest().getParameterMap().get("status");
        if(StringUtils.isNotBlank(st)){
            hql.append("and upper(status) like '%' || upper(?) || '%' ");
            condList.add(st);
        }
        queryCondition.setObjArray(condList.toArray());*/
        queryCondition.setQueryString(hql.toString());
        queryResult = ROOTDAOUtils.getROOTDAO().pageQueryByQL(queryCondition);

        return queryResult;
    }
}

package com.huateng.msgplatform.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @author zhangdianchao
 *
 */
public class CpgMsgUsrTmpGetter extends BaseGetter {

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
        String userId = (String) getCommQueryServletRequest().getParameterMap().get("userId");
        String innerId = (String) getCommQueryServletRequest().getParameterMap().get("id");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = new ArrayList();
        ArrayList<String> condList = new ArrayList<String>();
        StringBuffer hql = new StringBuffer("select po from CpgMsgUsrTmp po where 1=1 ");
        if (!DataFormat.isEmpty(userId)) {
            hql.append(" and po.userId = ? ");
            condList.add(userId);
        }
        if (!DataFormat.isEmpty(userId)) {
            hql.append(" and po.innerId = ? ");
            condList.add(innerId);
        }
        hql.append(" and po.optStatus = '0'");
        hql.append(" order by po.id");
        list = rootdao.queryByCondition(hql.toString(), condList.toArray());

        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List rs = new ArrayList();
        rs = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(rs);

        return pageQueryResult;
    }
}

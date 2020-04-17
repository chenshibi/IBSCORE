package com.huateng.ebank.business.pageqryexp.service;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.orm.HQLDAO;

public class MyPageQryExpService {
    public PageQueryResult list(int pageIndex, int pageSize, String hql) throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        HQLDAO hqlDAO = DAOUtils.getHQLDAO();
        return hqlDAO.pageQueryByQL(queryCondition);
    }

    public PageQueryResult list(int pageIndex, int pageSize, String hql, Object[] objs) throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        queryCondition.setObjArray(objs);
        HQLDAO hqlDAO = DAOUtils.getHQLDAO();
        return hqlDAO.pageQueryByQL(queryCondition);
    }
}

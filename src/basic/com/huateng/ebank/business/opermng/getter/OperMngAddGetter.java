/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.opermng.getter;

import java.util.ArrayList;
import java.util.List;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.TlrInfo;
import resource.dao.basic.TlrInfoDAO;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngAddGetter extends BaseGetter {

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
        PageQueryResult result = new PageQueryResult();
        String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("tlrno");
        String op = (String) getCommQueryServletRequest().getParameterMap().get("op");
        if (!op.equals("new")) {
            List<TlrInfo> list = new ArrayList<TlrInfo>();
            TlrInfoDAO tlrInfoDao = DAOUtils.getTlrInfoDAO();
            TlrInfo tlrInfo = tlrInfoDao.query(tlrno);
            list.add(tlrInfo);
            result.setQueryResult(list);
            result.setTotalCount(1);
        }
        getCommQueryServletRequest().setParameter("op", op);
        return result;
    }
}

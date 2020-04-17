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
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.Bctl;
import resource.bean.basic.TlrBctlRel;

/**
 * @author zhiguo.zhao
 *
 */
public class BctlMngEntryGetter extends BaseGetter {

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
        String tlrno = (String) getCommQueryServletRequest().getParameterMap().get("tlrno");
        String op = (String) getCommQueryServletRequest().getParameterMap().get("op");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = "select bctl from Bctl bctl where bctl.status='1'";
        if (op != null && op.equals("modify")) {
            hql += " and bctl.st='4'";
        }
        hql += " order by bctl.brno";
        List<Bctl> list = rootdao.queryByQL2List(hql);

        List<String> tlrnoBctlRel = new ArrayList<String>();
        if (!DataFormat.isEmpty(tlrno) && !tlrno.equals("0")) {
            ArrayList<String> condList = new ArrayList<String>();
            condList.add(tlrno);
            String tempHql = "select tlrBctl from TlrBctlRel tlrBctl where tlrBctl.tlrNo = ? ";
            List<TlrBctlRel> tempList = rootdao.queryByQL2List(tempHql, condList.toArray(), null);
            for (TlrBctlRel temp : tempList) {
                tlrnoBctlRel.add(temp.getBrNo());
            }
        }
        if (tlrnoBctlRel.size() > 0) {
            for (Bctl bc : list) {
                bc.setSelected(tlrnoBctlRel.contains(bc.getBrno()));
            }
        }

        PageQueryResult pageQueryResult = new PageQueryResult();
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(list);

        return pageQueryResult;
    }
}

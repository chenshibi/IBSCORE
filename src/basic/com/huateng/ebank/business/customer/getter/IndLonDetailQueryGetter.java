/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.util.ArrayList;
import java.util.List;

import resource.bean.basic.IndApp;
import resource.bean.basic.IndLonDetail;


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
 * @author 
 *
 */
public class IndLonDetailQueryGetter extends BaseGetter {

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

    @SuppressWarnings("unchecked")
	protected PageQueryResult getData() throws Exception {
        String rptId = (String) getCommQueryServletRequest().getParameterMap().get("rptId");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndLonDetail> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select id from IndLonDetail id where id.rptId='"+rptId+"'");
        List<IndLonDetail> listIndDetail = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listIndDetail.size(); i++) {
        	IndLonDetail indLonDetail=new IndLonDetail();
        	indLonDetail.setIssurenceDate(listIndDetail.get(i).getIssurenceDate());
        	indLonDetail.setEndDate(listIndDetail.get(i).getEndDate());
        	indLonDetail.setOrgName(listIndDetail.get(i).getOrgName());
        	indLonDetail.setOrgType(listIndDetail.get(i).getOrgType());
        	indLonDetail.setAmount(listIndDetail.get(i).getAmount());
        	indLonDetail.setType(listIndDetail.get(i).getType());
        	indLonDetail.setBizNo(listIndDetail.get(i).getBizNo());
        	indLonDetail.setAssurance(listIndDetail.get(i).getAssurance());
        	indLonDetail.setOverdueCount(listIndDetail.get(i).getOverdueCount());
        	indLonDetail.setAccStatus(listIndDetail.get(i).getAccStatus());
        	indLonDetail.setOverdueAmount(listIndDetail.get(i).getOverdueAmount());
        	list.add(indLonDetail);
        }
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /* 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List result = new ArrayList();
        result = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(result);
        return pageQueryResult;
    }
}

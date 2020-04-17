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
import resource.bean.basic.IndOverdue;


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
public class IndOverdueQueryGetter extends BaseGetter {

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
        List<IndOverdue> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select io from IndOverdue io where io.rptId='"+rptId+"'");
        List<IndOverdue> listIndOverdue = rootdao.queryByCondition(hql1.toString());
        if(listIndOverdue.size()>0){
        	IndOverdue indOverdue=new IndOverdue();
        	indOverdue.setLoanCount(listIndOverdue.get(0).getLoanCount());
        	indOverdue.setLoanMonthCount(listIndOverdue.get(0).getLoanMonthCount());
        	indOverdue.setLoanMaxAmount(listIndOverdue.get(0).getLoanMaxAmount());
        	indOverdue.setLoanMaxMonth(listIndOverdue.get(0).getLoanMaxMonth());
        	indOverdue.setCcCount(listIndOverdue.get(0).getCcCount());
        	indOverdue.setCcMonthCount(listIndOverdue.get(0).getCcMonthCount());
        	indOverdue.setCcMaxAmount(listIndOverdue.get(0).getCcMaxAmount());
        	indOverdue.setCcMaxMonth(listIndOverdue.get(0).getCcMaxMonth());
        	indOverdue.setPdcCount(listIndOverdue.get(0).getPdcCount());
        	indOverdue.setPdcMonthCount(listIndOverdue.get(0).getPdcMonthCount());
        	indOverdue.setPcdMaxAmount(listIndOverdue.get(0).getPcdMaxAmount());
        	indOverdue.setPdcMaxMonth(listIndOverdue.get(0).getPdcMaxMonth());
        	list.add(indOverdue);
        	
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

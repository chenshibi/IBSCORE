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
import resource.bean.basic.IndInsPayment;



import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author 
 *
 */
public class IndInsPaymentQueryGetter extends BaseGetter {

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
        List<IndInsPayment> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ia from IndInsPayment ia where ia.rptId='"+rptId+"' ");
        List<IndInsPayment> listInsPayment = rootdao.queryByCondition(hql1.toString());
       if(listInsPayment.size()>0) {
        	IndInsPayment indInsPayment=new IndInsPayment();
        	indInsPayment.setNo(listInsPayment.get(0).getNo());
        	indInsPayment.setCity(listInsPayment.get(0).getCity());
        	indInsPayment.setType(listInsPayment.get(0).getType());
        	indInsPayment.setRetireMonth(listInsPayment.get(0).getRetireMonth());
        	indInsPayment.setWorkMonth(listInsPayment.get(0).getWorkMonth());
        	indInsPayment.setPayAmount(listInsPayment.get(0).getPayAmount());
        	indInsPayment.setEndReason(listInsPayment.get(0).getEndReason());
        	indInsPayment.setOrgan(listInsPayment.get(0).getOrgan());
        	indInsPayment.setUpdateDate(listInsPayment.get(0).getUpdateDate());
        	list.add(indInsPayment);
        	
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

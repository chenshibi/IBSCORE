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
import resource.bean.basic.IndTelecomPayment;



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
public class IndTelecomPaymentQueryGetter extends BaseGetter {

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
        String yearsMonth="";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndTelecomPayment> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ia from IndTelecomPayment ia where ia.rptId='"+rptId+"' order by ia.no");
        List<IndTelecomPayment> listTelecomPayment = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listTelecomPayment.size(); i++) {
        	yearsMonth="";
        	IndTelecomPayment indTelecomPayment=new IndTelecomPayment();
        	indTelecomPayment.setNo(listTelecomPayment.get(i).getNo());
        	indTelecomPayment.setOrgan(listTelecomPayment.get(i).getOrgan());
        	indTelecomPayment.setType(listTelecomPayment.get(i).getType());
        	indTelecomPayment.setInitDate(listTelecomPayment.get(i).getInitDate());
        	indTelecomPayment.setStatus(listTelecomPayment.get(i).getStatus());
        	indTelecomPayment.setOweAmount(listTelecomPayment.get(i).getOweAmount());
        	indTelecomPayment.setOweMonth(listTelecomPayment.get(i).getOweMonth());
        	indTelecomPayment.setYearmonth(listTelecomPayment.get(i).getYearmonth());
        	String yearMonth=listTelecomPayment.get(i).getMonth24();
        	for (int j = 0; j < yearMonth.length(); j++) {
        		yearsMonth+=yearMonth.substring(j, j+1)+",";
//        		System.out.println(yearsMonth);
			}
//        	System.out.println(yearsMonth.substring(0, yearsMonth.length()-1));
        	indTelecomPayment.setMonth24(yearsMonth.substring(0, yearsMonth.length()-1));
//        	System.out.println(listTelecomPayment.get(i).getMonth24());
        	list.add(indTelecomPayment);
        	
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

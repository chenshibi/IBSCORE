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
import resource.bean.basic.IndDetailInfo;
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
public class IndLonDetailInfoQueryGetter extends BaseGetter {

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
        List<IndLonDetail> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select id from IndLonDetail id where id.rptId='"+rptId+"' order by id.no");
        List<IndLonDetail> listIndDetail = rootdao.queryByCondition(hql1.toString());
        StringBuffer hql2 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='L5CLASS' and id.type='LOAN' order by id.no");
        List<IndDetailInfo> listIndDetailInfo = rootdao.queryByCondition(hql2.toString());
        StringBuffer hql3 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='PAYDAY' and id.type='LOAN' order by id.no");
        List<IndDetailInfo> listIndDetailInfos = rootdao.queryByCondition(hql3.toString());
        if(listIndDetail.size()>0){
        for (int i = 0; i < listIndDetail.size(); i++) 
		{
        	yearsMonth="";
        	IndLonDetail indLonDetail=new IndLonDetail();
        	if(listIndDetailInfo.size()>0){
        			indLonDetail.setL5class(listIndDetailInfo.get(i).getValue());
        	}
        	else{
        		indLonDetail.setL5class("");
        	}
        		indLonDetail.setBalance(listIndDetail.get(i).getBalance());
        		indLonDetail.setLeftMonth(listIndDetail.get(i).getLeftMonth());
        		indLonDetail.setPayMonth(listIndDetail.get(i).getPayMonth());
        	if(listIndDetailInfos.size()>0){
        			indLonDetail.setPayDay(listIndDetailInfos.get(i).getValue());
        		}
        	else{
        		indLonDetail.setPayDay("");
        	}
        	indLonDetail.setPayReal(listIndDetail.get(i).getPayReal());
        	indLonDetail.setRecentPayDate(listIndDetail.get(i).getRecentPayDate());
        	indLonDetail.setOverdueCount(listIndDetail.get(i).getOverdueCount());
        	indLonDetail.setOverdueAmount(listIndDetail.get(i).getOverdueAmount());
        	indLonDetail.setOver31(listIndDetail.get(i).getOver31());
        	indLonDetail.setOver61(listIndDetail.get(i).getOver61());
        	indLonDetail.setOver91(listIndDetail.get(i).getOver91());
        	indLonDetail.setOver180(listIndDetail.get(i).getOver180());
        	String yearMonth=listIndDetail.get(i).getMonth24();
        	for (int j = 0; j < yearMonth.length(); j++) {
        		yearsMonth+=yearMonth.substring(j, j+1)+",";
//        		System.out.println(yearsMonth);
			}
//        	System.out.println(yearsMonth.substring(0, yearsMonth.length()-1));
        	indLonDetail.setMonth24(yearsMonth.substring(0, yearsMonth.length()-1));
        	indLonDetail.setYearmonth(listIndDetail.get(i).getYearmonth());
        	list.add(indLonDetail);
        	
        }
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

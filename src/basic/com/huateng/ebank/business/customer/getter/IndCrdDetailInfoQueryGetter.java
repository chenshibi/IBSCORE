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
import resource.bean.basic.IndCrdDetail;
import resource.bean.basic.IndDetailInfo;


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
public class IndCrdDetailInfoQueryGetter extends BaseGetter {

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
        List<IndCrdDetail> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select id from IndCrdDetail id where id.rptId='"+rptId+"' and cardType='贷记卡' order by id.no");
        List<IndCrdDetail> listIndDetail = rootdao.queryByCondition(hql1.toString());
        StringBuffer hql2 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='AVGUSEDL6M' and id.type='CARD' order by id.no");
        List<IndDetailInfo> listIndDetailInfo = rootdao.queryByCondition(hql2.toString());
        StringBuffer hql3 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='BILLDAY' and id.type='CARD' order by id.no");
        List<IndDetailInfo> listIndDetailInfo1 = rootdao.queryByCondition(hql3.toString());
        if(listIndDetail.size()>0){
        for (int i = 0; i < listIndDetail.size(); i++) 
		{
        	yearsMonth="";
        	IndCrdDetail indCrdDetail=new IndCrdDetail();
        	indCrdDetail.setShare(listIndDetail.get(i).getShare());
        	indCrdDetail.setOverdue(listIndDetail.get(i).getOverdue());
        	if(listIndDetailInfo.size()>0){
        			indCrdDetail.setAvgusedl6m(listIndDetailInfo.get(i).getValue());
        	}
        	else{
        		indCrdDetail.setAvgusedl6m("");
        	}
        	indCrdDetail.setMaxDebit(listIndDetail.get(i).getMaxDebit());
        	indCrdDetail.setPayMonth(listIndDetail.get(i).getPayMonth());
        	if(listIndDetailInfo1.size()>0){
        			indCrdDetail.setBillday(listIndDetailInfo1.get(i).getValue());
        	}
        	else{
        		indCrdDetail.setBillday("");
        	}
        	indCrdDetail.setPayReal(listIndDetail.get(i).getPayReal());
        	indCrdDetail.setRecentDate(listIndDetail.get(i).getRecentDate());
        	indCrdDetail.setOverCount(listIndDetail.get(i).getOverCount());
        	indCrdDetail.setOverAmount(listIndDetail.get(i).getOverAmount());
        	String yearMonth=listIndDetail.get(i).getMonth24();
        	for (int j = 0; j < yearMonth.length(); j++) {
        		yearsMonth+=yearMonth.substring(j, j+1)+",";
//        		System.out.println(yearsMonth);
			}
        	indCrdDetail.setMonth24(yearsMonth.substring(0, yearsMonth.length()-1));
        	indCrdDetail.setYearmonth(listIndDetail.get(i).getYearmonth());
        	list.add(indCrdDetail);
        	
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

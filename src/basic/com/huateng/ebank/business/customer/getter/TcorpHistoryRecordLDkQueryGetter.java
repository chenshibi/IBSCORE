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
import resource.bean.basic.TCorpDetailLoan;
import resource.bean.basic.TCorpHistoryRecord;






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
public class TcorpHistoryRecordLDkQueryGetter extends BaseGetter {

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
        String rptKey = (String) getCommQueryServletRequest().getParameterMap().get("rptKey");
        String historyRecord = (String) getCommQueryServletRequest().getParameterMap().get("historyRecord");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpHistoryRecord> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpHistoryRecord ia where ia.itemName='类贷款' and ia.extensionName='"+historyRecord+"' and ia.rptKey='"+rptKey+"'");
        List<TCorpHistoryRecord> listTcorpHistoryRecord = rootdao.queryByCondition(hql.toString());
       for (int i = 0; i < listTcorpHistoryRecord.size(); i++) {
		{
			if(""!=historyRecord&&"无"!=historyRecord){
        	TCorpHistoryRecord tcorpHistoryRecord=new TCorpHistoryRecord();
        	tcorpHistoryRecord.setCreateDate(listTcorpHistoryRecord.get(i).getCreateDate());
        	tcorpHistoryRecord.setLastBalanceChgDate(listTcorpHistoryRecord.get(i).getLastBalanceChgDate());
        	tcorpHistoryRecord.setBalance(listTcorpHistoryRecord.get(i).getBalance());
        	tcorpHistoryRecord.setFiveLevel(listTcorpHistoryRecord.get(i).getFiveLevel());
        	list.add(tcorpHistoryRecord);
			}
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

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

import resource.bean.basic.TCorpDetailOthers;





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
public class TcorpDetailOthersDkQueryGetter extends BaseGetter {

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
        String funcid6 = (String) getCommQueryServletRequest().getParameterMap().get("funcid6");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpDetailOthers> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpDetailOthers ia where ia.itemName='垫款' and ia.status='未结清' and ia.rptKey='"+rptKey+"'");
        List<TCorpDetailOthers> listTcorpDetailOthers = rootdao.queryByCondition(hql.toString());
       for (int i = 0; i < listTcorpDetailOthers.size(); i++) {
		{
        	 if("6666240206".equals(funcid6)){ 
        	TCorpDetailOthers tcorpDetailOthers=new TCorpDetailOthers();
        	tcorpDetailOthers.setOrgan(listTcorpDetailOthers.get(i).getOrgan());
        	tcorpDetailOthers.setCurrency(listTcorpDetailOthers.get(i).getCurrency());
        	tcorpDetailOthers.setAmount(listTcorpDetailOthers.get(i).getAmount());
        	tcorpDetailOthers.setBalance(listTcorpDetailOthers.get(i).getBalance());
        	tcorpDetailOthers.setInitDate(listTcorpDetailOthers.get(i).getInitDate());
        	tcorpDetailOthers.setFiveLevel(listTcorpDetailOthers.get(i).getFiveLevel());
        	tcorpDetailOthers.setType(listTcorpDetailOthers.get(i).getType());
        	tcorpDetailOthers.setRptKey(listTcorpDetailOthers.get(i).getRptKey());
        	list.add(tcorpDetailOthers);
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

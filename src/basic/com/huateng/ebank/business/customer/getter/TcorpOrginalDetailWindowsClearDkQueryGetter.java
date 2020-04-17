/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import resource.bean.basic.TCorpOrginalDetailWindows;







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
public class TcorpOrginalDetailWindowsClearDkQueryGetter extends BaseGetter {

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
//        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        String type1 = new String(((String) getCommQueryServletRequest().getParameterMap().get("type")).getBytes("ISO-8859-1"),"GBK");
        String type = URLDecoder.decode(type1 , "utf-8");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpOrginalDetailWindows> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpOrginalDetailWindows ia where ia.itemName='"+type+"' and ia.rptKey='"+rptKey+"'");
        List<TCorpOrginalDetailWindows> listTcorpOrginalDetailWindows = rootdao.queryByCondition(hql.toString());
       for (int i = 0; i < listTcorpOrginalDetailWindows.size(); i++) {
			TCorpOrginalDetailWindows tcorpOrginalDetailWindows=new TCorpOrginalDetailWindows();
			tcorpOrginalDetailWindows.setCurrency(listTcorpOrginalDetailWindows.get(i).getCurrency());
			tcorpOrginalDetailWindows.setAmount(listTcorpOrginalDetailWindows.get(i).getAmount());
			tcorpOrginalDetailWindows.setBalance(listTcorpOrginalDetailWindows.get(i).getBalance());
			tcorpOrginalDetailWindows.setOpenDate(listTcorpOrginalDetailWindows.get(i).getOpenDate());
			tcorpOrginalDetailWindows.setExpireDate(listTcorpOrginalDetailWindows.get(i).getExpireDate());
			tcorpOrginalDetailWindows.setBondDate(listTcorpOrginalDetailWindows.get(i).getBondDate());
			tcorpOrginalDetailWindows.setFiveLevel(listTcorpOrginalDetailWindows.get(i).getFiveLevel());
        	list.add(tcorpOrginalDetailWindows);
        	
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

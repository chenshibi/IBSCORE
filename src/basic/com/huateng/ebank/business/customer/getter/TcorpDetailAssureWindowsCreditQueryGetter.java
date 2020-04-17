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

import resource.bean.basic.TCorpDetailAssureWindows;






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
public class TcorpDetailAssureWindowsCreditQueryGetter extends BaseGetter {

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
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        String mainBiz = (String) getCommQueryServletRequest().getParameterMap().get("mainBiz");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpDetailAssureWindows> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select po from TCorpDetailAssureWindows po where po.mainBiz='"+mainBiz+"' and po.rptKey='"+rptKey+"'  ");
        List<TCorpDetailAssureWindows> listTcorpDetailAssureWindows = rootdao.queryByCondition(hql.toString());
        for (int i = 0; i < listTcorpDetailAssureWindows.size(); i++) {
					if("未结清信用证".equals(listTcorpDetailAssureWindows.get(i).getTitle())){
						TCorpDetailAssureWindows tcorpDetailAssureWindows=new TCorpDetailAssureWindows();

						tcorpDetailAssureWindows.setCurrency(listTcorpDetailAssureWindows.get(i).getCurrency());
						tcorpDetailAssureWindows.setAmout(listTcorpDetailAssureWindows.get(i).getAmout());
						tcorpDetailAssureWindows.setReleaseDate(listTcorpDetailAssureWindows.get(i).getReleaseDate());
						tcorpDetailAssureWindows.setCloseDate(listTcorpDetailAssureWindows.get(i).getCloseDate());
						tcorpDetailAssureWindows.setFiveLevel(listTcorpDetailAssureWindows.get(i).getFiveLevel());
						tcorpDetailAssureWindows.setTitle(listTcorpDetailAssureWindows.get(i).getTitle());
						list.add(tcorpDetailAssureWindows);

					}
					
//					tcorpDetailAssureWindows.setCurrency(listTcorpDetailAssureWindows.get(0).getCurrency());
//					tcorpDetailAssureWindows.setAmout(listTcorpDetailAssureWindows.get(0).getAmout());
//					tcorpDetailAssureWindows.setReleaseDate(listTcorpDetailAssureWindows.get(0).getReleaseDate());
//					tcorpDetailAssureWindows.setCloseDate(listTcorpDetailAssureWindows.get(0).getCloseDate());
//					tcorpDetailAssureWindows.setBalance(listTcorpDetailAssureWindows.get(0).getBalance());
//					tcorpDetailAssureWindows.setFiveLevel(listTcorpDetailAssureWindows.get(0).getFiveLevel());
//					tcorpDetailAssureWindows.setAssureStatus(listTcorpDetailAssureWindows.get(0).getAssureStatus());
//		        	list.add(tcorpDetailAssureWindows);
        	
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

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

import resource.bean.basic.TCorpInfoBasic;

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
public class TcorpInfoBasicQueryGetter extends BaseGetter {

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
        String funcid2 = (String) getCommQueryServletRequest().getParameterMap().get("funcid2");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpInfoBasic> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpInfoBasic ia where ia.rptKey='"+rptKey+"'");
        List<TCorpInfoBasic> listTcorpInfoBasic = rootdao.queryByCondition(hql.toString());
        if(listTcorpInfoBasic.size()>0){
        	 if("6666240202".equals(funcid2)){ 
        	TCorpInfoBasic tcorpInfoBasic=new TCorpInfoBasic();
        	tcorpInfoBasic.setName(listTcorpInfoBasic.get(0).getName());
        	tcorpInfoBasic.setAddress(listTcorpInfoBasic.get(0).getAddress());
        	tcorpInfoBasic.setRegOrganNo(listTcorpInfoBasic.get(0).getRegOrganNo());
        	tcorpInfoBasic.setRegOrganCode(listTcorpInfoBasic.get(0).getRegOrganCode());
        	tcorpInfoBasic.setRegDate(listTcorpInfoBasic.get(0).getRegDate());
        	tcorpInfoBasic.setRegEndDate(listTcorpInfoBasic.get(0).getRegEndDate());
        	tcorpInfoBasic.setRegStateTaxNo(listTcorpInfoBasic.get(0).getRegStateTaxNo());
        	tcorpInfoBasic.setRegLocalTaxNo(listTcorpInfoBasic.get(0).getRegLocalTaxNo());
        	tcorpInfoBasic.setLoancardId(listTcorpInfoBasic.get(0).getLoancardId());
        	tcorpInfoBasic.setRegOrganType(listTcorpInfoBasic.get(0).getRegOrganType());
        	
        	list.add(tcorpInfoBasic);
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

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

import resource.bean.basic.CorpCust;
import resource.bean.basic.InqCust;
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
public class CorpCustQueryGetter extends BaseGetter {

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
        String corpCustType = (String) getCommQueryServletRequest().getParameterMap().get("corpCustType");
        String relName1 = new String(((String) getCommQueryServletRequest().getParameterMap().get("relName")).getBytes("ISO-8859-1"),"GBK");
        String relName = URLDecoder.decode(relName1 , "utf-8");
        String relCorpId = (String) getCommQueryServletRequest().getParameterMap().get("relCorpId");
        String funcid1 = (String) getCommQueryServletRequest().getParameterMap().get("funcid1");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CorpCust> list = new ArrayList(); 
        	 if("6666240201".equals(funcid1)){ 
        	if("2".equals(corpCustType)){
        	CorpCust corpcust=new CorpCust();
        	corpcust.setRelName(relName);
        	corpcust.setRelCorpId(relCorpId);
        	list.add(corpcust);
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

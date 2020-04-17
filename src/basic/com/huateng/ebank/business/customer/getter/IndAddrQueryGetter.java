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

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.IndAddr;


/**
 * @author 
 *
 */
public class IndAddrQueryGetter extends BaseGetter {

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
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        PageQueryResult pageQueryResult = new PageQueryResult();
        String addressreplace="";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndAddr> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ia from IndAddr ia where ia.rptId='"+rptId+"' order by ia.number");
        List<IndAddr> listAddr = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listAddr.size(); i++) {
        	addressreplace="";
        	IndAddr indAddr=new IndAddr();
        	indAddr.setNumber(listAddr.get(i).getNumber());
        	
        	if("1".equals(type)){
        		if(listAddr.get(i).getAddress().length()>2){
        		String addressfirst=listAddr.get(i).getAddress().substring(0, 2);
            	String address=listAddr.get(i).getAddress().substring(2,listAddr.get(i).getAddress().length());
        		for (int j = 0; j < address.length(); j++) {
            		addressreplace+="*";
    			}
        		indAddr.setAddress(addressfirst+addressreplace);
        		}
        		else{
        			indAddr.setAddress(listAddr.get(i).getAddress());
        		}
        	}
        	if("2".equals(type)){
        	indAddr.setAddress(listAddr.get(i).getAddress());
        	}
        	indAddr.setStatus(listAddr.get(i).getStatus());
        	if(null != listAddr.get(i).getGetDate()){
        		//SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-DD");
        		indAddr.setGetDate(listAddr.get(i).getGetDate());
        		
        	}
        	
        	list.add(indAddr);
        	
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

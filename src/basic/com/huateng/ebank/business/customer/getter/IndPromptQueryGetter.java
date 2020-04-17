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
import resource.bean.basic.IndPrompt;


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
public class IndPromptQueryGetter extends BaseGetter {

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
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndPrompt> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ip from IndPrompt ip where ip.rptId='"+rptId+"'");
        List<IndPrompt> listIndPrompt = rootdao.queryByCondition(hql1.toString());
        if(listIndPrompt.size()>0){
        	IndPrompt indPrompt=new IndPrompt();
        	indPrompt.setPersonHouseLoan(listIndPrompt.get(0).getPersonHouseLoan());
        	indPrompt.setPersonBizHouseLoan(listIndPrompt.get(0).getPersonBizHouseLoan());
        	indPrompt.setOtherLoan(listIndPrompt.get(0).getOtherLoan());
        	indPrompt.setFirstLoanIssueDate(listIndPrompt.get(0).getFirstLoanIssueDate());
        	indPrompt.setCrdAccount(listIndPrompt.get(0).getCrdAccount());
        	indPrompt.setFirstCcIssueDate(listIndPrompt.get(0).getFirstCcIssueDate());
        	indPrompt.setPdcAccount(listIndPrompt.get(0).getPdcAccount());
        	System.out.println(listIndPrompt.get(0).getFirstPdcIssueDate());
        	if("1900-01-01 00:00:00.0".equals(listIndPrompt.get(0).getFirstPdcIssueDate().toString())){
        		indPrompt.setFirstPdcIssueDate(null);
        	}
        	else{
        		indPrompt.setFirstPdcIssueDate(listIndPrompt.get(0).getFirstPdcIssueDate());
        	}
        	indPrompt.setSelfStatementCount(listIndPrompt.get(0).getSelfStatementCount());
        	indPrompt.setDissentCount(listIndPrompt.get(0).getDissentCount());
        	list.add(indPrompt);
        	
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

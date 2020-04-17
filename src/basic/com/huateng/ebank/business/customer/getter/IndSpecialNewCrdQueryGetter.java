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
import resource.bean.basic.IndSpecialNew;

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
public class IndSpecialNewCrdQueryGetter extends BaseGetter {

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
        List<IndSpecialNew> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select id from IndSpecialNew id where id.rptId='"+rptId+"' and accType='CARD' order by id.no");
        List<IndSpecialNew> listIndSpecial = rootdao.queryByCondition(hql1.toString());
        StringBuffer hql2 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='ORGDESC' and id.type='CARD' order by id.no");
        List<IndDetailInfo> listIndDetailInfo = rootdao.queryByCondition(hql2.toString());
        StringBuffer hql3 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='SELFSTATEMENT' and id.type='CARD' order by id.no");
        List<IndDetailInfo> listIndDetailInfo1 = rootdao.queryByCondition(hql3.toString());
        StringBuffer hql4 = new StringBuffer("select id from IndDetailInfo id where id.rptId='"+rptId+"' and id.code='DISSENT’' and id.type='CARD' order by id.no");
        List<IndDetailInfo> listIndDetailInfo2 = rootdao.queryByCondition(hql4.toString());
        for (int i = 0; i < listIndSpecial.size(); i++) 
		{
        	IndSpecialNew indSpecialNew=new IndSpecialNew();
        	indSpecialNew.setType(listIndSpecial.get(i).getType());
        	indSpecialNew.setDate(listIndSpecial.get(i).getDate());
        	indSpecialNew.setChangeMonth(listIndSpecial.get(i).getChangeMonth());
        	indSpecialNew.setAmount(listIndSpecial.get(i).getAmount());
        	indSpecialNew.setDetails(listIndSpecial.get(i).getDetails());
        	if(listIndDetailInfo.size()>0){
        			indSpecialNew.setLoanOrgDesc(listIndDetailInfo.get(i).getValue());
        			indSpecialNew.setOrgdate(listIndDetailInfo.get(i).getValue());
        	}
        	else{
        		indSpecialNew.setLoanOrgDesc("");
    			indSpecialNew.setOrgdate("");
        	}
        	if(listIndDetailInfo1.size()>0){
        			indSpecialNew.setInDeclare(listIndDetailInfo1.get(i).getValue());
        			indSpecialNew.setDeclareDate(listIndDetailInfo1.get(i).getValue());
        	}
        	else{
        		indSpecialNew.setInDeclare("");
    			indSpecialNew.setDeclareDate("");
        	}
        	if(listIndDetailInfo2.size()>0){
        			indSpecialNew.setObjectTag(listIndDetailInfo2.get(i).getValue());
        			indSpecialNew.setTagDate(listIndDetailInfo2.get(i).getValue());
        	}
        	else{
        		indSpecialNew.setObjectTag("");
    			indSpecialNew.setTagDate("");
        	}
        	list.add(indSpecialNew);
        	
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

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

import com.huateng.common.DateUtil;
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

import resource.bean.basic.TCorpPermit;

/**
 * @author zhiguo.zhao
 *
 */
public class TCorpPermitGetter extends BaseGetter {

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
    	
        String loanCardNo = (String) getCommQueryServletRequest().getParameterMap().get("qloanCardNo");
        String corpName = (String) getCommQueryServletRequest().getParameterMap().get("qcorpName");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpPermit> list = new ArrayList<TCorpPermit>(); 
        StringBuffer hql = new StringBuffer("select po from TCorpPermit po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(loanCardNo)) {
            hql.append(" and po.loanCardNo= ? ");
            condList.add(loanCardNo);
        }
        if (!DataFormat.isEmpty(corpName)) {
            hql.append(" and po.corpName = ? ");
            condList.add(corpName);
        }
        List<TCorpPermit> listApp =  rootdao.queryByCondition(hql.toString(), condList.toArray());
        for (int i = 0; i < listApp.size(); i++) {
        	TCorpPermit tcApp = new TCorpPermit();
        	tcApp.setId(listApp.get(i).getId());
             tcApp.setLoanCardNo(listApp.get(i).getLoanCardNo());
             tcApp.setLoanCardPass(listApp.get(i).getLoanCardPass());
             tcApp.setEnterpriseRegId(listApp.get(i).getEnterpriseRegId());
             tcApp.setCorpName(listApp.get(i).getCorpName());
             String customerConUp=listApp.get(i).getCustomerConUp().trim();
             tcApp.setCustomerConUp2(customerConUp);
             tcApp.setCustomerConUp(customerConUp.substring(customerConUp.lastIndexOf("/")+1));

             tcApp.setCreateUser(listApp.get(i).getCreateUser());
             tcApp.setInputTime(listApp.get(i).getInputTime());
             tcApp.setExpireDate(listApp.get(i).getExpireDate());
             tcApp.setApproveTime(listApp.get(i).getApproveTime());
             tcApp.setStatus(listApp.get(i).getStatus());
             list.add(tcApp);
		}
        /**
        while (it.hasNext()) {
            Map map = (Map) it.next();
            TCorpApp tcApp = new TCorpApp();
            tcApp.setLoanCardNo((String) map.get("Loan_Card_No"));
            tcApp.setLoanCardPass((String) map.get("loan_Card_Pass"));
            tcApp.setEnterpriseRegId((String) map.get("enterprise_Reg_Id"));
            tcApp.setCorpName((String) map.get("corp_Name"));
            tcApp.setCustomerConUp((String) map.get("customer_Con_Up"));
            tcApp.setExpireDate((String) map.get("expire_Date"));
            list.add(tcApp);
        }
        */
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List rs = new ArrayList();
        rs = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(rs);
        return pageQueryResult;
    }
}

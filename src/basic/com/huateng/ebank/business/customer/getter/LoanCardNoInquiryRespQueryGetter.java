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
import java.util.Date;
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

import resource.bean.basic.TCorpLoancardInq;
import resource.bean.basic.TCorpLoancardResp;
import resource.bean.basic.TCorpPermit;

/**
 * @author zhiguo.zhao
 *
 */
public class LoanCardNoInquiryRespQueryGetter extends BaseGetter {

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
    	
        String qid =   (String) getCommQueryServletRequest().getParameterMap().get("id");
        
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpLoancardResp> list = new ArrayList<TCorpLoancardResp>(); 
        StringBuffer hql = new StringBuffer("select po from TCorpLoancardResp po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
            hql.append(" and po.inqId = '"+qid+"'");
        List<TCorpLoancardResp> listResp =  rootdao.queryByCondition(hql.toString());
        
        	if(null != listResp && listResp.size()>0){
        		 for (int i = 0; i < listResp.size(); i++) {
        	        	TCorpLoancardResp tcorpLoancardResp = new TCorpLoancardResp();
        	        	tcorpLoancardResp.setInqId(listResp.get(i).getInqId());
        	        	tcorpLoancardResp.setChnName(listResp.get(i).getChnName());
        	        	tcorpLoancardResp.setFullName(listResp.get(i).getFullName());
        	        	tcorpLoancardResp.setEngName(listResp.get(i).getEngName());
        	        	tcorpLoancardResp.setOrgCreditCode(listResp.get(i).getOrgCreditCode());
        	        	tcorpLoancardResp.setCountryTaxCode(listResp.get(i).getCountryTaxCode());
        	        	tcorpLoancardResp.setLoancardno(listResp.get(i).getLoancardno());
        	        	tcorpLoancardResp.setRegionTaxCode(listResp.get(i).getRegionTaxCode());
        	        	tcorpLoancardResp.setRegistCodeType(listResp.get(i).getRegistCodeType());
        	        	tcorpLoancardResp.setRegistCode(listResp.get(i).getRegistCode());
        	        	tcorpLoancardResp.setOrgCode(listResp.get(i).getOrgCode());
        	        	tcorpLoancardResp.setReturnTime(listResp.get(i).getReturnTime());
        	            list.add(tcorpLoancardResp);
        	            
        	           
        	         

        			}
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

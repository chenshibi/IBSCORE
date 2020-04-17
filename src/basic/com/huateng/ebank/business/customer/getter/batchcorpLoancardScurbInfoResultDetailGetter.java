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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.CorpLoancardScurbInfo;
import resource.bean.basic.IndScrubInfo;

/**
 * @author zhiguo.zhao
 *
 */
@SuppressWarnings("unchecked")
public class batchcorpLoancardScurbInfoResultDetailGetter extends BaseGetter {

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
    	
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String batchId = (String) getCommQueryServletRequest().getParameterMap().get("batchId");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<CorpLoancardScurbInfo> list = new ArrayList<CorpLoancardScurbInfo>(); 
        StringBuffer hql = new StringBuffer("select isi from CorpLoancardScurbInfo isi where 1=1 ");
        hql.append(" and isi.batchId = '"+batchId+"' ");
        StringBuffer hqlquery = new StringBuffer("select count(status) as query from CorpLoancardScurbInfo  where  status='0' and batchId='"+batchId+"'");
        StringBuffer hqlcheckNoPass = new StringBuffer("select count(status) from CorpLoancardScurbInfo isi where status='1' and batchId='"+batchId+"'");
        StringBuffer hqlquerySuccess = new StringBuffer("select count(status)  from CorpLoancardScurbInfo isi where status='2'  and batchId='"+batchId+"'");
        StringBuffer hqlqueryDefeat = new StringBuffer("select count(status)  from CorpLoancardScurbInfo isi where status='3' and batchId='"+batchId+"'");
        @SuppressWarnings("unchecked")
        List<CorpLoancardScurbInfo> listCorpLoancardScurbInfo = rootdao.queryByCondition(hql.toString());
        Long queryCount=  (Long) rootdao.queryByCondition(hqlquery.toString()).get(0);
        Long querycheckNoPassCount=  (Long) rootdao.queryByCondition(hqlcheckNoPass.toString()).get(0); 
        Long querySuccessCount=  (Long) rootdao.queryByCondition(hqlquerySuccess.toString()).get(0); 
        Long queryDefeatCount=  (Long) rootdao.queryByCondition(hqlqueryDefeat.toString()).get(0); 
       
     	if(null != listCorpLoancardScurbInfo && listCorpLoancardScurbInfo.size()>0){
    		 for (int i = 0; i < listCorpLoancardScurbInfo.size(); i++) {
    			 CorpLoancardScurbInfo corpLoancardScurbInfo = new CorpLoancardScurbInfo();
    			 corpLoancardScurbInfo.setAppId(listCorpLoancardScurbInfo.get(i).getAppId());
    			 corpLoancardScurbInfo.setBatchId(listCorpLoancardScurbInfo.get(i).getBatchId());
    			 corpLoancardScurbInfo.setCreateUser(listCorpLoancardScurbInfo.get(i).getCreateUser());
    			 corpLoancardScurbInfo.setInputTime(listCorpLoancardScurbInfo.get(i).getInputTime());
    			 corpLoancardScurbInfo.setReturnTime(listCorpLoancardScurbInfo.get(i).getReturnTime());
    			 corpLoancardScurbInfo.setInquiryType(listCorpLoancardScurbInfo.get(i).getInquiryType());
    			 corpLoancardScurbInfo.setInquiryValue(listCorpLoancardScurbInfo.get(i).getInquiryValue());
    			 corpLoancardScurbInfo.setStatus(listCorpLoancardScurbInfo.get(i).getStatus());
    			 corpLoancardScurbInfo.setQuerySuccess(querySuccessCount);
    			 corpLoancardScurbInfo.setQuery(queryCount);
    			 corpLoancardScurbInfo.setQueryDefeat(queryDefeatCount);
    			 corpLoancardScurbInfo.setCheckNoPass(querycheckNoPassCount);
	        	 list.add(corpLoancardScurbInfo);
			}
     	}
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

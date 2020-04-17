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

import resource.bean.basic.TCorpSocialPayRecord;








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
public class TcorpSocialPayRecordCauseQueryGetter extends BaseGetter {

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
        String funcid7 = (String) getCommQueryServletRequest().getParameterMap().get("funcid7");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpSocialPayRecord> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpSocialPayRecord ia where ia.itemName='公用事业缴费记录' and ia.rptKey='"+rptKey+"'");
        List<TCorpSocialPayRecord> listTcorpSocialPayRecord = rootdao.queryByCondition(hql.toString());
    	   for (int i = 0; i < listTcorpSocialPayRecord.size(); i++) {
        	 if("6666240207".equals(funcid7)){ 
        	TCorpSocialPayRecord tcorpSocialPayRecord=new TCorpSocialPayRecord();
        	tcorpSocialPayRecord.setOrgan(listTcorpSocialPayRecord.get(i).getOrgan());
        	tcorpSocialPayRecord.setInfotype(listTcorpSocialPayRecord.get(i).getInfotype());
        	tcorpSocialPayRecord.setSumYm(listTcorpSocialPayRecord.get(i).getSumYm());
        	tcorpSocialPayRecord.setPayStatus(listTcorpSocialPayRecord.get(i).getPayStatus());
        	tcorpSocialPayRecord.setLastPayDate(listTcorpSocialPayRecord.get(i).getLastPayDate());
        	tcorpSocialPayRecord.setSumOwnAmt(listTcorpSocialPayRecord.get(i).getSumOwnAmt());
        	tcorpSocialPayRecord.setHighestOwnDate(listTcorpSocialPayRecord.get(i).getHighestOwnDate());
        	tcorpSocialPayRecord.setHighestOwnAmt(listTcorpSocialPayRecord.get(i).getHighestOwnAmt());
        	tcorpSocialPayRecord.setRptKey(listTcorpSocialPayRecord.get(i).getRptKey());
        	list.add(tcorpSocialPayRecord);
        	
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

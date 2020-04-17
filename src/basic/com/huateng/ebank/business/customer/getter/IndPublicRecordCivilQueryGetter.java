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
import resource.bean.basic.IndPublicRecord;



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
public class IndPublicRecordCivilQueryGetter extends BaseGetter {

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
        List<IndPublicRecord> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ia from IndPublicRecord ia where ia.recordType='强制执行记录' and ia.rptId='"+rptId+"' order by ia.no");
        List<IndPublicRecord> listPublicRecord = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listPublicRecord.size(); i++) {
        	IndPublicRecord indPublicRecord=new IndPublicRecord();
        	indPublicRecord.setNo(listPublicRecord.get(i).getNo());
        	indPublicRecord.setOrgan(listPublicRecord.get(i).getOrgan());
        	indPublicRecord.setReason(listPublicRecord.get(i).getReason());
        	indPublicRecord.setInitDate(listPublicRecord.get(i).getInitDate());
        	indPublicRecord.setType(listPublicRecord.get(i).getType());
        	indPublicRecord.setResult(listPublicRecord.get(i).getResult());
        	indPublicRecord.setEndDate(listPublicRecord.get(i).getEndDate());
        	indPublicRecord.setSubjectName(listPublicRecord.get(i).getSubjectName());
        	indPublicRecord.setSubjectAmount(listPublicRecord.get(i).getSubjectAmount());
        	list.add(indPublicRecord);
        	
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

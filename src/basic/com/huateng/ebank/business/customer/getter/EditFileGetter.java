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

import resource.bean.basic.FileSubmit;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
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
public class EditFileGetter extends BaseGetter {

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
        String qid = (String) getCommQueryServletRequest().getParameterMap().get("qid");
        PageQueryResult pageQueryResult = new PageQueryResult();
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<FileSubmit> list = new ArrayList(); 
        List<FileSubmit> listApp=new ArrayList();
        StringBuffer hql = new StringBuffer("select po from FileSubmit po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(qid)) {
        	hql.append(" and po.id = '"+qid+"' ");
        }
        hql.append(" order by po.id ");
        list = rootdao.queryByCondition(hql.toString(),condList.toArray());
        
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(list);
        return pageQueryResult;
    }
}

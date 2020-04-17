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
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.FileSubmit;

/**
 * 
 * @author Grassy
 *
 */
public class FileGroupUploadGetter extends BaseGetter {

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
        String department = (String) getCommQueryServletRequest().getParameterMap().get("department");
     //   String status = (String) getCommQueryServletRequest().getParameterMap().get("status");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<FileSubmit> list = new ArrayList<FileSubmit>(); 
        StringBuffer hql = new StringBuffer("select po from FileSubmit po where 1=1 and status='1' ");
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(department)) {
        	hql.append(" and po.department = ?");
        	condList.add(department);
        }
 /*       if (!DataFormat.isEmpty(status)) {
        	if(status.equals("0")){
        		hql.append(" and po.flag = ?");
            	condList.add(status);
        	
        	}else if(status.equals("1")){
        		hql.append(" and po.flag = ?");
            	condList.add(status);
        	}
        }*/
        hql.append(" order by po.department desc ");
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

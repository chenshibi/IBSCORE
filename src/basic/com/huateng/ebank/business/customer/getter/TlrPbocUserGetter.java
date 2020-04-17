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

import resource.bean.basic.TlrPbocUser;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author 
 *
 */
public class TlrPbocUserGetter extends BaseGetter {

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
        String userNo = (String) getCommQueryServletRequest().getParameterMap().get("userNo");
        String userType = (String) getCommQueryServletRequest().getParameterMap().get("userType");
        String statusPswd = (String) getCommQueryServletRequest().getParameterMap().get("statusPswd");
        PageQueryResult pageQueryResult = new PageQueryResult();
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TlrPbocUser> list = new ArrayList(); 
        List<TlrPbocUser> listTlrPbocUser=new ArrayList();
        StringBuffer hql = new StringBuffer("select po from TlrPbocUser po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
       if (!DataFormat.isEmpty(userNo)) {
            hql.append(" and po.userNo = ?");
            condList.add(userNo);
        }
        if (!DataFormat.isEmpty(userType)) {
        	hql.append(" and po.userType = ?");
        	condList.add(userType);
        }
        if (!DataFormat.isEmpty(statusPswd)) {
        	hql.append(" and po.statusPswd = ?");
        	condList.add(statusPswd);
        }
        hql.append(" order by po.id ");
        list = rootdao.queryByCondition(hql.toString(),condList.toArray());
        if(list != null && list.size()>0){
        for (int i = 0; i < list.size(); i++) {
        	TlrPbocUser tlrPbocUser=new TlrPbocUser();
        	tlrPbocUser.setId(list.get(i).getId());
        	tlrPbocUser.setUserNo(list.get(i).getUserNo());
        	tlrPbocUser.setUserPswdNow(list.get(i).getUserPswdNow());
        	tlrPbocUser.setUserPswdOld(list.get(i).getUserPswdOld());
        	tlrPbocUser.setUserType(list.get(i).getUserType());
        	tlrPbocUser.setStatusPswd(list.get(i).getStatusPswd());
        	tlrPbocUser.setLastUpdateTime(list.get(i).getLastUpdateTime());
        	tlrPbocUser.setUpdateTlrInfo(list.get(i).getUpdateTlrInfo());
        	
        	listTlrPbocUser.add(tlrPbocUser);
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
        pageQueryResult.setTotalCount(listTlrPbocUser.size());
        pageQueryResult.setQueryResult(listTlrPbocUser);
        return pageQueryResult;
    }
}

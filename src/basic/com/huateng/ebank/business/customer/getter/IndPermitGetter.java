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

import resource.bean.basic.IndPermit;

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
public class IndPermitGetter extends BaseGetter {

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
        String individualId = (String) getCommQueryServletRequest().getParameterMap().get("qindividualId");
        String name = (String) getCommQueryServletRequest().getParameterMap().get("qname");
        String idType = (String) getCommQueryServletRequest().getParameterMap().get("qidType");
        PageQueryResult pageQueryResult = new PageQueryResult();
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndPermit> list = new ArrayList(); 
        List<IndPermit> listApp=new ArrayList();
        StringBuffer hql = new StringBuffer("select po from IndPermit po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(individualId)) {
            hql.append(" and po.individualId = ?");
            condList.add(individualId);
        }
        if (!DataFormat.isEmpty(name)) {
        	hql.append(" and po.name = ?");
        	condList.add(name);
        }
        if (!DataFormat.isEmpty(idType)) {
        	hql.append(" and po.idType = ?");
        	condList.add(idType);
        }
        hql.append(" order by po.id ");
        list = rootdao.queryByCondition(hql.toString(),condList.toArray());
        if(list != null && list.size()>0){
        for (int i = 0; i < list.size(); i++) {
        	IndPermit indPermit=new IndPermit();
        	indPermit.setId(list.get(i).getId());
        	indPermit.setIndividualId(list.get(i).getIndividualId());
        	indPermit.setName(list.get(i).getName());
        	indPermit.setIdType(list.get(i).getIdType());
        	String customerConUp=list.get(i).getCustomerConUp().trim();
        	indPermit.setCustomerConUp2(customerConUp);
        	indPermit.setCustomerConUp(customerConUp.substring(customerConUp.lastIndexOf("/")+1));
    
        	indPermit.setCreateUser(list.get(i).getCreateUser());
        	indPermit.setInputTime(list.get(i).getInputTime());
        	indPermit.setExpireDate(list.get(i).getExpireDate());
        	
        	
        	indPermit.setStatus(list.get(i).getStatus());
        	indPermit.setApproveTime(list.get(i).getApproveTime());
            listApp.add(indPermit);
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
      //  rs = listApp.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(listApp.size());
        pageQueryResult.setQueryResult(listApp);
        return pageQueryResult;
    }
}

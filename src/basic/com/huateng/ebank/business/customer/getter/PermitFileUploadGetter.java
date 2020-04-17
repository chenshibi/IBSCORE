/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import resource.bean.basic.FileSubmit;
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
public class PermitFileUploadGetter extends BaseGetter {

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
        String qfileName = (String) getCommQueryServletRequest().getParameterMap().get("qfileName");
        String qsgement = (String) getCommQueryServletRequest().getParameterMap().get("qsgement");
        String qproduct = (String) getCommQueryServletRequest().getParameterMap().get("qproduct");
        String qscope = (String) getCommQueryServletRequest().getParameterMap().get("qscope");
        String qflag = (String) getCommQueryServletRequest().getParameterMap().get("qflag");
        PageQueryResult pageQueryResult = new PageQueryResult();
        GlobalInfo globalinfo=GlobalInfo.getCurrentInstance();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowday = sdf.format(date);
        List<FileSubmit> list = new ArrayList(); 
        List<FileSubmit> listApp=new ArrayList();
        StringBuffer hql = new StringBuffer("select po from FileSubmit po where 1=1 ");
        ArrayList<String> condList = new ArrayList<String>();
        if (!DataFormat.isEmpty(qfileName)) {
        	hql.append(" and po.fileName like '%"+qfileName+"%' ");
        }
        if (!DataFormat.isEmpty(qsgement)) {
        	hql.append(" and po.sgement = ?");
        	condList.add(qsgement);
        }
        if (!DataFormat.isEmpty(qproduct)) {
        	hql.append(" and po.product = ?");
        	condList.add(qproduct);
        }
        if (!DataFormat.isEmpty(qscope)) {
        	hql.append(" and po.scope = ?");
        	condList.add(qscope);
        }
        if (!DataFormat.isEmpty(qflag)) {
        	if(qflag.equals("0")){
        		hql.append(" and po.flag = ?");
            	condList.add(qflag);
        		hql.append(" and ( po.expireDate = ?");
            	condList.add("");
            	hql.append(" or po.expireDate > ? )");
            	condList.add(nowday);
        	}else if(qflag.equals("1")){
        		hql.append(" and (po.flag = ?");
            	condList.add(qflag);
        		hql.append(" or (po.expireDate <= ? )");
            	condList.add(nowday);
            	hql.append(" and  po.expireDate <> ? ))");
            	condList.add("");
        	}
        }
        hql.append(" order by po.id ");
        list = rootdao.queryByCondition(hql.toString(),condList.toArray());
//        if(list != null && list.size()>0){
//        for (int i = 0; i < list.size(); i++) {
//        	FileSubmit fileSubmit=new FileSubmit();
//        	fileSubmit.setId(list.get(i).getId());
//        	fileSubmit.setIndividualId(list.get(i).getIndividualId());
//        	fileSubmit.setName(list.get(i).getName());
//        	fileSubmit.setIdType(list.get(i).getIdType());
//        	String customerConUp=list.get(i).getCustomerConUp().trim();
//        	fileSubmit.setCustomerConUp(customerConUp.substring(customerConUp.lastIndexOf("/")+1));
//    
//        	fileSubmit.setCreateUser(list.get(i).getCreateUser());
//        	fileSubmit.setInputTime(list.get(i).getInputTime());
//        	fileSubmit.setExpireDate(list.get(i).getExpireDate());
//        	
//        	
//        	fileSubmit.setStatus(list.get(i).getStatus());
//            listApp.add(fileSubmit);
//        }
//        }
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

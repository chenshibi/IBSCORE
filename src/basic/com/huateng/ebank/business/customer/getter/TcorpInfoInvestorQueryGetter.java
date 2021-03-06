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

import org.apache.bsf.Main;

import resource.bean.basic.TCorpInfoInvestor;


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
public class TcorpInfoInvestorQueryGetter extends BaseGetter {

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
        String funcid3 = (String) getCommQueryServletRequest().getParameterMap().get("funcid3");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<TCorpInfoInvestor> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from TCorpInfoInvestor ia where ia.rptKey='"+rptKey+"'");
        List<TCorpInfoInvestor> listTcorpInfoInvestor = rootdao.queryByCondition(hql.toString());
        for (int i = 0; i < listTcorpInfoInvestor.size(); i++) {
		{
        	 if("6666240203".equals(funcid3)){ 
        	TCorpInfoInvestor tcorpInfoInvestor=new TCorpInfoInvestor();
        	tcorpInfoInvestor.setName(replaceInformation(listTcorpInfoInvestor.get(i).getName()));
        	tcorpInfoInvestor.setIdType(listTcorpInfoInvestor.get(i).getIdType());
        	tcorpInfoInvestor.setIdNumber(replaceIdCrad(listTcorpInfoInvestor.get(i).getIdNumber()));
        	tcorpInfoInvestor.setAmount(listTcorpInfoInvestor.get(i).getAmount());
        	tcorpInfoInvestor.setProportion(listTcorpInfoInvestor.get(i).getProportion());
        	list.add(tcorpInfoInvestor);
        	 }
        	
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
    
    /**
	 * 将证件号中间部分替换成*            
	 * @param num
	 * @return
	  */
	public static String replaceIdCrad(String num){
		String sbf=new String();
		if(null != num && num.length()>=3){
			 sbf=num.substring(0,3);
			 for (int i = 3; i < num.length()-3; i++) {
			    sbf+="*";
			 }
			 if(num.length()>3){
			 sbf+=num.substring(num.length()-3,num.length());
			 }
			 return sbf;
		}
		return num;
	}
	/**
	 * 将部分信息替换成*
	 * @param Information
	 * @return
	 */
	public static String replaceInformation(String Information){
		String sbf=new String();
		if(null != Information && Information.length()>=1){
			sbf=Information.substring(0,1);
			for (int i = 1; i < Information.length(); i++) {
				sbf+="*";
			}
			return sbf;
		}
		return Information;
	}
	
	public static void main(String[] args) {
		String a="000";
		System.out.println(replaceIdCrad(a));
	}
	
}

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import resource.bean.basic.InqCust;
import resource.bean.basic.TCorpInfoBasic;

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
public class InqCustGlinfoQueryGetter extends BaseGetter {

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
        String corpCustType = (String) getCommQueryServletRequest().getParameterMap().get("corpCustType");
        String Id = getCommQueryServletRequest().getParameterMap().get("Id").toString();
//        String corpCustLoancard = (String) getCommQueryServletRequest().getParameterMap().get("corpCustLoancard");
//        String corpCustCompanyname1 = new String(((String) getCommQueryServletRequest().getParameterMap().get("corpCustCompanyname")).getBytes("ISO-8859-1"),"GBK");
//        String corpCustCompanyname = URLDecoder.decode(corpCustCompanyname1 , "utf-8");
        String funcid1 = (String) getCommQueryServletRequest().getParameterMap().get("funcid1");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<InqCust> list = new ArrayList(); 
        StringBuffer hql = new StringBuffer("select ia from InqCust ia where ia.custId='"+Id+"' and ia.inqCustType='1'");
        List<InqCust> listInqcust = rootdao.queryByCondition(hql.toString());
        for (int i = 0; i < listInqcust.size(); i++) {
			
        	 if("6666240201".equals(funcid1)){ 
        	if("1".equals(corpCustType)){
        	InqCust inqcust=new InqCust();
        	inqcust.setInqCustName(replaceInformation(listInqcust.get(i).getInqCustName()));
        	inqcust.setInqCustId(replaceIdCrad(listInqcust.get(i).getInqCustId()));
        	inqcust.setInqCustIdType(listInqcust.get(i).getInqCustIdType());
        	list.add(inqcust);
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
   			 sbf+=num.substring(0,3);
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
    
}

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
import resource.bean.basic.IndInfo;

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
public class IndAppQueryGetter extends BaseGetter {

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
    /**
	 * 将证件号中间部分替换成*            
	 * @param num
	 * @return
	  */
	public static StringBuffer replaceIdCrad(String num){
		StringBuffer sbf=new StringBuffer();
		if(null != num && num.length()>=3){
			 sbf.append(num.substring(0,3));
			 for (int i = 3; i < num.length()-3; i++) {
			    sbf.append(num.replaceAll(num, "*"));
			 }
			 if(num.length()>3){
			 sbf.append(num.substring(num.length()-3,num.length()));
			 }
			 return sbf;
		}
		return sbf.append(num);
	}
	
	/**
	 * 将部分信息全部替换成*
	 * @param Information
	 * @return
	 */
	public static StringBuffer replaceAllInformation(String Information){
		StringBuffer sbf=new StringBuffer();
		if(null != Information){
			for (int i = 0; i < Information.length(); i++) {
				sbf.append(Information.replaceAll(Information, "*"));
			}
			return sbf;  
		}
		return sbf.append(Information);
	}

    @SuppressWarnings("unchecked")
	protected PageQueryResult getData() throws Exception {
    	String rptId=(String) getCommQueryServletRequest().getParameterMap().get("rptId");
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        PageQueryResult pageQueryResult = new PageQueryResult();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndApp> list = new ArrayList(); 
        String replace="";
        String indreplace="";
        StringBuffer hql = new StringBuffer("select ia from IndApp ia where ia.rptId='"+rptId+"'");
        List<IndApp> listApp = rootdao.queryByCondition(hql.toString());
        if(listApp.size()>0){
        	IndApp indApp=new IndApp();
        	indApp.setRptId(listApp.get(0).getRptId());
        	indApp.setReturnTime(listApp.get(0).getReturnTime());
//        	if("1".equals(type)){
//        		if(listApp.get(0).getName().length()>1){
////        		String namefirst=listApp.get(0).getName().substring(0, 1);
////            	String name=listApp.get(0).getName().substring(1, listApp.get(0).getName().length());
////            	for (int i = 0; i < name.length(); i++) {
////    				replace+="*";
////    			}
////            	indApp.setName(namefirst+replace);
//            	indApp.setName(replaceAllInformation(listApp.get(0).getName()).toString());
//        		}
//        		else{
//        			indApp.setName(listApp.get(0).getName());
//        		}
//        	}
        	if("2".equals(type)){
        		if(null != listApp.get(0).getName()){
        			indApp.setName(replaceAllInformation(listApp.get(0).getName()).toString());
//            		indApp.setName(listApp.get(0).getName());
        		}
        	
        	}
        	indApp.setIdType(listApp.get(0).getIdType());
        	
//        	if("1".equals(type)){
//        		if(listApp.get(0).getIndividualId().length()>1){
////        		String indfirst=listApp.get(0).getIndividualId().substring(0, 1);
////            	String indmiddle=listApp.get(0).getIndividualId().substring(1, listApp.get(0).getIndividualId().length()-1);
////            	for (int i = 0; i < indmiddle.length(); i++) {
////            		indreplace+="*";
////    			}
////            	String indlast=listApp.get(0).getIndividualId().substring(listApp.get(0).getIndividualId().length()-1, listApp.get(0).getIndividualId().length());
////        		System.out.println(indfirst+indreplace+indlast);
////        		indApp.setIndividualId(indfirst+indreplace+indlast);
//        			indApp.setIndividualId(replaceIdCrad(listApp.get(0).getIndividualId()).toString());
//        		}
//        		else{
//        			indApp.setIndividualId(listApp.get(0).getIndividualId());
//        		}
//        	}
        	if("2".equals(type)){
//        		if(listApp.get(0).getIndividualId().length()>1){
        		if(null != listApp.get(0).getIndividualId()){
        			indApp.setIndividualId(replaceIdCrad(listApp.get(0).getIndividualId()).toString());
        		}
        	}
//        	indApp.setQueryReason(listApp.get(0).getQueryReason());
        	list.add(indApp);
        	
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

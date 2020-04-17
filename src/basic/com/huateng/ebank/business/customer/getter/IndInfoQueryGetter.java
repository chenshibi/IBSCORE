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
public class IndInfoQueryGetter extends BaseGetter {

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
        String type = (String) getCommQueryServletRequest().getParameterMap().get("type");
        PageQueryResult pageQueryResult = new PageQueryResult();
        String mobilereplace="";
        String phonecomreplace="";
        String phonelivereplace="";
        String addrreplace="";
        String HuKouaddrreplace="";
        String spousereplace="";
        String idnumberreplace="";
        String spousecomreplace="";
        String spousephonereplace="";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndInfo> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ii from IndInfo ii where ii.rptId='"+rptId+"'");
        List<IndInfo> listInfo = rootdao.queryByCondition(hql1.toString());
        if(listInfo.size()>0){
        	IndInfo indInfo=new IndInfo();
        	indInfo.setGender(listInfo.get(0).getGender());
        	indInfo.setBirthday(listInfo.get(0).getBirthday());
        	indInfo.setMarriage(listInfo.get(0).getMarriage());
        	if("1".equals(type)){
        		if(listInfo.get(0).getMobile().length()>1){
        		String mobilefirst=listInfo.get(0).getMobile().substring(0, 1);
            	String mobilemiddle=listInfo.get(0).getMobile().substring(1, listInfo.get(0).getMobile().length()-1);
            	for (int i = 0; i < mobilemiddle.length(); i++) {
            		mobilereplace+="*";
    			}
            	String mobilelast=listInfo.get(0).getMobile().substring(listInfo.get(0).getMobile().length()-1, listInfo.get(0).getMobile().length());
        		indInfo.setMobile(mobilefirst+mobilereplace+mobilelast);
        		}
        		else{
        			indInfo.setMobile(listInfo.get(0).getMobile());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setMobile(listInfo.get(0).getMobile());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getPhoneCom().length()>1){
        		String phonecomfirst=listInfo.get(0).getPhoneCom().substring(0, 1);
            	String phonecommiddle=listInfo.get(0).getPhoneCom().substring(1, listInfo.get(0).getPhoneCom().length()-1);
            	for (int i = 0; i < phonecommiddle.length(); i++) {
            		phonecomreplace+="*";
    			}
            	String phonecomlast=listInfo.get(0).getPhoneCom().substring(listInfo.get(0).getPhoneCom().length()-1, listInfo.get(0).getPhoneCom().length());
        		indInfo.setPhoneCom(phonecomfirst+phonecomreplace+phonecomlast);
        		}
        		else{
        			indInfo.setPhoneCom(listInfo.get(0).getPhoneCom());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setPhoneCom(listInfo.get(0).getPhoneCom());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getPhoneLiv().length()>1){
        		String phonelivefirst=listInfo.get(0).getPhoneLiv().substring(0, 1);
            	String phonelivemiddle=listInfo.get(0).getPhoneLiv().substring(1, listInfo.get(0).getPhoneLiv().length()-1);
            	for (int i = 0; i < phonelivemiddle.length(); i++) {
            		phonelivereplace+="*";
    			}
            	String phonelivelast=listInfo.get(0).getPhoneLiv().substring(listInfo.get(0).getPhoneLiv().length()-1, listInfo.get(0).getPhoneLiv().length());
        		indInfo.setPhoneLiv(phonelivefirst+phonelivereplace+phonelivelast);
        		}
        		else{
        			indInfo.setPhoneLiv(listInfo.get(0).getPhoneLiv());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setPhoneLiv(listInfo.get(0).getPhoneLiv());
        	}
        	indInfo.setEducation(listInfo.get(0).getEducation());
        	indInfo.setDegree(listInfo.get(0).getDegree());
        	if("1".equals(type)){
        		if(listInfo.get(0).getAddr().length()>2){
        		String addrfirst=listInfo.get(0).getAddr().substring(0, 2);
            	String addr=listInfo.get(0).getAddr().substring(2, listInfo.get(0).getAddr().length());
            	for (int i = 0; i < addr.length(); i++) {
    				addrreplace+="*";
    			}
        		indInfo.setAddr(addrfirst+addrreplace);
        		}
        		else{
        			indInfo.setAddr(listInfo.get(0).getAddr());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setAddr(listInfo.get(0).getAddr());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getHukouAddr().length()>2){
        		String HukouAddrfirst=listInfo.get(0).getHukouAddr().substring(0, 2);
            	String Hukouaddr=listInfo.get(0).getHukouAddr().substring(2, listInfo.get(0).getHukouAddr().length());
            	for (int i = 0; i < Hukouaddr.length(); i++) {
            		HuKouaddrreplace+="*";
    			}
        		indInfo.setHukouAddr(HukouAddrfirst+HuKouaddrreplace);
        		}
        		else{
        			indInfo.setHukouAddr(listInfo.get(0).getHukouAddr());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setHukouAddr(listInfo.get(0).getHukouAddr());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getSpouse().length()>1){
        		String apousefirst=listInfo.get(0).getSpouse().substring(0, 1);
            	String spouse=listInfo.get(0).getSpouse().substring(1, listInfo.get(0).getSpouse().length());
            	for (int i = 0; i < spouse.length(); i++) {
            		spousereplace+="*";
    			}
        		indInfo.setSpouse(apousefirst+spousereplace);
        		}
        		else{
        			indInfo.setSpouse(listInfo.get(0).getSpouse());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setSpouse(listInfo.get(0).getSpouse());
        	}
        	indInfo.setSpouseIdType(listInfo.get(0).getSpouseIdType());
        	if("1".equals(type)){
        		if(listInfo.get(0).getSpouseIdNumber().length()>1){
        		String idnumberfirst=listInfo.get(0).getSpouseIdNumber().substring(0, 1);
            	String idnumbermiddle=listInfo.get(0).getSpouseIdNumber().substring(1, listInfo.get(0).getSpouseIdNumber().length()-1);
            	for (int i = 0; i < idnumbermiddle.length(); i++) {
            		idnumberreplace+="*";
    			}
            	String idnumberlast=listInfo.get(0).getSpouseIdNumber().substring(listInfo.get(0).getSpouseIdNumber().length()-1, listInfo.get(0).getSpouseIdNumber().length());
        		indInfo.setSpouseIdNumber(idnumberfirst+idnumberreplace+idnumberlast);
        		}
        		else{
        			indInfo.setSpouseIdNumber(listInfo.get(0).getSpouseIdNumber());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setSpouseIdNumber(listInfo.get(0).getSpouseIdNumber());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getSpouseCom().length()>2){
        		String spousecomfirst=listInfo.get(0).getSpouseCom().substring(0, 2);
            	String spousecom=listInfo.get(0).getSpouseCom().substring(2, listInfo.get(0).getSpouseCom().length());
            	for (int i = 0; i < spousecom.length(); i++) {
            		spousecomreplace+="*";
    			}
        		indInfo.setSpouseCom(spousecomfirst+spousecomreplace);
        		}
        		else{
        			indInfo.setSpouseCom(listInfo.get(0).getSpouseCom());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setSpouseCom(listInfo.get(0).getSpouseCom());
        	}
        	if("1".equals(type)){
        		if(listInfo.get(0).getSpousePhone().length()>1){
        		String spousephonefirst=listInfo.get(0).getSpousePhone().substring(0, 1);
            	String spousephonemiddle=listInfo.get(0).getSpousePhone().substring(1, listInfo.get(0).getSpousePhone().length()-1);
            	for (int i = 0; i < spousephonemiddle.length(); i++) {
            		spousephonereplace+="*";
    			}
            	String spousephonelast=listInfo.get(0).getSpousePhone().substring(listInfo.get(0).getSpousePhone().length()-1, listInfo.get(0).getSpousePhone().length());
        		indInfo.setSpousePhone(spousephonefirst+spousephonereplace+spousephonelast);
        		}
        		else{
        			indInfo.setSpousePhone(listInfo.get(0).getSpousePhone());
        		}
        	}
        	if("2".equals(type)){
        	indInfo.setSpousePhone(listInfo.get(0).getSpousePhone());
        	}
        	list.add(indInfo);
        	
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

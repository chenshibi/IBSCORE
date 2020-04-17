/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import resource.bean.basic.IndApp;
import resource.bean.basic.IndJob;



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
public class IndJobQueryGetter extends BaseGetter {

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
        String namereplace="";
        String addrreplace="";
        String professionreplace="";
        String industryreplace="";
        String titlereplace="";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndJob> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ij from IndJob ij where ij.rptId='"+rptId+"' order by ij.no");
        List<IndJob> listJob = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listJob.size(); i++) {
        	namereplace="";
        	addrreplace="";
        	professionreplace="";
        	industryreplace="";
        	titlereplace="";
        	IndJob indJob=new IndJob();
        	indJob.setNo(listJob.get(i).getNo());
        	
        	if("1".equals(type)){
        		if(listJob.get(i).getName().length()>2){
        		String namefirst=listJob.get(i).getName().substring(0, 2);
            	String name=listJob.get(i).getName().substring(2,listJob.get(i).getName().length());
        		for (int j = 0; j < name.length(); j++) {
        			namereplace+="*";
    			}
        		indJob.setName(namefirst+namereplace);
        		}
        		else{
        			indJob.setName(listJob.get(i).getName());	
        		}
        	}
        	if("2".equals(type)){
        	indJob.setName(listJob.get(i).getName());
        	}
        	if("1".equals(type)){
        		if(listJob.get(i).getAddr().length()>2){
        		String addrfirst=listJob.get(i).getAddr().substring(0, 2);
            	String addr=listJob.get(i).getAddr().substring(2,listJob.get(i).getAddr().length());
        		for (int j = 0; j < addr.length(); j++) {
        			addrreplace+="*";
    			}
        		indJob.setAddr(addrfirst+addrreplace);
        		}
        		else{
        			indJob.setAddr(listJob.get(i).getAddr());
        		}
        	}
        	if("2".equals(type)){
        	indJob.setAddr(listJob.get(i).getAddr());
        	}
        	if("1".equals(type)){
        		if(listJob.get(i).getProfession().length()>2){
        		String professionfirst=listJob.get(i).getProfession().substring(0, 2);
            	String profession=listJob.get(i).getProfession().substring(2,listJob.get(i).getProfession().length());
        		for (int j = 0; j < profession.length(); j++) {
        			professionreplace+="*";
    			}
        		indJob.setProfession(professionfirst+professionreplace);
        		}
        		else{
        			indJob.setProfession(listJob.get(i).getProfession());
        		}
        	}
        	if("2".equals(type)){
        	indJob.setProfession(listJob.get(i).getProfession());
        	}
        	if("1".equals(type)){
        		if(listJob.get(i).getIndustry().length()>2){
        		String industryfirst=listJob.get(i).getIndustry().substring(0, 2);
            	String industry=listJob.get(i).getIndustry().substring(2,listJob.get(i).getIndustry().length());
        		for (int j = 0; j < industry.length(); j++) {
        			industryreplace+="*";
    			}
        		indJob.setIndustry(industryfirst+industryreplace);
        		}
        		else{
        			indJob.setIndustry(listJob.get(i).getIndustry());
        		}
        	}
        	if("2".equals(type)){
        	indJob.setIndustry(listJob.get(i).getIndustry());
        	}
        	if("1".equals(type)){
        		if(listJob.get(i).getTitle().length()>2){
        		String titlefirst=listJob.get(i).getTitle().substring(0, 2);
            	String title=listJob.get(i).getTitle().substring(2,listJob.get(i).getTitle().length());
        		for (int j = 0; j < title.length(); j++) {
        			titlereplace+="*";
    			}
        		indJob.setTitle(titlefirst+titlereplace);
        		}
        		else{
        			indJob.setTitle(listJob.get(i).getTitle());
        		}
        	}
        	if("2".equals(type)){
        	indJob.setTitle(listJob.get(i).getTitle());
        	}
        	indJob.setTitleTec(listJob.get(i).getTitleTec());
        	if(null != listJob.get(i).getStartdate()){
        		if("1900-01-01 00:00:00.0".equals(listJob.get(i).getStartdate().toString())){
            		indJob.setStartdate(null);
            	}
            	else{
            		String sdate=listJob.get(i).getStartdate().toString().substring(0, 4);
            		indJob.setStartdates(sdate);
            	}
            	
            	indJob.setGetdate(listJob.get(i).getGetdate());
            	list.add(indJob);
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
}

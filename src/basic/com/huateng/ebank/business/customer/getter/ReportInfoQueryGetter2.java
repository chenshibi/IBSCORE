/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 
package com.huateng.ebank.business.customer.getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.utils.Airth;

import resource.bean.crms.IbsEntCreditSum;
import resource.bean.crms.IbsPerCreditSum;
import resource.bean.crms.TotalPerCreditSum;
*//**
 * 
 * @author Grassy
 *
 *//*
@SuppressWarnings("unchecked")
public class ReportInfoQueryGetter2 extends BaseGetter {

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
    	 PageQueryResult pageQueryResult = new PageQueryResult();
         ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	  ArrayList<HashMap<String, String>> queryList =new ArrayList<HashMap<String,String>>();
    	  HashMap<String, String> queryMap=new HashMap<String, String>();
    	  String loanCardId=(String) getCommQueryServletRequest().getParameterMap().get("loanCardId");
    	  String companyName=(String) getCommQueryServletRequest().getParameterMap().get("companyName");
          queryMap.put((String) getCommQueryServletRequest().getParameterMap().get("individualId"), (String) getCommQueryServletRequest().getParameterMap().get("name"));
          queryList.add(queryMap);
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIda"))){
        	  HashMap<String, String> queryMap1=new HashMap<String, String>();
	          queryMap1.put((String) getCommQueryServletRequest().getParameterMap().get("individualIda"), (String) getCommQueryServletRequest().getParameterMap().get("namea"));
	          queryList.add(queryMap1);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdb"))){
        	  HashMap<String, String> queryMap2=new HashMap<String, String>();
	          queryMap2.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdb"), (String) getCommQueryServletRequest().getParameterMap().get("nameb"));
	          queryList.add(queryMap2);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdc"))){
	          HashMap<String, String> queryMap3=new HashMap<String, String>();
	          queryMap3.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdc"), (String) getCommQueryServletRequest().getParameterMap().get("namec"));
	          queryList.add(queryMap3);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdd"))){
	          HashMap<String, String> queryMap4=new HashMap<String, String>();
	          queryMap4.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdd"), (String) getCommQueryServletRequest().getParameterMap().get("named"));
	          queryList.add(queryMap4);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIde"))){
	          HashMap<String, String> queryMap5=new HashMap<String, String>();
	          queryMap5.put((String) getCommQueryServletRequest().getParameterMap().get("individualIde"), (String) getCommQueryServletRequest().getParameterMap().get("namee"));
	          queryList.add(queryMap5);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdf"))){
	          HashMap<String, String> queryMap6=new HashMap<String, String>();
	          queryMap6.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdf"), (String) getCommQueryServletRequest().getParameterMap().get("namef"));
	          queryList.add(queryMap6);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdg"))){
	          HashMap<String, String> queryMap7=new HashMap<String, String>();
	          queryMap7.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdg"), (String) getCommQueryServletRequest().getParameterMap().get("nameg"));
	          queryList.add(queryMap7);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdh"))){
	          HashMap<String, String> queryMap8=new HashMap<String, String>();
	          queryMap8.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdh"), (String)getCommQueryServletRequest().getParameterMap().get("nameh"));
	          queryList.add(queryMap8);
          }
          if(!"".equals((String) getCommQueryServletRequest().getParameterMap().get("individualIdi"))){
	          HashMap<String, String> queryMap9=new HashMap<String, String>();
	          queryMap9.put((String) getCommQueryServletRequest().getParameterMap().get("individualIdi"), (String) getCommQueryServletRequest().getParameterMap().get("namei"));
	          queryList.add(queryMap9);
          }
          
          StringBuilder hq = new StringBuilder(" SELECT model FROM IbsEntCreditSum model WHERE 1 = 1 ");
  		  if (!DataFormat.isEmpty(loanCardId)) {
  			   hq.append(" and model.zzm='").append(loanCardId).append("' ");		
  		  }
  		  if (!DataFormat.isEmpty(companyName)) {
  			   hq.append(" and model.qymc='").append(companyName).append("' ");	
		  }
  		  List<IbsEntCreditSum> queryListByCorp = rootdao.queryByCondition(hq.toString());
  		  List<IbsPerCreditSum> queryListByPerList=new ArrayList<IbsPerCreditSum>();
  		  IbsPerCreditSum perCreditSum=new IbsPerCreditSum(); 
  		  
  		  if(null!=queryListByCorp && queryListByCorp.size()>0) {
  			 perCreditSum.setDbrxm(queryListByCorp.get(0).getQymc());
  			 perCreditSum.setCxrq(queryListByCorp.get(0).getCxrq());
  			 perCreditSum.setSfbh(queryListByCorp.get(0).getSfbh());
  			 perCreditSum.setYwyq(queryListByCorp.get(0).getYwyq());  
  		//	 perCreditSum.setYqje(queryListByCorp.get(0).getDqgzlblfzbs());
  			 perCreditSum.setTue(queryListByCorp.get(0).getTue());
  			 perCreditSum.setDsr(queryListByCorp.get(0).getDsr());
  			 perCreditSum.setWc(queryListByCorp.get(0).getWc());
  			 queryListByPerList.add(perCreditSum);
  		  }
  		  Double tue=Airth.StringToDouble(perCreditSum.getTue());
  		  Double dsr=Airth.StringToDouble(perCreditSum.getDsr());
  		  Double wc=Airth.StringToDouble(perCreditSum.getWc());
  		  Double totalTue=0.00;
  		  String totalTue2=null;
  		  Double totalDsr=0.00;
  		  String totalDsr2=null;
  		  Double totalWc=0.00;
  		  String totalWc2=null;
	      if(null != queryList && queryList.size()>0){
	        for (int i = 0; i < queryList.size(); i++) {
	        	Iterator<Entry<String,String>> itor=queryList.get(i).entrySet().iterator();
	        	while(itor.hasNext()){
	        		Entry<String,String> entry=itor.next();
	        		String key=entry.getKey();
	        		String idCard= key.substring(0, 3)+key.substring(key.length()-3, key.length());
	        		 StringBuffer hql = new StringBuffer("select po from IbsPerCreditSum po where 1=1 ");
	             	 hql.append(" and po.idcard ='"+idCard+"'");
	             	 hql.append(" and po.dbrxm ='"+entry.getValue()+"'");
	             	 hql.append("  order by po.cxrq desc ");
	             	 List<IbsPerCreditSum> queryByCondition  = rootdao.queryByCondition(hql.toString());
	             	 if(queryByCondition!=null && queryByCondition.size()>0) {
	             		 for(int j=0;j<queryByCondition.size();j++) {
	             			 IbsPerCreditSum ibsPerCreditSum2 = queryByCondition.get(j);
	             			 totalTue+=Airth.add(tue, Airth.StringToDouble(ibsPerCreditSum2.getTue()));
	             			 totalDsr+=Airth.add(dsr, Airth.StringToDouble(ibsPerCreditSum2.getDsr()));
	             			 totalWc+=Airth.add(wc, Airth.StringToDouble(ibsPerCreditSum2.getWc()));
	             			 totalTue2=Airth.DoubleToStr(totalTue);
	             			 totalDsr2=Airth.DoubleToStr(totalDsr);
	             			 totalWc2=Airth.DoubleToStr(totalWc);
	             			 ibsPerCreditSum2.setTotalTue(totalTue2);
	             			 ibsPerCreditSum2.setTotalDsr(totalDsr2);
	             			 ibsPerCreditSum2.setTotalWc(totalWc2);
	             		 }
	             	 }
	             	
	             	 queryListByPerList.addAll(queryByCondition);
	        	}
	        	
	     	}
	      }
	      List<TotalPerCreditSum> newList=new ArrayList<TotalPerCreditSum>();
	      if(queryListByPerList!=null&& queryListByPerList.size()>0) {
	    	  TotalPerCreditSum totalPerCreditSum=new TotalPerCreditSum();
	    	  totalPerCreditSum.setTotalTue(totalTue2);
	    	  totalPerCreditSum.setTotalDsr(totalDsr2);
	    	  totalPerCreditSum.setTotalWc(totalWc2);
	    	  newList.add(totalPerCreditSum);
	      }
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
         对最后一页的处理 
        if (maxIndex > newList.size()) {
            maxIndex = newList.size();
        }
        List result = new ArrayList();
        result = newList.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(newList.size());
        pageQueryResult.setQueryResult(result);
        return pageQueryResult;
    }
}
*/
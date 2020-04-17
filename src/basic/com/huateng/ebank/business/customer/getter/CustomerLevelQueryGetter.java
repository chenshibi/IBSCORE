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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.service.CustomerLevelService;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.IndInfo;


/**
 * @author 
 *
 */
@SuppressWarnings("unchecked")
public class CustomerLevelQueryGetter extends BaseGetter {

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
    	 List<IndInfo> list = new ArrayList(); 
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
        //根据查询条件查询 取出rpdid存放在listRpdids
          ArrayList<String> listRpdids = new ArrayList<String>();
	      if(null != queryList && queryList.size()>0){
	        for (int i = 0; i < queryList.size(); i++) {
	        	Iterator<Entry<String,String>> itor=queryList.get(i).entrySet().iterator();
	        	while(itor.hasNext()){
	        		Entry<String,String> entry=itor.next();
	        		 StringBuffer hql = new StringBuffer("select po from IndInfo po where 1=1 ");
	             	 hql.append(" and po.idNumber ='"+entry.getKey()+"'");
	             	 hql.append(" and po.name ='"+entry.getValue()+"'");
	             	 hql.append("  order by po.reportDate desc ");
	             	 List<IndInfo> listIndInfo = rootdao.queryByCondition(hql.toString());
	             	 if(listIndInfo != null && listIndInfo.size()>0){
	         	        	String rpdids=listIndInfo.get(0).getRptId();
	         	        	listRpdids.add(rpdids);
	                 }
	             	 
	        	}
	     	}
	      }
	      	String DPDX24M = "missing";
			String Current12M = "missing";
			String WorstCCStatus12M = "missing";
			String WorstPLStatus12M = "missing";
			String AvgEnq12M = "0";
			String AvgCCUtil6M = "missing";
			CustomerLevelService customerLevelService=new CustomerLevelService();
        //根据担保人 不同type业务类型 获取最近24个月还款状态的字符串集合() 每个人每个业务类型可能为多笔
	    if(listRpdids != null && listRpdids.size()>0){ 
	    	ArrayList<String> crd_month24s = customerLevelService.getMonth24s( listRpdids, "CARD");// 贷记卡/准贷记卡
			ArrayList<String> lon_month24s = customerLevelService.getMonth24s( listRpdids, "LOAN");// 个人消费贷款/个人住房贷款/个人住房公积金贷款/个人汽车贷款。。。
			ArrayList<String> all_month24s = new ArrayList<String>();
			all_month24s.addAll(crd_month24s);
			all_month24s.addAll(lon_month24s);
	        
			//将对应n个担保人最近24个月的还款状态全部按条件(逾期和正常)替换，其他都默认为"*"状态,merged_month24融合成为对应n个担保人最近24个月还款状态的字符串,[注意]将每个月状态筛选替换为所有当月最大逾期数(1-7)或者N
			String crd_merged = customerLevelService.getMergedMonth24( crd_month24s);
			String lon_merged = customerLevelService.getMergedMonth24( lon_month24s);
			String total_merged = customerLevelService.getMergedMonth24(all_month24s);
	        
			DPDX24M = customerLevelService.getDPDX24M(total_merged);//担保人最近24个月使用借贷业务时，返回担保人最近24个月(卡业务 /贷款业务)每个月最大逾期次数加总(同一个月中，所有记录逾期天数只取最大);没使用借贷业务时，返回"missing"
			Current12M = customerLevelService.getCurrent12M( total_merged);//担保人最近12个月使用借贷业务，返回担保人最近12个月 (卡业务 /贷款业务)正常还款次数加总 (所有对应记录必须同一个月都正常还款。只要同一个月中没有逾期（1-7），只要有一个为N（正常），其他状态为*（本月没有还款历史）的也默认成N(正常还款));没使用返回 "missing"
			WorstCCStatus12M = customerLevelService.getLastMaxMonth(crd_merged, 12, 8);//担保人最近12个月使用借贷业务小于等于4次时，返回担保人最近12个月 卡业务 (贷记卡/准贷记卡)最大逾期数(1-7);使用大于4次时返回"missing";
			WorstPLStatus12M = customerLevelService.getLastMaxMonth(lon_merged, 12, 8);//担保人最近12个月使用借贷业务小于等于4次时，返回担保人最近12个月 贷款业务(各类贷款) 最大逾期数(1-7);使用大于4次时返回"missing";
			AvgEnq12M = customerLevelService.getAvgEnq12M(listRpdids);//对应担保人的信用报告最近12个月(从前12个月的1号开始算到查询当天)因（'贷款审批','信用卡审批','担保资格审查'）每个月被查询平均次数（如n个人，每个月查询有n条次数，选取每个月查询次数的最大值）
			AvgCCUtil6M =customerLevelService.getAvgCCUtil6M(listRpdids);//最近6个月担保人(贷记卡/准贷记卡)的  已使用额度占共享授信额度比例（全部担保人已使用额度总和/全部担保人共享授信额度总和）
	    }
		IndInfo indInfo=new IndInfo();
		indInfo.setDpdx(DPDX24M);
		indInfo.setMaxLast12M(Current12M);
		indInfo.setCreditCards(WorstCCStatus12M);
		indInfo.setPersonalLoans(WorstPLStatus12M);
		indInfo.setLast12Months(AvgEnq12M);
		indInfo.setLast6Months(AvgCCUtil6M);
		list.add(indInfo);
		customerLevelService.CustomerLevelQuerySave(loanCardId,companyName,queryList,DPDX24M,Current12M,WorstCCStatus12M,WorstPLStatus12M,AvgEnq12M,AvgCCUtil6M);
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

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import resource.bean.basic.IndApp;
import resource.bean.basic.IndHousefundDeposit;



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
public class IndHousefundDepositQueryGetter extends BaseGetter {

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
        String cityreplace="";
        String organreplace="";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<IndHousefundDeposit> list = new ArrayList(); 
        StringBuffer hql1 = new StringBuffer("select ia from IndHousefundDeposit ia where ia.rptId='"+rptId+"' order by ia.no");
        List<IndHousefundDeposit> listHousefundDeposit = rootdao.queryByCondition(hql1.toString());
        for (int i = 0; i < listHousefundDeposit.size(); i++) {
        	cityreplace="";
        	organreplace="";
        	IndHousefundDeposit indHousefundDeposit=new IndHousefundDeposit();
        	indHousefundDeposit.setNo(listHousefundDeposit.get(i).getNo());
        	if("1".equals(type)){
        		if(listHousefundDeposit.get(i).getCity().length()>2){
        			String cityfirst=listHousefundDeposit.get(i).getCity().substring(0, 2);
                	String city=listHousefundDeposit.get(i).getCity().substring(2,listHousefundDeposit.get(i).getCity().length());
            		for (int j = 0; j < city.length(); j++) {
            			cityreplace+="*";
        			}
            	indHousefundDeposit.setCity(cityfirst+cityreplace);
        		}
        		else{
        			indHousefundDeposit.setCity(listHousefundDeposit.get(i).getCity());
        		}
        	}
        	if("2".equals(type)){
        		indHousefundDeposit.setCity(listHousefundDeposit.get(i).getCity());
            	}
        	indHousefundDeposit.setInitDate(listHousefundDeposit.get(i).getInitDate());
        	indHousefundDeposit.setFirstMonth(listHousefundDeposit.get(i).getFirstMonth());
        	indHousefundDeposit.setToMonth(listHousefundDeposit.get(i).getToMonth());
        	indHousefundDeposit.setStatus(listHousefundDeposit.get(i).getStatus());
        	String monthAmount=listHousefundDeposit.get(i).getMonthlyAmount();
        	indHousefundDeposit.setMonthlyAmount(numToCurrency(monthAmount));
        	indHousefundDeposit.setPersentPer(listHousefundDeposit.get(i).getPersentPer());
        	indHousefundDeposit.setPercentCom(listHousefundDeposit.get(i).getPercentCom());
        	if("1".equals(type)){
        		if(listHousefundDeposit.get(i).getOrgan().length()>2){
        			String organfirst=listHousefundDeposit.get(i).getOrgan().substring(0, 2);
        			String organ=listHousefundDeposit.get(i).getOrgan().substring(2,listHousefundDeposit.get(i).getOrgan().length());
        			for (int j = 0; j < organ.length(); j++) {
        				organreplace+="*";
        			}
        			indHousefundDeposit.setOrgan(organfirst+organreplace);
        		}
        		else{
        			indHousefundDeposit.setOrgan(listHousefundDeposit.get(i).getOrgan());
        		}
        	}
        	if("2".equals(type)){
        		indHousefundDeposit.setOrgan(listHousefundDeposit.get(i).getOrgan());
        	}
        	indHousefundDeposit.setUpdateDate(listHousefundDeposit.get(i).getUpdateDate());
        	list.add(indHousefundDeposit);
        	
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
    public static String numToCurrency(String amount){
		if(null != amount && (!"--".equals(amount))){
			DecimalFormat df = null;
			df = new DecimalFormat("###,##0.00");
			double number = Double.parseDouble(String.valueOf(amount.replaceAll(",", "")));
			return df.format(number);
		}
	return amount;
}
}

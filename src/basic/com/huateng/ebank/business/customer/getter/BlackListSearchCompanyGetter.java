/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import resource.bean.basic.RoleFuncRel;



import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Page;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.customer.dao.CompanyReport2Sql;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;


/**
 * @author 
 *
 */
public class BlackListSearchCompanyGetter extends BaseGetter {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BlackListSearchCompanyGetter.class);

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
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	
    	 String compId = (String) getCommQueryServletRequest().getParameterMap().get("compId");
    	 String compRegId = (String) getCommQueryServletRequest().getParameterMap().get("compRegId");
    	 String compName = (String) getCommQueryServletRequest().getParameterMap().get("compName");
    	 String compEng = (String) getCommQueryServletRequest().getParameterMap().get("compEng");
    	 String phone = (String) getCommQueryServletRequest().getParameterMap().get("phone");
    	 String nameChn = (String) getCommQueryServletRequest().getParameterMap().get("nameChn");
    	 String custId = (String) getCommQueryServletRequest().getParameterMap().get("custId");
    	 
    	 PageQueryResult pageQueryResult = new PageQueryResult();
    	 String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
         //ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
         
         String funcid1="";//黑名单企业详情
         
         List<RoleFuncRel> list1 = new ArrayList(); 
         String sql="from RoleFuncRel t1 where t1.roleId in(select t2.roleId from TlrRoleRel t2 where tlrno='"+tlrno+"')";
 		 List<RoleFuncRel> listroleFuncRel=rootdao.queryByQL2List(sql);
 		 if(listroleFuncRel.size()>0){
 			for (int i = 0; i < listroleFuncRel.size(); i++) {
 				String funcid=listroleFuncRel.get(i).getFuncid();
 				if("91992".equals(funcid)){
					funcid1=funcid;
				}
 			}
 		 }
        /* String funcid1="";//原始企业征信报告  
         String funcid2="";//二代企业征信报告
         String funcid3="";//企业信息核验
         String funcid4="";//企业一般信息展开(二级)
         String funcid5="";//企业明细信息展开 
         String funcid6="";//查询授权书下载       
         String funcid7="";//二代企业信息汇总       
         
         List<RoleFuncRel> list1 = new ArrayList(); 
         String sql="from RoleFuncRel t1 where t1.roleId in(select t2.roleId from TlrRoleRel t2 where tlrno='"+tlrno+"')";
 		 List<RoleFuncRel> listroleFuncRel=rootdao.queryByQL2List(sql);
 		 if(listroleFuncRel.size()>0){
 			for (int i = 0; i < listroleFuncRel.size(); i++) {
 				String funcid=listroleFuncRel.get(i).getFuncid();
 				if("66661701".equals(funcid)){
					funcid1=funcid;
				}
 				if("66661702".equals(funcid)){
 					funcid2=funcid;
 				}
 				if("66661703".equals(funcid)){
 					funcid3=funcid;
 				}
 				if("66661704".equals(funcid)){
 					funcid4=funcid;
 				}
 				if("66661705".equals(funcid)){
 					funcid5=funcid;
 				}
 				if("66661706".equals(funcid)){
 					funcid6=funcid;
 				}
 				if("66661707".equals(funcid)){
 					funcid7=funcid;
 				}
 			}
 		 }*/
 		
         BlackListSearchCompanyBean bean = null;
       
         /*每日时间*/
        /*Date startTm = null;
		Date endTm = null;
		startTm = new Date();//*获取当前时间
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");// 年月日
		String day = fmt.format(startTm);// 获取当前时间的年月日
		System.out.println(day);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String yesterday = new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime());
		System.out.println(yesterday);
		
		每月时间
		//Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, -1);
		String start = new SimpleDateFormat("yyyy-MM-dd").format(cal
				.getTime());
		System.out.println(start);

		Calendar lastDate = Calendar.getInstance();
		lastDate.add(Calendar.MONTH, -1);// 减一个月
		lastDate.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		lastDate.roll(Calendar.DATE, -1);// 日期回滚一天，也就是本月最后一天
		String end = new SimpleDateFormat("yyyy-MM-dd").format(lastDate
				.getTime());
		System.out.println(end);*/
		
        
 		/*
 		 String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		String beginTime=DateUtil.get14Date(c).substring(0,8)+" 00:00:00";
		
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+" 00:00:00";
		
		String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
		*/
		
		
		List list = new ArrayList(); 
        
        StringBuffer hql = new StringBuffer();
        hql.append("select tc.COMP_ID as compId,tc.REG_ID as regId,tc.NAME_CHN as nameChn,tc.PRODUCT as product,tc.REASON1 as reason,tc.LOAN_NO as loanNo,tc.STATUS as status from T_COMPANY tc left join T_BLACKLIST tb on tc.REG_ID = tb.COMP_REG_ID WHERE 1=1");
        
        if (!DataFormat.isEmpty(compId)) {
			hql.append(" and tb.COMP_ID like '%").append(compId).append("%' ");			
		}
        if (!DataFormat.isEmpty(compRegId)) {
			hql.append(" and tb.COMP_REG_ID like '%").append(compRegId).append("%' ");			
		}
        if (!DataFormat.isEmpty(compName)) {
			hql.append(" and tb.COMP_NAME like '%").append(compName).append("%' ");			
		}
        if (!DataFormat.isEmpty(compEng)) {
        	hql.append(" and tb.COMP_ENG like '%").append(compEng).append("%' ");			
        }
        if (!DataFormat.isEmpty(phone)) {
        	hql.append(" and tb.OFFICE_PHONE1='").append(phone).append("' ");			
        }
        if (!DataFormat.isEmpty(nameChn)) {
        	hql.append(" and tb.NAME_CHN='").append(nameChn).append("' ");			
        }
        if (!DataFormat.isEmpty(custId)) {
        	hql.append(" and tb.CUST_ID='").append(custId).append("' ");			
        }
        hql.append(" order by tc.DATE_INPUT desc ");
        Iterator it = rootdao.queryBySQL2(hql.toString());
        while(it.hasNext()){
        	Map map = (Map)it.next();
        	bean=new BlackListSearchCompanyBean();
        	
        	if(map.get("COMPID")!=null) {
				bean.setCompId(map.get("COMPID").toString());
			}
        	if(map.get("REGID")!=null) {
        		bean.setRegId(map.get("REGID").toString());
        	}
        	if(map.get("NAMECHN")!=null) {
        		bean.setNameChn(map.get("NAMECHN").toString());
        	}
        	if(map.get("PRODUCT")!=null) {
        		bean.setProduct(map.get("PRODUCT").toString());
        	}
        	if(map.get("REASON")!=null) {
        		bean.setReason(map.get("REASON").toString());
        	}
        	if(map.get("LOANNO")!=null) {
        		bean.setLoanNo(map.get("LOANNO").toString());
        	}
        	if(map.get("STATUS")!=null) {
        		bean.setStatus(map.get("STATUS").toString());
        	}
        	
        	bean.setFuncid1(funcid1);
        	list.add(bean);
        }
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List result = new ArrayList();
        result = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(result);
        return pageQueryResult;

        
    	
    	/*Page page = getResult().getPage();
		ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
		Map<String, String> map = getCommQueryServletRequest().getParameterMap();
    	
		String hql = CompanyReport2Sql.queryCompanyReport(map).getSql();
		PageQueryResult pageQueryResult = rootDao.pageQueryByHql(page.getCurrentPage(), page.getEveryPage(), hql);
		return pageQueryResult;*/
    }
        
}

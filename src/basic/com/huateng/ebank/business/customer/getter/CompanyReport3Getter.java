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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.DateUtil;
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

import resource.bean.basic.RoleFuncRel;


/**
 * @author 
 *
 */
public class CompanyReport3Getter extends BaseGetter {
	
 	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CompanyReport3Getter.class);

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
    	
    	 String entName = (String) getCommQueryServletRequest().getParameterMap().get("entName");
    	 String entCertNum = (String) getCommQueryServletRequest().getParameterMap().get("entCertNum");
    	 String rsv9 = (String) getCommQueryServletRequest().getParameterMap().get("rsv9");
    	/* String queryReason = (String) getCommQueryServletRequest().getParameterMap().get("queryReason");
    	 String status = (String) getCommQueryServletRequest().getParameterMap().get("status");*/
    	 String MyQuery = (String) getCommQueryServletRequest().getParameterMap().get("MyQuery");
    	 PageQueryResult pageQueryResult = new PageQueryResult();
         String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
        /* ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();*/
         
         String funcid1="";//原始企业征信报告  
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
 		 }
 		
 		CompanyReport3Bean bean = null;
 		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		String beginTime=DateUtil.get14Date(c).substring(0,8)+"000000";
		
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+"000000";
		
		String nowTime=DateUtil.get14Date().substring(0,8)+DateUtil.get14Date().substring(8,10)+DateUtil.get14Date().substring(10,12)+DateUtil.get14Date().substring(12,14);
        List list = new ArrayList(); 
        
        StringBuffer hql = new StringBuffer();
        hql.append("select t.ID as id,'' as MyQuery, t.ENT_NAME as entName, t.ENT_CERT_TYPE as entCertType,t.rsv9 as rsv9, t.ENT_CERT_NUM as entCertNum, t.QUERY_REASON as queryReason, t.SERVICE_CODE as serviceCode, t.RESP_ID as respId, t.RESP_CODE as respCode, t.RESP_MSG as respMsg, t.QUERY_DATE as queryDate, t.CREATE_USER as createUser, t.CREATE_TIME as createTime, t.CHECK_USER as checkUser, t.CHECK_TIME as checkTime, t.SEND_TIME as sendTime, t.RESP_TIME as respTime, t.STATUS as status, t.CERT_AUTH_STATUS as certAuthStatus from CUST_PBOC_ENT_QUERY t where 1=1");
        if (!DataFormat.isEmpty(entName)) {
			hql.append(" and t.ENT_NAME='").append(entName).append("' ");			
		}
        if (!DataFormat.isEmpty(entCertNum)) {
			hql.append(" and ent_cert_num in ").append("(SELECT EA01CI01 FROM  CR_COM_EA01CH  " + 
					" where batch_id  in (").append("select batch_id from CR_COM_EA01CH where EA01CI01 = '"+entCertNum+"') )");	
		}
        if (!DataFormat.isEmpty(rsv9)) {
			  hql.append(" and t.RSV9='").append(rsv9).append("' ");			
		}
     /*   if (!DataFormat.isEmpty(queryReason)) {
			hql.append(" and t.QUERY_REASON='").append(queryReason).append("' ");			
		}
        if (!DataFormat.isEmpty(status)) {
        	hql.append(" and t.STATUS='").append(status).append("' ");			
        }*/
        /*if(!DataFormat.isEmpty()) {
        	
        }*/
        if("1".equals(MyQuery)){
        	hql.append(" and t.CREATE_USER='").append(tlrno).append("' and t.CREATE_TIME>'"+beginTime+"' and t.CREATE_TIME<'"+nowTime+"' ");
        }
        if("2".equals(MyQuery)){
        	hql.append(" and t.CREATE_USER='").append(tlrno).append("' and t.CREATE_TIME>'"+beginTimeOf30+"' and t.CREATE_TIME<'"+nowTime+"' ");
        }
        hql.append(" order by t.CERT_AUTH_STATUS desc,t.QUERY_LEVEL desc,t.STATUS asc,t.RESP_TIME desc");
        
        Iterator it = rootdao.queryBySQL3(hql.toString());
        while(it.hasNext()){
        	Map map = (Map)it.next();
        	bean=new CompanyReport3Bean();
        	
        	if(map.get("id")!=null) {
				bean.setId(map.get("id").toString());
			}
        	if(map.get("entName")!=null) {
        		bean.setEntName(map.get("entName").toString());
        	}
        	if(map.get("entCertType")!=null) {
        		bean.setEntCertType(map.get("entCertType").toString());
        	}
        	if(map.get("rsv9")!=null) {
        		bean.setRsv9(map.get("rsv9").toString());
        	}
        	if(map.get("entCertNum")!=null) {
        		bean.setEntCertNum(map.get("entCertNum").toString());
        	}
        	if(map.get("queryReason")!=null) {
        		bean.setQueryReason(map.get("queryReason").toString());
        	}
        	if(map.get("serviceCode")!=null) {
        		bean.setServiceCode(map.get("serviceCode").toString());
        	}
        	if(map.get("respId")!=null) {
        		bean.setRespId(map.get("respId").toString());
        	}
        	if(map.get("respCode")!=null) {
        		bean.setRespCode(map.get("respCode").toString());
        	}
        	if(map.get("respMsg")!=null) {
        		bean.setRespMsg(map.get("respMsg").toString());
        	}
        	
        	//设置日期格式"yyyy-MM-dd"  DateFormat设置错误，暂且用回string
        	/*DateFormat fmt1 =new SimpleDateFormat("yyyy-MM-dd");
        	if(map.get("queryDate")!=null){
				bean.setQueryDate(fmt1.format(map.get("queryDate")) );
				}*/
        	
        	if(map.get("queryDate")!=null) {
        		bean.setQueryDate(map.get("queryDate").toString());
        	}
        	if(map.get("createUser")!=null) {
        		bean.setCreateUser(map.get("createUser").toString());
        	}
        	//设置日期格式"yyyy-MM-dd HH:mm:ss"
        	//DateFormat fmt =new SimpleDateFormat("yyyyMMddHHmmss");
			/*if(map.get("createTime")!=null){
				bean.setCreateTime(fmt.format(map.get("createTime")) );
				}*/
			if(map.get("createTime")!=null){
				bean.setCreateTime(map.get("createTime").toString());
			}
        	
			bean.setCheckUser((String) map.get("checkUser"));
        	
        	/*if(map.get("checkTime")!=null){
				bean.setCheckTime(fmt.format(map.get("checkTime")) );
				}
        	if(map.get("sendTime")!=null){
				bean.setSendTime(fmt.format(map.get("sendTime")) );
				}
        	if(map.get("respTime")!=null){
				bean.setRespTime(fmt.format(map.get("respTime")) );
				}*/
        	if(map.get("checkTime")!=null){
        		bean.setCheckTime(map.get("checkTime").toString());
        	}
        	if(map.get("sendTime")!=null){
        		bean.setSendTime(map.get("sendTime").toString());
        	}
        	if(map.get("respTime")!=null){
        		bean.setRespTime(map.get("respTime").toString());
        	}
        	
        	if(map.get("status")!=null) {
        		bean.setStatus(map.get("status").toString());
        	}
        	if(map.get("certAuthStatus")!=null) {
        		bean.setCertAuthStatus(map.get("certAuthStatus").toString());
        	}
        	
        	bean.setFuncid1(funcid1);
        	bean.setFuncid2(funcid2);
        	bean.setFuncid3(funcid3);
        	bean.setFuncid4(funcid4);
        	bean.setFuncid5(funcid5);
        	bean.setFuncid6(funcid6);
        	bean.setFuncid7(funcid7);
        	
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

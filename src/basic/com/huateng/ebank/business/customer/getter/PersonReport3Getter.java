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
public class PersonReport3Getter extends BaseGetter {

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
    	String name = (String) getCommQueryServletRequest().getParameterMap().get("name");
    	String idNum = (String) getCommQueryServletRequest().getParameterMap().get("idNum");
/*    	String queryReason = (String) getCommQueryServletRequest().getParameterMap().get("queryReason");
    	String status = (String) getCommQueryServletRequest().getParameterMap().get("status");*/
    	String respId = (String) getCommQueryServletRequest().getParameterMap().get("respId");
        String MyQuery = (String) getCommQueryServletRequest().getParameterMap().get("MyQuery");
    	
        PageQueryResult pageQueryResult =new PageQueryResult();
 
        String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	
        String funcid1=""; //原始个人征信报告
        String funcid2=""; //二代个人征信报告
        String funcid3=""; //二代个人信息核验
        String funcid4=""; //二代个人汇总报告
        String funcid5=""; //查询授权书下载
        String funcid6=""; //二代个人信贷交易明细
        String funcid7=""; //二代个人信息汇总
        
        List<RoleFuncRel> list1 = new ArrayList(); 
        String sql="from RoleFuncRel t1 where t1.roleId in(select t2.roleId from TlrRoleRel t2 where tlrno='"+tlrno+"')";
		 List<RoleFuncRel> listroleFuncRel=rootdao.queryByQL2List(sql);
		 if(listroleFuncRel.size()>0){
			 for (int i = 0; i < listroleFuncRel.size(); i++) {
				String funcid=listroleFuncRel.get(i).getFuncid();
				if("66661801".equals(funcid)){
					funcid1=funcid;
				}
				if("66661802".equals(funcid)){
					funcid2=funcid;
				}
				if("66661803".equals(funcid)){
					funcid3=funcid;
				}
				if("66661804".equals(funcid)){
					funcid4=funcid;
				}
				if("66661805".equals(funcid)){
					funcid5=funcid;
				}
				if("66661806".equals(funcid)){
					funcid6=funcid;
				}
				if("66661807".equals(funcid)){
					funcid7=funcid;
				}
				
			}
		 }
		 
		PersonalReport3Bean bean=null;
		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
			
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
			
		String beginTime=DateUtil.get14Date(c).substring(0,8)+"000000";
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+"000000";
		String nowTime=DateUtil.get14Date().substring(0,8)+DateUtil.get14Date().substring(8,10)+DateUtil.get14Date().substring(10,12)+DateUtil.get14Date().substring(12,14);
	//	String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
	    List list = new ArrayList(); 
		
	    StringBuffer hql = new StringBuffer();
        hql.append("SELECT t.ID AS id,'' as MyQuery,t.NAME AS name,t.ID_TYPE AS idType,t.ID_NUM AS idNum,t.QUERY_REASON AS queryReason,t.SERVICE_CODE AS serviceCode,t.RSV2 as rsv2,t.RESP_ID AS respId,t.QUERY_DATE AS queryDate,t.CREATE_USER AS createUser,t.CREATE_TIME AS createTime,t.CHECK_USER AS checkUser,t.CHECK_TIME AS checkTime,t.SEND_TIME AS sendTime,t.RESP_TIME AS respTime,t.STATUS AS status,t.CERT_AUTH_STATUS AS certAuthStatus,t.RESP_CODE AS respCode,t.RESP_MSG AS respMsg,t.rsv3 FROM CUST_PBOC_PER_QUERY  t WHERE 1 = 1");
        if (!DataFormat.isEmpty(name)) {
        	hql.append(" and t.NAME = '"+name+"' ");
        }
        if (!DataFormat.isEmpty(idNum)) {
        	hql.append(" and t.ID_NUM = '"+idNum+"' ");
        }
        if (!DataFormat.isEmpty(respId)) {
        	hql.append(" and t.RESP_ID = '"+respId+"' ");
        }
        if("1".equals(MyQuery)){
        	hql.append(" and t.CREATE_USER='").append(tlrno).append("' and t.CREATE_TIME>'"+beginTime+"' and t.CREATE_TIME<'"+nowTime+"' ");
        }
        if("2".equals(MyQuery)){
        	hql.append(" and t.CREATE_USER='").append(tlrno).append("' and t.CREATE_TIME>'"+beginTimeOf30+"' and t.CREATE_TIME<'"+nowTime+"' ");
        }
        hql.append(" order by t.CERT_AUTH_STATUS desc,t.QUERY_LEVEL desc,t.STATUS asc,t.RESP_TIME desc");
        
        Iterator it = rootdao.queryBySQL4(hql.toString());
        while(it.hasNext()) {
        	Map map = (Map)it.next();
			bean=new PersonalReport3Bean();
			
			if(map.get("id")!=null) {
				bean.setId(map.get("id").toString());
			}
			if(map.get("name")!=null) {
				bean.setName(map.get("name").toString());
			}
			if(map.get("idType")!=null) {
				bean.setIdType(map.get("idType").toString());
			}
			if(map.get("idNum")!=null) {
				bean.setIdNum(map.get("idNum").toString());
			}
			if(map.get("queryReason")!=null) {
				bean.setQueryReason(map.get("queryReason").toString());
			}
			if(map.get("serviceCode")!=null) {
				bean.setServiceCode(map.get("serviceCode").toString());
			}
			if(map.get("rsv2")!=null) {
				bean.setRsv2(map.get("rsv2").toString());
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
			if(map.get("queryDate")!=null) {
				bean.setQueryDate(map.get("queryDate").toString());
			}
			if(map.get("createUser")!=null) {
				bean.setCreateUser(map.get("createUser").toString());
			}
			if(map.get("createTime")!=null) {
				bean.setCreateTime(map.get("createTime").toString());
			}
			if(map.get("checkUser")!=null) {
				bean.setCheckUser(map.get("checkUser").toString());
			}
			if(map.get("checkTime")!=null) {
				bean.setCheckTime(map.get("checkTime").toString());
			}
			if(map.get("sendTime")!=null) {
				bean.setSendTime(map.get("sendTime").toString());
			}
			if(map.get("respTime")!=null) {
				bean.setRespTime(map.get("respTime").toString());
			}
			if(map.get("status")!=null) {
				bean.setStatus(map.get("status").toString());
			}
			if(map.get("certAuthStatus")!=null) {
				bean.setCertAuthStatus(map.get("certAuthStatus").toString());
			}
			if(map.get("rsv3")!=null) {
				bean.setRsv3(map.get("rsv3").toString());
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
    	
		String hql = PersonReport2Sql.queryPersonReport(map).getSql();
		PageQueryResult pageQueryResult = rootDao.pageQueryByHql(page.getCurrentPage(), page.getEveryPage(), hql);
		return pageQueryResult;*/
    }
        
}

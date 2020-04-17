/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.customer.getter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.TDetailIndApp;

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


/**
 * @author 
 *
 */
@SuppressWarnings("unchecked")
public class NaturePersonCodeGetter extends BaseGetter {

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

	@SuppressWarnings({ "unused", "rawtypes" })
	protected PageQueryResult getData() throws Exception {
        String idType = (String) getCommQueryServletRequest().getParameterMap().get("individualIdType");
        String individualId = (String) getCommQueryServletRequest().getParameterMap().get("individualId");
        String name = (String) getCommQueryServletRequest().getParameterMap().get("name");
        String MyQuery = (String) getCommQueryServletRequest().getParameterMap().get("MyQuery");
        String rptId = (String) getCommQueryServletRequest().getParameterMap().get("rptId");
        PageQueryResult pageQueryResult = new PageQueryResult();
        String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String funcid1=""; //原始个人征信报告
        String funcid2=""; //个人信息汇总 
        String funcid3=""; //个人信息核验
        String funcid4=""; //个人汇总报告
        String funcid5=""; //用户许可下载
        List<RoleFuncRel> list1 = new ArrayList(); 
        String sql="from RoleFuncRel t1 where t1.roleId in(select t2.roleId from TlrRoleRel t2 where tlrno='"+tlrno+"')";
		 List<RoleFuncRel> listroleFuncRel=rootdao.queryByQL2List(sql);
		 if(listroleFuncRel.size()>0){
			 for (int i = 0; i < listroleFuncRel.size(); i++) {
				String funcid=listroleFuncRel.get(i).getFuncid();
				if("66661001".equals(funcid)){
					funcid1=funcid;
				}
				if("66661002".equals(funcid)){
					funcid2=funcid;
				}
				if("66661003".equals(funcid)){
					funcid3=funcid;
				}
				if("66661004".equals(funcid)){
					funcid4=funcid;
				}
				if("66661005".equals(funcid)){
					funcid5=funcid;
				}
				
			}
		 }
		 TDetailIndApp bean=null;
		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		//换oracle数据库，调整日期格式  20191209-qx
		//String beginTime=DateUtil.get14Date(c).substring(0,8)+" 00:00:00";
		String beginTime = DateUtil.get14Date(c).substring(0,4)+"-"+DateUtil.get14Date(c).substring(4,6)+"-"+DateUtil.get14Date(c).substring(6,8)+" 00:00:00"+".000000";
		//String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
		String nowTime=DateUtil.get14Date().substring(0,4)+"-"+DateUtil.get14Date().substring(4,6)+"-"+DateUtil.get14Date().substring(6,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14)+".000000";
        List list = new ArrayList(); 
        StringBuffer hql = new StringBuffer();
        hql.append("select ta.name,ta.rpt_key as rptKey,ta.id as id,ta.individual_id_type as idType,'' as MyQuery,rtrim(ta.individual_id) as individualId,ta.input_user as inputUser,ta.query_time as queryTime,ta.return_time as returnTime,ta.input_time as inputTime,ta.status as status from t_detail_ind_app ta where 1=1 ");
        if (!DataFormat.isEmpty(individualId)) {
        	hql.append(" and ta.Individual_id = '"+individualId+"' ");
        }
        if (!DataFormat.isEmpty(idType)) {
        	hql.append(" and ta.individual_id_type = '"+idType+"' ");
        }
        if("1".equals(MyQuery)){
        	//hql.append(" and ta.input_user='").append(tlrno).append("' and ta.query_time>'"+beginTime+"' and ta.query_time<'"+nowTime+"' ");
        	//换oracle数据库，调整日期格式  20191209-qx
        	hql.append(" and ta.input_user='").append(tlrno).append("' and to_char(ta.query_time,'yyyy-mm-dd hh24:mi:ssxff')>'"+beginTime+"' and to_char(ta.query_time,'yyyy-mm-dd hh24:mi:ssxff')<'"+nowTime+"' ");
        	
        }
        hql.append(" order by ta.return_time desc ");
        Iterator it = rootdao.queryBySQL2(hql.toString());
		while(it.hasNext()){
			Map map = (Map)it.next();
			bean=new TDetailIndApp();
			if(map.get("rptKey")!=null){
				bean.setRptKey(map.get("rptKey").toString());
				}
			if(map.get("idType")!=null){
			bean.setIndividualIdType(map.get("idType").toString());
			}
			
			if(map.get("individualId")!=null){
			bean.setIndividualId(map.get("individualId").toString());
			}
			if(map.get("name")!=null){
				bean.setName(map.get("name").toString());
				}
			SimpleDateFormat  fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(map.get("queryTime")!=null){
			bean.setQueryTime((Timestamp) map.get("queryTime"));
			}
			if(map.get("inputTime")!=null){
				bean.setInputTime((Timestamp) map.get("inputTime"));
				}
			if(map.get("returnTime")!=null){
			bean.setReturnTime((Timestamp) map.get("returnTime"));
			}
			if(map.get("inputUser")!=null){
			bean.setInputUser(map.get("inputUser").toString());
			}
			
			if(map.get("status")!=null){
				bean.setStatus(map.get("status").toString());
			}
			if(map.get("id")!=null){
				bean.setId((Integer) map.get("id"));
			}
			
//			bean.setFuncid1(funcid1);
//			bean.setFuncid2(funcid2);
//			bean.setFuncid3(funcid3);
//			bean.setFuncid4(funcid4);
//			bean.setFuncid5(funcid5);
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
    }
}

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.assure.getter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.InqCust;
import resource.bean.basic.RoleFuncRel;

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
public class AssureIndCustGetter extends BaseGetter {

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
        String individualId = (String) getCommQueryServletRequest().getParameterMap().get("individualId");
        String MyQuery = (String) getCommQueryServletRequest().getParameterMap().get("MyQuery");
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
		AssureReportBean bean=null;
		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		//String beginTime=DateUtil.get14Date(c).substring(0,8)+" 00:00:00";
		String beginTime=DateUtil.get14Date(c).substring(0,4)+"-"+DateUtil.get14Date(c).substring(4,6)+"-"+DateUtil.get14Date(c).substring(6,8)+" 00:00:00"+".000000";
		//String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
		String nowTime=DateUtil.get14Date().substring(0,4)+"-"+DateUtil.get14Date().substring(4,6)+"-"+DateUtil.get14Date().substring(6,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14)+".999999";
		List list = new ArrayList(); 
        StringBuffer hql = new StringBuffer();
        hql.append("select ia.individual_id_type as individualIdType,'' as MyQuery, rtrim(ia.individual_id) as individualId,ia.name as name," +
        		"ia.input_user as inputUser,rtrim(ia.rpt_Key) as rptKey,rtrim(ia.status) as status, ia.query_Time as queryTime,ia.id as id," +
        		"ia.return_Time as returnTime,ia.parse_Time as parseTime,ia.input_Time as inputTime, ic.consent_file_path as consentFilePath," +
        		"ic.non_consent_file_path as nonConsentFilePath, ic.app_Id as appId from assure_ind_app ia left join assure_ind_cust ic on ia.id=ic.app_Id where 1=1");
        if (!DataFormat.isEmpty(individualId)) {
        	hql.append(" and ia.individual_id = '"+individualId+"' ");
        }
        if (!DataFormat.isEmpty(name)) {
        	hql.append(" and ia.name = '"+name+"' ");
        }
        if("1".equals(MyQuery)){
        	hql.append(" and ia.input_user='").append(tlrno).append("' and to_char(ia.input_Time,'yyyy-mm-dd hh24:mi:ssxff') >'"+beginTime+"' and to_char(ia.input_Time,'yyyy-mm-dd hh24:mi:ssxff') <'"+nowTime+"' ");
        }
        hql.append(" order by ia.return_time desc,ia.input_Time desc ");
        Iterator it = rootdao.queryBySQL2(hql.toString());
		while(it.hasNext()){
			Map map = (Map)it.next();
			bean=new AssureReportBean();
			if(map.get("individualIdType")!=null){
			bean.setIndividualIdType(map.get("individualIdType").toString());
			}
			if(map.get("consentFilePath")!=null){
				String fName = (String) map.get("consentFilePath").toString().trim();  
				bean.setConsentFilePath(fName);
			}
			if(map.get("individualId")!=null){
			bean.setIndividualId(map.get("individualId").toString());
			}
			bean.setName((String) map.get("name"));
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			if(map.get("createTime")!=null){
//			bean.setCreateTime(fmt.format(map.get("createTime")) );
//			}
			if(map.get("returnTime")!=null){
			bean.setReturnTime(fmt.format(map.get("returnTime")) );
			}
			if(map.get("inputTime")!=null){
				bean.setInputTime(fmt.format(map.get("inputTime")) );
				}
			if(map.get("queryTime")!=null){
				bean.setQueryTime(fmt.format(map.get("queryTime")) );
				}
			bean.setInputUser((String) map.get("inputUser"));
			if(map.get("consentFilePath")!=null){
			String fName = (String) map.get("consentFilePath").toString().trim();  
	        String fileName = fName.substring(fName.lastIndexOf("/")+1); 
			bean.setConsentFilePath(fileName);
			
			}
		
			if(map.get("nonConsentFilePath")!=null){
			String nonfName = (String) map.get("nonConsentFilePath").toString().trim();  
	        String nonfileName = nonfName.substring(nonfName.lastIndexOf("/")+1); 
			bean.setNonConsentFilePath(nonfileName);
			}
			if(map.get("rptKey")!=null){
			bean.setRptKey(map.get("rptKey").toString());
			}
			if(map.get("appId")!=null){
			String appId=map.get("appId").toString();
			bean.setAppId(appId);
			}
			if(map.get("status")!=null){
				bean.setStatus(map.get("status").toString());
			}
			if(map.get("id")!=null){
				int id=Integer.parseInt(map.get("id").toString());
				bean.setId(id);
			}
			bean.setFuncid1(funcid1);
			bean.setFuncid2(funcid2);
			bean.setFuncid3(funcid3);
			bean.setFuncid4(funcid4);
			bean.setFuncid5(funcid5);
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

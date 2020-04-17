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
public class InqCustGetter extends BaseGetter {

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
        String idType = (String) getCommQueryServletRequest().getParameterMap().get("idType");
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
		PersonalReportBean bean=null;
		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
		//String beginTime=DateUtil.get14Date(c).substring(0,8)+" 00:00:00";
		String beginTime=DateUtil.get14Date(c).substring(0,4)+"-"+DateUtil.get14Date(c).substring(4,6)+"-"+DateUtil.get14Date(c).substring(6,8)+" 00:00:00"+".000000";
		//String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+" 00:00:00";
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,4)+"-"+DateUtil.get14Date(d).substring(4,6)+"-"+DateUtil.get14Date(d).substring(6,8)+" 00:00:00"+".000000";
		//String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
		String nowTime=DateUtil.get14Date().substring(0,4)+"-"+DateUtil.get14Date().substring(4,6)+"-"+DateUtil.get14Date().substring(6,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14)+".999999";
        List list = new ArrayList(); 
        StringBuffer hql = new StringBuffer();
        hql.append("select ia.id_type as idType,'' as MyQuery,rtrim(ia.Individual_id) as individualId,ia.name as name,ic.query_reason as queryReason,ic.inq_cust_type as inqCustType,ic.create_time as createTime,ic.create_user as createUser,ic.consent_file_path as consentFilePath,ic.non_workhour_filepath as nonWorkhourFilepath,ic.inq_type as inqType,rtrim(ia.Rpt_id) as rptId,ic.inq_cust_appid as inqCustAppid,ia.return_time as returnTime,rtrim(ia.status) as status,ic.rel_name as relName,ic.rel_corp_id as relCorpId,ic.id as id from ind_app ia left join inq_cust ic on ia.id=ic.inq_cust_appid where 1=1 ");
      //add by chensibi start   不展示2020年2月15号以后的数据
	    hql.append( " and to_char(ia.query_time,'yyyyMMddHHmmss') <='20200215000000'");
	    //add by chensibi end 
        if (!DataFormat.isEmpty(individualId)) {//
        	hql.append(" and ia.Individual_id = '"+individualId+"' ");
        }
        if (!DataFormat.isEmpty(rptId)) {
        	hql.append(" and ia.Rpt_id = '"+rptId+"' ");
        }
        if (!DataFormat.isEmpty(name)) {
        	hql.append(" and ia.name = '"+name+"' ");
        }
        if("1".equals(MyQuery)){
        	//hql.append(" and ic.create_user='").append(tlrno).append("' and ic.create_time>'"+beginTime+"' and ic.create_time<'"+nowTime+"' ");
        	hql.append(" and ic.create_user='").append(tlrno).append("' and to_char(ic.create_time,'yyyy-mm-dd hh24:mi:ssxff') >'"+beginTime+"' and to_char(ic.create_time,'yyyy-mm-dd hh24:mi:ssxff') <'"+nowTime+"' ");
        }
        if("2".equals(MyQuery)){
        	//hql.append(" and ic.create_user='").append(tlrno).append("' and ic.create_time>'"+beginTimeOf30+"' and ic.create_time<'"+nowTime+"' ");
        	hql.append(" and ic.create_user='").append(tlrno).append("' and to_char(ic.create_time,'yyyy-mm-dd hh24:mi:ssxff') >'"+beginTimeOf30+"' and to_char(ic.create_time,'yyyy-mm-dd hh24:mi:ssxff') <'"+nowTime+"' ");
        }
        hql.append(" order by ia.return_time desc,ic.create_time desc ");
        Iterator it = rootdao.queryBySQL2(hql.toString());
		while(it.hasNext()){
			Map map = (Map)it.next();
			bean=new PersonalReportBean();
			if(map.get("IDTYPE")!=null){
			bean.setIdType(map.get("IDTYPE").toString());
			}
			if(map.get("CONSENTFILEPATH")!=null){
				String fName = (String) map.get("CONSENTFILEPATH").toString().trim();  
				bean.setConsentFilePath2(fName);
			}
			if(map.get("INDIVIDUALID")!=null){
			bean.setIndividualId(map.get("INDIVIDUALID").toString());
			}
			bean.setName((String) map.get("NAME"));
			bean.setQueryReason((String) map.get("QUERYREASON"));
			bean.setInqCustType((String) map.get("INQCUSTTYPE"));
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(map.get("CREATETIME")!=null){
			bean.setCreateTime(fmt.format(map.get("CREATETIME")) );
			}
			if(map.get("RETURNTIME")!=null){
			bean.setReturnTime(fmt.format(map.get("RETURNTIME")) );
			}
			bean.setCreateUser((String) map.get("CREATEUSER"));
			if(map.get("CONSENTFILEPATH")!=null){
			String fName = (String) map.get("CONSENTFILEPATH").toString().trim();  
	        String fileName = fName.substring(fName.lastIndexOf("/")+1); 
			bean.setConsentFilePath(fileName);
			
			}
		
			if(map.get("NONWORKHOURFILEPATH")!=null){
			String nonfName = (String) map.get("NONWORKHOURFILEPATH").toString().trim();  
	      //  String nonfileName = nonfName.substring(nonfName.lastIndexOf("/")+1); 
			bean.setNonWorkhourFilepath(nonfName);
			}
			if(map.get("RPTID")!=null){
			bean.setRptId(map.get("RPTID").toString());
			}
			if(map.get("INQCUSTAPPID")!=null){
			int inqCustAppid=Integer.parseInt(map.get("INQCUSTAPPID").toString());
			bean.setInqCustAppid(inqCustAppid);
			}
			if(map.get("STATUS")!=null){
				bean.setStatus(map.get("STATUS").toString());
			}
			bean.setRelName((String) map.get("RELNAME"));
			bean.setRelCorpId((String) map.get("RELCORPID"));
			if(map.get("ID")!=null){
				int id=Integer.parseInt(map.get("ID").toString());
				bean.setId(id);
				}
/*			while(it.hasNext()){
				Map map = (Map)it.next();
				bean=new PersonalReportBean();
				if(map.get("idType")!=null){
					bean.setIdType(map.get("idType").toString());
				}
				if(map.get("consentFilePath")!=null){
					String fName = (String) map.get("consentFilePath").toString().trim();  
					bean.setConsentFilePath2(fName);
				}
				if(map.get("individualId")!=null){
					bean.setIndividualId(map.get("individualId").toString());
				}
				bean.setName((String) map.get("name"));
				bean.setQueryReason((String) map.get("queryReason"));
				bean.setInqCustType((String) map.get("inqCustType"));
				DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if(map.get("createTime")!=null){
					bean.setCreateTime(fmt.format(map.get("createTime")) );
				}
				if(map.get("returnTime")!=null){
					bean.setReturnTime(fmt.format(map.get("returnTime")) );
				}
				bean.setCreateUser((String) map.get("createUser"));
				if(map.get("consentFilePath")!=null){
					String fName = (String) map.get("consentFilePath").toString().trim();  
					String fileName = fName.substring(fName.lastIndexOf("/")+1); 
					bean.setConsentFilePath(fileName);
					
				}
				
				if(map.get("nonWorkhourFilepath")!=null){
					String nonfName = (String) map.get("nonWorkhourFilepath").toString().trim();  
					//  String nonfileName = nonfName.substring(nonfName.lastIndexOf("/")+1); 
					bean.setNonWorkhourFilepath(nonfName);
				}
				if(map.get("rptId")!=null){
					bean.setRptId(map.get("rptId").toString());
				}
				if(map.get("inqCustAppid")!=null){
					int inqCustAppid=Integer.parseInt(map.get("inqCustAppid").toString());
					bean.setInqCustAppid(inqCustAppid);
				}
				if(map.get("status")!=null){
					bean.setStatus(map.get("status").toString());
				}
				bean.setRelName((String) map.get("relName"));
				bean.setRelCorpId((String) map.get("relCorpId"));
				if(map.get("id")!=null){
					int id=Integer.parseInt(map.get("id").toString());
					bean.setId(id);
				}
*/			bean.setFuncid1(funcid1);
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

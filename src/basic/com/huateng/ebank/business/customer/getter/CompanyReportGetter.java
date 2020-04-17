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

import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.TCorpApp;


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
public class CompanyReportGetter extends BaseGetter {

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
        String corpCustLoancard = (String) getCommQueryServletRequest().getParameterMap().get("corpCustLoancard");
        String corpCustCompanyname = (String) getCommQueryServletRequest().getParameterMap().get("corpCustCompanyname");
        String MyQuery = (String) getCommQueryServletRequest().getParameterMap().get("MyQuery");
        String rptKey = (String) getCommQueryServletRequest().getParameterMap().get("rptKey");
        PageQueryResult pageQueryResult = new PageQueryResult();
        String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String funcid10=""; //原始企业一般报告下载
        String funcid11="";//企业信息汇总 
        String funcid12="";//原始企业明细报告下载 
        String funcid13="";//企业信用一级下载
        String funcid14="";//企业信息校验
        String funcid15="";//查询授权书下载
        String funcid1=""; //关联信息
        String funcid2=""; //身份信息
        String funcid3=""; //主要出资人信息、高管人员信息
        String funcid4=""; //有直接关联关系的其他企业
        String funcid5=""; //信息概要
        String funcid6=""; //信贷记录明细
        String funcid7=""; //公共记录明细
        String funcid8=""; //声明信息明细
        List<RoleFuncRel> list1 = new ArrayList(); 
        String sql="from RoleFuncRel t1 where t1.roleId in(select t2.roleId from TlrRoleRel t2 where tlrno='"+tlrno+"')";
		 List<RoleFuncRel> listroleFuncRel=rootdao.queryByQL2List(sql);
		 if(listroleFuncRel.size()>0){
			 for (int i = 0; i < listroleFuncRel.size(); i++) {
				String funcid=listroleFuncRel.get(i).getFuncid();
				if("66662401".equals(funcid)){
					funcid10=funcid;
				}
				if("66662404".equals(funcid)){
					funcid13=funcid;
				}
				
				if("66662405".equals(funcid)){
					funcid14=funcid;
				}
				if("66662406".equals(funcid)){
					funcid15=funcid;
				}
				if("66662402".equals(funcid)){
					funcid11=funcid;
				}
				if("66662403".equals(funcid)){
					funcid12=funcid;
				}
				
				if("6666240201".equals(funcid)){
					funcid1=funcid;
				}
				if("6666240202".equals(funcid)){
					funcid2=funcid;
				}
				if("6666240203".equals(funcid)){
					funcid3=funcid;
				}
				if("6666240204".equals(funcid)){
					funcid4=funcid;
				}
				if("6666240205".equals(funcid)){
					funcid5=funcid;
				}
				if("6666240206".equals(funcid)){
					funcid6=funcid;
				}
				if("6666240207".equals(funcid)){
					funcid7=funcid;
				}
				if("6666240208".equals(funcid)){
					funcid8=funcid;
				}
				
				
			}
		 }
		CompanyReportBean bean=null;
		String nowDate=DateUtil.get8Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
		Date newtfmstime=df.parse(nowDate);
		Calendar c=Calendar.getInstance();
		c.setTime(newtfmstime);
		c.add(Calendar.DAY_OF_MONTH, -6);
		//String beginTime=DateUtil.get14Date(c).substring(0,8)+" 00:00:00";
		String beginTime=DateUtil.get14Date(c).substring(0,4)+"-"+DateUtil.get14Date(c).substring(4,6)+"-"+DateUtil.get14Date(c).substring(6,8)+" 00:00:00"+".000000";
		Calendar d=Calendar.getInstance();
		d.setTime(newtfmstime);
		d.add(Calendar.DAY_OF_MONTH, -29);
		//String beginTimeOf30=DateUtil.get14Date(d).substring(0,8)+" 00:00:00";
		String beginTimeOf30=DateUtil.get14Date(d).substring(0,4)+"-"+DateUtil.get14Date(d).substring(4,6)+"-"+DateUtil.get14Date(d).substring(6,8)+" 00:00:00"+".000000";		
		//String nowTime=DateUtil.get14Date().substring(0,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14);
		String nowTime=DateUtil.get14Date().substring(0,4)+"-"+DateUtil.get14Date().substring(4,6)+"-"+DateUtil.get14Date().substring(6,8)+" "+DateUtil.get14Date().substring(8,10)+":"+DateUtil.get14Date().substring(10,12)+":"+DateUtil.get14Date().substring(12,14)+".999999";       
		List list = new ArrayList(); 
        StringBuffer hql = new StringBuffer();
        hql.append("select tca.corp_cust_loancard as corpCustLoancard,'' as MyQuery,tca.corp_cust_companyname as corpCustCompanyname,tca.ent_cert_type as entCertType,tca.ent_cert_num as entCertNum,tca.service_code as serviceCode, tca.query_reason as queryReason,tca.corp_cust_type as corpCustType,tca.rel_name as relName,tca.rel_corp_id as relCorpId,tca.create_time as createTime,tca.create_user as createUser,tca.consent_file_path as consentFilePath,tca.non_workhour_filepath as nonWorkhourFilepath,tca.detail_flag as detailFlag,cc.return_time as ccreturnTime,tcda.return_time as tcdareturnTime,cc.rpt_key as rptKey,tca.id as id,cc.status as status,tcda.status as detailstatus,tcda.rpt_key as detailrptKey from corp_cust tca left join t_corp_app cc on tca.corp_cust_appid=cc.id left join t_corp_detail_app tcda   on tcda.id=tca.corp_cust_detail_id where 1=1");
        if (!DataFormat.isEmpty(corpCustLoancard)) {
			hql.append(" and tca.corp_cust_loancard='").append(corpCustLoancard).append("' ");			
		}
        if (!DataFormat.isEmpty(corpCustCompanyname)) {
			hql.append(" and tca.corp_cust_companyname='").append(corpCustCompanyname).append("' ");			
		}
        if (!DataFormat.isEmpty(rptKey)) {
			hql.append(" and cc.rpt_key='").append(rptKey).append("' ");			
		}
        if("1".equals(MyQuery)){
        	//hql.append(" and tca.create_user='").append(tlrno).append("' and tca.create_time>'"+beginTime+"' and tca.create_time<'"+nowTime+"' ");
        	hql.append(" and tca.create_user='").append(tlrno).append("' and to_char(tca.create_time,'yyyy-mm-dd hh24:mi:ssxff') >'"+beginTime+"' and to_char(tca.create_time,'yyyy-mm-dd hh24:mi:ssxff') <'"+nowTime+"' ");           
        }
        if("2".equals(MyQuery)){
        	//hql.append(" and tca.create_user='").append(tlrno).append("' and tca.create_time>'"+beginTimeOf30+"' and tca.create_time<'"+nowTime+"' ");
        	hql.append(" and tca.create_user='").append(tlrno).append("' and to_char(tca.create_time,'yyyy-mm-dd hh24:mi:ssxff') >'"+beginTimeOf30+"' and to_char(tca.create_time,'yyyy-mm-dd hh24:mi:ssxff') <'"+nowTime+"' ");
        }
        hql.append(" order by tca.create_time desc,cc.return_time desc,tcda.return_time desc ");
        Iterator it = rootdao.queryBySQL2(hql.toString());
		while(it.hasNext()){
			Map map = (Map)it.next();
			bean=new CompanyReportBean();
			bean.setCorpCustLoancard((String) map.get("CORPCUSTLOANCARD"));
			bean.setCorpCustCompanyname((String) map.get("CORPCUSTCOMPANYNAME"));
			bean.setQueryReason((String) map.get("QUERYREASON"));
			if(map.get("ENTCERTTYPE")!=null) {
				bean.setEntCertType(map.get("ENTCERTTYPE").toString());
			}
			if(map.get("ENTCERTNUM")!=null) {
				bean.setEntCertNum(map.get("ENTCERTNUM").toString());
			}
			if(map.get("SERVICECODE")!=null) {
				bean.setServiceCode(map.get("SERVICECODE").toString());
			}
			if(map.get("CORPCUSTTYPE")!=null){
			bean.setCorpCustType(map.get("CORPCUSTTYPE").toString());
			}
			bean.setRelName((String) map.get("RELNAME"));
			bean.setRelCorpId((String) map.get("RELCORPID"));
			if(map.get("CONSENTFILEPATH")!=null){
				String fName = (String) map.get("CONSENTFILEPATH").toString().trim();  
				bean.setConsentFilePath2(fName);
			}
			DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(map.get("CREATETIME")!=null){
				bean.setCreateTime(fmt.format(map.get("CREATETIME")) );
				}
			bean.setCreateUser((String) map.get("CREATEUSER"));
			if(map.get("CONSENTFILEPATH")!=null){
			String fName = (String) map.get("CONSENTFILEPATH").toString().trim();  
	        String fileName = fName.substring(fName.lastIndexOf("/")+1);  
			bean.setConsentFilePath(fileName);
			}
			if(map.get("NONWORKHOURFILEPATH")!=null){
			String nFilepath=(String) map.get("NONWORKHOURFILEPATH").toString().trim();
			//String nonWorkhourFileName=nFilepath.substring(nFilepath.lastIndexOf("/")+1);
			bean.setNonWorkhourFilepath(nFilepath);
			}
			if(map.get("DETAILFLAG")!=null){
			bean.setDetailFlag(map.get("DETAILFLAG").toString());
			}
			if(map.get("CCRETURNTIME")!=null){
			bean.setCcreturnTime(fmt.format(map.get("CCRETURNTIME")));
			}
			if(map.get("TCDARETURNTIME")!=null){
				bean.setTcdareturnTime(fmt.format(map.get("TCDARETURNTIME")));
				}
			bean.setRptKey((String) map.get("RPTKEY"));
			if(map.get("ID")!=null){
			int Id=Integer.parseInt(map.get("ID").toString());
			bean.setId(Id);
			}
			bean.setDetailrptKey((String) map.get("DETAILRPTKEY"));
			bean.setStatus((String) map.get("STATUS"));
			bean.setDetailstatus((String) map.get("DETAILSTATUS"));
//			bean.setId(map.get("id").toString());
			bean.setFuncid1(funcid1);
			bean.setFuncid2(funcid2);
			bean.setFuncid3(funcid3);
			bean.setFuncid4(funcid4);
			bean.setFuncid5(funcid5);
			bean.setFuncid6(funcid6);
			bean.setFuncid7(funcid7);
			bean.setFuncid8(funcid8);
			bean.setFuncid10(funcid10);
			bean.setFuncid11(funcid11);
			bean.setFuncid12(funcid12);
			bean.setFuncid13(funcid13);
			bean.setFuncid14(funcid14);
			bean.setFuncid15(funcid15);
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

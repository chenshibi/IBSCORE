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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.DateUtil;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.itextpdf.text.log.SysoLogger;

import resource.bean.basic.CorpScurbInfo;
import resource.bean.basic.CorpScurbInfoBean;
import resource.bean.basic.IndScrubInfo;

/**
 * @author zhiguo.zhao
 *
 */
@SuppressWarnings("unchecked")
public class CorpScrubInfoQuerydetailsGetter extends BaseGetter {

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
        String batchId = (String) getCommQueryServletRequest().getParameterMap().get("batchId");
        PageQueryResult pageQueryResult = new PageQueryResult();
        List<CorpScurbInfoBean> list = new ArrayList<CorpScurbInfoBean>(); 
        StringBuffer hql = new StringBuffer("select t1.*,t1.status as tstatus,t2.status as detailStatus");
        hql.append(" from corp_scurb_info t1 left join T_CORP_DETAIL_APP t2 on  t2.id=t1.detail_App_Id ");
        hql.append(" where t1.batch_Id = '"+batchId+"' ");
        //一般报告查询状态 
        StringBuffer hqlquery = new StringBuffer("select count(status) as query from CorpScurbInfo  where  status='0' and batchId='"+batchId+"'");
        StringBuffer hqlcheckNoPass = new StringBuffer("select count(status) from CorpScurbInfo isi where status='1' and batchId='"+batchId+"'");
        StringBuffer hqlquerySuccess = new StringBuffer("select count(status)  from CorpScurbInfo isi where status='2'  and batchId='"+batchId+"'");
        StringBuffer hqlqueryDefeat = new StringBuffer("select count(status)  from CorpScurbInfo isi where status='3' and batchId='"+batchId+"'");
        
        //详细报告查询状态
		StringBuffer hqlqueryDetail = new StringBuffer("select count(t2.status) as detailStatus from CorpScurbInfo t1,TCorpDetailApp t2   where t1.detailAppId=t2.id and  (t2.status='1' or t2.status='2') and t1.batchId='"+batchId+"'");
      //  StringBuffer hqlcheckNoPassDetail = new StringBuffer("select count(t2.status) as detailStatus from CorpScurbInfo t1,TCorpDetailApp t2   where t1.detailAppId=t2.id and  t2.status='1' and t1.batchId='"+batchId+"'");
        StringBuffer hqlquerySuccessDetail = new StringBuffer("select count(t2.status) as detailStatus from CorpScurbInfo t1,TCorpDetailApp t2   where t1.detailAppId=t2.id and  t2.status='0' and t1.batchId='"+batchId+"'");
        StringBuffer hqlqueryDefeatDetail = new StringBuffer("select count(t2.status) as detailStatus from CorpScurbInfo t1,TCorpDetailApp t2   where t1.detailAppId=t2.id and  t2.status<>'0' and t2.status<>'1' and t2.status<>'2' and t1.batchId='"+batchId+"'");
        
        @SuppressWarnings("unchecked")
//        List<CorpScurbInfo> listCorpScrubInfo = rootdao.queryByCondition(hql.toString());
        Iterator it =rootdao.queryBySQL2(hql.toString());
        //一般报告查询状态统计
        Long queryCount=  (Long) rootdao.queryByCondition(hqlquery.toString()).get(0);
        Long querycheckNoPassCount=  (Long) rootdao.queryByCondition(hqlcheckNoPass.toString()).get(0); 
        Long querySuccessCount=  (Long) rootdao.queryByCondition(hqlquerySuccess.toString()).get(0); 
        Long queryDefeatCount=  (Long) rootdao.queryByCondition(hqlqueryDefeat.toString()).get(0); 
       
      //详细报告查询状态统计
        Long queryCountDetail=  (Long) rootdao.queryByCondition(hqlqueryDetail.toString()).get(0);
//        Long querycheckNoPassCountDetail=  (Long) rootdao.queryByCondition(hqlcheckNoPassDetail.toString()).get(0); 
        Long querySuccessCountDetail=  (Long) rootdao.queryByCondition(hqlquerySuccessDetail.toString()).get(0); 
        Long queryDefeatCountDetail=  (Long) rootdao.queryByCondition(hqlqueryDefeatDetail.toString()).get(0); 
        
    	while(it.hasNext()){
			Map map = (Map)it.next();
			 CorpScurbInfoBean corpScrubInfoBean = new CorpScurbInfoBean();
			 if(null != map.get("RPT_KEY") && !"".equals(map.get("RPT_KEY"))){
				 corpScrubInfoBean.setRptKey((String) map.get("RPT_KEY"));
			 }
			 if(null != map.get("BATCH_ID") && !"".equals(map.get("BATCH_ID"))){
				 //Integer.valueOf(s)   (Integer)map.get("BATCH_ID")
				 corpScrubInfoBean.setBatchId(Integer.valueOf(map.get("BATCH_ID").toString()));			 
			 }
			 if(map.get("NAME")!=null && !"".equals(map.get("NAME"))){
				 corpScrubInfoBean.setName((String) map.get("NAME"));
			 }
			 if(map.get("APP_ID")!=null && !"".equals(map.get("APP_ID"))){
				 corpScrubInfoBean.setAppId((Integer)map.get("APP_ID"));
			 }
		     if(map.get("DETAIL_APP_ID")!=null && !"".equals(map.get("DETAIL_APP_ID"))){
		    	 corpScrubInfoBean.setDetailAppId((Integer)map.get("DETAIL_APP_ID"));
		     }
			 if(map.get("LOAN_NO")!=null && !"".equals(map.get("LOAN_NO"))){
				 corpScrubInfoBean.setLoanNo((String)map.get("LOAN_NO"));
			 }
			 if(map.get("LOANCARD")!=null && !"".equals(map.get("LOANCARD"))){
				 corpScrubInfoBean.setLoancard((String)map.get("LOANCARD"));
			 }
			 if(map.get("PASSWORD")!=null && !"".equals(map.get("PASSWORD"))){
				 corpScrubInfoBean.setPassword((String)map.get("PASSWORD"));
			 }
			 DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 if(map.get("INPUT_TIME")!=null && !"".equals(map.get("INPUT_TIME"))){
				corpScrubInfoBean.setInputTime(fmt.format(map.get("INPUT_TIME")) );
			 }
			 if(map.get("RETURN_TIME")!=null && !"".equals(map.get("RETURN_TIME"))){
				corpScrubInfoBean.setReturnTime(fmt.format(map.get("RETURN_TIME")) );
			 }
			 if(null != map.get("CREATE_USER") && !"".equals(map.get("CREATE_USER"))){
				 corpScrubInfoBean.setCreateUser((String)map.get("CREATE_USER"));
			 }
			 if(null != map.get("ORGCODE") && !"".equals(map.get("ORGCODE"))){
				 corpScrubInfoBean.setOrgcode((String)map.get("ORGCODE"));
			 }
			 if(null != map.get("TSTATUS") && !"".equals(map.get("TSTATUS"))){
				 corpScrubInfoBean.setStatus(map.get("TSTATUS").toString());
			 }
			 if(null != map.get("DETAILSTATUS") && !"".equals(map.get("DETAILSTATUS"))){
				 corpScrubInfoBean.setDetailstatus((String)map.get("DETAILSTATUS"));
			 }
			
			 if(null != map.get("QUERY_REASON") && !"".equals(map.get("QUERY_REASON"))){
				 corpScrubInfoBean.setQueryReason((String)map.get("QUERY_REASON")); 
			 }
			 
			 corpScrubInfoBean.setQuerySuccess(querySuccessCount);
			 corpScrubInfoBean.setQuery(queryCount);
			 corpScrubInfoBean.setQueryDefeat(queryDefeatCount);
			 corpScrubInfoBean.setCheckNoPass(querycheckNoPassCount);
			 corpScrubInfoBean.setQueryDefeatDetail(queryDefeatCountDetail);
			 corpScrubInfoBean.setQueryDetail(queryCountDetail);
			 corpScrubInfoBean.setQuerySuccessDetail(querySuccessCountDetail);
			 corpScrubInfoBean.setCheckNoPassDetail(querycheckNoPassCount);
			 list.add(corpScrubInfoBean);
			 
    	}
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        /** 对最后一页的处理 */
        if (maxIndex > list.size()) {
            maxIndex = list.size();
        }
        List rs = new ArrayList();
        rs = list.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(list.size());
        pageQueryResult.setQueryResult(rs);
        return pageQueryResult;
    }
    
}

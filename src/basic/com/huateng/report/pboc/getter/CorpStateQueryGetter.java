package com.huateng.report.pboc.getter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.bean.CorpStateQueryBean;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.common.PbocConstants;

/**
 * @author Grassy
 * @date 2019/5/31 17:00
 * @jdk.version 1.8
 * @desc
 */
public class CorpStateQueryGetter extends BaseGetter {
    @Override
    public Result call() throws AppException {
        try {
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(), getResult());
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

    private PageQueryResult getData() throws Exception {
    	PageQueryResult pageQueryResult =new PageQueryResult();
    	Map<String, String> requestMap = getCommQueryServletRequest().getParameterMap();
		String startDate = requestMap.get("etlDateStart");
		String endDate =   requestMap.get("etlDateEnd");
    /*	 Map<String,Object> paramMap=new HashMap<String,Object>();
    	 paramMap.put("startDate",startDate);
    	 paramMap.put("endDate", endDate);*/
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT rsv2,create_time AS createTime,create_user AS createUser,status FROM CUST_PBOC_ENT_QUERY WHERE RSV2 IS NOT NULL");
        if (!DataFormat.isEmpty(startDate)) {
        	sql.append(" and create_time>=").append("'").append(startDate).append("000000").append("'");
		}
        if(!DataFormat.isEmpty(endDate)) {
        	sql.append(" and create_time<=").append("'").append(endDate).append("240000").append("'");
        }
        sql.append(" ORDER BY RSV2 DESC");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String[] objArg = new String[]{startDate,endDate};
        Iterator it = rootdao.queryByCorpState(sql.toString());
        CorpStateQueryBean bean=null;
        List<CorpStateQueryBean> list=new ArrayList<CorpStateQueryBean>();
        while(it.hasNext()) {
        	Map map = (Map)it.next();
        	bean=new CorpStateQueryBean();
        	if(map.get("rsv2")!=null) {
        		bean.setRsv2(String.valueOf(map.get("rsv2")));
        	}
        	if(map.get("createTime")!=null) {
        		bean.setCreateTime(String.valueOf(map.get("createTime")));
        	}
        	if(map.get("createUser")!=null) {
        		bean.setCreateUser(String.valueOf(map.get("createUser")));
        	}
        	if(map.get("status")!=null){
        		bean.setStatus(String.valueOf(map.get("status")));
        	}
        	list.add(bean);
        }
        List<CorpStateQueryBean> lists=new ArrayList<CorpStateQueryBean>();
        Integer successNum=0;
        Integer failNum=0;
        Integer totalNum=0;
        Integer emptyNum=0;
        Integer completedNum=0;
        for(CorpStateQueryBean corpStateQueryBean:list) {
        	 boolean state=false;
        	 for(CorpStateQueryBean corpStateQueryBeans:lists) {
        		 if(corpStateQueryBeans.getRsv2().equals(corpStateQueryBean.getRsv2())) {
        			 totalNum++;
        			 corpStateQueryBeans.setTotalNum(totalNum);
        			 String st=corpStateQueryBean.getStatus();
        			 if(PbocConstants.INIT_STATE.equals(st)){
        				 emptyNum++;
        				 corpStateQueryBeans.setEmptyNum(emptyNum);
        			 }
        			 if(PbocConstants.SUCCESS_STATE.equals(st)){
        				 successNum++;
        				 corpStateQueryBeans.setSuccessNum(successNum);
        			 }if(PbocConstants.FAILED_STATE.equals(st)){
        				 failNum++;
        				 corpStateQueryBeans.setFailNum(failNum);
        			 }
        			 successNum=(corpStateQueryBeans.getSuccessNum()!=null)?corpStateQueryBeans.getSuccessNum():0;
        			 failNum=(corpStateQueryBeans.getFailNum()!=null)?corpStateQueryBeans.getFailNum():0;
        			 completedNum=successNum+failNum;
        			 corpStateQueryBeans.setCompletedNum(completedNum);
        			 corpStateQueryBeans.setCreateTime(corpStateQueryBean.getCreateTime().substring(0, 8));
        			 state=true;
        		 }
        		 
        	 } 
        	 if(!state){
        		 totalNum=0;
        		 failNum=0;
        		 successNum=0;
        		 emptyNum=0;
        		 completedNum=0;
        		 lists.add(corpStateQueryBean);
        		 for(CorpStateQueryBean corpStateQueryBeans:lists) {
        			 if(corpStateQueryBeans.getRsv2().equals(corpStateQueryBean.getRsv2())) {
        				 totalNum++;
        				 corpStateQueryBeans.setTotalNum(totalNum);
        				 String st=corpStateQueryBeans.getStatus();
        				 if(PbocConstants.INIT_STATE.equals(st)){
        					 emptyNum++;
        					 corpStateQueryBeans.setEmptyNum(emptyNum);
        				 }
        				 if(PbocConstants.SUCCESS_STATE.equals(st)){
        					 successNum++;
        					 corpStateQueryBeans.setSuccessNum(successNum);
        				 }if(PbocConstants.FAILED_STATE.equals(st)){
        					 failNum++;
        					 corpStateQueryBeans.setFailNum(failNum);
        				 }
        				 successNum=(corpStateQueryBeans.getSuccessNum()!=null)?corpStateQueryBeans.getSuccessNum():0;
            			 failNum=(corpStateQueryBeans.getFailNum()!=null)?corpStateQueryBeans.getFailNum():0;
            			 completedNum=successNum+failNum;
            			 corpStateQueryBeans.setCompletedNum(completedNum);
        				 corpStateQueryBeans.setCreateTime(corpStateQueryBean.getCreateTime().substring(0, 8));
        			 }
        		 }
        	 }
        	 
        }
        int pageIndex = getResult().getPage().getCurrentPage();
        int pageSize = getResult().getPage().getEveryPage();
        int maxIndex = pageIndex * pageSize;
        if (maxIndex > lists.size()) {
            maxIndex = lists.size();
        }
        List result = new ArrayList();
        result = lists.subList((pageIndex - 1) * pageSize, maxIndex);
        pageQueryResult.setTotalCount(lists.size());
        pageQueryResult.setQueryResult(result);
        return pageQueryResult;

    }
    

}

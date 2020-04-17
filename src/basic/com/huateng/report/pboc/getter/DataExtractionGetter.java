package com.huateng.report.pboc.getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.huateng.common.DataFormat;
import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;
import com.huateng.report.pboc.entity.CorpStatisticsReportEntity;
import com.huateng.report.pboc.util.Constant;

/**
 * @author Grassy
 * @date 2019/5/31 17:00
 * @jdk.version 1.8
 * @desc
 */
public class DataExtractionGetter extends BaseGetter {
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
    	String startDate = (String) getCommQueryServletRequest().getParameterMap().get("startDate");
    	String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
    	String branch = (String) getCommQueryServletRequest().getParameterMap().get("city");
    	String city=(String) getCommQueryServletRequest().getParameterMap().get("branch");
    	String tableName=(String) getCommQueryServletRequest().getParameterMap().get("tableName");
        PageQueryResult queryResult = new PageQueryResult();
        StringBuffer hql = new StringBuffer();
        if(Constant.CR_COM_EAA.equals(tableName)) {
        	
        }
        
        hql.append("select t1.id as corpPermitId,t.ENT_NAME as entName,t.ENT_CERT_TYPE as entCertType,t.ENT_CERT_NUM as entCertNum,t.QUERY_REASON as queryReason,\r\n" + 
        		"t.SERVICE_CODE as serviceCode,t.QUERY_DATE as queryDate,t.STATUS as status,t.RSV4 as branch,t.RSV7 as ip,t.RSV8 as queryOrgCode,t.RSV9 as userCode\r\n" + 
        		"from CUST_PBOC_ENT_QUERY t inner join t_corp_permit t1 on t.RSV10=t1.id where 1=1");
     
        hql.append(" order by t.QUERY_DATE desc");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CorpStatisticsReportEntity> list = new ArrayList<CorpStatisticsReportEntity>(); 
        CorpStatisticsReportEntity bean=null;
        Iterator it = rootdao.queryBySQL6(hql.toString());
      		while(it.hasNext()){
      			Map map = (Map)it.next();
      			bean=new CorpStatisticsReportEntity();
      			if(map.get("corpPermitId")!=null) {
      				bean.setCorpPermitId((map.get("corpPermitId").toString()));
      			}
      			if(map.get("entName")!=null) {
      				bean.setEntName((map.get("entName").toString()));
      			}
      			if(map.get("entCertType")!=null) {
      				bean.setEntCertType((map.get("entCertType").toString()));
      			}
      			if(map.get("entCertNum")!=null) {
      				 bean.setEntCertNum((map.get("entCertNum").toString()));
      				}
      			if(map.get("queryReason")!=null) {
     				 bean.setQueryReason((map.get("queryReason").toString()));
     				}
      			if(map.get("serviceCode")!=null) {
     				 bean.setServiceCode((map.get("serviceCode").toString()));
     				}
      			
      			if(map.get("queryDate")!=null) {
     				 bean.setQueryDate((map.get("queryDate").toString()));
     				}
      			if(map.get("status")!=null) {
     				 bean.setStatus((map.get("status").toString()));
     				}
      			if(map.get("ip")!=null) {
     				 bean.setIp((map.get("ip").toString()));
     				}
      			if(map.get("queryOrgCode")!=null) {
     				 bean.setQueryOrgCode((map.get("queryOrgCode").toString()));
     				}
      			if(map.get("userCode")!=null) {
    				 bean.setUserCode((map.get("userCode").toString()));
    				}
      			if(map.get("branch")!=null) {
      			     bean.setBranch((map.get("branch").toString()));
      			}
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
        queryResult.setTotalCount(list.size());
        queryResult.setQueryResult(result);
        return queryResult;

    }
}

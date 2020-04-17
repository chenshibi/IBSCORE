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

/**
 * @author Grassy
 * @date 2019/5/31 17:00
 * @jdk.version 1.8
 * @desc
 */
public class CorpStatisticsReportGetter extends BaseGetter {
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
    	String branch = (String) getCommQueryServletRequest().getParameterMap().get("branch");
    	String reportDate = (String) getCommQueryServletRequest().getParameterMap().get("reportDate");
        PageQueryResult queryResult = new PageQueryResult();
        StringBuffer hql = new StringBuffer();
        hql.append("select c.tlr_name as userName,NVL(t.create_user, 'system') as operatorId,utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(t.create_time,''))) as createTime, t1.id as corpPermitId,t.ENT_NAME as entName,t.ENT_CERT_TYPE as entCertType,t.ENT_CERT_NUM as entCertNum,t.QUERY_REASON as queryReason,\r\n" + 
        		"utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(t.resp_time,''))) as returnTime,'' as cdappQueryTime, '' as cdappReturnTime,utl_raw.cast_to_varchar2(utl_raw.cast_to_raw(NVL(t.send_time,''))) as sendTime,t.SERVICE_CODE as serviceCode,t.QUERY_DATE as queryDate,t.STATUS as status,c.DEPARTMENT as branch,t.RSV7 as ip,t.RSV8 as queryOrgCode,t.create_user as userCode\r\n" + 
        		"from CUST_PBOC_ENT_QUERY t  left join tlr_info c on c.tlrno = t.create_user left join t_corp_permit t1 on t.ent_cert_num = t1.loan_card_no and t1.status='1' where 1=1");
        if (!DataFormat.isEmpty(branch)) {
			hql.append(" and c.DEPARTMENT='").append(branch).append("' ");			
		}
        if (!DataFormat.isEmpty(reportDate)) {
			hql.append(" and t.query_date like '").append(reportDate).append("%' ");			
		}
        hql.append(" order by t.resp_time desc ");
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CorpStatisticsReportEntity> list = new ArrayList<CorpStatisticsReportEntity>(); 
        CorpStatisticsReportEntity bean=null;
        Iterator it = rootdao.queryBySQL6(hql.toString());
      		while(it.hasNext()){
      			Map map = (Map)it.next();
      			bean=new CorpStatisticsReportEntity();
      			if(map.get("userName")!=null) {
      				bean.setUserName((map.get("userName").toString()));
      			}
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
      			if(map.get("operatorId")!=null) {
    			     bean.setOperatorId((map.get("operatorId").toString()));
    			}
      			if(map.get("createTime")!=null) {
          			String createTime=(map.get("createTime").toString());
          			createTime=createTime.substring(0, 4)+"-"+createTime.substring(4, 6)+"-"+createTime.substring(6, 8)+" " +createTime.substring(8, 10)+":"+createTime.substring(10, 12)+":"+createTime.substring(12, 14);
        			bean.setCreateTime(createTime);
        			}
          		if(map.get("returnTime")!=null) {
          			String returnTime=(map.get("returnTime").toString());
          			returnTime= returnTime.substring(0, 4)+"-"+returnTime.substring(4, 6)+"-"+returnTime.substring(6, 8)+" " +returnTime.substring(8, 10)+":"+returnTime.substring(10, 12)+":"+returnTime.substring(12, 14);
       			    bean.setReturnTime(returnTime);
       			  }
          		if(map.get("sendTime")!=null) {
          			String sendTime=(map.get("sendTime").toString());
          			sendTime= sendTime.substring(0, 4)+"-"+sendTime.substring(4, 6)+"-"+sendTime.substring(6, 8)+" " +sendTime.substring(8, 10)+":"+sendTime.substring(10, 12)+":"+sendTime.substring(12, 14);
        			bean.setSendTime(sendTime);
        		  }
     			if(map.get("cdappQueryTime")!=null) {
    			     bean.setCdappQueryTime((map.get("cdappQueryTime").toString()));
    		    }
       		    if(map.get("cdappReturnTime")!=null) {
    			     bean.setCdappReturnTime((map.get("cdappReturnTime").toString()));
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

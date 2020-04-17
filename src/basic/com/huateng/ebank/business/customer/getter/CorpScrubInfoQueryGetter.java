package com.huateng.ebank.business.customer.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.CommonFunctions;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

import resource.bean.basic.IndScrubInfo;

/**
 * @Description: 日志查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class CorpScrubInfoQueryGetter extends BaseGetter {

    @Override
    public Result call() throws AppException {
        try {

            CommonFunctions comm = CommonFunctions.getInstance();
            PageQueryResult pageResult = getData();
            ResultMng.fillResultByList(getCommonQueryBean(), getCommQueryServletRequest(), pageResult.getQueryResult(),
                    getResult());
            result.setContent(pageResult.getQueryResult());
            result.getPage().setTotalPage(pageResult.getPageCount(getResult().getPage().getEveryPage()));
            result.init();
            result.setTotal(pageResult.getTotalCount());
            return result;
        } catch (CommonException e) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, e.getMessage());
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

    private PageQueryResult getData() throws CommonException {
    	 String batchId = (String) getCommQueryServletRequest().getParameterMap().get("batchId");
    	 String startDate = (String) getCommQueryServletRequest().getParameterMap().get("startDate");
    	 String endDate = (String) getCommQueryServletRequest().getParameterMap().get("endDate");
    	//换oracle数据库，调整日期格式  20191211-qx
    	 String startDate1 = startDate.substring(0,4)+"-"+startDate.substring(4,6)+"-"+startDate.substring(6,8)+" 00:00:00"+".000000";
    	 String endDate1 = endDate.substring(0,4)+"-"+endDate.substring(4,6)+"-"+endDate.substring(6,8)+" 23:59:59"+".999999";
    	 String a =String.valueOf(Long.valueOf(endDate)-14);
    	 String b=String.valueOf(Long.valueOf(startDate)+14);
    	 String endDate2 = a.substring(0,4)+"-"+a.substring(4,6)+"-"+a.substring(6,8)+" 00:00:00"+".000000";;
    	 String startDate2=b.substring(0,4)+"-"+b.substring(4,6)+"-"+b.substring(6,8)+" 23:59:59"+".999999";
    	 
    	 PageQueryResult pageQueryResult = new PageQueryResult();
         ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
         List<IndScrubInfo> list = new ArrayList(); 
         StringBuffer hql = new StringBuffer("select count(batchId) as countId,inputTime,createUser,batchId from CorpScurbInfo where 1=1 ");
         if (!DataFormat.isEmpty(batchId)) {
          	hql.append(" and batchId = '"+batchId+"' ");
          }
          if (!DataFormat.isEmpty(startDate)) {
         	//hql.append(" and inputTime >= '"+startDate+" 00:00:00"+"' ");
        	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate+" 00:00:00"+".000000"+"'");
        	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate1+"' ");
          }
          if (!DataFormat.isEmpty(endDate)) {
           //  hql.append(" and inputTime <= '"+endDate+" 23:59:59"+"' ");
        	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+endDate+" 23:59:59"+".999999"+"'");
        	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+endDate1+"'");
          }
          if (DataFormat.isEmpty(startDate) && !DataFormat.isEmpty(endDate)) {
        	//  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+String.valueOf(Long.valueOf(endDate)-14)+" 00:00:00"+"' ");
        	//  hql.append(" and inputTime <= '"+endDate+" 23:59:59"+"' ");
        	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+String.valueOf(Long.valueOf(endDate)-14)+" 00:00:00"+".000000"+"'");
          	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+endDate+" 23:59:59"+".999999"+"'");
          	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+endDate2+"'");
          	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+endDate1+"'");
            }
          if (!DataFormat.isEmpty(startDate) && DataFormat.isEmpty(endDate)) {
        	//  hql.append(" and inputTime >= '"+startDate+" 00:00:00"+"' ");
        	//  hql.append(" and inputTime <= '"+String.valueOf(Long.valueOf(startDate)+14)+" 23:59:59"+"' ");
        	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate+" 00:00:00"+".000000"+"'");
          	 // hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+String.valueOf(Long.valueOf(startDate)+14)+" 23:59:59"+".999999"+"'");
          	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate1+"'");
          	  hql.append(" and to_char(inputTime,'yyyy-mm-dd hh24:mi:ssxff') <= '"+startDate2+"'");
            }
         hql.append(" group by batchId,inputTime,createUser order by batchId desc");
         List listCorpScurbInfoBean=rootdao.queryByCondition(hql.toString());
         if(null != listCorpScurbInfoBean && listCorpScurbInfoBean.size()>0){
        	 for (int i = 0; i < listCorpScurbInfoBean.size(); i++) {
        		 IndScrubInfo indScrubInfo=new IndScrubInfo();
        		 Object[] obj=(Object[]) listCorpScurbInfoBean.get(i);
        		 indScrubInfo.setCountid((Long) obj[0]);
        		 indScrubInfo.setInputTime((Date) obj[1]);
        		 indScrubInfo.setCreateUser((String) obj[2]);
        		 indScrubInfo.setBatchId((Integer) obj[3]);
        		 list.add(indScrubInfo);
			}
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

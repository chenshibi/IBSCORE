package com.huateng.report.pboc.getter;

import java.util.Map;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultMng;
import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * 
 * @author Grassy
 *
 */
public class IbsQueryExpireGetter extends BaseGetter {
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
    	ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();
        PageQueryResult queryResult = new PageQueryResult();
        PageQueryCondition queryCondition = new PageQueryCondition();
        int pageSize = getResult().getPage().getEveryPage();
        int pageIndex = getResult().getPage().getCurrentPage();
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        StringBuilder hql = new StringBuilder("FROM IbsQueryExpire WHERE 1 = 1 ");
        Map<String, Object> map = getCommQueryServletRequest().getParameterMap();
		String sDate = (String) map.get("etlDateStart");
		String sYear=sDate.substring(0, 4);
        String sMonth=sDate.substring(4, 6);		 
		String sDay=sDate.substring(6, 8);
		sDate=sYear+"-"+sMonth+"-"+sDay+" "+"00:00:00";
		String eDate = (String) map.get("etlDateEnd");
		eDate=eDate.substring(0, 4)+"-"+eDate.substring(4, 6)+"-"+eDate.substring(6, 8)+" "+"23:59:59";
		/*hql.append(" and update_time between ").append("'").append(sDate).append("'").
		append(" ").append("and ").append("'").append(eDate).append("'");*/
		
/*        Date startDate = DateUtils.parseTime8(sDate);
        Date endDate = DateUtils.parseTime8(eDate);
        
		List<Object> paramentList = new ArrayList<Object>();
		if (!DataFormat.isEmpty(startDate)) {
			hql.append(" and updateTime  >= ? ");
			paramentList.add(startDate);
		}
		if (!DataFormat.isEmpty(endDate)) {
			hql.append(" and updateTime  <= ? ");
			paramentList.add(endDate);
		}*/
		//oracle时间戳查询
		hql.append(" and update_time>=").append("to_timestamp").append("(").append("'").append(sDate).append("'").append(",")
		.append("'").append("yyyy-mm-dd hh24:mi:ss.ff").append("')").append(" and update_time<=to_timestamp").append("('")
		.append(eDate).append("'").append(",").append("'yyyy-mm-dd hh24:mi:ss.ff").append("')");
		hql.append(" order by update_time desc ");
		queryCondition.setQueryString(hql.toString());
		queryCondition.setPageIndex(pageIndex);
		queryCondition.setPageSize(pageSize);
	//	queryCondition.setObjArray(paramentList.toArray());
		queryResult = rootDAO.pageQueryByQL(queryCondition);
        return queryResult;
    }
}

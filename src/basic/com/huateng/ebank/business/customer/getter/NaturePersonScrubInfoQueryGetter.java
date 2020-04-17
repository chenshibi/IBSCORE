package com.huateng.ebank.business.customer.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.NatureCodeQuery;
import resource.bean.basic.NaturePersonQuery;

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
import com.huateng.ebank.framework.web.commQuery.BaseGetter;
import com.huateng.exception.AppException;

/**
 * @Description: 日志查询
 * @Package: com.huateng.ebank.business.custadmin.getter
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class NaturePersonScrubInfoQueryGetter extends BaseGetter {

	@Override
	public Result call() throws AppException {
		try {

			CommonFunctions comm = CommonFunctions.getInstance();
			PageQueryResult pageResult = getData();
			ResultMng.fillResultByList(getCommonQueryBean(),
					getCommQueryServletRequest(), pageResult.getQueryResult(),
					getResult());
			result.setContent(pageResult.getQueryResult());
			result.getPage().setTotalPage(
					pageResult.getPageCount(getResult().getPage()
							.getEveryPage()));
			result.init();
			result.setTotal(pageResult.getTotalCount());
			return result;
		} catch (CommonException e) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, e.getMessage());
		} catch (AppException appEx) {
			throw appEx;
		} catch (Exception ex) {
			throw new AppException(Module.SYSTEM_MODULE,
					Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
		}
	}

	private PageQueryResult getData() throws CommonException {
		String batchId = (String) getCommQueryServletRequest()
				.getParameterMap().get("batchId");
		String startDate = (String) getCommQueryServletRequest()
				.getParameterMap().get("startDate");
		//换oracle数据库，调整日期格式  20191125-qx
   	 	String startDate1 = startDate.substring(0,4)+"-"+startDate.substring(4,6)+"-"+startDate.substring(6,8)+" 00:00:00"+".000000";
   	 	String startDate2 = startDate.substring(0,4)+"-"+startDate.substring(4,6)+"-"+startDate.substring(6,8)+" 23:59:59"+".999999";
		PageQueryResult pageQueryResult = new PageQueryResult();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<NaturePersonQuery> list = new ArrayList<NaturePersonQuery>();
		StringBuffer hql = new StringBuffer(
				"select a.status astatus,a.id,a.rpt_key,a.batch_id,a.name,a.individual_id_type,a.individual_id,")
				.append("a.create_User,a.input_time,b.return_time,b.status,a.app_Id,type,b.input_user,")
				.append("b.query_time,b.parse_time,b.consent_file_path,b.input_user_ip,b.consent_file_path")
				.append(" from assure_batch_info a left join assure_ind_app b on a.app_id = b.id where 1=1");
		if (!DataFormat.isEmpty(batchId)) {
			hql.append(" and a.batch_id = '" + batchId + "' ");
		}
		if (!DataFormat.isEmpty(startDate)) {
			//hql.append(" and a.input_time >= '" + startDate + " 00:00:00" + "' ");
			//换oracle数据库，调整日期格式  20191125-qx
      	  	//hql.append(" and  to_char(a.input_time,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate1+" 00:00:00"+".000000"+"' ");
      	  	hql.append(" and  to_char(a.input_time,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate1+"' ");
			//hql.append(" and a.input_time <= '" + startDate + " 23:59:59" + "' ");
      	  	//换oracle数据库，调整日期格式  20191125-qx
      	  	hql.append(" and  to_char(a.input_time,'yyyy-mm-dd hh24:mi:ssxff') <= '"+startDate2+"' ");
		}

		Iterator it = rootdao.queryBySQL2(hql.toString());
		//Iterator it = rootdao.queryBySQL7(hql.toString());
		
		NaturePersonQuery naturePersonQuery = null;
		while (it.hasNext()) {
			Map map = (Map) it.next();
			naturePersonQuery = new NaturePersonQuery();
			String individual_id = (String) map.get("individual_id");
			String individual_id_type = (String) map.get("individual_id_type");
			String name = (String) map.get("name");
			String status = (String) map.get("status");
			String astatus = map.get("astatus").toString();
			naturePersonQuery.setName(name);
			naturePersonQuery.setIndividualId(individual_id);
			naturePersonQuery.setIndividualIdType(individual_id_type);
			if (astatus.equals("1")) {
				naturePersonQuery.setStatus("校验不通过");
			} else {
				naturePersonQuery.setStatus(status);
			}
			list.add(naturePersonQuery);
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

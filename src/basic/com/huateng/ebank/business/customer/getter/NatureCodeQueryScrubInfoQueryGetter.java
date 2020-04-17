package com.huateng.ebank.business.customer.getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import resource.bean.basic.IndScrubInfo;
import resource.bean.basic.NatureCodeQuery;

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
public class NatureCodeQueryScrubInfoQueryGetter extends BaseGetter {

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
		String year=startDate.substring(0, 4);
		String month=startDate.substring(4, 6);
		String day=startDate.substring(6, 8);
		String startDate1=year+"-"+month+"-"+day;
		PageQueryResult pageQueryResult = new PageQueryResult();
		ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		List<NatureCodeQuery> list = new ArrayList<NatureCodeQuery>();
		StringBuffer hql = new StringBuffer(
				"select fo.status astatus,pp.individual_id as individual_id,pp.individual_id_type as individual_id_type , ")
				.append("pp.name as name ,pp.status as status,lt.loancard_no as loancard_no, ")
				.append("info.individual_id as idNo , info.individual_type as idType,info.name as assureName ")
				.append("from natural_code_batch_info fo left join t_detail_ind_app pp on fo.app_id=pp.id ")
				.append("left join t_detail_ind_result lt on pp.rpt_key=lt.rpt_key ")
				.append("left join t_detail_ind_info info on pp.rpt_key=info.rpt_key ")
				.append("where 1=1 ");
		if (!DataFormat.isEmpty(batchId)) {
			hql.append(" and fo.batch_id = '" + batchId + "' ");
		}
		if (!DataFormat.isEmpty(startDate)) {
//			hql.append(" and fo.input_time >= '"+startDate+" 00:00:00"+"' ");
//			hql.append(" and fo.input_time <= '"+startDate+" 23:59:59"+"' ");
			hql.append(" and to_char(fo.input_time,'yyyy-mm-dd hh24:mi:ssxff') >= '"+startDate1+" 00:00:00"+"' ");
			hql.append(" and to_char(fo.input_time,'yyyy-mm-dd hh24:mi:ssxff') <= '"+startDate1+" 23:59:59"+"' ");
			
		}
		Iterator it = rootdao.queryBySQL2(hql.toString());
		NatureCodeQuery natureCodeQuery = null;
		while (it.hasNext()) {
			Map map = (Map) it.next();
			natureCodeQuery = new NatureCodeQuery();
			String individual_id = (String) map.get("individual_id");
			String individual_id_type = (String) map.get("individual_id_type");
			String name = (String) map.get("name");
			String status = (String) map.get("status");
			String astatus =  map.get("astatus").toString();
			String loancard_no = (String) map.get("loancard_no");
			String idNo = (String) map.get("idNo");
			String idType = (String) map.get("idType");
			String assureName = (String) map.get("assureName");
			
			
			natureCodeQuery.setName(name);
			natureCodeQuery.setIndividualId(individual_id);
			natureCodeQuery.setIndividualIdType(individual_id_type);
			natureCodeQuery.setLoancardNo(loancard_no);
			natureCodeQuery.setIdNo(idNo);
			natureCodeQuery.setIdType(idType);
			natureCodeQuery.setAssureName(assureName);
			if (astatus.equals("1")) {
				natureCodeQuery.setStatus("校验不通过");
			} else {
				natureCodeQuery.setStatus(status);
			}

			list.add(natureCodeQuery);
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

package com.huateng.ebank.business.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.dao.PbocQueryHistoryQueryDAO;

import resource.bean.crms.CustPbocHistoryQuery;

public class PbocQueryHistorydisApproveUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
		UpdateResultBean updateResultBean=paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryHistoryCheck");
		PbocQueryHistoryQueryDAO dao=BaseDAOUtils.getPbocQueryHistoryQueryDAO();
		CustPbocHistoryQuery history = new CustPbocHistoryQuery();   
		UpdateReturnBean UpdateReturnBean=new UpdateReturnBean();
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		while(updateResultBean.hasNext()){
		Map param=updateResultBean.next();
		String status=(String)param.get("status");
		if("02".equals(status)){
			ExceptionUtil.throwCommonException("查询状态为审批成功不允许审批拒绝！");
		}
		history.setEntCertNum((String)param.get("entCertNum"));
		history.setEntCertType((String)param.get("entCertType"));
		history.setEntName((String)param.get("entName"));
		history.setId((String)param.get("id"));
		history.setIsLock((String)param.get("isLock"));
		history.setQueryDate((String)param.get("queryDate"));
		history.setQueryReason((String)param.get("queryReason"));
		//history.setStatus((String)param.get("Status"));
		history.setStatus("00");//审批失败
		history.setUserId((String)(param.get("userId")));
		dao.update(history);
		}
		return updateReturnBean;
	}

}

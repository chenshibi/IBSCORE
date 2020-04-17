package com.huateng.ebank.business.customer.update;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.dao.PbocQueryHistoryQueryDAO;

import resource.bean.crms.CustPbocHistoryQuery;

public class PbocQueryHistoryDelUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
		UpdateResultBean updateResultBean=paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryHistoryMake");
		PbocQueryHistoryQueryDAO dao=BaseDAOUtils.getPbocQueryHistoryQueryDAO();
		CustPbocHistoryQuery history = new CustPbocHistoryQuery();   
		UpdateReturnBean UpdateReturnBean=new UpdateReturnBean();
		while(updateResultBean.hasNext()){
		Map param=updateResultBean.next();
		String status=(String)param.get("status");
		if("01".equals(status) || "02".equals(status)){
			ExceptionUtil.throwCommonException("查询状态为审批中或者审批成功不允许删除！");
		}
		history.setEntCertNum((String)param.get("entCertNum"));
		history.setEntCertType((String)param.get("entCertType"));
		history.setEntName((String)param.get("entName"));
		history.setId((String)param.get("id"));
		history.setIsLock((String)param.get("isLock"));
		history.setQueryDate((String)param.get("queryDate"));
		history.setQueryReason((String)param.get("queryReason"));
		history.setUserId((String)param.get("userId"));
		history.setStatus((String)param.get("status"));//审批中
		dao.delete(history);
		}		
		return UpdateReturnBean;
	}
	
	

}

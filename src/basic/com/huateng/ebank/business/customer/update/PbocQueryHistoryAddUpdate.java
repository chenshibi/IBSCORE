package com.huateng.ebank.business.customer.update;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.dao.PbocQueryHistoryQueryDAO;

import resource.bean.crms.CustPbocHistoryQuery;

public class PbocQueryHistoryAddUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
			throws AppException {
		UpdateResultBean updateResultBean=paramMultiUpdateResultBean.getUpdateResultBeanByID("PbocQueryHistoryAdd");
		PbocQueryHistoryQueryDAO dao=BaseDAOUtils.getPbocQueryHistoryQueryDAO();
		Date date = new Date();
		String tlrno=GlobalInfo.getCurrentInstance().getTlrno();
		UpdateReturnBean UpdateReturnBean=new UpdateReturnBean();
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMdd");
		String date1=format.format(date);
		String entName = updateResultBean.getParameter("entName");
		String entCertType = updateResultBean.getParameter("entCertType");
		String entCertNum = updateResultBean.getParameter("entCertNum");
		String queryReason = updateResultBean.getParameter("queryReason");
		CustPbocHistoryQuery history = new CustPbocHistoryQuery();
		history.setEntName(entName);
		history.setEntCertType(entCertType);
		history.setEntCertNum(entCertNum);
		history.setQueryReason(queryReason);
		history.setIsLock("0");//0-未锁定
		history.setStatus("00");//00-未提交审批
		history.setQueryDate(date1);
		history.setUserId(tlrno);
		dao.save(history);
		
		
		return UpdateReturnBean;
	}
	
	

}

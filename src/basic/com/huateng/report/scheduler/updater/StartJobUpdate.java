package com.huateng.report.scheduler.updater;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.scheduler.timer.SystemTimedScheduler;
import com.huateng.util.ContextUtil;

/**
 *
 * Filename:EventinforApproval.java Description:案件举报信息审批 Copyright:Copyright
 * (c)2012 Company: HuaTeng
 * 
 * @author: shijie.zhu
 * @version: 1.0
 * @Create: 2013-1-21 Modification History: Date Author Version
 *          ------------------------------------------------------------------
 *          2013-1-21上午11:01:56 shijie.zhu 1.0
 */
public class StartJobUpdate extends BaseUpdate {
	private static final String DATASET_ID = "SystemTimedScheduler";

	@Override
	public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
			HttpServletResponse respone) throws AppException {
		// TODO Auto-generated method stub

		// 结果集对象
		UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
		UpdateReturnBean updateReturnBean = new UpdateReturnBean();
		String id = updateResultBean.getParameter("id");

		SystemTimedScheduler scheduler = (SystemTimedScheduler) ContextUtil.getContext().getBean("SystemTimedScheduler");
		
		scheduler.runNow(id);

		return updateReturnBean;
	}

}

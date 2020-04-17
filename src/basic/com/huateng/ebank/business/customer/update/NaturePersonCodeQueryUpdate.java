package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.TDetailIndApp;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.NaturePersonCodeQueryOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class NaturePersonCodeQueryUpdate extends BaseUpdate{

	@SuppressWarnings("rawtypes")
	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// TODO Auto-generated method stub
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("NaturePersonCodeQuery");
        TDetailIndApp tDetailIndApp=null;
        List<TDetailIndApp> tDetailIndAppList = new ArrayList<TDetailIndApp>();
        while (updateResultBean.hasNext()) {
        	tDetailIndApp = new TDetailIndApp();
            Map map = updateResultBean.next();
            mapToObject(tDetailIndApp, map);
            tDetailIndAppList.add(tDetailIndApp);
        }
     
        
        OperationContext oc = new OperationContext();

        oc.setAttribute(NaturePersonCodeQueryOperation.IN_PARAM, tDetailIndAppList);
        OPCaller.call(NaturePersonCodeQueryOperation.ID, oc);
        
        return updateReturnBean;
	}

}

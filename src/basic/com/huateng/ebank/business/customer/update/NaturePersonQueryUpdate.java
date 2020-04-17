package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.AssureIndApp;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class NaturePersonQueryUpdate extends BaseUpdate{

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
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("NaturePersonQuery");
        AssureIndApp assureIndApp=null;
        List<AssureIndApp> assureIndAppList = new ArrayList<AssureIndApp>();
        while (updateResultBean.hasNext()) {
        	assureIndApp = new AssureIndApp();
            Map map = updateResultBean.next();
            mapToObject(assureIndApp, map);
            assureIndAppList.add(assureIndApp);
        }
     
        
        OperationContext oc = new OperationContext();

        oc.setAttribute(NaturePersonQueryOperation.IN_PARAM, assureIndAppList);
        OPCaller.call(NaturePersonQueryOperation.ID, oc);
        
        return updateReturnBean;
	}

}

package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.IndAppOperation;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.business.dwr.DwrFunctions;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class IndAppUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// TODO Auto-generated method stub
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("IndAppRequest");
        UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID("IndAppCommon");
        InqCust inqCust=null;
        InqCust inqCust1=null;
        List<InqCust> inqCustList = new ArrayList<InqCust>();
        List commonList=new ArrayList();
        while (updateResultBean.hasNext()) {
        	inqCust = new InqCust();
            Map map = updateResultBean.next();
            mapToObject(inqCust, map);
            inqCustList.add(inqCust);
        }
        while (updateResultBean1.hasNext()) {
        	inqCust1 = new InqCust();
            Map map = updateResultBean1.next();
            mapToObject(inqCust1, map);
            commonList.add(inqCust1);
        }
        
        
        OperationContext oc = new OperationContext();

        oc.setAttribute(IndAppOperation.IN_PARAM, inqCustList);
        oc.setAttribute(IndAppOperation.IN_COMMONLIST, commonList);
        OPCaller.call(IndAppOperation.ID, oc);
        
        String flag=(String)oc.getAttribute(IndAppOperation.FLAG);
        updateReturnBean.setParameter("flag", flag);
        return updateReturnBean;
	}

}

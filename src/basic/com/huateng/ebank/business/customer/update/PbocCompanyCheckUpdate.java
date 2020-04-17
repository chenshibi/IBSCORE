package com.huateng.ebank.business.customer.update;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.CorpCust;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.PbocCompanyCheckOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class PbocCompanyCheckUpdate extends BaseUpdate{


	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// TODO Auto-generated method stub
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("PbocCompany");
        CorpCust corpCust=null;
        while (updateResultBean.hasNext()) {
        	corpCust = new CorpCust();
            Map map = updateResultBean.next();
            mapToObject(corpCust, map);
        }
        
        OperationContext oc = new OperationContext();
        oc.setAttribute(PbocCompanyCheckOperation.IN_PARAM, corpCust);
        OPCaller.call(PbocCompanyCheckOperation.ID, oc);
        
        String flag=(String)oc.getAttribute(PbocCompanyCheckOperation.FLAG);
        updateReturnBean.setParameter("flag", flag);
        return updateReturnBean;
	}


}

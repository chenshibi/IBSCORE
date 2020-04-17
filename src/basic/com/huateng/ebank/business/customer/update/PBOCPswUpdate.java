package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.TlrPbocUser;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.PBOCPswOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class PBOCPswUpdate extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("PBOCPswChange");
        TlrPbocUser tlrPbocUser=null;
        List<TlrPbocUser> tlrPbocUserList = new ArrayList<TlrPbocUser>();
        while (updateResultBean.hasNext()) {
        	tlrPbocUser = new TlrPbocUser();
            Map map = updateResultBean.next();
            mapToObject(tlrPbocUser, map);
            tlrPbocUserList.add(tlrPbocUser);
        }      
        OperationContext oc = new OperationContext();

        oc.setAttribute(PBOCPswOperation.IN_PARAM, tlrPbocUserList);
        OPCaller.call(PBOCPswOperation.ID, oc);
        return updateReturnBean;
	}

}

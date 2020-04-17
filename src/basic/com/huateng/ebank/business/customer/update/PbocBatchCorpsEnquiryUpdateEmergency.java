package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.CorpCust;
import resource.bean.basic.InqCust;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.PbocBatchCorpsEnquiryEmergencyOperation;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class PbocBatchCorpsEnquiryUpdateEmergency extends BaseUpdate{

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// TODO Auto-generated method stub
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("PbocBatchCorpsEnquiry");
        UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID("IndAppCommonForCom");
        UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID("PbocCompany");
        CorpCust corpCust=null;
        InqCust inqCust=null;
        List corpCustList = new ArrayList();
        List inqCustList=new ArrayList();
        List companyList=new ArrayList();
        while (updateResultBean.hasNext()) {
        	corpCust = new CorpCust();
            Map map = updateResultBean.next();
            mapToObject(corpCust, map);
            corpCustList.add(corpCust);
        }
        while (updateResultBean1.hasNext()) {
        	inqCust = new InqCust();
            Map map = updateResultBean1.next();
            mapToObject(inqCust, map);
            inqCustList.add(inqCust);
        }
        while (updateResultBean2.hasNext()) {
        	corpCust = new CorpCust();
            Map map = updateResultBean2.next();
            mapToObject(corpCust, map);
            companyList.add(corpCust);
        }
        
        OperationContext oc = new OperationContext();

        oc.setAttribute(PbocBatchCorpsEnquiryEmergencyOperation.IN_INQCUSTLIST, inqCustList);
        oc.setAttribute(PbocBatchCorpsEnquiryEmergencyOperation.IN_CORPCUSTLIST, corpCustList);
        oc.setAttribute(PbocBatchCorpsEnquiryEmergencyOperation.IN_COMPANYLIST, companyList);
        OPCaller.call(PbocBatchCorpsEnquiryEmergencyOperation.ID, oc);
        
        String flag=(String)oc.getAttribute(PbocBatchCorpsEnquiryEmergencyOperation.FLAG);
        updateReturnBean.setParameter("flag", flag);
        return updateReturnBean;
	}

}

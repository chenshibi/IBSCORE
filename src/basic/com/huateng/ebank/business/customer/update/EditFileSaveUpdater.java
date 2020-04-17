package com.huateng.ebank.business.customer.update;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import resource.bean.basic.FileSubmit;
import resource.bean.basic.IndApp;
import resource.bean.basic.IndPermit;
import resource.bean.basic.InqCust;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.customer.operation.EditFileOperation;
import com.huateng.ebank.business.customer.operation.IndAppOperation;
import com.huateng.ebank.business.customer.service.BusinessUploadService;
import com.huateng.ebank.business.dwr.DwrFunctions;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;

public class EditFileSaveUpdater extends BaseUpdate{

	@Override
	public UpdateReturnBean saveOrUpdate(
			MultiUpdateResultBean paramMultiUpdateResultBean,
			HttpServletRequest request,
			HttpServletResponse paramHttpServletResponse) throws AppException {
		// TODO Auto-generated method stub
		// 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 返回结果对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("EditFile");
        FileSubmit fileSubmit=null;
        List<FileSubmit> fileSubmitList = new ArrayList<FileSubmit>();
        List commonList=new ArrayList();
        while (updateResultBean.hasNext()) {
        	fileSubmit = new FileSubmit();
            Map map = updateResultBean.next();
            mapToObject(fileSubmit, map);
            fileSubmitList.add(fileSubmit);
        }
        
        
        OperationContext oc = new OperationContext();

        oc.setAttribute(EditFileOperation.IN_PARAM, fileSubmitList);
        OPCaller.call(EditFileOperation.ID, oc);
        
        String flag=(String)oc.getAttribute(EditFileOperation.FLAG);
        updateReturnBean.setParameter("flag", flag);
        return updateReturnBean;
	}

}

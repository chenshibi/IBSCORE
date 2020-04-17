package com.huateng.report.system.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.report.system.operation.SecParameterOperation;

import resource.bean.basic.PfSysParam;
import resource.bean.basic.PfSysParamPK;

public class SecParameterUpdate extends BaseUpdate {
    private final static String DATASET_ID = "SysParamsSec";

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
        PfSysParam param = null;

        if (updateResultBean.hasNext()) {
            param = new PfSysParam();
            Map map = updateResultBean.next();
            mapToObject(param, map);

            String magicId = (String) map.get("magicId");
            String paramId = (String) map.get("paramId");
            PfSysParamPK pk = new PfSysParamPK(magicId, paramId);
            param.setId(pk);
        }
        OperationContext oc = new OperationContext();
        oc.setAttribute(SecParameterOperation.IN_UPDATE, param);
        OPCaller.call(SecParameterOperation.ID, oc);
        return updateReturnBean;
    }

}

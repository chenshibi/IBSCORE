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
import com.huateng.report.system.operation.SysNoticeOperation;

import resource.bean.basic.SysNotice;

public class SysNoticeUpdate extends BaseUpdate {

    private static final String DATASET_ID = "SysNotice";

    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {
        // 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        // 取得结果集对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
        // 开始处理
        SysNotice sysNotice = null;
        OperationContext oc = new OperationContext();
        if (updateResultBean.hasNext()) {
            sysNotice = new SysNotice();
            Map map = updateResultBean.next();
            mapToObject(sysNotice, map);
        }
        String opType = updateResultBean.getParameter("opType");
        oc.setAttribute(SysNoticeOperation.CMD, opType);
        oc.setAttribute(SysNoticeOperation.IN_PARAM, sysNotice);
        OPCaller.call(SysNoticeOperation.ID, oc);
        return updateReturnBean;
    }

}

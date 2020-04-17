package com.huateng.msgplatform.updater;

import java.util.ArrayList;
import java.util.List;
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
import com.huateng.msgplatform.opertation.RcvUserGroupOperation;

import resource.bean.msg.CpgGroupInfTmp;

/**
 *
 * Filename:EventinforApproval.java Description:接收用户组维护审批 Copyright:Copyright
 * (c)2012 Company: HuaTeng
 * 
 * @author: shijie.zhu
 * @version: 1.0
 * @Create: 2013-1-21 Modification History: Date Author Version
 *          ------------------------------------------------------------------
 *          2013-1-21上午11:01:56 shijie.zhu 1.0
 */
public class RcvUserGroupApvUpdater extends BaseUpdate {
    private static final String DATASET_ID = "CpgGroupInfTmp";

    @SuppressWarnings("unchecked")
    @Override
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse respone) throws AppException {
        // TODO Auto-generated method stub

        // 结果集对象
        UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID);
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();
        OperationContext oc = new OperationContext();
        List list = new ArrayList();
        String approveStatusChoose = updateResultBean.getParameter("approveStatusChoose");
        String approveResultChoose = updateResultBean.getParameter("approveResultChoose");
        while (updateResultBean.hasNext()) {
            Map map = updateResultBean.next();
            String select = (String) map.get("select");
            CpgGroupInfTmp bean = new CpgGroupInfTmp();
            mapToObject(bean, map);
            if ("true".equals(select)) {
                list.add(bean);
            }

        }
        oc.setAttribute(RcvUserGroupOperation.IN_AUDIT_STATUS, approveStatusChoose);
        oc.setAttribute(RcvUserGroupOperation.IN_AUDIT_RESULT, approveResultChoose);
        oc.setAttribute(RcvUserGroupOperation.CMD, RcvUserGroupOperation.CMD_AUDIT);
        oc.setAttribute(RcvUserGroupOperation.IN_PARAM, list);
        OPCaller.call(RcvUserGroupOperation.ID, oc);

        return updateReturnBean;
    }

}

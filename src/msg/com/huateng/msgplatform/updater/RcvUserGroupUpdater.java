package com.huateng.msgplatform.updater;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.msgplatform.opertation.RcvUserGroupOperation;
import com.huateng.msgplatform.service.RcvUserGroupService;

import resource.bean.msg.CpgGroupInf;
import resource.bean.msg.CpgUsrInf;

public class RcvUserGroupUpdater extends BaseUpdate {

    /* ftl页面中通用查询ID,即CommonQuery的ID */
    private static final String DATASET_ID1 = "CpgGroupInf";
    private static final String DATASET_ID2 = "CpgUsrInf";

    private static final String RECORD_DELETE = "delete";
    private static final String RECORD_ADD = "addNewGroup";
    private static final String RECORD_MOD = "update";

    @SuppressWarnings("rawtypes")
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {

        // 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();

        // 返回结果对象
        UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID1);
        UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);

        CpgGroupInf groupInf = new CpgGroupInf(); // 基础信息
        OperationContext oc = new OperationContext();

        // 交易信息
        List<CpgUsrInf> paramList = new ArrayList<CpgUsrInf>();
        // 返回对象
        String type = updateResultBean1.getParameter("type");
        // 基本信息段增删改
        if (updateResultBean1.hasNext()) {
            Map map = updateResultBean1.next();
            mapToObject(groupInf, map);
            // 去数据查询下，REC_STATUS是否变动

            if (!StringUtils.isEmpty(type)) {
                if (RECORD_ADD.equalsIgnoreCase(type)) {
                    RcvUserGroupService.beforeSubmit("new", groupInf.getGroupId());
                    oc.setAttribute(RcvUserGroupOperation.CMD, RcvUserGroupOperation.CMD_INSERT);
                } else if (RECORD_MOD.equalsIgnoreCase(type)) {
                    RcvUserGroupService.beforeSubmit(null, groupInf.getGroupId());
                    oc.setAttribute(RcvUserGroupOperation.CMD, RcvUserGroupOperation.CMD_UPDATE);
                } else if (RECORD_DELETE.equalsIgnoreCase(type)) {
                    RcvUserGroupService.beforeSubmit(null, groupInf.getGroupId());
                    oc.setAttribute(RcvUserGroupOperation.CMD, RcvUserGroupOperation.CMD_DELETE);
                }
            }
        }

        // 交易信息
        while (updateResultBean2.hasNext()) {
            CpgUsrInf list = new CpgUsrInf();
            Map map = updateResultBean2.next();
            String select = (String) map.get("select");
            mapToObject(list, map);
            if ("true".equals(select)) {
                paramList.add(list);
            }

        }

        oc.setAttribute(RcvUserGroupOperation.IN_OPERATION, groupInf);
        oc.setAttribute(RcvUserGroupOperation.IN_PARAM, paramList);
        OPCaller.call(RcvUserGroupOperation.ID, oc);

        return updateReturnBean;
    }

}

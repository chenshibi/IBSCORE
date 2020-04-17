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
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.msgplatform.getter.BctlBean;
import com.huateng.msgplatform.opertation.RcvUserOperation;
import com.huateng.msgplatform.service.RcvUserService;

import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgUsrInf;

/**
 * 
 * Filename: RcvUserUpdater.java Description:接收用户维护 Copyright:Copyright (c)2012
 * Company: HuaTeng
 * 
 * @author: zhangdianchao
 * @version: 1.0
 * @Create: 2016-3-7
 */
public class RcvUserUpdater extends BaseUpdate {

    /* ftl页面中通用查询ID,即CommonQuery的ID */
    private static final String DATASET_ID1 = "CpgUsrInf";
    private static final String DATASET_ID2 = "CpgUsrInfBctl";
    private static final String DATASET_ID3 = "CpgMsgUsr";

    private static final String RECORD_DELETE = "delete";
    private static final String RECORD_ADD = "new";
    private static final String RECORD_MOD = "update";

    @SuppressWarnings("rawtypes")
    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean arg0, HttpServletRequest arg1, HttpServletResponse arg2)
            throws AppException {

        // 返回对象
        UpdateReturnBean updateReturnBean = new UpdateReturnBean();

        // 返回结果对象
        UpdateResultBean updateResultBean1 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID1);
        UpdateResultBean updateResultBean2 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID2);
        UpdateResultBean updateResultBean3 = multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID3);

        CpgUsrInf usrInf = new CpgUsrInf(); // 基础信息 CpgUsrInf
        OperationContext oc = new OperationContext();

        // 接收方式 和 可选内部机构
        List<CpgMsgUsr> delList = new ArrayList<CpgMsgUsr>();
        List<CpgMsgUsr> insertList = new ArrayList<CpgMsgUsr>();
        List<BctlBean> updateList = new ArrayList<BctlBean>();
        // 返回对象
        String type = updateResultBean1.getParameter("type");

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        // 基本信息段增删改
        if (updateResultBean1.hasNext()) {
            Map map = updateResultBean1.next();
            mapToObject(usrInf, map);
            if (!StringUtils.isEmpty(type)) {
                if (RECORD_ADD.equalsIgnoreCase(type)) {
                    // 新增时要检查userId是否重复
                    RcvUserService.beforeSubmit("new", usrInf.getUserId());
                    oc.setAttribute(RcvUserOperation.CMD, RcvUserOperation.CMD_INSERT);
                } else if (RECORD_MOD.equalsIgnoreCase(type)) {
                    // 这里检查重复提交
                    RcvUserService.beforeSubmit(null, usrInf.getUserId());
                    oc.setAttribute(RcvUserOperation.CMD, RcvUserOperation.CMD_UPDATE);
                } else if (RECORD_DELETE.equalsIgnoreCase(type)) {
                    // 这里检查重复提交
                    RcvUserService.beforeSubmit(null, usrInf.getUserId());
                    oc.setAttribute(RcvUserOperation.CMD, RcvUserOperation.CMD_DELETE);
                }
            }
        }

        while (updateResultBean2.hasNext()) {
            BctlBean bctlBean = new BctlBean();
            Map map = updateResultBean2.next();
            String select = (String) map.get("select");
            mapToObject(bctlBean, map);
            if ("true".equals(select)) {
                updateList.add(bctlBean);
            }
        }

        // 交易信息
        while (updateResultBean3.hasNext()) {
            CpgMsgUsr msgUsr = new CpgMsgUsr();
            Map map = updateResultBean3.next();
            mapToObject(msgUsr, map);
            insertList.add(msgUsr);
        }

        oc.setAttribute(RcvUserOperation.IN_OPERATION, usrInf);

        // 交易信息
        oc.setAttribute(RcvUserOperation.IN_PARAM_INSERT, insertList);
        oc.setAttribute(RcvUserOperation.IN_PARAM_MOD, updateList);
        oc.setAttribute(RcvUserOperation.IN_PARAM_DEL, delList);
        OPCaller.call(RcvUserOperation.ID, oc);

        return updateReturnBean;
    }

}

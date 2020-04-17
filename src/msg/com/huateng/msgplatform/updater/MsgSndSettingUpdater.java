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
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.msgplatform.getter.MsgSndSettingBean;
import com.huateng.msgplatform.getter.RcvObjBean;
import com.huateng.msgplatform.opertation.MsgSendSettingOperation;
import com.huateng.msgplatform.service.MsgSendSettingService;

/**
 * 
 * Filename: MsgSndSettingUpdater.java Description:接收用户维护 Copyright:Copyright
 * (c)2012 Company: HuaTeng
 * 
 * @author: zhangdianchao
 * @version: 1.0
 * @Create: 2016-3-7
 */
public class MsgSndSettingUpdater extends BaseUpdate {

    /* ftl页面中通用查询ID,即CommonQuery的ID */
    private static final String DATASET_ID1 = "MsgSndSetting";
    private static final String DATASET_ID2 = "RcvUsrList";
    private static final String DATASET_ID3 = "RcvGroupList";

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
        UpdateResultBean updateResultBean3 =multiUpdateResultBean.getUpdateResultBeanByID(DATASET_ID3);

        MsgSndSettingBean msgSndSettingBean = new MsgSndSettingBean();
        OperationContext oc = new OperationContext();

        // 交易信息
        List<RcvObjBean> insertList = new ArrayList<RcvObjBean>();// 存 user
        List<RcvObjBean> updateList = new ArrayList<RcvObjBean>();// 存 group
        // 返回对象
        String type = updateResultBean1.getParameter("type");
        // ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();

        if (updateResultBean1.hasNext()) {
            Map map = updateResultBean1.next();
            mapToObject(msgSndSettingBean, map);
            // 这里检查重复提交
            // RcvUserService.beforeSubmit("entryPage", cpgMsgCtl.getId(),null);
            if (!StringUtils.isEmpty(type)) {
                if (RECORD_ADD.equalsIgnoreCase(type)) {
                    // 新增时要检查userId是否重复
                    MsgSendSettingService.beforeSubmit("new", msgSndSettingBean.getMsgId());
                    oc.setAttribute(MsgSendSettingOperation.CMD, MsgSendSettingOperation.CMD_INSERT);
                } else if (RECORD_MOD.equalsIgnoreCase(type)) {
                    MsgSendSettingService.beforeSubmit(null, msgSndSettingBean.getMsgId());
                    oc.setAttribute(MsgSendSettingOperation.CMD, MsgSendSettingOperation.CMD_UPDATE);
                } else if (RECORD_DELETE.equalsIgnoreCase(type)) {
                    MsgSendSettingService.beforeSubmit(null, msgSndSettingBean.getMsgId());
                    oc.setAttribute(MsgSendSettingOperation.CMD, MsgSendSettingOperation.CMD_DELETE);
                }
            }
        }

        while (updateResultBean2.hasNext()) {
            RcvObjBean bean = new RcvObjBean();
            Map map = updateResultBean2.next();
            String select = (String) map.get("select");
            mapToObject(bean, map);
            if ("true".equals(select)) {
                insertList.add(bean);
            }

        }

         while (updateResultBean3.hasNext()) {
         RcvObjBean bean = new RcvObjBean();
         Map map = updateResultBean3.next();
         String select = (String) map.get("select");
         mapToObject(bean, map);
         if ("true".equals(select)) {
         updateList.add(bean);
         }
        
         }

        if (insertList.size() == 0) {
            ExceptionUtil.throwCommonException("请至少选择一个接收用户！\r\n", "提交操作错误");
        }

        oc.setAttribute(MsgSendSettingOperation.IN_OPERATION, msgSndSettingBean);
        // 交易信息
        oc.setAttribute(MsgSendSettingOperation.IN_PARAM_INSERT, insertList);
        oc.setAttribute(MsgSendSettingOperation.IN_PARAM_MOD, updateList);
        OPCaller.call(MsgSendSettingOperation.ID, oc);

        return updateReturnBean;
    }

}

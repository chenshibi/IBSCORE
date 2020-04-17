package com.huateng.msgplatform.updater;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.common.err.Module;
import com.huateng.common.err.Rescode;
import com.huateng.commquery.result.MultiUpdateResultBean;
import com.huateng.commquery.result.UpdateResultBean;
import com.huateng.commquery.result.UpdateReturnBean;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.operation.OPCaller;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.web.commQuery.BaseUpdate;
import com.huateng.exception.AppException;
import com.huateng.msgplatform.opertation.MsgTypeOperation;

import resource.bean.msg.CpgMsgCtlTmp;

public class MsgTypeCheckUpdater extends BaseUpdate {

    public UpdateReturnBean saveOrUpdate(MultiUpdateResultBean multiUpdateResultBean, HttpServletRequest request,
            HttpServletResponse response) throws AppException {
        try {
            UpdateReturnBean updateReturnBean = new UpdateReturnBean();
            UpdateResultBean updateResultBean = multiUpdateResultBean.getUpdateResultBeanByID("CpgMsgCtlTmp");
            CpgMsgCtlTmp bean = new CpgMsgCtlTmp();
            Map map = updateResultBean.next();
            if (map == null) {
                ExceptionUtil.throwAppException("未找到指定错误", ErrorCode.ERROR_CODE_NORMAL);
            }
            mapToObject(bean, map);
            OperationContext context = new OperationContext();
            context.setAttribute(MsgTypeOperation.CMD, MsgTypeOperation.CMD_CHECK);
            context.setAttribute(MsgTypeOperation.IN_PARAM, bean);
            OPCaller.call("MsgTypeOperation", context);
            return updateReturnBean;
        } catch (AppException appEx) {
            throw appEx;
        } catch (Exception ex) {
            throw new AppException(Module.SYSTEM_MODULE, Rescode.DEFAULT_RESCODE, ex.getMessage(), ex);
        }
    }

}

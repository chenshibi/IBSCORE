package com.huateng.msgplatform.opertation;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.msgplatform.service.MsgTypeService;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgCtlTmp;

public class MsgTypeOperation extends BaseOperation {
    private static Logger log = Logger.getLogger(MsgTypeOperation.class);

    public static final String ID = "MsgTypeOperation";

    public static final String CMD = "CMD";

    public static final String IN_PARAM = "IN_PARAM";
    public static final String OUT_PARAM = "OUT_PARAM";
    public static final String IN_PARAM_PAGESIZE = "IN_PARAM_PAGESIZE";
    public static final String IN_PARAM_PAGEINDEX = "IN_PARAM_PAGEINDEX";

    public static final String CMD_ADD = "CMD_ADD";
    public static final String CMD_MODIFY = "CMD_MODIFY";
    public static final String CMD_CHANGE_STATUS = "CMD_CHANGE_STATUS";
    public static final String CMD_CHECK = "CMD_CHECK";
    public static final String CMD_REJECT = "CMD_REJECT";

    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        // 新增
        if (CMD_ADD.equals(cmd)) {
            // CpgMsgCtl bean = (CpgMsgCtl)context.getAttribute(IN_PARAM);
            // MsgTypeService service = MsgTypeService.getInstance();
            // service.addNew(bean);
        }

        // 修改
        if (CMD_MODIFY.equals(cmd)) {
            // CpgMsgCtl bean = (CpgMsgCtl)context.getAttribute(IN_PARAM);
            // MsgTypeService service = MsgTypeService.getInstance();
            // service.modify(bean);
        }
        // 有效/无效
        if (CMD_CHANGE_STATUS.equals(cmd)) {
            CpgMsgCtl bean = (CpgMsgCtl) context.getAttribute(IN_PARAM);
            MsgTypeService service = MsgTypeService.getInstance();
            service.changeStatus(bean);
        }
        // 审核
        if (CMD_CHECK.equals(cmd)) {
            CpgMsgCtlTmp bean = (CpgMsgCtlTmp) context.getAttribute(IN_PARAM);
            MsgTypeService service = MsgTypeService.getInstance();
            service.check(bean);
        }
        // 拒绝
        if (CMD_REJECT.equals(cmd)) {
            CpgMsgCtlTmp bean = (CpgMsgCtlTmp) context.getAttribute(IN_PARAM);
            MsgTypeService service = MsgTypeService.getInstance();
            service.reject(bean);
        }
    }
}
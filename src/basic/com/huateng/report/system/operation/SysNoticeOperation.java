package com.huateng.report.system.operation;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysNoticeService;

import resource.bean.basic.SysNotice;

public class SysNoticeOperation extends BaseOperation {

    private static final HtLog htlog = HtLogFactory.getLogger(SysNoticeOperation.class);
    public static final String ID = "SysNoticeOperation";
    public static final String CMD = "CMD";
    public static final String CMD_INSERT = "new";
    public static final String CMD_UPDATE = "mod";
    public static final String CMD_DELETE = "del";
    public static final String IN_PARAM = "IN_PARAM";

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void execute(OperationContext context) throws CommonException {

        String cmd = (String) context.getAttribute(CMD);
        SysNotice sysNotice = (SysNotice) context.getAttribute(IN_PARAM);
        SysNoticeService sysNoticeService = SysNoticeService.getInstance();
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        if (CMD_INSERT.equalsIgnoreCase(cmd)) {
            sysNoticeService.save(sysNotice, cmd);
            gi.addBizLog("Updater.log",
                    new String[] { gi.getTlrno(),  "系统公告维护新增【标题为：" + sysNotice.getNoticeTitle() + "】" });
            htlog.info("Updater.log",
                    new String[] { gi.getTlrno(), "系统公告维护新增【标题为：" + sysNotice.getNoticeTitle() + "】" });
        } else if (CMD_UPDATE.equalsIgnoreCase(cmd)) {
            sysNoticeService.save(sysNotice, cmd);
            gi.addBizLog("Updater.log",
                    new String[] { gi.getTlrno(),  "系统公告维护修改【标题为：" + sysNotice.getNoticeTitle() + "】" });
            htlog.info("Updater.log",
                    new String[] { gi.getTlrno(),  "系统公告维护修改【标题为：" + sysNotice.getNoticeTitle() + "】" });
        } else if (CMD_DELETE.equalsIgnoreCase(cmd)) {
            sysNoticeService.save(sysNotice, cmd);
            gi.addBizLog("Updater.log",
                    new String[] { gi.getTlrno(),  "系统公告维护删除【标题为：" + sysNotice.getNoticeTitle() + "】" });
            htlog.info("Updater.log",
                    new String[] { gi.getTlrno(),  "系统公告维护删除【标题为：" + sysNotice.getNoticeTitle() + "】" });
        }
    }

}

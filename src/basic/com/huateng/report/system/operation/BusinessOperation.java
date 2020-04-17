package com.huateng.report.system.operation;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.huateng.common.DateUtil;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.SysParams;
import resource.bean.basic.SysTaskInfo;

/*
 * 系统参数操作类
 */
public class BusinessOperation extends BaseOperation {
    private static Logger log = Logger.getLogger(BusinessOperation.class);
    public final static String ID = "businessOperation";
    public final static String CMD = "CMD";
    public final static String CMD_MOD = "CMD_MOD";
    public final static String IN_PARAM = "IN_PARAM";

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void execute(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub
        String cmd = (String) context.getAttribute(CMD);
        SysParams sysParams = (SysParams) context.getAttribute(IN_PARAM);
        // 调用服务类
        SysParamsService sysParamsService = SysParamsService.getInstance();
        if (CMD_MOD.equals(cmd)) {
            // 调用服务类更新
            // 将对象序列化写入SYS_TASK_INFO表中；
            String pk = sysParams.getId().getParamgroupId() + "#" + sysParams.getId().getParamId();

            Iterator it = sysParamsService.selectByid(sysParams.getId().getParamgroupId(),
                    sysParams.getId().getParamId());

            while (it.hasNext()) {
                SysParams sys1 = (SysParams) it.next();
                sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
                sys1.setCrtDt(DateUtil.get8Date());
                sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
                sys1.setLastUpdTms(DateUtil.get14Date());
                sys1.setLock("T");
                sysParamsService.mergeSysParamsEntity(sys1);

            }
            // sysParamsService.mergeSysParamsEntity(sysParams);
            try {

                SysTaskInfo taskInfo = ReportTaskUtil.getSysTaskInfoBean(
                        ReportEnum.REPORT_TASK_FUNCID.TASK_120299.value, ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value,
                        sysParams, pk, sysParams.getSt());

                sysParamsService.addTosystaskinfo(taskInfo);
            } catch (IOException e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
            }

        }
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        gi.addBizLog("Updater.log", new String[] { gi.getTlrno(),  "执行更新法院参数信息" });
        log.info(gi.getBrcode() + " " + gi.getTlrno() + " 执行更新法院参数信息");
    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

}

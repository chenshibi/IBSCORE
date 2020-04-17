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
public class SysParamsOperation extends BaseOperation {
    private static Logger log = Logger.getLogger(SysParamsOperation.class);
    public final static String ID = "sysPramsOperation";
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
            String memo=sysParams.getMemo();
            String paramVal=sysParams.getParamVal();
            String paramName=sysParams.getParamName();
            Iterator it = sysParamsService.selectByid(sysParams.getId().getParamgroupId(),
                    sysParams.getId().getParamId());

            while (it.hasNext()) {
                SysParams sys1 = (SysParams) it.next();
                sys1.setCrtDt(DateUtil.get8Date());
                sys1.setLastUpdOper(GlobalInfo.getCurrentInstance().getTlrno());
                sys1.setLastUpdTms(DateUtil.get14Date());
                sys1.setMemo(memo);
                sys1.setParamVal(paramVal);
                sys1.setParamName(paramName);
                sysParamsService.mergeSysParamsEntity(sys1);

            }

        }
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        gi.addBizLog("Updater.log", new String[] { gi.getTlrno(), "执行更新系统参数信息" });
        log.info(gi.getBrcode() + " " + gi.getTlrno() + " 执行更新系统参数信息");
    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

}

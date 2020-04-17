package com.huateng.report.system.operation;

import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.system.service.SysParamsService;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.PfSysParam;
import resource.bean.basic.SysTaskInfo;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.operation
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class SecParameterOperation extends BaseOperation {
    private static Logger log = Logger.getLogger(SecParameterOperation.class);
    public static final String ID = "Parameter.SecParameterOperation";
    public static final String IN_UPDATE = "IN_UPDATE";

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
        PfSysParam param = (PfSysParam) context.getAttribute(IN_UPDATE);
        SysParamsService secService = SysParamsService.getInstance();
        // 调用服务类更新
        // 将对象序列化写入SYS_TASK_INFO表中；
        String pk = param.getId().getMagicId() + "#" + param.getId().getParamId();

        Iterator it = secService.selectID(param.getId().getMagicId(), param.getId().getParamId());

        while (it.hasNext()) {
            PfSysParam sys1 = (PfSysParam) it.next();
            sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
            sys1.setLock("T");
            secService.savePfParam(sys1);
        }
        // sysParamsService.mergeSysParamsEntity(sysParams);
        try {
            SysTaskInfo taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100899.value,
                    ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, param, pk, param.getSt());
            secService.addTosystaskinfo(taskInfo);
        } catch (IOException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
        // secService.saveSecParam(param);
    }
}

package com.huateng.report.dataClean.operation;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.dataClean.bean.ReportDataCleanBean;
import com.huateng.report.dataClean.service.ReportDataCleanService;

public class ReportDataCleanOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(ReportDataCleanOperation.class);
    public static final String ID = "ReportDataCleanOperation";
    public static final String IN_OBJ = "IN_OBJ";

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
        ReportDataCleanService service = ReportDataCleanService.getInstance();
        ReportDataCleanBean bean = (ReportDataCleanBean) context.getAttribute(IN_OBJ);
        service.executeDataClean(bean);
    }

}

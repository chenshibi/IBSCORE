package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.report.common.service.ReportCommonService;

public class FavOperation extends BaseOperation {
    public static final String CMD = "CMD";
    public static final String OP_FAVT = "OP_FAVT";
    public static final String IN_FAVT = "IN_FAVT";
    public static final String ID = "Management.FavOperation";

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void execute(OperationContext context) throws CommonException {
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        String cmd = (String) context.getAttribute(CMD);
        if (OP_FAVT.equals(cmd)) {
            List<String> funcIds = (List<String>) context.getAttribute(IN_FAVT);
            ReportCommonService.getInstance().saveOrUpdateFavt(gi.getTlrno(), gi.getMenuCode(), funcIds);
        }

    }

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

}

package com.huateng.ebank.business.management.operation;

import java.util.List;

import com.huateng.ebank.business.management.service.TlrInfoExService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * Title:
 * com.huateng.ebank.business.management.operation.TlrInfoExOperation.java
 * Description: TODO Copyright (c) 2006 Company: Shanghai Huateng Software
 * Systems Co., Ltd.
 *
 * @author kangbyron
 * @version v1.0,2011-2-22
 */
public class TlrWorkloadSetOperation extends BaseOperation {
    public static final String ID = "Management.TlrWorkloadSetOp";
    public static final String CMD = "CMD";
    public static final String UPDATE_LIST = "UPDATE_LIST";

    public void afterProc(OperationContext context) throws CommonException {

    }

    public void beforeProc(OperationContext context) throws CommonException {

    }

    public void execute(OperationContext context) throws CommonException {
        List updateList = (List) context.getAttribute(UPDATE_LIST);
        TlrInfoExService service = TlrInfoExService.getInstance();
        service.updateMaxWl(updateList);
    }
}

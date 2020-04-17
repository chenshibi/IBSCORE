package com.huateng.ebank.business.bizlog.operation;

import com.huateng.ebank.business.bizlog.bean.BizLogQueryBean;
import com.huateng.ebank.business.bizlog.service.BizLogQueryService;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;

/**
 * @author JorneZhang
 * @version 创建时间：2010-1-5 下午03:13:39
 */
public class BizLogQueryOP extends BaseOperation {

    public static final String IN_PAGEINDEX = "IN_PAGEINDEX";
    public static final String IN_PAGESIZE = "IN_PAGESIZE";
    public static final String IN_BEAN = "IN_BEAN";
    public static final String OUT_LIST = "OUT_LIST";

    // 定义命令
    public static final String CMDTYPE = "CMDTYPE";
    public static final String CMD_QUERY = "CMD_QUERY";

    // 标识符bean ID
    public static final String ID = "bizLogQueryOP";

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
        String cmdType = (String) context.getAttribute(CMDTYPE);
        BizLogQueryService service = BizLogQueryService.getInstance();
        if (CMD_QUERY.equals(cmdType)) {
            Integer pageSize = (Integer) context.getAttribute(IN_PAGESIZE);
            Integer pageIndex = (Integer) context.getAttribute(IN_PAGEINDEX);
            BizLogQueryBean queryBean = (BizLogQueryBean) context.getAttribute(IN_BEAN);
            PageQueryResult list = service.getBizLogResult(queryBean, pageSize, pageIndex);
            context.setAttribute(OUT_LIST, list);
        }
    }

}

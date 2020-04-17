/**
 *
 */
package com.huateng.ebank.business.common.service;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.operator.GetNextCoreReqSeqOP;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.operation.SingleOPCaller;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.dao.basic.TlrInfoDAO;

/**
 * Title: LogSeqService Description: 日志流水服务(记录BizLog,CommLog,获取操作员流水号，获取主机流水号等)
 * Copyright: Copyright (c) 2008 Company: Shanghai Huateng Software Systems Co.,
 * Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2008-5-8
 */
public class LogSeqService {

    /**
     * Get instance of log seq service
     *
     * @return
     */
    public synchronized static LogSeqService getInstance() {
        return (LogSeqService) ApplicationContextUtils.getBean(LogSeqService.class.getName());
    }

    /**
     * 获取当前操作员的流水号
     * 
     * @return
     * @throws CommonException
     */
    public int getNextTlrMsrno() throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        String tlrno = DataFormat.trim(globalInfo.getTlrno());
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        resource.bean.basic.TlrInfo tlrinfo = tlrInfoDAO.query(tlrno);
        if (tlrinfo == null)
            ExceptionUtil.throwCommonException(ErrorCode.ERROR_CODE_USER_NOT_EXIST);
        tlrinfo.setMsrno(new Integer(tlrinfo.getMsrno().intValue() + 1));
        tlrInfoDAO.update(tlrinfo);
        return tlrinfo.getMsrno().intValue();
    }

    /**
     * 获取核心流水号
     * 
     * @return
     * @throws CommonException
     */
    public int getNextCoreSeq() throws CommonException {
        OperationContext context = new OperationContext();
        SingleOPCaller.call("Common.GetNextCoreReqSeqOP", context);
        Integer seq = (Integer) context.getAttribute(GetNextCoreReqSeqOP.CORESYS_REQSEQ);
        return seq.intValue();
    }

}

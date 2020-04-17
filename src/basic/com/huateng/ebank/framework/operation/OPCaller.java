/*
 * Created on 2005-5-11
*
*/
package com.huateng.ebank.framework.operation;

import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.LogSeqService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.BizFuncInfo;

/**
 * @author yujianjun
 *
 *         Operation caller.
 */
public class OPCaller {
    private final static Logger log = Logger.getLogger(OPCaller.class);

    private static String BEAN_NAME_KEY = "BEAN_NAME";

    public void callOperation(BaseOperation operation, OperationContext context) throws CommonException {
        try {
            GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
            if (null != globalInfo) {
                globalInfo.setTxtime(new java.sql.Time(System.currentTimeMillis()));
                /** init globalinfo . */
                // globalInfo.setContractnoFlag(SystemConstant.FLAG_OFF);
                // globalInfo.setCustcdFlag(SystemConstant.FLAG_OFF);
                // globalInfo.setAppnoFlag(SystemConstant.FLAG_OFF);
                // globalInfo.setTxamtFlag(SystemConstant.FLAG_OFF);
            }

            operation.beforeProc(context);
            /** TLS-567 增加定时任务功能到海尔系统 by zhouxuejing 2011-11-21 begin */
            if (null != globalInfo) {
                // operation.procTLsrno(context);BMS-3153
            }
            /** TLS-567 增加定时任务功能到海尔系统 by zhouxuejing 2011-11-21 end */
            operation.execute(context);
            operation.afterProc(context);
        } catch (CommonException ce) {
            throw ce;
        } catch (Throwable t) {
            // t.printStackTrace();
            ExceptionUtil.throwCommonException("系统错误", ErrorCode.ERROR_CODE_UNKNOWN, t);
        }
    }

    /**
     * 获取操作员流水号
     * 
     * @throws CommonException
     */
    private void doTlsrno() throws CommonException {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
        if (null != globalInfo) {
            int tlrMsrno = LogSeqService.getInstance().getNextTlrMsrno();
            if (log.isInfoEnabled()) {
                log.info("tlrno = " + globalInfo.getTlrno() + " msrno = " + tlrMsrno);
            }
            globalInfo.initTlsrno(tlrMsrno, 0);
        }
    }

    /**
     * 调用以beanName指定的Operation，Operation的参数为context.
     *
     * @param beanName
     *            operation's bean name
     * @param context
     *            输入输出参数
     * @throws CommonException
     *             异常发生
     */
    public static void call(String beanName, OperationContext context) throws CommonException {
        // modify by shen_antonio 20080508
        String errCd = null;
        OPCaller caller = (OPCaller) ApplicationContextUtils.getBean("operationCaller");
        BaseOperation operation = (BaseOperation) ApplicationContextUtils.getBean(beanName);
        log.info("=========opname==========" + beanName + "===============");
        String needlog = DAOUtils.getPfSysParamDAO().getPfSysParamNeedLog();
        context.setAttribute(BEAN_NAME_KEY, beanName);
        try {
            // start/end a transaction
            // if (operation.isNeedLog()) {
            if (SystemConstant.FLAG_ON.equals(needlog) && GlobalInfo.getCurrentInstanceWithoutException() != null) {
                // caller.doTlsrno();BMS-3153
            }
            // }
            caller.callOperation(operation, context);
        } catch (CommonException cex) {
            cex.printStackTrace();
            errCd = cex.getKey() == null ? "" : cex.getKey();
            throw cex;
        } catch (Exception e) {
            e.printStackTrace();
            errCd = e.getMessage();
            ExceptionUtil.throwCommonException(errCd);
            ;
        } finally {
            // 成功交易
            if (errCd == null) {
                // 记录日志 -- 只有成功时才记录.
                if (SystemConstant.FLAG_ON.equals(needlog)) {
                    try {
                        doLog(errCd, context);
                    } catch (Throwable t) {
                        log.error("记录日志时发生异常。", t);
                    }
                }
                /*
                 * if (operation.isNeedLog()) { try { doLog(errCd,context); }
                 * catch (Throwable t) { log.error("记录日志时发生异常。", t); } }
                 */
                // 失败交易
            } else {
                if (SystemConstant.FLAG_ON.equals(needlog)) {
                    try {
                        doLog(errCd, context);
                    } catch (Throwable t) {
                        log.error("记录日志时发生异常。", t);
                    }
                }
                /*
                 * if (operation.isNeedFailLog()) { try { doLog(errCd,context);
                 * } catch (Throwable t) { log.error("记录日志时发生异常。", t); } }
                 */
            }
        }
    }
    
    /**
     * 调用以beanName指定的Operation，Operation的参数为context.
     *
     * @param clazz   operation's class
     * @param context 输入输出参数
     * @throws CommonException 异常发生
     */
    public static void call(Class clazz, OperationContext context) throws CommonException {
        String errCd = null;
        OPCaller caller = (OPCaller) ApplicationContextUtils.getBean("operationCaller");
        String needlog = DAOUtils.getPfSysParamDAO().getPfSysParamNeedLog();
        try {
            BaseOperation operation = (BaseOperation) clazz.newInstance();
            log.info("=========opname==========" + clazz.getName() + "===============");
            context.setAttribute(BEAN_NAME_KEY, clazz.getName());
            caller.callOperation(operation, context);
        } catch (CommonException cex) {
            log.error(cex.getMessage(), cex);
            errCd = cex.getKey() == null ? "" : cex.getKey();
            throw cex;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            errCd = e.getMessage();
            ExceptionUtil.throwCommonException(errCd);
        } finally {
            if (SystemConstant.FLAG_ON.equals(needlog)) {
                try {
                    doLog(errCd, context);
                } catch (Throwable t) {
                    log.error("记录日志时发生异常。", t);
                }
            }
        }
    }

    

    /**
     * 记录日志。
     *
     * @throws Exception
     */
    private static void doLog(String errorCode, OperationContext context) throws Exception {
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
        if (null == globalInfo) {
            log.warn("globalInfo为空,不能记录业务日志。");
            return;
        }
        String needquerylog = DAOUtils.getPfSysParamDAO().getPfSysParamNeedQueryLog();
        String needBizLog = SystemConstant.FLAG_OFF;
        String beanName = (String) context.getAttribute(BEAN_NAME_KEY);
        String bizFuncType = "";
        BizFuncInfo info = null;
        try {
            List list = DAOUtils.getBizFuncInfoDAO().queryByCondition(" po.id = '" + beanName + "' ");
            if (list != null && list.size() > 0) {
                info = (BizFuncInfo) list.get(0);
                needBizLog = info.getLogType();
                bizFuncType = info.getBizFuncType();
            } else {
                log.warn("=====================" + beanName + "===流水日志用交易码表没有配置");
            }
        } catch (RuntimeException e) {
            log.warn("流水日志用交易码表查询错误或没有对应记录,不能记录业务日志。");
            return;
        }

        if (SystemConstant.FLAG_OFF.equals(needBizLog)) {
            // 此功能不需要记日志
            return;
        }
        if (SystemConstant.BIZ_FUNC_TYPE_QUERY.equals(bizFuncType) && SystemConstant.FLAG_OFF.equals(needquerylog)) {
            // 查询类交易&&查询类不记日志
            return;
        }
        // 记录日志
        // BizLog bizLog = new BizLog();
        // bizLog.setTxdate(globalInfo.getTxdate());
        // bizLog.setBrcode(DataFormat.trim(globalInfo.getBrcode()));
        // bizLog.setTlrno(DataFormat.trim(globalInfo.getTlrno()));
        // bizLog.setTlsrno(DataFormat.trim(globalInfo.getTlsrno()));
        // bizLog.setBranchBrcode(DataFormat.trim(globalInfo.getBrcode()));
        // bizLog.setTxtime(globalInfo.getTxtime());
        // // bizLog.setBizFuncCode(globalInfo.getFuncCode());
        // bizLog.setBizFuncCode(beanName);
        // bizLog.setErrCode(DataFormat.trim(errorCode));
        // bizLog.setCurcd(SystemConstant.CURCD_RMB);
        // bizLog.setIp(DataFormat.trim(globalInfo.getIp()));
        //
        // bizLog.setContractno(DataFormat.trim(globalInfo.getContractno()));
        // bizLog.setCustcd(DataFormat.trim(globalInfo.getCustcd()));
        // bizLog.setAppno(DataFormat.trim(globalInfo.getAppno()));
        // bizLog.setTxamt(new BigDecimal(globalInfo.getTxamt()));
        // // if (globalInfo.isPlTlsrnoFlag()) {
        // // bizLog.setPlTlsrno(globalInfo.getPlTlsrno());
        // // }
        // // 记录bizlog中的misc信息
        // if (context != null &&
        // context.getAttribute(SystemConstant.CONTEXT_BIZ_LOG_MISC) != null) {
        // bizLog.setMisc(context.getAttribute(SystemConstant.CONTEXT_BIZ_LOG_MISC).toString());
        // }
        // LogSeqService.getInstance().saveBizLog(bizLog);
    }
}
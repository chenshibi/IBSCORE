/*
 * Created on 2005-5-11
 *
 */
package com.huateng.ebank.framework.operation;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * @author yujianjun
 *
 *         Operation caller.
 */
public class SingleOPCaller {
    private final static Logger log = Logger.getLogger(SingleOPCaller.class);

    public void callOperation(BaseOperation operation, OperationContext context) throws CommonException {
        try {
            operation.beforeProc(context);
            operation.execute(context);
            operation.afterProc(context);
        } catch (CommonException ce) {
            throw ce;
        } catch (Throwable t) {
            ExceptionUtil.throwCommonException("GD0001_1", ErrorCode.ERROR_CODE_UNKNOWN, t);
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
        SingleOPCaller caller = (SingleOPCaller) ApplicationContextUtils.getBean("singleCaller");
        BaseOperation operation = (BaseOperation) ApplicationContextUtils.getBean(beanName);
        try {
            caller.callOperation(operation, context);
        } catch (CommonException cex) {
            throw cex;
        } finally {
        }
    }
}
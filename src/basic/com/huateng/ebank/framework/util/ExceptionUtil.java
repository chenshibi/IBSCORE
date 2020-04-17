/*
 * Created on 2005-3-3
 * $Id: ExceptionUtil.java,v 1.2 2005/05/27 09:38:36 liuwen Exp $
 *
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * $Log: ExceptionUtil.java,v $
 * Revision 1.2  2005/05/27 09:38:36  liuwen
 * no message
 *
 * Revision 1.1.1.1  2005/05/24 06:04:49  liuwen
 * init.
 *
 * Revision 1.1.1.2  2005/05/23 10:52:25  yujianjun
 * no message
 *
 * Revision 1.1.1.1  2005/05/16 08:52:12  yujianjun
 * no message
 *
 * Revision 1.1  2005/04/04 03:36:24  liuwen
 * no message
 *
 * Revision 1.1.1.1  2005/03/21 06:21:06  liuwen
 * Initialization.
 *
 */
package com.huateng.ebank.framework.util;

import com.huateng.ebank.business.common.MessageResourceUtil;
import com.huateng.ebank.framework.exceptions.CommonException;

/**
 * @author liu_wen@huateng.com
 * @version $$Revision: 1.2 $$
 *
 *          异常工具类.
 * @see com.huateng.ebank.framework.exceptions.CommonException.
 */
public class ExceptionUtil {

    /**
     * modify by shen_antonio 20111221 JIRA: FPP-3 i18n
     * <P>
     * throwCommonException:
     * <P>
     * 适用条件: 国际化环境使用
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param key
     * @param t
     * @param objs
     * @throws CommonException
     * @throws @since
     *             ExceptionUtil Ver1.1
     */
    public static void throwCommonException(String key, Throwable t, Object[] objs) throws CommonException {
        CommonException ce = new CommonException(MessageResourceUtil.getErrorMessage("OPER_FAILED") + key, t);
        ce.setKey(key);
        ce.setObjs(objs);
        throw ce;
    }

    /**
     * <P>
     * throwCommonException:
     * <P>
     * 适用条件: 国际化环境使用
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param key
     * @param objs
     * @throws CommonException
     * @throws @since
     *             ExceptionUtil Ver1.1
     */
    public static void throwCommonException(String key, Object[] objs) throws CommonException {
        CommonException ce = new CommonException(MessageResourceUtil.getErrorMessage("OPER_FAILED") + key);
        ce.setKey(key);
        ce.setObjs(objs);
        throw ce;
    }

    /**
     * <P>
     * throwCommonException:(这里用一句话描述这个方法的作用)
     * <P>
     * 适用条件: 非国际化环境下使用
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param msg
     * @param key
     * @param t
     * @throws CommonException
     * @throws @since
     *             ExceptionUtil Ver1.1
     * @deprecated since FlowPower 1.1
     */
    public static void throwCommonException(String msg, String key, Throwable t) throws CommonException {
        CommonException ce = new CommonException(msg, t);
        ce.setKey(key);
        throw ce;
    }

    /**
     * <P>
     * throwCommonException:(这里用一句话描述这个方法的作用)
     * <P>
     * 适用条件: 非国际化环境下使用
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param msg
     * @param key
     * @throws CommonException
     * @throws @since
     *             ExceptionUtil Ver1.1
     * @deprecated since FlowPower 1.1
     */
    public static void throwCommonException(String msg, String key) throws CommonException {
        CommonException ce = new CommonException(msg);
        ce.setKey(key);
        throw ce;
    }

    public static void throwCommonException(String key) throws CommonException {
        /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
        /*
         * old code //CommonException ce = new CommonException("异常中的key值为:" +
         * key);
         * 
         */
        CommonException ce = new CommonException(MessageResourceUtil.getErrorMessage("OPER_FAILED") + key);
        /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end . */
        ce.setKey(key);
        throw ce;
    }

    /**
     * <P>
     * throwAppException:(这里用一句话描述这个方法的作用)
     * <P>
     * 适用条件: 非国际化环境下使用
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param msg
     * @param key
     * @throws CommonException
     * @throws @since
     *             ExceptionUtil Ver1.1
     * @deprecated since FlowPower 1.1
     */
    public static void throwAppException(String msg, String key) throws CommonException {
        CommonException ce = new CommonException(msg);
        ce.setKey(key);
        throw ce;
    }
}
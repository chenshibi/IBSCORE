/*
 * Created on 2005-3-10
 * $Id: ApplicationContextUtils.java,v 1.2 2005/07/20 11:54:27 liuwen Exp $
 *
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.huateng.ebank.framework.util;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.util.ContextUtil;

/**
 * @author liu_wen@huateng.com
 * @version $Revision: 1.2 $
 *
 *          用来方便的调用Spring的方法的类。
 */
public class ApplicationContextUtils {
    private static ApplicationContext context = null;

    private static Logger log = Logger.getLogger(ApplicationContextUtils.class);

    public static synchronized void init(String location) throws CommonException {
        try {
            if (null == context) {
                String[] locations = StringUtils.tokenizeToStringArray(location, ",");
                if (log.isInfoEnabled()) {
                    for (int i = 0; i < locations.length; i++) {
                        log.info("Loading spring config from files:" + locations[i].trim());
                    }
                    log.info("Loading spring config from files:" + location);
                }
                context = new ClassPathXmlApplicationContext(locations);
                /** shen_antonio. */
                ContextUtil.setContext(context);
            }
        } catch (Exception ex) {
            log.error("初始化spring配置失败。", ex);
            ExceptionUtil.throwCommonException("获得系统配置信息(spring相关)时出现错误.", "errors.system.spring", ex);
        }
    }

    /*
     * public static synchronized ApplicationContext getApplicationContext()
     * throws CommonException { init(); return _context; }
     */

    public static Object getBean(String beanName) {
        // ApplicationContext ac = getApplicationContext();
        if (null == context) {
            throw new IllegalStateException("ApplicationContext没有被初始化.");
        }
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clazz) {
        // ApplicationContext ac = getApplicationContext();
        if (null == context) {
            throw new IllegalStateException("ApplicationContext没有被初始化.");
        }
        return context.getBean(clazz);
    }
    public synchronized static void close() {
        context = null;
    }

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        ApplicationContextUtils.context = context;
    }
}
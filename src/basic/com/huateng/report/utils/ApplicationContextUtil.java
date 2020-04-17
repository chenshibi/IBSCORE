package com.huateng.report.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author YiSiliang
 * @date 2019/1/10 10:17
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ApplicationContextUtil.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return ApplicationContextUtil.applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return ApplicationContextUtil.applicationContext.getBean(requiredType);
    }
}

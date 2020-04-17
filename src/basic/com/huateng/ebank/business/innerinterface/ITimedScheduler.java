package com.huateng.ebank.business.innerinterface;

import javax.servlet.ServletContext;

import com.huateng.ebank.framework.exceptions.CommonException;

public interface ITimedScheduler {
    public static final String TIMED_STATUS_1 = "1";// 启动

    public static final String TIMED_STATUS_0 = "0";// 停止

    // 初始化加载
    public void run(ServletContext context) throws CommonException;

}

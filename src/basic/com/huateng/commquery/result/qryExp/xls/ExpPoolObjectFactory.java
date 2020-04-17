package com.huateng.commquery.result.qryExp.xls;

import java.io.IOException;

import org.apache.commons.pool.BasePoolableObjectFactory;
import org.apache.log4j.Logger;

import com.huateng.commquery.result.qryExp.IQueryExport;
import com.huateng.report.utils.LogExceptionUtils;

/**
 * 用于对象缓冲池中的对象操作：创建、清除、挂起等
 * 
 * @author 116091
 *
 */
public abstract class ExpPoolObjectFactory extends BasePoolableObjectFactory {
    private static Logger log = Logger.getLogger(ExpPoolObjectFactory.class);

    /**
     * 为这个类添加一个void activateObject(Object obj)方法。这个方法用于将对象“激活”??设置为适合开始使用的状态。
     */
    public void activateObject(Object obj) throws Exception {
        System.err.println("Activating Object " + obj);
    }

    /**
     * when an object is returned to the pool, we'll clear it out 对象“挂起”
     * 设置为适合开始休眠的状态。
     */
    public void passivateObject(Object obj) {
        IQueryExport export = (IQueryExport) obj;
        try {
            export.clear();
        } catch (IOException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
            System.out.println("Close System Resource!");
        }
    }

    /**
     * 为这个类添加一个boolean validateObject(Object obj)方法。
     * 这个方法用于校验一个具体的对象是否仍然有效，已失效的对象会被自动交给destroyObject方法销毁
     */
    // public boolean validateObject(Object obj) {
    // boolean result = (Math.random() > 0.5);
    // System.err.println("Validating Object " + obj + " : " + result);
    // return result;
    // }

    /**
     * 为这个类添加一个void destroyObject(Object obj)方法。
     * 这个方法用于销毁被validateObject判定为已失效的对象。
     */
    public void destroyObject(Object obj) throws Exception {
        System.err.println("Destroying Object " + obj);
    }
}

/*
 * ===================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ===================================================================
 */

package com.huateng.ebank.framework.operation;

import java.util.Enumeration;
import java.util.Hashtable;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

/**
 * 操作上下文内容类，提供一个完整操作业务数据保存的数据结构
 */

public class OperationContext {

    public OperationContext() {
        dataHashtable = new Hashtable<String, Object>();
    }

    private Hashtable<String, Object> dataHashtable;

    public Object getAttribute(String key) {
        return dataHashtable.get(key);
    }

    public Object setAttribute(String key, Object value) {
        return dataHashtable.put(key, value);
    }

    public Object removeAttribute(Object key) {
        return dataHashtable.remove(key);
    }

    /**
     * 判断一个对象是否是key。
     * 
     * @param key
     *            授信号
     * @return boolean, 如果key是Hashtable中的key的话，返回true，否则，返回false。
     */
    public boolean isKey(Object key) {
        return dataHashtable.containsKey(key);
    }

    /**
     * 判断一个对象是否value。
     * 
     * @param value
     * @return boolean, 如果value是Hashtable中的value的话，返回true，否则，返回false。
     */
    public boolean isValue(Object value) {
        return dataHashtable.containsValue(value);
    }

    /*
     * getAllKeys
     * 
     * @author WU_JAMES
     * 
     * Returns an enumeration of the keys in this hashtable. Parameters:
     * 
     * Returns: an enumeration of the keys in this hashtable. Throws:
     * 
     */
    public Enumeration getAllKeys() {
        return dataHashtable.keys();
    }

    /*
     * getAllValues
     * 
     * @author WU_JAMES
     * 
     * Returns an enumeration of the elements in this hashtable. Parameters:
     * 
     * Returns: an enumeration of the elements in this hashtable. Throws:
     * 
     */

    public Enumeration getAllValues() {
        return dataHashtable.elements();
    }

    /*
     * isEmpty
     * 
     * @author WU_JAMES
     * 
     * Tests if this hashtable maps no keys to values. Parameters:
     * 
     * Returns: true if this hashtable maps no keys to values; false otherwise.
     * Throws:
     * 
     */

    public boolean isEmpty() {
        return dataHashtable.isEmpty();
    }

    /*
     * size
     * 
     * @author WU_JAMES
     * 
     * Returns the number of keys in this hashtable. Parameters:
     * 
     * Returns: the number of keys in this hashtable. Throws:
     * 
     */

    public int size() {
        return dataHashtable.size();
    }

    /*
     * clear
     * 
     * @author WU_JAMES
     * 
     * clear the all key-value of hashtable. Parameters:
     * 
     * Returns:
     * 
     * Throws:
     * 
     */

    public void clear() {
        dataHashtable.clear();
    }

    /**
     * added by liuwen. 从指定的context中获取key所对应的值。
     * 
     * @param context
     *            参数容器。
     * @param key
     *            参数名称
     * @return key所对应的值。
     * @throws CommonException
     *             如果没有找到key所对应的值。
     */
    public static Object getValue(OperationContext context, String key) throws CommonException {
        Object obj = context.getAttribute(key);
        if (null == obj) {
            /* modify by shen_antonio 20111221 JIRA: FPP-3 begin . */
            ExceptionUtil.throwCommonException("缺少参数-" + key);
            /* modify by shen_antonio 20111221 JIRA: FPP-3 end . */
        }
        return obj;
    }
}

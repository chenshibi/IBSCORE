/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.CallbackException;
import org.hibernate.EntityMode;
import org.hibernate.Hibernate;
import org.hibernate.Interceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;

import com.huateng.common.CommonFunction;
import com.huateng.ebank.business.common.GlobalInfo;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.2 $
 * @date 2005-7-26
 *
 *       Hibernate访问数据库的过滤器.
 */
public class HibernateInterceptor implements Interceptor {

    /*
     * 当载入时, 修改state从而使得所有的字符串类型被trim.
     */
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {

        for (int i = 0; i < types.length; i++) {
            if (Hibernate.STRING.equals(types[i])) {
                String s = (String) state[i];
                if (null != s) {
                    state[i] = s.trim();
                }
                /** for oracle . */
                /*
                 * else{ state[i] = ""; }
                 */
            }
            /*
             * else if(types[i].equals(Hibernate.BIG_INTEGER)||
             * types[i].equals(Hibernate.BIG_DECIMAL)||
             * types[i].equals(Hibernate.DOUBLE)||
             * types[i].equals(Hibernate.INTEGER)||
             * types[i].equals(Hibernate.FLOAT)||
             * types[i].equals(Hibernate.LONG)||
             * types[i].equals(Hibernate.SHORT)){ if(state[i]==null) state[i] =
             * new Integer(0); }
             */
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#onFlushDirty(java.lang.Object,
     * java.io.Serializable, java.lang.Object[], java.lang.Object[],
     * java.lang.String[], org.hibernate.type.Type[])
     */
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
            String[] propertyNames, Type[] types) throws CallbackException {
        int length = propertyNames.length;
        for (int i = 0; i < length; i++) {
            if (propertyNames[i].equalsIgnoreCase("LASTUPDOPERID")) {
                GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
                if (globalInfo != null && currentState[i] == null) {
                    currentState[i] = globalInfo.getTlrno();
                }
            } else if (propertyNames[i].equalsIgnoreCase("LASTUPDTIME")) {
                try {
                    if (types[i].equals(Hibernate.STRING) || types[i].equals(Hibernate.CHARACTER)) {
                        currentState[i] = CommonFunction.getLocalDateTime14();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#onSave(java.lang.Object,
     * java.io.Serializable, java.lang.Object[], java.lang.String[],
     * org.hibernate.type.Type[])
     */
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        int length = propertyNames.length;
        for (int i = 0; i < length; i++) {
            if (propertyNames[i].equalsIgnoreCase("LASTUPDOPERID")) {
                GlobalInfo globalInfo = GlobalInfo.getCurrentInstanceWithoutException();
                if (globalInfo != null && state[i] == null) {
                    state[i] = globalInfo.getTlrno();
                }
            } else if (propertyNames[i].equalsIgnoreCase("LASTUPDTIME")) {
                try {
                    if (types[i].equals(Hibernate.STRING) || types[i].equals(Hibernate.CHARACTER)) {
                        state[i] = CommonFunction.getLocalDateTime14();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#onDelete(java.lang.Object,
     * java.io.Serializable, java.lang.Object[], java.lang.String[],
     * org.hibernate.type.Type[])
     */
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#preFlush(java.util.Iterator)
     */
    public void preFlush(Iterator entities) throws CallbackException {

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#postFlush(java.util.Iterator)
     */
    public void postFlush(Iterator entities) throws CallbackException {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#isUnsaved(java.lang.Object)
     */
    public Boolean isUnsaved(Object entity) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#findDirty(java.lang.Object,
     * java.io.Serializable, java.lang.Object[], java.lang.Object[],
     * java.lang.String[], org.hibernate.type.Type[])
     */
    public int[] findDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
            String[] propertyNames, Type[] types) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.hibernate.Interceptor#instantiate(java.lang.Class,
     * java.io.Serializable)
     */
    public Object instantiate(Class clazz, Serializable id) throws CallbackException {
        return null;
    }

    // *************************************** hibrenate 2 升级到 hibernate 3
    // 后增加以下的方法

    public void afterTransactionBegin(Transaction arg0) {
        // TODO Auto-generated method stub

    }

    public void afterTransactionCompletion(Transaction arg0) {
        // TODO Auto-generated method stub

    }

    public void beforeTransactionCompletion(Transaction arg0) {
        // TODO Auto-generated method stub

    }

    public Object getEntity(String arg0, Serializable arg1) throws CallbackException {
        // TODO Auto-generated method stub
        return null;
    }

    public String getEntityName(Object arg0) throws CallbackException {
        // TODO Auto-generated method stub
        return null;
    }

    public Object instantiate(String arg0, EntityMode arg1, Serializable arg2) throws CallbackException {
        // TODO Auto-generated method stub
        return null;
    }

    public Boolean isTransient(Object arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    public void onCollectionRecreate(Object arg0, Serializable arg1) throws CallbackException {
        // TODO Auto-generated method stub

    }

    public void onCollectionRemove(Object arg0, Serializable arg1) throws CallbackException {
        // TODO Auto-generated method stub

    }

    public void onCollectionUpdate(Object arg0, Serializable arg1) throws CallbackException {
        // TODO Auto-generated method stub

    }

    public String onPrepareStatement(String arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

}

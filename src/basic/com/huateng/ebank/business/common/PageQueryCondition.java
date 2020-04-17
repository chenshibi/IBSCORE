/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

import org.hibernate.type.Type;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-7-14 分页查询条件
 */
public class PageQueryCondition {
    private int pageSize; /* 每页的记录数 */
    private int pageIndex; /* 需要查询第几页, 从0开始 */
    private String queryString; /* 查询条件 */
    private Object[] objArray; /* 查询变量 */
    private Type[] typeArray; /* 变量类型 */

    /**
     * @return Returns the objArray.
     */
    public Object[] getObjArray() {
        return objArray;
    }

    /**
     * @param objArray
     *            The objArray to set.
     */
    public void setObjArray(Object[] objArray) {
        this.objArray = objArray;
    }

    /**
     * @return Returns the pageIndex.
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageIndex
     *            The pageIndex to set.
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return Returns the pageSize.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            The pageSize to set.
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return Returns the queryString.
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * @param queryString
     *            The queryString to set.
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * @return Returns the typeArray.
     */
    public Type[] getTypeArray() {
        return typeArray;
    }

    /**
     * @param typeArray
     *            The typeArray to set.
     */
    public void setTypeArray(Type[] typeArray) {
        this.typeArray = typeArray;
    }
}

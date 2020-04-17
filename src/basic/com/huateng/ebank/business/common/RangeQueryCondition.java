package com.huateng.ebank.business.common;

import java.io.Serializable;

import org.hibernate.type.Type;

@SuppressWarnings("ucd")
public class RangeQueryCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    private int start; /* 起始记录数 0-based */
    private int count; /* 记录数 */

    private String queryString; /* 查询条件 */
    private Object[] objArray; /* 查询变量 */
    private Type[] typeArray; /* 变量类型 */

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object[] getObjArray() {
        return objArray;
    }

    public void setObjArray(Object[] objArray) {
        this.objArray = objArray;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public Type[] getTypeArray() {
        return typeArray;
    }

    public void setTypeArray(Type[] typeArray) {
        this.typeArray = typeArray;
    }
}

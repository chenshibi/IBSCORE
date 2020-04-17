package com.huateng.report.pboc.entity;

/**
 * @author Grassy
 * @date 2019/2/23 19:49
 * @jdk.version 1.8
 * @desc
 */
public class MyError {
    private String objectName;

    private String field;

    private String msg;

    private String value;


    public MyError() {
        super();
    }



    public MyError(String field, String msg) {
        super();
        this.field = field;
        this.msg = msg;
    }



    public MyError(String objectName, String field, String msg) {
        super();
        this.field = field;
        this.msg = msg;
        this.objectName = objectName;
    }



    public MyError(String objectName, String field, String msg, String value) {
        super();
        this.objectName = objectName;
        this.field = field;
        this.msg = msg;
        this.value = value;
    }



    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }



    public String getObjectName() {
        return objectName;
    }



    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }



    @Override
    public String toString() {
        return "MyError [objectName=" + objectName + ", field=" + field
                + ", msg=" + msg + ", value=" + value + "]";
    }

}

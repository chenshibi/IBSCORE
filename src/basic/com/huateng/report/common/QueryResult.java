package com.huateng.report.common;

/**
 * @author YiSiliang
 * @date 2019/1/10 09:55
 */

/**
 *
 */
public class QueryResult {
    /**
     * 0000-success
     * other-failed
     */
    private String code;
    private String id;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

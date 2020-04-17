package com.huateng.report.pboc.view;

/**
 * @author Grassy
 * @date 2019/1/29 10:43
 * @jdk.version 1.8
 * @desc
 */
public class BatchCorpMakeBean {

    private String requestId;
    private String entName;
    private String entCertType;
    private String entCertNum;
    private String queryReason;
    private String serviceCode;
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }

    public String getEntCertType() {
        return entCertType;
    }

    public void setEntCertType(String entCertType) {
        this.entCertType = entCertType;
    }

    public String getEntCertNum() {
        return entCertNum;
    }

    public void setEntCertNum(String entCertNum) {
        this.entCertNum = entCertNum;
    }

    public String getQueryReason() {
        return queryReason;
    }

    public void setQueryReason(String queryReason) {
        this.queryReason = queryReason;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }


}

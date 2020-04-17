package com.huateng.report.pboc.view;

/**
 * @author Grassy
 * @date 2019/1/14 17:26
 * @jdk.version 1.8
 * @desc
 */
public class CorpMakeBean {
    private String entName;
    private String entCertType;
    private String entCertNum;
    private String queryReason;
    private String serviceCode;

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



    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }


}

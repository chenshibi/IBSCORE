package com.huateng.ebank.business.common.bean;

@SuppressWarnings("ucd")
public class MgnDepartInfoBean {

    private Integer id;

    private Integer departId;

    private String mgnName;

    private String mgnNo;

    private String departName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDepartId() {
        return departId;
    }

    public void setDepartId(Integer departId) {
        this.departId = departId;
    }

    public String getMgnName() {
        return mgnName;
    }

    public void setMgnName(String mgnName) {
        this.mgnName = mgnName;
    }

    public String getMgnNo() {
        return mgnNo;
    }

    public void setMgnNo(String mgnNo) {
        this.mgnNo = mgnNo;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}

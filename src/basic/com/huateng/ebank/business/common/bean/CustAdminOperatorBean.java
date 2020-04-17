package com.huateng.ebank.business.common.bean;

/**
 * @Description:
 * @Package: com.huateng.ebank.business.custadmin.bean
 * @author: fubo
 * @date: 2010-8-3 涓婂崃10:28:53
 * @Copyright: Copyright (c) 2010
 * @Company: Shanghai Huateng Software Systems Co., Ltd.
 */
public class CustAdminOperatorBean {
    private java.lang.String id;
    private java.lang.String roleName;

    private java.lang.String tlrno;
    private java.lang.String status;
    private java.lang.String flag;// modify add 操作员状态
    private java.lang.String tlrName;
    private java.lang.String lastaccesstm;

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getRoleName() {
        return roleName;
    }

    public void setRoleName(java.lang.String roleName) {
        this.roleName = roleName;
    }

    public java.lang.String getTlrno() {
        return tlrno;
    }

    public void setTlrno(java.lang.String tlrno) {
        this.tlrno = tlrno;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getTlrName() {
        return tlrName;
    }

    public void setTlrName(java.lang.String tlrName) {
        this.tlrName = tlrName;
    }

    public java.lang.String getLastaccesstm() {
        return lastaccesstm;
    }

    public void setLastaccesstm(java.lang.String lastaccesstm) {
        this.lastaccesstm = lastaccesstm;
    }

    public java.lang.String getFlag() {
        return flag;
    }

    public void setFlag(java.lang.String flag) {
        this.flag = flag;
    }

}

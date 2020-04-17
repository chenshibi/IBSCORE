package com.huateng.report.system.bean;

import java.io.Serializable;

import com.huateng.report.utils.RepList;

import resource.bean.basic.TlrBctlRel;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrRoleRel;

public class TlrInfoAuditBean implements Serializable {
    private static final long serialVersionUID = 3555678777321230392L;
    private TlrInfo tlrInfo;
    private RepList<TlrRoleRel> roleRellist;
    private RepList<TlrBctlRel> bctlRellist;

    public TlrInfo getTlrInfo() {
        return tlrInfo;
    }

    public void setTlrInfo(TlrInfo tlrInfo) {
        this.tlrInfo = tlrInfo;
    }

    public RepList<TlrRoleRel> getRoleRellist() {
        return roleRellist;
    }

    public void setRoleRellist(RepList<TlrRoleRel> roleRellist) {
        this.roleRellist = roleRellist;
    }

    public RepList<TlrBctlRel> getBctlRellist() {
        return bctlRellist;
    }

    public void setBctlRellist(RepList<TlrBctlRel> bctlRellist) {
        this.bctlRellist = bctlRellist;
    }

}
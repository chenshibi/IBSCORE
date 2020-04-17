package com.huateng.report.system.bean;

import resource.bean.basic.Bctl;
import resource.bean.basic.PfSysParam;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysNotice;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysTaskInfo;

/**
 *
 * @author zjx 这个是用来存储待审批的中间页面的对象的bean 包含taskinfobean和相应任务类型对应的bean;
 *
 */
public class TaskListBean {

    // primary key

    private String id;
    private SysTaskInfo sysTaskInfo;

    // 审批时显示使用,目前共有9种
    private SysParams sysParams;
    private Bctl bctl;
    private RoleInfo roleInfo;
    private TlrInfoAuditBean tlrInfo;
    // 系统安全参数
    private PfSysParam pfSysparam;

    private SysNotice sysNotice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SysTaskInfo getSysTaskInfo() {
        return sysTaskInfo;
    }

    public void setSysTaskInfo(SysTaskInfo sysTaskInfo) {
        this.sysTaskInfo = sysTaskInfo;
    }

    public SysParams getSysParams() {
        return sysParams;
    }

    public void setSysParams(SysParams sysParams) {
        this.sysParams = sysParams;
    }

    public Bctl getBctl() {
        return bctl;
    }

    public void setBctl(Bctl bctl) {
        this.bctl = bctl;
    }

    public RoleInfo getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(RoleInfo ob) {
        this.roleInfo = ob;
    }

    public TlrInfoAuditBean getTlrInfo() {
        return tlrInfo;
    }

    public void setTlrInfo(TlrInfoAuditBean tlrInfo) {
        this.tlrInfo = tlrInfo;
    }

    public PfSysParam getPfSysparam() {
        return pfSysparam;
    }

    public void setPfSysparam(PfSysParam pfSysparam) {
        this.pfSysparam = pfSysparam;
    }

    public SysNotice getSysNotice() {
        return sysNotice;
    }

    public void setSysNotice(SysNotice sysNotice) {
        this.sysNotice = sysNotice;
    }

}

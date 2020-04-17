package resource.bean.msg.base;

import java.io.Serializable;

public abstract class BaseCpgClientEmailCtl implements Serializable {

    private static final long serialVersionUID = 1L;

    java.lang.String id;
    java.lang.String msgId;
    java.lang.String msgName;
    java.lang.String sysName;
    java.lang.String brno;
    java.lang.String clientSnd;
    java.lang.String opsSnd;
    java.lang.String email;
    java.lang.String st;
    java.lang.String mdTlr;
    java.lang.String mdTime;
    java.lang.String apvTlr;
    java.lang.String apvTime;
    java.lang.String crtDt;
    java.lang.String roleGroup;
    java.lang.String isLock;
    java.lang.String rsv1;
    java.lang.String rsv2;
    java.lang.String rsv3;
    java.lang.String rsv4;
    java.lang.String rsv5;
    java.lang.String rsv6;

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getMsgId() {
        return msgId;
    }

    public void setMsgId(java.lang.String msgId) {
        this.msgId = msgId;
    }

    public java.lang.String getMsgName() {
        return msgName;
    }

    public void setMsgName(java.lang.String msgName) {
        this.msgName = msgName;
    }

    public java.lang.String getSysName() {
        return sysName;
    }

    public void setSysName(java.lang.String sysName) {
        this.sysName = sysName;
    }

    public java.lang.String getBrno() {
        return brno;
    }

    public void setBrno(java.lang.String brno) {
        this.brno = brno;
    }

    public java.lang.String getClientSnd() {
        return clientSnd;
    }

    public void setClientSnd(java.lang.String clientSnd) {
        this.clientSnd = clientSnd;
    }

    public java.lang.String getOpsSnd() {
        return opsSnd;
    }

    public void setOpsSnd(java.lang.String opsSnd) {
        this.opsSnd = opsSnd;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getSt() {
        return st;
    }

    public void setSt(java.lang.String st) {
        this.st = st;
    }

    public java.lang.String getMdTlr() {
        return mdTlr;
    }

    public void setMdTlr(java.lang.String mdTlr) {
        this.mdTlr = mdTlr;
    }

    public java.lang.String getMdTime() {
        return mdTime;
    }

    public void setMdTime(java.lang.String mdTime) {
        this.mdTime = mdTime;
    }

    public java.lang.String getApvTlr() {
        return apvTlr;
    }

    public void setApvTlr(java.lang.String apvTlr) {
        this.apvTlr = apvTlr;
    }

    public java.lang.String getApvTime() {
        return apvTime;
    }

    public void setApvTime(java.lang.String apvTime) {
        this.apvTime = apvTime;
    }

    public java.lang.String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(java.lang.String crtDt) {
        this.crtDt = crtDt;
    }

    public java.lang.String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(java.lang.String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public java.lang.String getIsLock() {
        return isLock;
    }

    public void setIsLock(java.lang.String isLock) {
        this.isLock = isLock;
    }

    public java.lang.String getRsv1() {
        return rsv1;
    }

    public void setRsv1(java.lang.String rsv1) {
        this.rsv1 = rsv1;
    }

    public java.lang.String getRsv2() {
        return rsv2;
    }

    public void setRsv2(java.lang.String rsv2) {
        this.rsv2 = rsv2;
    }

    public java.lang.String getRsv3() {
        return rsv3;
    }

    public void setRsv3(java.lang.String rsv3) {
        this.rsv3 = rsv3;
    }

    public java.lang.String getRsv4() {
        return rsv4;
    }

    public void setRsv4(java.lang.String rsv4) {
        this.rsv4 = rsv4;
    }

    public java.lang.String getRsv5() {
        return rsv5;
    }

    public void setRsv5(java.lang.String rsv5) {
        this.rsv5 = rsv5;
    }

    public java.lang.String getRsv6() {
        return rsv6;
    }

    public void setRsv6(java.lang.String rsv6) {
        this.rsv6 = rsv6;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("msgId = [" + msgId + "], ");
        sb.append("msgName = [" + msgName + "], ");
        sb.append("sysName = [" + sysName + "], ");
        sb.append("brno = [" + brno + "], ");
        sb.append("clientSnd = [" + clientSnd + "], ");
        sb.append("opsSnd = [" + opsSnd + "], ");
        sb.append("email = [" + email + "], ");
        sb.append("st = [" + st + "], ");
        sb.append("mdTlr = [" + mdTlr + "], ");
        sb.append("mdTime = [" + mdTime + "], ");
        sb.append("apvTlr = [" + apvTlr + "], ");
        sb.append("apvTime = [" + apvTime + "], ");
        sb.append("crtDt = [" + crtDt + "], ");
        sb.append("roleGroup = [" + roleGroup + "], ");
        sb.append("isLock = [" + isLock + "], ");
        sb.append("rsv1 = [" + rsv1 + "], ");
        sb.append("rsv2 = [" + rsv2 + "], ");
        sb.append("rsv3 = [" + rsv3 + "], ");
        sb.append("rsv4 = [" + rsv4 + "], ");
        sb.append("rsv5 = [" + rsv5 + "], ");
        sb.append("rsv6 = [" + rsv6 + "], ");
        return sb.toString();
    }

}

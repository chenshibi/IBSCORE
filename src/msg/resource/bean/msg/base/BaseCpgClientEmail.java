package resource.bean.msg.base;

import java.io.Serializable;

public abstract class BaseCpgClientEmail implements Serializable {

    private static final long serialVersionUID = 1L;

    java.lang.String id;
    java.lang.String actno;
    java.lang.String actName;
    java.lang.String brno;
    java.lang.String email;
    java.lang.String msgId;
    java.lang.String msgName;
    java.lang.String sndTime;
    java.lang.String st;
    java.lang.String errmsg;
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

    public java.lang.String getActno() {
        return actno;
    }

    public void setActno(java.lang.String actno) {
        this.actno = actno;
    }

    public java.lang.String getActName() {
        return actName;
    }

    public void setActName(java.lang.String actName) {
        this.actName = actName;
    }

    public java.lang.String getBrno() {
        return brno;
    }

    public void setBrno(java.lang.String brno) {
        this.brno = brno;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
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

    public java.lang.String getSndTime() {
        return sndTime;
    }

    public void setSndTime(java.lang.String sndTime) {
        this.sndTime = sndTime;
    }

    public java.lang.String getSt() {
        return st;
    }

    public void setSt(java.lang.String st) {
        this.st = st;
    }

    public java.lang.String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(java.lang.String errmsg) {
        this.errmsg = errmsg;
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
        sb.append("actno = [" + actno + "], ");
        sb.append("actName = [" + actName + "], ");
        sb.append("brno = [" + brno + "], ");
        sb.append("email = [" + email + "], ");
        sb.append("msgId = [" + msgId + "], ");
        sb.append("msgName = [" + msgName + "], ");
        sb.append("sndTime = [" + sndTime + "], ");
        sb.append("st = [" + st + "], ");
        sb.append("errmsg = [" + errmsg + "], ");
        sb.append("rsv1 = [" + rsv1 + "], ");
        sb.append("rsv2 = [" + rsv2 + "], ");
        sb.append("rsv3 = [" + rsv3 + "], ");
        sb.append("rsv4 = [" + rsv4 + "], ");
        sb.append("rsv5 = [" + rsv5 + "], ");
        sb.append("rsv6 = [" + rsv6 + "], ");
        return sb.toString();
    }

}

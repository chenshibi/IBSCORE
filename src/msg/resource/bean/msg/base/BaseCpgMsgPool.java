//package com.huateng.messagePlatform.bean.base;
//
//public class BaseCpgMsgPool {
//
//}
package resource.bean.msg.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the CPG_MSG_POOL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="CPG_MSG_POOL"
 */

public abstract class BaseCpgMsgPool implements Serializable {

    private static final long serialVersionUID = 1L;

    // constructors
    public BaseCpgMsgPool() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCpgMsgPool(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String innerId;
    private java.lang.String brno;
    private java.lang.String msgId;
    private java.lang.String msgSysId;
    private java.lang.String msgLogHead;
    private java.lang.String msgLog;
    private java.lang.String status;
    private java.lang.String createdDate;
    private java.lang.String source;
    private java.lang.String addUserType;
    private java.lang.String addUser;
    private java.lang.String rsv1;
    private java.lang.String rsv2;
    private java.lang.String rsv3;
    private java.lang.String rsv4;
    private java.lang.String rsv5;
    private java.lang.String sendTime;

    public java.lang.String getSendTime() {
        return sendTime;
    }

    public void setSendTime(java.lang.String sendTime) {
        this.sendTime = sendTime;
    }

    private java.lang.String failedReason;

    public java.lang.String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(java.lang.String failedReason) {
        this.failedReason = failedReason;
    }

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="sequence" column="ID"
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setId(java.lang.String id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    // get and set methods <<
    public java.lang.String getInnerId() {
        return innerId;
    }

    public void setInnerId(java.lang.String innerId) {
        this.innerId = innerId;
    }

    public java.lang.String getBrno() {
        return brno;
    }

    public void setBrno(java.lang.String brno) {
        this.brno = brno;
    }

    public java.lang.String getMsgId() {
        return msgId;
    }

    public void setMsgId(java.lang.String msgId) {
        this.msgId = msgId;
    }

    public java.lang.String getMsgSysId() {
        return msgSysId;
    }

    public void setMsgSysId(java.lang.String msgSysId) {
        this.msgSysId = msgSysId;
    }

    public java.lang.String getMsgLogHead() {
        return msgLogHead;
    }

    public void setMsgLogHead(java.lang.String msgLogHead) {
        this.msgLogHead = msgLogHead;
    }

    public java.lang.String getMsgLog() {
        return msgLog;
    }

    public void setMsgLog(java.lang.String msgLog) {
        this.msgLog = msgLog;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.lang.String createdDate) {
        this.createdDate = createdDate;
    }

    public java.lang.String getSource() {
        return source;
    }

    public void setSource(java.lang.String source) {
        this.source = source;
    }

    public java.lang.String getAddUserType() {
        return addUserType;
    }

    public void setAddUserType(java.lang.String addUserType) {
        this.addUserType = addUserType;
    }

    public java.lang.String getAddUser() {
        return addUser;
    }

    public void setAddUser(java.lang.String addUser) {
        this.addUser = addUser;
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
    // get and set methods >>

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.msg.CpgMsgPool))
            return false;
        else {
            resource.bean.msg.CpgMsgPool affenterprise = (resource.bean.msg.CpgMsgPool) obj;
            if (null == this.getId() || null == affenterprise.getId())
                return false;
            else
                return (this.getId().equals(affenterprise.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId())
                return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    public String toString() {
        return super.toString();
    }

}
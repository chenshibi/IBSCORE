package resource.bean.msg.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the CPG_MSG_CTL table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="CPG_MSG_CTL"
 */

public abstract class BaseCpgMsgCtl implements Serializable {

    private static final long serialVersionUID = 1L;

    // constructors
    public BaseCpgMsgCtl() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCpgMsgCtl(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String msgId;
    private java.lang.String sysType;
    private java.lang.String msgName;
    private java.lang.String type;
    private java.lang.String subType;
    private java.lang.String status;
    // private java.lang.String sndCtlFlag;
    // private java.lang.String sndCtlStatus;
    private java.lang.String creator;
    private java.lang.String createdDate;
    private java.lang.String modUser;
    private java.lang.String modDate;
    private java.lang.String checkUser;
    private java.lang.String checkDate;
    private java.lang.String rsv1;
    private java.lang.String rsv2;
    private java.lang.String rsv3;
    private java.lang.String rsv4;
    private java.lang.String rsv5;

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
    public java.lang.String getMsgId() {
        return msgId;
    }

    public void setMsgId(java.lang.String msgId) {
        this.msgId = msgId;
    }

    public java.lang.String getSysType() {
        return sysType;
    }

    public void setSysType(java.lang.String sysType) {
        this.sysType = sysType;
    }

    public java.lang.String getMsgName() {
        return msgName;
    }

    public void setMsgName(java.lang.String msgName) {
        this.msgName = msgName;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getSubType() {
        return subType;
    }

    public void setSubType(java.lang.String subType) {
        this.subType = subType;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    /*
     * public java.lang.String getSndCtlFlag() { return sndCtlFlag; }
     * 
     * public void setSndCtlFlag(java.lang.String sndCtlFlag) { this.sndCtlFlag
     * = sndCtlFlag; }
     * 
     * public java.lang.String getSndCtlStatus() { return sndCtlStatus; }
     * 
     * public void setSndCtlStatus(java.lang.String sndCtlStatus) {
     * this.sndCtlStatus = sndCtlStatus; }
     */

    public java.lang.String getCreator() {
        return creator;
    }

    public void setCreator(java.lang.String creator) {
        this.creator = creator;
    }

    public java.lang.String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(java.lang.String createdDate) {
        this.createdDate = createdDate;
    }

    public java.lang.String getModUser() {
        return modUser;
    }

    public void setModUser(java.lang.String modUser) {
        this.modUser = modUser;
    }

    public java.lang.String getModDate() {
        return modDate;
    }

    public void setModDate(java.lang.String modDate) {
        this.modDate = modDate;
    }

    public java.lang.String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(java.lang.String checkUser) {
        this.checkUser = checkUser;
    }

    public java.lang.String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(java.lang.String checkDate) {
        this.checkDate = checkDate;
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
        if (!(obj instanceof resource.bean.msg.CpgMsgCtl))
            return false;
        else {
            resource.bean.msg.CpgMsgCtl affenterprise = (resource.bean.msg.CpgMsgCtl) obj;
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
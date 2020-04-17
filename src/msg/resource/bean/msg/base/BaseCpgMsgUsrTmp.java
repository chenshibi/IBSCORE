package resource.bean.msg.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the CPG_MSG_USR_TMP table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="CPG_MSG_USR_TMP"
 */

public abstract class BaseCpgMsgUsrTmp implements Serializable {

    private static final long serialVersionUID = 1L;

    // constructors
    public BaseCpgMsgUsrTmp() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCpgMsgUsrTmp(java.lang.String id) {
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
    private java.lang.String optType;
    private java.lang.String userId;
    private java.lang.String sendType;
    private java.lang.String rcvInf;
    private java.lang.String creator;
    private java.lang.String createdDate;
    private java.lang.String checkUser;
    private java.lang.String checkDate;
    private java.lang.String optStatus;
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
    public java.lang.String getInnerId() {
        return innerId;
    }

    public void setInnerId(java.lang.String innerId) {
        this.innerId = innerId;
    }

    public java.lang.String getOptType() {
        return optType;
    }

    public void setOptType(java.lang.String optType) {
        this.optType = optType;
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public java.lang.String getSendType() {
        return sendType;
    }

    public void setSendType(java.lang.String sendType) {
        this.sendType = sendType;
    }

    public java.lang.String getRcvInf() {
        return rcvInf;
    }

    public void setRcvInf(java.lang.String rcvInf) {
        this.rcvInf = rcvInf;
    }

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

    public java.lang.String getOptStatus() {
        return optStatus;
    }

    public void setOptStatus(java.lang.String optStatus) {
        this.optStatus = optStatus;
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
        if (!(obj instanceof resource.bean.msg.CpgMsgUsrTmp))
            return false;
        else {
            resource.bean.msg.CpgMsgUsrTmp affenterprise = (resource.bean.msg.CpgMsgUsrTmp) obj;
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
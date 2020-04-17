//package com.huateng.messagePlatform.bean.base;
//
//public class BaseCpgMsgSndDtl {
//
//}
package resource.bean.msg.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the CPG_MSG_SND_DTL table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="CPG_MSG_SND_DTL"
 */

public abstract class BaseCpgMsgSndDtl implements Serializable {

    private static final long serialVersionUID = 1L;

    // constructors
    public BaseCpgMsgSndDtl() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCpgMsgSndDtl(java.lang.String id) {
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
    private java.lang.String msgLogId;
    private java.lang.String msgId;
    private java.lang.String oppId;
    private java.lang.String sendType;
    private java.lang.String rcvInf;
    private java.lang.String status;
    private java.lang.String sendDate;
    private java.lang.String rsv1;
    private java.lang.String rsv2;
    private java.lang.String rsv3;
    private java.lang.String rsv4;
    private java.lang.String rsv5;
    private java.lang.String failedReason;
    private java.lang.String errorType;
    private java.lang.String content;
    private java.lang.String title;
    private java.lang.String brno;

    public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getBrno() {
		return brno;
	}

	public void setBrno(java.lang.String brno) {
		this.brno = brno;
	}

	public java.lang.String getErrorType() {
		return errorType;
	}

	public void setErrorType(java.lang.String errorType) {
		this.errorType = errorType;
	}

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

    public java.lang.String getMsgLogId() {
        return msgLogId;
    }

    public void setMsgLogId(java.lang.String msgLogId) {
        this.msgLogId = msgLogId;
    }

    public java.lang.String getMsgId() {
        return msgId;
    }

    public void setMsgId(java.lang.String msgId) {
        this.msgId = msgId;
    }

    public java.lang.String getOppId() {
        return oppId;
    }

    public void setOppId(java.lang.String oppId) {
        this.oppId = oppId;
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

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getSendDate() {
        return sendDate;
    }

    public void setSendDate(java.lang.String sendDate) {
        this.sendDate = sendDate;
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
        if (!(obj instanceof resource.bean.msg.CpgMsgSndDtl))
            return false;
        else {
            resource.bean.msg.CpgMsgSndDtl affenterprise = (resource.bean.msg.CpgMsgSndDtl) obj;
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
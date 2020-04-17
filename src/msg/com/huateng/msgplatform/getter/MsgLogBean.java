package com.huateng.msgplatform.getter;

public class MsgLogBean {
    // entry page fields
    // id,msgId,msgName,msgSysId,oppId,userName,msgLogHead,sendDate
    private String id;
    private String msgId;
    private String msgName;
    private String msgSysId;
    private String oppId;
    private String userName;
    private String msgLogHead;
    private String sendDate;

    // detail page fields
    // bId,aId,msgId,msgName,oppId,userName,brno,type,subType,createdDate,msgSysId,source,sendDate,status,msgLogHead,msgLog
    private String bId;
    private String aId;
    // private String msgId;
    // private String msgName;
    // private String oppId;
    // private String userName;
    private String brno;
    private String type;
    private String subType;
    private String createdDate;
    // private String msgSysId;
    private String source;
    // private String sendDate;
    private String status;
    // private String msgLogHead;
    private String msgLog;
    private String rcvInf;
    private String failedReason;

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    public String getRcvInf() {
        return rcvInf;
    }

    public void setRcvInf(String rcvInf) {
        this.rcvInf = rcvInf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getMsgSysId() {
        return msgSysId;
    }

    public void setMsgSysId(String msgSysId) {
        this.msgSysId = msgSysId;
    }

    public String getOppId() {
        return oppId;
    }

    public void setOppId(String oppId) {
        this.oppId = oppId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsgLogHead() {
        return msgLogHead;
    }

    public void setMsgLogHead(String msgLogHead) {
        this.msgLogHead = msgLogHead;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    // detail page fields
    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getBrno() {
        return brno;
    }

    public void setBrno(String brno) {
        this.brno = brno;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsgLog() {
        return msgLog;
    }

    public void setMsgLog(String msgLog) {
        this.msgLog = msgLog;
    }
}

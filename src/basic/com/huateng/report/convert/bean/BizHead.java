package com.huateng.report.convert.bean;

/**
 * @author YiSiliang
 * @date 2018/12/29 18:11
 */
public class BizHead {
    private String startFlag;
    private String version;
    private String sendCode;
    private String recvCode;
    private String genTime;
    private String msgType;
    private String msgId;
    private String rsv;

    public String getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(String startFlag) {
        this.startFlag = startFlag;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getRecvCode() {
        return recvCode;
    }

    public void setRecvCode(String recvCode) {
        this.recvCode = recvCode;
    }

    public String getGenTime() {
        return genTime;
    }

    public void setGenTime(String genTime) {
        this.genTime = genTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getRsv() {
        return rsv;
    }

    public void setRsv(String rsv) {
        this.rsv = rsv;
    }
}

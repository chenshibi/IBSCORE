package com.huateng.report.convert.bean;

/**
 * @author Grassy
 * @date 2019/1/22 17:24
 * @jdk.version 1.8
 * @desc
 */
public class FileBizHead {
    private String fileStartFlag;
    private String fileVersion;
    private String fileQryCode;
    private String fileGenTime;
    private String fileType;
    private String recordQryNum;
    private String fileRsv;

    public String getFileStartFlag() {
        return fileStartFlag;
    }

    public void setFileStartFlag(String fileStartFlag) {
        this.fileStartFlag = fileStartFlag;
    }

    public String getFileVersion() {
        return fileVersion;
    }

    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    public String getFileQryCode() {
        return fileQryCode;
    }

    public void setFileQryCode(String fileQryCode) {
        this.fileQryCode = fileQryCode;
    }

    public String getFileGenTime() {
        return fileGenTime;
    }

    public void setFileGenTime(String fileGenTime) {
        this.fileGenTime = fileGenTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRecordQryNum() {
        return recordQryNum;
    }

    public void setRecordQryNum(String recordQryNum) {
        this.recordQryNum = recordQryNum;
    }

    public String getFileRsv() {
        return fileRsv;
    }

    public void setFileRsv(String fileRsv) {
        this.fileRsv = fileRsv;
    }


}

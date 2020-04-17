package com.huateng.report.databak.bean;

import java.util.Date;

public class RecoverBakFileBean {

    private String filePath;

    private String fileSize;

    private Date lastModifyTime;

    private String exits;

    private String recoverReason;

    public String getExits() {
        return exits;
    }

    public void setExits(String exits) {
        this.exits = exits;
    }

    public String getRecoverReason() {
        return recoverReason;
    }

    public void setRecoverReason(String recoverReason) {
        this.recoverReason = recoverReason;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

}

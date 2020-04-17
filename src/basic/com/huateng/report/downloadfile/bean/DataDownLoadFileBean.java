package com.huateng.report.downloadfile.bean;

public class DataDownLoadFileBean {
    private String id;
    private String displayName;
    private String fileName;
    private String fileExt;

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public DataDownLoadFileBean(String id, String displayName, String fileName) {
        super();
        this.id = id;
        this.displayName = displayName;
        this.fileName = fileName;
    }

    public DataDownLoadFileBean() {
        super();
        // TODO Auto-generated constructor stub
    }

}

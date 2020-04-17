package com.huateng.msgplatform.mail;

import java.util.List;

public class MailInfo {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String title;
    private String content;
    private List<String> addresses;
    // 邮件附件的文件名[上传文件路径]
    private String[] attachFileNames;

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] attachFileNames) {
        this.attachFileNames = attachFileNames;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<String> getCcaddresses() {
        return ccaddresses;
    }

    public void setCcaddresses(List<String> ccaddresses) {
        this.ccaddresses = ccaddresses;
    }

    private List<String> ccaddresses;

}

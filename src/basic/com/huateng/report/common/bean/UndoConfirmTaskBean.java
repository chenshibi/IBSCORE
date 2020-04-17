package com.huateng.report.common.bean;

import java.io.Serializable;

public class UndoConfirmTaskBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7676076471599935972L;

    private String intInsId;

    private String intInsIdName;

    private Long count;

    private String urlLink;

    private String urlColor;

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getUrlColor() {
        return urlColor;
    }

    public void setUrlColor(String urlColor) {
        this.urlColor = urlColor;
    }

    public String getIntInsId() {
        return intInsId;
    }

    public void setIntInsId(String intInsId) {
        this.intInsId = intInsId;
    }

    public String getIntInsIdName() {
        return intInsIdName;
    }

    public void setIntInsIdName(String intInsIdName) {
        this.intInsIdName = intInsIdName;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public UndoConfirmTaskBean(String intInsId, String intInsIdName, Long count) {
        super();
        this.intInsId = intInsId;
        this.intInsIdName = intInsIdName;
        this.count = count;
    }

    public UndoConfirmTaskBean() {
        super();
    }

    public UndoConfirmTaskBean(String intInsId, Long count) {
        this.intInsId = intInsId;
        this.count = count;
    }

}

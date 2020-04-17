package com.huateng.excel.imp;

import java.util.List;
import java.util.Map;

import resource.bean.basic.TableCfg;

public class CheckOnlyOne {
    private TableCfg cf;
    private Map<String, String> attributetoname;
    private List objlist;

    public Map<String, String> getAttributetoname() {
        return attributetoname;
    }

    public void setAttributetoname(Map<String, String> attributetoname) {
        this.attributetoname = attributetoname;
    }

    public TableCfg getCf() {
        return cf;
    }

    public void setCf(TableCfg cf) {
        this.cf = cf;
    }

    public List getObjlist() {
        return objlist;
    }

    public void setObjlist(List objlist) {
        this.objlist = objlist;
    }

}

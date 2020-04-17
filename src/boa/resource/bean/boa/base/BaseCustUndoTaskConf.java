package resource.bean.boa.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the BAOLIS table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 * 
 * @hibernate.class table="Tfms100101"
 */
public abstract class BaseCustUndoTaskConf implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // constructors
    public BaseCustUndoTaskConf() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseCustUndoTaskConf(java.lang.String funcid) {
        // this.setId(funcid);
        initialize();
    }

    /**
     * Constructor for required fields
     */

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    java.lang.String funcid;
    java.lang.String funcname;
    java.lang.String pagepath;
    java.lang.String tablename;
    java.lang.String tabledes;
    java.lang.String sysname;
    java.lang.String type;
    java.lang.String wherecondition;
    java.lang.String status;
    java.lang.String rsv1;
    java.lang.String rsv2;
    java.lang.String rsv3;
    java.lang.String rsv4;
    java.lang.String rsv5;
    java.lang.String rsv6;

    public java.lang.String getBrtype() {
        return brtype;
    }

    public void setBrtype(java.lang.String brtype) {
        this.brtype = brtype;
    }

    java.lang.String brtype;

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public java.lang.String getFuncid() {
        return funcid;
    }

    public void setFuncid(java.lang.String funcid) {
        this.funcid = funcid;
    }

    public java.lang.String getFuncname() {
        return funcname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((funcid == null) ? 0 : funcid.hashCode());
        result = prime * result + hashCode;
        result = prime * result + ((pagepath == null) ? 0 : pagepath.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseCustUndoTaskConf other = (BaseCustUndoTaskConf) obj;
        if (funcid == null) {
            if (other.funcid != null)
                return false;
        } else if (!funcid.equals(other.funcid))
            return false;
        if (hashCode != other.hashCode)
            return false;
        if (pagepath == null) {
            if (other.pagepath != null)
                return false;
        } else if (!pagepath.equals(other.pagepath))
            return false;
        return true;
    }

    public void setFuncname(java.lang.String funcname) {
        this.funcname = funcname;
    }

    public java.lang.String getPagepath() {
        return pagepath;
    }

    public void setPagepath(java.lang.String pagepath) {
        this.pagepath = pagepath;
    }

    public java.lang.String getTablename() {
        return tablename;
    }

    public void setTablename(java.lang.String tablename) {
        this.tablename = tablename;
    }

    public java.lang.String getTabledes() {
        return tabledes;
    }

    public void setTabledes(java.lang.String tabledes) {
        this.tabledes = tabledes;
    }

    public java.lang.String getSysname() {
        return sysname;
    }

    public void setSysname(java.lang.String sysname) {
        this.sysname = sysname;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getWherecondition() {
        return wherecondition;
    }

    public void setWherecondition(java.lang.String wherecondition) {
        this.wherecondition = wherecondition;
    }

    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
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

    public java.lang.String getRsv6() {
        return rsv6;
    }

    public void setRsv6(java.lang.String rsv6) {
        this.rsv6 = rsv6;
    }

}

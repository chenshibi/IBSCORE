package resource.bean.basic.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the SYS_PARAMS table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="SYS_PARAMS"
 */

public abstract class BaseSysParams implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3505002349392034465L;
    public static String REF = "SysParams";
    public static String PROP_PARAM_NAME = "paramName";
    public static String PROP_MEMO = "memo";
    public static String PROP_ID = "id";
    public static String PROP_PARAM_VAL = "paramVal";

    public static String PROP_CRT_DT = "crtDt";
    public static String PROP_LAST_UPD_TMS = "lastUpdTms";
    public static String PROP_ST = "st";
    public static String PROP_LOCK = "lock";
    public static String PROP_LAST_UPD_OPER = "lastUpdOper";
    public static String PROP_DEL = "del";
    public static String PROP_SYS_NAME = "sys_name";

    // constructors
    public BaseSysParams() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseSysParams(resource.bean.basic.SysParamsPK id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private resource.bean.basic.SysParamsPK id;

    // fields
    private java.lang.String paramVal;
    private java.lang.String paramName;
    private java.lang.String memo;
    private java.lang.String crtDt;
    private java.lang.String lastUpdTms;
    private java.lang.String lock;
    private java.lang.String st;
    private java.lang.String lastUpdOper;
    private java.lang.String del;
    private java.lang.String sys_name;

    public java.lang.String getCrtDt() {
        return crtDt;
    }

    public void setCrtDt(java.lang.String crtDt) {
        this.crtDt = crtDt;
    }

    public java.lang.String getLastUpdTms() {
        return lastUpdTms;
    }

    public void setLastUpdTms(java.lang.String lastUpdTms) {
        this.lastUpdTms = lastUpdTms;
    }

    public java.lang.String getLock() {
        return lock;
    }

    public void setLock(java.lang.String lock) {
        this.lock = lock;
    }

    public java.lang.String getSt() {
        return st;
    }

    public void setSt(java.lang.String st) {
        this.st = st;
    }

    public java.lang.String getLastUpdOper() {
        return lastUpdOper;
    }

    public void setLastUpdOper(java.lang.String lastUpdOper) {
        this.lastUpdOper = lastUpdOper;
    }

    public java.lang.String getDel() {
        return del;
    }

    public void setDel(java.lang.String del) {
        this.del = del;
    }

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id
     */
    public resource.bean.basic.SysParamsPK getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setId(resource.bean.basic.SysParamsPK id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: PARAM_VAL
     */
    public java.lang.String getParamVal() {
        return paramVal;
    }

    /**
     * Set the value related to the column: PARAM_VAL
     * 
     * @param paramVal
     *            the PARAM_VAL value
     */
    public void setParamVal(java.lang.String paramVal) {
        this.paramVal = paramVal;
    }

    /**
     * Return the value associated with the column: PARAM_NAME
     */
    public java.lang.String getParamName() {
        return paramName;
    }

    /**
     * Set the value related to the column: PARAM_NAME
     * 
     * @param paramName
     *            the PARAM_NAME value
     */
    public void setParamName(java.lang.String paramName) {
        this.paramName = paramName;
    }

    /**
     * Return the value associated with the column: MEMO
     */
    public java.lang.String getMemo() {
        return memo;
    }

    /**
     * Set the value related to the column: MEMO
     * 
     * @param memo
     *            the MEMO value
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.basic.SysParams))
            return false;
        else {
            resource.bean.basic.SysParams sysParams = (resource.bean.basic.SysParams) obj;
            if (null == this.getId() || null == sysParams.getId())
                return false;
            else
                return (this.getId().equals(sysParams.getId()));
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

    public java.lang.String getSys_name() {
        return sys_name;
    }

    public void setSys_name(java.lang.String sys_name) {
        this.sys_name = sys_name;
    }

}
package resource.bean.basic.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the BI_QUARTZ_JOB_LOG table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="BI_QUARTZ_JOB_LOG"
 */

public abstract class BaseBiQuartzJobLog implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1416926212612602937L;
    public static String REF = "BiQuartzJobLog";
    public static String PROP_QUARTZ_RESULT = "quartzResult";
    public static String PROP_QUARTZ_ID = "quartzId";
    public static String PROP_ID = "id";
    public static String PROP_EXEC_TM = "execTm";
    public static String PROP_REMARK = "remark";
    public static String PROP_END_TM = "endTm";
    public static String PROP_QUARTZ_NAME = "quartzName";

    // constructors
    public BaseBiQuartzJobLog() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseBiQuartzJobLog(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String quartzId;
    private java.lang.String execTm;
    private java.lang.String endTm;
    private java.lang.String quartzName;
    private java.lang.String quartzResult;
    private java.lang.String remark;

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id column="LOG_ID"
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setId(java.lang.String id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: QUARTZ_ID
     */
    public java.lang.String getQuartzId() {
        return quartzId;
    }

    /**
     * Set the value related to the column: QUARTZ_ID
     * 
     * @param quartzId
     *            the QUARTZ_ID value
     */
    public void setQuartzId(java.lang.String quartzId) {
        this.quartzId = quartzId;
    }

    /**
     * Return the value associated with the column: EXEC_TM
     */
    public java.lang.String getExecTm() {
        return execTm;
    }

    /**
     * Set the value related to the column: EXEC_TM
     * 
     * @param execTm
     *            the EXEC_TM value
     */
    public void setExecTm(java.lang.String execTm) {
        this.execTm = execTm;
    }

    /**
     * Return the value associated with the column: END_TM
     */
    public java.lang.String getEndTm() {
        return endTm;
    }

    /**
     * Set the value related to the column: END_TM
     * 
     * @param endTm
     *            the END_TM value
     */
    public void setEndTm(java.lang.String endTm) {
        this.endTm = endTm;
    }

    /**
     * Return the value associated with the column: QUARTZ_NAME
     */
    public java.lang.String getQuartzName() {
        return quartzName;
    }

    /**
     * Set the value related to the column: QUARTZ_NAME
     * 
     * @param quartzName
     *            the QUARTZ_NAME value
     */
    public void setQuartzName(java.lang.String quartzName) {
        this.quartzName = quartzName;
    }

    /**
     * Return the value associated with the column: QUARTZ_RESULT
     */
    public java.lang.String getQuartzResult() {
        return quartzResult;
    }

    /**
     * Set the value related to the column: QUARTZ_RESULT
     * 
     * @param quartzResult
     *            the QUARTZ_RESULT value
     */
    public void setQuartzResult(java.lang.String quartzResult) {
        this.quartzResult = quartzResult;
    }

    /**
     * Return the value associated with the column: REMARK
     */
    public java.lang.String getRemark() {
        return remark;
    }

    /**
     * Set the value related to the column: REMARK
     * 
     * @param remark
     *            the REMARK value
     */
    public void setRemark(java.lang.String remark) {
        this.remark = remark;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.basic.BiQuartzJobLog))
            return false;
        else {
            resource.bean.basic.BiQuartzJobLog biQuartzJobLog = (resource.bean.basic.BiQuartzJobLog) obj;
            if (null == this.getId() || null == biQuartzJobLog.getId())
                return false;
            else
                return (this.getId().equals(biQuartzJobLog.getId()));
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

}
package resource.bean.basic.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the REPORT_JOB_CONFIG table.
 * Do not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="REPORT_JOB_CONFIG"
 */

public abstract class BaseReportJobConfig implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1738194410225932363L;
    public static String REF = "ReportJobConfig";
    public static String PROP_JOB_REMARK = "jobRemark";
    public static String PROP_JOB_CLASS_NAME = "jobClassName";
    public static String PROP_JOB_LST_TM = "jobLstTm";
    public static String PROP_JOB_TIME = "jobTime";
    public static String PROP_JOB_NAME = "jobName";
    public static String PROP_JOB_LST_TRL = "jobLstTrl";
    public static String PROP_ID = "id";
    public static String PROP_JOB_STAUTS = "jobStauts";
    public static String PROP_JUST_WORKDATE_RUN = "justWorkdateRun";
    public static String PROP_SYS_NAME = "sysName";

    // constructors
    public BaseReportJobConfig() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseReportJobConfig(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String jobName;
    private java.lang.String jobClassName;
    private java.lang.String jobTime;
    private java.lang.String jobStauts;
    private java.lang.String justWorkdateRun;
    private java.lang.String jobRemark;
    private java.lang.String jobLstTm;
    private java.lang.String jobLstTrl;
    private java.lang.String sysName;

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id column="JOB_ID"
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
     * Return the value associated with the column: JOB_NAME
     */
    public java.lang.String getJobName() {
        return jobName;
    }

    /**
     * Set the value related to the column: JOB_NAME
     * 
     * @param jobName
     *            the JOB_NAME value
     */
    public void setJobName(java.lang.String jobName) {
        this.jobName = jobName;
    }

    /**
     * Return the value associated with the column: JOB_CLASS_NAME
     */
    public java.lang.String getJobClassName() {
        return jobClassName;
    }

    /**
     * Set the value related to the column: JOB_CLASS_NAME
     * 
     * @param jobClassName
     *            the JOB_CLASS_NAME value
     */
    public void setJobClassName(java.lang.String jobClassName) {
        this.jobClassName = jobClassName;
    }

    /**
     * Return the value associated with the column: JOB_TIME
     */
    public java.lang.String getJobTime() {
        return jobTime;
    }

    /**
     * Set the value related to the column: JOB_TIME
     * 
     * @param jobTime
     *            the JOB_TIME value
     */
    public void setJobTime(java.lang.String jobTime) {
        this.jobTime = jobTime;
    }

    /**
     * Return the value associated with the column: JOB_STAUTS
     */
    public java.lang.String getJobStauts() {
        return jobStauts;
    }

    /**
     * Set the value related to the column: JOB_STAUTS
     * 
     * @param jobStauts
     *            the JOB_STAUTS value
     */
    public void setJobStauts(java.lang.String jobStauts) {
        this.jobStauts = jobStauts;
    }

    /**
     * Return the value associated with the column: JUST_WORKDATE_RUN
     */
    public java.lang.String getJustWorkdateRun() {
        return justWorkdateRun;
    }

    /**
     * Set the value related to the column: JUST_WORKDATE_RUN
     * 
     * @param justWorkdateRun
     *            the JUST_WORKDATE_RUN value
     */
    public void setJustWorkdateRun(java.lang.String justWorkdateRun) {
        this.justWorkdateRun = justWorkdateRun;
    }

    /**
     * Return the value associated with the column: JOB_REMARK
     */
    public java.lang.String getJobRemark() {
        return jobRemark;
    }

    /**
     * Set the value related to the column: JOB_REMARK
     * 
     * @param jobRemark
     *            the JOB_REMARK value
     */
    public void setJobRemark(java.lang.String jobRemark) {
        this.jobRemark = jobRemark;
    }

    /**
     * Return the value associated with the column: JOB_LST_TM
     */
    public java.lang.String getJobLstTm() {
        return jobLstTm;
    }

    /**
     * Set the value related to the column: JOB_LST_TM
     * 
     * @param jobLstTm
     *            the JOB_LST_TM value
     */
    public void setJobLstTm(java.lang.String jobLstTm) {
        this.jobLstTm = jobLstTm;
    }

    /**
     * Return the value associated with the column: JOB_LST_TRL
     */
    public java.lang.String getJobLstTrl() {
        return jobLstTrl;
    }

    /**
     * Set the value related to the column: JOB_LST_TRL
     * 
     * @param jobLstTrl
     *            the JOB_LST_TRL value
     */
    public void setJobLstTrl(java.lang.String jobLstTrl) {
        this.jobLstTrl = jobLstTrl;
    }

    public java.lang.String getSysName() {
        return sysName;
    }

    public void setSysName(java.lang.String sysName) {
        this.sysName = sysName;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.basic.ReportJobConfig))
            return false;
        else {
            resource.bean.basic.ReportJobConfig reportJobConfig = (resource.bean.basic.ReportJobConfig) obj;
            if (null == this.getId() || null == reportJobConfig.getId())
                return false;
            else
                return (this.getId().equals(reportJobConfig.getId()));
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
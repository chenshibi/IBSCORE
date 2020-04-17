package resource.bean.basic.base;

import java.io.Serializable;

/**
 * This is an object that contains data related to the SYS_NOTICE table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="SYS_NOTICE"
 */

public abstract class BaseSysNotice implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5726270385924268419L;
    public static String REF = "SysNotice";
    public static String PROP_CRT_TLR = "crtTlr";
    public static String PROP_NOTICE_CONTENT = "noticeContent";
    public static String PROP_LST_UPD_TLR = "lstUpdTlr";
    public static String PROP_END_DATE = "endDate";
    public static String PROP_START_DATE = "startDate";
    public static String PROP_NOTICE_TITLE = "noticeTitle";
    public static String PROP_ID = "id";
    public static String PROP_ST = "st";
    public static String PROP_BR_NO = "brNo";
    public static String PROP_CRT_TM = "crtTm";
    public static String PROP_LST_UPD_TM = "lstUpdTm";

    // constructors
    public BaseSysNotice() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseSysNotice(java.lang.String id) {
        this.setId(id);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;

    // fields
    private java.lang.String noticeTitle;
    private java.lang.String noticeContent;
    private java.lang.String crtTm;
    private java.lang.String crtTlr;
    private java.lang.String startDate;
    private java.lang.String endDate;
    private java.lang.String brNo;
    private java.lang.String lstUpdTm;
    private java.lang.String lstUpdTlr;
    private java.lang.String st;

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id column="ID"
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
     * Return the value associated with the column: NOTICE_TITLE
     */
    public java.lang.String getNoticeTitle() {
        return noticeTitle;
    }

    /**
     * Set the value related to the column: NOTICE_TITLE
     * 
     * @param noticeTitle
     *            the NOTICE_TITLE value
     */
    public void setNoticeTitle(java.lang.String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    /**
     * Return the value associated with the column: NOTICE_CONTENT
     */
    public java.lang.String getNoticeContent() {
        return noticeContent;
    }

    /**
     * Set the value related to the column: NOTICE_CONTENT
     * 
     * @param noticeContent
     *            the NOTICE_CONTENT value
     */
    public void setNoticeContent(java.lang.String noticeContent) {
        this.noticeContent = noticeContent;
    }

    /**
     * Return the value associated with the column: CRT_TM
     */
    public java.lang.String getCrtTm() {
        return crtTm;
    }

    /**
     * Set the value related to the column: CRT_TM
     * 
     * @param crtTm
     *            the CRT_TM value
     */
    public void setCrtTm(java.lang.String crtTm) {
        this.crtTm = crtTm;
    }

    /**
     * Return the value associated with the column: CRT_TLR
     */
    public java.lang.String getCrtTlr() {
        return crtTlr;
    }

    /**
     * Set the value related to the column: CRT_TLR
     * 
     * @param crtTlr
     *            the CRT_TLR value
     */
    public void setCrtTlr(java.lang.String crtTlr) {
        this.crtTlr = crtTlr;
    }

    /**
     * Return the value associated with the column: START_DATE
     */
    public java.lang.String getStartDate() {
        return startDate;
    }

    /**
     * Set the value related to the column: START_DATE
     * 
     * @param startDate
     *            the START_DATE value
     */
    public void setStartDate(java.lang.String startDate) {
        this.startDate = startDate;
    }

    /**
     * Return the value associated with the column: END_DATE
     */
    public java.lang.String getEndDate() {
        return endDate;
    }

    /**
     * Set the value related to the column: END_DATE
     * 
     * @param endDate
     *            the END_DATE value
     */
    public void setEndDate(java.lang.String endDate) {
        this.endDate = endDate;
    }

    /**
     * Return the value associated with the column: BR_NO
     */
    public java.lang.String getBrNo() {
        return brNo;
    }

    /**
     * Set the value related to the column: BR_NO
     * 
     * @param brNo
     *            the BR_NO value
     */
    public void setBrNo(java.lang.String brNo) {
        this.brNo = brNo;
    }

    /**
     * Return the value associated with the column: LST_UPD_TM
     */
    public java.lang.String getLstUpdTm() {
        return lstUpdTm;
    }

    /**
     * Set the value related to the column: LST_UPD_TM
     * 
     * @param lstUpdTm
     *            the LST_UPD_TM value
     */
    public void setLstUpdTm(java.lang.String lstUpdTm) {
        this.lstUpdTm = lstUpdTm;
    }

    /**
     * Return the value associated with the column: LST_UPD_TLR
     */
    public java.lang.String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * Set the value related to the column: LST_UPD_TLR
     * 
     * @param lstUpdTlr
     *            the LST_UPD_TLR value
     */
    public void setLstUpdTlr(java.lang.String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr;
    }

    /**
     * Return the value associated with the column: ST
     */
    public java.lang.String getSt() {
        return st;
    }

    /**
     * Set the value related to the column: ST
     * 
     * @param st
     *            the ST value
     */
    public void setSt(java.lang.String st) {
        this.st = st;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof resource.bean.basic.SysNotice))
            return false;
        else {
            resource.bean.basic.SysNotice sysNotice = (resource.bean.basic.SysNotice) obj;
            if (null == this.getId() || null == sysNotice.getId())
                return false;
            else
                return (this.getId().equals(sysNotice.getId()));
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
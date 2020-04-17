package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="IND_INFO"
 */

public abstract class BaseIndEnquiry implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndEnquiry";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_ENQ_DATE="enqDate";
    public static String PROP_ENQUIRER="enquirer";
    public static String PROP_REASON="reason";
    public static String PROP_NO="no";
    public BaseIndEnquiry() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.util.Date enqDate;
    private java.lang.String enquirer;
    private java.lang.String reason;
    private java.lang.Integer no;
	public static String getREF() {
		return REF;
	}
	public static void setREF(String rEF) {
		REF = rEF;
	}
	public static String getPROP_ID() {
		return PROP_ID;
	}
	public static void setPROP_ID(String pROP_ID) {
		PROP_ID = pROP_ID;
	}
	public static String getPROP_RPT_ID() {
		return PROP_RPT_ID;
	}
	public static void setPROP_RPT_ID(String pROP_RPT_ID) {
		PROP_RPT_ID = pROP_RPT_ID;
	}
	public static String getPROP_ENQ_DATE() {
		return PROP_ENQ_DATE;
	}
	public static void setPROP_ENQ_DATE(String pROP_ENQ_DATE) {
		PROP_ENQ_DATE = pROP_ENQ_DATE;
	}
	public static String getPROP_ENQUIRER() {
		return PROP_ENQUIRER;
	}
	public static void setPROP_ENQUIRER(String pROP_ENQUIRER) {
		PROP_ENQUIRER = pROP_ENQUIRER;
	}
	public static String getPROP_REASON() {
		return PROP_REASON;
	}
	public static void setPROP_REASON(String pROP_REASON) {
		PROP_REASON = pROP_REASON;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getRptId() {
		return rptId;
	}
	public void setRptId(java.lang.String rptId) {
		this.rptId = rptId;
	}
	public java.util.Date getEnqDate() {
		return enqDate;
	}
	public void setEnqDate(java.util.Date enqDate) {
		this.enqDate = enqDate;
	}
	public java.lang.String getEnquirer() {
		return enquirer;
	}
	public void setEnquirer(java.lang.String enquirer) {
		this.enquirer = enquirer;
	}
	public java.lang.String getReason() {
		return reason;
	}
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enqDate == null) ? 0 : enqDate.hashCode());
		result = prime * result
				+ ((enquirer == null) ? 0 : enquirer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
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
		BaseIndEnquiry other = (BaseIndEnquiry) obj;
		if (enqDate == null) {
			if (other.enqDate != null)
				return false;
		} else if (!enqDate.equals(other.enqDate))
			return false;
		if (enquirer == null) {
			if (other.enquirer != null)
				return false;
		} else if (!enquirer.equals(other.enquirer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		return true;
	}
	public BaseIndEnquiry(Integer id, String rptId, Date enqDate,
			String enquirer, String reason, Integer no) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.enqDate = enqDate;
		this.enquirer = enquirer;
		this.reason = reason;
		this.no = no;
	}

    
	
    
    
  
}
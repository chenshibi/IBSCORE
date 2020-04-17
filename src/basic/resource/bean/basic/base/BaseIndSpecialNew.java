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

public abstract class BaseIndSpecialNew implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndSpecialNew";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_ACC_TYPE="accType";
    public static String PROP_TYPE="type";
    public static String PROP_DATE="date";
    public static String PROP_CHANGE_MONTH="changeMonth";
    public static String PROP_AMOUNT="amount";
    public static String PROP_DETAILS="details";
    public static String PROP_GET_DATE="getDate";

    public BaseIndSpecialNew() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String accType;
    private java.lang.String type;
    private java.util.Date date;
    private java.lang.String changeMonth;
    private java.lang.Float amount;
    private java.lang.String details;
    private java.util.Date getDate;
    
    private java.lang.String loanOrgDesc;
    private java.lang.String orgdate;
    private java.lang.String inDeclare;
    private java.lang.String declareDate;
    private java.lang.String objectTag;
    private java.lang.String tagDate;
    
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
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_ACC_TYPE() {
		return PROP_ACC_TYPE;
	}
	public static void setPROP_ACC_TYPE(String pROP_ACC_TYPE) {
		PROP_ACC_TYPE = pROP_ACC_TYPE;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_DATE() {
		return PROP_DATE;
	}
	public static void setPROP_DATE(String pROP_DATE) {
		PROP_DATE = pROP_DATE;
	}
	public static String getPROP_CHANGE_MONTH() {
		return PROP_CHANGE_MONTH;
	}
	public static void setPROP_CHANGE_MONTH(String pROP_CHANGE_MONTH) {
		PROP_CHANGE_MONTH = pROP_CHANGE_MONTH;
	}
	public static String getPROP_AMOUNT() {
		return PROP_AMOUNT;
	}
	public static void setPROP_AMOUNT(String pROP_AMOUNT) {
		PROP_AMOUNT = pROP_AMOUNT;
	}
	public static String getPROP_DETAILS() {
		return PROP_DETAILS;
	}
	public static void setPROP_DETAILS(String pROP_DETAILS) {
		PROP_DETAILS = pROP_DETAILS;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
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
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getAccType() {
		return accType;
	}
	public void setAccType(java.lang.String accType) {
		this.accType = accType;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public java.lang.String getChangeMonth() {
		return changeMonth;
	}
	public void setChangeMonth(java.lang.String changeMonth) {
		this.changeMonth = changeMonth;
	}
	public java.lang.Float getAmount() {
		return amount;
	}
	public void setAmount(java.lang.Float amount) {
		this.amount = amount;
	}
	public java.lang.String getDetails() {
		return details;
	}
	public void setDetails(java.lang.String details) {
		this.details = details;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accType == null) ? 0 : accType.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((changeMonth == null) ? 0 : changeMonth.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BaseIndSpecialNew other = (BaseIndSpecialNew) obj;
		if (accType == null) {
			if (other.accType != null)
				return false;
		} else if (!accType.equals(other.accType))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (changeMonth == null) {
			if (other.changeMonth != null)
				return false;
		} else if (!changeMonth.equals(other.changeMonth))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (getDate == null) {
			if (other.getDate != null)
				return false;
		} else if (!getDate.equals(other.getDate))
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
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public BaseIndSpecialNew(Integer id, String rptId, Integer no,
			String accType, String type, Date date, String changeMonth,
			Float amount, String details, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.accType = accType;
		this.type = type;
		this.date = date;
		this.changeMonth = changeMonth;
		this.amount = amount;
		this.details = details;
		this.getDate = getDate;
	}
	public java.lang.String getLoanOrgDesc() {
		return loanOrgDesc;
	}
	public void setLoanOrgDesc(java.lang.String loanOrgDesc) {
		this.loanOrgDesc = loanOrgDesc;
	}
	public java.lang.String getOrgdate() {
		return orgdate;
	}
	public void setOrgdate(java.lang.String orgdate) {
		this.orgdate = orgdate;
	}
	public java.lang.String getInDeclare() {
		return inDeclare;
	}
	public void setInDeclare(java.lang.String inDeclare) {
		this.inDeclare = inDeclare;
	}
	public java.lang.String getDeclareDate() {
		return declareDate;
	}
	public void setDeclareDate(java.lang.String declareDate) {
		this.declareDate = declareDate;
	}
	public java.lang.String getObjectTag() {
		return objectTag;
	}
	public void setObjectTag(java.lang.String objectTag) {
		this.objectTag = objectTag;
	}
	public java.lang.String getTagDate() {
		return tagDate;
	}
	public void setTagDate(java.lang.String tagDate) {
		this.tagDate = tagDate;
	}

    
	
    
    
  
}
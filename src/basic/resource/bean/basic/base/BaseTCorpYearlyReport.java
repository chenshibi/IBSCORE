package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_yearly_report"
 */

public abstract class BaseTCorpYearlyReport implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 887494355297202088L;
	public static String REF = "TCorpYearlyReport";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_NAME="rptKind";
    public static String PROP_ADDRESS="rptSummaryType";
    public static String PROP_REG_ORGAN_TYPE="rptType";
    public static String PROP_LOANCARD_ID="rptYear";
	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String rptKind;
    private java.lang.String rptSummaryType;
    private java.lang.String rptType;
    private java.lang.String rptYear;
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
	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}
	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}
	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}
	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}
	public static String getPROP_NAME() {
		return PROP_NAME;
	}
	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}
	public static String getPROP_ADDRESS() {
		return PROP_ADDRESS;
	}
	public static void setPROP_ADDRESS(String pROP_ADDRESS) {
		PROP_ADDRESS = pROP_ADDRESS;
	}
	public static String getPROP_REG_ORGAN_TYPE() {
		return PROP_REG_ORGAN_TYPE;
	}
	public static void setPROP_REG_ORGAN_TYPE(String pROP_REG_ORGAN_TYPE) {
		PROP_REG_ORGAN_TYPE = pROP_REG_ORGAN_TYPE;
	}
	public static String getPROP_LOANCARD_ID() {
		return PROP_LOANCARD_ID;
	}
	public static void setPROP_LOANCARD_ID(String pROP_LOANCARD_ID) {
		PROP_LOANCARD_ID = pROP_LOANCARD_ID;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getRptKey() {
		return rptKey;
	}
	public void setRptKey(java.lang.String rptKey) {
		this.rptKey = rptKey;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getRptKind() {
		return rptKind;
	}
	public void setRptKind(java.lang.String rptKind) {
		this.rptKind = rptKind;
	}
	public java.lang.String getRptSummaryType() {
		return rptSummaryType;
	}
	public void setRptSummaryType(java.lang.String rptSummaryType) {
		this.rptSummaryType = rptSummaryType;
	}
	public java.lang.String getRptType() {
		return rptType;
	}
	public void setRptType(java.lang.String rptType) {
		this.rptType = rptType;
	}
	public java.lang.String getRptYear() {
		return rptYear;
	}
	public void setRptYear(java.lang.String rptYear) {
		this.rptYear = rptYear;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((rptKind == null) ? 0 : rptKind.hashCode());
		result = prime * result
				+ ((rptSummaryType == null) ? 0 : rptSummaryType.hashCode());
		result = prime * result + ((rptType == null) ? 0 : rptType.hashCode());
		result = prime * result + ((rptYear == null) ? 0 : rptYear.hashCode());
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
		BaseTCorpYearlyReport other = (BaseTCorpYearlyReport) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (rptKind == null) {
			if (other.rptKind != null)
				return false;
		} else if (!rptKind.equals(other.rptKind))
			return false;
		if (rptSummaryType == null) {
			if (other.rptSummaryType != null)
				return false;
		} else if (!rptSummaryType.equals(other.rptSummaryType))
			return false;
		if (rptType == null) {
			if (other.rptType != null)
				return false;
		} else if (!rptType.equals(other.rptType))
			return false;
		if (rptYear == null) {
			if (other.rptYear != null)
				return false;
		} else if (!rptYear.equals(other.rptYear))
			return false;
		return true;
	}
	public BaseTCorpYearlyReport(int hashCode, Integer id, String rptKey,
			Date createTime, String rptKind, String rptSummaryType,
			String rptType, String rptYear) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.rptKind = rptKind;
		this.rptSummaryType = rptSummaryType;
		this.rptType = rptType;
		this.rptYear = rptYear;
	}
	@Override
	public String toString() {
		return "BaseTCorpYearlyReport [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", createTime=" + createTime
				+ ", rptKind=" + rptKind + ", rptSummaryType=" + rptSummaryType
				+ ", rptType=" + rptType + ", rptYear=" + rptYear + "]";
	}
	public BaseTCorpYearlyReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    




    
	
    
    
	
    
    
}
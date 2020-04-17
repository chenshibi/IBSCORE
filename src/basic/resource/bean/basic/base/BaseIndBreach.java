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

public abstract class BaseIndBreach implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndBreach";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_BAD_DEBT_COUNT="badDebtCount";
    public static String PROP_BAD_DEBT_AMOUNT="badDebtAmount";
    public static String PROP_DISPOSAL_COUNT="disposalCount";
    public static String PROP_DISPOSAL_AMOUNT="disposalAmount";
    public static String PROP_ENSURE_PAY_COUNT="ensurePayCount";
    public static String PROP_ENSURE_PAY_AMOUNT="ensurePayAmount";
    public static String PROP_GET_DATE="getDate";
    public BaseIndBreach() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer badDebtCount;
    private java.lang.Float badDebtAmount;
    private java.lang.Integer disposalCount;
    private java.lang.Float disposalAmount;
    private java.lang.Integer ensurePayCount;
    private java.lang.Float ensurePayAmount;
    private java.util.Date getDate;
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
	public static String getPROP_BAD_DEBT_COUNT() {
		return PROP_BAD_DEBT_COUNT;
	}
	public static void setPROP_BAD_DEBT_COUNT(String pROP_BAD_DEBT_COUNT) {
		PROP_BAD_DEBT_COUNT = pROP_BAD_DEBT_COUNT;
	}
	public static String getPROP_BAD_DEBT_AMOUNT() {
		return PROP_BAD_DEBT_AMOUNT;
	}
	public static void setPROP_BAD_DEBT_AMOUNT(String pROP_BAD_DEBT_AMOUNT) {
		PROP_BAD_DEBT_AMOUNT = pROP_BAD_DEBT_AMOUNT;
	}
	public static String getPROP_DISPOSAL_COUNT() {
		return PROP_DISPOSAL_COUNT;
	}
	public static void setPROP_DISPOSAL_COUNT(String pROP_DISPOSAL_COUNT) {
		PROP_DISPOSAL_COUNT = pROP_DISPOSAL_COUNT;
	}
	public static String getPROP_DISPOSAL_AMOUNT() {
		return PROP_DISPOSAL_AMOUNT;
	}
	public static void setPROP_DISPOSAL_AMOUNT(String pROP_DISPOSAL_AMOUNT) {
		PROP_DISPOSAL_AMOUNT = pROP_DISPOSAL_AMOUNT;
	}
	public static String getPROP_ENSURE_PAY_COUNT() {
		return PROP_ENSURE_PAY_COUNT;
	}
	public static void setPROP_ENSURE_PAY_COUNT(String pROP_ENSURE_PAY_COUNT) {
		PROP_ENSURE_PAY_COUNT = pROP_ENSURE_PAY_COUNT;
	}
	public static String getPROP_ENSURE_PAY_AMOUNT() {
		return PROP_ENSURE_PAY_AMOUNT;
	}
	public static void setPROP_ENSURE_PAY_AMOUNT(String pROP_ENSURE_PAY_AMOUNT) {
		PROP_ENSURE_PAY_AMOUNT = pROP_ENSURE_PAY_AMOUNT;
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
	public java.lang.Integer getBadDebtCount() {
		return badDebtCount;
	}
	public void setBadDebtCount(java.lang.Integer badDebtCount) {
		this.badDebtCount = badDebtCount;
	}
	public java.lang.Float getBadDebtAmount() {
		return badDebtAmount;
	}
	public void setBadDebtAmount(java.lang.Float badDebtAmount) {
		this.badDebtAmount = badDebtAmount;
	}
	public Integer getDisposalCount() {
		return disposalCount;
	}
	public void setDisposalCount(Integer disposalCount) {
		this.disposalCount = disposalCount;
	}
	public java.lang.Float getDisposalAmount() {
		return disposalAmount;
	}
	public void setDisposalAmount(java.lang.Float disposalAmount) {
		this.disposalAmount = disposalAmount;
	}
	public java.lang.Integer getEnsurePayCount() {
		return ensurePayCount;
	}
	public void setEnsurePayCount(java.lang.Integer ensurePayCount) {
		this.ensurePayCount = ensurePayCount;
	}
	public java.lang.Float getEnsurePayAmount() {
		return ensurePayAmount;
	}
	public void setEnsurePayAmount(java.lang.Float ensurePayAmount) {
		this.ensurePayAmount = ensurePayAmount;
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
		result = prime * result
				+ ((badDebtAmount == null) ? 0 : badDebtAmount.hashCode());
		result = prime * result
				+ ((badDebtCount == null) ? 0 : badDebtCount.hashCode());
		result = prime * result
				+ ((disposalAmount == null) ? 0 : disposalAmount.hashCode());
		result = prime * result
				+ ((disposalCount == null) ? 0 : disposalCount.hashCode());
		result = prime * result
				+ ((ensurePayAmount == null) ? 0 : ensurePayAmount.hashCode());
		result = prime * result
				+ ((ensurePayCount == null) ? 0 : ensurePayCount.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BaseIndBreach other = (BaseIndBreach) obj;
		if (badDebtAmount == null) {
			if (other.badDebtAmount != null)
				return false;
		} else if (!badDebtAmount.equals(other.badDebtAmount))
			return false;
		if (badDebtCount == null) {
			if (other.badDebtCount != null)
				return false;
		} else if (!badDebtCount.equals(other.badDebtCount))
			return false;
		if (disposalAmount == null) {
			if (other.disposalAmount != null)
				return false;
		} else if (!disposalAmount.equals(other.disposalAmount))
			return false;
		if (disposalCount == null) {
			if (other.disposalCount != null)
				return false;
		} else if (!disposalCount.equals(other.disposalCount))
			return false;
		if (ensurePayAmount == null) {
			if (other.ensurePayAmount != null)
				return false;
		} else if (!ensurePayAmount.equals(other.ensurePayAmount))
			return false;
		if (ensurePayCount == null) {
			if (other.ensurePayCount != null)
				return false;
		} else if (!ensurePayCount.equals(other.ensurePayCount))
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
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		return true;
	}
	public BaseIndBreach(Integer id, String rptId, Integer badDebtCount,
			Float badDebtAmount, Integer disposalCount, Float disposalAmount,
			Integer ensurePayCount, Float ensurePayAmount, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.badDebtCount = badDebtCount;
		this.badDebtAmount = badDebtAmount;
		this.disposalCount = disposalCount;
		this.disposalAmount = disposalAmount;
		this.ensurePayCount = ensurePayCount;
		this.ensurePayAmount = ensurePayAmount;
		this.getDate = getDate;
	}

    
    
	
    
    
  
}
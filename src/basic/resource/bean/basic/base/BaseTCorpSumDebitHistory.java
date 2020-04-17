package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpSumDebitHistory implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 887494355297202088L;
	public static String REF = "TCorpSumDebitHistory";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_TOTAL_AMOUNT="totalAmount";
    public static String PROP_BAD_AMOUNT="badAmount";
    public static String PROP_MONTH="month";


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.Float totalAmount;
    private java.lang.Float badAmount;
    private java.lang.String month;

	public BaseTCorpSumDebitHistory() {
		super();
	}

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

	public static String getPROP_TOTAL_AMOUNT() {
		return PROP_TOTAL_AMOUNT;
	}

	public static void setPROP_TOTAL_AMOUNT(String pROP_TOTAL_AMOUNT) {
		PROP_TOTAL_AMOUNT = pROP_TOTAL_AMOUNT;
	}

	public static String getPROP_BAD_AMOUNT() {
		return PROP_BAD_AMOUNT;
	}

	public static void setPROP_BAD_AMOUNT(String pROP_BAD_AMOUNT) {
		PROP_BAD_AMOUNT = pROP_BAD_AMOUNT;
	}

	public static String getPROP_MONTH() {
		return PROP_MONTH;
	}

	public static void setPROP_MONTH(String pROP_MONTH) {
		PROP_MONTH = pROP_MONTH;
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

	public java.lang.Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(java.lang.Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.lang.Float getBadAmount() {
		return badAmount;
	}

	public void setBadAmount(java.lang.Float badAmount) {
		this.badAmount = badAmount;
	}

	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((badAmount == null) ? 0 : badAmount.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
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
		BaseTCorpSumDebitHistory other = (BaseTCorpSumDebitHistory) obj;
		if (badAmount == null) {
			if (other.badAmount != null)
				return false;
		} else if (!badAmount.equals(other.badAmount))
			return false;
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
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		return true;
	}

	public BaseTCorpSumDebitHistory(int hashCode, Integer id, String rptKey,
			Date createTime, Float totalAmount, Float badAmount, String month) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.totalAmount = totalAmount;
		this.badAmount = badAmount;
		this.month = month;
	}

	
	




	
	
    
    
	
    
    
}
package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.Bctl;

/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpPublicInfoDetail implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpPublicInfoDetail";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_SUM_YM="sumYm";
    public static String PROP_MONTH_FEE_PAYABLE="monthFeePayable";
    public static String PROP_MONTH_FEE_PAID="monthFeePaid";
    public static String PROP_PAY_STATUS="payStatus";
    public static String PROP_OW_AMOUNT="owAmount";
	public BaseTCorpPublicInfoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.String sumYm;
    private java.lang.String monthFeePayable;
    private java.lang.String monthFeePaid;
    private java.lang.String payStatus;
    private java.lang.String owAmount;
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
	public static String getPROP_ITEM_NAME() {
		return PROP_ITEM_NAME;
	}
	public static void setPROP_ITEM_NAME(String pROP_ITEM_NAME) {
		PROP_ITEM_NAME = pROP_ITEM_NAME;
	}
	public static String getPROP_SUM_YM() {
		return PROP_SUM_YM;
	}
	public static void setPROP_SUM_YM(String pROP_SUM_YM) {
		PROP_SUM_YM = pROP_SUM_YM;
	}
	public static String getPROP_MONTH_FEE_PAYABLE() {
		return PROP_MONTH_FEE_PAYABLE;
	}
	public static void setPROP_MONTH_FEE_PAYABLE(String pROP_MONTH_FEE_PAYABLE) {
		PROP_MONTH_FEE_PAYABLE = pROP_MONTH_FEE_PAYABLE;
	}
	public static String getPROP_MONTH_FEE_PAID() {
		return PROP_MONTH_FEE_PAID;
	}
	public static void setPROP_MONTH_FEE_PAID(String pROP_MONTH_FEE_PAID) {
		PROP_MONTH_FEE_PAID = pROP_MONTH_FEE_PAID;
	}
	public static String getPROP_PAY_STATUS() {
		return PROP_PAY_STATUS;
	}
	public static void setPROP_PAY_STATUS(String pROP_PAY_STATUS) {
		PROP_PAY_STATUS = pROP_PAY_STATUS;
	}
	public static String getPROP_OW_AMOUNT() {
		return PROP_OW_AMOUNT;
	}
	public static void setPROP_OW_AMOUNT(String pROP_OW_AMOUNT) {
		PROP_OW_AMOUNT = pROP_OW_AMOUNT;
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
	public java.lang.String getItemName() {
		return itemName;
	}
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	public java.lang.String getSumYm() {
		return sumYm;
	}
	public void setSumYm(java.lang.String sumYm) {
		this.sumYm = sumYm;
	}
	public java.lang.String getMonthFeePayable() {
		return monthFeePayable;
	}
	public void setMonthFeePayable(java.lang.String monthFeePayable) {
		this.monthFeePayable = monthFeePayable;
	}
	public java.lang.String getMonthFeePaid() {
		return monthFeePaid;
	}
	public void setMonthFeePaid(java.lang.String monthFeePaid) {
		this.monthFeePaid = monthFeePaid;
	}
	public java.lang.String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(java.lang.String payStatus) {
		this.payStatus = payStatus;
	}
	public java.lang.String getOwAmount() {
		return owAmount;
	}
	public void setOwAmount(java.lang.String owAmount) {
		this.owAmount = owAmount;
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
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((monthFeePaid == null) ? 0 : monthFeePaid.hashCode());
		result = prime * result
				+ ((monthFeePayable == null) ? 0 : monthFeePayable.hashCode());
		result = prime * result
				+ ((owAmount == null) ? 0 : owAmount.hashCode());
		result = prime * result
				+ ((payStatus == null) ? 0 : payStatus.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((sumYm == null) ? 0 : sumYm.hashCode());
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
		BaseTCorpPublicInfoDetail other = (BaseTCorpPublicInfoDetail) obj;
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
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (monthFeePaid == null) {
			if (other.monthFeePaid != null)
				return false;
		} else if (!monthFeePaid.equals(other.monthFeePaid))
			return false;
		if (monthFeePayable == null) {
			if (other.monthFeePayable != null)
				return false;
		} else if (!monthFeePayable.equals(other.monthFeePayable))
			return false;
		if (owAmount == null) {
			if (other.owAmount != null)
				return false;
		} else if (!owAmount.equals(other.owAmount))
			return false;
		if (payStatus == null) {
			if (other.payStatus != null)
				return false;
		} else if (!payStatus.equals(other.payStatus))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (sumYm == null) {
			if (other.sumYm != null)
				return false;
		} else if (!sumYm.equals(other.sumYm))
			return false;
		return true;
	}
	public BaseTCorpPublicInfoDetail(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String sumYm,
			String monthFeePayable, String monthFeePaid, String payStatus,
			String owAmount) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.sumYm = sumYm;
		this.monthFeePayable = monthFeePayable;
		this.monthFeePaid = monthFeePaid;
		this.payStatus = payStatus;
		this.owAmount = owAmount;
	}
    
    




    
}
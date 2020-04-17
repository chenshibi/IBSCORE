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

public abstract class BaseTCorpOrginalDetailWindows implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpOrginalDetailWindows";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_AMOUNT="amount";
    public static String PROP_BALANCE="balance";
    public static String PROP_BOND_DATE="bondDate";
    public static String PROP_CREATE_TIME="createTime";
	public static String PROP_CURRENCY="currency";
	public static String PROP_EXPIRE_DATE="expireDate";
	public static String PROP_FIVE_LEVEL="fiveLevel";
	public static String PROP_ITEM_NAME="itemName";
	public static String PROP_OPEN_DATE="openDate";
	
	



	public BaseTCorpOrginalDetailWindows() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.lang.Float amount;
    private java.lang.Float balance;
    private java.lang.String bondDate;
    private java.util.Date createTime;
    private java.lang.String currency;
    private java.lang.String expireDate;
    private java.lang.String fiveLevel;
    private java.lang.String itemName;
    private java.lang.String openDate;





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
	public static String getPROP_AMOUNT() {
		return PROP_AMOUNT;
	}
	public static void setPROP_AMOUNT(String pROP_AMOUNT) {
		PROP_AMOUNT = pROP_AMOUNT;
	}
	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}
	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}
	public static String getPROP_BOND_DATE() {
		return PROP_BOND_DATE;
	}
	public static void setPROP_BOND_DATE(String pROP_BOND_DATE) {
		PROP_BOND_DATE = pROP_BOND_DATE;
	}
	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}
	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}
	public static String getPROP_CURRENCY() {
		return PROP_CURRENCY;
	}
	public static void setPROP_CURRENCY(String pROP_CURRENCY) {
		PROP_CURRENCY = pROP_CURRENCY;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public static String getPROP_FIVE_LEVEL() {
		return PROP_FIVE_LEVEL;
	}
	public static void setPROP_FIVE_LEVEL(String pROP_FIVE_LEVEL) {
		PROP_FIVE_LEVEL = pROP_FIVE_LEVEL;
	}
	public static String getPROP_ITEM_NAME() {
		return PROP_ITEM_NAME;
	}
	public static void setPROP_ITEM_NAME(String pROP_ITEM_NAME) {
		PROP_ITEM_NAME = pROP_ITEM_NAME;
	}
	public static String getPROP_OPEN_DATE() {
		return PROP_OPEN_DATE;
	}
	public static void setPROP_OPEN_DATE(String pROP_OPEN_DATE) {
		PROP_OPEN_DATE = pROP_OPEN_DATE;
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
	public java.lang.Float getAmount() {
		return amount;
	}
	public void setAmount(java.lang.Float amount) {
		this.amount = amount;
	}
	public java.lang.Float getBalance() {
		return balance;
	}
	public void setBalance(java.lang.Float balance) {
		this.balance = balance;
	}
	public java.lang.String getBondDate() {
		return bondDate;
	}
	public void setBondDate(java.lang.String bondDate) {
		this.bondDate = bondDate;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getCurrency() {
		return currency;
	}
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}
	public java.lang.String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.lang.String expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getFiveLevel() {
		return fiveLevel;
	}
	public void setFiveLevel(java.lang.String fiveLevel) {
		this.fiveLevel = fiveLevel;
	}
	public java.lang.String getItemName() {
		return itemName;
	}
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	public java.lang.String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(java.lang.String openDate) {
		this.openDate = openDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((bondDate == null) ? 0 : bondDate.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result
				+ ((fiveLevel == null) ? 0 : fiveLevel.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
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
		BaseTCorpOrginalDetailWindows other = (BaseTCorpOrginalDetailWindows) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (bondDate == null) {
			if (other.bondDate != null)
				return false;
		} else if (!bondDate.equals(other.bondDate))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (fiveLevel == null) {
			if (other.fiveLevel != null)
				return false;
		} else if (!fiveLevel.equals(other.fiveLevel))
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
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTCorpOrginalDetailWindows(int hashCode, Integer id,
			String rptKey, Float amount, Float balance, String bondDate,
			Date createTime, String currency, String expireDate,
			String fiveLevel, String itemName, String openDate) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.amount = amount;
		this.balance = balance;
		this.bondDate = bondDate;
		this.createTime = createTime;
		this.currency = currency;
		this.expireDate = expireDate;
		this.fiveLevel = fiveLevel;
		this.itemName = itemName;
		this.openDate = openDate;
	}
    
}
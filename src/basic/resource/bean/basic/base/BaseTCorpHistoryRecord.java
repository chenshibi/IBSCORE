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

public abstract class BaseTCorpHistoryRecord implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpHistoryRecord";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_CLEAR_TYPE="clearType";
    public static String PROP_CREATE_DATE="createDate";
    public static String PROP_LAST_BALANCE_CHG_DATE="lastBalanceChgDate";
    public static String PROP_BALANCE="balance";
	public static String PROP_FIVE_LEVEL="fiveLevel";
	public static String PROP_EXTENSION_NAME="extensionName";

	public BaseTCorpHistoryRecord() {
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
    private java.lang.String clearType;
    private java.lang.String createDate;
    private java.lang.String lastBalanceChgDate;
    private java.lang.String balance;
    private java.lang.String fiveLevel;
    private java.lang.String extensionName;

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
	public static String getPROP_CLEAR_TYPE() {
		return PROP_CLEAR_TYPE;
	}
	public static void setPROP_CLEAR_TYPE(String pROP_CLEAR_TYPE) {
		PROP_CLEAR_TYPE = pROP_CLEAR_TYPE;
	}
	public static String getPROP_CREATE_DATE() {
		return PROP_CREATE_DATE;
	}
	public static void setPROP_CREATE_DATE(String pROP_CREATE_DATE) {
		PROP_CREATE_DATE = pROP_CREATE_DATE;
	}
	public static String getPROP_LAST_BALANCE_CHG_DATE() {
		return PROP_LAST_BALANCE_CHG_DATE;
	}
	public static void setPROP_LAST_BALANCE_CHG_DATE(
			String pROP_LAST_BALANCE_CHG_DATE) {
		PROP_LAST_BALANCE_CHG_DATE = pROP_LAST_BALANCE_CHG_DATE;
	}
	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}
	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}
	public static String getPROP_FIVE_LEVEL() {
		return PROP_FIVE_LEVEL;
	}
	public static void setPROP_FIVE_LEVEL(String pROP_FIVE_LEVEL) {
		PROP_FIVE_LEVEL = pROP_FIVE_LEVEL;
	}
	public static String getPROP_EXTENSION_NAME() {
		return PROP_EXTENSION_NAME;
	}
	public static void setPROP_EXTENSION_NAME(String pROP_EXTENSION_NAME) {
		PROP_EXTENSION_NAME = pROP_EXTENSION_NAME;
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
	public java.lang.String getClearType() {
		return clearType;
	}
	public void setClearType(java.lang.String clearType) {
		this.clearType = clearType;
	}
	public java.lang.String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.lang.String createDate) {
		this.createDate = createDate;
	}
	public java.lang.String getLastBalanceChgDate() {
		return lastBalanceChgDate;
	}
	public void setLastBalanceChgDate(java.lang.String lastBalanceChgDate) {
		this.lastBalanceChgDate = lastBalanceChgDate;
	}
	public java.lang.String getBalance() {
		return balance;
	}
	public void setBalance(java.lang.String balance) {
		this.balance = balance;
	}
	public java.lang.String getFiveLevel() {
		return fiveLevel;
	}
	public void setFiveLevel(java.lang.String fiveLevel) {
		this.fiveLevel = fiveLevel;
	}
	public java.lang.String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(java.lang.String extensionName) {
		this.extensionName = extensionName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((clearType == null) ? 0 : clearType.hashCode());
		result = prime * result
				+ ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((extensionName == null) ? 0 : extensionName.hashCode());
		result = prime * result
				+ ((fiveLevel == null) ? 0 : fiveLevel.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime
				* result
				+ ((lastBalanceChgDate == null) ? 0 : lastBalanceChgDate
						.hashCode());
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
		BaseTCorpHistoryRecord other = (BaseTCorpHistoryRecord) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (clearType == null) {
			if (other.clearType != null)
				return false;
		} else if (!clearType.equals(other.clearType))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (extensionName == null) {
			if (other.extensionName != null)
				return false;
		} else if (!extensionName.equals(other.extensionName))
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
		if (lastBalanceChgDate == null) {
			if (other.lastBalanceChgDate != null)
				return false;
		} else if (!lastBalanceChgDate.equals(other.lastBalanceChgDate))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTCorpHistoryRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String clearType,
			String createDate, String lastBalanceChgDate, String balance,
			String fiveLevel, String extensionName) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.clearType = clearType;
		this.createDate = createDate;
		this.lastBalanceChgDate = lastBalanceChgDate;
		this.balance = balance;
		this.fiveLevel = fiveLevel;
		this.extensionName = extensionName;
	}

    





    
}
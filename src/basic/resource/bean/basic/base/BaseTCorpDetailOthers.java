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

public abstract class BaseTCorpDetailOthers implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpDetailOthers";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_STATUS="status";
    public static String PROP_ORGAN="organ";
    public static String PROP_TYPE="type";
    public static String PROP_CURRENCY="currency";
    public static String PROP_AMOUNT="amount";
    public static String PROP_BALANCE="balance";
	public static String PROP_INIT_DATE="initDate";
	public static String PROP_EXPIRE_DATE="expireDate";
	public static String PROP_CLOSE_DATE="closeDate";
	public static String PROP_UPDATE_DATE="updateDate";
	public static String PROP_FIVE_LEVEL="fiveLevel";
	public static String PROP_STYLE="style";
	public static String PROP_ASSURED="assured";
	public static String PROP_EXTENDED="extended";
	public static String PROP_ADVANCED="advanced";
	public static String PROP_DEPOSIT_RATIO="depositRatio";
	public static String PROP_CLOSE_STYLEE="closeStyle";
	public static String PROP_HISTORY_RECORD="historyRecord";
	
	



	public BaseTCorpDetailOthers() {
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
    private java.lang.String status;
    private java.lang.String organ;
    private java.lang.String type;
    private java.lang.String currency;
    private java.lang.Float amount;
    private java.lang.Float balance;
    private java.lang.String initDate;
    private java.lang.String expireDate;
    private java.lang.String closeDate;
    private java.lang.String updateDate;
    private java.lang.String fiveLevel;
    private java.lang.String style;
    private java.lang.String assured;
    private java.lang.String extended;
    private java.lang.String advanced;
    private java.lang.String depositRatio;
    private java.lang.String closeStyle;
    private java.lang.String historyRecord;





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
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_CURRENCY() {
		return PROP_CURRENCY;
	}
	public static void setPROP_CURRENCY(String pROP_CURRENCY) {
		PROP_CURRENCY = pROP_CURRENCY;
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
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public static String getPROP_CLOSE_DATE() {
		return PROP_CLOSE_DATE;
	}
	public static void setPROP_CLOSE_DATE(String pROP_CLOSE_DATE) {
		PROP_CLOSE_DATE = pROP_CLOSE_DATE;
	}
	public static String getPROP_UPDATE_DATE() {
		return PROP_UPDATE_DATE;
	}
	public static void setPROP_UPDATE_DATE(String pROP_UPDATE_DATE) {
		PROP_UPDATE_DATE = pROP_UPDATE_DATE;
	}
	public static String getPROP_FIVE_LEVEL() {
		return PROP_FIVE_LEVEL;
	}
	public static void setPROP_FIVE_LEVEL(String pROP_FIVE_LEVEL) {
		PROP_FIVE_LEVEL = pROP_FIVE_LEVEL;
	}
	public static String getPROP_STYLE() {
		return PROP_STYLE;
	}
	public static void setPROP_STYLE(String pROP_STYLE) {
		PROP_STYLE = pROP_STYLE;
	}
	public static String getPROP_ASSURED() {
		return PROP_ASSURED;
	}
	public static void setPROP_ASSURED(String pROP_ASSURED) {
		PROP_ASSURED = pROP_ASSURED;
	}
	public static String getPROP_EXTENDED() {
		return PROP_EXTENDED;
	}
	public static void setPROP_EXTENDED(String pROP_EXTENDED) {
		PROP_EXTENDED = pROP_EXTENDED;
	}
	public static String getPROP_ADVANCED() {
		return PROP_ADVANCED;
	}
	public static void setPROP_ADVANCED(String pROP_ADVANCED) {
		PROP_ADVANCED = pROP_ADVANCED;
	}
	public static String getPROP_DEPOSIT_RATIO() {
		return PROP_DEPOSIT_RATIO;
	}
	public static void setPROP_DEPOSIT_RATIO(String pROP_DEPOSIT_RATIO) {
		PROP_DEPOSIT_RATIO = pROP_DEPOSIT_RATIO;
	}
	public static String getPROP_CLOSE_STYLEE() {
		return PROP_CLOSE_STYLEE;
	}
	public static void setPROP_CLOSE_STYLEE(String pROP_CLOSE_STYLEE) {
		PROP_CLOSE_STYLEE = pROP_CLOSE_STYLEE;
	}
	public static String getPROP_HISTORY_RECORD() {
		return PROP_HISTORY_RECORD;
	}
	public static void setPROP_HISTORY_RECORD(String pROP_HISTORY_RECORD) {
		PROP_HISTORY_RECORD = pROP_HISTORY_RECORD;
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
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getCurrency() {
		return currency;
	}
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
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
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.lang.String expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(java.lang.String closeDate) {
		this.closeDate = closeDate;
	}
	public java.lang.String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}
	public java.lang.String getFiveLevel() {
		return fiveLevel;
	}
	public void setFiveLevel(java.lang.String fiveLevel) {
		this.fiveLevel = fiveLevel;
	}
	public java.lang.String getStyle() {
		return style;
	}
	public void setStyle(java.lang.String style) {
		this.style = style;
	}
	public java.lang.String getAssured() {
		return assured;
	}
	public void setAssured(java.lang.String assured) {
		this.assured = assured;
	}
	public java.lang.String getExtended() {
		return extended;
	}
	public void setExtended(java.lang.String extended) {
		this.extended = extended;
	}
	public java.lang.String getAdvanced() {
		return advanced;
	}
	public void setAdvanced(java.lang.String advanced) {
		this.advanced = advanced;
	}
	public java.lang.String getDepositRatio() {
		return depositRatio;
	}
	public void setDepositRatio(java.lang.String depositRatio) {
		this.depositRatio = depositRatio;
	}
	public java.lang.String getCloseStyle() {
		return closeStyle;
	}
	public void setCloseStyle(java.lang.String closeStyle) {
		this.closeStyle = closeStyle;
	}
	public java.lang.String getHistoryRecord() {
		return historyRecord;
	}
	public void setHistoryRecord(java.lang.String historyRecord) {
		this.historyRecord = historyRecord;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((advanced == null) ? 0 : advanced.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((assured == null) ? 0 : assured.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result
				+ ((closeStyle == null) ? 0 : closeStyle.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((depositRatio == null) ? 0 : depositRatio.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result
				+ ((extended == null) ? 0 : extended.hashCode());
		result = prime * result
				+ ((fiveLevel == null) ? 0 : fiveLevel.hashCode());
		result = prime * result + hashCode;
		result = prime * result
				+ ((historyRecord == null) ? 0 : historyRecord.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((style == null) ? 0 : style.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((updateDate == null) ? 0 : updateDate.hashCode());
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
		BaseTCorpDetailOthers other = (BaseTCorpDetailOthers) obj;
		if (advanced == null) {
			if (other.advanced != null)
				return false;
		} else if (!advanced.equals(other.advanced))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (assured == null) {
			if (other.assured != null)
				return false;
		} else if (!assured.equals(other.assured))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (closeStyle == null) {
			if (other.closeStyle != null)
				return false;
		} else if (!closeStyle.equals(other.closeStyle))
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
		if (depositRatio == null) {
			if (other.depositRatio != null)
				return false;
		} else if (!depositRatio.equals(other.depositRatio))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (extended == null) {
			if (other.extended != null)
				return false;
		} else if (!extended.equals(other.extended))
			return false;
		if (fiveLevel == null) {
			if (other.fiveLevel != null)
				return false;
		} else if (!fiveLevel.equals(other.fiveLevel))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (historyRecord == null) {
			if (other.historyRecord != null)
				return false;
		} else if (!historyRecord.equals(other.historyRecord))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (style == null) {
			if (other.style != null)
				return false;
		} else if (!style.equals(other.style))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	public BaseTCorpDetailOthers(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status, String organ,
			String type, String currency, Float amount, Float balance,
			String initDate, String expireDate, String closeDate,
			String updateDate, String fiveLevel, String style, String assured,
			String extended, String advanced, String depositRatio,
			String closeStyle, String historyRecord) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.status = status;
		this.organ = organ;
		this.type = type;
		this.currency = currency;
		this.amount = amount;
		this.balance = balance;
		this.initDate = initDate;
		this.expireDate = expireDate;
		this.closeDate = closeDate;
		this.updateDate = updateDate;
		this.fiveLevel = fiveLevel;
		this.style = style;
		this.assured = assured;
		this.extended = extended;
		this.advanced = advanced;
		this.depositRatio = depositRatio;
		this.closeStyle = closeStyle;
		this.historyRecord = historyRecord;
	}
    




    
}
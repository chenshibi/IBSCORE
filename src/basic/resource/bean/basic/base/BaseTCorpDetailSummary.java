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

public abstract class BaseTCorpDetailSummary implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpDetailSummary";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_STATUS="status";
    public static String PROP_ORGAN="organ";
    public static String PROP_COUNT="count";
    public static String PROP_AMOUNT="amount";
    public static String PROP_BALANCE="balance";
	public static String PROP_BALANCE_DAY30="balanceDay30";
	public static String PROP_BALANCE_DAY60="balanceDay60";
	public static String PROP_BALANCE_DAY90="balanceDay90";
	public static String PROP_BALANCE_DAY90_PLUS="balanceDay90Plus";
	public static String PROP_BIZ_DETAIL="bizDetail";
	
	



	public BaseTCorpDetailSummary() {
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
    private java.lang.Integer count;
    private java.lang.Float amount;
    private java.lang.Float balance;
    private java.lang.Float balanceDay30;
    private java.lang.Float balanceDay60;
    private java.lang.Float balanceDay90;
    private java.lang.Float balanceDay90Plus;
    private java.lang.String bizDetail;





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
	public static String getPROP_COUNT() {
		return PROP_COUNT;
	}
	public static void setPROP_COUNT(String pROP_COUNT) {
		PROP_COUNT = pROP_COUNT;
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
	public static String getPROP_BALANCE_DAY30() {
		return PROP_BALANCE_DAY30;
	}
	public static void setPROP_BALANCE_DAY30(String pROP_BALANCE_DAY30) {
		PROP_BALANCE_DAY30 = pROP_BALANCE_DAY30;
	}
	public static String getPROP_BALANCE_DAY60() {
		return PROP_BALANCE_DAY60;
	}
	public static void setPROP_BALANCE_DAY60(String pROP_BALANCE_DAY60) {
		PROP_BALANCE_DAY60 = pROP_BALANCE_DAY60;
	}
	public static String getPROP_BALANCE_DAY90() {
		return PROP_BALANCE_DAY90;
	}
	public static void setPROP_BALANCE_DAY90(String pROP_BALANCE_DAY90) {
		PROP_BALANCE_DAY90 = pROP_BALANCE_DAY90;
	}
	public static String getPROP_BALANCE_DAY90_PLUS() {
		return PROP_BALANCE_DAY90_PLUS;
	}
	public static void setPROP_BALANCE_DAY90_PLUS(String pROP_BALANCE_DAY90_PLUS) {
		PROP_BALANCE_DAY90_PLUS = pROP_BALANCE_DAY90_PLUS;
	}
	public static String getPROP_BIZ_DETAIL() {
		return PROP_BIZ_DETAIL;
	}
	public static void setPROP_BIZ_DETAIL(String pROP_BIZ_DETAIL) {
		PROP_BIZ_DETAIL = pROP_BIZ_DETAIL;
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
	public java.lang.Integer getCount() {
		return count;
	}
	public void setCount(java.lang.Integer count) {
		this.count = count;
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
	public java.lang.Float getBalanceDay30() {
		return balanceDay30;
	}
	public void setBalanceDay30(java.lang.Float balanceDay30) {
		this.balanceDay30 = balanceDay30;
	}
	public java.lang.Float getBalanceDay60() {
		return balanceDay60;
	}
	public void setBalanceDay60(java.lang.Float balanceDay60) {
		this.balanceDay60 = balanceDay60;
	}
	public java.lang.Float getBalanceDay90() {
		return balanceDay90;
	}
	public void setBalanceDay90(java.lang.Float balanceDay90) {
		this.balanceDay90 = balanceDay90;
	}
	public java.lang.Float getBalanceDay90Plus() {
		return balanceDay90Plus;
	}
	public void setBalanceDay90Plus(java.lang.Float balanceDay90Plus) {
		this.balanceDay90Plus = balanceDay90Plus;
	}
	public java.lang.String getBizDetail() {
		return bizDetail;
	}
	public void setBizDetail(java.lang.String bizDetail) {
		this.bizDetail = bizDetail;
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
				+ ((balanceDay30 == null) ? 0 : balanceDay30.hashCode());
		result = prime * result
				+ ((balanceDay60 == null) ? 0 : balanceDay60.hashCode());
		result = prime * result
				+ ((balanceDay90 == null) ? 0 : balanceDay90.hashCode());
		result = prime
				* result
				+ ((balanceDay90Plus == null) ? 0 : balanceDay90Plus.hashCode());
		result = prime * result
				+ ((bizDetail == null) ? 0 : bizDetail.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BaseTCorpDetailSummary other = (BaseTCorpDetailSummary) obj;
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
		if (balanceDay30 == null) {
			if (other.balanceDay30 != null)
				return false;
		} else if (!balanceDay30.equals(other.balanceDay30))
			return false;
		if (balanceDay60 == null) {
			if (other.balanceDay60 != null)
				return false;
		} else if (!balanceDay60.equals(other.balanceDay60))
			return false;
		if (balanceDay90 == null) {
			if (other.balanceDay90 != null)
				return false;
		} else if (!balanceDay90.equals(other.balanceDay90))
			return false;
		if (balanceDay90Plus == null) {
			if (other.balanceDay90Plus != null)
				return false;
		} else if (!balanceDay90Plus.equals(other.balanceDay90Plus))
			return false;
		if (bizDetail == null) {
			if (other.bizDetail != null)
				return false;
		} else if (!bizDetail.equals(other.bizDetail))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
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
		return true;
	}
	public BaseTCorpDetailSummary(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status, String organ,
			Integer count, Float amount, Float balance, Float balanceDay30,
			Float balanceDay60, Float balanceDay90, Float balanceDay90Plus,
			String bizDetail) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.status = status;
		this.organ = organ;
		this.count = count;
		this.amount = amount;
		this.balance = balance;
		this.balanceDay30 = balanceDay30;
		this.balanceDay60 = balanceDay60;
		this.balanceDay90 = balanceDay90;
		this.balanceDay90Plus = balanceDay90Plus;
		this.bizDetail = bizDetail;
	}
    




    




    
}
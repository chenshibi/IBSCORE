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

public abstract class BaseTCorpSumAssure implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpSumAssure";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_DISPOSE_COUNT="itemName";
    public static String PROP_DISPOSE_AMOUNT="count";
    public static String PROP_DISPOSE_DATE="amount";
    public static String PROP_DEBIT_INTEREST_COUNT="normalAmount";
    public static String PROP_DEBIT_INTEREST_AMOUNT="concernAmount";
    public static String PROP_DIVEST_COUNT="badAmount";
    public static String PROP_DIVEST_AMOUNT="totalAmount";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.Integer count;
    private java.lang.Float amount;
    private java.lang.Float normalAmount;
    private java.lang.Float concernAmount;
    private java.lang.Float badAmount;
    private java.lang.Float totalAmount;

	public BaseTCorpSumAssure() {
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

	public static String getPROP_DISPOSE_COUNT() {
		return PROP_DISPOSE_COUNT;
	}

	public static void setPROP_DISPOSE_COUNT(String pROP_DISPOSE_COUNT) {
		PROP_DISPOSE_COUNT = pROP_DISPOSE_COUNT;
	}

	public static String getPROP_DISPOSE_AMOUNT() {
		return PROP_DISPOSE_AMOUNT;
	}

	public static void setPROP_DISPOSE_AMOUNT(String pROP_DISPOSE_AMOUNT) {
		PROP_DISPOSE_AMOUNT = pROP_DISPOSE_AMOUNT;
	}

	public static String getPROP_DISPOSE_DATE() {
		return PROP_DISPOSE_DATE;
	}

	public static void setPROP_DISPOSE_DATE(String pROP_DISPOSE_DATE) {
		PROP_DISPOSE_DATE = pROP_DISPOSE_DATE;
	}

	public static String getPROP_DEBIT_INTEREST_COUNT() {
		return PROP_DEBIT_INTEREST_COUNT;
	}

	public static void setPROP_DEBIT_INTEREST_COUNT(String pROP_DEBIT_INTEREST_COUNT) {
		PROP_DEBIT_INTEREST_COUNT = pROP_DEBIT_INTEREST_COUNT;
	}

	public static String getPROP_DEBIT_INTEREST_AMOUNT() {
		return PROP_DEBIT_INTEREST_AMOUNT;
	}

	public static void setPROP_DEBIT_INTEREST_AMOUNT(
			String pROP_DEBIT_INTEREST_AMOUNT) {
		PROP_DEBIT_INTEREST_AMOUNT = pROP_DEBIT_INTEREST_AMOUNT;
	}

	public static String getPROP_DIVEST_COUNT() {
		return PROP_DIVEST_COUNT;
	}

	public static void setPROP_DIVEST_COUNT(String pROP_DIVEST_COUNT) {
		PROP_DIVEST_COUNT = pROP_DIVEST_COUNT;
	}

	public static String getPROP_DIVEST_AMOUNT() {
		return PROP_DIVEST_AMOUNT;
	}

	public static void setPROP_DIVEST_AMOUNT(String pROP_DIVEST_AMOUNT) {
		PROP_DIVEST_AMOUNT = pROP_DIVEST_AMOUNT;
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

	public java.lang.Float getNormalAmount() {
		return normalAmount;
	}

	public void setNormalAmount(java.lang.Float normalAmount) {
		this.normalAmount = normalAmount;
	}

	public java.lang.Float getConcernAmount() {
		return concernAmount;
	}

	public void setConcernAmount(java.lang.Float concernAmount) {
		this.concernAmount = concernAmount;
	}

	public java.lang.Float getBadAmount() {
		return badAmount;
	}

	public void setBadAmount(java.lang.Float badAmount) {
		this.badAmount = badAmount;
	}

	public java.lang.Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(java.lang.Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((badAmount == null) ? 0 : badAmount.hashCode());
		result = prime * result
				+ ((concernAmount == null) ? 0 : concernAmount.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((normalAmount == null) ? 0 : normalAmount.hashCode());
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
		BaseTCorpSumAssure other = (BaseTCorpSumAssure) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (badAmount == null) {
			if (other.badAmount != null)
				return false;
		} else if (!badAmount.equals(other.badAmount))
			return false;
		if (concernAmount == null) {
			if (other.concernAmount != null)
				return false;
		} else if (!concernAmount.equals(other.concernAmount))
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
		if (normalAmount == null) {
			if (other.normalAmount != null)
				return false;
		} else if (!normalAmount.equals(other.normalAmount))
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

	public BaseTCorpSumAssure(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, Integer count, Float amount,
			Float normalAmount, Float concernAmount, Float badAmount,
			Float totalAmount) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.count = count;
		this.amount = amount;
		this.normalAmount = normalAmount;
		this.concernAmount = concernAmount;
		this.badAmount = badAmount;
		this.totalAmount = totalAmount;
	}
	

	

	




	
	
    
    
	
    
    
}
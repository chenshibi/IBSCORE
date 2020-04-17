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

public abstract class BaseTCorpSumCreditItems implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpSumCreditItems";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_STATUS="status";
    public static String PROP_NORMAL_COUNT="normalCount";
    public static String PROP_NORMAL_AMOUNT="normalAmount";
    public static String PROP_CONCERN_COUNT="concernCount";
    public static String PROP_CONCERN_AMOUNT="concernAmount";
    public static String PROP_BAD_COUNT="badCount";
	public static String PROP_BAD_AMOUNT="badAmount";
	public static String PROP_TOTAL_COUNT="totalCount";
	public static String PROP_TOTAL_AMOUNT="totalAmount";

	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.String status;
    private java.lang.Integer normalCount;
    private java.lang.Float normalAmount;
    private java.lang.Integer concernCount;
    private java.lang.Float concernAmount;
    private java.lang.Integer badCount;
    private java.lang.Float badAmount;
    private java.lang.Integer totalCount;
    private java.lang.Float totalAmount;
	public BaseTCorpSumCreditItems() {
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
	public static String getPROP_NORMAL_COUNT() {
		return PROP_NORMAL_COUNT;
	}
	public static void setPROP_NORMAL_COUNT(String pROP_NORMAL_COUNT) {
		PROP_NORMAL_COUNT = pROP_NORMAL_COUNT;
	}
	public static String getPROP_NORMAL_AMOUNT() {
		return PROP_NORMAL_AMOUNT;
	}
	public static void setPROP_NORMAL_AMOUNT(String pROP_NORMAL_AMOUNT) {
		PROP_NORMAL_AMOUNT = pROP_NORMAL_AMOUNT;
	}
	public static String getPROP_CONCERN_COUNT() {
		return PROP_CONCERN_COUNT;
	}
	public static void setPROP_CONCERN_COUNT(String pROP_CONCERN_COUNT) {
		PROP_CONCERN_COUNT = pROP_CONCERN_COUNT;
	}
	public static String getPROP_CONCERN_AMOUNT() {
		return PROP_CONCERN_AMOUNT;
	}
	public static void setPROP_CONCERN_AMOUNT(String pROP_CONCERN_AMOUNT) {
		PROP_CONCERN_AMOUNT = pROP_CONCERN_AMOUNT;
	}
	public static String getPROP_BAD_COUNT() {
		return PROP_BAD_COUNT;
	}
	public static void setPROP_BAD_COUNT(String pROP_BAD_COUNT) {
		PROP_BAD_COUNT = pROP_BAD_COUNT;
	}
	public static String getPROP_BAD_AMOUNT() {
		return PROP_BAD_AMOUNT;
	}
	public static void setPROP_BAD_AMOUNT(String pROP_BAD_AMOUNT) {
		PROP_BAD_AMOUNT = pROP_BAD_AMOUNT;
	}
	public static String getPROP_TOTAL_COUNT() {
		return PROP_TOTAL_COUNT;
	}
	public static void setPROP_TOTAL_COUNT(String pROP_TOTAL_COUNT) {
		PROP_TOTAL_COUNT = pROP_TOTAL_COUNT;
	}
	public static String getPROP_TOTAL_AMOUNT() {
		return PROP_TOTAL_AMOUNT;
	}
	public static void setPROP_TOTAL_AMOUNT(String pROP_TOTAL_AMOUNT) {
		PROP_TOTAL_AMOUNT = pROP_TOTAL_AMOUNT;
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
	public java.lang.Integer getNormalCount() {
		return normalCount;
	}
	public void setNormalCount(java.lang.Integer normalCount) {
		this.normalCount = normalCount;
	}
	public java.lang.Float getNormalAmount() {
		return normalAmount;
	}
	public void setNormalAmount(java.lang.Float normalAmount) {
		this.normalAmount = normalAmount;
	}
	public java.lang.Integer getConcernCount() {
		return concernCount;
	}
	public void setConcernCount(java.lang.Integer concernCount) {
		this.concernCount = concernCount;
	}
	public java.lang.Float getConcernAmount() {
		return concernAmount;
	}
	public void setConcernAmount(java.lang.Float concernAmount) {
		this.concernAmount = concernAmount;
	}
	public java.lang.Integer getBadCount() {
		return badCount;
	}
	public void setBadCount(java.lang.Integer badCount) {
		this.badCount = badCount;
	}
	public java.lang.Float getBadAmount() {
		return badAmount;
	}
	public void setBadAmount(java.lang.Float badAmount) {
		this.badAmount = badAmount;
	}
	public java.lang.Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(java.lang.Integer totalCount) {
		this.totalCount = totalCount;
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
		result = prime * result
				+ ((badAmount == null) ? 0 : badAmount.hashCode());
		result = prime * result
				+ ((badCount == null) ? 0 : badCount.hashCode());
		result = prime * result
				+ ((concernAmount == null) ? 0 : concernAmount.hashCode());
		result = prime * result
				+ ((concernCount == null) ? 0 : concernCount.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((normalAmount == null) ? 0 : normalAmount.hashCode());
		result = prime * result
				+ ((normalCount == null) ? 0 : normalCount.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result
				+ ((totalCount == null) ? 0 : totalCount.hashCode());
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
		BaseTCorpSumCreditItems other = (BaseTCorpSumCreditItems) obj;
		if (badAmount == null) {
			if (other.badAmount != null)
				return false;
		} else if (!badAmount.equals(other.badAmount))
			return false;
		if (badCount == null) {
			if (other.badCount != null)
				return false;
		} else if (!badCount.equals(other.badCount))
			return false;
		if (concernAmount == null) {
			if (other.concernAmount != null)
				return false;
		} else if (!concernAmount.equals(other.concernAmount))
			return false;
		if (concernCount == null) {
			if (other.concernCount != null)
				return false;
		} else if (!concernCount.equals(other.concernCount))
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
		if (normalCount == null) {
			if (other.normalCount != null)
				return false;
		} else if (!normalCount.equals(other.normalCount))
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
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalCount == null) {
			if (other.totalCount != null)
				return false;
		} else if (!totalCount.equals(other.totalCount))
			return false;
		return true;
	}
	public BaseTCorpSumCreditItems(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status,
			Integer normalCount, Float normalAmount, Integer concernCount,
			Float concernAmount, Integer badCount, Float badAmount,
			Integer totalCount, Float totalAmount) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.status = status;
		this.normalCount = normalCount;
		this.normalAmount = normalAmount;
		this.concernCount = concernCount;
		this.concernAmount = concernAmount;
		this.badCount = badCount;
		this.badAmount = badAmount;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
	}
	
	
	




	
	
    
    
	
    
    
}
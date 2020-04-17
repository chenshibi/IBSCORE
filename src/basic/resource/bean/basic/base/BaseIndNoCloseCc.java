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

public abstract class BaseIndNoCloseCc implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndNoCloseCc";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_LAW_ORG_COUNT="lawOrgCount";
    public static String PROP_ORG_COUNT="orgCount";
    public static String PROP_COUNT="count";
    public static String PROP_TOTAL_CREDIT_AMOUNT="totalCreditAmount";
    public static String PROP_MAX_CREDIT_AMOUNT="maxCreditAmount";
    public static String PROP_MIN_CREDIT_AMOUNT="minCreditAmount";
    public static String PROP_TOTAL_USED="totalUsed";
    public static String PROP_AVG_USED_L6M="avgUsedL6m";
    public static String PROP_GETDATE="getDate";

    public BaseIndNoCloseCc() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer lawOrgCount;
    private java.lang.Integer orgCount;
    private java.lang.Integer count;
    private java.lang.Float totalCreditAmount;
    private java.lang.Float maxCreditAmount;
    private java.lang.Float minCreditAmount;
    private java.lang.Float totalUsed;
    private java.lang.Float avgUsedL6m;
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
	public static String getPROP_LAW_ORG_COUNT() {
		return PROP_LAW_ORG_COUNT;
	}
	public static void setPROP_LAW_ORG_COUNT(String pROP_LAW_ORG_COUNT) {
		PROP_LAW_ORG_COUNT = pROP_LAW_ORG_COUNT;
	}
	public static String getPROP_ORG_COUNT() {
		return PROP_ORG_COUNT;
	}
	public static void setPROP_ORG_COUNT(String pROP_ORG_COUNT) {
		PROP_ORG_COUNT = pROP_ORG_COUNT;
	}
	public static String getPROP_COUNT() {
		return PROP_COUNT;
	}
	public static void setPROP_COUNT(String pROP_COUNT) {
		PROP_COUNT = pROP_COUNT;
	}
	public static String getPROP_TOTAL_CREDIT_AMOUNT() {
		return PROP_TOTAL_CREDIT_AMOUNT;
	}
	public static void setPROP_TOTAL_CREDIT_AMOUNT(String pROP_TOTAL_CREDIT_AMOUNT) {
		PROP_TOTAL_CREDIT_AMOUNT = pROP_TOTAL_CREDIT_AMOUNT;
	}
	public static String getPROP_MAX_CREDIT_AMOUNT() {
		return PROP_MAX_CREDIT_AMOUNT;
	}
	public static void setPROP_MAX_CREDIT_AMOUNT(String pROP_MAX_CREDIT_AMOUNT) {
		PROP_MAX_CREDIT_AMOUNT = pROP_MAX_CREDIT_AMOUNT;
	}
	public static String getPROP_MIN_CREDIT_AMOUNT() {
		return PROP_MIN_CREDIT_AMOUNT;
	}
	public static void setPROP_MIN_CREDIT_AMOUNT(String pROP_MIN_CREDIT_AMOUNT) {
		PROP_MIN_CREDIT_AMOUNT = pROP_MIN_CREDIT_AMOUNT;
	}
	public static String getPROP_TOTAL_USED() {
		return PROP_TOTAL_USED;
	}
	public static void setPROP_TOTAL_USED(String pROP_TOTAL_USED) {
		PROP_TOTAL_USED = pROP_TOTAL_USED;
	}
	public static String getPROP_AVG_USED_L6M() {
		return PROP_AVG_USED_L6M;
	}
	public static void setPROP_AVG_USED_L6M(String pROP_AVG_USED_L6M) {
		PROP_AVG_USED_L6M = pROP_AVG_USED_L6M;
	}
	public static String getPROP_GETDATE() {
		return PROP_GETDATE;
	}
	public static void setPROP_GETDATE(String pROP_GETDATE) {
		PROP_GETDATE = pROP_GETDATE;
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
	public java.lang.Integer getLawOrgCount() {
		return lawOrgCount;
	}
	public void setLawOrgCount(java.lang.Integer lawOrgCount) {
		this.lawOrgCount = lawOrgCount;
	}
	public java.lang.Integer getOrgCount() {
		return orgCount;
	}
	public void setOrgCount(java.lang.Integer orgCount) {
		this.orgCount = orgCount;
	}
	public java.lang.Integer getCount() {
		return count;
	}
	public void setCount(java.lang.Integer count) {
		this.count = count;
	}
	public java.lang.Float getTotalCreditAmount() {
		return totalCreditAmount;
	}
	public void setTotalCreditAmount(java.lang.Float totalCreditAmount) {
		this.totalCreditAmount = totalCreditAmount;
	}
	public java.lang.Float getMaxCreditAmount() {
		return maxCreditAmount;
	}
	public void setMaxCreditAmount(java.lang.Float maxCreditAmount) {
		this.maxCreditAmount = maxCreditAmount;
	}
	public java.lang.Float getMinCreditAmount() {
		return minCreditAmount;
	}
	public void setMinCreditAmount(java.lang.Float minCreditAmount) {
		this.minCreditAmount = minCreditAmount;
	}
	public java.lang.Float getTotalUsed() {
		return totalUsed;
	}
	public void setTotalUsed(java.lang.Float totalUsed) {
		this.totalUsed = totalUsed;
	}
	public java.lang.Float getAvgUsedL6m() {
		return avgUsedL6m;
	}
	public void setAvgUsedL6m(java.lang.Float avgUsedL6m) {
		this.avgUsedL6m = avgUsedL6m;
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
				+ ((avgUsedL6m == null) ? 0 : avgUsedL6m.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lawOrgCount == null) ? 0 : lawOrgCount.hashCode());
		result = prime * result
				+ ((maxCreditAmount == null) ? 0 : maxCreditAmount.hashCode());
		result = prime * result
				+ ((minCreditAmount == null) ? 0 : minCreditAmount.hashCode());
		result = prime * result
				+ ((orgCount == null) ? 0 : orgCount.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime
				* result
				+ ((totalCreditAmount == null) ? 0 : totalCreditAmount
						.hashCode());
		result = prime * result
				+ ((totalUsed == null) ? 0 : totalUsed.hashCode());
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
		BaseIndNoCloseCc other = (BaseIndNoCloseCc) obj;
		if (avgUsedL6m == null) {
			if (other.avgUsedL6m != null)
				return false;
		} else if (!avgUsedL6m.equals(other.avgUsedL6m))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
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
		if (lawOrgCount == null) {
			if (other.lawOrgCount != null)
				return false;
		} else if (!lawOrgCount.equals(other.lawOrgCount))
			return false;
		if (maxCreditAmount == null) {
			if (other.maxCreditAmount != null)
				return false;
		} else if (!maxCreditAmount.equals(other.maxCreditAmount))
			return false;
		if (minCreditAmount == null) {
			if (other.minCreditAmount != null)
				return false;
		} else if (!minCreditAmount.equals(other.minCreditAmount))
			return false;
		if (orgCount == null) {
			if (other.orgCount != null)
				return false;
		} else if (!orgCount.equals(other.orgCount))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (totalCreditAmount == null) {
			if (other.totalCreditAmount != null)
				return false;
		} else if (!totalCreditAmount.equals(other.totalCreditAmount))
			return false;
		if (totalUsed == null) {
			if (other.totalUsed != null)
				return false;
		} else if (!totalUsed.equals(other.totalUsed))
			return false;
		return true;
	}
	public BaseIndNoCloseCc(Integer id, String rptId, Integer lawOrgCount,
			Integer orgCount, Integer count, Float totalCreditAmount,
			Float maxCreditAmount, Float minCreditAmount, Float totalUsed,
			Float avgUsedL6m, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.lawOrgCount = lawOrgCount;
		this.orgCount = orgCount;
		this.count = count;
		this.totalCreditAmount = totalCreditAmount;
		this.maxCreditAmount = maxCreditAmount;
		this.minCreditAmount = minCreditAmount;
		this.totalUsed = totalUsed;
		this.avgUsedL6m = avgUsedL6m;
		this.getDate = getDate;
	}

    
    
	
    
    
  
}
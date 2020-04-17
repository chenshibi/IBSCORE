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

public abstract class BaseIndNoCloseLoan implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndNoCloseLoan";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_LAW_ORG_COUNT="lawOrgCount";
    public static String PROP_ORG_COUNT="orgCount";
    public static String PROP_COUNT="count";
    public static String PROP_TOTAL_AMOUNT="totalAmount";
    public static String PROP_TOTAL_BALANCE="totalBalance";
    public static String PROP_AVG_MONTH_PAY_L6M="avgMonthPayL6m";
    public static String PROP_GETDATE="getDate";

    public BaseIndNoCloseLoan() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer lawOrgCount;
    private java.lang.Integer orgCount;
    private java.lang.Integer count;
    private java.lang.Float totalAmount;
    private java.lang.Float totalBalance;
    private java.lang.Float avgMonthPayL6m;
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
	public static String getPROP_TOTAL_AMOUNT() {
		return PROP_TOTAL_AMOUNT;
	}
	public static void setPROP_TOTAL_AMOUNT(String pROP_TOTAL_AMOUNT) {
		PROP_TOTAL_AMOUNT = pROP_TOTAL_AMOUNT;
	}
	public static String getPROP_TOTAL_BALANCE() {
		return PROP_TOTAL_BALANCE;
	}
	public static void setPROP_TOTAL_BALANCE(String pROP_TOTAL_BALANCE) {
		PROP_TOTAL_BALANCE = pROP_TOTAL_BALANCE;
	}
	public static String getPROP_AVG_MONTH_PAY_L6M() {
		return PROP_AVG_MONTH_PAY_L6M;
	}
	public static void setPROP_AVG_MONTH_PAY_L6M(String pROP_AVG_MONTH_PAY_L6M) {
		PROP_AVG_MONTH_PAY_L6M = pROP_AVG_MONTH_PAY_L6M;
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
	public java.lang.Float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(java.lang.Float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public java.lang.Float getTotalBalance() {
		return totalBalance;
	}
	public void setTotalBalance(java.lang.Float totalBalance) {
		this.totalBalance = totalBalance;
	}
	public java.lang.Float getAvgMonthPayL6m() {
		return avgMonthPayL6m;
	}
	public void setAvgMonthPayL6m(java.lang.Float avgMonthPayL6m) {
		this.avgMonthPayL6m = avgMonthPayL6m;
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
				+ ((avgMonthPayL6m == null) ? 0 : avgMonthPayL6m.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lawOrgCount == null) ? 0 : lawOrgCount.hashCode());
		result = prime * result
				+ ((orgCount == null) ? 0 : orgCount.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result
				+ ((totalAmount == null) ? 0 : totalAmount.hashCode());
		result = prime * result
				+ ((totalBalance == null) ? 0 : totalBalance.hashCode());
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
		BaseIndNoCloseLoan other = (BaseIndNoCloseLoan) obj;
		if (avgMonthPayL6m == null) {
			if (other.avgMonthPayL6m != null)
				return false;
		} else if (!avgMonthPayL6m.equals(other.avgMonthPayL6m))
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
		if (totalAmount == null) {
			if (other.totalAmount != null)
				return false;
		} else if (!totalAmount.equals(other.totalAmount))
			return false;
		if (totalBalance == null) {
			if (other.totalBalance != null)
				return false;
		} else if (!totalBalance.equals(other.totalBalance))
			return false;
		return true;
	}
	public BaseIndNoCloseLoan(Integer id, String rptId, Integer lawOrgCount,
			Integer orgCount, Integer count, Float totalAmount,
			Float totalBalance, Float avgMonthPayL6m, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.lawOrgCount = lawOrgCount;
		this.orgCount = orgCount;
		this.count = count;
		this.totalAmount = totalAmount;
		this.totalBalance = totalBalance;
		this.avgMonthPayL6m = avgMonthPayL6m;
		this.getDate = getDate;
	}
    
    
    
	
    
    
  
}
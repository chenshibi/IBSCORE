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

public abstract class BaseIndLonDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndLonDetail";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_TYPE="type";
    public static String PROP_BIZ_NO="bizNo";
    public static String PROP_ORG_NAME="orgName";
    public static String PROP_ASSURANCE="assurance";
    public static String PROP_CURRENCY="currency";
    public static String PROP_ASS_STATUS="accStatus";
    public static String PROP_PAY_FRE="payFre";
    public static String PROP_MONTH_COUNT="monthCount";
    public static String PROP_ISSURENCE_DATE="issurenceDate";
    public static String PROP_END_DATE="endDate";
    public static String PROP_AMOUNT="amount";
    public static String PROP_BALANCE="balance";
    public static String PROP_GETDATE="getdate";
    public static String PROP_LEFT_MONTH="leftMonth";
    public static String PROP_RECENT_PAY_DATE="recentPayDate";
    public static String PROP_PAY_MONTH="payMonth";
    public static String PROP_PAY_REAL="payReal";
    public static String PROP_OVERDUE_COUNT="overdueCount";
    public static String PROP_OVERDUE_AMOUNT="overdueAmount";
    public static String PROP_OVERDUE_TOTAL="overdueTotal";
    public static String PROP_MAX_OVER_DUE="maxOverDue";
    public static String PROP_OVER31="over31";
    public static String PROP_OVER61="over61";
    public static String PROP_OVER91="over91";
    public static String PROP_AOVER180="over180";
    public static String PROP_MONTH24="month24";
    public static String PROP_YEARMONTH="yearmonth";
    public static String PROP_ORG_TYPE="orgType";

    public BaseIndLonDetail() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String type;
    private java.lang.String bizNo;
    private java.lang.String orgName;
    private java.lang.String assurance;
    private java.lang.String currency;
    private java.lang.String accStatus;
    private java.lang.String payFre;
    private java.lang.String monthCount;
    private java.util.Date issurenceDate;
    private java.util.Date endDate;
    private java.lang.Float amount;
    private java.lang.Float balance;
    private java.util.Date getdate;
    private java.lang.String leftMonth;
    private java.util.Date recentPayDate;
    private java.lang.Integer payMonth;
    private java.lang.Float payReal;
    private java.lang.Integer overdueCount;
    private java.lang.Float overdueAmount;
    private java.lang.Integer overdueTotal;
    private java.lang.Integer maxOverDue;
    private java.lang.Float over31;
    private java.lang.Float over61;
    private java.lang.Float over91;
    private java.lang.Float over180;
    private java.lang.String month24;
    private java.util.Date yearmonth;
    private java.lang.String orgType;
    private java.lang.String l5class;
    private java.lang.String payDay;

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
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_BIZ_NO() {
		return PROP_BIZ_NO;
	}
	public static void setPROP_BIZ_NO(String pROP_BIZ_NO) {
		PROP_BIZ_NO = pROP_BIZ_NO;
	}
	public static String getPROP_ORG_NAME() {
		return PROP_ORG_NAME;
	}
	public static void setPROP_ORG_NAME(String pROP_ORG_NAME) {
		PROP_ORG_NAME = pROP_ORG_NAME;
	}
	public static String getPROP_ASSURANCE() {
		return PROP_ASSURANCE;
	}
	public static void setPROP_ASSURANCE(String pROP_ASSURANCE) {
		PROP_ASSURANCE = pROP_ASSURANCE;
	}
	public static String getPROP_CURRENCY() {
		return PROP_CURRENCY;
	}
	public static void setPROP_CURRENCY(String pROP_CURRENCY) {
		PROP_CURRENCY = pROP_CURRENCY;
	}
	public static String getPROP_ASS_STATUS() {
		return PROP_ASS_STATUS;
	}
	public static void setPROP_ASS_STATUS(String pROP_ASS_STATUS) {
		PROP_ASS_STATUS = pROP_ASS_STATUS;
	}
	public static String getPROP_PAY_FRE() {
		return PROP_PAY_FRE;
	}
	public static void setPROP_PAY_FRE(String pROP_PAY_FRE) {
		PROP_PAY_FRE = pROP_PAY_FRE;
	}
	public static String getPROP_MONTH_COUNT() {
		return PROP_MONTH_COUNT;
	}
	public static void setPROP_MONTH_COUNT(String pROP_MONTH_COUNT) {
		PROP_MONTH_COUNT = pROP_MONTH_COUNT;
	}
	public static String getPROP_ISSURENCE_DATE() {
		return PROP_ISSURENCE_DATE;
	}
	public static void setPROP_ISSURENCE_DATE(String pROP_ISSURENCE_DATE) {
		PROP_ISSURENCE_DATE = pROP_ISSURENCE_DATE;
	}
	public static String getPROP_END_DATE() {
		return PROP_END_DATE;
	}
	public static void setPROP_END_DATE(String pROP_END_DATE) {
		PROP_END_DATE = pROP_END_DATE;
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
	public static String getPROP_GETDATE() {
		return PROP_GETDATE;
	}
	public static void setPROP_GETDATE(String pROP_GETDATE) {
		PROP_GETDATE = pROP_GETDATE;
	}
	public static String getPROP_LEFT_MONTH() {
		return PROP_LEFT_MONTH;
	}
	public static void setPROP_LEFT_MONTH(String pROP_LEFT_MONTH) {
		PROP_LEFT_MONTH = pROP_LEFT_MONTH;
	}
	public static String getPROP_RECENT_PAY_DATE() {
		return PROP_RECENT_PAY_DATE;
	}
	public static void setPROP_RECENT_PAY_DATE(String pROP_RECENT_PAY_DATE) {
		PROP_RECENT_PAY_DATE = pROP_RECENT_PAY_DATE;
	}
	public static String getPROP_PAY_MONTH() {
		return PROP_PAY_MONTH;
	}
	public static void setPROP_PAY_MONTH(String pROP_PAY_MONTH) {
		PROP_PAY_MONTH = pROP_PAY_MONTH;
	}
	public static String getPROP_PAY_REAL() {
		return PROP_PAY_REAL;
	}
	public static void setPROP_PAY_REAL(String pROP_PAY_REAL) {
		PROP_PAY_REAL = pROP_PAY_REAL;
	}
	public static String getPROP_OVERDUE_COUNT() {
		return PROP_OVERDUE_COUNT;
	}
	public static void setPROP_OVERDUE_COUNT(String pROP_OVERDUE_COUNT) {
		PROP_OVERDUE_COUNT = pROP_OVERDUE_COUNT;
	}
	public static String getPROP_OVERDUE_AMOUNT() {
		return PROP_OVERDUE_AMOUNT;
	}
	public static void setPROP_OVERDUE_AMOUNT(String pROP_OVERDUE_AMOUNT) {
		PROP_OVERDUE_AMOUNT = pROP_OVERDUE_AMOUNT;
	}
	public static String getPROP_OVERDUE_TOTAL() {
		return PROP_OVERDUE_TOTAL;
	}
	public static void setPROP_OVERDUE_TOTAL(String pROP_OVERDUE_TOTAL) {
		PROP_OVERDUE_TOTAL = pROP_OVERDUE_TOTAL;
	}
	public static String getPROP_MAX_OVER_DUE() {
		return PROP_MAX_OVER_DUE;
	}
	public static void setPROP_MAX_OVER_DUE(String pROP_MAX_OVER_DUE) {
		PROP_MAX_OVER_DUE = pROP_MAX_OVER_DUE;
	}
	public static String getPROP_OVER31() {
		return PROP_OVER31;
	}
	public static void setPROP_OVER31(String pROP_OVER31) {
		PROP_OVER31 = pROP_OVER31;
	}
	public static String getPROP_OVER61() {
		return PROP_OVER61;
	}
	public static void setPROP_OVER61(String pROP_OVER61) {
		PROP_OVER61 = pROP_OVER61;
	}
	public static String getPROP_OVER91() {
		return PROP_OVER91;
	}
	public static void setPROP_OVER91(String pROP_OVER91) {
		PROP_OVER91 = pROP_OVER91;
	}
	public static String getPROP_AOVER180() {
		return PROP_AOVER180;
	}
	public static void setPROP_AOVER180(String pROP_AOVER180) {
		PROP_AOVER180 = pROP_AOVER180;
	}
	public static String getPROP_MONTH24() {
		return PROP_MONTH24;
	}
	public static void setPROP_MONTH24(String pROP_MONTH24) {
		PROP_MONTH24 = pROP_MONTH24;
	}
	public static String getPROP_YEARMONTH() {
		return PROP_YEARMONTH;
	}
	public static void setPROP_YEARMONTH(String pROP_YEARMONTH) {
		PROP_YEARMONTH = pROP_YEARMONTH;
	}
	public static String getPROP_ORG_TYPE() {
		return PROP_ORG_TYPE;
	}
	public static void setPROP_ORG_TYPE(String pROP_ORG_TYPE) {
		PROP_ORG_TYPE = pROP_ORG_TYPE;
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
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getBizNo() {
		return bizNo;
	}
	public void setBizNo(java.lang.String bizNo) {
		this.bizNo = bizNo;
	}
	public java.lang.String getOrgName() {
		return orgName;
	}
	public void setOrgName(java.lang.String orgName) {
		this.orgName = orgName;
	}
	public java.lang.String getAssurance() {
		return assurance;
	}
	public void setAssurance(java.lang.String assurance) {
		this.assurance = assurance;
	}
	public java.lang.String getCurrency() {
		return currency;
	}
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}
	public java.lang.String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(java.lang.String accStatus) {
		this.accStatus = accStatus;
	}
	public java.lang.String getPayFre() {
		return payFre;
	}
	public void setPayFre(java.lang.String payFre) {
		this.payFre = payFre;
	}
	public java.lang.String getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(java.lang.String monthCount) {
		this.monthCount = monthCount;
	}
	public java.util.Date getIssurenceDate() {
		return issurenceDate;
	}
	public void setIssurenceDate(java.util.Date issurenceDate) {
		this.issurenceDate = issurenceDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
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
	public java.util.Date getGetdate() {
		return getdate;
	}
	public void setGetdate(java.util.Date getdate) {
		this.getdate = getdate;
	}
	public java.lang.String getLeftMonth() {
		return leftMonth;
	}
	public void setLeftMonth(java.lang.String leftMonth) {
		this.leftMonth = leftMonth;
	}
	public java.util.Date getRecentPayDate() {
		return recentPayDate;
	}
	public void setRecentPayDate(java.util.Date recentPayDate) {
		this.recentPayDate = recentPayDate;
	}
	public java.lang.Integer getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(java.lang.Integer payMonth) {
		this.payMonth = payMonth;
	}
	public java.lang.Float getPayReal() {
		return payReal;
	}
	public void setPayReal(java.lang.Float payReal) {
		this.payReal = payReal;
	}
	public java.lang.Integer getOverdueCount() {
		return overdueCount;
	}
	public void setOverdueCount(java.lang.Integer overdueCount) {
		this.overdueCount = overdueCount;
	}
	public java.lang.Float getOverdueAmount() {
		return overdueAmount;
	}
	public void setOverdueAmount(java.lang.Float overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	public java.lang.Integer getOverdueTotal() {
		return overdueTotal;
	}
	public void setOverdueTotal(java.lang.Integer overdueTotal) {
		this.overdueTotal = overdueTotal;
	}
	public java.lang.Integer getMaxOverDue() {
		return maxOverDue;
	}
	public void setMaxOverDue(java.lang.Integer maxOverDue) {
		this.maxOverDue = maxOverDue;
	}
	public java.lang.Float getOver31() {
		return over31;
	}
	public void setOver31(java.lang.Float over31) {
		this.over31 = over31;
	}
	public java.lang.Float getOver61() {
		return over61;
	}
	public void setOver61(java.lang.Float over61) {
		this.over61 = over61;
	}
	public java.lang.Float getOver91() {
		return over91;
	}
	public void setOver91(java.lang.Float over91) {
		this.over91 = over91;
	}
	public java.lang.Float getOver180() {
		return over180;
	}
	public void setOver180(java.lang.Float over180) {
		this.over180 = over180;
	}
	public java.lang.String getMonth24() {
		return month24;
	}
	public void setMonth24(java.lang.String month24) {
		this.month24 = month24;
	}
	public java.util.Date getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(java.util.Date yearmonth) {
		this.yearmonth = yearmonth;
	}
	public java.lang.String getOrgType() {
		return orgType;
	}
	public void setOrgType(java.lang.String orgType) {
		this.orgType = orgType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accStatus == null) ? 0 : accStatus.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((assurance == null) ? 0 : assurance.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((bizNo == null) ? 0 : bizNo.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((getdate == null) ? 0 : getdate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issurenceDate == null) ? 0 : issurenceDate.hashCode());
		result = prime * result
				+ ((leftMonth == null) ? 0 : leftMonth.hashCode());
		result = prime * result
				+ ((maxOverDue == null) ? 0 : maxOverDue.hashCode());
		result = prime * result + ((month24 == null) ? 0 : month24.hashCode());
		result = prime * result
				+ ((monthCount == null) ? 0 : monthCount.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((orgName == null) ? 0 : orgName.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + ((over180 == null) ? 0 : over180.hashCode());
		result = prime * result + ((over31 == null) ? 0 : over31.hashCode());
		result = prime * result + ((over61 == null) ? 0 : over61.hashCode());
		result = prime * result + ((over91 == null) ? 0 : over91.hashCode());
		result = prime * result
				+ ((overdueAmount == null) ? 0 : overdueAmount.hashCode());
		result = prime * result
				+ ((overdueCount == null) ? 0 : overdueCount.hashCode());
		result = prime * result
				+ ((overdueTotal == null) ? 0 : overdueTotal.hashCode());
		result = prime * result + ((payFre == null) ? 0 : payFre.hashCode());
		result = prime * result
				+ ((payMonth == null) ? 0 : payMonth.hashCode());
		result = prime * result + ((payReal == null) ? 0 : payReal.hashCode());
		result = prime * result
				+ ((recentPayDate == null) ? 0 : recentPayDate.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((yearmonth == null) ? 0 : yearmonth.hashCode());
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
		BaseIndLonDetail other = (BaseIndLonDetail) obj;
		if (accStatus == null) {
			if (other.accStatus != null)
				return false;
		} else if (!accStatus.equals(other.accStatus))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (assurance == null) {
			if (other.assurance != null)
				return false;
		} else if (!assurance.equals(other.assurance))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (bizNo == null) {
			if (other.bizNo != null)
				return false;
		} else if (!bizNo.equals(other.bizNo))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (getdate == null) {
			if (other.getdate != null)
				return false;
		} else if (!getdate.equals(other.getdate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issurenceDate == null) {
			if (other.issurenceDate != null)
				return false;
		} else if (!issurenceDate.equals(other.issurenceDate))
			return false;
		if (leftMonth == null) {
			if (other.leftMonth != null)
				return false;
		} else if (!leftMonth.equals(other.leftMonth))
			return false;
		if (maxOverDue == null) {
			if (other.maxOverDue != null)
				return false;
		} else if (!maxOverDue.equals(other.maxOverDue))
			return false;
		if (month24 == null) {
			if (other.month24 != null)
				return false;
		} else if (!month24.equals(other.month24))
			return false;
		if (monthCount == null) {
			if (other.monthCount != null)
				return false;
		} else if (!monthCount.equals(other.monthCount))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (orgName == null) {
			if (other.orgName != null)
				return false;
		} else if (!orgName.equals(other.orgName))
			return false;
		if (orgType == null) {
			if (other.orgType != null)
				return false;
		} else if (!orgType.equals(other.orgType))
			return false;
		if (over180 == null) {
			if (other.over180 != null)
				return false;
		} else if (!over180.equals(other.over180))
			return false;
		if (over31 == null) {
			if (other.over31 != null)
				return false;
		} else if (!over31.equals(other.over31))
			return false;
		if (over61 == null) {
			if (other.over61 != null)
				return false;
		} else if (!over61.equals(other.over61))
			return false;
		if (over91 == null) {
			if (other.over91 != null)
				return false;
		} else if (!over91.equals(other.over91))
			return false;
		if (overdueAmount == null) {
			if (other.overdueAmount != null)
				return false;
		} else if (!overdueAmount.equals(other.overdueAmount))
			return false;
		if (overdueCount == null) {
			if (other.overdueCount != null)
				return false;
		} else if (!overdueCount.equals(other.overdueCount))
			return false;
		if (overdueTotal == null) {
			if (other.overdueTotal != null)
				return false;
		} else if (!overdueTotal.equals(other.overdueTotal))
			return false;
		if (payFre == null) {
			if (other.payFre != null)
				return false;
		} else if (!payFre.equals(other.payFre))
			return false;
		if (payMonth == null) {
			if (other.payMonth != null)
				return false;
		} else if (!payMonth.equals(other.payMonth))
			return false;
		if (payReal == null) {
			if (other.payReal != null)
				return false;
		} else if (!payReal.equals(other.payReal))
			return false;
		if (recentPayDate == null) {
			if (other.recentPayDate != null)
				return false;
		} else if (!recentPayDate.equals(other.recentPayDate))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (yearmonth == null) {
			if (other.yearmonth != null)
				return false;
		} else if (!yearmonth.equals(other.yearmonth))
			return false;
		return true;
	}
	public BaseIndLonDetail(Integer id, String rptId, Integer no, String type,
			String bizNo, String orgName, String assurance, String currency,
			String accStatus, String payFre, String monthCount,
			Date issurenceDate, Date endDate, Float amount, Float balance,
			Date getdate, String leftMonth, Date recentPayDate,
			Integer payMonth, Float payReal, Integer overdueCount,
			Float overdueAmount, Integer overdueTotal, Integer maxOverDue,
			Float over31, Float over61, Float over91, Float over180,
			String month24, Date yearmonth, String orgType) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.type = type;
		this.bizNo = bizNo;
		this.orgName = orgName;
		this.assurance = assurance;
		this.currency = currency;
		this.accStatus = accStatus;
		this.payFre = payFre;
		this.monthCount = monthCount;
		this.issurenceDate = issurenceDate;
		this.endDate = endDate;
		this.amount = amount;
		this.balance = balance;
		this.getdate = getdate;
		this.leftMonth = leftMonth;
		this.recentPayDate = recentPayDate;
		this.payMonth = payMonth;
		this.payReal = payReal;
		this.overdueCount = overdueCount;
		this.overdueAmount = overdueAmount;
		this.overdueTotal = overdueTotal;
		this.maxOverDue = maxOverDue;
		this.over31 = over31;
		this.over61 = over61;
		this.over91 = over91;
		this.over180 = over180;
		this.month24 = month24;
		this.yearmonth = yearmonth;
		this.orgType = orgType;
	}
	public java.lang.String getL5class() {
		return l5class;
	}
	public void setL5class(java.lang.String l5class) {
		this.l5class = l5class;
	}
	public java.lang.String getPayDay() {
		return payDay;
	}
	public void setPayDay(java.lang.String payDay) {
		this.payDay = payDay;
	}

    
    
	
    
    
  
}
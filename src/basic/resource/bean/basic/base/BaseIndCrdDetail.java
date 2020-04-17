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

public abstract class BaseIndCrdDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndCrdDetail";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_CARD_TYPE="cardType";
    public static String PROP_BIZ_NO="bizNo";
    public static String PROP_ISSUER="issuer";
    public static String PROP_ASSURANCE="assurance";
    public static String PROP_CURRENCY="currency";
    public static String PROP_DATEOFCREATE="dateofcreate";
    public static String PROP_CREDIT="credit";
    public static String PROP_SHARE="share";
    public static String PROP_MAX_DEBIT="maxDebit";
    public static String PROP_OVERDUE="overdue";
    public static String PROP_ACC_STATUS="accStatus";
    public static String PROP_PAY_MONTH="payMonth";
    public static String PROP_PAY_REAL="payReal";
    public static String PROP_RECENT_DATE="recentDate";
    public static String PROP_OVER_COUNT="overCount";
    public static String PROP_OVER180="over180";
    public static String PROP_NOTPAY12="notpay12";
    public static String PROP_GETDATE="getdate";
    public static String PROP_MONTH24="month24";
    public static String PROP_YEARMONTH="yearmonth";
    public static String PROP_OVER_AMOUNT="overAmount";
    public static String PROP_ORG_TYPE="orgType";

    public BaseIndCrdDetail() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String cardType;
    private java.lang.String bizNo;
    private java.lang.String issuer;
    private java.lang.String assurance;
    private java.lang.String currency;
    private java.util.Date dateofcreate;
    private java.lang.Float credit;
    private java.lang.Float share;
    private java.lang.Float maxDebit;
    private java.lang.Float overdue;
    private java.lang.String accStatus;
    private java.lang.Float payMonth;
    private java.lang.Float payReal;
    private java.util.Date recentDate;
    private java.lang.Integer overCount;
    private java.lang.Float over180;
    private java.lang.Integer notpay12;
    private java.util.Date getdate;
    private java.lang.String month24;
    private java.util.Date yearmonth;
    private java.lang.Float overAmount;
    private java.lang.String orgType;
    
    private java.lang.String avgusedl6m;
    private java.lang.String billday;

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
	public static String getPROP_CARD_TYPE() {
		return PROP_CARD_TYPE;
	}
	public static void setPROP_CARD_TYPE(String pROP_CARD_TYPE) {
		PROP_CARD_TYPE = pROP_CARD_TYPE;
	}
	public static String getPROP_BIZ_NO() {
		return PROP_BIZ_NO;
	}
	public static void setPROP_BIZ_NO(String pROP_BIZ_NO) {
		PROP_BIZ_NO = pROP_BIZ_NO;
	}
	public static String getPROP_ISSUER() {
		return PROP_ISSUER;
	}
	public static void setPROP_ISSUER(String pROP_ISSUER) {
		PROP_ISSUER = pROP_ISSUER;
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
	public static String getPROP_DATEOFCREATE() {
		return PROP_DATEOFCREATE;
	}
	public static void setPROP_DATEOFCREATE(String pROP_DATEOFCREATE) {
		PROP_DATEOFCREATE = pROP_DATEOFCREATE;
	}
	public static String getPROP_CREDIT() {
		return PROP_CREDIT;
	}
	public static void setPROP_CREDIT(String pROP_CREDIT) {
		PROP_CREDIT = pROP_CREDIT;
	}
	public static String getPROP_SHARE() {
		return PROP_SHARE;
	}
	public static void setPROP_SHARE(String pROP_SHARE) {
		PROP_SHARE = pROP_SHARE;
	}
	public static String getPROP_MAX_DEBIT() {
		return PROP_MAX_DEBIT;
	}
	public static void setPROP_MAX_DEBIT(String pROP_MAX_DEBIT) {
		PROP_MAX_DEBIT = pROP_MAX_DEBIT;
	}
	public static String getPROP_OVERDUE() {
		return PROP_OVERDUE;
	}
	public static void setPROP_OVERDUE(String pROP_OVERDUE) {
		PROP_OVERDUE = pROP_OVERDUE;
	}
	public static String getPROP_ACC_STATUS() {
		return PROP_ACC_STATUS;
	}
	public static void setPROP_ACC_STATUS(String pROP_ACC_STATUS) {
		PROP_ACC_STATUS = pROP_ACC_STATUS;
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
	public static String getPROP_RECENT_DATE() {
		return PROP_RECENT_DATE;
	}
	public static void setPROP_RECENT_DATE(String pROP_RECENT_DATE) {
		PROP_RECENT_DATE = pROP_RECENT_DATE;
	}
	public static String getPROP_OVER_COUNT() {
		return PROP_OVER_COUNT;
	}
	public static void setPROP_OVER_COUNT(String pROP_OVER_COUNT) {
		PROP_OVER_COUNT = pROP_OVER_COUNT;
	}
	public static String getPROP_OVER180() {
		return PROP_OVER180;
	}
	public static void setPROP_OVER180(String pROP_OVER180) {
		PROP_OVER180 = pROP_OVER180;
	}
	public static String getPROP_NOTPAY12() {
		return PROP_NOTPAY12;
	}
	public static void setPROP_NOTPAY12(String pROP_NOTPAY12) {
		PROP_NOTPAY12 = pROP_NOTPAY12;
	}
	public static String getPROP_GETDATE() {
		return PROP_GETDATE;
	}
	public static void setPROP_GETDATE(String pROP_GETDATE) {
		PROP_GETDATE = pROP_GETDATE;
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
	public static String getPROP_OVER_AMOUNT() {
		return PROP_OVER_AMOUNT;
	}
	public static void setPROP_OVER_AMOUNT(String pROP_OVER_AMOUNT) {
		PROP_OVER_AMOUNT = pROP_OVER_AMOUNT;
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
	public java.lang.String getCardType() {
		return cardType;
	}
	public void setCardType(java.lang.String cardType) {
		this.cardType = cardType;
	}
	public java.lang.String getBizNo() {
		return bizNo;
	}
	public void setBizNo(java.lang.String bizNo) {
		this.bizNo = bizNo;
	}
	public java.lang.String getIssuer() {
		return issuer;
	}
	public void setIssuer(java.lang.String issuer) {
		this.issuer = issuer;
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
	public java.util.Date getDateofcreate() {
		return dateofcreate;
	}
	public void setDateofcreate(java.util.Date dateofcreate) {
		this.dateofcreate = dateofcreate;
	}
	public java.lang.Float getCredit() {
		return credit;
	}
	public void setCredit(java.lang.Float credit) {
		this.credit = credit;
	}
	public java.lang.Float getShare() {
		return share;
	}
	public void setShare(java.lang.Float share) {
		this.share = share;
	}
	public java.lang.Float getMaxDebit() {
		return maxDebit;
	}
	public void setMaxDebit(java.lang.Float maxDebit) {
		this.maxDebit = maxDebit;
	}
	public java.lang.Float getOverdue() {
		return overdue;
	}
	public void setOverdue(java.lang.Float overdue) {
		this.overdue = overdue;
	}
	public java.lang.String getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(java.lang.String accStatus) {
		this.accStatus = accStatus;
	}
	public java.lang.Float getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(java.lang.Float payMonth) {
		this.payMonth = payMonth;
	}
	public java.lang.Float getPayReal() {
		return payReal;
	}
	public void setPayReal(java.lang.Float payReal) {
		this.payReal = payReal;
	}
	public java.util.Date getRecentDate() {
		return recentDate;
	}
	public void setRecentDate(java.util.Date recentDate) {
		this.recentDate = recentDate;
	}
	public java.lang.Integer getOverCount() {
		return overCount;
	}
	public void setOverCount(java.lang.Integer overCount) {
		this.overCount = overCount;
	}
	public java.lang.Float getOver180() {
		return over180;
	}
	public void setOver180(java.lang.Float over180) {
		this.over180 = over180;
	}
	public java.lang.Integer getNotpay12() {
		return notpay12;
	}
	public void setNotpay12(java.lang.Integer notpay12) {
		this.notpay12 = notpay12;
	}
	public java.util.Date getGetdate() {
		return getdate;
	}
	public void setGetdate(java.util.Date getdate) {
		this.getdate = getdate;
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
	public java.lang.Float getOverAmount() {
		return overAmount;
	}
	public void setOverAmount(java.lang.Float overAmount) {
		this.overAmount = overAmount;
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
		result = prime * result
				+ ((assurance == null) ? 0 : assurance.hashCode());
		result = prime * result + ((bizNo == null) ? 0 : bizNo.hashCode());
		result = prime * result
				+ ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((credit == null) ? 0 : credit.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((dateofcreate == null) ? 0 : dateofcreate.hashCode());
		result = prime * result + ((getdate == null) ? 0 : getdate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((issuer == null) ? 0 : issuer.hashCode());
		result = prime * result
				+ ((maxDebit == null) ? 0 : maxDebit.hashCode());
		result = prime * result + ((month24 == null) ? 0 : month24.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result
				+ ((notpay12 == null) ? 0 : notpay12.hashCode());
		result = prime * result + ((orgType == null) ? 0 : orgType.hashCode());
		result = prime * result + ((over180 == null) ? 0 : over180.hashCode());
		result = prime * result
				+ ((overAmount == null) ? 0 : overAmount.hashCode());
		result = prime * result
				+ ((overCount == null) ? 0 : overCount.hashCode());
		result = prime * result + ((overdue == null) ? 0 : overdue.hashCode());
		result = prime * result
				+ ((payMonth == null) ? 0 : payMonth.hashCode());
		result = prime * result + ((payReal == null) ? 0 : payReal.hashCode());
		result = prime * result
				+ ((recentDate == null) ? 0 : recentDate.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((share == null) ? 0 : share.hashCode());
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
		BaseIndCrdDetail other = (BaseIndCrdDetail) obj;
		if (accStatus == null) {
			if (other.accStatus != null)
				return false;
		} else if (!accStatus.equals(other.accStatus))
			return false;
		if (assurance == null) {
			if (other.assurance != null)
				return false;
		} else if (!assurance.equals(other.assurance))
			return false;
		if (bizNo == null) {
			if (other.bizNo != null)
				return false;
		} else if (!bizNo.equals(other.bizNo))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (credit == null) {
			if (other.credit != null)
				return false;
		} else if (!credit.equals(other.credit))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (dateofcreate == null) {
			if (other.dateofcreate != null)
				return false;
		} else if (!dateofcreate.equals(other.dateofcreate))
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
		if (issuer == null) {
			if (other.issuer != null)
				return false;
		} else if (!issuer.equals(other.issuer))
			return false;
		if (maxDebit == null) {
			if (other.maxDebit != null)
				return false;
		} else if (!maxDebit.equals(other.maxDebit))
			return false;
		if (month24 == null) {
			if (other.month24 != null)
				return false;
		} else if (!month24.equals(other.month24))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (notpay12 == null) {
			if (other.notpay12 != null)
				return false;
		} else if (!notpay12.equals(other.notpay12))
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
		if (overAmount == null) {
			if (other.overAmount != null)
				return false;
		} else if (!overAmount.equals(other.overAmount))
			return false;
		if (overCount == null) {
			if (other.overCount != null)
				return false;
		} else if (!overCount.equals(other.overCount))
			return false;
		if (overdue == null) {
			if (other.overdue != null)
				return false;
		} else if (!overdue.equals(other.overdue))
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
		if (recentDate == null) {
			if (other.recentDate != null)
				return false;
		} else if (!recentDate.equals(other.recentDate))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (share == null) {
			if (other.share != null)
				return false;
		} else if (!share.equals(other.share))
			return false;
		if (yearmonth == null) {
			if (other.yearmonth != null)
				return false;
		} else if (!yearmonth.equals(other.yearmonth))
			return false;
		return true;
	}
	public BaseIndCrdDetail(Integer id, String rptId, Integer no,
			String cardType, String bizNo, String issuer, String assurance,
			String currency, Date dateofcreate, Float credit, Float share,
			Float maxDebit, Float overdue, String accStatus, Float payMonth,
			Float payReal, Date recentDate, Integer overCount, Float over180,
			Integer notpay12, Date getdate, String month24, Date yearmonth,
			Float overAmount, String orgType) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.cardType = cardType;
		this.bizNo = bizNo;
		this.issuer = issuer;
		this.assurance = assurance;
		this.currency = currency;
		this.dateofcreate = dateofcreate;
		this.credit = credit;
		this.share = share;
		this.maxDebit = maxDebit;
		this.overdue = overdue;
		this.accStatus = accStatus;
		this.payMonth = payMonth;
		this.payReal = payReal;
		this.recentDate = recentDate;
		this.overCount = overCount;
		this.over180 = over180;
		this.notpay12 = notpay12;
		this.getdate = getdate;
		this.month24 = month24;
		this.yearmonth = yearmonth;
		this.overAmount = overAmount;
		this.orgType = orgType;
	}
	public java.lang.String getAvgusedl6m() {
		return avgusedl6m;
	}
	public void setAvgusedl6m(java.lang.String avgusedl6m) {
		this.avgusedl6m = avgusedl6m;
	}
	public java.lang.String getBillday() {
		return billday;
	}
	public void setBillday(java.lang.String billday) {
		this.billday = billday;
	}

    
    
    
  
}
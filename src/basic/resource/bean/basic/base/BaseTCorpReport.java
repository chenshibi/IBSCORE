package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.Bctl;


public abstract class BaseTCorpReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4759930199441924118L;
	public static String REF = "TCorpReport";
	 public static String PROP_ID = "id";
    public static String PROP_CREATE_TIME = "createTime";
    public static String PROP_REPORT_CODE = "reportCode";
    public static String PROP_ORGAN_NAME = "organName";
    public static String PROP_ORGAN_CREDIT_CODE= "organCreditCode";
    public static String PROP_LOAN_CARD_NO= "loanCardNo";
    public static String PROP_QUERY_REASON = "queryReason";
    public static String PROP_QUERY_REASON_CODE = "queryReasonCode";
    public static String PROP_QUERIER = "querier";
    public static String PROP_QUERIER_CODE = "querierCode";
    public static String PROP_QUERIER_NAME = "querierName";
    public static String PROP_REPORT_DATE = "reportDate";
    public static String PROP_EXCHANGE_RATE = "exchangeRate";
    public static String PROP_RPT_KEY = "rptKey";

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.String id;
    private java.util.Date createTime;
	private java.lang.String reportCode;
	private java.lang.String organName;
	private java.lang.String organCreditCode;
	private java.lang.String loanCardNo ;
	private java.lang.String queryReason;
	private java.lang.String queryReasonCode;
	private java.lang.String querier;
	private java.lang.String querierCode;
	private java.lang.String querierName;
	private java.util.Date reportDate;
	private java.lang.String exchangeRate;
	private java.lang.String rptKey;
	
	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}
	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}
	public java.lang.String getRptKey() {
		return rptKey;
	}
	public void setRptKey(java.lang.String rptKey) {
		this.rptKey = rptKey;
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
	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}
	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}
	public static String getPROP_REPORT_CODE() {
		return PROP_REPORT_CODE;
	}
	public static void setPROP_REPORT_CODE(String pROP_REPORT_CODE) {
		PROP_REPORT_CODE = pROP_REPORT_CODE;
	}
	public static String getPROP_ORGAN_NAME() {
		return PROP_ORGAN_NAME;
	}
	public static void setPROP_ORGAN_NAME(String pROP_ORGAN_NAME) {
		PROP_ORGAN_NAME = pROP_ORGAN_NAME;
	}
	public static String getPROP_ORGAN_CREDIT_CODE() {
		return PROP_ORGAN_CREDIT_CODE;
	}
	public static void setPROP_ORGAN_CREDIT_CODE(String pROP_ORGAN_CREDIT_CODE) {
		PROP_ORGAN_CREDIT_CODE = pROP_ORGAN_CREDIT_CODE;
	}
	public static String getPROP_LOAN_CARD_NO() {
		return PROP_LOAN_CARD_NO;
	}
	public static void setPROP_LOAN_CARD_NO(String pROP_LOAN_CARD_NO) {
		PROP_LOAN_CARD_NO = pROP_LOAN_CARD_NO;
	}
	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}
	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
	}
	public static String getPROP_QUERY_REASON_CODE() {
		return PROP_QUERY_REASON_CODE;
	}
	public static void setPROP_QUERY_REASON_CODE(String pROP_QUERY_REASON_CODE) {
		PROP_QUERY_REASON_CODE = pROP_QUERY_REASON_CODE;
	}
	public static String getPROP_QUERIER() {
		return PROP_QUERIER;
	}
	public static void setPROP_QUERIER(String pROP_QUERIER) {
		PROP_QUERIER = pROP_QUERIER;
	}
	public static String getPROP_QUERIER_CODE() {
		return PROP_QUERIER_CODE;
	}
	public static void setPROP_QUERIER_CODE(String pROP_QUERIER_CODE) {
		PROP_QUERIER_CODE = pROP_QUERIER_CODE;
	}
	public static String getPROP_QUERIER_NAME() {
		return PROP_QUERIER_NAME;
	}
	public static void setPROP_QUERIER_NAME(String pROP_QUERIER_NAME) {
		PROP_QUERIER_NAME = pROP_QUERIER_NAME;
	}
	public static String getPROP_REPORT_DATE() {
		return PROP_REPORT_DATE;
	}
	public static void setPROP_REPORT_DATE(String pROP_REPORT_DATE) {
		PROP_REPORT_DATE = pROP_REPORT_DATE;
	}
	public static String getPROP_EXCHANGE_RATE() {
		return PROP_EXCHANGE_RATE;
	}
	public static void setPROP_EXCHANGE_RATE(String pROP_EXCHANGE_RATE) {
		PROP_EXCHANGE_RATE = pROP_EXCHANGE_RATE;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getReportCode() {
		return reportCode;
	}
	public void setReportCode(java.lang.String reportCode) {
		this.reportCode = reportCode;
	}
	public java.lang.String getOrganName() {
		return organName;
	}
	public void setOrganName(java.lang.String organName) {
		this.organName = organName;
	}
	public java.lang.String getOrganCreditCode() {
		return organCreditCode;
	}
	public void setOrganCreditCode(java.lang.String organCreditCode) {
		this.organCreditCode = organCreditCode;
	}
	public java.lang.String getLoanCardNo() {
		return loanCardNo;
	}
	public void setLoanCardNo(java.lang.String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}
	public java.lang.String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}
	public java.lang.String getQueryReasonCode() {
		return queryReasonCode;
	}
	public void setQueryReasonCode(java.lang.String queryReasonCode) {
		this.queryReasonCode = queryReasonCode;
	}
	public java.lang.String getQuerier() {
		return querier;
	}
	public void setQuerier(java.lang.String querier) {
		this.querier = querier;
	}
	public java.lang.String getQuerierCode() {
		return querierCode;
	}
	public void setQuerierCode(java.lang.String querierCode) {
		this.querierCode = querierCode;
	}
	public java.lang.String getQuerierName() {
		return querierName;
	}
	public void setQuerierName(java.lang.String querierName) {
		this.querierName = querierName;
	}
	public java.util.Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(java.util.Date reportDate) {
		this.reportDate = reportDate;
	}
	public java.lang.String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(java.lang.String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseTCorpReport [hashCode=" + hashCode + ", id=" + id
				+ ", createTime=" + createTime + ", reportCode=" + reportCode
				+ ", organName=" + organName + ", organCreditCode="
				+ organCreditCode + ", loanCardNo=" + loanCardNo
				+ ", queryReason=" + queryReason + ", queryReasonCode="
				+ queryReasonCode + ", querier=" + querier + ", querierCode="
				+ querierCode + ", querierName=" + querierName
				+ ", reportDate=" + reportDate + ", exchangeRate="
				+ exchangeRate + ", rptKey=" + rptKey + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loanCardNo == null) ? 0 : loanCardNo.hashCode());
		result = prime * result
				+ ((organCreditCode == null) ? 0 : organCreditCode.hashCode());
		result = prime * result
				+ ((organName == null) ? 0 : organName.hashCode());
		result = prime * result + ((querier == null) ? 0 : querier.hashCode());
		result = prime * result
				+ ((querierCode == null) ? 0 : querierCode.hashCode());
		result = prime * result
				+ ((querierName == null) ? 0 : querierName.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((queryReasonCode == null) ? 0 : queryReasonCode.hashCode());
		result = prime * result
				+ ((reportCode == null) ? 0 : reportCode.hashCode());
		result = prime * result
				+ ((reportDate == null) ? 0 : reportDate.hashCode());
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
		BaseTCorpReport other = (BaseTCorpReport) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loanCardNo == null) {
			if (other.loanCardNo != null)
				return false;
		} else if (!loanCardNo.equals(other.loanCardNo))
			return false;
		if (organCreditCode == null) {
			if (other.organCreditCode != null)
				return false;
		} else if (!organCreditCode.equals(other.organCreditCode))
			return false;
		if (organName == null) {
			if (other.organName != null)
				return false;
		} else if (!organName.equals(other.organName))
			return false;
		if (querier == null) {
			if (other.querier != null)
				return false;
		} else if (!querier.equals(other.querier))
			return false;
		if (querierCode == null) {
			if (other.querierCode != null)
				return false;
		} else if (!querierCode.equals(other.querierCode))
			return false;
		if (querierName == null) {
			if (other.querierName != null)
				return false;
		} else if (!querierName.equals(other.querierName))
			return false;
		if (queryReason == null) {
			if (other.queryReason != null)
				return false;
		} else if (!queryReason.equals(other.queryReason))
			return false;
		if (queryReasonCode == null) {
			if (other.queryReasonCode != null)
				return false;
		} else if (!queryReasonCode.equals(other.queryReasonCode))
			return false;
		if (reportCode == null) {
			if (other.reportCode != null)
				return false;
		} else if (!reportCode.equals(other.reportCode))
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTCorpReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BaseTCorpReport(int hashCode, String id, Date createTime,
			String reportCode, String organName, String organCreditCode,
			String loanCardNo, String queryReason, String queryReasonCode,
			String querier, String querierCode, String querierName,
			Date reportDate, String exchangeRate, String rptKey) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.createTime = createTime;
		this.reportCode = reportCode;
		this.organName = organName;
		this.organCreditCode = organCreditCode;
		this.loanCardNo = loanCardNo;
		this.queryReason = queryReason;
		this.queryReasonCode = queryReasonCode;
		this.querier = querier;
		this.querierCode = querierCode;
		this.querierName = querierName;
		this.reportDate = reportDate;
		this.exchangeRate = exchangeRate;
		this.rptKey = rptKey;
	}
	

	
}
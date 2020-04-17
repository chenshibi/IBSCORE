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

public abstract class BaseIndAssuranceDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndAssuranceDetail";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_ASSURANCE_ORG="assuranceOrg";
    public static String PROP_CONTRACT_AMOUNT="contractAmount";
    public static String PROP_ISSUE_DATE="issueDate";
    public static String PROP_END_DATE="endDate";
    public static String PROP_ASSURANCE_AMOUNT="assuranceAmount";
    public static String PROP_BALANCE="balance";
    public static String PROP_l5class="l5class";
    public static String PROP_YEARMONTH="yearmonth";
    public static String PROP_GET_DATE="getDate";
    public static String PROP_TYPE="type";


    public BaseIndAssuranceDetail() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String assuranceOrg;
    private java.lang.Float contractAmount;
    private java.util.Date issueDate;
    private java.util.Date endDate;
    private java.lang.Float assuranceAmount;
    private java.lang.Float balance;
    private java.lang.String l5class;
    private java.util.Date yearmonth;
    private java.util.Date getDate;
    private java.lang.String type;


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
	public static String getPROP_ASSURANCE_ORG() {
		return PROP_ASSURANCE_ORG;
	}
	public static void setPROP_ASSURANCE_ORG(String pROP_ASSURANCE_ORG) {
		PROP_ASSURANCE_ORG = pROP_ASSURANCE_ORG;
	}
	public static String getPROP_CONTRACT_AMOUNT() {
		return PROP_CONTRACT_AMOUNT;
	}
	public static void setPROP_CONTRACT_AMOUNT(String pROP_CONTRACT_AMOUNT) {
		PROP_CONTRACT_AMOUNT = pROP_CONTRACT_AMOUNT;
	}
	public static String getPROP_ISSUE_DATE() {
		return PROP_ISSUE_DATE;
	}
	public static void setPROP_ISSUE_DATE(String pROP_ISSUE_DATE) {
		PROP_ISSUE_DATE = pROP_ISSUE_DATE;
	}
	public static String getPROP_END_DATE() {
		return PROP_END_DATE;
	}
	public static void setPROP_END_DATE(String pROP_END_DATE) {
		PROP_END_DATE = pROP_END_DATE;
	}
	public static String getPROP_ASSURANCE_AMOUNT() {
		return PROP_ASSURANCE_AMOUNT;
	}
	public static void setPROP_ASSURANCE_AMOUNT(String pROP_ASSURANCE_AMOUNT) {
		PROP_ASSURANCE_AMOUNT = pROP_ASSURANCE_AMOUNT;
	}
	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}
	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}
	public static String getPROP_l5class() {
		return PROP_l5class;
	}
	public static void setPROP_l5class(String pROP_l5class) {
		PROP_l5class = pROP_l5class;
	}
	public static String getPROP_YEARMONTH() {
		return PROP_YEARMONTH;
	}
	public static void setPROP_YEARMONTH(String pROP_YEARMONTH) {
		PROP_YEARMONTH = pROP_YEARMONTH;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
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
	public java.lang.String getAssuranceOrg() {
		return assuranceOrg;
	}
	public void setAssuranceOrg(java.lang.String assuranceOrg) {
		this.assuranceOrg = assuranceOrg;
	}
	public java.lang.Float getContractAmount() {
		return contractAmount;
	}
	public void setContractAmount(java.lang.Float contractAmount) {
		this.contractAmount = contractAmount;
	}
	public java.util.Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
	}
	public java.util.Date getEndDate() {
		return endDate;
	}
	public void setEndDate(java.util.Date endDate) {
		this.endDate = endDate;
	}
	public java.lang.Float getAssuranceAmount() {
		return assuranceAmount;
	}
	public void setAssuranceAmount(java.lang.Float assuranceAmount) {
		this.assuranceAmount = assuranceAmount;
	}
	public java.lang.Float getBalance() {
		return balance;
	}
	public void setBalance(java.lang.Float balance) {
		this.balance = balance;
	}
	public java.lang.String getL5class() {
		return l5class;
	}
	public void setL5class(java.lang.String l5class) {
		this.l5class = l5class;
	}
	public java.util.Date getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(java.util.Date yearmonth) {
		this.yearmonth = yearmonth;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assuranceAmount == null) ? 0 : assuranceAmount.hashCode());
		result = prime * result
				+ ((assuranceOrg == null) ? 0 : assuranceOrg.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((contractAmount == null) ? 0 : contractAmount.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + ((l5class == null) ? 0 : l5class.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
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
		BaseIndAssuranceDetail other = (BaseIndAssuranceDetail) obj;
		if (assuranceAmount == null) {
			if (other.assuranceAmount != null)
				return false;
		} else if (!assuranceAmount.equals(other.assuranceAmount))
			return false;
		if (assuranceOrg == null) {
			if (other.assuranceOrg != null)
				return false;
		} else if (!assuranceOrg.equals(other.assuranceOrg))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (contractAmount == null) {
			if (other.contractAmount != null)
				return false;
		} else if (!contractAmount.equals(other.contractAmount))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
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
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		if (l5class == null) {
			if (other.l5class != null)
				return false;
		} else if (!l5class.equals(other.l5class))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
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
	public BaseIndAssuranceDetail(Integer id, String rptId, Integer no,
			String assuranceOrg, Float contractAmount, Date issueDate,
			Date endDate, Float assuranceAmount, Float balance, String l5class,
			Date yearmonth, Date getDate, String type) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.assuranceOrg = assuranceOrg;
		this.contractAmount = contractAmount;
		this.issueDate = issueDate;
		this.endDate = endDate;
		this.assuranceAmount = assuranceAmount;
		this.balance = balance;
		this.l5class = l5class;
		this.yearmonth = yearmonth;
		this.getDate = getDate;
		this.type = type;
	}

    
	
    
    
  
}
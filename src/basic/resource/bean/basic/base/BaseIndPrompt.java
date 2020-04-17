package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseIndPrompt  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndPrompt";
	public static String PROP_ID= "id";
    public static String PROP_RPTID= "RptId"; 
    public static String PROP_HOUSE_LOAN = "houseLoan"; 
    public static String PROP_OTHER_LOAN="otherLoan";
    public static String PROP_FIRST_LOAN_ISSUE_DATE="firstLoanIssueDate";
    public static String PROP_FIRST_CC_ISSUE_DATE="firstCcIssueDate";
    public static String PROP_FIRST_PDC_ISSUE_DATE="firstPdcIssueDate";
    public static String PROP_SELF_STATEMENT_COUNT="selfStatementCount";
    public static String PROP_DISSENT_COUNT="dissentCount";
    public static String PROP_CRD_ACCOUNT="crdAccount";
    public static String PROP_PDC_ACCOUNT="pdcAccount";
    public static String PROP_GET_DATE="getDate";
    public static String PROP_PERSON_HOUSE_LOAN="personHouseLoan";
    public static String PROP_PERSON_BIZ_HOUSE_LOAN="personBizHouseLoan";
    


	protected void initialize() {
    }
	
	private int hashCode = Integer.MIN_VALUE;
	
	private java.lang.Integer id;
	 private java.lang.String RptId;
	 private java.lang.Integer personHouseLoan;
	 private java.lang.Integer personBizHouseLoan;
	 private java.lang.Integer houseLoan;
	 private java.lang.Integer otherLoan;
	 private java.util.Date firstLoanIssueDate;
	 private java.util.Date firstCcIssueDate;
	 private java.util.Date firstPdcIssueDate;
	 private java.lang.Integer selfStatementCount;
	 private java.lang.Integer dissentCount;
	 private java.lang.Integer crdAccount;
	 private java.lang.Integer pdcAccount;
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
	public static String getPROP_RPTID() {
		return PROP_RPTID;
	}
	public static void setPROP_RPTID(String pROP_RPTID) {
		PROP_RPTID = pROP_RPTID;
	}
	public static String getPROP_HOUSE_LOAN() {
		return PROP_HOUSE_LOAN;
	}
	public static void setPROP_HOUSE_LOAN(String pROP_HOUSE_LOAN) {
		PROP_HOUSE_LOAN = pROP_HOUSE_LOAN;
	}
	public static String getPROP_OTHER_LOAN() {
		return PROP_OTHER_LOAN;
	}
	public static void setPROP_OTHER_LOAN(String pROP_OTHER_LOAN) {
		PROP_OTHER_LOAN = pROP_OTHER_LOAN;
	}
	public static String getPROP_FIRST_LOAN_ISSUE_DATE() {
		return PROP_FIRST_LOAN_ISSUE_DATE;
	}
	public static void setPROP_FIRST_LOAN_ISSUE_DATE(
			String pROP_FIRST_LOAN_ISSUE_DATE) {
		PROP_FIRST_LOAN_ISSUE_DATE = pROP_FIRST_LOAN_ISSUE_DATE;
	}
	public static String getPROP_FIRST_CC_ISSUE_DATE() {
		return PROP_FIRST_CC_ISSUE_DATE;
	}
	public static void setPROP_FIRST_CC_ISSUE_DATE(String pROP_FIRST_CC_ISSUE_DATE) {
		PROP_FIRST_CC_ISSUE_DATE = pROP_FIRST_CC_ISSUE_DATE;
	}
	public static String getPROP_FIRST_PDC_ISSUE_DATE() {
		return PROP_FIRST_PDC_ISSUE_DATE;
	}
	public static void setPROP_FIRST_PDC_ISSUE_DATE(String pROP_FIRST_PDC_ISSUE_DATE) {
		PROP_FIRST_PDC_ISSUE_DATE = pROP_FIRST_PDC_ISSUE_DATE;
	}
	public static String getPROP_SELF_STATEMENT_COUNT() {
		return PROP_SELF_STATEMENT_COUNT;
	}
	public static void setPROP_SELF_STATEMENT_COUNT(String pROP_SELF_STATEMENT_COUNT) {
		PROP_SELF_STATEMENT_COUNT = pROP_SELF_STATEMENT_COUNT;
	}
	public static String getPROP_DISSENT_COUNT() {
		return PROP_DISSENT_COUNT;
	}
	public static void setPROP_DISSENT_COUNT(String pROP_DISSENT_COUNT) {
		PROP_DISSENT_COUNT = pROP_DISSENT_COUNT;
	}
	public static String getPROP_CRD_ACCOUNT() {
		return PROP_CRD_ACCOUNT;
	}
	public static void setPROP_CRD_ACCOUNT(String pROP_CRD_ACCOUNT) {
		PROP_CRD_ACCOUNT = pROP_CRD_ACCOUNT;
	}
	public static String getPROP_PDC_ACCOUNT() {
		return PROP_PDC_ACCOUNT;
	}
	public static void setPROP_PDC_ACCOUNT(String pROP_PDC_ACCOUNT) {
		PROP_PDC_ACCOUNT = pROP_PDC_ACCOUNT;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
	}
	public static String getPROP_PERSON_HOUSE_LOAN() {
		return PROP_PERSON_HOUSE_LOAN;
	}
	public static void setPROP_PERSON_HOUSE_LOAN(String pROP_PERSON_HOUSE_LOAN) {
		PROP_PERSON_HOUSE_LOAN = pROP_PERSON_HOUSE_LOAN;
	}
	public static String getPROP_PERSON_BIZ_HOUSE_LOAN() {
		return PROP_PERSON_BIZ_HOUSE_LOAN;
	}
	public static void setPROP_PERSON_BIZ_HOUSE_LOAN(
			String pROP_PERSON_BIZ_HOUSE_LOAN) {
		PROP_PERSON_BIZ_HOUSE_LOAN = pROP_PERSON_BIZ_HOUSE_LOAN;
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
	public java.lang.String getRptId() {
		return RptId;
	}
	public void setRptId(java.lang.String rptId) {
		RptId = rptId;
	}
	public java.lang.Integer getPersonHouseLoan() {
		return personHouseLoan;
	}
	public void setPersonHouseLoan(java.lang.Integer personHouseLoan) {
		this.personHouseLoan = personHouseLoan;
	}
	public java.lang.Integer getPersonBizHouseLoan() {
		return personBizHouseLoan;
	}
	public void setPersonBizHouseLoan(java.lang.Integer personBizHouseLoan) {
		this.personBizHouseLoan = personBizHouseLoan;
	}
	public java.lang.Integer getHouseLoan() {
		return houseLoan;
	}
	public void setHouseLoan(java.lang.Integer houseLoan) {
		this.houseLoan = houseLoan;
	}
	public java.lang.Integer getOtherLoan() {
		return otherLoan;
	}
	public void setOtherLoan(java.lang.Integer otherLoan) {
		this.otherLoan = otherLoan;
	}
	public java.util.Date getFirstLoanIssueDate() {
		return firstLoanIssueDate;
	}
	public void setFirstLoanIssueDate(java.util.Date firstLoanIssueDate) {
		this.firstLoanIssueDate = firstLoanIssueDate;
	}
	public java.util.Date getFirstCcIssueDate() {
		return firstCcIssueDate;
	}
	public void setFirstCcIssueDate(java.util.Date firstCcIssueDate) {
		this.firstCcIssueDate = firstCcIssueDate;
	}
	public java.util.Date getFirstPdcIssueDate() {
		return firstPdcIssueDate;
	}
	public void setFirstPdcIssueDate(java.util.Date firstPdcIssueDate) {
		this.firstPdcIssueDate = firstPdcIssueDate;
	}
	public java.lang.Integer getSelfStatementCount() {
		return selfStatementCount;
	}
	public void setSelfStatementCount(java.lang.Integer selfStatementCount) {
		this.selfStatementCount = selfStatementCount;
	}
	public java.lang.Integer getDissentCount() {
		return dissentCount;
	}
	public void setDissentCount(java.lang.Integer dissentCount) {
		this.dissentCount = dissentCount;
	}
	public java.lang.Integer getCrdAccount() {
		return crdAccount;
	}
	public void setCrdAccount(java.lang.Integer crdAccount) {
		this.crdAccount = crdAccount;
	}
	public java.lang.Integer getPdcAccount() {
		return pdcAccount;
	}
	public void setPdcAccount(java.lang.Integer pdcAccount) {
		this.pdcAccount = pdcAccount;
	}
	public Date getGetDate() {
		return getDate;
	}
	public void setGetDate(Date getDate) {
		this.getDate = getDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RptId == null) ? 0 : RptId.hashCode());
		result = prime * result
				+ ((crdAccount == null) ? 0 : crdAccount.hashCode());
		result = prime * result
				+ ((dissentCount == null) ? 0 : dissentCount.hashCode());
		result = prime
				* result
				+ ((firstCcIssueDate == null) ? 0 : firstCcIssueDate.hashCode());
		result = prime
				* result
				+ ((firstLoanIssueDate == null) ? 0 : firstLoanIssueDate
						.hashCode());
		result = prime
				* result
				+ ((firstPdcIssueDate == null) ? 0 : firstPdcIssueDate
						.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + hashCode;
		result = prime * result
				+ ((houseLoan == null) ? 0 : houseLoan.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((otherLoan == null) ? 0 : otherLoan.hashCode());
		result = prime * result
				+ ((pdcAccount == null) ? 0 : pdcAccount.hashCode());
		result = prime
				* result
				+ ((personBizHouseLoan == null) ? 0 : personBizHouseLoan
						.hashCode());
		result = prime * result
				+ ((personHouseLoan == null) ? 0 : personHouseLoan.hashCode());
		result = prime
				* result
				+ ((selfStatementCount == null) ? 0 : selfStatementCount
						.hashCode());
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
		BaseIndPrompt other = (BaseIndPrompt) obj;
		if (RptId == null) {
			if (other.RptId != null)
				return false;
		} else if (!RptId.equals(other.RptId))
			return false;
		if (crdAccount == null) {
			if (other.crdAccount != null)
				return false;
		} else if (!crdAccount.equals(other.crdAccount))
			return false;
		if (dissentCount == null) {
			if (other.dissentCount != null)
				return false;
		} else if (!dissentCount.equals(other.dissentCount))
			return false;
		if (firstCcIssueDate == null) {
			if (other.firstCcIssueDate != null)
				return false;
		} else if (!firstCcIssueDate.equals(other.firstCcIssueDate))
			return false;
		if (firstLoanIssueDate == null) {
			if (other.firstLoanIssueDate != null)
				return false;
		} else if (!firstLoanIssueDate.equals(other.firstLoanIssueDate))
			return false;
		if (firstPdcIssueDate == null) {
			if (other.firstPdcIssueDate != null)
				return false;
		} else if (!firstPdcIssueDate.equals(other.firstPdcIssueDate))
			return false;
		if (getDate == null) {
			if (other.getDate != null)
				return false;
		} else if (!getDate.equals(other.getDate))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (houseLoan == null) {
			if (other.houseLoan != null)
				return false;
		} else if (!houseLoan.equals(other.houseLoan))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (otherLoan == null) {
			if (other.otherLoan != null)
				return false;
		} else if (!otherLoan.equals(other.otherLoan))
			return false;
		if (pdcAccount == null) {
			if (other.pdcAccount != null)
				return false;
		} else if (!pdcAccount.equals(other.pdcAccount))
			return false;
		if (personBizHouseLoan == null) {
			if (other.personBizHouseLoan != null)
				return false;
		} else if (!personBizHouseLoan.equals(other.personBizHouseLoan))
			return false;
		if (personHouseLoan == null) {
			if (other.personHouseLoan != null)
				return false;
		} else if (!personHouseLoan.equals(other.personHouseLoan))
			return false;
		if (selfStatementCount == null) {
			if (other.selfStatementCount != null)
				return false;
		} else if (!selfStatementCount.equals(other.selfStatementCount))
			return false;
		return true;
	}
	public BaseIndPrompt(int hashCode, Integer id, String rptId,
			Integer personHouseLoan, Integer personBizHouseLoan,
			Integer houseLoan, Integer otherLoan, Date firstLoanIssueDate,
			Date firstCcIssueDate, Date firstPdcIssueDate,
			Integer selfStatementCount, Integer dissentCount,
			Integer crdAccount, Integer pdcAccount, Date getDate) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		RptId = rptId;
		this.personHouseLoan = personHouseLoan;
		this.personBizHouseLoan = personBizHouseLoan;
		this.houseLoan = houseLoan;
		this.otherLoan = otherLoan;
		this.firstLoanIssueDate = firstLoanIssueDate;
		this.firstCcIssueDate = firstCcIssueDate;
		this.firstPdcIssueDate = firstPdcIssueDate;
		this.selfStatementCount = selfStatementCount;
		this.dissentCount = dissentCount;
		this.crdAccount = crdAccount;
		this.pdcAccount = pdcAccount;
		this.getDate = getDate;
	}
	public BaseIndPrompt() {
		super();
		// TODO Auto-generated constructor stub
	}

	 

	
	 
	 


	 


	 

	 
	 

}

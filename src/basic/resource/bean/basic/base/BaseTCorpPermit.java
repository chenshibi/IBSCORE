package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.TlrLoginLog;

/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="T_Corp_App"
 */

public abstract class BaseTCorpPermit implements Serializable {

    public static String getPROP_APPROVE_TIME() {
		return PROP_APPROVE_TIME;
	}
	public static void setPROP_APPROVE_TIME(String pROP_APPROVE_TIME) {
		PROP_APPROVE_TIME = pROP_APPROVE_TIME;
	}
	public java.util.Date getApproveTime() {
		return approveTime;
	}
	public void setApproveTime(java.util.Date approveTime) {
		this.approveTime = approveTime;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -799113293960017264L;
	public static String REF = "TCorpPermit";
	public static String PROP_ID= "id"; 
    public static String PROP_LOAN_CARD_NO= "loanCardNo"; 
    public static String PROP_LOAN_CARD_PASS = "loanCardPass"; 
    public static String PROP_ENTERPRISE_REG_ID="enterpriseRegId";
    public static String PROP_CORP_NAME="corpName";
    public static String PROP_CUSTOMER_CON_UP="customerConUp";
    public static String PROP_CUSTOMER_CON_UP2="customerConUp2";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_EXPIRE_DATE="expireDate";
    public static String PROP_STATUS="status";
    public static String PROP_APPROVE_TIME="approveTime";
    
    // constructors
   public BaseTCorpPermit(){
	   initialize();
   }
	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;


    // primary key
    private java.lang.Integer id;
    private java.lang.String loanCardNo;
    // fields
    private java.lang.String loanCardPass;
    private java.lang.String enterpriseRegId;
    private java.lang.String corpName;
    private java.lang.String customerConUp;
    private java.lang.String customerConUp2;
    private java.lang.String createUser;
    public  java.util.Date inputTime;
    private  java.util.Date expireDate;
    private  java.util.Date approveTime;
    private java.lang.String status;

	public BaseTCorpPermit(int hashCode, Integer id, String loanCardNo,
			String loanCardPass, String enterpriseRegId, String corpName,
			String customerConUp, String customerConUp2, String createUser,
			Date inputTime, Date expireDate, Date approveTime, String status) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.loanCardNo = loanCardNo;
		this.loanCardPass = loanCardPass;
		this.enterpriseRegId = enterpriseRegId;
		this.corpName = corpName;
		this.customerConUp = customerConUp;
		this.customerConUp2 = customerConUp2;
		this.createUser = createUser;
		this.inputTime = inputTime;
		this.expireDate = expireDate;
		this.approveTime = approveTime;
		this.status = status;
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
	public static String getPROP_LOAN_CARD_NO() {
		return PROP_LOAN_CARD_NO;
	}
	public static void setPROP_LOAN_CARD_NO(String pROP_LOAN_CARD_NO) {
		PROP_LOAN_CARD_NO = pROP_LOAN_CARD_NO;
	}
	public static String getPROP_LOAN_CARD_PASS() {
		return PROP_LOAN_CARD_PASS;
	}
	public static void setPROP_LOAN_CARD_PASS(String pROP_LOAN_CARD_PASS) {
		PROP_LOAN_CARD_PASS = pROP_LOAN_CARD_PASS;
	}
	public static String getPROP_ENTERPRISE_REG_ID() {
		return PROP_ENTERPRISE_REG_ID;
	}
	public static void setPROP_ENTERPRISE_REG_ID(String pROP_ENTERPRISE_REG_ID) {
		PROP_ENTERPRISE_REG_ID = pROP_ENTERPRISE_REG_ID;
	}
	public static String getPROP_CORP_NAME() {
		return PROP_CORP_NAME;
	}
	public static void setPROP_CORP_NAME(String pROP_CORP_NAME) {
		PROP_CORP_NAME = pROP_CORP_NAME;
	}
	public static String getPROP_CUSTOMER_CON_UP() {
		return PROP_CUSTOMER_CON_UP;
	}
	public static void setPROP_CUSTOMER_CON_UP(String pROP_CUSTOMER_CON_UP) {
		PROP_CUSTOMER_CON_UP = pROP_CUSTOMER_CON_UP;
	}
	public static String getPROP_CUSTOMER_CON_UP2() {
		return PROP_CUSTOMER_CON_UP2;
	}
	public static void setPROP_CUSTOMER_CON_UP2(String pROP_CUSTOMER_CON_UP2) {
		PROP_CUSTOMER_CON_UP2 = pROP_CUSTOMER_CON_UP2;
	}
	public static String getPROP_CREATE_USER() {
		return PROP_CREATE_USER;
	}
	public static void setPROP_CREATE_USER(String pROP_CREATE_USER) {
		PROP_CREATE_USER = pROP_CREATE_USER;
	}
	public static String getPROP_INPUT_TIME() {
		return PROP_INPUT_TIME;
	}
	public static void setPROP_INPUT_TIME(String pROP_INPUT_TIME) {
		PROP_INPUT_TIME = pROP_INPUT_TIME;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
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
	public java.lang.String getLoanCardNo() {
		return loanCardNo;
	}
	public void setLoanCardNo(java.lang.String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}
	public java.lang.String getLoanCardPass() {
		return loanCardPass;
	}
	public void setLoanCardPass(java.lang.String loanCardPass) {
		this.loanCardPass = loanCardPass;
	}
	public java.lang.String getEnterpriseRegId() {
		return enterpriseRegId;
	}
	public void setEnterpriseRegId(java.lang.String enterpriseRegId) {
		this.enterpriseRegId = enterpriseRegId;
	}
	public java.lang.String getCorpName() {
		return corpName;
	}
	public void setCorpName(java.lang.String corpName) {
		this.corpName = corpName;
	}
	public java.lang.String getCustomerConUp() {
		return customerConUp;
	}
	public void setCustomerConUp(java.lang.String customerConUp) {
		this.customerConUp = customerConUp;
	}
	public java.lang.String getCustomerConUp2() {
		return customerConUp2;
	}
	public void setCustomerConUp2(java.lang.String customerConUp2) {
		this.customerConUp2 = customerConUp2;
	}
	public java.lang.String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}
	public java.util.Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(java.util.Date inputTime) {
		this.inputTime = inputTime;
	}
	public java.util.Date getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.util.Date expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseTCorpPermit [hashCode=" + hashCode + ", id=" + id
				+ ", loanCardNo=" + loanCardNo + ", loanCardPass="
				+ loanCardPass + ", enterpriseRegId=" + enterpriseRegId
				+ ", corpName=" + corpName + ", customerConUp=" + customerConUp
				+ ", customerConUp2=" + customerConUp2 + ", createUser="
				+ createUser + ", inputTime=" + inputTime + ", expireDate="
				+ expireDate + ", approveTime=" + approveTime + ", status="
				+ status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approveTime == null) ? 0 : approveTime.hashCode());
		result = prime * result
				+ ((corpName == null) ? 0 : corpName.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((customerConUp == null) ? 0 : customerConUp.hashCode());
		result = prime * result
				+ ((customerConUp2 == null) ? 0 : customerConUp2.hashCode());
		result = prime * result
				+ ((enterpriseRegId == null) ? 0 : enterpriseRegId.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((loanCardNo == null) ? 0 : loanCardNo.hashCode());
		result = prime * result
				+ ((loanCardPass == null) ? 0 : loanCardPass.hashCode());
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
		BaseTCorpPermit other = (BaseTCorpPermit) obj;
		if (approveTime == null) {
			if (other.approveTime != null)
				return false;
		} else if (!approveTime.equals(other.approveTime))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (customerConUp == null) {
			if (other.customerConUp != null)
				return false;
		} else if (!customerConUp.equals(other.customerConUp))
			return false;
		if (customerConUp2 == null) {
			if (other.customerConUp2 != null)
				return false;
		} else if (!customerConUp2.equals(other.customerConUp2))
			return false;
		if (enterpriseRegId == null) {
			if (other.enterpriseRegId != null)
				return false;
		} else if (!enterpriseRegId.equals(other.enterpriseRegId))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inputTime == null) {
			if (other.inputTime != null)
				return false;
		} else if (!inputTime.equals(other.inputTime))
			return false;
		if (loanCardNo == null) {
			if (other.loanCardNo != null)
				return false;
		} else if (!loanCardNo.equals(other.loanCardNo))
			return false;
		if (loanCardPass == null) {
			if (other.loanCardPass != null)
				return false;
		} else if (!loanCardPass.equals(other.loanCardPass))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

    
    
}
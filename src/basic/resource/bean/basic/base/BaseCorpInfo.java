package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.Bctl;


public abstract class BaseCorpInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7710043025247793715L;
	/**
     * 
     */
    public static String REF = "CorpInfo";
    public static String PROP_LOAN_CARD_ID = "LoanCardId";
    public static String PROP_LOAN_CARD_PWD = "LoanCardPwd";
    public static String PROP_ENTERPRISE_REG_ID = "EnterpriseRegId";
    public static String PROP_CORP_NAME= "CorpName";
    public static String PROP_CUSTOMER_UPLOAD= "CustomerUpload";
    public static String PROP_EXPIRE_DATE = "ExpireDate";
    

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key

    private String LoanCardId;
    
    private String LoanCardPwd;
    private String EnterpriseRegId;
    private String CorpName;
    private String CustomerUpload;
    private String ExpireDate;

    public BaseCorpInfo(java.lang.String loanCardId) {
        this.setLoanCardId(loanCardId);
        initialize();
    }

	public static String getREF() {
		return REF;
	}
	public static void setREF(String rEF) {
		REF = rEF;
	}
	public static String getPROP_LOAN_CARD_ID() {
		return PROP_LOAN_CARD_ID;
	}
	public static void setPROP_LOAN_CARD_ID(String pROP_LOAN_CARD_ID) {
		PROP_LOAN_CARD_ID = pROP_LOAN_CARD_ID;
	}
	public static String getPROP_LOAN_CARD_PWD() {
		return PROP_LOAN_CARD_PWD;
	}
	public static void setPROP_LOAN_CARD_PWD(String pROP_LOAN_CARD_PWD) {
		PROP_LOAN_CARD_PWD = pROP_LOAN_CARD_PWD;
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
	public static String getPROP_CUSTOMER_UPLOAD() {
		return PROP_CUSTOMER_UPLOAD;
	}
	public static void setPROP_CUSTOMER_UPLOAD(String pROP_CUSTOMER_UPLOAD) {
		PROP_CUSTOMER_UPLOAD = pROP_CUSTOMER_UPLOAD;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public int getHashCode() {
		return hashCode;
	}
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}
	public String getLoanCardId() {
		return LoanCardId;
	}
	public void setLoanCardId(String loanCardId) {
		LoanCardId = loanCardId;
	}
	public String getLoanCardPwd() {
		return LoanCardPwd;
	}
	public void setLoanCardPwd(String loanCardPwd) {
		LoanCardPwd = loanCardPwd;
	}
	public String getEnterpriseRegId() {
		return EnterpriseRegId;
	}
	public void setEnterpriseRegId(String enterpriseRegId) {
		EnterpriseRegId = enterpriseRegId;
	}
	public String getCorpName() {
		return CorpName;
	}
	public void setCorpName(String corpName) {
		CorpName = corpName;
	}
	public String getCustomerUpload() {
		return CustomerUpload;
	}
	public void setCustomerUpload(String customerUpload) {
		CustomerUpload = customerUpload;
	}
	public String getExpireDate() {
		return ExpireDate;
	}
	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BaseCorpInfo(int hashCode, String loanCardId, String loanCardPwd,
			String enterpriseRegId, String corpName, String customerUpload,
			String expireDate) {
		super();
		this.hashCode = hashCode;
		LoanCardId = loanCardId;
		LoanCardPwd = loanCardPwd;
		EnterpriseRegId = enterpriseRegId;
		CorpName = corpName;
		CustomerUpload = customerUpload;
		ExpireDate = expireDate;
	}
	public BaseCorpInfo() {
		initialize();
	}
    
    
}
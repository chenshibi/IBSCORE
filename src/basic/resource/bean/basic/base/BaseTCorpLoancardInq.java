package resource.bean.basic.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_loancard_inq"
 */

public abstract class BaseTCorpLoancardInq implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2499051313800096800L;
	public static String REF = "TCorpLoancardInq";
    public static String PROP_ID="id";
    public static String PROP_PW_ID="pwid";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_ORG_CREDIT_CODE="inquiryType";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_REGION_TAX_CODE="inquiryValue";
	public static String PROP_STATUS="status";
	 public static String PROP_CREATE_USER_IP="createUserIp";

	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String pwid;
    private java.lang.String inquiryValue;
    private java.lang.String inquiryType;
    private java.lang.String queryReason;
    private Date inputTime;
    private java.lang.String status;
    private java.lang.String createUserIp;

	public BaseTCorpLoancardInq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseTCorpLoancardInq(int hashCode, Integer id, String pwid,
			String inquiryValue, String inquiryType, String queryReason,
			Date inputTime, String status, String createUserIp) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.pwid = pwid;
		this.inquiryValue = inquiryValue;
		this.inquiryType = inquiryType;
		this.queryReason = queryReason;
		this.inputTime = inputTime;
		this.status = status;
		this.createUserIp = createUserIp;
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

	public static String getPROP_PW_ID() {
		return PROP_PW_ID;
	}

	public static void setPROP_PW_ID(String pROP_PW_ID) {
		PROP_PW_ID = pROP_PW_ID;
	}

	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}

	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
	}

	public static String getPROP_ORG_CREDIT_CODE() {
		return PROP_ORG_CREDIT_CODE;
	}

	public static void setPROP_ORG_CREDIT_CODE(String pROP_ORG_CREDIT_CODE) {
		PROP_ORG_CREDIT_CODE = pROP_ORG_CREDIT_CODE;
	}

	public static String getPROP_INPUT_TIME() {
		return PROP_INPUT_TIME;
	}

	public static void setPROP_INPUT_TIME(String pROP_INPUT_TIME) {
		PROP_INPUT_TIME = pROP_INPUT_TIME;
	}

	public static String getPROP_REGION_TAX_CODE() {
		return PROP_REGION_TAX_CODE;
	}

	public static void setPROP_REGION_TAX_CODE(String pROP_REGION_TAX_CODE) {
		PROP_REGION_TAX_CODE = pROP_REGION_TAX_CODE;
	}

	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}

	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}

	public static String getPROP_CREATE_USER_IP() {
		return PROP_CREATE_USER_IP;
	}

	public static void setPROP_CREATE_USER_IP(String pROP_CREATE_USER_IP) {
		PROP_CREATE_USER_IP = pROP_CREATE_USER_IP;
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

	public java.lang.String getPwid() {
		return pwid;
	}

	public void setPwid(java.lang.String pwid) {
		this.pwid = pwid;
	}

	public java.lang.String getInquiryValue() {
		return inquiryValue;
	}

	public void setInquiryValue(java.lang.String inquiryValue) {
		this.inquiryValue = inquiryValue;
	}

	public java.lang.String getInquiryType() {
		return inquiryType;
	}

	public void setInquiryType(java.lang.String inquiryType) {
		this.inquiryType = inquiryType;
	}

	public java.lang.String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}
    
	public java.util.Date getInputTime() {
		return inputTime;
	}
    
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getCreateUserIp() {
		return createUserIp;
	}

	public void setCreateUserIp(java.lang.String createUserIp) {
		this.createUserIp = createUserIp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createUserIp == null) ? 0 : createUserIp.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((inquiryType == null) ? 0 : inquiryType.hashCode());
		result = prime * result
				+ ((inquiryValue == null) ? 0 : inquiryValue.hashCode());
		result = prime * result + ((pwid == null) ? 0 : pwid.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
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
		BaseTCorpLoancardInq other = (BaseTCorpLoancardInq) obj;
		if (createUserIp == null) {
			if (other.createUserIp != null)
				return false;
		} else if (!createUserIp.equals(other.createUserIp))
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
		if (inquiryType == null) {
			if (other.inquiryType != null)
				return false;
		} else if (!inquiryType.equals(other.inquiryType))
			return false;
		if (inquiryValue == null) {
			if (other.inquiryValue != null)
				return false;
		} else if (!inquiryValue.equals(other.inquiryValue))
			return false;
		if (pwid == null) {
			if (other.pwid != null)
				return false;
		} else if (!pwid.equals(other.pwid))
			return false;
		if (queryReason == null) {
			if (other.queryReason != null)
				return false;
		} else if (!queryReason.equals(other.queryReason))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseTCorpLoancardInq [hashCode=" + hashCode + ", id=" + id
				+ ", pwid=" + pwid + ", inquiryValue=" + inquiryValue
				+ ", inquiryType=" + inquiryType + ", queryReason="
				+ queryReason + ", inputTime=" + inputTime + ", status="
				+ status + ", createUserIp=" + createUserIp + "]";
	}

	
    
    
}
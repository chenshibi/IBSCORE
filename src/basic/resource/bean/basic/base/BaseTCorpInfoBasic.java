package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpInfoBasic implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 887494355297202088L;
	public static String REF = "TCorpInfoBasic";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_NAME="name";
    public static String PROP_ADDRESS="address";
    public static String PROP_REG_ORGAN_TYPE="regOrganType";
    public static String PROP_LOANCARD_ID="loancardId";
    public static String PROP_REG_ORGAN_NO="regOrganNo";
    public static String PROP_REG_ORGAN_CODE="regOrganCode";
    public static String PROP_REG_DATE="regDate";
    public static String PROP_REG_END_DATE="regEndDate";
    public static String PROP_REG_STATE_TAX_NO="regStateTaxNo";
	public static String PROP_REG_LOCAL_TAX_NO="regLocalTaxNo";
	public static String PROP_LOAN_CARD_STATUS="loanCardStatus";
	public static String PROP_LAST_AUDIT_DATE="lastAuditDate";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String name;
    private java.lang.String address;
    private java.lang.String regOrganType;
    private java.lang.String loancardId;
    private java.lang.String regOrganNo;
    private java.lang.String regOrganCode;
    private java.lang.String regDate;
    private java.lang.String regEndDate;
    private java.lang.String regStateTaxNo;
    private java.lang.String regLocalTaxNo;
    private java.lang.String loanCardStatus;
    private java.lang.String lastAuditDate;

    

	public BaseTCorpInfoBasic() {
		super();
	}



	public BaseTCorpInfoBasic(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String address, String regOrganType,
			String loancardId, String regOrganNo, String regOrganCode,
			String regDate, String regEndDate, String regStateTaxNo,
			String regLocalTaxNo, String loanCardStatus, String lastAuditDate) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.name = name;
		this.address = address;
		this.regOrganType = regOrganType;
		this.loancardId = loancardId;
		this.regOrganNo = regOrganNo;
		this.regOrganCode = regOrganCode;
		this.regDate = regDate;
		this.regEndDate = regEndDate;
		this.regStateTaxNo = regStateTaxNo;
		this.regLocalTaxNo = regLocalTaxNo;
		this.loanCardStatus = loanCardStatus;
		this.lastAuditDate = lastAuditDate;
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



	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}



	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}



	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}



	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}



	public static String getPROP_NAME() {
		return PROP_NAME;
	}



	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}



	public static String getPROP_ADDRESS() {
		return PROP_ADDRESS;
	}



	public static void setPROP_ADDRESS(String pROP_ADDRESS) {
		PROP_ADDRESS = pROP_ADDRESS;
	}



	public static String getPROP_REG_ORGAN_TYPE() {
		return PROP_REG_ORGAN_TYPE;
	}



	public static void setPROP_REG_ORGAN_TYPE(String pROP_REG_ORGAN_TYPE) {
		PROP_REG_ORGAN_TYPE = pROP_REG_ORGAN_TYPE;
	}



	public static String getPROP_LOANCARD_ID() {
		return PROP_LOANCARD_ID;
	}



	public static void setPROP_LOANCARD_ID(String pROP_LOANCARD_ID) {
		PROP_LOANCARD_ID = pROP_LOANCARD_ID;
	}



	public static String getPROP_REG_ORGAN_NO() {
		return PROP_REG_ORGAN_NO;
	}



	public static void setPROP_REG_ORGAN_NO(String pROP_REG_ORGAN_NO) {
		PROP_REG_ORGAN_NO = pROP_REG_ORGAN_NO;
	}



	public static String getPROP_REG_ORGAN_CODE() {
		return PROP_REG_ORGAN_CODE;
	}



	public static void setPROP_REG_ORGAN_CODE(String pROP_REG_ORGAN_CODE) {
		PROP_REG_ORGAN_CODE = pROP_REG_ORGAN_CODE;
	}



	public static String getPROP_REG_DATE() {
		return PROP_REG_DATE;
	}



	public static void setPROP_REG_DATE(String pROP_REG_DATE) {
		PROP_REG_DATE = pROP_REG_DATE;
	}



	public static String getPROP_REG_END_DATE() {
		return PROP_REG_END_DATE;
	}



	public static void setPROP_REG_END_DATE(String pROP_REG_END_DATE) {
		PROP_REG_END_DATE = pROP_REG_END_DATE;
	}



	public static String getPROP_REG_STATE_TAX_NO() {
		return PROP_REG_STATE_TAX_NO;
	}



	public static void setPROP_REG_STATE_TAX_NO(String pROP_REG_STATE_TAX_NO) {
		PROP_REG_STATE_TAX_NO = pROP_REG_STATE_TAX_NO;
	}



	public static String getPROP_REG_LOCAL_TAX_NO() {
		return PROP_REG_LOCAL_TAX_NO;
	}



	public static void setPROP_REG_LOCAL_TAX_NO(String pROP_REG_LOCAL_TAX_NO) {
		PROP_REG_LOCAL_TAX_NO = pROP_REG_LOCAL_TAX_NO;
	}



	public static String getPROP_LOAN_CARD_STATUS() {
		return PROP_LOAN_CARD_STATUS;
	}



	public static void setPROP_LOAN_CARD_STATUS(String pROP_LOAN_CARD_STATUS) {
		PROP_LOAN_CARD_STATUS = pROP_LOAN_CARD_STATUS;
	}



	public static String getPROP_LAST_AUDIT_DATE() {
		return PROP_LAST_AUDIT_DATE;
	}



	public static void setPROP_LAST_AUDIT_DATE(String pROP_LAST_AUDIT_DATE) {
		PROP_LAST_AUDIT_DATE = pROP_LAST_AUDIT_DATE;
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



	public java.lang.String getRptKey() {
		return rptKey;
	}



	public void setRptKey(java.lang.String rptKey) {
		this.rptKey = rptKey;
	}



	public java.util.Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}



	public java.lang.String getName() {
		return name;
	}



	public void setName(java.lang.String name) {
		this.name = name;
	}



	public java.lang.String getAddress() {
		return address;
	}



	public void setAddress(java.lang.String address) {
		this.address = address;
	}



	public java.lang.String getRegOrganType() {
		return regOrganType;
	}



	public void setRegOrganType(java.lang.String regOrganType) {
		this.regOrganType = regOrganType;
	}



	public java.lang.String getLoancardId() {
		return loancardId;
	}



	public void setLoancardId(java.lang.String loancardId) {
		this.loancardId = loancardId;
	}



	public java.lang.String getRegOrganNo() {
		return regOrganNo;
	}



	public void setRegOrganNo(java.lang.String regOrganNo) {
		this.regOrganNo = regOrganNo;
	}



	public java.lang.String getRegOrganCode() {
		return regOrganCode;
	}



	public void setRegOrganCode(java.lang.String regOrganCode) {
		this.regOrganCode = regOrganCode;
	}



	public java.lang.String getRegDate() {
		return regDate;
	}



	public void setRegDate(java.lang.String regDate) {
		this.regDate = regDate;
	}



	public java.lang.String getRegEndDate() {
		return regEndDate;
	}



	public void setRegEndDate(java.lang.String regEndDate) {
		this.regEndDate = regEndDate;
	}



	public java.lang.String getRegStateTaxNo() {
		return regStateTaxNo;
	}



	public void setRegStateTaxNo(java.lang.String regStateTaxNo) {
		this.regStateTaxNo = regStateTaxNo;
	}



	public java.lang.String getRegLocalTaxNo() {
		return regLocalTaxNo;
	}



	public void setRegLocalTaxNo(java.lang.String regLocalTaxNo) {
		this.regLocalTaxNo = regLocalTaxNo;
	}



	public java.lang.String getLoanCardStatus() {
		return loanCardStatus;
	}



	public void setLoanCardStatus(java.lang.String loanCardStatus) {
		this.loanCardStatus = loanCardStatus;
	}



	public java.lang.String getLastAuditDate() {
		return lastAuditDate;
	}



	public void setLastAuditDate(java.lang.String lastAuditDate) {
		this.lastAuditDate = lastAuditDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastAuditDate == null) ? 0 : lastAuditDate.hashCode());
		result = prime * result
				+ ((loanCardStatus == null) ? 0 : loanCardStatus.hashCode());
		result = prime * result
				+ ((loancardId == null) ? 0 : loancardId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result
				+ ((regEndDate == null) ? 0 : regEndDate.hashCode());
		result = prime * result
				+ ((regLocalTaxNo == null) ? 0 : regLocalTaxNo.hashCode());
		result = prime * result
				+ ((regOrganCode == null) ? 0 : regOrganCode.hashCode());
		result = prime * result
				+ ((regOrganNo == null) ? 0 : regOrganNo.hashCode());
		result = prime * result
				+ ((regOrganType == null) ? 0 : regOrganType.hashCode());
		result = prime * result
				+ ((regStateTaxNo == null) ? 0 : regStateTaxNo.hashCode());
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
		BaseTCorpInfoBasic other = (BaseTCorpInfoBasic) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastAuditDate == null) {
			if (other.lastAuditDate != null)
				return false;
		} else if (!lastAuditDate.equals(other.lastAuditDate))
			return false;
		if (loanCardStatus == null) {
			if (other.loanCardStatus != null)
				return false;
		} else if (!loanCardStatus.equals(other.loanCardStatus))
			return false;
		if (loancardId == null) {
			if (other.loancardId != null)
				return false;
		} else if (!loancardId.equals(other.loancardId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (regEndDate == null) {
			if (other.regEndDate != null)
				return false;
		} else if (!regEndDate.equals(other.regEndDate))
			return false;
		if (regLocalTaxNo == null) {
			if (other.regLocalTaxNo != null)
				return false;
		} else if (!regLocalTaxNo.equals(other.regLocalTaxNo))
			return false;
		if (regOrganCode == null) {
			if (other.regOrganCode != null)
				return false;
		} else if (!regOrganCode.equals(other.regOrganCode))
			return false;
		if (regOrganNo == null) {
			if (other.regOrganNo != null)
				return false;
		} else if (!regOrganNo.equals(other.regOrganNo))
			return false;
		if (regOrganType == null) {
			if (other.regOrganType != null)
				return false;
		} else if (!regOrganType.equals(other.regOrganType))
			return false;
		if (regStateTaxNo == null) {
			if (other.regStateTaxNo != null)
				return false;
		} else if (!regStateTaxNo.equals(other.regStateTaxNo))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "BaseTCorpInfoBasic [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", createTime=" + createTime
				+ ", name=" + name + ", address=" + address + ", regOrganType="
				+ regOrganType + ", loancardId=" + loancardId + ", regOrganNo="
				+ regOrganNo + ", regOrganCode=" + regOrganCode + ", regDate="
				+ regDate + ", regEndDate=" + regEndDate + ", regStateTaxNo="
				+ regStateTaxNo + ", regLocalTaxNo=" + regLocalTaxNo
				+ ", loanCardStatus=" + loanCardStatus + ", lastAuditDate="
				+ lastAuditDate + "]";
	}

	
    
	
    
    
	
    
    
}
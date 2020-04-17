package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="IND_APP"
 */

public abstract class BaseTCorpLoancardResp implements Serializable {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1808516965030875955L;
	public static String REF = "TCorpLoancardResp";
    public static String PROP_ID="id";
    public static String PROP_INQ_ID="inqId";
    public static String PROP_LOAN_CARD_NO="loancardno";
    public static String PROP_COUNTRY_TAX_CODE="countryTaxCode";
    public static String PROP_ORG_CREDIT_CODE="orgCreditCode";
    public static String PROP_ORG_CODE="orgCode";
    public static String PROP_REGION_TAX_CODE="regionTaxCode";
    public static String PROP_REGIST_CODE_TYPE="registCodeType";
    public static String PROP_REGIST_CODE="registCode";
    public static String PROP_ENG_NAME="engName";
    public static String PROP_CHN_NAME="chnName";
    public static String PROP_FULL_NAME="fullName";
    public static String PROP_RETURN_TIME="returnTime";
	



    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.Integer inqId;
    private java.lang.String loancardno;
    private java.lang.String countryTaxCode;
    private java.lang.String orgCreditCode;
    private java.lang.String orgCode;
    private java.lang.String regionTaxCode;
    private java.lang.String registCodeType;
    private java.lang.String registCode;
    private java.lang.String engName;
    private java.lang.String chnName;
    private java.lang.String  fullName;
    private java.util.Date returnTime;
	public BaseTCorpLoancardResp() {
		super();
	}
	public BaseTCorpLoancardResp(Integer id, Integer inqId, String loancardno,
			String countryTaxCode, String orgCreditCode, String orgCode,
			String regionTaxCode, String registCodeType, String registCode,
			String engName, String chnName, String fullName, Date returnTime) {
		super();
		this.id = id;
		this.inqId = inqId;
		this.loancardno = loancardno;
		this.countryTaxCode = countryTaxCode;
		this.orgCreditCode = orgCreditCode;
		this.orgCode = orgCode;
		this.regionTaxCode = regionTaxCode;
		this.registCodeType = registCodeType;
		this.registCode = registCode;
		this.engName = engName;
		this.chnName = chnName;
		this.fullName = fullName;
		this.returnTime = returnTime;
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
	public static String getPROP_INQ_ID() {
		return PROP_INQ_ID;
	}
	public static void setPROP_INQ_ID(String pROP_INQ_ID) {
		PROP_INQ_ID = pROP_INQ_ID;
	}
	public static String getPROP_LOAN_CARD_NO() {
		return PROP_LOAN_CARD_NO;
	}
	public static void setPROP_LOAN_CARD_NO(String pROP_LOAN_CARD_NO) {
		PROP_LOAN_CARD_NO = pROP_LOAN_CARD_NO;
	}
	public static String getPROP_COUNTRY_TAX_CODE() {
		return PROP_COUNTRY_TAX_CODE;
	}
	public static void setPROP_COUNTRY_TAX_CODE(String pROP_COUNTRY_TAX_CODE) {
		PROP_COUNTRY_TAX_CODE = pROP_COUNTRY_TAX_CODE;
	}
	public static String getPROP_ORG_CREDIT_CODE() {
		return PROP_ORG_CREDIT_CODE;
	}
	public static void setPROP_ORG_CREDIT_CODE(String pROP_ORG_CREDIT_CODE) {
		PROP_ORG_CREDIT_CODE = pROP_ORG_CREDIT_CODE;
	}
	public static String getPROP_ORG_CODE() {
		return PROP_ORG_CODE;
	}
	public static void setPROP_ORG_CODE(String pROP_ORG_CODE) {
		PROP_ORG_CODE = pROP_ORG_CODE;
	}
	public static String getPROP_REGION_TAX_CODE() {
		return PROP_REGION_TAX_CODE;
	}
	public static void setPROP_REGION_TAX_CODE(String pROP_REGION_TAX_CODE) {
		PROP_REGION_TAX_CODE = pROP_REGION_TAX_CODE;
	}
	public static String getPROP_REGIST_CODE_TYPE() {
		return PROP_REGIST_CODE_TYPE;
	}
	public static void setPROP_REGIST_CODE_TYPE(String pROP_REGIST_CODE_TYPE) {
		PROP_REGIST_CODE_TYPE = pROP_REGIST_CODE_TYPE;
	}
	public static String getPROP_REGIST_CODE() {
		return PROP_REGIST_CODE;
	}
	public static void setPROP_REGIST_CODE(String pROP_REGIST_CODE) {
		PROP_REGIST_CODE = pROP_REGIST_CODE;
	}
	public static String getPROP_ENG_NAME() {
		return PROP_ENG_NAME;
	}
	public static void setPROP_ENG_NAME(String pROP_ENG_NAME) {
		PROP_ENG_NAME = pROP_ENG_NAME;
	}
	public static String getPROP_CHN_NAME() {
		return PROP_CHN_NAME;
	}
	public static void setPROP_CHN_NAME(String pROP_CHN_NAME) {
		PROP_CHN_NAME = pROP_CHN_NAME;
	}
	public static String getPROP_FULL_NAME() {
		return PROP_FULL_NAME;
	}
	public static void setPROP_FULL_NAME(String pROP_FULL_NAME) {
		PROP_FULL_NAME = pROP_FULL_NAME;
	}
	public static String getPROP_RETURN_TIME() {
		return PROP_RETURN_TIME;
	}
	public static void setPROP_RETURN_TIME(String pROP_RETURN_TIME) {
		PROP_RETURN_TIME = pROP_RETURN_TIME;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.Integer getInqId() {
		return inqId;
	}
	public void setInqId(java.lang.Integer inqId) {
		this.inqId = inqId;
	}
	public java.lang.String getLoancardno() {
		return loancardno;
	}
	public void setLoancardno(java.lang.String loancardno) {
		this.loancardno = loancardno;
	}
	public java.lang.String getCountryTaxCode() {
		return countryTaxCode;
	}
	public void setCountryTaxCode(java.lang.String countryTaxCode) {
		this.countryTaxCode = countryTaxCode;
	}
	public java.lang.String getOrgCreditCode() {
		return orgCreditCode;
	}
	public void setOrgCreditCode(java.lang.String orgCreditCode) {
		this.orgCreditCode = orgCreditCode;
	}
	public java.lang.String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(java.lang.String orgCode) {
		this.orgCode = orgCode;
	}
	public java.lang.String getRegionTaxCode() {
		return regionTaxCode;
	}
	public void setRegionTaxCode(java.lang.String regionTaxCode) {
		this.regionTaxCode = regionTaxCode;
	}
	public java.lang.String getRegistCodeType() {
		return registCodeType;
	}
	public void setRegistCodeType(java.lang.String registCodeType) {
		this.registCodeType = registCodeType;
	}
	public java.lang.String getRegistCode() {
		return registCode;
	}
	public void setRegistCode(java.lang.String registCode) {
		this.registCode = registCode;
	}
	public java.lang.String getEngName() {
		return engName;
	}
	public void setEngName(java.lang.String engName) {
		this.engName = engName;
	}
	public java.lang.String getChnName() {
		return chnName;
	}
	public void setChnName(java.lang.String chnName) {
		this.chnName = chnName;
	}
	public java.lang.String getFullName() {
		return fullName;
	}
	public void setFullName(java.lang.String fullName) {
		this.fullName = fullName;
	}
	public java.util.Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(java.util.Date returnTime) {
		this.returnTime = returnTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chnName == null) ? 0 : chnName.hashCode());
		result = prime * result
				+ ((countryTaxCode == null) ? 0 : countryTaxCode.hashCode());
		result = prime * result + ((engName == null) ? 0 : engName.hashCode());
		result = prime * result
				+ ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inqId == null) ? 0 : inqId.hashCode());
		result = prime * result
				+ ((loancardno == null) ? 0 : loancardno.hashCode());
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		result = prime * result
				+ ((orgCreditCode == null) ? 0 : orgCreditCode.hashCode());
		result = prime * result
				+ ((regionTaxCode == null) ? 0 : regionTaxCode.hashCode());
		result = prime * result
				+ ((registCode == null) ? 0 : registCode.hashCode());
		result = prime * result
				+ ((registCodeType == null) ? 0 : registCodeType.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
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
		BaseTCorpLoancardResp other = (BaseTCorpLoancardResp) obj;
		if (chnName == null) {
			if (other.chnName != null)
				return false;
		} else if (!chnName.equals(other.chnName))
			return false;
		if (countryTaxCode == null) {
			if (other.countryTaxCode != null)
				return false;
		} else if (!countryTaxCode.equals(other.countryTaxCode))
			return false;
		if (engName == null) {
			if (other.engName != null)
				return false;
		} else if (!engName.equals(other.engName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inqId == null) {
			if (other.inqId != null)
				return false;
		} else if (!inqId.equals(other.inqId))
			return false;
		if (loancardno == null) {
			if (other.loancardno != null)
				return false;
		} else if (!loancardno.equals(other.loancardno))
			return false;
		if (orgCode == null) {
			if (other.orgCode != null)
				return false;
		} else if (!orgCode.equals(other.orgCode))
			return false;
		if (orgCreditCode == null) {
			if (other.orgCreditCode != null)
				return false;
		} else if (!orgCreditCode.equals(other.orgCreditCode))
			return false;
		if (regionTaxCode == null) {
			if (other.regionTaxCode != null)
				return false;
		} else if (!regionTaxCode.equals(other.regionTaxCode))
			return false;
		if (registCode == null) {
			if (other.registCode != null)
				return false;
		} else if (!registCode.equals(other.registCode))
			return false;
		if (registCodeType == null) {
			if (other.registCodeType != null)
				return false;
		} else if (!registCodeType.equals(other.registCodeType))
			return false;
		if (returnTime == null) {
			if (other.returnTime != null)
				return false;
		} else if (!returnTime.equals(other.returnTime))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseTCorpLoancardResp [id=" + id + ", inqId=" + inqId
				+ ", loancardno=" + loancardno + ", countryTaxCode="
				+ countryTaxCode + ", orgCreditCode=" + orgCreditCode
				+ ", orgCode=" + orgCode + ", regionTaxCode=" + regionTaxCode
				+ ", registCodeType=" + registCodeType + ", registCode="
				+ registCode + ", engName=" + engName + ", chnName=" + chnName
				+ ", fullName=" + fullName + ", returnTime=" + returnTime + "]";
	}
    
	
   
    
    
  
}
package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 */

public abstract class BaseTDetailIndResult implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6614834221276719303L;
	public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CHINESE_NAME="chineseName";
    public static String PROP_ENGLIST_NAME="englistName";
    public static String PROP_ORG_CREDIT_CODE="orgCreditCode";
    public static String PROP_ORG_CODE="orgCode";
    public static String PROP_LOANCARD_NO="loancardNo";
    public static String PROP_REGIST_TYPE="registType";
    public static String PROP_REGIST_CODE="registCode";
    public static String PROP_COUNTRY_TAX_CODE="countryTaxCode";
	public static String PROP_REGION_TAX_CODE="regionTaxCode";
	public static String PROP_ADDRESS="address";
	public static String PROP_CONTACT_ADDRESS="contactAddress";
	public static String PROP_CONTACT_NO="contactNo";
	
	
	
	

	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.lang.String chineseName;
    private java.lang.String englistName;
    private java.lang.String orgCreditCode;
    private java.lang.String orgCode;
    private java.lang.String loancardNo;
    private java.lang.String registType;
    private java.lang.String registCode;
    private java.lang.String countryTaxCode;
    private java.lang.String regionTaxCode;
    private java.lang.String address;
    private java.lang.String contactAddress;
    private java.lang.String contactNo;





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
	public static String getPROP_CHINESE_NAME() {
		return PROP_CHINESE_NAME;
	}
	public static void setPROP_CHINESE_NAME(String pROP_CHINESE_NAME) {
		PROP_CHINESE_NAME = pROP_CHINESE_NAME;
	}
	public static String getPROP_ENGLIST_NAME() {
		return PROP_ENGLIST_NAME;
	}
	public static void setPROP_ENGLIST_NAME(String pROP_ENGLIST_NAME) {
		PROP_ENGLIST_NAME = pROP_ENGLIST_NAME;
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
	public static String getPROP_LOANCARD_NO() {
		return PROP_LOANCARD_NO;
	}
	public static void setPROP_LOANCARD_NO(String pROP_LOANCARD_NO) {
		PROP_LOANCARD_NO = pROP_LOANCARD_NO;
	}
	public static String getPROP_REGIST_TYPE() {
		return PROP_REGIST_TYPE;
	}
	public static void setPROP_REGIST_TYPE(String pROP_REGIST_TYPE) {
		PROP_REGIST_TYPE = pROP_REGIST_TYPE;
	}
	public static String getPROP_REGIST_CODE() {
		return PROP_REGIST_CODE;
	}
	public static void setPROP_REGIST_CODE(String pROP_REGIST_CODE) {
		PROP_REGIST_CODE = pROP_REGIST_CODE;
	}
	public static String getPROP_COUNTRY_TAX_CODE() {
		return PROP_COUNTRY_TAX_CODE;
	}
	public static void setPROP_COUNTRY_TAX_CODE(String pROP_COUNTRY_TAX_CODE) {
		PROP_COUNTRY_TAX_CODE = pROP_COUNTRY_TAX_CODE;
	}
	public static String getPROP_REGION_TAX_CODE() {
		return PROP_REGION_TAX_CODE;
	}
	public static void setPROP_REGION_TAX_CODE(String pROP_REGION_TAX_CODE) {
		PROP_REGION_TAX_CODE = pROP_REGION_TAX_CODE;
	}
	public static String getPROP_ADDRESS() {
		return PROP_ADDRESS;
	}
	public static void setPROP_ADDRESS(String pROP_ADDRESS) {
		PROP_ADDRESS = pROP_ADDRESS;
	}
	public static String getPROP_CONTACT_ADDRESS() {
		return PROP_CONTACT_ADDRESS;
	}
	public static void setPROP_CONTACT_ADDRESS(String pROP_CONTACT_ADDRESS) {
		PROP_CONTACT_ADDRESS = pROP_CONTACT_ADDRESS;
	}
	public static String getPROP_CONTACT_NO() {
		return PROP_CONTACT_NO;
	}
	public static void setPROP_CONTACT_NO(String pROP_CONTACT_NO) {
		PROP_CONTACT_NO = pROP_CONTACT_NO;
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
	public java.lang.String getChineseName() {
		return chineseName;
	}
	public void setChineseName(java.lang.String chineseName) {
		this.chineseName = chineseName;
	}
	public java.lang.String getEnglistName() {
		return englistName;
	}
	public void setEnglistName(java.lang.String englistName) {
		this.englistName = englistName;
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
	public java.lang.String getLoancardNo() {
		return loancardNo;
	}
	public void setLoancardNo(java.lang.String loancardNo) {
		this.loancardNo = loancardNo;
	}
	public java.lang.String getRegistType() {
		return registType;
	}
	public void setRegistType(java.lang.String registType) {
		this.registType = registType;
	}
	public java.lang.String getRegistCode() {
		return registCode;
	}
	public void setRegistCode(java.lang.String registCode) {
		this.registCode = registCode;
	}
	public java.lang.String getCountryTaxCode() {
		return countryTaxCode;
	}
	public void setCountryTaxCode(java.lang.String countryTaxCode) {
		this.countryTaxCode = countryTaxCode;
	}
	public java.lang.String getRegionTaxCode() {
		return regionTaxCode;
	}
	public void setRegionTaxCode(java.lang.String regionTaxCode) {
		this.regionTaxCode = regionTaxCode;
	}
	public java.lang.String getAddress() {
		return address;
	}
	public void setAddress(java.lang.String address) {
		this.address = address;
	}
	public java.lang.String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(java.lang.String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public java.lang.String getContactNo() {
		return contactNo;
	}
	public void setContactNo(java.lang.String contactNo) {
		this.contactNo = contactNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseTDetailIndResult [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", chineseName=" + chineseName
				+ ", englistName=" + englistName + ", orgCreditCode="
				+ orgCreditCode + ", orgCode=" + orgCode + ", loancardNo="
				+ loancardNo + ", registType=" + registType + ", registCode="
				+ registCode + ", countryTaxCode=" + countryTaxCode
				+ ", regionTaxCode=" + regionTaxCode + ", address=" + address
				+ ", contactAddress=" + contactAddress + ", contactNo="
				+ contactNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result
				+ ((chineseName == null) ? 0 : chineseName.hashCode());
		result = prime * result
				+ ((contactAddress == null) ? 0 : contactAddress.hashCode());
		result = prime * result
				+ ((contactNo == null) ? 0 : contactNo.hashCode());
		result = prime * result
				+ ((countryTaxCode == null) ? 0 : countryTaxCode.hashCode());
		result = prime * result
				+ ((englistName == null) ? 0 : englistName.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loancardNo == null) ? 0 : loancardNo.hashCode());
		result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
		result = prime * result
				+ ((orgCreditCode == null) ? 0 : orgCreditCode.hashCode());
		result = prime * result
				+ ((regionTaxCode == null) ? 0 : regionTaxCode.hashCode());
		result = prime * result
				+ ((registCode == null) ? 0 : registCode.hashCode());
		result = prime * result
				+ ((registType == null) ? 0 : registType.hashCode());
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
		BaseTDetailIndResult other = (BaseTDetailIndResult) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (chineseName == null) {
			if (other.chineseName != null)
				return false;
		} else if (!chineseName.equals(other.chineseName))
			return false;
		if (contactAddress == null) {
			if (other.contactAddress != null)
				return false;
		} else if (!contactAddress.equals(other.contactAddress))
			return false;
		if (contactNo == null) {
			if (other.contactNo != null)
				return false;
		} else if (!contactNo.equals(other.contactNo))
			return false;
		if (countryTaxCode == null) {
			if (other.countryTaxCode != null)
				return false;
		} else if (!countryTaxCode.equals(other.countryTaxCode))
			return false;
		if (englistName == null) {
			if (other.englistName != null)
				return false;
		} else if (!englistName.equals(other.englistName))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loancardNo == null) {
			if (other.loancardNo != null)
				return false;
		} else if (!loancardNo.equals(other.loancardNo))
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
		if (registType == null) {
			if (other.registType != null)
				return false;
		} else if (!registType.equals(other.registType))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTDetailIndResult(int hashCode, Integer id, String rptKey,
			String chineseName, String englistName, String orgCreditCode,
			String orgCode, String loancardNo, String registType,
			String registCode, String countryTaxCode, String regionTaxCode,
			String address, String contactAddress, String contactNo) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.chineseName = chineseName;
		this.englistName = englistName;
		this.orgCreditCode = orgCreditCode;
		this.orgCode = orgCode;
		this.loancardNo = loancardNo;
		this.registType = registType;
		this.registCode = registCode;
		this.countryTaxCode = countryTaxCode;
		this.regionTaxCode = regionTaxCode;
		this.address = address;
		this.contactAddress = contactAddress;
		this.contactNo = contactNo;
	}
	public BaseTDetailIndResult() {
		super();
		// TODO Auto-generated constructor stub
	}

    


}
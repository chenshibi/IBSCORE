package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 */

public abstract class BaseNatureCodeQuery implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6614834221276719303L;
	
	public static String REF = "BaseNatureCodeQuery";
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
	
	
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_NAME="name";
    public static String PROP_INDIVIDUAL_ID_TYPE="individualIdType";
    public static String PROP_INDIVIDUAL_ID="individualId";
    public static String PROP_STATUS="status";
    public static String PROP_ASTATUS="astatus";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_RETURN_TIME="returnTime";
    public static String PROP_APP_ID="appId";
	

    public static String PROP_TYPE="type";
    public static String PROP_INPUT_USER="inputUser";
    public static String PROP_QUERY_TIME="queryTime";
	public static String PROP_PARSE_TIME="parseTime";
	public static String PROP_INPUT_USER_IP="inputUserIp";

	
	

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
    
    

    private java.lang.Integer batchId;
    private java.lang.String name;
    private java.lang.String individualIdType;
    private java.lang.String individualId;
    private java.lang.String  createUser;
    private java.util.Date inputTime;
    private  java.util.Date returnTime;
    private java.lang.String  astatus;
    private java.lang.String  status;
    private java.lang.Integer appId;
    
    
    private java.lang.String type;
    private java.lang.String inputUser;
    private java.util.Date queryTime;
    private java.util.Date parseTime;
    private java.lang.String inputUserIp;
    private java.lang.String idNo;
    private java.lang.String idType;
    private java.lang.String assureName;




	public BaseNatureCodeQuery(int hashCode, Integer id, String rptKey,
			String chineseName, String englistName, String orgCreditCode,
			String orgCode, String loancardNo, String registType,
			String registCode, String countryTaxCode, String regionTaxCode,
			String address, String contactAddress, String contactNo,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String astatus, String status, Integer appId,
			String type, String inputUser, Date queryTime, Date parseTime,
			String inputUserIp, String idNo, String idType, String assureName) {
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
		this.batchId = batchId;
		this.name = name;
		this.individualIdType = individualIdType;
		this.individualId = individualId;
		this.createUser = createUser;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.astatus = astatus;
		this.status = status;
		this.appId = appId;
		this.type = type;
		this.inputUser = inputUser;
		this.queryTime = queryTime;
		this.parseTime = parseTime;
		this.inputUserIp = inputUserIp;
		this.idNo = idNo;
		this.idType = idType;
		this.assureName = assureName;
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




	public static String getPROP_BATCH_ID() {
		return PROP_BATCH_ID;
	}




	public static void setPROP_BATCH_ID(String pROP_BATCH_ID) {
		PROP_BATCH_ID = pROP_BATCH_ID;
	}




	public static String getPROP_NAME() {
		return PROP_NAME;
	}




	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}




	public static String getPROP_INDIVIDUAL_ID_TYPE() {
		return PROP_INDIVIDUAL_ID_TYPE;
	}




	public static void setPROP_INDIVIDUAL_ID_TYPE(String pROP_INDIVIDUAL_ID_TYPE) {
		PROP_INDIVIDUAL_ID_TYPE = pROP_INDIVIDUAL_ID_TYPE;
	}




	public static String getPROP_INDIVIDUAL_ID() {
		return PROP_INDIVIDUAL_ID;
	}




	public static void setPROP_INDIVIDUAL_ID(String pROP_INDIVIDUAL_ID) {
		PROP_INDIVIDUAL_ID = pROP_INDIVIDUAL_ID;
	}




	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}




	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}




	public static String getPROP_ASTATUS() {
		return PROP_ASTATUS;
	}




	public static void setPROP_ASTATUS(String pROP_ASTATUS) {
		PROP_ASTATUS = pROP_ASTATUS;
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




	public static String getPROP_RETURN_TIME() {
		return PROP_RETURN_TIME;
	}




	public static void setPROP_RETURN_TIME(String pROP_RETURN_TIME) {
		PROP_RETURN_TIME = pROP_RETURN_TIME;
	}




	public static String getPROP_APP_ID() {
		return PROP_APP_ID;
	}




	public static void setPROP_APP_ID(String pROP_APP_ID) {
		PROP_APP_ID = pROP_APP_ID;
	}




	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}




	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}




	public static String getPROP_INPUT_USER() {
		return PROP_INPUT_USER;
	}




	public static void setPROP_INPUT_USER(String pROP_INPUT_USER) {
		PROP_INPUT_USER = pROP_INPUT_USER;
	}




	public static String getPROP_QUERY_TIME() {
		return PROP_QUERY_TIME;
	}




	public static void setPROP_QUERY_TIME(String pROP_QUERY_TIME) {
		PROP_QUERY_TIME = pROP_QUERY_TIME;
	}




	public static String getPROP_PARSE_TIME() {
		return PROP_PARSE_TIME;
	}




	public static void setPROP_PARSE_TIME(String pROP_PARSE_TIME) {
		PROP_PARSE_TIME = pROP_PARSE_TIME;
	}




	public static String getPROP_INPUT_USER_IP() {
		return PROP_INPUT_USER_IP;
	}




	public static void setPROP_INPUT_USER_IP(String pROP_INPUT_USER_IP) {
		PROP_INPUT_USER_IP = pROP_INPUT_USER_IP;
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




	public java.lang.Integer getBatchId() {
		return batchId;
	}




	public void setBatchId(java.lang.Integer batchId) {
		this.batchId = batchId;
	}




	public java.lang.String getName() {
		return name;
	}




	public void setName(java.lang.String name) {
		this.name = name;
	}




	public java.lang.String getIndividualIdType() {
		return individualIdType;
	}




	public void setIndividualIdType(java.lang.String individualIdType) {
		this.individualIdType = individualIdType;
	}




	public java.lang.String getIndividualId() {
		return individualId;
	}




	public void setIndividualId(java.lang.String individualId) {
		this.individualId = individualId;
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




	public java.util.Date getReturnTime() {
		return returnTime;
	}




	public void setReturnTime(java.util.Date returnTime) {
		this.returnTime = returnTime;
	}




	public java.lang.String getAstatus() {
		return astatus;
	}




	public void setAstatus(java.lang.String astatus) {
		this.astatus = astatus;
	}




	public java.lang.String getStatus() {
		return status;
	}




	public void setStatus(java.lang.String status) {
		this.status = status;
	}




	public java.lang.Integer getAppId() {
		return appId;
	}




	public void setAppId(java.lang.Integer appId) {
		this.appId = appId;
	}




	public java.lang.String getType() {
		return type;
	}




	public void setType(java.lang.String type) {
		this.type = type;
	}




	public java.lang.String getInputUser() {
		return inputUser;
	}




	public void setInputUser(java.lang.String inputUser) {
		this.inputUser = inputUser;
	}




	public java.util.Date getQueryTime() {
		return queryTime;
	}




	public void setQueryTime(java.util.Date queryTime) {
		this.queryTime = queryTime;
	}




	public java.util.Date getParseTime() {
		return parseTime;
	}




	public void setParseTime(java.util.Date parseTime) {
		this.parseTime = parseTime;
	}




	public java.lang.String getInputUserIp() {
		return inputUserIp;
	}




	public void setInputUserIp(java.lang.String inputUserIp) {
		this.inputUserIp = inputUserIp;
	}




	public java.lang.String getIdNo() {
		return idNo;
	}




	public void setIdNo(java.lang.String idNo) {
		this.idNo = idNo;
	}




	public java.lang.String getIdType() {
		return idType;
	}




	public void setIdType(java.lang.String idType) {
		this.idType = idType;
	}




	public java.lang.String getAssureName() {
		return assureName;
	}




	public void setAssureName(java.lang.String assureName) {
		this.assureName = assureName;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public BaseNatureCodeQuery() {
		super();
	}

 


	

    


}
package resource.bean.basic.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="Ind_permit"
 */

public abstract class BaseFileSubmit implements Serializable {

	private static final long serialVersionUID = 5209513467412657202L;
	public static String REF = "FileSubmit";
	public static String PROP_ID = "id";
	public static String PROP_FILE_NAME = "fileName";
    public static String PROP_FILE_PATH="filePath";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_STATUS="status";
    public static String PROP_SGEMENT = "sgement";
    public static String PROP_PRODUCT = "product";
    public static String PROP_SCOPE = "scope";
    public static String PROP_NOTE = "note";
    public static String PROP_EFFECTIVE_DATE = "effectiveDate";
    public static String PROP_EXPIRE_DATE = "expireDate";
    public static String PROP_FLAG = "flag";
    public static String FILE_TYPE="fileType";
    public static String CITY="city";
    
    // constructors
    public BaseFileSubmit() {
        initialize();
    }


    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

 // primary key
    private java.lang.Integer id;
    // fields
  
    private java.lang.String fileName;
    private java.lang.String filePath;
    private java.lang.String createUser;
    private java.lang.String status;
    private java.lang.String inputTime;

    private java.lang.String sgement;
    private java.lang.String product;
    private java.lang.String scope;
    private java.lang.String note;
    private java.lang.String effectiveDate;
    private java.lang.String expireDate;
    private java.lang.String flag;
    private java.lang.String fileType;
    private java.lang.String department;
    public java.lang.String getDepartment() {
		return department;
	}


	public void setDepartment(java.lang.String department) {
		this.department = department;
	}


	public java.lang.String getFileType() {
		return fileType;
	}


	public void setFileType(java.lang.String fileType) {
		this.fileType = fileType;
	}


	public java.lang.String getCity() {
		return city;
	}


	public void setCity(java.lang.String city) {
		this.city = city;
	}

	private java.lang.String city;

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


	public static String getPROP_FILE_NAME() {
		return PROP_FILE_NAME;
	}


	public static void setPROP_FILE_NAME(String pROP_FILE_NAME) {
		PROP_FILE_NAME = pROP_FILE_NAME;
	}


	public static String getPROP_FILE_PATH() {
		return PROP_FILE_PATH;
	}


	public static void setPROP_FILE_PATH(String pROP_FILE_PATH) {
		PROP_FILE_PATH = pROP_FILE_PATH;
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


	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}


	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}


	public static String getPROP_SGEMENT() {
		return PROP_SGEMENT;
	}


	public static void setPROP_SGEMENT(String pROP_SGEMENT) {
		PROP_SGEMENT = pROP_SGEMENT;
	}


	public static String getPROP_PRODUCT() {
		return PROP_PRODUCT;
	}


	public static void setPROP_PRODUCT(String pROP_PRODUCT) {
		PROP_PRODUCT = pROP_PRODUCT;
	}


	public static String getPROP_SCOPE() {
		return PROP_SCOPE;
	}


	public static void setPROP_SCOPE(String pROP_SCOPE) {
		PROP_SCOPE = pROP_SCOPE;
	}


	public static String getPROP_NOTE() {
		return PROP_NOTE;
	}


	public static void setPROP_NOTE(String pROP_NOTE) {
		PROP_NOTE = pROP_NOTE;
	}


	public static String getPROP_EFFECTIVE_DATE() {
		return PROP_EFFECTIVE_DATE;
	}


	public static void setPROP_EFFECTIVE_DATE(String pROP_EFFECTIVE_DATE) {
		PROP_EFFECTIVE_DATE = pROP_EFFECTIVE_DATE;
	}


	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}


	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}


	public static String getPROP_FLAG() {
		return PROP_FLAG;
	}


	public static void setPROP_FLAG(String pROP_FLAG) {
		PROP_FLAG = pROP_FLAG;
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


	public java.lang.String getFileName() {
		return fileName;
	}


	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}


	public java.lang.String getFilePath() {
		return filePath;
	}


	public void setFilePath(java.lang.String filePath) {
		this.filePath = filePath;
	}


	public java.lang.String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}


	public java.lang.String getStatus() {
		return status;
	}


	public void setStatus(java.lang.String status) {
		this.status = status;
	}


	public java.lang.String getInputTime() {
		return inputTime;
	}


	public void setInputTime(java.lang.String inputTime) {
		this.inputTime = inputTime;
	}


	public java.lang.String getSgement() {
		return sgement;
	}


	public void setSgement(java.lang.String sgement) {
		this.sgement = sgement;
	}


	public java.lang.String getProduct() {
		return product;
	}


	public void setProduct(java.lang.String product) {
		this.product = product;
	}


	public java.lang.String getScope() {
		return scope;
	}


	public void setScope(java.lang.String scope) {
		this.scope = scope;
	}


	public java.lang.String getNote() {
		return note;
	}


	public void setNote(java.lang.String note) {
		this.note = note;
	}


	public java.lang.String getEffectiveDate() {
		return effectiveDate;
	}


	public void setEffectiveDate(java.lang.String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}


	public java.lang.String getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(java.lang.String expireDate) {
		this.expireDate = expireDate;
	}


	public java.lang.String getFlag() {
		return flag;
	}


	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public BaseFileSubmit(int hashCode, Integer id, String fileName,
			String filePath, String createUser, String status,
			String inputTime, String sgement, String product, String scope,
			String note, String effectiveDate, String expireDate, String flag,String department) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.fileName = fileName;
		this.filePath = filePath;
		this.createUser = createUser;
		this.status = status;
		this.inputTime = inputTime;
		this.sgement = sgement;
		this.product = product;
		this.scope = scope;
		this.note = note;
		this.effectiveDate = effectiveDate;
		this.expireDate = expireDate;
		this.flag = flag;
		this.department=department;
	}
	 


	 
	 
    
    
    
}
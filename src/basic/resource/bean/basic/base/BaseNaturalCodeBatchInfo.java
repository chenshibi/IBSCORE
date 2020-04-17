package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseNaturalCodeBatchInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3762620282951783608L;
	public static String REF = "NaturalCodeBatchInfo";
	public static String PROP_ID = "id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_NAME="name";
    public static String PROP_INDIVIDUAL_ID_TYPE="individualIdType";
    public static String PROP_INDIVIDUAL_ID="individualId";
    public static String PROP_STATUS="status";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_RETURN_TIME="returnTime";
    public static String PROP_APP_ID="appId";
    
    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;


    private java.lang.Integer id;
    private java.lang.String rptKey;
    private java.lang.Integer batchId;
    private java.lang.String name;
    private java.lang.String individualIdType;
    private java.lang.String individualId;
    private java.lang.String  createUser;
    private java.util.Date inputTime;
    private  java.util.Date returnTime;
    
    private java.lang.String  status;
    private java.lang.Integer appId;

	public BaseNaturalCodeBatchInfo() {
		super();
	}

	public BaseNaturalCodeBatchInfo(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String status, Integer appId) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.batchId = batchId;
		this.name = name;
		this.individualIdType = individualIdType;
		this.individualId = individualId;
		this.createUser = createUser;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.status = status;
		this.appId = appId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((individualId == null) ? 0 : individualId.hashCode());
		result = prime
				* result
				+ ((individualIdType == null) ? 0 : individualIdType.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
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
		BaseNaturalCodeBatchInfo other = (BaseNaturalCodeBatchInfo) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (individualId == null) {
			if (other.individualId != null)
				return false;
		} else if (!individualId.equals(other.individualId))
			return false;
		if (individualIdType == null) {
			if (other.individualIdType != null)
				return false;
		} else if (!individualIdType.equals(other.individualIdType))
			return false;
		if (inputTime == null) {
			if (other.inputTime != null)
				return false;
		} else if (!inputTime.equals(other.inputTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (returnTime == null) {
			if (other.returnTime != null)
				return false;
		} else if (!returnTime.equals(other.returnTime))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
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
		return "BaseNaturalCodeBatchInfo [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", batchId=" + batchId + ", name="
				+ name + ", individualIdType=" + individualIdType
				+ ", individualId=" + individualId + ", createUser="
				+ createUser + ", inputTime=" + inputTime + ", returnTime="
				+ returnTime + ", status=" + status + ", appId=" + appId + "]";
	}

}

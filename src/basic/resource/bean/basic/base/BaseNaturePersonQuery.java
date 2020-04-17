package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 * 
 */

public abstract class BaseNaturePersonQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6614834221276719303L;

	public static String REF = "BaseNaturePersonQuery";

	public static String PROP_ID = "id";
	public static String PROP_RPT_KEY = "rptKey";
	public static String PROP_BATCH_ID = "batchId";
	public static String PROP_NAME = "name";
	public static String PROP_INDIVIDUAL_ID_TYPE = "individualIdType";
	public static String PROP_INDIVIDUAL_ID = "individualId";
	public static String PROP_STATUS = "status";
	public static String PROP_ASTATUS = "astatus";
	public static String PROP_CREATE_USER = "createUser";
	public static String PROP_INPUT_TIME = "inputTime";
	public static String PROP_RETURN_TIME = "returnTime";
	public static String PROP_APP_ID = "appId";

	public static String PROP_TYPE = "type";
	public static String PROP_INPUT_USER = "inputUser";
	public static String PROP_QUERY_TIME = "queryTime";
	public static String PROP_PARSE_TIME = "parseTime";
	public static String PROP_CONSENT_FILE_PATH = "consentFilePath";
	public static String PROP_INPUT_USER_IP = "inputUserIp";
	public static String PROP_NON_CONSENT_FILE_PATH = "nonConsentFilePath";

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// fields
	private java.lang.Integer id;
	private java.lang.String rptKey;
	private java.lang.Integer batchId;
	private java.lang.String name;
	private java.lang.String individualIdType;
	private java.lang.String individualId;
	private java.lang.String createUser;
	private java.util.Date inputTime;
	private java.util.Date returnTime;
	private java.lang.String status;
	private java.lang.String astatus;
	private java.lang.Integer appId;

	private java.lang.String type;
	private java.lang.String inputUser;
	private java.util.Date queryTime;
	private java.util.Date parseTime;
	private java.lang.String consentFilePath;
	private java.lang.String inputUserIp;
	private java.lang.String nonConsentFilePath;

	public BaseNaturePersonQuery() {
		super();
	}

	public BaseNaturePersonQuery(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String status, String astatus, Integer appId,
			String type, String inputUser, Date queryTime, Date parseTime,
			String consentFilePath, String inputUserIp,
			String nonConsentFilePath) {
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
		this.astatus = astatus;
		this.appId = appId;
		this.type = type;
		this.inputUser = inputUser;
		this.queryTime = queryTime;
		this.parseTime = parseTime;
		this.consentFilePath = consentFilePath;
		this.inputUserIp = inputUserIp;
		this.nonConsentFilePath = nonConsentFilePath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((astatus == null) ? 0 : astatus.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((consentFilePath == null) ? 0 : consentFilePath.hashCode());
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
		result = prime * result
				+ ((inputUser == null) ? 0 : inputUser.hashCode());
		result = prime * result
				+ ((inputUserIp == null) ? 0 : inputUserIp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime
				* result
				+ ((nonConsentFilePath == null) ? 0 : nonConsentFilePath
						.hashCode());
		result = prime * result
				+ ((parseTime == null) ? 0 : parseTime.hashCode());
		result = prime * result
				+ ((queryTime == null) ? 0 : queryTime.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BaseNaturePersonQuery other = (BaseNaturePersonQuery) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (astatus == null) {
			if (other.astatus != null)
				return false;
		} else if (!astatus.equals(other.astatus))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (consentFilePath == null) {
			if (other.consentFilePath != null)
				return false;
		} else if (!consentFilePath.equals(other.consentFilePath))
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
		if (inputUser == null) {
			if (other.inputUser != null)
				return false;
		} else if (!inputUser.equals(other.inputUser))
			return false;
		if (inputUserIp == null) {
			if (other.inputUserIp != null)
				return false;
		} else if (!inputUserIp.equals(other.inputUserIp))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nonConsentFilePath == null) {
			if (other.nonConsentFilePath != null)
				return false;
		} else if (!nonConsentFilePath.equals(other.nonConsentFilePath))
			return false;
		if (parseTime == null) {
			if (other.parseTime != null)
				return false;
		} else if (!parseTime.equals(other.parseTime))
			return false;
		if (queryTime == null) {
			if (other.queryTime != null)
				return false;
		} else if (!queryTime.equals(other.queryTime))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public static String getPROP_ASTATUS() {
		return PROP_ASTATUS;
	}

	public static void setPROP_ASTATUS(String pROP_ASTATUS) {
		PROP_ASTATUS = pROP_ASTATUS;
	}

	public java.lang.String getAstatus() {
		return astatus;
	}

	public void setAstatus(java.lang.String astatus) {
		this.astatus = astatus;
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

	public static String getPROP_CONSENT_FILE_PATH() {
		return PROP_CONSENT_FILE_PATH;
	}

	public static void setPROP_CONSENT_FILE_PATH(String pROP_CONSENT_FILE_PATH) {
		PROP_CONSENT_FILE_PATH = pROP_CONSENT_FILE_PATH;
	}

	public static String getPROP_INPUT_USER_IP() {
		return PROP_INPUT_USER_IP;
	}

	public static void setPROP_INPUT_USER_IP(String pROP_INPUT_USER_IP) {
		PROP_INPUT_USER_IP = pROP_INPUT_USER_IP;
	}

	public static String getPROP_NON_CONSENT_FILE_PATH() {
		return PROP_NON_CONSENT_FILE_PATH;
	}

	public static void setPROP_NON_CONSENT_FILE_PATH(
			String pROP_NON_CONSENT_FILE_PATH) {
		PROP_NON_CONSENT_FILE_PATH = pROP_NON_CONSENT_FILE_PATH;
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

	public java.lang.String getConsentFilePath() {
		return consentFilePath;
	}

	public void setConsentFilePath(java.lang.String consentFilePath) {
		this.consentFilePath = consentFilePath;
	}

	public java.lang.String getInputUserIp() {
		return inputUserIp;
	}

	public void setInputUserIp(java.lang.String inputUserIp) {
		this.inputUserIp = inputUserIp;
	}

	public java.lang.String getNonConsentFilePath() {
		return nonConsentFilePath;
	}

	public void setNonConsentFilePath(java.lang.String nonConsentFilePath) {
		this.nonConsentFilePath = nonConsentFilePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
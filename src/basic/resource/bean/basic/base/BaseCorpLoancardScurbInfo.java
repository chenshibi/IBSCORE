package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="corp_loancard_scurb_info"
 */

public abstract class BaseCorpLoancardScurbInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7914481263162613759L;
	public static String REF = "BaseCorpLoancardScurbInfo";
	public static String PROP_ID = "id";
	public static String PROP_APP_ID="appId";
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_INQUIRY_TYPE="inquiryType";
    public static String PROP_INQUIRY_VALUE="inquiryValue";
    public static String PROP_STATUS="status";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_RETURN_TIME="returnTime";
    public static String PROP_CREATE_USER="createUser";
    
    public static String PROP_COUNT_ID="countid";
    public static String PROP_QUERY_SUCCESS="querySuccess";
    public static String PROP_QUERY="query";
    public static String PROP_CHECK_NO_PASS="checkNoPass";
    public static String PROP_QUERT_DEFEAT="queryDefeat";	

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    private java.lang.Integer id;
    private java.lang.Integer appId;
    private java.lang.Integer batchId;
    private java.lang.String inquiryType;
    private java.lang.String inquiryValue;
    private java.lang.String  status;
    private java.util.Date inputTime;
    private  java.util.Date returnTime;
    private java.lang.String createUser;

    private java.lang.Long countid;
    private java.lang.Long querySuccess;
    private java.lang.Long query;
    private java.lang.Long checkNoPass;
    private java.lang.Long queryDefeat;
    

	public BaseCorpLoancardScurbInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BaseCorpLoancardScurbInfo(int hashCode, Integer id, Integer appId,
			Integer batchId, String inquiryType, String inquiryValue,
			String status, Date inputTime, Date returnTime, String createUser,
			Long countid, Long querySuccess, Long query, Long checkNoPass,
			Long queryDefeat) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.appId = appId;
		this.batchId = batchId;
		this.inquiryType = inquiryType;
		this.inquiryValue = inquiryValue;
		this.status = status;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.createUser = createUser;
		this.countid = countid;
		this.querySuccess = querySuccess;
		this.query = query;
		this.checkNoPass = checkNoPass;
		this.queryDefeat = queryDefeat;
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


	public static String getPROP_APP_ID() {
		return PROP_APP_ID;
	}


	public static void setPROP_APP_ID(String pROP_APP_ID) {
		PROP_APP_ID = pROP_APP_ID;
	}


	public static String getPROP_BATCH_ID() {
		return PROP_BATCH_ID;
	}


	public static void setPROP_BATCH_ID(String pROP_BATCH_ID) {
		PROP_BATCH_ID = pROP_BATCH_ID;
	}


	public static String getPROP_INQUIRY_TYPE() {
		return PROP_INQUIRY_TYPE;
	}


	public static void setPROP_INQUIRY_TYPE(String pROP_INQUIRY_TYPE) {
		PROP_INQUIRY_TYPE = pROP_INQUIRY_TYPE;
	}


	public static String getPROP_INQUIRY_VALUE() {
		return PROP_INQUIRY_VALUE;
	}


	public static void setPROP_INQUIRY_VALUE(String pROP_INQUIRY_VALUE) {
		PROP_INQUIRY_VALUE = pROP_INQUIRY_VALUE;
	}


	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}


	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
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


	public static String getPROP_CREATE_USER() {
		return PROP_CREATE_USER;
	}


	public static void setPROP_CREATE_USER(String pROP_CREATE_USER) {
		PROP_CREATE_USER = pROP_CREATE_USER;
	}


	public static String getPROP_COUNT_ID() {
		return PROP_COUNT_ID;
	}


	public static void setPROP_COUNT_ID(String pROP_COUNT_ID) {
		PROP_COUNT_ID = pROP_COUNT_ID;
	}


	public static String getPROP_QUERY_SUCCESS() {
		return PROP_QUERY_SUCCESS;
	}


	public static void setPROP_QUERY_SUCCESS(String pROP_QUERY_SUCCESS) {
		PROP_QUERY_SUCCESS = pROP_QUERY_SUCCESS;
	}


	public static String getPROP_QUERY() {
		return PROP_QUERY;
	}


	public static void setPROP_QUERY(String pROP_QUERY) {
		PROP_QUERY = pROP_QUERY;
	}


	public static String getPROP_CHECK_NO_PASS() {
		return PROP_CHECK_NO_PASS;
	}


	public static void setPROP_CHECK_NO_PASS(String pROP_CHECK_NO_PASS) {
		PROP_CHECK_NO_PASS = pROP_CHECK_NO_PASS;
	}


	public static String getPROP_QUERT_DEFEAT() {
		return PROP_QUERT_DEFEAT;
	}


	public static void setPROP_QUERT_DEFEAT(String pROP_QUERT_DEFEAT) {
		PROP_QUERT_DEFEAT = pROP_QUERT_DEFEAT;
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


	public java.lang.Integer getAppId() {
		return appId;
	}


	public void setAppId(java.lang.Integer appId) {
		this.appId = appId;
	}


	public java.lang.Integer getBatchId() {
		return batchId;
	}


	public void setBatchId(java.lang.Integer batchId) {
		this.batchId = batchId;
	}


	public java.lang.String getInquiryType() {
		return inquiryType;
	}


	public void setInquiryType(java.lang.String inquiryType) {
		this.inquiryType = inquiryType;
	}


	public java.lang.String getInquiryValue() {
		return inquiryValue;
	}


	public void setInquiryValue(java.lang.String inquiryValue) {
		this.inquiryValue = inquiryValue;
	}


	public java.lang.String getStatus() {
		return status;
	}


	public void setStatus(java.lang.String status) {
		this.status = status;
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


	public java.lang.String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}


	public java.lang.Long getCountid() {
		return countid;
	}


	public void setCountid(java.lang.Long countid) {
		this.countid = countid;
	}


	public java.lang.Long getQuerySuccess() {
		return querySuccess;
	}


	public void setQuerySuccess(java.lang.Long querySuccess) {
		this.querySuccess = querySuccess;
	}


	public java.lang.Long getQuery() {
		return query;
	}


	public void setQuery(java.lang.Long query) {
		this.query = query;
	}


	public java.lang.Long getCheckNoPass() {
		return checkNoPass;
	}


	public void setCheckNoPass(java.lang.Long checkNoPass) {
		this.checkNoPass = checkNoPass;
	}


	public java.lang.Long getQueryDefeat() {
		return queryDefeat;
	}


	public void setQueryDefeat(java.lang.Long queryDefeat) {
		this.queryDefeat = queryDefeat;
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
				+ ((checkNoPass == null) ? 0 : checkNoPass.hashCode());
		result = prime * result + ((countid == null) ? 0 : countid.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((inquiryType == null) ? 0 : inquiryType.hashCode());
		result = prime * result
				+ ((inquiryValue == null) ? 0 : inquiryValue.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result
				+ ((queryDefeat == null) ? 0 : queryDefeat.hashCode());
		result = prime * result
				+ ((querySuccess == null) ? 0 : querySuccess.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
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
		BaseCorpLoancardScurbInfo other = (BaseCorpLoancardScurbInfo) obj;
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
		if (checkNoPass == null) {
			if (other.checkNoPass != null)
				return false;
		} else if (!checkNoPass.equals(other.checkNoPass))
			return false;
		if (countid == null) {
			if (other.countid != null)
				return false;
		} else if (!countid.equals(other.countid))
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
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (queryDefeat == null) {
			if (other.queryDefeat != null)
				return false;
		} else if (!queryDefeat.equals(other.queryDefeat))
			return false;
		if (querySuccess == null) {
			if (other.querySuccess != null)
				return false;
		} else if (!querySuccess.equals(other.querySuccess))
			return false;
		if (returnTime == null) {
			if (other.returnTime != null)
				return false;
		} else if (!returnTime.equals(other.returnTime))
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
		return "BaseCorpLoancardScurbInfo [hashCode=" + hashCode + ", id=" + id
				+ ", appId=" + appId + ", batchId=" + batchId
				+ ", inquiryType=" + inquiryType + ", inquiryValue="
				+ inquiryValue + ", status=" + status + ", inputTime="
				+ inputTime + ", returnTime=" + returnTime + ", createUser="
				+ createUser + ", countid=" + countid + ", querySuccess="
				+ querySuccess + ", query=" + query + ", checkNoPass="
				+ checkNoPass + ", queryDefeat=" + queryDefeat + "]";
	}

	
	
    
}
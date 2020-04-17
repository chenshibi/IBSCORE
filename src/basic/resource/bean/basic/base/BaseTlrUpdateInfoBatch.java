package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="corp_scurb_info"
 */

public abstract class BaseTlrUpdateInfoBatch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7119533364546322409L;
	public static String REF = "TlrUpdateInfoBatch";
	public static String PROP_ID = "id";
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_USER_ID="userId";
    public static String PROP_CITY="city";
    public static String PROP_REGION="region";
    public static String PROP_STATUS="status";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_COUNT_ID="countid";
    public static String PROP_QUERY_SUCCESS="querySuccess";
    public static String PROP_QUERY="query";
    public static String PROP_CHECK_NO_PASS="checkNoPass";
    public static String PROP_QUERT_DEFEAT="queryDefeat";		
    public static String PROP_QUERY_SUCCESS_DETAIL="querySuccessDetail";
    public static String PROP_QUERY_DETAIL="queryDetail";
    public static String PROP_CHECK_NO_PASS_DETAIL="checkNoPassDetail";
    public static String PROP_QUERT_DEFEAT_DETAIL="queryDefeatDetail";
    
    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;


    private java.lang.Integer id;
    private java.lang.Integer batchId;
    private java.lang.String userId;
    // fields
    private java.lang.String city;
    private java.lang.String  region;
    private java.lang.String status;
    private java.util.Date inputTime;
    private java.lang.String createUser;
    private java.lang.Long countid;
    private java.lang.Long querySuccess;
    private java.lang.Long query;
    private java.lang.Long checkNoPass;
    private java.lang.Long queryDefeat;

    private java.lang.Long querySuccessDetail;
    private java.lang.Long queryDetail;
    private java.lang.Long checkNoPassDetail;
    private java.lang.Long queryDefeatDetail;

	public BaseTlrUpdateInfoBatch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseTlrUpdateInfoBatch(int hashCode, Integer id, Integer batchId,
			String userId, String city, String region, String status,
			Date inputTime, String createUser, Long countid, Long querySuccess,
			Long query, Long checkNoPass, Long queryDefeat,
			Long querySuccessDetail, Long queryDetail, Long checkNoPassDetail,
			Long queryDefeatDetail) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.batchId = batchId;
		this.userId = userId;
		this.city = city;
		this.region = region;
		this.status = status;
		this.inputTime = inputTime;
		this.createUser = createUser;
		this.countid = countid;
		this.querySuccess = querySuccess;
		this.query = query;
		this.checkNoPass = checkNoPass;
		this.queryDefeat = queryDefeat;
		this.querySuccessDetail = querySuccessDetail;
		this.queryDetail = queryDetail;
		this.checkNoPassDetail = checkNoPassDetail;
		this.queryDefeatDetail = queryDefeatDetail;
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

	public static String getPROP_BATCH_ID() {
		return PROP_BATCH_ID;
	}

	public static void setPROP_BATCH_ID(String pROP_BATCH_ID) {
		PROP_BATCH_ID = pROP_BATCH_ID;
	}

	public static String getPROP_USER_ID() {
		return PROP_USER_ID;
	}

	public static void setPROP_USER_ID(String pROP_USER_ID) {
		PROP_USER_ID = pROP_USER_ID;
	}

	public static String getPROP_CITY() {
		return PROP_CITY;
	}

	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}

	public static String getPROP_REGION() {
		return PROP_REGION;
	}

	public static void setPROP_REGION(String pROP_REGION) {
		PROP_REGION = pROP_REGION;
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

	public static String getPROP_QUERY_SUCCESS_DETAIL() {
		return PROP_QUERY_SUCCESS_DETAIL;
	}

	public static void setPROP_QUERY_SUCCESS_DETAIL(String pROP_QUERY_SUCCESS_DETAIL) {
		PROP_QUERY_SUCCESS_DETAIL = pROP_QUERY_SUCCESS_DETAIL;
	}

	public static String getPROP_QUERY_DETAIL() {
		return PROP_QUERY_DETAIL;
	}

	public static void setPROP_QUERY_DETAIL(String pROP_QUERY_DETAIL) {
		PROP_QUERY_DETAIL = pROP_QUERY_DETAIL;
	}

	public static String getPROP_CHECK_NO_PASS_DETAIL() {
		return PROP_CHECK_NO_PASS_DETAIL;
	}

	public static void setPROP_CHECK_NO_PASS_DETAIL(String pROP_CHECK_NO_PASS_DETAIL) {
		PROP_CHECK_NO_PASS_DETAIL = pROP_CHECK_NO_PASS_DETAIL;
	}

	public static String getPROP_QUERT_DEFEAT_DETAIL() {
		return PROP_QUERT_DEFEAT_DETAIL;
	}

	public static void setPROP_QUERT_DEFEAT_DETAIL(String pROP_QUERT_DEFEAT_DETAIL) {
		PROP_QUERT_DEFEAT_DETAIL = pROP_QUERT_DEFEAT_DETAIL;
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

	public java.lang.Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(java.lang.Integer batchId) {
		this.batchId = batchId;
	}

	public java.lang.String getUserId() {
		return userId;
	}

	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}

	public java.lang.String getCity() {
		return city;
	}

	public void setCity(java.lang.String city) {
		this.city = city;
	}

	public java.lang.String getRegion() {
		return region;
	}

	public void setRegion(java.lang.String region) {
		this.region = region;
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

	public java.lang.Long getQuerySuccessDetail() {
		return querySuccessDetail;
	}

	public void setQuerySuccessDetail(java.lang.Long querySuccessDetail) {
		this.querySuccessDetail = querySuccessDetail;
	}

	public java.lang.Long getQueryDetail() {
		return queryDetail;
	}

	public void setQueryDetail(java.lang.Long queryDetail) {
		this.queryDetail = queryDetail;
	}

	public java.lang.Long getCheckNoPassDetail() {
		return checkNoPassDetail;
	}

	public void setCheckNoPassDetail(java.lang.Long checkNoPassDetail) {
		this.checkNoPassDetail = checkNoPassDetail;
	}

	public java.lang.Long getQueryDefeatDetail() {
		return queryDefeatDetail;
	}

	public void setQueryDefeatDetail(java.lang.Long queryDefeatDetail) {
		this.queryDefeatDetail = queryDefeatDetail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BaseTlrUpdateInfoBatch [hashCode=" + hashCode + ", id=" + id
				+ ", batchId=" + batchId + ", userId=" + userId + ", city="
				+ city + ", region=" + region + ", status=" + status
				+ ", inputTime=" + inputTime + ", createUser=" + createUser
				+ ", countid=" + countid + ", querySuccess=" + querySuccess
				+ ", query=" + query + ", checkNoPass=" + checkNoPass
				+ ", queryDefeat=" + queryDefeat + ", querySuccessDetail="
				+ querySuccessDetail + ", queryDetail=" + queryDetail
				+ ", checkNoPassDetail=" + checkNoPassDetail
				+ ", queryDefeatDetail=" + queryDefeatDetail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((checkNoPass == null) ? 0 : checkNoPass.hashCode());
		result = prime
				* result
				+ ((checkNoPassDetail == null) ? 0 : checkNoPassDetail
						.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((countid == null) ? 0 : countid.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result
				+ ((queryDefeat == null) ? 0 : queryDefeat.hashCode());
		result = prime
				* result
				+ ((queryDefeatDetail == null) ? 0 : queryDefeatDetail
						.hashCode());
		result = prime * result
				+ ((queryDetail == null) ? 0 : queryDetail.hashCode());
		result = prime * result
				+ ((querySuccess == null) ? 0 : querySuccess.hashCode());
		result = prime
				* result
				+ ((querySuccessDetail == null) ? 0 : querySuccessDetail
						.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		BaseTlrUpdateInfoBatch other = (BaseTlrUpdateInfoBatch) obj;
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
		if (checkNoPassDetail == null) {
			if (other.checkNoPassDetail != null)
				return false;
		} else if (!checkNoPassDetail.equals(other.checkNoPassDetail))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
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
		if (queryDefeatDetail == null) {
			if (other.queryDefeatDetail != null)
				return false;
		} else if (!queryDefeatDetail.equals(other.queryDefeatDetail))
			return false;
		if (queryDetail == null) {
			if (other.queryDetail != null)
				return false;
		} else if (!queryDetail.equals(other.queryDetail))
			return false;
		if (querySuccess == null) {
			if (other.querySuccess != null)
				return false;
		} else if (!querySuccess.equals(other.querySuccess))
			return false;
		if (querySuccessDetail == null) {
			if (other.querySuccessDetail != null)
				return false;
		} else if (!querySuccessDetail.equals(other.querySuccessDetail))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	
	
    
}
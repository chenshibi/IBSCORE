package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="ind_scrub_info"
 */

public abstract class BaseIndScrubInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3064933743739247331L;
	public static String REF = "IndScrubInfo";
	public static String PROP_ID = "id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_LOAN_NO="loanNo";
    public static String PROP_RELATIONSHIP_NO="relationshipNo";
    public static String PROP_APPLICATION_NO="applicationNo";
    public static String PROP_STATUS="status";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_RETURN_TIME="returnTime";
    public static String PROP_APP_ID="appId";
    
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_NAME="name";
    public static String PROP_INDIVIDUAL="individual";
    public static String PROP_INDIVIDUAL_TYPE="individualType";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_COUNT_ID="countid";
    public static String PROP_QUERY_SUCCESS="querySuccess";
    public static String PROP_QUERY="query";
    public static String PROP_CHECK_NO_PASS="checkNoPass";
    public static String PROP_QUERT_DEFEAT="queryDefeat";		
    

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;


    private java.lang.String createUser;
    private java.lang.String name;
    private java.lang.String individual;
    private java.lang.String individualType;
    private java.lang.String queryReason;
    
    private java.lang.Integer id;
    private java.lang.String rptId;
    private java.lang.Integer batchId;
    private java.lang.String loanNo;
    // fields
    private java.lang.String relationshipNo;
    private java.lang.String  applicationNo;
    private java.lang.String  status;
    private java.util.Date inputTime;
    private  java.util.Date returnTime;
    private java.lang.Integer appId;
    
    private java.lang.Long countid;
    private java.lang.Long querySuccess;
    private java.lang.Long query;
    private java.lang.Long checkNoPass;
    private java.lang.Long queryDefeat;


	public BaseIndScrubInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BaseIndScrubInfo(int hashCode, String createUser, String name,
			String individual, String individualType, String queryReason,
			Integer id, String rptId, Integer batchId, String loanNo,
			String relationshipNo, String applicationNo, String status,
			Date inputTime, Date returnTime, Integer appId, Long countid,
			Long querySuccess, Long query, Long checkNoPass, Long queryDefeat) {
		super();
		this.hashCode = hashCode;
		this.createUser = createUser;
		this.name = name;
		this.individual = individual;
		this.individualType = individualType;
		this.queryReason = queryReason;
		this.id = id;
		this.rptId = rptId;
		this.batchId = batchId;
		this.loanNo = loanNo;
		this.relationshipNo = relationshipNo;
		this.applicationNo = applicationNo;
		this.status = status;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.appId = appId;
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


	public static String getPROP_RPT_ID() {
		return PROP_RPT_ID;
	}


	public static void setPROP_RPT_ID(String pROP_RPT_ID) {
		PROP_RPT_ID = pROP_RPT_ID;
	}


	public static String getPROP_BATCH_ID() {
		return PROP_BATCH_ID;
	}


	public static void setPROP_BATCH_ID(String pROP_BATCH_ID) {
		PROP_BATCH_ID = pROP_BATCH_ID;
	}


	public static String getPROP_LOAN_NO() {
		return PROP_LOAN_NO;
	}


	public static void setPROP_LOAN_NO(String pROP_LOAN_NO) {
		PROP_LOAN_NO = pROP_LOAN_NO;
	}


	public static String getPROP_RELATIONSHIP_NO() {
		return PROP_RELATIONSHIP_NO;
	}


	public static void setPROP_RELATIONSHIP_NO(String pROP_RELATIONSHIP_NO) {
		PROP_RELATIONSHIP_NO = pROP_RELATIONSHIP_NO;
	}


	public static String getPROP_APPLICATION_NO() {
		return PROP_APPLICATION_NO;
	}


	public static void setPROP_APPLICATION_NO(String pROP_APPLICATION_NO) {
		PROP_APPLICATION_NO = pROP_APPLICATION_NO;
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


	public static String getPROP_APP_ID() {
		return PROP_APP_ID;
	}


	public static void setPROP_APP_ID(String pROP_APP_ID) {
		PROP_APP_ID = pROP_APP_ID;
	}


	public static String getPROP_CREATE_USER() {
		return PROP_CREATE_USER;
	}


	public static void setPROP_CREATE_USER(String pROP_CREATE_USER) {
		PROP_CREATE_USER = pROP_CREATE_USER;
	}


	public static String getPROP_NAME() {
		return PROP_NAME;
	}


	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}


	public static String getPROP_INDIVIDUAL() {
		return PROP_INDIVIDUAL;
	}


	public static void setPROP_INDIVIDUAL(String pROP_INDIVIDUAL) {
		PROP_INDIVIDUAL = pROP_INDIVIDUAL;
	}


	public static String getPROP_INDIVIDUAL_TYPE() {
		return PROP_INDIVIDUAL_TYPE;
	}


	public static void setPROP_INDIVIDUAL_TYPE(String pROP_INDIVIDUAL_TYPE) {
		PROP_INDIVIDUAL_TYPE = pROP_INDIVIDUAL_TYPE;
	}


	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}


	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
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


	public java.lang.String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}


	public java.lang.String getName() {
		return name;
	}


	public void setName(java.lang.String name) {
		this.name = name;
	}


	public java.lang.String getIndividual() {
		return individual;
	}


	public void setIndividual(java.lang.String individual) {
		this.individual = individual;
	}


	public java.lang.String getIndividualType() {
		return individualType;
	}


	public void setIndividualType(java.lang.String individualType) {
		this.individualType = individualType;
	}


	public java.lang.String getQueryReason() {
		return queryReason;
	}


	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}


	public java.lang.Integer getId() {
		return id;
	}


	public void setId(java.lang.Integer id) {
		this.id = id;
	}


	public java.lang.String getRptId() {
		return rptId;
	}


	public void setRptId(java.lang.String rptId) {
		this.rptId = rptId;
	}


	public java.lang.Integer getBatchId() {
		return batchId;
	}


	public void setBatchId(java.lang.Integer batchId) {
		this.batchId = batchId;
	}


	public java.lang.String getLoanNo() {
		return loanNo;
	}


	public void setLoanNo(java.lang.String loanNo) {
		this.loanNo = loanNo;
	}


	public java.lang.String getRelationshipNo() {
		return relationshipNo;
	}


	public void setRelationshipNo(java.lang.String relationshipNo) {
		this.relationshipNo = relationshipNo;
	}


	public java.lang.String getApplicationNo() {
		return applicationNo;
	}


	public void setApplicationNo(java.lang.String applicationNo) {
		this.applicationNo = applicationNo;
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


	public java.lang.Integer getAppId() {
		return appId;
	}


	public void setAppId(java.lang.Integer appId) {
		this.appId = appId;
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
		result = prime * result
				+ ((applicationNo == null) ? 0 : applicationNo.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((checkNoPass == null) ? 0 : checkNoPass.hashCode());
		result = prime * result + ((countid == null) ? 0 : countid.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((individual == null) ? 0 : individual.hashCode());
		result = prime * result
				+ ((individualType == null) ? 0 : individualType.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((loanNo == null) ? 0 : loanNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result
				+ ((queryDefeat == null) ? 0 : queryDefeat.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((querySuccess == null) ? 0 : querySuccess.hashCode());
		result = prime * result
				+ ((relationshipNo == null) ? 0 : relationshipNo.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
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
		BaseIndScrubInfo other = (BaseIndScrubInfo) obj;
		if (appId == null) {
			if (other.appId != null)
				return false;
		} else if (!appId.equals(other.appId))
			return false;
		if (applicationNo == null) {
			if (other.applicationNo != null)
				return false;
		} else if (!applicationNo.equals(other.applicationNo))
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
		if (individual == null) {
			if (other.individual != null)
				return false;
		} else if (!individual.equals(other.individual))
			return false;
		if (individualType == null) {
			if (other.individualType != null)
				return false;
		} else if (!individualType.equals(other.individualType))
			return false;
		if (inputTime == null) {
			if (other.inputTime != null)
				return false;
		} else if (!inputTime.equals(other.inputTime))
			return false;
		if (loanNo == null) {
			if (other.loanNo != null)
				return false;
		} else if (!loanNo.equals(other.loanNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (queryReason == null) {
			if (other.queryReason != null)
				return false;
		} else if (!queryReason.equals(other.queryReason))
			return false;
		if (querySuccess == null) {
			if (other.querySuccess != null)
				return false;
		} else if (!querySuccess.equals(other.querySuccess))
			return false;
		if (relationshipNo == null) {
			if (other.relationshipNo != null)
				return false;
		} else if (!relationshipNo.equals(other.relationshipNo))
			return false;
		if (returnTime == null) {
			if (other.returnTime != null)
				return false;
		} else if (!returnTime.equals(other.returnTime))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
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
		return "BaseIndScrubInfo [hashCode=" + hashCode + ", createUser="
				+ createUser + ", name=" + name + ", individual=" + individual
				+ ", individualType=" + individualType + ", queryReason="
				+ queryReason + ", id=" + id + ", rptId=" + rptId
				+ ", batchId=" + batchId + ", loanNo=" + loanNo
				+ ", relationshipNo=" + relationshipNo + ", applicationNo="
				+ applicationNo + ", status=" + status + ", inputTime="
				+ inputTime + ", returnTime=" + returnTime + ", appId=" + appId
				+ ", countid=" + countid + ", querySuccess=" + querySuccess
				+ ", query=" + query + ", checkNoPass=" + checkNoPass
				+ ", queryDefeat=" + queryDefeat + "]";
	}

    
    
    
}
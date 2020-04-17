package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.TCorpUploadBean;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="corp_scurb_info"
 */

public abstract class BaseCorpScurbInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4267371232544705564L;
	public static String REF = "CorpScrubInfo";
	public static String PROP_ID = "id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_BATCH_ID="batchId";
    public static String PROP_NAME="name";
    public static String PROP_LOAN_CARD="loancard";
    public static String PROP_PASSWORD="password";
    public static String PROP_ORG_CODE="orgcode";
    public static String PROP_LOAN_NO="loanNo";
    public static String PROP_STATUS="status";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_RETURN_TIME="returnTime";
    public static String PROP_DETAIL_APP_ID="detailAppId";
    public static String PROP_APP_ID="appId";
    public static String PROP_DETAIL_STATUS="Detailstatus";
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
    private java.lang.String rptKey;
    private java.lang.Integer batchId;
    private java.lang.String name;
    // fields
    private java.lang.String loancard;
    private java.lang.String  password;
    private java.lang.String orgcode;
    private java.lang.String loanNo;
    private java.lang.String  status;
    private java.lang.String queryReason;
    private java.lang.String  createUser;
    private java.util.Date inputTime;
    private  java.util.Date returnTime;
    private java.lang.Integer detailAppId;
    private java.lang.Integer appId;
    private java.lang.String  Detailstatus;
    private java.lang.Long countid;
    private java.lang.Long querySuccess;
    private java.lang.Long query;
    private java.lang.Long checkNoPass;
    private java.lang.Long queryDefeat;

    private java.lang.Long querySuccessDetail;
    private java.lang.Long queryDetail;
    private java.lang.Long checkNoPassDetail;
    private java.lang.Long queryDefeatDetail;

	public BaseCorpScurbInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaseCorpScurbInfo(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String loancard, String password,
			String orgcode, String loanNo, String status, String queryReason,
			String createUser, Date inputTime, Date returnTime,
			Integer detailAppId, Integer appId, String detailstatus,
			Long countid, Long querySuccess, Long query, Long checkNoPass,
			Long queryDefeat, Long querySuccessDetail, Long queryDetail,
			Long checkNoPassDetail, Long queryDefeatDetail) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.batchId = batchId;
		this.name = name;
		this.loancard = loancard;
		this.password = password;
		this.orgcode = orgcode;
		this.loanNo = loanNo;
		this.status = status;
		this.queryReason = queryReason;
		this.createUser = createUser;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.detailAppId = detailAppId;
		this.appId = appId;
		Detailstatus = detailstatus;
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

	public static String getPROP_LOAN_CARD() {
		return PROP_LOAN_CARD;
	}

	public static void setPROP_LOAN_CARD(String pROP_LOAN_CARD) {
		PROP_LOAN_CARD = pROP_LOAN_CARD;
	}

	public static String getPROP_PASSWORD() {
		return PROP_PASSWORD;
	}

	public static void setPROP_PASSWORD(String pROP_PASSWORD) {
		PROP_PASSWORD = pROP_PASSWORD;
	}

	public static String getPROP_ORG_CODE() {
		return PROP_ORG_CODE;
	}

	public static void setPROP_ORG_CODE(String pROP_ORG_CODE) {
		PROP_ORG_CODE = pROP_ORG_CODE;
	}

	public static String getPROP_LOAN_NO() {
		return PROP_LOAN_NO;
	}

	public static void setPROP_LOAN_NO(String pROP_LOAN_NO) {
		PROP_LOAN_NO = pROP_LOAN_NO;
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

	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}

	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
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

	public static String getPROP_DETAIL_APP_ID() {
		return PROP_DETAIL_APP_ID;
	}

	public static void setPROP_DETAIL_APP_ID(String pROP_DETAIL_APP_ID) {
		PROP_DETAIL_APP_ID = pROP_DETAIL_APP_ID;
	}

	public static String getPROP_APP_ID() {
		return PROP_APP_ID;
	}

	public static void setPROP_APP_ID(String pROP_APP_ID) {
		PROP_APP_ID = pROP_APP_ID;
	}

	public static String getPROP_DETAIL_STATUS() {
		return PROP_DETAIL_STATUS;
	}

	public static void setPROP_DETAIL_STATUS(String pROP_DETAIL_STATUS) {
		PROP_DETAIL_STATUS = pROP_DETAIL_STATUS;
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

	public java.lang.String getLoancard() {
		return loancard;
	}

	public void setLoancard(java.lang.String loancard) {
		this.loancard = loancard;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(java.lang.String orgcode) {
		this.orgcode = orgcode;
	}

	public java.lang.String getLoanNo() {
		return loanNo;
	}

	public void setLoanNo(java.lang.String loanNo) {
		this.loanNo = loanNo;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
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

	public java.lang.Integer getDetailAppId() {
		return detailAppId;
	}

	public void setDetailAppId(java.lang.Integer detailAppId) {
		this.detailAppId = detailAppId;
	}

	public java.lang.Integer getAppId() {
		return appId;
	}

	public void setAppId(java.lang.Integer appId) {
		this.appId = appId;
	}

	public java.lang.String getDetailstatus() {
		return Detailstatus;
	}

	public void setDetailstatus(java.lang.String detailstatus) {
		Detailstatus = detailstatus;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((Detailstatus == null) ? 0 : Detailstatus.hashCode());
		result = prime * result + ((appId == null) ? 0 : appId.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((checkNoPass == null) ? 0 : checkNoPass.hashCode());
		result = prime
				* result
				+ ((checkNoPassDetail == null) ? 0 : checkNoPassDetail
						.hashCode());
		result = prime * result + ((countid == null) ? 0 : countid.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((detailAppId == null) ? 0 : detailAppId.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((loanNo == null) ? 0 : loanNo.hashCode());
		result = prime * result
				+ ((loancard == null) ? 0 : loancard.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((orgcode == null) ? 0 : orgcode.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
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
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((querySuccess == null) ? 0 : querySuccess.hashCode());
		result = prime
				* result
				+ ((querySuccessDetail == null) ? 0 : querySuccessDetail
						.hashCode());
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
		BaseCorpScurbInfo other = (BaseCorpScurbInfo) obj;
		if (Detailstatus == null) {
			if (other.Detailstatus != null)
				return false;
		} else if (!Detailstatus.equals(other.Detailstatus))
			return false;
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
		if (checkNoPassDetail == null) {
			if (other.checkNoPassDetail != null)
				return false;
		} else if (!checkNoPassDetail.equals(other.checkNoPassDetail))
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
		if (detailAppId == null) {
			if (other.detailAppId != null)
				return false;
		} else if (!detailAppId.equals(other.detailAppId))
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
		if (loanNo == null) {
			if (other.loanNo != null)
				return false;
		} else if (!loanNo.equals(other.loanNo))
			return false;
		if (loancard == null) {
			if (other.loancard != null)
				return false;
		} else if (!loancard.equals(other.loancard))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (orgcode == null) {
			if (other.orgcode != null)
				return false;
		} else if (!orgcode.equals(other.orgcode))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (querySuccessDetail == null) {
			if (other.querySuccessDetail != null)
				return false;
		} else if (!querySuccessDetail.equals(other.querySuccessDetail))
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
		return "BaseCorpScurbInfo [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", batchId=" + batchId + ", name="
				+ name + ", loancard=" + loancard + ", password=" + password
				+ ", orgcode=" + orgcode + ", loanNo=" + loanNo + ", status="
				+ status + ", queryReason=" + queryReason + ", createUser="
				+ createUser + ", inputTime=" + inputTime + ", returnTime="
				+ returnTime + ", detailAppId=" + detailAppId + ", appId="
				+ appId + ", Detailstatus=" + Detailstatus + ", countid="
				+ countid + ", querySuccess=" + querySuccess + ", query="
				+ query + ", checkNoPass=" + checkNoPass + ", queryDefeat="
				+ queryDefeat + ", querySuccessDetail=" + querySuccessDetail
				+ ", queryDetail=" + queryDetail + ", checkNoPassDetail="
				+ checkNoPassDetail + ", queryDefeatDetail="
				+ queryDefeatDetail + "]";
	}

	
	
	
    
}
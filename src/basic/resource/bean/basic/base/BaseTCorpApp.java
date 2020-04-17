package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpApp implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 887494355297202088L;
	public static String REF = "TCorpApp";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_LOANCARD_NO="loanCardNo";
    public static String PROP_LOANCARD_PASS="loanCardPass";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_TYPE="type";
    public static String PROP_STATUS="status";
    public static String PROP_STATUS_MSG="statusMsg";
    public static String PROP_INPUT_TIME="inputTime";
	public static String PROP_QUERY_TIME="queryTime";
	public static String PROP_RETURN_TIME="returnTime";
	public static String PROP_PARSED_TIME="parsedTime";
	public static String PROP_BATCH_ID="batchId";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String loanCardNo;
    private java.lang.String loanCardPass;
    private java.lang.String queryReason;
    private java.lang.String type;
    private java.lang.String status;
    private java.lang.String statusMsg;
    private java.util.Date inputTime;
    private java.util.Date returnTime;
    private java.util.Date parsedTime;
    private java.lang.Integer batchId;
    private java.lang.String uploadedFilePath;
    private java.util.Date queryTime;



	public BaseTCorpApp() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BaseTCorpApp(int hashCode, Integer id, String rptKey,
			Date createTime, String loanCardNo, String loanCardPass,
			String queryReason, String type, String status, String statusMsg,
			Date inputTime, Date returnTime, Date parsedTime, Integer batchId,
			String uploadedFilePath, Date queryTime) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.loanCardNo = loanCardNo;
		this.loanCardPass = loanCardPass;
		this.queryReason = queryReason;
		this.type = type;
		this.status = status;
		this.statusMsg = statusMsg;
		this.inputTime = inputTime;
		this.returnTime = returnTime;
		this.parsedTime = parsedTime;
		this.batchId = batchId;
		this.uploadedFilePath = uploadedFilePath;
		this.queryTime = queryTime;
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



	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}



	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}



	public static String getPROP_LOANCARD_NO() {
		return PROP_LOANCARD_NO;
	}



	public static void setPROP_LOANCARD_NO(String pROP_LOANCARD_NO) {
		PROP_LOANCARD_NO = pROP_LOANCARD_NO;
	}



	public static String getPROP_LOANCARD_PASS() {
		return PROP_LOANCARD_PASS;
	}



	public static void setPROP_LOANCARD_PASS(String pROP_LOANCARD_PASS) {
		PROP_LOANCARD_PASS = pROP_LOANCARD_PASS;
	}



	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}



	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
	}



	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}



	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}



	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}



	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}



	public static String getPROP_STATUS_MSG() {
		return PROP_STATUS_MSG;
	}



	public static void setPROP_STATUS_MSG(String pROP_STATUS_MSG) {
		PROP_STATUS_MSG = pROP_STATUS_MSG;
	}



	public static String getPROP_INPUT_TIME() {
		return PROP_INPUT_TIME;
	}



	public static void setPROP_INPUT_TIME(String pROP_INPUT_TIME) {
		PROP_INPUT_TIME = pROP_INPUT_TIME;
	}



	public static String getPROP_QUERY_TIME() {
		return PROP_QUERY_TIME;
	}



	public static void setPROP_QUERY_TIME(String pROP_QUERY_TIME) {
		PROP_QUERY_TIME = pROP_QUERY_TIME;
	}



	public static String getPROP_RETURN_TIME() {
		return PROP_RETURN_TIME;
	}



	public static void setPROP_RETURN_TIME(String pROP_RETURN_TIME) {
		PROP_RETURN_TIME = pROP_RETURN_TIME;
	}



	public static String getPROP_PARSED_TIME() {
		return PROP_PARSED_TIME;
	}



	public static void setPROP_PARSED_TIME(String pROP_PARSED_TIME) {
		PROP_PARSED_TIME = pROP_PARSED_TIME;
	}



	public static String getPROP_BATCH_ID() {
		return PROP_BATCH_ID;
	}



	public static void setPROP_BATCH_ID(String pROP_BATCH_ID) {
		PROP_BATCH_ID = pROP_BATCH_ID;
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



	public java.util.Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}



	public java.lang.String getLoanCardNo() {
		return loanCardNo;
	}



	public void setLoanCardNo(java.lang.String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}



	public java.lang.String getLoanCardPass() {
		return loanCardPass;
	}



	public void setLoanCardPass(java.lang.String loanCardPass) {
		this.loanCardPass = loanCardPass;
	}



	public java.lang.String getQueryReason() {
		return queryReason;
	}



	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}



	public java.lang.String getType() {
		return type;
	}



	public void setType(java.lang.String type) {
		this.type = type;
	}



	public java.lang.String getStatus() {
		return status;
	}



	public void setStatus(java.lang.String status) {
		this.status = status;
	}



	public java.lang.String getStatusMsg() {
		return statusMsg;
	}



	public void setStatusMsg(java.lang.String statusMsg) {
		this.statusMsg = statusMsg;
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



	public java.util.Date getParsedTime() {
		return parsedTime;
	}



	public void setParsedTime(java.util.Date parsedTime) {
		this.parsedTime = parsedTime;
	}



	public java.lang.Integer getBatchId() {
		return batchId;
	}



	public void setBatchId(java.lang.Integer batchId) {
		this.batchId = batchId;
	}



	public java.lang.String getUploadedFilePath() {
		return uploadedFilePath;
	}



	public void setUploadedFilePath(java.lang.String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}



	public java.util.Date getQueryTime() {
		return queryTime;
	}



	public void setQueryTime(java.util.Date queryTime) {
		this.queryTime = queryTime;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((loanCardNo == null) ? 0 : loanCardNo.hashCode());
		result = prime * result
				+ ((loanCardPass == null) ? 0 : loanCardPass.hashCode());
		result = prime * result
				+ ((parsedTime == null) ? 0 : parsedTime.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((queryTime == null) ? 0 : queryTime.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((statusMsg == null) ? 0 : statusMsg.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime
				* result
				+ ((uploadedFilePath == null) ? 0 : uploadedFilePath.hashCode());
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
		BaseTCorpApp other = (BaseTCorpApp) obj;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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
		if (loanCardNo == null) {
			if (other.loanCardNo != null)
				return false;
		} else if (!loanCardNo.equals(other.loanCardNo))
			return false;
		if (loanCardPass == null) {
			if (other.loanCardPass != null)
				return false;
		} else if (!loanCardPass.equals(other.loanCardPass))
			return false;
		if (parsedTime == null) {
			if (other.parsedTime != null)
				return false;
		} else if (!parsedTime.equals(other.parsedTime))
			return false;
		if (queryReason == null) {
			if (other.queryReason != null)
				return false;
		} else if (!queryReason.equals(other.queryReason))
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
		if (statusMsg == null) {
			if (other.statusMsg != null)
				return false;
		} else if (!statusMsg.equals(other.statusMsg))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (uploadedFilePath == null) {
			if (other.uploadedFilePath != null)
				return false;
		} else if (!uploadedFilePath.equals(other.uploadedFilePath))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "BaseTCorpApp [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", createTime=" + createTime
				+ ", loanCardNo=" + loanCardNo + ", loanCardPass="
				+ loanCardPass + ", queryReason=" + queryReason + ", type="
				+ type + ", status=" + status + ", statusMsg=" + statusMsg
				+ ", inputTime=" + inputTime + ", returnTime=" + returnTime
				+ ", parsedTime=" + parsedTime + ", batchId=" + batchId
				+ ", uploadedFilePath=" + uploadedFilePath + ", queryTime="
				+ queryTime + "]";
	}



	
    
	
    
    
}
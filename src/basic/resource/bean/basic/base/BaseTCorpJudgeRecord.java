package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.Bctl;

/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpJudgeRecord implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpPublicOweTax";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_COURT="court";
    public static String PROP_JUDGE_DATE="judgeDate";
    public static String PROP_JUDGE_REASON="judgeReason";
    public static String PROP_JUDGE_PARTY="judgeParty";
    public static String PROP_CASE_NO="caseNo";
    public static String PROP_JUDGE_PROCESS="judgeProcess";
    public static String PROP_JUDGE_OBJECT="judgeObject";
    public static String PROP_OBJECT_VALUE="objectValue";
    public static String PROP_CASE_CLOSE_MODE="caseCloseMode";
    public static String PROP_JUDGE_EFF_DATE="judgeEffDate";
    public static String PROP_JUDGE_RESULT="judgeResult";
    public static String PROP_CASE_STATUS="caseStatus";
    public static String PROP_EXECUTED_OBJECT="executedObject";
    public static String PROP_EXECUTED_OBJECT_VALUE="executedObjectValue";
	public BaseTCorpJudgeRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.String court;
    private java.lang.String judgeDate;
    private java.lang.String judgeReason;
    private java.lang.String judgeParty;
    private java.lang.String caseNo;
    private java.lang.String judgeProcess;
    private java.lang.String judgeObject;
    private java.lang.String objectValue;
    private java.lang.String caseCloseMode;
    private java.lang.String judgeEffDate;
    private java.lang.String judgeResult;
    private java.lang.String caseStatus;
    private java.lang.String executedObject;
    private java.lang.String executedObjectValue;
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
	public static String getPROP_ITEM_NAME() {
		return PROP_ITEM_NAME;
	}
	public static void setPROP_ITEM_NAME(String pROP_ITEM_NAME) {
		PROP_ITEM_NAME = pROP_ITEM_NAME;
	}
	public static String getPROP_COURT() {
		return PROP_COURT;
	}
	public static void setPROP_COURT(String pROP_COURT) {
		PROP_COURT = pROP_COURT;
	}
	public static String getPROP_JUDGE_DATE() {
		return PROP_JUDGE_DATE;
	}
	public static void setPROP_JUDGE_DATE(String pROP_JUDGE_DATE) {
		PROP_JUDGE_DATE = pROP_JUDGE_DATE;
	}
	public static String getPROP_JUDGE_REASON() {
		return PROP_JUDGE_REASON;
	}
	public static void setPROP_JUDGE_REASON(String pROP_JUDGE_REASON) {
		PROP_JUDGE_REASON = pROP_JUDGE_REASON;
	}
	public static String getPROP_JUDGE_PARTY() {
		return PROP_JUDGE_PARTY;
	}
	public static void setPROP_JUDGE_PARTY(String pROP_JUDGE_PARTY) {
		PROP_JUDGE_PARTY = pROP_JUDGE_PARTY;
	}
	public static String getPROP_CASE_NO() {
		return PROP_CASE_NO;
	}
	public static void setPROP_CASE_NO(String pROP_CASE_NO) {
		PROP_CASE_NO = pROP_CASE_NO;
	}
	public static String getPROP_JUDGE_PROCESS() {
		return PROP_JUDGE_PROCESS;
	}
	public static void setPROP_JUDGE_PROCESS(String pROP_JUDGE_PROCESS) {
		PROP_JUDGE_PROCESS = pROP_JUDGE_PROCESS;
	}
	public static String getPROP_JUDGE_OBJECT() {
		return PROP_JUDGE_OBJECT;
	}
	public static void setPROP_JUDGE_OBJECT(String pROP_JUDGE_OBJECT) {
		PROP_JUDGE_OBJECT = pROP_JUDGE_OBJECT;
	}
	public static String getPROP_OBJECT_VALUE() {
		return PROP_OBJECT_VALUE;
	}
	public static void setPROP_OBJECT_VALUE(String pROP_OBJECT_VALUE) {
		PROP_OBJECT_VALUE = pROP_OBJECT_VALUE;
	}
	public static String getPROP_CASE_CLOSE_MODE() {
		return PROP_CASE_CLOSE_MODE;
	}
	public static void setPROP_CASE_CLOSE_MODE(String pROP_CASE_CLOSE_MODE) {
		PROP_CASE_CLOSE_MODE = pROP_CASE_CLOSE_MODE;
	}
	public static String getPROP_JUDGE_EFF_DATE() {
		return PROP_JUDGE_EFF_DATE;
	}
	public static void setPROP_JUDGE_EFF_DATE(String pROP_JUDGE_EFF_DATE) {
		PROP_JUDGE_EFF_DATE = pROP_JUDGE_EFF_DATE;
	}
	public static String getPROP_JUDGE_RESULT() {
		return PROP_JUDGE_RESULT;
	}
	public static void setPROP_JUDGE_RESULT(String pROP_JUDGE_RESULT) {
		PROP_JUDGE_RESULT = pROP_JUDGE_RESULT;
	}
	public static String getPROP_CASE_STATUS() {
		return PROP_CASE_STATUS;
	}
	public static void setPROP_CASE_STATUS(String pROP_CASE_STATUS) {
		PROP_CASE_STATUS = pROP_CASE_STATUS;
	}
	public static String getPROP_EXECUTED_OBJECT() {
		return PROP_EXECUTED_OBJECT;
	}
	public static void setPROP_EXECUTED_OBJECT(String pROP_EXECUTED_OBJECT) {
		PROP_EXECUTED_OBJECT = pROP_EXECUTED_OBJECT;
	}
	public static String getPROP_EXECUTED_OBJECT_VALUE() {
		return PROP_EXECUTED_OBJECT_VALUE;
	}
	public static void setPROP_EXECUTED_OBJECT_VALUE(
			String pROP_EXECUTED_OBJECT_VALUE) {
		PROP_EXECUTED_OBJECT_VALUE = pROP_EXECUTED_OBJECT_VALUE;
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
	public java.lang.String getItemName() {
		return itemName;
	}
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	public java.lang.String getCourt() {
		return court;
	}
	public void setCourt(java.lang.String court) {
		this.court = court;
	}
	public java.lang.String getJudgeDate() {
		return judgeDate;
	}
	public void setJudgeDate(java.lang.String judgeDate) {
		this.judgeDate = judgeDate;
	}
	public java.lang.String getJudgeReason() {
		return judgeReason;
	}
	public void setJudgeReason(java.lang.String judgeReason) {
		this.judgeReason = judgeReason;
	}
	public java.lang.String getJudgeParty() {
		return judgeParty;
	}
	public void setJudgeParty(java.lang.String judgeParty) {
		this.judgeParty = judgeParty;
	}
	public java.lang.String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(java.lang.String caseNo) {
		this.caseNo = caseNo;
	}
	public java.lang.String getJudgeProcess() {
		return judgeProcess;
	}
	public void setJudgeProcess(java.lang.String judgeProcess) {
		this.judgeProcess = judgeProcess;
	}
	public java.lang.String getJudgeObject() {
		return judgeObject;
	}
	public void setJudgeObject(java.lang.String judgeObject) {
		this.judgeObject = judgeObject;
	}
	public java.lang.String getObjectValue() {
		return objectValue;
	}
	public void setObjectValue(java.lang.String objectValue) {
		this.objectValue = objectValue;
	}
	public java.lang.String getCaseCloseMode() {
		return caseCloseMode;
	}
	public void setCaseCloseMode(java.lang.String caseCloseMode) {
		this.caseCloseMode = caseCloseMode;
	}
	public java.lang.String getJudgeEffDate() {
		return judgeEffDate;
	}
	public void setJudgeEffDate(java.lang.String judgeEffDate) {
		this.judgeEffDate = judgeEffDate;
	}
	public java.lang.String getJudgeResult() {
		return judgeResult;
	}
	public void setJudgeResult(java.lang.String judgeResult) {
		this.judgeResult = judgeResult;
	}
	public java.lang.String getCaseStatus() {
		return caseStatus;
	}
	public void setCaseStatus(java.lang.String caseStatus) {
		this.caseStatus = caseStatus;
	}
	public java.lang.String getExecutedObject() {
		return executedObject;
	}
	public void setExecutedObject(java.lang.String executedObject) {
		this.executedObject = executedObject;
	}
	public java.lang.String getExecutedObjectValue() {
		return executedObjectValue;
	}
	public void setExecutedObjectValue(java.lang.String executedObjectValue) {
		this.executedObjectValue = executedObjectValue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((caseCloseMode == null) ? 0 : caseCloseMode.hashCode());
		result = prime * result + ((caseNo == null) ? 0 : caseNo.hashCode());
		result = prime * result
				+ ((caseStatus == null) ? 0 : caseStatus.hashCode());
		result = prime * result + ((court == null) ? 0 : court.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((executedObject == null) ? 0 : executedObject.hashCode());
		result = prime
				* result
				+ ((executedObjectValue == null) ? 0 : executedObjectValue
						.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((judgeDate == null) ? 0 : judgeDate.hashCode());
		result = prime * result
				+ ((judgeEffDate == null) ? 0 : judgeEffDate.hashCode());
		result = prime * result
				+ ((judgeObject == null) ? 0 : judgeObject.hashCode());
		result = prime * result
				+ ((judgeParty == null) ? 0 : judgeParty.hashCode());
		result = prime * result
				+ ((judgeProcess == null) ? 0 : judgeProcess.hashCode());
		result = prime * result
				+ ((judgeReason == null) ? 0 : judgeReason.hashCode());
		result = prime * result
				+ ((judgeResult == null) ? 0 : judgeResult.hashCode());
		result = prime * result
				+ ((objectValue == null) ? 0 : objectValue.hashCode());
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
		BaseTCorpJudgeRecord other = (BaseTCorpJudgeRecord) obj;
		if (caseCloseMode == null) {
			if (other.caseCloseMode != null)
				return false;
		} else if (!caseCloseMode.equals(other.caseCloseMode))
			return false;
		if (caseNo == null) {
			if (other.caseNo != null)
				return false;
		} else if (!caseNo.equals(other.caseNo))
			return false;
		if (caseStatus == null) {
			if (other.caseStatus != null)
				return false;
		} else if (!caseStatus.equals(other.caseStatus))
			return false;
		if (court == null) {
			if (other.court != null)
				return false;
		} else if (!court.equals(other.court))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (executedObject == null) {
			if (other.executedObject != null)
				return false;
		} else if (!executedObject.equals(other.executedObject))
			return false;
		if (executedObjectValue == null) {
			if (other.executedObjectValue != null)
				return false;
		} else if (!executedObjectValue.equals(other.executedObjectValue))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (judgeDate == null) {
			if (other.judgeDate != null)
				return false;
		} else if (!judgeDate.equals(other.judgeDate))
			return false;
		if (judgeEffDate == null) {
			if (other.judgeEffDate != null)
				return false;
		} else if (!judgeEffDate.equals(other.judgeEffDate))
			return false;
		if (judgeObject == null) {
			if (other.judgeObject != null)
				return false;
		} else if (!judgeObject.equals(other.judgeObject))
			return false;
		if (judgeParty == null) {
			if (other.judgeParty != null)
				return false;
		} else if (!judgeParty.equals(other.judgeParty))
			return false;
		if (judgeProcess == null) {
			if (other.judgeProcess != null)
				return false;
		} else if (!judgeProcess.equals(other.judgeProcess))
			return false;
		if (judgeReason == null) {
			if (other.judgeReason != null)
				return false;
		} else if (!judgeReason.equals(other.judgeReason))
			return false;
		if (judgeResult == null) {
			if (other.judgeResult != null)
				return false;
		} else if (!judgeResult.equals(other.judgeResult))
			return false;
		if (objectValue == null) {
			if (other.objectValue != null)
				return false;
		} else if (!objectValue.equals(other.objectValue))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTCorpJudgeRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String court, String judgeDate,
			String judgeReason, String judgeParty, String caseNo,
			String judgeProcess, String judgeObject, String objectValue,
			String caseCloseMode, String judgeEffDate, String judgeResult,
			String caseStatus, String executedObject, String executedObjectValue) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.court = court;
		this.judgeDate = judgeDate;
		this.judgeReason = judgeReason;
		this.judgeParty = judgeParty;
		this.caseNo = caseNo;
		this.judgeProcess = judgeProcess;
		this.judgeObject = judgeObject;
		this.objectValue = objectValue;
		this.caseCloseMode = caseCloseMode;
		this.judgeEffDate = judgeEffDate;
		this.judgeResult = judgeResult;
		this.caseStatus = caseStatus;
		this.executedObject = executedObject;
		this.executedObjectValue = executedObjectValue;
	}
    
    


    




    
}
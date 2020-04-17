package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="IND_INFO"
 */

public abstract class BaseIndPublicRecord implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndPublicRecord";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_END_DATE="endDate";
    public static String PROP_INIT_DATE="initDate";
    public static String PROP_NO="no";
    public static String PROP_OBJECT_AMOUNT="objectAmount";
    public static String PROP_OBJECT_NAME="objectName";
    public static String PROP_ORGAN="organ";
    public static String PROP_REASON="reason";
    public static String PROP_RECORD_TYPE="recordType";
    public static String PROP_RESULT="result";
    public static String PROP_STATUS="status";
    public static String PROP_SUBJECT_AMOUNT="subjectAmount";
    public static String PROP_SUBJECT_NAME="subjectName";
    public static String PROP_TYPE="type";

    public BaseIndPublicRecord() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String endDate;
    private java.lang.String initDate;
    private java.lang.Integer no;
    private java.lang.String objectAmount;
    private java.lang.String objectName;
    private java.lang.String organ;
    private java.lang.String reason;
    private java.lang.String recordType;
    private java.lang.String result;
    private java.lang.String status;
    private java.lang.String subjectAmount;
    private java.lang.String subjectName;
    private java.lang.String type;

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
	public static String getPROP_END_DATE() {
		return PROP_END_DATE;
	}
	public static void setPROP_END_DATE(String pROP_END_DATE) {
		PROP_END_DATE = pROP_END_DATE;
	}
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_OBJECT_AMOUNT() {
		return PROP_OBJECT_AMOUNT;
	}
	public static void setPROP_OBJECT_AMOUNT(String pROP_OBJECT_AMOUNT) {
		PROP_OBJECT_AMOUNT = pROP_OBJECT_AMOUNT;
	}
	public static String getPROP_OBJECT_NAME() {
		return PROP_OBJECT_NAME;
	}
	public static void setPROP_OBJECT_NAME(String pROP_OBJECT_NAME) {
		PROP_OBJECT_NAME = pROP_OBJECT_NAME;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_REASON() {
		return PROP_REASON;
	}
	public static void setPROP_REASON(String pROP_REASON) {
		PROP_REASON = pROP_REASON;
	}
	public static String getPROP_RECORD_TYPE() {
		return PROP_RECORD_TYPE;
	}
	public static void setPROP_RECORD_TYPE(String pROP_RECORD_TYPE) {
		PROP_RECORD_TYPE = pROP_RECORD_TYPE;
	}
	public static String getPROP_RESULT() {
		return PROP_RESULT;
	}
	public static void setPROP_RESULT(String pROP_RESULT) {
		PROP_RESULT = pROP_RESULT;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_SUBJECT_AMOUNT() {
		return PROP_SUBJECT_AMOUNT;
	}
	public static void setPROP_SUBJECT_AMOUNT(String pROP_SUBJECT_AMOUNT) {
		PROP_SUBJECT_AMOUNT = pROP_SUBJECT_AMOUNT;
	}
	public static String getPROP_SUBJECT_NAME() {
		return PROP_SUBJECT_NAME;
	}
	public static void setPROP_SUBJECT_NAME(String pROP_SUBJECT_NAME) {
		PROP_SUBJECT_NAME = pROP_SUBJECT_NAME;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
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
	public java.lang.String getEndDate() {
		return endDate;
	}
	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getObjectAmount() {
		return objectAmount;
	}
	public void setObjectAmount(java.lang.String objectAmount) {
		this.objectAmount = objectAmount;
	}
	public java.lang.String getObjectName() {
		return objectName;
	}
	public void setObjectName(java.lang.String objectName) {
		this.objectName = objectName;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getReason() {
		return reason;
	}
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}
	public java.lang.String getRecordType() {
		return recordType;
	}
	public void setRecordType(java.lang.String recordType) {
		this.recordType = recordType;
	}
	public java.lang.String getResult() {
		return result;
	}
	public void setResult(java.lang.String result) {
		this.result = result;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getSubjectAmount() {
		return subjectAmount;
	}
	public void setSubjectAmount(java.lang.String subjectAmount) {
		this.subjectAmount = subjectAmount;
	}
	public java.lang.String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(java.lang.String subjectName) {
		this.subjectName = subjectName;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result
				+ ((objectAmount == null) ? 0 : objectAmount.hashCode());
		result = prime * result
				+ ((objectName == null) ? 0 : objectName.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result
				+ ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result
				+ ((this.result == null) ? 0 : this.result.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((subjectAmount == null) ? 0 : subjectAmount.hashCode());
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		BaseIndPublicRecord other = (BaseIndPublicRecord) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (objectAmount == null) {
			if (other.objectAmount != null)
				return false;
		} else if (!objectAmount.equals(other.objectAmount))
			return false;
		if (objectName == null) {
			if (other.objectName != null)
				return false;
		} else if (!objectName.equals(other.objectName))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (result == null) {
			if (other.result != null)
				return false;
		} else if (!result.equals(other.result))
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
		if (subjectAmount == null) {
			if (other.subjectAmount != null)
				return false;
		} else if (!subjectAmount.equals(other.subjectAmount))
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public BaseIndPublicRecord(Integer id, String rptId, String endDate,
			String initDate, Integer no, String objectAmount,
			String objectName, String organ, String reason, String recordType,
			String result, String status, String subjectAmount,
			String subjectName, String type) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.endDate = endDate;
		this.initDate = initDate;
		this.no = no;
		this.objectAmount = objectAmount;
		this.objectName = objectName;
		this.organ = organ;
		this.reason = reason;
		this.recordType = recordType;
		this.result = result;
		this.status = status;
		this.subjectAmount = subjectAmount;
		this.subjectName = subjectName;
		this.type = type;
	}

    
	
    
    
  
}
package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="IND_APP"
 */

public abstract class BaseIndApp implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndApp";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_INDIVIDUAL_ID="individualId";
    public static String PROP_NAME="name";
    public static String PROP_ID_TYPE="idType";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_QUERY_TYPE="queryType";
    public static String PROP_REPORT_FORMAT="reportFormat";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_QUERY_TIME="queryTime";
	public static String PROP_RETURN_TIME="returnTime";
	public static String PROP_TYPE="type";
	public static String PROP_STATUS="status";
	public static String PROP_CUSTOMER_ATTRIBUTE="customerAttribute";
	public static String PROP_CUST_ATTRIBUTE_KEY="custAttributeKey";
	public static String PROP_CUST_ATTRIBUTE_RPTID="custAttributeRptId";
	
	public static String PROP_CORP_NAME="corpName";
	public static String PROP__LOAN_CARD_NO="loanCardNo";
	public static String PROP_ATTRIBUTE_INDIVIDUAL_ID="attributeIndividualId";
	public static String PROP_ATTRIBUTE_NAME="attributeName";
	public static String PROP_ATTRIBUTE_ID_TYPE="attributeIdType";
	public static String PROP_UPLOADED_FILE_PATH="uploadedFilePath";

	

    public BaseIndApp() {
		super();
	}

	public BaseIndApp(int hashCode, Integer id, String rptId,
			String individualId, String name, String idType,
			String queryReason, String queryType, String reportFormat,
			Date inputTime, Date queryTime, Date returnTime, String type,
			String status, String customerAttribute, String custAttributeKey,
			String custAttributeRptId, String corpName, String loanCardNo,
			String attributeIndividualId, String attributeName,
			String attributeIdType, String uploadedFilePath) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptId = rptId;
		this.individualId = individualId;
		this.name = name;
		this.idType = idType;
		this.queryReason = queryReason;
		this.queryType = queryType;
		this.reportFormat = reportFormat;
		this.inputTime = inputTime;
		this.queryTime = queryTime;
		this.returnTime = returnTime;
		this.type = type;
		this.status = status;
		this.customerAttribute = customerAttribute;
		this.custAttributeKey = custAttributeKey;
		this.custAttributeRptId = custAttributeRptId;
		this.corpName = corpName;
		this.loanCardNo = loanCardNo;
		this.attributeIndividualId = attributeIndividualId;
		this.attributeName = attributeName;
		this.attributeIdType = attributeIdType;
		this.uploadedFilePath = uploadedFilePath;
	}

	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String individualId;
    private java.lang.String name;
    private java.lang.String idType;
    private java.lang.String queryReason;
    private java.lang.String queryType;
    private java.lang.String reportFormat;
    private java.util.Date inputTime;
    private java.util.Date queryTime;
    private java.util.Date returnTime;
    private java.lang.String type;
    private java.lang.String status;
	private java.lang.String customerAttribute;
	private java.lang.String custAttributeKey;
	private java.lang.String custAttributeRptId;
	private java.lang.String corpName;
	private java.lang.String loanCardNo;
	private java.lang.String attributeIndividualId;
	private java.lang.String attributeName;
	private java.lang.String attributeIdType;
	    
    private java.lang.String uploadedFilePath;



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

	public static String getPROP_INDIVIDUAL_ID() {
		return PROP_INDIVIDUAL_ID;
	}

	public static void setPROP_INDIVIDUAL_ID(String pROP_INDIVIDUAL_ID) {
		PROP_INDIVIDUAL_ID = pROP_INDIVIDUAL_ID;
	}

	public static String getPROP_NAME() {
		return PROP_NAME;
	}

	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}

	public static String getPROP_ID_TYPE() {
		return PROP_ID_TYPE;
	}

	public static void setPROP_ID_TYPE(String pROP_ID_TYPE) {
		PROP_ID_TYPE = pROP_ID_TYPE;
	}

	public static String getPROP_QUERY_REASON() {
		return PROP_QUERY_REASON;
	}

	public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
		PROP_QUERY_REASON = pROP_QUERY_REASON;
	}

	public static String getPROP_QUERY_TYPE() {
		return PROP_QUERY_TYPE;
	}

	public static void setPROP_QUERY_TYPE(String pROP_QUERY_TYPE) {
		PROP_QUERY_TYPE = pROP_QUERY_TYPE;
	}

	public static String getPROP_REPORT_FORMAT() {
		return PROP_REPORT_FORMAT;
	}

	public static void setPROP_REPORT_FORMAT(String pROP_REPORT_FORMAT) {
		PROP_REPORT_FORMAT = pROP_REPORT_FORMAT;
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

	public static String getPROP_CUSTOMER_ATTRIBUTE() {
		return PROP_CUSTOMER_ATTRIBUTE;
	}

	public static void setPROP_CUSTOMER_ATTRIBUTE(String pROP_CUSTOMER_ATTRIBUTE) {
		PROP_CUSTOMER_ATTRIBUTE = pROP_CUSTOMER_ATTRIBUTE;
	}

	public static String getPROP_CUST_ATTRIBUTE_KEY() {
		return PROP_CUST_ATTRIBUTE_KEY;
	}

	public static void setPROP_CUST_ATTRIBUTE_KEY(String pROP_CUST_ATTRIBUTE_KEY) {
		PROP_CUST_ATTRIBUTE_KEY = pROP_CUST_ATTRIBUTE_KEY;
	}

	public static String getPROP_CUST_ATTRIBUTE_RPTID() {
		return PROP_CUST_ATTRIBUTE_RPTID;
	}

	public static void setPROP_CUST_ATTRIBUTE_RPTID(String pROP_CUST_ATTRIBUTE_RPTID) {
		PROP_CUST_ATTRIBUTE_RPTID = pROP_CUST_ATTRIBUTE_RPTID;
	}

	public static String getPROP_CORP_NAME() {
		return PROP_CORP_NAME;
	}

	public static void setPROP_CORP_NAME(String pROP_CORP_NAME) {
		PROP_CORP_NAME = pROP_CORP_NAME;
	}

	public static String getPROP__LOAN_CARD_NO() {
		return PROP__LOAN_CARD_NO;
	}

	public static void setPROP__LOAN_CARD_NO(String pROP__LOAN_CARD_NO) {
		PROP__LOAN_CARD_NO = pROP__LOAN_CARD_NO;
	}

	public static String getPROP_ATTRIBUTE_INDIVIDUAL_ID() {
		return PROP_ATTRIBUTE_INDIVIDUAL_ID;
	}

	public static void setPROP_ATTRIBUTE_INDIVIDUAL_ID(
			String pROP_ATTRIBUTE_INDIVIDUAL_ID) {
		PROP_ATTRIBUTE_INDIVIDUAL_ID = pROP_ATTRIBUTE_INDIVIDUAL_ID;
	}

	public static String getPROP_ATTRIBUTE_NAME() {
		return PROP_ATTRIBUTE_NAME;
	}

	public static void setPROP_ATTRIBUTE_NAME(String pROP_ATTRIBUTE_NAME) {
		PROP_ATTRIBUTE_NAME = pROP_ATTRIBUTE_NAME;
	}

	public static String getPROP_ATTRIBUTE_ID_TYPE() {
		return PROP_ATTRIBUTE_ID_TYPE;
	}

	public static void setPROP_ATTRIBUTE_ID_TYPE(String pROP_ATTRIBUTE_ID_TYPE) {
		PROP_ATTRIBUTE_ID_TYPE = pROP_ATTRIBUTE_ID_TYPE;
	}

	public static String getPROP_UPLOADED_FILE_PATH() {
		return PROP_UPLOADED_FILE_PATH;
	}

	public static void setPROP_UPLOADED_FILE_PATH(String pROP_UPLOADED_FILE_PATH) {
		PROP_UPLOADED_FILE_PATH = pROP_UPLOADED_FILE_PATH;
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

	public java.lang.String getRptId() {
		return rptId;
	}

	public void setRptId(java.lang.String rptId) {
		this.rptId = rptId;
	}

	public java.lang.String getIndividualId() {
		return individualId;
	}

	public void setIndividualId(java.lang.String individualId) {
		this.individualId = individualId;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getIdType() {
		return idType;
	}

	public void setIdType(java.lang.String idType) {
		this.idType = idType;
	}

	public java.lang.String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}

	public java.lang.String getQueryType() {
		return queryType;
	}

	public void setQueryType(java.lang.String queryType) {
		this.queryType = queryType;
	}

	public java.lang.String getReportFormat() {
		return reportFormat;
	}

	public void setReportFormat(java.lang.String reportFormat) {
		this.reportFormat = reportFormat;
	}

	public java.util.Date getInputTime() {
		return inputTime;
	}

	public void setInputTime(java.util.Date inputTime) {
		this.inputTime = inputTime;
	}

	public java.util.Date getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(java.util.Date queryTime) {
		this.queryTime = queryTime;
	}

	public java.util.Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(java.util.Date returnTime) {
		this.returnTime = returnTime;
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

	public java.lang.String getCustomerAttribute() {
		return customerAttribute;
	}

	public void setCustomerAttribute(java.lang.String customerAttribute) {
		this.customerAttribute = customerAttribute;
	}

	public java.lang.String getCustAttributeKey() {
		return custAttributeKey;
	}

	public void setCustAttributeKey(java.lang.String custAttributeKey) {
		this.custAttributeKey = custAttributeKey;
	}

	public java.lang.String getCustAttributeRptId() {
		return custAttributeRptId;
	}

	public void setCustAttributeRptId(java.lang.String custAttributeRptId) {
		this.custAttributeRptId = custAttributeRptId;
	}

	public java.lang.String getCorpName() {
		return corpName;
	}

	public void setCorpName(java.lang.String corpName) {
		this.corpName = corpName;
	}

	public java.lang.String getLoanCardNo() {
		return loanCardNo;
	}

	public void setLoanCardNo(java.lang.String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}

	public java.lang.String getAttributeIndividualId() {
		return attributeIndividualId;
	}

	public void setAttributeIndividualId(java.lang.String attributeIndividualId) {
		this.attributeIndividualId = attributeIndividualId;
	}

	public java.lang.String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(java.lang.String attributeName) {
		this.attributeName = attributeName;
	}

	public java.lang.String getAttributeIdType() {
		return attributeIdType;
	}

	public void setAttributeIdType(java.lang.String attributeIdType) {
		this.attributeIdType = attributeIdType;
	}

	public java.lang.String getUploadedFilePath() {
		return uploadedFilePath;
	}

	public void setUploadedFilePath(java.lang.String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributeIdType == null) ? 0 : attributeIdType.hashCode());
		result = prime
				* result
				+ ((attributeIndividualId == null) ? 0 : attributeIndividualId
						.hashCode());
		result = prime * result
				+ ((attributeName == null) ? 0 : attributeName.hashCode());
		result = prime * result
				+ ((corpName == null) ? 0 : corpName.hashCode());
		result = prime
				* result
				+ ((custAttributeKey == null) ? 0 : custAttributeKey.hashCode());
		result = prime
				* result
				+ ((custAttributeRptId == null) ? 0 : custAttributeRptId
						.hashCode());
		result = prime
				* result
				+ ((customerAttribute == null) ? 0 : customerAttribute
						.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result
				+ ((individualId == null) ? 0 : individualId.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((loanCardNo == null) ? 0 : loanCardNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((queryTime == null) ? 0 : queryTime.hashCode());
		result = prime * result
				+ ((queryType == null) ? 0 : queryType.hashCode());
		result = prime * result
				+ ((reportFormat == null) ? 0 : reportFormat.hashCode());
		result = prime * result
				+ ((returnTime == null) ? 0 : returnTime.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BaseIndApp other = (BaseIndApp) obj;
		if (attributeIdType == null) {
			if (other.attributeIdType != null)
				return false;
		} else if (!attributeIdType.equals(other.attributeIdType))
			return false;
		if (attributeIndividualId == null) {
			if (other.attributeIndividualId != null)
				return false;
		} else if (!attributeIndividualId.equals(other.attributeIndividualId))
			return false;
		if (attributeName == null) {
			if (other.attributeName != null)
				return false;
		} else if (!attributeName.equals(other.attributeName))
			return false;
		if (corpName == null) {
			if (other.corpName != null)
				return false;
		} else if (!corpName.equals(other.corpName))
			return false;
		if (custAttributeKey == null) {
			if (other.custAttributeKey != null)
				return false;
		} else if (!custAttributeKey.equals(other.custAttributeKey))
			return false;
		if (custAttributeRptId == null) {
			if (other.custAttributeRptId != null)
				return false;
		} else if (!custAttributeRptId.equals(other.custAttributeRptId))
			return false;
		if (customerAttribute == null) {
			if (other.customerAttribute != null)
				return false;
		} else if (!customerAttribute.equals(other.customerAttribute))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (individualId == null) {
			if (other.individualId != null)
				return false;
		} else if (!individualId.equals(other.individualId))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		if (queryType == null) {
			if (other.queryType != null)
				return false;
		} else if (!queryType.equals(other.queryType))
			return false;
		if (reportFormat == null) {
			if (other.reportFormat != null)
				return false;
		} else if (!reportFormat.equals(other.reportFormat))
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
		return "BaseIndApp [hashCode=" + hashCode + ", id=" + id + ", rptId="
				+ rptId + ", individualId=" + individualId + ", name=" + name
				+ ", idType=" + idType + ", queryReason=" + queryReason
				+ ", queryType=" + queryType + ", reportFormat=" + reportFormat
				+ ", inputTime=" + inputTime + ", queryTime=" + queryTime
				+ ", returnTime=" + returnTime + ", type=" + type + ", status="
				+ status + ", customerAttribute=" + customerAttribute
				+ ", custAttributeKey=" + custAttributeKey
				+ ", custAttributeRptId=" + custAttributeRptId + ", corpName="
				+ corpName + ", loanCardNo=" + loanCardNo
				+ ", attributeIndividualId=" + attributeIndividualId
				+ ", attributeName=" + attributeName + ", attributeIdType="
				+ attributeIdType + ", uploadedFilePath=" + uploadedFilePath
				+ "]";
	}

    
    
  
}
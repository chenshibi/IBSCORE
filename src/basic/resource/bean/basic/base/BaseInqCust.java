package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseInqCust  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6798661405791281838L;
	public static String REF = "InqCust";
	 public static String PROP_ID= "id";
    public static String PROP_INQ_CUST_APPID= "inqCustAppid"; 
    public static String PROP_INQ_CUST_NAME = "inqCustName"; 
    public static String PROP_INQ_CUST_ID="inqCustId";
    public static String PROP_INQ_CUST_id_TYPE="inqCustIdType";
    public static String PROP_INQ_CUST_TYPE="inqCustType";
    public static String PROP_INQ_TYPE="inqType";
    public static String PROP_CUST_ID="custId";
    public static String PROP_REL_NAME="relName";
    public static String PROP_REL_NAMEC="relNamec";
    public static String PROP_REL_CUST_ID="relCustId";
    public static String PROP_REL_CUST_id_TYPE="relCustIdType";
    public static String PROP_REL_CORP_ID="relCorpId";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_QUERY_REASON="queryReason";
    public static String PROP_CONSENT_FILE_PATH="consentFilePath";
    public static String PROP_NON_WORKHOUR_FILE_PATH="nonWorkhourFilepath";
    public static String PROP_CONFIRM_FLAG="confirmFlag";
    public static String PROP_CREATE_USER_IP="createUserIp";
    
    public static String PROP_QUERY_REASON_IND="queryReasonInd";


	protected void initialize() {
    }
	
	private int hashCode = Integer.MIN_VALUE;
	
	 private java.lang.Integer id;
	 private java.lang.Integer inqCustAppid;
	 private java.lang.String inqCustName;
	 private java.lang.String inqCustId;
	 private java.lang.String inqCustIdType;
	 private java.lang.String inqCustType;
	 private java.lang.String inqType;
	 private java.lang.Integer custId;
	 private java.lang.String relName;
	 private java.lang.String relNamec;
	 private java.lang.String relCustId;
	 private java.lang.String relCustIdType;
	 private java.lang.String relCorpId;
	 public  java.util.Date createTime;
	 private java.lang.String createUser;
	 private java.lang.String queryReason;
	 private java.lang.String consentFilePath;
	 private java.lang.String nonWorkhourFilepath;
	 
	 private java.lang.String corpCustLoancard;
	 private java.lang.String corpCustCompanyname;
	 private java.lang.String confirmFlag;
	 private java.lang.String createUserIp;
	 
	 private java.lang.String queryReasonInd;
	 

	public BaseInqCust() {
		super();
	}



	public BaseInqCust(int hashCode, Integer id, Integer inqCustAppid,
			String inqCustName, String inqCustId, String inqCustIdType,
			String inqCustType, String inqType, Integer custId, String relName,String relNamec,
			String relCustId, String relCustIdType, String relCorpId,
			Date createTime, String createUser, String queryReason,String queryReasonInd,
			String consentFilePath ,String nonWorkhourFilepath,String confirmFlag,String createUserIp) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.inqCustAppid = inqCustAppid;
		this.inqCustName = inqCustName;
		this.inqCustId = inqCustId;
		this.inqCustIdType = inqCustIdType;
		this.inqCustType = inqCustType;
		this.inqType = inqType;
		this.custId = custId;
		this.relName = relName;
		this.relNamec = relNamec;
		this.relCustId = relCustId;
		this.relCustIdType = relCustIdType;
		this.relCorpId = relCorpId;
		this.createTime = createTime;
		this.createUser = createUser;
		this.queryReason = queryReason;
		this.consentFilePath = consentFilePath;
		this.nonWorkhourFilepath=nonWorkhourFilepath;
		this.confirmFlag=confirmFlag;
		this.createUserIp=createUserIp;
		this.queryReasonInd = queryReasonInd;
	}



	public static String getPROP_QUERY_REASON_IND() {
		return PROP_QUERY_REASON_IND;
	}



	public static void setPROP_QUERY_REASON_IND(String pROP_QUERY_REASON_IND) {
		PROP_QUERY_REASON_IND = pROP_QUERY_REASON_IND;
	}



	public java.lang.String getQueryReasonInd() {
		return queryReasonInd;
	}



	public void setQueryReasonInd(java.lang.String queryReasonInd) {
		this.queryReasonInd = queryReasonInd;
	}



	public static String getPROP_REL_NAMEC() {
		return PROP_REL_NAMEC;
	}



	public static void setPROP_REL_NAMEC(String pROP_REL_NAMEC) {
		PROP_REL_NAMEC = pROP_REL_NAMEC;
	}



	public java.lang.String getRelNamec() {
		return relNamec;
	}



	public void setRelNamec(java.lang.String relNamec) {
		this.relNamec = relNamec;
	}



	public static String getPROP_CREATE_USER_IP() {
		return PROP_CREATE_USER_IP;
	}



	public static void setPROP_CREATE_USER_IP(String pROP_CREATE_USER_IP) {
		PROP_CREATE_USER_IP = pROP_CREATE_USER_IP;
	}



	public java.lang.String getCreateUserIp() {
		return createUserIp;
	}



	public void setCreateUserIp(java.lang.String createUserIp) {
		this.createUserIp = createUserIp;
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



	public static String getPROP_INQ_CUST_APPID() {
		return PROP_INQ_CUST_APPID;
	}



	public static void setPROP_INQ_CUST_APPID(String pROP_INQ_CUST_APPID) {
		PROP_INQ_CUST_APPID = pROP_INQ_CUST_APPID;
	}



	public static String getPROP_INQ_CUST_NAME() {
		return PROP_INQ_CUST_NAME;
	}



	public static void setPROP_INQ_CUST_NAME(String pROP_INQ_CUST_NAME) {
		PROP_INQ_CUST_NAME = pROP_INQ_CUST_NAME;
	}



	public static String getPROP_INQ_CUST_ID() {
		return PROP_INQ_CUST_ID;
	}



	public static void setPROP_INQ_CUST_ID(String pROP_INQ_CUST_ID) {
		PROP_INQ_CUST_ID = pROP_INQ_CUST_ID;
	}



	public static String getPROP_INQ_CUST_id_TYPE() {
		return PROP_INQ_CUST_id_TYPE;
	}



	public static void setPROP_INQ_CUST_id_TYPE(String pROP_INQ_CUST_id_TYPE) {
		PROP_INQ_CUST_id_TYPE = pROP_INQ_CUST_id_TYPE;
	}



	public static String getPROP_INQ_CUST_TYPE() {
		return PROP_INQ_CUST_TYPE;
	}



	public static String getPROP_CONFIRM_FLAG() {
		return PROP_CONFIRM_FLAG;
	}



	public static void setPROP_CONFIRM_FLAG(String pROP_CONFIRM_FLAG) {
		PROP_CONFIRM_FLAG = pROP_CONFIRM_FLAG;
	}



	public java.lang.String getConfirmFlag() {
		return confirmFlag;
	}



	public void setConfirmFlag(java.lang.String confirmFlag) {
		this.confirmFlag = confirmFlag;
	}



	public static void setPROP_INQ_CUST_TYPE(String pROP_INQ_CUST_TYPE) {
		PROP_INQ_CUST_TYPE = pROP_INQ_CUST_TYPE;
	}



	public static String getPROP_INQ_TYPE() {
		return PROP_INQ_TYPE;
	}



	public static void setPROP_INQ_TYPE(String pROP_INQ_TYPE) {
		PROP_INQ_TYPE = pROP_INQ_TYPE;
	}



	public static String getPROP_CUST_ID() {
		return PROP_CUST_ID;
	}



	public static void setPROP_CUST_ID(String pROP_CUST_ID) {
		PROP_CUST_ID = pROP_CUST_ID;
	}



	public static String getPROP_REL_NAME() {
		return PROP_REL_NAME;
	}



	public static void setPROP_REL_NAME(String pROP_REL_NAME) {
		PROP_REL_NAME = pROP_REL_NAME;
	}



	public static String getPROP_REL_CUST_ID() {
		return PROP_REL_CUST_ID;
	}



	public static void setPROP_REL_CUST_ID(String pROP_REL_CUST_ID) {
		PROP_REL_CUST_ID = pROP_REL_CUST_ID;
	}



	public static String getPROP_REL_CUST_id_TYPE() {
		return PROP_REL_CUST_id_TYPE;
	}



	public static void setPROP_REL_CUST_id_TYPE(String pROP_REL_CUST_id_TYPE) {
		PROP_REL_CUST_id_TYPE = pROP_REL_CUST_id_TYPE;
	}



	public static String getPROP_REL_CORP_ID() {
		return PROP_REL_CORP_ID;
	}



	public static void setPROP_REL_CORP_ID(String pROP_REL_CORP_ID) {
		PROP_REL_CORP_ID = pROP_REL_CORP_ID;
	}



	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}



	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
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



	public static String getPROP_CONSENT_FILE_PATH() {
		return PROP_CONSENT_FILE_PATH;
	}



	public static void setPROP_CONSENT_FILE_PATH(String pROP_CONSENT_FILE_PATH) {
		PROP_CONSENT_FILE_PATH = pROP_CONSENT_FILE_PATH;
	}



	public static String getPROP_NON_WORKHOUR_FILE_PATH() {
		return PROP_NON_WORKHOUR_FILE_PATH;
	}



	public static void setPROP_NON_WORKHOUR_FILE_PATH(
			String pROP_NON_WORKHOUR_FILE_PATH) {
		PROP_NON_WORKHOUR_FILE_PATH = pROP_NON_WORKHOUR_FILE_PATH;
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



	public java.lang.Integer getInqCustAppid() {
		return inqCustAppid;
	}



	public void setInqCustAppid(java.lang.Integer inqCustAppid) {
		this.inqCustAppid = inqCustAppid;
	}



	public java.lang.String getInqCustName() {
		return inqCustName;
	}



	public void setInqCustName(java.lang.String inqCustName) {
		this.inqCustName = inqCustName;
	}



	public java.lang.String getInqCustId() {
		return inqCustId;
	}



	public void setInqCustId(java.lang.String inqCustId) {
		this.inqCustId = inqCustId;
	}



	public java.lang.String getInqCustIdType() {
		return inqCustIdType;
	}



	public void setInqCustIdType(java.lang.String inqCustIdType) {
		this.inqCustIdType = inqCustIdType;
	}



	public java.lang.String getInqCustType() {
		return inqCustType;
	}



	public void setInqCustType(java.lang.String inqCustType) {
		this.inqCustType = inqCustType;
	}



	public java.lang.String getInqType() {
		return inqType;
	}



	public void setInqType(java.lang.String inqType) {
		this.inqType = inqType;
	}



	public java.lang.Integer getCustId() {
		return custId;
	}



	public void setCustId(java.lang.Integer custId) {
		this.custId = custId;
	}



	public java.lang.String getRelName() {
		return relName;
	}



	public void setRelName(java.lang.String relName) {
		this.relName = relName;
	}



	public java.lang.String getRelCustId() {
		return relCustId;
	}



	public void setRelCustId(java.lang.String relCustId) {
		this.relCustId = relCustId;
	}



	public java.lang.String getRelCustIdType() {
		return relCustIdType;
	}



	public void setRelCustIdType(java.lang.String relCustIdType) {
		this.relCustIdType = relCustIdType;
	}



	public java.lang.String getRelCorpId() {
		return relCorpId;
	}



	public void setRelCorpId(java.lang.String relCorpId) {
		this.relCorpId = relCorpId;
	}



	public java.util.Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}



	public java.lang.String getCreateUser() {
		return createUser;
	}



	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
	}



	public java.lang.String getQueryReason() {
		return queryReason;
	}



	public void setQueryReason(java.lang.String queryReason) {
		this.queryReason = queryReason;
	}



	public java.lang.String getConsentFilePath() {
		return consentFilePath;
	}



	public void setConsentFilePath(java.lang.String consentFilePath) {
		this.consentFilePath = consentFilePath;
	}



	public java.lang.String getNonWorkhourFilepath() {
		return nonWorkhourFilepath;
	}



	public void setNonWorkhourFilepath(java.lang.String nonWorkhourFilepath) {
		this.nonWorkhourFilepath = nonWorkhourFilepath;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((queryReasonInd == null) ? 0 : queryReasonInd.hashCode());
		result = prime * result
				+ ((createUserIp == null) ? 0 : createUserIp.hashCode());
		result = prime * result
				+ ((confirmFlag == null) ? 0 : confirmFlag.hashCode());
		result = prime * result
				+ ((nonWorkhourFilepath == null) ? 0 : nonWorkhourFilepath.hashCode());
		result = prime * result
				+ ((consentFilePath == null) ? 0 : consentFilePath.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inqCustAppid == null) ? 0 : inqCustAppid.hashCode());
		result = prime * result
				+ ((inqCustId == null) ? 0 : inqCustId.hashCode());
		result = prime * result
				+ ((inqCustIdType == null) ? 0 : inqCustIdType.hashCode());
		result = prime * result
				+ ((inqCustName == null) ? 0 : inqCustName.hashCode());
		result = prime * result
				+ ((inqCustType == null) ? 0 : inqCustType.hashCode());
		result = prime * result + ((inqType == null) ? 0 : inqType.hashCode());
		result = prime * result
				+ ((queryReason == null) ? 0 : queryReason.hashCode());
		result = prime * result
				+ ((relCorpId == null) ? 0 : relCorpId.hashCode());
		result = prime * result
				+ ((relCustId == null) ? 0 : relCustId.hashCode());
		result = prime * result
				+ ((relCustIdType == null) ? 0 : relCustIdType.hashCode());
		result = prime * result + ((relName == null) ? 0 : relName.hashCode());
		result = prime * result + ((relNamec == null) ? 0 : relNamec.hashCode());
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
		BaseInqCust other = (BaseInqCust) obj;
		if(queryReasonInd==null){
			if (other.queryReasonInd != null)
				return false;
		}else if(createUserIp==null){
			if (other.createUserIp != null)
				return false;
		}else if(confirmFlag==null){
			if (other.confirmFlag != null)
				return false;
		}else if(nonWorkhourFilepath==null){
			if (other.nonWorkhourFilepath != null)
				return false;
		} else if (consentFilePath == null) {
			if (other.consentFilePath != null)
				return false;
		} else if (!consentFilePath.equals(other.consentFilePath))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inqCustAppid == null) {
			if (other.inqCustAppid != null)
				return false;
		} else if (!inqCustAppid.equals(other.inqCustAppid))
			return false;
		if (inqCustId == null) {
			if (other.inqCustId != null)
				return false;
		} else if (!inqCustId.equals(other.inqCustId))
			return false;
		if (inqCustIdType == null) {
			if (other.inqCustIdType != null)
				return false;
		} else if (!inqCustIdType.equals(other.inqCustIdType))
			return false;
		if (inqCustName == null) {
			if (other.inqCustName != null)
				return false;
		} else if (!inqCustName.equals(other.inqCustName))
			return false;
		if (inqCustType == null) {
			if (other.inqCustType != null)
				return false;
		} else if (!inqCustType.equals(other.inqCustType))
			return false;
		if (inqType == null) {
			if (other.inqType != null)
				return false;
		} else if (!inqType.equals(other.inqType))
			return false;
		if (queryReason == null) {
			if (other.queryReason != null)
				return false;
		} else if (!queryReason.equals(other.queryReason))
			return false;
		if (relCorpId == null) {
			if (other.relCorpId != null)
				return false;
		} else if (!relCorpId.equals(other.relCorpId))
			return false;
		if (relCustId == null) {
			if (other.relCustId != null)
				return false;
		} else if (!relCustId.equals(other.relCustId))
			return false;
		if (relCustIdType == null) {
			if (other.relCustIdType != null)
				return false;
		} else if (!relCustIdType.equals(other.relCustIdType))
			return false;
		if (relName == null) {
			if (other.relName != null)
				return false;
		} else if (!relName.equals(other.relName))
			return false;
		if (relNamec == null) {
			if (other.relNamec != null)
				return false;
		} else if (!relNamec.equals(other.relNamec))
			return false;
		return true;
	}




	
	

	@Override
	public String toString() {
		return "BaseInqCust [hashCode=" + hashCode + ", id=" + id
				+ ", inqCustAppid=" + inqCustAppid + ", inqCustName="
				+ inqCustName + ", inqCustId=" + inqCustId + ", inqCustIdType="
				+ inqCustIdType + ", inqCustType=" + inqCustType + ", inqType="
				+ inqType + ", custId=" + custId + ", relName=" + relName
				+ ", relNamec=" + relNamec + ", relCustId=" + relCustId
				+ ", relCustIdType=" + relCustIdType + ", relCorpId="
				+ relCorpId + ", createTime=" + createTime + ", createUser="
				+ createUser + ", queryReason=" + queryReason
				+ ", consentFilePath=" + consentFilePath
				+ ", nonWorkhourFilepath=" + nonWorkhourFilepath
				+ ", corpCustLoancard=" + corpCustLoancard
				+ ", corpCustCompanyname=" + corpCustCompanyname
				+ ", confirmFlag=" + confirmFlag + ", createUserIp="
				+ createUserIp + ", queryReasonInd=" + queryReasonInd + "]";
	}



	public java.lang.String getCorpCustLoancard() {
		return corpCustLoancard;
	}



	public void setCorpCustLoancard(java.lang.String corpCustLoancard) {
		this.corpCustLoancard = corpCustLoancard;
	}



	public java.lang.String getCorpCustCompanyname() {
		return corpCustCompanyname;
	}



	public void setCorpCustCompanyname(java.lang.String corpCustCompanyname) {
		this.corpCustCompanyname = corpCustCompanyname;
	}


	
	 


	 
}

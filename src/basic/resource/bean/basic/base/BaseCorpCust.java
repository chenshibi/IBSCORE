package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseCorpCust implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6252397255385471069L;
	   public static String REF = "CorpCust";
	   public static String PROP_ID= "id";
	   public static String PROP_CORP_CUST_APPID= "corpCustAppid"; 
	   public static String PROP_CORP_CUST_DETAIL_ID= "corpCustDetailId"; 
	   public static String PROP_CORP_CUST_LOANCARD = "corpCustLoancard"; 
	   public static String PROP_CORP_CUST_PSWD="corpCustPswd";
	   public static String PROP_CORP_CUST_COMPANYNAME="corpCustCompanyname";
	   public static String PROP_QUERY_REASON="queryReason";
	   public static String PROP_CORP_CUST_TYPE="corpCustType";
	   public static String PROP_CUST_ID="custId";
	   public static String PROP_REL_NAME="relName";
	   public static String PROP_REL_CUST_ID="relCustId";
	   public static String PROP_REL_CUST_id_TYPE="relCustIdType";
	   public static String PROP_REL_CORP_ID="relCorpId";
	   public static String PROP_CREATE_TIME="createTime";
	   public static String PROP_CREATE_USER="createUser";
	   public static String PROP_CONSENT_FILE_PATH="consentFilePath";
	   public static String PROP_INQ_TYPE="inqType";
	   public static String PROP_DETAIL_FLAG="detailFlag";
	   public static String PROP_NON_WORKHOUR_FILEPATH="nonWorkhourFilepath";
	   public static String PROP_CONFIRM_FLAG="confirmFlag";
	   public static String PROP_CREATE_USER_IP="createUserIp";
	   
	   
	   	 private java.lang.Integer id;
		 private java.lang.Integer corpCustAppid;
		 private java.lang.Integer corpCustDetailId;
		 private java.lang.String corpCustLoancard;
		 private java.lang.String corpCustPswd;
		 private java.lang.String corpCustCompanyname;
		 private java.lang.String queryReason;
		 private java.lang.String corpCustType;
		 private java.lang.Integer custId;
		 private java.lang.String relName;
		 private java.lang.String relCustId;
		 private java.lang.String relCustIdType;
		 private java.lang.String relCorpId;
		 private java.util.Date createTime;
		 private java.lang.String createUser;
		 private java.lang.String consentFilePath;
		 private java.lang.String inqType;
		 private java.lang.String detailFlag;
		 private java.lang.String nonWorkhourFilepath;
		 private java.lang.String confirmFlag;
		 private java.lang.String createUserIp;
		 private java.lang.String serviceCode;
		 public java.lang.String getServiceCode() {
			return serviceCode;
		}


		public void setServiceCode(java.lang.String serviceCode) {
			this.serviceCode = serviceCode;
		}


		public java.lang.String getEntCertType() {
			return entCertType;
		}


		public void setEntCertType(java.lang.String entCertType) {
			this.entCertType = entCertType;
		}


		public java.lang.String getEntCertNum() {
			return entCertNum;
		}


		public void setEntCertNum(java.lang.String entCertNum) {
			this.entCertNum = entCertNum;
		}


		private java.lang.String entCertType;
		 private java.lang.String entCertNum;
		 
		public BaseCorpCust() {
			super();
		}


		public BaseCorpCust(Integer id, Integer corpCustAppid,
				Integer corpCustDetailId, String corpCustLoancard,
				String corpCustPswd, String corpCustCompanyname,
				String queryReason, String corpCustType, Integer custId,
				String relName, String relCustId, String relCustIdType,
				String relCorpId, Date createTime, String createUser,
				String consentFilePath, String inqType, String detailFlag,String nonWorkhourFilepath,String confirmFlag,String createUserIp,
				String serviceCode,String entCertType,String entCertNum) {
			super();
			this.id = id;
			this.corpCustAppid = corpCustAppid;
			this.corpCustDetailId = corpCustDetailId;
			this.corpCustLoancard = corpCustLoancard;
			this.corpCustPswd = corpCustPswd;
			this.corpCustCompanyname = corpCustCompanyname;
			this.queryReason = queryReason;
			this.corpCustType = corpCustType;
			this.custId = custId;
			this.relName = relName;
			this.relCustId = relCustId;
			this.relCustIdType = relCustIdType;
			this.relCorpId = relCorpId;
			this.createTime = createTime;
			this.createUser = createUser;
			this.consentFilePath = consentFilePath;
			this.inqType = inqType;
			this.detailFlag = detailFlag;
			this.nonWorkhourFilepath=nonWorkhourFilepath;
			this.confirmFlag=confirmFlag;
			this.createUserIp=createUserIp;
			this.serviceCode=serviceCode;
			this.entCertType=entCertType;
			this.entCertNum=entCertNum;
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


		public static String getPROP_CORP_CUST_APPID() {
			return PROP_CORP_CUST_APPID;
		}


		public static void setPROP_CORP_CUST_APPID(String pROP_CORP_CUST_APPID) {
			PROP_CORP_CUST_APPID = pROP_CORP_CUST_APPID;
		}


		public static String getPROP_CORP_CUST_DETAIL_ID() {
			return PROP_CORP_CUST_DETAIL_ID;
		}


		public static void setPROP_CORP_CUST_DETAIL_ID(String pROP_CORP_CUST_DETAIL_ID) {
			PROP_CORP_CUST_DETAIL_ID = pROP_CORP_CUST_DETAIL_ID;
		}


		public static String getPROP_CORP_CUST_LOANCARD() {
			return PROP_CORP_CUST_LOANCARD;
		}


		public static void setPROP_CORP_CUST_LOANCARD(String pROP_CORP_CUST_LOANCARD) {
			PROP_CORP_CUST_LOANCARD = pROP_CORP_CUST_LOANCARD;
		}


		public static String getPROP_CORP_CUST_PSWD() {
			return PROP_CORP_CUST_PSWD;
		}


		public static void setPROP_CORP_CUST_PSWD(String pROP_CORP_CUST_PSWD) {
			PROP_CORP_CUST_PSWD = pROP_CORP_CUST_PSWD;
		}


		public static String getPROP_CORP_CUST_COMPANYNAME() {
			return PROP_CORP_CUST_COMPANYNAME;
		}


		public static void setPROP_CORP_CUST_COMPANYNAME(
				String pROP_CORP_CUST_COMPANYNAME) {
			PROP_CORP_CUST_COMPANYNAME = pROP_CORP_CUST_COMPANYNAME;
		}


		public static String getPROP_QUERY_REASON() {
			return PROP_QUERY_REASON;
		}


		public static void setPROP_QUERY_REASON(String pROP_QUERY_REASON) {
			PROP_QUERY_REASON = pROP_QUERY_REASON;
		}


		public static String getPROP_CORP_CUST_TYPE() {
			return PROP_CORP_CUST_TYPE;
		}


		public static void setPROP_CORP_CUST_TYPE(String pROP_CORP_CUST_TYPE) {
			PROP_CORP_CUST_TYPE = pROP_CORP_CUST_TYPE;
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


		public static String getPROP_CONSENT_FILE_PATH() {
			return PROP_CONSENT_FILE_PATH;
		}


		public static void setPROP_CONSENT_FILE_PATH(String pROP_CONSENT_FILE_PATH) {
			PROP_CONSENT_FILE_PATH = pROP_CONSENT_FILE_PATH;
		}


		public static String getPROP_INQ_TYPE() {
			return PROP_INQ_TYPE;
		}


		public static void setPROP_INQ_TYPE(String pROP_INQ_TYPE) {
			PROP_INQ_TYPE = pROP_INQ_TYPE;
		}


		public static String getPROP_DETAIL_FLAG() {
			return PROP_DETAIL_FLAG;
		}


		public static void setPROP_DETAIL_FLAG(String pROP_DETAIL_FLAG) {
			PROP_DETAIL_FLAG = pROP_DETAIL_FLAG;
		}


		public static String getPROP_NON_WORKHOUR_FILEPATH() {
			return PROP_NON_WORKHOUR_FILEPATH;
		}


		public static void setPROP_NON_WORKHOUR_FILEPATH(
				String pROP_NON_WORKHOUR_FILEPATH) {
			PROP_NON_WORKHOUR_FILEPATH = pROP_NON_WORKHOUR_FILEPATH;
		}


		public java.lang.Integer getId() {
			return id;
		}


		public void setId(java.lang.Integer id) {
			this.id = id;
		}


		public java.lang.Integer getCorpCustAppid() {
			return corpCustAppid;
		}


		public void setCorpCustAppid(java.lang.Integer corpCustAppid) {
			this.corpCustAppid = corpCustAppid;
		}


		public java.lang.Integer getCorpCustDetailId() {
			return corpCustDetailId;
		}


		public void setCorpCustDetailId(java.lang.Integer corpCustDetailId) {
			this.corpCustDetailId = corpCustDetailId;
		}


		public java.lang.String getCorpCustLoancard() {
			return corpCustLoancard;
		}


		public void setCorpCustLoancard(java.lang.String corpCustLoancard) {
			this.corpCustLoancard = corpCustLoancard;
		}


		public java.lang.String getCorpCustPswd() {
			return corpCustPswd;
		}


		public void setCorpCustPswd(java.lang.String corpCustPswd) {
			this.corpCustPswd = corpCustPswd;
		}


		public java.lang.String getCorpCustCompanyname() {
			return corpCustCompanyname;
		}


		public void setCorpCustCompanyname(java.lang.String corpCustCompanyname) {
			this.corpCustCompanyname = corpCustCompanyname;
		}


		public java.lang.String getQueryReason() {
			return queryReason;
		}


		public void setQueryReason(java.lang.String queryReason) {
			this.queryReason = queryReason;
		}


		public java.lang.String getCorpCustType() {
			return corpCustType;
		}


		public void setCorpCustType(java.lang.String corpCustType) {
			this.corpCustType = corpCustType;
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


		public java.lang.String getConsentFilePath() {
			return consentFilePath;
		}


		public void setConsentFilePath(java.lang.String consentFilePath) {
			this.consentFilePath = consentFilePath;
		}


		public java.lang.String getInqType() {
			return inqType;
		}


		public void setInqType(java.lang.String inqType) {
			this.inqType = inqType;
		}


		public java.lang.String getDetailFlag() {
			return detailFlag;
		}


		public void setDetailFlag(java.lang.String detailFlag) {
			this.detailFlag = detailFlag;
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
					+ ((createUserIp == null) ? 0 : createUserIp.hashCode());
			result = prime * result
					+ ((confirmFlag == null) ? 0 : confirmFlag.hashCode());
			result = prime
					* result
					+ ((nonWorkhourFilepath == null) ? 0 : nonWorkhourFilepath
							.hashCode());
			result = prime
					* result
					+ ((consentFilePath == null) ? 0 : consentFilePath
							.hashCode());
			result = prime * result
					+ ((corpCustAppid == null) ? 0 : corpCustAppid.hashCode());
			result = prime
					* result
					+ ((corpCustCompanyname == null) ? 0 : corpCustCompanyname
							.hashCode());
			result = prime
					* result
					+ ((corpCustDetailId == null) ? 0 : corpCustDetailId
							.hashCode());
			result = prime
					* result
					+ ((corpCustLoancard == null) ? 0 : corpCustLoancard
							.hashCode());
			result = prime * result
					+ ((corpCustPswd == null) ? 0 : corpCustPswd.hashCode());
			result = prime * result
					+ ((corpCustType == null) ? 0 : corpCustType.hashCode());
			result = prime * result
					+ ((createTime == null) ? 0 : createTime.hashCode());
			result = prime * result
					+ ((createUser == null) ? 0 : createUser.hashCode());
			result = prime * result
					+ ((custId == null) ? 0 : custId.hashCode());
			result = prime * result
					+ ((detailFlag == null) ? 0 : detailFlag.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((inqType == null) ? 0 : inqType.hashCode());
			result = prime * result
					+ ((queryReason == null) ? 0 : queryReason.hashCode());
			result = prime * result
					+ ((relCorpId == null) ? 0 : relCorpId.hashCode());
			result = prime * result
					+ ((relCustId == null) ? 0 : relCustId.hashCode());
			result = prime * result
					+ ((relCustIdType == null) ? 0 : relCustIdType.hashCode());
			result = prime * result
					+ ((relName == null) ? 0 : relName.hashCode());
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
			BaseCorpCust other = (BaseCorpCust) obj;
			if(createUserIp==null){
				if (other.createUserIp != null)
					return false;
			}else if(confirmFlag==null){
				if (other.confirmFlag != null)
					return false;
			}else if (nonWorkhourFilepath == null) {
				if (other.nonWorkhourFilepath != null)
					return false;
			} else if (consentFilePath == null) {
				if (other.consentFilePath != null)
					return false;
			} else if (!consentFilePath.equals(other.consentFilePath))
				return false;
			if (corpCustAppid == null) {
				if (other.corpCustAppid != null)
					return false;
			} else if (!corpCustAppid.equals(other.corpCustAppid))
				return false;
			if (corpCustCompanyname == null) {
				if (other.corpCustCompanyname != null)
					return false;
			} else if (!corpCustCompanyname.equals(other.corpCustCompanyname))
				return false;
			if (corpCustDetailId == null) {
				if (other.corpCustDetailId != null)
					return false;
			} else if (!corpCustDetailId.equals(other.corpCustDetailId))
				return false;
			if (corpCustLoancard == null) {
				if (other.corpCustLoancard != null)
					return false;
			} else if (!corpCustLoancard.equals(other.corpCustLoancard))
				return false;
			if (corpCustPswd == null) {
				if (other.corpCustPswd != null)
					return false;
			} else if (!corpCustPswd.equals(other.corpCustPswd))
				return false;
			if (corpCustType == null) {
				if (other.corpCustType != null)
					return false;
			} else if (!corpCustType.equals(other.corpCustType))
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
			if (detailFlag == null) {
				if (other.detailFlag != null)
					return false;
			} else if (!detailFlag.equals(other.detailFlag))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
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
			return true;
		}


		@Override
		public String toString() {
			return "BaseCorpCust [id=" + id + ", corpCustAppid="
					+ corpCustAppid + ", corpCustDetailId=" + corpCustDetailId
					+ ", corpCustLoancard=" + corpCustLoancard
					+ ", corpCustPswd=" + corpCustPswd
					+ ", corpCustCompanyname=" + corpCustCompanyname
					+ ", queryReason=" + queryReason + ", corpCustType="
					+ corpCustType + ", custId=" + custId + ", relName="
					+ relName + ", relCustId=" + relCustId + ", relCustIdType="
					+ relCustIdType + ", relCorpId=" + relCorpId
					+ ", createTime=" + createTime + ", createUser="
					+ createUser + ", consentFilePath=" + consentFilePath
					+ ", inqType=" + inqType + ", detailFlag=" + detailFlag
					+ ", nonWorkhourFilepath=" + nonWorkhourFilepath
					+ ", confirmFlag=" + confirmFlag + ", createUserIp="
					+ createUserIp + "]";
		}	
		 
		 
}

package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAssureIndCust  implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 8570218111598168438L;
		public static String PROP_ID="id";
	    public static String PROP_APP_ID="appId";
	    public static String PROP_INDIVIDUAL_ID="individualId";
	    public static String PROP_INDIVIDUAL_ID_TYPE="individualIdType";
	    public static String PROP_NAME="name";
	    public static String PROP_INPUT_USER="inputUser";
	    public static String PROP_INPUT_TIME="inputTime";
	    public static String PROP_CONSENT_FILE_PATH="consentFilePath";
	    public static String PROP_INPUT_USER_IP="inputUserIp";
	    public static String PROP_NON_CONSENT_FILE_PATH="nonConsentFilePath";
	    public static String PROP_RSV1="rsv1";
	    public static String PROP_RSV2="rsv2";
	    public static String PROP_RSV3="rsv3";
	    public static String PROP_RSV4="rsv4";
	    public static String PROP_RSV5="rsv5";
	    public static String PROP_RSV6="rsv6";
	    public static String PROP_RSV7="rsv7";
	    public static String PROP_RSV8="rsv8";
	    
	    
	    protected void initialize() {
	    }

	    private int hashCode = Integer.MIN_VALUE;

	    // primary key
	    private java.lang.Integer id;

	    // fields
	    private java.lang.String appId;
	    private java.lang.String individualId;
	    private java.lang.String individualIdType;
	    private java.lang.String name;
	    private java.lang.String inputUser;
	    private java.util.Date inputTime;
	    private java.lang.String consentFilePath;
	    private java.lang.String inputUserIp;
	    private java.lang.String nonConsentFilePath;
	    private java.lang.String rsv1;
	    private java.lang.String rsv2;
	    private java.lang.String rsv3;
	    private java.lang.String rsv4;
	    private java.lang.String rsv5;
	    private java.lang.String rsv6;
	    private java.lang.String rsv7;
	    private java.lang.String rsv8;


		public BaseAssureIndCust() {
			super();
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
		public static String getPROP_INDIVIDUAL_ID() {
			return PROP_INDIVIDUAL_ID;
		}
		public static void setPROP_INDIVIDUAL_ID(String pROP_INDIVIDUAL_ID) {
			PROP_INDIVIDUAL_ID = pROP_INDIVIDUAL_ID;
		}
		public static String getPROP_INDIVIDUAL_ID_TYPE() {
			return PROP_INDIVIDUAL_ID_TYPE;
		}
		public static void setPROP_INDIVIDUAL_ID_TYPE(String pROP_INDIVIDUAL_ID_TYPE) {
			PROP_INDIVIDUAL_ID_TYPE = pROP_INDIVIDUAL_ID_TYPE;
		}
		public static String getPROP_NAME() {
			return PROP_NAME;
		}
		public static void setPROP_NAME(String pROP_NAME) {
			PROP_NAME = pROP_NAME;
		}
		public static String getPROP_INPUT_USER() {
			return PROP_INPUT_USER;
		}
		public static void setPROP_INPUT_USER(String pROP_INPUT_USER) {
			PROP_INPUT_USER = pROP_INPUT_USER;
		}
		public static String getPROP_INPUT_TIME() {
			return PROP_INPUT_TIME;
		}
		public static void setPROP_INPUT_TIME(String pROP_INPUT_TIME) {
			PROP_INPUT_TIME = pROP_INPUT_TIME;
		}
		public static String getPROP_CONSENT_FILE_PATH() {
			return PROP_CONSENT_FILE_PATH;
		}
		public static void setPROP_CONSENT_FILE_PATH(String pROP_CONSENT_FILE_PATH) {
			PROP_CONSENT_FILE_PATH = pROP_CONSENT_FILE_PATH;
		}
		public static String getPROP_INPUT_USER_IP() {
			return PROP_INPUT_USER_IP;
		}
		public static void setPROP_INPUT_USER_IP(String pROP_INPUT_USER_IP) {
			PROP_INPUT_USER_IP = pROP_INPUT_USER_IP;
		}
		public static String getPROP_NON_CONSENT_FILE_PATH() {
			return PROP_NON_CONSENT_FILE_PATH;
		}
		public static void setPROP_NON_CONSENT_FILE_PATH(
				String pROP_NON_CONSENT_FILE_PATH) {
			PROP_NON_CONSENT_FILE_PATH = pROP_NON_CONSENT_FILE_PATH;
		}
		public static String getPROP_RSV1() {
			return PROP_RSV1;
		}
		public static void setPROP_RSV1(String pROP_RSV1) {
			PROP_RSV1 = pROP_RSV1;
		}
		public static String getPROP_RSV2() {
			return PROP_RSV2;
		}
		public static void setPROP_RSV2(String pROP_RSV2) {
			PROP_RSV2 = pROP_RSV2;
		}
		public static String getPROP_RSV3() {
			return PROP_RSV3;
		}
		public static void setPROP_RSV3(String pROP_RSV3) {
			PROP_RSV3 = pROP_RSV3;
		}
		public static String getPROP_RSV4() {
			return PROP_RSV4;
		}
		public static void setPROP_RSV4(String pROP_RSV4) {
			PROP_RSV4 = pROP_RSV4;
		}
		public static String getPROP_RSV5() {
			return PROP_RSV5;
		}
		public static void setPROP_RSV5(String pROP_RSV5) {
			PROP_RSV5 = pROP_RSV5;
		}
		public static String getPROP_RSV6() {
			return PROP_RSV6;
		}
		public static void setPROP_RSV6(String pROP_RSV6) {
			PROP_RSV6 = pROP_RSV6;
		}
		public static String getPROP_RSV7() {
			return PROP_RSV7;
		}
		public static void setPROP_RSV7(String pROP_RSV7) {
			PROP_RSV7 = pROP_RSV7;
		}
		public static String getPROP_RSV8() {
			return PROP_RSV8;
		}
		public static void setPROP_RSV8(String pROP_RSV8) {
			PROP_RSV8 = pROP_RSV8;
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
		public java.lang.String getAppId() {
			return appId;
		}
		public void setAppId(java.lang.String appId) {
			this.appId = appId;
		}
		public java.lang.String getIndividualId() {
			return individualId;
		}
		public void setIndividualId(java.lang.String individualId) {
			this.individualId = individualId;
		}
		public java.lang.String getIndividualIdType() {
			return individualIdType;
		}
		public void setIndividualIdType(java.lang.String individualIdType) {
			this.individualIdType = individualIdType;
		}
		public java.lang.String getName() {
			return name;
		}
		public void setName(java.lang.String name) {
			this.name = name;
		}
		public java.lang.String getInputUser() {
			return inputUser;
		}
		public void setInputUser(java.lang.String inputUser) {
			this.inputUser = inputUser;
		}
		public java.util.Date getInputTime() {
			return inputTime;
		}
		public void setInputTime(java.util.Date inputTime) {
			this.inputTime = inputTime;
		}
		public java.lang.String getConsentFilePath() {
			return consentFilePath;
		}
		public void setConsentFilePath(java.lang.String consentFilePath) {
			this.consentFilePath = consentFilePath;
		}
		public java.lang.String getInputUserIp() {
			return inputUserIp;
		}
		public void setInputUserIp(java.lang.String inputUserIp) {
			this.inputUserIp = inputUserIp;
		}
		public java.lang.String getNonConsentFilePath() {
			return nonConsentFilePath;
		}
		public void setNonConsentFilePath(java.lang.String nonConsentFilePath) {
			this.nonConsentFilePath = nonConsentFilePath;
		}
		public java.lang.String getRsv1() {
			return rsv1;
		}
		public void setRsv1(java.lang.String rsv1) {
			this.rsv1 = rsv1;
		}
		public java.lang.String getRsv2() {
			return rsv2;
		}
		public void setRsv2(java.lang.String rsv2) {
			this.rsv2 = rsv2;
		}
		public java.lang.String getRsv3() {
			return rsv3;
		}
		public void setRsv3(java.lang.String rsv3) {
			this.rsv3 = rsv3;
		}
		public java.lang.String getRsv4() {
			return rsv4;
		}
		public void setRsv4(java.lang.String rsv4) {
			this.rsv4 = rsv4;
		}
		public java.lang.String getRsv5() {
			return rsv5;
		}
		public void setRsv5(java.lang.String rsv5) {
			this.rsv5 = rsv5;
		}
		public java.lang.String getRsv6() {
			return rsv6;
		}
		public void setRsv6(java.lang.String rsv6) {
			this.rsv6 = rsv6;
		}
		public java.lang.String getRsv7() {
			return rsv7;
		}
		public void setRsv7(java.lang.String rsv7) {
			this.rsv7 = rsv7;
		}
		public java.lang.String getRsv8() {
			return rsv8;
		}
		public void setRsv8(java.lang.String rsv8) {
			this.rsv8 = rsv8;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((appId == null) ? 0 : appId.hashCode());
			result = prime
					* result
					+ ((consentFilePath == null) ? 0 : consentFilePath
							.hashCode());
			result = prime * result + hashCode;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((individualId == null) ? 0 : individualId.hashCode());
			result = prime
					* result
					+ ((individualIdType == null) ? 0 : individualIdType
							.hashCode());
			result = prime * result
					+ ((inputTime == null) ? 0 : inputTime.hashCode());
			result = prime * result
					+ ((inputUser == null) ? 0 : inputUser.hashCode());
			result = prime * result
					+ ((inputUserIp == null) ? 0 : inputUserIp.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime
					* result
					+ ((nonConsentFilePath == null) ? 0 : nonConsentFilePath
							.hashCode());
			result = prime * result + ((rsv1 == null) ? 0 : rsv1.hashCode());
			result = prime * result + ((rsv2 == null) ? 0 : rsv2.hashCode());
			result = prime * result + ((rsv3 == null) ? 0 : rsv3.hashCode());
			result = prime * result + ((rsv4 == null) ? 0 : rsv4.hashCode());
			result = prime * result + ((rsv5 == null) ? 0 : rsv5.hashCode());
			result = prime * result + ((rsv6 == null) ? 0 : rsv6.hashCode());
			result = prime * result + ((rsv7 == null) ? 0 : rsv7.hashCode());
			result = prime * result + ((rsv8 == null) ? 0 : rsv8.hashCode());
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
			BaseAssureIndCust other = (BaseAssureIndCust) obj;
			if (appId == null) {
				if (other.appId != null)
					return false;
			} else if (!appId.equals(other.appId))
				return false;
			if (consentFilePath == null) {
				if (other.consentFilePath != null)
					return false;
			} else if (!consentFilePath.equals(other.consentFilePath))
				return false;
			if (hashCode != other.hashCode)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (individualId == null) {
				if (other.individualId != null)
					return false;
			} else if (!individualId.equals(other.individualId))
				return false;
			if (individualIdType == null) {
				if (other.individualIdType != null)
					return false;
			} else if (!individualIdType.equals(other.individualIdType))
				return false;
			if (inputTime == null) {
				if (other.inputTime != null)
					return false;
			} else if (!inputTime.equals(other.inputTime))
				return false;
			if (inputUser == null) {
				if (other.inputUser != null)
					return false;
			} else if (!inputUser.equals(other.inputUser))
				return false;
			if (inputUserIp == null) {
				if (other.inputUserIp != null)
					return false;
			} else if (!inputUserIp.equals(other.inputUserIp))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (nonConsentFilePath == null) {
				if (other.nonConsentFilePath != null)
					return false;
			} else if (!nonConsentFilePath.equals(other.nonConsentFilePath))
				return false;
			if (rsv1 == null) {
				if (other.rsv1 != null)
					return false;
			} else if (!rsv1.equals(other.rsv1))
				return false;
			if (rsv2 == null) {
				if (other.rsv2 != null)
					return false;
			} else if (!rsv2.equals(other.rsv2))
				return false;
			if (rsv3 == null) {
				if (other.rsv3 != null)
					return false;
			} else if (!rsv3.equals(other.rsv3))
				return false;
			if (rsv4 == null) {
				if (other.rsv4 != null)
					return false;
			} else if (!rsv4.equals(other.rsv4))
				return false;
			if (rsv5 == null) {
				if (other.rsv5 != null)
					return false;
			} else if (!rsv5.equals(other.rsv5))
				return false;
			if (rsv6 == null) {
				if (other.rsv6 != null)
					return false;
			} else if (!rsv6.equals(other.rsv6))
				return false;
			if (rsv7 == null) {
				if (other.rsv7 != null)
					return false;
			} else if (!rsv7.equals(other.rsv7))
				return false;
			if (rsv8 == null) {
				if (other.rsv8 != null)
					return false;
			} else if (!rsv8.equals(other.rsv8))
				return false;
			return true;
		}
		public BaseAssureIndCust(int hashCode, Integer id, String appId,
				String individualId, String individualIdType, String name,
				String inputUser, Date inputTime, String consentFilePath,
				String inputUserIp, String nonConsentFilePath, String rsv1,
				String rsv2, String rsv3, String rsv4, String rsv5,
				String rsv6, String rsv7, String rsv8) {
			super();
			this.hashCode = hashCode;
			this.id = id;
			this.appId = appId;
			this.individualId = individualId;
			this.individualIdType = individualIdType;
			this.name = name;
			this.inputUser = inputUser;
			this.inputTime = inputTime;
			this.consentFilePath = consentFilePath;
			this.inputUserIp = inputUserIp;
			this.nonConsentFilePath = nonConsentFilePath;
			this.rsv1 = rsv1;
			this.rsv2 = rsv2;
			this.rsv3 = rsv3;
			this.rsv4 = rsv4;
			this.rsv5 = rsv5;
			this.rsv6 = rsv6;
			this.rsv7 = rsv7;
			this.rsv8 = rsv8;
		}
		@Override
		public String toString() {
			return "BaseAssureIndCust [hashCode=" + hashCode + ", id=" + id
					+ ", appId=" + appId + ", individualId=" + individualId
					+ ", individualIdType=" + individualIdType + ", name="
					+ name + ", inputUser=" + inputUser + ", inputTime="
					+ inputTime + ", consentFilePath=" + consentFilePath
					+ ", inputUserIp=" + inputUserIp + ", nonConsentFilePath="
					+ nonConsentFilePath + ", rsv1=" + rsv1 + ", rsv2=" + rsv2
					+ ", rsv3=" + rsv3 + ", rsv4=" + rsv4 + ", rsv5=" + rsv5
					+ ", rsv6=" + rsv6 + ", rsv7=" + rsv7 + ", rsv8=" + rsv8
					+ "]";
		}
	   
	    
	    
	    
		
		
		
		
}

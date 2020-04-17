package resource.bean.basic.base;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 */

public abstract class BaseTDetailIndApp implements Serializable {
	private static final long serialVersionUID = 4451754977452556749L;
	
	public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_INDIVIDUAL_ID="individualId";
    public static String PROP_INDIVIDUAL_ID_TYPE="individualIdType";
    public static String PROP_TYPE="type";
    public static String PROP_NAME="name";
    public static String PROP_INPUT_USER="inputUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_QUERY_TIME="queryTime";
    public static String PROP_RETURN_TIME="returnTime";
	public static String PROP_PARSE_TIME="parseTime";
	public static String PROP_STATUS="status";
	public static String PROP_INPUT_USER_IP="inputUserIp";
	
	
	

	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.lang.String individualId;
    private java.lang.String individualIdType;
    private java.lang.String type;
    private java.lang.String name;
    private java.lang.String inputUser;
    private Timestamp inputTime;
    private Timestamp queryTime;
    private Timestamp returnTime;
    private Timestamp parseTime;
    private java.lang.String status;
    private java.lang.String inputUserIp;




    public BaseTDetailIndApp(){
    	super();
    }
	public BaseTDetailIndApp(int hashCode, Integer id, String rptKey,
			String individualId, String individualIdType, String name,String type,
			String inputUser, Timestamp inputTime, Timestamp queryTime, Timestamp returnTime,
			Timestamp parseTime, String status, String inputUserIp) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.individualId = individualId;
		this.individualIdType = individualIdType;
		this.type = type;
		this.name = name;
		this.inputUser = inputUser;
		this.inputTime = inputTime;
		this.queryTime = queryTime;
		this.returnTime = returnTime;
		this.parseTime = parseTime;
		this.status = status;
		this.inputUserIp = inputUserIp;
	}
	
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
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
	public static String getPROP_PARSE_TIME() {
		return PROP_PARSE_TIME;
	}
	public static void setPROP_PARSE_TIME(String pROP_PARSE_TIME) {
		PROP_PARSE_TIME = pROP_PARSE_TIME;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_INPUT_USER_IP() {
		return PROP_INPUT_USER_IP;
	}
	public static void setPROP_INPUT_USER_IP(String pROP_INPUT_USER_IP) {
		PROP_INPUT_USER_IP = pROP_INPUT_USER_IP;
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
	public Timestamp getInputTime() {
		return inputTime;
	}
	public void setInputTime(Timestamp inputTime) {
		this.inputTime = inputTime;
	}
	public Timestamp getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(Timestamp queryTime) {
		this.queryTime = queryTime;
	}
	public Timestamp getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Timestamp returnTime) {
		this.returnTime = returnTime;
	}
	public Timestamp getParseTime() {
		return parseTime;
	}
	public void setParseTime(Timestamp parseTime) {
		this.parseTime = parseTime;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getInputUserIp() {
		return inputUserIp;
	}
	public void setInputUserIp(java.lang.String inputUserIp) {
		this.inputUserIp = inputUserIp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((individualId == null) ? 0 : individualId.hashCode());
		result = prime
				* result
				+ ((individualIdType == null) ? 0 : individualIdType.hashCode());
		result = prime
				* result
				+ ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result
				+ ((inputUser == null) ? 0 : inputUser.hashCode());
		result = prime * result
				+ ((inputUserIp == null) ? 0 : inputUserIp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((parseTime == null) ? 0 : parseTime.hashCode());
		result = prime * result
				+ ((queryTime == null) ? 0 : queryTime.hashCode());
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
		BaseTDetailIndApp other = (BaseTDetailIndApp) obj;
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		if (parseTime == null) {
			if (other.parseTime != null)
				return false;
		} else if (!parseTime.equals(other.parseTime))
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
		return true;
	}
	@Override
	public String toString() {
		return "BaseTDetailIndApp [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", individualId=" + individualId
				+ ", individualIdType=" + individualIdType + ", name=" + name
				+ ", inputUser=" + inputUser + ", inputTime=" + inputTime
				+ ", queryTime=" + queryTime + ", returnTime=" + returnTime
				+ ", parseTime=" + parseTime + ", status=" + status
				+ ", inputUserIp=" + inputUserIp +", type=" + type + "]";
	}
    
    

}
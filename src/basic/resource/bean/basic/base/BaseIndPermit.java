package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the TLR_LOGIN_LOG table. Do
 * not modify this class because it will be overwritten if the configuration
 * file related to this class is modified.
 *
 * @hibernate.class table="Ind_permit"
 */

public abstract class BaseIndPermit implements Serializable {

	private static final long serialVersionUID = 5209513467412657202L;
	public static String REF = "IndPermit";
	public static String PROP_ID = "id";
	public static String PROP_INDIVIDUAL_ID = "individualId";
	public static String PROP_ID_TYPE = "idType";
	public static String PROP_NAME = "name";
    public static String PROP_CUSTOMER_CON_UP="customerConUp";
    public static String PROP_CUSTOMER_CON_UP2="customerConUp2";
    public static String PROP_CREATE_USER="createUser";
    public static String PROP_INPUT_TIME="inputTime";
    public static String PROP_EXPIRE_DATE="expireDate";
    public static String PROP_APPROVE_DATE="approveTime";
    public static String PROP_STATUS="status";
   
    // constructors
    public BaseIndPermit() {
        initialize();
    }


    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

 // primary key
    private java.lang.Integer id;
    // fields
    private java.lang.String individualId;
    private java.lang.String idType;
    private java.lang.String name;
    private java.lang.String customerConUp;
    private java.lang.String customerConUp2;
    private java.lang.String createUser;
    private java.lang.String status;
    public  java.util.Date inputTime;
    private java.util.Date expireDate;
    private java.util.Date approveTime;
    


	public BaseIndPermit(int hashCode, Integer id, String individualId,
			String idType, String name, String customerConUp,
			String customerConUp2, String createUser, String status,
			Date inputTime, Date expireDate, Date approveTime) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.individualId = individualId;
		this.idType = idType;
		this.name = name;
		this.customerConUp = customerConUp;
		this.customerConUp2 = customerConUp2;
		this.createUser = createUser;
		this.status = status;
		this.inputTime = inputTime;
		this.expireDate = expireDate;
		this.approveTime = approveTime;
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


	public static String getPROP_INDIVIDUAL_ID() {
		return PROP_INDIVIDUAL_ID;
	}


	public static void setPROP_INDIVIDUAL_ID(String pROP_INDIVIDUAL_ID) {
		PROP_INDIVIDUAL_ID = pROP_INDIVIDUAL_ID;
	}


	public static String getPROP_ID_TYPE() {
		return PROP_ID_TYPE;
	}


	public static void setPROP_ID_TYPE(String pROP_ID_TYPE) {
		PROP_ID_TYPE = pROP_ID_TYPE;
	}


	public static String getPROP_NAME() {
		return PROP_NAME;
	}


	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}


	public static String getPROP_CUSTOMER_CON_UP() {
		return PROP_CUSTOMER_CON_UP;
	}


	public static void setPROP_CUSTOMER_CON_UP(String pROP_CUSTOMER_CON_UP) {
		PROP_CUSTOMER_CON_UP = pROP_CUSTOMER_CON_UP;
	}


	public static String getPROP_CUSTOMER_CON_UP2() {
		return PROP_CUSTOMER_CON_UP2;
	}


	public static void setPROP_CUSTOMER_CON_UP2(String pROP_CUSTOMER_CON_UP2) {
		PROP_CUSTOMER_CON_UP2 = pROP_CUSTOMER_CON_UP2;
	}


	public static String getPROP_CREATE_USER() {
		return PROP_CREATE_USER;
	}


	public static void setPROP_CREATE_USER(String pROP_CREATE_USER) {
		PROP_CREATE_USER = pROP_CREATE_USER;
	}


	public static String getPROP_INPUT_TIME() {
		return PROP_INPUT_TIME;
	}


	public static void setPROP_INPUT_TIME(String pROP_INPUT_TIME) {
		PROP_INPUT_TIME = pROP_INPUT_TIME;
	}


	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}


	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}


	public static String getPROP_APPROVE_DATE() {
		return PROP_APPROVE_DATE;
	}


	public static void setPROP_APPROVE_DATE(String pROP_APPROVE_DATE) {
		PROP_APPROVE_DATE = pROP_APPROVE_DATE;
	}


	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}


	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
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


	public java.lang.String getIndividualId() {
		return individualId;
	}


	public void setIndividualId(java.lang.String individualId) {
		this.individualId = individualId;
	}


	public java.lang.String getIdType() {
		return idType;
	}


	public void setIdType(java.lang.String idType) {
		this.idType = idType;
	}


	public java.lang.String getName() {
		return name;
	}


	public void setName(java.lang.String name) {
		this.name = name;
	}


	public java.lang.String getCustomerConUp() {
		return customerConUp;
	}


	public void setCustomerConUp(java.lang.String customerConUp) {
		this.customerConUp = customerConUp;
	}


	public java.lang.String getCustomerConUp2() {
		return customerConUp2;
	}


	public void setCustomerConUp2(java.lang.String customerConUp2) {
		this.customerConUp2 = customerConUp2;
	}


	public java.lang.String getCreateUser() {
		return createUser;
	}


	public void setCreateUser(java.lang.String createUser) {
		this.createUser = createUser;
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


	public java.util.Date getExpireDate() {
		return expireDate;
	}


	public void setExpireDate(java.util.Date expireDate) {
		this.expireDate = expireDate;
	}


	public java.util.Date getApproveTime() {
		return approveTime;
	}


	public void setApproveTime(java.util.Date approveTime) {
		this.approveTime = approveTime;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approveTime == null) ? 0 : approveTime.hashCode());
		result = prime * result
				+ ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result
				+ ((customerConUp == null) ? 0 : customerConUp.hashCode());
		result = prime * result
				+ ((customerConUp2 == null) ? 0 : customerConUp2.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result
				+ ((individualId == null) ? 0 : individualId.hashCode());
		result = prime * result
				+ ((inputTime == null) ? 0 : inputTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BaseIndPermit other = (BaseIndPermit) obj;
		if (approveTime == null) {
			if (other.approveTime != null)
				return false;
		} else if (!approveTime.equals(other.approveTime))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (customerConUp == null) {
			if (other.customerConUp != null)
				return false;
		} else if (!customerConUp.equals(other.customerConUp))
			return false;
		if (customerConUp2 == null) {
			if (other.customerConUp2 != null)
				return false;
		} else if (!customerConUp2.equals(other.customerConUp2))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "BaseIndPermit [hashCode=" + hashCode + ", id=" + id
				+ ", individualId=" + individualId + ", idType=" + idType
				+ ", name=" + name + ", customerConUp=" + customerConUp
				+ ", customerConUp2=" + customerConUp2 + ", createUser="
				+ createUser + ", status=" + status + ", inputTime="
				+ inputTime + ", expireDate=" + expireDate + ", approveTime="
				+ approveTime + "]";
	}
	
    
    
    
}
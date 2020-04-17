package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.TlrInfo;

/**
 * This is an object that contains data related to the TLR_INFO table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="TLR_INFO"
 */

public abstract class BaseTlrInfoChange implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 8055946567580283873L;
	public static String REF = "TlrInfoChange";
    public static String PROP_OPER_STATUS = "operStatus";
    public static String PROP_DEPARTMENT = "department";
    public static String PROP_REGION = "region";
    public static String PROP_CITY = "city";
    public static String PROP_LAST_UPD_OPER = "lastUpdOper";
    public static String PROP_LAST_UPD_TMS = "lastUpdTms";
    public static String PROP_IS_LOCK = "isLock";
    public static String PROP_STATUS = "status";
    public static String PROP_FLAG = "flag";
    public static String PROP_TLRNO = "tlrno";
    public static String PROP_TLR_NAME = "tlrName";
    public static String PROP_ID = "id";


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String operStatus;
    private java.lang.String department;
    private java.lang.String region;
    private java.lang.String city;
    private java.lang.String lastUpdOper;
    private java.lang.String lastUpdTms;
    private java.lang.String isLock;
    private java.lang.String flag;
    private java.lang.String tlrName;
    private java.lang.String tlrno;
    private java.lang.String status;

	public static String getREF() {
		return REF;
	}
	public static void setREF(String rEF) {
		REF = rEF;
	}
	public static String getPROP_OPER_STATUS() {
		return PROP_OPER_STATUS;
	}
	public static void setPROP_OPER_STATUS(String pROP_OPER_STATUS) {
		PROP_OPER_STATUS = pROP_OPER_STATUS;
	}
	public static String getPROP_DEPARTMENT() {
		return PROP_DEPARTMENT;
	}
	public static void setPROP_DEPARTMENT(String pROP_DEPARTMENT) {
		PROP_DEPARTMENT = pROP_DEPARTMENT;
	}
	public static String getPROP_REGION() {
		return PROP_REGION;
	}
	public static void setPROP_REGION(String pROP_REGION) {
		PROP_REGION = pROP_REGION;
	}
	public static String getPROP_CITY() {
		return PROP_CITY;
	}
	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}
	public static String getPROP_LAST_UPD_OPER() {
		return PROP_LAST_UPD_OPER;
	}
	public static void setPROP_LAST_UPD_OPER(String pROP_LAST_UPD_OPER) {
		PROP_LAST_UPD_OPER = pROP_LAST_UPD_OPER;
	}
	public static String getPROP_LAST_UPD_TMS() {
		return PROP_LAST_UPD_TMS;
	}
	public static void setPROP_LAST_UPD_TMS(String pROP_LAST_UPD_TMS) {
		PROP_LAST_UPD_TMS = pROP_LAST_UPD_TMS;
	}
	public static String getPROP_IS_LOCK() {
		return PROP_IS_LOCK;
	}
	public static void setPROP_IS_LOCK(String pROP_IS_LOCK) {
		PROP_IS_LOCK = pROP_IS_LOCK;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_FLAG() {
		return PROP_FLAG;
	}
	public static void setPROP_FLAG(String pROP_FLAG) {
		PROP_FLAG = pROP_FLAG;
	}
	public static String getPROP_TLRNO() {
		return PROP_TLRNO;
	}
	public static void setPROP_TLRNO(String pROP_TLRNO) {
		PROP_TLRNO = pROP_TLRNO;
	}
	public static String getPROP_TLR_NAME() {
		return PROP_TLR_NAME;
	}
	public static void setPROP_TLR_NAME(String pROP_TLR_NAME) {
		PROP_TLR_NAME = pROP_TLR_NAME;
	}
	public static String getPROP_ID() {
		return PROP_ID;
	}
	public static void setPROP_ID(String pROP_ID) {
		PROP_ID = pROP_ID;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getOperStatus() {
		return operStatus;
	}
	public void setOperStatus(java.lang.String operStatus) {
		this.operStatus = operStatus;
	}
	public java.lang.String getDepartment() {
		return department;
	}
	public void setDepartment(java.lang.String department) {
		this.department = department;
	}
	public java.lang.String getRegion() {
		return region;
	}
	public void setRegion(java.lang.String region) {
		this.region = region;
	}
	public java.lang.String getCity() {
		return city;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	public java.lang.String getLastUpdOper() {
		return lastUpdOper;
	}
	public void setLastUpdOper(java.lang.String lastUpdOper) {
		this.lastUpdOper = lastUpdOper;
	}
	public java.lang.String getLastUpdTms() {
		return lastUpdTms;
	}
	public void setLastUpdTms(java.lang.String lastUpdTms) {
		this.lastUpdTms = lastUpdTms;
	}
	public java.lang.String getIsLock() {
		return isLock;
	}
	public void setIsLock(java.lang.String isLock) {
		this.isLock = isLock;
	}
	public java.lang.String getFlag() {
		return flag;
	}
	public void setFlag(java.lang.String flag) {
		this.flag = flag;
	}
	public java.lang.String getTlrName() {
		return tlrName;
	}
	public void setTlrName(java.lang.String tlrName) {
		this.tlrName = tlrName;
	}
	public java.lang.String getTlrno() {
		return tlrno;
	}
	public void setTlrno(java.lang.String tlrno) {
		this.tlrno = tlrno;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BaseTlrInfoChange [id=" + id + ", operStatus=" + operStatus
				+ ", department=" + department + ", region=" + region
				+ ", city=" + city + ", lastUpdOper=" + lastUpdOper
				+ ", lastUpdTms=" + lastUpdTms + ", isLock=" + isLock
				+ ", flag=" + flag + ", tlrName=" + tlrName + ", tlrno="
				+ tlrno + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((flag == null) ? 0 : flag.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isLock == null) ? 0 : isLock.hashCode());
		result = prime * result
				+ ((lastUpdOper == null) ? 0 : lastUpdOper.hashCode());
		result = prime * result
				+ ((lastUpdTms == null) ? 0 : lastUpdTms.hashCode());
		result = prime * result
				+ ((operStatus == null) ? 0 : operStatus.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tlrName == null) ? 0 : tlrName.hashCode());
		result = prime * result + ((tlrno == null) ? 0 : tlrno.hashCode());
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
		BaseTlrInfoChange other = (BaseTlrInfoChange) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (flag == null) {
			if (other.flag != null)
				return false;
		} else if (!flag.equals(other.flag))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isLock == null) {
			if (other.isLock != null)
				return false;
		} else if (!isLock.equals(other.isLock))
			return false;
		if (lastUpdOper == null) {
			if (other.lastUpdOper != null)
				return false;
		} else if (!lastUpdOper.equals(other.lastUpdOper))
			return false;
		if (lastUpdTms == null) {
			if (other.lastUpdTms != null)
				return false;
		} else if (!lastUpdTms.equals(other.lastUpdTms))
			return false;
		if (operStatus == null) {
			if (other.operStatus != null)
				return false;
		} else if (!operStatus.equals(other.operStatus))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tlrName == null) {
			if (other.tlrName != null)
				return false;
		} else if (!tlrName.equals(other.tlrName))
			return false;
		if (tlrno == null) {
			if (other.tlrno != null)
				return false;
		} else if (!tlrno.equals(other.tlrno))
			return false;
		return true;
	}
	public BaseTlrInfoChange() {
		super();
	}
	public BaseTlrInfoChange(Integer id, String operStatus, String department,
			String region, String city, String lastUpdOper, String lastUpdTms,
			String isLock, String flag, String tlrName, String tlrno,
			String status) {
		super();
		this.id = id;
		this.operStatus = operStatus;
		this.department = department;
		this.region = region;
		this.city = city;
		this.lastUpdOper = lastUpdOper;
		this.lastUpdTms = lastUpdTms;
		this.isLock = isLock;
		this.flag = flag;
		this.tlrName = tlrName;
		this.tlrno = tlrno;
		this.status = status;
	}

    

}
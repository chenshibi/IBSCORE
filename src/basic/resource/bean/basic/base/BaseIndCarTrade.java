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

public abstract class BaseIndCarTrade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndCarTrade";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_BRAND="brand";
    public static String PROP_CAR_NUMBER="carNumber";
    public static String PROP_CAR_USAGE="carUsage";
    public static String PROP_ENGINE_NUMBER="engineNumber";
    public static String PROP_NO="no";
    public static String PROP_PLEDGED="pledged";
    public static String PROP_STATUS="status";
    public static String PROP_TYPE="type";
    public static String PROP_UPDATE_DATE="updateDate";

    public BaseIndCarTrade() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String brand;
    private java.lang.String carNumber;
    private java.lang.String carUsage;
    private java.lang.String engineNumber;
    private java.lang.Integer no;
    private java.lang.String pledged;
    private java.lang.String status;
    private java.lang.String type;
    private java.lang.String updateDate;

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
	public static String getPROP_BRAND() {
		return PROP_BRAND;
	}
	public static void setPROP_BRAND(String pROP_BRAND) {
		PROP_BRAND = pROP_BRAND;
	}
	public static String getPROP_CAR_NUMBER() {
		return PROP_CAR_NUMBER;
	}
	public static void setPROP_CAR_NUMBER(String pROP_CAR_NUMBER) {
		PROP_CAR_NUMBER = pROP_CAR_NUMBER;
	}
	public static String getPROP_CAR_USAGE() {
		return PROP_CAR_USAGE;
	}
	public static void setPROP_CAR_USAGE(String pROP_CAR_USAGE) {
		PROP_CAR_USAGE = pROP_CAR_USAGE;
	}
	public static String getPROP_ENGINE_NUMBER() {
		return PROP_ENGINE_NUMBER;
	}
	public static void setPROP_ENGINE_NUMBER(String pROP_ENGINE_NUMBER) {
		PROP_ENGINE_NUMBER = pROP_ENGINE_NUMBER;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_PLEDGED() {
		return PROP_PLEDGED;
	}
	public static void setPROP_PLEDGED(String pROP_PLEDGED) {
		PROP_PLEDGED = pROP_PLEDGED;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_UPDATE_DATE() {
		return PROP_UPDATE_DATE;
	}
	public static void setPROP_UPDATE_DATE(String pROP_UPDATE_DATE) {
		PROP_UPDATE_DATE = pROP_UPDATE_DATE;
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
	public java.lang.String getBrand() {
		return brand;
	}
	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}
	public java.lang.String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(java.lang.String carNumber) {
		this.carNumber = carNumber;
	}
	public java.lang.String getCarUsage() {
		return carUsage;
	}
	public void setCarUsage(java.lang.String carUsage) {
		this.carUsage = carUsage;
	}
	public java.lang.String getEngineNumber() {
		return engineNumber;
	}
	public void setEngineNumber(java.lang.String engineNumber) {
		this.engineNumber = engineNumber;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getPledged() {
		return pledged;
	}
	public void setPledged(java.lang.String pledged) {
		this.pledged = pledged;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result
				+ ((carNumber == null) ? 0 : carNumber.hashCode());
		result = prime * result
				+ ((carUsage == null) ? 0 : carUsage.hashCode());
		result = prime * result
				+ ((engineNumber == null) ? 0 : engineNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((pledged == null) ? 0 : pledged.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((updateDate == null) ? 0 : updateDate.hashCode());
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
		BaseIndCarTrade other = (BaseIndCarTrade) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (carNumber == null) {
			if (other.carNumber != null)
				return false;
		} else if (!carNumber.equals(other.carNumber))
			return false;
		if (carUsage == null) {
			if (other.carUsage != null)
				return false;
		} else if (!carUsage.equals(other.carUsage))
			return false;
		if (engineNumber == null) {
			if (other.engineNumber != null)
				return false;
		} else if (!engineNumber.equals(other.engineNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (pledged == null) {
			if (other.pledged != null)
				return false;
		} else if (!pledged.equals(other.pledged))
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
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		return true;
	}
	public BaseIndCarTrade(Integer id, String rptId, String brand,
			String carNumber, String carUsage, String engineNumber, Integer no,
			String pledged, String status, String type, String updateDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.brand = brand;
		this.carNumber = carNumber;
		this.carUsage = carUsage;
		this.engineNumber = engineNumber;
		this.no = no;
		this.pledged = pledged;
		this.status = status;
		this.type = type;
		this.updateDate = updateDate;
	}

    
    
	
    
    
  
}
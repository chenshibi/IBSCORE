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

public abstract class BaseIndAward implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndAward";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_CITY="city";
    public static String PROP_CONTENT="content";
    public static String PROP_END_DATE="endDate";
    public static String PROP_EXPIRE_DATE="expireDate";
    public static String PROP_INIT_DATE="initDate";
    public static String PROP_LEVEL="level";
    public static String PROP_NAME="name";
    public static String PROP_NO="no";
    public static String PROP_ORGAN="organ";
    public static String PROP_RECORD_TYPE="recordType";
    public BaseIndAward() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String city;
    private java.lang.String content;
    private java.lang.String endDate;
    private java.lang.String expireDate;
    private java.lang.String initDate;
    private java.lang.String level;
    private java.lang.String name;
    private java.lang.Integer no;
    private java.lang.String organ;
    private java.lang.String recordType;
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
	public static String getPROP_CITY() {
		return PROP_CITY;
	}
	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}
	public static String getPROP_CONTENT() {
		return PROP_CONTENT;
	}
	public static void setPROP_CONTENT(String pROP_CONTENT) {
		PROP_CONTENT = pROP_CONTENT;
	}
	public static String getPROP_END_DATE() {
		return PROP_END_DATE;
	}
	public static void setPROP_END_DATE(String pROP_END_DATE) {
		PROP_END_DATE = pROP_END_DATE;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_LEVEL() {
		return PROP_LEVEL;
	}
	public static void setPROP_LEVEL(String pROP_LEVEL) {
		PROP_LEVEL = pROP_LEVEL;
	}
	public static String getPROP_NAME() {
		return PROP_NAME;
	}
	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_RECORD_TYPE() {
		return PROP_RECORD_TYPE;
	}
	public static void setPROP_RECORD_TYPE(String pROP_RECORD_TYPE) {
		PROP_RECORD_TYPE = pROP_RECORD_TYPE;
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
	public java.lang.String getCity() {
		return city;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getEndDate() {
		return endDate;
	}
	public void setEndDate(java.lang.String endDate) {
		this.endDate = endDate;
	}
	public java.lang.String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.lang.String expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.String getLevel() {
		return level;
	}
	public void setLevel(java.lang.String level) {
		this.level = level;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getRecordType() {
		return recordType;
	}
	public void setRecordType(java.lang.String recordType) {
		this.recordType = recordType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result + ((level == null) ? 0 : level.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result
				+ ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
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
		BaseIndAward other = (BaseIndAward) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
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
		if (level == null) {
			if (other.level != null)
				return false;
		} else if (!level.equals(other.level))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		return true;
	}
	public BaseIndAward(Integer id, String rptId, String city, String content,
			String endDate, String expireDate, String initDate, String level,
			String name, Integer no, String organ, String recordType) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.city = city;
		this.content = content;
		this.endDate = endDate;
		this.expireDate = expireDate;
		this.initDate = initDate;
		this.level = level;
		this.name = name;
		this.no = no;
		this.organ = organ;
		this.recordType = recordType;
	}
    
    
    
	
    
    
  
}
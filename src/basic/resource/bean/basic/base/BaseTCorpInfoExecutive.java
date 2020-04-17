package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpInfoExecutive implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpInfoExecutive";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_TITLE="title";
    public static String PROP_NAME="name";
    public static String PROP_ID_TYPE="idType";
    public static String PROP_ID_NUMBER="idNumber";
    public static String PROP_SEX="sex";
    public static String PROP_BIRTHDAY="birthday";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String title;
    private java.lang.String name;
    private java.lang.String idType;
    private java.lang.String idNumber;
    private java.lang.String sex;
    private java.lang.String birthday;


	public BaseTCorpInfoExecutive() {
		super();
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


	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}


	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}


	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}


	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}


	public static String getPROP_TITLE() {
		return PROP_TITLE;
	}


	public static void setPROP_TITLE(String pROP_TITLE) {
		PROP_TITLE = pROP_TITLE;
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


	public static String getPROP_ID_NUMBER() {
		return PROP_ID_NUMBER;
	}


	public static void setPROP_ID_NUMBER(String pROP_ID_NUMBER) {
		PROP_ID_NUMBER = pROP_ID_NUMBER;
	}


	public static String getPROP_SEX() {
		return PROP_SEX;
	}


	public static void setPROP_SEX(String pROP_SEX) {
		PROP_SEX = pROP_SEX;
	}


	public static String getPROP_BIRTHDAY() {
		return PROP_BIRTHDAY;
	}


	public static void setPROP_BIRTHDAY(String pROP_BIRTHDAY) {
		PROP_BIRTHDAY = pROP_BIRTHDAY;
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


	public java.util.Date getCreateTime() {
		return createTime;
	}


	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}


	public java.lang.String getTitle() {
		return title;
	}


	public void setTitle(java.lang.String title) {
		this.title = title;
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


	public java.lang.String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(java.lang.String idNumber) {
		this.idNumber = idNumber;
	}


	public java.lang.String getSex() {
		return sex;
	}


	public void setSex(java.lang.String sex) {
		this.sex = sex;
	}


	public java.lang.String getBirthday() {
		return birthday;
	}


	public void setBirthday(java.lang.String birthday) {
		this.birthday = birthday;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		BaseTCorpInfoExecutive other = (BaseTCorpInfoExecutive) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	public BaseTCorpInfoExecutive(int hashCode, Integer id, String rptKey,
			Date createTime, String title, String name, String idType,
			String idNumber, String sex, String birthday) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.title = title;
		this.name = name;
		this.idType = idType;
		this.idNumber = idNumber;
		this.sex = sex;
		this.birthday = birthday;
	}

	

	




	
	
    
    
	
    
    
}
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

public abstract class BaseIndSuccour implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndSuccour";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_APPLY_DATE="applyDate";
    public static String PROP_CITY="city";
    public static String PROP_FAMILY_INCOME="familyIncome";
    public static String PROP_ISSUE_DATE="issueDate";
    public static String PROP_NO="no";
    public static String PROP_ORGAN="organ";
    public static String PROP_TYPE="type";
    public static String PROP_UPDATE_DATE="updateDate";
    public BaseIndSuccour() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String applyDate;
    private java.lang.String city;
    private java.lang.String familyIncome;
    private java.lang.String issueDate;
    private java.lang.Integer no;
    private java.lang.String organ;
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
	public static String getPROP_APPLY_DATE() {
		return PROP_APPLY_DATE;
	}
	public static void setPROP_APPLY_DATE(String pROP_APPLY_DATE) {
		PROP_APPLY_DATE = pROP_APPLY_DATE;
	}
	public static String getPROP_CITY() {
		return PROP_CITY;
	}
	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}
	public static String getPROP_FAMILY_INCOME() {
		return PROP_FAMILY_INCOME;
	}
	public static void setPROP_FAMILY_INCOME(String pROP_FAMILY_INCOME) {
		PROP_FAMILY_INCOME = pROP_FAMILY_INCOME;
	}
	public static String getPROP_ISSUE_DATE() {
		return PROP_ISSUE_DATE;
	}
	public static void setPROP_ISSUE_DATE(String pROP_ISSUE_DATE) {
		PROP_ISSUE_DATE = pROP_ISSUE_DATE;
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
	public java.lang.String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(java.lang.String applyDate) {
		this.applyDate = applyDate;
	}
	public java.lang.String getCity() {
		return city;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	public java.lang.String getFamilyIncome() {
		return familyIncome;
	}
	public void setFamilyIncome(java.lang.String familyIncome) {
		this.familyIncome = familyIncome;
	}
	public java.lang.String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(java.lang.String issueDate) {
		this.issueDate = issueDate;
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
		result = prime * result
				+ ((applyDate == null) ? 0 : applyDate.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((familyIncome == null) ? 0 : familyIncome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((issueDate == null) ? 0 : issueDate.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
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
		BaseIndSuccour other = (BaseIndSuccour) obj;
		if (applyDate == null) {
			if (other.applyDate != null)
				return false;
		} else if (!applyDate.equals(other.applyDate))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (familyIncome == null) {
			if (other.familyIncome != null)
				return false;
		} else if (!familyIncome.equals(other.familyIncome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
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
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
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
	public BaseIndSuccour(Integer id, String rptId, String applyDate,
			String city, String familyIncome, String issueDate, Integer no,
			String organ, String type, String updateDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.applyDate = applyDate;
		this.city = city;
		this.familyIncome = familyIncome;
		this.issueDate = issueDate;
		this.no = no;
		this.organ = organ;
		this.type = type;
		this.updateDate = updateDate;
	}

    
    
	
    
    
  
}
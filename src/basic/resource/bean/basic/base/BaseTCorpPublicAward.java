package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.Bctl;

/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpPublicAward implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpPublicAward";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_ORGAN="organ";
    public static String PROP_SUB_ORGAN="subOrgan";
    public static String PROP_TYPE="type";
    public static String PROP_INIT_DATE="initDate";
    public static String PROP_UPDATE_DATE="updateDate";
    public static String PROP_EXPIRE_DATE="expireDate";
    public static String PROP_CONTENT="content";
    public static String PROP_AWARD_CODE="awardCode";
    public static String PROP_TERM="term";
	public BaseTCorpPublicAward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.String organ;
    private java.lang.String subOrgan;
    private java.lang.String type;
    private java.lang.String initDate;
    private java.lang.String updateDate;
    private java.lang.String expireDate;
    private java.lang.String content;
    private java.lang.String awardCode;
    private java.lang.String term;
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
	public static String getPROP_ITEM_NAME() {
		return PROP_ITEM_NAME;
	}
	public static void setPROP_ITEM_NAME(String pROP_ITEM_NAME) {
		PROP_ITEM_NAME = pROP_ITEM_NAME;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_SUB_ORGAN() {
		return PROP_SUB_ORGAN;
	}
	public static void setPROP_SUB_ORGAN(String pROP_SUB_ORGAN) {
		PROP_SUB_ORGAN = pROP_SUB_ORGAN;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_UPDATE_DATE() {
		return PROP_UPDATE_DATE;
	}
	public static void setPROP_UPDATE_DATE(String pROP_UPDATE_DATE) {
		PROP_UPDATE_DATE = pROP_UPDATE_DATE;
	}
	public static String getPROP_EXPIRE_DATE() {
		return PROP_EXPIRE_DATE;
	}
	public static void setPROP_EXPIRE_DATE(String pROP_EXPIRE_DATE) {
		PROP_EXPIRE_DATE = pROP_EXPIRE_DATE;
	}
	public static String getPROP_CONTENT() {
		return PROP_CONTENT;
	}
	public static void setPROP_CONTENT(String pROP_CONTENT) {
		PROP_CONTENT = pROP_CONTENT;
	}
	public static String getPROP_AWARD_CODE() {
		return PROP_AWARD_CODE;
	}
	public static void setPROP_AWARD_CODE(String pROP_AWARD_CODE) {
		PROP_AWARD_CODE = pROP_AWARD_CODE;
	}
	public static String getPROP_TERM() {
		return PROP_TERM;
	}
	public static void setPROP_TERM(String pROP_TERM) {
		PROP_TERM = pROP_TERM;
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
	public java.lang.String getItemName() {
		return itemName;
	}
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getSubOrgan() {
		return subOrgan;
	}
	public void setSubOrgan(java.lang.String subOrgan) {
		this.subOrgan = subOrgan;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}
	public java.lang.String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(java.lang.String expireDate) {
		this.expireDate = expireDate;
	}
	public java.lang.String getContent() {
		return content;
	}
	public void setContent(java.lang.String content) {
		this.content = content;
	}
	public java.lang.String getAwardCode() {
		return awardCode;
	}
	public void setAwardCode(java.lang.String awardCode) {
		this.awardCode = awardCode;
	}
	public java.lang.String getTerm() {
		return term;
	}
	public void setTerm(java.lang.String term) {
		this.term = term;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((awardCode == null) ? 0 : awardCode.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result
				+ ((subOrgan == null) ? 0 : subOrgan.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		BaseTCorpPublicAward other = (BaseTCorpPublicAward) obj;
		if (awardCode == null) {
			if (other.awardCode != null)
				return false;
		} else if (!awardCode.equals(other.awardCode))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
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
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (subOrgan == null) {
			if (other.subOrgan != null)
				return false;
		} else if (!subOrgan.equals(other.subOrgan))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
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
	public BaseTCorpPublicAward(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String organ, String subOrgan,
			String type, String initDate, String updateDate, String expireDate,
			String content, String awardCode, String term) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.organ = organ;
		this.subOrgan = subOrgan;
		this.type = type;
		this.initDate = initDate;
		this.updateDate = updateDate;
		this.expireDate = expireDate;
		this.content = content;
		this.awardCode = awardCode;
		this.term = term;
	}
    
    


    




    
}
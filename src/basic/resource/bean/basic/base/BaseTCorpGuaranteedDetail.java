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

public abstract class BaseTCorpGuaranteedDetail implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpGuaranteedDetail";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_TYPE="type";
    public static String PROP_ASSURE_PERSON="assurePerson";
    public static String PROP_ASSURE_KINDE="assureKind";
    public static String PROP_ASSURE_DATE="assureDate";
    public static String PROP_CURRENCY="currency";
    public static String PROP_VALUATION="valuation";
	public static String PROP_ASSURE_AMT="assureAmt";
	public static String PROP_ASSURE_TYPE="assureType";
	public static String PROP_FIVE_LEVEL="fiveLevel";
	public static String PROP_ASSURED_NAME="assuredName";
	
	



	public BaseTCorpGuaranteedDetail() {
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
    private java.lang.String type;
    private java.lang.String assurePerson;
    private java.lang.String assureKind;
    private java.lang.String assureDate;
    private java.lang.String currency;
    private java.lang.String valuation;
    private java.lang.String assureAmt;
    private java.lang.String assureType;
    private java.lang.String fiveLevel;
    private java.lang.String assuredName;





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
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_ASSURE_PERSON() {
		return PROP_ASSURE_PERSON;
	}
	public static void setPROP_ASSURE_PERSON(String pROP_ASSURE_PERSON) {
		PROP_ASSURE_PERSON = pROP_ASSURE_PERSON;
	}
	public static String getPROP_ASSURE_KINDE() {
		return PROP_ASSURE_KINDE;
	}
	public static void setPROP_ASSURE_KINDE(String pROP_ASSURE_KINDE) {
		PROP_ASSURE_KINDE = pROP_ASSURE_KINDE;
	}
	public static String getPROP_ASSURE_DATE() {
		return PROP_ASSURE_DATE;
	}
	public static void setPROP_ASSURE_DATE(String pROP_ASSURE_DATE) {
		PROP_ASSURE_DATE = pROP_ASSURE_DATE;
	}
	public static String getPROP_CURRENCY() {
		return PROP_CURRENCY;
	}
	public static void setPROP_CURRENCY(String pROP_CURRENCY) {
		PROP_CURRENCY = pROP_CURRENCY;
	}
	public static String getPROP_VALUATION() {
		return PROP_VALUATION;
	}
	public static void setPROP_VALUATION(String pROP_VALUATION) {
		PROP_VALUATION = pROP_VALUATION;
	}
	public static String getPROP_ASSURE_AMT() {
		return PROP_ASSURE_AMT;
	}
	public static void setPROP_ASSURE_AMT(String pROP_ASSURE_AMT) {
		PROP_ASSURE_AMT = pROP_ASSURE_AMT;
	}
	public static String getPROP_ASSURE_TYPE() {
		return PROP_ASSURE_TYPE;
	}
	public static void setPROP_ASSURE_TYPE(String pROP_ASSURE_TYPE) {
		PROP_ASSURE_TYPE = pROP_ASSURE_TYPE;
	}
	public static String getPROP_FIVE_LEVEL() {
		return PROP_FIVE_LEVEL;
	}
	public static void setPROP_FIVE_LEVEL(String pROP_FIVE_LEVEL) {
		PROP_FIVE_LEVEL = pROP_FIVE_LEVEL;
	}
	public static String getPROP_ASSURED_NAME() {
		return PROP_ASSURED_NAME;
	}
	public static void setPROP_ASSURED_NAME(String pROP_ASSURED_NAME) {
		PROP_ASSURED_NAME = pROP_ASSURED_NAME;
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
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getAssurePerson() {
		return assurePerson;
	}
	public void setAssurePerson(java.lang.String assurePerson) {
		this.assurePerson = assurePerson;
	}
	public java.lang.String getAssureKind() {
		return assureKind;
	}
	public void setAssureKind(java.lang.String assureKind) {
		this.assureKind = assureKind;
	}
	public java.lang.String getAssureDate() {
		return assureDate;
	}
	public void setAssureDate(java.lang.String assureDate) {
		this.assureDate = assureDate;
	}
	public java.lang.String getCurrency() {
		return currency;
	}
	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}
	public java.lang.String getValuation() {
		return valuation;
	}
	public void setValuation(java.lang.String valuation) {
		this.valuation = valuation;
	}
	public java.lang.String getAssureAmt() {
		return assureAmt;
	}
	public void setAssureAmt(java.lang.String assureAmt) {
		this.assureAmt = assureAmt;
	}
	public java.lang.String getAssureType() {
		return assureType;
	}
	public void setAssureType(java.lang.String assureType) {
		this.assureType = assureType;
	}
	public java.lang.String getFiveLevel() {
		return fiveLevel;
	}
	public void setFiveLevel(java.lang.String fiveLevel) {
		this.fiveLevel = fiveLevel;
	}
	public java.lang.String getAssuredName() {
		return assuredName;
	}
	public void setAssuredName(java.lang.String assuredName) {
		this.assuredName = assuredName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assureAmt == null) ? 0 : assureAmt.hashCode());
		result = prime * result
				+ ((assureDate == null) ? 0 : assureDate.hashCode());
		result = prime * result
				+ ((assureKind == null) ? 0 : assureKind.hashCode());
		result = prime * result
				+ ((assurePerson == null) ? 0 : assurePerson.hashCode());
		result = prime * result
				+ ((assureType == null) ? 0 : assureType.hashCode());
		result = prime * result
				+ ((assuredName == null) ? 0 : assuredName.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((fiveLevel == null) ? 0 : fiveLevel.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((valuation == null) ? 0 : valuation.hashCode());
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
		BaseTCorpGuaranteedDetail other = (BaseTCorpGuaranteedDetail) obj;
		if (assureAmt == null) {
			if (other.assureAmt != null)
				return false;
		} else if (!assureAmt.equals(other.assureAmt))
			return false;
		if (assureDate == null) {
			if (other.assureDate != null)
				return false;
		} else if (!assureDate.equals(other.assureDate))
			return false;
		if (assureKind == null) {
			if (other.assureKind != null)
				return false;
		} else if (!assureKind.equals(other.assureKind))
			return false;
		if (assurePerson == null) {
			if (other.assurePerson != null)
				return false;
		} else if (!assurePerson.equals(other.assurePerson))
			return false;
		if (assureType == null) {
			if (other.assureType != null)
				return false;
		} else if (!assureType.equals(other.assureType))
			return false;
		if (assuredName == null) {
			if (other.assuredName != null)
				return false;
		} else if (!assuredName.equals(other.assuredName))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (fiveLevel == null) {
			if (other.fiveLevel != null)
				return false;
		} else if (!fiveLevel.equals(other.fiveLevel))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (valuation == null) {
			if (other.valuation != null)
				return false;
		} else if (!valuation.equals(other.valuation))
			return false;
		return true;
	}
	public BaseTCorpGuaranteedDetail(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String type, String assurePerson,
			String assureKind, String assureDate, String currency,
			String valuation, String assureAmt, String assureType,
			String fiveLevel, String assuredName) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.type = type;
		this.assurePerson = assurePerson;
		this.assureKind = assureKind;
		this.assureDate = assureDate;
		this.currency = currency;
		this.valuation = valuation;
		this.assureAmt = assureAmt;
		this.assureType = assureType;
		this.fiveLevel = fiveLevel;
		this.assuredName = assuredName;
	}

    











    
}
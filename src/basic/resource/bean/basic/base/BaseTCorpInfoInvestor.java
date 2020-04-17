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

public abstract class BaseTCorpInfoInvestor implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpInfoInvestor";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_NAME="name";
    public static String PROP_ID_TYPE="idType";
    public static String PROP_ID_NUMBER="idNumber";
    public static String PROP_CURRENCY="currency";
    public static String PROP_AMOUNT="amount";
    public static String PROP_PROPORTION="proportion";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String name;
    private java.lang.String idType;
    private java.lang.String idNumber;
    private java.lang.String currency;
    private java.lang.Float amount;
    private java.lang.String proportion;


	public BaseTCorpInfoInvestor() {
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


	public static String getPROP_CURRENCY() {
		return PROP_CURRENCY;
	}


	public static void setPROP_CURRENCY(String pROP_CURRENCY) {
		PROP_CURRENCY = pROP_CURRENCY;
	}


	public static String getPROP_AMOUNT() {
		return PROP_AMOUNT;
	}


	public static void setPROP_AMOUNT(String pROP_AMOUNT) {
		PROP_AMOUNT = pROP_AMOUNT;
	}


	public static String getPROP_PROPORTION() {
		return PROP_PROPORTION;
	}


	public static void setPROP_PROPORTION(String pROP_PROPORTION) {
		PROP_PROPORTION = pROP_PROPORTION;
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


	public java.lang.String getCurrency() {
		return currency;
	}


	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}


	public java.lang.Float getAmount() {
		return amount;
	}


	public void setAmount(java.lang.Float amount) {
		this.amount = amount;
	}


	public java.lang.String getProportion() {
		return proportion;
	}


	public void setProportion(java.lang.String proportion) {
		this.proportion = proportion;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((proportion == null) ? 0 : proportion.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
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
		BaseTCorpInfoInvestor other = (BaseTCorpInfoInvestor) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
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
		if (proportion == null) {
			if (other.proportion != null)
				return false;
		} else if (!proportion.equals(other.proportion))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}


	public BaseTCorpInfoInvestor(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String idType, String idNumber,
			String currency, Float amount, String proportion) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.name = name;
		this.idType = idType;
		this.idNumber = idNumber;
		this.currency = currency;
		this.amount = amount;
		this.proportion = proportion;
	}

	




	
	
    
    
	
    
    
}
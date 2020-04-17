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

public abstract class BaseTCorpInfoRelevantCorp implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpInfoRelevantCorp";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_LOANCARD_NO="name";
    public static String PROP_LOANCARD_PASS="loanCardNo";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String name;
    private java.lang.String loanCardNo;
    private java.lang.String relevant;



	public BaseTCorpInfoRelevantCorp() {
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



	public static String getPROP_LOANCARD_NO() {
		return PROP_LOANCARD_NO;
	}



	public static void setPROP_LOANCARD_NO(String pROP_LOANCARD_NO) {
		PROP_LOANCARD_NO = pROP_LOANCARD_NO;
	}



	public static String getPROP_LOANCARD_PASS() {
		return PROP_LOANCARD_PASS;
	}



	public static void setPROP_LOANCARD_PASS(String pROP_LOANCARD_PASS) {
		PROP_LOANCARD_PASS = pROP_LOANCARD_PASS;
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



	public java.lang.String getLoanCardNo() {
		return loanCardNo;
	}



	public void setLoanCardNo(java.lang.String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}



	public java.lang.String getRelevant() {
		return relevant;
	}



	public void setRelevant(java.lang.String relevant) {
		this.relevant = relevant;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loanCardNo == null) ? 0 : loanCardNo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((relevant == null) ? 0 : relevant.hashCode());
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
		BaseTCorpInfoRelevantCorp other = (BaseTCorpInfoRelevantCorp) obj;
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
		if (loanCardNo == null) {
			if (other.loanCardNo != null)
				return false;
		} else if (!loanCardNo.equals(other.loanCardNo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (relevant == null) {
			if (other.relevant != null)
				return false;
		} else if (!relevant.equals(other.relevant))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}



	public BaseTCorpInfoRelevantCorp(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String loanCardNo, String relevant) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.name = name;
		this.loanCardNo = loanCardNo;
		this.relevant = relevant;
	}

	



	
	
    
    
	
    
    
}
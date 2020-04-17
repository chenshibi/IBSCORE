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

public abstract class BaseIndAssurance implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndNoClosePdc";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_COUNT="count";
    public static String PROP_BALANCE="balance";
    public static String PROP_BANK_ASSURANCE="bankAssurance";
    public static String PROP_GETDATE="getDate";

    public BaseIndAssurance() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer count;
    private java.lang.Float balance;
    private java.lang.Float bankAssurance;
    private java.util.Date getDate;

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
	public static String getPROP_COUNT() {
		return PROP_COUNT;
	}
	public static void setPROP_COUNT(String pROP_COUNT) {
		PROP_COUNT = pROP_COUNT;
	}
	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}
	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}
	public static String getPROP_BANK_ASSURANCE() {
		return PROP_BANK_ASSURANCE;
	}
	public static void setPROP_BANK_ASSURANCE(String pROP_BANK_ASSURANCE) {
		PROP_BANK_ASSURANCE = pROP_BANK_ASSURANCE;
	}
	public static String getPROP_GETDATE() {
		return PROP_GETDATE;
	}
	public static void setPROP_GETDATE(String pROP_GETDATE) {
		PROP_GETDATE = pROP_GETDATE;
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
	public java.lang.Integer getCount() {
		return count;
	}
	public void setCount(java.lang.Integer count) {
		this.count = count;
	}
	public java.lang.Float getBalance() {
		return balance;
	}
	public void setBalance(java.lang.Float balance) {
		this.balance = balance;
	}
	public java.lang.Float getBankAssurance() {
		return bankAssurance;
	}
	public void setBankAssurance(java.lang.Float bankAssurance) {
		this.bankAssurance = bankAssurance;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((bankAssurance == null) ? 0 : bankAssurance.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BaseIndAssurance other = (BaseIndAssurance) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (bankAssurance == null) {
			if (other.bankAssurance != null)
				return false;
		} else if (!bankAssurance.equals(other.bankAssurance))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (getDate == null) {
			if (other.getDate != null)
				return false;
		} else if (!getDate.equals(other.getDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		return true;
	}
	public BaseIndAssurance(Integer id, String rptId, Integer count,
			Float balance, Float bankAssurance, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.count = count;
		this.balance = balance;
		this.bankAssurance = bankAssurance;
		this.getDate = getDate;
	}

    
    
    
    
    
    
	
    
    
  
}
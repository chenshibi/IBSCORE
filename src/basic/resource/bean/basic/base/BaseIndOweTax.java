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

public abstract class BaseIndOweTax implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndOweTax";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_AMOUNT="amount";
    public static String PROP_MANAGER="manager";
    public static String PROP_NO="no";
    public static String PROP_TAX_DATE="taxDate";
    public BaseIndOweTax() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String amount;
    private java.lang.String manager;
    private java.lang.Integer no;
    private java.lang.String taxDate;
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
	public static String getPROP_AMOUNT() {
		return PROP_AMOUNT;
	}
	public static void setPROP_AMOUNT(String pROP_AMOUNT) {
		PROP_AMOUNT = pROP_AMOUNT;
	}
	public static String getPROP_MANAGER() {
		return PROP_MANAGER;
	}
	public static void setPROP_MANAGER(String pROP_MANAGER) {
		PROP_MANAGER = pROP_MANAGER;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_TAX_DATE() {
		return PROP_TAX_DATE;
	}
	public static void setPROP_TAX_DATE(String pROP_TAX_DATE) {
		PROP_TAX_DATE = pROP_TAX_DATE;
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
	public java.lang.String getAmount() {
		return amount;
	}
	public void setAmount(java.lang.String amount) {
		this.amount = amount;
	}
	public java.lang.String getManager() {
		return manager;
	}
	public void setManager(java.lang.String manager) {
		this.manager = manager;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getTaxDate() {
		return taxDate;
	}
	public void setTaxDate(java.lang.String taxDate) {
		this.taxDate = taxDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((taxDate == null) ? 0 : taxDate.hashCode());
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
		BaseIndOweTax other = (BaseIndOweTax) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (taxDate == null) {
			if (other.taxDate != null)
				return false;
		} else if (!taxDate.equals(other.taxDate))
			return false;
		return true;
	}
	public BaseIndOweTax(Integer id, String rptId, String amount,
			String manager, Integer no, String taxDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.amount = amount;
		this.manager = manager;
		this.no = no;
		this.taxDate = taxDate;
	}

    
	
    
    
  
}
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

public abstract class BaseIndDisposal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndDisposal";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_BIZ_TYPE="bizType";
    public static String PROP_MANAGER_ORG="managerOrg";
    public static String PROP_EXPROPRIATE_DATE="expropriateDate";
    public static String PROP_EXPROPRIATE_AMOUNT="expropriateAmount";
    public static String PROP_LAST_PAY_DATE="lastPayDate";
    public static String PROP_BALANCE="balance";
    public static String PROP_GET_DATE="getDate";

    public BaseIndDisposal() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String bizType;
    private java.lang.String managerOrg;
    private java.util.Date expropriateDate;
    private java.lang.Float expropriateAmount;
    private java.util.Date lastPayDate;
    private java.lang.Float balance;
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
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_BIZ_TYPE() {
		return PROP_BIZ_TYPE;
	}
	public static void setPROP_BIZ_TYPE(String pROP_BIZ_TYPE) {
		PROP_BIZ_TYPE = pROP_BIZ_TYPE;
	}
	public static String getPROP_MANAGER_ORG() {
		return PROP_MANAGER_ORG;
	}
	public static void setPROP_MANAGER_ORG(String pROP_MANAGER_ORG) {
		PROP_MANAGER_ORG = pROP_MANAGER_ORG;
	}
	public static String getPROP_EXPROPRIATE_DATE() {
		return PROP_EXPROPRIATE_DATE;
	}
	public static void setPROP_EXPROPRIATE_DATE(String pROP_EXPROPRIATE_DATE) {
		PROP_EXPROPRIATE_DATE = pROP_EXPROPRIATE_DATE;
	}
	public static String getPROP_EXPROPRIATE_AMOUNT() {
		return PROP_EXPROPRIATE_AMOUNT;
	}
	public static void setPROP_EXPROPRIATE_AMOUNT(String pROP_EXPROPRIATE_AMOUNT) {
		PROP_EXPROPRIATE_AMOUNT = pROP_EXPROPRIATE_AMOUNT;
	}
	public static String getPROP_LAST_PAY_DATE() {
		return PROP_LAST_PAY_DATE;
	}
	public static void setPROP_LAST_PAY_DATE(String pROP_LAST_PAY_DATE) {
		PROP_LAST_PAY_DATE = pROP_LAST_PAY_DATE;
	}
	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}
	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
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
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getBizType() {
		return bizType;
	}
	public void setBizType(java.lang.String bizType) {
		this.bizType = bizType;
	}
	public java.lang.String getManagerOrg() {
		return managerOrg;
	}
	public void setManagerOrg(java.lang.String managerOrg) {
		this.managerOrg = managerOrg;
	}
	public java.util.Date getExpropriateDate() {
		return expropriateDate;
	}
	public void setExpropriateDate(java.util.Date expropriateDate) {
		this.expropriateDate = expropriateDate;
	}
	public java.lang.Float getExpropriateAmount() {
		return expropriateAmount;
	}
	public void setExpropriateAmount(java.lang.Float expropriateAmount) {
		this.expropriateAmount = expropriateAmount;
	}
	public java.util.Date getLastPayDate() {
		return lastPayDate;
	}
	public void setLastPayDate(java.util.Date lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	public java.lang.Float getBalance() {
		return balance;
	}
	public void setBalance(java.lang.Float balance) {
		this.balance = balance;
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
		result = prime * result + ((bizType == null) ? 0 : bizType.hashCode());
		result = prime
				* result
				+ ((expropriateAmount == null) ? 0 : expropriateAmount
						.hashCode());
		result = prime * result
				+ ((expropriateDate == null) ? 0 : expropriateDate.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastPayDate == null) ? 0 : lastPayDate.hashCode());
		result = prime * result
				+ ((managerOrg == null) ? 0 : managerOrg.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
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
		BaseIndDisposal other = (BaseIndDisposal) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (bizType == null) {
			if (other.bizType != null)
				return false;
		} else if (!bizType.equals(other.bizType))
			return false;
		if (expropriateAmount == null) {
			if (other.expropriateAmount != null)
				return false;
		} else if (!expropriateAmount.equals(other.expropriateAmount))
			return false;
		if (expropriateDate == null) {
			if (other.expropriateDate != null)
				return false;
		} else if (!expropriateDate.equals(other.expropriateDate))
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
		if (lastPayDate == null) {
			if (other.lastPayDate != null)
				return false;
		} else if (!lastPayDate.equals(other.lastPayDate))
			return false;
		if (managerOrg == null) {
			if (other.managerOrg != null)
				return false;
		} else if (!managerOrg.equals(other.managerOrg))
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
		return true;
	}
	public BaseIndDisposal(Integer id, String rptId, Integer no,
			String bizType, String managerOrg, Date expropriateDate,
			Float expropriateAmount, Date lastPayDate, Float balance,
			Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.bizType = bizType;
		this.managerOrg = managerOrg;
		this.expropriateDate = expropriateDate;
		this.expropriateAmount = expropriateAmount;
		this.lastPayDate = lastPayDate;
		this.balance = balance;
		this.getDate = getDate;
	}

    
    
    
    
	
    
    
  
}
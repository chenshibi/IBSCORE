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

public abstract class BaseTCorpDetailAssureWindows implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpDetailAssureWindows";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_CURRENCY="currency";
    public static String PROP_AMOUNT="amout";
    public static String PROP_RELEASE_DATE="releaseDate";
	public static String PROP_CLOSE_DATE="closeDate";
	public static String PROP_BALANCE="balance";
	public static String PROP_FIVE_LEVEL="fiveLevel";
	public static String PROP_ASSURE_STATUS="assureStatus";
	public static String PROP_MAIN_BIZ="mainBiz";
	public static String PROP_TITLE="title";

	public BaseTCorpDetailAssureWindows() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String currency;
    private java.lang.Float amout;
    private java.lang.String releaseDate;
    private java.lang.String closeDate;
    private java.lang.String balance;
    private java.lang.String fiveLevel;
    private java.lang.String assureStatus;
    private java.lang.String mainBiz;
    private java.lang.String title;

	public BaseTCorpDetailAssureWindows(int hashCode, Integer id,
			String rptKey, Date createTime, String currency, Float amout,
			String releaseDate, String closeDate, String balance,
			String fiveLevel, String assureStatus, String mainBiz, String title) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.currency = currency;
		this.amout = amout;
		this.releaseDate = releaseDate;
		this.closeDate = closeDate;
		this.balance = balance;
		this.fiveLevel = fiveLevel;
		this.assureStatus = assureStatus;
		this.mainBiz = mainBiz;
		this.title = title;
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

	public static String getPROP_RELEASE_DATE() {
		return PROP_RELEASE_DATE;
	}

	public static void setPROP_RELEASE_DATE(String pROP_RELEASE_DATE) {
		PROP_RELEASE_DATE = pROP_RELEASE_DATE;
	}

	public static String getPROP_CLOSE_DATE() {
		return PROP_CLOSE_DATE;
	}

	public static void setPROP_CLOSE_DATE(String pROP_CLOSE_DATE) {
		PROP_CLOSE_DATE = pROP_CLOSE_DATE;
	}

	public static String getPROP_BALANCE() {
		return PROP_BALANCE;
	}

	public static void setPROP_BALANCE(String pROP_BALANCE) {
		PROP_BALANCE = pROP_BALANCE;
	}

	public static String getPROP_FIVE_LEVEL() {
		return PROP_FIVE_LEVEL;
	}

	public static void setPROP_FIVE_LEVEL(String pROP_FIVE_LEVEL) {
		PROP_FIVE_LEVEL = pROP_FIVE_LEVEL;
	}

	public static String getPROP_ASSURE_STATUS() {
		return PROP_ASSURE_STATUS;
	}

	public static void setPROP_ASSURE_STATUS(String pROP_ASSURE_STATUS) {
		PROP_ASSURE_STATUS = pROP_ASSURE_STATUS;
	}

	public static String getPROP_MAIN_BIZ() {
		return PROP_MAIN_BIZ;
	}

	public static void setPROP_MAIN_BIZ(String pROP_MAIN_BIZ) {
		PROP_MAIN_BIZ = pROP_MAIN_BIZ;
	}

	public static String getPROP_TITLE() {
		return PROP_TITLE;
	}

	public static void setPROP_TITLE(String pROP_TITLE) {
		PROP_TITLE = pROP_TITLE;
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

	public java.lang.String getCurrency() {
		return currency;
	}

	public void setCurrency(java.lang.String currency) {
		this.currency = currency;
	}

	public java.lang.Float getAmout() {
		return amout;
	}

	public void setAmout(java.lang.Float amout) {
		this.amout = amout;
	}

	public java.lang.String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(java.lang.String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public java.lang.String getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(java.lang.String closeDate) {
		this.closeDate = closeDate;
	}

	public java.lang.String getBalance() {
		return balance;
	}

	public void setBalance(java.lang.String balance) {
		this.balance = balance;
	}

	public java.lang.String getFiveLevel() {
		return fiveLevel;
	}

	public void setFiveLevel(java.lang.String fiveLevel) {
		this.fiveLevel = fiveLevel;
	}

	public java.lang.String getAssureStatus() {
		return assureStatus;
	}

	public void setAssureStatus(java.lang.String assureStatus) {
		this.assureStatus = assureStatus;
	}

	public java.lang.String getMainBiz() {
		return mainBiz;
	}

	public void setMainBiz(java.lang.String mainBiz) {
		this.mainBiz = mainBiz;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amout == null) ? 0 : amout.hashCode());
		result = prime * result
				+ ((assureStatus == null) ? 0 : assureStatus.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result
				+ ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result
				+ ((currency == null) ? 0 : currency.hashCode());
		result = prime * result
				+ ((fiveLevel == null) ? 0 : fiveLevel.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mainBiz == null) ? 0 : mainBiz.hashCode());
		result = prime * result
				+ ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
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
		BaseTCorpDetailAssureWindows other = (BaseTCorpDetailAssureWindows) obj;
		if (amout == null) {
			if (other.amout != null)
				return false;
		} else if (!amout.equals(other.amout))
			return false;
		if (assureStatus == null) {
			if (other.assureStatus != null)
				return false;
		} else if (!assureStatus.equals(other.assureStatus))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
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
		if (mainBiz == null) {
			if (other.mainBiz != null)
				return false;
		} else if (!mainBiz.equals(other.mainBiz))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseTCorpDetailAssureWindows [hashCode=" + hashCode + ", id="
				+ id + ", rptKey=" + rptKey + ", createTime=" + createTime
				+ ", currency=" + currency + ", amout=" + amout
				+ ", releaseDate=" + releaseDate + ", closeDate=" + closeDate
				+ ", balance=" + balance + ", fiveLevel=" + fiveLevel
				+ ", assureStatus=" + assureStatus + ", mainBiz=" + mainBiz
				+ ", title=" + title + "]";
	}

    


    
}
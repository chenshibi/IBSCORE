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

public abstract class BaseTCorpSocialPayRecord implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpSocailPayRecord";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_SUM_YM="sumYm";
    public static String PROP_PAY_AMT="payAmt";
    public static String PROP_PAY_STATUS="payStatus";
    public static String PROP_SUM_OWN_AMT="sumOwnAmt";
    public static String PROP_EMPLOYEE_NUMBER="employeeNumber";
    public static String PROP_FIRST_PAY_YM="firstPayYm";
    public static String PROP_LAST_PAY_DATE="lastPayDate";
    public static String PROP_LAST_PAY_YM="lastPayYm";
    public static String PROP_INSURANCE_TYPE="insuranceType";
    public static String PROP_INSURED_DATE="insuredDate";
    public static String PROP_ORGAN="organ";
    public static String PROP_INFOTYPE="infotype";
    public static String PROP_HIGHEST_OWN_DATE="highestOwnDate";
    public static String PROP_HIGHEST_OWN_AMT="highestOwnAmt";
	public BaseTCorpSocialPayRecord() {
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
    private java.lang.String sumYm;
    private java.lang.String payAmt;
    private java.lang.String payStatus;
    private java.lang.String sumOwnAmt;
    private java.lang.String employeeNumber;
    private java.lang.String firstPayYm;
    private java.lang.String lastPayDate;
    private java.lang.String lastPayYm;
    private java.lang.String insuranceType;
    private java.lang.String insuredDate;
    private java.lang.String organ;
    private java.lang.String infotype;
    private java.lang.String highestOwnDate;
    private java.lang.String highestOwnAmt;
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
	public static String getPROP_SUM_YM() {
		return PROP_SUM_YM;
	}
	public static void setPROP_SUM_YM(String pROP_SUM_YM) {
		PROP_SUM_YM = pROP_SUM_YM;
	}
	public static String getPROP_PAY_AMT() {
		return PROP_PAY_AMT;
	}
	public static void setPROP_PAY_AMT(String pROP_PAY_AMT) {
		PROP_PAY_AMT = pROP_PAY_AMT;
	}
	public static String getPROP_PAY_STATUS() {
		return PROP_PAY_STATUS;
	}
	public static void setPROP_PAY_STATUS(String pROP_PAY_STATUS) {
		PROP_PAY_STATUS = pROP_PAY_STATUS;
	}
	public static String getPROP_SUM_OWN_AMT() {
		return PROP_SUM_OWN_AMT;
	}
	public static void setPROP_SUM_OWN_AMT(String pROP_SUM_OWN_AMT) {
		PROP_SUM_OWN_AMT = pROP_SUM_OWN_AMT;
	}
	public static String getPROP_EMPLOYEE_NUMBER() {
		return PROP_EMPLOYEE_NUMBER;
	}
	public static void setPROP_EMPLOYEE_NUMBER(String pROP_EMPLOYEE_NUMBER) {
		PROP_EMPLOYEE_NUMBER = pROP_EMPLOYEE_NUMBER;
	}
	public static String getPROP_FIRST_PAY_YM() {
		return PROP_FIRST_PAY_YM;
	}
	public static void setPROP_FIRST_PAY_YM(String pROP_FIRST_PAY_YM) {
		PROP_FIRST_PAY_YM = pROP_FIRST_PAY_YM;
	}
	public static String getPROP_LAST_PAY_DATE() {
		return PROP_LAST_PAY_DATE;
	}
	public static void setPROP_LAST_PAY_DATE(String pROP_LAST_PAY_DATE) {
		PROP_LAST_PAY_DATE = pROP_LAST_PAY_DATE;
	}
	public static String getPROP_LAST_PAY_YM() {
		return PROP_LAST_PAY_YM;
	}
	public static void setPROP_LAST_PAY_YM(String pROP_LAST_PAY_YM) {
		PROP_LAST_PAY_YM = pROP_LAST_PAY_YM;
	}
	public static String getPROP_INSURANCE_TYPE() {
		return PROP_INSURANCE_TYPE;
	}
	public static void setPROP_INSURANCE_TYPE(String pROP_INSURANCE_TYPE) {
		PROP_INSURANCE_TYPE = pROP_INSURANCE_TYPE;
	}
	public static String getPROP_INSURED_DATE() {
		return PROP_INSURED_DATE;
	}
	public static void setPROP_INSURED_DATE(String pROP_INSURED_DATE) {
		PROP_INSURED_DATE = pROP_INSURED_DATE;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_INFOTYPE() {
		return PROP_INFOTYPE;
	}
	public static void setPROP_INFOTYPE(String pROP_INFOTYPE) {
		PROP_INFOTYPE = pROP_INFOTYPE;
	}
	public static String getPROP_HIGHEST_OWN_DATE() {
		return PROP_HIGHEST_OWN_DATE;
	}
	public static void setPROP_HIGHEST_OWN_DATE(String pROP_HIGHEST_OWN_DATE) {
		PROP_HIGHEST_OWN_DATE = pROP_HIGHEST_OWN_DATE;
	}
	public static String getPROP_HIGHEST_OWN_AMT() {
		return PROP_HIGHEST_OWN_AMT;
	}
	public static void setPROP_HIGHEST_OWN_AMT(String pROP_HIGHEST_OWN_AMT) {
		PROP_HIGHEST_OWN_AMT = pROP_HIGHEST_OWN_AMT;
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
	public java.lang.String getSumYm() {
		return sumYm;
	}
	public void setSumYm(java.lang.String sumYm) {
		this.sumYm = sumYm;
	}
	public java.lang.String getPayAmt() {
		return payAmt;
	}
	public void setPayAmt(java.lang.String payAmt) {
		this.payAmt = payAmt;
	}
	public java.lang.String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(java.lang.String payStatus) {
		this.payStatus = payStatus;
	}
	public java.lang.String getSumOwnAmt() {
		return sumOwnAmt;
	}
	public void setSumOwnAmt(java.lang.String sumOwnAmt) {
		this.sumOwnAmt = sumOwnAmt;
	}
	public java.lang.String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(java.lang.String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public java.lang.String getFirstPayYm() {
		return firstPayYm;
	}
	public void setFirstPayYm(java.lang.String firstPayYm) {
		this.firstPayYm = firstPayYm;
	}
	public java.lang.String getLastPayDate() {
		return lastPayDate;
	}
	public void setLastPayDate(java.lang.String lastPayDate) {
		this.lastPayDate = lastPayDate;
	}
	public java.lang.String getLastPayYm() {
		return lastPayYm;
	}
	public void setLastPayYm(java.lang.String lastPayYm) {
		this.lastPayYm = lastPayYm;
	}
	public java.lang.String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(java.lang.String insuranceType) {
		this.insuranceType = insuranceType;
	}
	public java.lang.String getInsuredDate() {
		return insuredDate;
	}
	public void setInsuredDate(java.lang.String insuredDate) {
		this.insuredDate = insuredDate;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getInfotype() {
		return infotype;
	}
	public void setInfotype(java.lang.String infotype) {
		this.infotype = infotype;
	}
	public java.lang.String getHighestOwnDate() {
		return highestOwnDate;
	}
	public void setHighestOwnDate(java.lang.String highestOwnDate) {
		this.highestOwnDate = highestOwnDate;
	}
	public java.lang.String getHighestOwnAmt() {
		return highestOwnAmt;
	}
	public void setHighestOwnAmt(java.lang.String highestOwnAmt) {
		this.highestOwnAmt = highestOwnAmt;
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
		result = prime * result
				+ ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
		result = prime * result
				+ ((firstPayYm == null) ? 0 : firstPayYm.hashCode());
		result = prime * result + hashCode;
		result = prime * result
				+ ((highestOwnAmt == null) ? 0 : highestOwnAmt.hashCode());
		result = prime * result
				+ ((highestOwnDate == null) ? 0 : highestOwnDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((infotype == null) ? 0 : infotype.hashCode());
		result = prime * result
				+ ((insuranceType == null) ? 0 : insuranceType.hashCode());
		result = prime * result
				+ ((insuredDate == null) ? 0 : insuredDate.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((lastPayDate == null) ? 0 : lastPayDate.hashCode());
		result = prime * result
				+ ((lastPayYm == null) ? 0 : lastPayYm.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((payAmt == null) ? 0 : payAmt.hashCode());
		result = prime * result
				+ ((payStatus == null) ? 0 : payStatus.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result
				+ ((sumOwnAmt == null) ? 0 : sumOwnAmt.hashCode());
		result = prime * result + ((sumYm == null) ? 0 : sumYm.hashCode());
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
		BaseTCorpSocialPayRecord other = (BaseTCorpSocialPayRecord) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (employeeNumber == null) {
			if (other.employeeNumber != null)
				return false;
		} else if (!employeeNumber.equals(other.employeeNumber))
			return false;
		if (firstPayYm == null) {
			if (other.firstPayYm != null)
				return false;
		} else if (!firstPayYm.equals(other.firstPayYm))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (highestOwnAmt == null) {
			if (other.highestOwnAmt != null)
				return false;
		} else if (!highestOwnAmt.equals(other.highestOwnAmt))
			return false;
		if (highestOwnDate == null) {
			if (other.highestOwnDate != null)
				return false;
		} else if (!highestOwnDate.equals(other.highestOwnDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (infotype == null) {
			if (other.infotype != null)
				return false;
		} else if (!infotype.equals(other.infotype))
			return false;
		if (insuranceType == null) {
			if (other.insuranceType != null)
				return false;
		} else if (!insuranceType.equals(other.insuranceType))
			return false;
		if (insuredDate == null) {
			if (other.insuredDate != null)
				return false;
		} else if (!insuredDate.equals(other.insuredDate))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (lastPayDate == null) {
			if (other.lastPayDate != null)
				return false;
		} else if (!lastPayDate.equals(other.lastPayDate))
			return false;
		if (lastPayYm == null) {
			if (other.lastPayYm != null)
				return false;
		} else if (!lastPayYm.equals(other.lastPayYm))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (payAmt == null) {
			if (other.payAmt != null)
				return false;
		} else if (!payAmt.equals(other.payAmt))
			return false;
		if (payStatus == null) {
			if (other.payStatus != null)
				return false;
		} else if (!payStatus.equals(other.payStatus))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (sumOwnAmt == null) {
			if (other.sumOwnAmt != null)
				return false;
		} else if (!sumOwnAmt.equals(other.sumOwnAmt))
			return false;
		if (sumYm == null) {
			if (other.sumYm != null)
				return false;
		} else if (!sumYm.equals(other.sumYm))
			return false;
		return true;
	}
	public BaseTCorpSocialPayRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String sumYm, String payAmt,
			String payStatus, String sumOwnAmt, String employeeNumber,
			String firstPayYm, String lastPayDate, String lastPayYm,
			String insuranceType, String insuredDate, String organ,
			String infotype, String highestOwnDate, String highestOwnAmt) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.sumYm = sumYm;
		this.payAmt = payAmt;
		this.payStatus = payStatus;
		this.sumOwnAmt = sumOwnAmt;
		this.employeeNumber = employeeNumber;
		this.firstPayYm = firstPayYm;
		this.lastPayDate = lastPayDate;
		this.lastPayYm = lastPayYm;
		this.insuranceType = insuranceType;
		this.insuredDate = insuredDate;
		this.organ = organ;
		this.infotype = infotype;
		this.highestOwnDate = highestOwnDate;
		this.highestOwnAmt = highestOwnAmt;
	}
    

    


    




    
}
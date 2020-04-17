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

public abstract class BaseTCorpSumCredit implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 887494355297202088L;
	public static String REF = "TCorpSumCredit";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_DISPOSE_COUNT="disposeCount";
    public static String PROP_DISPOSE_AMOUNT="disposeAmount";
    public static String PROP_DISPOSE_DATE="disposeDate";
    public static String PROP_DEBIT_INTEREST_COUNT="debitInterestCount";
    public static String PROP_DEBIT_INTEREST_AMOUNT="debitInterestAmount";
    public static String PROP_DIVEST_COUNT="divestCount";
    public static String PROP_DIVEST_AMOUNT="divestAmount";
	public static String PROP_DIVEST_DATE="divestDate";
	public static String PROP_ADVANCED_COUNT="advancedCount";
	public static String PROP_ADVANCED_AMOUNT="advancedAmount";
	public static String PROP_ADVANCED_DATE="advancedDate";
	public static String PROP_STATUS="status";
	public static String PROP_ASSURE_CREDIT_CLEAR_DATE="assureCreditClearDate";
	public static String PROP_ASSURE_CREDIT_COUNT="assureCreditCount";
	public static String PROP_ASSURE_CREDIT_SUM="assureCreditSum";
	public static String PROP_DEBIT_INTEREST_CLEAR_DATE="debitInterestClearDate";
	


	protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.Integer disposeCount;
    private java.lang.Float disposeAmount;
    private java.lang.String disposeDate;
    private java.lang.Integer debitInterestCount;
    private java.lang.Float debitInterestAmount;
    private java.lang.Integer divestCount;
    private java.lang.Float divestAmount;
    private java.lang.String divestDate;
    private java.lang.Integer advancedCount;
    private java.lang.Float advancedAmount;
    private java.lang.String advancedDate;
    private java.lang.String status;
    private java.lang.String assureCreditClearDate;
    private java.lang.String assureCreditCount;
    private java.lang.String assureCreditSum;
    private java.lang.String debitInterestClearDate;

	public BaseTCorpSumCredit() {
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

	public static String getPROP_DISPOSE_COUNT() {
		return PROP_DISPOSE_COUNT;
	}

	public static void setPROP_DISPOSE_COUNT(String pROP_DISPOSE_COUNT) {
		PROP_DISPOSE_COUNT = pROP_DISPOSE_COUNT;
	}

	public static String getPROP_DISPOSE_AMOUNT() {
		return PROP_DISPOSE_AMOUNT;
	}

	public static void setPROP_DISPOSE_AMOUNT(String pROP_DISPOSE_AMOUNT) {
		PROP_DISPOSE_AMOUNT = pROP_DISPOSE_AMOUNT;
	}

	public static String getPROP_DISPOSE_DATE() {
		return PROP_DISPOSE_DATE;
	}

	public static void setPROP_DISPOSE_DATE(String pROP_DISPOSE_DATE) {
		PROP_DISPOSE_DATE = pROP_DISPOSE_DATE;
	}

	public static String getPROP_DEBIT_INTEREST_COUNT() {
		return PROP_DEBIT_INTEREST_COUNT;
	}

	public static void setPROP_DEBIT_INTEREST_COUNT(String pROP_DEBIT_INTEREST_COUNT) {
		PROP_DEBIT_INTEREST_COUNT = pROP_DEBIT_INTEREST_COUNT;
	}

	public static String getPROP_DEBIT_INTEREST_AMOUNT() {
		return PROP_DEBIT_INTEREST_AMOUNT;
	}

	public static void setPROP_DEBIT_INTEREST_AMOUNT(
			String pROP_DEBIT_INTEREST_AMOUNT) {
		PROP_DEBIT_INTEREST_AMOUNT = pROP_DEBIT_INTEREST_AMOUNT;
	}

	public static String getPROP_DIVEST_COUNT() {
		return PROP_DIVEST_COUNT;
	}

	public static void setPROP_DIVEST_COUNT(String pROP_DIVEST_COUNT) {
		PROP_DIVEST_COUNT = pROP_DIVEST_COUNT;
	}

	public static String getPROP_DIVEST_AMOUNT() {
		return PROP_DIVEST_AMOUNT;
	}

	public static void setPROP_DIVEST_AMOUNT(String pROP_DIVEST_AMOUNT) {
		PROP_DIVEST_AMOUNT = pROP_DIVEST_AMOUNT;
	}

	public static String getPROP_DIVEST_DATE() {
		return PROP_DIVEST_DATE;
	}

	public static void setPROP_DIVEST_DATE(String pROP_DIVEST_DATE) {
		PROP_DIVEST_DATE = pROP_DIVEST_DATE;
	}

	public static String getPROP_ADVANCED_COUNT() {
		return PROP_ADVANCED_COUNT;
	}

	public static void setPROP_ADVANCED_COUNT(String pROP_ADVANCED_COUNT) {
		PROP_ADVANCED_COUNT = pROP_ADVANCED_COUNT;
	}

	public static String getPROP_ADVANCED_AMOUNT() {
		return PROP_ADVANCED_AMOUNT;
	}

	public static void setPROP_ADVANCED_AMOUNT(String pROP_ADVANCED_AMOUNT) {
		PROP_ADVANCED_AMOUNT = pROP_ADVANCED_AMOUNT;
	}

	public static String getPROP_ADVANCED_DATE() {
		return PROP_ADVANCED_DATE;
	}

	public static void setPROP_ADVANCED_DATE(String pROP_ADVANCED_DATE) {
		PROP_ADVANCED_DATE = pROP_ADVANCED_DATE;
	}

	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}

	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}

	public static String getPROP_ASSURE_CREDIT_CLEAR_DATE() {
		return PROP_ASSURE_CREDIT_CLEAR_DATE;
	}

	public static void setPROP_ASSURE_CREDIT_CLEAR_DATE(
			String pROP_ASSURE_CREDIT_CLEAR_DATE) {
		PROP_ASSURE_CREDIT_CLEAR_DATE = pROP_ASSURE_CREDIT_CLEAR_DATE;
	}

	public static String getPROP_ASSURE_CREDIT_COUNT() {
		return PROP_ASSURE_CREDIT_COUNT;
	}

	public static void setPROP_ASSURE_CREDIT_COUNT(String pROP_ASSURE_CREDIT_COUNT) {
		PROP_ASSURE_CREDIT_COUNT = pROP_ASSURE_CREDIT_COUNT;
	}

	public static String getPROP_ASSURE_CREDIT_SUM() {
		return PROP_ASSURE_CREDIT_SUM;
	}

	public static void setPROP_ASSURE_CREDIT_SUM(String pROP_ASSURE_CREDIT_SUM) {
		PROP_ASSURE_CREDIT_SUM = pROP_ASSURE_CREDIT_SUM;
	}

	public static String getPROP_DEBIT_INTEREST_CLEAR_DATE() {
		return PROP_DEBIT_INTEREST_CLEAR_DATE;
	}

	public static void setPROP_DEBIT_INTEREST_CLEAR_DATE(
			String pROP_DEBIT_INTEREST_CLEAR_DATE) {
		PROP_DEBIT_INTEREST_CLEAR_DATE = pROP_DEBIT_INTEREST_CLEAR_DATE;
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

	public java.lang.Integer getDisposeCount() {
		return disposeCount;
	}

	public void setDisposeCount(java.lang.Integer disposeCount) {
		this.disposeCount = disposeCount;
	}

	public java.lang.Float getDisposeAmount() {
		return disposeAmount;
	}

	public void setDisposeAmount(java.lang.Float disposeAmount) {
		this.disposeAmount = disposeAmount;
	}

	public java.lang.String getDisposeDate() {
		return disposeDate;
	}

	public void setDisposeDate(java.lang.String disposeDate) {
		this.disposeDate = disposeDate;
	}

	public java.lang.Integer getDebitInterestCount() {
		return debitInterestCount;
	}

	public void setDebitInterestCount(java.lang.Integer debitInterestCount) {
		this.debitInterestCount = debitInterestCount;
	}

	public java.lang.Float getDebitInterestAmount() {
		return debitInterestAmount;
	}

	public void setDebitInterestAmount(java.lang.Float debitInterestAmount) {
		this.debitInterestAmount = debitInterestAmount;
	}

	public java.lang.Integer getDivestCount() {
		return divestCount;
	}

	public void setDivestCount(java.lang.Integer divestCount) {
		this.divestCount = divestCount;
	}

	public java.lang.Float getDivestAmount() {
		return divestAmount;
	}

	public void setDivestAmount(java.lang.Float divestAmount) {
		this.divestAmount = divestAmount;
	}

	public java.lang.String getDivestDate() {
		return divestDate;
	}

	public void setDivestDate(java.lang.String divestDate) {
		this.divestDate = divestDate;
	}

	public java.lang.Integer getAdvancedCount() {
		return advancedCount;
	}

	public void setAdvancedCount(java.lang.Integer advancedCount) {
		this.advancedCount = advancedCount;
	}

	public java.lang.Float getAdvancedAmount() {
		return advancedAmount;
	}

	public void setAdvancedAmount(java.lang.Float advancedAmount) {
		this.advancedAmount = advancedAmount;
	}

	public java.lang.String getAdvancedDate() {
		return advancedDate;
	}

	public void setAdvancedDate(java.lang.String advancedDate) {
		this.advancedDate = advancedDate;
	}

	public java.lang.String getStatus() {
		return status;
	}

	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	public java.lang.String getAssureCreditClearDate() {
		return assureCreditClearDate;
	}

	public void setAssureCreditClearDate(java.lang.String assureCreditClearDate) {
		this.assureCreditClearDate = assureCreditClearDate;
	}

	public java.lang.String getAssureCreditCount() {
		return assureCreditCount;
	}

	public void setAssureCreditCount(java.lang.String assureCreditCount) {
		this.assureCreditCount = assureCreditCount;
	}

	public java.lang.String getAssureCreditSum() {
		return assureCreditSum;
	}

	public void setAssureCreditSum(java.lang.String assureCreditSum) {
		this.assureCreditSum = assureCreditSum;
	}

	public java.lang.String getDebitInterestClearDate() {
		return debitInterestClearDate;
	}

	public void setDebitInterestClearDate(java.lang.String debitInterestClearDate) {
		this.debitInterestClearDate = debitInterestClearDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((advancedAmount == null) ? 0 : advancedAmount.hashCode());
		result = prime * result
				+ ((advancedCount == null) ? 0 : advancedCount.hashCode());
		result = prime * result
				+ ((advancedDate == null) ? 0 : advancedDate.hashCode());
		result = prime
				* result
				+ ((assureCreditClearDate == null) ? 0 : assureCreditClearDate
						.hashCode());
		result = prime
				* result
				+ ((assureCreditCount == null) ? 0 : assureCreditCount
						.hashCode());
		result = prime * result
				+ ((assureCreditSum == null) ? 0 : assureCreditSum.hashCode());
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime
				* result
				+ ((debitInterestAmount == null) ? 0 : debitInterestAmount
						.hashCode());
		result = prime
				* result
				+ ((debitInterestClearDate == null) ? 0
						: debitInterestClearDate.hashCode());
		result = prime
				* result
				+ ((debitInterestCount == null) ? 0 : debitInterestCount
						.hashCode());
		result = prime * result
				+ ((disposeAmount == null) ? 0 : disposeAmount.hashCode());
		result = prime * result
				+ ((disposeCount == null) ? 0 : disposeCount.hashCode());
		result = prime * result
				+ ((disposeDate == null) ? 0 : disposeDate.hashCode());
		result = prime * result
				+ ((divestAmount == null) ? 0 : divestAmount.hashCode());
		result = prime * result
				+ ((divestCount == null) ? 0 : divestCount.hashCode());
		result = prime * result
				+ ((divestDate == null) ? 0 : divestDate.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		BaseTCorpSumCredit other = (BaseTCorpSumCredit) obj;
		if (advancedAmount == null) {
			if (other.advancedAmount != null)
				return false;
		} else if (!advancedAmount.equals(other.advancedAmount))
			return false;
		if (advancedCount == null) {
			if (other.advancedCount != null)
				return false;
		} else if (!advancedCount.equals(other.advancedCount))
			return false;
		if (advancedDate == null) {
			if (other.advancedDate != null)
				return false;
		} else if (!advancedDate.equals(other.advancedDate))
			return false;
		if (assureCreditClearDate == null) {
			if (other.assureCreditClearDate != null)
				return false;
		} else if (!assureCreditClearDate.equals(other.assureCreditClearDate))
			return false;
		if (assureCreditCount == null) {
			if (other.assureCreditCount != null)
				return false;
		} else if (!assureCreditCount.equals(other.assureCreditCount))
			return false;
		if (assureCreditSum == null) {
			if (other.assureCreditSum != null)
				return false;
		} else if (!assureCreditSum.equals(other.assureCreditSum))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (debitInterestAmount == null) {
			if (other.debitInterestAmount != null)
				return false;
		} else if (!debitInterestAmount.equals(other.debitInterestAmount))
			return false;
		if (debitInterestClearDate == null) {
			if (other.debitInterestClearDate != null)
				return false;
		} else if (!debitInterestClearDate.equals(other.debitInterestClearDate))
			return false;
		if (debitInterestCount == null) {
			if (other.debitInterestCount != null)
				return false;
		} else if (!debitInterestCount.equals(other.debitInterestCount))
			return false;
		if (disposeAmount == null) {
			if (other.disposeAmount != null)
				return false;
		} else if (!disposeAmount.equals(other.disposeAmount))
			return false;
		if (disposeCount == null) {
			if (other.disposeCount != null)
				return false;
		} else if (!disposeCount.equals(other.disposeCount))
			return false;
		if (disposeDate == null) {
			if (other.disposeDate != null)
				return false;
		} else if (!disposeDate.equals(other.disposeDate))
			return false;
		if (divestAmount == null) {
			if (other.divestAmount != null)
				return false;
		} else if (!divestAmount.equals(other.divestAmount))
			return false;
		if (divestCount == null) {
			if (other.divestCount != null)
				return false;
		} else if (!divestCount.equals(other.divestCount))
			return false;
		if (divestDate == null) {
			if (other.divestDate != null)
				return false;
		} else if (!divestDate.equals(other.divestDate))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public BaseTCorpSumCredit(int hashCode, Integer id, String rptKey,
			Date createTime, Integer disposeCount, Float disposeAmount,
			String disposeDate, Integer debitInterestCount,
			Float debitInterestAmount, Integer divestCount, Float divestAmount,
			String divestDate, Integer advancedCount, Float advancedAmount,
			String advancedDate, String status, String assureCreditClearDate,
			String assureCreditCount, String assureCreditSum,
			String debitInterestClearDate) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.disposeCount = disposeCount;
		this.disposeAmount = disposeAmount;
		this.disposeDate = disposeDate;
		this.debitInterestCount = debitInterestCount;
		this.debitInterestAmount = debitInterestAmount;
		this.divestCount = divestCount;
		this.divestAmount = divestAmount;
		this.divestDate = divestDate;
		this.advancedCount = advancedCount;
		this.advancedAmount = advancedAmount;
		this.advancedDate = advancedDate;
		this.status = status;
		this.assureCreditClearDate = assureCreditClearDate;
		this.assureCreditCount = assureCreditCount;
		this.assureCreditSum = assureCreditSum;
		this.debitInterestClearDate = debitInterestClearDate;
	}

	
	

	




	
	
    
    
	
    
    
}
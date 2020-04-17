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

public abstract class BaseIndOverdue implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndOverdue";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_LOAN_COUNT="loanCount";
    public static String PROP_LOAN_MONTH_COUNT="loanMonthCount";
    public static String PROP_LOAN_MAX_AMOUNT="loanMaxAmount";
    public static String PROP_LOAN_MAX_MONTH="loanMaxMonth";
    public static String PROP_CC_COUNT="ccCount";
    public static String PROP_CC_MONTH_COUNT="ccMonthCount";
    public static String PROP_CC_MAX_AMOUNT="ccMaxAmount";
    public static String PROP_CC_MAX_MONTH="ccMaxMonth";
    public static String PROP_PDC_COUNT="pdcCount";
    public static String PROP_PDC_MONTH_COUNT="pdcMonthCount";
    public static String PROP_PCD_MAX_AMOUNT="pcdMaxAmount";
    public static String PROP_PDC_MAX_MONTH="pdcMaxMonth";
    public static String PROP_GETDATE="getDate";
    public BaseIndOverdue() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer loanCount;
    private java.lang.Integer loanMonthCount;
    private java.lang.Float loanMaxAmount;
    private java.lang.Integer loanMaxMonth;
    private java.lang.Integer ccCount;
    private java.lang.Integer ccMonthCount;
    private java.lang.Float ccMaxAmount;
    private java.lang.Integer ccMaxMonth;
    private java.lang.Integer pdcCount;
    private java.lang.Integer pdcMonthCount;
    private java.lang.Float pcdMaxAmount;
    private java.lang.Integer pdcMaxMonth;
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
	public static String getPROP_LOAN_COUNT() {
		return PROP_LOAN_COUNT;
	}
	public static void setPROP_LOAN_COUNT(String pROP_LOAN_COUNT) {
		PROP_LOAN_COUNT = pROP_LOAN_COUNT;
	}
	public static String getPROP_LOAN_MONTH_COUNT() {
		return PROP_LOAN_MONTH_COUNT;
	}
	public static void setPROP_LOAN_MONTH_COUNT(String pROP_LOAN_MONTH_COUNT) {
		PROP_LOAN_MONTH_COUNT = pROP_LOAN_MONTH_COUNT;
	}
	public static String getPROP_LOAN_MAX_AMOUNT() {
		return PROP_LOAN_MAX_AMOUNT;
	}
	public static void setPROP_LOAN_MAX_AMOUNT(String pROP_LOAN_MAX_AMOUNT) {
		PROP_LOAN_MAX_AMOUNT = pROP_LOAN_MAX_AMOUNT;
	}
	public static String getPROP_LOAN_MAX_MONTH() {
		return PROP_LOAN_MAX_MONTH;
	}
	public static void setPROP_LOAN_MAX_MONTH(String pROP_LOAN_MAX_MONTH) {
		PROP_LOAN_MAX_MONTH = pROP_LOAN_MAX_MONTH;
	}
	public static String getPROP_CC_COUNT() {
		return PROP_CC_COUNT;
	}
	public static void setPROP_CC_COUNT(String pROP_CC_COUNT) {
		PROP_CC_COUNT = pROP_CC_COUNT;
	}
	public static String getPROP_CC_MONTH_COUNT() {
		return PROP_CC_MONTH_COUNT;
	}
	public static void setPROP_CC_MONTH_COUNT(String pROP_CC_MONTH_COUNT) {
		PROP_CC_MONTH_COUNT = pROP_CC_MONTH_COUNT;
	}
	public static String getPROP_CC_MAX_AMOUNT() {
		return PROP_CC_MAX_AMOUNT;
	}
	public static void setPROP_CC_MAX_AMOUNT(String pROP_CC_MAX_AMOUNT) {
		PROP_CC_MAX_AMOUNT = pROP_CC_MAX_AMOUNT;
	}
	public static String getPROP_CC_MAX_MONTH() {
		return PROP_CC_MAX_MONTH;
	}
	public static void setPROP_CC_MAX_MONTH(String pROP_CC_MAX_MONTH) {
		PROP_CC_MAX_MONTH = pROP_CC_MAX_MONTH;
	}
	public static String getPROP_PDC_COUNT() {
		return PROP_PDC_COUNT;
	}
	public static void setPROP_PDC_COUNT(String pROP_PDC_COUNT) {
		PROP_PDC_COUNT = pROP_PDC_COUNT;
	}
	public static String getPROP_PDC_MONTH_COUNT() {
		return PROP_PDC_MONTH_COUNT;
	}
	public static void setPROP_PDC_MONTH_COUNT(String pROP_PDC_MONTH_COUNT) {
		PROP_PDC_MONTH_COUNT = pROP_PDC_MONTH_COUNT;
	}
	public static String getPROP_PCD_MAX_AMOUNT() {
		return PROP_PCD_MAX_AMOUNT;
	}
	public static void setPROP_PCD_MAX_AMOUNT(String pROP_PCD_MAX_AMOUNT) {
		PROP_PCD_MAX_AMOUNT = pROP_PCD_MAX_AMOUNT;
	}
	public static String getPROP_PDC_MAX_MONTH() {
		return PROP_PDC_MAX_MONTH;
	}
	public static void setPROP_PDC_MAX_MONTH(String pROP_PDC_MAX_MONTH) {
		PROP_PDC_MAX_MONTH = pROP_PDC_MAX_MONTH;
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
	public java.lang.Integer getLoanCount() {
		return loanCount;
	}
	public void setLoanCount(java.lang.Integer loanCount) {
		this.loanCount = loanCount;
	}
	public java.lang.Integer getLoanMonthCount() {
		return loanMonthCount;
	}
	public void setLoanMonthCount(java.lang.Integer loanMonthCount) {
		this.loanMonthCount = loanMonthCount;
	}
	public java.lang.Float getLoanMaxAmount() {
		return loanMaxAmount;
	}
	public void setLoanMaxAmount(java.lang.Float loanMaxAmount) {
		this.loanMaxAmount = loanMaxAmount;
	}
	public java.lang.Integer getLoanMaxMonth() {
		return loanMaxMonth;
	}
	public void setLoanMaxMonth(java.lang.Integer loanMaxMonth) {
		this.loanMaxMonth = loanMaxMonth;
	}
	public java.lang.Integer getCcCount() {
		return ccCount;
	}
	public void setCcCount(java.lang.Integer ccCount) {
		this.ccCount = ccCount;
	}
	public java.lang.Integer getCcMonthCount() {
		return ccMonthCount;
	}
	public void setCcMonthCount(java.lang.Integer ccMonthCount) {
		this.ccMonthCount = ccMonthCount;
	}
	public java.lang.Float getCcMaxAmount() {
		return ccMaxAmount;
	}
	public void setCcMaxAmount(java.lang.Float ccMaxAmount) {
		this.ccMaxAmount = ccMaxAmount;
	}
	public java.lang.Integer getCcMaxMonth() {
		return ccMaxMonth;
	}
	public void setCcMaxMonth(java.lang.Integer ccMaxMonth) {
		this.ccMaxMonth = ccMaxMonth;
	}
	public java.lang.Integer getPdcCount() {
		return pdcCount;
	}
	public void setPdcCount(java.lang.Integer pdcCount) {
		this.pdcCount = pdcCount;
	}
	public java.lang.Integer getPdcMonthCount() {
		return pdcMonthCount;
	}
	public void setPdcMonthCount(java.lang.Integer pdcMonthCount) {
		this.pdcMonthCount = pdcMonthCount;
	}
	public java.lang.Float getPcdMaxAmount() {
		return pcdMaxAmount;
	}
	public void setPcdMaxAmount(java.lang.Float pcdMaxAmount) {
		this.pcdMaxAmount = pcdMaxAmount;
	}
	public java.lang.Integer getPdcMaxMonth() {
		return pdcMaxMonth;
	}
	public void setPdcMaxMonth(java.lang.Integer pdcMaxMonth) {
		this.pdcMaxMonth = pdcMaxMonth;
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
		result = prime * result + ((ccCount == null) ? 0 : ccCount.hashCode());
		result = prime * result
				+ ((ccMaxAmount == null) ? 0 : ccMaxAmount.hashCode());
		result = prime * result
				+ ((ccMaxMonth == null) ? 0 : ccMaxMonth.hashCode());
		result = prime * result
				+ ((ccMonthCount == null) ? 0 : ccMonthCount.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loanCount == null) ? 0 : loanCount.hashCode());
		result = prime * result
				+ ((loanMaxAmount == null) ? 0 : loanMaxAmount.hashCode());
		result = prime * result
				+ ((loanMaxMonth == null) ? 0 : loanMaxMonth.hashCode());
		result = prime * result
				+ ((loanMonthCount == null) ? 0 : loanMonthCount.hashCode());
		result = prime * result
				+ ((pcdMaxAmount == null) ? 0 : pcdMaxAmount.hashCode());
		result = prime * result
				+ ((pdcCount == null) ? 0 : pdcCount.hashCode());
		result = prime * result
				+ ((pdcMaxMonth == null) ? 0 : pdcMaxMonth.hashCode());
		result = prime * result
				+ ((pdcMonthCount == null) ? 0 : pdcMonthCount.hashCode());
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
		BaseIndOverdue other = (BaseIndOverdue) obj;
		if (ccCount == null) {
			if (other.ccCount != null)
				return false;
		} else if (!ccCount.equals(other.ccCount))
			return false;
		if (ccMaxAmount == null) {
			if (other.ccMaxAmount != null)
				return false;
		} else if (!ccMaxAmount.equals(other.ccMaxAmount))
			return false;
		if (ccMaxMonth == null) {
			if (other.ccMaxMonth != null)
				return false;
		} else if (!ccMaxMonth.equals(other.ccMaxMonth))
			return false;
		if (ccMonthCount == null) {
			if (other.ccMonthCount != null)
				return false;
		} else if (!ccMonthCount.equals(other.ccMonthCount))
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
		if (loanCount == null) {
			if (other.loanCount != null)
				return false;
		} else if (!loanCount.equals(other.loanCount))
			return false;
		if (loanMaxAmount == null) {
			if (other.loanMaxAmount != null)
				return false;
		} else if (!loanMaxAmount.equals(other.loanMaxAmount))
			return false;
		if (loanMaxMonth == null) {
			if (other.loanMaxMonth != null)
				return false;
		} else if (!loanMaxMonth.equals(other.loanMaxMonth))
			return false;
		if (loanMonthCount == null) {
			if (other.loanMonthCount != null)
				return false;
		} else if (!loanMonthCount.equals(other.loanMonthCount))
			return false;
		if (pcdMaxAmount == null) {
			if (other.pcdMaxAmount != null)
				return false;
		} else if (!pcdMaxAmount.equals(other.pcdMaxAmount))
			return false;
		if (pdcCount == null) {
			if (other.pdcCount != null)
				return false;
		} else if (!pdcCount.equals(other.pdcCount))
			return false;
		if (pdcMaxMonth == null) {
			if (other.pdcMaxMonth != null)
				return false;
		} else if (!pdcMaxMonth.equals(other.pdcMaxMonth))
			return false;
		if (pdcMonthCount == null) {
			if (other.pdcMonthCount != null)
				return false;
		} else if (!pdcMonthCount.equals(other.pdcMonthCount))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		return true;
	}
	public BaseIndOverdue(Integer id, String rptId, Integer loanCount,
			Integer loanMonthCount, Float loanMaxAmount, Integer loanMaxMonth,
			Integer ccCount, Integer ccMonthCount, Float ccMaxAmount,
			Integer ccMaxMonth, Integer pdcCount, Integer pdcMonthCount,
			Float pcdMaxAmount, Integer pdcMaxMonth, Date getDate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.loanCount = loanCount;
		this.loanMonthCount = loanMonthCount;
		this.loanMaxAmount = loanMaxAmount;
		this.loanMaxMonth = loanMaxMonth;
		this.ccCount = ccCount;
		this.ccMonthCount = ccMonthCount;
		this.ccMaxAmount = ccMaxAmount;
		this.ccMaxMonth = ccMaxMonth;
		this.pdcCount = pdcCount;
		this.pdcMonthCount = pdcMonthCount;
		this.pcdMaxAmount = pcdMaxAmount;
		this.pdcMaxMonth = pdcMaxMonth;
		this.getDate = getDate;
	}
    
	
    
    
  
}
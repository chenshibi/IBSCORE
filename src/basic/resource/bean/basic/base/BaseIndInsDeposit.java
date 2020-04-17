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

public abstract class BaseIndInsDeposit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndInsDeposit";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_BASE_AMOUNT="baseAmount";
    public static String PROP_CITY="city";
    public static String PROP_DEPOSIT_AMOUNT="depositAmount";
    public static String PROP_END_REASON="endReason";
    public static String PROP_INIT_DATE="initDate";
    public static String PROP_NO="no";
    public static String PROP_ORGAN="organ";
    public static String PROP_STATUS="status";
    public static String PROP_TOTAL_MONTH="totalMonth";
    public static String PROP_UPDATE_DATE="updateDate";
    public static String PROP_WORK_MONTH="workMonth";

    public BaseIndInsDeposit() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String baseAmount;
    private java.lang.String city;
    private java.lang.String depositAmount;
    private java.lang.String endReason;
    private java.lang.String initDate;
    private java.lang.Integer no;
    private java.lang.String organ;
    private java.lang.String status;
    private java.lang.String totalMonth;
    private java.lang.String updateDate;
    private java.lang.String workMonth;

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
	public static String getPROP_BASE_AMOUNT() {
		return PROP_BASE_AMOUNT;
	}
	public static void setPROP_BASE_AMOUNT(String pROP_BASE_AMOUNT) {
		PROP_BASE_AMOUNT = pROP_BASE_AMOUNT;
	}
	public static String getPROP_CITY() {
		return PROP_CITY;
	}
	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}
	public static String getPROP_DEPOSIT_AMOUNT() {
		return PROP_DEPOSIT_AMOUNT;
	}
	public static void setPROP_DEPOSIT_AMOUNT(String pROP_DEPOSIT_AMOUNT) {
		PROP_DEPOSIT_AMOUNT = pROP_DEPOSIT_AMOUNT;
	}
	public static String getPROP_END_REASON() {
		return PROP_END_REASON;
	}
	public static void setPROP_END_REASON(String pROP_END_REASON) {
		PROP_END_REASON = pROP_END_REASON;
	}
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_NO() {
		return PROP_NO;
	}
	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_TOTAL_MONTH() {
		return PROP_TOTAL_MONTH;
	}
	public static void setPROP_TOTAL_MONTH(String pROP_TOTAL_MONTH) {
		PROP_TOTAL_MONTH = pROP_TOTAL_MONTH;
	}
	public static String getPROP_UPDATE_DATE() {
		return PROP_UPDATE_DATE;
	}
	public static void setPROP_UPDATE_DATE(String pROP_UPDATE_DATE) {
		PROP_UPDATE_DATE = pROP_UPDATE_DATE;
	}
	public static String getPROP_WORK_MONTH() {
		return PROP_WORK_MONTH;
	}
	public static void setPROP_WORK_MONTH(String pROP_WORK_MONTH) {
		PROP_WORK_MONTH = pROP_WORK_MONTH;
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
	public java.lang.String getBaseAmount() {
		return baseAmount;
	}
	public void setBaseAmount(java.lang.String baseAmount) {
		this.baseAmount = baseAmount;
	}
	public java.lang.String getCity() {
		return city;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	public java.lang.String getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(java.lang.String depositAmount) {
		this.depositAmount = depositAmount;
	}
	public java.lang.String getEndReason() {
		return endReason;
	}
	public void setEndReason(java.lang.String endReason) {
		this.endReason = endReason;
	}
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.Integer getNo() {
		return no;
	}
	public void setNo(java.lang.Integer no) {
		this.no = no;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getTotalMonth() {
		return totalMonth;
	}
	public void setTotalMonth(java.lang.String totalMonth) {
		this.totalMonth = totalMonth;
	}
	public java.lang.String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.lang.String updateDate) {
		this.updateDate = updateDate;
	}
	public java.lang.String getWorkMonth() {
		return workMonth;
	}
	public void setWorkMonth(java.lang.String workMonth) {
		this.workMonth = workMonth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((baseAmount == null) ? 0 : baseAmount.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((depositAmount == null) ? 0 : depositAmount.hashCode());
		result = prime * result
				+ ((endReason == null) ? 0 : endReason.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((totalMonth == null) ? 0 : totalMonth.hashCode());
		result = prime * result
				+ ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result
				+ ((workMonth == null) ? 0 : workMonth.hashCode());
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
		BaseIndInsDeposit other = (BaseIndInsDeposit) obj;
		if (baseAmount == null) {
			if (other.baseAmount != null)
				return false;
		} else if (!baseAmount.equals(other.baseAmount))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (depositAmount == null) {
			if (other.depositAmount != null)
				return false;
		} else if (!depositAmount.equals(other.depositAmount))
			return false;
		if (endReason == null) {
			if (other.endReason != null)
				return false;
		} else if (!endReason.equals(other.endReason))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (initDate == null) {
			if (other.initDate != null)
				return false;
		} else if (!initDate.equals(other.initDate))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (totalMonth == null) {
			if (other.totalMonth != null)
				return false;
		} else if (!totalMonth.equals(other.totalMonth))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (workMonth == null) {
			if (other.workMonth != null)
				return false;
		} else if (!workMonth.equals(other.workMonth))
			return false;
		return true;
	}
	public BaseIndInsDeposit(Integer id, String rptId, String baseAmount,
			String city, String depositAmount, String endReason,
			String initDate, Integer no, String organ, String status,
			String totalMonth, String updateDate, String workMonth) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.baseAmount = baseAmount;
		this.city = city;
		this.depositAmount = depositAmount;
		this.endReason = endReason;
		this.initDate = initDate;
		this.no = no;
		this.organ = organ;
		this.status = status;
		this.totalMonth = totalMonth;
		this.updateDate = updateDate;
		this.workMonth = workMonth;
	}

    
	
    
    
  
}
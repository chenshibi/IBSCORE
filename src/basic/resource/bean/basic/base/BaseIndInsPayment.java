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

public abstract class BaseIndInsPayment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndInsPayment";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_CITY="city";
    public static String PROP_END_REASON="endReason";
    public static String PROP_NO="no";
    public static String PROP_ORGAN="organ";
    public static String PROP_PAY_AMOUNT="payAmount";
    public static String PROP_RETIRE_MONTH="retireMonth";
    public static String PROP_TYPE="type";
    public static String PROP_UPDATE_DATE="updateDate";
    public static String PROP_WORK_MONTH="workMonth";

    public BaseIndInsPayment() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String city;
    private java.lang.String endReason;
    private java.lang.Integer no;
    private java.lang.String organ;
    private java.lang.String payAmount;
    private java.lang.String retireMonth;
    private java.lang.String type;
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
	public static String getPROP_CITY() {
		return PROP_CITY;
	}
	public static void setPROP_CITY(String pROP_CITY) {
		PROP_CITY = pROP_CITY;
	}
	public static String getPROP_END_REASON() {
		return PROP_END_REASON;
	}
	public static void setPROP_END_REASON(String pROP_END_REASON) {
		PROP_END_REASON = pROP_END_REASON;
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
	public static String getPROP_PAY_AMOUNT() {
		return PROP_PAY_AMOUNT;
	}
	public static void setPROP_PAY_AMOUNT(String pROP_PAY_AMOUNT) {
		PROP_PAY_AMOUNT = pROP_PAY_AMOUNT;
	}
	public static String getPROP_RETIRE_MONTH() {
		return PROP_RETIRE_MONTH;
	}
	public static void setPROP_RETIRE_MONTH(String pROP_RETIRE_MONTH) {
		PROP_RETIRE_MONTH = pROP_RETIRE_MONTH;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
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
	public java.lang.String getCity() {
		return city;
	}
	public void setCity(java.lang.String city) {
		this.city = city;
	}
	public java.lang.String getEndReason() {
		return endReason;
	}
	public void setEndReason(java.lang.String endReason) {
		this.endReason = endReason;
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
	public java.lang.String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(java.lang.String payAmount) {
		this.payAmount = payAmount;
	}
	public java.lang.String getRetireMonth() {
		return retireMonth;
	}
	public void setRetireMonth(java.lang.String retireMonth) {
		this.retireMonth = retireMonth;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result
				+ ((endReason == null) ? 0 : endReason.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result
				+ ((payAmount == null) ? 0 : payAmount.hashCode());
		result = prime * result
				+ ((retireMonth == null) ? 0 : retireMonth.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		BaseIndInsPayment other = (BaseIndInsPayment) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
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
		if (payAmount == null) {
			if (other.payAmount != null)
				return false;
		} else if (!payAmount.equals(other.payAmount))
			return false;
		if (retireMonth == null) {
			if (other.retireMonth != null)
				return false;
		} else if (!retireMonth.equals(other.retireMonth))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
	public BaseIndInsPayment(Integer id, String rptId, String city,
			String endReason, Integer no, String organ, String payAmount,
			String retireMonth, String type, String updateDate, String workMonth) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.city = city;
		this.endReason = endReason;
		this.no = no;
		this.organ = organ;
		this.payAmount = payAmount;
		this.retireMonth = retireMonth;
		this.type = type;
		this.updateDate = updateDate;
		this.workMonth = workMonth;
	}

    
	
    
    
  
}
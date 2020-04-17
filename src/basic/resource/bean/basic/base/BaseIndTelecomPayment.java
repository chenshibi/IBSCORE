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

public abstract class BaseIndTelecomPayment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndTelecomPayment";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_INIT_DATE="initDate";
    public static String PROP_MONTH24="month24";
    public static String PROP_NO="no";
    public static String PROP_ORGAN="organ";
    public static String PROP_OWE_AMOUNT="oweAmount";
    public static String PROP_OWE_MONTH="oweMonth";
    public static String PROP_STATUS="status";
    public static String PROP_TYPE="type";
    public static String PROP_YEARMONTH="yearmonth";

    public BaseIndTelecomPayment() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String initDate;
    private java.lang.String month24;
    private java.lang.Integer no;
    private java.lang.String organ;
    private java.lang.String oweAmount;
    private java.lang.String oweMonth;
    private java.lang.String status;
    private java.lang.String type;
    private java.lang.String yearmonth;

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
	public static String getPROP_INIT_DATE() {
		return PROP_INIT_DATE;
	}
	public static void setPROP_INIT_DATE(String pROP_INIT_DATE) {
		PROP_INIT_DATE = pROP_INIT_DATE;
	}
	public static String getPROP_MONTH24() {
		return PROP_MONTH24;
	}
	public static void setPROP_MONTH24(String pROP_MONTH24) {
		PROP_MONTH24 = pROP_MONTH24;
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
	public static String getPROP_OWE_AMOUNT() {
		return PROP_OWE_AMOUNT;
	}
	public static void setPROP_OWE_AMOUNT(String pROP_OWE_AMOUNT) {
		PROP_OWE_AMOUNT = pROP_OWE_AMOUNT;
	}
	public static String getPROP_OWE_MONTH() {
		return PROP_OWE_MONTH;
	}
	public static void setPROP_OWE_MONTH(String pROP_OWE_MONTH) {
		PROP_OWE_MONTH = pROP_OWE_MONTH;
	}
	public static String getPROP_STATUS() {
		return PROP_STATUS;
	}
	public static void setPROP_STATUS(String pROP_STATUS) {
		PROP_STATUS = pROP_STATUS;
	}
	public static String getPROP_TYPE() {
		return PROP_TYPE;
	}
	public static void setPROP_TYPE(String pROP_TYPE) {
		PROP_TYPE = pROP_TYPE;
	}
	public static String getPROP_YEARMONTH() {
		return PROP_YEARMONTH;
	}
	public static void setPROP_YEARMONTH(String pROP_YEARMONTH) {
		PROP_YEARMONTH = pROP_YEARMONTH;
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
	public java.lang.String getInitDate() {
		return initDate;
	}
	public void setInitDate(java.lang.String initDate) {
		this.initDate = initDate;
	}
	public java.lang.String getMonth24() {
		return month24;
	}
	public void setMonth24(java.lang.String month24) {
		this.month24 = month24;
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
	public java.lang.String getOweAmount() {
		return oweAmount;
	}
	public void setOweAmount(java.lang.String oweAmount) {
		this.oweAmount = oweAmount;
	}
	public java.lang.String getOweMonth() {
		return oweMonth;
	}
	public void setOweMonth(java.lang.String oweMonth) {
		this.oweMonth = oweMonth;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getType() {
		return type;
	}
	public void setType(java.lang.String type) {
		this.type = type;
	}
	public java.lang.String getYearmonth() {
		return yearmonth;
	}
	public void setYearmonth(java.lang.String yearmonth) {
		this.yearmonth = yearmonth;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((initDate == null) ? 0 : initDate.hashCode());
		result = prime * result + ((month24 == null) ? 0 : month24.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result
				+ ((oweAmount == null) ? 0 : oweAmount.hashCode());
		result = prime * result
				+ ((oweMonth == null) ? 0 : oweMonth.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((yearmonth == null) ? 0 : yearmonth.hashCode());
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
		BaseIndTelecomPayment other = (BaseIndTelecomPayment) obj;
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
		if (month24 == null) {
			if (other.month24 != null)
				return false;
		} else if (!month24.equals(other.month24))
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
		if (oweAmount == null) {
			if (other.oweAmount != null)
				return false;
		} else if (!oweAmount.equals(other.oweAmount))
			return false;
		if (oweMonth == null) {
			if (other.oweMonth != null)
				return false;
		} else if (!oweMonth.equals(other.oweMonth))
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (yearmonth == null) {
			if (other.yearmonth != null)
				return false;
		} else if (!yearmonth.equals(other.yearmonth))
			return false;
		return true;
	}
	public BaseIndTelecomPayment(Integer id, String rptId, String initDate,
			String month24, Integer no, String organ, String oweAmount,
			String oweMonth, String status, String type, String yearmonth) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.initDate = initDate;
		this.month24 = month24;
		this.no = no;
		this.organ = organ;
		this.oweAmount = oweAmount;
		this.oweMonth = oweMonth;
		this.status = status;
		this.type = type;
		this.yearmonth = yearmonth;
	}

    
	
    
    
  
}
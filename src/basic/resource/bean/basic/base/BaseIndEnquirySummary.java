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

public abstract class BaseIndEnquirySummary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndEnquirySummary";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_LOAN_APPROVE_ORGL1M="loanApproveOrgL1m";
    public static String PROP_CC_APPROVE_ORGL1M="ccApproveOrgL1m";
    public static String PROP_LOAN_APPROVE_L1M="loanApproveL1m";
    public static String PROP_CC_APPROVE_L1M="ccApproveL1m";
    public static String PROP_LOAN_MANAGE_L2Y="loanManageL2y";
    public static String PROP_ASSURANCE_CHECK_L2Y="assuranceCheckL2y";
    public static String PROP_REAL_NAME_CHECK_L2Y="realNameCheckL2y";
    public static String PROP_GET_DATE="getDate";
    public static String PROP_SELF_L1M="selfL1m";

    public BaseIndEnquirySummary() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer loanApproveOrgL1m;
    private java.lang.Integer ccApproveOrgL1m;
    private java.lang.Integer loanApproveL1m;
    private java.lang.Integer ccApproveL1m;
    private java.lang.Integer loanManageL2y;
    private java.lang.Integer assuranceCheckL2y;
    private java.lang.Integer realNameCheckL2y;
    private java.util.Date getDate;
    private java.lang.Integer selfL1m;

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
	public static String getPROP_LOAN_APPROVE_ORGL1M() {
		return PROP_LOAN_APPROVE_ORGL1M;
	}
	public static void setPROP_LOAN_APPROVE_ORGL1M(String pROP_LOAN_APPROVE_ORGL1M) {
		PROP_LOAN_APPROVE_ORGL1M = pROP_LOAN_APPROVE_ORGL1M;
	}
	public static String getPROP_CC_APPROVE_ORGL1M() {
		return PROP_CC_APPROVE_ORGL1M;
	}
	public static void setPROP_CC_APPROVE_ORGL1M(String pROP_CC_APPROVE_ORGL1M) {
		PROP_CC_APPROVE_ORGL1M = pROP_CC_APPROVE_ORGL1M;
	}
	public static String getPROP_LOAN_APPROVE_L1M() {
		return PROP_LOAN_APPROVE_L1M;
	}
	public static void setPROP_LOAN_APPROVE_L1M(String pROP_LOAN_APPROVE_L1M) {
		PROP_LOAN_APPROVE_L1M = pROP_LOAN_APPROVE_L1M;
	}
	public static String getPROP_CC_APPROVE_L1M() {
		return PROP_CC_APPROVE_L1M;
	}
	public static void setPROP_CC_APPROVE_L1M(String pROP_CC_APPROVE_L1M) {
		PROP_CC_APPROVE_L1M = pROP_CC_APPROVE_L1M;
	}
	public static String getPROP_LOAN_MANAGE_L2Y() {
		return PROP_LOAN_MANAGE_L2Y;
	}
	public static void setPROP_LOAN_MANAGE_L2Y(String pROP_LOAN_MANAGE_L2Y) {
		PROP_LOAN_MANAGE_L2Y = pROP_LOAN_MANAGE_L2Y;
	}
	public static String getPROP_ASSURANCE_CHECK_L2Y() {
		return PROP_ASSURANCE_CHECK_L2Y;
	}
	public static void setPROP_ASSURANCE_CHECK_L2Y(String pROP_ASSURANCE_CHECK_L2Y) {
		PROP_ASSURANCE_CHECK_L2Y = pROP_ASSURANCE_CHECK_L2Y;
	}
	public static String getPROP_REAL_NAME_CHECK_L2Y() {
		return PROP_REAL_NAME_CHECK_L2Y;
	}
	public static void setPROP_REAL_NAME_CHECK_L2Y(String pROP_REAL_NAME_CHECK_L2Y) {
		PROP_REAL_NAME_CHECK_L2Y = pROP_REAL_NAME_CHECK_L2Y;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
	}
	public static String getPROP_SELF_L1M() {
		return PROP_SELF_L1M;
	}
	public static void setPROP_SELF_L1M(String pROP_SELF_L1M) {
		PROP_SELF_L1M = pROP_SELF_L1M;
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
	public java.lang.Integer getLoanApproveOrgL1m() {
		return loanApproveOrgL1m;
	}
	public void setLoanApproveOrgL1m(java.lang.Integer loanApproveOrgL1m) {
		this.loanApproveOrgL1m = loanApproveOrgL1m;
	}
	public java.lang.Integer getCcApproveOrgL1m() {
		return ccApproveOrgL1m;
	}
	public void setCcApproveOrgL1m(java.lang.Integer ccApproveOrgL1m) {
		this.ccApproveOrgL1m = ccApproveOrgL1m;
	}
	public java.lang.Integer getLoanApproveL1m() {
		return loanApproveL1m;
	}
	public void setLoanApproveL1m(java.lang.Integer loanApproveL1m) {
		this.loanApproveL1m = loanApproveL1m;
	}
	public java.lang.Integer getCcApproveL1m() {
		return ccApproveL1m;
	}
	public void setCcApproveL1m(java.lang.Integer ccApproveL1m) {
		this.ccApproveL1m = ccApproveL1m;
	}
	public java.lang.Integer getLoanManageL2y() {
		return loanManageL2y;
	}
	public void setLoanManageL2y(java.lang.Integer loanManageL2y) {
		this.loanManageL2y = loanManageL2y;
	}
	public java.lang.Integer getAssuranceCheckL2y() {
		return assuranceCheckL2y;
	}
	public void setAssuranceCheckL2y(java.lang.Integer assuranceCheckL2y) {
		this.assuranceCheckL2y = assuranceCheckL2y;
	}
	public java.lang.Integer getRealNameCheckL2y() {
		return realNameCheckL2y;
	}
	public void setRealNameCheckL2y(java.lang.Integer realNameCheckL2y) {
		this.realNameCheckL2y = realNameCheckL2y;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public java.lang.Integer getSelfL1m() {
		return selfL1m;
	}
	public void setSelfL1m(java.lang.Integer selfL1m) {
		this.selfL1m = selfL1m;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((assuranceCheckL2y == null) ? 0 : assuranceCheckL2y
						.hashCode());
		result = prime * result
				+ ((ccApproveL1m == null) ? 0 : ccApproveL1m.hashCode());
		result = prime * result
				+ ((ccApproveOrgL1m == null) ? 0 : ccApproveOrgL1m.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((loanApproveL1m == null) ? 0 : loanApproveL1m.hashCode());
		result = prime
				* result
				+ ((loanApproveOrgL1m == null) ? 0 : loanApproveOrgL1m
						.hashCode());
		result = prime * result
				+ ((loanManageL2y == null) ? 0 : loanManageL2y.hashCode());
		result = prime
				* result
				+ ((realNameCheckL2y == null) ? 0 : realNameCheckL2y.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((selfL1m == null) ? 0 : selfL1m.hashCode());
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
		BaseIndEnquirySummary other = (BaseIndEnquirySummary) obj;
		if (assuranceCheckL2y == null) {
			if (other.assuranceCheckL2y != null)
				return false;
		} else if (!assuranceCheckL2y.equals(other.assuranceCheckL2y))
			return false;
		if (ccApproveL1m == null) {
			if (other.ccApproveL1m != null)
				return false;
		} else if (!ccApproveL1m.equals(other.ccApproveL1m))
			return false;
		if (ccApproveOrgL1m == null) {
			if (other.ccApproveOrgL1m != null)
				return false;
		} else if (!ccApproveOrgL1m.equals(other.ccApproveOrgL1m))
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
		if (loanApproveL1m == null) {
			if (other.loanApproveL1m != null)
				return false;
		} else if (!loanApproveL1m.equals(other.loanApproveL1m))
			return false;
		if (loanApproveOrgL1m == null) {
			if (other.loanApproveOrgL1m != null)
				return false;
		} else if (!loanApproveOrgL1m.equals(other.loanApproveOrgL1m))
			return false;
		if (loanManageL2y == null) {
			if (other.loanManageL2y != null)
				return false;
		} else if (!loanManageL2y.equals(other.loanManageL2y))
			return false;
		if (realNameCheckL2y == null) {
			if (other.realNameCheckL2y != null)
				return false;
		} else if (!realNameCheckL2y.equals(other.realNameCheckL2y))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (selfL1m == null) {
			if (other.selfL1m != null)
				return false;
		} else if (!selfL1m.equals(other.selfL1m))
			return false;
		return true;
	}
	public BaseIndEnquirySummary(Integer id, String rptId,
			Integer loanApproveOrgL1m, Integer ccApproveOrgL1m,
			Integer loanApproveL1m, Integer ccApproveL1m,
			Integer loanManageL2y, Integer assuranceCheckL2y,
			Integer realNameCheckL2y, Date getDate, Integer selfL1m) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.loanApproveOrgL1m = loanApproveOrgL1m;
		this.ccApproveOrgL1m = ccApproveOrgL1m;
		this.loanApproveL1m = loanApproveL1m;
		this.ccApproveL1m = ccApproveL1m;
		this.loanManageL2y = loanManageL2y;
		this.assuranceCheckL2y = assuranceCheckL2y;
		this.realNameCheckL2y = realNameCheckL2y;
		this.getDate = getDate;
		this.selfL1m = selfL1m;
	}

    
	
    
    
  
}
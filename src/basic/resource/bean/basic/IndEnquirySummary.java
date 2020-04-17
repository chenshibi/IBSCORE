package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndEnquirySummary;



public class IndEnquirySummary extends BaseIndEnquirySummary {
	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndEnquirySummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndEnquirySummary(Integer id, String rptId,
			Integer loanApproveOrgL1m, Integer ccApproveOrgL1m,
			Integer loanApproveL1m, Integer ccApproveL1m,
			Integer loanManageL2y, Integer assuranceCheckL2y,
			Integer realNameCheckL2y, Date getDate, Integer selfL1m) {
		super(id, rptId, loanApproveOrgL1m, ccApproveOrgL1m, loanApproveL1m,
				ccApproveL1m, loanManageL2y, assuranceCheckL2y, realNameCheckL2y,
				getDate, selfL1m);
		// TODO Auto-generated constructor stub
	}

	
	

	

	
	
    
}
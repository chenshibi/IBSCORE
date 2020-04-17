package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndAddr;
import resource.bean.basic.base.BaseIndAssuranceDetail;


public class IndAssuranceDetail extends BaseIndAssuranceDetail {
	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndAssuranceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndAssuranceDetail(Integer id, String rptId, Integer no,
			String assuranceOrg, Float contractAmount, Date issueDate,
			Date endDate, Float assuranceAmount, Float balance, String l5class,
			Date yearmonth, Date getDate, String type) {
		super(id, rptId, no, assuranceOrg, contractAmount, issueDate, endDate,
				assuranceAmount, balance, l5class, yearmonth, getDate, type);
		// TODO Auto-generated constructor stub
	}

	
	

	

	
	
    
}
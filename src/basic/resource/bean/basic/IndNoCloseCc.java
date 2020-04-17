package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndNoCloseCc;
import resource.bean.basic.base.BaseIndNoCloseLoan;



public class IndNoCloseCc extends BaseIndNoCloseCc {
	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndNoCloseCc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndNoCloseCc(Integer id, String rptId, Integer lawOrgCount,
			Integer orgCount, Integer count, Float totalCreditAmount,
			Float maxCreditAmount, Float minCreditAmount, Float totalUsed,
			Float avgUsedL6m, Date getDate) {
		super(id, rptId, lawOrgCount, orgCount, count, totalCreditAmount,
				maxCreditAmount, minCreditAmount, totalUsed, avgUsedL6m, getDate);
		// TODO Auto-generated constructor stub
	}


	
	

	

	
	
    
}
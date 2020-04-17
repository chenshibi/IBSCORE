package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndOverdue;



public class IndOverdue extends BaseIndOverdue {
	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndOverdue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndOverdue(Integer id, String rptId, Integer loanCount,
			Integer loanMonthCount, Float loanMaxAmount, Integer loanMaxMonth,
			Integer ccCount, Integer ccMonthCount, Float ccMaxAmount,
			Integer ccMaxMonth, Integer pdcCount, Integer pdcMonthCount,
			Float pcdMaxAmount, Integer pdcMaxMonth, Date getDate) {
		super(id, rptId, loanCount, loanMonthCount, loanMaxAmount, loanMaxMonth,
				ccCount, ccMonthCount, ccMaxAmount, ccMaxMonth, pdcCount,
				pdcMonthCount, pcdMaxAmount, pdcMaxMonth, getDate);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

	

	
	
    
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoBasic;
import resource.bean.basic.base.BaseTCorpSumCredit;



/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpSumCredit extends BaseTCorpSumCredit {

	public TCorpSumCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpSumCredit(int hashCode, Integer id, String rptKey,
			Date createTime, Integer disposeCount, Float disposeAmount,
			String disposeDate, Integer debitInterestCount,
			Float debitInterestAmount, Integer divestCount, Float divestAmount,
			String divestDate, Integer advancedCount, Float advancedAmount,
			String advancedDate, String status, String assureCreditClearDate,
			String assureCreditCount, String assureCreditSum,
			String debitInterestClearDate) {
		super(hashCode, id, rptKey, createTime, disposeCount, disposeAmount,
				disposeDate, debitInterestCount, debitInterestAmount, divestCount,
				divestAmount, divestDate, advancedCount, advancedAmount, advancedDate,
				status, assureCreditClearDate, assureCreditCount, assureCreditSum,
				debitInterestClearDate);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

		
  
}
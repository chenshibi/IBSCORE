package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoBasic;
import resource.bean.basic.base.BaseTCorpSumCredit;
import resource.bean.basic.base.BaseTCorpSumDebitHistory;



/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpSumDebitHistory extends BaseTCorpSumDebitHistory {

	public TCorpSumDebitHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpSumDebitHistory(int hashCode, Integer id, String rptKey,
			Date createTime, Float totalAmount, Float badAmount, String month) {
		super(hashCode, id, rptKey, createTime, totalAmount, badAmount, month);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

		
  
}
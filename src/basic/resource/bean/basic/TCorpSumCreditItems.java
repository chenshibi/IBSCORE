package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoBasic;
import resource.bean.basic.base.BaseTCorpSumCredit;
import resource.bean.basic.base.BaseTCorpSumCreditItems;



/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpSumCreditItems extends BaseTCorpSumCreditItems {

	public TCorpSumCreditItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpSumCreditItems(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status,
			Integer normalCount, Float normalAmount, Integer concernCount,
			Float concernAmount, Integer badCount, Float badAmount,
			Integer totalCount, Float totalAmount) {
		super(hashCode, id, rptKey, createTime, itemName, status, normalCount,
				normalAmount, concernCount, concernAmount, badCount, badAmount,
				totalCount, totalAmount);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

		
  
}
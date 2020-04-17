package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpSumAssure;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpSumAssure extends BaseTCorpSumAssure {

	public TCorpSumAssure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpSumAssure(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, Integer count, Float amount,
			Float normalAmount, Float concernAmount, Float badAmount,
			Float totalAmount) {
		super(hashCode, id, rptKey, createTime, itemName, count, amount, normalAmount,
				concernAmount, badAmount, totalAmount);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

		
  
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoInvestor;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpInfoInvestor extends BaseTCorpInfoInvestor {

	public TCorpInfoInvestor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpInfoInvestor(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String idType, String idNumber,
			String currency, Float amount, String proportion) {
		super(hashCode, id, rptKey, createTime, name, idType, idNumber, currency,
				amount, proportion);
		// TODO Auto-generated constructor stub
	}

	
	
	
	

		
  
}
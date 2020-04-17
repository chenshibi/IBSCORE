package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpOrginalDetailWindows;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpOrginalDetailWindows extends BaseTCorpOrginalDetailWindows {

	public TCorpOrginalDetailWindows() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpOrginalDetailWindows(int hashCode, Integer id, String rptKey,
			Float amount, Float balance, String bondDate, Date createTime,
			String currency, String expireDate, String fiveLevel,
			String itemName, String openDate) {
		super(hashCode, id, rptKey, amount, balance, bondDate, createTime, currency,
				expireDate, fiveLevel, itemName, openDate);
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	

		
  
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpPublicOweTax;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpPublicOweTax extends BaseTCorpPublicOweTax {

	public TCorpPublicOweTax() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpPublicOweTax(int hashCode, Integer id, String rptKey,
			Date createTime, String manager, Float amount, String taxDate) {
		super(hashCode, id, rptKey, createTime, manager, amount, taxDate);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

		
  
}
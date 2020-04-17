package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailSummary;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpDetailSummary extends BaseTCorpDetailSummary {

	public TCorpDetailSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailSummary(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status, String organ,
			Integer count, Float amount, Float balance, Float balanceDay30,
			Float balanceDay60, Float balanceDay90, Float balanceDay90Plus,
			String bizDetail) {
		super(hashCode, id, rptKey, createTime, itemName, status, organ, count, amount,
				balance, balanceDay30, balanceDay60, balanceDay90, balanceDay90Plus,
				bizDetail);
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	

		
  
}
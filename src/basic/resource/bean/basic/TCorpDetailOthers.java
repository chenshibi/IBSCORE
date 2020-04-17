package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailOthers;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpDetailOthers extends BaseTCorpDetailOthers {

	public TCorpDetailOthers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailOthers(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status, String organ,
			String type, String currency, Float amount, Float balance,
			String initDate, String expireDate, String closeDate,
			String updateDate, String fiveLevel, String style, String assured,
			String extended, String advanced, String depositRatio,
			String closeStyle, String historyRecord) {
		super(hashCode, id, rptKey, createTime, itemName, status, organ, type,
				currency, amount, balance, initDate, expireDate, closeDate, updateDate,
				fiveLevel, style, assured, extended, advanced, depositRatio,
				closeStyle, historyRecord);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

		
  
}
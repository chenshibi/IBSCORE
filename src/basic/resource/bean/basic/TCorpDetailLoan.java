package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailLoan;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpDetailLoan extends BaseTCorpDetailLoan {

	public TCorpDetailLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailLoan(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String status, String organ,
			String type, String currency, Float amount, Float balance,
			String initDate, String expireDate, String fiveLevel, String style,
			String assured, String extended, String closeDate,
			String closeStyle, String historyRecord) {
		super(hashCode, id, rptKey, createTime, itemName, status, organ, type,
				currency, amount, balance, initDate, expireDate, fiveLevel, style,
				assured, extended, closeDate, closeStyle, historyRecord);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

		
  
}
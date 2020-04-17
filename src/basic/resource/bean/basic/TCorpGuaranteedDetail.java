package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailOthers;
import resource.bean.basic.base.BaseTCorpGuaranteedDetail;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpGuaranteedDetail extends BaseTCorpGuaranteedDetail {

	public TCorpGuaranteedDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpGuaranteedDetail(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String type, String assurePerson,
			String assureKind, String assureDate, String currency,
			String valuation, String assureAmt, String assureType,
			String fiveLevel, String assuredName) {
		super(hashCode, id, rptKey, createTime, itemName, type, assurePerson,
				assureKind, assureDate, currency, valuation, assureAmt, assureType,
				fiveLevel, assuredName);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

		
  
}
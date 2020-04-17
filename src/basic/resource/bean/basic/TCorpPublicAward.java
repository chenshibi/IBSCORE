package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpPublicAward;
import resource.bean.basic.base.BaseTCorpPublicOweTax;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpPublicAward extends BaseTCorpPublicAward {

	public TCorpPublicAward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpPublicAward(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String organ, String subOrgan,
			String type, String initDate, String updateDate, String expireDate,
			String content, String awardCode, String term) {
		super(hashCode, id, rptKey, createTime, itemName, organ, subOrgan, type,
				initDate, updateDate, expireDate, content, awardCode, term);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

		
  
}
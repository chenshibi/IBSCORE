package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpPublicAward;
import resource.bean.basic.base.BaseTCorpPublicInfoDetail;
import resource.bean.basic.base.BaseTCorpPublicOweTax;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpPublicInfoDetail extends BaseTCorpPublicInfoDetail {

	public TCorpPublicInfoDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpPublicInfoDetail(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String sumYm,
			String monthFeePayable, String monthFeePaid, String payStatus,
			String owAmount) {
		super(hashCode, id, rptKey, createTime, itemName, sumYm, monthFeePayable,
				monthFeePaid, payStatus, owAmount);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	

		
  
}
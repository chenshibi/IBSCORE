package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailOthers;
import resource.bean.basic.base.BaseTCorpExtendedDetail;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpExtendedDetail extends BaseTCorpExtendedDetail {

	public TCorpExtendedDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpExtendedDetail(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String type, String startDate,
			String endDate, String extendedAmt, String extensionName) {
		super(hashCode, id, rptKey, createTime, itemName, type, startDate, endDate,
				extendedAmt, extensionName);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

		
  
}
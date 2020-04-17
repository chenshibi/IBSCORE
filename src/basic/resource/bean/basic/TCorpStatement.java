package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpPublicAward;
import resource.bean.basic.base.BaseTCorpPublicOweTax;
import resource.bean.basic.base.BaseTCorpStatement;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpStatement extends BaseTCorpStatement {

	public TCorpStatement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpStatement(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String organ, String content,
			String initDate, String updateDate) {
		super(hashCode, id, rptKey, createTime, itemName, organ, content, initDate,
				updateDate);
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	
	
	

		
  
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpApp;
import resource.bean.basic.base.BaseTCorpInfoRelevantCorp;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpInfoRelevantCorp extends BaseTCorpInfoRelevantCorp {

	public TCorpInfoRelevantCorp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpInfoRelevantCorp(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String loanCardNo, String relevant) {
		super(hashCode, id, rptKey, createTime, name, loanCardNo, relevant);
		// TODO Auto-generated constructor stub
	}

	
	
	

		
  
}
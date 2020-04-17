package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailAssureWindows;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpDetailAssureWindows extends BaseTCorpDetailAssureWindows {

	public TCorpDetailAssureWindows() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailAssureWindows(int hashCode, Integer id, String rptKey,
			Date createTime, String currency, Float amout, String releaseDate,
			String closeDate, String balance, String fiveLevel,
			String assureStatus, String mainBiz, String title) {
		super(hashCode, id, rptKey, createTime, currency, amout, releaseDate,
				closeDate, balance, fiveLevel, assureStatus, mainBiz, title);
		// TODO Auto-generated constructor stub
	}
	
	
	

	
	

	
	
	
	
	
	

		
  
}
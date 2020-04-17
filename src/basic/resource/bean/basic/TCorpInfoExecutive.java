package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoExecutive;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpInfoExecutive extends BaseTCorpInfoExecutive {

	public TCorpInfoExecutive() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpInfoExecutive(int hashCode, Integer id, String rptKey,
			Date createTime, String title, String name, String idType,
			String idNumber, String sex, String birthday) {
		super(hashCode, id, rptKey, createTime, title, name, idType, idNumber, sex,
				birthday);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

		
  
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpDetailAssure;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpDetailAssure extends BaseTCorpDetailAssure {

	public TCorpDetailAssure() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailAssure(int hashCode, Integer id, String rptKey,
			Date createTime, String type, String name, String idType,
			String idNumber, String currency, Float amount, String style,
			String mainBiz) {
		super(hashCode, id, rptKey, createTime, type, name, idType, idNumber, currency,
				amount, style, mainBiz);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

		
  
}
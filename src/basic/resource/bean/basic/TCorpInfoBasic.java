package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpInfoBasic;



/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpInfoBasic extends BaseTCorpInfoBasic {

	public TCorpInfoBasic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpInfoBasic(int hashCode, Integer id, String rptKey,
			Date createTime, String name, String address, String regOrganType,
			String loancardId, String regOrganNo, String regOrganCode,
			String regDate, String regEndDate, String regStateTaxNo,
			String regLocalTaxNo, String loanCardStatus, String lastAuditDate) {
		super(hashCode, id, rptKey, createTime, name, address, regOrganType,
				loancardId, regOrganNo, regOrganCode, regDate, regEndDate,
				regStateTaxNo, regLocalTaxNo, loanCardStatus, lastAuditDate);
		// TODO Auto-generated constructor stub
	}

	
	
	
	

		
  
}
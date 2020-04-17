package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndApp;
import resource.bean.basic.base.BaseTCorpLoancardInq;
import resource.bean.basic.base.BaseTCorpLoancardResp;

public class TCorpLoancardResp extends BaseTCorpLoancardResp {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5843330165995648380L;

	public TCorpLoancardResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpLoancardResp(Integer id, Integer inqId, String loancardno,
			String countryTaxCode, String orgCreditCode, String orgCode,
			String regionTaxCode, String registCodeType, String registCode,
			String engName, String chnName, String fullName, Date returnTime) {
		super(id, inqId, loancardno, countryTaxCode, orgCreditCode, orgCode,
				regionTaxCode, registCodeType, registCode, engName, chnName, fullName,
				returnTime);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	

	
	
    
}
package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpSocialPayRecord;






/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpSocialPayRecord extends BaseTCorpSocialPayRecord {

	public TCorpSocialPayRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpSocialPayRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String sumYm, String payAmt,
			String payStatus, String sumOwnAmt, String employeeNumber,
			String firstPayYm, String lastPayDate, String lastPayYm,
			String insuranceType, String insuredDate, String organ,
			String infotype, String highestOwnDate, String highestOwnAmt) {
		super(hashCode, id, rptKey, createTime, itemName, sumYm, payAmt, payStatus,
				sumOwnAmt, employeeNumber, firstPayYm, lastPayDate, lastPayYm,
				insuranceType, insuredDate, organ, infotype, highestOwnDate,
				highestOwnAmt);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

		
  
}
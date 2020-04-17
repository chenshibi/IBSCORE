package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpPunishRecord;





/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpPunishRecord extends BaseTCorpPunishRecord {

	public TCorpPunishRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpPunishRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String organ, String punishDocNo,
			String illegalAct, String punishDate, String punishDecision,
			String punishAmount, String punishSituation, String reviewResult) {
		super(hashCode, id, rptKey, createTime, itemName, organ, punishDocNo,
				illegalAct, punishDate, punishDecision, punishAmount, punishSituation,
				reviewResult);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	

		
  
}
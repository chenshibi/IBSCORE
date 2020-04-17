package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpHistoryRecord;




/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpHistoryRecord extends BaseTCorpHistoryRecord {

	public TCorpHistoryRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpHistoryRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String clearType,
			String createDate, String lastBalanceChgDate, String balance,
			String fiveLevel, String extensionName) {
		super(hashCode, id, rptKey, createTime, itemName, clearType, createDate,
				lastBalanceChgDate, balance, fiveLevel, extensionName);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

		
  
}
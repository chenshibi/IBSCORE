package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpJudgeRecord;






/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpJudgeRecord extends BaseTCorpJudgeRecord {

	public TCorpJudgeRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpJudgeRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String court, String judgeDate,
			String judgeReason, String judgeParty, String caseNo,
			String judgeProcess, String judgeObject, String objectValue,
			String caseCloseMode, String judgeEffDate, String judgeResult,
			String caseStatus, String executedObject, String executedObjectValue) {
		super(hashCode, id, rptKey, createTime, itemName, court, judgeDate,
				judgeReason, judgeParty, caseNo, judgeProcess, judgeObject,
				objectValue, caseCloseMode, judgeEffDate, judgeResult, caseStatus,
				executedObject, executedObjectValue);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	

		
  
}
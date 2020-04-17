package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpApp;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

@SuppressWarnings("serial")
public  class TCorpApp extends BaseTCorpApp {

	public TCorpApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpApp(int hashCode, Integer id, String rptKey, Date createTime,
			String loanCardNo, String loanCardPass, String queryReason,
		 String type, String status, String statusMsg,
			Date inputTime, Date returnTime, Date parsedTime, Integer batchId,
			String uploadedFilePath, Date queryTime) {
		super(hashCode, id, rptKey, createTime, loanCardNo, loanCardPass, queryReason,
				 type, status, statusMsg, inputTime, returnTime, parsedTime,
				batchId, uploadedFilePath, queryTime);
		// TODO Auto-generated constructor stub
	}

	
	

		
  
}
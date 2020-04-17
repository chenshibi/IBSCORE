package resource.bean.basic;

import java.io.Serializable;
import java.util.Date;

import resource.bean.basic.base.BaseTCorpApp;
import resource.bean.basic.base.BaseTCorpDetailApp;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_Detail_App"
 */

public class TCorpDetailApp extends BaseTCorpDetailApp {

	public TCorpDetailApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpDetailApp(int hashCode, Integer id, String rptKey, Date createTime, String loanCardNo,
			String loanCardPass, String queryReason, String type, String status, String statusMsg, Date inputTime,
			Date returnTime, Date parsedTime, Date queryTime) {
		super(hashCode, id, rptKey, createTime, loanCardNo, loanCardPass, queryReason, type, status, statusMsg, inputTime,
				returnTime, parsedTime, queryTime);
		// TODO Auto-generated constructor stub
	}

	

}
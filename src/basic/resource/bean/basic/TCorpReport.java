package resource.bean.basic;
import java.util.Date;

import resource.bean.basic.base.BaseTCorpReport;


public class TCorpReport extends BaseTCorpReport{


	/**
	 * 
	 */
	private static final long serialVersionUID = -1734004284989534657L;

	public TCorpReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCorpReport(int hashCode, String id, Date createTime,
			String reportCode, String organName, String organCreditCode,
			String loanCardNo, String queryReason, String queryReasonCode,
			String querier, String querierCode, String querierName,
			Date reportDate, String exchangeRate, String rptKey) {
		super(hashCode, id, createTime, reportCode, organName, organCreditCode,
				loanCardNo, queryReason, queryReasonCode, querier, querierCode,
				querierName, reportDate, exchangeRate, rptKey);
		// TODO Auto-generated constructor stub
	}

	

	
	
	
}
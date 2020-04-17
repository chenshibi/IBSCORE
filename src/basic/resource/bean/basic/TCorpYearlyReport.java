package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseTCorpYearlyReport;



/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_yearly_report"
 */

@SuppressWarnings("serial")
public  class TCorpYearlyReport extends BaseTCorpYearlyReport {
	
	
	public TCorpYearlyReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TCorpYearlyReport(int hashCode, Integer id, String rptKey,
			Date createTime, String rptKind, String rptSummaryType,
			String rptType, String rptYear) {
		super(hashCode, id, rptKey, createTime, rptKind, rptSummaryType, rptType,
				rptYear);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	

		
  
}
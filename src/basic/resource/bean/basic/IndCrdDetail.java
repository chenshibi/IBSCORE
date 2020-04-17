package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndAddr;
import resource.bean.basic.base.BaseIndCrdDetail;


public class IndCrdDetail extends BaseIndCrdDetail {
	

	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndCrdDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IndCrdDetail(Integer id, String rptId, Integer no, String cardType,
			String bizNo, String issuer, String assurance, String currency,
			Date dateofcreate, Float credit, Float share, Float maxDebit,
			Float overdue, String accStatus, Float payMonth, Float payReal,
			Date recentDate, Integer overCount, Float over180,
			Integer notpay12, Date getdate, String month24, Date yearmonth,
			Float overAmount, String orgType) {
		super(id, rptId, no, cardType, bizNo, issuer, assurance, currency,
				dateofcreate, credit, share, maxDebit, overdue, accStatus, payMonth,
				payReal, recentDate, overCount, over180, notpay12, getdate, month24,
				yearmonth, overAmount, orgType);
		// TODO Auto-generated constructor stub
	}

	
	

	

	
	
    
}
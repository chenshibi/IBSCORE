package resource.bean.basic;

import java.sql.Timestamp;
import java.util.Date;

import resource.bean.basic.base.BaseTCorpPermit;


public class TCorpPermit extends BaseTCorpPermit {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4357111689946644220L;

	/* [CONSTRUCTOR MARKER BEGIN] */
    public TCorpPermit() {
        super();
    }

	public TCorpPermit(int hashCode, Integer id, String loanCardNo,
			String loanCardPass, String enterpriseRegId, String corpName,
			String customerConUp, String customerConUp2, String createUser,
			Date inputTime, Timestamp expireDate, Date approveTime, String status) {
		super(hashCode, id, loanCardNo, loanCardPass, enterpriseRegId, corpName,
				customerConUp, customerConUp2, createUser, inputTime, expireDate,
				approveTime, status);
		// TODO Auto-generated constructor stub
	}

    
	

    

	
	
}
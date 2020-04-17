package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseIndPermit;

public class IndPermit extends BaseIndPermit {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1651027460405094490L;

	/**
	 * 
	 */

	/* [CONSTRUCTOR MARKER BEGIN] */
    public IndPermit() {
        super();
    }

	public IndPermit(int hashCode, Integer id, String individualId,
			String idType, String name, String customerConUp,
			String customerConUp2, String createUser, String status,
			Date inputTime, Date expireDate, Date approveTime) {
		super(hashCode, id, individualId, idType, name, customerConUp, customerConUp2,
				createUser, status, inputTime, expireDate, approveTime);
		// TODO Auto-generated constructor stub
	}
    
    
    /* [CONSTRUCTOR MARKER END] */

}
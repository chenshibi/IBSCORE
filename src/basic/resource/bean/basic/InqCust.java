package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseInqCust;

public class InqCust extends BaseInqCust{

	/**
	 * 
	 */
	private static final long serialVersionUID = 420769891799488626L;

	public InqCust() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public InqCust(int hashCode, Integer id, Integer inqCustAppid,
			String inqCustName, String inqCustId, String inqCustIdType,
			String inqCustType, String inqType, Integer custId, String relName,String relNamec,
			String relCustId, String relCustIdType, String relCorpId,
			Date createTime, String createUser, String queryReason,String queryReasonInd,
			String consentFilePath,String nonWorkhourFilepath,String confirmFlag,String createUserIp) {
		super(hashCode, id, inqCustAppid, inqCustName, inqCustId, inqCustIdType,
				inqCustType, inqType, custId, relName, relNamec,relCustId, relCustIdType,
				relCorpId, createTime, createUser, queryReason,queryReasonInd, consentFilePath,nonWorkhourFilepath,confirmFlag,createUserIp);
		// TODO Auto-generated constructor stub
	}

//	

	

	
	
}

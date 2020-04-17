package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseCorpCust;

public class CorpCust extends BaseCorpCust{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1647845942849748419L;

	public CorpCust() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CorpCust(Integer id, Integer corpCustAppid,
			Integer corpCustDetailId, String corpCustLoancard,
			String corpCustPswd, String corpCustCompanyname,
			String queryReason, String corpCustType, Integer custId,
			String relName, String relCustId, String relCustIdType,
			String relCorpId, Date createTime, String createUser,
			String consentFilePath, String inqType, String detailFlag,String nonWorkhourFilepath,String confirmFlag,String createUserIp,
			String serviceCode,String entCertType,String entCertNum) {
		super(id, corpCustAppid, corpCustDetailId, corpCustLoancard, corpCustPswd,
				corpCustCompanyname, queryReason, corpCustType, custId, relName,
				relCustId, relCustIdType, relCorpId, createTime, createUser,
				consentFilePath, inqType, detailFlag,nonWorkhourFilepath,confirmFlag,createUserIp,serviceCode,entCertType,entCertNum);
		// TODO Auto-generated constructor stub
	}

	

	
	

}

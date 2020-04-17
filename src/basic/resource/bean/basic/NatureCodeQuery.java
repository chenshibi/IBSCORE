package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseNatureCodeQuery;

public class NatureCodeQuery extends BaseNatureCodeQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066692066672817646L;
	public NatureCodeQuery(){
		super();
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public NatureCodeQuery(int hashCode, Integer id, String rptKey,
			String chineseName, String englistName, String orgCreditCode,
			String orgCode, String loancardNo, String registType,
			String registCode, String countryTaxCode, String regionTaxCode,
			String address, String contactAddress, String contactNo,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String astatus, String status, Integer appId,
			String type, String inputUser, Date queryTime, Date parseTime,
			String inputUserIp, String idNo, String idType, String assureName) {
		super(hashCode, id, rptKey, chineseName, englistName, orgCreditCode, orgCode,
				loancardNo, registType, registCode, countryTaxCode, regionTaxCode,
				address, contactAddress, contactNo, batchId, name, individualIdType,
				individualId, createUser, inputTime, returnTime, astatus, status,
				appId, type, inputUser, queryTime, parseTime, inputUserIp, idNo,
				idType, assureName);
		// TODO Auto-generated constructor stub
	}
	 
 
	 

}

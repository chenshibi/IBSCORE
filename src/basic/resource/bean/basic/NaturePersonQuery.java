package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseNatureCodeQuery;
import resource.bean.basic.base.BaseNaturePersonQuery;

public class NaturePersonQuery extends BaseNaturePersonQuery {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2066692066672817646L;
	public NaturePersonQuery(){
		super();
	}
	public NaturePersonQuery(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String status, String astatus, Integer appId,
			String type, String inputUser, Date queryTime, Date parseTime,
			String consentFilePath, String inputUserIp,
			String nonConsentFilePath) {
		super(hashCode, id, rptKey, batchId, name, individualIdType, individualId,
				createUser, inputTime, returnTime, status, astatus, appId, type,
				inputUser, queryTime, parseTime, consentFilePath, inputUserIp,
				nonConsentFilePath);
		// TODO Auto-generated constructor stub
	}
 
	 

}

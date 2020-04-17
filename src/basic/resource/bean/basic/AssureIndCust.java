package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseAssureIndCust;

public class AssureIndCust extends BaseAssureIndCust {
	

	private static final long serialVersionUID = 4971254232078244865L;
	public AssureIndCust() {
		
	}
	
	public AssureIndCust(int hashCode, Integer id, String appId,
			String individualId, String individualIdType, String name,
			String inputUser, Date inputTime, String consentFilePath,
			String inputUserIp, String nonConsentFilePath, String rsv1,
			String rsv2, String rsv3, String rsv4, String rsv5, String rsv6,
			String rsv7, String rsv8) {
		super(hashCode, id, appId, individualId, individualIdType, name,
				inputUser, inputTime, consentFilePath, inputUserIp,
				nonConsentFilePath, rsv1, rsv2, rsv3, rsv4, rsv5, rsv6, rsv7,
				rsv8);
	}

}

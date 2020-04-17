package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseAssureIndApp;

public class AssureIndApp extends BaseAssureIndApp {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5141105198211679305L;

	public AssureIndApp() {
	}

	public AssureIndApp(int hashCode, Integer id, String rptKey,
			String individualId, String individualIdType,String type, String name,
			String inputUser, Date inputTime, Date queryTime, Date returnTime,
			Date parseTime, String status, String consentFilePath,
			String inputUserIp, String nonConsentFilePath) {
		super(hashCode, id, rptKey, individualId, individualIdType, type,name, inputUser,
				inputTime, queryTime, returnTime, parseTime, status, consentFilePath,
				inputUserIp, nonConsentFilePath);
	}

}

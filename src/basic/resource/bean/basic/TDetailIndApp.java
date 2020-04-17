package resource.bean.basic;

import java.sql.Timestamp;
import java.util.Date;

import resource.bean.basic.base.BaseTDetailIndApp;

public class TDetailIndApp extends BaseTDetailIndApp {

	private static final long serialVersionUID = 777033957713529313L;

	public TDetailIndApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TDetailIndApp(int hashCode, Integer id, String rptKey,
			String individualId, String individualIdType, String name,String type,
			String inputUser, Timestamp inputTime, Timestamp queryTime, Timestamp returnTime,
			Timestamp parseTime, String status, String inputUserIp) {
		super(hashCode, id, rptKey, individualId, individualIdType, name,type, inputUser,
				inputTime, queryTime, returnTime, parseTime, status, inputUserIp);
		// TODO Auto-generated constructor stub
	}
	
}

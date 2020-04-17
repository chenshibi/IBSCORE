package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseAssureBatchInfo;

public class AssureBatchInfo extends BaseAssureBatchInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6068074391874528798L;

	public AssureBatchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssureBatchInfo(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String status, Integer appId) {
		super(hashCode, id, rptKey, batchId, name, individualIdType, individualId,
				createUser, inputTime, returnTime, status, appId);
		// TODO Auto-generated constructor stub
	}

}

package resource.bean.basic;

import java.util.Date;

import resource.bean.basic.base.BaseNaturalCodeBatchInfo;

public class NaturalCodeBatchInfo extends BaseNaturalCodeBatchInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3978831385991966322L;

	public NaturalCodeBatchInfo() {
		// TODO Auto-generated constructor stub
	}

	public NaturalCodeBatchInfo(int hashCode, Integer id, String rptKey,
			Integer batchId, String name, String individualIdType,
			String individualId, String createUser, Date inputTime,
			Date returnTime, String status, Integer appId) {
		super(hashCode, id, rptKey, batchId, name, individualIdType,
				individualId, createUser, inputTime, returnTime, status, appId);
		// TODO Auto-generated constructor stub
	}

}

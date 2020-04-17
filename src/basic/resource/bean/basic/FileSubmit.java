package resource.bean.basic;

import resource.bean.basic.base.BaseFileSubmit;

public class FileSubmit extends BaseFileSubmit {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1651027460405094490L;

	/**
	 * 
	 */

	/* [CONSTRUCTOR MARKER BEGIN] */
    public FileSubmit() {
        super();
    }

	public FileSubmit(int hashCode, Integer id, String fileName,
			String filePath, String createUser, String status,
			String inputTime, String sgement, String product, String scope,
			String note, String effectiveDate, String expireDate, String flag,String department) {
		super(hashCode, id, fileName, filePath, createUser, status, inputTime, sgement,
				product, scope, note, effectiveDate, expireDate, flag,department);
		// TODO Auto-generated constructor stub
	}

 
	 
    
    /* [CONSTRUCTOR MARKER END] */

}
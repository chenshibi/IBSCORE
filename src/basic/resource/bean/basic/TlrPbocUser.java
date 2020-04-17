package resource.bean.basic;

import resource.bean.basic.base.BaseTlrPbocUser;

public class TlrPbocUser extends BaseTlrPbocUser{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TlrPbocUser(){
			
		}

		public TlrPbocUser(Integer id, String userNo, String userPswdNow,
				String userPswdOld, String userType, String statusPswd,
				String lastUpdateTime, String updateTlrInfo) {
			super(id, userNo, userPswdNow, userPswdOld, userType, statusPswd,
					lastUpdateTime, updateTlrInfo);
			// TODO Auto-generated constructor stub
		}
	
}

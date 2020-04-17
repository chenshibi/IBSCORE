package resource.bean.basic.base;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class BaseTlrPbocUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 public static String ID="id";
	 public static String USER_NO="userNo";
	 public static String USER_PSWD_NOW="userPswdNow";
	 public static String USER_PSWD_OLD="userPswdOld";
	 public static String USER_TYPE="userType";
	 public static String STATUS_PSWD="statusPswd";
	 public static String LAST_UPDATE_TIME="lastUpdateTime";
	 public static String UPDATE_TLR_INFO="updateTlrInfo";
	 
	
	 private java.lang.Integer id;
	 private java.lang.String userNo;
	 private java.lang.String userPswdNow;
	 private java.lang.String userPswdOld;
	 private java.lang.String userType;
	 private java.lang.String statusPswd;
	 private java.lang.String lastUpdateTime;
	 private java.lang.String updateTlrInfo;
	 
	 
	 
	 public BaseTlrPbocUser(){
		 super();
	 }



	public BaseTlrPbocUser(Integer id, String userNo, String userPswdNow,
			String userPswdOld, String userType, String statusPswd,
			String lastUpdateTime, String updateTlrInfo) {
		super();
		this.id = id;
		this.userNo = userNo;
		this.userPswdNow = userPswdNow;
		this.userPswdOld = userPswdOld;
		this.userType = userType;
		this.statusPswd = statusPswd;
		this.lastUpdateTime = lastUpdateTime;
		this.updateTlrInfo = updateTlrInfo;
	}



	public static String getID() {
		return ID;
	}



	public static void setID(String iD) {
		ID = iD;
	}



	public static String getUSER_NO() {
		return USER_NO;
	}



	public static void setUSER_NO(String uSER_NO) {
		USER_NO = uSER_NO;
	}



	public static String getUSER_PSWD_NOW() {
		return USER_PSWD_NOW;
	}



	public static void setUSER_PSWD_NOW(String uSER_PSWD_NOW) {
		USER_PSWD_NOW = uSER_PSWD_NOW;
	}



	public static String getUSER_PSWD_OLD() {
		return USER_PSWD_OLD;
	}



	public static void setUSER_PSWD_OLD(String uSER_PSWD_OLD) {
		USER_PSWD_OLD = uSER_PSWD_OLD;
	}



	public static String getUSER_TYPE() {
		return USER_TYPE;
	}



	public static void setUSER_TYPE(String uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}



	public static String getSTATUS_PSWD() {
		return STATUS_PSWD;
	}



	public static void setSTATUS_PSWD(String sTATUS_PSWD) {
		STATUS_PSWD = sTATUS_PSWD;
	}



	public static String getLAST_UPDATE_TIME() {
		return LAST_UPDATE_TIME;
	}



	public static void setLAST_UPDATE_TIME(String lAST_UPDATE_TIME) {
		LAST_UPDATE_TIME = lAST_UPDATE_TIME;
	}



	public static String getUPDATE_TLR_INFO() {
		return UPDATE_TLR_INFO;
	}



	public static void setUPDATE_TLR_INFO(String uPDATE_TLR_INFO) {
		UPDATE_TLR_INFO = uPDATE_TLR_INFO;
	}



	public java.lang.Integer getId() {
		return id;
	}



	public void setId(java.lang.Integer id) {
		this.id = id;
	}



	public java.lang.String getUserNo() {
		return userNo;
	}



	public void setUserNo(java.lang.String userNo) {
		this.userNo = userNo;
	}



	public java.lang.String getUserPswdNow() {
		return userPswdNow;
	}



	public void setUserPswdNow(java.lang.String userPswdNow) {
		this.userPswdNow = userPswdNow;
	}



	public java.lang.String getUserPswdOld() {
		return userPswdOld;
	}



	public void setUserPswdOld(java.lang.String userPswdOld) {
		this.userPswdOld = userPswdOld;
	}



	public java.lang.String getUserType() {
		return userType;
	}



	public void setUserType(java.lang.String userType) {
		this.userType = userType;
	}



	public java.lang.String getStatusPswd() {
		return statusPswd;
	}



	public void setStatusPswd(java.lang.String statusPswd) {
		this.statusPswd = statusPswd;
	}



	public java.lang.String getLastUpdateTime() {
		return lastUpdateTime;
	}



	public void setLastUpdateTime(java.lang.String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}



	public java.lang.String getUpdateTlrInfo() {
		return updateTlrInfo;
	}



	public void setUpdateTlrInfo(java.lang.String updateTlrInfo) {
		this.updateTlrInfo = updateTlrInfo;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastUpdateTime == null) ? 0 : lastUpdateTime.hashCode());
		result = prime * result
				+ ((statusPswd == null) ? 0 : statusPswd.hashCode());
		result = prime * result
				+ ((updateTlrInfo == null) ? 0 : updateTlrInfo.hashCode());
		result = prime * result + ((userNo == null) ? 0 : userNo.hashCode());
		result = prime * result
				+ ((userPswdOld == null) ? 0 : userPswdOld.hashCode());
		result = prime * result
				+ ((userPswdNow == null) ? 0 : userPswdNow.hashCode());
		result = prime * result
				+ ((userType == null) ? 0 : userType.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseTlrPbocUser other = (BaseTlrPbocUser) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastUpdateTime == null) {
			if (other.lastUpdateTime != null)
				return false;
		} else if (!lastUpdateTime.equals(other.lastUpdateTime))
			return false;
		if (statusPswd == null) {
			if (other.statusPswd != null)
				return false;
		} else if (!statusPswd.equals(other.statusPswd))
			return false;
		if (updateTlrInfo == null) {
			if (other.updateTlrInfo != null)
				return false;
		} else if (!updateTlrInfo.equals(other.updateTlrInfo))
			return false;
		if (userNo == null) {
			if (other.userNo != null)
				return false;
		} else if (!userNo.equals(other.userNo))
			return false;
		if (userPswdOld == null) {
			if (other.userPswdOld != null)
				return false;
		} else if (!userPswdOld.equals(other.userPswdOld))
			return false;
		if (userPswdNow == null) {
			if (other.userPswdNow != null)
				return false;
		} else if (!userPswdNow.equals(other.userPswdNow))
			return false;
		if (userType == null) {
			if (other.userType != null)
				return false;
		} else if (!userType.equals(other.userType))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "BaseTlrPbocUser [id=" + id + ", userNo=" + userNo
				+ ", userPswdNow=" + userPswdNow + ", userPswdOld="
				+ userPswdOld + ", userType=" + userType + ", statusPswd="
				+ statusPswd + ", lastUpdateTime=" + lastUpdateTime
				+ ", updateTlrInfo=" + updateTlrInfo + "]";
	}
	  
	 
}

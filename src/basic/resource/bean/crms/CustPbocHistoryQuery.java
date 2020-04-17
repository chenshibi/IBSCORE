package resource.bean.crms;

public class CustPbocHistoryQuery {
	String id;
	String entName;
	String entCertType;
	String entCertNum;
	String status;
	String queryDate;
	String isLock;
	String queryReason;
	String userId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntCertType() {
		return entCertType;
	}
	public void setEntCertType(String entCertType) {
		this.entCertType = entCertType;
	}
	public String getEntCertNum() {
		return entCertNum;
	}
	public void setEntCertNum(String entCertNum) {
		this.entCertNum = entCertNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}
	public String getIsLock() {
		return isLock;
	}
	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
	@Override
	public String toString() {
		return "CustPbocHistoryQuery [id=" + id + ", entName=" + entName + ", entCertType=" + entCertType
				+ ", entCertNum=" + entCertNum + ", status=" + status + ", queryDate=" + queryDate + ", isLock="
				+ isLock + ", queryReason=" + queryReason + "]";
	}
	
}

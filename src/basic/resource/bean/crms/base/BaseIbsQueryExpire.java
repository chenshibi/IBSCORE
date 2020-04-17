package resource.bean.crms.base;

import java.io.Serializable;
import java.util.Date;

public class BaseIbsQueryExpire implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCentralCode() {
		return centralCode;
	}

	public void setCentralCode(String centralCode) {
		this.centralCode = centralCode;
	}

	public String getClientLeId() {
		return clientLeId;
	}

	public void setClientLeId(String clientLeId) {
		this.clientLeId = clientLeId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getRsv1() {
		return rsv1;
	}

	public void setRsv1(String rsv1) {
		this.rsv1 = rsv1;
	}

	public String getRsv2() {
		return rsv2;
	}

	public void setRsv2(String rsv2) {
		this.rsv2 = rsv2;
	}

	public String getRsv3() {
		return rsv3;
	}

	public void setRsv3(String rsv3) {
		this.rsv3 = rsv3;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String userName;
	
	private String centralCode;
	
	private String clientLeId;
	
	private String customerName;
	
	private Date updateTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	private Date expireTime;
	
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String rsv1;
	
	private String rsv2;
	
	private String rsv3;
}

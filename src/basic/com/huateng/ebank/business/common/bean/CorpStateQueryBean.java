package com.huateng.ebank.business.common.bean;
/** 
* @author Grassy 
* @version 创建时间：2020年1月30日 下午3:34:10 
* 类说明 
*/
public class CorpStateQueryBean {
 private String rsv2;
public String getRsv2() {
	return rsv2;
}
public void setRsv2(String rsv2) {
	this.rsv2 = rsv2;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getCreateUser() {
	return createUser;
}
public void setCreateUser(String createUser) {
	this.createUser = createUser;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
 private String createTime;
 private String createUser;
 private String status;
 private Integer successNum;
 private Integer totalNum;
 private Integer emptyNum;
 private Integer completedNum;
 public Integer getCompletedNum() {
	return completedNum;
}
public void setCompletedNum(Integer completedNum) {
	this.completedNum = completedNum;
}
public Integer getEmptyNum() {
	return emptyNum;
}
public void setEmptyNum(Integer emptyNum) {
	this.emptyNum = emptyNum;
}
public Integer getTotalNum() {
	return totalNum;
}
public void setTotalNum(Integer totalNum) {
	this.totalNum = totalNum;
}
public Integer getSuccessNum() {
	return successNum;
}
public void setSuccessNum(Integer successNum) {
	this.successNum = successNum;
}
public Integer getFailNum() {
	return failNum;
}
public void setFailNum(Integer failNum) {
	this.failNum = failNum;
}
private Integer failNum;
}

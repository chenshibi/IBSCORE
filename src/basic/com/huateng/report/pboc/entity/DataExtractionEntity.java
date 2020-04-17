package com.huateng.report.pboc.entity;

public class DataExtractionEntity {
 private String city;
 public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
private String department;

private String id;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}

private String trlNo;
public String getTrlNo() {
	return trlNo;
}
public void setTrlNo(String trlNo) {
	this.trlNo = trlNo;
}

private String queryDate;
public String getQueryDate() {
	return queryDate;
}
public void setQueryDate(String queryDate) {
	this.queryDate = queryDate;
}

private String queryMonth;
public String getQueryMonth() {
	return queryMonth;
}
public void setQueryMonth(String queryMonth) {
	this.queryMonth = queryMonth;
}

}

package com.huateng.ebank.business.common.bean;
/** 
* @author Grassy 
* @version 创建时间：2020年1月22日 下午11:54:38 
* 类说明 
*/
public class IndEnquiryBean {
  private String rptId;
  public String getRptId() {
	return rptId;
}
public void setRptId(String rptId) {
	this.rptId = rptId;
}
public String getEyear() {
	return eyear;
}
public void setEyear(String eyear) {
	this.eyear = eyear;
}
public String getEmonth() {
	return emonth;
}
public void setEmonth(String emonth) {
	this.emonth = emonth;
}
private String eyear;
  private String emonth;
}

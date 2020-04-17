package com.huateng.ebank.business.common.bean;
/** 
* @author Grassy 
* @version 创建时间：2020年1月23日 上午1:35:58 
* 类说明 
*/
public class OverCreditBean {
	private String overdue;
	public String getOverdue() {
		return overdue;
	}
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	private String credit;

}

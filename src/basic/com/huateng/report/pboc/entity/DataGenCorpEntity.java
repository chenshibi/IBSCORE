package com.huateng.report.pboc.entity;
/** 
* @author Grassy 
* @version 创建时间：2020年2月22日 下午8:31:53 
* 类说明 
*/
public class DataGenCorpEntity {
	private String rptKey;
	public String getRptKey() {
		return rptKey;
	}
	public void setRptKey(String rptKey) {
		this.rptKey = rptKey;
	}
	public String getCorpCustId() {
		return corpCustId;
	}
	public void setCorpCustId(String corpCustId) {
		this.corpCustId = corpCustId;
	}
	public String getDetailrptKey() {
		return detailrptKey;
	}
	public void setDetailrptKey(String detailrptKey) {
		this.detailrptKey = detailrptKey;
	}
	private String corpCustId;
	private String detailrptKey;

}

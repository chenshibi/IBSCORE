package com.huateng.htaml.reportForm.util;

import com.huateng.common.DateUtil;

public class DoubtReportFormBean {
	private String transType;//指令类型
	private String featureCode;//事件特征码
	private String sendTime;//发送时间
	private String recordUpdTlr;//maker
	private String lstUpdTlr;//checker
	private String applicationId;//业务申请编号
	private String cardNumber;//卡\折号
	private String idType;//证件类型
	private String idNumber;//证件号
	private String accountName;//账户名\姓名
	private String PBOCcode;//PBOC返回码
	private String PBOCdescription;//PBOC返回消息
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getFeatureCode() {
		return featureCode;
	}
	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		if(sendTime != null){
			this.sendTime = DateUtil.get19Date(sendTime);
		}else{
			this.sendTime ="";
		}
	}
	public String getRecordUpdTlr() {
		return recordUpdTlr;
	}
	public void setRecordUpdTlr(String recordUpdTlr) {
		if(recordUpdTlr != null){
			this.recordUpdTlr = recordUpdTlr;
		}else{
			this.recordUpdTlr="";
		}
	}
	public String getLstUpdTlr() {
		return lstUpdTlr;
	}
	public void setLstUpdTlr(String lstUpdTlr) {
		this.lstUpdTlr = lstUpdTlr;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getPBOCcode() {
		return PBOCcode;
	}
	public void setPBOCcode(String pBOCcode) {
		if("100000".equals(pBOCcode)){
			this.PBOCcode = "100000-成功";
		}else{
			this.PBOCcode = pBOCcode;
		}
	}
	public String getPBOCdescription() {
		return PBOCdescription;
	}
	public void setPBOCdescription(String pBOCdescription) {
		this.PBOCdescription = pBOCdescription;
	}
	

}

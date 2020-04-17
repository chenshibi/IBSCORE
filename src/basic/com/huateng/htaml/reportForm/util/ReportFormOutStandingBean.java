package com.huateng.htaml.reportForm.util;

import com.huateng.common.DateUtil;

public class ReportFormOutStandingBean {
	private String transType;//指令类型
	private String caseNumber;//案件编号
	private String createTime;//接收时间
	private String sendStatus;//发送状态
	private String approveStatus;//审核状态
	private String lstUpdTm;//最后修改时间
	private String recordUpdTlr;//maker
	private String lstUpdTlr;//checker
	private String sendTime;//反馈时间
	private String result;//反馈结果
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		if(createTime != null){
			this.createTime = DateUtil.get19Date(createTime);
		}else{
			this.createTime ="";
		}
	}
	public String getSendStatus() {
		return sendStatus;
	}
	public void setSendStatus(String sendStatus) {
		if(DxzpConstants.REPORT_RECSTATUS_00.equals(sendStatus)){
			this.sendStatus="00-已接收/已录入";
		}else if(DxzpConstants.REPORT_RECSTATUS_01.equals(sendStatus)){
			this.sendStatus="01-待反馈/待发送";
		}else if(DxzpConstants.REPORT_RECSTATUS_02.equals(sendStatus)){
			this.sendStatus="02-反馈成功/发送成功";
		}else if(DxzpConstants.REPORT_RECSTATUS_03.equals(sendStatus)){
			this.sendStatus="03-反馈错误/发送错误";
		}else{
			this.sendStatus="";
		}
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		if(DxzpConstants.REPORT_APPROVESTATUS_00.equals(approveStatus)){
			this.approveStatus="00-未提交";
		}else if(DxzpConstants.REPORT_APPROVESTATUS_01.equals(approveStatus)){
			this.approveStatus="01-提交待审核";
		}else if(DxzpConstants.REPORT_APPROVESTATUS_02.equals(approveStatus)){
			this.approveStatus="02-审核通过";
		}else if(DxzpConstants.REPORT_APPROVESTATUS_03.equals(approveStatus)){
			this.approveStatus="03-审核不通过";
		}else{
			this.approveStatus="";
		}
	}
	public String getLstUpdTm() {
		return lstUpdTm;
	}
	public void setLstUpdTm(String lstUpdTm) {
		if(lstUpdTm != null){
			this.lstUpdTm = DateUtil.get19Date(lstUpdTm);
		}else{
			this.lstUpdTm ="";
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}

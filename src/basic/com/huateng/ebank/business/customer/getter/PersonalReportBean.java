package com.huateng.ebank.business.customer.getter;

import java.util.Date;

public class PersonalReportBean {
	private String rptId;
	private String MyQuery;
	private Integer inqCustAppid;
	private String name;
	private String individualId;
	private String idType;
	private String queryReason;
	private String inqCustType;
	private String createTime;
	private String createUser;
	private String consentFilePath;
	private String consentFilePath2;
	private String nonWorkhourFilepath;
	private String returnTime;
	private String status;
	private String relName;
	private String relCorpId;
	private String inqType;
	private String funcid1;
	private String funcid2;
	private String funcid3;
	private String funcid4;
	private String funcid5;
	private Integer id;
	
	public String getConsentFilePath2() {
		return consentFilePath2;
	}
	public void setConsentFilePath2(String consentFilePath2) {
		this.consentFilePath2 = consentFilePath2;
	}
	public String getRptId() {
		return rptId;
	}
	public void setRptId(String rptId) {
		this.rptId = rptId;
	}
	public Integer getInqCustAppid() {
		return inqCustAppid;
	}
	public void setInqCustAppid(Integer inqCustAppid) {
		this.inqCustAppid = inqCustAppid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIndividualId() {
		return individualId;
	}
	public void setIndividualId(String individualId) {
		this.individualId = individualId;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getInqCustType() {
		return inqCustType;
	}
	public void setInqCustType(String inqCustType) {
		if("1".equals(inqCustType)){
			this.inqCustType = "1-担保人";
		}
		else if("2".equals(inqCustType)){
			this.inqCustType = "2-主借款人";
		}
		else if("3".equals(inqCustType)){
			this.inqCustType = "3-共同借款人";
		}
		else{
			this.inqCustType = "";
		}
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
	public String getConsentFilePath() {
		return consentFilePath;
	}
	public void setConsentFilePath(String consentFilePath) {
		this.consentFilePath = consentFilePath;
	}
	public String getNonWorkhourFilepath() {
		return nonWorkhourFilepath;
	}
	public void setNonWorkhourFilepath(String nonWorkhourFilepath) {
		this.nonWorkhourFilepath = nonWorkhourFilepath;
	}
	public String getInqType() {
		return inqType;
	}
	public void setInqType(String inqType) {
		if("0".equals(inqType)){
			this.inqType = "0-batch";
		}
		else if("1".equals(inqType)){
			this.inqType = "1-单笔";
		}
		else if("2".equals(inqType)){
			this.inqType = "2-紧急";
		}
		else{
			this.inqType = "4-行内接口";
		}
	}
	public String getFuncid1() {
		return funcid1;
	}
	public void setFuncid1(String funcid1) {
		this.funcid1 = funcid1;
	}
	public String getFuncid2() {
		return funcid2;
	}
	public void setFuncid2(String funcid2) {
		this.funcid2 = funcid2;
	}
	public String getFuncid3() {
		return funcid3;
	}
	public void setFuncid3(String funcid3) {
		this.funcid3 = funcid3;
	}
	public String getFuncid4() {
		return funcid4;
	}
	public void setFuncid4(String funcid4) {
		this.funcid4 = funcid4;
	}
	public String getFuncid5() {
		return funcid5;
	}
	public void setFuncid5(String funcid5) {
		this.funcid5 = funcid5;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
			this.status = status;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	public String getRelCorpId() {
		return relCorpId;
	}
	public void setRelCorpId(String relCorpId) {
		this.relCorpId = relCorpId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMyQuery() {
		return MyQuery;
	}
	public void setMyQuery(String myQuery) {
		MyQuery = myQuery;
	}
	
}

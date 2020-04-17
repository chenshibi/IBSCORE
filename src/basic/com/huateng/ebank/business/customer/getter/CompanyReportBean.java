package com.huateng.ebank.business.customer.getter;

public class CompanyReportBean {
	private String corpCustLoancard;
	private String corpCustCompanyname;
	private String MyQuery;
	private String queryReason;
	private String corpCustType;
	private String relName;
	private String relCorpId;
	private String createTime;
	private String createUser;
	private String consentFilePath;
	private String consentFilePath2;
	private String nonWorkhourFilepath;
	private String detailFlag;
	private String ccreturnTime;
	private String tcdareturnTime;
	private String rptKey;
	private String detailrptKey;
	private Integer id;
	private String status;
	private String detailstatus;
	private String entCertType;
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
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	private String entCertNum;
	private String serviceCode;
	private String funcid1;
	private String funcid2;
	private String funcid3;
	private String funcid4;
	private String funcid5;
	private String funcid6;
	private String funcid7;
	private String funcid8;
	private String funcid10;
	private String funcid11;
	private String funcid12;
	private String funcid13;
	private String funcid14;
	private String funcid15;
	public String getCorpCustLoancard() {
		return corpCustLoancard;
	}
	public void setCorpCustLoancard(String corpCustLoancard) {
		this.corpCustLoancard = corpCustLoancard;
	}
	public String getCorpCustCompanyname() {
		return corpCustCompanyname;
	}
	public void setCorpCustCompanyname(String corpCustCompanyname) {
		this.corpCustCompanyname = corpCustCompanyname;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getCorpCustType() {
		return corpCustType;
	}
	public void setCorpCustType(String corpCustType) {
		if("1".equals(corpCustType)){
			this.corpCustType = "1-借款公司";
		}
		else if("2".equals(corpCustType)){
			this.corpCustType="2-担保公司";
		}
		else{
			this.corpCustType = "";
		}
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
	public String getDetailFlag() {
		return detailFlag;
	}
	public void setDetailFlag(String detailFlag) {
		if("1".equals(detailFlag)){
			this.detailFlag = "1-要详细";
		}
		else if("2".equals(detailFlag)){
			this.detailFlag="2-不要详细";
		}
		else{
			this.detailFlag = "";
		}
	}
	public String getCcreturnTime() {
		return ccreturnTime;
	}
	public void setCcreturnTime(String ccreturnTime) {
		this.ccreturnTime = ccreturnTime;
	}
	public String getTcdareturnTime() {
		return tcdareturnTime;
	}
	public void setTcdareturnTime(String tcdareturnTime) {
		this.tcdareturnTime = tcdareturnTime;
	}
	public String getRptKey() {
		return rptKey;
	}
	public void setRptKey(String rptKey) {
		this.rptKey = rptKey;
	}
	public java.lang.String getFuncid1() {
		return funcid1;
	}
	public void setFuncid1(java.lang.String funcid1) {
		this.funcid1 = funcid1;
	}
	public java.lang.String getFuncid2() {
		return funcid2;
	}
	public void setFuncid2(java.lang.String funcid2) {
		this.funcid2 = funcid2;
	}
	public java.lang.String getFuncid3() {
		return funcid3;
	}
	public void setFuncid3(java.lang.String funcid3) {
		this.funcid3 = funcid3;
	}
	public java.lang.String getFuncid4() {
		return funcid4;
	}
	public void setFuncid4(java.lang.String funcid4) {
		this.funcid4 = funcid4;
	}
	public java.lang.String getFuncid5() {
		return funcid5;
	}
	public void setFuncid5(java.lang.String funcid5) {
		this.funcid5 = funcid5;
	}
	public java.lang.String getFuncid6() {
		return funcid6;
	}
	public void setFuncid6(java.lang.String funcid6) {
		this.funcid6 = funcid6;
	}
	public java.lang.String getFuncid7() {
		return funcid7;
	}
	public void setFuncid7(java.lang.String funcid7) {
		this.funcid7 = funcid7;
	}
	public java.lang.String getFuncid8() {
		return funcid8;
	}
	public void setFuncid8(java.lang.String funcid8) {
		this.funcid8 = funcid8;
	}
	public String getFuncid10() {
		return funcid10;
	}
	public void setFuncid10(String funcid10) {
		this.funcid10 = funcid10;
	}
	public String getFuncid11() {
		return funcid11;
	}
	public void setFuncid11(String funcid11) {
		this.funcid11 = funcid11;
	}
	public String getFuncid12() {
		return funcid12;
	}
	public void setFuncid12(String funcid12) {
		this.funcid12 = funcid12;
	}
	public String getFuncid13() {
		return funcid13;
	}
	public void setFuncid13(String funcid13) {
		this.funcid13 = funcid13;
	}
	
	public String getFuncid14() {
		return funcid14;
	}
	public void setFuncid14(String funcid14) {
		this.funcid14 = funcid14;
	}
	
	public String getFuncid15() {
		return funcid15;
	}
	public void setFuncid15(String funcid15) {
		this.funcid15 = funcid15;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDetailstatus() {
		return detailstatus;
	}
	public void setDetailstatus(String detailstatus) {
		this.detailstatus = detailstatus;
	}
	public String getDetailrptKey() {
		return detailrptKey;
	}
	public void setDetailrptKey(String detailrptKey) {
		this.detailrptKey = detailrptKey;
	}
	public String getConsentFilePath2() {
		return consentFilePath2;
	}
	public void setConsentFilePath2(String consentFilePath2) {
		this.consentFilePath2 = consentFilePath2;
	}
	public String getMyQuery() {
		return MyQuery;
	}
	public void setMyQuery(String myQuery) {
		MyQuery = myQuery;
	}
	
}

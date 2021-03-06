package com.huateng.report.pboc.entity;

public class PerStatisticsReportEntity {
	
	private String queryOrgCode; //查询机构代码
	
	public String getQueryOrgCode() {
		return queryOrgCode;
	}

	public void setQueryOrgCode(String queryOrgCode) {
		this.queryOrgCode = queryOrgCode;
	}

	public String getQueryOrgName() {
		return queryOrgName;
	}

	public void setQueryOrgName(String queryOrgName) {
		this.queryOrgName = queryOrgName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIndPermitId() {
		return indPermitId;
	}

	public void setIndPermitId(String indPermitId) {
		this.indPermitId = indPermitId;
	}

	public String getUseScan() {
		return useScan;
	}

	public void setUseScan(String useScan) {
		this.useScan = useScan;
	}

	private String queryOrgName; //查询机构名称
	
	private String userCode;   //查询用户代码
	
	private String userName;   //查询用户姓名
	
    private String name;     //客户姓名
    
    private String idType;  //证件类型
    
    private String idNum;  // 证件号码
    
    private String queryReason; //查询原因
    
    private String serviceCode; //服务代码
    
    private String queryDate;  //查询日期
    
    private String status;  //记录状态
    
    private String ip;   //查询人IP地址
    
    private String indPermitId;  //客户授权书编码
    
    private String useScan;   //应用场景
    
    private String branch ;   //部门
    
    private String operatorId; //查询操作员ID
    
    private String createTime; //用户录入时间
    
    private String returnTime; //一般报告返回时间
    
    private String sendTime; //一般报告查询时间
    
    private String cdappQueryTime;//明细报告的查询时间
    
    private String cdappReturnTime;//明细报告的返回时间

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getCdappQueryTime() {
		return cdappQueryTime;
	}

	public void setCdappQueryTime(String cdappQueryTime) {
		this.cdappQueryTime = cdappQueryTime;
	}

	public String getCdappReturnTime() {
		return cdappReturnTime;
	}

	public void setCdappReturnTime(String cdappReturnTime) {
		this.cdappReturnTime = cdappReturnTime;
	}
	
	

}

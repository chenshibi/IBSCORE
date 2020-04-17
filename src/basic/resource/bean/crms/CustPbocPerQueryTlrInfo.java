package resource.bean.crms;

public class CustPbocPerQueryTlrInfo {
	/*
	//CustPbocPerQuery
	private String id;
	private String name;
	private String idType;
	private String idNum;
	private String queryReason;
	private String serviceCode;
	private String respId;
	private String queryDate;
	private String createUser;
	private String createTime;
	private String checkUser;
	private String checkTime;
	private String sendTime;
	private String respTime;
	private String status;
	private String certAuthStatus;
	private String rsv2;
	private String rsv3;
	private String rsv4;
	private String rsv5;
	private String rsv6;
	private String rsv7;
	private String rsv8;
	private String rsv9;
	private String rsv10;
	private String respCode;
	private String respMsg;
	
	//TlrInfo
	private String tlrno;
	private String tlrName;
	private String tlrType;
	private String agentType;
	private String brcode;
	private String password;
	//private String status;
	private String chekDpwdFlg;
	private String lastaccesstm;
	private String roleid;
	private Integer pswderrcnt;
	private Integer totpswderrcnt;
	private String pswderrdate;
	private String lastlogouttm;
	private String loginIp;
	private String passwdenc;
	private Integer failmaxlogin;
	private Integer passwdchginterval;
	private Integer passwdwarninterval;
	private String sessionId;
	private Integer msrno;
	private String flag;
	private String credateDate;
	private String lastUpdOperId;
	private String lastUpdTime;
	private String createDate;
	private Integer departmentCode;
	private String extTlrno;
	private String effectDate;
	private String expireDate;
	private String misc;
	private String idNumber;
	private String isLockModify;
	private String st;
	private String crtDt;
	private String lastUpdTms;
	private String lastUpdOper;
	private String joinDate;
	private String leaveDate;
	private String innerflag;
	private String innerFlag;
	private String lastpwdchgtm;
	private String isLock;
	private String lastfailedtm;
	private String lockReason;
	private String maker;
	private String maketime;
	private String checker;
	private String checktime;
	private String city;
	private String region;*/
	private String department;
	
	private String query_times;
	
	private String createTime;
	
	private String city;
	
	private String region;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getQuery_times() {
		return query_times;
	}

	public void setQuery_times(String query_times) {
		this.query_times = query_times;
	}
	
	
	
}

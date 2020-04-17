package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午5:11:57 
* 类说明 
*/
public abstract class BaseCollateralEntQuery implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getEntCertNum() {
		return entCertNum;
	}

	public void setEntCertNum(String entCertNum) {
		this.entCertNum = entCertNum;
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

	public String getUseScan() {
		return useScan;
	}

	public void setUseScan(String useScan) {
		this.useScan = useScan;
	}

	public String getRsv1() {
		return rsv1;
	}

	public void setRsv1(String rsv1) {
		this.rsv1 = rsv1;
	}

	public String getRsv2() {
		return rsv2;
	}

	public void setRsv2(String rsv2) {
		this.rsv2 = rsv2;
	}

	public String getRsv3() {
		return rsv3;
	}

	public void setRsv3(String rsv3) {
		this.rsv3 = rsv3;
	}

	public String getRsv4() {
		return rsv4;
	}

	public void setRsv4(String rsv4) {
		this.rsv4 = rsv4;
	}

	public String getRsv5() {
		return rsv5;
	}

	public void setRsv5(String rsv5) {
		this.rsv5 = rsv5;
	}

	public String getRsv6() {
		return rsv6;
	}

	public void setRsv6(String rsv6) {
		this.rsv6 = rsv6;
	}

	public String getRsv7() {
		return rsv7;
	}

	public void setRsv7(String rsv7) {
		this.rsv7 = rsv7;
	}

	public String getRsv8() {
		return rsv8;
	}

	public void setRsv8(String rsv8) {
		this.rsv8 = rsv8;
	}

	public String getRsv9() {
		return rsv9;
	}

	public void setRsv9(String rsv9) {
		this.rsv9 = rsv9;
	}

	public String getRsv10() {
		return rsv10;
	}

	public void setRsv10(String rsv10) {
		this.rsv10 = rsv10;
	}
	private String ip;
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	private String useScan;
	private String entName;    ;
	private String entCertType;;
	public String getEntCertType() {
		return entCertType;
	}

	public void setEntCertType(String entCertType) {
		this.entCertType = entCertType;
	}

	public String getRespId() {
		return respId;
	}

	public void setRespId(String respId) {
		this.respId = respId;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getRespTime() {
		return respTime;
	}

	public void setRespTime(String respTime) {
		this.respTime = respTime;
	}
	private String entCertNum; ;
	private String queryReason;;
	private String serviceCode;;
	private String respId;     ;
	private String respCode;   ;
	private String respMsg;    ;
	private String queryDate;  ;
	private String createUser; ;
	private String createTime; ;
	private String checkUser;     ;
	private String checkTime;     ;
	private String sendTime;      ;
	private String respTime;      ;
	private String status;        ;
	private String rsv1;
	private String rsv2;
	private String rsv3;
	private String rsv4;
	private String rsv5;
	private String rsv6           ;
	private String rsv7           ;
	private String rsv8           ;
	private String rsv9           ;
	private String rsv10          ;
	
	
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("entName = [" + entName + "], ");
        sb.append("entCertType = [" + entCertType + "], ");
        sb.append("entCertNum = [" + entCertNum + "], ");
        sb.append("queryReason = [" + queryReason + "], ");
        sb.append("serviceCode = [" + serviceCode + "], ");
        sb.append("respId = [" + respId + "], ");
        sb.append("respCode = [" + respCode + "], ");
        sb.append("respMsg = [" + respMsg + "], ");
        sb.append("queryDate = [" + queryDate + "], ");
        sb.append("createUser = [" + createUser + "], ");
        sb.append("createTime = [" + createTime + "], ");
        sb.append("checkUser = [" + checkUser + "], ");
        sb.append("checkTime = [" + checkTime + "], ");
        sb.append("sendTime = [" + sendTime + "], ");
        sb.append("respTime = [" + respTime + "], ");
        sb.append("status = [" + status + "], ");
        sb.append("ip             = [" + ip             + "], ");
	    sb.append("useScan       = [" + useScan        + "], ");
        sb.append("rsv1 = [" + rsv1 + "], ");
        sb.append("rsv2 = [" + rsv2 + "], ");
        sb.append("rsv3 = [" + rsv3 + "], ");
        sb.append("rsv4 = [" + rsv4 + "], ");
        sb.append("rsv5 = [" + rsv5 + "], ");
        sb.append("rsv6 = [" + rsv6 + "], ");
        sb.append("rsv7 = [" + rsv7 + "], ");
        sb.append("rsv8 = [" + rsv8 + "], ");
        sb.append("rsv9 = [" + rsv9 + "], ");
        sb.append("rsv10 = [" + rsv10 + "], ");
        return sb.toString();
    }

	
}

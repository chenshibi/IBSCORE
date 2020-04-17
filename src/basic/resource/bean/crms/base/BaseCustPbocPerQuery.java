package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCustPbocPerQuery implements Serializable {


    private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String name;
    java.lang.String idType;
    java.lang.String idNum;
    java.lang.String queryReason;
    java.lang.String serviceCode;
    java.lang.String respId;
    java.lang.String queryDate;
    java.lang.String createUser;
    java.lang.String createTime;
    java.lang.String checkUser;
    java.lang.String checkTime;
    java.lang.String sendTime;
    java.lang.String respTime;
    java.lang.String status;
    java.lang.String certAuthStatus;
    java.lang.String queryLevel;
    java.lang.String query_times;
    public java.lang.String getQuery_times() {
		return query_times;
	}
	public void setQuery_times(java.lang.String query_times) {
		this.query_times = query_times;
	}
	public java.lang.String getQueryLevel() {
		return queryLevel;
	}
	public void setQueryLevel(java.lang.String queryLevel) {
		this.queryLevel = queryLevel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    java.lang.String rsv2;
    java.lang.String rsv3;
    java.lang.String rsv4;
    java.lang.String rsv5;
    java.lang.String rsv6;
    java.lang.String rsv7;
    java.lang.String rsv8;
    java.lang.String rsv9;
    java.lang.String rsv10;
    java.lang.String respCode;
    java.lang.String respMsg;


    public java.lang.String getId(){
        return id;
    }
    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getName(){
        return name;
    }
    public void setName(java.lang.String name){
        this.name = name;
    }

    public java.lang.String getIdType(){
        return idType;
    }
    public void setIdType(java.lang.String idType){
        this.idType = idType;
    }

    public java.lang.String getIdNum(){
        return idNum;
    }
    public void setIdNum(java.lang.String idNum){
        this.idNum = idNum;
    }

    public java.lang.String getQueryReason(){
        return queryReason;
    }
    public void setQueryReason(java.lang.String queryReason){
        this.queryReason = queryReason;
    }

    public java.lang.String getServiceCode(){
        return serviceCode;
    }
    public void setServiceCode(java.lang.String serviceCode){
        this.serviceCode = serviceCode;
    }

    public java.lang.String getRespId(){
        return respId;
    }
    public void setRespId(java.lang.String respId){
        this.respId = respId;
    }

    public java.lang.String getQueryDate(){
        return queryDate;
    }
    public void setQueryDate(java.lang.String queryDate){
        this.queryDate = queryDate;
    }

    public java.lang.String getCreateUser(){
        return createUser;
    }
    public void setCreateUser(java.lang.String createUser){
        this.createUser = createUser;
    }

    public java.lang.String getCreateTime(){
        return createTime;
    }
    public void setCreateTime(java.lang.String createTime){
        this.createTime = createTime;
    }

    public java.lang.String getCheckUser(){
        return checkUser;
    }
    public void setCheckUser(java.lang.String checkUser){
        this.checkUser = checkUser;
    }

    public java.lang.String getCheckTime(){
        return checkTime;
    }
    public void setCheckTime(java.lang.String checkTime){
        this.checkTime = checkTime;
    }

    public java.lang.String getSendTime(){
        return sendTime;
    }
    public void setSendTime(java.lang.String sendTime){
        this.sendTime = sendTime;
    }

    public java.lang.String getRespTime(){
        return respTime;
    }
    public void setRespTime(java.lang.String respTime){
        this.respTime = respTime;
    }

    public java.lang.String getStatus(){
        return status;
    }
    public void setStatus(java.lang.String status){
        this.status = status;
    }

    public java.lang.String getCertAuthStatus(){
        return certAuthStatus;
    }
    public void setCertAuthStatus(java.lang.String certAuthStatus){
        this.certAuthStatus = certAuthStatus;
    }

    public java.lang.String getRsv2(){
        return rsv2;
    }
    public void setRsv2(java.lang.String rsv2){
        this.rsv2 = rsv2;
    }

    public java.lang.String getRsv3(){
        return rsv3;
    }
    public void setRsv3(java.lang.String rsv3){
        this.rsv3 = rsv3;
    }

    public java.lang.String getRsv4(){
        return rsv4;
    }
    public void setRsv4(java.lang.String rsv4){
        this.rsv4 = rsv4;
    }

    public java.lang.String getRsv5(){
        return rsv5;
    }
    public void setRsv5(java.lang.String rsv5){
        this.rsv5 = rsv5;
    }

    public java.lang.String getRsv6(){
        return rsv6;
    }
    public void setRsv6(java.lang.String rsv6){
        this.rsv6 = rsv6;
    }

    public java.lang.String getRsv7(){
        return rsv7;
    }
    public void setRsv7(java.lang.String rsv7){
        this.rsv7 = rsv7;
    }

    public java.lang.String getRsv8(){
        return rsv8;
    }
    public void setRsv8(java.lang.String rsv8){
        this.rsv8 = rsv8;
    }

    public java.lang.String getRsv9(){
        return rsv9;
    }
    public void setRsv9(java.lang.String rsv9){
        this.rsv9 = rsv9;
    }

    public java.lang.String getRsv10(){
        return rsv10;
    }
    public void setRsv10(java.lang.String rsv10){
        this.rsv10 = rsv10;
    }

    public java.lang.String getRespCode(){
        return respCode;
    }
    public void setRespCode(java.lang.String respCode){
        this.respCode = respCode;
    }

    public java.lang.String getRespMsg(){
        return respMsg;
    }
    public void setRespMsg(java.lang.String respMsg){
        this.respMsg = respMsg;
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("name = [" + name + "], ");
        sb.append("idType = [" + idType + "], ");
        sb.append("idNum = [" + idNum + "], ");
        sb.append("queryReason = [" + queryReason + "], ");
        sb.append("serviceCode = [" + serviceCode + "], ");
        sb.append("respId = [" + respId + "], ");
        sb.append("queryDate = [" + queryDate + "], ");
        sb.append("createUser = [" + createUser + "], ");
        sb.append("createTime = [" + createTime + "], ");
        sb.append("checkUser = [" + checkUser + "], ");
        sb.append("checkTime = [" + checkTime + "], ");
        sb.append("sendTime = [" + sendTime + "], ");
        sb.append("respTime = [" + respTime + "], ");
        sb.append("status = [" + status + "], ");
        sb.append("certAuthStatus = [" + certAuthStatus + "], ");
        sb.append("rsv2 = [" + rsv2 + "], ");
        sb.append("rsv3 = [" + rsv3 + "], ");
        sb.append("rsv4 = [" + rsv4 + "], ");
        sb.append("rsv5 = [" + rsv5 + "], ");
        sb.append("rsv6 = [" + rsv6 + "], ");
        sb.append("rsv7 = [" + rsv7 + "], ");
        sb.append("rsv8 = [" + rsv8 + "], ");
        sb.append("rsv9 = [" + rsv9 + "], ");
        sb.append("rsv10 = [" + rsv10 + "], ");
        sb.append("respCode = [" + respCode + "], ");
        sb.append("respMsg = [" + respMsg + "], ");
        return sb.toString();
    }

}


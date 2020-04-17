package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrPbocD103 implements Serializable {


    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	// private static final GenerationType IDENTITY = null;
    
    protected void initialize() {
    }

    
    public BaseCrPbocD103() {
        super();
    }

    /**
     * Constructor for primary key
     */
/*    public BaseCrPbocD103(java.lang.String id) {
       this.setId(id);
       initialize();
    }*/
    

    java.lang.String id;
    java.lang.String msgStartFlag;
    java.lang.String msgVersion;
    java.lang.String msgSndCode;
    java.lang.String msgRcvCode;
    java.lang.String msgGenTime;
    java.lang.String msgType;
    java.lang.String msgId;
    java.lang.String msgRsv;
    java.lang.String queryOrgCode;
    java.lang.String userCode;
    java.lang.String password;
    java.lang.String originateOrgCode;
    java.lang.String originateUserCode;
    java.lang.String entName;
    java.lang.String entCertType;
    java.lang.String entCertNum;
    java.lang.String queryReason;
    java.lang.String serviceCode;
    java.lang.String digitalSignature;
    java.lang.String queryDate;
    java.lang.String createUser;
    java.lang.String createTime;
    java.lang.String checkUser;
    java.lang.String checkTime;
    java.lang.String sendTime;
    java.lang.String respTime;
    java.lang.String status;
    java.lang.String rsv1;
    java.lang.String rsv2;
    java.lang.String rsv3;
    java.lang.String rsv4;
    java.lang.String rsv5;
    java.lang.String rsv6;
    java.lang.String rsv7;
    java.lang.String rsv8;
    java.lang.String rsv9;
    java.lang.String rsv10;

  
    public java.lang.String getId(){
        return id;
    }
    
    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getMsgStartFlag(){
        return msgStartFlag;
    }
    public void setMsgStartFlag(java.lang.String msgStartFlag){
        this.msgStartFlag = msgStartFlag;
    }

    public java.lang.String getMsgVersion(){
        return msgVersion;
    }
    public void setMsgVersion(java.lang.String msgVersion){
        this.msgVersion = msgVersion;
    }

    public java.lang.String getMsgSndCode(){
        return msgSndCode;
    }
    public void setMsgSndCode(java.lang.String msgSndCode){
        this.msgSndCode = msgSndCode;
    }

    public java.lang.String getMsgRcvCode(){
        return msgRcvCode;
    }
    public void setMsgRcvCode(java.lang.String msgRcvCode){
        this.msgRcvCode = msgRcvCode;
    }

    public java.lang.String getMsgGenTime(){
        return msgGenTime;
    }
    public void setMsgGenTime(java.lang.String msgGenTime){
        this.msgGenTime = msgGenTime;
    }

    public java.lang.String getMsgType(){
        return msgType;
    }
    public void setMsgType(java.lang.String msgType){
        this.msgType = msgType;
    }

    public java.lang.String getMsgId(){
        return msgId;
    }
    public void setMsgId(java.lang.String msgId){
        this.msgId = msgId;
    }

    public java.lang.String getMsgRsv(){
        return msgRsv;
    }
    public void setMsgRsv(java.lang.String msgRsv){
        this.msgRsv = msgRsv;
    }

    public java.lang.String getQueryOrgCode(){
        return queryOrgCode;
    }
    public void setQueryOrgCode(java.lang.String queryOrgCode){
        this.queryOrgCode = queryOrgCode;
    }

    public java.lang.String getUserCode(){
        return userCode;
    }
    public void setUserCode(java.lang.String userCode){
        this.userCode = userCode;
    }

    public java.lang.String getPassword(){
        return password;
    }
    public void setPassword(java.lang.String password){
        this.password = password;
    }

    public java.lang.String getOriginateOrgCode(){
        return originateOrgCode;
    }
    public void setOriginateOrgCode(java.lang.String originateOrgCode){
        this.originateOrgCode = originateOrgCode;
    }

    public java.lang.String getOriginateUserCode(){
        return originateUserCode;
    }
    public void setOriginateUserCode(java.lang.String originateUserCode){
        this.originateUserCode = originateUserCode;
    }

    public java.lang.String getEntName(){
        return entName;
    }
    public void setEntName(java.lang.String entName){
        this.entName = entName;
    }

    public java.lang.String getEntCertType(){
        return entCertType;
    }
    public void setEntCertType(java.lang.String entCertType){
        this.entCertType = entCertType;
    }

    public java.lang.String getEntCertNum(){
        return entCertNum;
    }
    public void setEntCertNum(java.lang.String entCertNum){
        this.entCertNum = entCertNum;
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

    public java.lang.String getDigitalSignature(){
        return digitalSignature;
    }
    public void setDigitalSignature(java.lang.String digitalSignature){
        this.digitalSignature = digitalSignature;
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

    public java.lang.String getRsv1(){
        return rsv1;
    }
    public void setRsv1(java.lang.String rsv1){
        this.rsv1 = rsv1;
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


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("msgStartFlag = [" + msgStartFlag + "], ");
        sb.append("msgVersion = [" + msgVersion + "], ");
        sb.append("msgSndCode = [" + msgSndCode + "], ");
        sb.append("msgRcvCode = [" + msgRcvCode + "], ");
        sb.append("msgGenTime = [" + msgGenTime + "], ");
        sb.append("msgType = [" + msgType + "], ");
        sb.append("msgId = [" + msgId + "], ");
        sb.append("msgRsv = [" + msgRsv + "], ");
        sb.append("queryOrgCode = [" + queryOrgCode + "], ");
        sb.append("userCode = [" + userCode + "], ");
        sb.append("password = [" + password + "], ");
        sb.append("originateOrgCode = [" + originateOrgCode + "], ");
        sb.append("originateUserCode = [" + originateUserCode + "], ");
        sb.append("entName = [" + entName + "], ");
        sb.append("entCertType = [" + entCertType + "], ");
        sb.append("entCertNum = [" + entCertNum + "], ");
        sb.append("queryReason = [" + queryReason + "], ");
        sb.append("serviceCode = [" + serviceCode + "], ");
        sb.append("digitalSignature = [" + digitalSignature + "], ");
        sb.append("queryDate = [" + queryDate + "], ");
        sb.append("createUser = [" + createUser + "], ");
        sb.append("createTime = [" + createTime + "], ");
        sb.append("checkUser = [" + checkUser + "], ");
        sb.append("checkTime = [" + checkTime + "], ");
        sb.append("sendTime = [" + sendTime + "], ");
        sb.append("respTime = [" + respTime + "], ");
        sb.append("status = [" + status + "], ");
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


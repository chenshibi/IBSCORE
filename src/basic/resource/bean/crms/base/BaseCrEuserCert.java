package resource.bean.crms.base;

import java.io.Serializable;

public abstract class BaseCrEuserCert implements Serializable {


    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String corpId;
    java.lang.String serialNo;
    java.lang.String certRefNo;
    java.lang.String certAuthCode;
    java.lang.String certificateIssuer;
    java.lang.String applyDate;
    java.lang.String usbKeyFlag;
    java.lang.String usbKeySn;
    java.lang.String certDownCode;
    java.lang.String certState;
    java.lang.String closeDate;
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

    public java.lang.String getCorpId(){
        return corpId;
    }
    public void setCorpId(java.lang.String corpId){
        this.corpId = corpId;
    }

    public java.lang.String getSerialNo(){
        return serialNo;
    }
    public void setSerialNo(java.lang.String serialNo){
        this.serialNo = serialNo;
    }

    public java.lang.String getCertRefNo(){
        return certRefNo;
    }
    public void setCertRefNo(java.lang.String certRefNo){
        this.certRefNo = certRefNo;
    }

    public java.lang.String getCertAuthCode(){
        return certAuthCode;
    }
    public void setCertAuthCode(java.lang.String certAuthCode){
        this.certAuthCode = certAuthCode;
    }

    public java.lang.String getCertificateIssuer(){
        return certificateIssuer;
    }
    public void setCertificateIssuer(java.lang.String certificateIssuer){
        this.certificateIssuer = certificateIssuer;
    }

    public java.lang.String getApplyDate(){
        return applyDate;
    }
    public void setApplyDate(java.lang.String applyDate){
        this.applyDate = applyDate;
    }

    public java.lang.String getUsbKeyFlag(){
        return usbKeyFlag;
    }
    public void setUsbKeyFlag(java.lang.String usbKeyFlag){
        this.usbKeyFlag = usbKeyFlag;
    }

    public java.lang.String getUsbKeySn(){
        return usbKeySn;
    }
    public void setUsbKeySn(java.lang.String usbKeySn){
        this.usbKeySn = usbKeySn;
    }

    public java.lang.String getCertDownCode(){
        return certDownCode;
    }
    public void setCertDownCode(java.lang.String certDownCode){
        this.certDownCode = certDownCode;
    }

    public java.lang.String getCertState(){
        return certState;
    }
    public void setCertState(java.lang.String certState){
        this.certState = certState;
    }

    public java.lang.String getCloseDate(){
        return closeDate;
    }
    public void setCloseDate(java.lang.String closeDate){
        this.closeDate = closeDate;
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
        sb.append("corpId = [" + corpId + "], ");
        sb.append("serialNo = [" + serialNo + "], ");
        sb.append("certRefNo = [" + certRefNo + "], ");
        sb.append("certAuthCode = [" + certAuthCode + "], ");
        sb.append("certificateIssuer = [" + certificateIssuer + "], ");
        sb.append("applyDate = [" + applyDate + "], ");
        sb.append("usbKeyFlag = [" + usbKeyFlag + "], ");
        sb.append("usbKeySn = [" + usbKeySn + "], ");
        sb.append("certDownCode = [" + certDownCode + "], ");
        sb.append("certState = [" + certState + "], ");
        sb.append("closeDate = [" + closeDate + "], ");
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


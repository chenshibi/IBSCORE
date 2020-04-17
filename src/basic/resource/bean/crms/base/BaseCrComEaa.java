package resource.bean.crms.base;

import java.io.Serializable;

public abstract class BaseCrComEaa implements Serializable {


    private static final long serialVersionUID = 1L;


    public java.lang.String getEa01cs01() {
		return ea01cs01;
	}
	public java.lang.String getEa01ds01() {
		return ea01ds01;
	}
	public java.lang.String getEa01eq01() {
		return ea01eq01;
	}


	java.lang.String id;
    java.lang.String ea01ai01;
    java.lang.String ea01ar01;
    java.lang.String ea01bi01;
    java.lang.String ea01bd02;
    java.lang.String ea01cq01;
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setEa01cs01(java.lang.String ea01cs01) {
		this.ea01cs01 = ea01cs01;
	}
	public void setEa01ds01(java.lang.String ea01ds01) {
		this.ea01ds01 = ea01ds01;
	}
	public void setEa01eq01(java.lang.String ea01eq01) {
		this.ea01eq01 = ea01eq01;
	}


	java.lang.String ea01cs01;
    java.lang.String ea01ds01;
    java.lang.String ea01eq01;
    java.lang.String ea01er01;
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

    public java.lang.String getEa01ai01(){
        return ea01ai01;
    }
    public void setEa01ai01(java.lang.String ea01ai01){
        this.ea01ai01 = ea01ai01;
    }

    public java.lang.String getEa01ar01(){
        return ea01ar01;
    }
    public void setEa01ar01(java.lang.String ea01ar01){
        this.ea01ar01 = ea01ar01;
    }

    public java.lang.String getEa01bi01(){
        return ea01bi01;
    }
    public void setEa01bi01(java.lang.String ea01bi01){
        this.ea01bi01 = ea01bi01;
    }

    public java.lang.String getEa01bd02(){
        return ea01bd02;
    }
    public void setEa01bd02(java.lang.String ea01bd02){
        this.ea01bd02 = ea01bd02;
    }

    public java.lang.String getEa01cq01(){
        return ea01cq01;
    }
    public void setEa01cq01(java.lang.String ea01cq01){
        this.ea01cq01 = ea01cq01;
    }

    public java.lang.String getEa01er01(){
        return ea01er01;
    }
    public void setEa01er01(java.lang.String ea01er01){
        this.ea01er01 = ea01er01;
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
        sb.append("ea01ai01 = [" + ea01ai01 + "], ");
        sb.append("ea01ar01 = [" + ea01ar01 + "], ");
        sb.append("ea01bi01 = [" + ea01bi01 + "], ");
        sb.append("ea01bd02 = [" + ea01bd02 + "], ");
        sb.append("ea01cq01 = [" + ea01cq01 + "], ");
        sb.append("ea01cs01 = [" + ea01cs01 + "], ");
        sb.append("ea01ds01 = [" + ea01ds01 + "], ");
        sb.append("ea01eq01 = [" + ea01eq01 + "], ");
        sb.append("ea01er01 = [" + ea01er01 + "], ");
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


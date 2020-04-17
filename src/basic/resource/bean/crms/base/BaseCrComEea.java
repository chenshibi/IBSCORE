package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrComEea implements Serializable {


    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String ee01ai01;
    java.lang.String ee01aq01;
    java.lang.String ee01ad01;
    java.lang.String ee01ad02;
    java.lang.String ee01aj01;
    java.lang.String ee01ar01;
    java.lang.String ee01bs01;
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

    public java.lang.String getEe01ai01(){
        return ee01ai01;
    }
    public void setEe01ai01(java.lang.String ee01ai01){
        this.ee01ai01 = ee01ai01;
    }

    public java.lang.String getEe01aq01(){
        return ee01aq01;
    }
    public void setEe01aq01(java.lang.String ee01aq01){
        this.ee01aq01 = ee01aq01;
    }

    public java.lang.String getEe01ad01(){
        return ee01ad01;
    }
    public void setEe01ad01(java.lang.String ee01ad01){
        this.ee01ad01 = ee01ad01;
    }

    public java.lang.String getEe01ad02(){
        return ee01ad02;
    }
    public void setEe01ad02(java.lang.String ee01ad02){
        this.ee01ad02 = ee01ad02;
    }

    public java.lang.String getEe01aj01(){
        return ee01aj01;
    }
    public void setEe01aj01(java.lang.String ee01aj01){
        this.ee01aj01 = ee01aj01;
    }

    public java.lang.String getEe01ar01(){
        return ee01ar01;
    }
    public void setEe01ar01(java.lang.String ee01ar01){
        this.ee01ar01 = ee01ar01;
    }

    public java.lang.String getEe01bs01(){
        return ee01bs01;
    }
    public void setEe01bs01(java.lang.String ee01bs01){
        this.ee01bs01 = ee01bs01;
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
        sb.append("ee01ai01 = [" + ee01ai01 + "], ");
        sb.append("ee01aq01 = [" + ee01aq01 + "], ");
        sb.append("ee01ad01 = [" + ee01ad01 + "], ");
        sb.append("ee01ad02 = [" + ee01ad02 + "], ");
        sb.append("ee01aj01 = [" + ee01aj01 + "], ");
        sb.append("ee01ar01 = [" + ee01ar01 + "], ");
        sb.append("ee01bs01 = [" + ee01bs01 + "], ");
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


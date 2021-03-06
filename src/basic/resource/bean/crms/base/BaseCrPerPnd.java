package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrPerPnd implements Serializable {


    private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String pe01ad01;
    java.lang.String pe01aq01;
    java.lang.String pe01ad02;
    java.lang.String pe01ar01;
    java.lang.String pe01ad03;
    java.lang.String pe01aj01;
    java.lang.String pe01ar02;
    java.lang.String pe01aq02;
    java.lang.String pe01zs01;
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
    java.lang.String batchId;


    public java.lang.String getId(){
        return id;
    }
    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getPe01ad01(){
        return pe01ad01;
    }
    public void setPe01ad01(java.lang.String pe01ad01){
        this.pe01ad01 = pe01ad01;
    }

    public java.lang.String getPe01aq01(){
        return pe01aq01;
    }
    public void setPe01aq01(java.lang.String pe01aq01){
        this.pe01aq01 = pe01aq01;
    }

    public java.lang.String getPe01ad02(){
        return pe01ad02;
    }
    public void setPe01ad02(java.lang.String pe01ad02){
        this.pe01ad02 = pe01ad02;
    }

    public java.lang.String getPe01ar01(){
        return pe01ar01;
    }
    public void setPe01ar01(java.lang.String pe01ar01){
        this.pe01ar01 = pe01ar01;
    }

    public java.lang.String getPe01ad03(){
        return pe01ad03;
    }
    public void setPe01ad03(java.lang.String pe01ad03){
        this.pe01ad03 = pe01ad03;
    }

    public java.lang.String getPe01aj01(){
        return pe01aj01;
    }
    public void setPe01aj01(java.lang.String pe01aj01){
        this.pe01aj01 = pe01aj01;
    }

    public java.lang.String getPe01ar02(){
        return pe01ar02;
    }
    public void setPe01ar02(java.lang.String pe01ar02){
        this.pe01ar02 = pe01ar02;
    }

    public java.lang.String getPe01aq02(){
        return pe01aq02;
    }
    public void setPe01aq02(java.lang.String pe01aq02){
        this.pe01aq02 = pe01aq02;
    }

    public java.lang.String getPe01zs01(){
        return pe01zs01;
    }
    public void setPe01zs01(java.lang.String pe01zs01){
        this.pe01zs01 = pe01zs01;
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

    public java.lang.String getBatchId(){
        return batchId;
    }
    public void setBatchId(java.lang.String batchId){
        this.batchId = batchId;
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("pe01ad01 = [" + pe01ad01 + "], ");
        sb.append("pe01aq01 = [" + pe01aq01 + "], ");
        sb.append("pe01ad02 = [" + pe01ad02 + "], ");
        sb.append("pe01ar01 = [" + pe01ar01 + "], ");
        sb.append("pe01ad03 = [" + pe01ad03 + "], ");
        sb.append("pe01aj01 = [" + pe01aj01 + "], ");
        sb.append("pe01ar02 = [" + pe01ar02 + "], ");
        sb.append("pe01aq02 = [" + pe01aq02 + "], ");
        sb.append("pe01zs01 = [" + pe01zs01 + "], ");
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
        sb.append("batchId = [" + batchId + "], ");
        return sb.toString();
    }

}


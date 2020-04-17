package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrPerPmm implements Serializable {


    private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String pb020d01;
    java.lang.String pb020q01;
    java.lang.String pb020d02;
    java.lang.String pb020i01;
    java.lang.String pb020q02;
    java.lang.String pb020q03;
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

    public java.lang.String getPb020d01(){
        return pb020d01;
    }
    public void setPb020d01(java.lang.String pb020d01){
        this.pb020d01 = pb020d01;
    }

    public java.lang.String getPb020q01(){
        return pb020q01;
    }
    public void setPb020q01(java.lang.String pb020q01){
        this.pb020q01 = pb020q01;
    }

    public java.lang.String getPb020d02(){
        return pb020d02;
    }
    public void setPb020d02(java.lang.String pb020d02){
        this.pb020d02 = pb020d02;
    }

    public java.lang.String getPb020i01(){
        return pb020i01;
    }
    public void setPb020i01(java.lang.String pb020i01){
        this.pb020i01 = pb020i01;
    }

    public java.lang.String getPb020q02(){
        return pb020q02;
    }
    public void setPb020q02(java.lang.String pb020q02){
        this.pb020q02 = pb020q02;
    }

    public java.lang.String getPb020q03(){
        return pb020q03;
    }
    public void setPb020q03(java.lang.String pb020q03){
        this.pb020q03 = pb020q03;
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
        sb.append("pb020d01 = [" + pb020d01 + "], ");
        sb.append("pb020q01 = [" + pb020q01 + "], ");
        sb.append("pb020d02 = [" + pb020d02 + "], ");
        sb.append("pb020i01 = [" + pb020i01 + "], ");
        sb.append("pb020q02 = [" + pb020q02 + "], ");
        sb.append("pb020q03 = [" + pb020q03 + "], ");
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


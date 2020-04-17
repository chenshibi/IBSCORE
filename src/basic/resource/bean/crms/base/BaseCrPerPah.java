package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrPerPah implements Serializable {


    private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String pf08aq01;
    java.lang.String pf08aq02;
    java.lang.String pf08ar01;
    java.lang.String pf08ar02;
    java.lang.String pf08zs01;
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

    public java.lang.String getPf08aq01(){
        return pf08aq01;
    }
    public void setPf08aq01(java.lang.String pf08aq01){
        this.pf08aq01 = pf08aq01;
    }

    public java.lang.String getPf08aq02(){
        return pf08aq02;
    }
    public void setPf08aq02(java.lang.String pf08aq02){
        this.pf08aq02 = pf08aq02;
    }

    public java.lang.String getPf08ar01(){
        return pf08ar01;
    }
    public void setPf08ar01(java.lang.String pf08ar01){
        this.pf08ar01 = pf08ar01;
    }

    public java.lang.String getPf08ar02(){
        return pf08ar02;
    }
    public void setPf08ar02(java.lang.String pf08ar02){
        this.pf08ar02 = pf08ar02;
    }

    public java.lang.String getPf08zs01(){
        return pf08zs01;
    }
    public void setPf08zs01(java.lang.String pf08zs01){
        this.pf08zs01 = pf08zs01;
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
        sb.append("pf08aq01 = [" + pf08aq01 + "], ");
        sb.append("pf08aq02 = [" + pf08aq02 + "], ");
        sb.append("pf08ar01 = [" + pf08ar01 + "], ");
        sb.append("pf08ar02 = [" + pf08ar02 + "], ");
        sb.append("pf08zs01 = [" + pf08zs01 + "], ");
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


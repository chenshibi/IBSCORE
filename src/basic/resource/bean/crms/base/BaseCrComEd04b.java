package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrComEd04b implements Serializable {


    private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String ed04br01;
    java.lang.String ed04bd01;
    java.lang.String ed04bj01;
    java.lang.String ed04bd02;
    java.lang.String ed04bj02;
    java.lang.String ed04bd03;
    java.lang.String ed04bd04;
    java.lang.String ed04br02;
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
    java.lang.String parentId;


    public java.lang.String getId(){
        return id;
    }
    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getEd04br01(){
        return ed04br01;
    }
    public void setEd04br01(java.lang.String ed04br01){
        this.ed04br01 = ed04br01;
    }

    public java.lang.String getEd04bd01(){
        return ed04bd01;
    }
    public void setEd04bd01(java.lang.String ed04bd01){
        this.ed04bd01 = ed04bd01;
    }

    public java.lang.String getEd04bj01(){
        return ed04bj01;
    }
    public void setEd04bj01(java.lang.String ed04bj01){
        this.ed04bj01 = ed04bj01;
    }

    public java.lang.String getEd04bd02(){
        return ed04bd02;
    }
    public void setEd04bd02(java.lang.String ed04bd02){
        this.ed04bd02 = ed04bd02;
    }

    public java.lang.String getEd04bj02(){
        return ed04bj02;
    }
    public void setEd04bj02(java.lang.String ed04bj02){
        this.ed04bj02 = ed04bj02;
    }

    public java.lang.String getEd04bd03(){
        return ed04bd03;
    }
    public void setEd04bd03(java.lang.String ed04bd03){
        this.ed04bd03 = ed04bd03;
    }

    public java.lang.String getEd04bd04(){
        return ed04bd04;
    }
    public void setEd04bd04(java.lang.String ed04bd04){
        this.ed04bd04 = ed04bd04;
    }

    public java.lang.String getEd04br02(){
        return ed04br02;
    }
    public void setEd04br02(java.lang.String ed04br02){
        this.ed04br02 = ed04br02;
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

    public java.lang.String getParentId(){
        return parentId;
    }
    public void setParentId(java.lang.String parentId){
        this.parentId = parentId;
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("ed04br01 = [" + ed04br01 + "], ");
        sb.append("ed04bd01 = [" + ed04bd01 + "], ");
        sb.append("ed04bj01 = [" + ed04bj01 + "], ");
        sb.append("ed04bd02 = [" + ed04bd02 + "], ");
        sb.append("ed04bj02 = [" + ed04bj02 + "], ");
        sb.append("ed04bd03 = [" + ed04bd03 + "], ");
        sb.append("ed04bd04 = [" + ed04bd04 + "], ");
        sb.append("ed04br02 = [" + ed04br02 + "], ");
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
        sb.append("parentId = [" + parentId + "], ");
        return sb.toString();
    }

}


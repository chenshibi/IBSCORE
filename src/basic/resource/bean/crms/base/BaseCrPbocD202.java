package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseCrPbocD202 implements Serializable {


    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	private static final long serialVersionUID = 1L;


    java.lang.String id;
    java.lang.String fileName;
    java.lang.String resultCode;
    java.lang.String resultDesc;
    java.lang.String stateCode;
    java.lang.String stateDesc;
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

    public java.lang.String getFileName(){
        return fileName;
    }
    public void setFileName(java.lang.String fileName){
        this.fileName = fileName;
    }

    public java.lang.String getResultCode(){
        return resultCode;
    }
    public void setResultCode(java.lang.String resultCode){
        this.resultCode = resultCode;
    }

    public java.lang.String getResultDesc(){
        return resultDesc;
    }
    public void setResultDesc(java.lang.String resultDesc){
        this.resultDesc = resultDesc;
    }

    public java.lang.String getStateCode(){
        return stateCode;
    }
    public void setStateCode(java.lang.String stateCode){
        this.stateCode = stateCode;
    }

    public java.lang.String getStateDesc(){
        return stateDesc;
    }
    public void setStateDesc(java.lang.String stateDesc){
        this.stateDesc = stateDesc;
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
        sb.append("fileName = [" + fileName + "], ");
        sb.append("resultCode = [" + resultCode + "], ");
        sb.append("resultDesc = [" + resultDesc + "], ");
        sb.append("stateCode = [" + stateCode + "], ");
        sb.append("stateDesc = [" + stateDesc + "], ");
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


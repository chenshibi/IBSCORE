package resource.bean.crms.base;

import java.io.Serializable;

public abstract class BaseCrComEbd implements Serializable {


    private static final long serialVersionUID = 1L;


    public java.lang.String getEb040j01() {
		return eb040j01;
	}
	public java.lang.String getEb040j02() {
		return eb040j02;
	}
	public java.lang.String getEb040j03() {
		return eb040j03;
	}
	public java.lang.String getEb040j04() {
		return eb040j04;
	}
	public java.lang.String getEb040j05() {
		return eb040j05;
	}
	public java.lang.String getEb040j06() {
		return eb040j06;
	}


	java.lang.String id;
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setEb040j01(java.lang.String eb040j01) {
		this.eb040j01 = eb040j01;
	}
	public void setEb040j02(java.lang.String eb040j02) {
		this.eb040j02 = eb040j02;
	}
	public void setEb040j03(java.lang.String eb040j03) {
		this.eb040j03 = eb040j03;
	}
	public void setEb040j04(java.lang.String eb040j04) {
		this.eb040j04 = eb040j04;
	}
	public void setEb040j05(java.lang.String eb040j05) {
		this.eb040j05 = eb040j05;
	}
	public void setEb040j06(java.lang.String eb040j06) {
		this.eb040j06 = eb040j06;
	}


	java.lang.String eb040j01;
    java.lang.String eb040j02;
    java.lang.String eb040j03;
    java.lang.String eb040j04;
    java.lang.String eb040j05;
    java.lang.String eb040j06;
    java.lang.String eb040d01;
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

    public java.lang.String getEb040d01(){
        return eb040d01;
    }
    public void setEb040d01(java.lang.String eb040d01){
        this.eb040d01 = eb040d01;
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
        sb.append("eb040j01 = [" + eb040j01 + "], ");
        sb.append("eb040j02 = [" + eb040j02 + "], ");
        sb.append("eb040j03 = [" + eb040j03 + "], ");
        sb.append("eb040j04 = [" + eb040j04 + "], ");
        sb.append("eb040j05 = [" + eb040j05 + "], ");
        sb.append("eb040j06 = [" + eb040j06 + "], ");
        sb.append("eb040d01 = [" + eb040d01 + "], ");
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


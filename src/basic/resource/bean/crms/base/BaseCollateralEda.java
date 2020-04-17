package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午5:03:23 
* 类说明 
*/
public abstract class BaseCollateralEda implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
    private String id;
	private String ed01Ai01;
	private String ed01Ai02;
	public String getEd01Ai02() {
		return ed01Ai02;
	}

	public void setEd01Ai02(String ed01Ai02) {
		this.ed01Ai02 = ed01Ai02;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEd01Ai01() {
		return ed01Ai01;
	}

	public void setEd01Ai01(String ed01Ai01) {
		this.ed01Ai01 = ed01Ai01;
	}

	public String getEd01Ad01() {
		return ed01Ad01;
	}

	public void setEd01Ad01(String ed01Ad01) {
		this.ed01Ad01 = ed01Ad01;
	}

	public String getEd01Aj01() {
		return ed01Aj01;
	}

	public void setEd01Aj01(String ed01Aj01) {
		this.ed01Aj01 = ed01Aj01;
	}

	public String getEd01Ad02() {
		return ed01Ad02;
	}

	public void setEd01Ad02(String ed01Ad02) {
		this.ed01Ad02 = ed01Ad02;
	}

	public String getEd01Ar01() {
		return ed01Ar01;
	}

	public void setEd01Ar01(String ed01Ar01) {
		this.ed01Ar01 = ed01Ar01;
	}

	public String getEd01Ar02() {
		return ed01Ar02;
	}

	public void setEd01Ar02(String ed01Ar02) {
		this.ed01Ar02 = ed01Ar02;
	}

	public String getEd01Ad03() {
		return ed01Ad03;
	}

	public void setEd01Ad03(String ed01Ad03) {
		this.ed01Ad03 = ed01Ad03;
	}

	public String getEd01Ad04() {
		return ed01Ad04;
	}

	public void setEd01Ad04(String ed01Ad04) {
		this.ed01Ad04 = ed01Ad04;
	}

	public String getEd01Ad05() {
		return ed01Ad05;
	}

	public void setEd01Ad05(String ed01Ad05) {
		this.ed01Ad05 = ed01Ad05;
	}

	public String getEd01Bs01() {
		return ed01Bs01;
	}

	public void setEd01Bs01(String ed01Bs01) {
		this.ed01Bs01 = ed01Bs01;
	}

	public String getEd01Cs01() {
		return ed01Cs01;
	}

	public void setEd01Cs01(String ed01Cs01) {
		this.ed01Cs01 = ed01Cs01;
	}

	public String getRsv1() {
		return rsv1;
	}

	public void setRsv1(String rsv1) {
		this.rsv1 = rsv1;
	}

	public String getRsv2() {
		return rsv2;
	}

	public void setRsv2(String rsv2) {
		this.rsv2 = rsv2;
	}

	public String getRsv3() {
		return rsv3;
	}

	public void setRsv3(String rsv3) {
		this.rsv3 = rsv3;
	}

	public String getRsv4() {
		return rsv4;
	}

	public void setRsv4(String rsv4) {
		this.rsv4 = rsv4;
	}

	public String getRsv5() {
		return rsv5;
	}

	public void setRsv5(String rsv5) {
		this.rsv5 = rsv5;
	}

	public String getRsv6() {
		return rsv6;
	}

	public void setRsv6(String rsv6) {
		this.rsv6 = rsv6;
	}

	public String getRsv7() {
		return rsv7;
	}

	public void setRsv7(String rsv7) {
		this.rsv7 = rsv7;
	}

	public String getRsv8() {
		return rsv8;
	}

	public void setRsv8(String rsv8) {
		this.rsv8 = rsv8;
	}

	public String getRsv9() {
		return rsv9;
	}

	public void setRsv9(String rsv9) {
		this.rsv9 = rsv9;
	}

	public String getRsv10() {
		return rsv10;
	}

	public void setRsv10(String rsv10) {
		this.rsv10 = rsv10;
	}
	private String ed01Ad01;
	private String ed01Aj01;
	private String ed01Ad02;
	private String ed01Ar01;
	private String ed01Ar02;
	private String ed01Ad03;
	private String ed01Ad04;
	private String ed01Ad05;
	private String ed01Bs01;
	private String ed01Cs01;
	private String rsv1    ;
	private String rsv2    ;
	private String rsv3    ;
	private String rsv4    ;
	private String rsv5    ;
	private String rsv6    ;
	private String rsv7    ;
	private String rsv8    ;
	private String rsv9    ;
	private String rsv10   ;

	 public String toString(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("id = [" + id + "], ");
	        sb.append("ed01Ai01 = [" + ed01Ai01 + "], ");
	        sb.append("ed01Ad01 = [" + ed01Ad01 + "], ");
	        sb.append("ed01Aj01 = [" + ed01Aj01 + "], ");
	        sb.append("ed01Ad02 = [" + ed01Ad02 + "], ");
	        sb.append("ed01Ar01 = [" + ed01Ar01 + "], ");
			sb.append("ed01Ar02 = [" + ed01Ar02 + "], ");
			sb.append("ed01Ad03 = [" + ed01Ad03 + "], ");
			sb.append("ed01Ad04 = [" + ed01Ad04 + "], ");
			sb.append("ed01Ad05 = [" + ed01Ad05  + "], ");
			sb.append("ed01Bs01 = [" + ed01Bs01  + "], ");
			sb.append("ed01Cs01 = [" + ed01Cs01  + "], ");
			sb.append("rsv1     = [" + rsv1     + "], ");
	        sb.append("rsv2     = [" + rsv2     + "], ");
			sb.append("rsv3     = [" + rsv3     + "], ");
			sb.append("rsv4     = [" + rsv4     + "], ");
			sb.append("rsv5     = [" + rsv5     + "], ");
			sb.append("rsv6     = [" + rsv6     + "], ");
			sb.append("rsv7     = [" + rsv7     + "], ");
			sb.append("rsv8     = [" + rsv8     + "], ");
			sb.append("rsv9     = [" + rsv9     + "], ");
			sb.append("rsv10     = [" +rsv10     + "], ");
	        return sb.toString();
	    }
}

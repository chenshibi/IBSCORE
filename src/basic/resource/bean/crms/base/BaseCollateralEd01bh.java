package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午5:04:46 
* 类说明 
*/
public abstract class BaseCollateralEd01bh implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
    private String id;
    private String batchId;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getEd01Bd01() {
		return ed01Bd01;
	}

	public void setEd01Bd01(String ed01Bd01) {
		this.ed01Bd01 = ed01Bd01;
	}

	public String getEd01Bd02() {
		return ed01Bd02;
	}

	public void setEd01Bd02(String ed01Bd02) {
		this.ed01Bd02 = ed01Bd02;
	}

	public String getEd01Bi01() {
		return ed01Bi01;
	}

	public void setEd01Bi01(String ed01Bi01) {
		this.ed01Bi01 = ed01Bi01;
	}

	public String getEd01Bd03() {
		return ed01Bd03;
	}

	public void setEd01Bd03(String ed01Bd03) {
		this.ed01Bd03 = ed01Bd03;
	}

	public String getEd01Bj01() {
		return ed01Bj01;
	}

	public void setEd01Bj01(String ed01Bj01) {
		this.ed01Bj01 = ed01Bj01;
	}

	public String getEd01Bd04() {
		return ed01Bd04;
	}

	public void setEd01Bd04(String ed01Bd04) {
		this.ed01Bd04 = ed01Bd04;
	}

	public String getEd01Bd05() {
		return ed01Bd05;
	}

	public void setEd01Bd05(String ed01Bd05) {
		this.ed01Bd05 = ed01Bd05;
	}

	public String getEd01Br01() {
		return ed01Br01;
	}

	public void setEd01Br01(String ed01Br01) {
		this.ed01Br01 = ed01Br01;
	}

	public String getEd01Bd06() {
		return ed01Bd06;
	}

	public void setEd01Bd06(String ed01Bd06) {
		this.ed01Bd06 = ed01Bd06;
	}

	public String getEd01Bq01() {
		return ed01Bq01;
	}

	public void setEd01Bq01(String ed01Bq01) {
		this.ed01Bq01 = ed01Bq01;
	}

	public String getEd01Bd07() {
		return ed01Bd07;
	}

	public void setEd01Bd07(String ed01Bd07) {
		this.ed01Bd07 = ed01Bd07;
	}

	public String getEd01Bi02() {
		return ed01Bi02;
	}

	public void setEd01Bi02(String ed01Bi02) {
		this.ed01Bi02 = ed01Bi02;
	}

	public String getEd01Bq02() {
		return ed01Bq02;
	}

	public void setEd01Bq02(String ed01Bq02) {
		this.ed01Bq02 = ed01Bq02;
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
	private String ed01Bd01  ;
	private String ed01Bd02  ;
	private String ed01Bi01  ;
	private String ed01Bd03  ;
	private String ed01Bj01  ;
	private String ed01Bd04  ;
	private String ed01Bd05  ;
	private String ed01Br01  ;
	private String ed01Bd06  ;
	private String ed01Bq01  ;
	private String ed01Bd07  ;
	private String ed01Bi02  ;
	private String ed01Bq02  ;
	private String rsv1      ;
	private String rsv2      ;
	private String rsv3      ;
	private String rsv4      ;
	private String rsv5      ;
	private String rsv6      ;
	private String rsv7      ;
	private String rsv8      ;
	private String rsv9      ;
	private String rsv10     ;

	 public String toString(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("id = [" + id + "], ");
	        sb.append("batchId = [" + batchId+ "], ");
	        sb.append("ed01Bd01 = [" + ed01Bd01+ "], ");
	        sb.append("ed01Bd02 = [" + ed01Bd02+ "], ");
	        sb.append("ed01Bi01 = [" + ed01Bi01+ "], ");
	        sb.append("ed01Bd03 = [" + ed01Bd03+ "], ");
			sb.append("ed01Bj01 = [" + ed01Bj01+ "], ");
			sb.append("ed01Bd04 = [" + ed01Bd04+ "], ");
			sb.append("ed01Bd05 = [" + ed01Bd05+ "], ");
			sb.append("ed01Br01 = [" + ed01Br01 + "], ");
			sb.append("ed01Bd06 = [" + ed01Bd06 + "], ");
			sb.append("ed01Bq01 = [" + ed01Bq01 + "], ");
		    sb.append("ed01Bd07  = [" +ed01Bd07  + "], ");
	        sb.append("ed01Bi02  = [" +ed01Bi02  + "], ");
	        sb.append("ed01Bq02  = [" +ed01Bq02  + "], ");
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

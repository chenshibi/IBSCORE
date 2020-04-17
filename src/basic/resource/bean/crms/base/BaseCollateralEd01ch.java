package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午5:06:26 
* 类说明 
*/
public abstract class BaseCollateralEd01ch implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
	private String    id;
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

	public String getEd01Cd01() {
		return ed01Cd01;
	}

	public void setEd01Cd01(String ed01Cd01) {
		this.ed01Cd01 = ed01Cd01;
	}

	public String getEd01Cj01() {
		return ed01Cj01;
	}

	public void setEd01Cj01(String ed01Cj01) {
		this.ed01Cj01 = ed01Cj01;
	}

	public String getEd01Cd02() {
		return ed01Cd02;
	}

	public void setEd01Cd02(String ed01Cd02) {
		this.ed01Cd02 = ed01Cd02;
	}

	public String getEd01Cd03() {
		return ed01Cd03;
	}

	public void setEd01Cd03(String ed01Cd03) {
		this.ed01Cd03 = ed01Cd03;
	}

	public String getEd01Cq01() {
		return ed01Cq01;
	}

	public void setEd01Cq01(String ed01Cq01) {
		this.ed01Cq01 = ed01Cq01;
	}

	public String getEd01Cd04() {
		return ed01Cd04;
	}

	public void setEd01Cd04(String ed01Cd04) {
		this.ed01Cd04 = ed01Cd04;
	}

	public String getEd01Ci01() {
		return ed01Ci01;
	}

	public void setEd01Ci01(String ed01Ci01) {
		this.ed01Ci01 = ed01Ci01;
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
	private String    batchId;
	private String    ed01Cd01 ;
	private String    ed01Cj01 ;
	private String    ed01Cd02 ;
	private String    ed01Cd03 ;
	private String    ed01Cq01 ;
	private String    ed01Cd04 ;
	private String    ed01Ci01 ;
	private String    rsv1     ;
	private String    rsv2     ;
	private String    rsv3     ;
	private String    rsv4     ;
	private String    rsv5     ;
	private String    rsv6     ;
	private String    rsv7     ;
	private String    rsv8     ;
	private String    rsv9     ;
	private String    rsv10    ;
	
	 public String toString(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("id = [" + id + "], ");
	        sb.append("batchId =  [" + batchId+ "], ");
	        sb.append("ed01Cd01 = [" + ed01Cd01+ "], ");
	        sb.append("ed01Cj01 = [" + ed01Cj01+ "], ");
	        sb.append("ed01Cd02 = [" + ed01Cd02+ "], ");
	        sb.append("ed01Cd03 = [" + ed01Cd03+ "], ");
			sb.append("ed01Cq01 = [" + ed01Cq01+ "], ");
			sb.append("ed01Cd04 = [" + ed01Cd04+ "], ");
			sb.append("ed01Ci01 = [" + ed01Ci01+ "], ");
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

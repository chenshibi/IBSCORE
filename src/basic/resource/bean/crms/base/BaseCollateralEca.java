package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午4:58:07 
* 类说明 
*/
public abstract class BaseCollateralEca implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
    private String    id;
    private String    batchId;
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

	public String getEc01Ad05() {
		return ec01Ad05;
	}

	public void setEc01Ad05(String ec01Ad05) {
		this.ec01Ad05 = ec01Ad05;
	}

	public String getEc01Ad06() {
		return ec01Ad06;
	}

	public void setEc01Ad06(String ec01Ad06) {
		this.ec01Ad06 = ec01Ad06;
	}

	public String getEc01Ad03() {
		return ec01Ad03;
	}

	public void setEc01Ad03(String ec01Ad03) {
		this.ec01Ad03 = ec01Ad03;
	}

	public String getEc01Ar01() {
		return ec01Ar01;
	}

	public void setEc01Ar01(String ec01Ar01) {
		this.ec01Ar01 = ec01Ar01;
	}

	public String getEc01Ad04() {
		return ec01Ad04;
	}

	public void setEc01Ad04(String ec01Ad04) {
		this.ec01Ad04 = ec01Ad04;
	}

	public String getEc01Aj01() {
		return ec01Aj01;
	}

	public void setEc01Aj01(String ec01Aj01) {
		this.ec01Aj01 = ec01Aj01;
	}

	public String getEc01Ar02() {
		return ec01Ar02;
	}

	public void setEc01Ar02(String ec01Ar02) {
		this.ec01Ar02 = ec01Ar02;
	}

	public String getEc01Ad01() {
		return ec01Ad01;
	}

	public void setEc01Ad01(String ec01Ad01) {
		this.ec01Ad01 = ec01Ad01;
	}

	public String getEc01Ad02() {
		return ec01Ad02;
	}

	public void setEc01Ad02(String ec01Ad02) {
		this.ec01Ad02 = ec01Ad02;
	}

	public String getEc01Ar03() {
		return ec01Ar03;
	}

	public void setEc01Ar03(String ec01Ar03) {
		this.ec01Ar03 = ec01Ar03;
	}

	public String getEc01Bs01() {
		return ec01Bs01;
	}

	public void setEc01Bs01(String ec01Bs01) {
		this.ec01Bs01 = ec01Bs01;
	}

	public String getEc01Cs01() {
		return ec01Cs01;
	}

	public void setEc01Cs01(String ec01Cs01) {
		this.ec01Cs01 = ec01Cs01;
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
	private String    ec01Ad05 ;
	private String    ec01Ad06 ;
	private String    ec01Ad03 ;
	private String    ec01Ar01 ;
	private String    ec01Ad04 ;
	private String    ec01Aj01 ;
	private String    ec01Ar02 ;
	private String    ec01Ad01 ;
	private String    ec01Ad02 ;
	private String    ec01Ar03 ;
	private String    ec01Bs01 ;
	private String    ec01Cs01 ;
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
	        sb.append("batchId =  [" + batchId + "], ");
	        sb.append("ec01Ad05 = [" + ec01Ad05 + "], ");
	        sb.append("ec01Ad06 = [" + ec01Ad06 + "], ");
	        sb.append("ec01Ad03 = [" + ec01Ad03 + "], ");
	        sb.append("ec01Ar01 = [" + ec01Ar01 + "], ");
			sb.append("ec01Ad04 = [" + ec01Ad04 + "], ");
			sb.append("ec01Aj01 = [" + ec01Aj01 + "], ");
			sb.append("ec01Ar02 = [" + ec01Ar02 + "], ");
			sb.append("ec01Ad01 = [" + ec01Ad01  + "], ");
			sb.append("ec01Ad02 = [" + ec01Ad02  + "], ");
			sb.append("ec01Ar03 = [" + ec01Ar03  + "], ");
			sb.append("ec01Bs01=  [" + ec01Bs01+ "], ");
	        sb.append("ec01Cs01=  [" + ec01Cs01+ "], ");
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

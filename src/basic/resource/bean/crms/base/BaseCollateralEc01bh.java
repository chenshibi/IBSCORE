package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午4:59:23 
* 类说明 
*/
public abstract class BaseCollateralEc01bh implements Serializable{
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getEc01Bd01() {
		return ec01Bd01;
	}

	public void setEc01Bd01(String ec01Bd01) {
		this.ec01Bd01 = ec01Bd01;
	}

	public String getEc01Bq01() {
		return ec01Bq01;
	}

	public void setEc01Bq01(String ec01Bq01) {
		this.ec01Bq01 = ec01Bq01;
	}

	public String getEc01Bd02() {
		return ec01Bd02;
	}

	public void Collateral(String ec01Bd02) {
		this.ec01Bd02 = ec01Bd02;
	}

	public String getEc01Bi01() {
		return ec01Bi01;
	}

	public void setEc01Bi01(String ec01Bi01) {
		this.ec01Bi01 = ec01Bi01;
	}

	public String getEc01Bd03() {
		return ec01Bd03;
	}

	public void setEc01Bd03(String ec01Bd03) {
		this.ec01Bd03 = ec01Bd03;
	}

	public String getEc01Bd04() {
		return ec01Bd04;
	}

	public void setEc01Bd04(String ec01Bd04) {
		this.ec01Bd04 = ec01Bd04;
	}

	public String getEc01Bj01() {
		return ec01Bj01;
	}

	public void setEc01Bj01(String ec01Bj01) {
		this.ec01Bj01 = ec01Bj01;
	}

	public String getEc01Bd05() {
		return ec01Bd05;
	}

	public void setEc01Bd05(String ec01Bd05) {
		this.ec01Bd05 = ec01Bd05;
	}

	public String getEc01Bi02() {
		return ec01Bi02;
	}

	public void setEc01Bi02(String ec01Bi02) {
		this.ec01Bi02 = ec01Bi02;
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
	private String    parentId;
	private String    ec01Bd01 ;
	private String    ec01Bq01 ;
	private String    ec01Bd02 ;
	public void setEc01Bd02(String ec01Bd02) {
		this.ec01Bd02 = ec01Bd02;
	}
	private String    ec01Bi01 ;
	private String    ec01Bd03 ;
	private String    ec01Bd04 ;
	private String    ec01Bj01 ;
	private String    ec01Bd05 ;
	private String    ec01Bi02 ;
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
	        sb.append("batchId  = [" + batchId  + "], ");
	        sb.append("parentId = [" + parentId + "], ");
	        sb.append("ec01Bd01  = [" + ec01Bd01  + "], ");
	        sb.append("ec01Bq01  = [" + ec01Bq01  + "], ");
	        sb.append("ec01Bd02  = [" + ec01Bd02  + "], ");
			sb.append("ec01Bi01  = [" + ec01Bi01  + "], ");
			sb.append("ec01Bd03  = [" + ec01Bd03  + "], ");
			sb.append("ec01Bd04  = [" + ec01Bd04  + "], ");
			sb.append("ec01Bj01  = [" + ec01Bj01   + "], ");
			sb.append("ec01Bd05  = [" + ec01Bd05   + "], ");
			sb.append("ec01Bi02  = [" + ec01Bi02   + "], ");
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

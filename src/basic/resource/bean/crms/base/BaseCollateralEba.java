package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午4:48:58 
* 类说明 
*/
public abstract class BaseCollateralEba implements Serializable{
	/**
	 * 
	 */
	   private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
	private String   id;
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

	public String getEb01Ad06() {
		return eb01Ad06;
	}

	public void setEb01Ad06(String eb01Ad06) {
		this.eb01Ad06 = eb01Ad06;
	}

	public String getEb01Ad07() {
		return eb01Ad07;
	}

	public void setEb01Ad07(String eb01Ad07) {
		this.eb01Ad07 = eb01Ad07;
	}

	public String getEb01Ad03() {
		return eb01Ad03;
	}

	public void setEb01Ad03(String eb01Ad03) {
		this.eb01Ad03 = eb01Ad03;
	}

	public String getEb01Ad04() {
		return eb01Ad04;
	}

	public void setEb01Ad04(String eb01Ad04) {
		this.eb01Ad04 = eb01Ad04;
	}

	public String getEb01Ar01() {
		return eb01Ar01;
	}

	public void setEb01Ar01(String eb01Ar01) {
		this.eb01Ar01 = eb01Ar01;
	}

	public String getEb01Ad05() {
		return eb01Ad05;
	}

	public void setEb01Ad05(String eb01Ad05) {
		this.eb01Ad05 = eb01Ad05;
	}

	public String getEb01Aj01() {
		return eb01Aj01;
	}

	public void setEb01Aj01(String eb01Aj01) {
		this.eb01Aj01 = eb01Aj01;
	}

	public String getEb01Aj02() {
		return eb01Aj02;
	}

	public void setEb01Aj02(String eb01Aj02) {
		this.eb01Aj02 = eb01Aj02;
	}

	public String getEb01Ar02() {
		return eb01Ar02;
	}

	public void setEb01Ar02(String eb01Ar02) {
		this.eb01Ar02 = eb01Ar02;
	}

	public String getEb01Ad01() {
		return eb01Ad01;
	}

	public void setEb01Ad01(String eb01Ad01) {
		this.eb01Ad01 = eb01Ad01;
	}

	public String getEb01Ad02() {
		return eb01Ad02;
	}

	public void setEb01Ad02(String eb01Ad02) {
		this.eb01Ad02 = eb01Ad02;
	}

	public String getEb01Ar03() {
		return eb01Ar03;
	}

	public void setEb01Ar03(String eb01Ar03) {
		this.eb01Ar03 = eb01Ar03;
	}

	public String getEb01Bs01() {
		return eb01Bs01;
	}

	public void setEb01Bs01(String eb01Bs01) {
		this.eb01Bs01 = eb01Bs01;
	}

	public String getEb01Cs01() {
		return eb01Cs01;
	}

	public void setEb01Cs01(String eb01Cs01) {
		this.eb01Cs01 = eb01Cs01;
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
	private String   batchId;
	private String   eb01Ad06 ;
	private String   eb01Ad07 ;
	private String   eb01Ad03 ;
	private String   eb01Ad04 ;
	private String   eb01Ar01 ;
	private String   eb01Ad05 ;
	private String   eb01Aj01 ;
	private String   eb01Aj02 ;
	private String   eb01Ar02 ;
	private String   eb01Ad01 ;
	private String   eb01Ad02 ;
	private String   eb01Ar03 ;
	private String   eb01Bs01 ;
	private String   eb01Cs01 ;
	private String   rsv1     ;
	private String   rsv2     ;
	private String   rsv3     ;
	private String   rsv4     ;
	private String   rsv5     ;
	private String   rsv6     ;
	private String   rsv7     ;
	private String   rsv8     ;
	private String   rsv9     ;
	private String   rsv10    ;
	
	 public String toString(){
	        StringBuffer sb = new StringBuffer();
	        sb.append("id = [" + id + "], ");
	        sb.append("batchId = [" + batchId + "], ");
	        sb.append("eb01Ad06 = [" + eb01Ad06 + "], ");
	        sb.append("eb01Ad07 = [" + eb01Ad07 + "], ");
	        sb.append("eb01Ad03 = [" + eb01Ad03 + "], ");
	        sb.append("eb01Ad04 = [" + eb01Ad04 + "], ");
			sb.append("eb01Ar01 = [" + eb01Ar01 + "], ");
			sb.append("eb01Ad05 = [" + eb01Ad05 + "], ");
			sb.append("eb01Aj01 = [" + eb01Aj01 + "], ");
			sb.append("eb01Aj02 = [" + eb01Aj02 + "], ");
			sb.append("eb01Ar02 = [" + eb01Ar02 + "], ");
			sb.append("eb01Ad01 = [" + eb01Ad01 + "], ");
			sb.append("eb01Ad02 = [" + eb01Ad02 + "], ");
			sb.append("eb01Ar03  = [" +eb01Ar03  + "], ");
			sb.append("eb01Bs01=  [" + eb01Bs01 + "], ");
	        sb.append("eb01Cs01 = [" + eb01Cs01 + "], ");
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

package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午4:55:14 
* 类说明 
*/
public abstract class BaseCollateralEb01c implements Serializable{
	
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

	public String getEb01Ci01() {
		return eb01Ci01;
	}

	public void setEb01Ci01(String eb01Ci01) {
		this.eb01Ci01 = eb01Ci01;
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
	private String    eb01Ci01 ;
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
		sb.append("batchId   = [" + batchId   + "], ");
		sb.append("parentId  = [" + parentId  + "], ");
		sb.append("eb01Ci01   = [" + eb01Ci01   + "], ");
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

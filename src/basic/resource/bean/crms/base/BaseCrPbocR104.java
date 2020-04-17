package resource.bean.crms.base;

import java.io.Serializable;

/** 
* @author Grassy 
* @version 创建时间：2019年10月22日 下午5:09:57 
* 类说明 
*/
public abstract class BaseCrPbocR104 implements Serializable{
	  private static final long serialVersionUID = 1L;
	    public static long getSerialversionuid() {
			return serialVersionUID;
		}
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportMessagePath() {
		return reportMessagePath;
	}

	public void setReportMessagePath(String reportMessagePath) {
		this.reportMessagePath = reportMessagePath;
	}

	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}

	public String getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(String receiptTime) {
		this.receiptTime = receiptTime;
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
	private String resultCode       ;
	private String resultDesc       ;
	private String reportName       ;
	private String reportMessagePath ;
	private String recordStatus     ;
	private String receiptTime      ;
	private String rsv1                ;
	private String rsv2                ;
	private String rsv3                ;
	private String rsv4                ;
	private String rsv5                ;
	private String rsv6                ;
	private String rsv7                ;
	private String rsv8                ;
	private String rsv9                ;
	private String rsv10               ;
    
	public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("resultCode         = [" + resultCode        + "], ");
        sb.append("resultDesc         = [" + resultDesc        + "], ");
        sb.append("reportName         = [" + reportName        + "], ");
		sb.append("reportMessagePath = [" + reportMessagePath+ "], ");
		sb.append("recordStatus       = [" + recordStatus      + "], ");
		sb.append("receiptTime        = [" + receiptTime       + "], ");
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

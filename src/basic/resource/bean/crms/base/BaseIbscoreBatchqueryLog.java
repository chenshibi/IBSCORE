package resource.bean.crms.base;
import java.io.Serializable;

public abstract class BaseIbscoreBatchqueryLog implements Serializable {


    private static final long serialVersionUID = 1L;
    
    private String id;
    
    public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public String getCreateTime() {
		return createTime;
	}




	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getIsresponse() {
		return isresponse;
	}




	public void setIsresponse(String isresponse) {
		this.isresponse = isresponse;
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




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getFileId() {
		return fileId;
	}




	public void setFileId(String fileId) {
		this.fileId = fileId;
	}




	public String getFileName() {
		return fileName;
	}




	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	private String fileId;
	private String fileName;

	private String createTime;
    
    private String userId;
    
    private String isresponse;
    
    private String rsv1;
    
    private String rsv2;
    
    private String rsv3;




    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("name = [" + createTime + "], ");
        sb.append("idType = [" + userId + "], ");
        sb.append("idNum = [" + rsv1 + "], ");
        sb.append("idNum = [" + rsv2 + "], ");
        sb.append("idNum = [" + rsv3 + "], ");
        return sb.toString();
    }

}


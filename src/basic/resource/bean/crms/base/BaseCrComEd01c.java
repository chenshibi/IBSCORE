package resource.bean.crms.base;

import java.io.Serializable;

public abstract class BaseCrComEd01c implements Serializable {


    private static final long serialVersionUID = 1L;


    public static long getSerialversionuid() {
		return serialVersionUID;
	}


	java.lang.String id;
    java.lang.String ed01cs01;
    java.lang.String batchId;
    java.lang.String parentId;


    public java.lang.String getParentId() {
		return parentId;
	}
	public void setParentId(java.lang.String parentId) {
		this.parentId = parentId;
	}
	public java.lang.String getId(){
        return id;
    }
    public void setId(java.lang.String id){
        this.id = id;
    }

    public java.lang.String getEd01cs01(){
        return ed01cs01;
    }
    public void setEd01cs01(java.lang.String ed01cs01){
        this.ed01cs01 = ed01cs01;
    }

    public java.lang.String getBatchId(){
        return batchId;
    }
    public void setBatchId(java.lang.String batchId){
        this.batchId = batchId;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id = [" + id + "], ");
        sb.append("ed01cs01 = [" + ed01cs01 + "], ");
        sb.append("batchId = [" + batchId + "], ");
        sb.append("paraentId = [" + parentId + "], ");
        return sb.toString();
    }

}


package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.Bctl;


public abstract class BaseCustomerInfo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1537420505441376561L;
	/**
	 * 
	 */
    public static String REF = "CustomerInfo";
    public static String PROP_ID = "Id";
    public static String PROP_ID_TYPE= "IdType";
    public static String PROP_NAME = "Name";
    public static String PROP_CUSTOMER_UPLOAD= "CustomerUpload";
    public static String PROP_EXPIRE = "ExpireDate";
    

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key

    private String Id;
    private String IdType;
    private String Name;
    private String CustomerUpload;
    private String ExpireDate;


	public BaseCustomerInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	   public BaseCustomerInfo(java.lang.String id) {
	        this.setId(id);
	        initialize();
	    }


	public BaseCustomerInfo(int hashCode, String id, String idType,
			String name, String customerUpload, String expireDate) {
		super();
		this.hashCode = hashCode;
		Id = id;
		IdType = idType;
		Name = name;
		CustomerUpload = customerUpload;
		ExpireDate = expireDate;
	}


	public static String getREF() {
		return REF;
	}


	public static void setREF(String rEF) {
		REF = rEF;
	}


	public static String getPROP_ID() {
		return PROP_ID;
	}


	public static void setPROP_ID(String pROP_ID) {
		PROP_ID = pROP_ID;
	}


	public static String getPROP_ID_TYPE() {
		return PROP_ID_TYPE;
	}


	public static void setPROP_ID_TYPE(String pROP_ID_TYPE) {
		PROP_ID_TYPE = pROP_ID_TYPE;
	}


	public static String getPROP_NAME() {
		return PROP_NAME;
	}


	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}


	public static String getPROP_CUSTOMER_UPLOAD() {
		return PROP_CUSTOMER_UPLOAD;
	}


	public static void setPROP_CUSTOMER_UPLOAD(String pROP_CUSTOMER_UPLOAD) {
		PROP_CUSTOMER_UPLOAD = pROP_CUSTOMER_UPLOAD;
	}


	public static String getPROP_EXPIRE() {
		return PROP_EXPIRE;
	}


	public static void setPROP_EXPIRE(String pROP_EXPIRE) {
		PROP_EXPIRE = pROP_EXPIRE;
	}


	public int getHashCode() {
		return hashCode;
	}


	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}


	public String getId() {
		return Id;
	}


	public void setId(String id) {
		Id = id;
	}


	public String getIdType() {
		return IdType;
	}


	public void setIdType(String idType) {
		IdType = idType;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCustomerUpload() {
		return CustomerUpload;
	}


	public void setCustomerUpload(String customerUpload) {
		CustomerUpload = customerUpload;
	}


	public String getExpireDate() {
		return ExpireDate;
	}


	public void setExpireDate(String expireDate) {
		ExpireDate = expireDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    



    
    
}
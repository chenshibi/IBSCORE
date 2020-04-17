package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 * 
 */

public abstract class BaseTDetailIndInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6614834221276719303L;
	public static String PROP_ID = "id";
	public static String PROP_RPT_KEY = "rptKey";
	public static String PROP_NAME = "name";
	public static String PROP_INDIVIDUAL_TYPE = "individualType";
	public static String PROP_INDIVIDUAL_ID = "individualId";
	public static String PROP_ADDRESS = "address";
	public static String PROP_CONTACT_ADDRESS = "contactAddress";
	public static String PROP_PHONE = "phone";

	protected void initialize() {
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String rptKey;
	private java.lang.String name;
	private java.lang.String individualType;
	private java.lang.String individualId;
	private java.lang.String address;
	private java.lang.String contactAddress;
	private java.lang.String phone;

	public static String getPROP_ID() {
		return PROP_ID;
	}

	public static void setPROP_ID(String pROP_ID) {
		PROP_ID = pROP_ID;
	}

	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}

	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}

	public static String getPROP_NAME() {
		return PROP_NAME;
	}

	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}

	public static String getPROP_INDIVIDUAL_TYPE() {
		return PROP_INDIVIDUAL_TYPE;
	}

	public static void setPROP_INDIVIDUAL_TYPE(String pROP_INDIVIDUAL_TYPE) {
		PROP_INDIVIDUAL_TYPE = pROP_INDIVIDUAL_TYPE;
	}

	public static String getPROP_INDIVIDUAL_ID() {
		return PROP_INDIVIDUAL_ID;
	}

	public static void setPROP_INDIVIDUAL_ID(String pROP_INDIVIDUAL_ID) {
		PROP_INDIVIDUAL_ID = pROP_INDIVIDUAL_ID;
	}

	public static String getPROP_ADDRESS() {
		return PROP_ADDRESS;
	}

	public static void setPROP_ADDRESS(String pROP_ADDRESS) {
		PROP_ADDRESS = pROP_ADDRESS;
	}

	public static String getPROP_CONTACT_ADDRESS() {
		return PROP_CONTACT_ADDRESS;
	}

	public static void setPROP_CONTACT_ADDRESS(String pROP_CONTACT_ADDRESS) {
		PROP_CONTACT_ADDRESS = pROP_CONTACT_ADDRESS;
	}

	public static String getPROP_PHONE() {
		return PROP_PHONE;
	}

	public static void setPROP_PHONE(String pROP_PHONE) {
		PROP_PHONE = pROP_PHONE;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	public java.lang.Integer getId() {
		return id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.String getRptKey() {
		return rptKey;
	}

	public void setRptKey(java.lang.String rptKey) {
		this.rptKey = rptKey;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getIndividualType() {
		return individualType;
	}

	public void setIndividualType(java.lang.String individualType) {
		this.individualType = individualType;
	}

	public java.lang.String getIndividualId() {
		return individualId;
	}

	public void setIndividualId(java.lang.String individualId) {
		this.individualId = individualId;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(java.lang.String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public java.lang.String getPhone() {
		return phone;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BaseTDetailIndInfo(int hashCode, Integer id, String rptKey,
			String name, String individualType, String individualId,
			String address, String contactAddress, String phone) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.name = name;
		this.individualType = individualType;
		this.individualId = individualId;
		this.address = address;
		this.contactAddress = contactAddress;
		this.phone = phone;
	}

	public BaseTDetailIndInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
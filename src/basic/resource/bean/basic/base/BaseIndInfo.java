package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="IND_INFO"
 */

public abstract class BaseIndInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndInfo";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_ENQUIRY_DATE="enquiryDate";
    public static String PROP_REPORT_DATE="reportDate";
    public static String PROP_NAME="name";
    public static String PROP_IDTYPE="idType";
    public static String PROP_GENDER="gender";
    public static String PROP_ID_NUMBER="idNumber";
    public static String PROP_BIRTHDAY="birthday";
    public static String PROP_EDUCATION="education";
	public static String PROP_DEGREE="degree";
	public static String PROP_ADDR="addr";
	public static String PROP_POSTCODE="postcode";
	public static String PROP_HUKOU_ADDR="hukouAddr";
	public static String PROP_PHONE_LIV="phoneLiv";
	public static String PROP_PHPNE_COM="phoneCom";
	
	public static String PROP_MOBILE="mobile";
	public static String PROP__EMAIL="email";
	public static String PROP_MARRIAGE="marriage";
	public static String PROP_SPOUSE="spouse";
	public static String PROP_SPOUSE_ID_TYPE="spouseIdType";
	public static String PROP_SPOUSE_ID_NUMBER="spouseIdNumber";
	public static String PROP_SPOUSE_COM="spouseCom";
	public static String PROP_SPOUSE_PHONE="spousePhone";
	public static String PROP_NAME_QUERIED="nameQueried";
	public static String PROP_ID_TYPE_QUERIED="idTypeQueried";
	public static String PROP_ID_NO_QUERIED="idNoQueried";
	public static String PROP_ENQUIRY_RESON="enquiryReson";
	public static String PROP_VERIFY_RESULT="verifyResult";
	public static String PROP_ISSUE_ORG="issueOrg";
	public static String PROP_ENQUIRY_NAME="enquiryName";
	public static String PROP_GET_DATE="getDate";
	
	

    public BaseIndInfo() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.util.Date enquiryDate;
    private java.util.Date reportDate;
    private java.lang.String name;
    private java.lang.String idType;
    private java.lang.String gender;
    private java.lang.String idNumber;
    private java.util.Date birthday;
    private java.lang.String education;
    private java.lang.String degree;
	private java.lang.String addr;
	private java.lang.String postcode;
	private java.lang.String hukouAddr;
	private java.lang.String phoneLiv;
	private java.lang.String phoneCom;
	private java.lang.String mobile;
	private java.lang.String email;
	private java.lang.String marriage;
    private java.lang.String spouse;
    private java.lang.String spouseIdType;
    private java.lang.String spouseIdNumber;
    private java.lang.String spouseCom;
    private java.lang.String spousePhone;
    private java.lang.String nameQueried;
    private java.lang.String idTypeQueried;
    private java.lang.String idNoQueried;
    private java.lang.String enquiryReson;
    private java.lang.String verifyResult;
    private java.lang.String issueOrg;
    private java.lang.String enquiryName;
    private java.util.Date getDate;
    
    
    private java.lang.String dpdx;
    private java.lang.String maxLast12M;
    private java.lang.String creditCards;
    private java.lang.String personalLoans;
    private java.lang.String last12Months;
    private java.lang.String last6Months;
    
	public java.lang.String getDpdx() {
		return dpdx;
	}
	public void setDpdx(java.lang.String dpdx) {
		this.dpdx = dpdx;
	}
	public java.lang.String getMaxLast12M() {
		return maxLast12M;
	}
	public void setMaxLast12M(java.lang.String maxLast12M) {
		this.maxLast12M = maxLast12M;
	}
	public java.lang.String getCreditCards() {
		return creditCards;
	}
	public void setCreditCards(java.lang.String creditCards) {
		this.creditCards = creditCards;
	}
	public java.lang.String getPersonalLoans() {
		return personalLoans;
	}
	public void setPersonalLoans(java.lang.String personalLoans) {
		this.personalLoans = personalLoans;
	}
	public java.lang.String getLast12Months() {
		return last12Months;
	}
	public void setLast12Months(java.lang.String last12Months) {
		this.last12Months = last12Months;
	}
	public java.lang.String getLast6Months() {
		return last6Months;
	}
	public void setLast6Months(java.lang.String last6Months) {
		this.last6Months = last6Months;
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
	public static String getPROP_RPT_ID() {
		return PROP_RPT_ID;
	}
	public static void setPROP_RPT_ID(String pROP_RPT_ID) {
		PROP_RPT_ID = pROP_RPT_ID;
	}
	public static String getPROP_ENQUIRY_DATE() {
		return PROP_ENQUIRY_DATE;
	}
	public static void setPROP_ENQUIRY_DATE(String pROP_ENQUIRY_DATE) {
		PROP_ENQUIRY_DATE = pROP_ENQUIRY_DATE;
	}
	public static String getPROP_REPORT_DATE() {
		return PROP_REPORT_DATE;
	}
	public static void setPROP_REPORT_DATE(String pROP_REPORT_DATE) {
		PROP_REPORT_DATE = pROP_REPORT_DATE;
	}
	public static String getPROP_NAME() {
		return PROP_NAME;
	}
	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}
	public static String getPROP_IDTYPE() {
		return PROP_IDTYPE;
	}
	public static void setPROP_IDTYPE(String pROP_IDTYPE) {
		PROP_IDTYPE = pROP_IDTYPE;
	}
	public static String getPROP_GENDER() {
		return PROP_GENDER;
	}
	public static void setPROP_GENDER(String pROP_GENDER) {
		PROP_GENDER = pROP_GENDER;
	}
	public static String getPROP_ID_NUMBER() {
		return PROP_ID_NUMBER;
	}
	public static void setPROP_ID_NUMBER(String pROP_ID_NUMBER) {
		PROP_ID_NUMBER = pROP_ID_NUMBER;
	}
	public static String getPROP_BIRTHDAY() {
		return PROP_BIRTHDAY;
	}
	public static void setPROP_BIRTHDAY(String pROP_BIRTHDAY) {
		PROP_BIRTHDAY = pROP_BIRTHDAY;
	}
	public static String getPROP_EDUCATION() {
		return PROP_EDUCATION;
	}
	public static void setPROP_EDUCATION(String pROP_EDUCATION) {
		PROP_EDUCATION = pROP_EDUCATION;
	}
	public static String getPROP_DEGREE() {
		return PROP_DEGREE;
	}
	public static void setPROP_DEGREE(String pROP_DEGREE) {
		PROP_DEGREE = pROP_DEGREE;
	}
	public static String getPROP_ADDR() {
		return PROP_ADDR;
	}
	public static void setPROP_ADDR(String pROP_ADDR) {
		PROP_ADDR = pROP_ADDR;
	}
	public static String getPROP_POSTCODE() {
		return PROP_POSTCODE;
	}
	public static void setPROP_POSTCODE(String pROP_POSTCODE) {
		PROP_POSTCODE = pROP_POSTCODE;
	}
	public static String getPROP_HUKOU_ADDR() {
		return PROP_HUKOU_ADDR;
	}
	public static void setPROP_HUKOU_ADDR(String pROP_HUKOU_ADDR) {
		PROP_HUKOU_ADDR = pROP_HUKOU_ADDR;
	}
	public static String getPROP_PHONE_LIV() {
		return PROP_PHONE_LIV;
	}
	public static void setPROP_PHONE_LIV(String pROP_PHONE_LIV) {
		PROP_PHONE_LIV = pROP_PHONE_LIV;
	}
	public static String getPROP_PHPNE_COM() {
		return PROP_PHPNE_COM;
	}
	public static void setPROP_PHPNE_COM(String pROP_PHPNE_COM) {
		PROP_PHPNE_COM = pROP_PHPNE_COM;
	}
	public static String getPROP_MOBILE() {
		return PROP_MOBILE;
	}
	public static void setPROP_MOBILE(String pROP_MOBILE) {
		PROP_MOBILE = pROP_MOBILE;
	}
	public static String getPROP__EMAIL() {
		return PROP__EMAIL;
	}
	public static void setPROP__EMAIL(String pROP__EMAIL) {
		PROP__EMAIL = pROP__EMAIL;
	}
	public static String getPROP_MARRIAGE() {
		return PROP_MARRIAGE;
	}
	public static void setPROP_MARRIAGE(String pROP_MARRIAGE) {
		PROP_MARRIAGE = pROP_MARRIAGE;
	}
	public static String getPROP_SPOUSE() {
		return PROP_SPOUSE;
	}
	public static void setPROP_SPOUSE(String pROP_SPOUSE) {
		PROP_SPOUSE = pROP_SPOUSE;
	}
	public static String getPROP_SPOUSE_ID_TYPE() {
		return PROP_SPOUSE_ID_TYPE;
	}
	public static void setPROP_SPOUSE_ID_TYPE(String pROP_SPOUSE_ID_TYPE) {
		PROP_SPOUSE_ID_TYPE = pROP_SPOUSE_ID_TYPE;
	}
	public static String getPROP_SPOUSE_ID_NUMBER() {
		return PROP_SPOUSE_ID_NUMBER;
	}
	public static void setPROP_SPOUSE_ID_NUMBER(String pROP_SPOUSE_ID_NUMBER) {
		PROP_SPOUSE_ID_NUMBER = pROP_SPOUSE_ID_NUMBER;
	}
	public static String getPROP_SPOUSE_COM() {
		return PROP_SPOUSE_COM;
	}
	public static void setPROP_SPOUSE_COM(String pROP_SPOUSE_COM) {
		PROP_SPOUSE_COM = pROP_SPOUSE_COM;
	}
	public static String getPROP_SPOUSE_PHONE() {
		return PROP_SPOUSE_PHONE;
	}
	public static void setPROP_SPOUSE_PHONE(String pROP_SPOUSE_PHONE) {
		PROP_SPOUSE_PHONE = pROP_SPOUSE_PHONE;
	}
	public static String getPROP_NAME_QUERIED() {
		return PROP_NAME_QUERIED;
	}
	public static void setPROP_NAME_QUERIED(String pROP_NAME_QUERIED) {
		PROP_NAME_QUERIED = pROP_NAME_QUERIED;
	}
	public static String getPROP_ID_TYPE_QUERIED() {
		return PROP_ID_TYPE_QUERIED;
	}
	public static void setPROP_ID_TYPE_QUERIED(String pROP_ID_TYPE_QUERIED) {
		PROP_ID_TYPE_QUERIED = pROP_ID_TYPE_QUERIED;
	}
	public static String getPROP_ID_NO_QUERIED() {
		return PROP_ID_NO_QUERIED;
	}
	public static void setPROP_ID_NO_QUERIED(String pROP_ID_NO_QUERIED) {
		PROP_ID_NO_QUERIED = pROP_ID_NO_QUERIED;
	}
	public static String getPROP_ENQUIRY_RESON() {
		return PROP_ENQUIRY_RESON;
	}
	public static void setPROP_ENQUIRY_RESON(String pROP_ENQUIRY_RESON) {
		PROP_ENQUIRY_RESON = pROP_ENQUIRY_RESON;
	}
	public static String getPROP_VERIFY_RESULT() {
		return PROP_VERIFY_RESULT;
	}
	public static void setPROP_VERIFY_RESULT(String pROP_VERIFY_RESULT) {
		PROP_VERIFY_RESULT = pROP_VERIFY_RESULT;
	}
	public static String getPROP_ISSUE_ORG() {
		return PROP_ISSUE_ORG;
	}
	public static void setPROP_ISSUE_ORG(String pROP_ISSUE_ORG) {
		PROP_ISSUE_ORG = pROP_ISSUE_ORG;
	}
	public static String getPROP_ENQUIRY_NAME() {
		return PROP_ENQUIRY_NAME;
	}
	public static void setPROP_ENQUIRY_NAME(String pROP_ENQUIRY_NAME) {
		PROP_ENQUIRY_NAME = pROP_ENQUIRY_NAME;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
	}
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getRptId() {
		return rptId;
	}
	public void setRptId(java.lang.String rptId) {
		this.rptId = rptId;
	}
	public Date getEnquiryDate() {
		return enquiryDate;
	}
	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}
	public Date getReportDate() {
		return reportDate;
	}
	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getIdType() {
		return idType;
	}
	public void setIdType(java.lang.String idType) {
		this.idType = idType;
	}
	public java.lang.String getGender() {
		return gender;
	}
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}
	public java.lang.String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(java.lang.String idNumber) {
		this.idNumber = idNumber;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public java.lang.String getEducation() {
		return education;
	}
	public void setEducation(java.lang.String education) {
		this.education = education;
	}
	public java.lang.String getDegree() {
		return degree;
	}
	public void setDegree(java.lang.String degree) {
		this.degree = degree;
	}
	public java.lang.String getAddr() {
		return addr;
	}
	public void setAddr(java.lang.String addr) {
		this.addr = addr;
	}
	public java.lang.String getPostcode() {
		return postcode;
	}
	public void setPostcode(java.lang.String postcode) {
		this.postcode = postcode;
	}
	public java.lang.String getHukouAddr() {
		return hukouAddr;
	}
	public void setHukouAddr(java.lang.String hukouAddr) {
		this.hukouAddr = hukouAddr;
	}
	public java.lang.String getPhoneLiv() {
		return phoneLiv;
	}
	public void setPhoneLiv(java.lang.String phoneLiv) {
		this.phoneLiv = phoneLiv;
	}
	public java.lang.String getPhoneCom() {
		return phoneCom;
	}
	public void setPhoneCom(java.lang.String phoneCom) {
		this.phoneCom = phoneCom;
	}
	public java.lang.String getMobile() {
		return mobile;
	}
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	public java.lang.String getEmail() {
		return email;
	}
	public void setEmail(java.lang.String email) {
		this.email = email;
	}
	public java.lang.String getMarriage() {
		return marriage;
	}
	public void setMarriage(java.lang.String marriage) {
		this.marriage = marriage;
	}
	public java.lang.String getSpouse() {
		return spouse;
	}
	public void setSpouse(java.lang.String spouse) {
		this.spouse = spouse;
	}
	public java.lang.String getSpouseIdType() {
		return spouseIdType;
	}
	public void setSpouseIdType(java.lang.String spouseIdType) {
		this.spouseIdType = spouseIdType;
	}
	public java.lang.String getSpouseIdNumber() {
		return spouseIdNumber;
	}
	public void setSpouseIdNumber(java.lang.String spouseIdNumber) {
		this.spouseIdNumber = spouseIdNumber;
	}
	public java.lang.String getSpouseCom() {
		return spouseCom;
	}
	public void setSpouseCom(java.lang.String spouseCom) {
		this.spouseCom = spouseCom;
	}
	public java.lang.String getSpousePhone() {
		return spousePhone;
	}
	public void setSpousePhone(java.lang.String spousePhone) {
		this.spousePhone = spousePhone;
	}
	public java.lang.String getNameQueried() {
		return nameQueried;
	}
	public void setNameQueried(java.lang.String nameQueried) {
		this.nameQueried = nameQueried;
	}
	public java.lang.String getIdTypeQueried() {
		return idTypeQueried;
	}
	public void setIdTypeQueried(java.lang.String idTypeQueried) {
		this.idTypeQueried = idTypeQueried;
	}
	public java.lang.String getIdNoQueried() {
		return idNoQueried;
	}
	public void setIdNoQueried(java.lang.String idNoQueried) {
		this.idNoQueried = idNoQueried;
	}
	public java.lang.String getEnquiryReson() {
		return enquiryReson;
	}
	public void setEnquiryReson(java.lang.String enquiryReson) {
		this.enquiryReson = enquiryReson;
	}
	public java.lang.String getVerifyResult() {
		return verifyResult;
	}
	public void setVerifyResult(java.lang.String verifyResult) {
		this.verifyResult = verifyResult;
	}
	public java.lang.String getIssueOrg() {
		return issueOrg;
	}
	public void setIssueOrg(java.lang.String issueOrg) {
		this.issueOrg = issueOrg;
	}
	public java.lang.String getEnquiryName() {
		return enquiryName;
	}
	public void setEnquiryName(java.lang.String enquiryName) {
		this.enquiryName = enquiryName;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result
				+ ((creditCards == null) ? 0 : creditCards.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((dpdx == null) ? 0 : dpdx.hashCode());
		result = prime * result
				+ ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((enquiryDate == null) ? 0 : enquiryDate.hashCode());
		result = prime * result
				+ ((enquiryName == null) ? 0 : enquiryName.hashCode());
		result = prime * result
				+ ((enquiryReson == null) ? 0 : enquiryReson.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result
				+ ((hukouAddr == null) ? 0 : hukouAddr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((idNoQueried == null) ? 0 : idNoQueried.hashCode());
		result = prime * result
				+ ((idNumber == null) ? 0 : idNumber.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result
				+ ((idTypeQueried == null) ? 0 : idTypeQueried.hashCode());
		result = prime * result
				+ ((issueOrg == null) ? 0 : issueOrg.hashCode());
		result = prime * result
				+ ((last12Months == null) ? 0 : last12Months.hashCode());
		result = prime * result
				+ ((last6Months == null) ? 0 : last6Months.hashCode());
		result = prime * result
				+ ((marriage == null) ? 0 : marriage.hashCode());
		result = prime * result
				+ ((maxLast12M == null) ? 0 : maxLast12M.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nameQueried == null) ? 0 : nameQueried.hashCode());
		result = prime * result
				+ ((personalLoans == null) ? 0 : personalLoans.hashCode());
		result = prime * result
				+ ((phoneCom == null) ? 0 : phoneCom.hashCode());
		result = prime * result
				+ ((phoneLiv == null) ? 0 : phoneLiv.hashCode());
		result = prime * result
				+ ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result
				+ ((reportDate == null) ? 0 : reportDate.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((spouse == null) ? 0 : spouse.hashCode());
		result = prime * result
				+ ((spouseCom == null) ? 0 : spouseCom.hashCode());
		result = prime * result
				+ ((spouseIdNumber == null) ? 0 : spouseIdNumber.hashCode());
		result = prime * result
				+ ((spouseIdType == null) ? 0 : spouseIdType.hashCode());
		result = prime * result
				+ ((spousePhone == null) ? 0 : spousePhone.hashCode());
		result = prime * result
				+ ((verifyResult == null) ? 0 : verifyResult.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseIndInfo other = (BaseIndInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (creditCards == null) {
			if (other.creditCards != null)
				return false;
		} else if (!creditCards.equals(other.creditCards))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (dpdx == null) {
			if (other.dpdx != null)
				return false;
		} else if (!dpdx.equals(other.dpdx))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enquiryDate == null) {
			if (other.enquiryDate != null)
				return false;
		} else if (!enquiryDate.equals(other.enquiryDate))
			return false;
		if (enquiryName == null) {
			if (other.enquiryName != null)
				return false;
		} else if (!enquiryName.equals(other.enquiryName))
			return false;
		if (enquiryReson == null) {
			if (other.enquiryReson != null)
				return false;
		} else if (!enquiryReson.equals(other.enquiryReson))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (getDate == null) {
			if (other.getDate != null)
				return false;
		} else if (!getDate.equals(other.getDate))
			return false;
		if (hukouAddr == null) {
			if (other.hukouAddr != null)
				return false;
		} else if (!hukouAddr.equals(other.hukouAddr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idNoQueried == null) {
			if (other.idNoQueried != null)
				return false;
		} else if (!idNoQueried.equals(other.idNoQueried))
			return false;
		if (idNumber == null) {
			if (other.idNumber != null)
				return false;
		} else if (!idNumber.equals(other.idNumber))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (idTypeQueried == null) {
			if (other.idTypeQueried != null)
				return false;
		} else if (!idTypeQueried.equals(other.idTypeQueried))
			return false;
		if (issueOrg == null) {
			if (other.issueOrg != null)
				return false;
		} else if (!issueOrg.equals(other.issueOrg))
			return false;
		if (last12Months == null) {
			if (other.last12Months != null)
				return false;
		} else if (!last12Months.equals(other.last12Months))
			return false;
		if (last6Months == null) {
			if (other.last6Months != null)
				return false;
		} else if (!last6Months.equals(other.last6Months))
			return false;
		if (marriage == null) {
			if (other.marriage != null)
				return false;
		} else if (!marriage.equals(other.marriage))
			return false;
		if (maxLast12M == null) {
			if (other.maxLast12M != null)
				return false;
		} else if (!maxLast12M.equals(other.maxLast12M))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameQueried == null) {
			if (other.nameQueried != null)
				return false;
		} else if (!nameQueried.equals(other.nameQueried))
			return false;
		if (personalLoans == null) {
			if (other.personalLoans != null)
				return false;
		} else if (!personalLoans.equals(other.personalLoans))
			return false;
		if (phoneCom == null) {
			if (other.phoneCom != null)
				return false;
		} else if (!phoneCom.equals(other.phoneCom))
			return false;
		if (phoneLiv == null) {
			if (other.phoneLiv != null)
				return false;
		} else if (!phoneLiv.equals(other.phoneLiv))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (reportDate == null) {
			if (other.reportDate != null)
				return false;
		} else if (!reportDate.equals(other.reportDate))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (spouse == null) {
			if (other.spouse != null)
				return false;
		} else if (!spouse.equals(other.spouse))
			return false;
		if (spouseCom == null) {
			if (other.spouseCom != null)
				return false;
		} else if (!spouseCom.equals(other.spouseCom))
			return false;
		if (spouseIdNumber == null) {
			if (other.spouseIdNumber != null)
				return false;
		} else if (!spouseIdNumber.equals(other.spouseIdNumber))
			return false;
		if (spouseIdType == null) {
			if (other.spouseIdType != null)
				return false;
		} else if (!spouseIdType.equals(other.spouseIdType))
			return false;
		if (spousePhone == null) {
			if (other.spousePhone != null)
				return false;
		} else if (!spousePhone.equals(other.spousePhone))
			return false;
		if (verifyResult == null) {
			if (other.verifyResult != null)
				return false;
		} else if (!verifyResult.equals(other.verifyResult))
			return false;
		return true;
	}
	public BaseIndInfo(Integer id, String rptId, Date enquiryDate,
			Date reportDate, String name, String idType, String gender,
			String idNumber, Date birthday, String education, String degree,
			String addr, String postcode, String hukouAddr, String phoneLiv,
			String phoneCom, String mobile, String email, String marriage,
			String spouse, String spouseIdType, String spouseIdNumber,
			String spouseCom, String spousePhone, String nameQueried,
			String idTypeQueried, String idNoQueried, String enquiryReson,
			String verifyResult, String issueOrg, String enquiryName,
			Date getDate, String dpdx, String maxLast12M, String creditCards,
			String personalLoans, String last12Months, String last6Months) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.enquiryDate = enquiryDate;
		this.reportDate = reportDate;
		this.name = name;
		this.idType = idType;
		this.gender = gender;
		this.idNumber = idNumber;
		this.birthday = birthday;
		this.education = education;
		this.degree = degree;
		this.addr = addr;
		this.postcode = postcode;
		this.hukouAddr = hukouAddr;
		this.phoneLiv = phoneLiv;
		this.phoneCom = phoneCom;
		this.mobile = mobile;
		this.email = email;
		this.marriage = marriage;
		this.spouse = spouse;
		this.spouseIdType = spouseIdType;
		this.spouseIdNumber = spouseIdNumber;
		this.spouseCom = spouseCom;
		this.spousePhone = spousePhone;
		this.nameQueried = nameQueried;
		this.idTypeQueried = idTypeQueried;
		this.idNoQueried = idNoQueried;
		this.enquiryReson = enquiryReson;
		this.verifyResult = verifyResult;
		this.issueOrg = issueOrg;
		this.enquiryName = enquiryName;
		this.getDate = getDate;
		this.dpdx = dpdx;
		this.maxLast12M = maxLast12M;
		this.creditCards = creditCards;
		this.personalLoans = personalLoans;
		this.last12Months = last12Months;
		this.last6Months = last6Months;
	}
	

	
    
    
  
}
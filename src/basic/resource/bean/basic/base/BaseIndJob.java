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

public abstract class BaseIndJob implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndJob";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_NO="no";
    public static String PROP_NAME="name";
    public static String PROP_ADDR="addr";
    public static String PROP_POST="post";
    public static String PROP_INDUSTRY="industry";
    public static String PROP_PROFESSION="profession";
    public static String PROP_TITLE="title";
    public static String PROP_TITLE_TEC="titleTec";
    public static String PROP_INCOME="income";
    public static String PROP_STARTDATE="startdate";
    public static String PROP_STARTDATES="startdates";
    public static String PROP_GETDATE="getdate";
    
    public BaseIndJob() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.Integer no;
    private java.lang.String name;
    private java.lang.String addr;
    private java.lang.String post;
    private java.lang.String industry;
    private java.lang.String profession;
    private java.lang.String title;
    private java.lang.String titleTec;
    private java.lang.String income;
    private java.util.Date startdate;
    private java.lang.String startdates;
    private java.util.Date getdate;

	public BaseIndJob(Integer id, String rptId, Integer no, String name,
			String addr, String post, String industry, String profession,
			String title, String titleTec, String income, Date startdate,
			String startdates, Date getdate) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.no = no;
		this.name = name;
		this.addr = addr;
		this.post = post;
		this.industry = industry;
		this.profession = profession;
		this.title = title;
		this.titleTec = titleTec;
		this.income = income;
		this.startdate = startdate;
		this.startdates = startdates;
		this.getdate = getdate;
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

	public static String getPROP_NO() {
		return PROP_NO;
	}

	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}

	public static String getPROP_NAME() {
		return PROP_NAME;
	}

	public static void setPROP_NAME(String pROP_NAME) {
		PROP_NAME = pROP_NAME;
	}

	public static String getPROP_ADDR() {
		return PROP_ADDR;
	}

	public static void setPROP_ADDR(String pROP_ADDR) {
		PROP_ADDR = pROP_ADDR;
	}

	public static String getPROP_POST() {
		return PROP_POST;
	}

	public static void setPROP_POST(String pROP_POST) {
		PROP_POST = pROP_POST;
	}

	public static String getPROP_INDUSTRY() {
		return PROP_INDUSTRY;
	}

	public static void setPROP_INDUSTRY(String pROP_INDUSTRY) {
		PROP_INDUSTRY = pROP_INDUSTRY;
	}

	public static String getPROP_PROFESSION() {
		return PROP_PROFESSION;
	}

	public static void setPROP_PROFESSION(String pROP_PROFESSION) {
		PROP_PROFESSION = pROP_PROFESSION;
	}

	public static String getPROP_TITLE() {
		return PROP_TITLE;
	}

	public static void setPROP_TITLE(String pROP_TITLE) {
		PROP_TITLE = pROP_TITLE;
	}

	public static String getPROP_TITLE_TEC() {
		return PROP_TITLE_TEC;
	}

	public static void setPROP_TITLE_TEC(String pROP_TITLE_TEC) {
		PROP_TITLE_TEC = pROP_TITLE_TEC;
	}

	public static String getPROP_INCOME() {
		return PROP_INCOME;
	}

	public static void setPROP_INCOME(String pROP_INCOME) {
		PROP_INCOME = pROP_INCOME;
	}

	public static String getPROP_STARTDATE() {
		return PROP_STARTDATE;
	}

	public static void setPROP_STARTDATE(String pROP_STARTDATE) {
		PROP_STARTDATE = pROP_STARTDATE;
	}

	public static String getPROP_STARTDATES() {
		return PROP_STARTDATES;
	}

	public static void setPROP_STARTDATES(String pROP_STARTDATES) {
		PROP_STARTDATES = pROP_STARTDATES;
	}

	public static String getPROP_GETDATE() {
		return PROP_GETDATE;
	}

	public static void setPROP_GETDATE(String pROP_GETDATE) {
		PROP_GETDATE = pROP_GETDATE;
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

	public java.lang.Integer getNo() {
		return no;
	}

	public void setNo(java.lang.Integer no) {
		this.no = no;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getAddr() {
		return addr;
	}

	public void setAddr(java.lang.String addr) {
		this.addr = addr;
	}

	public java.lang.String getPost() {
		return post;
	}

	public void setPost(java.lang.String post) {
		this.post = post;
	}

	public java.lang.String getIndustry() {
		return industry;
	}

	public void setIndustry(java.lang.String industry) {
		this.industry = industry;
	}

	public java.lang.String getProfession() {
		return profession;
	}

	public void setProfession(java.lang.String profession) {
		this.profession = profession;
	}

	public java.lang.String getTitle() {
		return title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitleTec() {
		return titleTec;
	}

	public void setTitleTec(java.lang.String titleTec) {
		this.titleTec = titleTec;
	}

	public java.lang.String getIncome() {
		return income;
	}

	public void setIncome(java.lang.String income) {
		this.income = income;
	}

	public java.util.Date getStartdate() {
		return startdate;
	}

	public void setStartdate(java.util.Date startdate) {
		this.startdate = startdate;
	}

	public java.lang.String getStartdates() {
		return startdates;
	}

	public void setStartdates(java.lang.String startdates) {
		this.startdates = startdates;
	}

	public java.util.Date getGetdate() {
		return getdate;
	}

	public void setGetdate(java.util.Date getdate) {
		this.getdate = getdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BaseIndJob [id=" + id + ", rptId=" + rptId + ", no=" + no
				+ ", name=" + name + ", addr=" + addr + ", post=" + post
				+ ", industry=" + industry + ", profession=" + profession
				+ ", title=" + title + ", titleTec=" + titleTec + ", income="
				+ income + ", startdate=" + startdate + ", startdates="
				+ startdates + ", getdate=" + getdate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((getdate == null) ? 0 : getdate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((income == null) ? 0 : income.hashCode());
		result = prime * result
				+ ((industry == null) ? 0 : industry.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result
				+ ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result
				+ ((startdate == null) ? 0 : startdate.hashCode());
		result = prime * result
				+ ((startdates == null) ? 0 : startdates.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((titleTec == null) ? 0 : titleTec.hashCode());
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
		BaseIndJob other = (BaseIndJob) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (getdate == null) {
			if (other.getdate != null)
				return false;
		} else if (!getdate.equals(other.getdate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (income == null) {
			if (other.income != null)
				return false;
		} else if (!income.equals(other.income))
			return false;
		if (industry == null) {
			if (other.industry != null)
				return false;
		} else if (!industry.equals(other.industry))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (startdate == null) {
			if (other.startdate != null)
				return false;
		} else if (!startdate.equals(other.startdate))
			return false;
		if (startdates == null) {
			if (other.startdates != null)
				return false;
		} else if (!startdates.equals(other.startdates))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (titleTec == null) {
			if (other.titleTec != null)
				return false;
		} else if (!titleTec.equals(other.titleTec))
			return false;
		return true;
	}
    

    
  
}
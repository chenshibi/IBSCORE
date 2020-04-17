package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;


/**
 * This is an object that contains data related to the BCTL table. Do not modify
 * this class because it will be overwritten if the configuration file related
 * to this class is modified.
 *
 * @hibernate.class table="t_corp_app"
 */

public abstract class BaseTCorpPunishRecord implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "TCorpPunishRecord";
    public static String PROP_ID="id";
    public static String PROP_RPT_KEY="rptKey";
    public static String PROP_CREATE_TIME="createTime";
    public static String PROP_ITEM_NAME="itemName";
    public static String PROP_ORGAN="organ";
    public static String PROP_PUNISH_DOC_NO="punishDocNo";
    public static String PROP_ILLEGAL_ACT="illegalAct";
    public static String PROP_PUNISH_DATE="punishDate";
    public static String PROP_PUNISH_DECISION="punishDecision";
	public static String PROP_PUNISH_AMOUNT="punishAmount";
	public static String PROP_PUNISH_SITUATION="punishSituation";
	public static String PROP_REVIEW_RESULT="reviewResult";

	public BaseTCorpPunishRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptKey;
    private java.util.Date createTime;
    private java.lang.String itemName;
    private java.lang.String organ;
    private java.lang.String punishDocNo;
    private java.lang.String illegalAct;
    private java.lang.String punishDate;
    private java.lang.String punishDecision;
    private java.lang.String punishAmount;
    private java.lang.String punishSituation;
    private java.lang.String reviewResult;

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
	public static String getPROP_RPT_KEY() {
		return PROP_RPT_KEY;
	}
	public static void setPROP_RPT_KEY(String pROP_RPT_KEY) {
		PROP_RPT_KEY = pROP_RPT_KEY;
	}
	public static String getPROP_CREATE_TIME() {
		return PROP_CREATE_TIME;
	}
	public static void setPROP_CREATE_TIME(String pROP_CREATE_TIME) {
		PROP_CREATE_TIME = pROP_CREATE_TIME;
	}
	public static String getPROP_ITEM_NAME() {
		return PROP_ITEM_NAME;
	}
	public static void setPROP_ITEM_NAME(String pROP_ITEM_NAME) {
		PROP_ITEM_NAME = pROP_ITEM_NAME;
	}
	public static String getPROP_ORGAN() {
		return PROP_ORGAN;
	}
	public static void setPROP_ORGAN(String pROP_ORGAN) {
		PROP_ORGAN = pROP_ORGAN;
	}
	public static String getPROP_PUNISH_DOC_NO() {
		return PROP_PUNISH_DOC_NO;
	}
	public static void setPROP_PUNISH_DOC_NO(String pROP_PUNISH_DOC_NO) {
		PROP_PUNISH_DOC_NO = pROP_PUNISH_DOC_NO;
	}
	public static String getPROP_ILLEGAL_ACT() {
		return PROP_ILLEGAL_ACT;
	}
	public static void setPROP_ILLEGAL_ACT(String pROP_ILLEGAL_ACT) {
		PROP_ILLEGAL_ACT = pROP_ILLEGAL_ACT;
	}
	public static String getPROP_PUNISH_DATE() {
		return PROP_PUNISH_DATE;
	}
	public static void setPROP_PUNISH_DATE(String pROP_PUNISH_DATE) {
		PROP_PUNISH_DATE = pROP_PUNISH_DATE;
	}
	public static String getPROP_PUNISH_DECISION() {
		return PROP_PUNISH_DECISION;
	}
	public static void setPROP_PUNISH_DECISION(String pROP_PUNISH_DECISION) {
		PROP_PUNISH_DECISION = pROP_PUNISH_DECISION;
	}
	public static String getPROP_PUNISH_AMOUNT() {
		return PROP_PUNISH_AMOUNT;
	}
	public static void setPROP_PUNISH_AMOUNT(String pROP_PUNISH_AMOUNT) {
		PROP_PUNISH_AMOUNT = pROP_PUNISH_AMOUNT;
	}
	public static String getPROP_PUNISH_SITUATION() {
		return PROP_PUNISH_SITUATION;
	}
	public static void setPROP_PUNISH_SITUATION(String pROP_PUNISH_SITUATION) {
		PROP_PUNISH_SITUATION = pROP_PUNISH_SITUATION;
	}
	public static String getPROP_REVIEW_RESULT() {
		return PROP_REVIEW_RESULT;
	}
	public static void setPROP_REVIEW_RESULT(String pROP_REVIEW_RESULT) {
		PROP_REVIEW_RESULT = pROP_REVIEW_RESULT;
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
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getItemName() {
		return itemName;
	}
	public void setItemName(java.lang.String itemName) {
		this.itemName = itemName;
	}
	public java.lang.String getOrgan() {
		return organ;
	}
	public void setOrgan(java.lang.String organ) {
		this.organ = organ;
	}
	public java.lang.String getPunishDocNo() {
		return punishDocNo;
	}
	public void setPunishDocNo(java.lang.String punishDocNo) {
		this.punishDocNo = punishDocNo;
	}
	public java.lang.String getIllegalAct() {
		return illegalAct;
	}
	public void setIllegalAct(java.lang.String illegalAct) {
		this.illegalAct = illegalAct;
	}
	public java.lang.String getPunishDate() {
		return punishDate;
	}
	public void setPunishDate(java.lang.String punishDate) {
		this.punishDate = punishDate;
	}
	public java.lang.String getPunishDecision() {
		return punishDecision;
	}
	public void setPunishDecision(java.lang.String punishDecision) {
		this.punishDecision = punishDecision;
	}
	public java.lang.String getPunishAmount() {
		return punishAmount;
	}
	public void setPunishAmount(java.lang.String punishAmount) {
		this.punishAmount = punishAmount;
	}
	public java.lang.String getPunishSituation() {
		return punishSituation;
	}
	public void setPunishSituation(java.lang.String punishSituation) {
		this.punishSituation = punishSituation;
	}
	public java.lang.String getReviewResult() {
		return reviewResult;
	}
	public void setReviewResult(java.lang.String reviewResult) {
		this.reviewResult = reviewResult;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((illegalAct == null) ? 0 : illegalAct.hashCode());
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((organ == null) ? 0 : organ.hashCode());
		result = prime * result
				+ ((punishAmount == null) ? 0 : punishAmount.hashCode());
		result = prime * result
				+ ((punishDate == null) ? 0 : punishDate.hashCode());
		result = prime * result
				+ ((punishDecision == null) ? 0 : punishDecision.hashCode());
		result = prime * result
				+ ((punishDocNo == null) ? 0 : punishDocNo.hashCode());
		result = prime * result
				+ ((punishSituation == null) ? 0 : punishSituation.hashCode());
		result = prime * result
				+ ((reviewResult == null) ? 0 : reviewResult.hashCode());
		result = prime * result + ((rptKey == null) ? 0 : rptKey.hashCode());
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
		BaseTCorpPunishRecord other = (BaseTCorpPunishRecord) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (illegalAct == null) {
			if (other.illegalAct != null)
				return false;
		} else if (!illegalAct.equals(other.illegalAct))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (organ == null) {
			if (other.organ != null)
				return false;
		} else if (!organ.equals(other.organ))
			return false;
		if (punishAmount == null) {
			if (other.punishAmount != null)
				return false;
		} else if (!punishAmount.equals(other.punishAmount))
			return false;
		if (punishDate == null) {
			if (other.punishDate != null)
				return false;
		} else if (!punishDate.equals(other.punishDate))
			return false;
		if (punishDecision == null) {
			if (other.punishDecision != null)
				return false;
		} else if (!punishDecision.equals(other.punishDecision))
			return false;
		if (punishDocNo == null) {
			if (other.punishDocNo != null)
				return false;
		} else if (!punishDocNo.equals(other.punishDocNo))
			return false;
		if (punishSituation == null) {
			if (other.punishSituation != null)
				return false;
		} else if (!punishSituation.equals(other.punishSituation))
			return false;
		if (reviewResult == null) {
			if (other.reviewResult != null)
				return false;
		} else if (!reviewResult.equals(other.reviewResult))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}
	public BaseTCorpPunishRecord(int hashCode, Integer id, String rptKey,
			Date createTime, String itemName, String organ, String punishDocNo,
			String illegalAct, String punishDate, String punishDecision,
			String punishAmount, String punishSituation, String reviewResult) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.createTime = createTime;
		this.itemName = itemName;
		this.organ = organ;
		this.punishDocNo = punishDocNo;
		this.illegalAct = illegalAct;
		this.punishDate = punishDate;
		this.punishDecision = punishDecision;
		this.punishAmount = punishAmount;
		this.punishSituation = punishSituation;
		this.reviewResult = reviewResult;
	}

    

    
}
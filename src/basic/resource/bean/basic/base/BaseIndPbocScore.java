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

public abstract class BaseIndPbocScore implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "IndPbocScore";
    public static String PROP_ID="id";
    public static String PROP_RPT_ID="rptId";
    public static String PROP_SCORE_DATE="scoreDate";
    public static String PROP_SCORE_PERCENTILE="scorePercentile";
    public static String PROP_SCORE_DESCRIPTION="scoreDescription";
    public static String PROP_PBOC_SCORE="pbocScore";
    public static String PROP_GET_DATE="getDate";
    public static String PROP_SCORE="score";

    public BaseIndPbocScore() {
		super();
	}


    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.String rptId;
    private java.lang.String scoreDate;
    private java.lang.String scorePercentile;
    private java.lang.String scoreDescription;
    private java.lang.String pbocScore;
    private java.util.Date getDate;
    private java.lang.Float score;

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
	public static String getPROP_SCORE_DATE() {
		return PROP_SCORE_DATE;
	}
	public static void setPROP_SCORE_DATE(String pROP_SCORE_DATE) {
		PROP_SCORE_DATE = pROP_SCORE_DATE;
	}
	public static String getPROP_SCORE_PERCENTILE() {
		return PROP_SCORE_PERCENTILE;
	}
	public static void setPROP_SCORE_PERCENTILE(String pROP_SCORE_PERCENTILE) {
		PROP_SCORE_PERCENTILE = pROP_SCORE_PERCENTILE;
	}
	public static String getPROP_SCORE_DESCRIPTION() {
		return PROP_SCORE_DESCRIPTION;
	}
	public static void setPROP_SCORE_DESCRIPTION(String pROP_SCORE_DESCRIPTION) {
		PROP_SCORE_DESCRIPTION = pROP_SCORE_DESCRIPTION;
	}
	public static String getPROP_PBOC_SCORE() {
		return PROP_PBOC_SCORE;
	}
	public static void setPROP_PBOC_SCORE(String pROP_PBOC_SCORE) {
		PROP_PBOC_SCORE = pROP_PBOC_SCORE;
	}
	public static String getPROP_GET_DATE() {
		return PROP_GET_DATE;
	}
	public static void setPROP_GET_DATE(String pROP_GET_DATE) {
		PROP_GET_DATE = pROP_GET_DATE;
	}
	public static String getPROP_SCORE() {
		return PROP_SCORE;
	}
	public static void setPROP_SCORE(String pROP_SCORE) {
		PROP_SCORE = pROP_SCORE;
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
	public java.lang.String getScoreDate() {
		return scoreDate;
	}
	public void setScoreDate(java.lang.String scoreDate) {
		this.scoreDate = scoreDate;
	}
	public java.lang.String getScorePercentile() {
		return scorePercentile;
	}
	public void setScorePercentile(java.lang.String scorePercentile) {
		this.scorePercentile = scorePercentile;
	}
	public java.lang.String getScoreDescription() {
		return scoreDescription;
	}
	public void setScoreDescription(java.lang.String scoreDescription) {
		this.scoreDescription = scoreDescription;
	}
	public java.lang.String getPbocScore() {
		return pbocScore;
	}
	public void setPbocScore(java.lang.String pbocScore) {
		this.pbocScore = pbocScore;
	}
	public java.util.Date getGetDate() {
		return getDate;
	}
	public void setGetDate(java.util.Date getDate) {
		this.getDate = getDate;
	}
	public java.lang.Float getScore() {
		return score;
	}
	public void setScore(java.lang.Float score) {
		this.score = score;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDate == null) ? 0 : getDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((pbocScore == null) ? 0 : pbocScore.hashCode());
		result = prime * result + ((rptId == null) ? 0 : rptId.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
		result = prime * result
				+ ((scoreDate == null) ? 0 : scoreDate.hashCode());
		result = prime
				* result
				+ ((scoreDescription == null) ? 0 : scoreDescription.hashCode());
		result = prime * result
				+ ((scorePercentile == null) ? 0 : scorePercentile.hashCode());
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
		BaseIndPbocScore other = (BaseIndPbocScore) obj;
		if (getDate == null) {
			if (other.getDate != null)
				return false;
		} else if (!getDate.equals(other.getDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pbocScore == null) {
			if (other.pbocScore != null)
				return false;
		} else if (!pbocScore.equals(other.pbocScore))
			return false;
		if (rptId == null) {
			if (other.rptId != null)
				return false;
		} else if (!rptId.equals(other.rptId))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		if (scoreDate == null) {
			if (other.scoreDate != null)
				return false;
		} else if (!scoreDate.equals(other.scoreDate))
			return false;
		if (scoreDescription == null) {
			if (other.scoreDescription != null)
				return false;
		} else if (!scoreDescription.equals(other.scoreDescription))
			return false;
		if (scorePercentile == null) {
			if (other.scorePercentile != null)
				return false;
		} else if (!scorePercentile.equals(other.scorePercentile))
			return false;
		return true;
	}
	public BaseIndPbocScore(Integer id, String rptId, String scoreDate,
			String scorePercentile, String scoreDescription, String pbocScore,
			Date getDate, Float score) {
		super();
		this.id = id;
		this.rptId = rptId;
		this.scoreDate = scoreDate;
		this.scorePercentile = scorePercentile;
		this.scoreDescription = scoreDescription;
		this.pbocScore = pbocScore;
		this.getDate = getDate;
		this.score = score;
	}

    
	
    
    
  
}
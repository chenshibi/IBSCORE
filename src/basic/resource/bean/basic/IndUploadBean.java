package resource.bean.basic;

/**
 * excel列表
 * 
 * @author jason.mao
 *
 */
@SuppressWarnings("ucd")
public class IndUploadBean {
    private String idType;
    private String individualId;
    private String name;
    private String relCustId;
    private String queryReason;
    private String applicationNo;
    private String loanNo;
    private String relationshipNo;
    private String inqCustType;
    private String relCorpId;
    private String corpName;
    private String relCustIdType;
    private String relName;
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIndividualId() {
		return individualId;
	}
	public void setIndividualId(String individualId) {
		this.individualId = individualId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRelCustId() {
		return relCustId;
	}
	public void setRelCustId(String relCustId) {
		this.relCustId = relCustId;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getRelationshipNo() {
		return relationshipNo;
	}
	public void setRelationshipNo(String relationshipNo) {
		this.relationshipNo = relationshipNo;
	}
	public String getInqCustType() {
		return inqCustType;
	}
	public void setInqCustType(String inqCustType) {
		this.inqCustType = inqCustType;
	}
	public String getRelCorpId() {
		return relCorpId;
	}
	public void setRelCorpId(String relCorpId) {
		this.relCorpId = relCorpId;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getRelCustIdType() {
		return relCustIdType;
	}
	public void setRelCustIdType(String relCustIdType) {
		this.relCustIdType = relCustIdType;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	
	
	public IndUploadBean() {
		super();
	}
	public IndUploadBean(String idType, String individualId, String name,
			String relCustId, String queryReason, String applicationNo,
			String loanNo, String relationshipNo, String inqCustType,
			String relCorpId, String corpName, String relCustIdType,
			String relName) {
		super();
		this.idType = idType;
		this.individualId = individualId;
		this.name = name;
		this.relCustId = relCustId;
		this.queryReason = queryReason;
		this.applicationNo = applicationNo;
		this.loanNo = loanNo;
		this.relationshipNo = relationshipNo;
		this.inqCustType = inqCustType;
		this.relCorpId = relCorpId;
		this.corpName = corpName;
		this.relCustIdType = relCustIdType;
		this.relName = relName;
	}
    
    
}

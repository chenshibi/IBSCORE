package resource.bean.basic;

/**
 * excel列表
 * 
 * @author jason.mao
 *
 */
@SuppressWarnings("ucd")
public class TCorpUploadBean {
    private String loanCardNo;
    private String loanCardPass;
    private String corpName;
    private String orgCode;
    private String loanNo;
    private String queryType;
    private String queryReason;
    private String custType;
    private String assureLoanCardNo;
    private String assureCorpName;
    private String dealQuery;
	public String getLoanCardNo() {
		return loanCardNo;
	}
	public void setLoanCardNo(String loanCardNo) {
		this.loanCardNo = loanCardNo;
	}
	public String getLoanCardPass() {
		return loanCardPass;
	}
	public void setLoanCardPass(String loanCardPass) {
		this.loanCardPass = loanCardPass;
	}
	public String getCorpName() {
		return corpName;
	}
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getLoanNo() {
		return loanNo;
	}
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getQueryReason() {
		return queryReason;
	}
	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getAssureLoanCardNo() {
		return assureLoanCardNo;
	}
	public void setAssureLoanCardNo(String assureLoanCardNo) {
		this.assureLoanCardNo = assureLoanCardNo;
	}
	public String getAssureCorpName() {
		return assureCorpName;
	}
	public void setAssureCorpName(String assureCorpName) {
		this.assureCorpName = assureCorpName;
	}
	public String getDealQuery() {
		return dealQuery;
	}
	public void setDealQuery(String dealQuery) {
		this.dealQuery = dealQuery;
	}
	public TCorpUploadBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TCorpUploadBean(String loanCardNo, String loanCardPass,
			String corpName, String orgCode, String loan_no, String queryType,
			String queryReason, String custType, String assureLoanCardNo,
			String assureCorpName, String dealQuery) {
		super();
		this.loanCardNo = loanCardNo;
		this.loanCardPass = loanCardPass;
		this.corpName = corpName;
		this.orgCode = orgCode;
		this.loanNo = loanNo;
		this.queryType = queryType;
		this.queryReason = queryReason;
		this.custType = custType;
		this.assureLoanCardNo = assureLoanCardNo;
		this.assureCorpName = assureCorpName;
		this.dealQuery = dealQuery;
	}
	@Override
	public String toString() {
		return "TCorpUploadBean [loanCardNo=" + loanCardNo + ", loanCardPass="
				+ loanCardPass + ", corpName=" + corpName + ", orgCode="
				+ orgCode + ", loan_no=" + loanNo + ", queryType=" + queryType
				+ ", queryReason=" + queryReason + ", custType=" + custType
				+ ", assureLoanCardNo=" + assureLoanCardNo
				+ ", assureCorpName=" + assureCorpName + ", dealQuery="
				+ dealQuery + "]";
	}
    
}

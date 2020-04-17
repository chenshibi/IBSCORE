package resource.bean.basic.base;

import java.io.Serializable;

public class BaseAssureIndPledgeList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2630080946120920840L;
	public static String PROP_ID="id";
	public static String PROP_RPT_KEY="rptKey";
	public static String PROP_CONTRACT_TYPE="contractType";
	public static String PROP_NO="no";
	public static String PROP_CONTRACT_NO="contractNo";
	public static String PROP_PLEDGE_NO="pledgeNo";
	public static String PROP_PLEDGE_AMOUNT="pledgeAmount";
	public static String PROP_PLEDGE_CURRENCY="pledgeCurrency";
	public static String PROP_PLEDGE_EST_AMOUNT="pledgeEstAmount";
	public static String PROP_PLEDGE_EST_CURRENCY="pledgeEstCurrency";
	public static String PROP_EST_DATE="estDate";
	public static String PROP_EST_ORG_NAME="estOrgName";
	public static String PROP_EST_ORG_CODE="estOrgCode";
	public static String PROP_PLEDGE_TYPE="pledgeType";
	public static String PROP_REGISTER_ORG="registerOrg";
	public static String PROP_REGISTER_DATE="registerDate";
	public static String PROP_PLEDGE_DESC="pledgeDesc";
	
	
	protected void initialize() {}

	private int hashCode = Integer.MIN_VALUE;
	
	
	 // primary key
    private java.lang.Integer id;
    
	private java.lang.String rptKey;
	private java.lang.String contractType;
	private java.lang.String no;
	private java.lang.String contractNo;
	private java.lang.String pledgeNo;
	private java.lang.Float pledgeAmount;
	private java.lang.String pledgeCurrency;
	private java.lang.Float pledgeEstAmount;
	private java.lang.String pledgeEstCurrency;
	private java.lang.String estDate;
	private java.lang.String estOrgName;
	private java.lang.String estOrgCode;
	private java.lang.String pledgeType;
	private java.lang.String registerOrg;
	private java.lang.String registerDate;
	private java.lang.String pledgeDesc;


	
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



	public static String getPROP_CONTRACT_TYPE() {
		return PROP_CONTRACT_TYPE;
	}



	public static void setPROP_CONTRACT_TYPE(String pROP_CONTRACT_TYPE) {
		PROP_CONTRACT_TYPE = pROP_CONTRACT_TYPE;
	}



	public static String getPROP_NO() {
		return PROP_NO;
	}



	public static void setPROP_NO(String pROP_NO) {
		PROP_NO = pROP_NO;
	}



	public static String getPROP_CONTRACT_NO() {
		return PROP_CONTRACT_NO;
	}



	public static void setPROP_CONTRACT_NO(String pROP_CONTRACT_NO) {
		PROP_CONTRACT_NO = pROP_CONTRACT_NO;
	}



	public static String getPROP_PLEDGE_NO() {
		return PROP_PLEDGE_NO;
	}



	public static void setPROP_PLEDGE_NO(String pROP_PLEDGE_NO) {
		PROP_PLEDGE_NO = pROP_PLEDGE_NO;
	}



	public static String getPROP_PLEDGE_AMOUNT() {
		return PROP_PLEDGE_AMOUNT;
	}



	public static void setPROP_PLEDGE_AMOUNT(String pROP_PLEDGE_AMOUNT) {
		PROP_PLEDGE_AMOUNT = pROP_PLEDGE_AMOUNT;
	}



	public static String getPROP_PLEDGE_CURRENCY() {
		return PROP_PLEDGE_CURRENCY;
	}



	public static void setPROP_PLEDGE_CURRENCY(String pROP_PLEDGE_CURRENCY) {
		PROP_PLEDGE_CURRENCY = pROP_PLEDGE_CURRENCY;
	}



	public static String getPROP_PLEDGE_EST_AMOUNT() {
		return PROP_PLEDGE_EST_AMOUNT;
	}



	public static void setPROP_PLEDGE_EST_AMOUNT(String pROP_PLEDGE_EST_AMOUNT) {
		PROP_PLEDGE_EST_AMOUNT = pROP_PLEDGE_EST_AMOUNT;
	}



	public static String getPROP_PLEDGE_EST_CURRENCY() {
		return PROP_PLEDGE_EST_CURRENCY;
	}



	public static void setPROP_PLEDGE_EST_CURRENCY(String pROP_PLEDGE_EST_CURRENCY) {
		PROP_PLEDGE_EST_CURRENCY = pROP_PLEDGE_EST_CURRENCY;
	}



	public static String getPROP_EST_DATE() {
		return PROP_EST_DATE;
	}



	public static void setPROP_EST_DATE(String pROP_EST_DATE) {
		PROP_EST_DATE = pROP_EST_DATE;
	}



	public static String getPROP_EST_ORG_NAME() {
		return PROP_EST_ORG_NAME;
	}



	public static void setPROP_EST_ORG_NAME(String pROP_EST_ORG_NAME) {
		PROP_EST_ORG_NAME = pROP_EST_ORG_NAME;
	}



	public static String getPROP_EST_ORG_CODE() {
		return PROP_EST_ORG_CODE;
	}



	public static void setPROP_EST_ORG_CODE(String pROP_EST_ORG_CODE) {
		PROP_EST_ORG_CODE = pROP_EST_ORG_CODE;
	}



	public static String getPROP_PLEDGE_TYPE() {
		return PROP_PLEDGE_TYPE;
	}



	public static void setPROP_PLEDGE_TYPE(String pROP_PLEDGE_TYPE) {
		PROP_PLEDGE_TYPE = pROP_PLEDGE_TYPE;
	}



	public static String getPROP_REGISTER_ORG() {
		return PROP_REGISTER_ORG;
	}



	public static void setPROP_REGISTER_ORG(String pROP_REGISTER_ORG) {
		PROP_REGISTER_ORG = pROP_REGISTER_ORG;
	}



	public static String getPROP_REGISTER_DATE() {
		return PROP_REGISTER_DATE;
	}



	public static void setPROP_REGISTER_DATE(String pROP_REGISTER_DATE) {
		PROP_REGISTER_DATE = pROP_REGISTER_DATE;
	}



	public static String getPROP_PLEDGE_DESC() {
		return PROP_PLEDGE_DESC;
	}



	public static void setPROP_PLEDGE_DESC(String pROP_PLEDGE_DESC) {
		PROP_PLEDGE_DESC = pROP_PLEDGE_DESC;
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



	public java.lang.String getContractType() {
		return contractType;
	}



	public void setContractType(java.lang.String contractType) {
		this.contractType = contractType;
	}



	public java.lang.String getNo() {
		return no;
	}



	public void setNo(java.lang.String no) {
		this.no = no;
	}



	public java.lang.String getContractNo() {
		return contractNo;
	}



	public void setContractNo(java.lang.String contractNo) {
		this.contractNo = contractNo;
	}



	public java.lang.String getPledgeNo() {
		return pledgeNo;
	}



	public void setPledgeNo(java.lang.String pledgeNo) {
		this.pledgeNo = pledgeNo;
	}



	public java.lang.Float getPledgeAmount() {
		return pledgeAmount;
	}



	public void setPledgeAmount(java.lang.Float pledgeAmount) {
		this.pledgeAmount = pledgeAmount;
	}



	public java.lang.String getPledgeCurrency() {
		return pledgeCurrency;
	}



	public void setPledgeCurrency(java.lang.String pledgeCurrency) {
		this.pledgeCurrency = pledgeCurrency;
	}



	public java.lang.Float getPledgeEstAmount() {
		return pledgeEstAmount;
	}



	public void setPledgeEstAmount(java.lang.Float pledgeEstAmount) {
		this.pledgeEstAmount = pledgeEstAmount;
	}



	public java.lang.String getPledgeEstCurrency() {
		return pledgeEstCurrency;
	}



	public void setPledgeEstCurrency(java.lang.String pledgeEstCurrency) {
		this.pledgeEstCurrency = pledgeEstCurrency;
	}



	public java.lang.String getEstDate() {
		return estDate;
	}



	public void setEstDate(java.lang.String estDate) {
		this.estDate = estDate;
	}



	public java.lang.String getEstOrgName() {
		return estOrgName;
	}



	public void setEstOrgName(java.lang.String estOrgName) {
		this.estOrgName = estOrgName;
	}



	public java.lang.String getEstOrgCode() {
		return estOrgCode;
	}



	public void setEstOrgCode(java.lang.String estOrgCode) {
		this.estOrgCode = estOrgCode;
	}



	public java.lang.String getPledgeType() {
		return pledgeType;
	}



	public void setPledgeType(java.lang.String pledgeType) {
		this.pledgeType = pledgeType;
	}



	public java.lang.String getRegisterOrg() {
		return registerOrg;
	}



	public void setRegisterOrg(java.lang.String registerOrg) {
		this.registerOrg = registerOrg;
	}



	public java.lang.String getRegisterDate() {
		return registerDate;
	}



	public void setRegisterDate(java.lang.String registerDate) {
		this.registerDate = registerDate;
	}



	public java.lang.String getPledgeDesc() {
		return pledgeDesc;
	}



	public void setPledgeDesc(java.lang.String pledgeDesc) {
		this.pledgeDesc = pledgeDesc;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public String toString() {
		return "BaseAssureIndPledgeList [hashCode=" + hashCode + ", id=" + id
				+ ", rptKey=" + rptKey + ", contractType=" + contractType
				+ ", no=" + no + ", contractNo=" + contractNo + ", pledgeNo="
				+ pledgeNo + ", pledgeAmount=" + pledgeAmount
				+ ", pledgeCurrency=" + pledgeCurrency + ", pledgeEstAmount="
				+ pledgeEstAmount + ", pledgeEstCurrency=" + pledgeEstCurrency
				+ ", estDate=" + estDate + ", estOrgName=" + estOrgName
				+ ", estOrgCode=" + estOrgCode + ", pledgeType=" + pledgeType
				+ ", registerOrg=" + registerOrg + ", registerDate="
				+ registerDate + ", pledgeDesc=" + pledgeDesc + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contractNo == null) ? 0 : contractNo.hashCode());
		result = prime * result
				+ ((contractType == null) ? 0 : contractType.hashCode());
		result = prime * result + ((estDate == null) ? 0 : estDate.hashCode());
		result = prime * result
				+ ((estOrgCode == null) ? 0 : estOrgCode.hashCode());
		result = prime * result
				+ ((estOrgName == null) ? 0 : estOrgName.hashCode());
		result = prime * result + hashCode;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result
				+ ((pledgeAmount == null) ? 0 : pledgeAmount.hashCode());
		result = prime * result
				+ ((pledgeCurrency == null) ? 0 : pledgeCurrency.hashCode());
		result = prime * result
				+ ((pledgeDesc == null) ? 0 : pledgeDesc.hashCode());
		result = prime * result
				+ ((pledgeEstAmount == null) ? 0 : pledgeEstAmount.hashCode());
		result = prime
				* result
				+ ((pledgeEstCurrency == null) ? 0 : pledgeEstCurrency
						.hashCode());
		result = prime * result
				+ ((pledgeNo == null) ? 0 : pledgeNo.hashCode());
		result = prime * result
				+ ((pledgeType == null) ? 0 : pledgeType.hashCode());
		result = prime * result
				+ ((registerDate == null) ? 0 : registerDate.hashCode());
		result = prime * result
				+ ((registerOrg == null) ? 0 : registerOrg.hashCode());
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
		BaseAssureIndPledgeList other = (BaseAssureIndPledgeList) obj;
		if (contractNo == null) {
			if (other.contractNo != null)
				return false;
		} else if (!contractNo.equals(other.contractNo))
			return false;
		if (contractType == null) {
			if (other.contractType != null)
				return false;
		} else if (!contractType.equals(other.contractType))
			return false;
		if (estDate == null) {
			if (other.estDate != null)
				return false;
		} else if (!estDate.equals(other.estDate))
			return false;
		if (estOrgCode == null) {
			if (other.estOrgCode != null)
				return false;
		} else if (!estOrgCode.equals(other.estOrgCode))
			return false;
		if (estOrgName == null) {
			if (other.estOrgName != null)
				return false;
		} else if (!estOrgName.equals(other.estOrgName))
			return false;
		if (hashCode != other.hashCode)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (pledgeAmount == null) {
			if (other.pledgeAmount != null)
				return false;
		} else if (!pledgeAmount.equals(other.pledgeAmount))
			return false;
		if (pledgeCurrency == null) {
			if (other.pledgeCurrency != null)
				return false;
		} else if (!pledgeCurrency.equals(other.pledgeCurrency))
			return false;
		if (pledgeDesc == null) {
			if (other.pledgeDesc != null)
				return false;
		} else if (!pledgeDesc.equals(other.pledgeDesc))
			return false;
		if (pledgeEstAmount == null) {
			if (other.pledgeEstAmount != null)
				return false;
		} else if (!pledgeEstAmount.equals(other.pledgeEstAmount))
			return false;
		if (pledgeEstCurrency == null) {
			if (other.pledgeEstCurrency != null)
				return false;
		} else if (!pledgeEstCurrency.equals(other.pledgeEstCurrency))
			return false;
		if (pledgeNo == null) {
			if (other.pledgeNo != null)
				return false;
		} else if (!pledgeNo.equals(other.pledgeNo))
			return false;
		if (pledgeType == null) {
			if (other.pledgeType != null)
				return false;
		} else if (!pledgeType.equals(other.pledgeType))
			return false;
		if (registerDate == null) {
			if (other.registerDate != null)
				return false;
		} else if (!registerDate.equals(other.registerDate))
			return false;
		if (registerOrg == null) {
			if (other.registerOrg != null)
				return false;
		} else if (!registerOrg.equals(other.registerOrg))
			return false;
		if (rptKey == null) {
			if (other.rptKey != null)
				return false;
		} else if (!rptKey.equals(other.rptKey))
			return false;
		return true;
	}



	public BaseAssureIndPledgeList() {
		super();
	}



	public BaseAssureIndPledgeList(int hashCode, Integer id, String rptKey,
			String contractType, String no, String contractNo, String pledgeNo,
			Float pledgeAmount, String pledgeCurrency, Float pledgeEstAmount,
			String pledgeEstCurrency, String estDate, String estOrgName,
			String estOrgCode, String pledgeType, String registerOrg,
			String registerDate, String pledgeDesc) {
		super();
		this.hashCode = hashCode;
		this.id = id;
		this.rptKey = rptKey;
		this.contractType = contractType;
		this.no = no;
		this.contractNo = contractNo;
		this.pledgeNo = pledgeNo;
		this.pledgeAmount = pledgeAmount;
		this.pledgeCurrency = pledgeCurrency;
		this.pledgeEstAmount = pledgeEstAmount;
		this.pledgeEstCurrency = pledgeEstCurrency;
		this.estDate = estDate;
		this.estOrgName = estOrgName;
		this.estOrgCode = estOrgCode;
		this.pledgeType = pledgeType;
		this.registerOrg = registerOrg;
		this.registerDate = registerDate;
		this.pledgeDesc = pledgeDesc;
	}
	
	

}

package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAssureIndGuarantee  implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 6260299050849565651L;
		public static String PROP_ID="id";
	    public static String PROP_RPT_KEY="rptKey";
	    public static String PROP_CONTRACT_TYPE="contractType";
	    public static String PROP_NO="no";
	    public static String PROP_CONTRACT_NO="contractNo";
	    public static String PROP_CONTRACT_EFF_FLAG="contractEffFlag";
	    public static String PROP_CONTRACT_NO_AMOUNT="contractNoAmount";
	    public static String PROP_CONTRACT_NO_CURRENCY="contractNoCurrency";
	    public static String PROP_GUARANTEE_AMOUNT="guaranteeAmount";
	    public static String PROP_GUARANTEE_CURRENCY="guaranteeCurrency";
	    public static String PROP_FINANCIAL_ORG="financialOrg";
	    public static String PROP_CONTRACT_SIGN_DATE="contractSignDate";
	    public static String PROP_CONTRACT_STYLE="contractStyle";
	    
	    
	    protected void initialize() {
	    }

	    private int hashCode = Integer.MIN_VALUE;

	    // primary key
	    private java.lang.Integer id;

	    // fields
	    private java.lang.String rptKey;
	    private java.lang.String contractType;
	    private java.lang.String no;
	    private java.lang.String contractNo;
	    private java.lang.String contractEffFlag;
	    private java.lang.Float contractNoAmount;
	    private java.lang.String contractNoCurrency;
	    private java.lang.Float guaranteeAmount;
	    private java.lang.String guaranteeCurrency;
	    private java.lang.String financialOrg;
	    private java.lang.String contractSignDate;
	    private java.lang.String contractStyle;


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
		public static String getPROP_CONTRACT_EFF_FLAG() {
			return PROP_CONTRACT_EFF_FLAG;
		}
		public static void setPROP_CONTRACT_EFF_FLAG(String pROP_CONTRACT_EFF_FLAG) {
			PROP_CONTRACT_EFF_FLAG = pROP_CONTRACT_EFF_FLAG;
		}
		public static String getPROP_CONTRACT_NO_AMOUNT() {
			return PROP_CONTRACT_NO_AMOUNT;
		}
		public static void setPROP_CONTRACT_NO_AMOUNT(String pROP_CONTRACT_NO_AMOUNT) {
			PROP_CONTRACT_NO_AMOUNT = pROP_CONTRACT_NO_AMOUNT;
		}
		public static String getPROP_CONTRACT_NO_CURRENCY() {
			return PROP_CONTRACT_NO_CURRENCY;
		}
		public static void setPROP_CONTRACT_NO_CURRENCY(String pROP_CONTRACT_NO_CURRENCY) {
			PROP_CONTRACT_NO_CURRENCY = pROP_CONTRACT_NO_CURRENCY;
		}
		public static String getPROP_GUARANTEE_AMOUNT() {
			return PROP_GUARANTEE_AMOUNT;
		}
		public static void setPROP_GUARANTEE_AMOUNT(String pROP_GUARANTEE_AMOUNT) {
			PROP_GUARANTEE_AMOUNT = pROP_GUARANTEE_AMOUNT;
		}
		public static String getPROP_GUARANTEE_CURRENCY() {
			return PROP_GUARANTEE_CURRENCY;
		}
		public static void setPROP_GUARANTEE_CURRENCY(String pROP_GUARANTEE_CURRENCY) {
			PROP_GUARANTEE_CURRENCY = pROP_GUARANTEE_CURRENCY;
		}
		public static String getPROP_FINANCIAL_ORG() {
			return PROP_FINANCIAL_ORG;
		}
		public static void setPROP_FINANCIAL_ORG(String pROP_FINANCIAL_ORG) {
			PROP_FINANCIAL_ORG = pROP_FINANCIAL_ORG;
		}
		public static String getPROP_CONTRACT_SIGN_DATE() {
			return PROP_CONTRACT_SIGN_DATE;
		}
		public static void setPROP_CONTRACT_SIGN_DATE(String pROP_CONTRACT_SIGN_DATE) {
			PROP_CONTRACT_SIGN_DATE = pROP_CONTRACT_SIGN_DATE;
		}
		public static String getPROP_CONTRACT_STYLE() {
			return PROP_CONTRACT_STYLE;
		}
		public static void setPROP_CONTRACT_STYLE(String pROP_CONTRACT_STYLE) {
			PROP_CONTRACT_STYLE = pROP_CONTRACT_STYLE;
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
		public java.lang.String getContractEffFlag() {
			return contractEffFlag;
		}
		public void setContractEffFlag(java.lang.String contractEffFlag) {
			this.contractEffFlag = contractEffFlag;
		}
		public java.lang.Float getContractNoAmount() {
			return contractNoAmount;
		}
		public void setContractNoAmount(java.lang.Float contractNoAmount) {
			this.contractNoAmount = contractNoAmount;
		}
		public java.lang.String getContractNoCurrency() {
			return contractNoCurrency;
		}
		public void setContractNoCurrency(java.lang.String contractNoCurrency) {
			this.contractNoCurrency = contractNoCurrency;
		}
		public java.lang.Float getGuaranteeAmount() {
			return guaranteeAmount;
		}
		public void setGuaranteeAmount(java.lang.Float guaranteeAmount) {
			this.guaranteeAmount = guaranteeAmount;
		}
		public java.lang.String getGuaranteeCurrency() {
			return guaranteeCurrency;
		}
		public void setGuaranteeCurrency(java.lang.String guaranteeCurrency) {
			this.guaranteeCurrency = guaranteeCurrency;
		}
		public java.lang.String getFinancialOrg() {
			return financialOrg;
		}
		public void setFinancialOrg(java.lang.String financialOrg) {
			this.financialOrg = financialOrg;
		}
		public java.lang.String getContractSignDate() {
			return contractSignDate;
		}
		public void setContractSignDate(java.lang.String contractSignDate) {
			this.contractSignDate = contractSignDate;
		}
		public java.lang.String getContractStyle() {
			return contractStyle;
		}
		public void setContractStyle(java.lang.String contractStyle) {
			this.contractStyle = contractStyle;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "BaseAssureIndGuarantee [hashCode=" + hashCode + ", id="
					+ id + ", rptKey=" + rptKey + ", contractType="
					+ contractType + ", no=" + no + ", contractNo="
					+ contractNo + ", contractEffFlag=" + contractEffFlag
					+ ", contractNoAmount=" + contractNoAmount
					+ ", contractNoCurrency=" + contractNoCurrency
					+ ", guaranteeAmount=" + guaranteeAmount
					+ ", guaranteeCurrency=" + guaranteeCurrency
					+ ", financialOrg=" + financialOrg + ", contractSignDate="
					+ contractSignDate + ", contractStyle=" + contractStyle
					+ "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime
					* result
					+ ((contractEffFlag == null) ? 0 : contractEffFlag
							.hashCode());
			result = prime * result
					+ ((contractNo == null) ? 0 : contractNo.hashCode());
			result = prime
					* result
					+ ((contractNoAmount == null) ? 0 : contractNoAmount
							.hashCode());
			result = prime
					* result
					+ ((contractNoCurrency == null) ? 0 : contractNoCurrency
							.hashCode());
			result = prime
					* result
					+ ((contractSignDate == null) ? 0 : contractSignDate
							.hashCode());
			result = prime * result
					+ ((contractStyle == null) ? 0 : contractStyle.hashCode());
			result = prime * result
					+ ((contractType == null) ? 0 : contractType.hashCode());
			result = prime * result
					+ ((financialOrg == null) ? 0 : financialOrg.hashCode());
			result = prime
					* result
					+ ((guaranteeAmount == null) ? 0 : guaranteeAmount
							.hashCode());
			result = prime
					* result
					+ ((guaranteeCurrency == null) ? 0 : guaranteeCurrency
							.hashCode());
			result = prime * result + hashCode;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((no == null) ? 0 : no.hashCode());
			result = prime * result
					+ ((rptKey == null) ? 0 : rptKey.hashCode());
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
			BaseAssureIndGuarantee other = (BaseAssureIndGuarantee) obj;
			if (contractEffFlag == null) {
				if (other.contractEffFlag != null)
					return false;
			} else if (!contractEffFlag.equals(other.contractEffFlag))
				return false;
			if (contractNo == null) {
				if (other.contractNo != null)
					return false;
			} else if (!contractNo.equals(other.contractNo))
				return false;
			if (contractNoAmount == null) {
				if (other.contractNoAmount != null)
					return false;
			} else if (!contractNoAmount.equals(other.contractNoAmount))
				return false;
			if (contractNoCurrency == null) {
				if (other.contractNoCurrency != null)
					return false;
			} else if (!contractNoCurrency.equals(other.contractNoCurrency))
				return false;
			if (contractSignDate == null) {
				if (other.contractSignDate != null)
					return false;
			} else if (!contractSignDate.equals(other.contractSignDate))
				return false;
			if (contractStyle == null) {
				if (other.contractStyle != null)
					return false;
			} else if (!contractStyle.equals(other.contractStyle))
				return false;
			if (contractType == null) {
				if (other.contractType != null)
					return false;
			} else if (!contractType.equals(other.contractType))
				return false;
			if (financialOrg == null) {
				if (other.financialOrg != null)
					return false;
			} else if (!financialOrg.equals(other.financialOrg))
				return false;
			if (guaranteeAmount == null) {
				if (other.guaranteeAmount != null)
					return false;
			} else if (!guaranteeAmount.equals(other.guaranteeAmount))
				return false;
			if (guaranteeCurrency == null) {
				if (other.guaranteeCurrency != null)
					return false;
			} else if (!guaranteeCurrency.equals(other.guaranteeCurrency))
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
			if (rptKey == null) {
				if (other.rptKey != null)
					return false;
			} else if (!rptKey.equals(other.rptKey))
				return false;
			return true;
		}
		public BaseAssureIndGuarantee(int hashCode, Integer id, String rptKey,
				String contractType, String no, String contractNo,
				String contractEffFlag, Float contractNoAmount,
				String contractNoCurrency, Float guaranteeAmount,
				String guaranteeCurrency, String financialOrg,
				String contractSignDate, String contractStyle) {
			super();
			this.hashCode = hashCode;
			this.id = id;
			this.rptKey = rptKey;
			this.contractType = contractType;
			this.no = no;
			this.contractNo = contractNo;
			this.contractEffFlag = contractEffFlag;
			this.contractNoAmount = contractNoAmount;
			this.contractNoCurrency = contractNoCurrency;
			this.guaranteeAmount = guaranteeAmount;
			this.guaranteeCurrency = guaranteeCurrency;
			this.financialOrg = financialOrg;
			this.contractSignDate = contractSignDate;
			this.contractStyle = contractStyle;
		}
		public BaseAssureIndGuarantee() {
			super();
			// TODO Auto-generated constructor stub
		}


	    
		
}

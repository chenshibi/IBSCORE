package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAssureIndMainInfo  implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 2809229801244099661L;
		public static String PROP_ID="id";
	    public static String PROP_RPT_KEY="rptKey";
	    public static String PROP_CONTRACT_TYPE="assureType";
	    public static String PROP_NO="no";
	    public static String PROP_CONTRACT_NO="contractNo";
	    public static String PROP_BIZ_TYPE="bizType";
	    public static String PROP_BIZ_AMOUNT="bizAmount";
	    public static String PROP_BIZ_BALANCE="bizBalance";
	    
	    
	    protected void initialize() {
	    }

	    private int hashCode = Integer.MIN_VALUE;

	    // primary key
	    private java.lang.Integer id;

	    // fields
	    private java.lang.String rptKey;
	    private java.lang.String assureType;
	    private java.lang.String no;
	    private java.lang.String contractNo;
	    private java.lang.String bizType;
	    private java.lang.Float bizAmount;
	    private java.lang.Float bizBalance;


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
		public static String getPROP_BIZ_TYPE() {
			return PROP_BIZ_TYPE;
		}
		public static void setPROP_BIZ_TYPE(String pROP_BIZ_TYPE) {
			PROP_BIZ_TYPE = pROP_BIZ_TYPE;
		}
		public static String getPROP_BIZ_AMOUNT() {
			return PROP_BIZ_AMOUNT;
		}
		public static void setPROP_BIZ_AMOUNT(String pROP_BIZ_AMOUNT) {
			PROP_BIZ_AMOUNT = pROP_BIZ_AMOUNT;
		}
		public static String getPROP_BIZ_BALANCE() {
			return PROP_BIZ_BALANCE;
		}
		public static void setPROP_BIZ_BALANCE(String pROP_BIZ_BALANCE) {
			PROP_BIZ_BALANCE = pROP_BIZ_BALANCE;
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
		public java.lang.String getAssureType() {
			return assureType;
		}
		public void setAssureType(java.lang.String assureType) {
			this.assureType = assureType;
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
		public java.lang.String getBizType() {
			return bizType;
		}
		public void setBizType(java.lang.String bizType) {
			this.bizType = bizType;
		}
		public java.lang.Float getBizAmount() {
			return bizAmount;
		}
		public void setBizAmount(java.lang.Float bizAmount) {
			this.bizAmount = bizAmount;
		}
		public java.lang.Float getBizBalance() {
			return bizBalance;
		}
		public void setBizBalance(java.lang.Float bizBalance) {
			this.bizBalance = bizBalance;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "BaseAssureIndMainInfo [hashCode=" + hashCode + ", id=" + id
					+ ", rptKey=" + rptKey + ", assureType=" + assureType
					+ ", no=" + no + ", contractNo=" + contractNo
					+ ", bizType=" + bizType + ", bizAmount=" + bizAmount
					+ ", bizBalance=" + bizBalance + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((assureType == null) ? 0 : assureType.hashCode());
			result = prime * result
					+ ((bizAmount == null) ? 0 : bizAmount.hashCode());
			result = prime * result
					+ ((bizBalance == null) ? 0 : bizBalance.hashCode());
			result = prime * result
					+ ((bizType == null) ? 0 : bizType.hashCode());
			result = prime * result
					+ ((contractNo == null) ? 0 : contractNo.hashCode());
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
			BaseAssureIndMainInfo other = (BaseAssureIndMainInfo) obj;
			if (assureType == null) {
				if (other.assureType != null)
					return false;
			} else if (!assureType.equals(other.assureType))
				return false;
			if (bizAmount == null) {
				if (other.bizAmount != null)
					return false;
			} else if (!bizAmount.equals(other.bizAmount))
				return false;
			if (bizBalance == null) {
				if (other.bizBalance != null)
					return false;
			} else if (!bizBalance.equals(other.bizBalance))
				return false;
			if (bizType == null) {
				if (other.bizType != null)
					return false;
			} else if (!bizType.equals(other.bizType))
				return false;
			if (contractNo == null) {
				if (other.contractNo != null)
					return false;
			} else if (!contractNo.equals(other.contractNo))
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
		public BaseAssureIndMainInfo() {
			super();
			// TODO Auto-generated constructor stub
		}
		public BaseAssureIndMainInfo(int hashCode, Integer id, String rptKey,
				String assureType, String no, String contractNo,
				String bizType, Float bizAmount, Float bizBalance) {
			super();
			this.hashCode = hashCode;
			this.id = id;
			this.rptKey = rptKey;
			this.assureType = assureType;
			this.no = no;
			this.contractNo = contractNo;
			this.bizType = bizType;
			this.bizAmount = bizAmount;
			this.bizBalance = bizBalance;
		}

	    
		
		
		
}

package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAssureIndSum  implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -2074461038754971449L;
		public static String PROP_ID="id";
	    public static String PROP_RPT_KEY="rptKey";
	    public static String PROP_CONTRACT_TYPE="contractType";
	    public static String PROP_SUM_AMOUNT="sumAmount";
	    
	    
	    protected void initialize() {
	    }

	    private int hashCode = Integer.MIN_VALUE;

	    // primary key
	    private java.lang.Integer id;

	    // fields
	    private java.lang.String rptKey;
	    private java.lang.String contractType;
	    private java.lang.Float sumAmount;


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
		public static String getPROP_SUM_AMOUNT() {
			return PROP_SUM_AMOUNT;
		}
		public static void setPROP_SUM_AMOUNT(String pROP_SUM_AMOUNT) {
			PROP_SUM_AMOUNT = pROP_SUM_AMOUNT;
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
		public java.lang.Float getSumAmount() {
			return sumAmount;
		}
		public void setSumAmount(java.lang.Float sumAmount) {
			this.sumAmount = sumAmount;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		@Override
		public String toString() {
			return "BaseAssureIndSum [hashCode=" + hashCode + ", id=" + id
					+ ", rptKey=" + rptKey + ", contractType=" + contractType
					+ ", sumAmount=" + sumAmount + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((contractType == null) ? 0 : contractType.hashCode());
			result = prime * result + hashCode;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result
					+ ((rptKey == null) ? 0 : rptKey.hashCode());
			result = prime * result
					+ ((sumAmount == null) ? 0 : sumAmount.hashCode());
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
			BaseAssureIndSum other = (BaseAssureIndSum) obj;
			if (contractType == null) {
				if (other.contractType != null)
					return false;
			} else if (!contractType.equals(other.contractType))
				return false;
			if (hashCode != other.hashCode)
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (rptKey == null) {
				if (other.rptKey != null)
					return false;
			} else if (!rptKey.equals(other.rptKey))
				return false;
			if (sumAmount == null) {
				if (other.sumAmount != null)
					return false;
			} else if (!sumAmount.equals(other.sumAmount))
				return false;
			return true;
		}
		public BaseAssureIndSum(int hashCode, Integer id, String rptKey,
				String contractType, Float sumAmount) {
			super();
			this.hashCode = hashCode;
			this.id = id;
			this.rptKey = rptKey;
			this.contractType = contractType;
			this.sumAmount = sumAmount;
		}
		public BaseAssureIndSum() {
			super();
			// TODO Auto-generated constructor stub
		}


		
		
		
		
		
}

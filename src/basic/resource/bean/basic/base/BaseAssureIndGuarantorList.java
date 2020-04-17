package resource.bean.basic.base;

import java.io.Serializable;
import java.util.Date;

public class BaseAssureIndGuarantorList  implements Serializable {
		public static String PROP_ID="id";
	    public static String PROP_RPT_KEY="rptKey";
	    public static String PROP_ASSURE_TYPE="assureType";
	    public static String PROP_NO="no";
	    public static String PROP_CONTRACT_NO="contractNo";
	    public static String PROP_GUARANTOR_NAME="guarantorName";
	    public static String PROP_GUARANTOR_LOANCARD_NO="guarantorLoancardNo";
	    
	    
	    protected void initialize() {
	    }

	    private int hashCode = Integer.MIN_VALUE;

	    // primary key
	    private java.lang.Integer id;
	    // fields
	    private java.lang.String rptKey;
	    private java.lang.String assureType;
	    private java.lang.String contractType;
	    private java.lang.String no;
	    private java.lang.String contractNo;
	    private java.lang.String guarantorName;
	    private java.lang.String guarantorLoancardNo;


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
		public static String getPROP_ASSURE_TYPE() {
			return PROP_ASSURE_TYPE;
		}
		public static void setPROP_ASSURE_TYPE(String pROP_ASSURE_TYPE) {
			PROP_ASSURE_TYPE = pROP_ASSURE_TYPE;
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
		public static String getPROP_GUARANTOR_NAME() {
			return PROP_GUARANTOR_NAME;
		}
		public static void setPROP_GUARANTOR_NAME(String pROP_GUARANTOR_NAME) {
			PROP_GUARANTOR_NAME = pROP_GUARANTOR_NAME;
		}
		public static String getPROP_GUARANTOR_LOANCARD_NO() {
			return PROP_GUARANTOR_LOANCARD_NO;
		}
		public static void setPROP_GUARANTOR_LOANCARD_NO(
				String pROP_GUARANTOR_LOANCARD_NO) {
			PROP_GUARANTOR_LOANCARD_NO = pROP_GUARANTOR_LOANCARD_NO;
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
		public java.lang.String getGuarantorName() {
			return guarantorName;
		}
		public void setGuarantorName(java.lang.String guarantorName) {
			this.guarantorName = guarantorName;
		}
		public java.lang.String getGuarantorLoancardNo() {
			return guarantorLoancardNo;
		}
		public void setGuarantorLoancardNo(java.lang.String guarantorLoancardNo) {
			this.guarantorLoancardNo = guarantorLoancardNo;
		}
		@Override
		public String toString() {
			return "BaseAssureIndGuarantorList [hashCode=" + hashCode + ", id="
					+ id + ", rptKey=" + rptKey + ", assureType=" + assureType
					+ ", contractType=" + contractType + ", no=" + no
					+ ", contractNo=" + contractNo + ", guarantorName="
					+ guarantorName + ", guarantorLoancardNo="
					+ guarantorLoancardNo + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((assureType == null) ? 0 : assureType.hashCode());
			result = prime * result
					+ ((contractNo == null) ? 0 : contractNo.hashCode());
			result = prime * result
					+ ((contractType == null) ? 0 : contractType.hashCode());
			result = prime
					* result
					+ ((guarantorLoancardNo == null) ? 0 : guarantorLoancardNo
							.hashCode());
			result = prime * result
					+ ((guarantorName == null) ? 0 : guarantorName.hashCode());
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
			BaseAssureIndGuarantorList other = (BaseAssureIndGuarantorList) obj;
			if (assureType == null) {
				if (other.assureType != null)
					return false;
			} else if (!assureType.equals(other.assureType))
				return false;
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
			if (guarantorLoancardNo == null) {
				if (other.guarantorLoancardNo != null)
					return false;
			} else if (!guarantorLoancardNo.equals(other.guarantorLoancardNo))
				return false;
			if (guarantorName == null) {
				if (other.guarantorName != null)
					return false;
			} else if (!guarantorName.equals(other.guarantorName))
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
		public BaseAssureIndGuarantorList(int hashCode, Integer id,
				String rptKey, String assureType, String contractType,
				String no, String contractNo, String guarantorName,
				String guarantorLoancardNo) {
			super();
			this.hashCode = hashCode;
			this.id = id;
			this.rptKey = rptKey;
			this.assureType = assureType;
			this.contractType = contractType;
			this.no = no;
			this.contractNo = contractNo;
			this.guarantorName = guarantorName;
			this.guarantorLoancardNo = guarantorLoancardNo;
		}
		public BaseAssureIndGuarantorList() {
			super();
			// TODO Auto-generated constructor stub
		}


	    
	    
		
		
}

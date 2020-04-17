package com.huateng.report.dataquery.bean;

import java.io.Serializable;

/**
 * 日志与操作员关联视图
 * 
 * @author 111111
 *
 */
public class TblCsBizLogView implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 5977898248486469047L;
	private java.lang.String id;
    private java.lang.String txnDate;
    private java.lang.String txnStartTime;
    private java.lang.String txnEndTime;
    private java.lang.Long txnRunTime;
    private java.lang.String oprCode;
    private java.lang.String ipAdr;
    private java.lang.String funcId;
    private java.lang.String oprTxnCd;
    private java.lang.String txnBizLog1;
    private java.lang.String txnBizLog2;
    private java.lang.String txnStatus;
    private java.lang.String txnFailLog;
    private java.lang.String tlrName;
    private java.lang.String misc;
    
    
    
    


	public TblCsBizLogView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TblCsBizLogView(String id, String txnDate, String txnStartTime,
			String txnEndTime, Long txnRunTime, String oprCode, String ipAdr,
			String funcId, String oprTxnCd, String txnBizLog1,
			String txnBizLog2, String txnStatus, String txnFailLog,
			String tlrName) {
		super();
		this.id = id;
		this.txnDate = txnDate;
		this.txnStartTime = txnStartTime;
		this.txnEndTime = txnEndTime;
		this.txnRunTime = txnRunTime;
		this.oprCode = oprCode;
		this.ipAdr = ipAdr;
		this.funcId = funcId;
		this.oprTxnCd = oprTxnCd;
		this.txnBizLog1 = txnBizLog1;
		this.txnBizLog2 = txnBizLog2;
		this.txnStatus = txnStatus;
		this.txnFailLog = txnFailLog;
		this.tlrName = tlrName;
	}


	public TblCsBizLogView(String id, String txnDate, String txnStartTime,
			String txnEndTime, Long txnRunTime, String oprCode, String funcId,
			String oprTxnCd, String txnBizLog1, String txnBizLog2,
			String txnStatus, String txnFailLog, String tlrName, String misc,
			String ipAdr) {
		super();
		this.id = id;
		this.txnDate = txnDate;
		this.txnStartTime = txnStartTime;
		this.txnEndTime = txnEndTime;
		this.txnRunTime = txnRunTime;
		this.oprCode = oprCode;
		this.funcId = funcId;
		this.oprTxnCd = oprTxnCd;
		this.txnBizLog1 = txnBizLog1;
		this.txnBizLog2 = txnBizLog2;
		this.txnStatus = txnStatus;
		this.txnFailLog = txnFailLog;
		this.tlrName = tlrName;
		this.misc = misc;
		this.ipAdr = ipAdr;
	}
	public java.lang.String getId() {
		return id;
	}
	public void setId(java.lang.String id) {
		this.id = id;
	}
	public java.lang.String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(java.lang.String txnDate) {
		this.txnDate = txnDate;
	}
	public java.lang.String getTxnStartTime() {
		return txnStartTime;
	}
	public void setTxnStartTime(java.lang.String txnStartTime) {
		this.txnStartTime = txnStartTime;
	}
	public java.lang.String getTxnEndTime() {
		return txnEndTime;
	}
	public void setTxnEndTime(java.lang.String txnEndTime) {
		this.txnEndTime = txnEndTime;
	}
	public java.lang.Long getTxnRunTime() {
		return txnRunTime;
	}
	public void setTxnRunTime(java.lang.Long txnRunTime) {
		this.txnRunTime = txnRunTime;
	}
	public java.lang.String getOprCode() {
		return oprCode;
	}
	public void setOprCode(java.lang.String oprCode) {
		this.oprCode = oprCode;
	}
	public java.lang.String getFuncId() {
		return funcId;
	}
	public void setFuncId(java.lang.String funcId) {
		this.funcId = funcId;
	}
	public java.lang.String getOprTxnCd() {
		return oprTxnCd;
	}
	public void setOprTxnCd(java.lang.String oprTxnCd) {
		this.oprTxnCd = oprTxnCd;
	}
	public java.lang.String getTxnBizLog1() {
		return txnBizLog1;
	}
	public void setTxnBizLog1(java.lang.String txnBizLog1) {
		this.txnBizLog1 = txnBizLog1;
	}
	public java.lang.String getTxnBizLog2() {
		return txnBizLog2;
	}
	public void setTxnBizLog2(java.lang.String txnBizLog2) {
		this.txnBizLog2 = txnBizLog2;
	}
	public java.lang.String getTxnStatus() {
		return txnStatus;
	}
	public void setTxnStatus(java.lang.String txnStatus) {
		this.txnStatus = txnStatus;
	}
	public java.lang.String getTxnFailLog() {
		return txnFailLog;
	}
	public void setTxnFailLog(java.lang.String txnFailLog) {
		this.txnFailLog = txnFailLog;
	}
	public java.lang.String getTlrName() {
		return tlrName;
	}
	public void setTlrName(java.lang.String tlrName) {
		this.tlrName = tlrName;
	}
	public java.lang.String getMisc() {
		return misc;
	}
	public void setMisc(java.lang.String misc) {
		this.misc = misc;
	}
	public java.lang.String getIpAdr() {
		return ipAdr;
	}
	public void setIpAdr(java.lang.String ipAdr) {
		this.ipAdr = ipAdr;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((funcId == null) ? 0 : funcId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAdr == null) ? 0 : ipAdr.hashCode());
		result = prime * result + ((misc == null) ? 0 : misc.hashCode());
		result = prime * result + ((oprCode == null) ? 0 : oprCode.hashCode());
		result = prime * result
				+ ((oprTxnCd == null) ? 0 : oprTxnCd.hashCode());
		result = prime * result + ((tlrName == null) ? 0 : tlrName.hashCode());
		result = prime * result
				+ ((txnBizLog1 == null) ? 0 : txnBizLog1.hashCode());
		result = prime * result
				+ ((txnBizLog2 == null) ? 0 : txnBizLog2.hashCode());
		result = prime * result + ((txnDate == null) ? 0 : txnDate.hashCode());
		result = prime * result
				+ ((txnEndTime == null) ? 0 : txnEndTime.hashCode());
		result = prime * result
				+ ((txnFailLog == null) ? 0 : txnFailLog.hashCode());
		result = prime * result
				+ ((txnRunTime == null) ? 0 : txnRunTime.hashCode());
		result = prime * result
				+ ((txnStartTime == null) ? 0 : txnStartTime.hashCode());
		result = prime * result
				+ ((txnStatus == null) ? 0 : txnStatus.hashCode());
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
		TblCsBizLogView other = (TblCsBizLogView) obj;
		if (funcId == null) {
			if (other.funcId != null)
				return false;
		} else if (!funcId.equals(other.funcId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipAdr == null) {
			if (other.ipAdr != null)
				return false;
		} else if (!ipAdr.equals(other.ipAdr))
			return false;
		if (misc == null) {
			if (other.misc != null)
				return false;
		} else if (!misc.equals(other.misc))
			return false;
		if (oprCode == null) {
			if (other.oprCode != null)
				return false;
		} else if (!oprCode.equals(other.oprCode))
			return false;
		if (oprTxnCd == null) {
			if (other.oprTxnCd != null)
				return false;
		} else if (!oprTxnCd.equals(other.oprTxnCd))
			return false;
		if (tlrName == null) {
			if (other.tlrName != null)
				return false;
		} else if (!tlrName.equals(other.tlrName))
			return false;
		if (txnBizLog1 == null) {
			if (other.txnBizLog1 != null)
				return false;
		} else if (!txnBizLog1.equals(other.txnBizLog1))
			return false;
		if (txnBizLog2 == null) {
			if (other.txnBizLog2 != null)
				return false;
		} else if (!txnBizLog2.equals(other.txnBizLog2))
			return false;
		if (txnDate == null) {
			if (other.txnDate != null)
				return false;
		} else if (!txnDate.equals(other.txnDate))
			return false;
		if (txnEndTime == null) {
			if (other.txnEndTime != null)
				return false;
		} else if (!txnEndTime.equals(other.txnEndTime))
			return false;
		if (txnFailLog == null) {
			if (other.txnFailLog != null)
				return false;
		} else if (!txnFailLog.equals(other.txnFailLog))
			return false;
		if (txnRunTime == null) {
			if (other.txnRunTime != null)
				return false;
		} else if (!txnRunTime.equals(other.txnRunTime))
			return false;
		if (txnStartTime == null) {
			if (other.txnStartTime != null)
				return false;
		} else if (!txnStartTime.equals(other.txnStartTime))
			return false;
		if (txnStatus == null) {
			if (other.txnStatus != null)
				return false;
		} else if (!txnStatus.equals(other.txnStatus))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TblCsBizLogView [id=" + id + ", txnDate=" + txnDate
				+ ", txnStartTime=" + txnStartTime + ", txnEndTime="
				+ txnEndTime + ", txnRunTime=" + txnRunTime + ", oprCode="
				+ oprCode + ", funcId=" + funcId + ", oprTxnCd=" + oprTxnCd
				+ ", txnBizLog1=" + txnBizLog1 + ", txnBizLog2=" + txnBizLog2
				+ ", txnStatus=" + txnStatus + ", txnFailLog=" + txnFailLog
				+ ", tlrName=" + tlrName + ", misc=" + misc + ", ipAdr="
				+ ipAdr + "]";
	}
    
    
    
}

package resource.bean.basic;

import resource.bean.basic.base.BaseTblCsBizLog;;

public class TblCsBizLog extends BaseTblCsBizLog {
    private static final long serialVersionUID = 1L;

    /* [CONSTRUCTOR MARKER BEGIN] */
    public TblCsBizLog() {
        super();
    }

    /**
     * Constructor for primary key
     */
    public TblCsBizLog(java.lang.String id) {
        super(id);
    }

	public TblCsBizLog(String id, String txnDate, String txnStartTime,
			String txnEndTime, Long txnRunTime, String oprCode, String ipAdr,
			String funcId, String oprTxnCd, String txnBizLog1,
			String txnBizLog2, String txnStatus, String txnFailLog,
			String tlrName, String misc, String logId) {
		super(id, txnDate, txnStartTime, txnEndTime, txnRunTime, oprCode, ipAdr,
				funcId, oprTxnCd, txnBizLog1, txnBizLog2, txnStatus, txnFailLog,
				tlrName, misc, logId);
		// TODO Auto-generated constructor stub
	}

	public TblCsBizLog(String id, String txnDate, String txnStartTime,
			String txnEndTime, Long txnRunTime, String oprCode, String ipAdr,
			String funcId, String oprTxnCd, String txnBizLog1,
			String txnBizLog2, String txnStatus, String txnFailLog,
			String tlrName) {
		super(id, txnDate, txnStartTime, txnEndTime, txnRunTime, oprCode, ipAdr,
				funcId, oprTxnCd, txnBizLog1, txnBizLog2, txnStatus, txnFailLog,
				tlrName);
		// TODO Auto-generated constructor stub
	}

    /* [CONSTRUCTOR MARKER END] */
    
}
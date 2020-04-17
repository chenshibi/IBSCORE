package com.huateng.ebank.business.bizlog.bean;

/**
 * 交易流水查询过滤条件
 * 
 * @author JorneZhang
 * @version 创建时间：2010-1-5 下午03:13:19
 */
public class BizLogQueryBean {
    private String tlrno;// 操作员号
    private String branchId;// 机构id
    private String txnDate;// 操作时间

    private String txnDateStart;// 操作时间起
    private String txnDateEnd;// 操作时间止
    private String bizFuncType;// 交易类型

    public String getTlrno() {
        return tlrno;
    }

    public void setTlrno(String tlrno) {
        this.tlrno = tlrno;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate;
    }

    public String getTxnDateStart() {
        return txnDateStart;
    }

    public void setTxnDateStart(String txnDateStart) {
        this.txnDateStart = txnDateStart;
    }

    public String getTxnDateEnd() {
        return txnDateEnd;
    }

    public void setTxnDateEnd(String txnDateEnd) {
        this.txnDateEnd = txnDateEnd;
    }

    public String getBizFuncType() {
        return bizFuncType;
    }

    public void setBizFuncType(String bizFuncType) {
        this.bizFuncType = bizFuncType;
    }
}

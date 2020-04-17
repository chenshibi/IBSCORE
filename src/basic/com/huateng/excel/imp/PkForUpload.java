package com.huateng.excel.imp;

public class PkForUpload {
    private String cardNo;
    private String loancontNo;// 合同号
    private String protoNo;// 融资协议号

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getLoancontNo() {
        return loancontNo;
    }

    public void setLoancontNo(String loancontNo) {
        this.loancontNo = loancontNo;
    }

    public String getProtoNo() {
        return protoNo;
    }

    public void setProtoNo(String protoNo) {
        this.protoNo = protoNo;
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (null == obj)
            return false;
        if (!(obj instanceof PkForUpload))
            return false;
        else {
            PkForUpload pk = (PkForUpload) obj;
            if (pk.getCardNo().equals(this.getCardNo()) && pk.getLoancontNo().equals(this.getLoancontNo())
                    && pk.getProtoNo().equals(this.getProtoNo())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.cardNo + "|" + this.loancontNo + "|" + this.protoNo;
    }
}

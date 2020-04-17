package com.huateng.ebank.business.common.bean;

/**
 * 下拉产品列表
 * 
 * @author jason.mao
 *
 */
@SuppressWarnings("ucd")
public class BizProductBean {
    private String productCode;// 产品代码
    private String productName;// 产品名称
    private String centralBankFlag;// 贴现标志
    private String buyBackType;// 回购方式
    private String draftType;// 票据种类

    public String getDraftType() {
        return draftType;
    }

    public void setDraftType(String draftType) {
        this.draftType = draftType;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCentralBankFlag() {
        return centralBankFlag;
    }

    public void setCentralBankFlag(String centralBankFlag) {
        this.centralBankFlag = centralBankFlag;
    }

    public String getBuyBackType() {
        return buyBackType;
    }

    public void setBuyBackType(String buyBackType) {
        this.buyBackType = buyBackType;
    }
}

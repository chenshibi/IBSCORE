package com.huateng.ebank.business.common.bean;

import java.math.BigDecimal;

/**
 * 用于票据级别额度占用输入的bean 见DfclsCreditService
 * 
 * @author jason.mao
 */
@SuppressWarnings("ucd")
public class Draft4ClsCreditBean {
    private Integer draftId;
    private Integer brId;
    private String draftClass;
    private BigDecimal amount;

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public Integer getBrId() {
        return brId;
    }

    public void setBrId(Integer brId) {
        this.brId = brId;
    }

    public String getDraftClass() {
        return draftClass;
    }

    public void setDraftClass(String draftClass) {
        this.draftClass = draftClass;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

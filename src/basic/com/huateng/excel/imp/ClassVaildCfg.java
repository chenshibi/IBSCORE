package com.huateng.excel.imp;

import java.util.HashMap;
import java.util.Map;

public class ClassVaildCfg {

    public final static Map<String, String> keymap = new HashMap<String, String>();// 校验service对象映射
    static {
        keymap.put("resource.bean.creditreport.Borrowers",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.LoanerDataVaildService");// 概况信息补录service
        keymap.put("resource.bean.creditreport.Regcapitals",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.FunCapitalDataVaildService");// 资本构成service
        // 财务报表
        keymap.put("resource.bean.creditreport.BSS",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.BssDataVaildService");// 资产负债
        keymap.put("resource.bean.creditreport.Profits",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.ProfitsDataVaildService");// 利润及利润分配表
        keymap.put("resource.bean.creditreport.Cashs",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.CashsDataVaildService");// 现金流量
        keymap.put("resource.bean.creditreport.TcInstistament",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.TcInstistamentDataVaildService");// 事业单位-->负债
        keymap.put("resource.bean.creditreport.TcInstiincout",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.TcInstiincoutDataVaildService");// 事业单位-->收支
        keymap.put("resource.bean.creditreport.Lawinformation",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.LawinformationDataVaildService");// 诉讼信息
        keymap.put("resource.bean.creditreport.Eventinformation",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.EventinformationDataVaildService");// 大事件
        keymap.put("resource.bean.creditreport.Loancontracts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.LoanbusinessDataVaildService");// 贷款业务service
        keymap.put("resource.bean.creditreport.Baolis",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.BaolisDataVaildService");// 保理业务
        keymap.put("resource.bean.creditreport.Billdiscounts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.BilldiscountsDataVaildService");// 票据贴现
        keymap.put("resource.bean.creditreport.Ensurecontracts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.EnsurecontractsDataVaildService");// 担保业务--保证合同
        keymap.put("resource.bean.creditreport.Pledgecontracts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.PledgecontractsDataVaildService");// 担保业务--抵押合同
        keymap.put("resource.bean.creditreport.Impawncontract",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.ImpawncontractDataVaildService");// 担保业务--质押合同
        keymap.put("resource.bean.creditreport.Financeprotos",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.FundDataVaildService");// 贸易融资业务
        keymap.put("resource.bean.creditreport.Lackofinterests",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.LackofinterestsDataVaildService");// 欠息业务

        keymap.put("resource.bean.creditreport.Creditbusiness",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.LetterCreditDataVaildService");// 信用证
        keymap.put("resource.bean.creditreport.Baohans",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.GuaranteesDataVaildService");// 保函
        keymap.put("resource.bean.creditreport.Bankaccepts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.EBankDataVaildService");// 银行承兑汇
        keymap.put("resource.bean.creditreport.Openawardtrusts",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.OpenAwardTrustsDataVaildService");// 公开授信
        keymap.put("resource.bean.creditreport.Dkmessages",
                "com.huateng.ebank.business.creditreport.vaild.dataVaildService.DkmessagesDataVaildService");// 垫款

        // 添加 贷款中借据、还款、展期；贸易融资中贸易融资业务、还款、展期 2015-01-16 start
        keymap.put("resource.bean.creditreport.Loanbills",
                "com.huateng.ebank.business.creditreport.vaild.loanbusiness.LoanbillsDataVaild");
        keymap.put("resource.bean.creditreport.Loanreturns",
                "com.huateng.ebank.business.creditreport.vaild.loanbusiness.LoanreturnsDataVaild");
        keymap.put("resource.bean.creditreport.Billexps",
                "com.huateng.ebank.business.creditreport.vaild.loanbusiness.BillexpsDataVaild");

        keymap.put("resource.bean.creditreport.Financebusiness",
                "com.huateng.ebank.business.creditreport.vaild.fund.FinancebusinessDataVaild");
        keymap.put("resource.bean.creditreport.Financereturns",
                "com.huateng.ebank.business.creditreport.vaild.fund.FinancereturnsDataVaild");
        keymap.put("resource.bean.creditreport.Financeexps",
                "com.huateng.ebank.business.creditreport.vaild.fund.FinanceexpsDataVaild");
        // end
    }
}

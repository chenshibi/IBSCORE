package com.huateng.boa.log4j.monitor;

import java.util.ArrayList;
import java.util.List;

public class ConfidentialDataLabels {

    public static final String ORGANIZATION_CODE = "organizationcode";
    public static final String CUSTOMER_NAME = "customername";
    public static final String CUSTOMER_NO = "customerno";
    public static final String ACCOUNT_NO = "accountno";
    public static final String ACCOUNT_TYPE = "accounttype";
    public static final String ACCOUNT_STATUS = "accountstatus";
    public static final String ACCOUNT_OPEN_DATE = "accountopendate";
    public static final String ACCOUNT_CLOSE_DATE = "accountclosedate";
    public static final String ACCOUNT_CURRENCY_CODE = "accountcurrencycode";
    public static final String ACCOUNT_BALANCE = "accountbalance";
    public static final String ACCOUNT_REAL_BALANCE = "accountrealbalance";
    public static final String ACCOUNT_RELATE_ACCOUNT = "accountrelateaccount";
    public static final String ACCOUNT_ADDRESS = "accountaddress";
    public static final String ACCOUNT_POST_CODE = "accountpostcode";
    public static final String ACCOUNT_TELE_PHONE = "accounttelephone";
    public static final String ACCOUNT_REMARKS = "accountremarks";

    public static final String TRANSACTION_ID = "transactionid";
    public static final String TRANSACTION_TYPE = "transactiontype";
    public static final String TRANSACTION_DIRECT = "transactiondirect";
    public static final String TRANSACTION_CURRENCY_CODE = "transactioncurrencycode";
    public static final String TRANSACTION_AMOUNT = "transactionamount";
    public static final String TRANSACTION_DATE = "transactiondate";
    public static final String TRANSACTION_GBS_ID = "transactiongbsid";
    public static final String TRANSACTION_COUNTER_NAME = "transactioncountername";
    public static final String TRANSACTION_COUNTER_ACCOUNT = "transactioncounteraccount";
    public static final String TRANSACTION_COUNTER_BANK_NAME = "transactioncounterbankname";
    public static final String TRANSACTION_COUNTER_BANK_ID = "transactioncounterbankid";
    public static final String TRANSACTION_COUNTER_PAPER_TYPE = "transactioncounterpapertype";
    public static final String TRANSACTION_COUNTER_PAPER_CODE = "transactioncounterpapercode";
    public static final String TRANSACTION_COUNTER_ADDRESS = "transactioncounteraddress";
    public static final String TRANSACTION_COUNTER_POST_CODE = "transactioncounterpostcode";
    public static final String TRANSACTION_COUNTER_TELE_PHONE = "transactioncountertelephone";
    public static final String TRANSACTION_REMARKS = "transactionremarks";

    public static List<String> getCustomerLabels() {
        List<String> list = new ArrayList<String>();
        list.add(ORGANIZATION_CODE);
        list.add(CUSTOMER_NAME);
        return list;
    }

    public static List<String> getAccountLabels() {
        List<String> list = new ArrayList<String>();
        list.add(ACCOUNT_NO);
        list.add(ACCOUNT_TYPE);
        list.add(ACCOUNT_STATUS);
        list.add(ACCOUNT_OPEN_DATE);
        list.add(ACCOUNT_CLOSE_DATE);
        list.add(ACCOUNT_CURRENCY_CODE);
        list.add(ACCOUNT_BALANCE);
        list.add(ACCOUNT_REAL_BALANCE);
        list.add(ACCOUNT_RELATE_ACCOUNT);
        list.add(ACCOUNT_ADDRESS);
        list.add(ACCOUNT_POST_CODE);
        list.add(ACCOUNT_TELE_PHONE);
        list.add(ACCOUNT_REMARKS);
        return list;
    }

    public static List<String> getTransactionLabels() {
        List<String> list = new ArrayList<String>();
        list.add(TRANSACTION_ID);
        list.add(TRANSACTION_TYPE);
        list.add(TRANSACTION_DIRECT);
        list.add(TRANSACTION_CURRENCY_CODE);
        list.add(TRANSACTION_AMOUNT);
        list.add(TRANSACTION_DATE);
        list.add(TRANSACTION_GBS_ID);
        list.add(TRANSACTION_COUNTER_NAME);
        list.add(TRANSACTION_COUNTER_ACCOUNT);
        list.add(TRANSACTION_COUNTER_BANK_NAME);
        list.add(TRANSACTION_COUNTER_BANK_ID);
        list.add(TRANSACTION_COUNTER_PAPER_TYPE);
        list.add(TRANSACTION_COUNTER_PAPER_CODE);
        list.add(TRANSACTION_COUNTER_ADDRESS);
        list.add(TRANSACTION_COUNTER_POST_CODE);
        list.add(TRANSACTION_COUNTER_TELE_PHONE);
        list.add(TRANSACTION_REMARKS);
        return list;
    }

}

package com.huateng.ebank.business.common.service;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.huateng.common.DateUtil;
import com.huateng.ebank.business.common.BaseGlobalData;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.report.utils.LogExceptionUtils;

import resource.bean.basic.TblCsBizLog;
import resource.dao.basic.TblBizLogDAO;

public class BizLogTask implements Runnable, Serializable {
    private static final long serialVersionUID = 1L;
    private BaseGlobalData globalInfo;
    private String s;
    private String txnLogFlag;
    private String uuId;
    private String oprTxnCd;
    private String sequence;
    private static final Logger logger = Logger.getLogger(BizLogTask.class);

    BizLogTask(BaseGlobalData globalInfo, String s, String txnLogFlag, String uuId, String oprTxnCd, String sequence) {
        this.globalInfo = globalInfo;
        this.txnLogFlag = txnLogFlag;
        this.oprTxnCd = oprTxnCd;
        this.uuId = uuId;
        this.s = s;
        this.sequence = sequence;
    }

    public void run() {
        try {
            String funcLogFlag = globalInfo.getFuncIdLogFlag();
            if ((funcLogFlag != null) && (!funcLogFlag.equals("")) && (txnLogFlag != null)
                    && (txnLogFlag.equals("true")) && (funcLogFlag.equals("true"))) {
                if (logger.isDebugEnabled()) {
                    logger.info("BizLogTask  - start");
                }
                TblBizLogDAO tblBizLogDAO = DAOUtils.getTblBizLogDAO();
                TblCsBizLog bizLog = new TblCsBizLog();

                bizLog.setLogId(uuId);

                bizLog.setTxnDate(DateUtil.dateToNumber(globalInfo.getTxnDate()));

                bizLog.setTxnStartTime(DateUtil.onlyTimeToString(globalInfo.getTxnStartTime()));
                Date endTime = new Date();
                String endTimeString = DateUtil.onlyTimeToString(endTime);

                bizLog.setTxnEndTime(endTimeString);

                bizLog.setTxnRunTime(Long.valueOf(DateUtil.comparaTime(globalInfo.getTxnStartTime(), endTime)));

//                bizLog.setBrCode(globalInfo.getBrcode());

                bizLog.setOprCode(globalInfo.getTlrno());

                bizLog.setIpAdr(globalInfo.getIp());

                bizLog.setFuncId(globalInfo.getFuncId());
                bizLog.setOprTxnCd(oprTxnCd);
                String[] txnDesc = getSubString(s, 2048);
                bizLog.setTxnBizLog1(txnDesc[0]);
                bizLog.setTxnBizLog2(txnDesc[1]);
                bizLog.setTxnStatus(globalInfo.getTxnStatus());
                if ((globalInfo.getTxnStatus() != null) && (!globalInfo.getTxnStatus().equals("02"))) {
                    bizLog.setTxnFailLog(getSubString(globalInfo.getTxnFailLog(), 2048)[0]);
                }
                tblBizLogDAO.insert(bizLog);

                if (logger.isDebugEnabled()) {
                    logger.info("BizLogTask  - end");
                }
            }
        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            e.printStackTrace();
            logger.error("BizLogTask 插入操作员日志信息失败 ", e);
        }
    }

    public static void main(String[] args) {
        String str = "插入1操作员日志";
        try {
            String[] subs = getSubString(str, 6);

            System.out.println(subs[0]);
            System.out.println(subs[1]);
        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            e.printStackTrace();
        }

    }

    private static String getUtf8Len(String str, int len) {
        if (null == str || str.trim().length() <= 0) {
            return "";
        }
        if (len <= 0) {
            return "";
        }

        while (true) {
            str = str.substring(0, str.length());
            try {
                if (str.getBytes("UTF-8").length <= len) {
                    return str;
                } else {
                    if (str.length() - 1 <= 0) {
                        return "";
                    }
                    str = str.substring(0, str.length() - 1);
                }
            } catch (UnsupportedEncodingException e) {
                LogExceptionUtils.logException(logger, e);
                e.printStackTrace();
            }
        }

    }

    public static String[] getSubString(String str, int limitLen) {
        if ((str == null) || (str.trim().equals(""))) {
            return new String[] { "", "" };
        }
        String[] sub1 = new String[2];

        sub1[0] = getUtf8Len(str, limitLen);
        int sub10Len = sub1[0].length();
        if (sub10Len == str.length()) {
            sub1[1] = "";
            return sub1;
        }

        str = str.substring(sub10Len);
        sub1[1] = getUtf8Len(str, limitLen);

        return sub1;
    }
}

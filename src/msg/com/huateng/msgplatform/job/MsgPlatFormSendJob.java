package com.huateng.msgplatform.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.mail.MailInfo;
import com.huateng.msgplatform.mail.MailSendResult;
import com.huateng.msgplatform.mail.MailUtil;
import com.huateng.msgplatform.mail.SmtpInfo;
import com.huateng.msgplatform.service.MsGPlatFormConstant;
import com.huateng.report.common.service.ReportCommonService;

import resource.bean.basic.ReportJobConfig;
import resource.bean.msg.CpgMsgPool;
import resource.bean.msg.CpgMsgSndDtl;

public class MsgPlatFormSendJob implements org.quartz.StatefulJob {
    private Logger htlog = Logger.getLogger(MsgPlatFormGetSendDetailsJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        String result = ReportCommonService.JOB_OK;
        Date startTm = null;
        Date endTm = null;
        String jobName = null;
        String jobId = null;
        String remark = "";
        try {
            startTm = new Date();
            jobId = context.getJobDetail().getJobDataMap().getString("jobId");// 定时器主键
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, jobId);
            jobName = jobConfig.getJobName();
            remark = jobConfig.getJobRemark();
            startTm = new Date();

            if (DateUtil.isHoliday() && "Y".equals(jobConfig.getJustWorkdateRun())) {
                remark = "该JOB只在工作日执行";
                return;
            }

            List<CpgMsgPool> list = null;
            StringBuffer hql = new StringBuffer("select po from CpgMsgPool po where 1=1 ");
            hql.append(" and po.status = '").append(MsGPlatFormConstant.MSG_POOL_STATUS_GEN_OK).append("'");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            htlog.info(hql);
            if (list == null || list.size() == 0) {
                htlog.info("no message need to be sent.");
                return;
            }
            for (CpgMsgPool pool : list) {
                MailInfo mail = new MailInfo();

                mail.setId(pool.getId());
                mail.setContent(pool.getMsgLog());
                mail.setTitle(pool.getMsgLogHead());

                List<String> toList = new ArrayList<String>();
                StringBuffer hqlDtl = new StringBuffer("select po from CpgMsgSndDtl po where 1=1 ");
                hql.append(" and po.msgLogId = '").append(pool.getId()).append("'");
                List<CpgMsgSndDtl> listDtl = null;
                listDtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

                for (CpgMsgSndDtl dtl : listDtl) {
                    if (MsGPlatFormConstant.MSG_POOL_SEND_TYPE_MAIL.equals(dtl.getSendType())) {
                        toList.add(dtl.getRcvInf());
                        dtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_OK);
                    } else if (MsGPlatFormConstant.MSG_POOL_SEND_TYPE_SMS.equals(dtl.getSendType())) {
                        htlog.info("did not support SMS, continue");
                        MailSendResult sendResult = sendSMS();
                        if (sendResult != null && sendResult.isSendResult() == true) {
                            dtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_OK);
                        } else {
                            dtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_FAILED);
                            if (sendResult != null) {
                                dtl.setFailedReason(sendResult.getFailedReason());
                            }
                        }
                    }
                    dtl.setSendDate(DateUtil.get14Time());
                    ROOTDAOUtils.getROOTDAO().update(dtl);
                }
                mail.setAddresses(toList);
                MailSendResult sendResult = sendMail(mail);
                if (sendResult != null) {
                    if (sendResult.getFailedReason() != null) {
                        if (sendResult.getFailedReason().length() < 1024) {
                            pool.setFailedReason(sendResult.getFailedReason());
                        } else {
                            pool.setFailedReason(StringUtils.substring(sendResult.getFailedReason(), 0, 1024));
                        }
                    }
                    if (sendResult.isSendResult() == true) {
                        pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_OK);
                    } else {
                        pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_FAILED);
                    }
                } else {
                    pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_SEND_FAILED);
                    pool.setFailedReason("unknow failed reason.");
                }
                pool.setSendTime(DateUtil.get14Time());
                ROOTDAOUtils.getROOTDAO().update(pool);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = ReportCommonService.JOB_FAILED;
            remark = e.getMessage();
        } finally {
            endTm = new Date();
            ReportCommonService.getInstance().saveJobLog(startTm, endTm, jobId, result, jobName, remark);
        }
    }

    private MailSendResult getResultFromList(List<MailSendResult> resultList, String id) {
        if (resultList == null || resultList.size() == 0) {
            return null;
        }
        for (MailSendResult result : resultList) {
            if (id.equals(result.getId())) {
                return result;
            }
        }
        return null;
    }

    public MailSendResult sendMail(MailInfo mailInfo) {
        MailSendResult result = new MailSendResult();

        SmtpInfo smtpInfo = MailUtil.initSmtpInfo();
        if (smtpInfo == null) {
            htlog.info("get smtp info failed");
            result.setFailedReason("get smtp info failed");
            result.setSendResult(false);
            return result;
        }
        return MailUtil.sendMail(smtpInfo, mailInfo);
    }

    public List<MailSendResult> sendMail(List<MailInfo> mailInfoList) {

        SmtpInfo smtpInfo = MailUtil.initSmtpInfo();
        if (smtpInfo == null) {
            htlog.info("get smtp info failed");
            List<MailSendResult> resultList = new ArrayList<MailSendResult>();
            for (MailInfo mailInfo : mailInfoList) {
                MailSendResult result = new MailSendResult();
                result.setId(mailInfo.getId());
                result.setFailedReason("get smtp info failed");
                result.setSendResult(false);
                resultList.add(result);
            }
            return resultList;
        }
        return MailUtil.sendMail(smtpInfo, mailInfoList);
    }

    public MailSendResult sendSMS() {
        MailSendResult result = new MailSendResult();
        result.setFailedReason("No support SMS");
        result.setSendResult(false);
        return result;

    }

}

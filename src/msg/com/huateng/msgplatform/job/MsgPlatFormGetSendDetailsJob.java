package com.huateng.msgplatform.job;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.msgplatform.service.MsGPlatFormConstant;
import com.huateng.report.common.service.ReportCommonService;

import resource.bean.basic.ReportJobConfig;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgPool;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndDtl;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgMsgUsrBranch;

public class MsgPlatFormGetSendDetailsJob implements org.quartz.StatefulJob {
    private Logger htlog = Logger.getLogger(MsgPlatFormGetSendDetailsJob.class);
    private static SimpleDateFormat formatter14 = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat formatter8 = new SimpleDateFormat("yyyyMMdd");

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

            List<CpgMsgPool> list = new ArrayList<CpgMsgPool>();
            StringBuffer hql = new StringBuffer("select po from CpgMsgPool po where 1=1 ");
            hql.append(" and po.status = '").append(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING).append("'");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
            htlog.info(hql);
            if (list.size() == 0) {
                htlog.info("no message need to be sent.");
                return;
            }

            for (CpgMsgPool pool : list) {
                StringBuffer hqlSnd = new StringBuffer("from CpgMsgSndCtl po where 1=1 ");
                hqlSnd.append(" and po.msgId = '").append(pool.getMsgId()).append("'");
                List<CpgMsgSndCtl> listSndCtl = new ArrayList<CpgMsgSndCtl>();
                listSndCtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSnd.toString());
                htlog.info(hqlSnd);
                for (CpgMsgSndCtl sndctl : listSndCtl) {
                    if (MsGPlatFormConstant.MSG_OPR_ID_TYPE_GROUP.equals(sndctl.getOppIdType())) {
                        StringBuffer hqlSndGroup = new StringBuffer(" from CpgMsgGroup po where 1=1 ");
                        hqlSndGroup.append(" and po.groupId = '").append(sndctl.getOppId()).append("' ");
                        List<CpgMsgGroup> listSndGroup = new ArrayList<CpgMsgGroup>();
                        listSndGroup = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSndGroup.toString());
                        htlog.info(hqlSndGroup);
                        if (listSndGroup.size() == 0) {
                            htlog.info("group " + sndctl.getOppId() + " not exist in database.");
                            continue;
                        }
                        for (CpgMsgGroup group : listSndGroup) {
                            StringBuffer hqlSndUsr = new StringBuffer(" from CpgMsgUsr po where 1=1 ");
                            hqlSndUsr.append(" and po.userId = '").append(group.getUserId()).append("' ");
                            List<CpgMsgUsr> listSndUsr = new ArrayList<CpgMsgUsr>();
                            listSndUsr = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSndUsr.toString());
                            htlog.info(hqlSndUsr);
                            if (listSndUsr.size() == 0) {
                                htlog.info("group " + sndctl.getOppId() + " not exist in database.");
                                continue;
                            }
                            for (CpgMsgUsr user : listSndUsr) {

                                if (isUserInBrno(user.getUserId(), pool.getBrno()) == false) {
                                    htlog.info("user " + user.getUserId() + " not belong to brno." + pool.getBrno());
                                    continue;
                                }

                                CpgMsgSndDtl sndDtl = new CpgMsgSndDtl();
                                sndDtl.setMsgLogId(pool.getId());
                                sndDtl.setMsgId(pool.getMsgId());
                                sndDtl.setOppId(user.getUserId());
                                sndDtl.setRcvInf(user.getRcvInf());
                                sndDtl.setSendDate(DateUtil.get14Time());
                                sndDtl.setSendType(user.getSendType());
                                sndDtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING);
                                sndDtl.setRsv1(DateUtil.get14Time());
                                ROOTDAOUtils.getROOTDAO().save(sndDtl);
                            }
                        }
                    } else if (MsGPlatFormConstant.MSG_OPR_ID_TYPE_PERSON.equals(sndctl.getOppIdType())) {

                        if (isUserInBrno(sndctl.getOppId(), pool.getBrno()) == false) {
                            htlog.info("user " + sndctl.getOppId() + " not belong to brno." + pool.getBrno());
                            continue;
                        }

                        StringBuffer hqlSndUsr = new StringBuffer(" from CpgMsgUsr po where 1=1 ");
                        hqlSndUsr.append(" and po.userId = '").append(sndctl.getOppId()).append("' ");
                        List<CpgMsgUsr> listSndUsr = new ArrayList<CpgMsgUsr>();
                        listSndUsr = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSndUsr.toString());
                        htlog.info(hqlSndUsr);
                        if (listSndUsr.size() == 0) {
                            htlog.info("user " + sndctl.getOppId() + " not exist in database.");
                            continue;
                        }

                        CpgMsgUsr user = listSndUsr.get(0);
                        CpgMsgSndDtl sndDtl = new CpgMsgSndDtl();
                        sndDtl.setMsgId(pool.getMsgId());
                        sndDtl.setMsgLogId(pool.getId());
                        sndDtl.setOppId(sndctl.getOppId());
                        sndDtl.setRcvInf(user.getRcvInf());
                        sndDtl.setSendDate(DateUtil.get14Time());
                        sndDtl.setSendType(user.getSendType());
                        sndDtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING);
                        sndDtl.setRsv1(DateUtil.get14Time());
                        ROOTDAOUtils.getROOTDAO().save(sndDtl);

                    }
                }
                pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_GEN_OK);
                pool.setRsv1(DateUtil.get14Time());
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

    public boolean isUserInBrno(String userId, String brno) {
        try {

            if (brno == null || brno.trim().length() == 0) {
                htlog.info("brno is null return true");
                return true;
            }

            StringBuffer hqlSndUsrBranch = new StringBuffer(" from CpgMsgUsrBranch po where 1=1 ");
            hqlSndUsrBranch.append(" and po.userId = '").append(userId).append("' ");
            hqlSndUsrBranch.append(" and po.brno = '").append(brno).append("' ");
            List<CpgMsgUsrBranch> listSndUsrBrCtl = new ArrayList<CpgMsgUsrBranch>();

            listSndUsrBrCtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSndUsrBranch.toString());

            htlog.info(hqlSndUsrBranch);
            if (listSndUsrBrCtl.size() == 0) {
                htlog.info("user " + userId + " not belong to brno." + brno);
                return false;
            }
            return true;
        } catch (CommonException e) {
            e.printStackTrace();
        }
        return false;
    }
}

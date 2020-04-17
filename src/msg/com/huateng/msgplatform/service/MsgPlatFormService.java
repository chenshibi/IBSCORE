package com.huateng.msgplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;

import resource.bean.msg.CpgMsgCtl;
import resource.bean.msg.CpgMsgPool;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndDtl;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgMsgUsrBranch;

public class MsgPlatFormService {
    private static final String DATASET_ID = "MsgPlatFormService";
    private static final Logger htlog = Logger.getLogger(MsgPlatFormService.class);

    public synchronized static MsgSendSettingService getInstance() {
        return (MsgSendSettingService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public static void SendMessageAPI(String msgType, String msgSubType, String msgLog, String brno) {
        try {
            CpgMsgCtl ctl = null;
            List<CpgMsgCtl> list = new ArrayList<CpgMsgCtl>();
            StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where 1=1 ");
            hql.append(" and po.type = '").append(msgType).append("' ");
            hql.append(" and po.subType = '").append(msgSubType).append("' ");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

            if (list.size() > 0) {
                ctl = list.get(0);
            } else {
                htlog.info("msgtype[" + msgType + "]msgsubtype[" + msgSubType + "] not found in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            if ("0".equals(ctl.getStatus()) != true) {
                htlog.info("msgtype[" + msgType + "]msgsubtype[" + msgSubType + "] is disable in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }
            String msgId = ctl.getMsgId();
            SendMessageAPI(msgId, msgLog, brno);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void SendMessageAPIWithRcvUsr(String msgId, String msgLog, String brno, List<String> userIdList) {
        try {
            CpgMsgCtl ctl = null;
            List<CpgMsgCtl> list = new ArrayList<CpgMsgCtl>();
            StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where 1=1 ");
            hql.append(" and po.msgId = '").append(msgId).append("'");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

            if (list.size() > 0) {
                ctl = list.get(0);
            } else {
                htlog.info("msgId[" + msgId + "] not found in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            if ("0".equals(ctl.getStatus()) != true) {
                htlog.info("msgtype[" + msgId + "] is disable in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            CpgMsgPool pool = new CpgMsgPool();
            pool.setBrno(brno);
            pool.setMsgId(msgId);
            pool.setMsgLogHead(ctl.getMsgName());
            pool.setMsgLog(msgLog);
            pool.setMsgSysId(ctl.getSysType());
            pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_GEN_OK);
            pool.setCreatedDate(DateUtil.get14Time());
            ROOTDAOUtils.getROOTDAO().save(pool);

            for (String userId : userIdList) {
                StringBuffer hqlSnd = new StringBuffer("from CpgMsgSndCtl po where 1=1 ");
                hqlSnd.append(" and po.msgId = '").append(pool.getMsgId()).append("'");
                hqlSnd.append(" and po.oppIdType = '1' ");
                hqlSnd.append(" and po.oppId = '").append(userId).append("'");
                List<CpgMsgSndCtl> listSndCtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSnd.toString());
                // htlog.info(hqlSnd);
                if (listSndCtl != null && listSndCtl.size() > 0) {
                    StringBuffer hqlSndUsr = new StringBuffer(" from CpgMsgUsr po where 1=1 ");
                    hqlSndUsr.append(" and po.userId = '").append(userId).append("' ");
                    List<CpgMsgUsr> listSndUsr = ROOTDAOUtils.getROOTDAO().queryByCondition(hqlSndUsr.toString());
                    htlog.info(hqlSndUsr);
                    if (listSndUsr != null && listSndUsr.size() == 0) {
                        htlog.info("user " + userId + " not exist in CpgMsgUsr.");
                        continue;
                    }

                    for (CpgMsgUsr user : listSndUsr) {
                        CpgMsgSndDtl sndDtl = new CpgMsgSndDtl();
                        sndDtl.setMsgId(pool.getMsgId());
                        sndDtl.setMsgLogId(pool.getId());
                        sndDtl.setOppId(userId);
                        sndDtl.setRcvInf(user.getRcvInf());
                        sndDtl.setSendDate(DateUtil.get14Time());
                        sndDtl.setSendType(user.getSendType());
                        sndDtl.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING);
                        sndDtl.setRsv1(DateUtil.get14Time());
                        ROOTDAOUtils.getROOTDAO().save(sndDtl);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void SendMessageAPI(String msgId, String msgLog, String brno) {
        try {
            CpgMsgCtl ctl = null;
            List<CpgMsgCtl> list = new ArrayList<CpgMsgCtl>();
            StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where 1=1 ");
            hql.append(" and po.msgId = '").append(msgId).append("'");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

            if (list.size() > 0) {
                ctl = list.get(0);
            } else {
                htlog.info("msgId[" + msgId + "] not found in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            if ("0".equals(ctl.getStatus()) != true) {
                htlog.info("msgtype[" + msgId + "] is disable in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            CpgMsgPool pool = new CpgMsgPool();
            pool.setBrno(brno);
            pool.setMsgId(msgId);
            pool.setMsgLogHead(ctl.getMsgName());
            pool.setMsgLog(msgLog);
            pool.setMsgSysId(ctl.getSysType());
            pool.setCreatedDate(DateUtil.get14Time());
            pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING);
            ROOTDAOUtils.getROOTDAO().save(pool);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void SendMessageAPINew(String msgId, String msgLog, String brno) {
        try {
            CpgMsgCtl ctl = null;
            List<CpgMsgCtl> list = new ArrayList<CpgMsgCtl>();
            StringBuffer hql = new StringBuffer("select po from CpgMsgCtl po where 1=1 ");
            hql.append(" and po.msgid = '").append(msgId).append("'");
            list = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

            if (list.size() > 0) {
                ctl = list.get(0);
            } else {
                htlog.info("msgId[" + msgId + "] not found in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            if ("0".equals(ctl.getStatus()) != true) {
                htlog.info("msgtype[" + msgId + "] is disable in the database.");
                htlog.info("msgLog=[" + msgLog + "] will not send out.");
                return;
            }

            StringBuffer hqlSnd = new StringBuffer("select po from cpgmsgsndctl po where 1=1 ");
            hql.append(" and po.msgid = '").append(msgId).append("'");
            List<CpgMsgSndCtl> listSndCtl = new ArrayList<CpgMsgSndCtl>();
            listSndCtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());

            for (CpgMsgSndCtl sndctl : listSndCtl) {
                if (MsGPlatFormConstant.MSG_OPR_ID_TYPE_GROUP.equals(sndctl.getOppIdType())) {

                } else if (MsGPlatFormConstant.MSG_OPR_ID_TYPE_PERSON.equals(sndctl.getOppIdType())) {
                    if (brno == null || brno.trim().length() == 0) {
                        htlog.info("brno id null, send to every one.");
                    } else {
                        StringBuffer hqlSndUsrBranch = new StringBuffer("select po from CPGMSGUSRBRANCH po where 1=1 ");
                        hql.append(" and po.userid = '").append(sndctl.getOppId()).append("' ");
                        hql.append(" and po.brno = '").append(brno).append("' ");
                        List<CpgMsgUsrBranch> listSndUsrBrCtl = new ArrayList<CpgMsgUsrBranch>();
                        listSndUsrBrCtl = ROOTDAOUtils.getROOTDAO().queryByCondition(hql.toString());
                        if (listSndUsrBrCtl.size() == 0) {
                            htlog.info("user " + sndctl.getOppId() + "no belong to brno." + brno);
                            htlog.info("msgLog=[" + msgLog + "] will not send out.");
                            continue;
                        }
                    }

                    CpgMsgPool pool = new CpgMsgPool();
                    pool.setBrno(brno);
                    pool.setMsgId(msgId);
                    pool.setMsgLogHead(ctl.getRsv1());
                    pool.setMsgLog(msgLog);
                    pool.setCreatedDate(DateUtil.get14Time());
                    pool.setStatus(MsGPlatFormConstant.MSG_POOL_STATUS_PENDING);
                    ROOTDAOUtils.getROOTDAO().save(pool);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

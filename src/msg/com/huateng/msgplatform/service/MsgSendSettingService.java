package com.huateng.msgplatform.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.msgplatform.getter.MsgSndSettingBean;

import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndCtlTmp;

public class MsgSendSettingService {

    private static final String DATASET_ID = "MsgSendSettingService";
    private static final HtLog htlog = HtLogFactory.getLogger(MsgSendSettingService.class);
    private ROOTDAO rootDao;

    public synchronized static MsgSendSettingService getInstance() {
        return (MsgSendSettingService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public <T> void delete(String id, Class classs) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.delete(classs, id);
    }

    public <T> void save(T t) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(t);
    }

    public <T> void update(T t) throws CommonException {

        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(t);

    }

    // 获得要操作的Item
    @SuppressWarnings("unchecked")
    public Iterator selectByid(String id, String hql) {
        ROOTDAO rootDAO = ROOTDAOUtils.getROOTDAO();

        try {
            return rootDAO.queryByQL(hql);
        } catch (CommonException e) {
            e.printStackTrace();
            return null;
        }

    }

    // 通过id来获取实体映射类
    @SuppressWarnings("unchecked")
    public <T> T selectById(String id, T t) {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        T t1 = null;
        try {
            t1 = (T) rootdao.query(t.getClass(), id);
        } catch (CommonException e) {
            htlog.info("对象不存在");
            e.printStackTrace();
        }
        return t1;
    }

    public void deleteBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void updateBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void auditRcvUsrInf(String approveStatusChoose, String approveResultChoose, List<MsgSndSettingBean> tmpList)
            throws CommonException {
        // 审核同意
        if ("1".equals(approveStatusChoose)) {
            for (MsgSndSettingBean bean : tmpList) {
                // 冲突检查
                MsgSendSettingService.beforeCheck(bean.getMsgId(), bean.getCreator());

                String optType = bean.getOptType();
                // 1-新增 2-修改 3-删除
                if ("1".equals(optType)) {
                    // 1-新增
                    // insert into to cpg_msg_snd_ctl
//                    this.saveNew2Entry(bean);
                } else if ("2".equals(optType)) {
                    // 2-修改
                    // delete from cpg_msg_snd_ctl
                    // insert into to cpg_msg_snd_ctl
//                    this.deleteFromEntry(bean);
//                    this.saveNew2Entry(bean);
                } else if ("3".equals(optType)) {
                    // 3-删除
                    // delete from cpg_msg_snd_ctl
//                    this.deleteFromEntry(bean);
                }
                // 最后save tmp表，加入check_user,check_date,optStatus字段 设置(OPT_STATUS
                // = 1) 1-已审核
                this.save2Tmp(bean, approveStatusChoose, approveResultChoose);
            }
        }
        // 审核拒绝
        if ("2".equals(approveStatusChoose)) {
            for (MsgSndSettingBean bean : tmpList) {
                // 冲突检查
                MsgSendSettingService.beforeCheck(bean.getMsgId(), bean.getCreator());
                // 最后save tmp表，加入check_user,check_date,optStatus字段 设置(OPT_STATUS
                // = 2) 1-已拒绝
                this.save2Tmp(bean, approveStatusChoose, approveResultChoose);
            }
        }
    }

    public void save2Tmp(MsgSndSettingBean tmp, String approveStatusChoose, String approveResultChoose)
            throws CommonException {
        // 根据msgId 查询出所有未审核的记录
        String hql = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '1' and po.msgId = '"
                + tmp.getMsgId() + "'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CpgMsgSndCtlTmp> list = rootdao.queryByCondition(hql);
        for (CpgMsgSndCtlTmp tmpBean : list) {
            MsgplatformStatusUtil.setAuditMsgStatus(tmpBean, approveStatusChoose, approveResultChoose);
            // 记录审核信息后保存
            this.save(tmpBean);
        }
    }

    public void deleteFromEntry(String  msgId) throws CommonException {
        String sql = "delete from cpg_msg_snd_ctl where msg_Id = '" + msgId + "'";
        String sql2 = "delete from CPG_MSG_SND_CTL_TMP where msg_Id = '" + msgId + "'";
        this.deleteBySql(sql);
        this.deleteBySql(sql2);
    }
    

    public List<String> getUsrListByMsgId(String msgId) throws CommonException {
        htlog.info("msgid = " + msgId);
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String sql1 = "select po from CpgMsgSndCtl po where 1=1 and po.msgId = ? ";
        List<CpgMsgSndCtl> list1 = rootdao.queryByCondition(sql1, new String[] { msgId });
        if (list1 == null || list1.size() == 0) {
            htlog.info("msgid = " + msgId + ", return null");
            return null;
        } else {
            List<String> usrList = new ArrayList<String>();
            for (CpgMsgSndCtl ctl : list1) {
                htlog.info("ctl.getOppId() = " + ctl.getOppId());
                usrList.add(ctl.getOppId());
            }
            return usrList;
        }

    }

//    public void saveNew2Entry(MsgSndSettingBean tmp) throws CommonException {
//        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//        String date = dateFormat.format(new Date());
//        String tlrNo = globalInfo.getTlrno();
//
//        // 根据msgId 查询出所有未审核的记录
//        String hql = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '0' and po.msgId = '"
//                + tmp.getMsgId() + "'";
//        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//        List<CpgMsgSndCtlTmp> list = rootdao.queryByCondition(hql);
//        for (CpgMsgSndCtlTmp tmpBean : list) {
//            // 遍历后更新主表
//            CpgMsgSndCtl entry = new CpgMsgSndCtl();
//            entry.setMsgId(tmpBean.getMsgId());
//            entry.setOppIdType(tmpBean.getOppIdType());
//            entry.setOppId(tmpBean.getOppId());
//            entry.setCreator(tmpBean.getCreator());
//            entry.setCreatedDate(tmpBean.getCreatedDate());
//            entry.setCheckUser(tlrNo);
//            entry.setCheckDate(date);
//            this.save(entry);
//        }
//    }
 // 根据msgId 查询出所有tmp表的记录
    public List<CpgMsgSndCtlTmp> getSndCtlTmp(String msgId ) throws CommonException{
    	String hql = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '1' and po.msgId = '"+msgId+ "'";
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	 List<CpgMsgSndCtlTmp> list = rootdao.queryByCondition(hql);
    	 if(null != list && list.size()>0){
    		 return list;
    	 }
		return null;
    }
    
 // 根据msgId 查询出所有tmp表的记录
    public List<CpgMsgSndCtlTmp> getSndCtlTmp2(String msgId ) throws CommonException{
    	String hql = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '1' and po.optType='2' and po.msgId = '"+msgId+ "'";
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
    	 List<CpgMsgSndCtlTmp> list = rootdao.queryByCondition(hql);
    	 if(null != list && list.size()>0){
    		 return list;
    	 }
		return null;
    }

    public static void beforeSubmit(String opType, String msgId) throws CommonException {
        ROOTDAO rootdao;
        if ("new".equals(opType)) {
            rootdao = ROOTDAOUtils.getROOTDAO();
            String sql1 = "select po from CpgMsgSndCtl po where 1=1 and po.msgId = '" + msgId + "'";
            String sql2 = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '0' and po.msgId = '" + msgId
                    + "'";
            List list1 = rootdao.queryByCondition(sql1);
            if (list1 != null && list1.size() > 0)
                ExceptionUtil.throwCommonException("消息编号已存在，请直接修改！", "提交操作错误");
            List list2 = rootdao.queryByCondition(sql2);
            if (list2 != null && list2.size() > 0)
                ExceptionUtil.throwCommonException("消息编号已被录入待审核，请核对！", "提交操作错误");

        } else {
            rootdao = ROOTDAOUtils.getROOTDAO();
            String sql1 = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '0' and po.msgId = '" + msgId
                    + "'";
            List list1 = rootdao.queryByCondition(sql1);
            if (list1 != null && list1.size() > 0)
                ExceptionUtil.throwCommonException("该记录已被修改或删除待审核，请勿重复提交！", "提交操作错误");
        }
    }

    public static void beforeCheck(String msgId, String creator) throws CommonException {
        String oprNo = GlobalInfo.getCurrentInstance().getTlrno();
//        if (oprNo.equals(creator)) {
//            ExceptionUtil.throwCommonException("审核和录入是同一操作人，不能审核！\r\n", "审核操作错误");
//        }

        String sql = "select po from CpgMsgSndCtlTmp po where 1=1 and po.optStatus = '0' and po.msgId = '" + msgId
                + "'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CpgMsgSndCtlTmp> list = rootdao.queryByCondition(sql);
        if (list == null || list.size() == 0) {
            ExceptionUtil.throwCommonException("该记录已被审核，请勿重复提交！", "提交操作错误");
        }
    }

}

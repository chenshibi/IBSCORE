package com.huateng.msgplatform.service;

import java.util.Iterator;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.msg.CpgGroupInf;
import resource.bean.msg.CpgGroupInfTmp;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgUsrInfTmp;

public class RcvUserGroupService {

    private static final String DATASET_ID = "RcvUserGroupService";
    private static final HtLog htlog = HtLogFactory.getLogger(RcvUserGroupService.class);
    private ROOTDAO rootDao;

    public synchronized static RcvUserGroupService getInstance() {
        return (RcvUserGroupService) ApplicationContextUtils.getBean(DATASET_ID);
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

    public void auditRcvUGroupInf(String approveStatusChoose, String approveResultChoose, List<CpgGroupInfTmp> tmpList)
            throws CommonException {
        // 审核同意
//        if ("1".equals(approveStatusChoose)) {
//            for (CpgGroupInfTmp bean : tmpList) {
//                // 冲突检查
//                RcvUserGroupService.beforeCheck(bean);
//                // 先save tmp表，加入check_user,check_date,optStatus字段
//                saveTmp(bean, approveStatusChoose, approveResultChoose);
//                String optType = bean.getOptType();
//                String delSql = "";
//                String insertSql = "";
//                // 1-新增 2-修改 3-删除
//                if ("1".equals(optType)) {
////                    // 新增时要 save to CpgUsrInf
////                    CpgGroupInf groupInf = new CpgGroupInf();
////                    groupInf.setGroupId(bean.getGroupId());
////                    groupInf.setGroupName(bean.getGroupName());
////                    groupInf.setCreator(bean.getCreator());
////                    groupInf.setCreatedDate(bean.getCreatedDate());
////                    groupInf.setCheckUser(bean.getCheckUser());
////                    groupInf.setCheckDate(bean.getCheckDate());
////                    this.save(groupInf);
////
////                    insertSql = "insert into CPG_MSG_GROUP (id,group_id,user_id,creator,created_date,check_user,check_date) "
////                            + " select id,group_id,user_id,creator,created_date,check_user,check_date from CPG_MSG_GROUP_TMP tmp"
////                            + " where tmp.inner_id = '" + bean.getId() + "'";
////                    this.updateBySql(insertSql);
//
//                } else if ("2".equals(optType)) {
//
////                    delSql = "delete from CPG_MSG_GROUP where group_id = '" + bean.getGroupId() + "'";
////                    this.deleteBySql(delSql);
////
////                    insertSql = "insert into CPG_MSG_GROUP (id,group_id,user_id,creator,created_date,check_user,check_date) "
////                            + " select id,group_id,user_id,creator,created_date,check_user,check_date from CPG_MSG_GROUP_TMP tmp"
////                            + " where tmp.inner_id = '" + bean.getId() + "'";
////                    this.updateBySql(insertSql);
////
//                } else if ("3".equals(optType)) {
//
////                    delSql = "delete from CPG_MSG_GROUP where group_id = '" + bean.getGroupId() + "'";
////                    this.deleteBySql(delSql);
////                    delSql = "delete from CPG_GROUP_INF where group_id = '" + bean.getGroupId() + "'";
////                    this.deleteBySql(delSql);
////                    delSql = "delete from CPG_MSG_SND_CTL where opp_id_type = '2' and opp_id = '" + bean.getGroupId()
////                            + "'";
////                    this.deleteBySql(delSql);
//                }
//            }
//        }
    }
//        // 审核拒绝
//        if ("2".equals(approveStatusChoose)) {
//            for (CpgGroupInfTmp bean : tmpList) {
//                // 冲突检查
//                RcvUserGroupService.beforeCheck(bean);
//                saveTmp(bean, approveStatusChoose, approveResultChoose);
//            }
//        }
//    }

    public void saveTmp(CpgGroupInfTmp tmp, String approveStatusChoose, String approveResultChoose)
            throws CommonException {
        MsgplatformStatusUtil.setAuditMsgStatus(tmp, approveStatusChoose, approveResultChoose);
        this.save(tmp);
        String innerId = tmp.getId();
        // Cpg_Msg_Group_Tmp
        StringBuffer sql1 = new StringBuffer(" update Cpg_Msg_Group_Tmp set opt_Status='").append(approveStatusChoose)
                .append("',check_User='").append(tmp.getCheckUser()).append("',check_Date='").append(tmp.getCheckDate())
                .append("' where inner_Id='").append(innerId).append("'");
        this.updateBySql(sql1.toString());
    }

    public static void beforeSubmit(String opType, String groupId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        if ("new".equals(opType)) {
            String sql1 = "select po from CpgGroupInf po where 1=1 and po.groupId = '" + groupId + "'";
            List list1 = rootdao.queryByCondition(sql1);
            if (list1 != null && list1.size() > 0) {
                ExceptionUtil.throwCommonException("组ID已存在，请核对！", "提交操作错误");
            }
            String sql2 = "select po from CpgGroupInfTmp po where 1=1 and po.groupId = '" + groupId
                    + "' and po.optStatus = '0'";
            List list2 = rootdao.queryByCondition(sql2);
            if (list2 != null && list2.size() > 0) {
                ExceptionUtil.throwCommonException("组ID已录入待审核，请核对！", "提交操作错误");
            }
        } else {
            String sql = "select t from CpgGroupInfTmp t where 1=1 and t.groupId = '" + groupId
                    + "' and t.optStatus = '0'";
            List list = rootdao.queryByCondition(sql);
            if (list != null && list.size() > 0)
                ExceptionUtil.throwCommonException("该记录已被修改或删除待审核，请勿重复提交！", "提交操作错误");
        }
    }

    public static void beforeCheck(CpgGroupInfTmp bean) throws CommonException {
        String oprNo = GlobalInfo.getCurrentInstance().getTlrno();
        String creator = bean.getCreator();
//        if (creator.equals(oprNo)) {
//            ExceptionUtil.throwCommonException("审核和录入是同一操作人，不能审核！\r\n", "审核操作错误");
//        }

        String sql = "select po from CpgGroupInfTmp po where po.id = '" + bean.getId() + "' and po.optStatus = '0'";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List<CpgUsrInfTmp> list = rootdao.queryByCondition(sql);
        if (list == null || list.size() == 0) {
            ExceptionUtil.throwCommonException("该记录已被审核，请勿重复提交！", "提交操作错误");
        }
    }
    public List<CpgMsgGroup> queryMsg(String groupId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	String sql="select po from CpgMsgGroup po where po.groupId='"+groupId+"'";
    	List<CpgMsgGroup> list=dao.queryByCondition(sql);
		return list;
    }
    
    public List<CpgGroupInf> queryInf(String groupId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	String sql="select po from CpgGroupInf po where po.groupId='"+groupId+"'";
    	List<CpgGroupInf> list=dao.queryByCondition(sql);
		return list;
    }
    
    
    public List<CpgMsgSndCtl> querySnd(String groupId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	String sql="select po from CpgMsgSndCtl po where po.oppId='"+groupId+"'";
    	List<CpgMsgSndCtl> list=dao.queryByCondition(sql);
		return list;
    }
    
}

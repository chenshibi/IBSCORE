package com.huateng.msgplatform.service;

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

import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgMsgUsrTmp;
import resource.bean.msg.CpgUsrInf;
import resource.bean.msg.CpgUsrInfTmp;

public class RcvUserService {

    private static final String DATASET_ID = "RcvUserService";
    private static final HtLog htlog = HtLogFactory.getLogger(RcvUserService.class);
    private ROOTDAO rootDao;

    public synchronized static RcvUserService getInstance() {
        return (RcvUserService) ApplicationContextUtils.getBean(DATASET_ID);
    }

    public <T> void delete(String id, Class classs) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.delete(classs, id);
    }

    public <T> void save(T t) throws CommonException {
        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(t);
    }

    public <CpgMsgUsr> void update(String userId) throws CommonException {

        rootDao = ROOTDAOUtils.getROOTDAO();
        rootDao.saveOrUpdate(userId);

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

    public void auditRcvUsrInf(String approveStatusChoose, String approveResultChoose, List<CpgUsrInfTmp> tmpList)
            throws CommonException {
        // 审核同意
        if ("1".equals(approveStatusChoose)) {
            for (CpgUsrInfTmp bean : tmpList) {
                // 冲突检查
//                RcvUserService.beforeCheck(bean);
                // 先save tmp表，加入check_user,check_date,optStatus字段
                saveTmp(bean, approveStatusChoose, approveResultChoose);
                String optType = bean.getOptType();
                String delSql = "";
                String sql1 = "";
                String sql2 = "";
                // 1-新增 2-修改 3-删除
                if ("1".equals(optType)) {
//                    // 新增时要 save to CpgUsrInf
//                    // doSome
//                    CpgUsrInf cpgUsrInf = new CpgUsrInf();
//                    cpgUsrInf.setUserId(bean.getUserId());
//                    cpgUsrInf.setUserName(bean.getUserName());
//                    cpgUsrInf.setBrno(bean.getBrno());
//                    cpgUsrInf.setUserType(bean.getUserType());
//                    cpgUsrInf.setCreator(bean.getCreator());
//                    cpgUsrInf.setCreatedDate(bean.getCreatedDate());
//                    cpgUsrInf.setCheckUser(bean.getCheckUser());
//                    cpgUsrInf.setCheckDate(bean.getCheckDate());
//                    this.save(cpgUsrInf);
//
//                    sql1 = "insert into CPG_MSG_USR_BRANCH (id,user_id,brno,creator,created_date,check_user,check_date) "
//                            + " select id,user_id,brno,creator,created_date,check_user,check_date from CPG_MSG_USR_BRANCH_TMP tmp"
//                            + " where tmp.inner_Id = '" + bean.getId() + "'";
//                    this.updateBySql(sql1);
//
//                    sql2 = "insert into CPG_MSG_USR (id,user_id,send_type,rcv_inf,creator,created_date,check_user,check_date)"
//                            + " select id,user_id,send_type,rcv_inf,creator,created_date,check_user,check_date from CPG_MSG_USR_TMP tmp"
//                            + " where tmp.inner_Id = '" + bean.getId() + "'";
//                    this.updateBySql(sql2);
                } else if ("2".equals(optType)) {
//                    delSql = "delete from CPG_MSG_USR_BRANCH where user_id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    sql1 = "insert into CPG_MSG_USR_BRANCH (id,user_id,brno,mod_user,mod_date,check_user,check_date) "
//                            + " select id,user_id,brno,creator,created_date,check_user,check_date from CPG_MSG_USR_BRANCH_TMP tmp"
//                            + " where tmp.inner_Id = '" + bean.getId() + "'";
//                    this.updateBySql(sql1);
//
//                    delSql = "delete from CPG_MSG_USR where user_id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    sql2 = "insert into CPG_MSG_USR (id,user_id,send_type,rcv_inf,mod_user,mod_date,check_user,check_date)"
//                            + " select id,user_id,send_type,rcv_inf,creator,created_date,check_user,check_date from CPG_MSG_USR_TMP tmp"
//                            + " where tmp.inner_Id = '" + bean.getId() + "'";
//                    this.updateBySql(sql2);
                } else if ("3".equals(optType)) {
//                    delSql = "delete from Cpg_Usr_Inf where user_id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    delSql = "delete from CPG_MSG_USR_BRANCH where user_id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    delSql = "delete from CPG_MSG_USR where user_id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    // 删除用户组中的对应记录
//                    delSql = "delete from CPG_MSG_GROUP where user_Id = '" + bean.getUserId() + "'";
//                    this.deleteBySql(delSql);
//                    // 删除消息发送配置中的对应配置
//                    delSql = "delete from CPG_MSG_SND_CTL where opp_id_type = '1' and opp_id = '" + bean.getUserId()
//                            + "'";
//                    this.deleteBySql(delSql);
                }
            }
        }
//        // 审核拒绝
//        if ("2".equals(approveStatusChoose)) {
//            for (CpgUsrInfTmp bean : tmpList) {
//                // 冲突检查
////                RcvUserService.beforeCheck(bean);
//                saveTmp(bean, approveStatusChoose, approveResultChoose);
//            }
//        }
    }

    public void saveTmp(CpgUsrInfTmp tmp, String approveStatusChoose, String approveResultChoose)
            throws CommonException {
        MsgplatformStatusUtil.setAuditMsgStatus(tmp, approveStatusChoose, approveResultChoose);
        this.save(tmp);

        String innerId = tmp.getId();
        // Cpg_Msg_Usr_Tmp
        StringBuffer sql1 = new StringBuffer(" update Cpg_Msg_Usr_Tmp set opt_Status='").append(approveStatusChoose)
                .append("',check_User='").append(tmp.getCheckUser()).append("',check_Date='").append(tmp.getCheckDate())
                .append("' where inner_Id='").append(innerId).append("'");
        this.updateBySql(sql1.toString());
        // Cpg_Msg_Usr_Branch_Tmp
        StringBuffer sql2 = new StringBuffer(" update Cpg_Msg_Usr_Branch_Tmp set opt_Status='")
                .append(approveStatusChoose).append("',check_User='").append(tmp.getCheckUser())
                .append("',check_Date='").append(tmp.getCheckDate()).append("' where inner_Id='").append(innerId)
                .append("'");
        this.updateBySql(sql2.toString());

    }

    public static void beforeSubmit(String opType, String userId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        if ("new".equals(opType)) {
            String sql1 = "select po from CpgUsrInf po where 1=1 and po.userId = '" + userId + "'";
            List list1 = rootdao.queryByCondition(sql1);
            if (list1 != null && list1.size() > 0) {
                ExceptionUtil.throwCommonException("操作员ID已存在，请核对！", "提交操作错误");
            }
            String sql2 = "select po from CpgUsrInfTmp po where 1=1 and po.userId = '" + userId
                    + "' and po.optStatus = '0'";
            List list2 = rootdao.queryByCondition(sql2);
            if (list2 != null && list2.size() > 0) {
                ExceptionUtil.throwCommonException("操作员ID已录入待审核，请核对！", "提交操作错误");
            }

        } else {
            String sql = "select t from CpgUsrInfTmp t where 1=1 and t.userId = '" + userId + "' and t.optStatus = '0'";
            List list = rootdao.queryByCondition(sql);
            if (list != null && list.size() > 0)
                ExceptionUtil.throwCommonException("该记录已被修改或删除待审核，请勿重复提交！", "提交操作错误");
        }
    }
    public List<CpgMsgUsrTmp> 	QuCpgMsgUsrtmp( String userId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	  String sql = "select po from CpgMsgUsrTmp po where 1=1 and po.optType = '2' order by CREATED_DATE DESC";
    	List list=dao.queryByCondition(sql);
		return list;
    	
    }
    public List<CpgMsgUsr> 	QuCpgMsgUsr( String userId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	  String sql = "select po from CpgMsgUsr po where 1=1 and po.userId =  '" + userId+"'";
    	List list=dao.queryByCondition(sql);
		return list;
    }
    public List<CpgUsrInf> 	QuCpgUsrInf( String userId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	  String sql = "select po from CpgUsrInf po where 1=1 and po.userId =  '" + userId+"'";
    	List list=dao.queryByCondition(sql);
		return list;
    }
    public List<CpgMsgSndCtl> querySnd(String userId) throws CommonException{
    	ROOTDAO dao=ROOTDAOUtils.getROOTDAO();
    	String sql="select po from CpgMsgSndCtl po where po.oppId='"+userId+"'";
    	List<CpgMsgSndCtl> list=dao.queryByCondition(sql);
		return list;
    }

//    public static void beforeCheck(CpgUsrInfTmp bean) throws CommonException {
//        String oprNo = GlobalInfo.getCurrentInstance().getTlrno();
//        String creator = bean.getCreator();
//        if (creator.equals(oprNo)) {
//            ExceptionUtil.throwCommonException("审核和录入是同一操作人，不能审核！\r\n", "审核操作错误");
//        }

//        String sql = "select po from CpgUsrInfTmp po where po.id = '" + bean.getId() + "' and po.optStatus = '0'";
//        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
//        List<CpgUsrInfTmp> list = rootdao.queryByCondition(sql);
//        if (list == null || list.size() == 0) {
//            ExceptionUtil.throwCommonException("该记录已被审核，请勿重复提交！", "提交操作错误");
//        }
//    }

}

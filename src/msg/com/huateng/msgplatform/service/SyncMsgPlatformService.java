package com.huateng.msgplatform.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.service.pub.RoleInfoService;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.TlrBctlRel;
import resource.bean.basic.TlrInfo;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgMsgUsrBranch;
import resource.bean.msg.CpgUsrInf;
import resource.dao.basic.RoleInfoDAO;
import resource.dao.basic.TlrBctlRelDAO;
import resource.dao.basic.TlrInfoDAO;

public class SyncMsgPlatformService {
    private static final Logger log = Logger.getLogger(SyncMsgPlatformService.class);

    public synchronized static SyncMsgPlatformService getInstance() {

        return (SyncMsgPlatformService) ApplicationContextUtils.getBean(SyncMsgPlatformService.class.getName());
    }

    /**
     * 
     * @param type:
     *            1-tlrno 2-role
     * @return
     */
    public boolean syncCpgMsgUsrBranch(String userId, int type) {
        log.info("userid = " + userId + " type = " + type);

        List<CpgMsgUsrBranch> cmubList = ROOTDAOUtils.getCpgMsgUsrBranchDAO().findByUserId(userId);
        for (CpgMsgUsrBranch cpgMsgUsrBranch : cmubList) {
            ROOTDAOUtils.getCpgMsgUsrBranchDAO().delete(cpgMsgUsrBranch);
        }
        if (type == 1) {
            TlrBctlRelDAO dao = ROOTDAOUtils.getTlrBctlRelDAO();

            List<TlrBctlRel> list = dao.findByTlr(userId);
            for (TlrBctlRel rel : list) {
                if ("1".equals(rel.getStatus())) {
                    CpgMsgUsrBranch cmub = new CpgMsgUsrBranch();
                    cmub.setBrno(rel.getBrNo());
                    cmub.setUserId(rel.getTlrNo());
                    ROOTDAOUtils.getCpgMsgUsrBranchDAO().save(cmub);
                }
            }
        } else {
            RoleInfo roleinfo = null;
            try {
                roleinfo = RoleInfoService.getInstance().getRoleInfoByRoleName(userId);
            } catch (CommonException e) {
                e.printStackTrace();
            }
            if (roleinfo != null) {
                CpgMsgUsrBranch cmub = new CpgMsgUsrBranch();
                cmub.setBrno(roleinfo.getBrno());
                cmub.setUserId(roleinfo.getRoleName());
                ROOTDAOUtils.getCpgMsgUsrBranchDAO().save(cmub);
            }
        }
        return true;
    }

    /**
     * 
     * @param tlrno:
     *            TLRNO in table TLR_INFO -->CPG_MSG_USR
     * @param type:
     *            1-add,2-update,3-delete
     * @return
     */
    public boolean syncToMsgUser(String tlrno, int type) {
        log.info("tlrno = " + tlrno + ", type = " + type);
        TlrInfoDAO tlrInfoDAO = BaseDAOUtils.getTlrInfoDAO();
        TlrInfo tlrInfo = null;
        try {
            tlrInfo = tlrInfoDAO.queryById(tlrno);
            if (tlrInfo == null) {
                log.error("tlrno " + tlrno + " not exists.");
                return false;
            }
            if (tlrInfo.getFlag().equals("0")) {
                type = 3;
            }
            if (type == 1) {// CpgMsgUsr--add
                boolean existFlag = false;
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(tlrno);
                if (cpgMsgUsr == null) {
                    existFlag = true;
                    cpgMsgUsr = new CpgMsgUsr();
                }
                cpgMsgUsr.setUserId(tlrInfo.getTlrno());// 操作员ID
                cpgMsgUsr.setSendType("02");// 发送方式:2:邮件
                cpgMsgUsr.setRcvInf(tlrInfo.getEmail());// 邮件地址
                cpgMsgUsr.setCreator(tlrInfo.getMaker());// 创建者
                cpgMsgUsr.setCreatedDate(tlrInfo.getMakeTime());// 创建时间
                cpgMsgUsr.setCheckUser(tlrInfo.getChecker());// 审核人
                cpgMsgUsr.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                if (existFlag) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().save(cpgMsgUsr);
                } else {
                    ROOTDAOUtils.getCpgMsgUsrDAO().update(cpgMsgUsr);
                }
                // CpgUsrInf--add
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(tlrno);
                if (cpgUsrInf == null) {
                    existFlag = true;
                    cpgUsrInf = new CpgUsrInf();
                }
                cpgUsrInf.setUserId(tlrInfo.getTlrno());// 操作员ID
                cpgUsrInf.setUserName(tlrInfo.getTlrName());//
                cpgUsrInf.setCreator(tlrInfo.getMaker());// 创建者
                cpgUsrInf.setCreatedDate(tlrInfo.getMakeTime());// 创建时间
                cpgUsrInf.setCheckUser(tlrInfo.getChecker());// 审核人
                cpgUsrInf.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                cpgUsrInf.setRsv1(tlrInfo.getEmail());
                cpgUsrInf.setBrno(tlrInfo.getBrcode());
              //  cpgUsrInf.setRoleGroup(tlrInfo.getRoleGroup());
                if (existFlag) {
                    ROOTDAOUtils.getCpgUsrInfDAO().save(cpgUsrInf);
                } else {
                    ROOTDAOUtils.getCpgUsrInfDAO().update(cpgUsrInf);
                }
            } else if (type == 2) {// update
                boolean existFlag = true;
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(tlrno);
                if (cpgMsgUsr == null) {
                    existFlag = false;
                    cpgMsgUsr = new CpgMsgUsr();
                }
                cpgMsgUsr.setUserId(tlrInfo.getTlrno());// 操作员ID
                cpgMsgUsr.setSendType("02");// 发送方式:2:邮件
                cpgMsgUsr.setRcvInf(tlrInfo.getEmail());// 邮件地址
                cpgMsgUsr.setModUser(tlrInfo.getMaker());// 最后修改人
                cpgMsgUsr.setModDate(tlrInfo.getMakeTime());// 最后修改时间
                cpgMsgUsr.setCheckUser(tlrInfo.getChecker());// 审核人
                cpgMsgUsr.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                if (existFlag) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().update(cpgMsgUsr);
                } else {
                    ROOTDAOUtils.getCpgMsgUsrDAO().save(cpgMsgUsr);
                }
                // CpgUsrInf -- update
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(tlrno);
                if (cpgUsrInf == null) {
                    existFlag = false;
                    cpgUsrInf = new CpgUsrInf();
                }
                cpgUsrInf.setUserId(tlrInfo.getTlrno());// 操作员ID
                cpgUsrInf.setUserName(tlrInfo.getTlrName());//
                cpgUsrInf.setModUser(tlrInfo.getMaker());// 最后修改人
                cpgUsrInf.setModDate(tlrInfo.getMakeTime());// 最后修改时间
                cpgUsrInf.setCheckUser(tlrInfo.getChecker());// 审核人
                cpgUsrInf.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                cpgUsrInf.setRsv1(tlrInfo.getEmail());
                cpgUsrInf.setBrno(tlrInfo.getBrcode());
                //cpgUsrInf.setRoleGroup(tlrInfo.getRoleGroup());
                if (existFlag) {
                    ROOTDAOUtils.getCpgUsrInfDAO().update(cpgUsrInf);
                } else {
                    ROOTDAOUtils.getCpgUsrInfDAO().save(cpgUsrInf);
                }
            } else if (type == 3) {// delete
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(tlrno);
                if (cpgMsgUsr != null) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().delete(cpgMsgUsr);
                }
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(tlrno);
                if (cpgUsrInf != null) {
                    ROOTDAOUtils.getCpgUsrInfDAO().delete(cpgUsrInf);
                }
            }

            syncCpgMsgUsrBranch(tlrInfo.getTlrno(), 1);
            return true;
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 
     * @param roleid:
     *            ROLEID in table ROLE_INFO -->CPG_MSG_USR
     * @param type:
     *            1-add,2-update,3-delete
     * @return
     */
    public boolean syncToMsgRole(String roleid, int type) {
        log.info("roleid = " + roleid + ", type = " + type);
        RoleInfoDAO roleInfoDAO = BaseDAOUtils.getRoleInfoDAO();
        RoleInfo roleInfo = null;
        try {
            roleInfo = roleInfoDAO.query(roleid);
            if (roleInfo == null) {
                log.error("roleid " + roleid + " not exists.");
                return false;
            }
            if (roleInfo.getStatus().equals("0")) {
                type = 3;
            }
            if (type == 1) {// add
                boolean existFlag = false;
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(roleid);
                if (cpgMsgUsr == null) {
                    existFlag = true;
                    cpgMsgUsr = new CpgMsgUsr();
                }
                cpgMsgUsr.setUserId(roleInfo.getRoleName());// 操作员ID
                cpgMsgUsr.setSendType("02");// 发送方式:2:邮件
                cpgMsgUsr.setRcvInf(roleInfo.getMail());// 邮件地址
                cpgMsgUsr.setCreator(roleInfo.getMdTlr());// 创建者
                cpgMsgUsr.setCreatedDate(roleInfo.getMdTime());// 创建时间
                cpgMsgUsr.setCheckUser(roleInfo.getApvTlr());// 审核人
                cpgMsgUsr.setCheckDate(roleInfo.getApvTime());// 审核时间
                if (existFlag) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().save(cpgMsgUsr);
                } else {
                    ROOTDAOUtils.getCpgMsgUsrDAO().update(cpgMsgUsr);
                }
                // CpgUsrInf -- add
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(roleid);
                if (cpgUsrInf == null) {
                    existFlag = true;
                    cpgUsrInf = new CpgUsrInf();
                }
                cpgUsrInf.setUserId(roleInfo.getRoleName());// 操作员ID
                cpgUsrInf.setUserName(roleInfo.getRoleName());//
                cpgUsrInf.setCreator(roleInfo.getMdTlr());// 创建者
                cpgUsrInf.setCreatedDate(roleInfo.getMdTime());// 创建时间
                cpgUsrInf.setCheckUser(roleInfo.getApvTlr());// 审核人
                cpgUsrInf.setCheckDate(roleInfo.getApvTime());// 审核时间
                cpgUsrInf.setRsv1(roleInfo.getMail());
                cpgUsrInf.setBrno(roleInfo.getBrno());
                cpgUsrInf.setRoleGroup(roleInfo.getRoleGroup());
                if (existFlag) {
                    ROOTDAOUtils.getCpgUsrInfDAO().save(cpgUsrInf);
                } else {
                    ROOTDAOUtils.getCpgUsrInfDAO().update(cpgUsrInf);
                }
            } else if (type == 2) {// update
                boolean existFlag = false;
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(roleInfo.getRoleName());
                if (cpgMsgUsr == null) {
                    existFlag = true;
                    cpgMsgUsr = new CpgMsgUsr();
                }
                cpgMsgUsr.setUserId(roleInfo.getRoleName());// 操作员ID
                cpgMsgUsr.setSendType("02");// 发送方式:2:邮件
                cpgMsgUsr.setRcvInf(roleInfo.getMail());// 邮件地址
                cpgMsgUsr.setModUser(roleInfo.getMdTlr());// 最后修改人
                cpgMsgUsr.setModDate(roleInfo.getMdTime());// 最后修改时间
                cpgMsgUsr.setCheckUser(roleInfo.getApvTlr());// 审核人
                cpgMsgUsr.setCheckDate(roleInfo.getApvTime());// 审核时间
                if (existFlag) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().save(cpgMsgUsr);
                } else {
                    ROOTDAOUtils.getCpgMsgUsrDAO().update(cpgMsgUsr);
                }
                // CpgUsrInf -- update
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(roleInfo.getRoleName());
                if (cpgUsrInf == null) {
                    existFlag = false;
                    cpgUsrInf = new CpgUsrInf();
                }
                cpgUsrInf.setUserId(roleInfo.getRoleName());// 操作员ID
                cpgUsrInf.setUserName(roleInfo.getRoleName());//
                cpgUsrInf.setModUser(roleInfo.getMdTlr());// 最后修改人
                cpgUsrInf.setModDate(roleInfo.getMdTime());// 最后修改时间
                cpgUsrInf.setCheckUser(roleInfo.getApvTlr());// 审核人
                cpgUsrInf.setCheckDate(roleInfo.getApvTime());// 审核时间
                cpgUsrInf.setRsv1(roleInfo.getMail());// 邮箱
                cpgUsrInf.setBrno(roleInfo.getBrno());
                cpgUsrInf.setRoleGroup(roleInfo.getRoleGroup());
                if (existFlag) {
                    ROOTDAOUtils.getCpgUsrInfDAO().update(cpgUsrInf);
                } else {
                    ROOTDAOUtils.getCpgUsrInfDAO().save(cpgUsrInf);
                }
            } else if (type == 3) {// delete
                CpgMsgUsr cpgMsgUsr = ROOTDAOUtils.getCpgMsgUsrDAO().findByUserId(roleInfo.getRoleName());
                if (cpgMsgUsr != null) {
                    ROOTDAOUtils.getCpgMsgUsrDAO().delete(cpgMsgUsr);
                }
                CpgUsrInf cpgUsrInf = ROOTDAOUtils.getCpgUsrInfDAO().findByUserId(roleInfo.getRoleName());
                if (cpgUsrInf != null) {
                    ROOTDAOUtils.getCpgUsrInfDAO().delete(cpgUsrInf);
                }
            }

            syncCpgMsgUsrBranch(roleInfo.getRoleName(), 2);

            return true;
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public void deleteBySql(String sql) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        rootdao.executeSql(sql);
    }

    public void deleteFromEntry(String  tlrno) throws CommonException {
        String sql = "delete from Tlr_Role_Rel where tlrno = '" + tlrno + "'";
        this.deleteBySql(sql);
    }
    public List<CpgMsgUsr> getCpgMsgUsr(String  userId) throws CommonException {
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String sql = "select po from CpgMsgUsr po where userId='"+userId+"'";
        List<CpgMsgUsr> list=rootdao.queryByCondition(sql);
        if(null != list && list.size()>0){
        	return list;
        }
		return null;
    }
    public List<CpgUsrInf> getCpgUsrInf(String  userId) throws CommonException {
    	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String sql = "select po from CpgUsrInf po where userId='"+userId+"'";
        List<CpgUsrInf> list=rootdao.queryByCondition(sql);
        if(null != list && list.size()>0){
        	return list;
        }
		return null;
    }

}

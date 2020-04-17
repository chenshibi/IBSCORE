/*
 * Created on 2005-5-11
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.huateng.ebank.business.opermng.operation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.UserMgrService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.util.HTStringUtils;
import com.huateng.msgplatform.service.SyncMsgPlatformService;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.RepList;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.service.pub.PasswordService;

import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrInfoChange;
import resource.bean.basic.TlrRoleRel;
import resource.bean.basic.TlrRoleRelChange;
import resource.bean.basic.view.TlrRoleRelationView;
import resource.bean.msg.CpgMsgUsr;
import resource.bean.msg.CpgUsrInf;
import resource.dao.basic.TlrInfoDAO;
import resource.dao.basic.TlrRoleRelDAO;

/**
 * @author zhiguo.zhao
 *
 */
public class OperMngOperation extends BaseOperation {

    private static final HtLog htlog = HtLogFactory.getLogger(OperMngOperation.class);

    public static final String ID = "management.OperMngOperation";
    public static final String CMD = "cmd";
    public static final String IN_TLRINFO = "IN_TLRINFO";
    public static final String IN_TLRNO = "IN_TLRNO";
    public static final String IN_PARAM = "IN_PARAM";
    public static final String IN_ROLELIST = "IN_ROLELIST";
    public static final String IN_BCTLLIST = "IN_BCTLLIST";
    public static final String FLAG = "FLAG";


    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.ebank.framework.operation.IOperation#beforeProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.ebank.framework.operation.IOperation#execute(com.huateng.
     * ebank.framework.operation.OperationContext)
     */
    public void execute(OperationContext context) throws CommonException {
        // GlobalInfo就相当于一个session
        GlobalInfo globalInfo = GlobalInfo.getCurrentInstance();
        TlrInfoDAO tlrInfoDAO = DAOUtils.getTlrInfoDAO();
        TlrRoleRelDAO relationDao = DAOUtils.getTlrRoleRelDAO();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        if ("new".equals(context.getAttribute(CMD))) {
        	
        	  TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
              List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);
              if (tlrInfoDAO.query(tlrInfo.getTlrno()) == null) {
                  tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
                  // 设置有效标志
                  tlrInfo.setFlag(SystemConstant.FLAG_ON);
                  String sysDefaultPwd = CommonService.getInstance().getSysParamDef("PSWD", "DEFAULT_PWD",
                          SystemConstant.DEFAULT_PASSWORD);
                  String encMethod = CommonService.getInstance().getSysParamDef("PSWD", "ENC_MODE", "AES128");
                  String password = PasswordService.getInstance().EncryptPassword(sysDefaultPwd, encMethod);
                  tlrInfo.setPassword(password);// 设置默认操作员密码
                  // 为操作员密码错误次数付初始值
                  tlrInfo.setTotpswderrcnt(new Integer(0));
                  tlrInfo.setPswderrcnt(new Integer(0));
                  tlrInfo.setPasswdenc(encMethod);
                  tlrInfo.setLastaccesstm(DateUtil.get14Time());
                  tlrInfo.setLastlogouttm(DateUtil.get14Time());
                  tlrInfo.setCreateDate(DateUtil.get8Date());
                  tlrInfo.setLastUpdTime(DateUtil.get14Time());
                  tlrInfo.setLoginIp(globalInfo.getIp());
                  tlrInfo.setSessionId(globalInfo.getSessionId());
                  tlrInfo.setLastUpdTms(DateUtil.get14Time());
                  tlrInfo.setLastUpdOper(globalInfo.getTlrno());
                  tlrInfo.setLastUpdOperId(GlobalInfo.getCurrentInstance().getTlrno());
                  tlrInfo.setIsLock(SystemConstant.FLAG_OFF);
                  tlrInfo.setIsLockModify("1");
                  tlrInfo.setSt("4");
                  tlrInfo.setMaker(GlobalInfo.getCurrentInstance().getTlrno());
                  tlrInfo.setMakeTime(DateUtil.get14Time());
                  //新增城市、区域字段
                  tlrInfo.setCity(tlrInfo.getCity());
                  tlrInfo.setRegion(tlrInfo.getRegion());
                  tlrInfo.setDepartment(tlrInfo.getDepartment());
                  tlrInfoDAO.saveOrUpdate(tlrInfo);

                  //新增操作员变更表
                  TlrInfoChange tlrInfoChange=new TlrInfoChange();
                  tlrInfoChange.setTlrno(tlrInfo.getTlrno());
                  tlrInfoChange.setTlrName(tlrInfo.getTlrName());
                  tlrInfoChange.setStatus(tlrInfo.getStatus());
                  tlrInfoChange.setFlag(tlrInfo.getFlag());
                  tlrInfoChange.setIsLock(tlrInfo.getIsLock());
                  tlrInfoChange.setLastUpdTms(tlrInfo.getLastUpdTms());
                  tlrInfoChange.setLastUpdOper(tlrInfo.getLastUpdOper());
                  tlrInfoChange.setCity(tlrInfo.getCity());
                  tlrInfoChange.setRegion(tlrInfo.getRegion());
                  tlrInfoChange.setDepartment(tlrInfo.getDepartment());
                  tlrInfoChange.setOperStatus("0");
                  int tlrInfoChangeId=(Integer) rootdao.save(tlrInfoChange);
                  
                
                  // 保存角色岗位
                  RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
                  for (RoleInfo rl : roles) {
                      TlrRoleRel tlrRoleRel = new TlrRoleRel();
                      tlrRoleRel.setRoleId(rl.getId());
                      tlrRoleRel.setTlrno(tlrInfo.getTlrno());
                      tlrRoleRel.setStatus("1");
                      rootdao.save(tlrRoleRel);
                      
                      TlrRoleRelChange tlrRoleRelChange = new TlrRoleRelChange();
                      tlrRoleRelChange.setChangeId(String.valueOf(tlrInfoChangeId));
                      tlrRoleRelChange.setRoleId(rl.getId());
                      tlrRoleRelChange.setTlrNo(tlrInfo.getTlrno());
                      rootdao.save(tlrRoleRelChange);
                  }
                  
                  
                  //保存CpgMsgUsr表
                  CpgMsgUsr cpgMsgUsr=new CpgMsgUsr();
                  cpgMsgUsr.setUserId(tlrInfo.getTlrno());// 操作员ID
                  cpgMsgUsr.setSendType("02");// 发送方式:2:邮件
                  cpgMsgUsr.setRcvInf(tlrInfo.getEmail());// 邮件地址
                  cpgMsgUsr.setCreator(tlrInfo.getMaker());// 创建者
                  cpgMsgUsr.setCreatedDate(tlrInfo.getMakeTime());// 创建时间
                  cpgMsgUsr.setCheckUser(tlrInfo.getChecker());// 审核人
                  cpgMsgUsr.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                  rootdao.save(cpgMsgUsr);
                  
                  //保存CpgUsrInf表
                  CpgUsrInf cpgUsrInf=new CpgUsrInf();
                  cpgUsrInf.setUserId(tlrInfo.getTlrno());// 操作员ID
                  cpgUsrInf.setUserName(tlrInfo.getTlrName());//
                  cpgUsrInf.setCreator(tlrInfo.getMaker());// 创建者
                  cpgUsrInf.setCreatedDate(tlrInfo.getMakeTime());// 创建时间
                  cpgUsrInf.setCheckUser(tlrInfo.getChecker());// 审核人
                  cpgUsrInf.setCheckDate(tlrInfo.getCheckTime());// 审核时间
                  cpgUsrInf.setRsv1(tlrInfo.getEmail());
                  cpgUsrInf.setBrno(tlrInfo.getBrcode());
                  rootdao.save(cpgUsrInf);
              }
                
        } else if ("modify".equals(context.getAttribute(CMD))) {
        	
        	 TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
             List<RoleInfo> roles = (List<RoleInfo>) context.getAttribute(IN_ROLELIST);

             
           
           
             //修改tlrInfo表
             TlrInfo dbTrlInfo = rootdao.query(TlrInfo.class, tlrInfo.getTlrno());
             String oldTlrName = dbTrlInfo.getTlrName();
             String oldLastUpTm = dbTrlInfo.getLastUpdTime();
             String oldEmail = dbTrlInfo.getEmail();
             dbTrlInfo.setSt("4");
             dbTrlInfo.setTlrName(tlrInfo.getTlrName());
             dbTrlInfo.setEmail(tlrInfo.getEmail());
             dbTrlInfo.setLastUpdTime(DateUtil.get14Time());
             dbTrlInfo.setLastUpdTime(oldLastUpTm);
             dbTrlInfo.setTlrName(oldTlrName);
             dbTrlInfo.setEmail(oldEmail);
             dbTrlInfo.setLastUpdTms(DateUtil.get14Time());
             dbTrlInfo.setLastUpdOper(globalInfo.getTlrno());
             dbTrlInfo.setCity(tlrInfo.getCity());
             dbTrlInfo.setRegion(tlrInfo.getRegion());
             dbTrlInfo.setDepartment(tlrInfo.getDepartment());
             rootdao.saveOrUpdate(dbTrlInfo);
             globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                     "修改用户编号[" + dbTrlInfo.getTlrno() + "]" });
             htlog.info("Updater.log", new String[] { globalInfo.getTlrno(),
                     "修改用户编号[" + dbTrlInfo.getTlrno() + "]" });
             
             
             
             //新增操作员变更表
             TlrInfoChange tlrInfoChange=new TlrInfoChange();
             tlrInfoChange.setTlrno(dbTrlInfo.getTlrno());
             tlrInfoChange.setTlrName(dbTrlInfo.getTlrName());
             tlrInfoChange.setStatus(dbTrlInfo.getStatus());
             tlrInfoChange.setFlag(dbTrlInfo.getFlag());
             tlrInfoChange.setIsLock(dbTrlInfo.getIsLock());
             tlrInfoChange.setLastUpdTms(dbTrlInfo.getLastUpdTms());
             tlrInfoChange.setLastUpdOper(dbTrlInfo.getLastUpdOper());
             tlrInfoChange.setCity(dbTrlInfo.getCity());
             tlrInfoChange.setRegion(dbTrlInfo.getRegion());
             tlrInfoChange.setDepartment(dbTrlInfo.getDepartment());
             tlrInfoChange.setOperStatus("1");
             int ChangeId=(Integer) rootdao.save(tlrInfoChange);
             
             
             
             //修改TlrRoleRel表中对应的记录  先将原记录删除  再将新选角色信息插入
             SyncMsgPlatformService service=new SyncMsgPlatformService();
             service.deleteFromEntry(tlrInfo.getTlrno());
             RepList<TlrRoleRel> roleRellist = new RepList<TlrRoleRel>();
             for (RoleInfo rl : roles) {
                 TlrRoleRel tlrRoleRel = new TlrRoleRel();
                 tlrRoleRel.setRoleId(rl.getId());
                 tlrRoleRel.setTlrno(tlrInfo.getTlrno());
                 tlrRoleRel.setStatus("1");
                 
                 rootdao.save(tlrRoleRel);
                 roleRellist.add(tlrRoleRel);
                 
                 TlrRoleRelChange tlrRoleRelChange = new TlrRoleRelChange();
                 tlrRoleRelChange.setChangeId(String.valueOf(ChangeId));
                 tlrRoleRelChange.setRoleId(rl.getId());
                 tlrRoleRelChange.setTlrNo(tlrInfo.getTlrno());
                 rootdao.save(tlrRoleRelChange);
             }
             //cpg_msg_usr 如果该表中有该条记录 就更改修改修改时间
             List<CpgMsgUsr> listCpgMsgUsr=service.getCpgMsgUsr(tlrInfo.getTlrno());
             if(null != listCpgMsgUsr && listCpgMsgUsr.size()>0){
             	   for (CpgMsgUsr cpgMsgusr : listCpgMsgUsr) {
             		   cpgMsgusr.setModDate(DateUtil.get14Time());
             		   cpgMsgusr.setModUser(tlrInfo.getTlrno());
             		   rootdao.saveOrUpdate(cpgMsgusr);
        			   }	
             }
          
             //Cpg_Usr_Inf 如果该表中有该条记录 就更改修改修改时间
             List<CpgUsrInf> listCpgUsrInf=service.getCpgUsrInf(tlrInfo.getTlrno());
             if(null != listCpgUsrInf && listCpgUsrInf.size()>0){
             	   for (CpgUsrInf CpgUsrInf : listCpgUsrInf) {
             		   CpgUsrInf.setModDate(DateUtil.get14Time());
             		   CpgUsrInf.setModUser(tlrInfo.getTlrno());
             		    rootdao.saveOrUpdate(CpgUsrInf);
        			   }	
             }
          
             
        } else if ("del".equals(context.getAttribute(CMD))) {
            String tlrno = (String) context.getAttribute(IN_TLRNO);
            tlrInfoDAO.delete(tlrno);
            List urrlist = relationDao.queryByCondition(" po.tlrno = '" + tlrno + "'");
            for (Iterator it = urrlist.iterator(); it.hasNext();) {
                TlrRoleRel ref = (TlrRoleRel) it.next();
                relationDao.delete(ref);
            }

        } else if ("mod".equals(context.getAttribute(CMD))) {
            TlrInfo tlrInfo = (TlrInfo) context.getAttribute(IN_TLRINFO);
            TlrInfo ti = tlrInfoDAO.query(tlrInfo.getTlrno());
            if (ti != null) {
                ti.setTlrName(tlrInfo.getTlrName());
                ti.setEffectDate(tlrInfo.getEffectDate());
                ti.setExpireDate(tlrInfo.getExpireDate());
                ti.setEmail(tlrInfo.getEmail());
               // ti.setContactWay(tlrInfo.getContactWay());
                tlrInfoDAO.saveOrUpdate(ti);
            }
        } else if ("auth".equals(context.getAttribute(CMD))) {
            List roleList = (List) context.getAttribute(IN_ROLELIST);
            TlrRoleRel rr = null;
            for (int i = 0; i < roleList.size(); i++) {
                TlrRoleRelationView inurr = (TlrRoleRelationView) roleList.get(i);
                List urrlist = relationDao.queryByCondition(
                        " po.tlrno = '" + inurr.getTlrno() + "'  and po.roleId = '" + inurr.getRoleId() + "'");
                // 选中的岗位
                if (inurr.isSelected()) {
                    // 原先无数据,则插入新数据
                    if (urrlist == null || urrlist.size() == 0) {
                        rr = new TlrRoleRel();
                        rr.setRoleId((inurr.getRoleId()));
                        rr.setTlrno(inurr.getTlrno());
                        rr.setStatus("1");// 1有效 0无效
                        relationDao.getHibernateTemplate().saveOrUpdate(rr);
                    }
                    // 原先有数据，则更新status
                    else {
                        for (int j = 0; j < urrlist.size(); j++) {
                            rr = (TlrRoleRel) urrlist.get(j);
                            if (!"1".equals(rr.getStatus())) {
                                rr.setStatus("1");
                                relationDao.getHibernateTemplate().saveOrUpdate(rr);
                            }
                        }
                    }
                }
                // 没有选中的岗位
                else {
                    for (int k = 0; k < urrlist.size(); k++) {
                        rr = (TlrRoleRel) urrlist.get(k);
                        relationDao.delete(rr);
                    }
                }

            }
        } else if ("resetPwd".equals(context.getAttribute(CMD))) {
            String tlrno = (String) context.getAttribute(IN_TLRNO);
            // 修改用户密码
             UserMgrService userMgrService = new UserMgrService();
             userMgrService.updatePassword(tlrno,
             SystemConstant.DEFAULT_PASSWORD);
            TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
            List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
            // 角色岗位
            RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
            for (TlrRoleRel tlrRoleRel : roleRellist) {
                repRoleList.add(tlrRoleRel);
            }

            // 设置修改中
            tlrInfo.setSt("4");
            tlrInfo.setIsLock("0");
            tlrInfo.setLastPwdUpdTime(null);
            // 设置充值密码标识
            tlrInfo.setRestFlg("reset");
            rootdao.saveOrUpdate(tlrInfo);
            globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "重置用户编号[" + tlrInfo.getTlrno() + "]的密码" });
            htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "重置用户编号[" + tlrInfo.getTlrno() + "]的密码" });
        } else if ("unlock".equals(context.getAttribute(CMD))) {// 解锁
            String tlrno = (String) context.getAttribute(IN_TLRNO);
            TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
            String oldFlag = tlrInfo.getFlag();//0
            List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
            // 角色岗位
            RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
            for (TlrRoleRel tlrRoleRel : roleRellist) {
                repRoleList.add(tlrRoleRel);
            }

            // 设置修改中
            tlrInfo.setSt(ReportEnum.REPORT_ST1.ET.value);
            String oldIsLock = tlrInfo.getIsLock();
            tlrInfo.setIsLock("0");
            try {
                TlrInfoAuditBean tlrInfoAuditBean = new TlrInfoAuditBean();
                tlrInfoAuditBean.setTlrInfo(tlrInfo);
                tlrInfoAuditBean.setRoleRellist(repRoleList);
                SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100399.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, tlrInfoAuditBean,
                        tlrInfoAuditBean.getTlrInfo().getTlrno(), tlrInfo.getSt());
                rootdao.saveOrUpdate(tskInf);
            } catch (IOException e) {
                ExceptionUtil.throwCommonException("操作员解锁，双岗复核序列化到数据库出错！");
                e.printStackTrace();
            }
            // 改回原值
            tlrInfo.setIsLock(oldIsLock);
            rootdao.saveOrUpdate(tlrInfo);
           
           
            globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "用户编号[" + tlrInfo.getTlrno() + "]解锁操作" });
            htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "用户编号[" + tlrInfo.getTlrno() + "]解锁操作" });
        } else if("flag".equals(context.getAttribute(CMD))){
        	 String tlrno = (String) context.getAttribute(IN_TLRNO);
        	 String flag = (String) context.getAttribute(FLAG);
        	 TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
        	 if("0".equals(flag)){
             	 tlrInfo.setFlag("0");
             	 tlrInfo.setLastUpdTms(DateUtil.get14Time());
             	 rootdao.saveOrUpdate(tlrInfo);
             	 //新增操作员变更表
                  TlrInfoChange tlrInfoChange=new TlrInfoChange();
                  tlrInfoChange.setTlrno(tlrInfo.getTlrno());
                  tlrInfoChange.setTlrName(tlrInfo.getTlrName());
                  tlrInfoChange.setStatus(tlrInfo.getStatus());
                  tlrInfoChange.setFlag(tlrInfo.getFlag());
                  tlrInfoChange.setIsLock(tlrInfo.getIsLock());
                  tlrInfoChange.setLastUpdTms(tlrInfo.getLastUpdTms());
                  tlrInfoChange.setLastUpdOper(tlrInfo.getLastUpdOper());
                  tlrInfoChange.setCity(tlrInfo.getCity());
                  tlrInfoChange.setRegion(tlrInfo.getRegion());
                  tlrInfoChange.setDepartment(tlrInfo.getDepartment());
                  tlrInfoChange.setOperStatus("1");
                   rootdao.save(tlrInfoChange);
             	
             }else if("1".equals(flag)){
             	tlrInfo.setFlag("1");
             	tlrInfo.setLastUpdTms(DateUtil.get14Time());
             	rootdao.saveOrUpdate(tlrInfo);
             	 //新增操作员变更表
                 TlrInfoChange tlrInfoChange=new TlrInfoChange();
                 tlrInfoChange.setTlrno(tlrInfo.getTlrno());
                 tlrInfoChange.setTlrName(tlrInfo.getTlrName());
                 tlrInfoChange.setStatus(tlrInfo.getStatus());
                 tlrInfoChange.setFlag(tlrInfo.getFlag());
                 tlrInfoChange.setIsLock(tlrInfo.getIsLock());
                 tlrInfoChange.setLastUpdTms(tlrInfo.getLastUpdTms());
                 tlrInfoChange.setLastUpdOper(tlrInfo.getLastUpdOper());
                 tlrInfoChange.setCity(tlrInfo.getCity());
                 tlrInfoChange.setRegion(tlrInfo.getRegion());
                 tlrInfoChange.setDepartment(tlrInfo.getDepartment());
                 tlrInfoChange.setOperStatus("1");
                  rootdao.save(tlrInfoChange);
             }
        	
        }else if ("status".equals(context.getAttribute(CMD))) {// 有效/无效 强行签退
            String tlrno = (String) context.getAttribute(IN_TLRNO);
            String status = (String) context.getAttribute(IN_PARAM);

            TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
            //1正常/停用的区分
            if("2".equals(status)){
              	tlrInfo.setStatus("2");
              	tlrInfo.setLastUpdTms(DateUtil.get14Time());
              	tlrInfo.setLastUpdOper(globalInfo.getTlrno());
                rootdao.saveOrUpdate(tlrInfo);
                //新增操作员变更表
                TlrInfoChange tlrInfoChange=new TlrInfoChange();
                tlrInfoChange.setTlrno(tlrInfo.getTlrno());
                tlrInfoChange.setTlrName(tlrInfo.getTlrName());
                tlrInfoChange.setStatus(tlrInfo.getStatus());
                tlrInfoChange.setFlag(tlrInfo.getFlag());
                tlrInfoChange.setIsLock(tlrInfo.getIsLock());
                tlrInfoChange.setLastUpdTms(tlrInfo.getLastUpdTms());
                tlrInfoChange.setLastUpdOper(tlrInfo.getLastUpdOper());
                tlrInfoChange.setCity(tlrInfo.getCity());
                tlrInfoChange.setRegion(tlrInfo.getRegion());
                tlrInfoChange.setDepartment(tlrInfo.getDepartment());
                tlrInfoChange.setOperStatus("2");
                int chanId=(Integer) rootdao.save(tlrInfoChange);
                List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
                // 角色岗位
                RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
                for (TlrRoleRel tlrRoleRel : roleRellist) {
                	  TlrRoleRelChange tlrRoleRelChange = new TlrRoleRelChange();
                      tlrRoleRelChange.setChangeId(String.valueOf(chanId));
                      tlrRoleRelChange.setRoleId(tlrRoleRel.getRoleId());
                      tlrRoleRelChange.setTlrNo(tlrInfo.getTlrno());
                      rootdao.save(tlrRoleRelChange);
                }
            }else if("0".equals(status)){
               	tlrInfo.setStatus("0");
               	//CHECKER   LAST_UPD_OPER_ID   LAST_UPD_OPER
             	tlrInfo.setLastUpdTms(DateUtil.get14Time());
             	tlrInfo.setLastUpdOper(globalInfo.getTlrno());
             	rootdao.saveOrUpdate(tlrInfo);
                 //新增操作员变更表
                 TlrInfoChange tlrInfoChange=new TlrInfoChange();
                 tlrInfoChange.setTlrno(tlrInfo.getTlrno());
                 tlrInfoChange.setTlrName(tlrInfo.getTlrName());
                 tlrInfoChange.setStatus(tlrInfo.getStatus());
                 tlrInfoChange.setFlag(tlrInfo.getFlag());
                 tlrInfoChange.setIsLock(tlrInfo.getIsLock());
                 tlrInfoChange.setLastUpdTms(tlrInfo.getLastUpdTms());
                 tlrInfoChange.setLastUpdOper(tlrInfo.getLastUpdOper());
                 tlrInfoChange.setCity(tlrInfo.getCity());
                 tlrInfoChange.setRegion(tlrInfo.getRegion());
                 tlrInfoChange.setDepartment(tlrInfo.getDepartment());
                 tlrInfoChange.setOperStatus("0");
                 int cgeId=(Integer) rootdao.save(tlrInfoChange);
                 List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
                 // 角色岗位
                 RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
                 for (TlrRoleRel tlrRoleRel : roleRellist) {
                 	  TlrRoleRelChange tlrRoleRelChange = new TlrRoleRelChange();
                       tlrRoleRelChange.setChangeId(String.valueOf(cgeId));
                       tlrRoleRelChange.setRoleId(tlrRoleRel.getRoleId());
                       tlrRoleRelChange.setTlrNo(tlrInfo.getTlrno());
                       rootdao.save(tlrRoleRelChange);
                 }
            }
            if (SystemConstant.FLAG_ON.equals(status) || SystemConstant.FLAG_OFF.equals(status)) {
                List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = ? ",
                        new String[] { tlrno }, null);
                // 角色岗位
                RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
                for (TlrRoleRel tlrRoleRel : roleRellist) {
                    repRoleList.add(tlrRoleRel);
                }
                // 设置修改中
                tlrInfo.setSt("4");
                String oldFlag = tlrInfo.getFlag();//0
                String oldStatus = tlrInfo.getStatus();//0
                
                // 改回原值
//                tlrInfo.setFlag(oldFlag);
              
              	
                
            } else if ("logout".equals(status)) {
                tlrInfo.setStatus(SystemConstant.TLR_NO_STATE_LOGOUT);
                rootdao.saveOrUpdate(tlrInfo);
            }
            if ("logout".equals(status)) {
                globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                        "用户编号[" + tlrInfo.getTlrno() + "]强行签退操作" });
                htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), 
                        "用户编号[" + tlrInfo.getTlrno() + "]强行签退操作" });
            } else {
                globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                        "用户编号[" + tlrInfo.getTlrno() + "]有效无效操作" });
                htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), 
                        "用户编号[" + tlrInfo.getTlrno() + "有效无效操作" });
            }
            
            
        } else if ("recover".equals(context.getAttribute(CMD))) {// 解锁
            String tlrno = (String) context.getAttribute(IN_TLRNO);
            TlrInfo tlrInfo = tlrInfoDAO.query(tlrno);
            List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = '" + tlrno + "'");
            // 角色岗位
            RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
            for (TlrRoleRel tlrRoleRel : roleRellist) {
                repRoleList.add(tlrRoleRel);
            }
            // 设置修改中
            tlrInfo.setSt("4");
            tlrInfo.setLastaccesstm(DateUtil.get14Time());
            rootdao.saveOrUpdate(tlrInfo);

            globalInfo.addBizLog("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "用户编号[" + tlrInfo.getTlrno() + "]过期操作员恢复操作" });
            htlog.info("Updater.log", new String[] { globalInfo.getTlrno(), 
                    "用户编号[" + tlrInfo.getTlrno() + "]过期操作员恢复操作" });
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    /*
     * (non-Javadoc)
     *
     * @see
     * com.huateng.ebank.framework.operation.IOperation#afterProc(com.huateng
     * .ebank.framework.operation.OperationContext)
     */
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }
}
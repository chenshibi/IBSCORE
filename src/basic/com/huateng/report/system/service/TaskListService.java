package com.huateng.report.system.service;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.beanutils.PropertyUtils;

import com.huateng.common.DateUtil;
import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.ebank.framework.util.HTStringUtils;
import com.huateng.msgplatform.service.SyncMsgPlatformService;
import com.huateng.report.system.bean.TaskListBean;
import com.huateng.report.system.bean.TlrInfoAuditBean;
import com.huateng.report.utils.RepList;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_FUNCID;
import com.huateng.report.utils.ReportEnum.REPORT_TASK_TRANS_CD;
import com.huateng.report.utils.ReportEnum.REPORT__FH_ST;
import com.huateng.report.utils.ReportObjectSerializerUtil;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.Bctl;
import resource.bean.basic.PfSysParam;
import resource.bean.basic.PfSysParamPK;
import resource.bean.basic.RoleFuncRel;
import resource.bean.basic.RoleInfo;
import resource.bean.basic.SysNotice;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.basic.SysTaskInfo;
import resource.bean.basic.SysTaskLog;
import resource.bean.basic.TlrInfo;
import resource.bean.basic.TlrRoleRel;
import resource.bean.msg.CpgMsgGroup;
import resource.bean.msg.CpgMsgGroupTmp;
import resource.bean.msg.CpgMsgSndCtl;
import resource.bean.msg.CpgMsgSndCtlTmp;
import resource.bean.msg.CpgUsrInf;
import resource.bean.msg.CpgUsrInfTmp;
import resource.dao.basic.RoleFuncRelDAO;

public class TaskListService {
    /**
     * @author jianxue.zhang 审批的service;
     */
    private static final HtLog htlog = HtLogFactory.getLogger(TaskListService.class);

    private static final String APPROVE_NEW = "APPROVE_NEW";
    private static final String APPROVE_MOD = "APPROVE_MOD";
    private static final String APPROVE_DEL = "APPROVE_DEL";

    public synchronized static TaskListService getInstance() {
        return (TaskListService) ApplicationContextUtils.getBean("TaskListService");
    }

    /**
     * 依据待办任务主键遍历加载待审批记录详细,查询专用--zjx
     */
    public List getApproveListByTaskIds(String taskIds, String type) throws CommonException {
        List<TaskListBean> list = new ArrayList<TaskListBean>();
        UndoConfirmService ucs = UndoConfirmService.getInstance();
        ReportTaskUtil rt = new ReportTaskUtil();
        if (!DataFormat.isEmpty(taskIds)) {
            System.out.println(taskIds);
            String[] ids = taskIds.split("@");

            for (int i = 0; i < ids.length; i++) {
                String tid = ids[i].trim();
                if (!DataFormat.isEmpty(tid)) {
                    // --这里实现根据id将taskinfo读出来,并将相应的值赋给taskListbean
                    SysTaskInfo systask = ucs.load(tid);
                    TaskListBean taskbean = new TaskListBean();
                    taskbean.setId(systask.getId());
                    taskbean.setSysTaskInfo(systask);
                    try {
                        Object ob;
                        // 从序列化中取出相应对象
                        ob = ReportTaskUtil.getObjctBySysTaskInfo(systask);
                        if (type.equals(REPORT_TASK_FUNCID.TASK_100199.value)) {
                            taskbean.setBctl((Bctl) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_100899.value)) {
                            taskbean.setPfSysparam((PfSysParam) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                            taskbean.setRoleInfo((RoleInfo) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                            taskbean.setTlrInfo((TlrInfoAuditBean) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_100799.value)) {
                            taskbean.setSysParams((SysParams) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                            taskbean.setSysNotice((SysNotice) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_120299.value)) {
                            taskbean.setSysParams((SysParams) ob);
                        } else if (type.equals(REPORT_TASK_FUNCID.TASK_120399.value)) {
                            taskbean.setSysParams((SysParams) ob);
                        }
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        ExceptionUtil.throwCommonException(e.getMessage());
                    }

                    list.add(taskbean);
                }
            }
        }
        return list;
    }

    // 复核后将taskInfo写入tasklog表
    // TODO
    private boolean LogTask(SysTaskInfo st, String pl, String result, String remark)
            throws CommonException {
        try {
            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            SysTaskLog stlog = new SysTaskLog();
            stlog.setApproveOperId(pl);
            stlog.setApproveRemark(remark);
            stlog.setApproveResult(result);
            stlog.setApproveTm(DateUtil.get14Date());
            stlog.setAdtRcdPk(st.getAdtRcdPk());
            stlog.setCrtDt(st.getCrtDt());
            stlog.setId(st.getId());
            stlog.setInsCd(st.getInsCd());
            stlog.setIntInsId(st.getIntInsId());
            stlog.setIntOperId(st.getIntOperId());
            stlog.setLastUpdOper(st.getLastUpdOper());
            stlog.setLastUpdTms(st.getLastUpdTms());
            stlog.setUpdTransCd(st.getUpdTransCd());
            String flag = st.getUpdTransCd();
            String insflag = st.getIntInsId();
            String key = st.getAdtRcdPk();
            if (flag.equals(REPORT_TASK_TRANS_CD.EDIT.value)) {
                stlog.setNewVal1(st.getNewVal1());
                stlog.setNewVal2(st.getNewVal2());
                if (insflag.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                    // 角色
                    List<String> rolelist = rootdao
                            .queryByQL2List("select funcid from RoleFuncRel where roleId = '" + key + "'");
                    StringBuffer roleListString = new StringBuffer("");
                    for (String func : rolelist) {
                        roleListString.append(func.trim()).append(",");
                    }
                    if (roleListString.length() > 0) {
                        roleListString = roleListString.deleteCharAt(roleListString.length() - 1);
                    }
                    RoleInfo roleInfo = (RoleInfo) getObjectByOldKey(key, insflag);
                    roleInfo.setRoleList(roleListString.toString());
                    String[] jsons;
                    jsons = ReportTaskUtil.getStrToArray(ReportObjectSerializerUtil.serialize(roleInfo));
                    stlog.setOldVal1(jsons[0]);
                    stlog.setOldVal2(jsons[1]);
                } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                    // 用户
                    TlrInfo tlrInfo = (TlrInfo) getObjectByOldKey(key, insflag);
//                    List<TlrBctlRel> bctlRellist = rootdao
//                            .queryByQL2List("from TlrBctlRel where tlrNo = '" + key + "'");
                    List<TlrRoleRel> roleRellist = rootdao
                            .queryByQL2List("from TlrRoleRel where tlrno = '" + key + "'");
//                    RepList<TlrBctlRel> repBctlList = new RepList<TlrBctlRel>();
//                    for (TlrBctlRel tlrBctlRel : bctlRellist) {
//                        repBctlList.add(tlrBctlRel);
//                    }
                    // 角色岗位
                    RepList<TlrRoleRel> repRoleList = new RepList<TlrRoleRel>();
                    for (TlrRoleRel tlrRoleRel : roleRellist) {
                        repRoleList.add(tlrRoleRel);
                    }
                    TlrInfoAuditBean tlrInfoAu = new TlrInfoAuditBean();
//                    tlrInfoAu.setBctlRellist(repBctlList);
                    tlrInfoAu.setRoleRellist(repRoleList);
                    tlrInfoAu.setTlrInfo(tlrInfo);
                    String[] jsons;
                    jsons = ReportTaskUtil.getStrToArray(ReportObjectSerializerUtil.serialize(tlrInfoAu));
                    stlog.setOldVal1(jsons[0]);
                    stlog.setOldVal2(jsons[1]);

                } else {
                    Object ob = new Object();
                    ob = getObjectByOldKey(key, insflag);
                    String[] jsons;
                    jsons = ReportTaskUtil.getStrToArray(ReportObjectSerializerUtil.serialize(ob));
                    stlog.setOldVal1(jsons[0]);
                    stlog.setOldVal2(jsons[1]);
                }
            }
            if (st.getUpdTransCd().equals(REPORT_TASK_TRANS_CD.NEW.value)) {
                // 只有新值
                stlog.setNewVal1(st.getNewVal1());
                stlog.setNewVal2(st.getNewVal2());
            }
            if (st.getUpdTransCd().equals(REPORT_TASK_TRANS_CD.DEL.value)) {
                // 只有旧值,将new的赋给old,
                stlog.setOldVal1(st.getNewVal1());
                stlog.setOldVal2(st.getNewVal2());
            }
            rootdao.saveOrUpdate(stlog);
            return true;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage());
            return false;
        }

    }

    // 根据原纪录主键获取Object
    private Object getObjectByOldKey(String key, String insflag) throws CommonException {
        Object ob = new Object();
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        try {
            if (insflag.equals(REPORT_TASK_FUNCID.TASK_100199.value)) {
                ob = rootdao.query(Bctl.class, key);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                ob = rootdao.query(RoleInfo.class, (key));
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                ob = rootdao.query(TlrInfo.class, key);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_100799.value)) {
                String[] sss = key.split("#");
                SysParamsPK spk = new SysParamsPK(sss[0], sss[1]);
                ob = rootdao.query(SysParams.class, spk);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_120399.value)) {
                String[] sss = key.split("#");
                SysParamsPK spk = new SysParamsPK(sss[0], sss[1]);
                ob = rootdao.query(SysParams.class, spk);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_120299.value)) {
                String[] sss = key.split("#");
                SysParamsPK spk = new SysParamsPK(sss[0], sss[1]);
                ob = rootdao.query(SysParams.class, spk);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_100899.value)) {
                String[] sss = key.split("#");
                PfSysParamPK spk = new PfSysParamPK(sss[0], sss[1]);
                ob = rootdao.query(PfSysParam.class, spk);
            } else if (insflag.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                ob = rootdao.query(SysNotice.class, key);
            }
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage());
        }
        return ob;
    }

    // 审批通用方法函数,不处理:角色,日期,用户
    private void getObjectAndApprove(SysTaskInfo taskbean, String st, String isLock, String isDel, boolean oldflag,
            boolean newDel, String approvePeople,  String approveResult, String approveRemark,
            String intInsId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        ReportTaskUtil rt = new ReportTaskUtil();
        String oldkey = taskbean.getAdtRcdPk();
        Object obj = null;
        try {
            // 写入历史表
            Boolean bl = LogTask(taskbean, approvePeople,  approveResult, approveRemark);
            if (oldflag) {
                // 根据原纪录主键获取object
                obj = getObjectByOldKey(oldkey, intInsId);
            } else {// 通过反序列化获取object
                obj = ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100799.value)) {
                    SysParams sys = (SysParams) obj;
                    sys.setSys_name("SYS");
                    obj = (Object) sys;
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120299.value)) {
                    SysParams sys = (SysParams) obj;
                    sys.setSys_name("CCIS");
                    obj = (Object) sys;
                } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120399.value)) {
                    SysParams sys = (SysParams) obj;
                    sys.setSys_name("TCP");
                    obj = (Object) sys;
                }
            }
            if (st != null) {
                PropertyUtils.setNestedProperty(obj, "st", st);
            }
            if (isLock != null) {
                PropertyUtils.setNestedProperty(obj, "lock", isLock);
            }
            if (isDel != null) {
                PropertyUtils.setNestedProperty(obj, "del", isDel);
            }

            if (newDel == true) {
                // 新增并且拒绝
                rootdao.delete(obj);
            } else {
                rootdao.saveOrUpdate(obj);
            }

            // 删除旧表
            if (bl) {
                rootdao.delete(taskbean);
            }

        } catch (Exception xe) {
            ExceptionUtil.throwCommonException(xe.getMessage());
        }
    }

    /**
     * @param rid
     * @param funcs
     * @return
     * @desc 更新角色的权限, 用, 隔开的
     * @author fubo
     */
    public int updateRoleFunc(String rid, String funcs) {

        Hashtable<String, RoleFuncRel> oldfuncs = new Hashtable<String, RoleFuncRel>();
        Hashtable<String, String> newfuncs = new Hashtable<String, String>();

        RoleFuncRelDAO rfrd = DAOUtils.getRoleFuncRelDAO();
        List rfuncs = rfrd.findByRoleid(rid);

        Iterator it = rfuncs.iterator();
        while (it.hasNext()) {
            RoleFuncRel rfr = (RoleFuncRel) it.next();
            oldfuncs.put(rfr.getFuncid().toString(), rfr);
        }

        StringTokenizer st = new StringTokenizer(funcs, ",");
        while (st.hasMoreTokens()) {
            String fid = st.nextToken();
            if (newfuncs.containsKey(fid) == false)
                newfuncs.put(fid, fid);
        }

        Iterator itnew = newfuncs.keySet().iterator();
        while (itnew.hasNext()) {
            String newfid = (String) itnew.next();
            if (oldfuncs.containsKey(newfid)) {
                oldfuncs.remove(newfid);
            } else {
                RoleFuncRel newrfr = new RoleFuncRel();
                newrfr.setFuncid(newfid);
                newrfr.setRoleId(rid);
                rfrd.save(newrfr);
            }
        }
        Enumeration en = oldfuncs.keys();
        while (en.hasMoreElements()) {
            Object key_num = en.nextElement();
            RoleFuncRel oldrfr = (RoleFuncRel) oldfuncs.get(key_num);
            rfrd.delete(oldrfr);
        }

        return 0;
    }

    // 删除角色-菜单关联用,隔开的
    public void deleRoleFunc(String rid) {
        RoleFuncRelDAO rfrd = DAOUtils.getRoleFuncRelDAO();
        List dfuncs = rfrd.findByRoleid(rid);
        Iterator it = dfuncs.iterator();
        while (it.hasNext()) {
            rfrd.delete((RoleFuncRel) it.next());
        }
    }

    // 对角色\日期\用户进行特殊处理
    // TODO
    private void getObjectAndApproveExtra(SysTaskInfo taskbean, String st, boolean extraFlag, String approvePeople,
             String approveResult, String approveRemark, String intInsId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        ReportTaskUtil rt = new ReportTaskUtil();
        String oldkey = taskbean.getAdtRcdPk();
        try {
            // 写入历史表
            Boolean bl = LogTask(taskbean, approvePeople,  approveResult, approveRemark);
            GlobalInfo gi = GlobalInfo.getCurrentInstance();
            // 如果是通过
            if (approveResult.equals("01")) {

                // 如果是新增操作:根据原纪录主键获取object
                // 如果是日期:
                // 如果是角色-通过
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                    if (extraFlag) {
                        // 新增:
                        RoleInfo obj = (RoleInfo) getObjectByOldKey(oldkey, intInsId);
                        obj.setIsLock("0");
                        obj.setSt(REPORT__FH_ST.YES.value);
                        obj.setApvTlr(gi.getTlrno());
                        obj.setApvTime(DateUtil.get14Date());
                        rootdao.saveOrUpdate(obj);
                        SyncMsgPlatformService syncmsgplatform = SyncMsgPlatformService.getInstance();
                        syncmsgplatform.syncToMsgRole(obj.getId(), 1);
                    } else {
                        // 修改:
                        RoleInfo roleInfo = null;
                        roleInfo = (RoleInfo) ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                        roleInfo.setIsLock("0");
                        roleInfo.setSt(REPORT__FH_ST.YES.value);
                        roleInfo.setApvTlr(gi.getTlrno());
                        roleInfo.setApvTime(DateUtil.get14Date());
                        rootdao.saveOrUpdate(roleInfo);
                        SyncMsgPlatformService syncmsgplatform = SyncMsgPlatformService.getInstance();
                        syncmsgplatform.syncToMsgRole(roleInfo.getId(), 2);
                        String roleListNew = roleInfo.getRoleList();
                        // 获取菜单列表
                        if (DataFormat.isEmpty(roleListNew)) {
                            roleListNew = "";
                        }
                        updateRoleFunc(roleInfo.getId(), roleListNew);
                    }
                }

                // 用户(包括重置密码和其它所有修改)
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                    // 新增
                    if (extraFlag) {
                        // 操作员全新新增
                        if (HTStringUtils.compareIgnoreCase("BR", taskbean.getOldSt()) == false) {
                            TlrInfo obj = (TlrInfo) getObjectByOldKey(oldkey, intInsId);
                            obj.setSt(REPORT__FH_ST.YES.value);
                            obj.setChecker(gi.getTlrno());
                            obj.setCheckTime(DateUtil.get14Date());
                            rootdao.saveOrUpdate(obj);
                            TlrInfoAuditBean tlrInfoAuditBean = (TlrInfoAuditBean) ReportTaskUtil
                                    .getObjctBySysTaskInfo(taskbean);
//                            List<TlrBctlRel> bctls = tlrInfoAuditBean.getBctlRellist();
//                            if (bctls != null) {
//                                for (TlrBctlRel rel : bctls) {
//                                    rootdao.save(rel);
//                                }
//                            }
                            List<TlrRoleRel> roleList = tlrInfoAuditBean.getRoleRellist();
                            if (roleList != null) {
                                for (TlrRoleRel rel : roleList) {
                                    rootdao.save(rel);
                                }
                            }
                            SyncMsgPlatformService syncMsg = SyncMsgPlatformService.getInstance();
                            syncMsg.syncToMsgUser(obj.getTlrno(), 1);
                        }
                        // 操作员新增到其他分行
                        else {
                            TlrInfo obj = (TlrInfo) getObjectByOldKey(oldkey, intInsId);
                            TlrInfoAuditBean tlrInfoAuditBean = (TlrInfoAuditBean) ReportTaskUtil
                                    .getObjctBySysTaskInfo(taskbean);
//                            List<TlrBctlRel> bctls = tlrInfoAuditBean.getBctlRellist();
                            // 给用户分配角色表：
                            List<TlrRoleRel> roleList = tlrInfoAuditBean.getRoleRellist();
                            for (TlrRoleRel trlrolerel : roleList) {
                                rootdao.save(trlrolerel);
                            }
//                            rootdao.save(bctls.get(0));
                            SyncMsgPlatformService syncMsg = SyncMsgPlatformService.getInstance();
                            syncMsg.syncCpgMsgUsrBranch(obj.getTlrno(), 1);
                        }
                    }
                    // 修改
                    else {
                        TlrInfoAuditBean tlrInfoAuditBean = null;
                        tlrInfoAuditBean = (TlrInfoAuditBean) ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                        // 获取bean
                        TlrInfo tlrInfo = tlrInfoAuditBean.getTlrInfo();

                        /**
                         * add by zhangdianchao 20160324 将【有效/无效】功能 改为【删除】 start
                         */
                        if ("03".equals(taskbean.getUpdTransCd())) {// 03-删除
                            tlrInfo.setSt(REPORT__FH_ST.YES.value);
                            tlrInfo.setChecker(gi.getTlrno());
                            tlrInfo.setCheckTime(DateUtil.get14Date());
                            String key = tlrInfo.getTlrno();
                            rootdao.delete(tlrInfo);
                            // 先删除用户的角色表和机构关联
//                            List<TlrBctlRel> bctlRellist = rootdao
//                                    .queryByQL2List("from TlrBctlRel where tlrNo = '" + key + "'");
//                            for (TlrBctlRel trlbctreldel : bctlRellist) {
//                                rootdao.delete(trlbctreldel);
//                            }
                            List<TlrRoleRel> roleRellist = rootdao
                                    .queryByQL2List("from TlrRoleRel where tlrno = '" + key + "'");
                            for (TlrRoleRel trlrolereldel : roleRellist) {
                                rootdao.delete(trlrolereldel);
                            }

                            // 删除用户时同时删除 [消息平台的对应接收用户、组、发送配置表]
                            // 接收用户表及其临时表
                            List<CpgUsrInf> cpgUsrInf = rootdao
                                    .queryByQL2List("from CpgUsrInf where userId = '" + key + "'");
                            for (CpgUsrInf bean : cpgUsrInf) {
                                rootdao.delete(bean);
                            }
                            List<CpgUsrInfTmp> cpgUsrInfTmp = rootdao
                                    .queryByQL2List("from CpgUsrInfTmp where userId = '" + key + "'");
                            for (CpgUsrInfTmp bean : cpgUsrInfTmp) {
                                rootdao.delete(bean);
                            }
                            // 接收用户组表及其临时表
                            List<CpgMsgGroup> cpgMsgGroup = rootdao
                                    .queryByQL2List("from CpgMsgGroup where userId = '" + key + "'");
                            for (CpgMsgGroup bean : cpgMsgGroup) {
                                rootdao.delete(bean);
                            }
                            List<CpgMsgGroupTmp> cpgMsgGroupTmp = rootdao
                                    .queryByQL2List("from CpgMsgGroupTmp where userId = '" + key + "'");
                            for (CpgMsgGroupTmp bean : cpgMsgGroupTmp) {
                                rootdao.delete(bean);
                            }
                            // 消息发送配置表及其临时表
                            List<CpgMsgSndCtl> cpgMsgSndCtl = rootdao
                                    .queryByQL2List("from CpgMsgSndCtl where oppIdType='"
                                            + CpgMsgSndCtl.OPP_ID_TYPE_USER + "' and oppId = '" + key + "'");
                            for (CpgMsgSndCtl bean : cpgMsgSndCtl) {
                                rootdao.delete(bean);
                            }
                            List<CpgMsgSndCtlTmp> cpgMsgSndCtlTmp = rootdao
                                    .queryByQL2List("from CpgMsgSndCtlTmp where oppIdType='"
                                            + CpgMsgSndCtl.OPP_ID_TYPE_USER + "' and oppId = '" + key + "'");
                            for (CpgMsgSndCtlTmp bean : cpgMsgSndCtlTmp) {
                                rootdao.delete(bean);
                            }
                            /**
                             * add by zhangdianchao 20160324 将【有效/无效】功能 改为【删除】
                             * end
                             */
                        } else {// modify by zhangdianchao 20160324 这里是原有的代码
                            // 保持不动
                            // 说明是其它修改
                            tlrInfo.setSt(REPORT__FH_ST.YES.value);
                            tlrInfo.setChecker(gi.getTlrno());
                            tlrInfo.setCheckTime(DateUtil.get14Date());

                            String key = tlrInfo.getTlrno();

                            List<TlrRoleRel> roleRellist = rootdao.queryByQL2List("from TlrRoleRel where tlrno = ? ",
                                    new String[] { key }, null);

                            for (TlrRoleRel trlrolereldel : roleRellist) {
                                rootdao.delete(trlrolereldel);
                            }
                            // 给用户分配角色表：
                            List<TlrRoleRel> roleList = tlrInfoAuditBean.getRoleRellist();
                            for (TlrRoleRel trlrolerel : roleList) {
                                rootdao.save(trlrolerel);
                            }

//                            List<TlrBctlRel> bctlRellist = ROOTDAOUtils.getTlrBctlRelDAO().findByTlr(key);
//
//                            for (TlrBctlRel reldel : bctlRellist) {
//                                rootdao.delete(reldel);
//                            }

//                            List<TlrBctlRel> bctls = tlrInfoAuditBean.getBctlRellist();
//                            for (TlrBctlRel rel : bctls) {
//                                rootdao.save(rel);
//                            }

                            rootdao.saveOrUpdate(tlrInfo);

                            SyncMsgPlatformService syncMsg = SyncMsgPlatformService.getInstance();
                            syncMsg.syncToMsgUser(tlrInfo.getTlrno(), 2);
                        }

                    }

                }
            }
            // 拒绝操作
            else {
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                    // 用户-新增-拒绝
                    if (extraFlag) {
                        TlrInfoAuditBean obj = (TlrInfoAuditBean) ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                        TlrInfo tlrinfo = rootdao.query(TlrInfo.class, obj.getTlrInfo().getTlrno());
                        rootdao.delete(tlrinfo);
                        // 删除角色引用
                        List<TlrRoleRel> roleList = obj.getRoleRellist();
                        for (TlrRoleRel tlrrolerel : roleList) {
                            rootdao.delete(tlrrolerel);

                        }
//                        // 删除机构引用
//                        List<TlrBctlRel> funcList = obj.getBctlRellist();
//                        for (TlrBctlRel tlrbctlrel : funcList) {
//                            rootdao.delete(tlrbctlrel);
//
//                        }
                    }
                    // 修改
                    else {
                        TlrInfo obj = (TlrInfo) getObjectByOldKey(oldkey, intInsId);
                        obj.setSt(REPORT__FH_ST.YES.value);
                        rootdao.saveOrUpdate(obj);
                    }

                }
                // 如果是角色-拒绝
                if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)) {
                    if (extraFlag) {// 新增拒绝
                        RoleInfo obj = (RoleInfo) ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                        String id = obj.getId();
                        rootdao.delete(obj);
                        // 删除角色-菜单表
                        deleRoleFunc(id);
                    } else {// 角色修该拒绝
                        RoleInfo obj = (RoleInfo) getObjectByOldKey(oldkey, intInsId);
                        obj.setIsLock("0");
                        obj.setSt(REPORT__FH_ST.YES.value);
                        obj.setApvTlr(gi.getTlrno());
                        obj.setApvTime(DateUtil.get14Date());
                        rootdao.saveOrUpdate(obj);

                    }

                }
            }

            // 删除旧表
            if (bl) {
                rootdao.delete(taskbean);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            ExceptionUtil.throwCommonException(e.getMessage());
        }
    }

    // 审批操作--jianxue.zhang--新版本
    public void approveList(List insert, List update, List del, String approveResult, String approveRemark,
            String intInsId) throws CommonException {
        // 公用数据:
        GlobalInfo GI = GlobalInfo.getCurrentInstance();
        String approvePeople = GI.getTlrno();
//        String approveInsCd = GI.getBrcode();
        SysTaskInfo taskbean = new SysTaskInfo();
        // 下边这些是每次遍历的时候的信号标志变量,每一次遍历前都得重新刷新这些数据,否则会被上一次干扰
        // ---------------------FLAG START-----------------------
        // 初始化这些参数的默认值
        // 1,2,3,4,5
        String st = null;
        // 0-1或者true-false
        String isLock = null;
        // true-false
        String isDel = null;
        // true-false
        boolean oldflag = false;
        // 是否新增删除标志表明是:新增拒绝
        boolean newDel = false;
        // 对getObjectAndApproveExtra的特殊flag:代表是新增还是修改
        boolean extraFlag = false;
        // ---------------------FLAG END---------------------------
        if (approveResult.equals("01")) {
            // ---复核通过---
            // 新增操作 :st:有效4,lock:解锁,del:null,oldflag:false;
            if (!insert.isEmpty()) {
                Iterator it = insert.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.YES.value;
                    isLock = "F";
                    isDel = "F";
                    extraFlag = true;
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople, approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_NEW, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople, 
                                approveResult, approveRemark, intInsId);
                    }
                }

            }
            // 更新操作:st:有效4,lock:解锁,del:null,oldflag:false;
            if (!update.isEmpty()) {
                Iterator it = update.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.YES.value;
                    isLock = "F";
                    isDel = "F";
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople, approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_MOD, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople,
                                approveResult, approveRemark, intInsId);
                    }
                }
            }
            // 删除操作:st:有效4,lock:解锁,del:true,oldflag:true;
            if (!del.isEmpty()) {
                Iterator it = del.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.YES.value;
                    isLock = "F";
                    isDel = "T";
                    oldflag = true;
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople, approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_DEL, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople, 
                                approveResult, approveRemark, intInsId);
                    }
                }
            }
            GI.addBizLog("Updater.log",
                    new String[] { GI.getTlrno(),  "主管确认-复核通过-业务类型【" + intInsId + "】" });
            htlog.info("Updater.log",
                    new String[] { GI.getTlrno(),  "主管确认-复核通过-业务类型【" + intInsId + "】" });
        } else {
            // ---复核拒绝---
            // 新增操作:st:无效5,lock:解锁,del:null,oldflag:false;
            if (!insert.isEmpty()) {
                Iterator it = insert.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.NO.value;
                    isLock = "F";
                    isDel = "T";
                    extraFlag = true;
                    newDel = true;
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople,  approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_NEW, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople, 
                                approveResult, approveRemark, intInsId);
                    }
                }

            }
            // 更新操作:st:有效4,lock:解锁,del:null,oldflag:true;
            if (!update.isEmpty()) {
                Iterator it = update.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.YES.value;
                    isLock = "F";
                    isDel = "F";
                    oldflag = true;
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople,  approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_MOD, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople, 
                                approveResult, approveRemark, intInsId);
                    }
                }
            }
            // 删除操作:st:有效4,lock:解锁,del:false,oldflag:false;
            if (!del.isEmpty()) {
                Iterator it = del.iterator();
                while (it.hasNext()) {
                    taskbean = (SysTaskInfo) it.next();
                    // --start--
                    st = null;
                    isLock = null;
                    isDel = null;
                    oldflag = false;
                    newDel = false;
                    extraFlag = false;
                    // end
                    st = REPORT__FH_ST.YES.value;
                    isLock = "F";
                    isDel = "F";
                    oldflag = true;
                    if (intInsId.equals(REPORT_TASK_FUNCID.TASK_100299.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100599.value)
                            || intInsId.equals(REPORT_TASK_FUNCID.TASK_100399.value)) {
                        getObjectAndApproveExtra(taskbean, st, extraFlag, approvePeople, approveResult,
                                approveRemark, intInsId);
                    } else if (intInsId.equals(REPORT_TASK_FUNCID.TASK_120199.value)) {
                        approveOperation(taskbean, APPROVE_DEL, approveResult, approvePeople, 
                                approveRemark, intInsId);
                    } else {
                        getObjectAndApprove(taskbean, st, isLock, isDel, oldflag, newDel, approvePeople, 
                                approveResult, approveRemark, intInsId);
                    }
                }

            }
            GI.addBizLog("Updater.log",
                    new String[] { GI.getTlrno(), "主管确认-复核拒绝-业务类型【" + intInsId + "】" });
            htlog.info("Updater.log",
                    new String[] { GI.getTlrno(),"主管确认-复核拒绝-业务类型【" + intInsId + "】" });
        }
    }

    /**
     * 审批通操作
     *
     * @param taskbean
     * @param opType
     * @param approveResult
     * @param approvePeople
     * @param approveBrCode
     * @param approveRemark
     * @param intInsId
     * @throws CommonException
     */
    private void approveOperation(SysTaskInfo taskbean, String opType, String approveResult, String approvePeople,
            String approveRemark, String intInsId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        ReportTaskUtil rt = new ReportTaskUtil();
        String oldkey = taskbean.getAdtRcdPk();
        Object obj = null;
        try {
            // 写入历史表
            Boolean bl = LogTask(taskbean, approvePeople, approveResult, approveRemark);
            // 通过反序列化获取object
            if (approveResult.equals("01")) {// 通过
                obj = ReportTaskUtil.getObjctBySysTaskInfo(taskbean);
                if (opType.equals(APPROVE_NEW) || opType.equals(APPROVE_MOD)) {
                    // 有效
                    PropertyUtils.setNestedProperty(obj, "st", REPORT__FH_ST.YES.value);
                    rootdao.saveOrUpdate(obj);
                } else {
                    rootdao.delete(obj);
                }
            } else {
                // 根据原纪录主键获取object
                obj = getObjectByOldKey(oldkey, intInsId);
                if (opType.equals(APPROVE_NEW)) {
                    rootdao.delete(obj);
                } else {
                    // 有效
                    PropertyUtils.setNestedProperty(obj, "st", REPORT__FH_ST.YES.value);
                    rootdao.saveOrUpdate(obj);
                }
            }
            // 删除旧表
            if (bl) {
                rootdao.delete(taskbean);
            }

        } catch (Exception xe) {
            ExceptionUtil.throwCommonException(xe.getMessage());
        }
    }
    
	  /**
	   * 获取roleInfo表中最大的role_id
	   * @return
	   * @throws CommonException
	   */
	  public int getMaxId() throws CommonException {
		  	ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
		  	String hql = "select max(id) from RoleInfo";
		  	List list =rootdao.queryByCondition(hql);
		  	int id;
		  	if(null==list.get(0)){
		  		id=100;
		  	}else{
		  		id= Integer.valueOf((String) list.get(0));
		  	}
			return id;
	 }
}
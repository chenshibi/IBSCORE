package com.huateng.report.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.common.bean.UndoConfirmTaskBean;
import com.huateng.report.constants.CreditReportConstants;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.BiQuartzJobLog;
import resource.bean.basic.BiTlrFavt;
import resource.bean.basic.DataDic;
import resource.bean.basic.SysParams;
import resource.bean.basic.SysParamsPK;
import resource.bean.boa.CustUndoTaskConf;
import resource.dao.basic.ComposedBean;

public class ReportCommonService {
    private static Logger log = Logger.getLogger(ReportCommonService.class);
    public static final String JOB_OK = "01";
    public static final String JOB_FAILED = "02";

    protected ReportCommonService() {

    }

    /**
     * get instance.
     *
     * @return
     */
    public synchronized static ReportCommonService getInstance() {
        return (ReportCommonService) ApplicationContextUtils.getBean(ReportCommonService.class.getName());
    }

    public DataDic getDataDic(int dataTypeNo, String dataNo) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo + " and model.dataNo='" + dataNo.trim()
                + "'";
        List<DataDic> list = rootdao.queryByQL2List(hql);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public List getDataDicList(int dataTypeNo) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo;

        List<DataDic> list = rootdao.queryByQL2List(hql);

        return list;
    }

    /**
     * @author zengqinag.yang 2013-2-26-下午8:16:42
     * @param highLimit
     * @return
     * @throws CommonException
     */
    public DataDic getDataDicByHighLimit(int dataTypeNo, String highLimit) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo + " and upper(model.highLimit)='"
                + highLimit + "'";
        List<DataDic> list = rootdao.queryByQL2List(hql);
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public List<DataDic> getDataDic(int dataTypeNo) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = " from DataDic model where model.dataTypeNo=" + dataTypeNo;
        List<DataDic> list = rootdao.queryByQL2List(hql);
        return list;
    }

    public List getConfList(String code) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = rootdao.queryByQL2List(
                " from SysBusinavConf model where model.parentCode='" + code + "' order by model.showSeq");
        return list;
    }

    public int getImportLogByWorkDate(String workDate) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return rootdao.queryByHqlToCount("select count(model) from BiImportLog model where model.workDate='" + workDate
                + "' and model.importStatus='1'");
    }

    public SysParams getSysparamsByPk(String groupId, String paramId) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return (SysParams) rootdao.query(SysParams.class, new SysParamsPK(groupId, paramId));
    }

    public List<DataDic> getBusinessByTypeNo() throws CommonException {
        List<DataDic> busiList = getDataDicList(ReportConstant.DATA_DIC_BUSI_TYPE_NO, null);
        return busiList;
    }

    public List<DataDic> getDataDicList(int typeNo, String dataNo) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = " from DataDic model where model.dataTypeNo=" + typeNo;
        if (dataNo != null && dataNo.trim().length() > 0) {
            hql += " and model.dataNo='" + dataNo.trim() + "'";
        }
        hql += " order by model.dataNo";
        List<DataDic> list = rootdao.queryByQL2List(hql);
        return list;
    }

    /**
     * 保存定时任务执行日志
     *
     * @param startTm
     * @param endTm
     * @param quartId
     * @param result
     * @param jobName
     * @param remarak
     * @throws CommonException
     */
    public void saveJobLog(Date startTm, Date endTm, String quartId, String result, String jobName, String remark) {
        ;
        BiQuartzJobLog joblog = new BiQuartzJobLog();
        joblog.setId(ReportUtils.getUUID());
        joblog.setExecTm(DateUtil.get14Date(startTm));
        joblog.setEndTm(endTm == null ? DateUtil.get14Date(new Date()) : DateUtil.get14Date(endTm));
        joblog.setQuartzId(quartId);
        joblog.setQuartzResult(result);
        joblog.setQuartzName(jobName);
        joblog.setRemark(remark);

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        try {
            rootdao.save(joblog);
        } catch (CommonException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

    /**
     * 待处理配置信息查询
     * 
     * @param map
     * @param map
     * @return
     */
    public static ComposedBean queryUndoTaskConf(Map map) {
        ComposedBean comBean = new ComposedBean();
        StringBuffer sb = new StringBuffer();
        sb.append("select rt");
        sb.append(" from CustUndoTaskConf rt");
        sb.append(" where 1=1");
        if (StringUtils.isNotBlank((String) map.get("sysname"))) {
            sb.append(" and rt.sysname in (" + map.get("sysname")).append(")");
        }
        sb.append(" order by rt.funcid asc ");
        comBean.setSql(sb.toString());
        return comBean;
    }

    /**
     * 首页主管确认信息
     *
     * @return
     * @throws CommonException
     */
    public List<UndoConfirmTaskBean> getUndoConfirmTask(HttpSession httpSession) throws CommonException {
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        GlobalInfo.setCurrentInstance(globalInfo);
        List confrimCodeList = globalInfo.getConfrimCodeList();
        List<UndoConfirmTaskBean> list = new ArrayList<UndoConfirmTaskBean>();
        /*
         * if (confrimCodeList != null && confrimCodeList.size() > 0) { String
         * codes = ReportUtils.getConfrimCodes(confrimCodeList); ROOTDAO rootDao
         * = ROOTDAOUtils.getROOTDAO(); String hql =
         * "select new com.huateng.report.common.bean.UndoConfirmTaskBean(dd.intInsId,count(dd)) from SysTaskInfo dd where dd.intInsId in "
         * + codes + " group by dd.intInsId"; list =
         * rootDao.queryByQL2List(hql); List<DataDic> dds =
         * getDataDicList(300001, null); Map<String, String> ddMap = new
         * HashMap<String, String>(); for (DataDic dd : dds) {
         * ddMap.put(dd.getDataNo(), dd.getDataName()); } for
         * (UndoConfirmTaskBean bean : list) {
         * bean.setIntInsIdName(ddMap.get(bean.getIntInsId())); } }
         */

        Map map = new HashMap();
        // map.put("isMain",CreditConstant.CREDIT_ISMAIN); //主表标识
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        ComposedBean bean = queryUndoTaskConf(map);
        String hql1 = bean.getSql();
        List<CustUndoTaskConf> UndoTaskConflist = rootDao.queryByQL2List(hql1);
        for (int i = 0; i < UndoTaskConflist.size(); i++) {
            CustUndoTaskConf undoconf = UndoTaskConflist.get(i);
            String undohql = "select t from " + undoconf.getTablename() + " t where  1=1 ";

            undohql = undohql + " and t." + undoconf.getBrtype() + "='" + globalInfo.getBrcode() + "'";

            if ("1".equalsIgnoreCase(undoconf.getType()))// 通用录入
            {
                undohql = undohql + " and ( t.recStatus='" + CreditReportConstants.REPORT_RECSTATUS_00
                        + "' or t.recStatus='" + CreditReportConstants.REPORT_RECSTATUS_03 + "' )"
                        + " and ( t.approveStatus='" + CreditReportConstants.REPORT_APPROVESTATUS_00
                        + "' or t.approveStatus='" + CreditReportConstants.REPORT_APPROVESTATUS_03 + "' ) ";
            } else if ("2".equalsIgnoreCase(undoconf.getType()))// 通用审核
            {
                undohql = undohql + " and ( t.recStatus='" + CreditReportConstants.REPORT_RECSTATUS_00
                        + "' or t.recStatus='" + CreditReportConstants.REPORT_RECSTATUS_03 + "' )"
                        + " and t.approveStatus='" + CreditReportConstants.REPORT_APPROVESTATUS_01 + "'";
            } else if ("3".equalsIgnoreCase(undoconf.getType()))// 自由条件
            {
                undohql = undohql + undoconf.getWherecondition();
            } else {
                String errlog = "FuncId " + undoconf.getFuncid() + ":" + undoconf.getFuncname() + " 类型不正确,请核实。";
                log.info(errlog);
                continue;
            }

            List undohqllist = rootDao.queryByQL2List(undohql);
            UndoConfirmTaskBean taskbean = new UndoConfirmTaskBean();
            long cnt = undohqllist.size();

            log.info("待办业务类型：" + undoconf.getFuncname() + ",共有[" + cnt + "]笔代办业务。");
            // 菜单权限
            boolean flag = false;// 是否有权限
            Map<String, String> buttonMap = globalInfo.getButtonMap();
            for (Map.Entry<String, String> entry : buttonMap.entrySet()) {
                // 业务菜单权限
                if (undoconf.getFuncid().equals(entry.getValue())) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                taskbean.setUrlLink(undoconf.getPagepath());
            } else {
                taskbean.setUrlLink(null);
            }

            taskbean.setCount(cnt);
            taskbean.setIntInsId(undoconf.getFuncid());
            taskbean.setIntInsIdName(undoconf.getFuncname());
            if (cnt != 0) {
                list.add(taskbean);
            }
        }
        return list;
    }

    public List getFunctionInfoListByFavt(HttpSession httpSession) throws CommonException {
        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        GlobalInfo.setCurrentInstance(globalInfo);
        Map funmap = globalInfo.getAllFunctions();
        List<Object> funcList = new ArrayList<Object>();
        ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
        List favtList = dao.queryByQL2List(" from BiTlrFavt model where model.tlrNo='" + globalInfo.getTlrno()
                + "' and model.funcType='" + globalInfo.getMenuCode() 
                + "' order by model.showSeq");
        for (int i = 0; i < favtList.size(); i++) {
            BiTlrFavt favt = (BiTlrFavt) favtList.get(i);
            if (funmap.containsKey(favt.getFuncId().trim())) {
                funcList.add(funmap.get(favt.getFuncId().trim()));
            }
        }
        return funcList;
    }

    public void saveOrUpdateFavt(String tlrNo, String funcType, List<String> funcId)
            throws CommonException {
        ROOTDAO dao = ROOTDAOUtils.getROOTDAO();
        List oldList = dao.queryByQL2List(
                " from BiTlrFavt model where model.tlrNo='" + tlrNo + "' and model.funcType='" + funcType + "'");
        if (oldList != null) {
            for (int i = 0; i < oldList.size(); i++) {
                dao.delete(oldList.get(i));
            }
        }
        for (int i = 0; i < funcId.size(); i++) {
            BiTlrFavt ft = new BiTlrFavt();
            ft.setId(ReportUtils.getUUID());
            ft.setFuncId(funcId.get(i).trim());
            ft.setTlrNo(tlrNo);
            ft.setShowSeq(i);
            ft.setFuncType(funcType);
            dao.saveOrUpdate(ft);
        }

    }

    /**
     * 首页显示定时任务日志
     *
     * @return
     * @throws CommonException
     */
    public List<BiQuartzJobLog> getQuartzJobLog() throws CommonException {
        StringBuffer hql = new StringBuffer(
                "select model from BiQuartzJobLog model where model.execTm>=? and model.execTm<=? order by model.execTm desc");
        List<Object> objlist = new ArrayList<Object>();
        String curDateStr = DateUtil.dateToNumber(new Date());
        objlist.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(curDateStr), +1));
        objlist.add(DateUtil.getStartDateByDays(DateUtil.stringToDate2(curDateStr), -1));
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return rootdao.queryByQL2List(hql.toString(), objlist.toArray(), null);
    }

    public List getReportBopJshList() throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = rootdao.queryByQL2List(" from BiBopjshRetNo");
        return list;
    }

    public List getFunctionNavList(String parentCode) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        List list = rootdao.queryByQL2List(
                " from FunctionInfo model where model.lastdirectory='" + parentCode + "' order by model.showseq");
        return list;
    }

    public int getFunctionCountByTlrNo(String tlrNo, String parentCode) throws CommonException {

        String funcIds = ReportUtils.getConfrimCodes(getFunctionNavList(parentCode));

        StringBuffer hql = new StringBuffer();
        hql.append("select count(rr) from TlrRoleRel tr,RoleFuncRel rr");
        hql.append(" where tr.roleId=rr.roleId ");
        hql.append("and tr.tlrno='").append(tlrNo).append("' and rr.funcid in " + funcIds);
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return rootdao.queryByHqlToCount(hql.toString());
    }

}

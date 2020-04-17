package com.huateng.report.system.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.system.operation.SysNoticeOperation;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;
import com.huateng.report.utils.ReportUtils;

import resource.bean.basic.SysNotice;
import resource.bean.basic.SysTaskInfo;

public class SysNoticeService {

    public synchronized static SysNoticeService getInstance() {
        return (SysNoticeService) ApplicationContextUtils.getBean(SysNoticeService.class.getName());
    }

    public void save(SysNotice sysNotice, String opType) throws CommonException {
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        if (SysNoticeOperation.CMD_INSERT.equals(opType)) {

            sysNotice.setId(ReportUtils.getUUID());
            sysNotice.setCrtTm(DateUtil.get14Time());
            sysNotice.setCrtTlr(gi.getTlrno());
            sysNotice.setLstUpdTlr(gi.getTlrno());
            sysNotice.setLstUpdTm(DateUtil.get14Time());
            sysNotice.setSt(ReportEnum.REPORT_ST1.CR.value);
            rootdao.save(sysNotice);
            try {
                SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_120199.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, sysNotice, sysNotice.getId(), null);
                rootdao.saveOrUpdate(tskInf);
            } catch (IOException e) {
                ExceptionUtil.throwCommonException("系统公告维护新增保存，双岗复核序列化到数据库出错！");
                e.printStackTrace();
            }
        } else if (SysNoticeOperation.CMD_UPDATE.equals(opType)) {

            SysNotice dbSysNotice = rootdao.query(SysNotice.class, sysNotice.getId());
            String sd = dbSysNotice.getStartDate();
            String ed = dbSysNotice.getEndDate();
            String nt = dbSysNotice.getNoticeTitle();
            String nc = dbSysNotice.getNoticeContent();
            dbSysNotice.setStartDate(sysNotice.getStartDate());
            dbSysNotice.setEndDate(sysNotice.getEndDate());
            dbSysNotice.setNoticeTitle(sysNotice.getNoticeTitle());
            dbSysNotice.setNoticeContent(sysNotice.getNoticeContent());
            dbSysNotice.setSt(ReportEnum.REPORT_ST1.ET.value);
            dbSysNotice.setLstUpdTlr(gi.getTlrno());
            dbSysNotice.setLstUpdTm(DateUtil.get14Time());
            try {
                SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_120199.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, dbSysNotice, dbSysNotice.getId(),
                        sysNotice.getSt());
                rootdao.saveOrUpdate(tskInf);
            } catch (IOException e) {
                ExceptionUtil.throwCommonException("系统公告维护修改保存，双岗复核序列化到数据库出错！");
                e.printStackTrace();
            }
            dbSysNotice.setStartDate(sd);
            dbSysNotice.setEndDate(ed);
            dbSysNotice.setNoticeTitle(nt);
            dbSysNotice.setNoticeContent(nc);
            rootdao.saveOrUpdate(dbSysNotice);
        } else if (SysNoticeOperation.CMD_DELETE.equals(opType)) {
            SysNotice dbsSysNotice = rootdao.query(SysNotice.class, sysNotice.getId());
            dbsSysNotice.setSt(ReportEnum.REPORT_ST1.DE.value);
            try {
                SysTaskInfo tskInf = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_120199.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.DEL.value, dbsSysNotice, dbsSysNotice.getId(),
                        sysNotice.getSt());
                rootdao.saveOrUpdate(tskInf);
            } catch (IOException e) {
                ExceptionUtil.throwCommonException("系统公告维护删除保存，双岗复核序列化到数据库出错！");
                e.printStackTrace();
            }
        }
    }

    public List<SysNotice> getViewSysNotice(HttpSession httpSession) throws CommonException {

        GlobalInfo globalInfo = (GlobalInfo) httpSession.getAttribute(GlobalInfo.KEY_GLOBAL_INFO);
        GlobalInfo.setCurrentInstance(globalInfo);
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        String hql = "select model from SysNotice model where model.startDate <='"
                + DateUtil.dateToNumber(gi.getTxdate()) + "' and model.endDate >='"
                + DateUtil.dateToNumber(gi.getTxdate()) + "' and model.st='4' order by model.lstUpdTm desc";
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        return rootdao.queryByQL2List(hql);
    }

}

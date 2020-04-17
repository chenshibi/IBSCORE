/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.management.operation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.BaseDAOUtils;
import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.SystemConstant;
import com.huateng.ebank.business.common.service.CommonService;
import com.huateng.ebank.business.management.service.branchManageDetailService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DataFormat;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.utils.ReportEnum;
import com.huateng.report.utils.ReportTaskUtil;

import resource.bean.basic.Bctl;
import resource.bean.basic.SysTaskInfo;
import resource.dao.basic.BctlDAO;

public class BranchManageUpdateOperation extends BaseOperation {
    private static final HtLog htlog = HtLogFactory.getLogger(BranchManageUpdateOperation.class);
    public static final String INSERT_LIST = "INSERT_LIST";
    public static final String UPDATE_LIST = "UPDATE_LIST";
    public static final String DEL_LIST = "DEL_LIST";

    public void beforeProc(OperationContext context) throws CommonException {

    }

    public void execute(OperationContext context) throws CommonException {
        BctlDAO bctlDao = BaseDAOUtils.getBctlDAO();
        List insertList = (List) context.getAttribute(INSERT_LIST);
        List updateList = (List) context.getAttribute(UPDATE_LIST);
        List delList = (List) context.getAttribute(DEL_LIST);
        // BctlService bctlService = BctlService.getInstance();
        // bctlService.bctlInfo(insertList, updateList, delList);
        AddEntityValue(insertList);
        UpdateEntityValue(updateList);

    }

    public void AddEntityValue(List list) throws CommonException {
        for (Iterator it = list.iterator(); it.hasNext();) {
            Bctl bean = (Bctl) it.next();

            BctlDAO dao = BaseDAOUtils.getBctlDAO();
            CommonService commonService = CommonService.getInstance();
            List lis = dao.queryByCondition(
                    "po.brno = '" + bean.getBrno() + "'" + " and po.status = " + SystemConstant.VALID_FLAG_VALID);

            if (lis.size() > 0) {// 已存在不能添加
                ExceptionUtil.throwCommonException("机构代码重复", ErrorCode.ERROR_CODE_BCTL_INSERT);
            } else {
                bean.setBrcode(bean.getBrno());
                bean.setStatus(SystemConstant.FLAG_ON);
                bean.setLastUpdTlr(GlobalInfo.getCurrentInstance().getTlrno());
                bean.setLastUpdDate(DateUtil.get14Time());
                bean.setSt(ReportEnum.REPORT_ST1.CR.value);
                bean.setLock("T");
                bean.setDel("F");
                // dao.insert(bean);

            }

            branchManageDetailService.addEntity(bean);
            SysTaskInfo taskInfo = null;

            try {
                taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100199.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.NEW.value, bean, bean.getBrcode(), bean.getSt());
            } catch (CommonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            branchManageDetailService.addTosystaskinfo(taskInfo);
            GlobalInfo gi = GlobalInfo.getCurrentInstance();
//            gi.addBizLog("Updater.log", new String[] { gi.getTlrno(), gi.getBrno(), "执行新建机构管理信息" + bean.getBrno() });
            htlog.info("Updater.log", new String[] { gi.getBrcode(), gi.getTlrno(), "执行新建机构管理信息" + bean.getBrno() });
        }

    }

    public void UpdateEntityValue(List list) throws CommonException {
        for (Iterator it = list.iterator(); it.hasNext();) {
            Bctl bean = (Bctl) it.next();
            Bctl sys1 = branchManageDetailService.selectById(bean.getBrcode());

            BctlDAO dao = BaseDAOUtils.getBctlDAO();
            Bctl bctlModify = dao.query(bean.getBrcode());

            // 不更新不存在的表
            if (null != bctlModify) {

                // 不能修改总行的级别
                if (SystemConstant.BRCODE_CLASS_HEAD.equals(bctlModify.getBrclass())// 原级别为总行
                        && !SystemConstant.BRCODE_CLASS_HEAD.equals(bean.getBrclass())) {// 修改后级别非总行
                    ExceptionUtil.throwCommonException("不能修改总行的级别", ErrorCode.ERROR_CODE_BCTL_INSERT);
                }

                if (DataFormat.isEmpty(bean.getBlnUpBrcode())) {
                    if (!SystemConstant.BRCODE_CLASS_HEAD.equals(bctlModify.getBrclass())) {// 原级别不为总行
                        ExceptionUtil.throwCommonException("[机构代码]为" + bean.getBrno() + "的记录，字段[上级机构]不应为空.",
                                ErrorCode.ERROR_CODE_INFO_NOT_INPUT);
                    }
                }
                if (DataFormat.isEmpty(bean.getBrclass())) {
                    ExceptionUtil.throwCommonException("[机构代码]为" + bean.getBrno() + "的记录，字段[机构级别]不应为空.",
                            ErrorCode.ERROR_CODE_INFO_NOT_INPUT);
                }

            }

            sys1.setSt(ReportEnum.REPORT_ST1.ET.value);
            sys1.setLock("T");
            sys1.setDel("F");

            branchManageDetailService.addEntity(sys1);
            SysTaskInfo taskInfo = null;

            try {
                taskInfo = ReportTaskUtil.getSysTaskInfoBean(ReportEnum.REPORT_TASK_FUNCID.TASK_100199.value,
                        ReportEnum.REPORT_TASK_TRANS_CD.EDIT.value, bean, bean.getBrcode(), bean.getSt());
            } catch (CommonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            branchManageDetailService.addTosystaskinfo(taskInfo);
            GlobalInfo gi = GlobalInfo.getCurrentInstance();
//            gi.addBizLog("Updater.log", new String[] { gi.getTlrno(), gi.getBrno(), "执行更新机构管理信息" + bean.getBrno() });
            htlog.info("Updater.log", new String[] { gi.getBrcode(), gi.getTlrno(), "执行更新机构管理信息" + bean.getBrno() });
        }

    }

    public void afterProc(OperationContext context) throws CommonException {

    }

    public void checkPostNo(Bctl bctl) throws CommonException {
        String postNo = bctl.getPostno();
        if (postNo.length() != 6) {
            ExceptionUtil.throwCommonException(bctl.getBrcode() + "的邮编不是6位！", ErrorCode.ERROR_CODE_POSTNO);
        } else {
            try {
                int post = Integer.parseInt(postNo);
            } catch (Exception e) {
                ExceptionUtil.throwCommonException(bctl.getBrcode() + "的邮编必须填入数字！", ErrorCode.ERROR_CODE_POSTNO);
            }
        }
    }

}
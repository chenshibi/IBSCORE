package com.huateng.report.scheduler.operation;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.SchedulerException;

import com.huateng.ebank.business.common.GlobalInfo;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.innerinterface.ITimedScheduler;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.operation.BaseOperation;
import com.huateng.ebank.framework.operation.OperationContext;
import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.scheduler.timer.SystemTimedScheduler;
import com.huateng.report.utils.LogExceptionUtils;

import resource.bean.basic.ReportJobConfig;

public class SystemTimedSchedulerOperation extends BaseOperation {
    private static Logger log = Logger.getLogger(SystemTimedSchedulerOperation.class);
    public static final String ID = "SystemTimedSchedulerOperation";
    public static final String CMD = "CMD";
    public static final String OP_START = "OP_START";
    public static final String OP_STOP = "OP_STOP";
    public static final String IN_ID_VALUE = "IN_ID_VALUE";
    public static final String IN_BEAN = "IN_BEAN";
    public static final String OP_UPDATE = "OP_UPDATE";

    @Override
    public void afterProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeProc(OperationContext context) throws CommonException {
        // TODO Auto-generated method stub

    }

    @Override
    public void execute(OperationContext context) throws CommonException {
        String cmd = (String) context.getAttribute(CMD);
        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        GlobalInfo gi = GlobalInfo.getCurrentInstance();
        if (cmd.equals(OP_START)) {
            String id = (String) context.getAttribute(IN_ID_VALUE);
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, id);
            jobConfig.setJobStauts(ITimedScheduler.TIMED_STATUS_1);
            jobConfig.setJobLstTm(DateUtil.get14Time());
            jobConfig.setJobLstTrl(gi.getTlrno());
            rootdao.update(jobConfig);
            // 定时任务停止
            try {
                SystemTimedScheduler.addJob(jobConfig.getId(),
                        (Job) Class.forName(jobConfig.getJobClassName()).newInstance(), jobConfig.getJobTime());
            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
                ExceptionUtil.throwCommonException("定时任务停止启动出错");
            }
            gi.addBizLog("Updater.log",
                    new String[] { gi.getTlrno(),  "启动定时器:" + jobConfig.getJobName() });
            log.info(gi.getTlrno() + " " + " 启动定时器:" + jobConfig.getJobName());
        } else if (cmd.equals(OP_STOP)) {
            String id = (String) context.getAttribute(IN_ID_VALUE);
            ReportJobConfig jobConfig = rootdao.query(ReportJobConfig.class, id);
            jobConfig.setJobStauts(ITimedScheduler.TIMED_STATUS_0);
            jobConfig.setJobLstTm(DateUtil.get14Time());
            jobConfig.setJobLstTrl(gi.getTlrno());
            rootdao.update(jobConfig);
            // 定时任务停止
            try {
                SystemTimedScheduler.removeJob(jobConfig.getId());
            } catch (SchedulerException e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
                ExceptionUtil.throwCommonException("定时任务停止启动出错");
            }
            gi.addBizLog("Updater.log",
                    new String[] { gi.getTlrno(),  "停止定时器:" + jobConfig.getJobName() });
            log.info(gi.getTlrno() + " "   + " 停止定时器:" + jobConfig.getJobName());
        } else if (cmd.equals(OP_UPDATE)) {
            ReportJobConfig jobConfig = (ReportJobConfig) context.getAttribute(IN_BEAN);
            ReportJobConfig dbJobConfig = rootdao.query(ReportJobConfig.class, jobConfig.getId());

            String dbJobTime = dbJobConfig.getJobTime();

            dbJobConfig.setJobTime(jobConfig.getJobTime());
            dbJobConfig.setJobRemark(jobConfig.getJobRemark());
            dbJobConfig.setJustWorkdateRun(jobConfig.getJustWorkdateRun());
            jobConfig.setJobLstTm(DateUtil.get14Time());
            jobConfig.setJobLstTrl(gi.getTlrno());
            rootdao.update(dbJobConfig);
            // 如果执行时间有改过则需修改触发器时间
            if (!dbJobTime.equals(jobConfig.getJobTime())) {
                try {
                    SystemTimedScheduler.removeJob(dbJobConfig.getId());
                    if (jobConfig.getJobStauts().equals(ITimedScheduler.TIMED_STATUS_1)) {
                        SystemTimedScheduler.addJob(dbJobConfig.getId(),
                                (Job) Class.forName(dbJobConfig.getJobClassName()).newInstance(),
                                dbJobConfig.getJobTime());
                    }
                } catch (Exception e) {
                    LogExceptionUtils.logException(log, e);
                    e.printStackTrace();
                    ExceptionUtil.throwCommonException("定时任务触发器时间修改错误");
                }

                gi.addBizLog("Updater.log", new String[] { gi.getTlrno(),
                        "修改定时器:" + jobConfig.getJobName() + "," + jobConfig.getJobTime() });
                log.info(gi.getTlrno() + " " +  " 修改定时器:" + jobConfig.getJobName() + ","
                        + jobConfig.getJobTime());

            }
        }
    }

}

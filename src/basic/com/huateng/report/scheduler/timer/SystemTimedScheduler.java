package com.huateng.report.scheduler.timer;

import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.business.innerinterface.ITimedScheduler;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.ReportJobConfig;

/*******************************************************************************
 * 定时器类
 ******************************************************************************/

public class SystemTimedScheduler implements ITimedScheduler {
    private static Logger logger = Logger.getLogger(SystemTimedScheduler.class);

    private static SchedulerFactory sf = new StdSchedulerFactory();

    private static String JOB_GROUP_NAME = "TOP_REPORT_BOP";

    private static String TRIGGER_GROUP_NAME = "TOP_REPORT_BOP_TRIGGER";

    private static ServletContext ctx = null;

    public void runNow(String jobid) {
        try {
            Scheduler sched = sf.getScheduler();
            sched.triggerJob(jobid, JOB_GROUP_NAME);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    // 初始化加载
    public void run(ServletContext context) throws CommonException {
        ctx = context;

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        String hql = "from ReportJobConfig model where model.jobStauts='" + ITimedScheduler.TIMED_STATUS_1 + "'";
        List<ReportJobConfig> list = rootdao.queryByQL2List(hql);
        if (list.size() > 0) {
            logger.info("Init timer start.....");
            for (ReportJobConfig jobConfig : list) {
                try {
                    SystemTimedScheduler.addJob(jobConfig.getId(),
                            (Job) Class.forName(jobConfig.getJobClassName()).newInstance(), jobConfig.getJobTime());
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                    ExceptionUtil.throwCommonException("定时初始化加载出错！");
                }
            }
            logger.info("Init timer end.....");
        }

    }

    /**
     * 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
     *
     * @param jobName
     *            任务名
     * @param job
     *            任务
     * @param time
     *            时间设置，参考quartz说明文档
     * @throws SchedulerException
     * @throws ParseException
     */
    public static void addJob(String jobId, Job job, String time) throws SchedulerException, ParseException {
        logger.info("add job " + jobId);

        Scheduler sched = sf.getScheduler();
        sched.getContext().put("serContext", ctx);
        JobDetail jobDetail = new JobDetail(jobId, JOB_GROUP_NAME, job.getClass());// 任务名，任务组，任务执行类
        jobDetail.getJobDataMap().put("jobId", jobId);
        // 触发器
        CronTrigger trigger = new CronTrigger(jobId, TRIGGER_GROUP_NAME);// 触发器名,触发器组
        trigger.setCronExpression(time);// 触发器时间设定
        sched.scheduleJob(jobDetail, trigger);
        // 启动
        if (!sched.isShutdown())
            sched.start();
    }

    /**
     * 移除一个任务
     *
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @throws SchedulerException
     */
    public static void removeJob(String jobId) throws SchedulerException {
        logger.info("remove job " + jobId);
        Scheduler sched = sf.getScheduler();
        sched.pauseTrigger(jobId, TRIGGER_GROUP_NAME);// 停止触发器
        sched.unscheduleJob(jobId, TRIGGER_GROUP_NAME);// 移除触发器
        sched.deleteJob(jobId, JOB_GROUP_NAME);// 删除任务
    }

}

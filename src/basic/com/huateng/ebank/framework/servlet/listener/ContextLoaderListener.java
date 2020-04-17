package com.huateng.ebank.framework.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.huateng.ebank.business.innerinterface.ITimedScheduler;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.util.ContextUtil;

public class ContextLoaderListener implements ServletContextListener {
    private static Logger logger = Logger.getLogger(ContextLoaderListener.class);

    public ContextLoaderListener() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        try {

            ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
            ApplicationContextUtils.setContext(ctx);
            ContextUtil.setContext(ctx);
            // del by zhaozhiguo
            // /** TLS-567 增加定时任务功能到海尔系统 by zhouxuejing 2011-11-21 begin */
            // /*启动所有定时任务*/
            // if(StringUtils.equals(context.getInitParameter("startJob"),"true")){
            // ITaskJobScheduler
            // scheduler=(ITaskJobScheduler)ContextUtil.getContext().getBean("TaskJobScheduler");
            // scheduler.startAllJob();
            // }
            // /** TLS-567 增加定时任务功能到海尔系统 by zhouxuejing 2011-11-21 end */

            // RuleApplicationContextUtils.setContext(ctx);
            // FIXME 定时器任务
            ITimedScheduler scheduler = (ITimedScheduler) ContextUtil.getContext().getBean("SystemTimedScheduler");
            scheduler.run(context);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void contextDestroyed(ServletContextEvent sce) {
        ApplicationContextUtils.close();
    }
    // del by zhaozhiguo
    // private void stopJobScheduler(){
    // try {
    // logger.info("###################停止定时任务开始###################");
    // ITaskJobScheduler
    // scheduler=(ITaskJobScheduler)ContextUtil.getContext().getBean("TaskJobScheduler");
    // scheduler.stopAllJob();
    // scheduler.stopScheduler();
    // logger.info("###################停止定时任务成功###################");
    // } catch (BeansException e) {
    // logger.error("###################停止定时任务失败###################",e);
    // // TODO Auto-generated catch block
    // } catch (Exception e) {
    // logger.error("###################停止定时任务失败###################",e);
    // // TODO Auto-generated catch block
    // }
    // }
}
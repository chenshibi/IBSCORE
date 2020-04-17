package com.huateng.ebank.framework.servlet.listener;

import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.log4j.Logger;

import com.huateng.common.Constants;
import com.huateng.common.SystemDProperty;
import com.huateng.ebank.business.common.DataDicUtils;
import com.huateng.ebank.business.common.MessageResourceUtil;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.MessageResources;
import com.huateng.exception.HuatengException;
import com.huateng.report.utils.ChineseUtils;
import com.huateng.service.pub.UserMgrService;

/**
 * @version 1.0
 * @author
 */
public class ApplicationListener implements ServletContextListener {

    private static Logger log = Logger.getLogger(ApplicationListener.class);

    private static String ERROR_MESSAGE_LOCATION_PARAM = "errorMessage";

    private static String SESSION_BETWEEN_SESSION_TIME = "sessionBetweenSessionTime";
    /** modify by shen_antonio 2009-7-28. BMS-2373 begin */
    private final static BigDecimal BIGDECIMAL_ZERO = new BigDecimal(0);

    /** modify by shen_antonio 2009-7-28. BMS-2373 end */
    public ApplicationListener() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent event) {
        String initParameter = event.getServletContext().getInitParameter(SESSION_BETWEEN_SESSION_TIME);
		log.info("sessionBetweenSessionTime="
                + initParameter);
        System.setProperty(SESSION_BETWEEN_SESSION_TIME,initParameter);   //变量重新定义

        String errorMessageLocation = event.getServletContext().getInitParameter(ERROR_MESSAGE_LOCATION_PARAM);
        if (null == errorMessageLocation) {
            log.error("没有配置错误消息资源.errorMessageLocation");
            System.exit(0);
        }
        try {
            MessageResources.getInstance().init(errorMessageLocation);
            /** shen_antonio . */
            /** 初始化字典数据 . */
            /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
            /** 默认加载英文和中文简体、繁体 */
            DataDicUtils.initDataDic(null);
            if (MessageResourceUtil.isIl8n()) {
                DataDicUtils.initDataDic(Locale.US);
                DataDicUtils.initDataDic(Locale.CHINA);
                DataDicUtils.initDataDic(Locale.TAIWAN);
            }
            /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end . */

            /** modify by shen_antonio 2009-7-28.BMS-2373 begin */
            converBeanUtils();
            /** modify by shen_antonio 2009-7-28.BMS-2373 end */

            /**** add by ningpeng 20121108 重启系统时设置状态为登陆的人员为已签退 *****/
            // this.setUserStatus();
        } catch (Exception ce) {
            log.error("异常", ce);
            log.error(ChineseUtils.SYS_SIGNOUT);
            System.err.println(ChineseUtils.SYS_SIGNOUT);
            System.exit(0);
        }

    }

    protected void init(ServletContext context) throws HuatengException {
        String appRootPath = context.getRealPath(Constants.SLASH);
        Constants.rootPath = appRootPath;
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * modify by shen_antonio 2009-7-28.BMS-2373 转换BeanUtils中的BigDecimal转换器
     * 
     * @throws HuatengException
     */
    protected void converBeanUtils() throws HuatengException {
        // 这里一定要注册默认值，使用null也可以
        try {
            BigDecimalConverter bd = new BigDecimalConverter(BIGDECIMAL_ZERO);
            ConvertUtils.register(bd, java.math.BigDecimal.class);
        } catch (Exception ex) {
            throw new HuatengException("设置BeanUtils转化器失败", ex);
        }
    }

    protected void setUserStatus() throws CommonException {
        if (SystemDProperty.isProductionMode()) {
            UserMgrService.getInstance().setUserLoginOut();
        }
    }

}

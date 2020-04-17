package com.huateng.boa.log4j.monitor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.boa.enterprise.instrumentation.core.types.NameValue;
import com.boa.enterprise.instrumentation.core.types.Result;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.utils.LogExceptionUtils;

public class CustLogMonitorService {
    private static Logger logger = LogManager.getLogger(CustLogMonitorService.class);

    public synchronized static CustLogMonitorService getInstance() {
        return (CustLogMonitorService) ApplicationContextUtils.getBean(CustLogMonitorService.class.getName());
    }

    public void BOALogMonitorConfidential(HttpServletRequest request, String tlrno, String action,
            List<String> confidentialDataLabels, int confidentialRecordCount, Result result, String errorMessage) {
        BOALogMonitor(request, tlrno, action, confidentialDataLabels, confidentialRecordCount, null, result, null);
    }

    public void BOALogMonitorProprierary(HttpServletRequest request, String tlrno, String action,
            List<List<NameValue>> proprieraryDataResords, Result result, String errorMessage) {
        BOALogMonitor(request, tlrno, action, null, 0, proprieraryDataResords, result, null);
    }

    public void BOALogMonitor(HttpServletRequest request, String tlrno, String action,
            List<String> confidentialDataLabels, int confidentialRecordCount,
            List<List<NameValue>> proprieraryDataResords, Result result, String errorMessage) {

        try {
            Class<?> UserActivityEvent = Class.forName("com.boa.enterprise.instrumentation.core.UserActivityEvent");

            java.lang.reflect.Method method = UserActivityEvent.getMethod("create", String.class, String.class,
                    String.class, String.class, String.class, String.class, String.class, String.class, Iterable.class,
                    int.class, Iterable.class, int.class, Result.class, String.class);
            int proprieraryDataResordCount = 0;
            if (proprieraryDataResords != null) {
                proprieraryDataResordCount = proprieraryDataResords.size();
            }
            Object o = method.invoke(null, tlrno, request.getRequestURI(), ResourceTypes.WEB_APP,
                    request.getServerName(), String.valueOf(request.getServerPort()), request.getScheme(),
                    request.getRemoteAddr(), action, confidentialDataLabels, confidentialRecordCount,
                    proprieraryDataResords, proprieraryDataResordCount, result, errorMessage);
            logger.log(Level.getLevel("COMPLIANCE"), o);

        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            logger.error(e);
        }

    }

}

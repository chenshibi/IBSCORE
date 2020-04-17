package com.huateng.report.utils;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
public class LogExceptionUtils {

	
    public static void logException(Logger logger, Exception e) {
        try {
            for (StackTraceElement ele : e.getStackTrace()) {
                logger.error("\tat " + ele.getClassName() + "." + ele.getMethodName() + "(" + ele.getFileName() + ":"
                        + ele.getLineNumber() + ")");
            }
        } catch (Exception ex) {
        	logger.error(e.getClass().getName() + ": " + e.getMessage().toString());
        }
    }

    public static void logException(org.apache.logging.log4j.Logger logger, Exception e) {
        try {
            for (StackTraceElement ele : e.getStackTrace()) {
                logger.error("\tat " + ele.getClassName() + "." + ele.getMethodName() + "(" + ele.getFileName() + ":"
                        + ele.getLineNumber() + ")");
            }
        } catch (Exception ex) {
        	logger.error(e.getClass().getName() + ": " + e.getMessage().toString());
        }
    }

    public static void logException(Log logger, Exception e) {
        try {
            for (StackTraceElement ele : e.getStackTrace()) {
                logger.error("\tat " + ele.getClassName() + "." + ele.getMethodName() + "(" + ele.getFileName() + ":"
                        + ele.getLineNumber() + ")");
            }
        } catch (Exception ex) {
        	logger.error(e.getClass().getName() + ": " + e.getMessage().toString());
        }
    }


}

package com.huateng.report.utils;

import java.io.File;

import org.apache.log4j.Logger;

public class FilePermissonUtils {
    private static final Logger log = Logger.getLogger(FilePermissonUtils.class);

    public static void setPermission755(String filename) {
        try {
            File file = new File(filename);
            file.setExecutable(true, false);
            file.setReadable(true, false);
            file.setWritable(true, true);
            System.out.println("change filename[" + filename + "] permission to 755.");
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

    public static void setPermission666(File file) {
        try {
            if (file == null) {
                log.error("file is null can not change permission to 644.");
                return;
            }
            if (file.exists() == false) {
                log.error("file not exist, can not change permission to 644.");
                return;
            }
            if (file.isDirectory()) {
                file.setExecutable(true, true);
            } else {
                file.setExecutable(false, false);
            }
            file.setReadable(true, false);
            file.setWritable(true, false);
            System.out.println("change filename[" + file.getPath() + "] permission to 644.");
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

    public static void setPermission666(String filename) {
        try {
            File file = new File(filename);
            if (file.exists() == false) {
                log.error("file not exist, can not change permission to 644.");
                return;
            }
            if (file.isDirectory()) {
                file.setExecutable(true, true);
            } else {
                file.setExecutable(false, false);
            }
            file.setReadable(true, false);
            file.setWritable(true, false);
            System.out.println("change filename[" + filename + "] permission to 644.");
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

    public static void setPermission644(File file) {
        try {
            if (file == null) {
                log.error("file is null can not change permission to 644.");
                return;
            }
            if (file.exists() == false) {
                log.error("file not exist, can not change permission to 644.");
                return;
            }
            if (file.isDirectory()) {
                file.setExecutable(true, true);
            } else {
                file.setExecutable(false, false);
            }
            file.setReadable(true, false);
            file.setWritable(true, true);
            System.out.println("change filename[" + file.getPath() + "] permission to 644.");
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

    public static void setPermission644(String filename) {
        try {
            File file = new File(filename);
            if (file.exists() == false) {
                log.error("file not exist, can not change permission to 644.");
                return;
            }
            if (file.isDirectory()) {
                file.setExecutable(true, true);
            } else {
                file.setExecutable(false, false);
            }
            file.setReadable(true, false);
            file.setWritable(true, true);
            System.out.println("change filename[" + filename + "] permission to 644.");
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        }
    }

}

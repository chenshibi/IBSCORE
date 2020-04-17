package com.huateng.report.databak.utils;

import java.io.File;
import java.text.DecimalFormat;

import com.huateng.report.utils.FilePermissonUtils;

public class ReportTableUtil {

    public static int getCycNum(int totalCount, int stepCount) {
        int num = totalCount / stepCount;
        if (totalCount % stepCount > 0) {
            num++;
        }
        return num;
    }

    public static String getDecimalFormatStr(int pre, int scl, Object tmp) {
        StringBuffer fm = new StringBuffer();
        for (int i = 1; i <= pre; i++) {
            fm.append("0");
            if (i == pre - scl) {
                fm.append(".");
            }
        }
        DecimalFormat dc = new DecimalFormat(fm.toString());
        return dc.format(tmp);
    }

    public static void createFilePath(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
            FilePermissonUtils.setPermission755(filePath);
        }
    }
}

package com.huateng.report.dataClean.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReportDataCleanUtil {

    public static String getCleanDate(String formate, int rdy) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, day - rdy);
        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.format(cal.getTime());
    }

    public static void main(String[] args) {
        ReportDataCleanResource.getInstance().getTableList();
    }
}

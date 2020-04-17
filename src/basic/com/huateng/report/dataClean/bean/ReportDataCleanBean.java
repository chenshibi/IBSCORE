package com.huateng.report.dataClean.bean;

import java.util.ArrayList;
import java.util.List;

public class ReportDataCleanBean {
    private String tableName;
    private int reservesDay;
    private String dateFormate;
    private String delSql;
    List<ReportDataCleanBean> detList = new ArrayList<ReportDataCleanBean>();

    public List<ReportDataCleanBean> getDetList() {
        return detList;
    }

    public void setDetList(List<ReportDataCleanBean> detList) {
        this.detList = detList;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getReservesDay() {
        return reservesDay;
    }

    public void setReservesDay(int reservesDay) {
        this.reservesDay = reservesDay;
    }

    public String getDateFormate() {
        return dateFormate;
    }

    public void setDateFormate(String dateFormate) {
        this.dateFormate = dateFormate;
    }

    public String getDelSql() {
        return delSql;
    }

    public void setDelSql(String delSql) {
        this.delSql = delSql;
    }

    public ReportDataCleanBean(String tableName, int reservesDay, String dateFormate, String delSql) {
        super();
        this.tableName = tableName;
        this.reservesDay = reservesDay;
        this.dateFormate = dateFormate;
        this.delSql = delSql;
    }

    public ReportDataCleanBean() {
        super();
        // TODO Auto-generated constructor stub
    }

}

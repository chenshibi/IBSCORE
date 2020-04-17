package com.huateng.report.databak.bean;

public class ReportTableBakBean {
    private String tableName;
    private int batchCount;
    private String batchCountSql;
    private String dataSql;
    private String delSql;

    public String getDelSql() {
        return delSql;
    }

    public void setDelSql(String delSql) {
        this.delSql = delSql;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getBatchCountSql() {
        return batchCountSql;
    }

    public void setBatchCountSql(String batchCountSql) {
        this.batchCountSql = batchCountSql;
    }

    public int getBatchCount() {
        return batchCount;
    }

    public void setBatchCount(int batchCount) {
        this.batchCount = batchCount;
    }

    public String getDataSql() {
        return dataSql;
    }

    public void setDataSql(String dataSql) {
        this.dataSql = dataSql;
    }

    public ReportTableBakBean() {
        super();
        // TODO Auto-generated constructor stub
    }

}

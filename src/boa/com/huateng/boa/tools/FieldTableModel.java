package com.huateng.boa.tools;

import javax.swing.table.AbstractTableModel;

public class FieldTableModel extends AbstractTableModel {

    public int rowCount = 0;
    public static String[] columnNames = {"表名", "列名", "查询条件", "条件类型", "结果列表", "明细页面", "DropDown"};

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int paramInt1, int paramInt2) {
        return null;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

}

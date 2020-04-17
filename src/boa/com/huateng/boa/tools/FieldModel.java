package com.huateng.boa.tools;

public class FieldModel {
    public String tableName;
    public String columnName;
    public String columnDesc;
    public boolean inWhere;
    public String whereType;
    public boolean inResult;
    public boolean inDetail;
    public String dropType;
    public String editType;
    public String dataType;
    public boolean isKey;

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean isKey) {
        this.isKey = isKey;
    }

    public int len;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isInWhere() {
        return inWhere;
    }

    public void setInWhere(boolean inWhere) {
        this.inWhere = inWhere;
    }

    public String getWhereType() {
        return whereType;
    }

    public void setWhereType(String whereType) {
        this.whereType = whereType;
    }

    public boolean isInResult() {
        return inResult;
    }

    public void setInResult(boolean inResult) {
        this.inResult = inResult;
    }

    public boolean isInDetail() {
        return inDetail;
    }

    public void setInDetail(boolean inDetail) {
        this.inDetail = inDetail;
    }

    public String getDropType() {
        return dropType;
    }

    public void setDropType(String dropType) {
        this.dropType = dropType;
    }

    public Object[] toArray() {
        Object[] objs = new Object[12];
        objs[0] = this.getTableName();
        objs[1] = this.getColumnName();
        objs[2] = this.getColumnDesc();
        objs[3] = this.isInWhere();
        objs[4] = this.getWhereType();
        objs[5] = this.isInResult();
        objs[6] = this.isInDetail();
        objs[7] = this.getEditType();
        objs[8] = this.getDataType();
        objs[9] = String.valueOf(this.getLen());
        objs[10] = this.getDropType();
        objs[11] = this.isKey();

        return objs;
    }

    public FieldModel toFieldModel(Object[] objs) {
        FieldModel field = new FieldModel();
        if (objs.length != 12) {
            return null;
        }
        field.setTableName(objs[0].toString());
        field.setColumnName(objs[1].toString());
        field.setColumnDesc(objs[2].toString());
        field.setInWhere(Boolean.valueOf(objs[3].toString()));
        field.setWhereType(objs[4].toString());
        field.setInResult(Boolean.valueOf(objs[5].toString()));
        field.setInDetail(Boolean.valueOf(objs[6].toString()));
        field.setEditType(objs[7].toString());
        field.setDataType(objs[8].toString());
        field.setDropType(objs[9].toString());
        field.setLen(Integer.parseInt(objs[10].toString()));
        field.setKey(Boolean.valueOf(objs[11].toString()));
        return field;
    }

}

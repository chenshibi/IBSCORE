package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.TableInfoPk;

public class BaseTableInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7122695882488126265L;
    public static String REF = "TableInfo";
    public static String PROP_ID = "id";// 表名、字段说明
    public static String PROP_COLUMNNAME = "columnName";// 字段名
    public static String PROP_DATA_LENGTH = "dataLength";// 数据长度
    public static String PROP_COLUMNTTYPE = "dataType";// 字段类型
    // wangjianda
    public static String PROP_TABLE_NAME = "tableName";
    public static String PROP_CLASS_NAME = "className";
    public static String PROP_ORDNUM = "ordnum";
    public static String PROP_ATTRIBUTE_NAME = "attributeName";
    public static String PROP_DATA_DIC = "dataDic";

    private TableInfoPk id;
    private String columnName;
    private String dataType;
    private String dataLength;
    // WANGJIANDA
    private String tableName;
    private String className;
    private String ordnum;
    private String attributeName;
    private String dataDic;
    // zqq
    private String twoSeven;
    private String isNotPk;

    public String getIsNotPk() {
        return isNotPk;
    }

    public void setIsNotPk(String isNotPk) {
        this.isNotPk = isNotPk;
    }

    public String getTwoSeven() {
        return twoSeven;
    }

    public void setTwoSeven(String twoSeven) {
        this.twoSeven = twoSeven;
    }

    public TableInfoPk getId() {
        return id;
    }

    public void setId(TableInfoPk id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dateType) {
        this.dataType = dateType;
    }

    public String getDataLength() {
        return dataLength;
    }

    public void setDataLength(String dateLength) {
        this.dataLength = dateLength;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getOrdnum() {
        return ordnum;
    }

    public void setOrdnum(String ordnum) {
        this.ordnum = ordnum;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getDataDic() {
        return dataDic;
    }

    public void setDataDic(String dataDic) {
        this.dataDic = dataDic;
    }

}

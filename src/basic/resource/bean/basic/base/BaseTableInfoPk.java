package resource.bean.basic.base;

import java.io.Serializable;

public class BaseTableInfoPk implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 2630799178701306838L;
    public static String REF = "TableInfoPK";
    public static String PROP_TABLENAME = "tableName";// 表名
    public static String PROP_COMMENTS = "comments";// 字段说明

    private String tableName;
    private String comments;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

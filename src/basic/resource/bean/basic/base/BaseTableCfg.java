package resource.bean.basic.base;

import java.io.Serializable;

public class BaseTableCfg implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4713257129824045827L;
    public static String REF = "TableCfg";
    public static String PROP_TABLE_NAME = "tableName";// 表名
    public static String PROP_REC_ID = "recId";// 表编号
    public static String PROP_TABLE_DESC = "tableDesc";// 表中文名称
    public static String PROP_CLASSFY_FLAG = "classfyFlag";// 标识，一般用于判断是否有补录人、审核人等
    // wangjiadna
    public static String PROP_CLASS_NAME = "className";
    public static String PROP_BUSINESS_FLAG = "businessflag";
    public static String PROP_PARENT_TBNAME = "parentTbName";
    private String tableName;
    private String recId;
    private String tableDesc;

    // wangjianda
    private String className;
    private String classfyFlag;
    private String businessflag;
    private String parentTbName;
    // zqq
    private String twoSeven;
    private String isOnlyone;

    public String getIsOnlyone() {
        return isOnlyone;
    }

    public void setIsOnlyone(String isOnlyone) {
        this.isOnlyone = isOnlyone;
    }

    public String getTwoSeven() {
        return twoSeven;
    }

    public void setTwoSeven(String twoSeven) {
        this.twoSeven = twoSeven;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public String getClassfyFlag() {
        return classfyFlag;
    }

    public void setClassfyFlag(String classfyFlag) {
        this.classfyFlag = classfyFlag;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBusinessflag() {
        return businessflag;
    }

    public void setBusinessflag(String businessflag) {
        this.businessflag = businessflag;
    }

    public String getParentTbName() {
        return parentTbName;
    }

    public void setParentTbName(String parentTbName) {
        this.parentTbName = parentTbName;
    }

}

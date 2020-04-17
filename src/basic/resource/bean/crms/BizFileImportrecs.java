package resource.bean.crms;

/**
 * @author Grassy
 * @date 2019/2/21 14:43
 * @jdk.version 1.8
 * @desc
 */
public class BizFileImportrecs {
    /**
     * 主键
     */
    private String id;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 导入人
     */
    private String importedBy;
    /**
     * 导入时间
     */
    private String importedDateTime;
    /**
     * 文件总记录数
     */
    private String totalRecords;
    /**
     * 导入成功记录数
     */
    private String successRecords;
    /**
     * 导入失败记录数
     */
    private String failRecords;
    /**
     * 数据导入状态
     */
    private String flag;
    /**
     * 导入处理错误结果文件名
     */
    private String errorFilename;
    /**
     * 导入处理错误结果文件存放路径
     */
    private String errorFilepath;
    /**
     * 文件导入方式 0：手工EXCEL 1：后台文件
     */
    private String importType;

    /**
     * 文件记录类型 0：个人批次 1：企业批次
     */
    private String recordType;
    /**
     * 备用字段
     */
    private String rsv1;
    private String rsv2;
    private String rsv3;
    private String rsv4;
    private String rsv5;
    private String rsv6;
    private String rsv7;
    private String rsv8;
    private String rsv9;
    private String rsv10;

    public String getRsv1() {
        return rsv1;
    }

    public void setRsv1(String rsv1) {
        this.rsv1 = rsv1;
    }

    public String getRsv2() {
        return rsv2;
    }

    public void setRsv2(String rsv2) {
        this.rsv2 = rsv2;
    }

    public String getRsv3() {
        return rsv3;
    }

    public void setRsv3(String rsv3) {
        this.rsv3 = rsv3;
    }

    public String getRsv4() {
        return rsv4;
    }

    public void setRsv4(String rsv4) {
        this.rsv4 = rsv4;
    }

    public String getRsv5() {
        return rsv5;
    }

    public void setRsv5(String rsv5) {
        this.rsv5 = rsv5;
    }

    public String getRsv6() {
        return rsv6;
    }

    public void setRsv6(String rsv6) {
        this.rsv6 = rsv6;
    }

    public String getRsv7() {
        return rsv7;
    }

    public void setRsv7(String rsv7) {
        this.rsv7 = rsv7;
    }

    public String getRsv8() {
        return rsv8;
    }

    public void setRsv8(String rsv8) {
        this.rsv8 = rsv8;
    }

    public String getRsv9() {
        return rsv9;
    }

    public void setRsv9(String rsv9) {
        this.rsv9 = rsv9;
    }

    public String getRsv10() {
        return rsv10;
    }

    public void setRsv10(String rsv10) {
        this.rsv10 = rsv10;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getImportedBy() {
        return importedBy;
    }

    public void setImportedBy(String importedBy) {
        this.importedBy = importedBy;
    }

    public String getImportedDateTime() {
        return importedDateTime;
    }

    public void setImportedDateTime(String importedDateTime) {
        this.importedDateTime = importedDateTime;
    }

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getSuccessRecords() {
        return successRecords;
    }

    public void setSuccessRecords(String successRecords) {
        this.successRecords = successRecords;
    }

    public String getFailRecords() {
        return failRecords;
    }

    public void setFailRecords(String failRecords) {
        this.failRecords = failRecords;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getErrorFilename() {
        return errorFilename;
    }

    public void setErrorFilename(String errorFilename) {
        this.errorFilename = errorFilename;
    }

    public String getErrorFilepath() {
        return errorFilepath;
    }

    public void setErrorFilepath(String errorFilepath) {
        this.errorFilepath = errorFilepath;
    }

    public String getImportType() {
        return importType;
    }

    public void setImportType(String importType) {
        this.importType = importType;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }



}

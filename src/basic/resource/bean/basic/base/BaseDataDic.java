package resource.bean.basic.base;

import java.io.Serializable;

import resource.bean.basic.DataDic;

/**
 * This is an object that contains data related to the DATA_DIC table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="DATA_DIC"
 */

public abstract class BaseDataDic implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5860874671596168425L;
    public static String REF = "DataDic";
    public static String PROP_HIGH_LIMIT = "highLimit";
    public static String PROP_EFFECT_DATE = "effectDate";
    public static String PROP_DATA_NAME = "dataName";
    public static String PROP_MISCFLGS = "miscflgs";
    public static String PROP_DATA_TYPE_NO = "dataTypeNo";
    public static String PROP_DATA_TYPE_NAME = "dataTypeName";
    public static String PROP_LOW_LIMIT = "lowLimit";
    public static String PROP_EXPIRE_DATE = "expireDate";
    public static String PROP_TIMESTAMPS = "timestamps";
    public static String PROP_ID = "id";
    public static String PROP_LIMIT_FLAG = "limitFlag";
    public static String PROP_DATA_NO = "dataNo";
    public static String PROP_DATA_NO_LEN = "dataNoLen";
    public static String PROP_APPROVE_STATUS = "approveStatus";
    public static String PROP_APPROVE_RESULT = "approveResult";
    public static String PROP_YWDATE = "ywdate";
    public static String PROP_BR_NO = "brNo";
    public static String PROP_APPTYPE = "apptype";
    public static String PROP_LST_UPD_TLR = "lstUpdTlr";
    public static String PROP_LST_UPD_TM = "lstUpdTm";
    public static String PROP_CRT_TM = "crtTm";
    public static String PROP_SUB_SUCCESS = "subSuccess";
    public static String PROP_REP_STATUS = "repStatus";
    public static String PROP_REC_STATUS = "recStatus";
    public static String PROP_ORGCODE = "orgcode";
    public static String PROP_RECORD_UPD_TLR = "RecordUpdTlr";
    public static String PROP_RECORD_UPD_TM = "RecordUpdTm";

    // constructors
    public BaseDataDic() {
        initialize();
    }

    /**
     * Constructor for primary key
     */
    public BaseDataDic(java.lang.Integer id) {
        this.setId(id);
        initialize();
    }

    /**
     * Constructor for required fields
     */
    public BaseDataDic(java.lang.Integer id, java.lang.Integer dataTypeNo, java.lang.String dataNo) {

        this.setId(id);
        this.setDataTypeNo(dataTypeNo);
        this.setDataNo(dataNo);
        initialize();
    }

    protected void initialize() {
    }

    private int hashCode = Integer.MIN_VALUE;

    // primary key
    private java.lang.Integer id;

    // fields
    private java.lang.Integer dataTypeNo;
    private java.lang.String dataNo;
    private java.lang.String dataTypeName;
    private java.lang.Integer dataNoLen;
    private java.lang.String dataName;
    private java.lang.String limitFlag;
    private java.lang.String highLimit;
    private java.lang.String lowLimit;
    private java.lang.String effectDate;
    private java.lang.String expireDate;
    private java.lang.String timestamps;
    private java.lang.String miscflgs;
    private java.lang.String approveStatus;
    private java.lang.String approveResult;
    private java.lang.String brNo;
    private java.lang.String ywdate;
    private java.lang.String recStatus;
    private java.lang.String repStatus;
    private java.lang.String subSuccess;
    private java.lang.String crtTm;
    private java.lang.String lstUpdTm;
    private java.lang.String lstUpdTlr;
    private java.lang.String apptype;
    private java.lang.String orgcode;
    private java.lang.String recordUpdTlr;
    private java.lang.String recordUpdTm;
    private java.lang.String st;

    public java.lang.String getSt() {
        return st;
    }

    public void setSt(java.lang.String st) {
        this.st = st;
    }

    public java.lang.String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(java.lang.String orgcode) {
        this.orgcode = orgcode;
    }

    /**
     * Return the value associated with the column: BR_NO
     */
    public java.lang.String getBrNo() {
        return brNo;
    }

    /**
     * Set the value related to the column: BR_NO
     * 
     * @param brNo
     *            the BR_NO value
     */
    public void setBrNo(java.lang.String brNo) {
        this.brNo = brNo;
    }

    public java.lang.String getRecordUpdTlr() {
        return recordUpdTlr;
    }

    public void setRecordUpdTlr(java.lang.String recordUpdTlr) {
        this.recordUpdTlr = recordUpdTlr;
    }

    public java.lang.String getRecordUpdTm() {
        return recordUpdTm;
    }

    public void setRecordUpdTm(java.lang.String recordUpdTm) {
        this.recordUpdTm = recordUpdTm;
    }

    /**
     * Return the value associated with the column: YWDATE
     */
    public java.lang.String getYwdate() {
        return ywdate;
    }

    /**
     * Set the value related to the column: YWDATE
     * 
     * @param ywdate
     *            the YWDATE value
     */
    public void setYwdate(java.lang.String ywdate) {
        this.ywdate = ywdate;
    }

    /**
     * Return the value associated with the column: REC_STATUS
     */
    public java.lang.String getRecStatus() {
        return recStatus;
    }

    /**
     * Set the value related to the column: REC_STATUS
     * 
     * @param recStatus
     *            the REC_STATUS value
     */
    public void setRecStatus(java.lang.String recStatus) {
        this.recStatus = recStatus;
    }

    /**
     * Return the value associated with the column: REP_STATUS
     */
    public java.lang.String getRepStatus() {
        return repStatus;
    }

    /**
     * Set the value related to the column: REP_STATUS
     * 
     * @param repStatus
     *            the REP_STATUS value
     */
    public void setRepStatus(java.lang.String repStatus) {
        this.repStatus = repStatus;
    }

    /**
     * Return the value associated with the column: IS_SUB_SUCCESS
     */
    public java.lang.String getSubSuccess() {
        return subSuccess;
    }

    /**
     * Set the value related to the column: IS_SUB_SUCCESS
     * 
     * @param subSuccess
     *            the IS_SUB_SUCCESS value
     */
    public void setSubSuccess(java.lang.String subSuccess) {
        this.subSuccess = subSuccess;
    }

    /**
     * Return the value associated with the column: CRT_TM
     */
    public java.lang.String getCrtTm() {
        return crtTm;
    }

    /**
     * Set the value related to the column: CRT_TM
     * 
     * @param crtTm
     *            the CRT_TM value
     */
    public void setCrtTm(java.lang.String crtTm) {
        this.crtTm = crtTm;
    }

    /**
     * Return the value associated with the column: LST_UPD_TM
     */
    public java.lang.String getLstUpdTm() {
        return lstUpdTm;
    }

    /**
     * Set the value related to the column: LST_UPD_TM
     * 
     * @param lstUpdTm
     *            the LST_UPD_TM value
     */
    public void setLstUpdTm(java.lang.String lstUpdTm) {
        this.lstUpdTm = lstUpdTm;
    }

    /**
     * Return the value associated with the column: LST_UPD_TLR
     */
    public java.lang.String getLstUpdTlr() {
        return lstUpdTlr;
    }

    /**
     * Set the value related to the column: LST_UPD_TLR
     * 
     * @param lstUpdTlr
     *            the LST_UPD_TLR value
     */
    public void setLstUpdTlr(java.lang.String lstUpdTlr) {
        this.lstUpdTlr = lstUpdTlr;
    }

    /**
     * Return the value associated with the column: APPTYPE
     */
    public java.lang.String getApptype() {
        return apptype;
    }

    /**
     * Set the value related to the column: APPTYPE
     * 
     * @param apptype
     *            the APPTYPE value
     */
    public void setApptype(java.lang.String apptype) {
        this.apptype = apptype;
    }

    /**
     * Return the value associated with the column: Approve_Status
     */
    public java.lang.String getApproveStatus() {
        return approveStatus;
    }

    /**
     * Set the value related to the column: Approve_Status
     * 
     * @param code
     *            the Approve_Status value
     */
    public void setApproveStatus(java.lang.String approveStatus) {
        this.approveStatus = approveStatus;
    }

    /**
     * Return the value associated with the column: Approve_Result
     */
    public java.lang.String getApproveResult() {
        return approveResult;
    }

    /**
     * Set the value related to the column: Approve_Result
     * 
     * @param code
     *            the Approve_Result value
     */
    public void setApproveResult(java.lang.String approveResult) {
        this.approveResult = approveResult;
    }

    /**
     * Return the unique identifier of this class
     * 
     * @hibernate.id generator-class="sequence" column="ID"
     */
    public java.lang.Integer getId() {
        return id;
    }

    /**
     * Set the unique identifier of this class
     * 
     * @param id
     *            the new ID
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
        this.hashCode = Integer.MIN_VALUE;
    }

    /**
     * Return the value associated with the column: DATA_TYPE_NO
     */
    public java.lang.Integer getDataTypeNo() {
        return dataTypeNo;
    }

    /**
     * Set the value related to the column: DATA_TYPE_NO
     * 
     * @param dataTypeNo
     *            the DATA_TYPE_NO value
     */
    public void setDataTypeNo(java.lang.Integer dataTypeNo) {
        this.dataTypeNo = dataTypeNo;
    }

    /**
     * Return the value associated with the column: DATA_NO
     */
    public java.lang.String getDataNo() {
        return dataNo;
    }

    /**
     * Set the value related to the column: DATA_NO
     * 
     * @param dataNo
     *            the DATA_NO value
     */
    public void setDataNo(java.lang.String dataNo) {
        this.dataNo = dataNo;
    }

    /**
     * Return the value associated with the column: DATA_TYPE_NAME
     */
    public java.lang.String getDataTypeName() {
        return dataTypeName;
    }

    /**
     * Set the value related to the column: DATA_TYPE_NAME
     * 
     * @param dataTypeName
     *            the DATA_TYPE_NAME value
     */
    public void setDataTypeName(java.lang.String dataTypeName) {
        this.dataTypeName = dataTypeName;
    }

    /**
     * Return the value associated with the column: DATA_NO_LEN
     */
    public java.lang.Integer getDataNoLen() {
        return dataNoLen;
    }

    /**
     * Set the value related to the column: DATA_NO_LEN
     * 
     * @param dataNoLen
     *            the DATA_NO_LEN value
     */
    public void setDataNoLen(java.lang.Integer dataNoLen) {
        this.dataNoLen = dataNoLen;
    }

    /**
     * Return the value associated with the column: DATA_NAME
     */
    public java.lang.String getDataName() {
        return dataName;
    }

    /**
     * Set the value related to the column: DATA_NAME
     * 
     * @param dataName
     *            the DATA_NAME value
     */
    public void setDataName(java.lang.String dataName) {
        this.dataName = dataName;
    }

    /**
     * Return the value associated with the column: LIMIT_FLAG
     */
    public java.lang.String getLimitFlag() {
        return limitFlag;
    }

    /**
     * Set the value related to the column: LIMIT_FLAG
     * 
     * @param limitFlag
     *            the LIMIT_FLAG value
     */
    public void setLimitFlag(java.lang.String limitFlag) {
        this.limitFlag = limitFlag;
    }

    /**
     * Return the value associated with the column: HIGH_LIMIT
     */
    public java.lang.String getHighLimit() {
        return highLimit;
    }

    /**
     * Set the value related to the column: HIGH_LIMIT
     * 
     * @param highLimit
     *            the HIGH_LIMIT value
     */
    public void setHighLimit(java.lang.String highLimit) {
        this.highLimit = highLimit;
    }

    /**
     * Return the value associated with the column: LOW_LIMIT
     */
    public java.lang.String getLowLimit() {
        return lowLimit;
    }

    /**
     * Set the value related to the column: LOW_LIMIT
     * 
     * @param lowLimit
     *            the LOW_LIMIT value
     */
    public void setLowLimit(java.lang.String lowLimit) {
        this.lowLimit = lowLimit;
    }

    /**
     * Return the value associated with the column: EFFECT_DATE
     */
    public java.lang.String getEffectDate() {
        return effectDate;
    }

    /**
     * Set the value related to the column: EFFECT_DATE
     * 
     * @param effectDate
     *            the EFFECT_DATE value
     */
    public void setEffectDate(java.lang.String effectDate) {
        this.effectDate = effectDate;
    }

    /**
     * Return the value associated with the column: EXPIRE_DATE
     */
    public java.lang.String getExpireDate() {
        return expireDate;
    }

    /**
     * Set the value related to the column: EXPIRE_DATE
     * 
     * @param expireDate
     *            the EXPIRE_DATE value
     */
    public void setExpireDate(java.lang.String expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * Return the value associated with the column: TIMESTAMPS
     */
    public java.lang.String getTimestamps() {
        return timestamps;
    }

    /**
     * Set the value related to the column: TIMESTAMPS
     * 
     * @param timestamps
     *            the TIMESTAMPS value
     */
    public void setTimestamps(java.lang.String timestamps) {
        this.timestamps = timestamps;
    }

    /**
     * Return the value associated with the column: MISCFLGS
     */
    public java.lang.String getMiscflgs() {
        return miscflgs;
    }

    /**
     * Set the value related to the column: MISCFLGS
     * 
     * @param miscflgs
     *            the MISCFLGS value
     */
    public void setMiscflgs(java.lang.String miscflgs) {
        this.miscflgs = miscflgs;
    }

    public boolean equals(Object obj) {
        if (null == obj)
            return false;
        if (!(obj instanceof DataDic))
            return false;
        else {
            DataDic dataDic = (DataDic) obj;
            if (null == this.getId() || null == dataDic.getId())
                return false;
            else
                return (this.getId().equals(dataDic.getId()));
        }
    }

    public int hashCode() {
        if (Integer.MIN_VALUE == this.hashCode) {
            if (null == this.getId())
                return super.hashCode();
            else {
                String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
                this.hashCode = hashStr.hashCode();
            }
        }
        return this.hashCode;
    }

    public String toString() {
        return super.toString();
    }

}
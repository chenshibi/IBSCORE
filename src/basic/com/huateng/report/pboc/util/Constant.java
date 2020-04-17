package com.huateng.report.pboc.util;

/**
 * @author Grassy
 * @date 2019/2/21 14:54
 * @jdk.version 1.8
 * @desc
 */
public class Constant {
    /**
     * 单个导入文件的最大笔数 5万笔
     */
    public static final int IMPORTDATA_MAXROWS = 50000;
    /**
     * 文件新上传服务器,未处理状态
     */
    public static final String FLAG_NEW = "0";
    /**
     * 正在将文件内容导入数据库
     */
    public static final String FLAG_DOING = "2";
    /**
     * 文件内容已经导入数据库
     */
    public static final String FLAG_DO_END = "1";
    /**
     * 手工上传EXCEL
     */
    public static final String UPLOAD_EXCEL = "0";
    /**
     * 后台上传EXCEL
     */
    public static final String CRONT_EXCEL = "1";
    /**
     * 上传个人文件
     */
    public static final String UPLOAD_PERSONAL_FILE="0";
    /**
     * 上传企业文件
     */
    public static final String UPLOAD_CORP_FILE="1";
    /**
     * 征信查询录入
     */
    public static final String ADD_QUERY_STATUS="00";
    /**
     * 征信查询审核通过
     */
    public static final String APPROVE_QUERY_STATUS="01";
    /**
     * 征信查询审核拒绝
     */
    public static final String REJECT_QUERY_STATUS="02";
    /**
     * 征信查询成功状态
     */
    public static final String RESP_QUERY_STATUS="03";
    /**
     * 征信查询失败状态
     */
    public static final String FAIL_QUERY_STATUS="04";
    /**
     * 授予证书权限
     */
    public static final String SUCC_GRANT_CERT_AUTH="05";
    /**
     * 状态过期
     */
    public static final String EXPIRED_STATUS="06";

    public static final String IS_TRUE="Y";

    public static final String IS_FALSE="N";
    
    public static final String CR_COM_EAA="1";
    
    public static final String CR_COM_EA01CH="2";
    
    public static final String CR_COM_ECA="3";
    
    public static final String CR_COM_EC020H="4";
    
    public static final String CR_COM_EC030H="5";
    
    public static final String CR_COM_EC050H="6";
    
    public static final String PERSON_FILE_TYPE="个人征信授权书";
    
    public static final String CORP_FILE_TYPE="企业征信授权书";
    
    public static final String WUHAN="Wuhan";
    
    public static final String MSG_FLAG="B";
    
    public static final String MSG_TYPE="R103";
    
    public static final String RESERVED_FIELD="0000000000";

}

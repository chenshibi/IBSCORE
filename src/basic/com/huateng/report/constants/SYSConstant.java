package com.huateng.report.constants;

public class SYSConstant {

    public static final char FULL_SPACE = ((char) 12288);


    public static final String REPORT_UNKNOW_VALUE = "@N";

    public static final String DEPARTMENT_GMO = "GMO";
    public static final String DEPARTMENT_GTS = "GTS";
    public static final String DEPARTMENT_GFCC = "GFCC";

    public static final String OPERATION_TYPE_ADD = "01";
    public static final String OPERATION_TYPE_MOD = "02";
    public static final String OPERATION_TYPE_DEL = "03";

    public static final String OPERATION_STATUS_PENDING = "00";
    public static final String OPERATION_STATUS_APPROVE = "01";
    public static final String OPERATION_STATUS_REJECT = "02";

    public static final String OPERATION_ACT_MAKE = "MAKE";
    public static final String OPERATION_ACT_CHECK = "CHECK";
    public static final String OPERATION_ACT_RECHECK="RECHECK";

    public static final String OPERATION_OP_SOURCE_1_NORMAL = "1";
    public static final String OPERATION_OP_SOURCE_2_HVPS = "2";
    public static final String OPERATION_OP_SOURCE_3_HISTORY = "3";
    public static final String OPERATION_OP_SOURCE_4_KEYI = "4";


    public static final String OPERATION_ACT_CHECK_APPROVE = "APPROVE";
    public static final String OPERATION_ACT_CHECK_REJECT = "REJECT";
    public static final String OPERATION_HISTORY = "History";
    public static final String OPERATION_NO_HISTORY = "NoHistory";

    public static final String OPERATION_BATCH = "Batch";
    public static final String OPERATION_NO_BATCH = "NoBatch";


    /**
     * N0-正常新增
     * N1-手工新增
     * D0-单笔删除
     * D1-批量删除
     * C0-交易补正
     * C1-交易修改
     * C2-信息更正
     * C2-交易纠错
     */
    public static final String REPORT_TYPE_HVPS_N0_NORMAL_ADD = "N0";
    public static final String REPORT_TYPE_HVPS_N1_MANUAL_ADD = "N1";
    public static final String REPORT_TYPE_HVPS_D0_SINGLE_DELETE = "D0";
    public static final String REPORT_TYPE_HVPS_D1_BATCH_DELETE = "D1";
    public static final String REPORT_TYPE_HVPS_C0_BUZHENG = "C0";
    public static final String REPORT_TYPE_HVPS_C1_XIUGAI = "C1";
    public static final String REPORT_TYPE_HVPS_C2_GENGZHENG = "C2";
    public static final String REPORT_TYPE_HVPS_C3_JIUCUO = "C3";

    public static final String REPORT_TYPE_HVPS_N_ADD = "N";

    /**
     * SN0-可疑追加
     * SN1-可疑新增
     * SC0-可疑主动纠错
     * SC1-可疑补正
     * SC2-可疑修改
     * SC3-可疑信息更正
     * B-信息补充
     */

    public static final String REPORT_TYPE_SUSP_SN0_ZHUIJIA = "SN0";
    public static final String REPORT_TYPE_SUSP_SN1_XINZENG = "SN1";
    public static final String REPORT_TYPE_SUSP_SC0_JIUCUO = "SC0";
    public static final String REPORT_TYPE_SUSP_SC1_BUZHENG = "SC1";
    public static final String REPORT_TYPE_SUSP_SC2_XIUGAI = "SC2";
    public static final String REPORT_TYPE_SUSP_SC3_GENGZHENG = "SC3";
    public static final String REPORT_TYPE_SUSP_B_BUCHONG = "B";

    public static final String CHECK_STATUS_0_PENDING = "0";
    public static final String CHECK_STATUS_1_APPROVED = "1";
    public static final String CHECK_STATUS_2_REJECTED = "2";


    public static final String REPORT_STATUS_10_UNREPORT = "10";
    public static final String REPORT_STATUS_11_GENERATED = "11";
    public static final String REPORT_STATUS_01_SUBMITED = "01";

    //上报成功
    public static final String REPORT_STATUS_02_SUCCESS = "02";
    //待补正
    public static final String REPORT_STATUS_03_PRE_BUZHENG = "03";
    //待修改
    public static final String REPORT_STATUS_04_PRE_XIUGAI = "04";
    //待更正
    public static final String REPORT_STATUS_05_PRE_GENGZHENG = "05";
    //删除待确认
    public static final String REPORT_STATUS_06_PRE_DEL = "06";
    //已删除
    public static final String REPORT_STATUS_07_ALREADY_DEL = "07";
    //主动纠错待确认
    public static final String REPORT_STATUS_08_PRE_JIUCUO = "08";

    /**
     * 报送类型
     * 01-大额
     * 02-可疑
     */
    public static final String REPORT_TYPE_01_HVPS = "01";
    public static final String REPORT_TYPE_02_SUSP = "02";


    /**
     * 00-交易导入 02-交易补录审核 03-数据分析 06-上报文件生成 07-工作日期切换
     * 01-交易补录 02-交易审核 合并成02-交易补录审核
     * 04-上报确认录入 05-上报确认审核 这两个步骤废弃
     */
    public static final String SYSTEM_STATUS_TXN_IMPORT = "00";
    public static final String SYSTEM_STATUS_TXN_MAKE = "01";
    public static final String SYSTEM_STATUS_TXN_CHECK = "02";
    public static final String SYSTEM_STATUS_DATA_ANALYSE = "03";
    public static final String SYSTEM_STATUS_REPORT_MAKE = "04";
    public static final String SYSTEM_STATUS_REPORT_CHECK = "05";
    public static final String SYSTEM_STATUS_REPORT_GENERATE = "06";
    public static final String SYSTEM_STATUS_DATE_SWITCH = "07";

    public static final String STEP_STATUS_UNCOMPLETED = "00";
    public static final String STEP_STATUS_COMPLETED = "01";

    public static final String SYSTEM_ACTION_TO_DO = "0";
    public static final String SYSTEM_ACTION_DOING = "1";
    public static final String SYSTEM_ACTION_DONE = "2";
    public static final String SYSTEM_ACTION_FAILED = "3";
    public static final String SYSTEM_ACTION_CHECK = "4";

    public static final String SYSTEM_OPERATOR = "SYS9999";

    public static final String CHINA_NATION_CODE = "CHN";
    public static final String FOREIGN_AREA_CODE = "000000";
    //角色状态-有效
    public static final String ROLE_STATUS = "1";

    // 应用类型AML-文件类型 BH 大额数据报告
    /**
     * 应用类型AML-文件类型 BH 大额数据报告
     **/
    public static final String REPORT_FILE_TYPE_AML_BH = "BH";
    // 应用类型AML-文件类型 BS 可疑数据报告
    /**
     * 应用类型AML-文件类型 BS 可疑数据报告
     **/
    public static final String REPORT_FILE_TYPE_AML_BS = "BS";

    /* 已导入未解析 */
    public static final String SOURCE_FILE_STATUS_IMPORTED = "00";
    /* 解析成功 */
    public static final String SOURCE_FILE_STATUS_PARSE_OK = "01";
    /* 解析失败 */
    public static final String SOURCE_FILE_STATUS_PARSE_FAILED = "02";

    /* 未导入交易表 */
    public static final String SOURCE_DTL_STATUS_LOAD = "00";
    /* 导入交易表成功 */
    public static final String SOURCE_DTL_STATUS_LOAD_OK = "01";
    /* 导入交易表失败 */
    public static final String SOURCE_DTL_STATUS_LOAD_FAILED = "02";


    /**
     * 上报类型  xml大额的普通报文
     */
    public static final String REPORT_XMLTYPE_BH_N = "NBH";
    /**
     * 上报类型  xml大额的纠错报文
     */
    public static final String REPORT_XMLTYPE_BH_C = "CBH";
    /**
     * 上报类型  xml大额的删除报文
     */
    public static final String REPORT_XMLTYPE_BH_D = "DBH";
    /**
     * 上报类型  xml可疑的普通报文
     */
    public static final String REPORT_XMLTYPE_BS_N = "NBS";
    /**
     * 上报类型  xml可疑的纠错报文
     */
    public static final String REPORT_XMLTYPE_BS_C = "CBS";

    /**
     * 上报类型  修改
     */
    public static final String REPORT_XMLTYPE_C = "C";


    /**
     * 单个XML文件的最大交易笔数在参数表中的参数名
     */
    public static final String AML_NBH_SUBMIT_GROUP_ID = "AML";
    public static final String AML_NBH_SUBMIT_XML_ID = "SUBMIT_XML";
    public static final String AML_NBH_SUBMIT_ZIP_ID = "SUBMIT";


    public static final int REPORT_NAME_TYPE_LEN = 3;
    public static final int REPORT_NAME_RICD_LEN = 14;
    public static final int REPORT_NAME_DATE_LEN = 8;
    public static final int REPORT_NAME_SEP_LEN = 1;

    public static final int REPORT_NAME_SEQ_INDEX = (REPORT_NAME_TYPE_LEN + REPORT_NAME_RICD_LEN + REPORT_NAME_SEP_LEN + REPORT_NAME_DATE_LEN + REPORT_NAME_SEP_LEN);
    public static final int REPORT_NAME_FIX_LENGTH = (REPORT_NAME_TYPE_LEN + REPORT_NAME_RICD_LEN + REPORT_NAME_SEP_LEN);


}

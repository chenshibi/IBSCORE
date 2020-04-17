package com.huateng.report.constants;

/**
 * 常量定义类
 * 
 * @author shishu.zhang
 *
 *         2012-8-14下午3:39:03
 */
public class CreditReportConstants {

    public static final String REPORT_REPAIR_TYPE_01 = "01";// 本系统修复

    public static final String REPORT_sh_0 = "0";// 处理中

    public static final String REPORT_RPTTYPE_1 = "1";// 待上报
    // 记录状态

    /**
     * rptType
     */
    public static final String REPORT_RPT_TYPE = "0";

    // 记录状态
    // 记录状态
    /** 记录状态 - 00 -已接收/已录入 **/
    public static final String REPORT_RECSTATUS_00 = "00";

    /** 记录状态 - 01 -待反馈/待发送 **/
    public static final String REPORT_RECSTATUS_01 = "01";

    /** 记录状态 - 02-反馈成功/发送成功 **/
    public static final String REPORT_RECSTATUS_02 = "02";

    /** 记录状态 - 03-反馈错误/发送错误 **/
    public static final String REPORT_RECSTATUS_03 = "03";

    /** 记录状态 - 05-校验不通过 **/
    public static final String REPORT_RECSTATUS_05 = "05";

    /** 记录状态 - 06-已生成文件 **/
    public static final String REPORT_RECSTATUS_06 = "06";

    /** 记录状态 - 07-已删除 **/
    public static final String REPORT_RECSTATUS_07 = "07";

    /** 记录状态 - 99-已过滤 **/
    public static final String REPORT_RECSTATUS_99 = "99";

    // 回执状态
    /** 回执状态 - 00-未返回 **/
    public static final String REPORT_REPSTATUS_00 = "00";

    /** 回执状态 - 01-回执成功 **/
    public static final String REPORT_REPSTATUS_01 = "01";

    /** 回执状态 - 02-回执失败 **/
    public static final String REPORT_REPSTATUS_02 = "02";

    // 审批状态
    /** 审批状态 - 00-未提交 **/
    public static final String REPORT_APPROVESTATUS_00 = "00";

    /** 审批状态 - 01-提交待审核 **/
    public static final String REPORT_APPROVESTATUS_01 = "01";

    /** 审批状态 - 02-审核通过 **/
    public static final String REPORT_APPROVESTATUS_02 = "02";

    /** 审批状态 - 03-审核不通过 **/
    public static final String REPORT_APPROVESTATUS_03 = "03";

    // 是否已成功上报 适用量化评分判断流程是否完成的标识
    /** 是否已成功上报 - 1 - 是 **/
    public static final String REPORT_IS_SUB_SUCCESS_YES = "1";

    /** 是否已成功上报 - 0 - 否 **/
    public static final String REPORT_IS_SUB_SUCCESS_NO = "0";

    // 数据上报方式
    /** 数据上报方式 - 01 - 生成上传 **/
    public static final String REPORT_SUB_FILE_TYPE_01 = "01";

    /** 数据上报方式 - 02 - 生成下载 **/
    public static final String REPORT_SUB_FILE_TYPE_02 = "02";

    // 两端核对记录状态
    /** 两端核对记录状态 - 01 -可编辑 **/
    public static final String CREDITCHECK_RECSTATUS_01 = "01";

    /** 两端核对记录状态 - 02-编辑待确认 **/
    public static final String CREDITCHECK_RECSTATUS_02 = "02";

    // 应用类型
    public static final String REPORT_APP_TYPE_FILE_01 = "01";// 个人征信
    public static final String REPORT_APP_TYPE_FILE_02 = "02";// 企业征信

}

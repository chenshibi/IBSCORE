/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 系统常量定义
 */
public class SystemConstant {

    /**
     * session ID的常量定义
     */
    public static final String WEB_SESSION_ID = "jsessionid";

    public static int TYPE_STRING = 1;
    public static int TYPE_DATE = 2;
    public static int TYPE_AMOUNT = 3;

    /** 操作日志参数 PF_SYS_PARAM ID */
    public static final String SYSPARAM_ID_BIZ_LOG = "BLOG";
    /** 是否需要记录操作日志 */
    public static final String MAGIC_ID_NEEDLOG = "NEEDLOG";
    /** 是否需要记录查询类日志 */
    public static final String MAGIC_ID_NEEDQUERYLOG = "NEEDQUERYLOG";

    public static final String CONTEXT_BIZ_LOG_MISC = "biz_log_misc"; // 用于记录流水的上下文键值

    public static final String BRCODE_CLASS_HEAD_CENTER = "A"; // 总行审批中心
    public static final String BRCODE_CLASS_NETBRANCH = "3"; // 网点
    public static final String BRCODE_CLASS_AREA_CENTER = "B"; // 区域审批中心

    /**
     * [流水日志用交易码表 交易类型 00-查询类 01-额度类 02-放款类 03-贷后管理类 04-客户管理类 99-系统管理类
     */
    public static final String BIZ_FUNC_TYPE_QUERY = "00";
    public static final String BIZ_FUNC_TYPE_CREDIT = "01";
    public static final String BIZ_FUNC_TYPE_GRANT_LOAN = "02";
    public static final String BIZ_FUNC_TYPE_POST_LOAN = "03";
    public static final String BIZ_FUNC_TYPE_CUSTMNG = "04";
    public static final String BIZ_FUNC_TYPE_SYSMNG = "99";

    /**
     * 是否标志
     */
    public static final String FLAG_OFF = "0"; // 否
    public static final String FLAG_ON = "1"; // 是

    /**
     * 有效标志/状态
     */
    public static final String VALID_FLAG_INVALID = "0"; // 无效
    public static final String VALID_FLAG_VALID = "1"; // 有效 modify by panghong
                                                       // 01 modify 1
    public static final String VALID_FLAG_FREEZE = "2"; // 冻结

    /**
     * 客户状态
     */
    public static final String CUSTOMRE_FLAG_INVALID = "0"; // 无效
    public static final String CUSTOMRE_FLAG_VALID = "1"; // 有效
    public static final String CUSTOMRE_FLAG_FREEZE = "2"; // 冻结

    /**
     * 业务类型
     */
    public static final String CINO_TYPE_PUB = "0";// 公共业务
    public static final String CINO_TYPE_CORP = "1";// 对公业务
    public static final String CINO_TYPE_INDV = "2";// 对私业务

    // 利率类型
    /**
     * 利率类型-年息(百分之)
     */
    public static final String RATE_TYPE_YEAR = "1"; // 年息
    /**
     * 利率类型-月息(千分之)
     */
    public static final String RATE_TYPE_MONTH = "2"; // 月息
    /**
     * 利率类型-日息(万分之)
     */
    public static final String RATE_TYPE_DAY = "3"; // 日息

    /**
     * 百分之
     */
    public static final String RATIO_TYPE_PERCENT = "1";
    /**
     * 利率类型-月息(千分之)
     */
    public static final String RATIO_TYPE_PER_THOUSAND = "2";
    /**
     * 利率类型-日息(万分之)
     */
    public static final String RATIO_TYPE_PER_TEN_THOUSAND = "3";

    /**
     * 14位 日期格式
     */
    public static final String TIME14_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME14_PATTERN2 = "yyyyMMddHHmmss";
    /**
     * 6位 日期格式
     */
    public static final String TIME6_PATTERN = "hh:mm:ss";

    /**
     * 币种
     */
    public static final String CURCD_RMB = "CNY"; // 人民币

    /**
     * 日期格式
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_PATTERN_2 = "yyyyMMdd";
    public static final String DATE_PATTERN_6 = "yyMMdd";

    // seqctl中的value_no
    public static final int VALUE_NO_APPNO = 1; // 申请编号
    public static final int VALUE_NO_CUSTCD = 2; // 客户编码

    public static final int VALUE_NO_CONTRACTNO = 3; // 合同
    public static final int VALUE_NO_PROJECTNO = 4; // 合作项目编号
    public static final int VALUE_NO_HOUSENO = 5; // 楼盘编号
    public static final int VALUE_NO_ACCUM_FUND_ACTNO = 6; // 公积金帐号
    public static final int VALUE_NO_ARCHIVE_ID = 7; // 档案要素编号
    public static final int VALUE_NO_WARNING_ID = 8; // 预警编号
    public static final int VALUE_NO_MORIIMPAWN_ID = 9;// 抵质压合同序号
    public static final int VALUE_NO_BRCODE = 10;// 机构编号
    public static final int VALUE_NO_COOP_PROTOCOLNO = 12; // 合作协议编号
    public static final int VALUE_NO_CORP_CREDIT_NO = 13; // 对公客户征信信息编号
    public static final int VALUE_NO_CORESYS = 50; // 核心交易请求流水号
    public static final int VALUE_NO_RULEFILE = 111; // 规则文件序号
    public static final int VALUE_NO_CREDITNO = 18; // 额度相关编号
    public static final int VALUE_NO_FRZNO = 19; // 额度冻结解冻顺序号
    public static final int VALUE_NO_LOANCENTER = 58;// 放款相关编号
    public static final int VALUE_NO_CREDITREALID = 67; // 额度使用明细-额度关联ID
    public static final int VALUE_NO_RULEID = 112; // 规则引擎表ID生成器

    public static final int VALUE_NO_NOTICENO = 113; // 审批通知书号

    public static final int VALUE_NO_MODEL_TYPE = 114; // 模型代码

    public static final String CREDIT_NOTICE_VALUE_INDEX = "creditnoticeno"; // 通知书编号VALUE_INDEX

    public static final String ACE_VALUE_INDEX = "ACE"; // 生成核心流水的VALUE_INDEX

    // 流程状态
    public static final String FLOW_STATUS_NOTUPLOAD = "0"; // 未上传
    public static final String FLOW_STATUS_INPROCESS = "1"; // 审批中
    public static final String FLOW_STATUS_REJECTED = "2"; // 已拒绝
    public static final String FLOW_STATUS_APPROVED = "3"; // 审批通过
    public static final String FLOW_STATUS_EXCEPTION = "4"; // 流程异常

    // seqctl中默认的value_index
    public static final String VALUE_INDEX = "00000000000000000000";

    // 公积金帐号科目(用于生成公积金帐号)
    public static final String ACCUM_FUND_ACNO = "0950";

    /**
     * 机构级别-BCTL.BRCLASS
     */
    public static final String BRCODE_CLASS_HEAD = "1"; // 1-总行
    public static final String BRCODE_CLASS_BRANCH = "2"; // 2-分行
    public static final String BRCODE_CLASS_SUBBRANCH = "5"; // 5-支行
    public static final String BRCODE_CLASS_MNGBRANCH = "3"; // 3-管理行
    public static final String BRCODE_CLASS_PL_CENTER = "3"; // 个贷中心
    public static final String BRCODE_CLASS_SUB_PL_CENTER = "5"; // 个贷分中心

    /**
     * 分行级别-BCTL.BLN_BRANCH_CLASS
     */
    public static final String BRCODE_BRANCH_CLASS_1 = "1";// 1-管理分行
    public static final String BRCODE_BRANCH_CLASS_2 = "2";// 2-直属行
    public static final String BRCODE_BRANCH_CLASS_3 = "3";// 3-辖属行

    /**
     * 报表机构级别 主要区分：直属行、省分行、省辖分行
     */
    public static final String RPT_BRCODE_CLASS_0 = "0";// 0-总行
    public static final String RPT_BRCODE_CLASS_1 = "1";// 1-省分行
    public static final String RPT_BRCODE_CLASS_2 = "2";// 2-直属行
    public static final String RPT_BRCODE_CLASS_3 = "3";// 3-辖属行
    public static final String RPT_BRCODE_CLASS_4 = "4";// 4-省辖分行
    public static final String RPT_BRCODE_CLASS_5 = "5";// 5-支行

    /**
     * 总行内部机构号
     */
    public static final String BRCODE_HEAD_9999 = "9999";// 总行内部机构号

    /**
     * 机构类别
     */
    public static final String BRTYPE_2 = "2"; // 国际业务部

    /**
     * 岗位名
     */
    public static final int ROLE_CUST_MANAGER = 100;// 客户经理
    public static final int ROLE_CUST_ZONGJINGLI = 105;// 总经理岗位
    public static final int ROLE_NPA_MANAGER = 121;// 资产保全管户岗

    /**
     * 审批意见
     */
    public static final String APP_ATTITUDE_AGREE = "1"; // 同意
    public static final String APP_ATTITUDE_DISAGREE = "2"; // 不同意
    public static final String APP_ATTITUDE_UNTREAD_NEXT = "3"; // 退回至前一级
    public static final String APP_ATTITUDE_UNTREAD = "4"; // 退回调查岗重审
    public static final String APP_ATTITUDE_UNTREAD_BACK = "5"; // 退回调查岗并返回退回者
    public static final String APP_ATTITUDE_CONDI_AGREE = "6"; // 有条件同意
    public static final String APP_ATTITUDE_AGREE_REPORT = "7"; // 审批同意上报

    /**
     * 权限检查结果（流程下一步走向）
     */
    public static final int APP_RESULT_REPORT = 0; // 审批上报
    public static final int APP_RESULT_PASS = 1; // 审批通过
    public static final int APP_RESULT_FAIL = 2; // 审批不通过
    public static final int APP_RESULT_UNTREAD = 3; // 审批退回

    /**
     * 客户类型
     */
    public static final String CUST_TYPE_ARTIFICIAL = "1"; // 法人
    public static final String CUST_TYPE_NATURAL = "2"; // 自然人
    public static final String CUST_TYPE_FINANCIAL = "3"; // 金融机构
    public static final String CUST_TYPE_ARTIFICIAL_AND_NATURAL = "0"; // 自然人和对公客户

    /**
     * 定期活期存款类别
     */
    public static final String ACTIVE_DEPOSIT = "0";// 活期
    public static final String AIRLINER_DEPOSIT = "0";// 定期
    public static final String AIRLINER_NOTIFY_DEPOSIT = "1";// 通知
    public static final String AIRLINER_PROTOCOL = "2";// 协议

    /**
     * 客户不良信息
     */
    public static final int CUST_INFRACT_NO = 4; // 客户不良信息序号

    // public static final String SCCBA_FILE_PATH =
    // "/home/sccba/finfo_t/upload/sccba";

    /**
     * 根据新规则生成合同号和从合同号时所用的机构号
     */
    public static final String CONTRACT_NO_BRNO = "010";// 机构号为合同签署机构代号，由3位阿拉伯数字组成，为010

    /**
     * 核心系统合同号长度
     */
    public static final int CONTRACTNO_LENGTH = 15;

    /**
     * 审批意见(新)
     */
    public static final String APP_ATTITUDE_AGREE_TO_NEXT = "0"; // 同意到下一步
    public static final String APP_ATTITUDE_AGREE_TO_SUBMIT = "1"; // 同意并上报
    public static final String APP_ATTITUDE_AGREE_TO_END = "2"; // 同意并结束流程
    public static final String APP_ATTITUDE_CONDI_AGREE_TO_NEXT = "3"; // 有条件同意到下一步
    public static final String APP_ATTITUDE_CONDI_AGREE_TO_SUBMIT = "4"; // 有条件同意并上报
    public static final String APP_ATTITUDE_DISAGREE_TO_NEXT = "5"; // 不同意并到下一步
    public static final String APP_ATTITUDE_DISAGREE_TO_END = "6"; // 不同意并结束流程
    public static final String APP_ATTITUDE_UNTREAD_TO_LAST = "7"; // 退回到上一步
    public static final String APP_ATTITUDE_UNTREAD_TO_BACK = "8"; // 退回到退回节点
    public static final String APP_ATTITUDE_TASK_FORWARD = "A"; // 任务移交

    /**
     * 单页最大记录数设置
     */
    public static final int MAX_ROWS = 20;

    /**
     * add by NT 2007-09-20 来源于交行个贷 缺省用户密码加密密钥
     */
    public static final String DEFAULT_PASSWORD_KEY = "Huateng.gd.Ocean's Fourteen.DWMNTH2CJFLCWL";

    /**
     * add by NT 2007-09-29 来源于交行个贷 缺省用户密码明文
     */
    public static final String DEFAULT_PASSWORD = "1qAZ@Wsx";

    /**
     * add by NT 2007-09-20 来源于交行个贷 柜员状态
     */
    public static final String TLR_NO_STATE_LOGOUT = "0"; // 签退

    public static final String TLR_NO_STATE_LOGIN = "1"; // 签到

    public static final String TLR_NO_STATE_QUIT = "2"; // 离职

    public static final String TLR_NO_STATE_LOKE = "3"; // X天未查询
    
    public static final String TLR_NO_STATE_SEARCH = "4"; // 当天查询量过多
    /**
     * 与核心交互的核心标准设置 0-不与核心交互false 1-与核心交互 true
     */

    public static final boolean CORE_GD_IS_FLAG = true;// 1-与核心交互 true
    public static final boolean CORE_GD_NOT_IS_FLAG = false;// 0-不与核心交互false

    /**
     * 年月天数转换标量
     */
    public static final int DAYS_NUM_OF_YEAR = 365; // 一年按365天算
    public static final int DAYS_NUM_OF_MONTH = 30; // 一月按30天算

    public static final String ADV_RTN_APPLYED = "0";// 提前还款提交
    public static final String ADV_RTN_APPROVED = "1";// 提前还款审批通过
    public static final String ADV_RTN_AUDITED = "2";// 提前还款复核通过
    public static final String ADV_RTN_REFUSED = "3";// 提前还款申请被拒绝
    public static final String ADV_RTN_CANCELED = "4";// 提前还款申请被撤回

    /**
     * 顺延方式
     */
    public static final String DELAYTYPE_1 = "1";// 系统自动调整顺延天数
    public static final String DELAYTYPE_2 = "2";// 用户自由指定顺延天数

    // add by kangbyron 2011-02-10 操作员审批默认阀值
    public static final String MAX_WL_DEFAULT = "10";

}
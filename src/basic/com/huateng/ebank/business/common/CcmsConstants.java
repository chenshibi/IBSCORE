package com.huateng.ebank.business.common;

@SuppressWarnings("ucd")
public class CcmsConstants {

    public final static String PRINTSTAT_PRTD = "PRTD";// 打印状态，已经打印
    public final static String PRINTSTAT_NOPT = "NOPT";// 打印状态，尚未打印
    public final static String PRINT_TYPE_ONLN = "ONLN";// 打印类型，在线打印
    // public final static String PRINT_TYPE_MBT = "MBT";// 打印类型，人工批量
    public final static String PRINT_TYPE_SBT = "SBT";// 打印类型，系统批量
    public final static String CHECK_STAT_APPL = "APPL";// 审核状态，已申请
    public final static String CHECK_STAT_CHK = "CHK";// 审核状态，已审批
    public final static String CHECK_STAT_DEFE = "DEFE";// 审核状态，已拒绝
    public final static String SYS_TYPE_BT = "BT";// 系统类型,批量
    public final static String SYS_TYPE_MAUL = "MAUL";// 系统类型,人工
    public final static String COLL_QUEUE_PRCD = "PRCD";// 催收队列,已处理
    public final static String COLL_QUEUE_NOPC = "NOPC";// 催收队列,未处理
    public final static String COLL_QUEUE_PROC = "PROC";// 催收队列,正在处理
    public final static String SEND_TYPE_SEND = "SEND";// 系统类型,人工
    public final static String SEND_TYPE_NOSN = "NOSN";// 系统类型,人工
    public final static String ACTION_CODE_CREDIT = "BR";// 催收动作,征信
    public final static String ACTION_CODE_SMS = "SMS";// 催收动作,短信
    public final static String ACTION_CODE_LETT = "LS";// 催收动作,信函
    public final static String ACTION_CODE_OA = "OA";// 催收动作,外包
    public final static String ACTION_CODE_CALLON = "SV";// 催收动作,外访
    public final static String ACTION_CODE_LEGAL = "LG";// 催收动作,法务
    public final static String ACTION_CODE_SURVEY = "SY";// 催收动作,案调
    public final static String ACTION_CODE_RV = "RV";// 催收动作,已复核
    public final static String ACTION_CODE_IR = "IR";// 催收动作,设跟催
    public final static String ACTION_CODE_TS = "TS";// 催收动作,定时
    public final static String ACTION_CODE_NOANSWER = "NA";// 催收动作,无应答
    public final static String ACTION_CODE_RR = "RR";// 催收动作，转至复核
    public final static String ACTION_CODE_DE = "DE";// 催收动作，虚拟进入
    public final static String ACTION_CODE_WO = "WO";// 催收动作，核销

    public final static String COL_CONSEQ_BUSY = "BUSY"; // 催收结果，忙音
    public final static String COL_CONSEQ_NOAN = "NOAN"; // 催收结果，无应答
    public final static String COL_CONSEQ_CONT = "CONT"; // 催收结果，接通
    public final static String COL_CONSEQ_APPL = "APPL"; // 催收结果，审核通过
    public final static String COL_CONSEQ_DEFE = "DEFE"; // 催收结果，审核通过

    public final static String COLL_STATE_OA = "OA";// 催收状态, 委外
    public final static String COLL_STATE_TEL = "TEL";// 催收状态, 电催
    public final static String COLL_STATE_RES = "RES";// 催收状态, 债务重组
    public final static String COLL_STATE_END = "END";// 催收状态, 结案

    public final static String YN_YES = "Y";
    public final static String YN_NO = "N";

    public final static String CREDIT_STAT_SUCC = "SUCC";// 征信状态，有结果
    public final static String CREDIT_STAT_PROC = "PROC";// 征信状态，征信中
    public final static String CREDIT_STAT_FAIL = "FAIL";// 征信状态，无结果

    public final static String CREDIT_TYPE_BANK = "BANK";// 征信类型,人行
    public final static String CREDIT_TYPE_POLI = "BANK";// 征信类型,公安

    public final static String OA_STAT_NOCA = "NOCA";// 外包状态,待非配
    public final static String OA_STAT_OA = "OA"; // 外包状态,已分配
    public final static String OA_STAT_REJT = "REJT";// 外包状态,已退案

    public final static String TPL_CHECK_MAUL = "人工审批"; // 模板审批标志,人工审批
    public final static String TPL_CHECK_AUTO = "自动审批"; // 模板审批标志,自动审批
    public final static String AUTO_CHECKER = "系统"; // 自动审批人

    public final static String RELATION_MUSR = "MUSR"; // 联系人类型: 本人

    public final static String COL_REC_TYPE_MAUL = "MAUL"; // 催收记录类型，人工

    public final static String STATUS_TYPE_CHK = "CHK"; // 案件状态类别，复核
    public final static String STATUS_TYPE_PTP = "PTP"; // 案件状态类别,PTP
    public final static String STATUS_TYPE_NEW = "NEW"; // 案件状态类别,新进
    public final static String STATUS_TYPE_WORK = "WORK"; // 案件状态类别,可操作
    public final static String STATUS_TYPE_UNWK = "UNWK"; // 案件状态类别,不可操作

    public final static String ASSG_TYPE_AMT = "AMT"; // 分配类型:按金额
    public final static String ASSG_TYPE_CNT = "CNT"; // 分配类型:按数量

    public final static String POSITION_NORM = "LA"; // 催收职位：普通
    public final static String POSITION_TEAM = "LB"; // 催收职位：组长

    public final static String SURVEY_RESULT_CONF = "CONF"; // 案调结果状态:确认
    public final static String SURVEY_RESULT_DIS = "DIS"; // 案调结果状态:否认
    public final static String SURVEY_RESULT_UNRS = "UNRS"; // 案调结果状态:无结果

    public final static String WO_CHECK_STAT_APPL = "WAPP";// 核销审核状态，已申请
    public final static String WO_CHECK_STAT_CHK_O = "WCKO";// 审核状态，初审通过
    public final static String WO_CHECK_STAT_DEFE_O = "WDEO";// 审核状态，初审拒绝
    public final static String WO_CHECK_STAT_CHK_T = "WCKT";// 审核状态，复审通过
    public final static String WO_CHECK_STAT_DEFE_T = "WDET";// 审核状态，复审拒绝

    public final static String LEGAL_TYPE_LAW = "CONF"; // 法务类型--律师函
    public final static String LEGAL_TYPE_POLI = "POLI"; // 法务类型--报公安
    public final static String LEGAL_TYPE_COUR = "COUR"; // 法务类型--法院

    public final static String SURVEY_PROCESS_LS = "01"; // 案调进度类型--银行受理
    public final static String SURVEY_PROCESS_ZC = "02"; // 案调进度类型--整理材料
    public final static String SURVEY_PROCESS_CG = "03"; // 案调进度类型--公安受理
    public final static String SURVEY_PROCESS_PD = "04"; // 案调进度类型--立案/案件侦察
    public final static String SURVEY_PROCESS_PC = "05"; // 案调进度类型--结案未还欠款
    public final static String SURVEY_PROCESS_PP = "06"; // 案调进度类型--结案未还清欠款
    public final static String SURVEY_PROCESS_PO = "07"; // 案调进度类型--结案已还清欠款

    public final static String LEGAL_PROCESS_C_OF = "04"; // 诉讼进度---撤消

    public final static int MAX_REQUEST_SIZE = 5242880; // 文件上传大小限制为5M
    public final static String LEGAL_OPERATE = "legalOperate"; // 诉讼操作权限
    public final static String VALIDATE_CODE = "ST-1-kP9ATJteOcbyWcBmEaBo-uam-w"; // 规则校验
}

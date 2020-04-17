/*
* ==================================================================
* The Huateng Software License
*
* Copyright (c) 2004-2005 Huateng Software System.  All rights
* reserved.
* ==================================================================
*/
/**
 * @desc 系统常量定义
 */

/**
 * 是否标志
 */
FLAG_OFF = "0"; //否
FLAG_ON = "1"; //是

/**
 * 有效标志/状态
 */
VALID_FLAG_INVALID = "0"; //无效
VALID_FLAG_VALID = "1"; //有效

/**
 * 币种
 */
CURCD_RMB = "CNY"; //人民币

/**
 * 日期格式
 */
DATE_PATTERN = "yyyy-MM-dd";

/**
 *  年、月、日
 */
MONTH_MAX = 11;
DAY_MAX = 30
YEAR_MAX = 99

//seqctl中的value_no
VALUE_NO_APPNO = 1; //申请编号
VALUE_NO_CUSTCD = 2; //客户编码
VALUE_NO_CONTRACTNO = 3; //合同号
VALUE_NO_PROJECTNO = 4; //合作项目编号
VALUE_NO_HOUSENO = 5; //楼盘编号
VALUE_NO_ACCUM_FUND_ACTNO = 6; //公积金帐号
VALUE_NO_ARCHIVE_ID = 7; //档案要素编号

//seqctl中默认的value_index
VALUE_INDEX = "00000000000000000000";

//公积金帐号科目(用于生成公积金帐号)
ACCUM_FUND_ACNO = "0950";

/**
 * 机构级别
 */
BRCODE_CLASS_HEAD = "1"; //总行
BRCODE_CLASS_BRANCH = "2"; //分行
BRCODE_CLASS_PL_CENTER = "3"; //个贷中心
BRCODE_CLASS_SUB_PL_CENTER = "4"; //个贷分中心
BRCODE_CLASS_SUBBRANCH = "5"; //支行

/**
 * 管理机构级别
 */
MANAGE_BRCODE_CLASS_HEAD = "0"; //总行
MANAGE_BRCODE_CLASS_BRANCH = "1"; //分行
MANAGE_BRCODE_CLASS_SUBBRANCH = "2"; //支行

/**
 * 操作员业务审批类型
 */
LIMIT_PARAM_BIZ_CLASS_ALL = "0"; //全部
LIMIT_PARAM_BIZ_CLASS_LOAN = "1"; //贷款业务
LIMIT_PARAM_BIZ_CLASS_PROJ = "2"; //合作项目

/**
 * 岗位类型
 */
ROLE_TYPE_OTHER = "0"; //其它
ROLE_TYPE_INPUT = "1"; //录入岗
ROLE_TYPE_MGR = "2"; //客户经理
ROLE_TYPE_AUDIT = "3"; //审查岗
ROLE_TYPE_APPROVE = "4"; //审批岗
ROLE_TYPE_COUNCIL = "5"; //贷审会意见录入岗
ROLE_TYPE_SUPERVISE = "6"; //放款监督岗

/**
 * 操作员审批控制方式
 */
APPROVE_TYPE_PASS_UNDER_MAX = "1"; //审批最高金额为准
APPROVE_TYPE_REPORT_IF_AGREE = "2"; //审批同意上报
APPROVE_TYPE_REPORT_ALL = "3"; //所有审批上报
APPROVE_TYPE_PASS_IF_AGREE = "4"; //审批同意通过

/**
 * 审批意见
 */
APP_ATTITUDE_AGREE = "1"; //同意
APP_ATTITUDE_CONDI_AGREE = "2"; //有条件同意
APP_ATTITUDE_AGREE_REPORT = "3"; //审批同意上报
APP_ATTITUDE_DISAGREE = "4"; //不同意
APP_ATTITUDE_UNTREAD = "5"; //退回

/**
 * 权限检查结果（流程下一步走向）
 */
APP_RESULT_REPORT = 0; //审批上报
APP_RESULT_PASS = 1; //审批通过
APP_RESULT_FAIL = 2; //审批不通过
APP_RESULT_UNTREAD = 3; //审批退回

/**
 * 前续审批条件
 */
PRE_APP_CONDITION_NON = "0"; //无
PRE_APP_CONDITION_PREAPP = "1"; //需要预审批
PRE_APP_CONDITION_INPUT = "2"; //需要录入贷审会意见

/**
 * 客户类型
 */
CUST_TYPE_NATURAL = "2"; //自然人
CUST_TYPE_ARTIFICIAL = "1"; //法人
CUST_TYPE_FINANCIAL = "3"; //金融机构

/**
 * 特约商户类型
 */
CORP_TYPE_COOP = "1"; //合作商
CORP_TYPE_ASSURER = "2"; //担保公司
CORP_TYPE_LAW_AGENCY = "3"; //法律中介
CORP_TYPE_EVAL_AGENCY = "4"; //评估机构

/**
 * 客户编码类型
 */
CORP_CODE_TYPE_LAND_AGENT = "F"; //房产商
CORP_CODE_TYPE_AUTO_DEALER = "C"; //汽车经销商
CORP_CODE_TYPE_RETAILER = "N"; //批发零售企业
CORP_CODE_TYPE_SCHOOL = "X"; //学校
CORP_CODE_TYPE_ACCUM_FUND = "G"; //住房公积金管理中心
CORP_CODE_TYPE_ASSURER = "D"; //担保公司
CORP_CODE_TYPE_AGENCY = "Z"; //中介机构
CORP_CODE_TYPE_CONSIGN = "W"; //委托单位
CORP_CODE_TYPE_INSURER = "B"; //保险公司
CORP_CODE_TYPE_OTHER = "Q"; //其他
CORP_CODE_TYPE_DIRECT_COOP = "9"; //直客式合作商

/**
 * 直客式合作商编号
 */
DIRECT_COOPNO = "99999999";

/**
 * 证件类型
 */
IDTYPE_ID_CARD = "1"; //身份证
IDTYPE_ORG_ID = "1"; //组织机构代码

/**
 * 婚姻状况
 */
MARRIAGE_MARRIED_ISSUE = "1"; //已婚有子女
MARRIAGE_MARRIED_ISSUELESS = "2"; //已婚无子女
MARRIAGE_UNMARRIED = "3"; //独身

/**
 * 个人关系
 */
PERSONAL_RELATION_MYSELF = "0"; //自己
PERSONAL_RELATION_MATE = "1"; //配偶
PERSONAL_RELATION_PARENT = "2"; //父母
PERSONAL_RELATION_CHILDREN = "3"; //子女
PERSONAL_RELATION_GRANDPARENT = "4"; //祖父母
PERSONAL_RELATION_GRANDCHILDREN = "5"; //孙子女
PERSONAL_RELATION_SIBLING = "6"; //兄弟姐妹
PERSONAL_RELATION_OTHER = "7"; //其他

/**
 * 合作项目类型
 */
PROJECT_TYPE_HOUSE = "1"; //购房贷款
PROJECT_TYPE_AUTO = "2"; //汽车贷款
PROJECT_TYPE_CONSUMABLE = "3"; //消费品贷款
PROJECT_TYPE_EDUCATION = "4"; //助学贷款
PROJECT_TYPE_WORKING = "5"; //经营性贷款
PROJECT_TYPE_ACCUM_FUND = "6"; //公积金贷款
PROJECT_TYPE_OTHER = "7"; //其它贷款
PROJECT_TYPE_ASSURE = "8"; //担保协议

PROJECT_TYPE_ALL = "0"; //不限

/**
 * 虚拟合作项目编号
 */
DUMMY_PROJECTNO = "999999999999";

/**
 * 合作项目额度控制方式
 */
LIMIT_MODE_UNLIMITED = "0"; //不设上限
LIMIT_MODE_SUM = "1"; //贷款累计发放额
LIMIT_MODE_BAL = "2"; //贷款余额

/**
 * 贷款大类
 */
LNTYPE_HOUSE = "001"; //个人一手房购房贷款
LNTYPE_SECONDHAND_HOUSE = "002"; //个人二手房购房贷款
LNTYPE_BIZ_HOUSE = "003"; //个人商业用房抵押贷款
LNTYPE_AUTO = "004"; //个人汽车贷款
LNTYPE_CONSUMABLE = "005"; //个人消费贷款
LNTYPE_WORKING = "006"; //个人生产经营贷款
LNTYPE_EDUCATION = "007"; //个人助学贷款
LNTYPE_EDUCATION_SH = "008"; //个人助学贷款(上海教委担保)
LNTYPE_STUDY_ABROAD = "009"; //个人留学贷款
LNTYPE_BANKBOOK_IMPAWN = "010"; //个人存单质押贷款
LNTYPE_NATIONAL_DEBT_IMPAWN = "011"; //个人国债质押贷款
LNTYPE_GUARANTEE_SLIP_IMPAWN = "012"; //个人保单质押贷款
LNTYPE_FX_IMPAWN = "013"; //个人外汇宝质押贷款
LNTYPE_SECURITIES_IMPAWN = "014"; //个人有价单证质押贷款
LNTYPE_OTHER_IMPAWN = "015"; //个人其他财产抵、质押贷款
LNTYPE_OCCUPATION_FUND_ASSURE = "016"; //就业基金担保贷款
LNTYPE_CASH_HOUSE_MORTAGAGE = "017"; //商品房抵押贷款
LNTYPE_NATIONAL_CREDIT = "018"; //个人信用贷款
LNTYPE_HOUSE_ADD = "aaa"; //加按贷款
LNTYPE_PAYHOUSE  = "aaa"; //赎楼贷款
LNTYPE_ACCUM_FUND = "100"; //公积金贷款

LNTYPE_ALL = "000"; //不限
LNID_ALL = "000000"; //不限
LNTYPE_CREDIT = "999"; //授信贷款
LNID_CREDIT = "999999"; //授信贷款

/**
*贷款大类 bak jiang@20080629
*
*LNTYPE_HOUSE = "001"; //个人一手房购房贷款
*LNTYPE_SECONDHAND_HOUSE = "002"; //个人二手房购房贷款
*LNTYPE_BIZ_HOUSE = "003"; //个人商业用房抵押贷款
*LNTYPE_AUTO = "004"; //个人汽车贷款
*LNTYPE_CONSUMABLE = "005"; //个人消费贷款
*LNTYPE_WORKING = "006"; //个人生产经营贷款
*LNTYPE_EDUCATION = "007"; //个人助学贷款
*LNTYPE_EDUCATION_SH = "008"; //个人助学贷款(上海教委担保)
*LNTYPE_STUDY_ABROAD = "009"; //个人留学贷款
*LNTYPE_BANKBOOK_IMPAWN = "010"; //个人存单质押贷款
*LNTYPE_NATIONAL_DEBT_IMPAWN = "011"; //个人国债质押贷款
*LNTYPE_GUARANTEE_SLIP_IMPAWN = "012"; //个人保单质押贷款
*LNTYPE_FX_IMPAWN = "013"; //个人外汇宝质押贷款
*LNTYPE_SECURITIES_IMPAWN = "014"; //个人有价单证质押贷款
*LNTYPE_OTHER_IMPAWN = "015"; //个人其他财产抵、质押贷款
*LNTYPE_OCCUPATION_FUND_ASSURE = "016"; //就业基金担保贷款
*LNTYPE_CASH_HOUSE_MORTAGAGE = "017"; //商品房抵押贷款
*LNTYPE_NATIONAL_CREDIT = "018"; //个人信用贷款
*LNTYPE_HOUSE_ADD = "020"; //加按贷款
*LNTYPE_PAYHOUSE  = "021"; //赎楼贷款
*LNTYPE_ACCUM_FUND = "100"; //公积金贷款
*
*LNTYPE_ALL = "000"; //不限
*LNID_ALL = "000000"; //不限
*LNTYPE_CREDIT = "999"; //授信贷款
*LNID_CREDIT = "999999"; //授信贷款
*
*/

/**
 * 贷款性质
 */
LOAN_ATTR_ALL = "0"; //所有
LOAN_ATTR_CONSUMABLE = "1"; //消费类贷款
LOAN_ATTR_WORKING = "2"; //经营类贷款

/**
 * 贷款类型
 */
LNTYPE_NATURE_OTHER = "0"; //其它
LNTYPE_NATURE_HOUSE = "1"; //购房贷款
LNTYPE_NATURE_AUTO = "2"; //汽车贷款
LNTYPE_NATURE_CONSUMABLE = "3"; //消费贷款
LNTYPE_NATURE_EDU = "4"; //助学贷款
LNTYPE_NATURE_WORKING = "5"; //生产经营贷款

/**
 * 合同性质
 */
LOAN_NATURE_NORMAL = "1"; //一般贷款合同
LOAN_NATURE_COMB = "2"; //组合贷款合同
LOAN_NATURE_ADD = "3"; //加按贷款合同
LOAN_NATURE_CREDIT = "4"; //授信贷款合同

/**
 * 申请审批状态/合同状态
 */
APPSTAT_INPUTED = "0"; //已录入
APPSTAT_SENDED = "1"; //已上传
APPSTAT_AUDITED = "2"; //已审查
APPSTAT_APPROVED = "3"; //已审批
APPSTAT_REJECTED = "4"; //已拒绝
APPSTAT_FINAL_APPROVED = "5"; //已终审
APPSTAT_GRANTED = "6"; //已会计确认

/**
 * 审批状态/流程状态
 */
FLOW_STATUS_APPROVING = "0"; //审批中
FLOW_STATUS_FINISH = "1"; //审批同意结束
FLOW_STATUS_REJECT = "2"; //审批拒绝结束

/**
 * 贷款借据发放状态
 */
GRANT_STATUS_UNGRANT = "0"; //未发放
GRANT_STATUS_GRANTED = "1"; //已发放
GRANT_STATUS_RETRACTED = "2"; //已撤销
GRANT_STATUS_OVER = "3"; //已终止

/**
 * 贷款形态
 */
TRM_CLASS_NORMAL = "0"; //正常
TRM_CLASS_OVERDUE = "1"; //逾期
TRM_CLASS_IDLE = "2"; //呆滞
TRM_CLASS_BAD = "3"; //呆帐
TRM_CLASS_CLOSE = "4"; //结清

/**
 * 五级分类
 */
CLR_CLASS_NORMAL = "0"; //正常
CLR_CLASS_ATTENTION = "1"; //关注
CLR_CLASS_LESSER = "2"; //次级
CLR_CLASS_SHADINESS = "3"; //可疑
CLR_CLASS_LOSS = "4"; //损失

/**
 * 五级分类方式
 */
CLR_MODE_AUTO = "1"; //自动
CLR_MODE_HAND = "2"; //手工

/**
 * 贷款发放方式
 */
GRANT_MODE_ONE_OFF = "0"; //一次性发放
GRANT_MODE_MULTI_TIMES = "1"; //分次发放
GRANT_MODE_PLAN = "2"; //按计划发放

/**
 * 还款方式
 */
//modifeid by fan.jiang 20100215 根据广州个贷进行调整
RTN_TYPE_BALINT_EQUAL = "3"; //等额本息还款
RTN_TYPE_BAL_EQUAL = "4"; //等额本金还款
RTN_TYPE_ONE_OFF = "1"; //一次性利随本清
RTN_TYPE_TIMES_INT = "2"; //分期付息一次还本
//fll----20060704-----还款方式的调整，根据浦发要求以下两个常量不可用
//值由原先的5，6修改为7，8
RTN_TYPE_BALLOON = "7"; //气球贷
RTN_TYPE_DESCENDING = "8"; //等额递减还款
RTN_TYPE_ELASTIC = "E"; //灵活还款
RTN_TYPE_FEE = "F"; //消费信贷
RTN_TYPE_TIMES_PRINT = "5";//分次还息分次还本
/**
 * 消费信贷分摊方式
 */
CONSUMER_CREDIT_TYPE_BUSI = "0"; // 商户全额分摊
CONSUMER_CREDIT_TYPE_CUST = "1"; // 客户全额分摊
CONSUMER_CREDIT_TYPE_PROTOCOL = "2"; // 协议分摊

/**modified by fan.jiang 20110215
 * 还款间隔
 */
RTN_INTERVAL_MONTHLY = "4"; //按月还款
RTN_INTERVAL_SEASON = "5"; //按季还款
RTN_INTERVAL_HALF_YEAR = "6"; //按半年还款
RTN_INTERVAL_STUDY_ABROAD = "3"; //按留学半年
RTN_INTERVAL_YEARLY = "7"; //按年还款
RTN_INTERVAL_FIXED_PERIOD = "5"; //按固定周期
RTN_INTERVAL_ONE_OFF = "6"; //一次性还款
RTN_INTERVAL_ONE_OFF2 = "1" //一次性还款，理财试算用
RTN_CYCLE_ONEWEEK = "2";//单周供
RTN_CYCLE_DOUBLEWEEK = "3";//双周供


/**
 * 不等额方式
 */
NON_EQUAL_MODE_FIRST_RTN = "1"; //指定首期还款金额
NON_EQUAL_MODE_PER_INCREASE = "2"; //指定每期递增/减金额

/**
 * 还款途径
 */
RTN_MODE_CARD = "0"; //东方卡
RTN_MODE_PASSBOOK = "1"; //一本通
RTN_MODE_BANKBOOK = "2"; //存折
RTN_MODE_NON = "3"; //暂无

/**
 * 还款日期确定方式
 */
RTN_DATE_TYPE_ISDATE = "0"; //借款日为还款日
RTN_DATE_TYPE_SPECIFY = "1"; //指定还款日期

/**
 * 阶段还款标志
 */
PHASE_FLAG_OFF = "0"; //非阶段还款
PHASE_FLAG_ON = "1"; //阶段还款

/**
 * 利率调整方式
 */
INT_ADJ_FIXED = "0"; //固定利率
INT_ADJ_MONTHLY = "1"; //按月调整
INT_ADJ_SEASON = "2"; //按季调整
INT_ADJ_YEARLY = "3"; //按年调整
INT_ADJ_YEAR_DATE = "4"; //一年一调
INT_ADJ_INT_DATE = "5"; //结息日

/**
 * 罚息浮动选项
 */
PUN_INT_OPT_FIXED = "0"; //固定罚息率
PUN_INT_OPT_FLOAT = "1"; //按合同利率浮动

/**
 * 划款方向
 */
PAY_DIRECT_INDV = "0"; //收款人为借款人
PAY_DIRECT_COOP = "1"; //合作商
PAY_DIRECT_INNER = "2"; //内部帐号
PAY_DIRECT_OTHER = "3"; //其他帐号

/**
 * 公积金冲还贷方式
 */
FUND_REPAY_MODE_ONE_OFF = "1"; //一次性还贷法
FUND_REPAY_MODE_MONTHLY = "2"; //逐月还贷法

/**
 * 公积金冲还贷月份
 */
FUND_REPAY_MONTH_APRIL = "1"; //4月份
FUND_REPAY_MONTH_SEPTEMBER = "2"; //9月份

/**
 * 按位表示的担保方式，每个下标位置所表示的担保方式
 */
GUATTYPE_SUBSCRIPT_CREDIT = 0; //信用
GUATTYPE_SUBSCRIPT_ASSURE = 1; //保证
GUATTYPE_SUBSCRIPT_MORTAGAGE = 2; //抵押
GUATTYPE_SUBSCRIPT_IMPAWN = 3; //质押
GUATTYPE_SUBSCRIPT_INSURANCE = 4; //履约保险

/**
 * 担保方式
 */
GUATCODE_IMPAWN = "1"; //质押
GUATCODE_MORTAGAGE = "2"; //抵押
GUATCODE_ASSURE = "3"; //保证
GUATCODE_CREDIT = "4"; //信用/免担保
GUATCODE_COMBINED_INC_ASSURE = "5"; //组合(含保证)
GUATCODE_COMBINED_EX_ASSURE = "6"; //组合(不含保证)
GUATCODE_INSURANCE = "7"; //履约保险
GUATCODE_OTHER = "9"; //其它

GUATCODE_ALL = "0"; //不限

/**
 * 贷款期限类型
 */
LOAN_TERM_TYPE_SHORT = "1"; //短期贷款
LOAN_TERM_TYPE_MEDIUM = "2"; //中期贷款
LOAN_TERM_TYPE_LONG = "3"; //长期贷款

/**
 * 客户帐单寄送地址
 */
BILL_MAIL_ADDR_FAMILY = "1"; //家庭地址
BILL_MAIL_ADDR_COMPANY = "2"; //单位地址
BILL_MAIL_ADDR_CONTACT1 = "3"; //联系地址1
BILL_MAIL_ADDR_CONTACT2 = "4"; //联系地址2
BILL_MAIL_ADDR_CONTACT3 = "5"; //联系地址3

/**
 * 助学贷款放款计划发放状态
 */
LOAN_PLAN_STATUS_UNGRANT = "0"; //未发放
LOAN_PLAN_STATUS_GRANTED = "1"; //已发放
LOAN_PLAN_STATUS_TERMINATED = "2"; //已终止发放

/**
 * 助学贷款分类
 */
EDU_LOAN_TYPE_NONE = "0"; //不分类
EDU_LOAN_TYPE_TUITION = "1"; //学费
EDU_LOAN_TYPE_ALIMONY = "2"; //生活费

/**
 * 房屋状况
 */
HOUSE_STAT_SPOT = "10"; //现房
HOUSE_STAT_FUTURES = "20"; //预售房
HOUSE_STAT_OTHER = "99"; //其他

/**
 * 抵押物大类
 */
MORT_CLASS_ESTATE = "1"; //房产
MORT_CLASS_CHATTEL = "2"; //动产
MORT_CLASS_OTHER = "3"; //其他

/**
 * 抵押物类型
 */
MORT_TYPE_HOUSE = "1"; //住房
MORT_TYPE_WORKING_HOUSE = "2"; //写字楼
MORT_TYPE_BIZ_HOUSE = "3"; //商铺
MORT_TYPE_CHATTEL = "4"; //动产
MORT_TYPE_OTHER = "5"; //其他

/**
 * 质物种类
 */
IMPAWN_TYPE_BANKBOOK = "1"; //存单
IMPAWN_TYPE_STOCK = "2"; //股票
IMPAWN_TYPE_GUARANTEE_SLIP = "3"; //保单
IMPAWN_TYPE_POSTBOOK = "4"; //邮储存单
IMPAWN_TYPE_OTHER_BANKBOOK = "5"; //他行存单
IMPAWN_TYPE_NATIONAL_DEBT = "6"; //凭证式国债
IMPAWN_TYPE_REGISTERED_RIGHTS = "7"; //记名式金融债权
IMPAWN_TYPE_OTHER_SECURITIES = "8"; //其它有价证券

/**
 * 额度冻结状态
 */
FREZ_STATUS_NORMAL = "0"; //正常
FREZ_STATUS_FREZ = "1"; //冻结

/**
 * 档案状态
 */
DOC_STATE_REGISTER = "1"; //已登记
DOC_STATE_STORAGE = "2"; //已入库
DOC_STATE_DESTROY = "3"; //已销毁

/**
 * 权利品状态
 */
GUA_STATE_SORT = "1"; //已建档
GUA_STATE_STORAGE = "2"; //已入库
GUA_STATE_APPLY_DRAW = "3"; //已申请领取
GUA_STATE_DRAW = "4"; //已出库

/**
 * 公证状态
 */
NOTARIZATION_STATUS_UNDONE = "0"; //未办理
NOTARIZATION_STATUS_PROCESSING = "1"; //办理中
NOTARIZATION_STATUS_DONE = "2"; //已公证

/**
 * 抵押状态
 */
MORTAGAGE_STATUS_UNDONE = "0"; //未办理
MORTAGAGE_STATUS_PROCESSING = "1"; //办理抵押中
MORTAGAGE_STATUS_PREPARE = "2"; //期房抵押(预抵押)
MORTAGAGE_STATUS_DONE = "3"; //已抵押
MORTAGAGE_STATUS_INVALID = "4"; //失效

/**
 * 保险状态
 */
INSURANCE_STATUS_UNDONE = "0"; //未办理
INSURANCE_STATUS_DONE = "1"; //已保险

/**
 * 核心帐户状态
 */
ACCOUNT_STATUS_VALID = "0"; //正常
ACCOUNT_STATUS_INVALID = "1"; //不正常

/**
 * 处置状态
 */
PROCESS_STATUS_NORMAL = "0"; //正常
PROCESS_STATUS_DUN = "1"; //催收
PROCESS_STATUS_LAW_MAIL = "2"; //律师函
PROCESS_STATUS_LAWSUIT = "3"; //诉讼
PROCESS_STATUS_COMPROMISE = "4"; //和解
PROCESS_STATUS_PAY_BY_ASSET = "5"; //抵债
PROCESS_STATUS_CANCEL = "6"; //核销

/**
 * 贷款交易明细类型
 */
LNHTR_TXTYPE_GRANT = "1"; //放款
LNHTR_TXTYPE_RTN = "2"; //还款
LNHTR_TXTYPE_TRM = "3"; //形态转换
LNHTR_TXTYPE_CLR = "4"; //五级分类
LNHTR_TXTYPE_ALTER = "5"; //贷后变更

/**
 * 贷款结清类型/还款类型
 */
CLOSE_TYPE_ADVANCE = "1"; //提前结清/提前还款
CLOSE_TYPE_ONTIME = "2"; //按时结清/按时还款
CLOSE_TYPE_OVERDUE = "3"; //逾期结清/逾期还款
CLOSE_TYPE_LOSS = "4"; //核销
CLOSE_TYPE_TRANSFER = "5"; //转呆滞/呆帐
CLOSE_TYPE_OTHER = "6"; //其它情况的终止/其它情况的还款

/**
 * 提前还款方式
 */
RTN_FLAG_BAL = "0"; //按本金还款
RTN_FLAG_PERI = "1"; //按期还款

/**
 * 催收方式
 */
DUN_MODE_PHONE = "1"; //电话
DUN_MODE_MAIL = "2"; //信函
DUN_MODE_MAIL_AND_DROP_IN = "3"; //信函和上门
DUN_MODE_DROP_IN = "4"; //上门
DUN_MODE_NOTE = "5"; //短信
DUN_MODE_EMAIL = "6"; //Email
DUN_MODE_LAW_MAIL = "7"; //律师函
DUN_MODE_OTHER = "8"; //其它

/**
 * 保单类型
 */
INSURE_TYPE_ESTATE = "1"; //财产保险
INSURE_TYPE_ASSUMPSIT = "2"; //履约保险



/**
 * 数据字典项类型
 */
DATADIC_TYPE_LNAMT = 1; //贷款金额
DATADIC_TYPE_INDV_INCOME = 2; //月收入
DATADIC_TYPE_FAMILY_INCOME = 3; //家庭月收入
DATADIC_TYPE_CREDIT_GRADE = 4; //信用等级
DATADIC_TYPE_TERM = 5; //贷款期限
DATADIC_TYPE_EDU_LEVEL = 6; //教育程度
DATADIC_TYPE_OCCUPATION = 7; //职业
DATADIC_TYPE_CORP_PROPERTY = 8; //单位性质
DATADIC_TYPE_DUTY = 9; //职务
DATADIC_TYPE_TITLE = 10; //职称
DATADIC_TYPE_MARRIAGE = 11; //婚姻状况
DATADIC_TYPE_SEX = 12; //性别
DATADIC_TYPE_HUKOU_TYPE = 13; //户籍性质
DATADIC_TYPE_GUATTYPE = 14; //担保方式
DATADIC_TYPE_RTN_TYPE = 16; //还款方式
DATADIC_TYPE_RTN_INTERVAL = 17; //还款间隔
DATADIC_TYPE_RTN_DATE_TYPE = 18; //还款日期确定方式
DATADIC_TYPE_TRM_CLASS = 19; //贷款状态(一逾两呆)
DATADIC_TYPE_OVD_DAYS_STAT = 20; //逾期天数状态
DATADIC_TYPE_RTN_MODE = 22; //还款途径
DATADIC_TYPE_CLIENT_ANLS_CONTENT = 23; //客户分析指标
DATADIC_TYPE_CLIENT_MODE_CONTENT = 24; //客户分类指标
DATADIC_TYPE_CERTIFICATE_IDTYPE = 29; //法人证件类型
DATADIC_TYPE_INDV_IDTYPE = 30; //个人证件类型
DATADIC_TYPE_PROJECT_TYPE = 31; //合作项目类型
DATADIC_TYPE_CLR_MODE = 34; //五级分类方式
DATADIC_TYPE_CLR_CLASS = 35; //五级分类
DATADIC_TYPE_HOUSE_STAT = 36; //房屋状态
DATADIC_TYPE_INT_ADJ_TPYE = 43; //利率调整方式
DATADIC_TYPE_LIMIT_TYPE = 51; //操作员审批类型
DATADIC_TYPE_PROCESS_STATUS = 53; //处置状态
DATADIC_TYPE_ADV_RTN_FLAG = 54; //提前还款方式
DATADIC_TYPE_LNUSE = 100; //贷款用途
DATADIC_TYPE_GRANT_MODE = 101; //发放方式
DATADIC_TYPE_NON_EQUAL_MODE = 102; //不等额方式
DATADIC_TYPE_PAY_DIRECT = 103; //划款方向
DATADIC_TYPE_LOAN_LIMIT_FORM = 112; //合作项目额度控制方式
DATADIC_TYPE_LNATTR = 116; //贷款性质(消费类贷款、经营类贷款)
DATADIC_TYPE_APPSTAT = 117; //合同状态
DATADIC_TYPE_ATTITUDE = 120; //审批意见
DATADIC_TYPE_ATTITUDE1 = 121; //贷后审批意见
DATADIC_TYPE_ATTITUDE2 = 122; //审查意见
DATADIC_TYPE_ATTITUDE3 = 123; //终审意见
DATADIC_TYPE_INSURANCE_TYPE = 140; //保单类型
DATADIC_TYPE_CURCD = 202; //币种
DATADIC_TYPE_IMPAWN_TYPE = 203; //质物种类
DATADIC_TYPE_CUST_TYPE = 206; //客户类型
DATADIC_TYPE_CORP_TYPE = 207; //特约商户类型
DATADIC_TYPE_CORP_CODE_TYPE = 208; //客户内部编码类型
DATADIC_TYPE_CORP_ECO_FORM = 209; //经营组织形式
DATADIC_TYPE_CORP_COWER_MODE = 210; //经济性质
DATADIC_TYPE_CORP_ORG_TYPE = 211; //机构类型
DATADIC_TYPE_CORP_BIZ_TYPE = 212; //行业类别
DATADIC_TYPE_CORP_SCALE = 213; //企业规模
DATADIC_TYPE_INDV_CORP_SCALE = 214; //借款人单位规模
DATADIC_TYPE_FOLK = 300; //民族
DATADIC_TYPE_HOUSE_PROPERTY = 302; //住宅性质
DATADIC_TYPE_COUNTRY = 303; //国籍
DATADIC_TYPE_TRADE = 306; //行业
DATADIC_TYPE_FLAG = 308; //是否标志
DATADIC_TYPE_STATUS = 309; //有效标志
DATADIC_TYPE_LIMIT_MODE = 310; //操作员审批控制方式
DATADIC_TYPE_BRCLASS = 401; //机构级别
DATADIC_TYPE_MANAGE_BRCLASS = 402; //管理机构级别
DATADIC_TYPE_DEGREE  = 403; //学位
DATADIC_TYPE_DUN_MODE = 404; //催收方式
DATADIC_TYPE_FUND_REPAY_MODE = 405; //公积金冲还贷方式
DATADIC_TYPE_FUND_REPAY_MONTH = 406; //公积金冲还贷月份
DATADIC_TYPE_HOUSE_TYPE = 407; //房屋类型
DATADIC_TYPE_MORT_TYPE = 408; //抵押物类型
DATADIC_TYPE_PHASE_FLAG = 409; //阶段还款标志
DATADIC_TYPE_PRELATION = 410; //个人关系
DATADIC_TYPE_PUN_INT_OPT = 411; //罚息浮动选项
DATADIC_TYPE_BRANCH_MAIL_ADDR = 412; //机构帐单寄送地址
DATADIC_TYPE_PL_CENTER_TYPE = 413; //个贷中心模式
DATADIC_TYPE_TERM_TYPE = 414; //贷款期限类型(短、中、长)
DATADIC_TYPE_PRE_APP_CONDITION = 415; //前续审批条件
DATADIC_TYPE_GUATCODE = 416; //担保方式
DATADIC_TYPE_RISK_GUIDE_LINE = 417; //风险指标
DATADIC_TYPE_HOUSE_PRICE_LEVEL = 418; //楼盘四级分类
DATADIC_TYPE_CORP_REPORT_TYPE = 419; //企业报表类型
DATADIC_TYPE_INFRACT_TYPE = 420; //客户信用记录来源
DATADIC_TYPE_DOC_CONS_MODE = 421; //档案调阅方式
DATADIC_TYPE_CUST_MAIL_ADDR = 422; //客户帐单寄送地址
DATADIC_TYPE_HOUSE_STRUCT = 423; //房屋结构
DATADIC_TYPE_HOUSE_BIZ_BPROPERTY = 424; //房屋性质
DATADIC_TYPE_HOUSE_SELL_PROPERTY = 425; //销售性质
DATADIC_TYPE_HOUSE_BUY_REASON = 426; //购房原因
DATADIC_TYPE_AUTO_USAGE = 427; //汽车用途
DATADIC_TYPE_AUTO_HANDS = 428; //一手车/二手车标志
DATADIC_TYPE_EDU_LOAN_TYPE = 429; //助学贷款分类
DATADIC_TYPE_EDU_LOAN_GRANT_STATUS = 430; //助学贷款放款计划发放状态
DATADIC_TYPE_MORT_STATUS = 431; //抵押状态
DATADIC_TYPE_MORT_PRELATION = 432; //权属人与借款人关系
DATADIC_TYPE_MORT_OWNERSHIP = 433; //抵押物所有权属
DATADIC_TYPE_INSURE_FEE_TYPE = 434; //保险费缴费方式
DATADIC_TYPE_INVEST_MODE = 435; //调查方式
DATADIC_TYPE_PBC_INQUIRY_RESULT = 436; //人民银行征信系统查询结论
DATADIC_TYPE_NOTARIZATION_STATUS = 437; //公证办理状态
DATADIC_TYPE_CLOSE_TYPE = 438; //还款类型/结清类型
DATADIC_TYPE_NOTE_TYPE = 439; //记事类型
DATADIC_TYPE_MORT_USAGE_KIND = 440; //抵押物使用情况
DATADIC_TYPE_ROLE_TYPE = 441; //抵押物使用情况
DATADIC_TYPE_CONTRIBUTE_DEGREE = 442; //业务贡献度
DATADIC_TYPE_LNCI_STATUS = 443; //借据发放状态

/**
 * 数据字典映射类型
 */
DATADIC_MAPTYPE_GUAT_TYPE = 1; //担保方式：将按位表示的担保方式映射为一位表示的担保方式
DATADIC_MAPTYPE_MORT_TYPE = 2; //抵押物类型：将抵押物类型映射为抵押物大类
DATADIC_MAPTYPE_PERSONAL_RELATION = 3; //个人关系：将个人关系映射为其反向的关系
DATADIC_MAPTYPE_LNUSE = 4; //贷款用途：将贷款大类映射为贷款用途
DATADIC_MAPTYPE_CURCD = 5; //币种：将币种代号映射为币种符号

//以下映射用于将系统内数据定义映射为人行征信数据定义
DATADIC_MAPTYPE_LNID = 11; //业务种类细分
DATADIC_MAPTYPE_RTN_INTERVAL = 12; //还款频率
DATADIC_MAPTYPE_CLR_CLASS = 13; //五级分类
DATADIC_MAPTYPE_TRM_CLASS = 14; //账户状态
DATADIC_MAPTYPE_IDTYPE = 15; //证件类型
DATADIC_MAPTYPE_SEX = 16; //性别
DATADIC_MAPTYPE_MARRIAGE = 17; //婚姻状况
DATADIC_MAPTYPE_EDUCATION = 18; //最高学历
DATADIC_MAPTYPE_OCCUPATION = 19; //职业
DATADIC_MAPTYPE_TRADE = 20; //单位所属行业
DATADIC_MAPTYPE_DUTY = 21; //职务
DATADIC_MAPTYPE_TITLE = 22; //职称
DATADIC_MAPTYPE_HABITATION = 23; //居住状况

/**
 * 申请类型
 */
APPLY_TYPE_NORMAL_LOAN = "01"; //贷款申请
APPLY_TYPE_COMBINATION_LOAN = "02"; //组合贷款申请
APPLY_TYPE_ADDITION_LOAN = "03"; //加按申请
APPLY_TYPE_TRANSFER_LOAN = "04"; //转按申请

APPLY_TYPE_CREDIT_APPLY = "11"; //授信额度申请
APPLY_TYPE_CREDIT_INCREASE = "12"; //额度增加申请
APPLY_TYPE_CREDIT_REVOKE = "13"; //额度收回申请
APPLY_TYPE_CREDIT_DECREASE = "14"; //额度缩减申请
APPLY_TYPE_CREDIT_FREEZE = "15"; //额度冻结/解冻结申请

APPLY_TYPE_PROJECT_APPLY = "21"; //合作项目申请
APPLY_TYPE_PROJECT_ALTER = "22"; //合作项目修改申请
APPLY_TYPE_PROJECT_TERMINATE = "23"; //合作项目终止申请

APPLY_TYPE_CLR_CLASS_DOWN = "31"; //五级分类下调申请
APPLY_TYPE_CLR_CLASS_UP = "32"; //五级分类上调申请
APPLY_TYPE_ADV_RTN = "33"; //提前还款申请
APPLY_TYPE_LOAN_TO_BAD = "34"; //贷款转呆滞/呆帐申请
APPLY_TYPE_CHG_GUARANTEE = "35"; //变更担保信息申请
APPLY_TYPE_CHG_INTRATE = "36"; //贷款利率变更申请
APPLY_TYPE_TERM_DEFER = "37"; //贷款期限延长申请
APPLY_TYPE_TERM_SHORTEN = "38"; //贷款期限缩短申请
APPLY_TYPE_CHG_RTN_TYPE = "39"; //还款方式变更申请
APPLY_TYPE_CHG_RTN_DATE = "40"; //约定扣款日变更申请
APPLY_TYPE_CHG_PHASE_DTL = "41"; //阶段还款信息变更申请
APPLY_TYPE_CHG_RTN_ACTNO = "42"; //还款帐号变更申请
APPLY_TYPE_CREDIT_INTRATE = "43"; //额度利率变更申请
APPLY_TYPE_EDU_LOAN_EXTEND = "44"; //助学贷款展期申请
APPLY_TYPE_EDU_LOAN_TRSF_DATE = "45"; //助学贷款转等额日变更申请
APPLY_TYPE_EDU_LOAN_GRANT_PLAN = "46"; //助学贷款放款计划变更申请
APPLY_TYPE_CHG_FUND_REPAY_MODE = "47"; //公积金冲还贷方式变更申请
APPLY_TYPE_CHG_CONJUNCTER = "48"; //参贷人变更申请

/**
 * 字符串长度
 */
STRING_BUFFER_LEN_MID = 1024;
STRING_BUFFER_LEN_MIN = 256;
STRING_BUFFER_LEN_MAX = 4096;

/**
 * globalinfo表ID
 */
TABLE_GLOBAL_INFO_ID = 1;

/**
 * session ID的常量定义
 */
WEB_SESSION_ID = "jsessionid";

/**
 * 批量状态
 */
GLOBAL_INFO_STATE_ONLINE = "0"; //联机状态
GLOBAL_INFO_STATE_BATCH = "1"; //批量状态

/**
 * 交易性质
 */
FUNC_TYPE_INQUIRY = "0"; //查询类
FUNC_TYPE_UPDATE = "1"; //修改类

/**
 * 机构帐单寄送地址
 */
BRANCH_MAIL_ADDR_PL_CENTER = "1"; //个贷中心
BRANCH_MAIL_ADDR_ACCOUNT = "2"; //帐务机构

/**
 * 记事类型
 */
NOTE_TYPE_LOAN = "1"; //合同
NOTE_TYPE_INDV = "2"; //客户
NOTE_TYPE_COOP = "3"; //特约商户
NOTE_TYPE_PROJECT = "4"; //合作项目
NOTE_TYPE_OTHER = "5"; //其它

/**
 * 风险指标
 */
RISK_GUIDE_LINE_LNBAL = "1"; //贷款余额
RISK_GUIDE_LINE_ILL_BAL = "2"; //不良贷款余额
RISK_GUIDE_LINE_ILL_BAL_RATE = "3"; //不良贷款率
RISK_GUIDE_LINE_ESTIMATE_LOSS_RATE = "4"; //估计贷款损失率
RISK_GUIDE_LINE_NORMAL_TRANSFER_RATIO = "5"; //正常类贷款迁徙率
RISK_GUIDE_LINE_ATTENTION_TRANSFER_RATIO = "6"; //关注类贷款迁徙率
RISK_GUIDE_LINE_LESSER_TRANSFER_RATIO = "7"; //次级类贷款迁徙率
RISK_GUIDE_LINE_SHADINESS_TRANSFER_RATIO = "8"; //可疑类贷款迁徙率

/**
 * 客户分析指标
 */
CUST_GUIDE_LINE_SEX = "01"; //性别
CUST_GUIDE_LINE_OCCUPATION = "02"; //职业
CUST_GUIDE_LINE_TRADE = "03"; //行业
CUST_GUIDE_LINE_DUTY = "04"; //职务
CUST_GUIDE_LINE_TITLE = "05"; //职称
CUST_GUIDE_LINE_CORP_PROPERTY = "06"; //单位性质
CUST_GUIDE_LINE_MARRIAGE = "07"; //婚姻状况
CUST_GUIDE_LINE_HUKOU_TYPE = "08"; //户籍性质
CUST_GUIDE_LINE_EDU_LEVEL = "09"; //文化程度
CUST_GUIDE_LINE_INDV_INCOME = "10"; //月收入
CUST_GUIDE_LINE_FAMILY_INCOME = "11"; //家庭月总收入
CUST_GUIDE_LINE_CREDIT_GRADE = "12"; //信用评估得分
CUST_GUIDE_LINE_LNTYPE = "13"; //贷款种类
CUST_GUIDE_LINE_LNAMT = "14"; //贷款金额
CUST_GUIDE_LINE_TERM = "15"; //贷款期限
CUST_GUIDE_LINE_GUATCODE = "16"; //担保方式
CUST_GUIDE_LINE_RTN_TYPE = "17"; //还款方式
CUST_GUIDE_LINE_RTN_INTERVAL = "18"; //还款间隔
CUST_GUIDE_LINE_RTN_DATE_TYPE = "19"; //还款日期确定方式

/**
 * 客户分类指标
 */
CUST_MODE_A = "A"; //A类客户
CUST_MODE_B = "B"; //B类客户
CUST_MODE_C = "C"; //C类客户
CUST_MODE_NO = "0"; //未分类客户

/**
 * 阶段还款之组合还款最大最小阶段数
 */
DATADIC_TYPE_PHASENO_MAX = 8; //
DATADIC_TYPE_PHASENO_MIN = 2; //

/*
*申请类型
*
*/
APPTYPE_TYPE_FIVECLASS_MODE="49";
APPTYPE_TYPE_FIVECLASS_DOWN="31";
APPTYPE_TYPE_FIVECLASS_UP="32";

/*
*评分要素
*
*/
CUSTGRADE_MODEL_SEX="1";//性别
CUSTGRADE_MODEL_MARRIAGE="2";//婚姻状况
CUSTGRADE_MODEL_AGE="3"//年龄

CUSTGRADE_MODEL_EDULEVEL="5";//文化程度
CUSTGRADE_MODEL_SOCIALSECURITSTATUS="6";//文化程度
CUSTGRADE_MODEL_HEALTHSTATUS="7";//健康状况
CUSTGRADE_MODEL_CURRRESIDEYEARS="8";//居住年限

CUSTGRADE_MODEL_CORPPRO="9";//单位性质
CUSTGRADE_MODEL_TITLE="10";//职称
CUSTGRADE_MODEL_POSTPRO="11";//岗位性质
CUSTGRADE_MODEL_JOBYEARS="12";//工作年限

CUSTGRADE_MODEL_INDVINCOME="13";//月收入
CUSTGRADE_MODEL_FAMILYINCOME="14";//家庭月收入
CUSTGRADE_MODEL_RTNRATE="15";//还贷比
CUSTGRADE_MODEL_HOUSEWORTH="16"//房产价值
CUSTGRADE_MODEL_OTHERWORTH="17"//其他价值

CUSTGRADE_MODEL_AVERAGEBAL="18";//日均收入
CUSTGRADE_MODEL_CREDITSTATUS="20"//人行征信情况
CUSTGRADE_MODEL_OTHERCREDIT="21"//其他信用情况
CUSTGRADE_MODEL_ACCOUNTSTATUS="22"//帐户开立情况
/*
*证件类型
*
*/
IDTYPE_HUKOU = "6";//户口
IDTYPE_OTHER = "7";//其他

/*
*期限变更方式
*
*/
TERM_TYPE_ZQ = "1";//展期
TERM_TYPE_YQ = "2";//延期
TERM_TYPE_SQ = "3";//缩期


/*
*商行金融机构代码
*人行征信使用
*add jiang@20080725
*/
BANK_CODE_JINGZHOU = "D10025370H0004";//荆州

/*
* 贷款期限的期限控制方式
*/
TERMTYPE_YEAR = "0";//按年
TERMTYPE_MONTH = "1";//按月
TERMTYPE_DATE = "2";//按天

/**
* 贷款小类
*/
LNID_CREDIT_LOAN = "101003"; // 个人信用消费信贷

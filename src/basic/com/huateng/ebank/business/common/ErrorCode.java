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
 * @desc define error code
 */
public class ErrorCode {
    public static final String ERROR_CODE_TLR_BE_DELETE = "SE3015"; // 操作员已被删除

    public static final String ERROR_CODE_PREVENT_TIME = "GD0130";// 不允许在N小时内再次修改密码

    public static final String ERROR_CODE_OK = "000000"; // 交易成功代码222

    public static final String ERROR_CODE_NORMAL = "000001"; // 未知错误

    public static final String DATE_IS_NULL = "GD0009"; // 时间为空
    public static final String ERROR_CODE_GLOBALINFO_SELECT = "GD1303"; // 系统表读取错误

    /**
     * 系统错误代码 SE0001~SE0100
     */
    public static final String ERROR_CODE_SAME_TLRNO = "GD2001"; // 相同操作员
    public static final String ERROR_CODE_WRONG_STATUS = "GD2002"; // 记录状态不正确
    public static final String ERROR_CODE_SAME_RECORD = "GD2003"; // 存在相同记录

    public static final String ERROR_CODE_UNKNOWN = "GD0001"; // 未知错误
    public static final String ERROR_CODE_DATE_FORMAT_ERR = "GD0002"; // 日期格式错误
    public static final String ERROR_CODE_DATA_FORMAT_ERR = "GD0003"; // 数据格式错误
    public static final String ERROR_CODE_INTERNAL_ERROR = "GD0004"; // 应用系统内部错误
    public static final String ERROR_CODE_FTP = "GD0005"; // FTP错误

    /**
     * DAO错误代码 GD1001~GD2000
     */
    public static final String ERROR_CODE_DAO = "GD1001"; // DAO错误

    /**
     * 用户登陆,操作员信息修改 错误码 SE0101~SE0400
     */
    public static final String ERROR_CODE_TLRNO_NO_FUNCTION = "GD0101"; // 操作员无此功能权限
    public static final String ERROR_CODE_TLRNO_SESSION_INVALID = "GD0102"; // 操作员会话无效
    public static final String ERROR_CODE_TLRNO_SESSION_BINDED = "GD0103"; // 此会话已经被其他操作员绑定
    public static final String ERROR_CODE_NO_GLOBALINFO_INSTANCE = "GD0104"; // 系统错误，没有初始化全局信息
    public static final String ERROR_CODE_GLOBALINFO_BATCH = "GD0105"; // 系统处于批量状态
    public static final String ERROR_CODE_TLRNO_ALREADY_LOGIN = "GD0106";// 用户已登录
    public static final String ERROR_CODE_TLRNO_STATUS_INVALID = "GD0107";// 用户状态无效
    public static final String ERROR_CODE_USER_NOT_EXIST = "GD0108";// 用户不存在
    public static final String ERROR_CODE_USER_PWD_INVALID = "GD0109";// 用户密码错误

    public static final String ERROR_CODE_CHG_PWD_SAME_CHARS = "GD0112";// 密码不能为连续相同字母
    public static final String ERROR_CODE_NEW_OLD_PWD_IS_SAME = "GD0113";// 新旧密码不能相同
    public static final String ERROR_CODE_USER_INFO_INVALID = "GD0114";// 获取用户信息失败
    public static final String ERROR_CODE_NEW_AGAIN_PWD_IS_NOT_SAME = "GD0115";// 新密码和确认密码必须相同
    public static final String ERROR_CODE_PWD_FIELDS_IS_NULL = "GD0116";// 旧密码、新密码或确认密码字段不能为空
    public static final String ERROR_CODE_QUERY_INPUT_NO_RECORD = "GD0200";// 记录状态错误，不存在带录入交易

    public static final String ERROR_CODE_ABNORMAL_STATUS_RECORD = "GD0201";// 记录状态错误，不存在带录入交易

    /**
     * 用户登陆,操作员信息修改 错误码 GD0101~GD0400
     */
    public static final String ERROR_CODE_TLRNO_PSWD_ERR_TIMES = "GD0110";// 操作员连续密码错误
    public static final String ERROR_CODE_TLRNO_PSWD_CHANGE = "GD0111";// 操作员密码修改
    public static final String ERROR_CODE_BRCODE = "GD0117";// 新密码和确认密码必须相同

    // 授权新增 farly.yu 20090923
    public static final String ERROR_CODE_ROLE_LIST_BY_ROLETYPE = "GD0123";// 获取岗位列表错
    public static final String ERROR_CODE_AUTHORIZATION_ERR = "GD0124"; // 授权出错

    public static final String ERROR_CODE_CHANGE_PASSWORD = "GD0129"; // 修改密码错

    /**
     * 部门管理错误表
     */
    public static final String ERROR_CODE_DEPARTMENT_MANAGEMENT_SELECT = "DM000";// 部门查询错误

    public static final String ERROR_CODE_RELATION_CODE_DELETE = "SE1670"; // 关系代码删除错误
    public static final String ERROR_CODE_RELATION_CODE_INSERT = "SE1671"; // 关系代码插入错误
    public static final String ERROR_CODE_RELATION_CODE_SELECT = "SE1672"; // 关系代码读取错误
    public static final String ERROR_CODE_RELATION_CODE_UPDATE = "SE1673"; // 关系代码修改错误

    public static final String ERROR_CODE_BCTL_DELETE = "GD1173"; // 机构控制表删除错误
    public static final String ERROR_CODE_BCTL_INSERT = "GD1174"; // 机构控制表插入错误
    public static final String ERROR_CODE_BCTL_SELECT = "GD1175"; // 机构控制表读取错误
    public static final String ERROR_CODE_BCTL_UPDATE = "GD1176"; // 机构控制表修改错误
    public static final String ERROR_CODE_BIZ_LOG_DELETE = "GD1177"; // 交易日志表删除错误
    public static final String ERROR_CODE_BIZ_LOG_INSERT = "GD1178"; // 交易日志表插入错误
    public static final String ERROR_CODE_BIZ_LOG_SELECT = "GD1179"; // 交易日志表读取错误
    public static final String ERROR_CODE_BIZ_LOG_UPDATE = "GD1180"; // 交易日志表修改错误
    public static final String ERROR_CODE_DATA_DIC_DELETE = "GD1273"; // 数据字典表删除错误
    public static final String ERROR_CODE_DATA_DIC_INSERT = "GD1274"; // 数据字典表插入错误
    public static final String ERROR_CODE_DATA_DIC_MAP_DELETE = "GD1275"; // 数据字典映射表删除错误
    public static final String ERROR_CODE_DATA_DIC_MAP_INSERT = "GD1276"; // 数据字典映射表插入错误
    public static final String ERROR_CODE_DATA_DIC_MAP_SELECT = "GD1277"; // 数据字典映射表读取错误
    public static final String ERROR_CODE_DATA_DIC_MAP_UPDATE = "GD1278"; // 数据字典映射表修改错误
    public static final String ERROR_CODE_DATA_DIC_SELECT = "GD1279"; // 数据字典表读取错误
    public static final String ERROR_CODE_DATA_DIC_UPDATE = "GD1280"; // 数据字典表修改错误
    public static final String ERROR_CODE_FUNCTION_INFO_DELETE = "GD1293"; // 交易定义表删除错误
    public static final String ERROR_CODE_FUNCTION_INFO_INSERT = "GD1294"; // 交易定义表插入错误
    public static final String ERROR_CODE_FUNCTION_INFO_SELECT = "GD1295"; // 交易定义表读取错误
    public static final String ERROR_CODE_FUNCTION_INFO_UPDATE = "GD1296"; // 交易定义表修改错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_INSERT = "GD1526"; // 岗位交易权限表插入错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_SELECT = "GD1527"; // 岗位交易权限表读取错误
    public static final String ERROR_CODE_ROLE_FUNC_RELATION_UPDATE = "GD1528"; // 岗位交易权限表修改错误
    public static final String ERROR_CODE_ROLE_INFO_DELETE = "GD1529"; // 岗位定义表删除错误
    public static final String ERROR_CODE_ROLE_INFO_INSERT = "GD1530"; // 岗位定义表插入错误
    public static final String ERROR_CODE_ROLE_INFO_SELECT = "GD1531"; // 岗位定义表读取错误
    public static final String ERROR_CODE_ROLE_INFO_UPDATE = "GD1532"; // 岗位定义表修改错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_DELETE = "GD1533"; // 岗位报表权限表删除错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_INSERT = "GD1534"; // 岗位报表权限表插入错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_SELECT = "GD1535"; // 岗位报表权限表读取错误
    public static final String ERROR_CODE_ROLE_REPORT_PARAM_UPDATE = "GD1536"; // 岗位报表权限表修改错误
    public static final String ERROR_CODE_SEQCTL_DELETE = "GD1549"; // 序号控制表删除错误
    public static final String ERROR_CODE_SEQCTL_INSERT = "GD1550"; // 序号控制表插入错误
    public static final String ERROR_CODE_SEQCTL_SELECT = "GD1551"; // 序号控制表读取错误
    public static final String ERROR_CODE_SEQCTL_UPDATE = "GD1552"; // 序号控制表修改错误

    public static final String ERROR_CODE_TLR_INFO_DELETE = "GD1561"; // 操作员定义表删除错误
    public static final String ERROR_CODE_TLR_INFO_INSERT = "GD1562"; // 操作员定义表插入错误
    public static final String ERROR_CODE_TLR_INFO_SELECT = "GD1563"; // 操作员定义表读取错误
    public static final String ERROR_CODE_TLR_INFO_UPDATE = "GD1564"; // 操作员定义表修改错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_DELETE = "GD1565"; // 操作员岗位关系表删除错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_INSERT = "GD1566"; // 操作员岗位关系表插入错误
    public static final String ERROR_CODE_TLR_ROLE_RELATION_SELECT = "GD1567"; // 操作员岗位关系表读取错误

    public static final String ERROR_CODE_REPORT_INFO_DELETE = "GD1581"; // 报表定义表删除错误
    public static final String ERROR_CODE_REPORT_INFO_INSERT = "GD1582"; // 报表定义表插入错误
    public static final String ERROR_CODE_REPORT_INFO_SELECT = "GD1583"; // 报表定义表读取错误
    public static final String ERROR_CODE_REPORT_INFO_UPDATE = "GD1584"; // 报表定义表修改错误

    public static final String ERROR_CODE_NO_BRCODE = "GD3003"; // 该机构号不存在
    public static final String ERROR_CODE_INFO_NOT_INPUT = "GD5549"; // 资料录入不全
    public static final String ERROR_CODE_RECORD_NOTFOUND = "GD3002"; // 没有找到符合条件的记录
    public static final String ERROR_CODE_CANNOT_SUBMIT = "GD3004"; // 不能提交

    // 通讯日志信息表
    /** add by shen_antonio 20080508 . */
    public static final String ERROR_CODE_COMM_LOG_SELECT = "GD1645";// 通讯日志信息表读取错误
    public static final String ERROR_CODE_COMM_LOG_INSERT = "GD1656";// 通讯日志信息表插入错误
    public static final String ERROR_CODE_COMM_LOG_UPDATE = "GD1647";// 通讯日志信息表修改错误
    public static final String ERROR_CODE_COMM_LOG_DELETE = "GD1648";// 通讯日志信息表删除错误

    /**
     * 系统参数设置的错误代码 GD7001~GD7500
     */
    public static final String ERROR_CODE_NO_PERMISSION = "GD7001";// 权限不足错误
    public static final String ERROR_CODE_UPDATE_PK = "GD7002";// 更新主键错误
    public static final String ERROR_CODE_DUP_INSERT = "GD7003";// 重复插入错误
    public static final String ERROR_CODE_OVER_HEAD = "GD7004";// 参数超出总行允许的范围错误
    public static final String ERROR_CODE_NO_UPCODE_PERMISSION = "GD7005";// 上级机构没有开办业务错误
    public static final String ERROR_CODE_POSTNO = "GD7006";// 邮编填写错误
    public static final String ERROR_CODE_NO_TLRNO_EXIST = "GD7007";// 该柜员不存在错误
    public static final String ERROR_CODE_NO_RIGHT_ROLEID = "GD7008";// 操作员不具备审批角色错误
    public static final String ERROR_CODE_NO_RANGE = "GD7009";// 该操作员不在本行管辖内错误
    public static final String ERROR_CODE_YES_DOWNCODE_PERMISSION = "GD7010";// 下级机构仍在开办此项业务
    public static final String ERROR_CODE_LOAN_PARAM = "GD7011";// 贷款产品参数错误
    public static final String ERROR_CODE_EAPPROVE_PARAM_ERROR = "GD7012";// 电子审批参数错误

    /**
     * 渠道错误代码
     */
    public static final String ERROR_CODE_CHANNEL_CINO_EMPTY = "GDE0001"; // 借据号不能为空.
    public static final String ERROR_CODE_CHANNEL_NO_RECORD = "GDE0002"; // 记录没有找到
    public static final String ERROR_CODE_CHANNEL_DATE_FORMAT = "GDE0003"; // 日期格式不正确
    public static final String ERROR_CODE_CHANNEL_QISHBS_EMPTY = "GDE0004"; // 起始笔数为空
    public static final String ERROR_CODE_CHANNEL_CXUNBS_EMPTY = "GDE0005"; // 查询笔数为空
    public static final String ERROR_CODE_CHANNEL_NUMBER_ERROR = "GDE0006"; // 数字格式错误

    /**
     * 组合还款方式错误代码 GD7501~GD8000
     */
    public static final String ERROR_CODE_PHASE_COUNT_MISMATCH = "GD7501"; // 还款阶段数错误
    public static final String ERROR_CODE_PHASE_TERM_MISMATCH = "GD7502"; // 还款阶段起止期数错误
    public static final String ERROR_CODE_PHASE_TYPE_MISMATCH = "GD7503"; // 还款方式组合错误
    public static final String ERROR_CODE_PHASE_TOTAMT_MISMATCH = "GD7504"; // ?8?3
                                                                            // 还款总金额计算错误
    public static final String ERROR_CODE_PHASE_PERAMT_MISMATCH = "GD7505"; // 还款金额计算错误

    /**
     * add by Robin 2007-11-21 会计错误码 GDA001 ~ GDA999
     */
    public static final String ERROR_CODE_SUJ_NO_IS_EXIST = "GDA001"; // 科目号已存在
    public static final String ERROR_CODE_UP_SUJ_NO_NOT_EXIST = "GDA002"; // 上级科目号不存在

    /**
     * add by Robin 2007-11-28 贷后管理错误码
     */

    /**
     * add by shen_antonio 2008-03-27 工作流相关任务分配错误码
     */
    public static final String ERROR_CODE_TLRLVDAY_ERROR = "GDW001";// 休假起始日不能在休假结束日之后
    public static final String ERROR_CODE_TLRVDAY_APPLY_ERROR = "GDW002";// 休假申请失败
    public static final String ERROR_CODE_TLRVDAY_CANCEL_ERROR = "GDW003";// 销假失败
    public static final String ERROR_CODE_TASK_GET_ASSIGN_TLRNO_ERROR = "GDW004";// 工作流获得该该分配的操作员失败
    public static final String ERROR_CODE_TASK_ASSIGN_ERROR = "GDW005";// 工作流分配任务失败
    public static final String ERROR_CODE_TASK_ASSIGN_DOFINISH_ERROR = "GDW006";// 工作流完成任务操作失败
    public static final String ERROR_CODE_IU_TLR_WL_HS_ERROR = "GDW007";// 操作员每日工作量统计表错误(记录重复，单个操作员单日，同种工作类型的记录有多条)
    public static final String ERROR_CODE_IU_TLR_WORKLOAD_ERROR = "GDW008";// 操作员工作量统计表错误(记录重复，操作员，同种工作类型的记录有多条)
    public static final String ERROR_CODE_TASK_FORWARD_ERROR = "GDW009";// 操作员工作移交失败
    public static final String ERROR_CODE_WORKFLOW_START_ERROR = "GDW010";// 工作流服务启动工作流失败
    public static final String ERROR_CODE_WORKFLOW_DOFINISH_ERROR = "GDW011";// 工作流服务执行任务失败
    public static final String ERROR_CODE_WORKFLOW_FORWARD_ERROR = "GDW012";// 工作流服务任务移交失败
    public static final String ERROR_CODE_WORKFLOW_GETTASKLIST_ERROR = "GDW013";// 工作流服务获取工作列表失败
    public static final String ERROR_CODE_WORKFLOW_GETTASKVALUE_ERROR = "GDW014";// 工作流服务获取任务参数失败
    public static final String ERROR_CODE_WORKFLOW_SETTASKVALUE_ERROR = "GDW015";// 工作流服务设置任务参数失败
    public static final String ERROR_CODE_WORKFLOW_LOCKTASK_ERROR = "GDW016";// 工作流服务锁任务失败
    public static final String ERROR_CODE_WORKFLOW_RELEASETASK_ERROR = "GDW017";// 工作流服务释放任务失败
    public static final String ERROR_CODE_WORKFLOW_KEEPTASK_ERROR = "GDW018";// 工作流服务保留任务失败
    public static final String ERROR_CODE_WORKFLOW_GETFLOWINS_ERROR = "GDW019";// 工作流服务获取流程实例失败
    public static final String ERROR_CODE_WORKFLOW_CLOSEFLOWINS_ERROR = "GDW020";// 工作流服务结束流程实例失败
    public static final String ERROR_CODE_WORKFLOWRULE_DYN_FLOWNAME_EMPTY = "GDW021";// 工作流规则启动错误，设置动态路由，没有对应流程名
    public static final String ERROR_CODE_WORKFLOWTASKRULE_CONTEXT = "GDW022";// 工作流工作规则启动错误,输入参数错误(TaskId
                                                                              // 不能为空
                                                                              // ProcId
                                                                              // 不能为空
                                                                              // TlrList
                                                                              // 不能为空
                                                                              // Status
                                                                              // 不能为空)
    public static final String ERROR_CODE_WORKFLOWCONTEXT_COPY_TASKINFO = "GDW023";// 工作流工作内容拷贝出错
    public static final String ERROR_CODE_TASK_ENDPROCTASK = "GDW024";// 取消操作员任务分配记录

    // 额度品种控制表
    public static final String ERROR_CODE_CREDIT_LNID_SELECT = "GD1708";// 额度品种控制表读取错误
    public static final String ERROR_CODE_CREDIT_LNID_INSERT = "GD1709";// 额度品种控制表插入错误
    public static final String ERROR_CODE_CREDIT_LNID_UPDATE = "GD1710";// 额度品种控制表修改错误
    public static final String ERROR_CODE_CREDIT_LNID_DELETE = "GD1711";// 额度品种控制表删除错误

    /**
     * add by weikun wang 2008-04-13 批量步骤表分配错误码
     */
    public static final String ERROR_CODE_BHPROC_STEP_SELECT = "GDF001"; // 批量步骤表读入错误
    public static final String ERROR_CODE_BHPROC_STEP_INSERT = "GDF002"; // 批量步骤表插入错误
    public static final String ERROR_CODE_BHPROC_STEP_UPDATE = "GDF003"; // 批量步骤表更新错误
    public static final String ERROR_CODE_BHPROC_STEP_DELETE = "GDF004"; // 批量步骤表删除错误

    public static final String ERROR_CODE_REPEAT_INTERVAL = "GD0131";// 用户密码不能与最近{0}次修改的密码相同

}

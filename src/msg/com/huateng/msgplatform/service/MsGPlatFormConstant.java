package com.huateng.msgplatform.service;

public class MsGPlatFormConstant {

    public final static String MSG_TYPE_CICS = "2";// 法院查控CICS
    public final static String MSG_SUB_TYPE_CICS_01 = "01";// 法院查控通知：查询请求待分配
    public final static String MSG_SUB_TYPE_CICS_02 = "02";// 法院查控提醒：查询请求未分配
    public final static String MSG_SUB_TYPE_CICS_03 = "03";// 法院查控提醒：控制请求未分配
    public final static String MSG_SUB_TYPE_CICS_04 = "04";// 法院查控提醒：查询请求未反馈
    public final static String MSG_SUB_TYPE_CICS_05 = "05";// 法院查控提醒：控制请求未反馈
    public final static String MSG_SUB_TYPE_CICS_06 = "06";// 法院查控提醒：查询反馈未审核
    public final static String MSG_SUB_TYPE_CICS_07 = "07";// 法院查控提醒：控制反馈未审核
    public final static String MSG_SUB_TYPE_CICS_08 = "08";// 法院查控提醒：控制反馈未发送
    public final static String MSG_SUB_TYPE_CICS_09 = "09";// 法院查控通知：控制请求待分配
    public final static String MSG_SUB_TYPE_CICS_10 = "10";// 法院查控通知：查询请求待反馈
    public final static String MSG_SUB_TYPE_CICS_11 = "11";// 法院查控通知：控制请求待反馈
    public final static String MSG_SUB_TYPE_CICS_12 = "12";// 法院查控通知：查询反馈待审核
    public final static String MSG_SUB_TYPE_CICS_13 = "13";// 法院查控通知：控制反馈待审核
    public final static String MSG_SUB_TYPE_CICS_14 = "14";// 法院查控通知：控制反馈待发送
    public final static String MSG_SUB_TYPE_CICS_15 = "15";// 法院查控通知：回退请求-查询
    public final static String MSG_SUB_TYPE_CICS_16 = "16";// 法院查控通知：回退请求-查询

    public final static String MSG_ID_CICS_01 = "01";// 法院查控通知：查询请求待分配
    public final static String MSG_ID_CICS_02 = "02";// 法院查控提醒：查询请求未分配
    public final static String MSG_ID_CICS_03 = "03";// 法院查控提醒：控制请求未分配
    public final static String MSG_ID_CICS_04 = "04";// 法院查控提醒：查询请求未反馈
    public final static String MSG_ID_CICS_05 = "05";// 法院查控提醒：控制请求未反馈
    public final static String MSG_ID_CICS_06 = "06";// 法院查控提醒：查询反馈未审核
    public final static String MSG_ID_CICS_07 = "07";// 法院查控提醒：控制反馈未审核
    public final static String MSG_ID_CICS_08 = "08";// 法院查控提醒：控制反馈未发送
    public final static String MSG_ID_CICS_09 = "09";// 法院查控通知：控制请求待分配
    public final static String MSG_ID_CICS_10 = "10";// 法院查控通知：查询请求待反馈
    public final static String MSG_ID_CICS_11 = "11";// 法院查控通知：控制请求待反馈
    public final static String MSG_ID_CICS_12 = "12";// 法院查控通知：查询反馈待审核
    public final static String MSG_ID_CICS_13 = "13";// 法院查控通知：控制反馈待审核
    public final static String MSG_ID_CICS_14 = "14";// 法院查控通知：控制反馈待发送
    public final static String MSG_ID_CICS_15 = "15";// 法院查控通知：回退请求-查询
    public final static String MSG_ID_CICS_16 = "16";// 法院查控通知：回退请求-查询

    /**
     * BOA CUST MSG TYPE
     */
    public final static String MSG_BOA_CICS_0001_INQ_PENDING_MAKE = "BOA_CICS_0001";
    public final static String MSG_BOA_CICS_0002_INQ_PENDING_CHECK = "BOA_CICS_0002";
    public final static String MSG_BOA_CICS_0003_CTL_PENDING_MAKE = "BOA_CICS_0003";
    public final static String MSG_BOA_CICS_0004_CTL_PENDING_CHECK = "BOA_CICS_0004";
    public final static String MSG_BOA_CICS_0005_CTL_PENDING_SEND = "BOA_CICS_0005";
    public final static String MSG_BOA_CICS_0006_INQ_PENDING_MAKE_FIRST_NOTICE = "BOA_CICS_0006";
    public final static String MSG_BOA_CICS_0007_INQ_PENDING_MAKE_SECOND_NOTICE = "BOA_CICS_0007";
    public final static String MSG_BOA_CICS_0008_INQ_PENDING_MAKE_THIRD_NOTICE = "BOA_CICS_0008";
    public final static String MSG_BOA_CICS_0009_INQ_PENDING_CHECK_FIRST_NOTICE = "BOA_CICS_0009";
    public final static String MSG_BOA_CICS_0010_INQ_PENDING_CHECK_SECOND_NOTICE = "BOA_CICS_0010";
    public final static String MSG_BOA_CICS_0011_INQ_PENDING_CHECK_THIRD_NOTICE = "BOA_CICS_0011";
    public final static String MSG_BOA_CICS_0012_CTL_PENDING_MAKE_FIRST_NOTICE = "BOA_CICS_0012";
    public final static String MSG_BOA_CICS_0013_CTL_PENDING_MAKE_SECOND_NOTICE = "BOA_CICS_0013";
    public final static String MSG_BOA_CICS_0014_CTL_PENDING_MAKE_THIRD_NOTICE = "BOA_CICS_0014";
    public final static String MSG_BOA_CICS_0015_CTL_PENDING_CHECK_FIRST_NOTICE = "BOA_CICS_0015";
    public final static String MSG_BOA_CICS_0016_CTL_PENDING_CHECK_SECOND_NOTICE = "BOA_CICS_0016";
    public final static String MSG_BOA_CICS_0017_CTL_PENDING_CHECK_THIRD_NOTICE = "BOA_CICS_0017";
    public final static String MSG_BOA_CICS_0018_CTL_PENDING_SEND_FIRST_NOTICE = "BOA_CICS_0018";
    public final static String MSG_BOA_CICS_0019_CTL_PENDING_SEND_SECOND_NOTICE = "BOA_CICS_0019";
    public final static String MSG_BOA_CICS_0020_CTL_PENDING_SEND_THIRD_NOTICE = "BOA_CICS_0020";
    public final static String MSG_BOA_CICS_0021_INQ_PENDING_SEND = "BOA_CICS_0021";
    public final static String MSG_BOA_CICS_0022_CTL_PENDING_SEND = "BOA_CICS_0022";

    public final static String MSG_BOA_CICS_1001_CTL_CHILD_FAILED = "BOA_CICS_1001";

    public final static String MSG_OPR_ID_TYPE_PERSON = "1";
    public final static String MSG_OPR_ID_TYPE_GROUP = "2";

    /* 未生成对应邮件记录 */
    public final static String MSG_POOL_STATUS_PENDING = "0";
    /* 已生成对应邮件记录, MsgPlatFormGetSendDetailsJob抓取状态为0的记录生成邮件记录，并将状态改成1 */
    public final static String MSG_POOL_STATUS_GEN_OK = "1";
    /* 发送成功，MsgPlatFormSendJob抓取记录为1的记录发送邮件，如果发送成功，将状态修改成2，发送失败将状态修改为3 */
    public final static String MSG_POOL_STATUS_SEND_OK = "2";
    /* 发送失败，MsgPlatFormSendJob抓取记录为1的记录发送邮件，如果发送成功，将状态修改成2，发送失败将状态修改为3 */
    public final static String MSG_POOL_STATUS_SEND_FAILED = "3";

    public final static String MSG_POOL_SEND_TYPE_MAIL = "02";
    public final static String MSG_POOL_SEND_TYPE_SMS = "01";

}

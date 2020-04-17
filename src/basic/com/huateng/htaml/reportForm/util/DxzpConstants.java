package com.huateng.htaml.reportForm.util;
/**
 * 常量定义类
 * @author wanlin.ren
 *
 * 2016-4-6下午3:39:03
 */
public class DxzpConstants {

	//记录状态
	/** 记录状态 - 00 -已接收/已录入 **/
	public static final String REPORT_RECSTATUS_00 = "00";
	/** 记录状态 - 01 -待反馈/待发送 **/
	public static final String REPORT_RECSTATUS_01 = "01";

	/** 记录状态 - 02-反馈成功/发送成功 **/
	public static final String REPORT_RECSTATUS_02 = "02";

	/** 记录状态 - 03-反馈错误/发送错误 **/
	public static final String REPORT_RECSTATUS_03 = "03";

	//审批状态
	/** 审批状态 - 00-未提交  **/
	public static final String REPORT_APPROVESTATUS_00 = "00";

	/** 审批状态 - 01-提交待审核 **/
	public static final String REPORT_APPROVESTATUS_01 = "01";

	/** 审批状态 - 02-审核通过 **/
	public static final String REPORT_APPROVESTATUS_02 = "02";
	
	/** 审批状态 - 03-审核不通过 **/
	public static final String REPORT_APPROVESTATUS_03 = "03";
	
	/** 发送状态 - 00-待发送 **/
	public static final String SEND_STATUS_00 = "00";
	
	//交易类型编码
	/** 交易类型编码 - 100401-案件举报 **/
	public static final String TXCODE_100401 = "100401";	
	
	/** 交易类型编码 - 100402-可疑名单上报-异常开卡**/
	public static final String TXCODE_100402 = "100402";	
	/** 交易类型编码 - 100403- 可疑名单上报-异常开卡**/
	public static final String TXCODE_100403 = "100403";
	/** 交易类型编码 - 100404-可疑名单上报-涉案账户 **/
	public static final String TXCODE_100404 = "100404";
	/** 交易类型编码 - 100405-可疑名单上报-异常事件 **/
	public static final String TXCODE_100405 = "100405";
	
	public static final String TXCODE_100302 = "100302";
	public static final String TXCODE_100304 = "100304";
	public static final String TXCODE_100308 = "100308";

	public static final String TXCODE_100306 = "100306";
	public static final String TXCODE_100310 = "100310";
	
	public static final String TXCODE_100102 = "100102";
	public static final String TXCODE_100104 = "100104";
	public static final String TXCODE_100106 = "100106";
	public static final String TXCODE_100202 = "100202";
	public static final String TXCODE_100204 = "100204";
	public static final String TXCODE_100206 = "100206";
	
	
	//接收方机构ID
	//public static final String TO_ORGANIZATION_ID = "111111000000";
	public static final String TO_ORGANIZATION_ID = "cfcapolice1";
	
	/** 审批状态 - 01-审核通过 **/
	public static final String APPROVESTATUS_01 = "01";
	
	/** 审批状态 - 02-审核不通过 **/
	public static final String APPROVESTATUS_02 = "02";
	
	/** 业务申请编号占位 13位**/
	public static final String APPLICATIONID = "0000000000000";	
	//分配标志
	/** 0-未分配 **/
	public static final String FP_FLAG_NO = "0";
	/** 1-已分配 **/
	public static final String FP_FLAG_YES = "1";
	
	/**止付分配 **/
	public static final String STOP_PAYMENT_FP = "StopPaymentFp";
	/**冻结分配 **/
	public static final String FREEZE_FP = "FreezeFp";
	/**账户分配 **/
	public static final String ACCOUNT_FP = "AccountFp";
	
	/** 行号**/
	public static final String ST_BANKNO = "671290000017";	
	
	/** 传输报文流水号占位 10位**/
	public static final String TRANS_NUMBER = "0000000000";	
	
	/** 是否内转标志**/
	public static final String INTERNAL_FLAG_YES = "1";
	public static final String INTERNAL_FLAG_NO = "0";
	public static final String LISTSOURCE = "200501";
	/**查验类型 0-汇出方查验，1-汇入方查验**/
	public static final String CHECK_OUT = "0";
	public static final String CHECK_IN = "1";

	public static final long  FILE_MAX_SIZE =  1024*1024;
	/**操作员登录状态 0-已签退,1-已登录**/
	public static final String YETLOGOUT_STATUS="0";
	public static final String YETLOGIN_STATUS="1";
	
	/**操作员记录状态 1-创建中,2-修改中,3-删除中,4-可用**/
	public static final String CREATE_IN="1";
	public static final String UPDATE_IN="2";
	public static final String DELETE_IN="3";
	public static final String AVAILABLE="4";
	
	
	/**交易类型编码 100501-TFMS**/
	public static final String TXCODE_TFMS="100501";
	
	/**查验状态 A0-不在黑/灰名单,A1-在黑名单,A2-在灰名单,00-两账户均不在黑/灰名单,01-汇出账户不在相关名单，汇入账户在黑名单,02-汇出账户不在相关名单，汇入账户在灰名单,10-汇出账户在黑名单，汇入账户不在相关名单,11-汇出账户和汇入账户均在黑名单,12-汇出账户在黑名单，汇入账户在灰名单,20-汇出账户在灰名单，汇入账户不在相关名单,21-汇出账户在灰名单，汇入账户在黑名单,22-汇出账户和汇入账户均在灰名单**/
	public static final String A_BZBGLIST="A0";
	public static final String A_ZBLIST="A1";
	public static final String A_ZGLIST="A2";
	public static final String DBZBGLIST="00";
	public static final String HRZHZBLIST="01";
	public static final String HRZHZGLIST="02";
	public static final String HCZHZBLIST="10";
	public static final String HCHRDZBLIST="11";
	public static final String HCBHRGLIST="12";
	public static final String HCZHZGLIST="20";
	public static final String HCGHRBLIST="21";
	public static final String HCHRDZGLIST="22";
	
	/**证件类型 01-身份证,02驾驶证,03-护照,04军官证,05士兵证,06户口本,07港澳居民往来内地通行证,08警官证,09社会保障号,10台湾通报来往内地通行证,11临时身份证,12外国人居住证,13组织机构代码(对公),14统一社会信用代码(对公),15营业执照号(对公),16(原)工商注册号,99其他**/
	public static final String ID_CARD="01";
	public static final String DRIVING_CARD="02";
	public static final String PASSPORT="03";
	public static final String CERTIFICATE_OF_OFFICERS="04";
	public static final String SOLDIER_CARD="05";
	public static final String ACCOUNT_BOOK="06";
	public static final String HONGKONG_CARD="07";
	public static final String POLICE_CARD="08";
	public static final String SOCIAL_SECURITY_NUMBER="09";
	public static final String TAIWAN_CARD="10";
	public static final String TEMP_ID_CARD="11";
	public static final String FOREIGNER_CARD="12";
	public static final String ORGANIZATION_CODE="13";
	public static final String SOCIAL_CREDIT_CODE="14";
	public static final String BUSINESS_LICENSE_CARD="15";
	public static final String REGISTRATION_CODE="16";
	public static final String OTHER="17";
	
	/**增量类型 +增加 -减少**/
	public static final String ADD="+";
	public static final String REDUCE="-";
	
	/**是否存在于渣打客户信息文件 1-存在于EBBS客户信息文件 2-不存在于EBBS客户信息文件**/
	public static final String EXIST="1";
	public static final String NOT_EXIST="2";
	
	/**操作方式 A-新增 U-更新 D-删除**/
	public static final String OPER_ADD="A";
	public static final String OPER_UPDATE="U";
	public static final String OPER_DELETE="D";
	
	/**发送EBBS状态 0-未发送EBBS 1-已发送EBBS 2-发送EBBS成功 3-发送EBBS失败**/
	public static final String EBBS_STATUS_NOSEND="0";
	public static final String EBBS_STATUS_YETSEND="1";
	public static final String EBBS_STATUS_SENDSUCCESS="2";
	public static final String EBBS_STATUS_SENDFAIL="3";
	
	/**操作机构  0011-渣打银行（中国）有限公司 **/
	public static final String OPERATING_MECHANISM="0011";
	public static final String DATATYPE = "AccountNumber";
	
	//渣打卡号前6位
	public static final String BANK_CARDNO1 = "622942";
	public static final String BANK_CARDNO2 = "622994";
}

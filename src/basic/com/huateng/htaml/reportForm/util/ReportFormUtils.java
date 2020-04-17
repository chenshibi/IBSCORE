package com.huateng.htaml.reportForm.util;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.DataFormat;
public class ReportFormUtils {
	
	public static final String APPLICATION_TIME = "applicationTime";//时间查询条件对应字段
	public static final String TRANS_DATE = "transDate";//时间查询条件对应字段
	public static final String QUERY_TM = "queryTm";//时间查询条件对应字段
	public static final String CRT_TM = "crtTm";//时间查询条件对应字段
	public static final String TRANS_TIME = "transTime";//时间查询条件对应字段
	
	public static final String REC_STATUS_00 = "00";//00-已接收/已录入
	public static final String REC_STATUS_01 = "01";//01-待反馈/待发送
	public static final String REC_STATUS_02 = "02";//02-反馈成功/发送成功
	public static final String REC_STATUS_03 = "03";//03-反馈错误/发送错误
	//public static final String CODE_100000 = "100000";//100000-成功
	public static final String FP_FLAG_0 = "0";//0-否 (尚未分配)
	public static final String FP_FLAG_1 = "1";//1-是 (已分配)
	
	public static final String PAGE_01 = "PAGE_01";//止付汇总报表
	public static final String PAGE_02 = "PAGE_02";//冻结汇总报表
	public static final String PAGE_03 = "PAGE_03";//账户查询汇总报表
	public static final String PAGE_04 = "PAGE_04";//可疑上报汇总报表
	public static final String PAGE_05 = "PAGE_05";//查验汇总报表
	public static final String PAGE_06 = "PAGE_06";//个人报表
	public static final String PAGE_07 = "PAGE_07";//企业报表
	public static final String PAGE_08 = "PAGE_08";//账户明细汇总报表
	public static final String PAGE_09 = "PAGE_09";//可疑上报明细报表
	public static final String PAGE_10 = "PAGE_10";//查验明细报表
	public static final String PAGE_11 = "PAGE_11";//上传报表
	public static final String PAGE_12 = "PAGE_12";//主动查验报表
	public static final String PAGE_13 = "PAGE_13";//黑灰名单系统更新结果报表
	public static final String PAGE_14 = "PAGE_14";//黑灰名单账号日报表
	public static final String PAGE_15 = "PAGE_15";//系统日志查询报表
	public static final String PAGE_16 = "PAGE_16";//角色菜单关系报表
	public static final String PAGE_17 = "PAGE_17";//UserReport报表
	public static final String PAGE_18 = "PAGE_18";//自然人对外担保
	public static final String PAGE_19 = "PAGE_19";//自然人中征码
	public static final String PAGE_20 = "PAGE_20";//企业中征码
	
	public static final String DATA_DIC_1319 = "1319";//状态
	public static final String DATA_DIC_1321 = "1321";//是否补流程
	public static final String DATA_DIC_1327 = "1327";//案件类型
	public static final String DATA_DIC_1303 = "1303";//账号类别
	public static final String DATA_DIC_1302 = "1302";//紧急程度
	public static final String DATA_DIC_1301 = "1301";//证件类型
	public static final String DATA_DIC_3102 = "3102";//止付结果
	public static final String DATA_DIC_3104 = "3104";//止付解除结果
	public static final String DATA_DIC_3106 = "3106";//止付延期结果
	public static final String DATA_DIC_1306 = "1306";//未能止付原因
	public static final String DATA_DIC_1305 = "1305";//冻结方式
	public static final String DATA_DIC_3202 = "3202";//冻结结果
	public static final String DATA_DIC_3204 = "3204";//冻结解除结果
	public static final String DATA_DIC_3206 = "3206";//冻结延期结果
	public static final String DATA_DIC_1307 = "1307";//查询主体类别
	public static final String DATA_DIC_1308 = "1308";//查询内容
	public static final String DATA_DIC_3300 = "3300";//查询结果
	public static final String DATA_DIC_1309 = "1309";//借贷标志
	public static final String DATA_DIC_1310 = "1310";//现金标志
	public static final String DATA_DIC_1311 = "1311";//交易是否成功
	public static final String DATA_DIC_1312 = "1312";//执行命令
	public static final String DATA_DIC_3306 = "3306";//查询结果 	! what's the difference between this and DATA_DIC_3300
	public static final String DATA_DIC_3308 = "3308";//动态查询解除结果
	public static final String DATA_DIC_1313 = "1313";//查询内容		! what's the difference between this and DATA_DIC_1308
	public static final String DATA_DIC_1325 = "1325";//冻结措施类型
	public static final String DATA_DIC_1324 = "1324";//权利类型
	public static final String DATA_DIC_1322 = "1322";//是否主动发送初始节点
	public static final String DATA_DIC_1323 = "1323";//案件举报类型
	public static final String DATA_DIC_3402 = "3402";//案件举报结果
	public static final String DATA_DIC_1320 = "1320";//交易类型编码 
	public static final String DATA_DIC_3500 = "3500";//查验状态
	public static final String DATA_DIC_1314 = "1314";//事件特征码
	
	public static String getBankNameFromTfmsOrganCfg(String brno) throws CommonException{
	
		System.out.println("报表获取机构名称出错: result is null or result.size() > 1 while get BankName from TfmsOrganCfg by brno ");
		return brno;
	}
	
	public static String appendTimeCondition(String timeField,String qdatebegin,String qdateend){
		//attention! table name must be "t"
		String hql = "";
		if(!DataFormat.isEmpty(qdatebegin)){
			hql += " and t."+timeField+" >='"+qdatebegin+"000000'";
		}
		if(!DataFormat.isEmpty(qdateend)){
			hql += " and t."+timeField+" <='"+qdateend+"235959'";
		}
		return hql;
	}
	
	
	public static String getCurrentDate8(){
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}

	



}

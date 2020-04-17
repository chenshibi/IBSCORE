/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.ebank.framework.report.common;

public class ReportConstant {

    public static final String CURRENT_COUNTY_CODE = "CHN";

    public static final String APPROVE_FUNC_ID = "1008";// 主管确认功能编码

    public static final String BAK_FILE_EXT = ".BAK";

    public static final String BAK_DATA_FILE_NAME = "TopReport_DataBak.zip";

    public static final String BAK_DATA_UNZIP_ = "TEMP_";

    public static final boolean BOP_SUB_FILE_BRNO_TYPE = false;// 是否采用当前登录机构号作为上报文件生成机构号
                                                               // true为是，flase采用参数配置的机构号

    public static final String DOWN_LOAD_PACK_ZIP_EXT = ".ZIP";

    public static final String JH_SENDANDREP_FILE_EXT = "XML";// 金宏工程上报、回执文件扩展名

    public static final boolean SUB_FILE_CREATE_AUTO_SEND = true;// 生成上报文件后是否自动上传

    public static final boolean IMP_FILE_IS_AUTO_ANALY = true;// 定时导入后是否自动进行数据分析

    public static final boolean CREATE_SUB_FILE_IS_WORKDATE = false;// 是否按工作日期生成上报文件，还是只检查审核已确认的记录

    public static final String QUERY_EXP_EXCEl_SPLIT = ",";

    public static final String SAVE_QUERY_LOG_SIGN = "isSaveLog";

    public static final String QUERY_LOG_BUSI_NAME = "QUERY_LOG_BUSI_NAME";

    public static final String BOP_SUB_FILE_FEEDBACK = "ERR";// bop接口反馈文件标识

    public static final String SUB_FILE_DATE_TYPE = "01";// 01-系统日期 02-工作日期
                                                         // //上报文件名及包名

    public static final int TASK_VALUE_NO = 1001;// 复核流程序号

    public static final int SUB_FILE_NO = 2001;// 文件序号

    public static final int SUB_FILE_REC_ROW = 5000;// 每个上报文件记录行数

    public static final int DATA_DIC_BUSI_TYPE_NO = 35;// 业务类型

    public static final int DATA_DIC_BOP_APP_TYPE_NO = 17;// 应用类型

    public static final boolean BUSINESS_NO_DATE_CURRENT = false;// 编号尚未生成日期是否采用当前工作日期

    public static final String BOP_ANALY_PROCESS_COUNT = "BOP0001";// 01-BOP用于统计处理文件数量

    public static final String BUSI_NO_CODE = "*";

    public static final String REPORT_FLAG = "1-0-0-0-0";

    public final static String POINT = ".";

    public static final String PDF_FILE_POSTFIX = "pdf";

    public static final String EXCEL_FILE_POSTFIX = "xls";

    public static final String HTML_FILE_POSTFIX = "html";

    public static final String XMLJ_FILE_POSTFIX = "xml";

    public static final String RTF_FILE_POSTFIX = "rtf";

    public static final String CSV_FILE_POSTFIX = "csv";

    public static final String REPORT_PROPERTY_REPORT_GEN_PATH = "reportGenPath";

    public static final String REPORT_PROPERTY_JASPER_FILE_PATH = "reportJasperFilePath";

    public static final String REPORT_LOACL_DATA_PARAMGROUP = "LOCDATA";

    public static final String REPORT_REMOTE_DATA_PARAMGROUP = "REMODATA";

}

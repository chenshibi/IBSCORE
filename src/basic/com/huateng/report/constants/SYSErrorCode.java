package com.huateng.report.constants;

import com.huateng.ebank.business.common.MessageResourceUtil;
import com.huateng.ebank.framework.exceptions.CommonException;

public class SYSErrorCode {


    public static final String INVALID_OP_TYPE = "GDAML_0001"; //操作类型无效
    public static final String SAME_RECORD_EXIST = "GDAML_0002"; //存在相同记录，请重新查询
    public static final String INVALID_STATUS = "GDAML_0003"; //记录状态不正确，请重新查询
    public static final String SAME_RECORD_IN_TMP = "GDAML_0004"; //存在相同未审核记录
    public static final String SAME_OPERATOR = "GDAML_0005"; //录入操作员和审核操作员相同，不能审核
    public static final String RECORD_NOT_EXIST = "GDAML_0006"; //记录不存在
    public static final String INVALID_DATA_LEN = "GDAML_0007"; //数据长度不合法
    public static final String INVALID_DATA_ERR = "GDAML_0013"; //字段校验出错

    public static final String INVALID_SYSTEM_STATUS = "GDAML_0008"; //数据长度不合法
    public static final String RECORD_ALREADY_CHECK = "GDAML_0009"; //记录已被审核
    public static final String INVALID_DATA_FORMAT = "GDAML_0010"; //输入格式不合法
    public static final String DATADIC_NOT_EXIST = "GDAML_0011"; //记录不存在数据字典中

    public static final String ZIP_NOT_DOWNLOAD = "GDAML_0012"; //当日存在未下载的上报文件
    public static final String NO_KEYI_NEED_REPORTED = "GDAML_0014"; //不存在待生成的可疑报送批次

    public static final String TLRNO_NO_CONFIRM_FUNCTION = "GDAML_0015"; //操作员没有交易审核确认的权限

    public static final String AML_SYSTEM_STATUS_ERROR = "AML_SYSTEM_STATUS_ERROR"; //系统状态不正确，应该为[%a]，实际为[%b]

    public static final String UNCOMPLETE_TASK = "UNCOMPLETE_TASK"; //有未完成的交易
    public static final String HAVE_COMPLETED = "HAVE_COMPLETED"; //已经完成

    public static final String GRANT_AUTH_TASK="GDAML_0017"; //企业证书没有授予证书权限

    public static final String BING_GRANT_AUTH="GDAML_0018"; 

    public static void throwCommonException(String msg, String key) throws CommonException {
        CommonException ce = new CommonException(MessageResourceUtil.getErrorMessage("OPER_FAILED") + msg);
        ce.setKey(key);
        throw ce;
    }

    public static void throwCommonException(String msg, String key, Object[] objs) throws CommonException {
        CommonException ce = new CommonException(MessageResourceUtil.getErrorMessage("OPER_FAILED") + msg);
        ce.setKey(key);
        ce.setObjs(objs);
        throw ce;
    }

}


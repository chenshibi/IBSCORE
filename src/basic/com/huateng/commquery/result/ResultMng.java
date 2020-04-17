package com.huateng.commquery.result;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.lang.StringUtils;

import com.huateng.common.DateUtil;
import com.huateng.common.SystemDProperty;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.config.bean.base.ICommonQueryField;
import com.huateng.commquery.process.FieldValueProcess;
import com.huateng.exception.AppException;

public class ResultMng {
    public static Result fillResultByList(ICommonQueryBean paramICommonQueryBean, ServletRequest paramServletRequest,
            List paramList, Result paramResult) throws AppException {
        if (paramList == null) {
            return paramResult;
        }
        Iterator localIterator1 = paramList.iterator();
        Iterator localIterator2 = null;
        ICommonQueryField localICommonQueryField = null;
        FieldData localFieldData = null;
        RowData localRowData = null;
        DecimalFormat localDecimalFormat = new DecimalFormat();
        localDecimalFormat.setGroupingSize(0);
        while (localIterator1.hasNext()) {
            Object localObject2 = localIterator1.next();
            JXPathContext localJXPathContext = JXPathContext.newContext(localObject2);
            localRowData = new RowData();
            localIterator2 = paramICommonQueryBean.getFields().keySet().iterator();
            while (localIterator2.hasNext()) {
                String str1 = (String) localIterator2.next();
                localICommonQueryField = paramICommonQueryBean.getField(str1);
                String str4 = StringUtils.defaultString(localICommonQueryField.getAnyValue("xpath"), "");
                String str2;
                if (StringUtils.isEmpty(str4)) {
                    str2 = null;
                } else {
                    Object localObject1;
                    try {
                        localObject1 = _$1(localJXPathContext, str4);
                    } catch (Exception localException) {
                        localObject1 = null;
                    }
                    if ((localObject1 instanceof Date)) {
                        if ((!StringUtils.isEmpty(localICommonQueryField.getAnyValue("datatype")))
                                && (localICommonQueryField.getAnyValue("datatype").equalsIgnoreCase("timestamp"))) {
                            if (localObject1 == null) {
                                str2 = null;
                            } else {
                                str2 = DateUtil.formatTimestamp((Date) localObject1);
                            }
                        } else if (localObject1 == null) {
                            str2 = null;
                        } else {
                            str2 = DateUtil.formatDate((Date) localObject1);
                        }
                    } else {
                        str2 = localObject1 == null ? null : localObject1.toString();
                    }
                }
                String str3;
                if (str2 == null) {
                    str2 = _$1(paramServletRequest, localICommonQueryField);
                    str3 = _$2(paramServletRequest, localICommonQueryField, str2);
                } else {
                    str3 = _$1(paramServletRequest, localICommonQueryField, str2);
                }
                localFieldData = new FieldData(str2, str3.trim());
                localRowData.addField(str1, localFieldData);
            }
            paramResult.addRow(localRowData);
        }
        return paramResult;
    }

    public static Result fillResultByObject(ICommonQueryBean paramICommonQueryBean, ServletRequest paramServletRequest,
            Object paramObject, Result paramResult) throws AppException {
        if (paramObject == null) {
            return paramResult;
        }
        Iterator localIterator = null;
        ICommonQueryField localICommonQueryField = null;
        FieldData localFieldData = null;
        RowData localRowData = null;
        localRowData = new RowData();
        localIterator = paramICommonQueryBean.getFields().keySet().iterator();
        JXPathContext localJXPathContext = JXPathContext.newContext(paramObject);
        DecimalFormat localDecimalFormat = new DecimalFormat();
        localDecimalFormat.setGroupingSize(0);
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            localICommonQueryField = paramICommonQueryBean.getField(str1);
            String str4 = StringUtils.defaultString(localICommonQueryField.getAnyValue("xpath"), "");
            String str2;
            if (StringUtils.isEmpty(str4)) {
                str2 = null;
            } else {
                Object localObject;
                try {
                    localObject = _$1(localJXPathContext, str4);
                } catch (Exception localException) {
                    localObject = null;
                }
                if ((localObject instanceof Date)) {
                    if ((!StringUtils.isEmpty(localICommonQueryField.getAnyValue("datatype")))
                            && (localICommonQueryField.getAnyValue("datatype").equalsIgnoreCase("timestamp"))) {
                        str2 = DateUtil.formatTimestamp((Date) localObject);
                    } else if ((localObject instanceof Double)) {
                        str2 = localDecimalFormat.format((Double) localObject);
                    } else {
                        str2 = DateUtil.formatDate((Date) localObject);
                    }
                } else {
                    str2 = localObject == null ? null : localObject.toString();
                }
            }
            String str3;
            if (str2 == null) {
                str2 = _$1(paramServletRequest, localICommonQueryField);
                str3 = _$2(paramServletRequest, localICommonQueryField, str2);
            } else {
                str3 = _$1(paramServletRequest, localICommonQueryField, str2);
            }
            localFieldData = new FieldData(str2, str3.trim());
            localRowData.addField(str1, localFieldData);
        }
        paramResult.addRow(localRowData);
        return paramResult;
    }

    public static Result fillResultDefault(ICommonQueryBean paramICommonQueryBean, ServletRequest paramServletRequest,
            Result paramResult) throws AppException {
        Iterator localIterator = null;
        ICommonQueryField localICommonQueryField = null;
        FieldData localFieldData = null;
        RowData localRowData = null;
        localRowData = new RowData();
        localIterator = paramICommonQueryBean.getFields().keySet().iterator();
        while (localIterator.hasNext()) {
            String str1 = (String) localIterator.next();
            localICommonQueryField = paramICommonQueryBean.getField(str1);
            String str2 = _$1(paramServletRequest, localICommonQueryField);
            String str3 = _$2(paramServletRequest, localICommonQueryField, str2);
            localFieldData = new FieldData(str2, str3.trim());
            localRowData.addField(str1, localFieldData);
        }
        paramResult.addRow(localRowData);
        return paramResult;
    }

    private static String _$1(ServletRequest paramServletRequest, ICommonQueryField paramICommonQueryField)
            throws AppException {
        String str = paramICommonQueryField.getAnyValue("default");
        if (str == null) {
            return "";
        }
        return FieldValueProcess.processEL(paramServletRequest, str);
    }

    private static String _$2(ServletRequest paramServletRequest, ICommonQueryField paramICommonQueryField,
            String paramString) throws AppException {
        return FieldValueProcess.processMT(paramServletRequest, paramICommonQueryField, paramString);
    }

    private static String _$1(ServletRequest paramServletRequest, ICommonQueryField paramICommonQueryField,
            String paramString) throws AppException {
        return FieldValueProcess.process(paramServletRequest, paramICommonQueryField, paramString);
    }

    private static Object _$1(JXPathContext paramJXPathContext, String paramString) {
        if (paramString.indexOf("|") != -1) {
            String[] localObject1 = paramString.split("\\|");
            String str1 = "";
            String str2 = "";
            Object localObject2 = "";
            for (int i = 0; i < localObject1.length; i++) {
                localObject2 = _$1(paramJXPathContext, localObject1[i]);
                if (localObject2 == null) {
                    str2 = str2 + "";
                } else {
                    str2 = str2 + String.valueOf(localObject2);
                }
            }
            return str2;
        }
        try {
            Object localObject1 = paramJXPathContext.getValue(paramString);
            return localObject1;
        } catch (Exception localException) {
            if (!SystemDProperty.isProductionMode()) {
                localException.printStackTrace();
            }
        }
        return "";
    }
}

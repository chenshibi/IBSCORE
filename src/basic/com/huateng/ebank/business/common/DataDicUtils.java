/**
 *
 */
package com.huateng.ebank.business.common;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import com.huateng.ebank.business.common.service.DataDicService;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.util.SystemDictionaryUnit;

import resource.bean.basic.DataDic;

/**
 * Title: DataDicUtils Description: Copyright: Copyright (c) 2007 Company:
 * Shanghai Huateng Software Systems Co., Ltd.
 * 
 * @author shen_antonio
 * @version 1.1, 2007-11-23
 */
public class DataDicUtils {

    public final static String TBL_NM = "DATA_DIC";

    /**
     * <P>
     * initDataDic:(这里用一句话描述这个方法的作用)
     * <P>
     * 适用条件: (这里描述这个方法适用条件 – 可选)
     * <P>
     * 执行流程: (这里描述这个方法的执行流程 – 可选)
     * <P>
     * 使用方法: (这里描述这个方法的使用方法 – 可选)
     * <P>
     * 注意事项: (这里描述这个方法的注意事项 – 可选)
     *
     * @param locale
     * @throws CommonException
     * @throws @since
     *             DataDicUtils Ver1.1
     */
    public static void initDataDic(Locale locale) throws CommonException {
        try {
            DataDicService dataDicService = DataDicService.getInstance();
            /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 begin . */
            List dataDicList = dataDicService.loadAllSort();
            Iterator it = dataDicList.iterator();
            DataDic dataDic;
            String tblNm = TBL_NM;
            while (it.hasNext()) {
                dataDic = (DataDic) it.next();
                String dataName = dataDic.getDataName();
                if (locale != null) {
                    tblNm = TBL_NM + locale;
                }
                /* modify by zhiguo.zhao JIRA: FPP-3 2011-12-16 end . */
                SystemDictionaryUnit.addRecord(tblNm, String.valueOf(dataDic.getDataTypeNo()),
                        dataDic.getDataNo().trim(), dataName);

            }
        } catch (Exception ex) {
            throw new CommonException(ex.getMessage(), ex);
        }
    }

    /**
     * 获取字典值
     * 
     * @param dicType
     * @param dicNo
     * @return
     */
    public static String getDicName(String dicType, String dicNo) {
        GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
        if (gi != null && gi.getLocale() != null) {
            return SystemDictionaryUnit.getFieldDesc(TBL_NM + gi.getLocale(), dicType, dicNo);
        } else {
            return SystemDictionaryUnit.getFieldDesc(TBL_NM, dicType, dicNo);
        }
    }

    /**
     * 更具数据类型，获取全部字典值
     * 
     * @param dicType
     * @return
     */
    public static LinkedHashMap getAllDicType(String dicType) {
        GlobalInfo gi = GlobalInfo.getCurrentInstanceWithoutException();
        if (gi != null && gi.getLocale() != null) {
            return SystemDictionaryUnit.getAllFieldDesc(TBL_NM + gi.getLocale(), dicType);
        } else {
            return SystemDictionaryUnit.getAllFieldDesc(TBL_NM, dicType);
        }
    }
}

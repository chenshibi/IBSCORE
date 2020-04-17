/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.business.common.service;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.huateng.ebank.business.common.DAOUtils;
import com.huateng.ebank.business.common.generator.GeneratorFactory;
import com.huateng.ebank.business.common.generator.GetBrcodeIDGenerator;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;

import resource.bean.basic.PfSysParam;
import resource.dao.basic.PfSysParamDAO;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 通用service
 */
public class CommonService {

    protected CommonService() {
    }

    /**
     * Get instance of common service
     *
     * @return
     */
    public synchronized static CommonService getInstance() {
        return (CommonService) ApplicationContextUtils.getBean(CommonService.class.getName());
    }

    /**
     *
     * Description: 校验组织机构代码证是否正确，例：23893788-0
     *
     * Modified by Robin Suo For Jira BMS-2329 支持组织机构代码中前8位有字母的情况
     *
     * @param no
     *            组织机构代码证
     * @return 是否正确的boolean值
     * @author mengyf
     * @version v1.0,2008-11-19
     */
    public boolean checkOrgCode(String no) {
        // 如果组织机构代码证是空
        if (StringUtils.isBlank(no)) {
            return false;
        }

        // 去掉空字符串
        String orgCode = StringUtils.trimToEmpty(no);

        // 组织机构代码基本格式10位的有效组织机构代码， 前8位为有效数字，第9位为“－”，第10位为校验位
        if (!Pattern.matches("^[A-Z0-9]{8}\\-[\\d{1}|X]$", orgCode)) {
            return false;
        }

        int[] tempInt = new int[8];
        int[] factor = { 3, 7, 9, 10, 5, 8, 4, 2 };

        int sum = 0;
        if (orgCode.charAt(8) != 45) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            int c = orgCode.charAt(i);
            if (c <= 122 && c >= 97) {
                return false;
            }
        }

        /*
         * Blocked by Robin Suo For Jira BMS-2329 int fir_value =
         * orgCode.charAt(0); int sec_value = orgCode.charAt(1);
         *
         * if (fir_value >= 65 && fir_value <= 90) { tempInt[0] = (fir_value +
         * 32) - 87; } else if (fir_value >= 48 && fir_value <= 57) { tempInt[0]
         * = fir_value - 48; } else { return false; } sum += factor[0] *
         * tempInt[0];
         *
         * if (sec_value >= 65 && sec_value <= 90) { tempInt[1] = (sec_value -
         * 65) + 10; } else if (sec_value >= 48 && sec_value <= 57) { tempInt[1]
         * = sec_value - 48; } else { return false; } sum += factor[1] *
         * tempInt[1];
         *
         */

        for (int j = 0; j < 8; j++) {
            if (orgCode.charAt(j) >= 65 && orgCode.charAt(j) <= 90) {
                tempInt[j] = orgCode.charAt(j) - 65 + 10;
            } else if (orgCode.charAt(j) >= 48 && orgCode.charAt(j) <= 57) {
                tempInt[j] = orgCode.charAt(j) - 48;
            } else {
                return false;
            }
            sum += factor[j] * tempInt[j];
        }

        // 计算获得最后真正的校验码
        int balance = 11 - sum % 11;

        // 最后一位校验码
        int last_value = orgCode.charAt(9);

        // 判断校验位
        if (!((last_value == 88 && balance == 10) // 条件1：如果校验码是'X'的话，计算而得的值为10
                || (balance == 11 && last_value == 48) // 条件2：如果计算而得的值为11，校验码是'0'的
                || balance == last_value - 48 // 条件3：其他情况都应该是：balance ==
                                              // last_value -
        // 48
        )) {
            return false;
        }

        return true;
    }

    /**
     * 生成机构编号
     *
     * @author yjw
     * @return
     * @throws CommonException
     */
    public String getBrcodeID() throws CommonException {
        GetBrcodeIDGenerator GetBrcodeIDGenerator = (GetBrcodeIDGenerator) GeneratorFactory
                .getGenerator("GetBrcodeIDGenerator");
        String brcodeId = GetBrcodeIDGenerator.gen(null);
        return brcodeId;
    }

    /**
     *
     * Description: TODO
     * 
     * @param
     * @return PfSysParam
     * @exception @author
     *                Administrator
     * @version v1.0,2008-11-15
     */
    public String getSysParamDef(String paramId, String magicId, String defaultVal) throws CommonException {
        PfSysParamDAO pfSysParamDAO = DAOUtils.getPfSysParamDAO();
        PfSysParam param = pfSysParamDAO.query(magicId, paramId);
        if (param == null) {
            param = new PfSysParam();
        }
        if (StringUtils.isBlank(param.getParamValueTx())) {
            return defaultVal;
        } else {
            return param.getParamValueTx();
        }
    }
}

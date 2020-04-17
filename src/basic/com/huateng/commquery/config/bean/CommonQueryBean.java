package com.huateng.commquery.config.bean;

import com.huateng.commquery.config.bean.base._CommonQueryBean;
import com.huateng.ebank.business.common.MessageResourceUtil;

public class CommonQueryBean extends _CommonQueryBean {

    @Override
    public String getAnyValueDefault(String paramString1, String paramString2) {
        String value = super.getAnyValueDefault(paramString1, paramString2);
        return MessageResourceUtil.getMessage(value);
    }

    @Override
    public String getAnyValue(String paramString) {
        String value = super.getAnyValue(paramString);
        return MessageResourceUtil.getMessage(value);
    }
}

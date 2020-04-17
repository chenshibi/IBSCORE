package com.huateng.commquery.config.bean;

import com.huateng.commquery.config.bean.base._CommonQueryOperationElement;
import com.huateng.ebank.business.common.MessageResourceUtil;

public class ButtonOperationElement extends _CommonQueryOperationElement {
    public static final String type = "Button";

    public String getType() {
        return null;
    }

    public Object getValue() {
        return null;
    }

    public boolean isShow(Object paramObject) {
        return true;
    }

    @Override
    public String getAnyValue(String paramString) {
        String value = super.getAnyValue(paramString);
        return MessageResourceUtil.getMessage(value);
    }

    @Override
    public String getAnyValue(String paramString1, String paramString2) {
        String value = super.getAnyValue(paramString1, paramString2);
        return MessageResourceUtil.getMessage(value);
    }
}
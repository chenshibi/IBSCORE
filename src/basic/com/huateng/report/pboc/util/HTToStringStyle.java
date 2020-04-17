package com.huateng.report.pboc.util;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringStyle;

public class HTToStringStyle extends ToStringStyle{
	private static final long serialVersionUID = 1L;
    public static final ToStringStyle HT_STYLE = new HTToStringStyle();

    public HTToStringStyle() {
        this.setContentStart("");
        this.setFieldSeparator(SystemUtils.LINE_SEPARATOR);
        this.setFieldSeparatorAtStart(true);
        this.setContentEnd("");
        this.setUseShortClassName(true);
        this.setUseIdentityHashCode(false);
        this.setUseClassName(false);
        this.setFieldSeparatorAtStart(false);
    }

    private Object readResolve() {
        return ToStringStyle.MULTI_LINE_STYLE;
    }
}

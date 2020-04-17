package com.huateng.ebank.business.common;

import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class ROOTDAOUtils extends BaseDAOUtils {
    final public static ROOTDAO getROOTDAO() {
        return (ROOTDAO) ApplicationContextUtils.getBean("ROOTDAO");
    }

}

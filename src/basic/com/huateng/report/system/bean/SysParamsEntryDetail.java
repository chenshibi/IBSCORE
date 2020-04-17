package com.huateng.report.system.bean;

import resource.bean.basic.SysParams;

/**
 * 
 * author by 计翔 2012.9.5 系统参数新旧信息对比的bean
 */
public class SysParamsEntryDetail {
    private SysParams sysparams;
    private SysParams old_sysparams;

    public SysParams getSysparams() {
        return sysparams;
    }

    public void setSysparams(SysParams sysparams) {
        this.sysparams = sysparams;
    }

    public SysParams getOld_sysparams() {
        return old_sysparams;
    }

    public void setOld_sysparams(SysParams oldSysparams) {
        old_sysparams = oldSysparams;
    }

}

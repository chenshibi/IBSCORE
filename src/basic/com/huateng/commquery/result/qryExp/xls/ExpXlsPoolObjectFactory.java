package com.huateng.commquery.result.qryExp.xls;

/**
 * 用于对象缓冲池中的对象操作：创建、清除、挂起等
 * 
 * @author 116091
 *
 */
public class ExpXlsPoolObjectFactory extends ExpPoolObjectFactory {
    /**
     * for makeObject we'll simply return a new buffer 用于在必要时产生新的对象
     */
    public Object makeObject() {
        XLSExport xls = new XLSExport();
        xls.setDesc("Export XLS FILE POOL, INDEX=[" + System.currentTimeMillis() + "], description:[]");
        return xls;
    }
}

package com.huateng.ebank.business.common;

/**
 * <PRE>
 * Filename:    BizLogThreadPoolExecutor.java  
 * Description: interface for globaldata 
 * Copyright:   Copyright (c)2008
 * Company:     Shanghai Huateng Software Systems Co., Ltd.
 * </PRE>
 * 
 * @author shen_antonio
 * @version 1.0
 * 
 *          <PRE>
 * Create at:   2011-6-25 下午12:14:33  
 * Modification History:  
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 *          </PRE>
 */
public interface IGlobalData extends java.io.Serializable {

    /**
     * KEY_GLOBAL_INFO: http session key
     * 
     * @since Ver 1.0
     */
    public final static String KEY_GLOBAL_INFO = "GLOBAL_INFO";

    /**
     * TXN_STATUS_02_S: txn status flag, success
     * 
     * @since Ver 1.0
     */
    public final static String TXN_STATUS_02_S = "02";

    /**
     * TXN_STATUS_02_F: txn status flag, fail
     * 
     * @since Ver 1.0
     */
    public final static String TXN_STATUS_02_F = "99";

}

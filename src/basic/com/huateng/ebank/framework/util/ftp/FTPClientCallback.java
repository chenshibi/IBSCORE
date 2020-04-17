/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */
package com.huateng.ebank.framework.util.ftp;

import java.io.InputStream;

/**
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * @date 2005-7-28
 * 
 *       call back interface of the ftp client.
 */
public interface FTPClientCallback {
    /**
     * 执行ftp过程.
     * 
     * @param inputStream
     * @throws Exception
     */
    public void doFtp(InputStream inputStream) throws Exception;
}

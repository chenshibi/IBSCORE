/*
 * Created on 2005-2-6
 *
 * $Id: CommonException.java,v 1.2 2005/05/25 08:47:30 liuwen Exp $
 *
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.huateng.ebank.framework.exceptions;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.huateng.exception.AppException;

/**
 * @author liu_wen@huateng.com
 * @version $Revision: 1.2 $
 *
 *          应用异常的基类。 可以使用
 *          <code>com.huateng.ebank.framework.util.ExceptionUtil</code>
 *          类方便的掷出此异常。 可以和STRUTS中的ApplicationResources结合使用。
 *
 *          例如： 在ApplicationResources中定义 errors.required={0}不能为空, 错误代码{1}。
 *
 *          我们可以相对应的构造异常： key="errors.required"; objs={"帐号","E00001"};
 *
 *          错误信息会被替换为: 帐号不能为空，错误代码E00001。
 */
public class CommonException extends AppException {
    /**
     * 
     */
    private static final long serialVersionUID = -7337834587421303236L;

    /**
     * error key, see struts's ApplicationResources
     */
    private String key;

    /**
     * the real value of the param in the error messages. for example
     *
     */
    private Object[] objs = null;

    public CommonException() {
        super();
    }

    public CommonException(String errorMsg) {
        super(errorMsg);
        this.errMessage = errorMsg;
    }

    public CommonException(String key, String errorMsg) {
        super("", key, errorMsg);
        this.errMessage = errorMsg;
        this.key = key;
    }

    public CommonException(String errorMsg, Throwable t) {
        super(errorMsg, t);
        this.errMessage = errorMsg;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public Object[] getObjs() {
        return objs;
    }

    public void setObjs(Object[] objs) {
        this.objs = objs;
    }

    public String message() {
        return new ToStringBuilder(this).append("message", this.getMessage()).append("key", key).toString();
    }

    @Override
    public String toString() {
        return message();
    }

}
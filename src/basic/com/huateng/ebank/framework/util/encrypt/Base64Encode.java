/*
 * Created on 2005-2-21
 * $Id: Base64Encode.java,v 1.1 2005/06/21 10:45:27 liuwen Exp $
 * 
 * Copyright 2005 Shanghai Huateng Software, Limited. All rights reserved.
 * HUATENG PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.huateng.ebank.framework.util.encrypt;

import com.sun.jndi.toolkit.chars.BASE64Decoder;
import com.sun.jndi.toolkit.chars.BASE64Encoder;

/**
 * 
 * @author <a href="mailto:liu_wen@huateng.com">Liu Wen</a>
 * @version $Revision: 1.1 $
 * 
 *          Base64 encode/decode class.
 */
public class Base64Encode {

    public Base64Encode() {
    }

    // 编码
    public static byte[] byBase64Encode(byte[] inByte) throws Exception {
        // base64 编码
        BASE64Encoder base64encoder = new BASE64Encoder();
        byte[] returnByte = (base64encoder.encode(inByte)).getBytes();
        // System.out.println(new String(returnByte));
        return returnByte;
    }

    // 解码
    public static byte[] byBase64Descode(byte[] inByte) throws Exception {
        // base64 解码
        BASE64Decoder base64decoder = new BASE64Decoder();
        byte[] returnByte = base64decoder.decodeBuffer(new String(inByte));
        // System.out.println(new String(returnByte));
        return returnByte;
    }

}

/**
 * $Log: Base64Encode.java,v $ Revision 1.1 2005/06/21 10:45:27 liuwen *** empty
 * log message ***
 *
 * Revision 1.1.1.1 2005/06/13 12:36:59 liuwen import
 *
 * Revision 1.2 2005/04/07 04:15:48 liuwen web service function is added.
 *
 */
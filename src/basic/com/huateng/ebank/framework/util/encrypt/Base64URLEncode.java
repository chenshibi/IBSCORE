package com.huateng.ebank.framework.util.encrypt;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 
 * @author tuyuan
 *
 */
public class Base64URLEncode extends Base64Encode {
    private static final String ENCODE = "UTF-8";

    // 编码
    public static String byBase64Encode(String str) throws Exception {
        byte[] temp = byBase64Encode(str.getBytes(ENCODE));

        return URLEncoder.encode(new String(temp, ENCODE), ENCODE);
    }

    // 解码
    public static String byBase64Descode(String str) throws Exception {
        // base64 解码
        byte temp[] = byBase64Descode(URLDecoder.decode(str, ENCODE).getBytes(ENCODE));
        return new String(temp, ENCODE);
    }
}

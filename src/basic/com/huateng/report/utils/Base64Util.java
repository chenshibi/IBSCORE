package com.huateng.report.utils;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Decoder;

import java.io.UnsupportedEncodingException;

public class Base64Util {

    private static final Logger logger = LoggerFactory.getLogger(Base64Util.class);

    private static final String UTF_8 = "UTF-8";

    /**
     * 对给定的字符串进行base64解码操作
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }

        return null;
    }
    /**
     * Base64解码
     * @param str
     * @return
     */
    public static String decode(String str) {
        try {
        	if (str == null)
                return null;
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                byte[] b = decoder.decodeBuffer(str);
                return new String(b,"UTF-8");
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e) {
        	logger.info("---------------Base64 解码异常----------------");
        }
        return null;
    }

    /**
     * 对给定的字符串进行base64加密操作
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            logger.error(inputData, e);
        }

        return null;
    }

    public static void main(String[] args) {
    	String aa=Base64Util.encodeData("S274590@cb");
        System.out.println(aa);
        System.out.println(Base64Util.decodeData(aa));
    }

}
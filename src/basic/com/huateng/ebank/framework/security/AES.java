package com.huateng.ebank.framework.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密
 * 
 * @author zhiguo.zhao
 * 
 */
public class AES implements IEncryption {

    /** 算法,此处默认AES */
    protected String algorithm;

    /** 这里可以设置128或者256位加密 */
    protected int size;

    public AES(int size) {
        algorithm = "AES";
        this.size = size;
    }

    private SecretKeySpec getKey(String salt) {
        SecretKeySpec key = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance(algorithm);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(salt.getBytes());
            kgen.init(size, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            key = new SecretKeySpec(enCodeFormat, algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return key;
    }

    private byte[] _encrypt(String plaintext, String salt) {
        try {
            SecretKeySpec key = getKey(salt);
            Cipher cipher = Cipher.getInstance(algorithm);// 创建密码器
            byte[] byteContent = plaintext.getBytes();// "UTF-8"
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     * 
     * @param plaintext
     *            需要加密的内容
     * @param salt
     *            加密密钥
     * @return String 加密后的字符串
     */
    public String encrypt(String plaintext, String salt) {
        return byte2Hex(_encrypt(plaintext, salt));
    }

    /**
     * 解密
     * 
     * @param ciphertext
     *            待解密内容
     * @param salt
     *            解密密钥
     * @return byte[]
     */
    private byte[] _decrypt(byte[] ciphertext, String salt) {
        try {
            SecretKeySpec key = getKey(salt);
            Cipher cipher = Cipher.getInstance(algorithm);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(ciphertext);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * 
     * @param ciphertext
     *            密文
     * @param salt
     *            解密密钥
     * @return String
     */
    public String decrypt(String ciphertext, String salt) {
        return new String(_decrypt(hex2Byte(ciphertext), salt));
    }

    /**
     * 将二进制转换成16进制
     * 
     * @param buf
     * @return String
     */
    private String byte2Hex(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     * 
     * @param hexStr
     * @return byte[]
     */
    private byte[] hex2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}
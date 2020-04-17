package com.huateng.ebank.framework.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.huateng.ebank.business.common.SystemConstant;

public class CryptoUtil {

    /**
     * 加密
     * 
     * @param content
     *            需要加密的内容
     * @param password
     *            加密密码
     * @return
     */
    public static byte[] encrypt(String content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
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
     * @param content
     *            待解密内容
     * @param password
     *            解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(password.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
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

    public static void main(String[] args) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance("AES"); // 获取密匙生成器
            kg.init(128); // 初始化
            // DES算法必须是56位
            // DESede算法可以是112位或168位
            // AES算法可以是128、192、256位
            SecretKey key = kg.generateKey(); // 生成密匙，可用多种方法来保存密匙

            // 加密：
            Cipher cp = Cipher.getInstance("AES"); // 创建密码器
            System.out.println(cp.getProvider().getName());
            System.out.println(cp.getProvider().getInfo());
            System.out.println(cp.getProvider().toString());
            System.out.println(cp.getProvider().getVersion());

            cp.init(Cipher.ENCRYPT_MODE, key);
            // 初始化
            String str = "test";
            byte[] ptext = str.getBytes("UTF8");
            byte[] ctext = cp.doFinal(ptext); // 加密
            str = new String(ctext, "UTF8"); // 显示密文
            System.out.println(str);

            // 解密：
            cp.init(Cipher.DECRYPT_MODE, key); // 初始化
            ptext = cp.doFinal(ctext); // 解密
            str = new String(ptext, "UTF8"); // 重新显示明文
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String content = "pass1234"; // 待加密、解密内容
        String password = SystemConstant.DEFAULT_PASSWORD_KEY; // 密钥
        // 加密
        System.out.println("加密前：" + content);
        byte[] encryptResult = encrypt(content, password);
        System.out.println(new String(org.bouncycastle.util.encoders.Hex.encode(encryptResult)));
        encryptResult = org.bouncycastle.util.encoders.Hex
                .decode(new String(org.bouncycastle.util.encoders.Hex.encode(encryptResult)));
        // 解密
        byte[] decryptResult = decrypt(encryptResult, password);
        System.out.println("解密后：" + new String(decryptResult));
    }

}

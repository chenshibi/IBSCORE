package com.huateng.ebank.framework.proxool;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.huateng.ebank.business.common.SystemConstant;
import com.sun.jndi.toolkit.chars.BASE64Decoder;
import com.sun.jndi.toolkit.chars.BASE64Encoder;


public class EbankProxoolDataSource extends org.logicalcobwebs.proxool.ProxoolDataSource {

    @Override
    public void setPassword(String password) {
        String decPassword = decrypt(password, SystemConstant.DEFAULT_PASSWORD_KEY.substring(0, 16));
        super.setPassword(decPassword);
    }

    private final static String algorithm = "AES";

    /**
     * 
     * @param encrypted
     * @param rawKey
     * @return
     */
    public static String decrypt(String encrypted, String rawKey) {
        try {
            byte[] tmp = decryptBASE64(encrypted);
            byte[] key = rawKey.getBytes();

            SecretKeySpec skeySpec = new SecretKeySpec(key, algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            byte[] decrypted = cipher.doFinal(tmp);
            return new String(decrypted);
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * 
     * @param key
     * @return
     * @throws Exception
     */
    private static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * 
     * @param data
     * @param rawKey
     * @return
     * @throws Exception
     */
    public static String encrypt(String data, String rawKey) {
        byte[] key = rawKey.getBytes();
        // Instantiate the cipher
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(key, algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

            byte[] encrypted = cipher.doFinal(data.getBytes());
            return encryptBASE64(encrypted);
        } catch (Exception e) {
            return "";
        }

    }

    /**
     * 
     * @param key
     * @return
     * @throws Exception
     */
    private static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: dec/enc enc_pswd/pswd");
            return;
        }
        if ("dec".equals(args[0])) {
            String newPasswd = decrypt(args[1], SystemConstant.DEFAULT_PASSWORD_KEY.substring(0, 16));
            System.out.println(newPasswd);
        } else if ("enc".equals(args[0])) {
            String newPasswd = encrypt(args[1], SystemConstant.DEFAULT_PASSWORD_KEY.substring(0, 16));
            System.out.println(newPasswd);
        } else {
            System.out.println("usage: dec/enc enc_pswd/pswd");
            return;
        }
    }

}

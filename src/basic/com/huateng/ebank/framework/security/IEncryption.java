/**
 * 
 */
package com.huateng.ebank.framework.security;

/**
 * 加密接口
 * 
 * @author zhiguo.zhao
 * 
 */
public interface IEncryption {
    /**
     * 加密
     * 
     * @param plaintext
     *            明文
     * @param salt
     *            盐值
     * @return 密文
     */
    String encrypt(String plaintext, String salt);

    /**
     * 解密
     * 
     * @param ciphertext
     *            密文
     * @param salt
     *            盐值
     * @return 明文
     */
    String decrypt(String ciphertext, String salt);
}

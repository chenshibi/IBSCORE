package com.huateng.ebank.framework.security;

import com.huateng.ebank.business.common.SystemConstant;

/**
 * 加密器生成类
 *
 * @author zhiguo.zhao
 *
 */
public class EncryptFactory {

    public enum Algorithm {
        AES128, AES256, MD5
    }

    /**
     * 获取加密类
     *
     * @param algorithm
     *            算法,目前仅支持MD5和AES256
     * @return
     */
    public static IEncryption getEncryption(Algorithm algorithm) {
        IEncryption encryption = null;
        switch (algorithm) {
        case MD5:
            encryption = new Md5();
            break;
        case AES128:
            encryption = new AES(128);
            break;
        case AES256:
            encryption = new AES(256);
            break;
        default:
            break;
        }
        return encryption;
    }

    public static void main(String[] args) {
        IEncryption enc = EncryptFactory.getEncryption(Algorithm.AES128);
        System.out.println(enc.encrypt("111111", SystemConstant.DEFAULT_PASSWORD_KEY));// AES128:16BD94B8D12468390D89E444196E311B
                                                                                       // AES256:16BD94B8D12468390D89E444196E311B
                                                                                       // MD5:409E0927261A0353238F07FA9B31FA1C
    }
}

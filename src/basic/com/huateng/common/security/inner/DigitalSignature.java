package com.huateng.common.security.inner;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;

import com.huateng.common.security.PKCS7Content;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:05:39 
* 类说明 
*/
public abstract interface DigitalSignature {
	 public abstract boolean verify(Certificate paramCertificate, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
			    throws InvalidKeyException, NoSuchAlgorithmException, SignatureException;
			  
			  public abstract boolean verify(PublicKey paramPublicKey, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
			  
			  public abstract byte[] sign(int paramInt, String paramString, byte[] paramArrayOfByte)
			    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException;
			  
			  public abstract byte[] signForPacket(byte[] paramArrayOfByte, int paramInt, String paramString)
			    throws InvalidKeyException, NoSuchAlgorithmException, SignatureException;
			  
			  public abstract PKCS7Content verify(String paramString)
			    throws IOException, CertStoreException, CertificateExpiredException, CertificateNotYetValidException, NoSuchAlgorithmException, NoSuchProviderException;
}

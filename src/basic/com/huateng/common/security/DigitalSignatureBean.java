package com.huateng.common.security;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import org.springframework.beans.factory.InitializingBean;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:02:56 
* 类说明 
*/
public class DigitalSignatureBean implements InitializingBean{
	  private CertificateManagement a;
	  private String jdField_if;
	  private DigitalSignature jdField_do;
	  
	  public boolean verify(String alias, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	    throws KeyStoreException, UnrecoverableKeyException, InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    Certificate cert = a.getCertificate(alias);
	    return jdField_do.verify(cert, signatureAlgorithm, dataPart, signaturePart);
	  }
	  
	  public CertificateManagement getCm()
	  {
	    return a;
	  }
	  
	  public void setCm(CertificateManagement management)
	  {
	    a = management;
	  }
	  
	  public void setCfgName(String string)
	  {
	    jdField_if = string;
	  }
	  
	  public void afterPropertiesSet()
	    throws Exception
	  {
	    jdField_do = DigitalSignature.getInstance(jdField_if);
	  }
}

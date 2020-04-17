package com.huateng.common.security;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:06:49 
* 类说明 
*/
public class PKCS7Content {
	 private X509Certificate[] jdField_if;
	  private byte[] jdField_do;
	  private byte[] a;
	  
	  public X509Certificate[] getCertificates()
	  {
	    return jdField_if;
	  }
	  
	  public void setCertificates(X509Certificate[] certificates)
	  {
	    if (certificates != null)
	    {
	      jdField_if = new X509Certificate[certificates.length];
	      for (int i = 0; i < certificates.length; i++) {
	        try
	        {
	          byte[] encodedBytes = certificates[i].getEncoded();
	          CertificateFactory cf = CertificateFactory.getInstance("X.509");
	          jdField_if[i] = ((X509Certificate)cf.generateCertificate(new ByteArrayInputStream(encodedBytes)));
	        }
	        catch (Exception e)
	        {
	          jdField_if[i] = certificates[i];
	        }
	      }
	    }
	  }
	  
	  public byte[] getData()
	  {
	    return jdField_do;
	  }
	  
	  public void setData(byte[] data)
	  {
	    jdField_do = data;
	  }
	  
	  public byte[] getSignature()
	  {
	    return a;
	  }
	  
	  public void setSignature(byte[] signature)
	  {
	    a = signature;
	  }
}

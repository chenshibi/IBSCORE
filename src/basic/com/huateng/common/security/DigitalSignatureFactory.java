package com.huateng.common.security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.bouncycastle.asn1.ASN1InputStream;
/*import org.bouncycastle.asn1.DEREncodable;*/
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import com.cfca.util.pki.asn1.DEREncodable;
import com.huateng.common.security.inner.DigitalSignature;
import com.huateng.report.utils.Hex2Byte;

import sun.misc.BASE64Decoder;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:08:07 
* 类说明 
*/
public class DigitalSignatureFactory {
	 public static String SHA_DSA = "SHA/DSA";
	  public static String MD5_RSA = "MD5/RSA";
	  private static Log jdField_do = LogFactory.getLog(DigitalSignatureFactory.class);
	  private static Hashtable jdField_for = new Hashtable();
	  private static DigitalSignature a;
	  public static final String copyright = "Copyright 2004 Client Server International, Inc. All rights reserved.";
	  private static Provider jdField_if;
	  
	  static
	  {
	    try
	    {
	      jdField_if = new BouncyCastleProvider();
	      Security.addProvider(jdField_if);
	      a = new DigitalSignatureImpl();
	    }
	    catch (Exception e)
	    {
	    	jdField_do.error("can't initialize JCE provider", e);
	    }
	  }
	  
	  public static DigitalSignature getInstance()
	  {
	    return a;
	  }
	  
	  public static void registerPrivateKey(int privateKeyOffset, PrivateKey privateKey)
	  {
		  jdField_for.put(new Integer(privateKeyOffset), privateKey);
	  }
	  
	  public static final String prefixZero(long numberIn, int iLength)
	  {
	    String sLongIn = Long.toString(numberIn);
	    int iLengthOfZero = iLength - sLongIn.length();
	    StringBuffer sb1 = new StringBuffer(iLength);
	    for (int i = 0; i < iLengthOfZero; i++) {
	      sb1.append('0');
	    }
	    sb1.append(sLongIn);
	    return sb1.toString();
	  }
	  
	  private static class DigitalSignatureImpl
	    implements DigitalSignature
	  {
	    
	    public boolean verify(Certificate certificate, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	      throws InvalidKeyException, NoSuchAlgorithmException, SignatureException
	    {
	      return verify(certificate.getPublicKey(), signatureAlgorithm, dataPart, signaturePart);
	    }
	    
	    public boolean verify(PublicKey publicKey, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException
	    {
	      Signature signature = Signature.getInstance(signatureAlgorithm);
	      signature.initVerify(publicKey);
	      signature.update(dataPart);
	      return signature.verify(signaturePart);
	    }
	    
	    public byte[] sign(int privateKeyOffset, String signatureAlgorithm, byte[] dataPart)
	      throws NoSuchAlgorithmException, InvalidKeyException, SignatureException
	    {
	      PrivateKey privateKey = (PrivateKey)DigitalSignatureFactory.jdField_for.get(new Integer(privateKeyOffset));
	      if (privateKey == null) {
	        throw new InvalidKeyException("cannot find key in private key registry");
	      }
	      Signature signature = Signature.getInstance(signatureAlgorithm);
	      signature.initSign(privateKey);
	      signature.update(dataPart);
	      return signature.sign();
	    }
	    
	    public byte[] signForPacket(byte[] packetData, int privateKeyOffset, String signatureAlgorithm)
	      throws InvalidKeyException, NoSuchAlgorithmException, SignatureException
	    {
	      byte[] signature = sign(privateKeyOffset, signatureAlgorithm, packetData);
	      String hexSignature = Hex2Byte.byte2Hex(signature);
	      byte[] result = new byte[packetData.length + hexSignature.length() + 8];
	      System.arraycopy(packetData, 0, result, 0, packetData.length);
	      String signatureLength = DigitalSignatureFactory.prefixZero(hexSignature.length(), 8);
	      System.arraycopy(signatureLength.getBytes(), 0, result, packetData.length, 8);
	      System.arraycopy(hexSignature.getBytes(), 0, result, packetData.length + 8, hexSignature.length());
	      return result;
	    }
	    
	    public PKCS7Content verify(String pkcs7Input)
	      throws IOException, CertStoreException, CertificateExpiredException, CertificateNotYetValidException, NoSuchAlgorithmException, NoSuchProviderException
	    {
	      try
	      {
	        BASE64Decoder bs = new BASE64Decoder();
	        byte[] raw = bs.decodeBuffer(pkcs7Input);
	        ASN1InputStream asn1inputstream = new ASN1InputStream(new ByteArrayInputStream(raw));
	        ContentInfo contentInfo = ContentInfo.getInstance(asn1inputstream.readObject());
	        DEREncodable encodable = (DEREncodable) contentInfo.getContent();
	        CMSSignedData cmssigneddata = new CMSSignedData(contentInfo);
	        byte[] data = (byte[])cmssigneddata.getSignedContent().getContent();
	        CertStore certstore = cmssigneddata.getCertificatesAndCRLs("Collection", "BC");
	        SignerInformationStore signerinformationstore = cmssigneddata.getSignerInfos();
	        Collection signers = signerinformationstore.getSigners();
	        Iterator iterator1 = signers.iterator();
	        while (iterator1.hasNext())
	        {
	          SignerInformation signerinformation1 = (SignerInformation)iterator1.next();
	          Collection certificates = certstore.getCertificates(signerinformation1.getSID());
	          X509Certificate[] certs = (X509Certificate[])certificates.toArray(new X509Certificate[0]);
	          for (int i = 0; i < certs.length; i++) {
	            if (signerinformation1.verify(certs[i], "BC"))
	            {
	              PKCS7Content pkcs7Content = new PKCS7Content();
	              pkcs7Content.setCertificates(certs);
	              pkcs7Content.setData(data);
	              pkcs7Content.setSignature(signerinformation1.getSignature());
	              return pkcs7Content;
	            }
	          }
	        }
	        return null;
	      }
	      catch (CMSException e)
	      {
	        throw new RuntimeException(e);
	      }
	    }
	  }
}

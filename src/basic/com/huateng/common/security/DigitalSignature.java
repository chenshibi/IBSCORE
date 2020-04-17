package com.huateng.common.security;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.huateng.report.utils.Hex2Byte;
import com.huateng.report.utils.HuaTengUtils;
import com.huateng.report.utils.ProviderFactory;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午4:22:16 
* 类说明 
*/
public class DigitalSignature {
	 private Provider jdField_if;
	  public static String SHA_DSA = "SHA/DSA";
	  public static String MD5_RSA = "MD5withRSA";
	  private static Log a = LogFactory.getLog(DigitalSignature.class);
	  private Pattern jdField_do = Pattern.compile("~\\|~");
	  
	  private DigitalSignature(Provider provider)
	  {
	    jdField_if = provider;
	  }
	  
	  public static DigitalSignature getInstance(String cfgName)
	  {
	    return new DigitalSignature(ProviderFactory.getProvider(cfgName));
	  }
	  
	  public boolean verify(java.security.cert.Certificate certificate, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    return verify(certificate.getPublicKey(), signatureAlgorithm, dataPart, signaturePart);
	  }
	  
	  public boolean verify(javax.security.cert.Certificate certificate, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    return verify(certificate.getPublicKey(), signatureAlgorithm, dataPart, signaturePart);
	  }
	  
	  public boolean verify(PublicKey publicKey, String signatureAlgorithm, byte[] dataPart, byte[] signaturePart)
	    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    Signature signature = Signature.getInstance(signatureAlgorithm, jdField_if);
	    signature.initVerify(publicKey);
	    signature.update(dataPart);
	    return signature.verify(signaturePart);
	  }
	  
	  public byte[] sign(PrivateKey privateKey, String signatureAlgorithm, byte[] dataPart)
	    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    Signature signature = Signature.getInstance(signatureAlgorithm, jdField_if);
	    signature.initSign(privateKey);
	    signature.update(dataPart);
	    return signature.sign();
	  }
	  
	  public final HashMap getSignedData(String signedData)
	  {
	    HashMap result = new HashMap();
	    try
	    {
	      String[] tokens = jdField_do.split(signedData);
	      for (int i = 0; i < tokens.length; i++)
	      {
	        String tmpStr = tokens[i];
	        int index = tmpStr.indexOf('=');
	        if (index == -1) {
	          return result;
	        }
	        String name = tmpStr.substring(0, index);
	        String value = tmpStr.substring(index + 1);
	        ArrayList indexedData = (ArrayList)result.get(name);
	        if (indexedData == null)
	        {
	          indexedData = new ArrayList();
	          indexedData.add(value);
	          result.put(name, indexedData);
	        }
	        else
	        {
	          indexedData.add(value);
	        }
	      }
	    }
	    catch (Exception localException) {}
	    Iterator iterator = result.entrySet().iterator();
	    while (iterator.hasNext())
	    {
	      Map.Entry entry = (Map.Entry)iterator.next();
	      Object[] array = ((ArrayList)entry.getValue()).toArray();
	      if (array.length == 1)
	      {
	        result.put(entry.getKey(), (String)array[0]);
	      }
	      else
	      {
	        String[] strArray = new String[array.length];
	        System.arraycopy(array, 0, strArray, 0, array.length);
	        result.put(entry.getKey(), strArray);
	      }
	    }
	    return result;
	  }
	  
	  public byte[] signForPacket(byte[] packetData, PrivateKey privateKey, String signatureAlgorithm)
	    throws InvalidKeyException, SignatureException, NoSuchAlgorithmException, NoSuchProviderException
	  {
	    byte[] signature = sign(privateKey, signatureAlgorithm, packetData);
	    String hexSignature = Hex2Byte.byte2Hex(signature);
	    byte[] result = new byte[packetData.length + hexSignature.length() + 8];
	    System.arraycopy(packetData, 0, result, 0, packetData.length);
	    String signatureLength = HuaTengUtils.prefixZero(hexSignature.length(), 8);
	    System.arraycopy(signatureLength.getBytes(), 0, result, packetData.length, 8);
	    System.arraycopy(hexSignature.getBytes(), 0, result, packetData.length + 8, hexSignature.length());
	    return result;
	  }
}

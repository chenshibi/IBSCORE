package com.huateng.common.security;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import com.huateng.report.utils.Hex2Byte;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午6:18:49 
* 类说明 
*/
public class VerifyUtil {
	 public static final String copyright = "Copyright 2004 Client Server International, Inc. All rights reserved.";
	  private static Pattern a = Pattern.compile("~\\|~");
	  
	  public static String verify(String charsetName, String signatureStr, String signatureAlgorithm, Certificate clientCert)
	    throws Exception
	  {
	    byte[] signatureBytes = signatureStr.getBytes(charsetName);
	    if (signatureBytes[0] != 65) {
	      throw new Exception("invalid_signature");
	    }
	    int dataLen = Integer.parseInt(new String(signatureBytes, 2, 8).trim());
	    byte[] dataPartBytes = new byte[dataLen];
	    System.arraycopy(signatureBytes, 10, dataPartBytes, 0, dataLen);
	    String dataPart = new String(dataPartBytes, charsetName);
	    int signLen = Integer.parseInt(new String(signatureBytes, 10 + dataLen, 8).trim());
	    String signature = new String(signatureBytes, 10 + dataLen + 8, signLen, charsetName);
	    byte[] signPartBytes = Hex2Byte.hex2Byte(signature);
	    if (!DigitalSignatureFactory.getInstance().verify(clientCert, signatureAlgorithm, dataPartBytes, signPartBytes)) {
	      throw new Exception("invalid_signature");
	    }
	    return dataPart;
	  }
	  
	  public static final HashMap getSignedData(String signedData)
	  {
	    HashMap result = new HashMap();
	    try
	    {
	      String[] tokens = a.split(signedData);
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
}

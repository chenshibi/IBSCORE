package com.huateng.common.security;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午4:20:55 
* 类说明 
*/
public class Des {
	 private static Log a = LogFactory.getLog(Des.class);
	  
	  public static byte[] DESEncrypt(byte[] inbuf, byte[] key)
	  {
	    return a(inbuf, 0, inbuf.length, key, "DES", 1);
	  }
	  
	  public static byte[] DESDecrypt(byte[] inbuf, byte[] key)
	  {
	    return a(inbuf, 0, inbuf.length, key, "DES", 2);
	  }
	  
	  public static byte[] DESEncryptNoPadding(byte[] inbuf, byte[] key)
	  {
	    return a(inbuf, 0, inbuf.length, key, "DES/ECB/NoPadding", 1);
	  }
	  
	  public static byte[] DESDecryptNoPadding(byte[] inbuf, byte[] key)
	  {
	    return a(inbuf, 0, inbuf.length, key, "DES/ECB/NoPadding", 2);
	  }
	  
	  public static byte[] DESEncryptNoPadding(byte[] inbuf, int offset, int length, byte[] key)
	  {
	    return a(inbuf, offset, length, key, "DES/ECB/NoPadding", 1);
	  }
	  
	  public static byte[] DESDecryptNoPadding(byte[] inbuf, int offset, int length, byte[] key)
	  {
	    return a(inbuf, offset, length, key, "DES/ECB/NoPadding", 2);
	  }
	  
	  public static byte[] DESEncryptWithFilling(byte[] inbuf, int offset, int length, int blockSize, byte fillByte, byte[] key)
	  {
	    return a(inbuf, offset, length, blockSize, fillByte, key, "DES/ECB/NoPadding", 1);
	  }
	  
	  private static byte[] a(byte[] inbuf, int offset, int length, int blockSize, byte fillByte, byte[] key, String transformation, int opmode)
	  {
	    SecretKeySpec tmpKey = new SecretKeySpec(key, "DES");
	    try
	    {
	      Cipher cipher = Cipher.getInstance(transformation);
	      cipher.init(opmode, tmpKey);
	      int remain = length % blockSize;
	      if (remain == 0) {
	        return cipher.doFinal(inbuf, offset, length);
	      }
	      byte[] tmpBytes = new byte[length + blockSize - remain];
	      Arrays.fill(tmpBytes, length, tmpBytes.length, fillByte);
	      System.arraycopy(inbuf, offset, tmpBytes, 0, length);
	      return cipher.doFinal(tmpBytes);
	    }
	    catch (Exception e)
	    {
	      a.error("DESCrypt Caught exception " + e);
	    }
	    return null;
	  }
	  
	  private static byte[] a(byte[] inbuf, int offset, int length, byte[] key, String transformation, int opmode)
	  {
	    SecretKeySpec tmpKey = new SecretKeySpec(key, "DES");
	    try
	    {
	      Cipher cipher = Cipher.getInstance(transformation);
	      cipher.init(opmode, tmpKey);
	      return cipher.doFinal(inbuf, offset, length);
	    }
	    catch (Exception e)
	    {
	      a.error("DESCrypt Caught exception " + e);
	    }
	    return null;
	  }
	  
	  public static byte[] DESCrypt(byte[] inbuf, byte[] key, String mode, int opmode, byte[] iv)
	  {
	    SecretKeySpec tmpKey = new SecretKeySpec(key, "DES");
	    String transformation;
	    if (mode == null) {
	      transformation = "DES";
	    } else {
	      transformation = "DES/" + mode;
	    }
	    try
	    {
	      Cipher cipher = Cipher.getInstance(transformation);
	      if ((mode.startsWith("CBC")) && (iv == null)) {
	        return null;
	      }
	      if (iv != null)
	      {
	        IvParameterSpec para = new IvParameterSpec(iv);
	        cipher.init(opmode, tmpKey, para);
	      }
	      else
	      {
	        cipher.init(opmode, tmpKey);
	      }
	      return cipher.doFinal(inbuf);
	    }
	    catch (Exception e)
	    {
	      a.error("DESCrypt Caught exception " + e);
	    }
	    return null;
	  }
}

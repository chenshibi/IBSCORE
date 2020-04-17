package com.huateng.report.utils;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:38:04 
* 类说明 
*/
public class Base64 {
	private static final char[] a = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
	  private static final char[] jdField_for = { '!', '"', '#', '$', '%', '&', '\'', '(', ')', ',', '-', '.', ':', ';', '<', '>', '@', '[', ']', '^', '`', '_', '{', '|', '}', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '?' };
	  private static final byte[] jdField_do = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
	  private static final byte[] jdField_if = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, -1, 62, 9, 10, 11, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 12, 13, 14, -1, 15, 63, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, 18, 19, 21, 20, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 22, 23, 24, 25 };
	  
	  public static String byteArrayToBase64(byte[] paramArrayOfByte)
	  {
	    return a(paramArrayOfByte, false);
	  }
	  
	  public static String byteArrayToAltBase64(byte[] paramArrayOfByte)
	  {
	    return a(paramArrayOfByte, true);
	  }
	  
	  private static String a(byte[] paramArrayOfByte, boolean paramBoolean)
	  {
	    int i = paramArrayOfByte.length;
	    int j = i / 3;
	    int k = i - 3 * j;
	    int m = 4 * ((i + 2) / 3);
	    StringBuffer localStringBuffer = new StringBuffer(m);
	    char[] arrayOfChar = paramBoolean ? jdField_for : a;
	    int n = 0;
	    int i2;
	    for (int i1 = 0; i1 < j; i1++)
	    {
	      i2 = paramArrayOfByte[(n++)] & 0xFF;
	      int i3 = paramArrayOfByte[(n++)] & 0xFF;
	      int i4 = paramArrayOfByte[(n++)] & 0xFF;
	      localStringBuffer.append(arrayOfChar[(i2 >> 2)]);
	      localStringBuffer.append(arrayOfChar[(i2 << 4 & 0x3F | i3 >> 4)]);
	      localStringBuffer.append(arrayOfChar[(i3 << 2 & 0x3F | i4 >> 6)]);
	      localStringBuffer.append(arrayOfChar[(i4 & 0x3F)]);
	    }
	    if (k != 0)
	    {
	      int i1 = paramArrayOfByte[(n++)] & 0xFF;
	      localStringBuffer.append(arrayOfChar[(i1 >> 2)]);
	      if (k == 1)
	      {
	        localStringBuffer.append(arrayOfChar[(i1 << 4 & 0x3F)]);
	        localStringBuffer.append("==");
	      }
	      else
	      {
	        i2 = paramArrayOfByte[(n++)] & 0xFF;
	        localStringBuffer.append(arrayOfChar[(i1 << 4 & 0x3F | i2 >> 4)]);
	        localStringBuffer.append(arrayOfChar[(i2 << 2 & 0x3F)]);
	        localStringBuffer.append('=');
	      }
	    }
	    return localStringBuffer.toString();
	  }
	  
	  public static byte[] base64ToByteArray(String paramString)
	  {
	    return a(paramString, false);
	  }
	  
	  public static byte[] altBase64ToByteArray(String paramString)
	  {
	    return a(paramString, true);
	  }
	  
	  private static byte[] a(String paramString, boolean paramBoolean)
	  {
	    byte[] arrayOfByte1 = paramBoolean ? jdField_if : jdField_do;
	    int i = paramString.length();
	    int j = i / 4;
	    if (4 * j != i) {
	      throw new IllegalArgumentException("String length must be a multiple of four.");
	    }
	    int k = 0;
	    int m = j;
	    if (i != 0)
	    {
	      if (paramString.charAt(i - 1) == '=')
	      {
	        k++;
	        m--;
	      }
	      if (paramString.charAt(i - 2) == '=') {
	        k++;
	      }
	    }
	    byte[] arrayOfByte2 = new byte[3 * j - k];
	    int n = 0;
	    int i1 = 0;
	    int i3;
	    int i4;
	    for (int i2 = 0; i2 < m; i2++)
	    {
	      i3 = a(paramString.charAt(n++), arrayOfByte1);
	      i4 = a(paramString.charAt(n++), arrayOfByte1);
	      int i5 = a(paramString.charAt(n++), arrayOfByte1);
	      int i6 = a(paramString.charAt(n++), arrayOfByte1);
	      arrayOfByte2[(i1++)] = ((byte)(i3 << 2 | i4 >> 4));
	      arrayOfByte2[(i1++)] = ((byte)(i4 << 4 | i5 >> 2));
	      arrayOfByte2[(i1++)] = ((byte)(i5 << 6 | i6));
	    }
	    if (k != 0)
	    {
	      int i2 = a(paramString.charAt(n++), arrayOfByte1);
	      i3 = a(paramString.charAt(n++), arrayOfByte1);
	      arrayOfByte2[(i1++)] = ((byte)(i2 << 2 | i3 >> 4));
	      if (k == 1)
	      {
	        i4 = a(paramString.charAt(n++), arrayOfByte1);
	        arrayOfByte2[(i1++)] = ((byte)(i3 << 4 | i4 >> 2));
	      }
	    }
	    return arrayOfByte2;
	  }
	  
	  private static int a(char paramChar, byte[] paramArrayOfByte)
	  {
	    int i = paramArrayOfByte[paramChar];
	    if (i < 0) {
	      throw new IllegalArgumentException("Illegal character " + paramChar);
	    }
	    return i;
	  }
}

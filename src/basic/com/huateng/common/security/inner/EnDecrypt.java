package com.huateng.common.security.inner;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午5:34:56 
* 类说明 
*/
public abstract interface EnDecrypt {
	 public abstract byte[] deCrypt(String paramString1, byte[] paramArrayOfByte1, int paramInt, String paramString2, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract byte[] deCrypt(String paramString1, byte[] paramArrayOfByte1, Key paramKey, String paramString2, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract byte[] enCrypt(String paramString1, byte[] paramArrayOfByte1, int paramInt, String paramString2, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract byte[] enCrypt(String paramString1, byte[] paramArrayOfByte1, Key paramKey, String paramString2, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract byte[] enCryptForRSA(byte[] paramArrayOfByte, Key paramKey, String paramString)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract boolean verify(int paramInt1, String paramString1, byte[] paramArrayOfByte1, int paramInt2, String paramString2, byte[] paramArrayOfByte2)
			    throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalStateException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract String deCrypt(Key paramKey, String paramString)
			    throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
			  
			  public abstract byte[] deCryptRaw(Key paramKey, byte[] paramArrayOfByte)
			    throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;
}

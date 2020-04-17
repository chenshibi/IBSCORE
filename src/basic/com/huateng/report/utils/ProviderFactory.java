package com.huateng.report.utils;
import java.lang.reflect.Constructor;
import java.security.Provider;
import java.security.Security;
/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午4:12:49 
* 类说明 
*/
public class ProviderFactory {
	  private static Provider jdField_do;
	  private static Provider a;
	  private Provider jdField_if;
	  
	  static
	  {
	    try
	    {
	      Class localClass = Class.forName("org.bouncycastle.jce.provider.BouncyCastleProvider");
	      Constructor localConstructor = localClass.getConstructor(new Class[0]);
	      Provider localProvider = (Provider)localConstructor.newInstance(new Object[0]);
	      Security.addProvider(localProvider);
	      jdField_do = localProvider;
	    }
	    catch (Exception localException)
	    {
	      localException.printStackTrace();
	    }
	  }
	  
	  public static Provider getProvider(String paramString)
	  {
	    if (paramString == null) {
	      return jdField_do;
	    }
	    if (a == null) {
	      try
	      {
	        Class localClass = Class.forName("sun.security.pkcs11.SunPKCS11");
	        Constructor localConstructor = localClass.getConstructor(new Class[] { String.class });
	        Provider localProvider = (Provider)localConstructor.newInstance(new Object[] { paramString });
	        Security.addProvider(localProvider);
	        a = localProvider;
	      }
	      catch (Exception localException)
	      {
	        localException.printStackTrace();
	        return null;
	      }
	    }
	    return a;
	  }
}

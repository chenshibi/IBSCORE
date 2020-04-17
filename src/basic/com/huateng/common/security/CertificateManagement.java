package com.huateng.common.security;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;

import com.huateng.report.utils.ProviderFactory;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import org.springframework.beans.factory.InitializingBean;

/** 
* @author Grassy 
* @version 创建时间：2019年11月5日 下午4:06:41 
* 类说明 
*/
public class CertificateManagement implements InitializingBean{
	
	  private String jdField_if;
	  private String jdField_for;
	  private String jdField_do;
	  private KeyStore jdField_int;
	  private String a = "JKS";
	  
	  public String getKeyStoreFileName()
	  {
	    return jdField_if;
	  }
	  
	  public String getKeyStorePassword()
	  {
	    return jdField_for;
	  }
	  
	  public void setKeyStoreFileName(String keyStoreFileName)
	  {
	    jdField_if = keyStoreFileName;
	  }
	  
	  public void setKeyStorePassword(String keyStorePassword)
	  {
	    jdField_for = keyStorePassword;
	  }
	  
	  public String getKeyPassword()
	  {
	    return jdField_do;
	  }
	  
	  public void setKeyPassword(String string)
	  {
	    jdField_do = string;
	  }
	  
	  public String getKeyStoreType()
	  {
	    return a;
	  }
	  
	  public void setKeyStoreType(String string)
	  {
	    a = string;
	  }
	  
	  public class KeyEntry
	  {
	    private Key a;
	    private Certificate[] jdField_if;
	    
	    public KeyEntry(Key key, Certificate[] certificateChain)
	    {
	      a = key;
	      jdField_if = certificateChain;
	    }
	    
	    public Certificate[] getCertificateChain()
	    {
	      return jdField_if;
	    }
	    
	    public Key getKey()
	    {
	      return a;
	    }
	  }
	  
	  public static CertificateManagement getInstance(String fileName, String keyStorePassword, String keyPassword, boolean initFlag)
			    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
			  {
			    CertificateManagement cm = new CertificateManagement();
			    cm.setKeyStoreFileName(fileName);
			    if (fileName.endsWith(".cfg"))
			    {
			      cm.setKeyStoreType("PKCS11");
			      ProviderFactory.getProvider(fileName);
			    }
			    cm.setKeyStorePassword(keyStorePassword);
			    cm.setKeyPassword(keyPassword);
			    if (initFlag) {
			      cm.jdMethod_if();
			    } else {
			      cm.a();
			    }
			    return cm;
			  }

	@Override
	public void afterPropertiesSet() throws Exception {
		   if (jdField_if.endsWith(".cfg"))
		    {
		      setKeyStoreType("PKCS11");
		      ProviderFactory.getProvider(jdField_if);
		    }
		    a();
		
	}
	
	 protected void jdMethod_if()
			    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
			  {
			    jdField_int = KeyStore.getInstance(a);
			    jdField_int.load(null, jdField_for.toCharArray());
			  }
			  
			  protected void a()
			    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException
			  {
			    jdField_int = KeyStore.getInstance(a);
			    if (a.equals("PKCS11")) {
			      jdField_int.load(null, jdField_for.toCharArray());
			    } else {
			      jdField_int.load(new FileInputStream(jdField_if), jdField_for.toCharArray());
			    }
			  }
			  
			  public void save()
			    throws KeyStoreException, NoSuchAlgorithmException, CertificateException, FileNotFoundException, IOException
			  {
			    jdField_int.store(new FileOutputStream(jdField_if), jdField_for.toCharArray());
			  }
			  
			  public void printKeyStore()
			  {
			    try
			    {
			      Enumeration e = jdField_int.aliases();
			      while (e.hasMoreElements())
			      {
			        String alias = (String)e.nextElement();
			        System.out.println("alias: " + alias + "cert:" + jdField_int.isCertificateEntry(alias) + "key:" + jdField_int.isKeyEntry(alias));
			        Certificate[] cert = jdField_int.getCertificateChain(alias);
			        for (int i = 0; i < cert.length; i++) {
			          System.out.println(cert[i]);
			        }
			      }
			    }
			    catch (Exception e)
			    {
			      e.printStackTrace();
			    }
			  }
			  
			  public List getKeyAlias()
			    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    List result = new ArrayList(jdField_int.size());
			    Enumeration e = jdField_int.aliases();
			    while (e.hasMoreElements())
			    {
			      String alias = (String)e.nextElement();
			      if (jdField_int.isKeyEntry(alias)) {
			        result.add(alias);
			      }
			    }
			    return result;
			  }
			  
			  public List getCertAlias()
			    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    List result = new ArrayList(jdField_int.size());
			    Enumeration e = jdField_int.aliases();
			    while (e.hasMoreElements())
			    {
			      String alias = (String)e.nextElement();
			      if (jdField_int.isCertificateEntry(alias)) {
			        result.add(alias);
			      }
			    }
			    return result;
			  }
			  
			  public Map getKeyStoreDetail()
			    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    Map result = new HashMap(jdField_int.size());
			    Enumeration e = jdField_int.aliases();
			    while (e.hasMoreElements())
			    {
			      String alias = (String)e.nextElement();
			      if (jdField_int.isKeyEntry(alias))
			      {
			        Certificate[] cert = jdField_int.getCertificateChain(alias);
			        Key key = jdField_int.getKey(alias, jdField_do.toCharArray());
			        KeyEntry entry = new KeyEntry(key, cert);
			        result.put(alias, entry);
			      }
			      else
			      {
			        Certificate cert = jdField_int.getCertificate(alias);
			        result.put(alias, cert);
			      }
			    }
			    return result;
			  }
			  
			  public KeyEntry getKeyEntry(String alias)
			    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    Certificate[] cert = jdField_int.getCertificateChain(alias);
			    Key key = jdField_int.getKey(alias, jdField_do.toCharArray());
			    KeyEntry entry = new KeyEntry(key, cert);
			    return entry;
			  }
			  
			  public Certificate getCertificate(String alias)
			    throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    return jdField_int.getCertificate(alias);
			  }
			  
			  public void importCertificate(String alias, InputStream in)
			    throws IOException, CertificateException, KeyStoreException
			  {
			    CertificateFactory cf = CertificateFactory.getInstance("X.509");
			    byte[] tmpBuffer = new byte[in.available()];
			    int totalLength = in.read(tmpBuffer);
			    ByteArrayInputStream in1 = new ByteArrayInputStream(tmpBuffer, 0, totalLength);
			    Certificate cert;
			    try
			    {
			      cert = cf.generateCertificate(in1);
			    }
			    catch (Exception e)
			    {
			      BASE64Decoder decoder = new BASE64Decoder();
			      ByteArrayInputStream in2 = new ByteArrayInputStream(decoder.decodeBuffer(new ByteArrayInputStream(tmpBuffer, 0, totalLength)));
			      cert = cf.generateCertificate(in2);
			    }
			    jdField_int.setCertificateEntry(alias, cert);
			  }
			  
			  public void importCertificate(String alias, Certificate cert)
			    throws KeyStoreException
			  {
			    jdField_int.setCertificateEntry(alias, cert);
			  }
			  
			  public String exportCertificate(String alias)
			  {
			    try
			    {
			      Certificate cert = jdField_int.getCertificate(alias);
			      BASE64Encoder encoder = new BASE64Encoder();
			      return encoder.encode(cert.getEncoded());
			    }
			    catch (Exception e)
			    {
			      e.printStackTrace();
			    }
			    return null;
			  }
			  
			  public void exportPFX(String alias, OutputStream out, char[] password)
			    throws UnrecoverableKeyException, KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException
			  {
			    Key key = jdField_int.getKey(alias, jdField_do.toCharArray());
			    Certificate[] certs = jdField_int.getCertificateChain(alias);
			    KeyStore outputKeyStore = KeyStore.getInstance("PKCS12");
			    outputKeyStore.load(null, password);
			    outputKeyStore.setKeyEntry(alias, key, password, certs);
			    outputKeyStore.store(out, password);
			  }
			  
			  public void deleteEntry(String alias)
			    throws KeyStoreException
			  {
			    jdField_int.deleteEntry(alias);
			  }
			  
			  public void importPFX(String alias, InputStream in, char[] password)
			    throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException
			  {
			    KeyStore inputKeyStore = KeyStore.getInstance("PKCS12");
			    inputKeyStore.load(in, password);
			    Enumeration enum0 = inputKeyStore.aliases();
			    while (enum0.hasMoreElements())
			    {
			      String keyAlias = (String)enum0.nextElement();
			      System.out.println("alias=[" + keyAlias + "]");
			      if (inputKeyStore.isKeyEntry(keyAlias))
			      {
			        Key key = inputKeyStore.getKey(keyAlias, password);
			        Certificate[] certChain = inputKeyStore.getCertificateChain(keyAlias);
			        jdField_int.setKeyEntry(alias, key, jdField_do.toCharArray(), certChain);
			      }
			    }
			  }
			  
}

package com.huateng.report.utils;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YiSiliang
 * @date 2019/1/12 01:10
 */
public class PbocUtils {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(PbocUtils.class);

    public static File saveFile(String msg, String path, String uuid) throws Exception {
    	  File file = FileUtils.getFile(new File(path), DateUtils.get8Date(), uuid + ".msg");
          FileUtils.forceMkdirParent(file);
          FileUtils.writeStringToFile(file, msg, "UTF-8",false);
          return file;
    }

    public static String genPbocMsgId() {
    	StringBuilder str=new StringBuilder();
    	try {
    		SecureRandom random= SecureRandom.getInstance("SHA1PRNG","RUN");
			for(int i=0;i<8;i++) {
				 str.append(random.nextInt(10));
			   }
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}
    	return str.toString();
    }
    /**
     *  
     * @param url
     * @return
     */
    public static boolean urlIsReach(String url) {		
    	 if (url==null) {			
    	     return false;		
    		 }		
    		 try {			
    		     HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();			
    			 if (HttpURLConnection.HTTP_OK==connection.getResponseCode()) {
    			      return true;			
    				  }		
    				  } 
    				  catch (Exception e) {			
    				         return false;		
    						 }		
    						 return false;	
    		}
    
}

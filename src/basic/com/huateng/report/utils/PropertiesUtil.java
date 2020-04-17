package com.huateng.report.utils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	 public static String getProperty(String key){
	        try {
	            Resource resource = new ClassPathResource("commonResources.properties");
	            Properties props = PropertiesLoaderUtils.loadProperties(resource);
	            return props.get(key).toString();
	        } catch (IOException e) {
	            e.printStackTrace();
	            return "";
	        }
	    }

}

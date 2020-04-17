package com.huateng.report.pboc.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.huateng.report.service.PbocD103Service;

/**
 * @author Grassy
 * @date 2019/2/21 14:37
 * @jdk.version 1.8
 * @desc
 */
public class PropertiesUtil {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(PbocD103Service.class);
	
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
    
    public static String getNetsafeUrl(){
        try {
            Resource resource = new ClassPathResource("netsignagent.properties");
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            String ip = props.get("ServerIP").toString();
            String port=props.get("ServerPort").toString();
            LOGGER.info("初始化签名服务器IP地址为======="+ip);
            LOGGER.info("初始化签名服务器端口为======="+port); 
            return resource.getURI().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
}

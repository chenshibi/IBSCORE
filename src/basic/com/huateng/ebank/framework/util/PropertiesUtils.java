package com.huateng.ebank.framework.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static Properties getProperties(String filePath) {
        Properties properties = new Properties();
        InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("exception in reading properties ! return new Properties();");
            return new Properties();
        }
        return properties;
    }
}

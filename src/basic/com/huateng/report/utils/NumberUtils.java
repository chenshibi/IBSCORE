package com.huateng.report.utils;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YiSiliang
 * @date 2019/1/10 10:22
 */
public class NumberUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberUtils.class);

    public static int parseInteger(String value) {
        return parseInteger(value, 0);
    }

    public static int parseInteger(String value, int defaultValue) {
        int result = defaultValue;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            LOGGER.error("parse {} to int failed by {}, return 0", value, e.getMessage());
        }
        return result;
    }

    public static long parseLong(String value) {
        return parseLong(value, 0L);
    }

    public static long parseLong(String value, long defaultValue) {
        long result = defaultValue;
        try {
            result = Long.parseLong(value);
        } catch (NumberFormatException e) {
            LOGGER.error("parse {} to int failed by {}, return 0", value, e.getMessage());
        }
        return result;
    }

    public static double parseDouble(String value) {
        return parseDouble(value, 0.0);
    }

    public static double parseDouble(String value, double defaultValue) {
        double result = defaultValue;
        try {
            result = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            LOGGER.error("parse {} to int failed by {}, return 0", value, e.getMessage());
        }
        return result;
    }

    public static String frontCompWithZore(int sourceData,int formatLength){
        String newString = String.format("%0"+formatLength+"d", sourceData);
        return newString;
    }
    
}

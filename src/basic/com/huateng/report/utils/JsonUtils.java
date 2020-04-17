package com.huateng.report.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author YiSiliang
 * @date 2019/1/2 17:24
 */
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJson(Object o) {
        if (o == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            return "";
        }
    }

    public static HashMap<String, Object> toMap(String json) {
        if (StringUtils.isBlank(json)) {
            return new HashMap<String, Object>();
        }
        try {
            return OBJECT_MAPPER.readValue(json, HashMap.class);
        } catch (Exception e) {
            return new HashMap<String, Object>();
        }
    }

//    public static HashMap<String, BulkCreditReporting> toMap2(String json) {
//        if (StringUtils.isBlank(json)) {
//            return new HashMap<String, BulkCreditReporting>();
//        }
//        try {
//            return OBJECT_MAPPER.readValue(json, HashMap.class);
//        } catch (Exception e) {
//            return new HashMap<String, BulkCreditReporting>();
//        }
//    }
    public static ArrayList<HashMap<String, Object>> toList(String json) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<HashMap<String, Object>>();
        }
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<ArrayList<HashMap<String, Object>>>() {});
        } catch (Exception e) {
            return new ArrayList<HashMap<String, Object>>();
        }
    }
    
    public static ArrayList<HashMap<String, String>> toList2(String json) {
        if (StringUtils.isBlank(json)) {
            return new ArrayList<HashMap<String, String>>();
        }
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<ArrayList<HashMap<String, String>>>() {});
        } catch (Exception e) {
            return new ArrayList<HashMap<String, String>>();
        }
    }
}

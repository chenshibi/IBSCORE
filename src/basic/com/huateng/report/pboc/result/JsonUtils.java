package com.huateng.report.pboc.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;

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
            return new HashMap<>();
        }
        try {
            return OBJECT_MAPPER.readValue(json, HashMap.class);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}

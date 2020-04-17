package com.huateng.report.pboc.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YiSiliang
 * @date 2018/12/19 15:46
 */
public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

    public static String toJson(Object object) {
        if (object == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

    public static <T> T toObject(String json, Class<T> valueType) {
        try {
            return OBJECT_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return null;
    }

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

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }



    public static void main(String[] args) {
        String json = "{\n" +
                "    \"brno\": \"6841\",\n" +
                "    \"tlrno\": \"cll\",\n" +
                "    \"name\": \"李四\",\n" +
                "    \"idType\": \"3 \",\n" +
                "    \"idNum\": \"130429198904571522\",\n" +
                "    \"queryReason\": \"01\",\n" +
                "    \"serviceCode\": \"yhbgrxybg_02\"\n" +
                "}";

        Map<String, String> map = toObject(json, HashMap.class);
        System.out.println(map);
    }

	public static Map<String, Object> toMap(String mapString) {
		// TODO Auto-generated method stub
		return null;
	}
}

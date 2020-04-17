package com.huateng.ebank.business.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class MapUtil {

    private static Logger log = Logger.getLogger(MapUtil.class);

    /**
     * map转换成字符串，字符串格式key1:value1;key2:value2
     * 
     * @exception 出错返回null
     * @param map
     * @return
     */
    public static String map2String(Map<String, String> map) {
        try {
            StringBuffer sb = new StringBuffer();
            Iterator it = map.keySet().iterator();
            String key;
            while (it.hasNext()) {
                key = it.next().toString();
                sb.append(key + ":" + map.get(key) + ";");
            }
            if (sb.length() > 0)
                return sb.toString().substring(0, sb.length() - 1);
            else
                return "";
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * request中的Map转换成HashMap
     * 
     * @param request
     * @return
     */
    public static HashMap<String, String> requestMap2HashMap(HttpServletRequest request) {
        Map<String, String[]> map = request.getParameterMap();
        HashMap<String, String> resultMap = new HashMap<String, String>();

        try {
            StringBuffer sb = new StringBuffer();
            Iterator it = map.keySet().iterator();
            String key;
            while (it.hasNext()) {
                key = it.next().toString();
                resultMap.put(key, map.get(key)[0]);
            }
            return resultMap;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * string格式转换成HashMap。
     * 
     * @param str
     * @return
     * @exception 格式不对或者出现错误返回null
     */
    public static HashMap<String, String> string2HashMap(String str) {
        try {
            if (str == null || str.trim().equals("")) {
                log.info("str为空。");
                return null;
            }
            if (str.indexOf(";") < 0 && str.indexOf(":") < 0) {
                log.info("格式不对：" + str);
                return null;
            }
            HashMap<String, String> map = new HashMap<String, String>();
            String ss[] = str.split(";");

            String temp[];
            for (String s : ss) {
                temp = s.split(":");
                if (temp.length == 2)
                    map.put(temp[0], temp[1]);
                else if (temp.length == 1)
                    map.put(temp[0], "");
                else
                    continue;
            }

            return map;
        } catch (Exception e) {
            log.info("转换str到HashMap出错:" + str);
            log.info(e);
            return null;
        }
    }

    public static void main(String arg[]) {

        Map<String, String> m = new HashMap<String, String>();
        m.put("name", "ty");
        m.put("address", "chengdu");

        System.out.println(map2String(m));
    }
}

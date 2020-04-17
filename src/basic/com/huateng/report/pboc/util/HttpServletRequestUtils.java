package com.huateng.report.pboc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Grassy
 * @date 2019/3/12 15:12
 * @jdk.version 1.8
 * @desc
 */
public class HttpServletRequestUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpServletRequestUtils.class);

    /**
     * 获取HttpServletRequest对象
     * @return request对象
     */
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取HttpSession对象
     * @return HttpSession
     */
    public static HttpSession getSession(){
        return getHttpServletRequest().getSession();
    }

    /**
     * 根据HttpServletRequest对象获取远程IP地址
     * @return 远程IP
     */
    public static String getRemoteIP(HttpServletRequest request){
     /*   HttpServletRequest request = getHttpServletRequest();
        if(request == null){
            String errorMsg = "request 对象为空";
            logger.error(errorMsg);
            throw new NullPointerException(errorMsg);
        }*/
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * 根据HttpServletRequest对象获取User-Agent信息
     * @param request HttpServletRequest对象
     * @return 请求浏览器信息
     */
    public static String getUserAgent(HttpServletRequest request) {
        return request.getHeader("User-Agent").toLowerCase();
    }
}

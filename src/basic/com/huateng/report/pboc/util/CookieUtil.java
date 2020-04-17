package com.huateng.report.pboc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Grassy
 * @date 2019/3/11
 * @jdk.version 1.8
 * @desc
 */
public class CookieUtil {

    private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);
    private static final int COOKIE_MAX_AGE = 3600*24*7;
    private static final String COOKIE_PATH = "/";

    public static void add(HttpServletResponse response, String key, String value) {
        set(response, key, value, (String) null, "/", COOKIE_MAX_AGE, false);
    }

    /**
     * 操作cookie
     * @param response
     * @param key 名称
     * @param value 值
     * @param domain 域名
     * @param path 路径
     * @param maxAge 有效期
     * @param isHttpOnly 是否可读
     */
    private static void set(HttpServletResponse response, String key, String value, String domain, String path, int maxAge, boolean isHttpOnly) {
        Cookie cookie = new Cookie(key, value);
        if (domain != null) {
            cookie.setDomain(domain);
        }

        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setHttpOnly(isHttpOnly);
        response.addCookie(cookie);
    }

    public static String getValue(HttpServletRequest request, String key) {
        Cookie cookie = get(request, key);
        return cookie != null ? cookie.getValue() : null;
    }

    /**
     * 根据名称查询cookie
     * @param request
     * @param key 名称
     * @return
     */
    private static Cookie get(HttpServletRequest request, String key) {
        Cookie[] arrCookie = request.getCookies();
        if (arrCookie != null && arrCookie.length > 0) {
            for (Cookie cookie: arrCookie) {
                if (cookie.getName().equals(key)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void remove(HttpServletRequest request, HttpServletResponse response, String key) {
        Cookie cookie = get(request, key);
        if (cookie != null) {
            set(response, key, "", (String) null, "/", 0, true);
        }
    }

    /**
     * 删除所有
     * @param request
     * @param response
     */
    public static void removeAll(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] arrCookie = request.getCookies();
        if (arrCookie != null && arrCookie.length > 0) {
            for (Cookie cookie: arrCookie) {
                set(response, cookie.getName(), "", (String) null, "/", 0, true);
            }
        }
    }
}

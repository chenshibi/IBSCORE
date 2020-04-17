package com.huateng.ebank.framework.util;

public class HTStringUtils {

    public static boolean compare(String str1, String str2) {

        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        str1 = str1.trim();
        str2 = str2.trim();

        if (str1.equals(str2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(String str1) {

        if (str1 == null) {
            return false;
        }
        str1 = str1.trim();

        if (str1.length() == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isEmpty(String str1) {

        if (str1 == null) {
            return true;
        }
        str1 = str1.trim();

        if (str1.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean compareIgnoreCase(String str1, String str2) {

        if (str1 == null) {
            str1 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        str1 = str1.trim();
        str2 = str2.trim();

        if (str1.equalsIgnoreCase(str2)) {
            return true;
        } else {
            return false;
        }
    }
}

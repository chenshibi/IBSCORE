package com.huateng.excel.imp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import com.huateng.ebank.framework.util.ApplicationContextUtils;

public class UploadVaildService {

    final public static UploadVaildService getUploadVaildService() {
        return (UploadVaildService) ApplicationContextUtils.getBean("UploadVaildService");
    }

    public String validService(Object obj, String opType, Map<String, List<Object>> classMap)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException,
            NoSuchMethodException, IllegalArgumentException, InvocationTargetException {

        String result = null;

        String objClassName = obj.getClass().getName();// 获取obj类名

        String serviceName = ClassVaildCfg.keymap.get(objClassName);// 获取对应校验service类名

        Class className = Class.forName(serviceName);// 获取对应校验类Class

        // BaseDataVaildService service =
        // (BaseDataVaildService)className.newInstance();//获取dataVaildService类
        Object service = className.newInstance();
        Method m = service.getClass().getDeclaredMethod("validService", Object.class, String.class, Map.class);
        m.setAccessible(true);
        result = (String) m.invoke(service, obj, opType, classMap);

        // result.append(service.validService(objClassName, opType,
        // classMap));//调用校验方法

        return result.toString();
    }
}

package com.huateng.commquery.process.call;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.ResultParamBean;
import com.huateng.exception.AppException;

public class BaseCallGetterProcess {
    public static ResultParamBean processAsync(Map<String, String> paramMap, HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws AppException {
        try {
            String str1 = (String) paramMap.get("CQId");
            if (str1 == null) {
                throw new AppException("SY", "9999", "CQId is null");
            }
            ICommonQueryBean localICommonQueryBean = CommonQueryUtil.getCommonQueryBean(str1);
            String str2 = localICommonQueryBean.getAnyValue("getterclassname");
            if (str2 == null) {
                throw new AppException("SY", "9999", "getterclassname is null");
            }
            Class localClass = Class.forName(str2);
            ICallGetter localICallGetter = (ICallGetter) localClass.newInstance();
            return localICallGetter.process(paramMap, paramHttpServletRequest, paramHttpServletResponse);
        } catch (AppException localAppException) {
            throw localAppException;
        } catch (Exception localException) {
            throw new AppException("SY", "9999", localException);
        }
    }

    public static Result processSync(String paramString, HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse) throws AppException {
        try {
            HashMap localHashMap = new HashMap();
            Enumeration localEnumeration = paramHttpServletRequest.getParameterNames();
            while (localEnumeration.hasMoreElements()) {
                String str1 = (String) localEnumeration.nextElement();
                String str2 = paramHttpServletRequest.getParameter(str1);
                localHashMap.put(str1, str2);
            }
            localHashMap.put("_session_key", paramHttpServletRequest.getSession().getId());
            ICommonQueryBean localICommonQueryBean = CommonQueryUtil.getCommonQueryBean(paramString);
            String str3 = localICommonQueryBean.getAnyValue("getterclassname");
            if (str3 == null) {
                throw new AppException("SY", "9999", "getterclassname is null");
            }
            Class localClass = Class.forName(str3);
            ICallGetter localICallGetter = (ICallGetter) localClass.newInstance();
            localICallGetter.process(localHashMap, paramHttpServletRequest, paramHttpServletResponse);
            return localICallGetter.getResult();
        } catch (AppException localAppException) {
            throw localAppException;
        } catch (Exception localException) {
            throw new AppException("SY", "9999", localException);
        }
    }

    public static Result processSync(String paramString, HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse, Map<String, String> paramMap) throws AppException {
        try {
            HashMap localHashMap = new HashMap();
            Enumeration localEnumeration = paramHttpServletRequest.getParameterNames();
            while (localEnumeration.hasMoreElements()) {
                String str1 = (String) localEnumeration.nextElement();
                String str2 = paramHttpServletRequest.getParameter(str1);
                localHashMap.put(str1, str2);
            }
            localHashMap.put("_session_key", paramHttpServletRequest.getSession().getId());
            if (paramMap != null) {
                Iterator localObject1 = paramMap.entrySet().iterator();
                while (((Iterator) localObject1).hasNext()) {
                    Map.Entry localObject2 = (Map.Entry) ((Iterator) localObject1).next();
                    localHashMap.put((String) ((Map.Entry) localObject2).getKey(),
                            (String) ((Map.Entry) localObject2).getValue());
                }
            }
            Object localObject1 = CommonQueryUtil.getCommonQueryBean(paramString);
            Object localObject2 = ((ICommonQueryBean) localObject1).getAnyValue("getterclassname");
            if (localObject2 == null) {
                throw new AppException("SY", "9999", "getterclassname is null");
            }
            Class localClass = Class.forName((String) localObject2);
            ICallGetter localICallGetter = (ICallGetter) localClass.newInstance();
            localICallGetter.process(localHashMap, paramHttpServletRequest, paramHttpServletResponse);
            return localICallGetter.getResult();
        } catch (AppException localAppException) {
            throw localAppException;
        } catch (Exception localException) {
            localException.printStackTrace();
            throw new AppException("SY", "9999", localException);
        }
    }
}

/*
 * Location:
 * /Users/YiSiliang/Documents/workspace_CICS/CICS/WebContent/WEB-INF/lib/
 * BasePackage.jar Qualified Name:
 * com.huateng.commquery.process.call.BaseCallGetterProcess Java Class Version:
 * 5 (49.0) JD-Core Version: 0.7.1
 */
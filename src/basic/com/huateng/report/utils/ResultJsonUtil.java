package com.huateng.report.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.huateng.report.pboc.entity.MyError;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Grassy
 * @date 2019/2/23 19:44
 * @jdk.version 1.8
 * @desc
 */
public class ResultJsonUtil {
    public final static String RESULT = "result";
    public final static String DATA = "data";
    public final static String MSG = "msg";
    //存放异常等错误信息，错误信息会弹错来
    public final static String ERROR_MSG = "errorMsg";
    //这个里面存放 form表单校验的错误，一个list，界面上显示是，在框后面加提示
    public final static String ERROR = "error";
    //用于区分 数据校验和系统异常
    public final static String EXCEPTION = "exception";
    public static String SUCCEED = "ok";
    public static String FAIL = "fail";

    public static Map<String,Object> getResultMap(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(RESULT, ResultJsonUtil.SUCCEED);
        return result;
    }

    public static Map<String,Object> getFileResultMap(String fileName){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(RESULT, ResultJsonUtil.SUCCEED);
        result.put("fileName",fileName);
        return result;
    }

    public static Map<String,Object> getPersonalResultMap(List<String> rptIdList){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(RESULT, ResultJsonUtil.SUCCEED);
        result.put("uuid",rptIdList);
        return result;
    }
    
    public static Map<String,Object> getCorpResultMap(List<String> rptIdList){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(RESULT, ResultJsonUtil.SUCCEED);
        result.put("uuid",rptIdList);
        return result;
    }

    public static Map<String,Object> getResultErrorMap(){
        Map<String,Object> result = new HashMap<String, Object>();
        result.put(RESULT, ResultJsonUtil.FAIL);
        return result;
    }

//	private static Map<String,Object> isExist(){
//		Map<String,Object> result = mapLocal.get();
//		if(result==null){
//			result = new HashMap<String, Object>();
//			mapLocal.set(result);
//			result.put(RESULT, ResultJsonUtil.SUCCEED);
//		}
//		return result;
//	}

    /**
     * 解析错误信息
     * @param binding
     * @return
     */
    public static Map<String,Object> analyzeError(BindingResult binding){
        Map<String,Object> resultMap = ResultJsonUtil.getResultMap();
        List<MyError> errorList = new ArrayList<MyError>();
        resultMap.put(ResultJsonUtil.RESULT, ResultJsonUtil.FAIL);
        resultMap.put(ResultJsonUtil.ERROR, errorList);
        List<ObjectError> objErrorList = binding.getAllErrors();

        for(ObjectError error : objErrorList){
            try {
                errorList.add(new MyError(error.getObjectName(),(String) BeanUtils.getProperty(error, "field"),error.getDefaultMessage()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return resultMap;
    }

}

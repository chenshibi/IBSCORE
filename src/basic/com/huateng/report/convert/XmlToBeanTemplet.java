package com.huateng.report.convert;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import resource.bean.crms.CrPbocD102;


/**
 * @author Grassy
 * @date 2019/1/6 17:03
 * @jdk.version 1.8
 * @desc
 */
public class XmlToBeanTemplet {
    static Map<String, String> map = new HashMap<String, String>();
    private static Object CrPbocD102Entity;

    public static <T> T  xmlToBean(String xml,T t) throws DocumentException, SecurityException, InstantiationException, IllegalAccessException{
        Document doc = DocumentHelper.parseText(xml); // 将字符串转为XML
        Element root = doc.getRootElement(); // 获取根节点
        Map<String, String> map = getElement(root);
        Field[] fields = t.getClass().getDeclaredFields();
        String[] name = new String[fields.length];
        Field.setAccessible(fields, true);
        for (int i = 0; i < name.length; i++) {
            name[i] = fields[i].getName();
            setFieldValue(t, name[i], map.get(toUpperCaseFirstOne(fields[i].getName())));
        }
        // 赋值后需要清空map
        map.clear();
        return t;
    }

    /**
     * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
     * @param obj
     * @param fieldName
     * @param value
     */
    public static void setFieldValue(final Object obj, final String fieldName,final Object value) {
            Field field = getAccessibleField(obj, fieldName);
            if (field == null) {
                throw new IllegalArgumentException("Could not find field ["
                        + fieldName + "] on target [" + obj + "]");
            }
            try {
                field.set(obj, value);
            } catch (IllegalAccessException e) {

            }
    }

    /**
     * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问
     * 如向上转型到Object仍无法找到, 返回null
     * @param obj
     * @param fieldName
     * @return
     */
    public static Field getAccessibleField(final Object obj,final String fieldName) {
        for (Class<?> superClass = obj.getClass(); superClass != Object.class;
             superClass = superClass.getSuperclass()) {
            try {
                Field field = superClass.getDeclaredField(fieldName);//没有字段的时候 继续向上寻找
                field.setAccessible(true);
                return field;
              } catch (NoSuchFieldException e) {// NOSONAR
                // Field不在当前类定义,继续向上转型
                 }
               }
               return null;
        }

    /**
     * 递归获取当前节点下的所有内容
     * @param root
     * @return
     */
    public static Map<String, String> getElement(Element root) {
        Iterator ri = root.elementIterator();
        // 父节点迭代器
        while (ri.hasNext()) {
            Element foo = (Element) ri.next();
            // 下一个二级节点
            map.put(foo.getName(), foo.getText());
            getElement(foo);
        }
        return map;
    }


    public static void main(String[] args)throws DocumentException, SecurityException, InstantiationException, IllegalAccessException{
        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Document>\n" +
                "<Msg>\n" +
                "<ResultCode>AAA000</ResultCode>\n" +
                "<ResultDesc>处理成功</ResultDesc>\n" +
                "<ReportName>xxxxxxxxxxxxx.xml</ReportName>\n" +
                "<ReportMessage>\n" +
                "</ReportMessage>\n" +
                "</Msg>\n" +
                "</Document>";
        CrPbocD102 entity=new CrPbocD102();
        CrPbocD102 crPbocD102Entity = XmlToBeanTemplet.xmlToBean(xml, entity);
        System.out.println(crPbocD102Entity.getResultCode());


    }

    /**
     * 首字母转小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0))) {
            return s;
        }
        else {
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }

    //首字母转大写
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0))) {
            return s;
        }
        else{
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();}
    }

    }

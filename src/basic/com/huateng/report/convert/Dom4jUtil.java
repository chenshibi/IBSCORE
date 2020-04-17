package com.huateng.report.convert;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Grassy
 * @date 2019/1/4 15:01
 * @jdk.version 1.8
 * @desc
 */
public class Dom4jUtil {

    Pattern pattern = Pattern.compile("\\$\\{.*?\\}");

    public Element getRootElement(Document doc) {
        return doc.getRootElement();
    }

    /**
     * 通过元素名称获取元素
     *
     * @param doc
     * @param name
     * @return
     */
    public List<Element> getAllNodeByName(Document doc, final String name) {
        final List<Element> result = new LinkedList<Element>();

        doc.accept(new VisitorSupport() {

            @Override
            public void visit(Element node) {
                if (node.getName().equalsIgnoreCase(name)) {
                    result.add(node);
                }
            }

        });

        return result;
    }

    public Node getSingleNode(Document doc, String xpath) {
        return doc.selectSingleNode(xpath);
    }

    public List<?> getNodes(Document doc, String xpath) {
        return doc.selectNodes(xpath);
    }

    /**
     * 将字符串转换为Document
     *
     * @param xml
     * @return
     * @throws DocumentException
     */
    public static Document stringToDoc(String xml) throws DocumentException {
        return DocumentHelper.parseText(xml);
    }

    /**
     * 将Document转换为字符串
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public String docToString(Document doc) throws Exception {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        format.setIndent(true);
        format.setIndent("\t");
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        XMLWriter writer = new XMLWriter(bos, format);
        writer.write(doc);
        writer.close();
        String temp = bos.toString();
        bos.close();
        return temp.substring(temp.indexOf("?>") + 3).trim();
    }


    /**
     * 将当前元素添加到指定的元素下
     *
     * @param doc
     * @param partent 父元素
     * @param current 当前元素
     */
    private void addElement(Document doc, String partent, Element current) {
        List<Element> eles = getAllNodeByName(doc, partent);
        for (Element ele : eles) {
            ele.add(current);
        }
    }

    /**
     * 删除指定的元素
     *
     * @param doc
     * @param current
     */
    private void delElement(Document doc, String current) {
        List<Element> eles = getAllNodeByName(doc, current);
        for (Element ele : eles) {
            ele.detach();
        }

    }

    /**
     * 替换字符串中的变量
     *
     * @param source
     * @param contents
     * @return String
     * @throws Exception
     */
    private String prepareString(String source, Map<String, String> contents) throws Exception {
        try {
            Matcher matcher = pattern.matcher(source);
            while (matcher.find()) {
                String temp = matcher.group();
                if (contents != null && !contents.isEmpty()) {
                    temp = temp.replaceAll("\\$\\{(.*)?\\}", "$1");
                    if (contents.keySet().contains(temp)) {
                        String value = contents.get(temp);
                        if (value != null && value.trim().length() != 0) {
                            source = source.replace("${" + temp + "}", value);
                        } else {
                            source = source.replace("${" + temp + "}", "");
                        }
                    } else {
                        source = source.replace("${" + temp + "}", "");
                    }
                } else {
                    source = source.replace(temp, "");
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return source;
    }


}

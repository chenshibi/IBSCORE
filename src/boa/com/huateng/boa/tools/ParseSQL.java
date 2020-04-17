package com.huateng.boa.tools;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseSQL {
    private static final Logger log = Logger.getLogger(ParseSQL.class);

    public static String filepath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "bop" + File.separator
            + "resources" + File.separator + "hbm" + File.separator + "bop";

    public static Map<String, ArrayList<ColumnItem>> hibernateMap = new HashMap<String, ArrayList<ColumnItem>>();
    public static Map<String, TableItem> tableInfo = new HashMap<String, TableItem>();

    public static void usage() {
        log.info("usage : Module Table");
    }

    public static boolean loadHibernate(String filename) throws Exception {
        InputStream inputStream = new FileInputStream(new File(filename));
        SAXReader saxReader = new SAXReader();
        saxReader.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(new ByteArrayInputStream("<?xml version='1.0' encoding='UTF-8'?>".getBytes()));
            }
        });
        Document document = saxReader.read(inputStream, "UTF-8");
        String pack = document.getRootElement().attributeValue("package");
        String classname = "";
        String tablename = "";
        TableItem tableItem = new TableItem();

        ArrayList<ColumnItem> colList = new ArrayList<ColumnItem>();

        Element eClass = (Element) document.getRootElement().elements("class").get(0);
        classname = eClass.attributeValue("name");
        tablename = eClass.attributeValue("table").toUpperCase();

        tableItem.setPack(pack);
        tableItem.setClassname(classname);
        tableInfo.put(tablename, tableItem);

        try {
            Element eId = (Element) eClass.elements("id").get(0);

            {
                ColumnItem item = new ColumnItem();

                String name = eId.attributeValue("name");
                String column = eId.attributeValue("column");
                String type = eId.attributeValue("type");
                String notnull = eId.attributeValue("not-null");
                String length = eId.attributeValue("length");

                item.setName(column);
                item.setJavaVarName(name);
                item.setHibVarType(type);
                item.setCannull("false".equals(notnull) ? true : false);

                if ("string".equals(type)) {
                    try {
                        item.setLen(Integer.parseInt(length));
                    } catch (Exception e1) {
                        log.info(name + " does have length attribute.");
                    }
                }
                colList.add(item);
            }
        } catch (Exception e2) {
            log.error(e2.getMessage(), e2);
        }

        List<Element> list = (List<Element>) eClass.elements("property");
        for (Element e : list) {
            ColumnItem item = new ColumnItem();

            String name = e.attributeValue("name");
            String column = e.attributeValue("column");
            String type = e.attributeValue("type");
            String notnull = e.attributeValue("not-null");
            String length = e.attributeValue("length");

            item.setName(column);
            item.setJavaVarName(name);
            item.setHibVarType(type);
            item.setCannull("false".equals(notnull) ? true : false);

            if ("string".equals(type)) {
                try {
                    item.setLen(Integer.parseInt(length));
                } catch (Exception e1) {
                    log.info(name + " does have length attribute.");
                }
            }

            colList.add(item);

        }

        hibernateMap.put(tablename, colList);
        return true;
    }

    public static boolean loadAllHibernate() throws Exception {
        File path = new File(filepath);
        for (Object file : FileUtils.listFiles(path, null, true)) {
            if (file instanceof File) {
                if (((File) file).getName().endsWith(".hbm.xml")) {
                    // log.info(((File) file).getAbsolutePath());
                    String tmpname = ".hbm.xml";
                    tmpname = tmpname.toUpperCase();
                    if (((File) file).getAbsolutePath().toUpperCase().endsWith(tmpname)) {
                        loadHibernate(((File) file).getAbsolutePath());
                    }
                }
            }

        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        loadAll();
        // if (args.length != 1) {
        // usage();
        // return;
        // }
        // String sql = args[0];
        //
        // sql = sql.toUpperCase();

    }

    public static boolean loadAll() throws Exception {
        return loadAllHibernate();
        // if (args.length != 1) {
        // usage();
        // return;
        // }
        // String sql = args[0];
        //
        // sql = sql.toUpperCase();

    }

}

package com.huateng.report.databak.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huateng.report.databak.bean.ReportTableBakBean;

public class ReportTableResource {
    /**
     * singleton
     */
    private static ReportTableResource single = null;

    private static String resourcePath = "reportTableBak_oracle.xml";

    public synchronized static ReportTableResource getInstance() {
        if (null == single) {
            single = new ReportTableResource();
        }
        return single;
    }

    public List<ReportTableBakBean> getTableList() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (null == is) {
            throw new RuntimeException("找不到资源文件:" + resourcePath);
        }
        List<ReportTableBakBean> list = new ArrayList<ReportTableBakBean>();
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(is);
            List<Element> recordlist = doc.selectNodes("//TABLES//TABLE");
            for (Element element : recordlist) {
                ReportTableBakBean bean = new ReportTableBakBean();
                bean.setTableName(element.element("NAME").getTextTrim());
                bean.setBatchCount(Integer.parseInt(element.element("BATCH_COUNT").getTextTrim()));
                bean.setBatchCountSql(element.element("BATCH_COUNT_SQL").getTextTrim());
                bean.setDataSql(element.element("DATE_SQL").getTextTrim());
                bean.setDelSql(element.element("DEL_SQL").getTextTrim());
                list.add(bean);
            }
        } catch (Exception ioe) {
            throw new RuntimeException("不能加载资源文件:" + resourcePath, ioe);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
        return list;
    }
}

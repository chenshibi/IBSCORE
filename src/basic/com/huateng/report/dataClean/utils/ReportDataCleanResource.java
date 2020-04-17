package com.huateng.report.dataClean.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huateng.report.dataClean.bean.ReportDataCleanBean;

public class ReportDataCleanResource {
    /**
     * singleton
     */
    private static ReportDataCleanResource single = null;

    private static String resourcePath = "reportDataClean_oracle.xml";

    public synchronized static ReportDataCleanResource getInstance() {
        if (null == single) {
            single = new ReportDataCleanResource();
        }
        return single;
    }

    public List<ReportDataCleanBean> getTableList() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (null == is) {
            throw new RuntimeException("找不到资源文件:" + resourcePath);
        }
        List<ReportDataCleanBean> list = new ArrayList<ReportDataCleanBean>();
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(is);
            List<Element> recordlist = doc.selectNodes("//TABLES//TABLE");
            for (Element element : recordlist) {
                ReportDataCleanBean bean = new ReportDataCleanBean();
                bean.setTableName(element.element("NAME").getTextTrim());
                int day = Integer.parseInt(element.element("RESERVES_DAY").getTextTrim());
                bean.setReservesDay(day);
                String df = element.element("DATE_FORMATE").getTextTrim();
                bean.setDateFormate(df);
                bean.setDelSql(element.element("DEL_SQL").getTextTrim());
                Element detsElement = element.element("DETS");
                if (detsElement != null) {
                    List detEmlist = detsElement.elements("DET");
                    if (detEmlist != null && detEmlist.size() > 0) {
                        for (int i = 0; i < detEmlist.size(); i++) {
                            ReportDataCleanBean detBean = new ReportDataCleanBean();
                            Element det = (Element) detEmlist.get(i);
                            String detname = det.element("DET_NAME").getTextTrim();
                            detBean.setTableName(detname);
                            detBean.setDateFormate(df);
                            detBean.setReservesDay(day);
                            detBean.setDelSql(det.element("DET_DELSQL").getTextTrim());
                            bean.getDetList().add(detBean);
                        }
                    }
                }
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

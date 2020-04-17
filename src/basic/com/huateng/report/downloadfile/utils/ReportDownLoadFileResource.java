package com.huateng.report.downloadfile.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huateng.report.downloadfile.bean.DataDownLoadFileBean;

public class ReportDownLoadFileResource {
    /**
     * singleton
     */
    private static ReportDownLoadFileResource single = null;

    private static String resourcePath = "DataDownLoadFile.xml";

    public synchronized static ReportDownLoadFileResource getInstance() {
        if (null == single) {
            single = new ReportDownLoadFileResource();
        }
        return single;
    }

    public DataDownLoadFileBean getDownLoadFileById(String id) {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (null == is) {
            throw new RuntimeException("找不到资源文件:" + resourcePath);
        }
        DataDownLoadFileBean bean = null;
        List<DataDownLoadFileBean> list = new ArrayList<DataDownLoadFileBean>();
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(is);
            List<Element> recordlist = doc.selectNodes("//FILES//FILE");
            for (Element element : recordlist) {
                String fid = element.element("ID").getTextTrim();
                if (fid.equals(id)) {
                    bean = new DataDownLoadFileBean();
                    bean.setId(fid);
                    bean.setDisplayName(element.element("DISPLAYNAME").getTextTrim());
                    bean.setFileName(element.element("FILENAME").getTextTrim());
                    bean.setFileExt(element.element("FILEEXT").getTextTrim());
                    break;
                }
            }
        } catch (Exception ioe) {
            throw new RuntimeException("不能加载资源文件:" + resourcePath, ioe);
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
        return bean;
    }

    public List<DataDownLoadFileBean> getDownLoadFileList() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (null == is) {
            throw new RuntimeException("找不到资源文件:" + resourcePath);
        }
        List<DataDownLoadFileBean> list = new ArrayList<DataDownLoadFileBean>();
        try {
            SAXReader saxReader = new SAXReader();
            Document doc = saxReader.read(is);
            List<Element> recordlist = doc.selectNodes("//FILES//FILE");
            for (Element element : recordlist) {
                DataDownLoadFileBean bean = new DataDownLoadFileBean();
                bean.setId(element.element("ID").getTextTrim());
                bean.setDisplayName(element.element("DISPLAYNAME").getTextTrim());
                bean.setFileName(element.element("FILENAME").getTextTrim());
                bean.setFileExt(element.element("FILEEXT").getTextTrim());
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

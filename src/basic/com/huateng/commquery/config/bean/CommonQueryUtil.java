//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.huateng.commquery.config.bean;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.huateng.common.log.LoggerConstants;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.config.bean.base.include.ICommonQueryIncludeBean;
import com.huateng.commquery.config.bean.base.meta.ICommonQueryCompMeta;
import com.huateng.commquery.config.bean.base.meta.ICommonQueryConfigMeta;
import com.huateng.commquery.config.bean.meta.CommonQueryMetaBean;
import com.huateng.commquery.config.parser.CommonQueryIncludeParser;
import com.huateng.commquery.config.parser.CommonQueryParser;
import com.huateng.commquery.result.qryExp.ExportPool;
import com.huateng.ebank.framework.util.IOUtils;
import com.huateng.exception.AppException;

public class CommonQueryUtil {
    private static final Logger LOGGER = Logger.getLogger(CommonQueryUtil.class);
    private static Map<String, ICommonQueryBean> commonQueryBeanMap = new HashMap(2);
    private static Map<String, String> commonQueryBeanPathMap = new HashMap(2);
    private static Map<String, ICommonQueryIncludeBean> commonQueryIncludeBeanMap = new HashMap(1);
    private static Map<String, CommonQueryMetaBean> commonQueryMetaBeanMap = new HashMap();
    private static Map<String, ICommonQueryCompMeta> commonQueryCompMetaMap = new HashMap();
    private static ServletContext servletContext = null;
    private static String[] metaFiles = null;
    private static boolean dynamicLoad = false;

    public CommonQueryUtil() {
    }

    public static void init() throws AppException {
        initCommonQueryMeta();
    }

    public static void initInclude(String[] includeFiles, ServletContext servletContext) throws AppException {
        CommonQueryUtil.servletContext = servletContext;
        initIncludeFile(includeFiles);
    }

    public static void init(String[] metaFiles, ServletContext servletContext, String configLoadMode) throws AppException {
        CommonQueryUtil.servletContext = servletContext;
        CommonQueryUtil.metaFiles = metaFiles;
        init();
        if (StringUtils.endsWithIgnoreCase(configLoadMode, "DynamicLoad")) {
            dynamicLoad = true;
        }
    }

    private static String findQueryFile(String beanId) throws Exception {
        int length = metaFiles.length;
        String metaFileName = null;

        for (int i = 0; i < length; ++i) {
            metaFileName = StringUtils.trimToEmpty(metaFiles[i]);
            if (StringUtils.isBlank(metaFileName)) {
                continue;
            }
            Set<String> pathSet = servletContext.getResourcePaths(metaFileName);
            if (pathSet == null || pathSet.isEmpty()) {
                continue;
            }
            for (String path : pathSet) {
                if (StringUtils.endsWithIgnoreCase(path, ".xml")) {
                    String key = FilenameUtils.getBaseName(path);
                    if (StringUtils.equals(key, beanId)) {
                        LOGGER.info("found " + beanId + " in " + path);
                        return path;
                    }
                }
            }
        }
        return null;
    }

    private synchronized static void updateCommonQueryBeanMap(String key, String path, ICommonQueryBean bean) {
        bean.setId(key);
        bean.setAnyValue("_META_BEAN_PATH_", path);
        if (commonQueryBeanPathMap.containsKey(key)) {
            if (StringUtils.equals(commonQueryBeanPathMap.get(key), path) == false) {
                LOGGER.warn("found duplicate key = " + key + " in different xml:\n" + path + "\n" + commonQueryBeanPathMap.get(key));
            }
            commonQueryBeanMap.remove(key);
            commonQueryBeanPathMap.remove(key);
        }
        commonQueryBeanMap.put(key, bean);
        commonQueryBeanPathMap.put(key, path);
    }

    public static ICommonQueryBean getCommonQueryBean(String beanId) throws AppException {
        if (dynamicLoad) {
            SAXReader saxReader = new SAXReader();
            CommonQueryParser commonQueryParser = new CommonQueryParser();
            String path = null;
            boolean saveFlag = false;
            InputStream inputStream = null;
            try {
                if (commonQueryBeanPathMap.containsKey(beanId)) {
                    path = commonQueryBeanPathMap.get(beanId);
                    saveFlag = true;
                } else {
                    path = findQueryFile(beanId);
                }

                inputStream = servletContext.getResourceAsStream(path);
                if (inputStream == null) {
                    if (saveFlag) {
                        path = findQueryFile(beanId);
                    }
                    inputStream = servletContext.getResourceAsStream(path);
                }
                if (inputStream == null) {
                    throw new AppException("SY", "CQ95", "Common Query Include Bean id = " + beanId + "not found!");
                }

                Document document = saxReader.read(inputStream);
                ICommonQueryBean bean = commonQueryParser.parse(document);
                String key = FilenameUtils.getBaseName(path);
                updateCommonQueryBeanMap(key, path, bean);
                return bean;
            } catch (AppException e) {
                throw e;
            } catch (Exception e) {
                throw new AppException("SY", "CQ95", "Common Query Include Bean id = " + beanId + "not found!");
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        } else {
            return commonQueryBeanMap.get(beanId);
        }
    }

    public static ICommonQueryIncludeBean getCommonQueryIncludeBean(String var0) throws AppException {
        ICommonQueryIncludeBean var1 = (ICommonQueryIncludeBean) commonQueryIncludeBeanMap.get(var0);
        if (var1 == null) {
            throw new AppException("SY", "CQ95", "Common Query Include Bean id = " + var0 + "not found!");
        } else {
            return var1;
        }
    }

    private static void initCommonQueryMeta() throws AppException {
        int length = metaFiles.length;
        String metaFileName = null;

        try {
            SAXReader saxReader = new SAXReader();
            CommonQueryParser commonQueryParser = new CommonQueryParser();

            for (int i = 0; i < length; ++i) {
                metaFileName = StringUtils.trimToEmpty(metaFiles[i]);
                if (StringUtils.isBlank(metaFileName)) {
                    continue;
                }
                Set<String> pathSet = servletContext.getResourcePaths(metaFileName);
                if (pathSet == null || pathSet.isEmpty()) {
                    LOGGER.warn("not files in " + metaFileName);
                    continue;
                }
                for (String path : pathSet) {
                    if (StringUtils.endsWithIgnoreCase(path, ".xml")) {
                        LOGGER.info(LoggerConstants.traceInfo("Paser Config File:" + path + " Begin"));
                        InputStream inputStream = null;
                        try {
                            inputStream = servletContext.getResourceAsStream(path);
                            Document document = saxReader.read(inputStream);
                            ICommonQueryBean bean = commonQueryParser.parse(document);
                            String key = FilenameUtils.getBaseName(path);
                            updateCommonQueryBeanMap(key, path, bean);
                        } finally {
                            IOUtils.closeQuietly(inputStream);
                        }
                    }
                }
            }

        } catch (AppException var7) {
            throw var7;
        } catch (Exception var8) {
            throw new AppException("SY", "CQ04", var8);
        }
    }

    public static void initIncludeFile(String[] includeFiles) throws AppException {
        try {
            for (String includeFile : includeFiles) {
                ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();
                Resource[] resources = resourceLoader.getResources(includeFile);
                if (resources != null && resources.length > 0) {
                    for (Resource resource : resources) {
                        LOGGER.info(LoggerConstants.traceInfo("Paser Include File:" + resource.getFilename() + " Begin"));
                        CommonQueryIncludeParser commonQueryIncludeParser = new CommonQueryIncludeParser();
                        InputStream inputStream = null;
                        try {
                            inputStream = resource.getInputStream();
                            ICommonQueryIncludeBean includeBean = commonQueryIncludeParser.parse(inputStream);
                            Map exportParser = includeBean.getQueryExportParser();
                            if (exportParser != null && !exportParser.isEmpty() && !ExportPool.initedParsers()) {
                                ExportPool.setExportParsers(exportParser);
                            }
                            commonQueryIncludeBeanMap.put(FilenameUtils.getBaseName(resource.getFilename()), includeBean);
                        } finally {
                            IOUtils.closeQuietly(inputStream);
                        }
                    }
                }
            }

        } catch (AppException var11) {
            throw var11;
        } catch (Exception var12) {
            throw new AppException("SY", "CQ94", var12);
        }
    }


    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static List<String> getCommonQueryConfigTxn(String var0) throws AppException {
        ICommonQueryBean var1 = (ICommonQueryBean) commonQueryBeanMap.get(var0);
        String var2 = var1.getAnyValue("_META_BEAN_PATH_");
        CommonQueryMetaBean var3 = (CommonQueryMetaBean) commonQueryMetaBeanMap.get(var2);
        ICommonQueryConfigMeta var4 = var3.getCommonQueryConfigMeta(var0);
        return var4.getTxn();
    }

    public static ICommonQueryCompMeta getCommonQueryComponent(String var0) throws AppException {
        ICommonQueryCompMeta var1 = (ICommonQueryCompMeta) commonQueryCompMetaMap.get(var0);
        if (var1 == null) {
            throw new AppException("SY", "CQ08", "Common Query Component[" + var0 + "] no exists");
        } else {
            return var1;
        }
    }

    public static void destroy() {
        commonQueryMetaBeanMap.clear();
        commonQueryBeanMap.clear();
        commonQueryIncludeBeanMap.clear();
        ExportPool.destroy();
    }
}

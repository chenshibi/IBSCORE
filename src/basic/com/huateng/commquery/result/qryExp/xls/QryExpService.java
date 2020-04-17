package com.huateng.commquery.result.qryExp.xls;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.pool.ObjectPool;
import org.apache.log4j.Logger;

import com.huateng.commquery.config.CommonQueryUtil;
import com.huateng.commquery.config.bean.CommonQueryField;
import com.huateng.commquery.config.bean.base.ICommonQueryBean;
import com.huateng.commquery.config.bean.base.ICommonQueryField;
import com.huateng.commquery.process.FieldValueProcess;
import com.huateng.commquery.process.call.BaseCallGetterProcess;
import com.huateng.commquery.result.FieldData;
import com.huateng.commquery.result.Result;
import com.huateng.commquery.result.RowData;
import com.huateng.commquery.result.qryExp.ExportPool;
import com.huateng.commquery.result.qryExp.IQueryExport;
import com.huateng.commquery.result.qryExp.csv.CSVExport;
import com.huateng.ebank.business.common.ConfigReader;
import com.huateng.ebank.framework.web.struts.QueryExportForm;
import com.huateng.exception.AppException;
import com.huateng.exception.DomainException;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.util.SystemDictionaryUnit;

import freemarker.template.TemplateModelException;

public class QryExpService {
    private static final Logger logger = Logger.getLogger(QryExpService.class);

    public void wirtHead(String[] expClsId, LinkedHashMap<?, ?> fieldsMap, IQueryExport export, String encoding,
            Map userParams) throws IOException {
        List colsStr = new ArrayList();

        String[] headDesc = new String[expClsId.length];
        for (int i = 0; i < expClsId.length; i++) {
            if (fieldsMap.containsKey(expClsId[i])) {
                CommonQueryField field = (CommonQueryField) fieldsMap.get(expClsId[i]);
                String desc = field.getAnyValue("desc");
              //  headDesc[i] = new String(desc.getBytes(), encoding);
                headDesc[i]=new String(desc);
            } else {
                headDesc[i] = expClsId[i];
            }
        }
        if (userParams.containsKey("PageQryExp_title")) {
            colsStr.add(new String[] { "TITLE", String.valueOf(Math.max(headDesc.length - 1, 0)),
                    (String) userParams.get("PageQryExp_title") });
        }
        colsStr.add(headDesc);

        export.writeHead(colsStr);
    }

    public void wirtTail(String[] tailStr, LinkedHashMap<?, ?> fieldsMap, IQueryExport export, String encoding)
            throws IOException {
    }

    public void wirtDetail(QueryExportForm form, ICommonQueryBean commonQueryBean, IQueryExport export, Map userParams)
            throws IOException, AppException, TemplateModelException {
        String[] fileIds = form.getColumnSort().split(",");

        int startPage = Integer.parseInt(form.getStartPage());

        int endPage = Integer.parseInt(form.getEndPage());

        Map otherParams = null;
        if ((userParams != null) && (!userParams.isEmpty())) {
            otherParams = userParams;
        } else {
            otherParams = new HashMap();
        }

        boolean hasMore = true;
        int everyPage = Integer.parseInt(form.getEveryPage());
        long maxsize = everyPage * (endPage - startPage + 1L);
        long sumsize = 0L;

        otherParams.put("exp_cur_num", "0");
        otherParams.put("exp_sum_num", "0");
        if (form.isExpAll()) {
            logger.info("=========批量导出========");
            int perfetch = Integer.parseInt((String) otherParams.get("perfetch"));

            otherParams.put("everyPage", String.valueOf(perfetch));
            logger.info("=========每页读取条数======" + perfetch);
        } else {
            logger.info("=========联机导出========");
            int maxpage = Integer.parseInt(form.getMaxpage());
            endPage = Math.min(startPage + maxpage - 1, endPage);
            logger.info("=========最大支持页======" + maxpage);
            logger.info("=========实际导出页======" + endPage);
        }

        for (int currentPage = startPage; ((endPage < 0) || (currentPage <= endPage)) && (hasMore); currentPage++) {

            otherParams.put("nextPage", String.valueOf(currentPage));

            Result result = BaseCallGetterProcess.processSync(commonQueryBean.getId(), form.getRequest(),
                    form.getResponse(), otherParams);

            List data = result.getData();

            if ((data.isEmpty()) || (data.size() < everyPage)) {
                hasMore = false;
            }
            List qryData = new ArrayList();
            for (int i = 0; i < data.size(); i++) {

                if ((endPage > 0) && (++sumsize > maxsize)) {
                    hasMore = false;
                    break;
                }

                RowData row = (RowData) data.get(i);
                String[] rowData = new String[fileIds.length];
                for (int j = 0; j < fileIds.length; j++) {
                    FieldData field = row.getField(fileIds[j]);
                    if (field == null) {
                        rowData[j] = " ";
                    } else {
                    //    rowData[j] = new String(field.toString().getBytes(), form.getFileEnCode());
                    	rowData[j] = new String(field.toString());
                        ICommonQueryField fBean = commonQueryBean.getField(fileIds[j]);
                        String translated = fBean.getAnyValue("translated");
                        String paramMethod = fBean.getAnyValue("method");

                        if ((translated != null) && (translated.trim().length() > 0)) {
                            List args = new ArrayList();
                            if (translated.toUpperCase().startsWith("LIST")) {
                                String[] trans = translated.split(":");
                                if (trans[1] != null) {
                                    String[] ops = trans[1].split(";");
                                    for (int x = 0; x < ops.length; x++) {
                                        if ((ops[x] != null) && (!"".equals(ops[x].trim()))) {
                                            String[] vals = ops[x].split(",");
                                            if ((vals.length == 2) && (vals[0].trim().equalsIgnoreCase(rowData[j]))) {
                                                rowData[j] = vals[1].trim();
                                            }

                                        }

                                    }
                                }
                            } else if (!translated.toUpperCase().startsWith("CQ:")) {

                                if (translated.toUpperCase().startsWith("DATA_DIC")) {
                                    String[] trans = translated.split("\\.");
                                    String translatedValue = SystemDictionaryUnit.getFieldDesc(trans[0], trans[1],
                                            rowData[j]);
                                    if (translatedValue != null) {
                                        rowData[j] = translatedValue;
                                    }
                                }
                            }
                        }

                        if ((paramMethod != null) && (paramMethod.trim().length() != 0)
                                && (!paramMethod.equalsIgnoreCase("none"))) {

                            rowData[j] = FieldValueProcess.process(form.getRequest(), fBean, rowData[j]);
                        }
                    }

                    if ((export instanceof CSVExport)) {
                        ICommonQueryField fBean = commonQueryBean.getField(fileIds[j]);
                        String dataType = fBean.getAnyValue("datatype");
                        if (((StringUtils.isEmpty(dataType)) || (StringUtils.equalsIgnoreCase(dataType, "string")))
                                && (NumberUtils.isNumber(rowData[j]))) {
                            BigDecimal bd = NumberUtils.createBigDecimal(rowData[j]).abs();
                            if ((bd.scale() > 6) || (bd.precision() > 11)) {
                                rowData[j] = ("=\"" + rowData[j] + "\"");
                            }
                        }
                    }
                }

                qryData.add(rowData);
            }

            export.writeDetails(qryData);
            String num = String
                    .valueOf(Long.valueOf((String) otherParams.get("exp_cur_num")).longValue() + qryData.size());
            otherParams.put("exp_cur_num", num);
            otherParams.put("exp_sum_num", num);
        }
    }

    public void genExport(QueryExportForm form, OutputStream outStream, Map userParams) throws DomainException {
        ObjectPool pool = null;
        IQueryExport export = null;

        String[] sortFields = null;

        OutputStream out = outStream;
        form.setFileEnCode("GBK");
        try {
            HttpServletResponse response = form.getResponse();
            HttpServletRequest request = form.getRequest();

            ICommonQueryBean commonQueryBean = CommonQueryUtil.getCommonQueryBean(form.getCqId());

          /*  String encoding = commonQueryBean.getPageExpConf("encoding");
            form.setFileEnCode(getAnyValueDefault(encoding, "UTF-8"));*/

            LinkedHashMap<?, ?> fieldsMap = commonQueryBean.getFields();

            String type = getAnyValueDefault(form.getExportType(), "csv").toLowerCase();

            String maxpage = commonQueryBean.getPageExpConf("maxpage");
            form.setMaxpage(getAnyValueDefault(maxpage, ConfigReader.getProperty("PageQryExp_maxpage")));

            if (out == null) {
                out = response.getOutputStream();
            }

            if (form.isZipFlag()) {
                response.setContentType("application/zip; charset=" + form.getFileEnCode().toUpperCase());

                response.setHeader("Pragma", "public");
                String disFileName = getAnyValueDefault(form.getFileName(), "qryExpZip");
                 disFileName = new String(disFileName.getBytes("GBK"), "8859_1");
                response.setHeader("Content-disposition", "attachment;filename=" + disFileName + ".zip");
                out = new ZipOutputStream(out);
                String fileName = getAnyValueDefault(form.getFileName(), "downloadFile");

                fileName = "downloadFile";
                ((ZipOutputStream) out).putNextEntry(new ZipEntry(fileName + "." + type));
            } else {
                 response.setContentType("application/" + type + "; " + "charset=" + form.getFileEnCode().toUpperCase());

                response.setHeader("Pragma", "public");
                String disFileName = getAnyValueDefault(form.getFileName(), "qryExpZip");
                disFileName = new String(disFileName.getBytes("GBK"), "8859_1");
                response.setHeader("Content-disposition", "attachment;filename=" + disFileName + "." + type);
            }

            response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");

            pool = ExportPool.getExportPool(type.toUpperCase());

            export = (IQueryExport) pool.borrowObject();

            export.setOutPutStream(out);

            String columnSort = form.getColumnSort();

            if ((columnSort == null) || (columnSort.length() < 1)) {
                columnSort = commonQueryBean.toFieldString();
                form.setColumnSort(columnSort);
            }
            sortFields = columnSort.split(",");

            wirtHead(sortFields, fieldsMap, export, form.getFileEnCode(), userParams);

            wirtDetail(form, commonQueryBean, export, userParams);

            wirtTail(null, null, null, form.getFileEnCode());

            export.clear();
            return;
        } catch (Exception e) {
            LogExceptionUtils.logException(logger, e);
            e.printStackTrace();
            throw new DomainException("", e);
        } finally {
            try {
                if (null != export) {
                    pool.returnObject(export);
                }
            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
            }
        }
    }

    public static String getAnyValueDefault(String value, String defaultValue) {
        if ((value != null) && (!"".equals(value))) {
            return value;
        }
        return defaultValue;
    }

    public String[] splitStrWithLenLimit(String inputStr, int maxLen) {
        int byteLen = maxLen / 2;
        if (byteLen == 0) {
            byteLen = 1;
        }
        int inputLen = inputStr.length();
        int dealNum = inputLen % byteLen == 0 ? inputLen / byteLen : inputLen / byteLen + 1;

        String[] resultArray = new String[dealNum];
        for (int index = 0; index < dealNum - 1; index++) {
            resultArray[index] = inputStr.substring(byteLen * index, byteLen * (index + 1));
        }

        resultArray[(dealNum - 1)] = inputStr.substring(byteLen * (dealNum - 1), inputStr.length());

        return resultArray;
    }

}

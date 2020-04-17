package com.huateng.report.databak.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.report.common.ReportConstant;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.report.databak.bean.ReportTableBakBean;
import com.huateng.report.databak.utils.ReportTableResource;
import com.huateng.report.databak.utils.ReportTableUtil;
import com.huateng.report.utils.LogExceptionUtils;
import com.huateng.report.utils.PackZipUtil;
import com.huateng.report.utils.ReportUtils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

public class ReportDataBakService {
    private static Logger log = Logger.getLogger(ReportDataBakService.class);

    protected ReportDataBakService() {
    }

    public synchronized static ReportDataBakService getInstance() {
        return (ReportDataBakService) ApplicationContextUtils.getBean(ReportDataBakService.class.getName());
    }

    /**
     * 开始备份文件
     *
     * @return
     * @throws Exception
     * @throws CommonException
     */
    public String createDataBakFile() throws Exception {
        String zipFileName = null;
        List<ReportTableBakBean> beanList = ReportTableResource.getInstance().getTableList();
        List<String> fileList = new ArrayList<String>();
        if (beanList.size() > 0) {
            // 文件保存目录
            String filePath = ReportUtils.getSysParamsValue("BAK", "PATH");
            ReportTableUtil.createFilePath(filePath);

            ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
            SessionFactory sf = rootdao.getSessionFactory();
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
            try {
                conn = cp.getConnection();
                for (int i = 0; i < beanList.size(); i++) {
                    ReportTableBakBean bean = beanList.get(i);
                    ps = conn.prepareStatement(bean.getBatchCountSql());
                    rs = ps.executeQuery();
                    int totalcount = 0;
                    if (rs != null && rs.next()) {
                        totalcount = rs.getInt(1);
                    }
                    // 计算需要查询次数
                    int num = ReportTableUtil.getCycNum(totalcount, bean.getBatchCount());
                    for (int j = 0; j < num; j++) {
                        int startnum = j * bean.getBatchCount() + 1;
                        int endnum = (j + 1) * bean.getBatchCount();
                        if (endnum > totalcount) {
                            endnum = totalcount;
                        }
                        // 查询
                        String savefile = queryDataAndWrFile(conn, bean.getTableName(), bean.getDataSql(), startnum,
                                endnum, filePath);
                        if (savefile != null && !fileList.contains(savefile)) {
                            fileList.add(savefile);
                        }
                    }
                }
                zipFileName = filePath + ReportConstant.BAK_DATA_FILE_NAME;
                File zipFile = new File(zipFileName);
                if (zipFile.exists()) {
                    log.info(zipFileName + "============zip file exists======");
                    zipFile.delete();
                }
                log.info(zipFileName + "============zip file start======");
                // 压缩文件
                PackZipUtil ziputil = new PackZipUtil();
                ziputil.createZip(fileList, zipFileName);
                log.info(zipFileName + "============zip file end======");

                // 删除源文件
                for (int i = 0; i < fileList.size(); i++) {
                    File f = new File(fileList.get(i));
                    if (f.exists()) {
                        f.delete();
                    }
                }
            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    if (cp != null) {
                        cp.closeConnection(conn);
                    } else {
                        // ignore
                    }
                }
            }
        }
        return zipFileName;
    }

    private String queryDataAndWrFile(Connection conn, String tableName, String querySql, int startnum, int endnum,
            String path) throws Exception {
        List<String[]> dataList = new ArrayList<String[]>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String filePath = null;
        try {
            log.info("exp table " + tableName + ",startrow:" + startnum + ",endrow:" + endnum + "=====start======");
            ps = conn.prepareStatement(querySql);
            ps.setInt(1, endnum);
            ps.setInt(2, startnum);
            ps.setInt(3, endnum);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colCount = rsmd.getColumnCount();// 去除rownum列
            String[] handstr = null;
            if (startnum == 1) {// 只写入一次头数据
                handstr = new String[colCount - 1];
                for (int i = 2; i <= colCount; i++) {
                    String colNm = rsmd.getColumnName(i);
                    int colType = rsmd.getColumnType(i);
                    handstr[i - 2] = colNm + "@@" + colType;
                }
            }
            while (rs.next()) {
                String[] datastr = new String[colCount - 1];
                for (int i = 2; i <= colCount; i++) {
                    Object elem = null;
                    if (rsmd.getColumnType(i) == Types.TIMESTAMP) {
                        elem = rs.getTimestamp(i);
                    } else {
                        elem = rs.getObject(i);
                    }
                    if (elem == null) {
                        datastr[i - 2] = "";
                    } else {
                        datastr[i - 2] = elem.toString();
                    }
                }
                dataList.add(datastr);
            }
            // 写入文件
            filePath = expFileToCsv(handstr, dataList, path, tableName);
            log.info("exp table " + tableName + ",startrow:" + startnum + ",endrow:" + endnum + "=====end======");
        } catch (SQLException e) {
            LogExceptionUtils.logException(log, e);
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return filePath;
    }

    /**
     * 将数据导出为csv文件
     *
     * @param handStr
     *            头数据
     * @param dataList
     *            数据
     * @param saveFileNm
     *            保存文件名
     * @return
     * @throws IOException
     */
    private String expFileToCsv(String[] handStr, List<String[]> dataList, String path, String saveFileNm)
            throws IOException {
        String filePath = null;
        if (dataList != null && dataList.size() > 0) {

            FileOutputStream fos = null;
            OutputStreamWriter out = null;
            CSVWriter csvwrite = null;
            try {
                filePath = path + saveFileNm + ReportConstant.BAK_FILE_EXT;
                File file = new File(filePath);
                if (handStr != null && handStr.length > 0) {
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (file.exists()) {
                    fos = new FileOutputStream(filePath, true);
                    log.info("write file " + filePath + "=====append=====");
                } else {
                    fos = new FileOutputStream(filePath);
                    log.info("write file " + filePath + "=====new=====");
                }
                out = new OutputStreamWriter(fos, Charset.forName("GBK"));
                csvwrite = new CSVWriter(out, ',');
                if (handStr != null && handStr.length > 0) {
                    // 写入头信息
                    csvwrite.writeNext(handStr);
                }
                // 写入内容
                for (int i = 0; i < dataList.size(); i++) {
                    String[] oldstr = dataList.get(i);
                    String[] newstr = new String[oldstr.length];
                    for (int j = 0; j < oldstr.length; j++) {
                        String s = oldstr[j];
                        if (s != null && s.length() > 0) {
                            newstr[j] = s.trim();
                        } else {
                            newstr[j] = "";
                        }
                    }
                    csvwrite.writeNext(newstr);
                }
                csvwrite.flush();
                log.info("write file " + filePath + "=====end=====");
            } catch (Exception e) {
                LogExceptionUtils.logException(log, e);
                e.printStackTrace();
            } finally {
                if (csvwrite != null) {
                    csvwrite.close();
                }
                if (out != null) {
                    out.close();
                    out = null;
                }
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            }
        }
        return filePath;
    }

    /**
     * 恢复数据
     * 
     * @param zipFileName
     * @throws Exception
     */
    public void recoveryDataBak(String zipFileName) throws Exception {
        String filePath = ReportUtils.getSysParamsValue("BAK", "PATH");
        String bakFilePath = filePath + zipFileName;
        File bakFile = new File(bakFilePath);
        if (!bakFile.exists()) {
            ExceptionUtil.throwCommonException(bakFilePath + "备份文件不存在!");
        }
        // 解压文件
        PackZipUtil zipUtil = new PackZipUtil();
        Map<String, String> fileMap = zipUtil.unZip(bakFilePath, filePath, ReportConstant.BAK_DATA_UNZIP_);
        if (fileMap.size() == 0) {
            ExceptionUtil.throwCommonException("没有可恢复的数据!");
        }
        // 加载配置
        List<ReportTableBakBean> beanList = ReportTableResource.getInstance().getTableList();

        ROOTDAO rootdao = ROOTDAOUtils.getROOTDAO();
        SessionFactory sf = rootdao.getSessionFactory();
        Connection conn = null;
        PreparedStatement ps = null;
        ConnectionProvider cp = ((SessionFactoryImplementor) sf).getConnectionProvider();
        try {
            conn = cp.getConnection();
            conn.setAutoCommit(false);
            for (int i = 0; i < beanList.size(); i++) {
                ReportTableBakBean bean = beanList.get(i);
                String tableName = bean.getTableName();
                if (fileMap.containsKey(tableName)) {
                    // 清空数据库
                    ps = conn.prepareStatement(bean.getDelSql());
                    ps.executeUpdate();
                    conn.commit();
                    // 读取文件执行写入
                    int rows = readCsvFileAndSave(conn, bean, fileMap.get(tableName));
                    log.info("insert into row " + rows);
                } else {
                    log.info(tableName + " no exists");
                }
            }
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true);
                if (cp != null) {
                    cp.closeConnection(conn);
                } else {
                    // ignore
                }
            }
            // 删除解压文件
            for (Iterator<String> it = fileMap.keySet().iterator(); it.hasNext();) {
                String name = it.next();
                String path = fileMap.get(name);
                File f = new File(path);
                if (f.exists()) {
                    f.delete();
                }
            }
        }
    }

    /**
     * 读取备份文件并写入数据库
     *
     * @param conn
     * @param bean
     * @param filePath
     * @return
     * @throws Exception
     */
    private int readCsvFileAndSave(Connection conn, ReportTableBakBean bean, String filePath) throws Exception {
        CSVReader csvReader = null;
        FileInputStream in = null;
        InputStreamReader inRead = null;
        PreparedStatement ps = null;
        int totalRow = 0;
        try {
            in = new FileInputStream(filePath);
            inRead = new InputStreamReader(in, Charset.forName("GBK"));
            csvReader = new CSVReader(inRead, ',');
            if (csvReader != null) {
                // 头信息
                String[] readhand = csvReader.readNext();

                List<String> handList = new ArrayList<String>();
                for (int i = 0; i < readhand.length; i++) {
                    if (readhand[i] != null && readhand[i].trim().length() > 0) {
                        handList.add(readhand[i]);
                    }
                }
                int handLen = handList.size();
                String[] hands = new String[handLen];
                Integer[] handTypes = new Integer[handLen];
                for (int i = 0; i < handList.size(); i++) {
                    String[] readhands = handList.get(i).split("@@");
                    hands[i] = readhands[0].trim();
                    handTypes[i] = Integer.parseInt(readhands[1].trim());
                }
                String sql = getInsertSql(bean.getTableName(), hands);
                conn.setAutoCommit(false);
                ps = conn.prepareStatement(sql);
                String[] csvRow = null;
                int row = 0;
                while ((csvRow = csvReader.readNext()) != null) {
                    for (int i = 0; i < handLen; i++) {
                        String content = csvRow[i];
                        if (content != null && content.trim().length() > 0) {
                            content = content.trim();
                        } else {
                            content = null;
                        }
                        if (content != null && (handTypes[i] == Types.NUMERIC || handTypes[i] == Types.DECIMAL)) {
                            ps.setBigDecimal(i + 1, new BigDecimal(content));
                        } else {
                            ps.setObject(i + 1, content, handTypes[i]);
                        }
                    }
                    ps.addBatch();
                    row++;
                    if (row == bean.getBatchCount()){
                        int[] updrow = ps.executeBatch();
                        if (updrow.length != row) {
                            log.error(" update row:" + updrow.length + "<> read row:" + row);
                        }
                        totalRow += updrow.length;
                        ps.clearBatch();
                        conn.commit();
                        row = 0;
                    }
                }
                // 提交剩余数量
                if (row > 0) {
                    int[] updrow = ps.executeBatch();
                    if (updrow.length != row) {
                        log.error(" update row:" + updrow.length + "<> read row:" + row);
                    }
                    totalRow += updrow.length;
                    ps.clearBatch();
                    conn.commit();
                    row = 0;
                }
            }
        } catch (Exception e) {
            LogExceptionUtils.logException(log, e);
            System.out.println(bean.getTableName());
            throw e;
        } finally {
            if (csvReader != null) {
                csvReader.close();
            }
            if (inRead != null) {
                inRead.close();
            }
            if (in != null) {
                in.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return totalRow;
    }

    private String getInsertSql(String tableName, String[] hands) {
        StringBuffer sql = new StringBuffer();
        StringBuffer vals = new StringBuffer();
        sql.append("INSERT INTO ");
        sql.append(tableName);
        sql.append(" (");
        vals.append(" VALUES (");
        int len = hands.length;
        for (int i = 0; i < len; i++) {
            if (hands[i] != null) {
                sql.append(hands[i]);
                vals.append("?");
                if (i < len - 1) {
                    sql.append(",");
                    vals.append(",");
                }

            }
        }
        sql.append(")");
        vals.append(")");
        sql.append(vals.toString());
        // System.out.println(sql.toString());
        return sql.toString();
    }

}

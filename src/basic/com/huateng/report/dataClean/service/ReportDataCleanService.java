package com.huateng.report.dataClean.service;

import com.huateng.common.log.HtLog;
import com.huateng.common.log.HtLogFactory;
import com.huateng.ebank.business.common.ROOTDAO;
import com.huateng.ebank.business.common.ROOTDAOUtils;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ApplicationContextUtils;
import com.huateng.report.dataClean.bean.ReportDataCleanBean;
import com.huateng.report.dataClean.utils.ReportDataCleanUtil;

public class ReportDataCleanService {
    private static final HtLog htlog = HtLogFactory.getLogger(ReportDataCleanService.class);

    protected ReportDataCleanService() {
    }

    public synchronized static ReportDataCleanService getInstance() {
        return (ReportDataCleanService) ApplicationContextUtils.getBean(ReportDataCleanService.class.getName());
    }

    /**
     * 执行数据清理
     *
     * @return
     * @throws CommonException
     */
    public void executeDataClean(ReportDataCleanBean cleanbean) throws CommonException {
        ROOTDAO rootDao = ROOTDAOUtils.getROOTDAO();
        htlog.info("clean table " + cleanbean.getTableName() + "===begin====");
        String delSql = cleanbean.getDelSql();
        String dt = null;
        if (cleanbean.getDateFormate() != null && cleanbean.getDateFormate().trim().length() > 0) {
            dt = ReportDataCleanUtil.getCleanDate(cleanbean.getDateFormate(), cleanbean.getReservesDay());
            htlog.info("clean table " + cleanbean.getTableName() + ",date:" + dt);
        }
        if (dt != null) {
            delSql = delSql.replace("{0}", "'" + dt + "'");
        }
        if (cleanbean.getDetList().size() > 0) {
            for (int i = 0; i < cleanbean.getDetList().size(); i++) {
                ReportDataCleanBean detbean = cleanbean.getDetList().get(i);
                executeDataClean(detbean);
            }
        }
        int count = rootDao.executeSql(delSql);
        htlog.info(cleanbean.getTableName() + " clean data row count:" + count);
        htlog.info("clean table " + cleanbean.getTableName() + "===end====");
    }
}

package com.huateng.hibernate.dialect.seq;

import java.math.BigDecimal;

import org.hibernate.HibernateException;

import com.huateng.exception.AppException;
import com.huateng.report.utils.LogExceptionUtils;

public class HTOracle10DialectSeq extends _DialectSeq {
    private String defaultCreateSequece = "CREATE SEQUENCE ${1} START WITH 1  INCREMENT BY 1 NOMAXVALUE  NOCYCLE NOCACHE";

    private String getNextSequence = "SELECT ${1}.nextval from dual";

    public Integer getSeqNo(String sequenceName) throws AppException {
        String flag = (String) this.squenceMap.get(sequenceName);
        if ((flag != null) && (flag.equals("true"))) {
            String getNextSeq = "";
            getNextSeq = this.getNextSequence.replace("${1}", sequenceName);
            try {
                return Integer.valueOf(((BigDecimal) createSQLQuery(getNextSeq).get(0)).intValue());
            } catch (HibernateException e) {
                LogExceptionUtils.logException(logger, e);
                this.logger.error("取下个序号sequenceName :" + sequenceName + "失败");

                e.printStackTrace();
            } catch (Exception e) {
                LogExceptionUtils.logException(logger, e);
                this.logger.error("取下个序号sequenceName :" + sequenceName + "失败");

                e.printStackTrace();
            }
        } else {
            throw new AppException("当前序号没有在generatorRegister.xml 的sequenceList 定义过" + sequenceName);
        }

        return null;
    }

    public void initSeqGenerator() {
        try {
            createAndCheckSequence(this.getNextSequence, this.defaultCreateSequece);
        } catch (AppException e) {
            LogExceptionUtils.logException(logger, e);
        }
    }
}
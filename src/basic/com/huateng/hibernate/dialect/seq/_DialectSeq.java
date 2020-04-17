package com.huateng.hibernate.dialect.seq;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.common.log.LoggerConstants;
import com.huateng.exception.AppException;
import com.huateng.report.utils.LogExceptionUtils;

public abstract class _DialectSeq extends HibernateDaoSupport implements IDialectSeq {

    public Logger logger = Logger.getLogger(LoggerConstants.SYSTEM_STRAT_UP_LOG);

    public String id;

    public String desc;

    public List sequenceList;

    public Map<String, String> squenceMap = new HashMap<String, String>();;

    public Connection conn;

    public Statement statment;

    /**
     * 校验当前的sequenceList 的准确性
     * 
     * @throws SQLException
     */
    public void createAndCheckSequence(String getNextSequence, String defaultCreateSequece) throws AppException {

        if (sequenceList != null && sequenceList.size() != 0) {
            for (int i = 0; i < sequenceList.size(); i++) {
                String sequence = (String) sequenceList.get(i);
                if (sequence != null && !sequence.equals("")) {
                    String sql = getNextSequence;
                    String sql1 = defaultCreateSequece;
                    sql = sql.replace("${1}", sequence);
                    if (logger.isDebugEnabled()) {
                        logger.info("执行" + sql);
                    }
                    try {
                        createSQLQuery(sql);
                        // 将当前有的Sequence 放入Map
                        squenceMap.put(sequence, "true");
                    } catch (Exception e) {
                        LogExceptionUtils.logException(logger, e);
                        logger.warn("当前序号没有在generatorRegister.xml 的sequenceList 定义过" + sequence);
                        logger.warn("系统采取默认新建Sequence 方式: " + sequence);
                        sql1 = sql1.replace("${1}", sequence);
                        if (logger.isDebugEnabled()) {
                            logger.info("执行SQL" + sql1);
                        }
                        try {
                            executeSQLQuery(sql1);
                            // 将当前有的Sequence 放入Map
                            if (logger.isDebugEnabled()) {
                                logger.info("成功执行创建Sequence ：" + sequence + "语句");
                            }
                            squenceMap.put(sequence, "true");
                        } catch (Exception e1) {
                            LogExceptionUtils.logException(logger, e1);
                            e1.printStackTrace();
                        } finally {
                            try {
                                statment.close();
                                conn.close();
                                statment = null;
                                conn = null;
                            } catch (SQLException e1) {
                                LogExceptionUtils.logException(logger, e1);
                                throw new AppException("");
                            }
                        }
                    }
                }
            }

        } else {
            logger.warn("当前没有存在sequenceList 在generatorRegister.xml ");
            // logger.warn(ErrorCodeUnit.getErrorMessage(Module.BO_MODULE+Rescode.SEQUENCE_PREFIX_NOT_FOUND));
        }

    }

    /**
     * 执行sql 语句
     * 
     * @param sql
     * @throws Exception
     */
    public List createSQLQuery(String sql) throws Exception {

        Session s = this.getHibernateTemplate().getSessionFactory().openSession();
        List list = s.createSQLQuery(sql).list();
        s.close();
        return list;
    }

    public void executeSQLQuery(String sql) throws Exception {
        Session s = this.getHibernateTemplate().getSessionFactory().openSession();
        if (conn == null) {
            conn = s.connection();
            statment = conn.createStatement();
        }
        statment.execute(sql);
        conn.commit();
        s.close();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List getSequenceList() {
        return sequenceList;
    }

    public void setSequenceList(List sequenceList) {
        this.sequenceList = sequenceList;
    }

}

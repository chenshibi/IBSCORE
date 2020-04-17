package com.huateng.ebank.framework.operation.orm;

import com.huateng.ebank.business.common.PageQueryCondition;
import com.huateng.ebank.business.common.PageQueryResult;
import com.huateng.ebank.business.common.RangeQueryCondition;
import com.huateng.ebank.business.common.RangeQueryResult;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;
import com.huateng.hibernate.dialect.BaseDaoSupport;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.type.Type;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Repository
public class HQLDAO extends BaseDaoSupport {
    private static final Logger logger = Logger.getLogger(HQLDAO.class);

    public HQLDAO() {
    }

    public Iterator queryByQL(String hql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String) - start");
        }

        Object it = null;

        try {
            List list = this.getHibernateTemplate().find(hql);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String) - hql hql=" + hql);
            }

            Iterator returnIterator = list.iterator();
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String) - list end");
            }

            return returnIterator;
        } catch (Exception var5) {
            logger.error("queryByQL(String)", var5);
            ExceptionUtil.throwCommonException(var5.getMessage(), "GD1001", var5);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String) - end");
            }

            return (Iterator) it;
        }
    }

    public List queryByQL2List(String hql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL2List(String) - start");
        }
 
        List list = null;

        try {
            list = this.getHibernateTemplate().find(hql);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String) - hql hql=" + hql);
            }

            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String) - list end");
            }

            return list;
        } catch (Exception var4) {
            logger.error("queryByQL2List(String)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String) - end");
            }

            return list;
        }
    }

    public List queryByQL2List(String hql, Object[] objArg, Type[] typeArg) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL2List(String) - start");
        }

        List list = null;

        try {
            list = this.getHibernateTemplate().find(hql, objArg);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String, Object[], Type[]) - hql hql=" + hql);
            }

            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String, Object[], Type[]) - list end");
            }

            return list;
        } catch (Exception var6) {
            logger.error("queryByQL2List(String, Object[], Type[])", var6);
            ExceptionUtil.throwCommonException(var6.getMessage(), "GD1001", var6);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL2List(String) - end");
            }

            return list;
        }
    }

    public List queryBySQL2List(String sql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryBySQL(String) - start");
        }

        final String tempSql = sql;
        List list = null;

        try {
            list = this.getHibernateTemplate().execute(new HibernateCallback<List>() {
                @Override
                public List doInHibernate(Session session) throws HibernateException {
                    if (HQLDAO.logger.isDebugEnabled()) {
                        HQLDAO.logger.debug("queryBySQL(String) - sql sql=" + tempSql);
                    }

                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    sqlQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
                    return sqlQuery.list();
                }
            });
            if (logger.isDebugEnabled()) {
                logger.debug("queryBySQL(String) - list end");
            }
        } catch (Exception var5) {
            logger.error("queryBySQL(String)", var5);
            ExceptionUtil.throwCommonException(var5.getMessage(), "GD1001", var5);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("queryBySQL(String) - end");
        }

        return list;
    }

    public Iterator queryBySQL(String sql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryBySQL(String) - start");
        }

        final String tempSql = sql;
        Iterator it = null;

        try {
            it = (Iterator) this.getHibernateTemplate().execute(new HibernateCallback<Iterator>() {
                @Override
                public Iterator doInHibernate(Session session) throws HibernateException {
                    if (HQLDAO.logger.isDebugEnabled()) {
                        HQLDAO.logger.debug("queryBySQL(String) - sql sql=" + tempSql);
                    }

                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    return sqlQuery.list().iterator();
                }
            });
            if (logger.isDebugEnabled()) {
                logger.debug("queryBySQL(String) - list end");
            }
        } catch (Exception var5) {
            logger.error("queryBySQL(String)", var5);
            ExceptionUtil.throwCommonException(var5.getMessage(), "GD1001", var5);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("queryBySQL(String) - end");
        }

        return it;
    }

    public Iterator queryByQL(String hql, Object[] objArg, Type[] typeArg) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String, Object[], Type[]) - start");
        }

        Object it = null;

        try {
            List list = this.getHibernateTemplate().find(hql, objArg);
            Iterator returnIterator = list.iterator();
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String, Object[], Type[]) - end");
            }

            return returnIterator;
        } catch (Exception var7) {
            logger.error("queryByQL(String, Object[], Type[])", var7);
            ExceptionUtil.throwCommonException(var7.getMessage(), "GD1001", var7);
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String, Object[], Type[]) - end");
            }

            return (Iterator) it;
        }
    }

    public List queryBySQL2List(String sql, final Object[] objArg, final Type[] typeArg) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - start");
        }

        final String tempSql = sql;
        List list = null;
        logger.info("要执行查询的sql为====="+sql);
        try {
            list = this.getHibernateTemplate().execute(new HibernateCallback<List>() {
                @Override
                public List doInHibernate(Session session) throws HibernateException {
                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    if (null != objArg) {
                        for (int i = 0; i < objArg.length; ++i) {
                            if (HQLDAO.logger.isDebugEnabled()) {
                                HQLDAO.logger.debug("i=" + i);
                                HQLDAO.logger.debug("values[i]=" + objArg[i]);
                                if (typeArg != null) {
                                    HQLDAO.logger.debug("types[i]=" + typeArg[i]);
                                }
                            }

                            if (typeArg != null) {
                                sqlQuery.setParameter(i, objArg[i], typeArg[i]);
                            } else {
                                sqlQuery.setParameter(i, objArg[i]);
                            }
                        }
                    }

                    if (HQLDAO.logger.isDebugEnabled()) {
                        HQLDAO.logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - end");
                    }
                    sqlQuery.setResultTransformer(CriteriaSpecification.ALIAS_TO_ENTITY_MAP);
                    return sqlQuery.list();
                }
            });
        } catch (Exception var7) {
            logger.error("queryByQL(String sql, Object[] objArg, Type[] typeArg)", var7);
            ExceptionUtil.throwCommonException(var7.getMessage(), "GD1001", var7);
        }

        return list;
    }

    public Iterator queryBySQL(String sql, final Object[] objArg, final Type[] typeArg) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - start");
        }

        final String tempSql = sql;
        Iterator it = null;

        try {
            it = (Iterator) this.getHibernateTemplate().execute(new HibernateCallback<Iterator>() {
                @Override
                public Iterator doInHibernate(Session session) throws HibernateException {
                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    if (null != objArg) {
                        for (int i = 0; i < objArg.length; ++i) {
                            if (HQLDAO.logger.isDebugEnabled()) {
                                HQLDAO.logger.debug("i=" + i);
                                HQLDAO.logger.debug("values[i]=" + objArg[i]);
                                if (typeArg != null) {
                                    HQLDAO.logger.debug("types[i]=" + typeArg[i]);
                                }
                            }

                            if (typeArg != null) {
                                sqlQuery.setParameter(i, objArg[i], typeArg[i]);
                            } else {
                                sqlQuery.setParameter(i, objArg[i]);
                            }
                        }
                    }

                    if (HQLDAO.logger.isDebugEnabled()) {
                        HQLDAO.logger.debug("queryByQL(String sql, Object[] objArg, Type[] typeArg) - end");
                    }

                    return sqlQuery.list().iterator();
                }
            });
        } catch (Exception var7) {
            logger.error("queryByQL(String sql, Object[] objArg, Type[] typeArg)", var7);
            ExceptionUtil.throwCommonException(var7.getMessage(), "GD1001", var7);
        }

        return it;
    }

    public Iterator iterator(String hql, Object[] objArg, Type[] typeArg) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("iterator(String, Object[], Type[]) - start");
        }

        Iterator it = null;

        try {
            it = this.getHibernateTemplate().iterate(hql, objArg);
        } catch (Exception var6) {
            logger.error("iterator(String, Object[], Type[])", var6);
            ExceptionUtil.throwCommonException(var6.getMessage(), "GD1001", var6);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("iterator(String, Object[], Type[]) - end");
        }

        return it;
    }

    public Integer delete(final String hql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("delete(String) - start");
        }

        Integer count = new Integer(-1);

        try {
            count = (Integer) this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
                @Override
                public Integer doInHibernate(Session session) throws HibernateException, SQLException {
                    return new Integer(session.createQuery("delete " + hql).executeUpdate());
                }
            });
        } catch (Exception var4) {
            logger.error("delete(String)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("delete(String) - end");
        }

        return count;
    }

    public void flush() throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("flush() - start");
        }

        try {
            this.getHibernateTemplate().flush();
        } catch (Exception var2) {
            logger.error("flush()", var2);
            ExceptionUtil.throwCommonException(var2.getMessage(), "GD1001", var2);
        }

        if (logger.isDebugEnabled()) {
            logger.debug("flush() - end");
        }

    }

    public PageQueryResult pageQueryByQL(PageQueryCondition queryCondition) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("pageQueryByQL(PageQueryCondition) - start");
        }
        try {
            PageQueryCallback callback = new PageQueryCallback(queryCondition);
            PageQueryResult returnPageQueryResult = (PageQueryResult) this.getHibernateTemplate().execute(callback);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }

            return returnPageQueryResult;
        } catch (Exception var4) {
            logger.error("pageQueryByQL(PageQueryCondition)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }
            return null;
        }
    }

    public PageQueryResult pageQueryBySQL(PageQueryCondition queryCondition) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("pageQueryByQL(PageQueryCondition) - start");
        }

        try {
            PageQueryCallbackForSQL callback = new PageQueryCallbackForSQL(queryCondition);
            PageQueryResult returnPageQueryResult = (PageQueryResult) this.getHibernateTemplate().execute(callback);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }

            return returnPageQueryResult;
        } catch (Exception var4) {
            logger.error("pageQueryByQL(PageQueryCondition)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }

            return null;
        }
    }

    public PageQueryResult pageQueryByQLWithCount(PageQueryCondition queryCondition) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("pageQueryByQL(PageQueryCondition) - start");
        }

        try {
            PageQueryCallbackWithCount callback = new PageQueryCallbackWithCount(queryCondition);
            PageQueryResult returnPageQueryResult = (PageQueryResult) this.getHibernateTemplate().execute(callback);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }

            return returnPageQueryResult;
        } catch (Exception var4) {
            logger.error("pageQueryByQL(PageQueryCondition)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
            if (logger.isDebugEnabled()) {
                logger.debug("pageQueryByQL(PageQueryCondition) - end");
            }

            return null;
        }
    }

    public RangeQueryResult rangeQueryByQL(RangeQueryCondition queryCondition) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("rangeQueryByQL(RangeQueryCondition) - start");
        }

        try {
            RangeQueryCallback callback = new RangeQueryCallback(queryCondition);
            RangeQueryResult returnRangeQueryResult = (RangeQueryResult) this.getHibernateTemplate().execute(callback);
            if (logger.isDebugEnabled()) {
                logger.debug("rangeQueryByQL(RangeQueryCondition) - end");
            }

            return returnRangeQueryResult;
        } catch (Exception var4) {
            logger.error("rangeQueryByQL(RangeQueryCondition)", var4);
            ExceptionUtil.throwCommonException(var4.getMessage(), "GD1001", var4);
            if (logger.isDebugEnabled()) {
                logger.debug("rangeQueryByQL(RangeQueryCondition) - end");
            }

            return null;
        }
    }

    public Iterator createQuery(String hql) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String, Object[], Type[]) - start");
        }

        Session session = this.getHibernateTemplate().getSessionFactory().openSession();
        Object it = null;

        try {
            Query query = session.createQuery(hql);
            Iterator returnIterator = query.iterate();
            if (logger.isDebugEnabled()) {
                logger.debug("queryByQL(String, Object[], Type[]) - end");
            }

            Iterator var6 = returnIterator;
            return var6;
        } catch (Exception var10) {
            logger.error("queryByQL(String, Object[], Type[])", var10);
            ExceptionUtil.throwCommonException(var10.getMessage(), "GD1001", var10);
        } finally {
            session.close();
        }

        if (logger.isDebugEnabled()) {
            logger.debug("queryByQL(String, Object[], Type[]) - end");
        }

        return (Iterator) it;
    }
}

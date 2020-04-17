package com.huateng.ebank.business.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.LockAcquisitionException;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

public class ROOTDAO extends com.huateng.ebank.framework.operation.orm.HQLDAO {

    private static final Logger log = Logger.getLogger(ROOTDAO.class);

    public ROOTDAO() {
        super();

    }
    /**
     * 数据新增
     *
     * @param obj
     * @return
     * @throws CommonException
     */
    public Object save2(Object obj) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);
        Session session =  getHibernateTemplate().getSessionFactory().openSession();
        Transaction transtion=session.beginTransaction();
        if (log.isDebugEnabled()) {
            log.info("save(Object) - start"); //$NON-NLS-1$
        }
        Object reObj = null;

        try {
            if (obj != null) {
                reObj = session.save(obj);
                session.flush();
                
                transtion.commit();
            }
        } catch (Exception e) {
        
            log.error("save(Object)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        	transtion.rollback();
        }finally{
        	session.close();
        }
        if (log.isDebugEnabled()) {
            log.info("save(Object) - end"); //$NON-NLS-1$
        }
        return reObj;
    }
    /**
     * Hibernate查询，根据主键ID查询
     *
     * @param id
     * @return Object
     * @throws CommonException
     */
    public <T> T query(Class<T> cls, Serializable id) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(true);
        if (log.isDebugEnabled()) {
            log.info("query(Class,String) - start"); //$NON-NLS-1$
        }
        try {

            Object reObj = this.getHibernateTemplate().get(cls, id);
            if (log.isDebugEnabled()) {
                log.info("query(Class,String) - end"); //$NON-NLS-1$
            }
            return (T) reObj;
        } catch (Exception e) {
            log.error("query(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }

        if (log.isDebugEnabled()) {
            log.info("query(Class,String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    /**
     * 数据新增
     *
     * @param obj
     * @return
     * @throws CommonException
     */
    public Object save(Object obj) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);
        if (log.isDebugEnabled()) {
            log.info("save(Object) - start"); //$NON-NLS-1$
        }
        Object reObj = null;

        try {
            if (obj != null) {
                reObj = this.getHibernateTemplate().save(obj);
            }
        } catch (Exception e) {
            log.error("save(Object)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        if (log.isDebugEnabled()) {
            log.info("save(Object) - end"); //$NON-NLS-1$
        }
        return reObj;
    }

    /**
     * 更新操作
     *
     * @param po
     * @throws CommonException
     */
    public void update(Object obj) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);
        if (log.isDebugEnabled()) {
            log.info("update(Object) - start"); //$NON-NLS-1$
        }
        try {
            this.getHibernateTemplate().update(obj);
        } catch (Exception e) {
            log.error("update(Object)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }

        if (log.isDebugEnabled()) {
            log.info("update(Object) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 更新/新增操作
     *
     * @param obj
     * @return
     * @throws CommonException
     */
    public Object saveOrUpdate(Object obj) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);

        if (log.isDebugEnabled()) {
            log.info("saveOrUpdate(Object) - start"); //$NON-NLS-1$
        }
        Object reObj = null;
        try {
            reObj = this.getHibernateTemplate().merge(obj);
        } catch (Exception e) {
            log.error("saveOrUpdate(Object)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }

        if (log.isDebugEnabled()) {
            log.info("saveOrUpdate(Object) - end"); //$NON-NLS-1$
        }

        return reObj;
    }

    /**
     * 删除操作
     *
     * @param obj
     * @throws CommonException
     */
    public void delete(Object obj) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);
        if (log.isDebugEnabled()) {
            log.info("delete(Object) - start"); //$NON-NLS-1$
        }
        try {
            if (obj != null) {
                this.getHibernateTemplate().delete(obj);
            }
        } catch (Exception e) {
            log.error("delete(Object)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        if (log.isDebugEnabled()) {
            log.info("delete(Object) - end"); //$NON-NLS-1$
        }

    }

    /**
     * 根据主键ID删除
     *
     * @param id
     * @throws CommonException
     */
    public void delete(Class cls, String id) throws CommonException {
        this.getHibernateTemplate().setCacheQueries(false);
        if (log.isDebugEnabled()) {
            log.info("delete(Class,String) - start"); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().delete(query(cls, id));
        } catch (Exception e) {
            log.error("delete(Class,String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }

        if (log.isDebugEnabled()) {
            log.info("delete(Class,String) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 查询数据，返回list
     *
     * @param hql
     * @param startPage
     * @param maxRows
     * @return
     * @throws CommonException
     */
    public List pageQueryByHql(String hql, int startPage, int maxRows) throws CommonException {
        PageQueryResult pageQueryResult = pageQueryByHql(startPage, maxRows, hql);
        List list = pageQueryResult.getQueryResult();
        List<Object> retList = new ArrayList<Object>();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object[] obj = (Object[]) list.get(i);
                retList.add(obj[0]);
            }
        }
        return retList;
    }

    public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql) throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        return pageQueryByQL(queryCondition);
    }

    public PageQueryResult pageQueryByHql(int pageIndex, int pageSize, String hql, Object[] objs)
            throws CommonException {
        PageQueryCondition queryCondition = new PageQueryCondition();
        queryCondition.setQueryString(hql);
        queryCondition.setPageIndex(pageIndex);
        queryCondition.setPageSize(pageSize);
        queryCondition.setObjArray(objs);
        return pageQueryByQL(queryCondition);
    }

    /**
     * ����hql��ѯ����
     *
     * @param hql
     * @return
     * @throws CommonException
     */
    public Integer queryByHqlToCount(String hql) throws CommonException {
        return Integer.parseInt(this.queryByQL(hql).next().toString());
    }

    /**
     * @author zengqinag.yang 2013-2-23-下午4:05:31
     * @param sql
     * @return
     * @throws CommonException
     */
    public Integer queryBySqlToCount(String sql) throws CommonException {
        return Integer.parseInt(this.queryBySQL(sql).next().toString());
    }

    public Object queryByHqlMax(String hql) throws CommonException {
        final String tempHql = hql;
        Object max = null;
        try {
            max = (Object) getHibernateTemplate().execute(new HibernateCallback<Object>() {
                public Object doInHibernate(Session session) throws HibernateException {
                    return session.createQuery(tempHql).uniqueResult();
                }
            });
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        return max;
    }

    public List queryByCondition(String whereString) throws CommonException {
        try {
            List list = this.getHibernateTemplate().find(whereString);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
        }
        return null;
    }

    @SuppressWarnings("deprecation")
	public List queryByCondition(String whereString, Object[] objs) throws CommonException {
        try {
            @SuppressWarnings("rawtypes")
			List list = this.getHibernateTemplate().find(whereString, objs);
            return list;
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_GLOBALINFO_SELECT, e);
        }
        return null;
    }

    public int executeSql(String sql) throws CommonException {
        final String tempSql = sql;
        Integer row = null;
        try {
            row = (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
                public Object doInHibernate(Session session) throws HibernateException {
                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    return sqlQuery.executeUpdate();
                }
            });
        } catch (Exception e) {
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }
        if (row == null) {
            row = 0;
        }
        return row;
    }

    /*******************************************************************************************************************
     * 根据sql语句查询记录
     *
     * @param sql
     * @return
     * @throws Exception
     */
    public List queryListBySql(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryListBySql(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        List list = null;
        try {
            list = (List) getHibernateTemplate().execute(new HibernateCallback<Object>() {
                public Object doInHibernate(Session session) throws HibernateException {
                    if (log.isDebugEnabled()) {
                        log.info("queryListBySql(String) - sql sql=" + tempSql); //$NON-NLS-1$
                    }
                    SQLQuery sqlQuery = session.createSQLQuery(tempSql);
                    return sqlQuery.list();
                }
            });
            if (log.isDebugEnabled()) {
                log.info("queryListBySql(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryListBySql(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        }

        if (log.isDebugEnabled()) {
            log.info("queryListBySql(String) - end"); //$NON-NLS-1$
        }
        return list;
    }
    
    
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQLK(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
        	SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rptId",Hibernate.STRING)
    				.addScalar("eyear",Hibernate.STRING )
    				.addScalar("emonth",Hibernate.STRING );
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    
    public Iterator queryBySQLRpdID(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
        	SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rptId",Hibernate.STRING);
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    
    
    public Iterator queryBySQLF(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
        	SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("overdue",Hibernate.STRING)
        			.addScalar("credit",Hibernate.STRING );
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL5(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
        	SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("indPermitId",Hibernate.STRING)
    				.addScalar("name",Hibernate.STRING )
    				.addScalar("idType",Hibernate.STRING )
    				.addScalar("idNum",Hibernate.STRING )
    				.addScalar("queryReason",Hibernate.STRING )
    				.addScalar("serviceCode",Hibernate.STRING )
    				.addScalar("queryDate",Hibernate.STRING )
    				.addScalar("status",Hibernate.STRING )
    				.addScalar("branch",Hibernate.STRING )
    				.addScalar("ip",Hibernate.STRING )
    				.addScalar("queryOrgCode",Hibernate.STRING )
    				.addScalar("userCode",Hibernate.STRING )
        	        //add by chensibi start
    				.addScalar("userName",Hibernate.STRING )
        	        .addScalar("operatorId",Hibernate.STRING )
			        .addScalar("createTime",Hibernate.STRING )
			        .addScalar("returnTime",Hibernate.STRING )
			        .addScalar("sendTime",Hibernate.STRING )
			        .addScalar("cdappQueryTime",Hibernate.STRING )
			        .addScalar("cdappReturnTime",Hibernate.STRING );
        	        //add by chensibi end
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    
    
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL6(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
        	SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("corpPermitId",Hibernate.STRING)
    				.addScalar("entName",Hibernate.STRING )
    				.addScalar("entCertType",Hibernate.STRING )
    				.addScalar("entCertNum",Hibernate.STRING )
    				.addScalar("queryReason",Hibernate.STRING )
    				.addScalar("serviceCode",Hibernate.STRING )
    				.addScalar("queryDate",Hibernate.STRING )
    				.addScalar("status",Hibernate.STRING )
    				.addScalar("branch",Hibernate.STRING )
    				.addScalar("ip",Hibernate.STRING )
    				.addScalar("queryOrgCode",Hibernate.STRING )
    				.addScalar("userCode",Hibernate.STRING )
    				 //add by chensibi start
        	        .addScalar("operatorId",Hibernate.STRING )
        	        .addScalar("userName",Hibernate.STRING )
			        .addScalar("createTime",Hibernate.STRING )
			        .addScalar("returnTime",Hibernate.STRING )
			        .addScalar("sendTime",Hibernate.STRING )
			        .addScalar("cdappQueryTime",Hibernate.STRING )
			        .addScalar("cdappReturnTime",Hibernate.STRING );
        	        //add by chensibi end
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    
    

    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL2(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    /**
     * 根据输入条件查询
     *	@author QX 20191125
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
   /* public Iterator queryBySQL7(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("input_time",Hibernate.STRING)
    				.addScalar("individual_id",Hibernate.STRING)
    				.addScalar("individual_id_type",Hibernate.STRING)
    				.addScalar("name",Hibernate.STRING)
    				.addScalar("status",Hibernate.STRING);
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }*/
    
    public Iterator queryBySQLGen(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rptId",Hibernate.STRING)
    				.addScalar("inqCustAppId",Hibernate.STRING );
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    
    public Iterator queryBySQLGenCorp(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rptKey",Hibernate.STRING)
    				.addScalar("corpCustId",Hibernate.STRING)
    				.addScalar("detailrptKey",Hibernate.STRING);
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    
    
    public Iterator queryBySQLExcel(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("id",Hibernate.STRING)
    				/*.addScalar("city",Hibernate.STRING )
    				.addScalar("department",Hibernate.STRING )*/
    		        .addScalar("queryDate",Hibernate.STRING )
    		        .addScalar("queryMonth",Hibernate.STRING );
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    
    public Iterator queryBySQL(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql);
    		/*SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("city",Hibernate.STRING)
    				.addScalar("department",Hibernate.STRING );*/
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    
    
    
    
    public Iterator queryBySQLPersoanlExcel(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("id",Hibernate.STRING);
    		//		.addScalar("queryDate",Hibernate.STRING);
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    
    
    
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL4(String sql) throws CommonException {
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - start"); //$NON-NLS-1$
    	}
    	final String tempSql = sql;
    	Iterator it = null;
    	Session session = null;
    	try {
    		session = getHibernateTemplate().getSessionFactory().openSession();
    		SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("id",Hibernate.STRING)
    				.addScalar("name",Hibernate.STRING )
    				.addScalar("idType",Hibernate.STRING )
    				.addScalar("idNum",Hibernate.STRING )
    				.addScalar("queryReason",Hibernate.STRING )
    				.addScalar("serviceCode",Hibernate.STRING )
    				.addScalar("respId",Hibernate.STRING )
    				.addScalar("respCode",Hibernate.STRING )
    				.addScalar("respMsg",Hibernate.STRING )
    				.addScalar("queryDate",Hibernate.STRING )
    				.addScalar("createUser",Hibernate.STRING )
    				.addScalar("createTime",Hibernate.STRING )
    				.addScalar("checkUser",Hibernate.STRING )
    				.addScalar("checkTime",Hibernate.STRING )
    				.addScalar("sendTime",Hibernate.STRING )
    				.addScalar("respTime",Hibernate.STRING )
    				.addScalar("status",Hibernate.STRING )
    				.addScalar("certAuthStatus",Hibernate.STRING)
    				.addScalar("rsv2", Hibernate.STRING)
    		        .addScalar("rsv3", Hibernate.STRING);
    		sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
    		it = sqlQuery.list().iterator();
    		if (log.isDebugEnabled()) {
    			log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
    		}
    	} catch (Exception e) {
    		log.error("queryBySQL(String)", e); //$NON-NLS-1$
    		ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
    	} finally {
    		if (session != null) {
    			session.close();
    		}
    	}
    	
    	if (log.isDebugEnabled()) {
    		log.info("queryBySQL(String) - end"); //$NON-NLS-1$
    	}
    	return it;
    }
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL3(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("id",Hibernate.STRING)
            .addScalar("id",Hibernate.STRING )
            .addScalar("entName",Hibernate.STRING )
            .addScalar("entCertType",Hibernate.STRING )
            .addScalar("rsv9",Hibernate.STRING )
            .addScalar("entCertNum",Hibernate.STRING )
            .addScalar("queryReason",Hibernate.STRING )
            .addScalar("serviceCode",Hibernate.STRING )
            .addScalar("respId",Hibernate.STRING )
            .addScalar("respCode",Hibernate.STRING )
            .addScalar("respMsg",Hibernate.STRING )
            .addScalar("queryDate",Hibernate.STRING )
            .addScalar("createUser",Hibernate.STRING )
            .addScalar("createTime",Hibernate.STRING )
            .addScalar("checkUser",Hibernate.STRING )
            .addScalar("checkTime",Hibernate.STRING )
            .addScalar("sendTime",Hibernate.STRING )
            .addScalar("respTime",Hibernate.STRING )
            .addScalar("status",Hibernate.STRING )
            .addScalar("certAuthStatus",Hibernate.STRING );
            sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }

    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQL2(String sql, Object[] objs) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sql);
            if (objs != null) {
                for (int i = 0; i < objs.length; i++) {
                    sqlQuery.setParameter(i, objs[i]);
                }
            }
            // SQLQuery sqlQuery = this.getSession().createSQLQuery(tempSql,
            // objs);
            sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }
    
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryBySQLState(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rsv5",Hibernate.STRING)
            .addScalar("createTime",Hibernate.STRING )
            .addScalar("createUser",Hibernate.STRING )
            .addScalar("status",Hibernate.STRING );
             sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }  
    
    
    /**
     * 根据输入条件查询
     *
     * @param sql，SQL查询语句
     * @return Iterator，返回Map集合
     * @throws CommonException
     */
    public Iterator queryByCorpState(String sql) throws CommonException {
        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - start"); //$NON-NLS-1$
        }
        final String tempSql = sql;
        Iterator it = null;
        Session session = null;
        try {
            session = getHibernateTemplate().getSessionFactory().openSession();
            SQLQuery sqlQuery = session.createSQLQuery(sql).addScalar("rsv2",Hibernate.STRING)
            .addScalar("createTime",Hibernate.STRING )
            .addScalar("createUser",Hibernate.STRING )
            .addScalar("status",Hibernate.STRING );
             sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
            it = sqlQuery.list().iterator();
            if (log.isDebugEnabled()) {
                log.info("queryBySQL(String) - list end"); //$NON-NLS-1$
            }
        } catch (Exception e) {
            log.error("queryBySQL(String)", e); //$NON-NLS-1$
            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_DAO, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }

        if (log.isDebugEnabled()) {
            log.info("queryBySQL(String) - end"); //$NON-NLS-1$
        }
        return it;
    }  
    
    

   public boolean findAndLockNoWait(final String hql, final String alias, final Object[] objs) {
        boolean rslt = (boolean) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                log.info("findAndLockNoWait(String) - sql=" + hql);
                Query sqlQuery = session.createQuery(hql);
                // = session.createSQLQuery(hql);
                if (objs != null) {
                    for (int i = 0; i < objs.length; i++) {
                        log.info("findAndLockNoWait(String) - objs[" + i + "]=" + objs[i]);
                        sqlQuery.setParameter(i, objs[i]);
                    }
                }
                sqlQuery.setLockMode(alias, LockMode.UPGRADE_NOWAIT);
                List list = null;
                try {
                    list = sqlQuery.list();
                } catch (LockAcquisitionException e) {
                    log.error("findAndLockNoWait(String) - sql= " + hql + " failed.");
                    return false;
                }
                if (list == null || list.isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            }
        });
        return rslt;
    }

    
    public Session openHibernateSession() {
        Session session = null;
        session = getHibernateTemplate().getSessionFactory().openSession();
        return session;
    }
}

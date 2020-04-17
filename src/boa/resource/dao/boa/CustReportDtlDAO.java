package resource.dao.boa;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.boa.CustReportDtl;

/**
 * Created by zcBell on 2016/11/10.
 */
public class CustReportDtlDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustReportDtlDAO.class);

    public CustReportDtlDAO() {
        super();
    }

    public void update(CustReportDtl custReportDtl) {
        log.info("saving CustReportDtl instance with id: " + custReportDtl.getId());
        try {
            this.getHibernateTemplate().update(custReportDtl);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CustReportDtl custReportDtl) {
        log.debug("saving CustReportDtl instance with id: " + custReportDtl.getId());
        try {
            this.getHibernateTemplate().save(custReportDtl);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustReportDtl custReportDtl) {
        log.info("deleting CustReportDtl instance with id: " + custReportDtl.getId());
        try {
            this.getHibernateTemplate().delete(custReportDtl);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CustReportDtl instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CustReportDtl");
            query.executeUpdate();
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public CustReportDtl findById(java.lang.String id) {
        log.info("getting CustReportDtl instance with id: " + id);
        try {
            CustReportDtl instance = (CustReportDtl) this.getHibernateTemplate().get(CustReportDtl.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(CustReportDtl custReportDtl) {
        log.info("finding CustReportDtl instance by example");
        try {
            List results = getHibernateTemplate().findByExample(custReportDtl);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CustReportDtl instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CustReportDtl as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CustReportDtl po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustReportDtl) - start " + po.getId()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CustReportDtl)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustReportDtl) - end"); //$NON-NLS-1$
        }
    }

    /**
     * 根据输入的条件查询所有符合条件的记录
     *
     * @param whereString
     * @return 包含TlrInfo对象的List
     * @throws CommonException
     */
    public List queryByCondition(String whereString) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from CustReportDtl po where " + whereString);
            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_ROLE_RELATION_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

    public List findAll() {
        log.info("finding all CustReportDtl instances");
        try {
            String queryString = "from CustReportDtl";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public CustReportDtl merge(CustReportDtl detachedInstance) {
        log.info("merging CustReportDtl instance");
        try {
            CustReportDtl result = (CustReportDtl) getHibernateTemplate().merge(detachedInstance);
            log.info("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CustReportDtl instance) {
        log.info("attaching dirty CustReportDtl instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(CustReportDtl instance) {
        log.info("attaching clean CustReportDtl instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}

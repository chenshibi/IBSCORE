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

import resource.bean.boa.CustStepInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustStepInfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .CustStepInfo
 * @author MyEclipse Persistence Tools
 */

public class CustStepInfoDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustStepInfoDAO.class);

    public CustStepInfoDAO() {
        super();
    }

    public void update(CustStepInfo custStepInfo) {
        log.info("saving CustStepInfo instance with id: " + custStepInfo.getId());
        try {
            this.getHibernateTemplate().update(custStepInfo);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CustStepInfo custStepInfo) {
        log.debug("saving CustStepInfo instance with id: " + custStepInfo.getId());
        try {
            this.getHibernateTemplate().save(custStepInfo);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustStepInfo custStepInfo) {
        log.info("deleting CustStepInfo instance with id: " + custStepInfo.getId());
        try {
            this.getHibernateTemplate().delete(custStepInfo);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CustStepInfo instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CustStepInfo");
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

    public CustStepInfo findById(java.lang.String id) {
        log.info("getting CustStepInfo instance with id: " + id);
        try {
            CustStepInfo instance = (CustStepInfo) this.getHibernateTemplate().get(CustStepInfo.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(CustStepInfo custStepInfo) {
        log.info("finding CustStepInfo instance by example");
        try {
            List results = getHibernateTemplate().findByExample(custStepInfo);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List<CustStepInfo> findByApplicationId(String recId) {
        log.info("finding CustStepInfo instance with recID: " + recId);
        try {
            String queryString = "from CustStepInfo as model where model.recId = ?";
            return (List<CustStepInfo>) getHibernateTemplate().find(queryString, recId);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CustStepInfo instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CustStepInfo as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CustStepInfo po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustStepInfo) - start " + po.getId()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CustStepInfo)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustStepInfo) - end"); //$NON-NLS-1$
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
            List list = this.getHibernateTemplate().find("from CustStepInfo po where " + whereString);
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
        log.info("finding all CustStepInfo instances");
        try {
            String queryString = "from CustStepInfo";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public CustStepInfo merge(CustStepInfo detachedInstance) {
        log.info("merging CustStepInfo instance");
        try {
            CustStepInfo result = (CustStepInfo) getHibernateTemplate().merge(detachedInstance);
            log.info("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CustStepInfo instance) {
        log.info("attaching dirty CustStepInfo instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(CustStepInfo instance) {
        log.info("attaching clean CustStepInfo instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}
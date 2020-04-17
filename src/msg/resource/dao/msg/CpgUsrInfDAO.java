package resource.dao.msg;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.msg.CpgUsrInf;

/**
 * A data access object (DAO) providing persistence and search support for
 * CpgUsrInf entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .CpgUsrInf
 * @author MyEclipse Persistence Tools
 */

public class CpgUsrInfDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CpgUsrInfDAO.class);

    public CpgUsrInfDAO() {
        super();
    }

    public void update(CpgUsrInf cpgUsrInf) {
        log.info("saving CpgUsrInf instance with id: " + cpgUsrInf.getId());
        try {
            this.getHibernateTemplate().update(cpgUsrInf);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CpgUsrInf cpgUsrInf) {
        log.debug("saving CpgUsrInf instance with id: " + cpgUsrInf.getUserId());
        try {
            this.getHibernateTemplate().save(cpgUsrInf);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CpgUsrInf cpgUsrInf) {
        log.info("deleting CpgUsrInf instance with id: " + cpgUsrInf.getId());
        try {
            this.getHibernateTemplate().delete(cpgUsrInf);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CpgUsrInf instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CpgUsrInf");
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

    public CpgUsrInf findById(String id) {
        log.info("getting CpgUsrInf instance with id: " + id);
        try {
            String queryString = "from CpgUsrInf as model where model." + "id" + "= ?";
            List<CpgUsrInf> list = getHibernateTemplate().find(queryString, id);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public CpgUsrInf findByUserId(String userId) {
        log.info("finding CpgUsrInf instance with userId: " + ", value: " + userId);
        try {
            String queryString = "from CpgUsrInf as model where model." + "userId" + "= ?";
            List<CpgUsrInf> list = getHibernateTemplate().find(queryString, userId);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByExample(CpgUsrInf CpgUsrInf) {
        log.info("finding CpgUsrInf instance by example");
        try {
            List results = getHibernateTemplate().findByExample(CpgUsrInf);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CpgUsrInf instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CpgUsrInf as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CpgUsrInf po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgUsrInf) - start " + po.getId()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CpgUsrInf)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgUsrInf) - end"); //$NON-NLS-1$
        }
    }

    public List findAll() {
        log.info("finding all CpgUsrInf instances");
        try {
            String queryString = "from CpgUsrInf";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
}
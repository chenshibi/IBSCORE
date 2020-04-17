package resource.dao.msg;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.msg.CpgMsgUsr;

/**
 * A data access object (DAO) providing persistence and search support for
 * CpgMsgUsr entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .CpgMsgUsr
 * @author MyEclipse Persistence Tools
 */

public class CpgMsgUsrDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CpgMsgUsrDAO.class);

    public CpgMsgUsrDAO() {
        super();
    }

    public void update(CpgMsgUsr cpgMsgUsr) {
        log.info("saving CpgMsgUsr instance with id: " + cpgMsgUsr.getId());
        try {
            this.getHibernateTemplate().update(cpgMsgUsr);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CpgMsgUsr cpgMsgUsr) {
        log.debug("saving CpgMsgUsr instance with id: " + cpgMsgUsr.getUserId());
        try {
            this.getHibernateTemplate().save(cpgMsgUsr);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CpgMsgUsr cpgMsgUsr) {
        log.info("deleting CpgMsgUsr instance with id: " + cpgMsgUsr.getId());
        try {
            this.getHibernateTemplate().delete(cpgMsgUsr);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CpgMsgUsr instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CpgMsgUsr");
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

    public CpgMsgUsr findById(String id) {
        log.info("getting CpgMsgUsr instance with id: " + id);
        try {
            String queryString = "from CpgMsgUsr as model where model." + "id" + "= ?";
            List<CpgMsgUsr> list = getHibernateTemplate().find(queryString, id);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public CpgMsgUsr findByUserId(String userId) {
        log.info("finding CpgMsgUsr instance with userId: " + ", value: " + userId);
        try {
            String queryString = "from CpgMsgUsr as model where model." + "userId" + "= ?";
            List<CpgMsgUsr> list = getHibernateTemplate().find(queryString, userId);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByExample(CpgMsgUsr cpgMsgUsr) {
        log.info("finding CpgMsgUsr instance by example");
        try {
            List results = getHibernateTemplate().findByExample(cpgMsgUsr);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CpgMsgUsr instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CpgMsgUsr as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CpgMsgUsr po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgMsgUsr) - start " + po.getId()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CpgMsgUsr)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgMsgUsr) - end"); //$NON-NLS-1$
        }
    }

    public List findAll() {
        log.info("finding all CpgMsgUsr instances");
        try {
            String queryString = "from CpgMsgUsr";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
}
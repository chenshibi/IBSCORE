package resource.dao.boa;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.boa.CustHoliday;

/**
 * A data access object (DAO) providing persistence and search support for
 * CustHoliday entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .CustHoliday
 * @author MyEclipse Persistence Tools
 */

public class CustHolidayDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustHolidayDAO.class);

    public CustHolidayDAO() {
        super();
    }

    public void update(CustHoliday custHoliday) {
        log.info("saving CustHoliday instance with hdate: " + custHoliday.getHdate());
        try {
            this.getHibernateTemplate().update(custHoliday);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CustHoliday custHoliday) {
        log.debug("saving CustHoliday instance with id: " + custHoliday.getHdate());
        try {
            this.getHibernateTemplate().save(custHoliday);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustHoliday custHoliday) {
        log.info("deleting CustHoliday instance with id: " + custHoliday.getHdate());
        try {
            this.getHibernateTemplate().delete(custHoliday);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CustHoliday instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CustHoliday");
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

    public CustHoliday findByHdate(java.lang.String hdate) {
        log.info("getting CustHoliday instance with hdate: " + hdate);
        try {
            CustHoliday instance = (CustHoliday) this.getHibernateTemplate().get(CustHoliday.class, hdate);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(CustHoliday custHoliday) {
        log.info("finding CustHoliday instance by example");
        try {
            List results = getHibernateTemplate().findByExample(custHoliday);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CustHoliday po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustHoliday) - start " + po.getHdate()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CustHoliday)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CustHoliday) - end"); //$NON-NLS-1$
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
            List list = this.getHibernateTemplate().find("from CustHoliday po where " + whereString);
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
        log.info("finding all CustHoliday instances");
        try {
            String queryString = "from CustHoliday";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
}
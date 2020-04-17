package resource.dao.boa;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.boa.CustChildInfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Judicial entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see .Judicial
 * @author MyEclipse Persistence Tools
 */

public class CustChildInfoDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustChildInfoDAO.class);

    public CustChildInfoDAO() {
        super();
    }

    public void update(CustChildInfo custChildInfo) {
        log.info("saving CustChildInfo instance with id: " + custChildInfo.getId());
        try {
            this.getHibernateTemplate().update(custChildInfo);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CustChildInfo custChildInfo) {
        log.debug("saving CustChildInfo instance with id: " + custChildInfo.getId());
        try {
            this.getHibernateTemplate().save(custChildInfo);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustChildInfo custChildInfo) {
        log.info("deleting CustChildInfo instance with id: " + custChildInfo.getId());
        try {
            this.getHibernateTemplate().delete(custChildInfo);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CustChildInfo findById(java.lang.String id) {
        log.info("getting CustChildInfo instance with id: " + id);
        try {
            CustChildInfo instance = (CustChildInfo) this.getHibernateTemplate().get(CustChildInfo.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CustChildInfo instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CustChildInfo as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

}
package resource.dao.boa;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.boa.CustChildConnect;

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

public class CustChildConnectDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustChildConnectDAO.class);

    public CustChildConnectDAO() {
        super();
    }

    public void update(CustChildConnect custChildConnect) {
        log.info("saving custChildConnect instance with id: " + custChildConnect.getId());
        try {
            this.getHibernateTemplate().update(custChildConnect);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CustChildConnect custChildConnect) {
        log.debug("saving custChildConnect instance with id: " + custChildConnect.getId());
        try {
            this.getHibernateTemplate().save(custChildConnect);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustChildConnect custChildConnect) {
        log.info("deleting custChildConnect instance with id: " + custChildConnect.getId());
        try {
            this.getHibernateTemplate().delete(custChildConnect);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CustChildConnect findById(java.lang.String id) {
        log.info("getting custChildConnect instance with id: " + id);
        try {
            CustChildConnect instance = (CustChildConnect) this.getHibernateTemplate().get(CustChildConnect.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CustChildConnect instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CustChildConnect as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

}
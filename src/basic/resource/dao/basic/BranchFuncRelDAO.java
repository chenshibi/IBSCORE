package resource.dao.basic;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.basic.BranchFuncRel;

/**
 * A data access object (DAO) providing persistence and search support for
 * BranchFuncRel entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see resource.bean.basic.BranchFuncRel
 * @author MyEclipse Persistence Tools
 */

public class BranchFuncRelDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(BranchFuncRelDAO.class);
    // property constants
    public static final String BRANCHID = "brcode";
    public static final String FUNCID = "funcid";

    @Override
    protected void initDao() {
        // do nothing
    }

    public void save(BranchFuncRel transientInstance) {
        log.info("saving BranchFuncRel instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(BranchFuncRel persistentInstance) {
        log.info("deleting BranchFuncRel instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public BranchFuncRel findById(java.lang.Integer id) {
        log.info("getting BranchFuncRel instance with id: " + id);
        try {
            BranchFuncRel instance = (BranchFuncRel) getHibernateTemplate()
                    .get("com.huateng.ebank.entity.data.mng.BranchFuncRel", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List findByExample(BranchFuncRel instance) {
        log.info("finding BranchFuncRel instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding BranchFuncRel instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from BranchFuncRel model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByBranchid(Object branchid) {
        return findByProperty(BRANCHID, branchid);
    }

    public List findByFuncid(Object funcid) {
        return findByProperty(FUNCID, funcid);
    }

    public List findAll() {
        log.info("finding all BranchFuncRel instances");
        try {
            String queryString = "from BranchFuncRel";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }

    public BranchFuncRel merge(BranchFuncRel detachedInstance) {
        log.info("merging BranchFuncRel instance");
        try {
            BranchFuncRel result = (BranchFuncRel) getHibernateTemplate().merge(detachedInstance);
            log.info("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(BranchFuncRel instance) {
        log.info("attaching dirty BranchFuncRel instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(BranchFuncRel instance) {
        log.info("attaching clean BranchFuncRel instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.info("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public static BranchFuncRelDAO getFromApplicationContext(ApplicationContext ctx) {
        return (BranchFuncRelDAO) ctx.getBean("BranchFuncRelDAO");
    }
}
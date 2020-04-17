package resource.dao.msg;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.msg.CpgMsgUsrBranch;

/**
 * A data access object (DAO) providing persistence and search support for
 * CpgMsgUsrBranch entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see .CpgMsgUsrBranch
 * @author MyEclipse Persistence Tools
 */

public class CpgMsgUsrBranchDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CpgMsgUsrBranchDAO.class);

    public CpgMsgUsrBranchDAO() {
        super();
    }

    public void update(CpgMsgUsrBranch cpgMsgUsrBranch) {
        log.info("saving CpgMsgUsrBranch instance with id: " + cpgMsgUsrBranch.getId());
        try {
            this.getHibernateTemplate().update(cpgMsgUsrBranch);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(CpgMsgUsrBranch cpgMsgUsrBranch) {
        log.debug("saving CpgMsgUsrBranch instance with id: " + cpgMsgUsrBranch.getUserId());
        try {
            this.getHibernateTemplate().save(cpgMsgUsrBranch);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CpgMsgUsrBranch cpgMsgUsrBranch) {
        log.info("deleting CpgMsgUsrBranch instance with id: " + cpgMsgUsrBranch.getId());
        try {
            this.getHibernateTemplate().delete(cpgMsgUsrBranch);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public void deleteAll() {
        log.info("deleting CpgMsgUsrBranch instance");
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            Query query = session.createQuery("delete from CpgMsgUsrBranch");
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

    public CpgMsgUsrBranch findById(String id) {
        log.info("getting CpgMsgUsrBranch instance with id: " + id);
        try {
            String queryString = "from CpgMsgUsrBranch as model where model." + "id" + "= ?";
            List<CpgMsgUsrBranch> list = getHibernateTemplate().find(queryString, id);
            if (list != null && list.size() > 0) {
                return list.get(0);
            }
            return null;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<CpgMsgUsrBranch> findByUserId(String userId) {
        log.info("finding CpgMsgUsrBranch instance with userId: " + ", value: " + userId);
        try {
            String queryString = "from CpgMsgUsrBranch as model where model." + "userId" + "= ?";
            List<CpgMsgUsrBranch> list = getHibernateTemplate().find(queryString, userId);

            return list;
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public CpgMsgUsrBranch findByUserIdBrno(String userId, String brno) {
        log.info("finding CpgMsgUsrBranch instance with userId: " + ", value: " + userId + ", brno = " + brno);
        try {
            String queryString = "from CpgMsgUsrBranch as model where model.userId = ? and model.brno = ? ";
            List<CpgMsgUsrBranch> list = getHibernateTemplate().find(queryString, new String[] { userId, brno });
            if (list == null || list.size() == 0) {
                return null;
            }
            return list.get(0);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public List findByExample(CpgMsgUsrBranch cpgMsgUsrBranch) {
        log.info("finding CpgMsgUsrBranch instance by example");
        try {
            List results = getHibernateTemplate().findByExample(cpgMsgUsrBranch);
            log.info("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }

    public List findByProperty(String propertyName, Object value) {
        log.info("finding CpgMsgUsrBranch instance with property: " + propertyName + ", value: " + value);
        try {
            String queryString = "from CpgMsgUsrBranch as model where model." + propertyName + "= ?";
            return getHibernateTemplate().find(queryString, value);
        } catch (RuntimeException re) {
            log.error("find by property name failed", re);
            throw re;
        }
    }

    public void saveOrUpdate(CpgMsgUsrBranch po) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgMsgUsrBranch) - start " + po.getId()); //$NON-NLS-1$
        }

        try {
            this.getHibernateTemplate().saveOrUpdate(po);
        } catch (Exception e) {
            logger.error("saveOrUpdate(CpgMsgUsrBranch)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_INSERT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("saveOrUpdate(CpgMsgUsrBranch) - end"); //$NON-NLS-1$
        }
    }

    public List findAll() {
        log.info("finding all CpgMsgUsrBranch instances");
        try {
            String queryString = "from CpgMsgUsrBranch";
            return getHibernateTemplate().find(queryString);
        } catch (RuntimeException re) {
            log.error("find all failed", re);
            throw re;
        }
    }
}
package resource.dao.basic;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.huateng.ebank.business.common.ErrorCode;
import com.huateng.ebank.framework.exceptions.CommonException;
import com.huateng.ebank.framework.util.ExceptionUtil;

import resource.bean.basic.TlrBctlRel;

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

public class TlrBctlRelDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(TlrBctlRelDAO.class);

    public TlrBctlRelDAO() {
        super();
    }

    public void update(TlrBctlRel tlrBctlRel) {
        log.info("saving tlrBctlRel instance with id: " + tlrBctlRel.getId());
        try {
            this.getHibernateTemplate().update(tlrBctlRel);
            log.info("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void save(TlrBctlRel tlrBctlRel) {
        log.debug("saving tlrBctlRel instance with id: " + tlrBctlRel.getId());
        try {
            this.getHibernateTemplate().save(tlrBctlRel);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(TlrBctlRel tlrBctlRel) {
        log.info("deleting tlrBctlRel instance with id: " + tlrBctlRel.getId());
        try {
            this.getHibernateTemplate().delete(tlrBctlRel);
            log.info("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TlrBctlRel findById(java.lang.String id) {
        log.info("getting tlrBctlRel instance with id: " + id);
        try {
            TlrBctlRel instance = (TlrBctlRel) this.getHibernateTemplate().get(TlrBctlRel.class, id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public TlrBctlRel findByTlrBctl(String tlrno, String brno) {
        log.info("finding TlrBctlRel instance with property: tlrno + brno, value: " + tlrno + ", " + brno);
        try {
            String queryString = "from TlrBctlRel as model where model.tlrNo = ? and model.brNo = ? ";
            List<TlrBctlRel> list = getHibernateTemplate().find(queryString, tlrno, brno);
            if (list == null || list.size() == 0) {
                return null;
            } else {
                return list.get(0);
            }
        } catch (Exception re) {
            log.error("find by property name failed", re);
        }
        return null;
    }

    public List<TlrBctlRel> findByTlr(String tlrno) {
        log.info("finding TlrBctlRel instance with property: tlrno, value: " + tlrno);
        try {
            String queryString = "from TlrBctlRel as model where model.tlrNo = ? ";
            return getHibernateTemplate().find(queryString, tlrno);
        } catch (Exception re) {
            log.error("find by property name failed", re);
        }
        return null;
    }

    public List<TlrBctlRel> findEffectiveByTlr(String tlrno) {
        log.info("finding TlrBctlRel instance with property: tlrno, value: " + tlrno);
        try {
            String queryString = "from TlrBctlRel as model where model.status = '1' and model.tlrNo = ? ";
            return getHibernateTemplate().find(queryString, tlrno);
        } catch (Exception re) {
            log.error("find by property name failed", re);
        }
        return null;
    }

    public List queryByCondition(String whereString) throws CommonException {
        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - start"); //$NON-NLS-1$
        }

        try {
            List list = this.getHibernateTemplate().find("from TlrBctlRel po where " + whereString);

            if (logger.isDebugEnabled()) {
                logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
            }
            return list;
        } catch (Exception e) {
            logger.error("queryByCondition(String)", e); //$NON-NLS-1$

            ExceptionUtil.throwCommonException(e.getMessage(), ErrorCode.ERROR_CODE_TLR_INFO_SELECT, e);
        }

        if (logger.isDebugEnabled()) {
            logger.info("queryByCondition(String) - end"); //$NON-NLS-1$
        }
        return null;
    }

}
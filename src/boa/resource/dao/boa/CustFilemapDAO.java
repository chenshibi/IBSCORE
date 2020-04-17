package resource.dao.boa;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.boa.CustFilemap;

public class CustFilemapDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CustFilemapDAO.class);

    public void update(CustFilemap pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CustFilemap pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustFilemap pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CustFilemap findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CustFilemap) this.getHibernateTemplate().get(CustFilemap.class, id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public boolean isNotBlankOrNull(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof java.lang.String) {
            return StringUtils.isNotBlank((String) o);
        }
        return true;
    }

    public List<CustFilemap> findByProperties(CustFilemap pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustFilemap as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if (isNotBlankOrNull(pojo.getId())) {
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if (isNotBlankOrNull(pojo.getFiletype())) {
                queryString.append(" and model.filetype = ? ");
                binds.add(pojo.getFiletype());
            }
            if (isNotBlankOrNull(pojo.getFilename())) {
                queryString.append(" and model.filename = ? ");
                binds.add(pojo.getFilename());
            }
            if (isNotBlankOrNull(pojo.getFilepath())) {
                queryString.append(" and model.filepath = ? ");
                binds.add(pojo.getFilepath());
            }
            if (isNotBlankOrNull(pojo.getMainId())) {
                queryString.append(" and model.mainId = ? ");
                binds.add(pojo.getMainId());
            }
            if (isNotBlankOrNull(pojo.getSysname())) {
                queryString.append(" and model.sysname = ? ");
                binds.add(pojo.getSysname());
            }
            if (isNotBlankOrNull(pojo.getRcvtime())) {
                queryString.append(" and model.rcvtime = ? ");
                binds.add(pojo.getRcvtime());
            }
            if (isNotBlankOrNull(pojo.getTxnId())) {
                queryString.append(" and model.txnId = ? ");
                binds.add(pojo.getTxnId());
            }
            if (isNotBlankOrNull(pojo.getFiller1())) {
                queryString.append(" and model.filler1 = ? ");
                binds.add(pojo.getFiller1());
            }
            if (isNotBlankOrNull(pojo.getFiller2())) {
                queryString.append(" and model.filler2 = ? ");
                binds.add(pojo.getFiller2());
            }
            if (isNotBlankOrNull(pojo.getFiller3())) {
                queryString.append(" and model.filler3 = ? ");
                binds.add(pojo.getFiller3());
            }
            if (isNotBlankOrNull(pojo.getFiller4())) {
                queryString.append(" and model.filler4 = ? ");
                binds.add(pojo.getFiller4());
            }
            if (isNotBlankOrNull(pojo.getFiller5())) {
                queryString.append(" and model.filler5 = ? ");
                binds.add(pojo.getFiller5());
            }
            if (isNotBlankOrNull(pojo.getFiller6())) {
                queryString.append(" and model.filler6 = ? ");
                binds.add(pojo.getFiller6());
            }
            if (isNotBlankOrNull(pojo.getFiller7())) {
                queryString.append(" and model.filler7 = ? ");
                binds.add(pojo.getFiller7());
            }
            if (isNotBlankOrNull(pojo.getFiller8())) {
                queryString.append(" and model.filler8 = ? ");
                binds.add(pojo.getFiller8());
            }
            if (isNotBlankOrNull(pojo.getFiller9())) {
                queryString.append(" and model.filler9 = ? ");
                binds.add(pojo.getFiller9());
            }
            if (isNotBlankOrNull(pojo.getFiller10())) {
                queryString.append(" and model.filler10 = ? ");
                binds.add(pojo.getFiller10());
            }
            if (isNotBlankOrNull(pojo.getFiller11())) {
                queryString.append(" and model.filler11 = ? ");
                binds.add(pojo.getFiller11());
            }
            if (isNotBlankOrNull(pojo.getFiller12())) {
                queryString.append(" and model.filler12 = ? ");
                binds.add(pojo.getFiller12());
            }
            return (List<CustFilemap>) getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}

package resource.dao.msg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.msg.CpgClientEmail;

public class CpgClientEmailDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CpgClientEmailDAO.class);

    public void update(CpgClientEmail pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CpgClientEmail pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CpgClientEmail pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CpgClientEmail findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CpgClientEmail) this.getHibernateTemplate().get(CpgClientEmail.class, id);
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
        return false;
    }

    public List<CpgClientEmail> findByProperties(CpgClientEmail pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CpgClientEmail as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if (isNotBlankOrNull(pojo.getId())) {
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if (isNotBlankOrNull(pojo.getActno())) {
                queryString.append(" and model.actno = ? ");
                binds.add(pojo.getActno());
            }
            if (isNotBlankOrNull(pojo.getActName())) {
                queryString.append(" and model.actName = ? ");
                binds.add(pojo.getActName());
            }
            if (isNotBlankOrNull(pojo.getBrno())) {
                queryString.append(" and model.brno = ? ");
                binds.add(pojo.getBrno());
            }
            if (isNotBlankOrNull(pojo.getEmail())) {
                queryString.append(" and model.email = ? ");
                binds.add(pojo.getEmail());
            }
            if (isNotBlankOrNull(pojo.getMsgId())) {
                queryString.append(" and model.msgId = ? ");
                binds.add(pojo.getMsgId());
            }
            if (isNotBlankOrNull(pojo.getMsgName())) {
                queryString.append(" and model.msgName = ? ");
                binds.add(pojo.getMsgName());
            }
            if (isNotBlankOrNull(pojo.getSndTime())) {
                queryString.append(" and model.sndTime = ? ");
                binds.add(pojo.getSndTime());
            }
            if (isNotBlankOrNull(pojo.getSt())) {
                queryString.append(" and model.st = ? ");
                binds.add(pojo.getSt());
            }
            if (isNotBlankOrNull(pojo.getErrmsg())) {
                queryString.append(" and model.errmsg = ? ");
                binds.add(pojo.getErrmsg());
            }
            if (isNotBlankOrNull(pojo.getRsv1())) {
                queryString.append(" and model.rsv1 = ? ");
                binds.add(pojo.getRsv1());
            }
            if (isNotBlankOrNull(pojo.getRsv2())) {
                queryString.append(" and model.rsv2 = ? ");
                binds.add(pojo.getRsv2());
            }
            if (isNotBlankOrNull(pojo.getRsv3())) {
                queryString.append(" and model.rsv3 = ? ");
                binds.add(pojo.getRsv3());
            }
            if (isNotBlankOrNull(pojo.getRsv4())) {
                queryString.append(" and model.rsv4 = ? ");
                binds.add(pojo.getRsv4());
            }
            if (isNotBlankOrNull(pojo.getRsv5())) {
                queryString.append(" and model.rsv5 = ? ");
                binds.add(pojo.getRsv5());
            }
            if (isNotBlankOrNull(pojo.getRsv6())) {
                queryString.append(" and model.rsv6 = ? ");
                binds.add(pojo.getRsv6());
            }
            return (List<CpgClientEmail>) getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}

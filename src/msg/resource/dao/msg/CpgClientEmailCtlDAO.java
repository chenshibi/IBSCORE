package resource.dao.msg;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.msg.CpgClientEmailCtl;

public class CpgClientEmailCtlDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CpgClientEmailCtlDAO.class);

    public void update(CpgClientEmailCtl pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CpgClientEmailCtl pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CpgClientEmailCtl pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CpgClientEmailCtl findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CpgClientEmailCtl) this.getHibernateTemplate().get(CpgClientEmailCtl.class, id);
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

    public List<CpgClientEmailCtl> findByProperties(CpgClientEmailCtl pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CpgClientEmailCtl as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if (isNotBlankOrNull(pojo.getId())) {
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if (isNotBlankOrNull(pojo.getMsgId())) {
                queryString.append(" and model.msgId = ? ");
                binds.add(pojo.getMsgId());
            }
            if (isNotBlankOrNull(pojo.getMsgName())) {
                queryString.append(" and model.msgName = ? ");
                binds.add(pojo.getMsgName());
            }
            if (isNotBlankOrNull(pojo.getSysName())) {
                queryString.append(" and model.sysName = ? ");
                binds.add(pojo.getSysName());
            }
            if (isNotBlankOrNull(pojo.getBrno())) {
                queryString.append(" and model.brno = ? ");
                binds.add(pojo.getBrno());
            }
            if (isNotBlankOrNull(pojo.getClientSnd())) {
                queryString.append(" and model.clientSnd = ? ");
                binds.add(pojo.getClientSnd());
            }
            if (isNotBlankOrNull(pojo.getOpsSnd())) {
                queryString.append(" and model.opsSnd = ? ");
                binds.add(pojo.getOpsSnd());
            }
            if (isNotBlankOrNull(pojo.getEmail())) {
                queryString.append(" and model.email = ? ");
                binds.add(pojo.getEmail());
            }
            if (isNotBlankOrNull(pojo.getSt())) {
                queryString.append(" and model.st = ? ");
                binds.add(pojo.getSt());
            }
            if (isNotBlankOrNull(pojo.getMdTlr())) {
                queryString.append(" and model.mdTlr = ? ");
                binds.add(pojo.getMdTlr());
            }
            if (isNotBlankOrNull(pojo.getMdTime())) {
                queryString.append(" and model.mdTime = ? ");
                binds.add(pojo.getMdTime());
            }
            if (isNotBlankOrNull(pojo.getApvTlr())) {
                queryString.append(" and model.apvTlr = ? ");
                binds.add(pojo.getApvTlr());
            }
            if (isNotBlankOrNull(pojo.getApvTime())) {
                queryString.append(" and model.apvTime = ? ");
                binds.add(pojo.getApvTime());
            }
            if (isNotBlankOrNull(pojo.getCrtDt())) {
                queryString.append(" and model.crtDt = ? ");
                binds.add(pojo.getCrtDt());
            }
            if (isNotBlankOrNull(pojo.getRoleGroup())) {
                queryString.append(" and model.roleGroup = ? ");
                binds.add(pojo.getRoleGroup());
            }
            if (isNotBlankOrNull(pojo.getIsLock())) {
                queryString.append(" and model.isLock = ? ");
                binds.add(pojo.getIsLock());
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
            return (List<CpgClientEmailCtl>) getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}

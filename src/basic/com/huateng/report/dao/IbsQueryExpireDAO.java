package com.huateng.report.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.IbsQueryExpire;

@Repository
public class IbsQueryExpireDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(IbsQueryExpireDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(IbsQueryExpire pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(IbsQueryExpire pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(IbsQueryExpire pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public IbsQueryExpire findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (IbsQueryExpire)this.getHibernateTemplate().get(IbsQueryExpire.class, id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public boolean isNotBlankOrNull(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof java.lang.String){
            return StringUtils.isNotBlank((String) o);
        }
        else {
            return true;
        }
    }

    public List<IbsQueryExpire> findByProperties(IbsQueryExpire pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from IbsQueryExpire as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            return (List<IbsQueryExpire>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}

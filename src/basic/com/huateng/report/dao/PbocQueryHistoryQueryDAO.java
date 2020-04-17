package com.huateng.report.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import resource.bean.crms.CrComEca;
import resource.bean.crms.CustPbocHistoryQuery;

public class PbocQueryHistoryQueryDAO extends HibernateDaoSupport {


	    private static final Logger log = Logger.getLogger(CrComEcaDAO.class);
	    
	    @Resource(name = "mySessionFactory")
	    public void setSuperSessionFactory(SessionFactory sessionFactory) {
	        super.setSessionFactory(sessionFactory);
	    }

	    public void update(CustPbocHistoryQuery pojo) {
	        log.info("update pojo instance with id: " + pojo.getId());
	        try {
	            this.getHibernateTemplate().update(pojo);
	            log.info("update successful " + pojo.toString());
	        } catch (RuntimeException re) {
	            log.error("update failed", re);
	            throw re;
	        }
	    }

	    public void save(CustPbocHistoryQuery pojo) {
	        log.info("save pojo instance with id: " + pojo.getId());
	        try {
	        	this.getHibernateTemplate().save(pojo);
	            log.info("save successful " + pojo.toString());
	        } catch (RuntimeException re) {
	            log.error("save failed", re);
	            throw re;
	        }
	    }

	    public void delete(CustPbocHistoryQuery pojo) {
	        log.info("delete pojo instance with id: " + pojo.getId());
	        try {
	            this.getHibernateTemplate().delete(pojo);
	            log.info("delete successful " + pojo.toString());
	        } catch (RuntimeException re) {
	            log.error("delete failed", re);
	            throw re;
	        }
	    }

	    public CustPbocHistoryQuery findById(java.lang.String id) {
	        log.info("getting pojo instance with id: " + id);
	        try {
	            return (CustPbocHistoryQuery)this.getHibernateTemplate().get(CustPbocHistoryQuery.class, id);
	        } catch (RuntimeException re) {
	            log.error("get failed", re);
	            throw re;
	        }
	    }


}

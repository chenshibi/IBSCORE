package com.huateng.report.dao;

import java.util.List;

import javax.annotation.Resource;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.report.pboc.util.DevUtils;

import resource.bean.crms.CrComEb02bh;
import resource.bean.crms.CrComEb02ch;
@Repository
public class CrComEb02chDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEb02chDAO.class);

    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public void update(CrComEb02ch pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEb02ch pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEb02ch pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEb02ch findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEb02ch)this.getHibernateTemplate().get(CrComEb02ch.class, id);
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

    public List<CrComEb02ch> findByProperties(CrComEb02ch pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEb02ch as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getBatchId())){
                queryString.append(" and model.batchId = ? ");
                binds.add(pojo.getBatchId());
            }
            if(isNotBlankOrNull(pojo.getEb02cr01())){
                queryString.append(" and model.eb02cr01 = ? ");
                binds.add(pojo.getEb02cr01());
            }
            if(isNotBlankOrNull(pojo.getEb02cs02())){
                queryString.append(" and model.eb02cs02 = ? ");
                binds.add(pojo.getEb02cs02());
            }
            if(isNotBlankOrNull(pojo.getEb02cj01())){
                queryString.append(" and model.eb02cj01 = ? ");
                binds.add(pojo.getEb02cj01());
            }
            if(isNotBlankOrNull(pojo.getEb02cs03())){
                queryString.append(" and model.eb02cs03 = ? ");
                binds.add(pojo.getEb02cs03());
            }
            if(isNotBlankOrNull(pojo.getEb02cj02())){
                queryString.append(" and model.eb02cj02 = ? ");
                binds.add(pojo.getEb02cj02());
            }
            if(isNotBlankOrNull(pojo.getEb02cs04())){
                queryString.append(" and model.eb02cs04 = ? ");
                binds.add(pojo.getEb02cs04());
            }
            if(isNotBlankOrNull(pojo.getEb02cj03())){
                queryString.append(" and model.eb02cj03 = ? ");
                binds.add(pojo.getEb02cj03());
            }
            if(isNotBlankOrNull(pojo.getEb02cs05())){
                queryString.append(" and model.eb02cs05 = ? ");
                binds.add(pojo.getEb02cs05());
            }
            if(isNotBlankOrNull(pojo.getEb02cj04())){
                queryString.append(" and model.eb02cj04 = ? ");
                binds.add(pojo.getEb02cj04());
            }
            if(isNotBlankOrNull(pojo.getEb02cs06())){
                queryString.append(" and model.eb02cs06 = ? ");
                binds.add(pojo.getEb02cs06());
            }
            if(isNotBlankOrNull(pojo.getEb02cj05())){
                queryString.append(" and model.eb02cj05 = ? ");
                binds.add(pojo.getEb02cj05());
            }
            if(isNotBlankOrNull(pojo.getRsv1())){
                queryString.append(" and model.rsv1 = ? ");
                binds.add(pojo.getRsv1());
            }
            if(isNotBlankOrNull(pojo.getRsv2())){
                queryString.append(" and model.rsv2 = ? ");
                binds.add(pojo.getRsv2());
            }
            if(isNotBlankOrNull(pojo.getRsv3())){
                queryString.append(" and model.rsv3 = ? ");
                binds.add(pojo.getRsv3());
            }
            if(isNotBlankOrNull(pojo.getRsv4())){
                queryString.append(" and model.rsv4 = ? ");
                binds.add(pojo.getRsv4());
            }
            if(isNotBlankOrNull(pojo.getRsv5())){
                queryString.append(" and model.rsv5 = ? ");
                binds.add(pojo.getRsv5());
            }
            if(isNotBlankOrNull(pojo.getRsv6())){
                queryString.append(" and model.rsv6 = ? ");
                binds.add(pojo.getRsv6());
            }
            if(isNotBlankOrNull(pojo.getRsv7())){
                queryString.append(" and model.rsv7 = ? ");
                binds.add(pojo.getRsv7());
            }
            if(isNotBlankOrNull(pojo.getRsv8())){
                queryString.append(" and model.rsv8 = ? ");
                binds.add(pojo.getRsv8());
            }
            if(isNotBlankOrNull(pojo.getRsv9())){
                queryString.append(" and model.rsv9 = ? ");
                binds.add(pojo.getRsv9());
            }
            if(isNotBlankOrNull(pojo.getRsv10())){
                queryString.append(" and model.rsv10 = ? ");
                binds.add(pojo.getRsv10());
            }
            return (List<CrComEb02ch>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEb02ch> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEb02ch as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEb02ch>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


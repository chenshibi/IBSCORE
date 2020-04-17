package com.huateng.report.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.report.pboc.util.DevUtils;

import resource.bean.crms.CrPerPco;

@Repository
public class CrPerPcoDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPcoDAO.class);
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrPerPco pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPco pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPco pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPco findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPco)this.getHibernateTemplate().get(CrPerPco.class, id);
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

    public List<CrPerPco> findByProperties(CrPerPco pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPco as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPc02as01())){
                queryString.append(" and model.pc02as01 = ? ");
                binds.add(pojo.getPc02as01());
            }
            if(isNotBlankOrNull(pojo.getPc02as02())){
                queryString.append(" and model.pc02as02 = ? ");
                binds.add(pojo.getPc02as02());
            }
            if(isNotBlankOrNull(pojo.getPc02bs01())){
                queryString.append(" and model.pc02bs01 = ? ");
                binds.add(pojo.getPc02bs01());
            }
            if(isNotBlankOrNull(pojo.getPc02bj01())){
                queryString.append(" and model.pc02bj01 = ? ");
                binds.add(pojo.getPc02bj01());
            }
            if(isNotBlankOrNull(pojo.getPc02bs02())){
                queryString.append(" and model.pc02bs02 = ? ");
                binds.add(pojo.getPc02bs02());
            }
            if(isNotBlankOrNull(pojo.getPc02cs01())){
                queryString.append(" and model.pc02cs01 = ? ");
                binds.add(pojo.getPc02cs01());
            }
            if(isNotBlankOrNull(pojo.getPc02cj01())){
                queryString.append(" and model.pc02cj01 = ? ");
                binds.add(pojo.getPc02cj01());
            }
            if(isNotBlankOrNull(pojo.getPc02ds01())){
                queryString.append(" and model.pc02ds01 = ? ");
                binds.add(pojo.getPc02ds01());
            }
            if(isNotBlankOrNull(pojo.getPc02es01())){
                queryString.append(" and model.pc02es01 = ? ");
                binds.add(pojo.getPc02es01());
            }
            if(isNotBlankOrNull(pojo.getPc02es02())){
                queryString.append(" and model.pc02es02 = ? ");
                binds.add(pojo.getPc02es02());
            }
            if(isNotBlankOrNull(pojo.getPc02ej01())){
                queryString.append(" and model.pc02ej01 = ? ");
                binds.add(pojo.getPc02ej01());
            }
            if(isNotBlankOrNull(pojo.getPc02ej02())){
                queryString.append(" and model.pc02ej02 = ? ");
                binds.add(pojo.getPc02ej02());
            }
            if(isNotBlankOrNull(pojo.getPc02ej03())){
                queryString.append(" and model.pc02ej03 = ? ");
                binds.add(pojo.getPc02ej03());
            }
            if(isNotBlankOrNull(pojo.getPc02fs01())){
                queryString.append(" and model.pc02fs01 = ? ");
                binds.add(pojo.getPc02fs01());
            }
            if(isNotBlankOrNull(pojo.getPc02fs02())){
                queryString.append(" and model.pc02fs02 = ? ");
                binds.add(pojo.getPc02fs02());
            }
            if(isNotBlankOrNull(pojo.getPc02fj01())){
                queryString.append(" and model.pc02fj01 = ? ");
                binds.add(pojo.getPc02fj01());
            }
            if(isNotBlankOrNull(pojo.getPc02fj02())){
                queryString.append(" and model.pc02fj02 = ? ");
                binds.add(pojo.getPc02fj02());
            }
            if(isNotBlankOrNull(pojo.getPc02fj03())){
                queryString.append(" and model.pc02fj03 = ? ");
                binds.add(pojo.getPc02fj03());
            }
            if(isNotBlankOrNull(pojo.getPc02gs01())){
                queryString.append(" and model.pc02gs01 = ? ");
                binds.add(pojo.getPc02gs01());
            }
            if(isNotBlankOrNull(pojo.getPc02gs02())){
                queryString.append(" and model.pc02gs02 = ? ");
                binds.add(pojo.getPc02gs02());
            }
            if(isNotBlankOrNull(pojo.getPc02gj01())){
                queryString.append(" and model.pc02gj01 = ? ");
                binds.add(pojo.getPc02gj01());
            }
            if(isNotBlankOrNull(pojo.getPc02gj02())){
                queryString.append(" and model.pc02gj02 = ? ");
                binds.add(pojo.getPc02gj02());
            }
            if(isNotBlankOrNull(pojo.getPc02gj03())){
                queryString.append(" and model.pc02gj03 = ? ");
                binds.add(pojo.getPc02gj03());
            }
            if(isNotBlankOrNull(pojo.getPc02hs01())){
                queryString.append(" and model.pc02hs01 = ? ");
                binds.add(pojo.getPc02hs01());
            }
            if(isNotBlankOrNull(pojo.getPc02hs02())){
                queryString.append(" and model.pc02hs02 = ? ");
                binds.add(pojo.getPc02hs02());
            }
            if(isNotBlankOrNull(pojo.getPc02hj01())){
                queryString.append(" and model.pc02hj01 = ? ");
                binds.add(pojo.getPc02hj01());
            }
            if(isNotBlankOrNull(pojo.getPc02hj02())){
                queryString.append(" and model.pc02hj02 = ? ");
                binds.add(pojo.getPc02hj02());
            }
            if(isNotBlankOrNull(pojo.getPc02hj03())){
                queryString.append(" and model.pc02hj03 = ? ");
                binds.add(pojo.getPc02hj03());
            }
            if(isNotBlankOrNull(pojo.getPc02hj04())){
                queryString.append(" and model.pc02hj04 = ? ");
                binds.add(pojo.getPc02hj04());
            }
            if(isNotBlankOrNull(pojo.getPc02hj05())){
                queryString.append(" and model.pc02hj05 = ? ");
                binds.add(pojo.getPc02hj05());
            }
            if(isNotBlankOrNull(pojo.getPc02is01())){
                queryString.append(" and model.pc02is01 = ? ");
                binds.add(pojo.getPc02is01());
            }
            if(isNotBlankOrNull(pojo.getPc02is02())){
                queryString.append(" and model.pc02is02 = ? ");
                binds.add(pojo.getPc02is02());
            }
            if(isNotBlankOrNull(pojo.getPc02ij01())){
                queryString.append(" and model.pc02ij01 = ? ");
                binds.add(pojo.getPc02ij01());
            }
            if(isNotBlankOrNull(pojo.getPc02ij02())){
                queryString.append(" and model.pc02ij02 = ? ");
                binds.add(pojo.getPc02ij02());
            }
            if(isNotBlankOrNull(pojo.getPc02ij03())){
                queryString.append(" and model.pc02ij03 = ? ");
                binds.add(pojo.getPc02ij03());
            }
            if(isNotBlankOrNull(pojo.getPc02ij04())){
                queryString.append(" and model.pc02ij04 = ? ");
                binds.add(pojo.getPc02ij04());
            }
            if(isNotBlankOrNull(pojo.getPc02ij05())){
                queryString.append(" and model.pc02ij05 = ? ");
                binds.add(pojo.getPc02ij05());
            }
            if(isNotBlankOrNull(pojo.getPc02ks01())){
                queryString.append(" and model.pc02ks01 = ? ");
                binds.add(pojo.getPc02ks01());
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
            if(isNotBlankOrNull(pojo.getBatchId())){
                queryString.append(" and model.batchId = ? ");
                binds.add(pojo.getBatchId());
            }
            return (List<CrPerPco>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPco> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPco as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrPerPco>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


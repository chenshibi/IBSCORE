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

import resource.bean.crms.CrComEdc;
import resource.bean.crms.CrComEdd;
@Repository
public class CrComEddDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEddDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEdd pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEdd pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEdd pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEdd findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEdd)this.getHibernateTemplate().get(CrComEdd.class, id);
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

    public List<CrComEdd> findByProperties(CrComEdd pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEdd as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEd070i01())){
                queryString.append(" and model.ed070i01 = ? ");
                binds.add(pojo.getEd070i01());
            }
            if(isNotBlankOrNull(pojo.getEd070d01())){
                queryString.append(" and model.ed070d01 = ? ");
                binds.add(pojo.getEd070d01());
            }
            if(isNotBlankOrNull(pojo.getEd070d02())){
                queryString.append(" and model.ed070d02 = ? ");
                binds.add(pojo.getEd070d02());
            }
            if(isNotBlankOrNull(pojo.getEd070d03())){
                queryString.append(" and model.ed070d03 = ? ");
                binds.add(pojo.getEd070d03());
            }
            if(isNotBlankOrNull(pojo.getEd070d10())){
                queryString.append(" and model.ed070d10 = ? ");
                binds.add(pojo.getEd070d10());
            }
            if(isNotBlankOrNull(pojo.getEd070j01())){
                queryString.append(" and model.ed070j01 = ? ");
                binds.add(pojo.getEd070j01());
            }
            if(isNotBlankOrNull(pojo.getEd070d04())){
                queryString.append(" and model.ed070d04 = ? ");
                binds.add(pojo.getEd070d04());
            }
            if(isNotBlankOrNull(pojo.getEd070i02())){
                queryString.append(" and model.ed070i02 = ? ");
                binds.add(pojo.getEd070i02());
            }
            if(isNotBlankOrNull(pojo.getEd070d05())){
                queryString.append(" and model.ed070d05 = ? ");
                binds.add(pojo.getEd070d05());
            }
            if(isNotBlankOrNull(pojo.getEd070d06())){
                queryString.append(" and model.ed070d06 = ? ");
                binds.add(pojo.getEd070d06());
            }
            if(isNotBlankOrNull(pojo.getEd070r01())){
                queryString.append(" and model.ed070r01 = ? ");
                binds.add(pojo.getEd070r01());
            }
            if(isNotBlankOrNull(pojo.getEd070r02())){
                queryString.append(" and model.ed070r02 = ? ");
                binds.add(pojo.getEd070r02());
            }
            if(isNotBlankOrNull(pojo.getEd070d07())){
                queryString.append(" and model.ed070d07 = ? ");
                binds.add(pojo.getEd070d07());
            }
            if(isNotBlankOrNull(pojo.getEd070j02())){
                queryString.append(" and model.ed070j02 = ? ");
                binds.add(pojo.getEd070j02());
            }
            if(isNotBlankOrNull(pojo.getEd070d08())){
                queryString.append(" and model.ed070d08 = ? ");
                binds.add(pojo.getEd070d08());
            }
            if(isNotBlankOrNull(pojo.getEd070j03())){
                queryString.append(" and model.ed070j03 = ? ");
                binds.add(pojo.getEd070j03());
            }
            if(isNotBlankOrNull(pojo.getEd070j04())){
                queryString.append(" and model.ed070j04 = ? ");
                binds.add(pojo.getEd070j04());
            }
            if(isNotBlankOrNull(pojo.getEd070s01())){
                queryString.append(" and model.ed070s01 = ? ");
                binds.add(pojo.getEd070s01());
            }
            if(isNotBlankOrNull(pojo.getEd070d09())){
                queryString.append(" and model.ed070d09 = ? ");
                binds.add(pojo.getEd070d09());
            }
            if(isNotBlankOrNull(pojo.getEd070s02())){
                queryString.append(" and model.ed070s02 = ? ");
                binds.add(pojo.getEd070s02());
            }
            if(isNotBlankOrNull(pojo.getEd070r03())){
                queryString.append(" and model.ed070r03 = ? ");
                binds.add(pojo.getEd070r03());
            }
            if(isNotBlankOrNull(pojo.getEd070j05())){
                queryString.append(" and model.ed070j05 = ? ");
                binds.add(pojo.getEd070j05());
            }
            if(isNotBlankOrNull(pojo.getEd070j06())){
                queryString.append(" and model.ed070j06 = ? ");
                binds.add(pojo.getEd070j06());
            }
            if(isNotBlankOrNull(pojo.getEd070i03())){
                queryString.append(" and model.ed070i03 = ? ");
                binds.add(pojo.getEd070i03());
            }
            if(isNotBlankOrNull(pojo.getEd080i01())){
                queryString.append(" and model.ed080i01 = ? ");
                binds.add(pojo.getEd080i01());
            }
            if(isNotBlankOrNull(pojo.getEd080d01())){
                queryString.append(" and model.ed080d01 = ? ");
                binds.add(pojo.getEd080d01());
            }
            if(isNotBlankOrNull(pojo.getEd080d02())){
                queryString.append(" and model.ed080d02 = ? ");
                binds.add(pojo.getEd080d02());
            }
            if(isNotBlankOrNull(pojo.getEd080i02())){
                queryString.append(" and model.ed080i02 = ? ");
                binds.add(pojo.getEd080i02());
            }
            if(isNotBlankOrNull(pojo.getEd080d03())){
                queryString.append(" and model.ed080d03 = ? ");
                binds.add(pojo.getEd080d03());
            }
            if(isNotBlankOrNull(pojo.getEd080d04())){
                queryString.append(" and model.ed080d04 = ? ");
                binds.add(pojo.getEd080d04());
            }
            if(isNotBlankOrNull(pojo.getEd080j01())){
                queryString.append(" and model.ed080j01 = ? ");
                binds.add(pojo.getEd080j01());
            }
            if(isNotBlankOrNull(pojo.getEd080s01())){
                queryString.append(" and model.ed080s01 = ? ");
                binds.add(pojo.getEd080s01());
            }
            if(isNotBlankOrNull(pojo.getEd080j02())){
                queryString.append(" and model.ed080j02 = ? ");
                binds.add(pojo.getEd080j02());
            }
            if(isNotBlankOrNull(pojo.getEd080j03())){
                queryString.append(" and model.ed080j03 = ? ");
                binds.add(pojo.getEd080j03());
            }
            if(isNotBlankOrNull(pojo.getEd080j04())){
                queryString.append(" and model.ed080j04 = ? ");
                binds.add(pojo.getEd080j04());
            }
            if(isNotBlankOrNull(pojo.getEd080j05())){
                queryString.append(" and model.ed080j05 = ? ");
                binds.add(pojo.getEd080j05());
            }
            if(isNotBlankOrNull(pojo.getEd080i03())){
                queryString.append(" and model.ed080i03 = ? ");
                binds.add(pojo.getEd080i03());
            }
            if(isNotBlankOrNull(pojo.getEd090i01())){
                queryString.append(" and model.ed090i01 = ? ");
                binds.add(pojo.getEd090i01());
            }
            if(isNotBlankOrNull(pojo.getEd090d01())){
                queryString.append(" and model.ed090d01 = ? ");
                binds.add(pojo.getEd090d01());
            }
            if(isNotBlankOrNull(pojo.getEd090d02())){
                queryString.append(" and model.ed090d02 = ? ");
                binds.add(pojo.getEd090d02());
            }
            if(isNotBlankOrNull(pojo.getEd090i02())){
                queryString.append(" and model.ed090i02 = ? ");
                binds.add(pojo.getEd090i02());
            }
            if(isNotBlankOrNull(pojo.getEd090d03())){
                queryString.append(" and model.ed090d03 = ? ");
                binds.add(pojo.getEd090d03());
            }
            if(isNotBlankOrNull(pojo.getEd090d04())){
                queryString.append(" and model.ed090d04 = ? ");
                binds.add(pojo.getEd090d04());
            }
            if(isNotBlankOrNull(pojo.getEd090j01())){
                queryString.append(" and model.ed090j01 = ? ");
                binds.add(pojo.getEd090j01());
            }
            if(isNotBlankOrNull(pojo.getEd090s01())){
                queryString.append(" and model.ed090s01 = ? ");
                binds.add(pojo.getEd090s01());
            }
            if(isNotBlankOrNull(pojo.getEd090j02())){
                queryString.append(" and model.ed090j02 = ? ");
                binds.add(pojo.getEd090j02());
            }
            if(isNotBlankOrNull(pojo.getEd100j03())){
                queryString.append(" and model.ed100j03 = ? ");
                binds.add(pojo.getEd100j03());
            }
            if(isNotBlankOrNull(pojo.getEd090i03())){
                queryString.append(" and model.ed090i03 = ? ");
                binds.add(pojo.getEd090i03());
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
            return (List<CrComEdd>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

    
    public List<CrComEdd> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEdd as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEdd>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
}


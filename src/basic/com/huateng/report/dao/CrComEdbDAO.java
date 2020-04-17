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

import resource.bean.crms.CrComEda;
import resource.bean.crms.CrComEdb;
@Repository
public class CrComEdbDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEdbDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEdb pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEdb pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEdb pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEdb findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEdb)this.getHibernateTemplate().get(CrComEdb.class, id);
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

    public List<CrComEdb> findByProperties(CrComEdb pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEdb as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEd04ai01())){
                queryString.append(" and model.ed04ai01 = ? ");
                binds.add(pojo.getEd04ai01());
            }
            if(isNotBlankOrNull(pojo.getEd04ad01())){
                queryString.append(" and model.ed04ad01 = ? ");
                binds.add(pojo.getEd04ad01());
            }
            if(isNotBlankOrNull(pojo.getEd04ad02())){
                queryString.append(" and model.ed04ad02 = ? ");
                binds.add(pojo.getEd04ad02());
            }
            if(isNotBlankOrNull(pojo.getEd04ai02())){
                queryString.append(" and model.ed04ai02 = ? ");
                binds.add(pojo.getEd04ai02());
            }
            if(isNotBlankOrNull(pojo.getEd04ai03())){
                queryString.append(" and model.ed04ai03 = ? ");
                binds.add(pojo.getEd04ai03());
            }
            if(isNotBlankOrNull(pojo.getEd04ad03())){
                queryString.append(" and model.ed04ad03 = ? ");
                binds.add(pojo.getEd04ad03());
            }
            if(isNotBlankOrNull(pojo.getEd04ar01())){
                queryString.append(" and model.ed04ar01 = ? ");
                binds.add(pojo.getEd04ar01());
            }
            if(isNotBlankOrNull(pojo.getEd04ad04())){
                queryString.append(" and model.ed04ad04 = ? ");
                binds.add(pojo.getEd04ad04());
            }
            if(isNotBlankOrNull(pojo.getEd04aj01())){
                queryString.append(" and model.ed04aj01 = ? ");
                binds.add(pojo.getEd04aj01());
            }
            if(isNotBlankOrNull(pojo.getEd04ar02())){
                queryString.append(" and model.ed04ar02 = ? ");
                binds.add(pojo.getEd04ar02());
            }
            if(isNotBlankOrNull(pojo.getEd04ad05())){
                queryString.append(" and model.ed04ad05 = ? ");
                binds.add(pojo.getEd04ad05());
            }
            if(isNotBlankOrNull(pojo.getEd04ad06())){
                queryString.append(" and model.ed04ad06 = ? ");
                binds.add(pojo.getEd04ad06());
            }
            if(isNotBlankOrNull(pojo.getEd04aq01())){
                queryString.append(" and model.ed04aq01 = ? ");
                binds.add(pojo.getEd04aq01());
            }
            if(isNotBlankOrNull(pojo.getEd04br01())){
                queryString.append(" and model.ed04br01 = ? ");
                binds.add(pojo.getEd04br01());
            }
            if(isNotBlankOrNull(pojo.getEd04bd01())){
                queryString.append(" and model.ed04bd01 = ? ");
                binds.add(pojo.getEd04bd01());
            }
            if(isNotBlankOrNull(pojo.getEd04bj01())){
                queryString.append(" and model.ed04bj01 = ? ");
                binds.add(pojo.getEd04bj01());
            }
            if(isNotBlankOrNull(pojo.getEd04bd02())){
                queryString.append(" and model.ed04bd02 = ? ");
                binds.add(pojo.getEd04bd02());
            }
            if(isNotBlankOrNull(pojo.getEd04bj02())){
                queryString.append(" and model.ed04bj02 = ? ");
                binds.add(pojo.getEd04bj02());
            }
            if(isNotBlankOrNull(pojo.getEd04bd03())){
                queryString.append(" and model.ed04bd03 = ? ");
                binds.add(pojo.getEd04bd03());
            }
            if(isNotBlankOrNull(pojo.getEd04bd04())){
                queryString.append(" and model.ed04bd04 = ? ");
                binds.add(pojo.getEd04bd04());
            }
            if(isNotBlankOrNull(pojo.getEd04br02())){
                queryString.append(" and model.ed04br02 = ? ");
                binds.add(pojo.getEd04br02());
            }
            if(isNotBlankOrNull(pojo.getEd050i01())){
                queryString.append(" and model.ed050i01 = ? ");
                binds.add(pojo.getEd050i01());
            }
            if(isNotBlankOrNull(pojo.getEd050d01())){
                queryString.append(" and model.ed050d01 = ? ");
                binds.add(pojo.getEd050d01());
            }
            if(isNotBlankOrNull(pojo.getEd050i02())){
                queryString.append(" and model.ed050i02 = ? ");
                binds.add(pojo.getEd050i02());
            }
            if(isNotBlankOrNull(pojo.getEd050d02())){
                queryString.append(" and model.ed050d02 = ? ");
                binds.add(pojo.getEd050d02());
            }
            if(isNotBlankOrNull(pojo.getEd050d03())){
                queryString.append(" and model.ed050d03 = ? ");
                binds.add(pojo.getEd050d03());
            }
            if(isNotBlankOrNull(pojo.getEd050s01())){
                queryString.append(" and model.ed050s01 = ? ");
                binds.add(pojo.getEd050s01());
            }
            if(isNotBlankOrNull(pojo.getEd050j01())){
                queryString.append(" and model.ed050j01 = ? ");
                binds.add(pojo.getEd050j01());
            }
            if(isNotBlankOrNull(pojo.getEd050j02())){
                queryString.append(" and model.ed050j02 = ? ");
                binds.add(pojo.getEd050j02());
            }
            if(isNotBlankOrNull(pojo.getEd050j03())){
                queryString.append(" and model.ed050j03 = ? ");
                binds.add(pojo.getEd050j03());
            }
            if(isNotBlankOrNull(pojo.getEd050j04())){
                queryString.append(" and model.ed050j04 = ? ");
                binds.add(pojo.getEd050j04());
            }
            if(isNotBlankOrNull(pojo.getEd050j05())){
                queryString.append(" and model.ed050j05 = ? ");
                binds.add(pojo.getEd050j05());
            }
            if(isNotBlankOrNull(pojo.getEd050s02())){
                queryString.append(" and model.ed050s02 = ? ");
                binds.add(pojo.getEd050s02());
            }
            if(isNotBlankOrNull(pojo.getEd050d04())){
                queryString.append(" and model.ed050d04 = ? ");
                binds.add(pojo.getEd050d04());
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
            return (List<CrComEdb>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEdb> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEdb as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEdb>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


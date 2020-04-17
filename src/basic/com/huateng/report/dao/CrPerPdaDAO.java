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

import resource.bean.crms.CrPerPda;
@Repository
public class CrPerPdaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPdaDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrPerPda pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPda pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPda pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPda findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPda)this.getHibernateTemplate().get(CrPerPda.class, id);
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

    public List<CrPerPda> findByProperties(CrPerPda pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPda as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPd01ai01())){
                queryString.append(" and model.pd01ai01 = ? ");
                binds.add(pojo.getPd01ai01());
            }
            if(isNotBlankOrNull(pojo.getPd01ad01())){
                queryString.append(" and model.pd01ad01 = ? ");
                binds.add(pojo.getPd01ad01());
            }
            if(isNotBlankOrNull(pojo.getPd01ad02())){
                queryString.append(" and model.pd01ad02 = ? ");
                binds.add(pojo.getPd01ad02());
            }
            if(isNotBlankOrNull(pojo.getPd01ai02())){
                queryString.append(" and model.pd01ai02 = ? ");
                binds.add(pojo.getPd01ai02());
            }
            if(isNotBlankOrNull(pojo.getPd01ai03())){
                queryString.append(" and model.pd01ai03 = ? ");
                binds.add(pojo.getPd01ai03());
            }
            if(isNotBlankOrNull(pojo.getPd01ai04())){
                queryString.append(" and model.pd01ai04 = ? ");
                binds.add(pojo.getPd01ai04());
            }
            if(isNotBlankOrNull(pojo.getPd01ad03())){
                queryString.append(" and model.pd01ad03 = ? ");
                binds.add(pojo.getPd01ad03());
            }
            if(isNotBlankOrNull(pojo.getPd01ar01())){
                queryString.append(" and model.pd01ar01 = ? ");
                binds.add(pojo.getPd01ar01());
            }
            if(isNotBlankOrNull(pojo.getPd01ad04())){
                queryString.append(" and model.pd01ad04 = ? ");
                binds.add(pojo.getPd01ad04());
            }
            if(isNotBlankOrNull(pojo.getPd01aj01())){
                queryString.append(" and model.pd01aj01 = ? ");
                binds.add(pojo.getPd01aj01());
            }
            if(isNotBlankOrNull(pojo.getPd01aj02())){
                queryString.append(" and model.pd01aj02 = ? ");
                binds.add(pojo.getPd01aj02());
            }
            if(isNotBlankOrNull(pojo.getPd01aj03())){
                queryString.append(" and model.pd01aj03 = ? ");
                binds.add(pojo.getPd01aj03());
            }
            if(isNotBlankOrNull(pojo.getPd01ar02())){
                queryString.append(" and model.pd01ar02 = ? ");
                binds.add(pojo.getPd01ar02());
            }
            if(isNotBlankOrNull(pojo.getPd01ad05())){
                queryString.append(" and model.pd01ad05 = ? ");
                binds.add(pojo.getPd01ad05());
            }
            if(isNotBlankOrNull(pojo.getPd01ad06())){
                queryString.append(" and model.pd01ad06 = ? ");
                binds.add(pojo.getPd01ad06());
            }
            if(isNotBlankOrNull(pojo.getPd01as01())){
                queryString.append(" and model.pd01as01 = ? ");
                binds.add(pojo.getPd01as01());
            }
            if(isNotBlankOrNull(pojo.getPd01ad07())){
                queryString.append(" and model.pd01ad07 = ? ");
                binds.add(pojo.getPd01ad07());
            }
            if(isNotBlankOrNull(pojo.getPd01ad08())){
                queryString.append(" and model.pd01ad08 = ? ");
                binds.add(pojo.getPd01ad08());
            }
            if(isNotBlankOrNull(pojo.getPd01ad09())){
                queryString.append(" and model.pd01ad09 = ? ");
                binds.add(pojo.getPd01ad09());
            }
            if(isNotBlankOrNull(pojo.getPd01ad10())){
                queryString.append(" and model.pd01ad10 = ? ");
                binds.add(pojo.getPd01ad10());
            }
            if(isNotBlankOrNull(pojo.getPd01bd01())){
                queryString.append(" and model.pd01bd01 = ? ");
                binds.add(pojo.getPd01bd01());
            }
            if(isNotBlankOrNull(pojo.getPd01br01())){
                queryString.append(" and model.pd01br01 = ? ");
                binds.add(pojo.getPd01br01());
            }
            if(isNotBlankOrNull(pojo.getPd01br04())){
                queryString.append(" and model.pd01br04 = ? ");
                binds.add(pojo.getPd01br04());
            }
            if(isNotBlankOrNull(pojo.getPd01bj01())){
                queryString.append(" and model.pd01bj01 = ? ");
                binds.add(pojo.getPd01bj01());
            }
            if(isNotBlankOrNull(pojo.getPd01br02())){
                queryString.append(" and model.pd01br02 = ? ");
                binds.add(pojo.getPd01br02());
            }
            if(isNotBlankOrNull(pojo.getPd01bj02())){
                queryString.append(" and model.pd01bj02 = ? ");
                binds.add(pojo.getPd01bj02());
            }
            if(isNotBlankOrNull(pojo.getPd01bd03())){
                queryString.append(" and model.pd01bd03 = ? ");
                binds.add(pojo.getPd01bd03());
            }
            if(isNotBlankOrNull(pojo.getPd01bd04())){
                queryString.append(" and model.pd01bd04 = ? ");
                binds.add(pojo.getPd01bd04());
            }
            if(isNotBlankOrNull(pojo.getPd01br03())){
                queryString.append(" and model.pd01br03 = ? ");
                binds.add(pojo.getPd01br03());
            }
            if(isNotBlankOrNull(pojo.getPd01cr01())){
                queryString.append(" and model.pd01cr01 = ? ");
                binds.add(pojo.getPd01cr01());
            }
            if(isNotBlankOrNull(pojo.getPd01cd01())){
                queryString.append(" and model.pd01cd01 = ? ");
                binds.add(pojo.getPd01cd01());
            }
            if(isNotBlankOrNull(pojo.getPd01cj01())){
                queryString.append(" and model.pd01cj01 = ? ");
                binds.add(pojo.getPd01cj01());
            }
            if(isNotBlankOrNull(pojo.getPd01cj02())){
                queryString.append(" and model.pd01cj02 = ? ");
                binds.add(pojo.getPd01cj02());
            }
            if(isNotBlankOrNull(pojo.getPd01cj03())){
                queryString.append(" and model.pd01cj03 = ? ");
                binds.add(pojo.getPd01cj03());
            }
            if(isNotBlankOrNull(pojo.getPd01cd02())){
                queryString.append(" and model.pd01cd02 = ? ");
                binds.add(pojo.getPd01cd02());
            }
            if(isNotBlankOrNull(pojo.getPd01cs01())){
                queryString.append(" and model.pd01cs01 = ? ");
                binds.add(pojo.getPd01cs01());
            }
            if(isNotBlankOrNull(pojo.getPd01cr02())){
                queryString.append(" and model.pd01cr02 = ? ");
                binds.add(pojo.getPd01cr02());
            }
            if(isNotBlankOrNull(pojo.getPd01cj04())){
                queryString.append(" and model.pd01cj04 = ? ");
                binds.add(pojo.getPd01cj04());
            }
            if(isNotBlankOrNull(pojo.getPd01cj05())){
                queryString.append(" and model.pd01cj05 = ? ");
                binds.add(pojo.getPd01cj05());
            }
            if(isNotBlankOrNull(pojo.getPd01cr03())){
                queryString.append(" and model.pd01cr03 = ? ");
                binds.add(pojo.getPd01cr03());
            }
            if(isNotBlankOrNull(pojo.getPd01cs02())){
                queryString.append(" and model.pd01cs02 = ? ");
                binds.add(pojo.getPd01cs02());
            }
            if(isNotBlankOrNull(pojo.getPd01cj06())){
                queryString.append(" and model.pd01cj06 = ? ");
                binds.add(pojo.getPd01cj06());
            }
            if(isNotBlankOrNull(pojo.getPd01cj07())){
                queryString.append(" and model.pd01cj07 = ? ");
                binds.add(pojo.getPd01cj07());
            }
            if(isNotBlankOrNull(pojo.getPd01cj08())){
                queryString.append(" and model.pd01cj08 = ? ");
                binds.add(pojo.getPd01cj08());
            }
            if(isNotBlankOrNull(pojo.getPd01cj09())){
                queryString.append(" and model.pd01cj09 = ? ");
                binds.add(pojo.getPd01cj09());
            }
            if(isNotBlankOrNull(pojo.getPd01cj10())){
                queryString.append(" and model.pd01cj10 = ? ");
                binds.add(pojo.getPd01cj10());
            }
            if(isNotBlankOrNull(pojo.getPd01cj11())){
                queryString.append(" and model.pd01cj11 = ? ");
                binds.add(pojo.getPd01cj11());
            }
            if(isNotBlankOrNull(pojo.getPd01cj12())){
                queryString.append(" and model.pd01cj12 = ? ");
                binds.add(pojo.getPd01cj12());
            }
            if(isNotBlankOrNull(pojo.getPd01cj13())){
                queryString.append(" and model.pd01cj13 = ? ");
                binds.add(pojo.getPd01cj13());
            }
            if(isNotBlankOrNull(pojo.getPd01cj14())){
                queryString.append(" and model.pd01cj14 = ? ");
                binds.add(pojo.getPd01cj14());
            }
            if(isNotBlankOrNull(pojo.getPd01cj15())){
                queryString.append(" and model.pd01cj15 = ? ");
                binds.add(pojo.getPd01cj15());
            }
            if(isNotBlankOrNull(pojo.getPd01cr04())){
                queryString.append(" and model.pd01cr04 = ? ");
                binds.add(pojo.getPd01cr04());
            }
            if(isNotBlankOrNull(pojo.getPd01dr01())){
                queryString.append(" and model.pd01dr01 = ? ");
                binds.add(pojo.getPd01dr01());
            }
            if(isNotBlankOrNull(pojo.getPd01dr02())){
                queryString.append(" and model.pd01dr02 = ? ");
                binds.add(pojo.getPd01dr02());
            }
            if(isNotBlankOrNull(pojo.getPd01er01())){
                queryString.append(" and model.pd01er01 = ? ");
                binds.add(pojo.getPd01er01());
            }
            if(isNotBlankOrNull(pojo.getPd01er02())){
                queryString.append(" and model.pd01er02 = ? ");
                binds.add(pojo.getPd01er02());
            }
            if(isNotBlankOrNull(pojo.getPd01es01())){
                queryString.append(" and model.pd01es01 = ? ");
                binds.add(pojo.getPd01es01());
            }
            if(isNotBlankOrNull(pojo.getPd01fs01())){
                queryString.append(" and model.pd01fs01 = ? ");
                binds.add(pojo.getPd01fs01());
            }
            if(isNotBlankOrNull(pojo.getPd01gs01())){
                queryString.append(" and model.pd01gs01 = ? ");
                binds.add(pojo.getPd01gs01());
            }
            if(isNotBlankOrNull(pojo.getPd01hs01())){
                queryString.append(" and model.pd01hs01 = ? ");
                binds.add(pojo.getPd01hs01());
            }
            if(isNotBlankOrNull(pojo.getPd01zs01())){
                queryString.append(" and model.pd01zs01 = ? ");
                binds.add(pojo.getPd01zs01());
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
            return (List<CrPerPda>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPda> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPda as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrPerPda>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }  


}


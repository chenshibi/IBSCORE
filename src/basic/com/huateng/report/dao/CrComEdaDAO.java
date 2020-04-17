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

import resource.bean.crms.CrComEd09;
import resource.bean.crms.CrComEda;
@Repository
public class CrComEdaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEdaDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEda pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEda pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEda pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEda findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEda)this.getHibernateTemplate().get(CrComEda.class, id);
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

    public List<CrComEda> findByProperties(CrComEda pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEda as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEd01ai01())){
                queryString.append(" and model.ed01ai01 = ? ");
                binds.add(pojo.getEd01ai01());
            }
            if(isNotBlankOrNull(pojo.getEd01ad01())){
                queryString.append(" and model.ed01ad01 = ? ");
                binds.add(pojo.getEd01ad01());
            }
            if(isNotBlankOrNull(pojo.getEd01ad02())){
                queryString.append(" and model.ed01ad02 = ? ");
                binds.add(pojo.getEd01ad02());
            }
            if(isNotBlankOrNull(pojo.getEd01ad03())){
                queryString.append(" and model.ed01ad03 = ? ");
                binds.add(pojo.getEd01ad03());
            }
            if(isNotBlankOrNull(pojo.getEd01ad04())){
                queryString.append(" and model.ed01ad04 = ? ");
                binds.add(pojo.getEd01ad04());
            }
            if(isNotBlankOrNull(pojo.getEd01ai02())){
                queryString.append(" and model.ed01ai02 = ? ");
                binds.add(pojo.getEd01ai02());
            }
            if(isNotBlankOrNull(pojo.getEd01ai03())){
                queryString.append(" and model.ed01ai03 = ? ");
                binds.add(pojo.getEd01ai03());
            }
            if(isNotBlankOrNull(pojo.getEd01ad05())){
                queryString.append(" and model.ed01ad05 = ? ");
                binds.add(pojo.getEd01ad05());
            }
            if(isNotBlankOrNull(pojo.getEd01ad06())){
                queryString.append(" and model.ed01ad06 = ? ");
                binds.add(pojo.getEd01ad06());
            }
            if(isNotBlankOrNull(pojo.getEd01ar01())){
                queryString.append(" and model.ed01ar01 = ? ");
                binds.add(pojo.getEd01ar01());
            }
            if(isNotBlankOrNull(pojo.getEd01ad07())){
                queryString.append(" and model.ed01ad07 = ? ");
                binds.add(pojo.getEd01ad07());
            }
            if(isNotBlankOrNull(pojo.getEd01aj01())){
                queryString.append(" and model.ed01aj01 = ? ");
                binds.add(pojo.getEd01aj01());
            }
            if(isNotBlankOrNull(pojo.getEd01aj02())){
                queryString.append(" and model.ed01aj02 = ? ");
                binds.add(pojo.getEd01aj02());
            }
            if(isNotBlankOrNull(pojo.getEd01ar02())){
                queryString.append(" and model.ed01ar02 = ? ");
                binds.add(pojo.getEd01ar02());
            }
            if(isNotBlankOrNull(pojo.getEd01ad08())){
                queryString.append(" and model.ed01ad08 = ? ");
                binds.add(pojo.getEd01ad08());
            }
            if(isNotBlankOrNull(pojo.getEd01ad09())){
                queryString.append(" and model.ed01ad09 = ? ");
                binds.add(pojo.getEd01ad09());
            }
            if(isNotBlankOrNull(pojo.getEd01ad10())){
                queryString.append(" and model.ed01ad10 = ? ");
                binds.add(pojo.getEd01ad10());
            }
            if(isNotBlankOrNull(pojo.getEd01ad11())){
                queryString.append(" and model.ed01ad11 = ? ");
                binds.add(pojo.getEd01ad11());
            }
            if(isNotBlankOrNull(pojo.getEd01ar03())){
                queryString.append(" and model.ed01ar03 = ? ");
                binds.add(pojo.getEd01ar03());
            }
            if(isNotBlankOrNull(pojo.getEd01ar04())){
                queryString.append(" and model.ed01ar04 = ? ");
                binds.add(pojo.getEd01ar04());
            }
            if(isNotBlankOrNull(pojo.getEd01bs01())){
                queryString.append(" and model.ed01bs01 = ? ");
                binds.add(pojo.getEd01bs01());
            }
            if(isNotBlankOrNull(pojo.getEd01cs01())){
                queryString.append(" and model.ed01cs01 = ? ");
                binds.add(pojo.getEd01cs01());
            }
            if(isNotBlankOrNull(pojo.getEd020i01())){
                queryString.append(" and model.ed020i01 = ? ");
                binds.add(pojo.getEd020i01());
            }
            if(isNotBlankOrNull(pojo.getEd020d01())){
                queryString.append(" and model.ed020d01 = ? ");
                binds.add(pojo.getEd020d01());
            }
            if(isNotBlankOrNull(pojo.getEd020i02())){
                queryString.append(" and model.ed020i02 = ? ");
                binds.add(pojo.getEd020i02());
            }
            if(isNotBlankOrNull(pojo.getEd020d02())){
                queryString.append(" and model.ed020d02 = ? ");
                binds.add(pojo.getEd020d02());
            }
            if(isNotBlankOrNull(pojo.getEd020d03())){
                queryString.append(" and model.ed020d03 = ? ");
                binds.add(pojo.getEd020d03());
            }
            if(isNotBlankOrNull(pojo.getEd020s01())){
                queryString.append(" and model.ed020s01 = ? ");
                binds.add(pojo.getEd020s01());
            }
            if(isNotBlankOrNull(pojo.getEd020j01())){
                queryString.append(" and model.ed020j01 = ? ");
                binds.add(pojo.getEd020j01());
            }
            if(isNotBlankOrNull(pojo.getEd020j02())){
                queryString.append(" and model.ed020j02 = ? ");
                binds.add(pojo.getEd020j02());
            }
            if(isNotBlankOrNull(pojo.getEd020j03())){
                queryString.append(" and model.ed020j03 = ? ");
                binds.add(pojo.getEd020j03());
            }
            if(isNotBlankOrNull(pojo.getEd020s02())){
                queryString.append(" and model.ed020s02 = ? ");
                binds.add(pojo.getEd020s02());
            }
            if(isNotBlankOrNull(pojo.getEd020j04())){
                queryString.append(" and model.ed020j04 = ? ");
                binds.add(pojo.getEd020j04());
            }
            if(isNotBlankOrNull(pojo.getEd030i01())){
                queryString.append(" and model.ed030i01 = ? ");
                binds.add(pojo.getEd030i01());
            }
            if(isNotBlankOrNull(pojo.getEd030d01())){
                queryString.append(" and model.ed030d01 = ? ");
                binds.add(pojo.getEd030d01());
            }
            if(isNotBlankOrNull(pojo.getEd030i02())){
                queryString.append(" and model.ed030i02 = ? ");
                binds.add(pojo.getEd030i02());
            }
            if(isNotBlankOrNull(pojo.getEd030d02())){
                queryString.append(" and model.ed030d02 = ? ");
                binds.add(pojo.getEd030d02());
            }
            if(isNotBlankOrNull(pojo.getEd030j01())){
                queryString.append(" and model.ed030j01 = ? ");
                binds.add(pojo.getEd030j01());
            }
            if(isNotBlankOrNull(pojo.getEd030r01())){
                queryString.append(" and model.ed030r01 = ? ");
                binds.add(pojo.getEd030r01());
            }
            if(isNotBlankOrNull(pojo.getEd030d03())){
                queryString.append(" and model.ed030d03 = ? ");
                binds.add(pojo.getEd030d03());
            }
            if(isNotBlankOrNull(pojo.getEd030r02())){
                queryString.append(" and model.ed030r02 = ? ");
                binds.add(pojo.getEd030r02());
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
            return (List<CrComEda>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEda> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEda as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEda>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


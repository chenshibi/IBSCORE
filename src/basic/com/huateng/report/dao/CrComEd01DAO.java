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

import resource.bean.crms.CrComEd01;
import resource.bean.crms.CrComEd01ch;
@Repository
public class CrComEd01DAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEd01DAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEd01 pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEd01 pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEd01 pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEd01 findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEd01)this.getHibernateTemplate().get(CrComEd01.class, id);
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

    public List<CrComEd01> findByProperties(CrComEd01 pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEd01 as model where 0= 0 ");
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
            return (List<CrComEd01>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEd01> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEd01 as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEd01>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }


}


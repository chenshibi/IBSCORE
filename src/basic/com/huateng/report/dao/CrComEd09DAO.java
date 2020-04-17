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

import resource.bean.crms.CrComEd09;
@Repository
public class CrComEd09DAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEd09DAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEd09 pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEd09 pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEd09 pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEd09 findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEd09)this.getHibernateTemplate().get(CrComEd09.class, id);
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

    public List<CrComEd09> findByProperties(CrComEd09 pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEd09 as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
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
            if(isNotBlankOrNull(pojo.getEd090j03())){
                queryString.append(" and model.ed090j03 = ? ");
                binds.add(pojo.getEd090j03());
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
            if(isNotBlankOrNull(pojo.getBatchId())){
                queryString.append(" and model.batchId = ? ");
                binds.add(pojo.getBatchId());
            }
            return (List<CrComEd09>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEd09> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEd09 as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEd09>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


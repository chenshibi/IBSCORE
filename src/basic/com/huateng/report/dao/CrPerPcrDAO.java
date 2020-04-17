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

import resource.bean.crms.CrPerPca;
import resource.bean.crms.CrPerPcr;
@Repository
public class CrPerPcrDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPcrDAO.class);
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrPerPcr pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPcr pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPcr pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPcr findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPcr)this.getHibernateTemplate().get(CrPerPcr.class, id);
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

    public List<CrPerPcr> findByProperties(CrPerPcr pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPcr as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPd03ad08())){
                queryString.append(" and model.pd03ad08 = ? ");
                binds.add(pojo.getPd03ad08());
            }
            if(isNotBlankOrNull(pojo.getPd03ad01())){
                queryString.append(" and model.pd03ad01 = ? ");
                binds.add(pojo.getPd03ad01());
            }
            if(isNotBlankOrNull(pojo.getPd03aq01())){
                queryString.append(" and model.pd03aq01 = ? ");
                binds.add(pojo.getPd03aq01());
            }
            if(isNotBlankOrNull(pojo.getPd03ad02())){
                queryString.append(" and model.pd03ad02 = ? ");
                binds.add(pojo.getPd03ad02());
            }
            if(isNotBlankOrNull(pojo.getPd03ar01())){
                queryString.append(" and model.pd03ar01 = ? ");
                binds.add(pojo.getPd03ar01());
            }
            if(isNotBlankOrNull(pojo.getPd03ar02())){
                queryString.append(" and model.pd03ar02 = ? ");
                binds.add(pojo.getPd03ar02());
            }
            if(isNotBlankOrNull(pojo.getPd03ad03())){
                queryString.append(" and model.pd03ad03 = ? ");
                binds.add(pojo.getPd03ad03());
            }
            if(isNotBlankOrNull(pojo.getPd03aq02())){
                queryString.append(" and model.pd03aq02 = ? ");
                binds.add(pojo.getPd03aq02());
            }
            if(isNotBlankOrNull(pojo.getPd03aj01())){
                queryString.append(" and model.pd03aj01 = ? ");
                binds.add(pojo.getPd03aj01());
            }
            if(isNotBlankOrNull(pojo.getPd03ad04())){
                queryString.append(" and model.pd03ad04 = ? ");
                binds.add(pojo.getPd03ad04());
            }
            if(isNotBlankOrNull(pojo.getPd03aj02())){
                queryString.append(" and model.pd03aj02 = ? ");
                binds.add(pojo.getPd03aj02());
            }
            if(isNotBlankOrNull(pojo.getPd03ad05())){
                queryString.append(" and model.pd03ad05 = ? ");
                binds.add(pojo.getPd03ad05());
            }
            if(isNotBlankOrNull(pojo.getPd03ad06())){
                queryString.append(" and model.pd03ad06 = ? ");
                binds.add(pojo.getPd03ad06());
            }
            if(isNotBlankOrNull(pojo.getPd03ad07())){
                queryString.append(" and model.pd03ad07 = ? ");
                binds.add(pojo.getPd03ad07());
            }
            if(isNotBlankOrNull(pojo.getPd03as01())){
                queryString.append(" and model.pd03as01 = ? ");
                binds.add(pojo.getPd03as01());
            }
            if(isNotBlankOrNull(pojo.getPd03ar03())){
                queryString.append(" and model.pd03ar03 = ? ");
                binds.add(pojo.getPd03ar03());
            }
            if(isNotBlankOrNull(pojo.getPd03zs01())){
                queryString.append(" and model.pd03zs01 = ? ");
                binds.add(pojo.getPd03zs01());
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
            return (List<CrPerPcr>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPcr> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPcr as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrPerPcr>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


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

import resource.bean.crms.CrPerPqo;
@Repository
public class CrPerPqoDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPqoDAO.class);
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrPerPqo pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPqo pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPqo pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPqo findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPqo)this.getHibernateTemplate().get(CrPerPqo.class, id);
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

    public List<CrPerPqo> findByProperties(CrPerPqo pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPqo as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPc05ar01())){
                queryString.append(" and model.pc05ar01 = ? ");
                binds.add(pojo.getPc05ar01());
            }
            if(isNotBlankOrNull(pojo.getPc05ad01())){
                queryString.append(" and model.pc05ad01 = ? ");
                binds.add(pojo.getPc05ad01());
            }
            if(isNotBlankOrNull(pojo.getPc05ai01())){
                queryString.append(" and model.pc05ai01 = ? ");
                binds.add(pojo.getPc05ai01());
            }
            if(isNotBlankOrNull(pojo.getPc05aq01())){
                queryString.append(" and model.pc05aq01 = ? ");
                binds.add(pojo.getPc05aq01());
            }
            if(isNotBlankOrNull(pojo.getPc05bs01())){
                queryString.append(" and model.pc05bs01 = ? ");
                binds.add(pojo.getPc05bs01());
            }
            if(isNotBlankOrNull(pojo.getPc05bs02())){
                queryString.append(" and model.pc05bs02 = ? ");
                binds.add(pojo.getPc05bs02());
            }
            if(isNotBlankOrNull(pojo.getPc05bs03())){
                queryString.append(" and model.pc05bs03 = ? ");
                binds.add(pojo.getPc05bs03());
            }
            if(isNotBlankOrNull(pojo.getPc05bs04())){
                queryString.append(" and model.pc05bs04 = ? ");
                binds.add(pojo.getPc05bs04());
            }
            if(isNotBlankOrNull(pojo.getPc05bs05())){
                queryString.append(" and model.pc05bs05 = ? ");
                binds.add(pojo.getPc05bs05());
            }
            if(isNotBlankOrNull(pojo.getPc05bs06())){
                queryString.append(" and model.pc05bs06 = ? ");
                binds.add(pojo.getPc05bs06());
            }
            if(isNotBlankOrNull(pojo.getPc05bs07())){
                queryString.append(" and model.pc05bs07 = ? ");
                binds.add(pojo.getPc05bs07());
            }
            if(isNotBlankOrNull(pojo.getPc05bs08())){
                queryString.append(" and model.pc05bs08 = ? ");
                binds.add(pojo.getPc05bs08());
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
            return (List<CrPerPqo>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPqo> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPqo as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		//	queryString.append(" and model.id = ? ");
    		}
        	return  (List<CrPerPqo>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


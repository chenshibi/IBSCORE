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

import resource.bean.crms.CrPerPcj;
@Repository
public class CrPerPcjDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPcjDAO.class);
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrPerPcj pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPcj pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPcj pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPcj findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPcj)this.getHibernateTemplate().get(CrPerPcj.class, id);
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

    public List<CrPerPcj> findByProperties(CrPerPcj pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPcj as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPf02aq01())){
                queryString.append(" and model.pf02aq01 = ? ");
                binds.add(pojo.getPf02aq01());
            }
            if(isNotBlankOrNull(pojo.getPf02aq02())){
                queryString.append(" and model.pf02aq02 = ? ");
                binds.add(pojo.getPf02aq02());
            }
            if(isNotBlankOrNull(pojo.getPf02ar01())){
                queryString.append(" and model.pf02ar01 = ? ");
                binds.add(pojo.getPf02ar01());
            }
            if(isNotBlankOrNull(pojo.getPf02ad01())){
                queryString.append(" and model.pf02ad01 = ? ");
                binds.add(pojo.getPf02ad01());
            }
            if(isNotBlankOrNull(pojo.getPf02aq03())){
                queryString.append(" and model.pf02aq03 = ? ");
                binds.add(pojo.getPf02aq03());
            }
            if(isNotBlankOrNull(pojo.getPf02ar02())){
                queryString.append(" and model.pf02ar02 = ? ");
                binds.add(pojo.getPf02ar02());
            }
            if(isNotBlankOrNull(pojo.getPf02aq04())){
                queryString.append(" and model.pf02aq04 = ? ");
                binds.add(pojo.getPf02aq04());
            }
            if(isNotBlankOrNull(pojo.getPf02aj01())){
                queryString.append(" and model.pf02aj01 = ? ");
                binds.add(pojo.getPf02aj01());
            }
            if(isNotBlankOrNull(pojo.getPf02zs01())){
                queryString.append(" and model.pf02zs01 = ? ");
                binds.add(pojo.getPf02zs01());
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
            return (List<CrPerPcj>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPcj> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPcj as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrPerPcj>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


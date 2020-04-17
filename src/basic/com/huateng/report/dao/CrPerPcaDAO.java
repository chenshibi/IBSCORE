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

import resource.bean.crms.CrPerPca;

@Repository
public class CrPerPcaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPerPcaDAO.class);
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrPerPca pojo) {
        log.info("update spojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPerPca pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPerPca pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPerPca findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPerPca)this.getHibernateTemplate().get(CrPerPca.class, id);
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

    public List<CrPerPca> findByProperties(CrPerPca pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPerPca as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getPd02ai01())){
                queryString.append(" and model.pd02ai01 = ? ");
                binds.add(pojo.getPd02ai01());
            }
            if(isNotBlankOrNull(pojo.getPd02ad01())){
                queryString.append(" and model.pd02ad01 = ? ");
                binds.add(pojo.getPd02ad01());
            }
            if(isNotBlankOrNull(pojo.getPd02ai02())){
                queryString.append(" and model.pd02ai02 = ? ");
                binds.add(pojo.getPd02ai02());
            }
            if(isNotBlankOrNull(pojo.getPd02ai03())){
                queryString.append(" and model.pd02ai03 = ? ");
                binds.add(pojo.getPd02ai03());
            }
            if(isNotBlankOrNull(pojo.getPd02ad02())){
                queryString.append(" and model.pd02ad02 = ? ");
                binds.add(pojo.getPd02ad02());
            }
            if(isNotBlankOrNull(pojo.getPd02aj01())){
                queryString.append(" and model.pd02aj01 = ? ");
                binds.add(pojo.getPd02aj01());
            }
            if(isNotBlankOrNull(pojo.getPd02ad03())){
                queryString.append(" and model.pd02ad03 = ? ");
                binds.add(pojo.getPd02ad03());
            }
            if(isNotBlankOrNull(pojo.getPd02ar01())){
                queryString.append(" and model.pd02ar01 = ? ");
                binds.add(pojo.getPd02ar01());
            }
            if(isNotBlankOrNull(pojo.getPd02ar02())){
                queryString.append(" and model.pd02ar02 = ? ");
                binds.add(pojo.getPd02ar02());
            }
            if(isNotBlankOrNull(pojo.getPd02ad04())){
                queryString.append(" and model.pd02ad04 = ? ");
                binds.add(pojo.getPd02ad04());
            }
            if(isNotBlankOrNull(pojo.getPd02aj04())){
                queryString.append(" and model.pd02aj04 = ? ");
                binds.add(pojo.getPd02aj04());
            }
            if(isNotBlankOrNull(pojo.getPd02aj03())){
                queryString.append(" and model.pd02aj03 = ? ");
                binds.add(pojo.getPd02aj03());
            }
            if(isNotBlankOrNull(pojo.getPd02ai04())){
                queryString.append(" and model.pd02ai04 = ? ");
                binds.add(pojo.getPd02ai04());
            }
            if(isNotBlankOrNull(pojo.getPd02zs01())){
                queryString.append(" and model.pd02zs01 = ? ");
                binds.add(pojo.getPd02zs01());
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
            return (List<CrPerPca>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrPerPca> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrPerPca as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrPerPca>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


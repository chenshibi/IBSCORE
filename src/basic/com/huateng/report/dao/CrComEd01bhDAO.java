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

import resource.bean.crms.CrComEd01b;
import resource.bean.crms.CrComEd01bh;

@Repository
public class CrComEd01bhDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEd01bhDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEd01bh pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEd01bh pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEd01bh pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEd01bh findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEd01bh)this.getHibernateTemplate().get(CrComEd01bh.class, id);
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

    public List<CrComEd01bh> findByProperties(CrComEd01bh pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEd01bh as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getBatchId())){
                queryString.append(" and model.batchId = ? ");
                binds.add(pojo.getBatchId());
            }
            if(isNotBlankOrNull(pojo.getEd01br01())){
                queryString.append(" and model.ed01br01 = ? ");
                binds.add(pojo.getEd01br01());
            }
            if(isNotBlankOrNull(pojo.getEd01bj01())){
                queryString.append(" and model.ed01bj01 = ? ");
                binds.add(pojo.getEd01bj01());
            }
            if(isNotBlankOrNull(pojo.getEd01br02())){
                queryString.append(" and model.ed01br02 = ? ");
                binds.add(pojo.getEd01br02());
            }
            if(isNotBlankOrNull(pojo.getEd01bd01())){
                queryString.append(" and model.ed01bd01 = ? ");
                binds.add(pojo.getEd01bd01());
            }
            if(isNotBlankOrNull(pojo.getEd01br03())){
                queryString.append(" and model.ed01br03 = ? ");
                binds.add(pojo.getEd01br03());
            }
            if(isNotBlankOrNull(pojo.getEd01br04())){
                queryString.append(" and model.ed01br04 = ? ");
                binds.add(pojo.getEd01br04());
            }
            if(isNotBlankOrNull(pojo.getEd01bj02())){
                queryString.append(" and model.ed01bj02 = ? ");
                binds.add(pojo.getEd01bj02());
            }
            if(isNotBlankOrNull(pojo.getEd01bd02())){
                queryString.append(" and model.ed01bd02 = ? ");
                binds.add(pojo.getEd01bd02());
            }
            if(isNotBlankOrNull(pojo.getEd01br05())){
                queryString.append(" and model.ed01br05 = ? ");
                binds.add(pojo.getEd01br05());
            }
            if(isNotBlankOrNull(pojo.getEd01bj03())){
                queryString.append(" and model.ed01bj03 = ? ");
                binds.add(pojo.getEd01bj03());
            }
            if(isNotBlankOrNull(pojo.getEd01bj04())){
                queryString.append(" and model.ed01bj04 = ? ");
                binds.add(pojo.getEd01bj04());
            }
            if(isNotBlankOrNull(pojo.getEd01bj05())){
                queryString.append(" and model.ed01bj05 = ? ");
                binds.add(pojo.getEd01bj05());
            }
            if(isNotBlankOrNull(pojo.getEd01bs02())){
                queryString.append(" and model.ed01bs02 = ? ");
                binds.add(pojo.getEd01bs02());
            }
            if(isNotBlankOrNull(pojo.getEd01bs03())){
                queryString.append(" and model.ed01bs03 = ? ");
                binds.add(pojo.getEd01bs03());
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
            if(isNotBlankOrNull(pojo.getParentid())){
                queryString.append(" and model.parentid = ? ");
                binds.add(pojo.getParentid());
            }
            return (List<CrComEd01bh>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEd01bh> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEd01bh as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.batchId in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEd01bh>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


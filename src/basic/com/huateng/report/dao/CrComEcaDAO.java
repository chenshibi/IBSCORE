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

import resource.bean.crms.CrComEca;
@Repository
public class CrComEcaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEcaDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEca pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEca pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEca pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEca findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEca)this.getHibernateTemplate().get(CrComEca.class, id);
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

    public List<CrComEca> findByProperties(CrComEca pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEca as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEc010d01())){
                queryString.append(" and model.ec010d01 = ? ");
                binds.add(pojo.getEc010d01());
            }
            if(isNotBlankOrNull(pojo.getEc010d02())){
                queryString.append(" and model.ec010d02 = ? ");
                binds.add(pojo.getEc010d02());
            }
            if(isNotBlankOrNull(pojo.getEc010d03())){
                queryString.append(" and model.ec010d03 = ? ");
                binds.add(pojo.getEc010d03());
            }
            if(isNotBlankOrNull(pojo.getEc010d04())){
                queryString.append(" and model.ec010d04 = ? ");
                binds.add(pojo.getEc010d04());
            }
            if(isNotBlankOrNull(pojo.getEc010q01())){
                queryString.append(" and model.ec010q01 = ? ");
                binds.add(pojo.getEc010q01());
            }
            if(isNotBlankOrNull(pojo.getEc010r01())){
                queryString.append(" and model.ec010r01 = ? ");
                binds.add(pojo.getEc010r01());
            }
            if(isNotBlankOrNull(pojo.getEc010r02())){
                queryString.append(" and model.ec010r02 = ? ");
                binds.add(pojo.getEc010r02());
            }
            if(isNotBlankOrNull(pojo.getEc010q02())){
                queryString.append(" and model.ec010q02 = ? ");
                binds.add(pojo.getEc010q02());
            }
            if(isNotBlankOrNull(pojo.getEc010d05())){
                queryString.append(" and model.ec010d05 = ? ");
                binds.add(pojo.getEc010d05());
            }
            if(isNotBlankOrNull(pojo.getEc020j01())){
                queryString.append(" and model.ec020j01 = ? ");
                binds.add(pojo.getEc020j01());
            }
            if(isNotBlankOrNull(pojo.getEc020s01())){
                queryString.append(" and model.ec020s01 = ? ");
                binds.add(pojo.getEc020s01());
            }
            if(isNotBlankOrNull(pojo.getEc020r01())){
                queryString.append(" and model.ec020r01 = ? ");
                binds.add(pojo.getEc020r01());
            }
            if(isNotBlankOrNull(pojo.getEc030s01())){
                queryString.append(" and model.ec030s01 = ? ");
                binds.add(pojo.getEc030s01());
            }
            if(isNotBlankOrNull(pojo.getEc030r01())){
                queryString.append(" and model.ec030r01 = ? ");
                binds.add(pojo.getEc030r01());
            }
            if(isNotBlankOrNull(pojo.getEc040d01())){
                queryString.append(" and model.ec040d01 = ? ");
                binds.add(pojo.getEc040d01());
            }
            if(isNotBlankOrNull(pojo.getEc040q01())){
                queryString.append(" and model.ec040q01 = ? ");
                binds.add(pojo.getEc040q01());
            }
            if(isNotBlankOrNull(pojo.getEc040d02())){
                queryString.append(" and model.ec040d02 = ? ");
                binds.add(pojo.getEc040d02());
            }
            if(isNotBlankOrNull(pojo.getEc040i01())){
                queryString.append(" and model.ec040i01 = ? ");
                binds.add(pojo.getEc040i01());
            }
            if(isNotBlankOrNull(pojo.getEc040r01())){
                queryString.append(" and model.ec040r01 = ? ");
                binds.add(pojo.getEc040r01());
            }
            if(isNotBlankOrNull(pojo.getEc050s01())){
                queryString.append(" and model.ec050s01 = ? ");
                binds.add(pojo.getEc050s01());
            }
            if(isNotBlankOrNull(pojo.getEc050r01())){
                queryString.append(" and model.ec050r01 = ? ");
                binds.add(pojo.getEc050r01());
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
            return (List<CrComEca>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    
    public List<CrComEca> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEca as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEca>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


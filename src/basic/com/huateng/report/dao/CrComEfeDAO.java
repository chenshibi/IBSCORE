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

import resource.bean.crms.CrComEfd;
import resource.bean.crms.CrComEfe;
@Repository
public class CrComEfeDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEfeDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEfe pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEfe pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEfe pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEfe findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEfe)this.getHibernateTemplate().get(CrComEfe.class, id);
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

    public List<CrComEfe> findByProperties(CrComEfe pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEfe as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEf060i01())){
                queryString.append(" and model.ef060i01 = ? ");
                binds.add(pojo.getEf060i01());
            }
            if(isNotBlankOrNull(pojo.getEf060q01())){
                queryString.append(" and model.ef060q01 = ? ");
                binds.add(pojo.getEf060q01());
            }
            if(isNotBlankOrNull(pojo.getEf060q02())){
                queryString.append(" and model.ef060q02 = ? ");
                binds.add(pojo.getEf060q02());
            }
            if(isNotBlankOrNull(pojo.getEf060r01())){
                queryString.append(" and model.ef060r01 = ? ");
                binds.add(pojo.getEf060r01());
            }
            if(isNotBlankOrNull(pojo.getEf060r02())){
                queryString.append(" and model.ef060r02 = ? ");
                binds.add(pojo.getEf060r02());
            }
            if(isNotBlankOrNull(pojo.getEf060q03())){
                queryString.append(" and model.ef060q03 = ? ");
                binds.add(pojo.getEf060q03());
            }
            if(isNotBlankOrNull(pojo.getEf070i01())){
                queryString.append(" and model.ef070i01 = ? ");
                binds.add(pojo.getEf070i01());
            }
            if(isNotBlankOrNull(pojo.getEf070q01())){
                queryString.append(" and model.ef070q01 = ? ");
                binds.add(pojo.getEf070q01());
            }
            if(isNotBlankOrNull(pojo.getEf070q02())){
                queryString.append(" and model.ef070q02 = ? ");
                binds.add(pojo.getEf070q02());
            }
            if(isNotBlankOrNull(pojo.getEf070r01())){
                queryString.append(" and model.ef070r01 = ? ");
                binds.add(pojo.getEf070r01());
            }
            if(isNotBlankOrNull(pojo.getEf070r02())){
                queryString.append(" and model.ef070r02 = ? ");
                binds.add(pojo.getEf070r02());
            }
            if(isNotBlankOrNull(pojo.getEf070q03())){
                queryString.append(" and model.ef070q03 = ? ");
                binds.add(pojo.getEf070q03());
            }
            if(isNotBlankOrNull(pojo.getEf080i01())){
                queryString.append(" and model.ef080i01 = ? ");
                binds.add(pojo.getEf080i01());
            }
            if(isNotBlankOrNull(pojo.getEf080q01())){
                queryString.append(" and model.ef080q01 = ? ");
                binds.add(pojo.getEf080q01());
            }
            if(isNotBlankOrNull(pojo.getEf080q02())){
                queryString.append(" and model.ef080q02 = ? ");
                binds.add(pojo.getEf080q02());
            }
            if(isNotBlankOrNull(pojo.getEf080r01())){
                queryString.append(" and model.ef080r01 = ? ");
                binds.add(pojo.getEf080r01());
            }
            if(isNotBlankOrNull(pojo.getEf080r02())){
                queryString.append(" and model.ef080r02 = ? ");
                binds.add(pojo.getEf080r02());
            }
            if(isNotBlankOrNull(pojo.getEf080q03())){
                queryString.append(" and model.ef080q03 = ? ");
                binds.add(pojo.getEf080q03());
            }
            if(isNotBlankOrNull(pojo.getEf090i01())){
                queryString.append(" and model.ef090i01 = ? ");
                binds.add(pojo.getEf090i01());
            }
            if(isNotBlankOrNull(pojo.getEf090q01())){
                queryString.append(" and model.ef090q01 = ? ");
                binds.add(pojo.getEf090q01());
            }
            if(isNotBlankOrNull(pojo.getEf090q02())){
                queryString.append(" and model.ef090q02 = ? ");
                binds.add(pojo.getEf090q02());
            }
            if(isNotBlankOrNull(pojo.getEf090r01())){
                queryString.append(" and model.ef090r01 = ? ");
                binds.add(pojo.getEf090r01());
            }
            if(isNotBlankOrNull(pojo.getEf090r02())){
                queryString.append(" and model.ef090r02 = ? ");
                binds.add(pojo.getEf090r02());
            }
            if(isNotBlankOrNull(pojo.getEf090q03())){
                queryString.append(" and model.ef090q03 = ? ");
                binds.add(pojo.getEf090q03());
            }
            if(isNotBlankOrNull(pojo.getEf100i01())){
                queryString.append(" and model.ef100i01 = ? ");
                binds.add(pojo.getEf100i01());
            }
            if(isNotBlankOrNull(pojo.getEf100q01())){
                queryString.append(" and model.ef100q01 = ? ");
                binds.add(pojo.getEf100q01());
            }
            if(isNotBlankOrNull(pojo.getEf100i02())){
                queryString.append(" and model.ef100i02 = ? ");
                binds.add(pojo.getEf100i02());
            }
            if(isNotBlankOrNull(pojo.getEf100r01())){
                queryString.append(" and model.ef100r01 = ? ");
                binds.add(pojo.getEf100r01());
            }
            if(isNotBlankOrNull(pojo.getEf100r02())){
                queryString.append(" and model.ef100r02 = ? ");
                binds.add(pojo.getEf100r02());
            }
            if(isNotBlankOrNull(pojo.getEf100s01())){
                queryString.append(" and model.ef100s01 = ? ");
                binds.add(pojo.getEf100s01());
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
            return (List<CrComEfe>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEfe> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEfe as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEfe>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }


}


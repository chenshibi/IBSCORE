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

import resource.bean.crms.CrComEfc;
import resource.bean.crms.CrComEfd;
@Repository
public class CrComEfdDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEfdDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEfd pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEfd pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEfd pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEfd findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEfd)this.getHibernateTemplate().get(CrComEfd.class, id);
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

    public List<CrComEfd> findByProperties(CrComEfd pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEfd as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEf05ai01())){
                queryString.append(" and model.ef05ai01 = ? ");
                binds.add(pojo.getEf05ai01());
            }
            if(isNotBlankOrNull(pojo.getEf05ar01())){
                queryString.append(" and model.ef05ar01 = ? ");
                binds.add(pojo.getEf05ar01());
            }
            if(isNotBlankOrNull(pojo.getEf05as01())){
                queryString.append(" and model.ef05as01 = ? ");
                binds.add(pojo.getEf05as01());
            }
            if(isNotBlankOrNull(pojo.getEf05aj01())){
                queryString.append(" and model.ef05aj01 = ? ");
                binds.add(pojo.getEf05aj01());
            }
            if(isNotBlankOrNull(pojo.getEf05ar02())){
                queryString.append(" and model.ef05ar02 = ? ");
                binds.add(pojo.getEf05ar02());
            }
            if(isNotBlankOrNull(pojo.getEf05ar03())){
                queryString.append(" and model.ef05ar03 = ? ");
                binds.add(pojo.getEf05ar03());
            }
            if(isNotBlankOrNull(pojo.getEf05ad01())){
                queryString.append(" and model.ef05ad01 = ? ");
                binds.add(pojo.getEf05ad01());
            }
            if(isNotBlankOrNull(pojo.getEf05aj02())){
                queryString.append(" and model.ef05aj02 = ? ");
                binds.add(pojo.getEf05aj02());
            }
            if(isNotBlankOrNull(pojo.getEf05ar04())){
                queryString.append(" and model.ef05ar04 = ? ");
                binds.add(pojo.getEf05ar04());
            }
            if(isNotBlankOrNull(pojo.getEf05bs01())){
                queryString.append(" and model.ef05bs01 = ? ");
                binds.add(pojo.getEf05bs01());
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
            return (List<CrComEfd>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEfd> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEfd as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEfd>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


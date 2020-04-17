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

import resource.bean.crms.CrComEfe;
import resource.bean.crms.CrComEff;

@Repository
public class CrComEffDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEffDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEff pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEff pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEff pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEff findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEff)this.getHibernateTemplate().get(CrComEff.class, id);
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

    public List<CrComEff> findByProperties(CrComEff pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEff as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEf110i01())){
                queryString.append(" and model.ef110i01 = ? ");
                binds.add(pojo.getEf110i01());
            }
            if(isNotBlankOrNull(pojo.getEf110q01())){
                queryString.append(" and model.ef110q01 = ? ");
                binds.add(pojo.getEf110q01());
            }
            if(isNotBlankOrNull(pojo.getEf110q02())){
                queryString.append(" and model.ef110q02 = ? ");
                binds.add(pojo.getEf110q02());
            }
            if(isNotBlankOrNull(pojo.getEf110r01())){
                queryString.append(" and model.ef110r01 = ? ");
                binds.add(pojo.getEf110r01());
            }
            if(isNotBlankOrNull(pojo.getEf120i01())){
                queryString.append(" and model.ef120i01 = ? ");
                binds.add(pojo.getEf120i01());
            }
            if(isNotBlankOrNull(pojo.getEf120q01())){
                queryString.append(" and model.ef120q01 = ? ");
                binds.add(pojo.getEf120q01());
            }
            if(isNotBlankOrNull(pojo.getEf120q02())){
                queryString.append(" and model.ef120q02 = ? ");
                binds.add(pojo.getEf120q02());
            }
            if(isNotBlankOrNull(pojo.getEf120i02())){
                queryString.append(" and model.ef120i02 = ? ");
                binds.add(pojo.getEf120i02());
            }
            if(isNotBlankOrNull(pojo.getEf120r02())){
                queryString.append(" and model.ef120r02 = ? ");
                binds.add(pojo.getEf120r02());
            }
            if(isNotBlankOrNull(pojo.getEf130i01())){
                queryString.append(" and model.ef130i01 = ? ");
                binds.add(pojo.getEf130i01());
            }
            if(isNotBlankOrNull(pojo.getEf130q01())){
                queryString.append(" and model.ef130q01 = ? ");
                binds.add(pojo.getEf130q01());
            }
            if(isNotBlankOrNull(pojo.getEf130q02())){
                queryString.append(" and model.ef130q02 = ? ");
                binds.add(pojo.getEf130q02());
            }
            if(isNotBlankOrNull(pojo.getEf130d01())){
                queryString.append(" and model.ef130d01 = ? ");
                binds.add(pojo.getEf130d01());
            }
            if(isNotBlankOrNull(pojo.getEf130r01())){
                queryString.append(" and model.ef130r01 = ? ");
                binds.add(pojo.getEf130r01());
            }
            if(isNotBlankOrNull(pojo.getEf130r02())){
                queryString.append(" and model.ef130r02 = ? ");
                binds.add(pojo.getEf130r02());
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
            return (List<CrComEff>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEff> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEff as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEff>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


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

import resource.bean.crms.CrComEba;
import resource.bean.crms.CrComEbb;
@Repository
public class CrComEbbDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEbbDAO.class);

    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    public void update(CrComEbb pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEbb pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEbb pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEbb findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEbb)this.getHibernateTemplate().get(CrComEbb.class, id);
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

    public List<CrComEbb> findByProperties(CrComEbb pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEbb as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEb02as01())){
                queryString.append(" and model.eb02as01 = ? ");
                binds.add(pojo.getEb02as01());
            }
            if(isNotBlankOrNull(pojo.getEb02aj01())){
                queryString.append(" and model.eb02aj01 = ? ");
                binds.add(pojo.getEb02aj01());
            }
            if(isNotBlankOrNull(pojo.getEb02ar01())){
                queryString.append(" and model.eb02ar01 = ? ");
                binds.add(pojo.getEb02ar01());
            }
            if(isNotBlankOrNull(pojo.getEb02as02())){
                queryString.append(" and model.eb02as02 = ? ");
                binds.add(pojo.getEb02as02());
            }
            if(isNotBlankOrNull(pojo.getEb02aj02())){
                queryString.append(" and model.eb02aj02 = ? ");
                binds.add(pojo.getEb02aj02());
            }
            if(isNotBlankOrNull(pojo.getEb02ar02())){
                queryString.append(" and model.eb02ar02 = ? ");
                binds.add(pojo.getEb02ar02());
            }
            if(isNotBlankOrNull(pojo.getEb02aj03())){
                queryString.append(" and model.eb02aj03 = ? ");
                binds.add(pojo.getEb02aj03());
            }
            if(isNotBlankOrNull(pojo.getEb02aj04())){
                queryString.append(" and model.eb02aj04 = ? ");
                binds.add(pojo.getEb02aj04());
            }
            if(isNotBlankOrNull(pojo.getEb02aj05())){
                queryString.append(" and model.eb02aj05 = ? ");
                binds.add(pojo.getEb02aj05());
            }
            if(isNotBlankOrNull(pojo.getEb02as03())){
                queryString.append(" and model.eb02as03 = ? ");
                binds.add(pojo.getEb02as03());
            }
            if(isNotBlankOrNull(pojo.getEb02bs01())){
                queryString.append(" and model.eb02bs01 = ? ");
                binds.add(pojo.getEb02bs01());
            }
            if(isNotBlankOrNull(pojo.getEb02bj01())){
                queryString.append(" and model.eb02bj01 = ? ");
                binds.add(pojo.getEb02bj01());
            }
            if(isNotBlankOrNull(pojo.getEb02br01())){
                queryString.append(" and model.eb02br01 = ? ");
                binds.add(pojo.getEb02br01());
            }
            if(isNotBlankOrNull(pojo.getEb02br02())){
                queryString.append(" and model.eb02br02 = ? ");
                binds.add(pojo.getEb02br02());
            }
            if(isNotBlankOrNull(pojo.getEb02bs02())){
                queryString.append(" and model.eb02bs02 = ? ");
                binds.add(pojo.getEb02bs02());
            }
            if(isNotBlankOrNull(pojo.getEb02bj02())){
                queryString.append(" and model.eb02bj02 = ? ");
                binds.add(pojo.getEb02bj02());
            }
            if(isNotBlankOrNull(pojo.getEb02bs03())){
                queryString.append(" and model.eb02bs03 = ? ");
                binds.add(pojo.getEb02bs03());
            }
            if(isNotBlankOrNull(pojo.getEb02cs01())){
                queryString.append(" and model.eb02cs01 = ? ");
                binds.add(pojo.getEb02cs01());
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
            return (List<CrComEbb>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEbb> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEbb as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEbb>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


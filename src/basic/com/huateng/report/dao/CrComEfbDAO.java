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

import resource.bean.crms.CrComEfa;
import resource.bean.crms.CrComEfb;
@Repository
public class CrComEfbDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEfbDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrComEfb pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEfb pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEfb pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEfb findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEfb)this.getHibernateTemplate().get(CrComEfb.class, id);
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

    public List<CrComEfb> findByProperties(CrComEfb pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEfb as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEf020i01())){
                queryString.append(" and model.ef020i01 = ? ");
                binds.add(pojo.getEf020i01());
            }
            if(isNotBlankOrNull(pojo.getEf020q01())){
                queryString.append(" and model.ef020q01 = ? ");
                binds.add(pojo.getEf020q01());
            }
            if(isNotBlankOrNull(pojo.getEf020i02())){
                queryString.append(" and model.ef020i02 = ? ");
                binds.add(pojo.getEf020i02());
            }
            if(isNotBlankOrNull(pojo.getEf020r01())){
                queryString.append(" and model.ef020r01 = ? ");
                binds.add(pojo.getEf020r01());
            }
            if(isNotBlankOrNull(pojo.getEf020q02())){
                queryString.append(" and model.ef020q02 = ? ");
                binds.add(pojo.getEf020q02());
            }
            if(isNotBlankOrNull(pojo.getEf020d01())){
                queryString.append(" and model.ef020d01 = ? ");
                binds.add(pojo.getEf020d01());
            }
            if(isNotBlankOrNull(pojo.getEf020d02())){
                queryString.append(" and model.ef020d02 = ? ");
                binds.add(pojo.getEf020d02());
            }
            if(isNotBlankOrNull(pojo.getEf020q03())){
                queryString.append(" and model.ef020q03 = ? ");
                binds.add(pojo.getEf020q03());
            }
            if(isNotBlankOrNull(pojo.getEf020j01())){
                queryString.append(" and model.ef020j01 = ? ");
                binds.add(pojo.getEf020j01());
            }
            if(isNotBlankOrNull(pojo.getEf020d03())){
                queryString.append(" and model.ef020d03 = ? ");
                binds.add(pojo.getEf020d03());
            }
            if(isNotBlankOrNull(pojo.getEf020r02())){
                queryString.append(" and model.ef020r02 = ? ");
                binds.add(pojo.getEf020r02());
            }
            if(isNotBlankOrNull(pojo.getEf020q04())){
                queryString.append(" and model.ef020q04 = ? ");
                binds.add(pojo.getEf020q04());
            }
            if(isNotBlankOrNull(pojo.getEf030i01())){
                queryString.append(" and model.ef030i01 = ? ");
                binds.add(pojo.getEf030i01());
            }
            if(isNotBlankOrNull(pojo.getEf030q01())){
                queryString.append(" and model.ef030q01 = ? ");
                binds.add(pojo.getEf030q01());
            }
            if(isNotBlankOrNull(pojo.getEf030i02())){
                queryString.append(" and model.ef030i02 = ? ");
                binds.add(pojo.getEf030i02());
            }
            if(isNotBlankOrNull(pojo.getEf030r01())){
                queryString.append(" and model.ef030r01 = ? ");
                binds.add(pojo.getEf030r01());
            }
            if(isNotBlankOrNull(pojo.getEf030q02())){
                queryString.append(" and model.ef030q02 = ? ");
                binds.add(pojo.getEf030q02());
            }
            if(isNotBlankOrNull(pojo.getEf030q03())){
                queryString.append(" and model.ef030q03 = ? ");
                binds.add(pojo.getEf030q03());
            }
            if(isNotBlankOrNull(pojo.getEf030j01())){
                queryString.append(" and model.ef030j01 = ? ");
                binds.add(pojo.getEf030j01());
            }
            if(isNotBlankOrNull(pojo.getEf030q04())){
                queryString.append(" and model.ef030q04 = ? ");
                binds.add(pojo.getEf030q04());
            }
            if(isNotBlankOrNull(pojo.getEf030d01())){
                queryString.append(" and model.ef030d01 = ? ");
                binds.add(pojo.getEf030d01());
            }
            if(isNotBlankOrNull(pojo.getEf030q05())){
                queryString.append(" and model.ef030q05 = ? ");
                binds.add(pojo.getEf030q05());
            }
            if(isNotBlankOrNull(pojo.getEf030j02())){
                queryString.append(" and model.ef030j02 = ? ");
                binds.add(pojo.getEf030j02());
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
            return (List<CrComEfb>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    public List<CrComEfb> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEfb as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		}
        	return  (List<CrComEfb>)getHibernateTemplate().find(queryString.toString(), null);
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


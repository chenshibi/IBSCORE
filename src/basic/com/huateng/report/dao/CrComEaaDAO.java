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

import resource.bean.crms.CrComEaa;
@Repository
public class CrComEaaDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrComEaaDAO.class);

    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
    
    public void update(CrComEaa pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrComEaa pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrComEaa pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrComEaa findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrComEaa)this.getHibernateTemplate().get(CrComEaa.class, id);
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

    public List<CrComEaa> findByProperties(CrComEaa pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrComEaa as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getEa01ai01())){
                queryString.append(" and model.ea01ai01 = ? ");
                binds.add(pojo.getEa01ai01());
            }
            if(isNotBlankOrNull(pojo.getEa01ar01())){
                queryString.append(" and model.ea01ar01 = ? ");
                binds.add(pojo.getEa01ar01());
            }
            if(isNotBlankOrNull(pojo.getEa01bi01())){
                queryString.append(" and model.ea01bi01 = ? ");
                binds.add(pojo.getEa01bi01());
            }
            if(isNotBlankOrNull(pojo.getEa01bd02())){
                queryString.append(" and model.ea01bd02 = ? ");
                binds.add(pojo.getEa01bd02());
            }
            if(isNotBlankOrNull(pojo.getEa01cq01())){
                queryString.append(" and model.ea01cq01 = ? ");
                binds.add(pojo.getEa01cq01());
            }
            if(isNotBlankOrNull(pojo.getEa01cs01())){
                queryString.append(" and model.ea01cs01 = ? ");
                binds.add(pojo.getEa01cs01());
            }
            if(isNotBlankOrNull(pojo.getEa01ds01())){
                queryString.append(" and model.ea01ds01 = ? ");
                binds.add(pojo.getEa01ds01());
            }
            if(isNotBlankOrNull(pojo.getEa01eq01())){
                queryString.append(" and model.ea01eq01 = ? ");
                binds.add(pojo.getEa01eq01());
            }
            if(isNotBlankOrNull(pojo.getEa01er01())){
                queryString.append(" and model.ea01er01 = ? ");
                binds.add(pojo.getEa01er01());
            }
            if(isNotBlankOrNull(pojo.getCreateUser())){
                queryString.append(" and model.createUser = ? ");
                binds.add(pojo.getCreateUser());
            }
            if(isNotBlankOrNull(pojo.getCreateTime())){
                queryString.append(" and model.createTime = ? ");
                binds.add(pojo.getCreateTime());
            }
            if(isNotBlankOrNull(pojo.getCheckUser())){
                queryString.append(" and model.checkUser = ? ");
                binds.add(pojo.getCheckUser());
            }
            if(isNotBlankOrNull(pojo.getCheckTime())){
                queryString.append(" and model.checkTime = ? ");
                binds.add(pojo.getCheckTime());
            }
            if(isNotBlankOrNull(pojo.getSendTime())){
                queryString.append(" and model.sendTime = ? ");
                binds.add(pojo.getSendTime());
            }
            if(isNotBlankOrNull(pojo.getRespTime())){
                queryString.append(" and model.respTime = ? ");
                binds.add(pojo.getRespTime());
            }
            if(isNotBlankOrNull(pojo.getStatus())){
                queryString.append(" and model.status = ? ");
                binds.add(pojo.getStatus());
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
            return (List<CrComEaa>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    
    public List<CrComEaa> findByIdProperties(String ids) {
        log.info("finding pojo instance with properties: " + ids.toString());
        try {
        	String idIn = DevUtils.spritIds(ids);
        	StringBuffer queryString = new StringBuffer();
        	queryString.append("from CrComEaa as model where 0= 0 ");
        	if(isNotBlankOrNull(idIn)){
        		queryString.append("and model.id in").append("(").append(idIn).append(")");
    		//	queryString.append(" and model.id = ? ");
    		}
        	return  (List<CrComEaa>)getHibernateTemplate().find(queryString.toString(), null);
        //	String[] id = spritIds(ids);
       // 	List<CrComEaa> newList=new ArrayList<CrComEaa>();
   /*     	for(String i:id) {
        		StringBuffer queryString = new StringBuffer();
        		queryString.append("from CrComEaa as model where 0= 0 ");
        		List<Object> binds = new ArrayList<Object>();
        		if(isNotBlankOrNull(i)){
        			queryString.append(" and model.id = ? ");
        			binds.add(i);
        		}
        		List<CrComEaa> list=(List<CrComEaa>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        		for(int j=0;j<list.size();j++) {
        			newList.add(list.get(j));
        		}
        		//return (List<CrComEaa>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        	}*/
        	
           
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    

}


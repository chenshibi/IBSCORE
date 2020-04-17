package com.huateng.report.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.CrPbocD101;

@Repository
public class CrPbocD101DAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPbocD101DAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrPbocD101 pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPbocD101 pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPbocD101 pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPbocD101 findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPbocD101)this.getHibernateTemplate().get(CrPbocD101.class, id);
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

    public List<CrPbocD101> findByProperties(CrPbocD101 pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPbocD101 as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getMsgStartFlag())){
                queryString.append(" and model.msgStartFlag = ? ");
                binds.add(pojo.getMsgStartFlag());
            }
            if(isNotBlankOrNull(pojo.getMsgVersion())){
                queryString.append(" and model.msgVersion = ? ");
                binds.add(pojo.getMsgVersion());
            }
            if(isNotBlankOrNull(pojo.getMsgSndCode())){
                queryString.append(" and model.msgSndCode = ? ");
                binds.add(pojo.getMsgSndCode());
            }
            if(isNotBlankOrNull(pojo.getMsgRcvCode())){
                queryString.append(" and model.msgRcvCode = ? ");
                binds.add(pojo.getMsgRcvCode());
            }
            if(isNotBlankOrNull(pojo.getMsgGenTime())){
                queryString.append(" and model.msgGenTime = ? ");
                binds.add(pojo.getMsgGenTime());
            }
            if(isNotBlankOrNull(pojo.getMsgType())){
                queryString.append(" and model.msgType = ? ");
                binds.add(pojo.getMsgType());
            }
            if(isNotBlankOrNull(pojo.getMsgId())){
                queryString.append(" and model.msgId = ? ");
                binds.add(pojo.getMsgId());
            }
            if(isNotBlankOrNull(pojo.getMsgRsv())){
                queryString.append(" and model.msgRsv = ? ");
                binds.add(pojo.getMsgRsv());
            }
            if(isNotBlankOrNull(pojo.getQueryOrgCode())){
                queryString.append(" and model.queryOrgCode = ? ");
                binds.add(pojo.getQueryOrgCode());
            }
            if(isNotBlankOrNull(pojo.getUserCode())){
                queryString.append(" and model.userCode = ? ");
                binds.add(pojo.getUserCode());
            }
            if(isNotBlankOrNull(pojo.getPassword())){
                queryString.append(" and model.password = ? ");
                binds.add(pojo.getPassword());
            }
            if(isNotBlankOrNull(pojo.getOriginateOrgCode())){
                queryString.append(" and model.originateOrgCode = ? ");
                binds.add(pojo.getOriginateOrgCode());
            }
            if(isNotBlankOrNull(pojo.getOriginateUserCode())){
                queryString.append(" and model.originateUserCode = ? ");
                binds.add(pojo.getOriginateUserCode());
            }
            if(isNotBlankOrNull(pojo.getName())){
                queryString.append(" and model.name = ? ");
                binds.add(pojo.getName());
            }
            if(isNotBlankOrNull(pojo.getIdType())){
                queryString.append(" and model.idType = ? ");
                binds.add(pojo.getIdType());
            }
            if(isNotBlankOrNull(pojo.getIdNum())){
                queryString.append(" and model.idNum = ? ");
                binds.add(pojo.getIdNum());
            }
            if(isNotBlankOrNull(pojo.getQueryReason())){
                queryString.append(" and model.queryReason = ? ");
                binds.add(pojo.getQueryReason());
            }
            if(isNotBlankOrNull(pojo.getServiceCode())){
                queryString.append(" and model.serviceCode = ? ");
                binds.add(pojo.getServiceCode());
            }
            if(isNotBlankOrNull(pojo.getDigitalSignature())){
                queryString.append(" and model.digitalSignature = ? ");
                binds.add(pojo.getDigitalSignature());
            }
            if(isNotBlankOrNull(pojo.getQueryDate())){
                queryString.append(" and model.queryDate = ? ");
                binds.add(pojo.getQueryDate());
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
            return (List<CrPbocD101>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


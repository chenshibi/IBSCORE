package com.huateng.report.dao;

import java.util.List;

import javax.annotation.Resource;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.CrEuserCert;

@Repository
public class CrEuserCertDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrEuserCertDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrEuserCert pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrEuserCert pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrEuserCert pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrEuserCert findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrEuserCert)this.getHibernateTemplate().get(CrEuserCert.class, id);
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

    public List<CrEuserCert> findByProperties(CrEuserCert pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrEuserCert as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getCorpId())){
                queryString.append(" and model.corpId = ? ");
                binds.add(pojo.getCorpId());
            }
            if(isNotBlankOrNull(pojo.getSerialNo())){
                queryString.append(" and model.serialNo = ? ");
                binds.add(pojo.getSerialNo());
            }
            if(isNotBlankOrNull(pojo.getCertRefNo())){
                queryString.append(" and model.certRefNo = ? ");
                binds.add(pojo.getCertRefNo());
            }
            if(isNotBlankOrNull(pojo.getCertAuthCode())){
                queryString.append(" and model.certAuthCode = ? ");
                binds.add(pojo.getCertAuthCode());
            }
            if(isNotBlankOrNull(pojo.getCertificateIssuer())){
                queryString.append(" and model.certificateIssuer = ? ");
                binds.add(pojo.getCertificateIssuer());
            }
            if(isNotBlankOrNull(pojo.getApplyDate())){
                queryString.append(" and model.applyDate = ? ");
                binds.add(pojo.getApplyDate());
            }
            if(isNotBlankOrNull(pojo.getUsbKeyFlag())){
                queryString.append(" and model.usbKeyFlag = ? ");
                binds.add(pojo.getUsbKeyFlag());
            }
            if(isNotBlankOrNull(pojo.getUsbKeySn())){
                queryString.append(" and model.usbKeySn = ? ");
                binds.add(pojo.getUsbKeySn());
            }
            if(isNotBlankOrNull(pojo.getCertDownCode())){
                queryString.append(" and model.certDownCode = ? ");
                binds.add(pojo.getCertDownCode());
            }
            if(isNotBlankOrNull(pojo.getCertState())){
                queryString.append(" and model.certState = ? ");
                binds.add(pojo.getCertState());
            }
            if(isNotBlankOrNull(pojo.getCloseDate())){
                queryString.append(" and model.closeDate = ? ");
                binds.add(pojo.getCloseDate());
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
            return (List<CrEuserCert>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


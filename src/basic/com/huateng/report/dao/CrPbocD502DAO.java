package com.huateng.report.dao;
import java.util.List;

import javax.annotation.Resource;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.CrPbocD502;
@Repository
public class CrPbocD502DAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPbocD502DAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrPbocD502 pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPbocD502 pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPbocD502 pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPbocD502 findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPbocD502)this.getHibernateTemplate().get(CrPbocD502.class, id);
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

    public List<CrPbocD502> findByProperties(CrPbocD502 pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPbocD502 as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if(isNotBlankOrNull(pojo.getFileStartFlag())){
                queryString.append(" and model.fileStartFlag = ? ");
                binds.add(pojo.getFileStartFlag());
            }
            if(isNotBlankOrNull(pojo.getFileVersion())){
                queryString.append(" and model.fileVersion = ? ");
                binds.add(pojo.getFileVersion());
            }
            if(isNotBlankOrNull(pojo.getOriginalSendFileName())){
                queryString.append(" and model.originalSendFileName = ? ");
                binds.add(pojo.getOriginalSendFileName());
            }
            if(isNotBlankOrNull(pojo.getFeedbackFlag())){
                queryString.append(" and model.feedbackFlag = ? ");
                binds.add(pojo.getFeedbackFlag());
            }
            if(isNotBlankOrNull(pojo.getFileGenTime())){
                queryString.append(" and model.fileGenTime = ? ");
                binds.add(pojo.getFileGenTime());
            }
            if(isNotBlankOrNull(pojo.getFileType())){
                queryString.append(" and model.fileType = ? ");
                binds.add(pojo.getFileType());
            }
            if(isNotBlankOrNull(pojo.getQrySuccNum())){
                queryString.append(" and model.qrySuccNum = ? ");
                binds.add(pojo.getQrySuccNum());
            }
            if(isNotBlankOrNull(pojo.getQryFailNum())){
                queryString.append(" and model.qryFailNum = ? ");
                binds.add(pojo.getQryFailNum());
            }
            if(isNotBlankOrNull(pojo.getFileRsv())){
                queryString.append(" and model.fileRsv = ? ");
                binds.add(pojo.getFileRsv());
            }
            if(isNotBlankOrNull(pojo.getRequestid())){
                queryString.append(" and model.requestid = ? ");
                binds.add(pojo.getRequestid());
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
            if(isNotBlankOrNull(pojo.getResultCode())){
                queryString.append(" and model.resultCode = ? ");
                binds.add(pojo.getResultCode());
            }
            if(isNotBlankOrNull(pojo.getResultDesc())){
                queryString.append(" and model.resultDesc = ? ");
                binds.add(pojo.getResultDesc());
            }
            if(isNotBlankOrNull(pojo.getReportName())){
                queryString.append(" and model.reportName = ? ");
                binds.add(pojo.getReportName());
            }
            if(isNotBlankOrNull(pojo.getReportMessagePath())){
                queryString.append(" and model.reportMessagePath = ? ");
                binds.add(pojo.getReportMessagePath());
            }
            if(isNotBlankOrNull(pojo.getRecordStatus())){
                queryString.append(" and model.recordStatus = ? ");
                binds.add(pojo.getRecordStatus());
            }
            if(isNotBlankOrNull(pojo.getReceiptTime())){
                queryString.append(" and model.receiptTime = ? ");
                binds.add(pojo.getReceiptTime());
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
            return (List<CrPbocD502>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


package com.huateng.report.dao;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.CrPbocD503;
@Repository
public class CrPbocD503DAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CrPbocD503DAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CrPbocD503 pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CrPbocD503 pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CrPbocD503 pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CrPbocD503 findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CrPbocD503)this.getHibernateTemplate().get(CrPbocD503.class, id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public String getMaxId(String batchNo,String flag) {
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            String sql="";
            if("0".equals(flag)) {
            	sql="select max(a.rsv1) maxid from CR_PBOC_D501 a";
            }else {
            	sql="select max(a.rsv1) maxid from CR_PBOC_D503 a";
            }
            Integer maxId = (Integer)(session.createSQLQuery(sql).addScalar("maxId",Hibernate.INTEGER)).uniqueResult();
        	if(maxId!=null) {
				batchNo=maxId.toString(maxId);
				batchNo = Integer.valueOf(batchNo)+1+"";
        		if(batchNo.length()<3){
        			String firstStr = "";
        			for(int i=0;i<3-batchNo.length();i++){
        				firstStr+="0";
        			}
        			batchNo=firstStr+batchNo;
        		}
			}
        	return batchNo; 
        } catch (RuntimeException re) {
            log.error("getMaxId() failed", re);
            throw re;
        } finally {
            if (session != null) {
                session.close();
            }
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

    public List<CrPbocD503> findByProperties(CrPbocD503 pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CrPbocD503 as model where 0= 0 ");
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
            if(isNotBlankOrNull(pojo.getFileQryCode())){
                queryString.append(" and model.fileQryCode = ? ");
                binds.add(pojo.getFileQryCode());
            }
            if(isNotBlankOrNull(pojo.getFileGenTime())){
                queryString.append(" and model.fileGenTime = ? ");
                binds.add(pojo.getFileGenTime());
            }
            if(isNotBlankOrNull(pojo.getFileType())){
                queryString.append(" and model.fileType = ? ");
                binds.add(pojo.getFileType());
            }
            if(isNotBlankOrNull(pojo.getRecordQryNum())){
                queryString.append(" and model.recordQryNum = ? ");
                binds.add(pojo.getRecordQryNum());
            }
            if(isNotBlankOrNull(pojo.getFileRsv())){
                queryString.append(" and model.fileRsv = ? ");
                binds.add(pojo.getFileRsv());
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
            if(isNotBlankOrNull(pojo.getEntName())){
                queryString.append(" and model.entName = ? ");
                binds.add(pojo.getEntName());
            }
            if(isNotBlankOrNull(pojo.getEntCertType())){
                queryString.append(" and model.entCertType = ? ");
                binds.add(pojo.getEntCertType());
            }
            if(isNotBlankOrNull(pojo.getEntCertNum())){
                queryString.append(" and model.entCertNum = ? ");
                binds.add(pojo.getEntCertNum());
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
            return (List<CrPbocD503>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


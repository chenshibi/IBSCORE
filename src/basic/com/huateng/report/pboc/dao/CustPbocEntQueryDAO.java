package com.huateng.report.pboc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.utils.DateUtils;

import resource.bean.crms.CustPbocEntQuery;

@Repository
public class CustPbocEntQueryDAO extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(CustPbocEntQueryDAO.class);

    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CustPbocEntQuery pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CustPbocEntQuery pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustPbocEntQuery pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CustPbocEntQuery findById(String Id) {
        log.info("getting pojo instance with Id: " + Id);
        try {
            return (CustPbocEntQuery)this.getHibernateTemplate().get(CustPbocEntQuery.class, Id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public boolean isNotBlankOrNull(Object o){
        if(o == null){
            return false;
        }
        if(o instanceof String){
            return StringUtils.isNotBlank((String) o);
        }
        else {
            return true;
        }
    }

    /**
     *  查询企业征信一个月前数据
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocEntQuery> findPbocEntQueryMonthBefore(String id){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery where 0=0 and id=").append("'").append(id).append("'").
                    append(" and to_date(RESP_TIME,'yyyy-MM-dd HH24:mi:ss')").
                    append("<=").
                    append("to_date('").
                    append(expiredDate).
                    append("'").
                    append(",").append("'").append("yyyy-MM-dd HH24:mi:ss").append("')");
                  /*  append(" and STATUS").append("<>").
                    append("'").append(Constant.EXPIRED_STATUS).append("'");*/
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
    
    /**
     * 不带ID    
     * @param entCertNum
     * @param entName
     * @return
     */
    public List<CustPbocEntQuery> findPbocEntQueryMonthBefore3(String entCertNum,String entName){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            String startDate = expiredDate.replace("-", "").replace(":", "").replace(" ", "").trim();
            String endDate=DateUtils.get8Date().trim()+"000000";
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery where 0=0").
            append("and").append(" ").append("ENT_CERT_NUM=").append("'").append(entCertNum).append("'").append(" ").
            append("and ENT_NAME=").append("'").append(entName).append("'").
            append("and RESP_TIME >=").append("'")
                    .append(startDate).append("'").
                    append("and RESP_TIME <=").append("'").
                    append(endDate).
                    append("'");
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
    
    /**
     *  查询企业征信一个月前数据
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocEntQuery> findPbocEntQueryMonthBefore2(String id,String entCertNum,String entName){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            String startDate = expiredDate.replace("-", "").replace(":", "").replace(" ", "").trim();
            String endDate=DateUtils.get8Date().trim()+"000000";
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery where 0=0 ").append("and ID=").append("'").append(id).append("'").
            append("and").append(" ").append("ENT_CERT_NUM=").append("'").append(entCertNum).append("'").append(" ").
            append("and RESP_TIME >=").append("'")
                    .append(startDate).append("'").
                    append("and RESP_TIME <=").append("'").
                    append(endDate).
                    append("'");
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
    
    
    /**
     * 查企业未查数据
     * @param entCertNum
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocEntQuery>  searchCorpByAddStatus(String opr){
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery where 0=0 and STATUS =").append("'").append(Constant.ADD_QUERY_STATUS).append("'").append(" and CREATE_USER=").
            append("'").append(opr).append("'").append(" order by QUERY_LEVEL desc");
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString());
        }catch(RuntimeException re){
            log.error("searchPersonal failed", re);
            throw re;
        }
    }

    /**
     * 根据企业标识号查询企业不过期的唯一数据
     * @param entCertNum
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocEntQuery>  searchCorp(String entCertNum){
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery where 0=0 and ENT_CERT_NUM =").append("'").append(entCertNum).append("'").
                    append(" and STATUS").append("<>").append("'").append(Constant.EXPIRED_STATUS).append("'");
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString());
        }catch(RuntimeException re){
            log.error("searchPersonal failed", re);
            throw re;
        }
    }

    public List<CustPbocEntQuery> findByProperties(CustPbocEntQuery pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocEntQuery as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
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
            if(isNotBlankOrNull(pojo.getRespId())){
                queryString.append(" and model.respId = ? ");
                binds.add(pojo.getRespId());
            }
            if(isNotBlankOrNull(pojo.getRespCode())){
                queryString.append(" and model.respCode = ? ");
                binds.add(pojo.getRespCode());
            }
            if(isNotBlankOrNull(pojo.getRespMsg())){
                queryString.append(" and model.respMsg = ? ");
                binds.add(pojo.getRespMsg());
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
            if(isNotBlankOrNull(pojo.getCertAuthStatus())){
                queryString.append(" and model.certAuthStatus = ? ");
                binds.add(pojo.getCertAuthStatus());
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
            return (List<CustPbocEntQuery>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

}


package com.huateng.report.pboc.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.ebank.framework.util.DateUtil;
import com.huateng.report.pboc.util.Constant;
import com.huateng.report.utils.DateUtils;

import resource.bean.crms.CustPbocPerQuery;
@Repository
public class CustPbocPerQueryDAO extends HibernateDaoSupport {

    private static final Logger log = Logger.getLogger(CustPbocPerQueryDAO.class);
    
    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void update(CustPbocPerQuery pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void save(CustPbocPerQuery pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
        	this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void delete(CustPbocPerQuery pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CustPbocPerQuery findById(java.lang.String id) {
        log.info("getting pojo instance with id: " + id);
        try {
            return (CustPbocPerQuery)this.getHibernateTemplate().get(CustPbocPerQuery.class, id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public String getPbocMaxId(String batchNo,String flag) {
        Session session = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            String sql="";
            if("0".equals(flag)) {
            	sql="select max(a.rsv5) maxid from CUST_PBOC_PER_QUERY a";
            }else {
            	sql="select max(a.rsv2) maxid from CUST_PBOC_ENT_QUERY a";
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

    public List<CustPbocPerQuery> findByProperties(CustPbocPerQuery pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocPerQuery as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if(isNotBlankOrNull(pojo.getId())){
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
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
            if(isNotBlankOrNull(pojo.getRespId())){
                queryString.append(" and model.respId = ? ");
                binds.add(pojo.getRespId());
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
            if(isNotBlankOrNull(pojo.getRespCode())){
                queryString.append(" and model.respCode = ? ");
                binds.add(pojo.getRespCode());
            }
            if(isNotBlankOrNull(pojo.getRespMsg())){
                queryString.append(" and model.respMsg = ? ");
                binds.add(pojo.getRespMsg());
            }
            return (List<CustPbocPerQuery>)getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }
    
    
    /**
     * 查个人未查数据
     * @param entCertNum
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocPerQuery>  searchPerByAddStatus(){
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocPerQuery where 0=0 and STATUS =").append("'").append(Constant.ADD_QUERY_STATUS).append("'").
                    append("order by QUERY_LEVEL desc");
            return (List<CustPbocPerQuery>)getHibernateTemplate().find(queryString.toString());
        }catch(RuntimeException re){
            log.error("searchPersonal failed", re);
            throw re;
        }
    }
    
    /**
     *  查询个人征信一个月前数据
     * @return List<CustPbocPerQuery>
     */
    public List<CustPbocPerQuery> findPbocPerQueryMonthBefore(String id,String idNum,String name){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            String startDate = expiredDate.replace("-", "").replace(":", "").replace(" ", "").trim();
            String endDate=DateUtils.get8Date().trim()+"235959";
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocPerQuery where 0=0 and status='03' and id=").append("'").append(id).append("'").append(" ").
            append("and").append(" ").append("ID_NUM=").append("'").append(idNum).append("'").append(" ").
            append("and NAME=").append("'").append(name).append("'").
            append("and RESP_TIME >=").append("'")
                    .append(startDate).append("'").
                    append("and RESP_TIME <=").append("'").
                    append(endDate).
                    append("'");
            return (List<CustPbocPerQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
    
    public List<CustPbocPerQuery> findPbocPerQueryMonthBefore2(String id,String idNum,String name){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            String startDate = expiredDate.replace("-", "").replace(":", "").replace(" ", "").trim();
            String endDate=DateUtils.get8Date().trim()+"0000000";
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocPerQuery where 0=0 ").append("and ID=").append("'").append(id).append("'").
            append("and").append(" ").append("ID_NUM=").append("'").append(idNum).append("'").append(" ").
            append("and NAME=").append("'").append(name).append("'").
            append("and RESP_TIME >=").append("'")
                    .append(startDate).append("'").
                    append("and RESP_TIME <=").append("'").
                    append(endDate).
                    append("'");
            return (List<CustPbocPerQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
    
    public List<CustPbocPerQuery> findPbocPerQueryMonthBefore3(String idNum,String name){
        try{
            Date startDateByMonths = DateUtil.getStartDateByMonths(new Date(), 1);
            String expiredDate = DateUtil.Time14ToString2(startDateByMonths);
            String startDate = expiredDate.replace("-", "").replace(":", "").replace(" ", "").trim();
            String endDate=DateUtils.get8Date().trim()+"0000000";
            StringBuffer queryString = new StringBuffer();
            queryString.append("from CustPbocPerQuery where 0=0 ").
            append("and").append(" ").append("ID_NUM=").append("'").append(idNum).append("'").append(" ").
            append("and NAME=").append("'").append(name).append("'").
            append("and RESP_TIME >=").append("'")
                    .append(startDate).append("'").
                    append("and RESP_TIME <=").append("'").
                    append(endDate).
                    append("'");
            return (List<CustPbocPerQuery>)getHibernateTemplate().find(queryString.toString());
        }catch (RuntimeException re){
            log.error("findExpired failed", re);
            throw re;

        }    }
}


package com.huateng.report.pboc.dao;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import resource.bean.crms.BizFileImportrecs;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grassy
 * @date 2019/2/21 16:13
 * @jdk.version 1.8
 * @desc
 */
@Repository
public class BizFileImportrecsDao extends HibernateDaoSupport {
    private static final Logger log = Logger.getLogger(BizFileImportrecsDao.class);

    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    public void save(BizFileImportrecs pojo) {
        log.info("save pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().save(pojo);
            log.info("save successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }

    public void update(BizFileImportrecs pojo) {
        log.info("update pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().update(pojo);
            log.info("update successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("update failed", re);
            throw re;
        }
    }

    public void delete(BizFileImportrecs pojo) {
        log.info("delete pojo instance with id: " + pojo.getId());
        try {
            this.getHibernateTemplate().delete(pojo);
            log.info("delete successful " + pojo.toString());
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public BizFileImportrecs findById(String Id) {
        log.info("getting pojo instance with Id: " + Id);
        try {
            return (BizFileImportrecs) this.getHibernateTemplate().get(BizFileImportrecs.class, Id);
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public boolean isNotBlankOrNull(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof String) {
            return StringUtils.isNotBlank((String) o);
        } else {
            return true;
        }
    }

    public List<BizFileImportrecs> findByProperties(BizFileImportrecs pojo) {
        log.info("finding pojo instance with properties: " + pojo.toString());
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from BizFileImportrecs as model where 0= 0 ");
            List<Object> binds = new ArrayList<Object>();
            if (isNotBlankOrNull(pojo.getId())) {
                queryString.append(" and model.id = ? ");
                binds.add(pojo.getId());
            }
            if (isNotBlankOrNull(pojo.getFileName())) {
                queryString.append(" and model.fileName = ? ");
                binds.add(pojo.getFileName());
            }
            if (isNotBlankOrNull(pojo.getFilePath())) {
                queryString.append(" and model.filePath = ? ");
                binds.add(pojo.getFilePath());
            }
            if (isNotBlankOrNull(pojo.getImportedBy())) {
                queryString.append(" and model.importedBy = ? ");
                binds.add(pojo.getImportedBy());
            }
            if (isNotBlankOrNull(pojo.getImportedDateTime())) {
                queryString.append(" and model.importedDateTime = ? ");
                binds.add(pojo.getImportedDateTime());
            }
            if (isNotBlankOrNull(pojo.getTotalRecords())) {
                queryString.append(" and model.totalRecords = ? ");
                binds.add(pojo.getTotalRecords());
            }
            if (isNotBlankOrNull(pojo.getSuccessRecords())) {
                queryString.append(" and model.successRecords = ? ");
                binds.add(pojo.getSuccessRecords());
            }
            if (isNotBlankOrNull(pojo.getFailRecords())) {
                queryString.append(" and model.failRecords = ? ");
                binds.add(pojo.getFailRecords());
            }
            if (isNotBlankOrNull(pojo.getFlag())) {
                queryString.append(" and model.flag = ? ");
                binds.add(pojo.getFlag());
            }
            if (isNotBlankOrNull(pojo.getErrorFilename())) {
                queryString.append(" and model.errorFilename = ? ");
                binds.add(pojo.getErrorFilename());
            }
            if (isNotBlankOrNull(pojo.getErrorFilepath())) {
                queryString.append(" and model.errorFilepath = ? ");
                binds.add(pojo.getErrorFilepath());
            }
            if (isNotBlankOrNull(pojo.getImportType())) {
                queryString.append(" and model.importType = ? ");
                binds.add(pojo.getImportType());
            }
            if (isNotBlankOrNull(pojo.getRecordType())) {
                queryString.append(" and model.recordType = ? ");
                binds.add(pojo.getImportType());
            }
            return (List<BizFileImportrecs>) getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }
    }

    public List<BizFileImportrecs> findByFileName(BizFileImportrecs pojo) {
        try {
            StringBuffer queryString = new StringBuffer();
            queryString.append("from BizFileImportrecs as model where 0= 0");
            List<Object> binds = new ArrayList<Object>();

            if (isNotBlankOrNull(pojo.getFileName())) {
                queryString.append("and model.fileName = ?");
                binds.add(pojo.getFileName());
            }
            return (List<BizFileImportrecs>) getHibernateTemplate().find(queryString.toString(), binds.toArray());
        } catch (RuntimeException re) {
            log.error("find by properties failed", re);
            throw re;
        }

    }
}
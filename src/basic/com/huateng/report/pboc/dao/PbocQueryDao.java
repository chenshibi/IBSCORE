package com.huateng.report.pboc.dao;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.huateng.ebank.framework.util.ApplicationContextUtils;

import javax.annotation.Resource;

/**
 * @author YiSiliang
 * @date 2019/1/8 17:26
 */
@Repository
public class PbocQueryDao extends HibernateDaoSupport {
    private static final Logger logger = Logger.getLogger(PbocQueryDao.class);

    public static PbocQueryDao getInstance() {
        return ApplicationContextUtils.getBean(PbocQueryDao.class);
    }


    @Resource(name = "mySessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
